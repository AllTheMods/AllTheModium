package com.thevortex.allthemodium.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
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
		return super.canEntityDestroy(state,world,pos,player) && canBreak(pos, player);
	}

	@Override
    protected float getDestroyProgress(final BlockState state, final Player player, final BlockGetter getter,
                                       final BlockPos blockPos) {
        return canEntityDestroy(state, getter, blockPos, player) ? destroyProgress(state, player, blockPos) : 0.0F;
    }

	/** Ancient stone refuses fake players, and anyone breaking it from 16 or more blocks away. */
	static boolean canBreak(BlockPos pos, Entity entity) {
		return !(entity instanceof FakePlayer) && distanceTo(pos, entity.blockPosition()) < 16.0F;
	}

	/**
	 * Break progress per tick for a block whose hardness is -1, which vanilla treats as unbreakable: the dig speed
	 * divided by 500 with the correct tool, or by 3000 without.
	 */
	static float destroyProgress(BlockState state, Player player, BlockPos pos) {
		int i = player.hasCorrectToolForDrops(state, player.level(), pos) ? 250 : 1500;
		return player.getDigSpeed(state, pos) / 2.0F / i;
	}

	private static double distanceTo(BlockPos block,BlockPos player) {
		return Math.sqrt(Math.pow(block.getX() - player.getX(), 2) + Math.pow(block.getY() - player.getY(), 2) + Math.pow(block.getZ() - player.getZ(), 2));
	}
}





