package com.thevortex.allthemodium.blocks;

import java.util.ArrayList;
import java.util.List;

import com.thevortex.allthemodium.AllTheModium;
import com.thevortex.allthemodium.init.ModBlocks;
import com.thevortex.allthemodium.init.ModItems;

import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthetweaks.config.Configuration;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.PushReaction;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext.Builder;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.particles.ParticleType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.ModList;

public class TeleportPad extends Block {
	protected static final VoxelShape TELEPORTPAD_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D);

	public TeleportPad(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return TELEPORTPAD_AABB;
	}

	@Override
	public PushReaction getPistonPushReaction(BlockState state) {
		return PushReaction.BLOCK;
	}

	@Override
	public boolean hasTileEntity(BlockState state) {

		return false;
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos,
			ISelectionContext context) {

		return TELEPORTPAD_AABB;
	}

	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		if ((player instanceof ServerPlayerEntity) && (player.isCrouching() == true)) {

			transferPlayer((ServerPlayerEntity) player, pos);
			worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, pos.getX(), pos.getY() + 1, pos.getZ(), 0, 1, 0);
		}
		return super.use(state, worldIn, pos, player, handIn, hit);
	}

	@Override
	public boolean canHarvestBlock(BlockState state, IBlockReader world, BlockPos pos, PlayerEntity player) {
		if(player.level.dimension.getRegistryName().getNamespace().contains(Reference.MOD_ID)) {
			return false;
		} else {
			return true;
		}
	}

	public void transferPlayer(ServerPlayerEntity player, BlockPos pos) {
		int config = 0;
		if(ModList.get().isLoaded("allthetweaks")) {
			config = Configuration.COMMON.mainmode.get();
		}
		if (player.level.dimension.equals(AllTheModium.Mining)) {
			ServerWorld targetWorld = player.server.getLevel(AllTheModium.OverWorld);
			int y = 256;
			boolean located = false;
			while (y >= 1) {
				BlockPos posa = new BlockPos(Math.round(pos.getX()), y, Math.round(pos.getZ()));
				Block potential = targetWorld.getBlockState(posa).getBlock();
				if (potential.getRegistryName().getPath().equals("teleport_pad")) {
					located = true;
					break;

				} else {
					y--;
				}
			}
			if (located) {
				targetWorld.addParticle(ParticleTypes.SOUL_FIRE_FLAME, pos.getX(), pos.getY(), pos.getZ(), 0, 1, 0);
				player.teleportTo(targetWorld, pos.getX() + 0.5D, y + 0.25D, pos.getZ() + 0.5D, player.rotA,
						player.yya);
				player.connection.send(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
				return;
			} else {

				if ((!targetWorld.getBlockState(pos).hasTileEntity())
						&& (targetWorld.getBlockState(pos).canEntityDestroy(targetWorld, pos, player))) {
					//targetWorld.setBlockState(pos, ModBlocks.TELEPORT_PAD.getDefaultState());
				}

				targetWorld.addParticle(ParticleTypes.SOUL_FIRE_FLAME, pos.getX(), pos.getY(), pos.getZ(), 0, 1, 0);
				player.teleportTo(targetWorld, pos.getX() + 0.5D, pos.getY() + 0.25D, pos.getZ() + 0.5D, player.rotA,
						player.yya);
				player.connection.send(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
			}

		} else if (player.level.dimension.equals(AllTheModium.Nether)) {
			ServerWorld targetWorld = player.server.getLevel(AllTheModium.THE_OTHER);
			BlockPos targetPos = new BlockPos(Math.round(pos.getX()), 75, Math.round(pos.getZ()));
			if (!targetWorld.getBlockState(targetPos).hasTileEntity()) {

				targetWorld.setBlockAndUpdate(targetPos, ModBlocks.TELEPORT_PAD.defaultBlockState());
				targetWorld.addParticle(ParticleTypes.SOUL_FIRE_FLAME, pos.getX(), pos.getY(), pos.getZ(), 0, 1, 0);
				player.teleportTo(targetWorld, targetPos.getX() + 0.5D, targetPos.getY() + 0.25D, targetPos.getZ() + 0.5D, 0, 0);
				player.connection.send(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));

			}
		} else if (player.level.dimension.equals(AllTheModium.THE_OTHER)) {
			ServerWorld targetWorld = player.server.getLevel(AllTheModium.Nether);
			int y = 128;
			boolean located = false;
			while (y >= 1) {
				BlockPos posa = new BlockPos(Math.round(pos.getX()), y, Math.round(pos.getZ()));
				Block potential = targetWorld.getBlockState(posa).getBlock();
				if (potential.getRegistryName().getPath().equals("teleport_pad")) {
					located = true;
					break;

				} else {
					y--;
				}
			}
			if (located) {
				targetWorld.addParticle(ParticleTypes.SOUL_FIRE_FLAME, pos.getX(), pos.getY(), pos.getZ(), 0, 1, 0);
				player.teleportTo(targetWorld, pos.getX() + 0.5D, y + 0.25D, pos.getZ() + 0.5D, player.rotA,
						player.yya);
				player.connection.send(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
				return;
			} else {
				BlockPos newpos = new BlockPos(pos.getX(), 90 , pos.getZ());
				if ((!targetWorld.getBlockState(newpos).hasTileEntity())
						&& (targetWorld.getBlockState(newpos).canEntityDestroy(targetWorld, newpos, player))) {
					targetWorld.setBlockAndUpdate(newpos, ModBlocks.TELEPORT_PAD.defaultBlockState());
				}

				targetWorld.addParticle(ParticleTypes.SOUL_FIRE_FLAME, newpos.getX(), newpos.getY(), newpos.getZ(), 0, 1, 0);
				player.teleportTo(targetWorld, newpos.getX() + 0.5D, newpos.getY() + 0.25D, newpos.getZ() + 0.5D, player.rotA,
						player.yya);
				player.connection.send(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
			}
		} else if (player.level.dimension.equals(AllTheModium.OverWorld) && (config != 2)) {
			ServerWorld targetWorld = player.server.getLevel(AllTheModium.Mining);
			BlockPos targetPos = new BlockPos(Math.round(pos.getX()), 75, Math.round(pos.getZ()));
			if (!targetWorld.getBlockState(targetPos).hasTileEntity()) {
				targetWorld.setBlockAndUpdate(targetPos, ModBlocks.TELEPORT_PAD.defaultBlockState());
				targetWorld.addParticle(ParticleTypes.SOUL_FIRE_FLAME, pos.getX(), pos.getY(), pos.getZ(), 0, 1, 0);
				player.teleportTo(targetWorld, targetPos.getX() + 0.5D, targetPos.getY() + 0.25D, targetPos.getZ() + 0.5D, 0, 0);
				player.connection.send(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
			}
		} /*else if (player.world.getDimensionKey().equals(AllTheModium.The_End)) {
			ServerWorld targetWorld = player.server.getWorld(AllTheModium.THE_BEYOND);
			BlockPos targetPos = new BlockPos(Math.round(pos.getX()), 75, Math.round(pos.getZ()));
			if (targetWorld.getBlockState(targetPos).hasTileEntity() == false) {
				targetWorld.setBlockState(targetPos, ModBlocks.TELEPORT_PAD.getDefaultState());
				targetWorld.addParticle(ParticleTypes.SOUL_FIRE_FLAME, pos.getX(), pos.getY(), pos.getZ(), 0, 1, 0);
				player.teleport(targetWorld, targetPos.getX() + 0.5D, targetPos.getY() + 0.25D, targetPos.getZ() + 0.5D, 0, 0);
				player.connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
			}
		}else if (player.world.getDimensionKey().equals(AllTheModium.THE_BEYOND)) {
			ServerWorld targetWorld = player.server.getWorld(AllTheModium.The_End);
			int y = 256;
			boolean located = false;
			while (y >= 1) {
				BlockPos posa = new BlockPos(Math.round(pos.getX()), y, Math.round(pos.getZ()));
				Block potential = targetWorld.getBlockState(posa).getBlock();
				if (potential.getRegistryName().getPath().equals("teleport_pad")) {
					located = true;
					break;

				} else {
					y--;
				}
			}
			if (located) {
				targetWorld.addParticle(ParticleTypes.SOUL_FIRE_FLAME, pos.getX(), pos.getY(), pos.getZ(), 0, 1, 0);
				player.teleport(targetWorld, pos.getX() + 0.5D, y + 0.25D, pos.getZ() + 0.5D, player.rotationYaw,
						player.rotationPitch);
				player.connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
				return;
			}
		}*/

	}

	@Override
	public List<ItemStack> getDrops(BlockState state, Builder builder) {
		List<ItemStack> list = new ArrayList<ItemStack>();
		list.add(new ItemStack(ModItems.TELEPORT_PAD));
		return list;
	}
}
