package com.thevortex.allthemodium.material;

import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.reference.TagRegistry;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ToolTiers {


    public static final TagKey<Block> ALLTHEMODIUM_TOOL_TAG = BlockTags.create(new ResourceLocation("mineable/pickaxe"));
    public static final TagKey<Block> VIBRANIUM_TOOL_TAG = BlockTags.create(new ResourceLocation("mineable/pickaxe"));
    public static final TagKey<Block> UNOBTAINIUM_TOOL_TAG = BlockTags.create(new ResourceLocation("mineable/pickaxe"));

    public static final TagKey<Block> ALLTHEMODIUM_TIER_TAG = TagRegistry.NEEDS_ALLTHEMODIUM_TOOL;
    public static final TagKey<Block> VIBRANIUM_TIER_TAG = TagRegistry.NEEDS_VIBRANIUM_TOOL;
    public static final TagKey<Block> UNOBTAINIUM_TIER_TAG = TagRegistry.NEEDS_UNOBTAINIUM_TOOL;

    public static final Tier UNOBTAINIUM_TIER = TierSortingRegistry.registerTier(
            new ForgeTier(7, 20000, 30, 200, 500, UNOBTAINIUM_TIER_TAG, () -> Ingredient.of(ModRegistry.UNOBTAINIUM_INGOT.get())),
            new ResourceLocation(Reference.MOD_ID,"unobtainium"),
            List.of(Tiers.NETHERITE), List.of());

    public static final Tier VIBRANIUM_TIER = TierSortingRegistry.registerTier(
            new ForgeTier(6, 10000, 40, 100, 250, VIBRANIUM_TIER_TAG, () -> Ingredient.of(ModRegistry.VIBRANIUM_INGOT.get())),
            new ResourceLocation(Reference.MOD_ID,"vibranium"),
            List.of(Tiers.NETHERITE), List.of(UNOBTAINIUM_TIER));

    public static final Tier ALLTHEMODIUM_TIER = TierSortingRegistry.registerTier(
            new ForgeTier(5, 15000, 10, 50, 125, ALLTHEMODIUM_TIER_TAG, () -> Ingredient.of(ModRegistry.ALLTHEMODIUM_INGOT.get())),
            new ResourceLocation(Reference.MOD_ID,"allthemodium"),
            List.of(Tiers.NETHERITE), List.of(VIBRANIUM_TIER));

}
