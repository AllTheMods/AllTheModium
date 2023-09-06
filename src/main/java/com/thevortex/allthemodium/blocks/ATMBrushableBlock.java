package com.thevortex.allthemodium.blocks;

import com.thevortex.allthemodium.blocks.entity.ATMBrushableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BrushableBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class ATMBrushableBlock extends BrushableBlock
{
    public ATMBrushableBlock(Block block, Properties properties, SoundEvent soundBrush, SoundEvent soundCompleted) {
        super(block, properties, soundBrush, soundCompleted);
    }

    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ATMBrushableBlockEntity(pos, state);
    }
}
