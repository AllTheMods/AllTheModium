package com.thevortex.allthemodium.blocks;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;

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
	public boolean ticksRandomly(BlockState state) {
		return true;
	}

	@Override
	public boolean isBurning(BlockState state, IBlockReader world, BlockPos pos) {
		return true;
	}

	@Override
	public boolean isFireSource(BlockState state, IWorldReader world, BlockPos pos, Direction side) {
		return true;
	}

	@Override
	public boolean isReplaceable(BlockState p_225541_1_, Fluid p_225541_2_) {
		return false;
	}

	@Override
	public boolean isReplaceable(BlockState state, BlockItemUseContext useContext) {

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

	public void randomTick(World p_207186_1_, BlockPos pos, FluidState state, Random random) {
		if (p_207186_1_.getGameRules().getBoolean(GameRules.DO_FIRE_TICK)) {
			int i = random.nextInt(10);
			if (i > 0) {
				BlockPos blockpos = pos;

				for (int j = 0; j < i; ++j) {
					blockpos = blockpos.add(random.nextInt(10) - 1, 1, random.nextInt(10) - 1);
					if (!p_207186_1_.isBlockPresent(blockpos)) {
						return;
					}

					BlockState blockstate = p_207186_1_.getBlockState(blockpos);
					BlockState FIRE = SoulFireBlock.shouldLightSoulFire(blockstate.getBlock())
							? Blocks.SOUL_FIRE.getDefaultState()
							: ((FireBlock) Blocks.FIRE).getDefaultState();
					if (blockstate.isAir()) {
						if (this.isSurroundingBlockFlammable(p_207186_1_, blockpos)) {
							p_207186_1_.setBlockState(blockpos, ForgeEventFactory
									.fireFluidPlaceBlockEvent(p_207186_1_, blockpos, pos, FIRE));
							return;
						}
					} else if (blockstate.getMaterial().blocksMovement()) {
						return;
					}
				}
			} else {
				for (int k = 0; k < 10; ++k) {
					BlockPos blockpos1 = pos.add(random.nextInt(10) - 1, 0, random.nextInt(10) - 1);
					BlockState FIRE = SoulFireBlock.shouldLightSoulFire(p_207186_1_.getBlockState(blockpos1).getBlock())
							? Blocks.SOUL_FIRE.getDefaultState()
							: ((FireBlock) Blocks.FIRE).getDefaultState();

					if (!p_207186_1_.isBlockPresent(blockpos1)) {
						return;
					}

					if (p_207186_1_.isAirBlock(blockpos1.up()) && this.getCanBlockBurn(p_207186_1_, blockpos1)) {
						p_207186_1_.setBlockState(blockpos1.up(), ForgeEventFactory
								.fireFluidPlaceBlockEvent(p_207186_1_, blockpos1.up(), pos, FIRE));
					}
				}
			}

		}
	}

	private boolean isSurroundingBlockFlammable(IWorldReader worldIn, BlockPos pos) {
		return true;
	}

	private boolean getCanBlockBurn(IWorldReader worldIn, BlockPos pos) {
		return pos.getY() >= 0 && pos.getY() < 256 && !worldIn.isBlockLoaded(pos) ? false
				: worldIn.getBlockState(pos).getMaterial().isFlammable();
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
				BlockPos blockpos = pos.offset(direction);
				if (worldIn.getFluidState(blockpos).isTagged(FluidTags.WATER)) {
					Block block = worldIn.getFluidState(blockpos).isSource() ? Blocks.CRYING_OBSIDIAN
							: Blocks.OBSIDIAN;
					worldIn.setBlockState(blockpos, net.minecraftforge.event.ForgeEventFactory
							.fireFluidPlaceBlockEvent(worldIn, blockpos, blockpos, block.getDefaultState()));

					return false;
				}
				if (worldIn.getFluidState(blockpos).isTagged(FluidTags.LAVA)) {
					Block block = worldIn.getFluidState(blockpos).isSource() ? Blocks.BLACKSTONE
							: Blocks.NETHERRACK;
					worldIn.setBlockState(blockpos, net.minecraftforge.event.ForgeEventFactory
							.fireFluidPlaceBlockEvent(worldIn, blockpos, blockpos, block.getDefaultState()));

					return false;
				}

			}
			if (direction == Direction.DOWN) {
				BlockPos blockpos = pos.offset(direction);
				if (worldIn.getFluidState(blockpos).isTagged(FluidTags.LAVA)) {
					Block block = worldIn.getFluidState(blockpos).isSource() ? Blocks.BLACKSTONE
							: Blocks.NETHERRACK;
					worldIn.setBlockState(blockpos, net.minecraftforge.event.ForgeEventFactory
							.fireFluidPlaceBlockEvent(worldIn, blockpos, blockpos, block.getDefaultState()));

					return false;
				}
			}
		}

		return true;
	}

	@Override
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if (this.reactWithNeighbors(worldIn, pos, state)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, state.getFluidState().getFluid(),
					this.getFluid().getTickRate(worldIn));
			spawnParticles(worldIn, pos);
		}

	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {

		spawnParticles(worldIn, pos);
		super.animateTick(stateIn, worldIn, pos, rand);
	}

	private static void spawnParticles(World p_180691_0_, BlockPos worldIn) {
		double d0 = 0.5625D;
		Random random = p_180691_0_.rand;
		if ((!p_180691_0_.getBlockState(worldIn).isOpaqueCube(p_180691_0_, worldIn))
				&& (p_180691_0_.getBlockState(worldIn).getFluidState().isSource() == true)) {
			p_180691_0_.addParticle(ParticleTypes.SOUL_FIRE_FLAME, (double) worldIn.getX() + 0.5D,
					(double) worldIn.getY() + 0.5D, (double) worldIn.getZ() + 0.5D,
					(double) (random.nextFloat() / 2.0F), 5.0E-5D, (double) (random.nextFloat() / 2.0F));

		}

	}

	@Override
	public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
		return 1000;
	}

	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		
		entityIn.attackEntityFrom(DamageSource.LAVA, 6.0F);
	}
 
	 public void transferPlayer(ServerPlayerEntity player, BlockPos pos) {
		   if(player.world.getWorldInfo().equals(AllTheModium.Mining)) {
			   ServerWorld targetWorld = player.server.getWorld(AllTheModium.OverWorld);
			   Teleporter teleporter = targetWorld.getDefaultTeleporter();
			   player.changeDimension(targetWorld, teleporter);

		   } else {
			   ServerWorld targetWorld = player.server.getWorld(AllTheModium.Mining);
			   Teleporter teleporter = targetWorld.getDefaultTeleporter();
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
