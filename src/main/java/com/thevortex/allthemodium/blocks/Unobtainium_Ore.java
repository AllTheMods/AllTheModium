package com.thevortex.allthemodium.blocks;

import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.PushReaction;

import net.minecraftforge.common.util.FakePlayer;

public class Unobtainium_Ore extends OreBlock {

	public Unobtainium_Ore() {//func_235861_h_ = setRequiresTool
		super(Properties.of(Material.STONE).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(20.0f));
	}

	@Override
	public boolean canEntityDestroy(BlockState state, BlockGetter world, BlockPos pos, Entity player) {
		if((player instanceof FakePlayer) && (state.getBlock() == ModRegistry.UNOBTAINIUM_ORE.get())) { return false; }
		return super.canEntityDestroy(state,world,pos,player) && (distanceTo(pos,player.blockPosition()) < 16.0F);
	}

	private double distanceTo(BlockPos block,BlockPos player) {
		return Math.sqrt(Math.pow(block.getX() - player.getX(), 2) + Math.pow(block.getY() - player.getY(), 2) + Math.pow(block.getZ() - player.getZ(), 2));
	}
	@Override
	public PushReaction getPistonPushReaction(BlockState state) {

		return PushReaction.BLOCK;
	}

}
