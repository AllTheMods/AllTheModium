package com.thevortex.allthemodium.blocks;

import java.util.Random;
import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.ticks.ScheduledTick;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraftforge.event.ForgeEventFactory;

import com.thevortex.allthemodium.registry.ModRegistry;
import org.lwjgl.system.CallbackI;

public class SoulLava extends LiquidBlock {

	public int tickcount = 0;
	protected FlowingFluid fluid;
	public SoulLava(Supplier<? extends FlowingFluid> supplier, Properties p_i48368_1_) {
		super(supplier, p_i48368_1_);

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
	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
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

						level.setBlockAndUpdate(blockpos1.above(), ForgeEventFactory
								.fireFluidPlaceBlockEvent(level, blockpos1.above(), pos, FIRE));

				}
			}

		}
	}
	/**/


	@OnlyIn(Dist.CLIENT)
	@Override
	public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, Random rand) {
		if(stateIn.is(ModRegistry.molten_BlueLava_block.get())) {
			spawnParticles(worldIn, pos);
		}
		super.animateTick(stateIn, worldIn, pos, rand);
	}

	private static void spawnParticles(Level world, BlockPos worldIn) {
		double d0 = 0.5625D;
		Random random = world.random;
		if(world.getFluidState(worldIn).isSource()) {
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
