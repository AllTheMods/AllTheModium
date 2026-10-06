package com.thevortex.allthemodium.compat.lootr;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import noobanidus.mods.lootr.common.api.replacement.ILootrBlockReplacementProvider;

public class ClayReplacementProvider implements ILootrBlockReplacementProvider {

    @Override
    public TagKey<Block> getApplicableTag() {
        return LootrCompat.CONVERT_CLAYS;
    }

    @Override
    public Block getBlock() {
        return LootrCompat.SUSPICIOUS_CLAY.get();
    }
}
