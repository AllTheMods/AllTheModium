package net.allthemods.allthemodium.common.blocks;

import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.extensions.ILevelExtension;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Util;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.levelgen.Heightmap;
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
    
    public static final BooleanProperty SPAWNED = BooleanProperty.create("spawned");
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    
    public TeleportPad(Properties properties) {
        super(properties.strength(3.0F));
        this.registerDefaultState(this.defaultBlockState().setValue(TeleportPad.SPAWNED, false));
    }
    
    private static int getDestinationMode() {
        return TeleportPad.isTweaksLoaded() ? ATTProxy.getPackMode() : 0;
    }
    
    private static boolean isTweaksLoaded() {
        return ModList.get().isLoaded("allthetweaks");
    }
    
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(TeleportPad.WATERLOGGED, context.getLevel().getFluidState(context.getClickedPos()).is(Fluids.WATER));
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
            if (target == pos) {
                serverPlayer.sendSystemMessage(ATMLanguage.MESSAGE_TRANSFER_FAILED.translate(ChatFormatting.RED), true);
                return InteractionResult.FAIL;
            }
            
            if (!partner.getBlockState(target).is(ATMBlocks.TELEPORT_PAD)) {
                partner.setBlockAndUpdate(target, ATMBlocks.TELEPORT_PAD.get().defaultBlockState().setValue(TeleportPad.SPAWNED, true));
            }
            
            level.addAlwaysVisibleParticle(ParticleTypes.SOUL_FIRE_FLAME, target.getX(), target.getY(), target.getZ(), 0.0D, 1.0D, 0.0D);
            player.teleportTo(partner, target.getX() + 0.5D, target.getY() + 0.5D, target.getZ() + 0.5D, Set.of(), player.getYRot(), player.getXRot(), false);
            partner.addAlwaysVisibleParticle(ParticleTypes.SOUL_FIRE_FLAME, target.getX(), target.getY(), target.getZ(), 0.0D, 1.0D, 0.0D);
            
            return InteractionResult.SUCCESS;
        }
        
        return InteractionResult.FAIL;
    }
    
    private static final int ISLAND_SEARCH_CHUNK_RADIUS = 8;
    private static final int ISLAND_COLUMN_STEP = 4;

    private static BlockPos findSafeSpot(ServerLevel level, BlockPos origin) {
        final PoiManager manager = level.getPoiManager();
        manager.ensureLoadedAndValid(level, origin, 64);
        return ChunkPos.rangeClosed(ChunkPos.containing(origin), 4)
                .flatMap(pos -> manager.getInChunk(record -> record.is(ATMPois.TELEPORT_PAD), pos, PoiManager.Occupancy.ANY))
                .map(PoiRecord::getPos)
                .min(Comparator.<BlockPos>comparingDouble(pos -> pos.distSqr(origin)).thenComparingInt(Vec3i::getY))
                .orElseGet(() -> TeleportPad.findIslandSurface(level, origin));
    }

    private static BlockPos findIslandSurface(ServerLevel level, BlockPos origin) {
        final int minY = level.getMinY();
        final ChunkPos center = ChunkPos.containing(origin);
        for (int radius = 0; radius <= TeleportPad.ISLAND_SEARCH_CHUNK_RADIUS; radius++) {
            BlockPos best = null;
            double bestDist = Double.MAX_VALUE;
            for (ChunkPos chunkPos : ChunkPos.rangeClosed(center, radius).toList()) {
                if (Math.max(Math.abs(chunkPos.x() - center.x()), Math.abs(chunkPos.z() - center.z())) != radius) continue;
                level.getChunk(chunkPos.x(), chunkPos.z());
                for (int dx = 0; dx < 16; dx += TeleportPad.ISLAND_COLUMN_STEP) {
                    for (int dz = 0; dz < 16; dz += TeleportPad.ISLAND_COLUMN_STEP) {
                        final int x = chunkPos.getMinBlockX() + dx;
                        final int z = chunkPos.getMinBlockZ() + dz;
                        final int top = level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x, z);
                        if (top <= minY) continue;
                        final BlockPos surface = new BlockPos(x, top, z);
                        final BlockState ground = level.getBlockState(surface.below());
                        if (ground.isAir() || ground.is(BlockTags.REPLACEABLE)) continue;
                        if (!level.getBlockState(surface).isAir() || !level.getBlockState(surface.above()).isAir()) continue;
                        final double dist = surface.distSqr(origin);
                        if (dist < bestDist) {
                            bestDist = dist;
                            best = surface;
                        }
                    }
                }
            }
            if (best != null) return best;
        }
        return origin;
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
