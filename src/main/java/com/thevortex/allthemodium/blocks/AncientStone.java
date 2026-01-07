package com.thevortex.allthemodium.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.util.FakePlayer;

public class AncientStone extends Block
{
	  // public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;
	public AncientStone() {	//func_235861_h_ = setRequiresTool
		super(Properties.of().requiresCorrectToolForDrops().isRedstoneConductor((BlockState state, BlockGetter level, BlockPos pos) -> false).sound(SoundType.ANCIENT_DEBRIS).lightLevel((state) -> { return 0;}).strength(-1.0f,1500.0f));
	}

	@Override
	public boolean canEntityDestroy(BlockState state, BlockGetter world, BlockPos pos, Entity player) {
		if((player instanceof FakePlayer)) { return false; }

	return super.canEntityDestroy(state,world,pos,player) && (distanceTo(pos,player.blockPosition()) < 16.0F);
	}

	private double distanceTo(BlockPos block,BlockPos player) {
		return Math.sqrt(Math.pow(block.getX() - player.getX(), 2) + Math.pow(block.getY() - player.getY(), 2) + Math.pow(block.getZ() - player.getZ(), 2));
	}

	@Override
    protected float getDestroyProgress(final BlockState state, final Player player, final BlockGetter getter,
                                       final BlockPos blockPos) {
        BlockEntity blockEntity = getter.getBlockEntity(blockPos);
        if (canEntityDestroy(state,getter,blockPos, player)) {
            int i = player.hasCorrectToolForDrops(state, player.level(), blockPos) ? 250 : 1500;
            return player.getDigSpeed(state, blockPos) / 2.0F / i;
        }
        return 0.0F;
    }
}





