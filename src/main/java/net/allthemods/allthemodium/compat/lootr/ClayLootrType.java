package net.allthemods.allthemodium.compat.lootr;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import noobanidus.mods.lootr.common.impl.type.BrushableLootrType;

public class ClayLootrType extends BrushableLootrType {

    @Override
    public String getName() {
        return LootrCompat.CLAY_TYPE;
    }

    @Override
    public Block getReplacementBlock() {
        return Blocks.CLAY;
    }
}
