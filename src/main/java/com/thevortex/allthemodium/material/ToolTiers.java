package com.thevortex.allthemodium.material;

import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ToolTiers {


    public static final Tag.Named<Block> ALLTHEMODIUM_TOOL_TAG = BlockTags.createOptional(new ResourceLocation(Reference.MOD_ID,"mineable/allthemodium_pickaxe"));
    public static final Tag.Named<Block> VIBRANIUM_TOOL_TAG = BlockTags.createOptional(new ResourceLocation(Reference.MOD_ID,"mineable/vibranium_pickaxe"));
    public static final Tag.Named<Block> UNOBTAINIUM_TOOL_TAG = BlockTags.createOptional(new ResourceLocation(Reference.MOD_ID,"mineable/unobtainium_pickaxe"));

    public static final Tag.Named<Block> ALLTHEMODIUM_TIER_TAG = BlockTags.createOptional(new ResourceLocation(Reference.MOD_ID,"needs_allthemodium_tool"));
    public static final Tag.Named<Block> VIBRANIUM_TIER_TAG = BlockTags.createOptional(new ResourceLocation(Reference.MOD_ID,"needs_vibranium_tool"));
    public static final Tag.Named<Block> UNOBTAINIUM_TIER_TAG = BlockTags.createOptional(new ResourceLocation(Reference.MOD_ID,"needs_unobtainium_tool"));

    public static final Tier UNOBTAINIUM_TIER = TierSortingRegistry.registerTier(
            new ForgeTier(7, 20000, 30, 200, 500, UNOBTAINIUM_TIER_TAG, () -> Ingredient.of(ModRegistry.UNOBTAINIUM_INGOT.get())),
            new ResourceLocation(Reference.MOD_ID,"unobtainium_tier"),
            List.of(Tiers.NETHERITE), List.of());

    public static final Tier VIBRANIUM_TIER = TierSortingRegistry.registerTier(
            new ForgeTier(6, 10000, 40, 100, 250, VIBRANIUM_TIER_TAG, () -> Ingredient.of(ModRegistry.VIBRANIUM_INGOT.get())),
            new ResourceLocation(Reference.MOD_ID,"vibranium_tier"),
            List.of(Tiers.NETHERITE), List.of(UNOBTAINIUM_TIER));

    public static final Tier ALLTHEMODIUM_TIER = TierSortingRegistry.registerTier(
            new ForgeTier(5, 15000, 10, 50, 125, ALLTHEMODIUM_TIER_TAG, () -> Ingredient.of(ModRegistry.ALLTHEMODIUM_INGOT.get())),
            new ResourceLocation(Reference.MOD_ID,"allthemodium_tier"),
            List.of(Tiers.NETHERITE), List.of(VIBRANIUM_TIER));

}
