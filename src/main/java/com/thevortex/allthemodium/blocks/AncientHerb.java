package com.thevortex.allthemodium.blocks;

import java.util.Random;
import javax.annotation.Nonnull;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class AncientHerb extends Block {

    public AncientHerb(Properties props) {
        super(props);
    }

    public void randomTick(
            BlockState state,
            ServerLevel level,
            BlockPos pos,
            Random random) {
        if (!level.getBlockState(pos.below()).is(BlockTags.DIRT)) {
            dropResources(state, level, pos);
            level.removeBlock(pos, false);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void tick(
            @Nonnull BlockState state,
            @Nonnull ServerLevel level,
            @Nonnull BlockPos pos,
            @Nonnull RandomSource rand) {
        super.tick(state, level, pos, rand);
        if (!level.getBlockState(pos.below()).is(BlockTags.DIRT)) {
            dropResources(state, level, pos);
            level.removeBlock(pos, false);
        }
    }
}
