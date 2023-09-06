package com.thevortex.allthemodium.blocks.entity;

import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ATMBrushableBlockEntity extends BrushableBlockEntity
{
    public ATMBrushableBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModRegistry.BRUSHABLE_BLOCK.get();
    }
}
