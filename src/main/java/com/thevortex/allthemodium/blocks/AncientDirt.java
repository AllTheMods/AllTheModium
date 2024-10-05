package com.thevortex.allthemodium.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;

public class AncientDirt extends Block {

    public AncientDirt(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public boolean canSustainPlant(
            BlockState state,
            BlockGetter world,
            BlockPos pos,
            Direction facing,
            IPlantable plantable) {
        return true;
    }
}
