package com.thevortex.allthemodium.blocks;

import java.util.ArrayList;
import java.util.List;

import com.thevortex.allthemodium.AllTheModium;

import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.reference.TweakProxy;
import com.thevortex.allthemodium.registry.LevelRegistry;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeConfig.Server;

public class TeleportPad extends Block {
	protected static final VoxelShape TELEPORTPAD_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D);
	protected static final String MINING =  "allthemodium:mining";
	protected static final String THE_OTHER = "allthemodium:the_other";
	protected static final String THE_BEYOND = "allthemodium:the_beyond";
	protected static final String THE_END = "minecraft:the_end";
	protected static final String NETHER = "minecraft:the_nether";
	protected static final String OVERWORLD = "minecraft:overworld";
	protected Integer lastTeleport = 0;
	public TeleportPad(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player,
								 InteractionHand handIn, BlockHitResult hit) {
		if ((player instanceof ServerPlayer) && (player.isCrouching() == true)) {

			transferPlayer((ServerPlayer) player, pos);
			worldIn.addAlwaysVisibleParticle(ParticleTypes.SOUL_FIRE_FLAME, pos.getX(), pos.getY() + 1, pos.getZ(), 0, 1, 0);
		}
		return super.use(state, worldIn, pos, player, handIn, hit);
	}

	

	public void transferPlayer(ServerPlayer player, BlockPos pos) {
		int config = TweakProxy.packMode();
		AllTheModium.LOGGER.info("Config Value: " + config);
		switch (player.level().dimension().location().toString()) {

			case(OVERWORLD):
				switch(config) {
					case 2:
						break;
					default:
						teleport(LevelRegistry.Mining, player, pos, player.server.getTickCount());
				}
			case(MINING):
				teleport(AllTheModium.OverWorld, player, pos, player.server.getTickCount());
				break;
			case(NETHER):
				teleport(LevelRegistry.THE_OTHER, player, pos, player.server.getTickCount());
				break;
			case(THE_OTHER):
				switch(config) {
					case 5:
						teleport(AllTheModium.The_End, player, pos, player.server.getTickCount());
						break;
					default:
						teleport(AllTheModium.Nether, player, pos, player.server.getTickCount());
						break;
				}
			case(THE_END):
				switch(config) {
					case 5:
						teleport(LevelRegistry.THE_OTHER, player, pos, player.server.getTickCount());
						break;
					default:
						teleport(LevelRegistry.THE_BEYOND, player, pos, player.server.getTickCount());
						break;
				}
			case(THE_BEYOND):
				teleport(AllTheModium.The_End, player, pos, player.server.getTickCount());
				break;
			
		}

	}

	private void teleport(ResourceKey<Level> destination,ServerPlayer player, BlockPos pos, Integer tickCount) {
			if(lastTeleport == 0){ lastTeleport = tickCount - 25; }
			if(tickCount - lastTeleport < 20) {
				return;
			}
			ServerLevel targetWorld = player.server.getLevel(destination);
			int y = 256;
			boolean located = false;
			while (y >= 1) {
				BlockPos posa = new BlockPos(Math.round(pos.getX()), y, Math.round(pos.getZ()));
				Block potential = targetWorld.getBlockState(posa).getBlock();
				if (potential.getName().toString().contains("teleport_pad")) {
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
				lastTeleport = tickCount;
				return;
				} else {

					if ((!targetWorld.getBlockState(pos).hasBlockEntity())
							&& (targetWorld.getBlockState(pos).canEntityDestroy(targetWorld, pos, player))) {
						targetWorld.setBlockAndUpdate(pos, ModRegistry.TELEPORT_PAD.get().defaultBlockState());
					}

					targetWorld.addParticle(ParticleTypes.SOUL_FIRE_FLAME, pos.getX(), pos.getY(), pos.getZ(), 0, 1, 0);
					player.teleportTo(targetWorld, pos.getX() + 0.5D, pos.getY() + 0.25D, pos.getZ() + 0.5D, player.rotA,
							player.yya);
					lastTeleport = tickCount;
				}

		}

		@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return TELEPORTPAD_AABB;
	}



	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos,
			CollisionContext context) {

		return TELEPORTPAD_AABB;
	}

	@Override
	public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
		if(player.level().dimension().registry().getNamespace().contains(Reference.MOD_ID)) {
			return false;
		} else {
			return true;
		}
	}
}
