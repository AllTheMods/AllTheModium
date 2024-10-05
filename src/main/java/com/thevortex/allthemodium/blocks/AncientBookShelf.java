package com.thevortex.allthemodium.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

public class AncientBookShelf extends RotatedPillarBlock {

    public AncientBookShelf(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public float getEnchantPowerBonus(
            BlockState state,
            LevelReader world,
            BlockPos pos) {
        return 2.0f;
    }
}
