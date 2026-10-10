package net.allthemods.allthemodium.compat.lootr;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import noobanidus.mods.lootr.common.impl.type.BrushableLootrType;

public class SoulSandLootrType extends BrushableLootrType {

    @Override
    public String getName() {
        return LootrCompat.SOUL_SAND_TYPE;
    }

    @Override
    public Block getReplacementBlock() {
        return Blocks.SOUL_SAND;
    }
}
