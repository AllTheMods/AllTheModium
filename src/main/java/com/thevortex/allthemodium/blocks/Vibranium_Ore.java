package com.thevortex.allthemodium.blocks;

import java.util.ArrayList;
import java.util.List;

import com.thevortex.allthemodium.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.util.FakePlayer;

public class Vibranium_Ore extends OreBlock {

	public Vibranium_Ore() {//func_235861_h_ = setRequiresTool
		super(Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(29.0f));
	}

	@Override
	public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
		if((player instanceof FakePlayer) && (state.getBlock() == ModBlocks.VIBRANIUM_ORE)) { return false; }
		return super.canHarvestBlock(state,world,pos,player) && (distanceTo(pos,player.blockPosition()) < 16.0F);
	}

	private double distanceTo(BlockPos block,BlockPos player) {
		return Math.sqrt(Math.pow(block.getX() - player.getX(), 2) + Math.pow(block.getY() - player.getY(), 2) + Math.pow(block.getZ() - player.getZ(), 2));
	}
	@Override
	public PushReaction getPistonPushReaction(BlockState state) {

		return PushReaction.BLOCK;
	}
	@Override
	public int getHarvestLevel(BlockState state) {
		return 5;
	}
	@Override
	public ToolType getHarvestTool(BlockState state) {
		
		return ToolType.PICKAXE;
	}
	
}
