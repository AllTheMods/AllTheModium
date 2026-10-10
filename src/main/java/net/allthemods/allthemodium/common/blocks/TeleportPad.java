package net.allthemods.allthemodium.common.blocks;

import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.extensions.ILevelExtension;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Util;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import net.allthemods.allthemodium.api.ATTProxy;
import net.allthemods.allthemodium.client.lang.ATMLanguage;
import net.allthemods.allthemodium.core.registry.ATMBlocks;
import net.allthemods.allthemodium.core.registry.ATMPois;
import net.allthemods.allthemodium.data.worldgen.ATMDimensions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class TeleportPad extends Block implements SimpleWaterloggedBlock {
    
    private static final Map<Integer, List<Destination>> DESTINATIONS = Util.make(new LinkedHashMap<>(), map -> {
        // Default
        map.put(0, List.of(
                new Destination(Level.OVERWORLD, ATMDimensions.MINING),
                new Destination(Level.NETHER, ATMDimensions.THE_OTHER),
                new Destination(Level.END, ATMDimensions.THE_BEYOND)
        ));
    });
    
    private static final VoxelShape SHAPE = Block.column(16.0D, 0.0D, 3.0D);
    private static final int SEARCH_RADIUS = 32;
    
    public static final BooleanProperty SPAWNED = BooleanProperty.create("spawned");
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    
    public TeleportPad(Properties properties) {
        super(properties.strength(20.0F).noOcclusion());
        this.registerDefaultState(this.defaultBlockState().setValue(TeleportPad.WATERLOGGED, false).setValue(TeleportPad.SPAWNED, false));
    }
    
    private static int getDestinationMode() {
        return TeleportPad.isTweaksLoaded() ? ATTProxy.getPackMode() : 0;
    }
    
    private static boolean isTweaksLoaded() {
        return ModList.get().isLoaded("allthetweaks");
    }
    
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState state = context.getLevel().getFluidState(context.getClickedPos());
        return this.defaultBlockState().setValue(TeleportPad.WATERLOGGED, state.is(FluidTags.WATER) && state.isFull());
    }
    
    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(TeleportPad.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TeleportPad.WATERLOGGED);
        builder.add(TeleportPad.SPAWNED);
    }
    
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return TeleportPad.SHAPE;
    }
    
    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return TeleportPad.SHAPE;
    }
    
    @Override
    public boolean canHarvestBlock(BlockState state, BlockGetter level, BlockPos pos, Player player) {
        return !state.getValue(TeleportPad.SPAWNED);
    }
    
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!player.isShiftKeyDown()) return InteractionResult.PASS;
        if (!(player instanceof ServerPlayer serverPlayer && level instanceof ServerLevel serverLevel)) return InteractionResult.SUCCESS;
        
        MinecraftServer server = serverLevel.getServer();
        for (Destination destination : TeleportPad.DESTINATIONS.get(TeleportPad.getDestinationMode())) {
            Optional<ResourceKey<Level>> optional = destination.getTarget(player.level().dimension());
            if (optional.isEmpty()) continue;
            
            ServerLevel partner = server.getLevel(optional.get());
            if (partner == null) {
                serverPlayer.sendSystemMessage(ATMLanguage.MESSAGE_TRANSFER_FAILED.translate(ChatFormatting.RED), true);
                return InteractionResult.FAIL;
            }
            
            
            BlockPos target = TeleportPad.findSafeSpot(partner, pos);
            if (!partner.getBlockState(target).is(ATMBlocks.TELEPORT_PAD)) {
                partner.setBlockAndUpdate(target, ATMBlocks.TELEPORT_PAD.get().defaultBlockState().setValue(TeleportPad.SPAWNED, true));
            }
            
            level.addAlwaysVisibleParticle(ParticleTypes.SOUL_FIRE_FLAME, target.getX(), target.getY(), target.getZ(), 0.0D, 1.0D, 0.0D);
            player.teleportTo(partner, target.getX() + 0.5D, target.getY() + 0.25D, target.getZ() + 0.5D, Set.of(), player.getYRot(), player.getXRot(), false);
            partner.addAlwaysVisibleParticle(ParticleTypes.SOUL_FIRE_FLAME, target.getX(), target.getY(), target.getZ(), 0.0D, 1.0D, 0.0D);
            
            return InteractionResult.SUCCESS;
        }
        
        return InteractionResult.FAIL;
    }
    
    private static BlockPos findSafeSpot(ServerLevel level, BlockPos origin) {
        final WorldBorder border = level.getWorldBorder();
        final PoiManager manager = level.getPoiManager();
        manager.ensureLoadedAndValid(level, origin, TeleportPad.SEARCH_RADIUS);
        Optional<BlockPos> existing = manager.getInSquare(record -> record.is(ATMPois.TELEPORT_PAD), origin, TeleportPad.SEARCH_RADIUS, PoiManager.Occupancy.ANY)
                .map(PoiRecord::getPos)
                .filter(border::isWithinBounds)
                .filter(pos -> level.getBlockState(pos).is(ATMBlocks.TELEPORT_PAD))
                .min(Comparator.<BlockPos>comparingDouble(pos -> pos.distSqr(origin)).thenComparingInt(Vec3i::getY));
        if (existing.isPresent()) return existing.get();
        
        for (BlockPos.MutableBlockPos candidate : BlockPos.spiralAround(origin, TeleportPad.SEARCH_RADIUS, Direction.EAST, Direction.SOUTH)) {
            if (!border.isWithinBounds(candidate)) continue;
            
            int y = level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, candidate.getX(), candidate.getZ());
            if (level.dimensionType().hasCeiling()) {
                y = TeleportPad.findSafeY(level, candidate.getX(), y, candidate.getZ());
            }
            
            BlockPos spot = new BlockPos(candidate.getX(), y, candidate.getZ());
            if (TeleportPad.isSafeSpot(level, spot)) return spot;
        }
        
        return origin;
    }
    
    private static int findSafeY(ServerLevel level, int x, int y, int z) {
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(x, y - 2, z);
        while (pos.getY() > level.getMinY()) {
            if (TeleportPad.isSafeSpot(level, pos)) return pos.getY();
            pos.move(Direction.DOWN);
        }
        
        return level.getChunkSource().getGenerator().getSpawnHeight(level.getChunk(pos).getHeightAccessorForGeneration());
    }
    
    private static boolean isSafeSpot(ServerLevel level, BlockPos pos) {
        return TeleportPad.isOpen(level, pos) && TeleportPad.isOpen(level, pos.above()) && TeleportPad.isGround(level, pos.below());
    }
    
    private static boolean isOpen(ServerLevel level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        return (state.isAir() || state.is(BlockTags.REPLACEABLE)) && state.getFluidState().isEmpty();
    }
    
    private static boolean isGround(ServerLevel level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        return !(state.isAir() || state.is(BlockTags.REPLACEABLE) || state.is(Blocks.BEDROCK)) && state.getFluidState().isEmpty();
    }
    
    public static List<Component> display() {
        List<Destination> destinations = TeleportPad.DESTINATIONS.get(TeleportPad.getDestinationMode());
        List<Component> components = new ArrayList<>();
        for (Destination destination : destinations) {
            components.add(destination.display());
        }
        return components;
    }
    
    public static MutableComponent display(ResourceKey<Level> origin) {
        List<Destination> destinations = TeleportPad.DESTINATIONS.get(TeleportPad.getDestinationMode());
        for (Destination destination : destinations) {
            Optional<ResourceKey<Level>> target = destination.getTarget(origin);
            if (target.isPresent()) return Destination.translate(target.get());
        }
        
        return ATMLanguage.MESSAGE_NO_DESTINATION.translate(ChatFormatting.RED);
    }
    
    private record Destination(ResourceKey<Level> from, ResourceKey<Level> to) {
        
        private Optional<ResourceKey<Level>> getTarget(ResourceKey<Level> origin) {
            if (origin.equals(this.from)) return Optional.of(this.to);
            if (origin.equals(this.to)) return Optional.of(this.from);
            return Optional.empty();
        }
        
        private MutableComponent display() {
            return Component.empty()
                    .append(Destination.translate(this.from).withStyle(ChatFormatting.GRAY))
                    .append(Component.literal(" ↔ ").withStyle(ChatFormatting.DARK_GRAY))
                    .append(Destination.translate(this.to).withStyle(ChatFormatting.GRAY));
        }
        
        private static MutableComponent translate(ResourceKey<Level> dimension) {
            return Component.translatable(dimension.identifier().toLanguageKey(ILevelExtension.TRANSLATION_PREFIX));
        }
    }
}
