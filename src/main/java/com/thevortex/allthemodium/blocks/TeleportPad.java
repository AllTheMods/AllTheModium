package com.thevortex.allthemodium.blocks;

import java.util.*;

import com.mojang.serialization.MapCodec;

import com.thevortex.allthemodium.registry.LevelRegistry;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import org.jetbrains.annotations.Nullable;

public class TeleportPad extends Block {
	MapCodec<? extends TeleportPad> codec = simpleCodec(TeleportPad::new);
	
	protected static final VoxelShape TELEPORTPAD_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D);

	public static final BooleanProperty SPAWNED = BooleanProperty.create("spawned");

	public TeleportPad(Properties properties) {
		this(false, properties);
	}

	public TeleportPad(boolean spawned, Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(SPAWNED, spawned));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(SPAWNED);
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return TELEPORTPAD_AABB;
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return TELEPORTPAD_AABB;
	}

	@Override
	public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
		if ((player instanceof ServerPlayer) && (player.isCrouching())) {

			transferPlayer((ServerPlayer) player, pos);
			level.addAlwaysVisibleParticle(ParticleTypes.SOUL_FIRE_FLAME, pos.getX(), pos.getY() + 1, pos.getZ(), 0, 1, 0);
		}
		return super.useWithoutItem(state, level, pos, player, hitResult);
	}

	@Override
	public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
		return !state.getValue(SPAWNED);
	}

	public void transferPlayer(ServerPlayer player, BlockPos pos) {
		int config = 1;//TweakProxy.packMode();

		// We can ignore the Warning here since if getPartner returns null, targetLevel will just be null and we return
		@SuppressWarnings("ConstantConditions")
		ServerLevel targetLevel = player.server.getLevel(getPartner(player.level().dimension(), config));
		if (targetLevel == null) return;

		BlockPos targetPos = findSafeExit(targetLevel, pos);
		teleport(player, targetLevel, targetPos);
	}

	/// Somewhat mirrors {@link net.minecraft.world.level.portal.PortalForcer#createPortal}
	private BlockPos findSafeExit(ServerLevel level, BlockPos entryPos) {
		// Look for an existing portal
		Optional<BlockPos> existing = findClosestTeleportPad(
				level, entryPos, 32, level.getWorldBorder()
		);
		if (existing.isPresent()) {
			return existing.get();
		}

		// Look for a safe spot in the world
		for (BlockPos.MutableBlockPos candidate : BlockPos.spiralAround(entryPos, 32, Direction.EAST, Direction.SOUTH)) {
			if (!level.getWorldBorder().isWithinBounds(candidate)) continue;

			int y = level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, candidate.getX(), candidate.getZ());
			if(level.dimensionType().hasCeiling()){
				y = findSafeY(level, candidate.getX(), y, candidate.getZ(), candidate);
			}

			BlockPos spot = new BlockPos(candidate.getX(), y, candidate.getZ());
			if (isSafeSpot(level, spot)) {
				level.setBlockAndUpdate(spot, ModRegistry.TELEPORT_PAD.get().defaultBlockState().setValue(SPAWNED, true));
				return spot;
			}
		}

		// Use the original position if no safe spot was found
		level.setBlockAndUpdate(entryPos, ModRegistry.TELEPORT_PAD.get().defaultBlockState().setValue(SPAWNED, true));
		return entryPos;
	}

	// Go down until we find a safe spot or the bottom of the world, in which case we return the spawn height
	private int findSafeY(ServerLevel level, int x, int y, int z, BlockPos.MutableBlockPos pos) {
		int minY = level.getMinBuildHeight();
		pos.set(x, y - 1, z);
		pos.move(Direction.DOWN);

		while (pos.getY() > minY) {
			if (isSafeSpot(level, pos.immutable())) {
				return pos.getY();
			}
			pos.move(Direction.DOWN);
		}

		return level.getChunkSource().getGenerator().getSpawnHeight(level.getChunk(pos).getHeightAccessorForGeneration());
	}


	// A safe spot is a 1x2 box of air with a solid ground
	private boolean isSafeSpot(ServerLevel level, BlockPos pos) {
		BlockState here  = level.getBlockState(pos);
		FluidState hereFluid = level.getFluidState(pos);
		BlockState below = level.getBlockState(pos.below());
		FluidState belowFluid = level.getFluidState(pos.below());
		BlockState above = level.getBlockState(pos.above());
		FluidState aboveFluid = level.getFluidState(pos.above());

		return ((here.isAir() || here.is(BlockTags.REPLACEABLE)) && hereFluid.isEmpty()) &&
				((above.isAir() || above.is(BlockTags.REPLACEABLE)) && aboveFluid.isEmpty()) &&
				(!(below.isAir() || below.is(BlockTags.REPLACEABLE) || below.is(Blocks.BEDROCK)) && belowFluid.isEmpty());
	}

	/// Stolen from {@link net.minecraft.world.level.portal.PortalForcer#findClosestPortalPosition}
	public Optional<BlockPos> findClosestTeleportPad(
			ServerLevel level,
			BlockPos origin,
			int radius,
			WorldBorder border
	) {
		PoiManager poiManager = level.getPoiManager();
		poiManager.ensureLoadedAndValid(level, origin, radius);

		return poiManager.getInSquare(
						record -> record.is(ModRegistry.TELEPORT_PAD_POI),
						origin,
						radius,
						PoiManager.Occupancy.ANY
				)
				.map(PoiRecord::getPos)
				.filter(border::isWithinBounds)
				.filter(pos -> level.getBlockState(pos).is(ModRegistry.TELEPORT_PAD))
				.min(Comparator.<BlockPos>
						comparingDouble(pos -> pos.distSqr(origin))
						.thenComparingInt(Vec3i::getY)
				);
	}

	private void teleport(ServerPlayer player, ServerLevel level, BlockPos targetPos) {
		level.addParticle(ParticleTypes.SOUL_FIRE_FLAME, targetPos.getX(), targetPos.getY(), targetPos.getZ(), 0, 1, 0);
		player.teleportTo(level, targetPos.getX() + 0.5D, targetPos.getY() + 0.25D, targetPos.getZ() + 0.5D, player.rotA, player.yya);
	}

	private @Nullable ResourceKey<Level> getPartner(ResourceKey<Level> level, int packMode) {
		Map<ResourceKey<Level>, ResourceKey<Level>> map = OVERRIDES.getOrDefault(packMode, DEFAULT_PARTNERS);
        return map.get(level);
	}

	public record LevelPair(ResourceKey<Level> a, ResourceKey<Level> b) {}

	private static Map<ResourceKey<Level>, ResourceKey<Level>> buildMap(LevelPair... pairs) {
		Map<ResourceKey<Level>, ResourceKey<Level>> m = new HashMap<>();
		// Bidirectional
		for (var p : pairs) {
			m.put(p.a, p.b);
			m.put(p.b, p.a);
		}
		return m;
	}

	private static final Map<ResourceKey<Level>,ResourceKey<Level>> DEFAULT_PARTNERS =
			buildMap(
					new LevelPair(ServerLevel.OVERWORLD, LevelRegistry.Mining),
					new LevelPair(ServerLevel.NETHER,    LevelRegistry.THE_OTHER),
					new LevelPair(ServerLevel.END,       LevelRegistry.THE_BEYOND)
			);

	// Used for special pairs in individual pack modes
	private static final Map<Integer, Map<ResourceKey<Level>,ResourceKey<Level>>> OVERRIDES = Map.of(
			/*
			[packmode], buildMap(
					new LevelPair(SomeDimension, SomeOtherDimension)
			);
			*/
	);
}
