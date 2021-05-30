package com.thevortex.allthemodium.blocks;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;

import com.thevortex.allthemodium.particledata.AllthemodiumParticleData;
import net.minecraft.block.*;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandSource;
import net.minecraft.command.arguments.DimensionArgument;
import net.minecraft.command.impl.TeleportCommand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.*;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.ITeleporter;

import net.minecraftforge.event.ForgeEventFactory;
import org.antlr.v4.runtime.misc.NotNull;

import com.mojang.brigadier.context.CommandContext;
import com.thevortex.allthemodium.AllTheModium;
import com.thevortex.allthemodium.fluids.FluidList;
import com.thevortex.allthemodium.init.ModItems;

import javax.annotation.Nullable;

public class FluidBlock extends FlowingFluidBlock {
	public int tickcount = 0;

	public FluidBlock(Supplier<? extends FlowingFluid> supplier, Properties p_i48368_1_) {
		super(supplier, p_i48368_1_);
	}

	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return true;
	}

	@Override
	public boolean isBurning(BlockState state, IBlockReader world, BlockPos pos) {
		return true;
	}

	@Override
	public boolean removedByPlayer(BlockState state, World world, BlockPos pos, PlayerEntity player, boolean willHarvest, FluidState fluid) {
		return false;
	}

	@Override
	public boolean isFireSource(BlockState state, IWorldReader world, BlockPos pos, Direction side) {
		return true;
	}


	@Override
	public boolean canEntityDestroy(BlockState state, IBlockReader world, BlockPos pos, Entity entity) {
		return false;
	}



	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		this.tickcount = this.tickcount + 1;
		if (tickcount == 20) {
			this.randomTick(state, worldIn, pos, rand);
			this.tickcount = 0;
		}

	}
	@Override
	public boolean canBeReplaced(BlockState p_225541_1_, Fluid p_225541_2_) {
		return false;
	}

	@Override
	public boolean canBeReplaced(BlockState state, BlockItemUseContext useContext) {

		return false;
	}
	public void randomTick(World p_207186_1_, BlockPos pos, FluidState state, Random random) {
		if (p_207186_1_.getGameRules().getBoolean(GameRules.RULE_DOFIRETICK)) {
			int i = random.nextInt(10);
			if (i > 0) {
				BlockPos blockpos = pos;

				for (int j = 0; j < i; ++j) {
					blockpos = blockpos.offset(random.nextInt(10) - 1, 1, random.nextInt(10) - 1);
					if (!p_207186_1_.isEmptyBlock(blockpos)) {
						return;
					}

					BlockState blockstate = p_207186_1_.getBlockState(blockpos);
					BlockState FIRE = SoulFireBlock.canSurviveOnBlock(blockstate.getBlock())
							? Blocks.SOUL_FIRE.defaultBlockState()
							: ((FireBlock) Blocks.FIRE).defaultBlockState();
					if (blockstate.isAir()) {
						if (this.isSurroundingBlockFlammable(p_207186_1_, blockpos)) {
							p_207186_1_.setBlockAndUpdate(blockpos, ForgeEventFactory
									.fireFluidPlaceBlockEvent(p_207186_1_, blockpos, pos, FIRE));
							return;
						}
					} else if (blockstate.getMaterial().blocksMotion()) {
						return;
					}
				}
			} else {
				for (int k = 0; k < 10; ++k) {
					BlockPos blockpos1 = pos.offset(random.nextInt(10) - 1, 0, random.nextInt(10) - 1);
					BlockState FIRE = SoulFireBlock.canSurviveOnBlock(p_207186_1_.getBlockState(blockpos1).getBlock())
							? Blocks.SOUL_FIRE.defaultBlockState()
							: ((FireBlock) Blocks.FIRE).defaultBlockState();

					if (!p_207186_1_.isEmptyBlock(blockpos1)) {
						return;
					}

					if (p_207186_1_.isEmptyBlock(blockpos1.above()) && this.getCanBlockBurn(p_207186_1_, blockpos1)) {
						p_207186_1_.setBlockAndUpdate(blockpos1.above(), ForgeEventFactory
								.fireFluidPlaceBlockEvent(p_207186_1_, blockpos1.above(), pos, FIRE));
					}
				}
			}

		}
	}

	private boolean isSurroundingBlockFlammable(IWorldReader worldIn, BlockPos pos) {
		return true;
	}

	private boolean getCanBlockBurn(IWorldReader worldIn, BlockPos pos) {
		return (pos.getY() < 0 || pos.getY() >= 256 || worldIn.isWaterAt(pos)) && worldIn.getBlockState(pos).getMaterial().isFlammable();
	}

	@Override
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos,
			boolean isMoving) {
		Random rand = new Random();
		this.randomTick(worldIn, pos, state.getFluidState(), rand);
		if (this.reactWithNeighbors(worldIn, pos, state)) {
			super.neighborChanged(state, worldIn, pos, blockIn, fromPos, isMoving);
		}
	}

	private boolean reactWithNeighbors(World worldIn, BlockPos pos, BlockState state) {
		for (Direction direction : Direction.values()) {
			if (direction != Direction.DOWN) {
				BlockPos blockpos = pos.offset(direction.getNormal());
				if (worldIn.getFluidState(blockpos).is(FluidTags.WATER)) {
					Block block = worldIn.getFluidState(blockpos).isSource() ? Blocks.CRYING_OBSIDIAN
							: Blocks.OBSIDIAN;
					worldIn.setBlockAndUpdate(blockpos, net.minecraftforge.event.ForgeEventFactory
							.fireFluidPlaceBlockEvent(worldIn, blockpos, blockpos, block.defaultBlockState()));

					return false;
				}
				if (worldIn.getFluidState(blockpos).is(FluidTags.LAVA)) {
					Block block = worldIn.getFluidState(blockpos).isSource() ? Blocks.BLACKSTONE
							: Blocks.NETHERRACK;
					worldIn.setBlockAndUpdate(blockpos, net.minecraftforge.event.ForgeEventFactory
							.fireFluidPlaceBlockEvent(worldIn, blockpos, blockpos, block.defaultBlockState()));

					return false;
				}

			}
			if (direction == Direction.DOWN) {
				BlockPos blockpos = pos.offset(direction.getNormal());
				if (worldIn.getFluidState(blockpos).is(FluidTags.LAVA)) {
					Block block = worldIn.getFluidState(blockpos).isSource() ? Blocks.BLACKSTONE
							: Blocks.NETHERRACK;
					worldIn.setBlockAndUpdate(blockpos, net.minecraftforge.event.ForgeEventFactory
							.fireFluidPlaceBlockEvent(worldIn, blockpos, blockpos, block.defaultBlockState()));

					return false;
				}
			}
		}

		return true;
	}

	@Override
	public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if (this.reactWithNeighbors(worldIn, pos, state)) {
			worldIn.getLiquidTicks().scheduleTick(pos, state.getFluidState().getType(),
					this.getFluid().getTickDelay(worldIn));
			spawnParticles(worldIn, pos);
		}

	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if(stateIn.is(FluidList.molten_BlueLava_block.get())) {
			//spawnParticles(worldIn, pos);
		}
		super.animateTick(stateIn, worldIn, pos, rand);
	}

	private static void spawnParticles(World world, BlockPos worldIn) {
		double d0 = 0.5625D;
		Random random = world.random;
		if(world.getFluidState(worldIn).getFluidState().isSource()) {
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
	public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
		return 1000;
	}


 
	 public void transferPlayer(ServerPlayerEntity player, BlockPos pos) {
		   if(player.level.dimension.equals(AllTheModium.Mining)) {
			   ServerWorld targetWorld = player.server.getLevel(AllTheModium.OverWorld);
			   Teleporter teleporter = targetWorld.getPortalForcer();
			   player.changeDimension(targetWorld, teleporter);

		   } else {
			   ServerWorld targetWorld = player.server.getLevel(AllTheModium.Mining);
			   Teleporter teleporter = targetWorld.getPortalForcer();
			   player.changeDimension(targetWorld, teleporter);
		   }
	   }
	@Override
	public void observedNeighborChange(BlockState observerState, World world, BlockPos observerPos, Block changedBlock,
			BlockPos changedBlockPos) {
		if (this.reactWithNeighbors(world, observerPos, observerState)) {
			super.observedNeighborChange(observerState, world, observerPos, changedBlock, changedBlockPos);
		}
	}
}
