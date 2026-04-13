package net.allthemods.allthemodium.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class OtherBookshelfBlock extends Block {
    
    public OtherBookshelfBlock(Properties properties) {
        super(properties);
    }
    
    @Override
    public float getEnchantPowerBonus(BlockState state, BlockGetter level, BlockPos pos) {
        return 4.0F;
    }
}
