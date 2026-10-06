package com.thevortex.allthemodium.compat.lootr;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import noobanidus.mods.lootr.common.api.replacement.ILootrBlockReplacementProvider;

public class SoulSandReplacementProvider implements ILootrBlockReplacementProvider {

    @Override
    public TagKey<Block> getApplicableTag() {
        return LootrCompat.CONVERT_SOUL_SANDS;
    }

    @Override
    public Block getBlock() {
        return LootrCompat.SUSPICIOUS_SOUL_SAND.get();
    }
}
