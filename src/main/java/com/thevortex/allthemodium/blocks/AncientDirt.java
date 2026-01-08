package com.thevortex.allthemodium.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.SpecialPlantable;
import org.jetbrains.annotations.Nullable;

public class AncientDirt extends Block implements SpecialPlantable
{
    public AncientDirt(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public boolean canPlacePlantAtPosition(ItemStack arg0, LevelReader arg1, BlockPos arg2, @Nullable Direction arg3) {
        return true;
    }


    @Override
    public void spawnPlantAtPosition(ItemStack arg0, LevelAccessor arg1, BlockPos arg2, @Nullable Direction arg3) {

    }
}
