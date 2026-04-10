package net.allthemods.allthemodium.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;

import net.allthemods.allthemodium.core.registry.ATMTags;

public class OtherSaplingBlock extends SaplingBlock {
    
    public OtherSaplingBlock(TreeGrower treeGrower, Properties properties) {
        super(treeGrower, properties);
    }
    
    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(ATMTags.Blocks.SUPPORTS_OTHER_VEGETATION);
    }
}
