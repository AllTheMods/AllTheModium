package net.allthemods.allthemodium.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BrushableBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import net.allthemods.allthemodium.common.blocks.entity.ModiumBrushableBlockEntity;

public class ModiumBrushableBlock extends BrushableBlock {
    
    public ModiumBrushableBlock(Block turnsInto, SoundEvent brushSound, SoundEvent brushCompletedSound, Properties properties) {
        super(turnsInto, brushSound, brushCompletedSound, properties);
    }
    
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ModiumBrushableBlockEntity(pos, state);
    }
}
