package com.thevortex.allthemodium.blocks;

import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class AncientHerb extends Block {
    public AncientHerb(Properties props) {
        super(props);
    }
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        if(!level.getBlockState(pos.below()).is(BlockTags.DIRT)) {
            dropResources(state, level, pos);
            level.removeBlock(pos, false);

        }
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, Random rand) {
        super.tick(state, level, pos, rand);
        if(!level.getBlockState(pos.below()).is(BlockTags.DIRT)) {
            dropResources(state, level, pos);
            level.removeBlock(pos, false);
        }
    }
}
