package com.thevortex.allthemodium.blocks;

import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoulFireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.event.EventHooks;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class SoulLava extends LiquidBlock {

	public int tickcount = 0;
	protected FlowingFluid fluid;
	public SoulLava(Supplier<? extends FlowingFluid> supplier, Properties p_i48368_1_) {
		super(supplier.get(), p_i48368_1_);

	}

	@Override
	public void entityInside(@NotNull BlockState state, @NotNull Level world, @NotNull BlockPos position, @NotNull Entity entity) {
		super.entityInside(state, world, position, entity);
		entity.setRemainingFireTicks(400);
	}

	@Override
	public boolean isBurning(BlockState state, BlockGetter world, BlockPos pos) {
		return true;
	}

	@Override
	public boolean isFireSource(BlockState state, LevelReader world, BlockPos pos, Direction side) {
		return true;
	}


	@Override
	public boolean canEntityDestroy(BlockState state, BlockGetter world, BlockPos pos, Entity entity) {
		return false;
	}

	@Override
	public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {

		return false;
	}
	@Override
	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		if (level.getGameRules().getBoolean(GameRules.RULE_DOFIRETICK)) {
			int i = random.nextInt(10);
			if (i > 0) {
				BlockPos blockpos = pos;

				for (int j = 0; j < i; ++j) {
					blockpos = blockpos.offset(random.nextInt(10) - 1, 1, random.nextInt(10) - 1);
					if (!level.isEmptyBlock(blockpos)) {
						return;
					}

					BlockState blockstate = level.getBlockState(blockpos);
					BlockState FIRE = SoulFireBlock.canSurviveOnBlock(blockstate)
							? Blocks.SOUL_FIRE.defaultBlockState()
							: ((FireBlock) Blocks.FIRE).defaultBlockState();
				}
			} else {
				for (int k = 0; k < 10; ++k) {
					BlockPos blockpos1 = pos.offset(random.nextInt(10) - 1, 0, random.nextInt(10) - 1);
					BlockState FIRE = SoulFireBlock.canSurviveOnBlock(level.getBlockState(blockpos1))
							? Blocks.SOUL_FIRE.defaultBlockState()
							: ((FireBlock) Blocks.FIRE).defaultBlockState();

					if (!level.isEmptyBlock(blockpos1)) {
						return;
					}

						level.setBlockAndUpdate(blockpos1.above(), EventHooks
								.fireFluidPlaceBlockEvent(level, blockpos1.above(), pos, FIRE));

				}
			}

		}
	}
	/**/


	@OnlyIn(Dist.CLIENT)
	@Override
	public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, RandomSource rand) {
		this.tickcount++;

		if(stateIn.is(ModRegistry.SOULLAVA_BLOCK.get()) && this.tickcount >= 40) {
			spawnParticles(worldIn, pos);
			this.tickcount = 0;
		}
		super.animateTick(stateIn, worldIn, pos, rand);
	}

	private static void spawnParticles(Level world, BlockPos worldIn) {
		double d0 = 0.5625D;
		RandomSource random = world.random;

		if(world.getFluidState(worldIn).isSource() && (random.nextBoolean() == true)) {
			for (Direction direction : Direction.values()) {
				BlockPos blockpos = worldIn.offset(direction.getNormal());
				if (!world.getBlockState(blockpos).isSolidRender(world, blockpos)) {
					Direction.Axis direction$axis = direction.getAxis();
					double d1 = direction$axis == Direction.Axis.X ? 0.5D + 0.5625D * (double) direction.getStepX() : (double) random.nextFloat();
					double d2 = direction$axis == Direction.Axis.Y ? 0.5D + 0.5625D * (double) direction.getStepY() : (double) random.nextFloat();
					double d3 = direction$axis == Direction.Axis.Z ? 0.5D + 0.5625D * (double) direction.getStepZ() : (double) random.nextFloat();
					world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, (double) worldIn.getX() + d1, (double) worldIn.getY() + d2, (double) worldIn.getZ() + d3, random.nextFloat(), random.nextFloat(), random.nextFloat());
					world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, (double) worldIn.getX() + d1, (double) worldIn.getY() + d2, (double) worldIn.getZ() + d3, random.nextFloat(), -random.nextFloat(), -random.nextFloat());
					world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, (double) worldIn.getX() + d1, (double) worldIn.getY() + d2, (double) worldIn.getZ() + d3, -random.nextFloat(), random.nextFloat(), -random.nextFloat());
					world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, (double) worldIn.getX() + d1, (double) worldIn.getY() + d2, (double) worldIn.getZ() + d3, -random.nextFloat(), -random.nextFloat(), random.nextFloat());
				}
			}
		}
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 1000;
	}


 


/**/

}
