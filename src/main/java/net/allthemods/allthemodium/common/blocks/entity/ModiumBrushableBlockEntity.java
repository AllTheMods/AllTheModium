package net.allthemods.allthemodium.common.blocks.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import net.allthemods.allthemodium.core.registry.ATMBlocks;

import org.jspecify.annotations.NonNull;

public class ModiumBrushableBlockEntity extends BrushableBlockEntity {
    
    public ModiumBrushableBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }
    
    @Override
    public @NonNull BlockEntityType<ModiumBrushableBlockEntity> getType() {
        return ATMBlocks.BRUSHABLE_BLOCK.get();
    }
}
