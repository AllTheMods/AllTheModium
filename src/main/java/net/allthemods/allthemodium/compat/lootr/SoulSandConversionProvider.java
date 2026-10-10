package net.allthemods.allthemodium.compat.lootr;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import net.allthemods.allthemodium.core.registry.ATMTags;

import noobanidus.mods.lootr.common.api.conversion.ILootrBlockConversionProvider;

public class SoulSandConversionProvider implements ILootrBlockConversionProvider {

    @Override
    public TagKey<Block> getApplicableTag() {
        return ATMTags.Blocks.LOOTR_CONVERT_SOUL_SANDS;
    }

    @Override
    public Block getBlock() {
        return LootrCompat.SUSPICIOUS_SOUL_SAND.get();
    }
}
