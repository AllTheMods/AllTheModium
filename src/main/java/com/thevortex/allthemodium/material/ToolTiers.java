package com.thevortex.allthemodium.material;

import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.ModRegistry;
import com.thevortex.allthemodium.registry.TagRegistry;
import java.util.List;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

public class ToolTiers {

    public static final TagKey<Block> ALLTHEMODIUM_TOOL_TAG = BlockTags.create(
            new ResourceLocation("mineable/pickaxe"));

    public static final TagKey<Block> ALLTHEMODIUM_TIER_TAG = TagRegistry.NEEDS_ALLTHEMODIUM_TOOL;
    public static final TagKey<Block> ALLOY_TIER_TAG = TagRegistry.NEEDS_ALLOY_TOOL;

    public static final Tier ALLTHEMODIUM_TIER = TierSortingRegistry.registerTier(
            new ForgeTier(
                    5,
                    15000,
                    10,
                    11.0F,
                    85,
                    ALLTHEMODIUM_TIER_TAG,
                    () -> Ingredient.of(ModRegistry.ALLTHEMODIUM_INGOT.get())),
            new ResourceLocation(Reference.MOD_ID, "allthemodium"),
            List.of(Tiers.NETHERITE),
            List.of());

    public static final Tier ALLOY_TIER = TierSortingRegistry.registerTier(
            new ForgeTier(
                    5,
                    15000,
                    10,
                    11.0F,
                    85,
                    ALLOY_TIER_TAG,
                    () -> Ingredient.of(ModRegistry.ALLTHEMODIUM_INGOT.get())),
            new ResourceLocation(Reference.MOD_ID, "allthemodium_alloy"),
            List.of(ToolTiers.ALLTHEMODIUM_TIER),
            List.of());
}
