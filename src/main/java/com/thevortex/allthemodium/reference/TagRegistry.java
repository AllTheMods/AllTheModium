package com.thevortex.allthemodium.reference;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.Tags;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class TagRegistry {

    public static final Tag.Named<Block> ALLTHEMODIUM_ORE = BlockTags.createOptional(Reference.ore("allthemodium"));
    public static final Tag.Named<Block> VIBRANIUM_ORE = BlockTags.createOptional(Reference.ore("vibranium"));
    public static final Tag.Named<Block> UNOBTAINIUM_ORE = BlockTags.createOptional(Reference.ore("unobtainium"));

    public static final Tag.Named<Block> ANCIENT_DIRT = BlockTags.createOptional(Reference.location("allthemodium:ancient_dirt"));
    public static final Tag.Named<Block> ANCIENT_STONE = BlockTags.createOptional(Reference.location("allthemodium:ancient_stone"));
    public static final Tag.Named<Item> ANCIENT_STONE_ITEM = ItemTags.createOptional(Reference.location("allthemodium:ancient_stone"));
    public static final Tag.Named<Block> ANCIENT_WOODEN_PLANKS = BlockTags.createOptional(Reference.location("allthemodium:ancient_planks"));
    public static final Tag.Named<Item> ANCIENT_WOODEN_PLANKS_ITEM = ItemTags.createOptional(Reference.location("allthemodium:ancient_planks"));
    public static final Tag.Named<Block> ANCIENT_MOSSY_STONE = BlockTags.createOptional(Reference.location("allthemodium:ancient_mossy_stone"));
    public static final Tag.Named<Item> ANCIENT_MOSSY_STONE_ITEM = ItemTags.createOptional(Reference.location("allthemodium:ancient_mossy_stone"));
    public static final Tag.Named<Block> ANCIENT_SMOOTH_STONE = BlockTags.createOptional(Reference.location("allthemodium:ancient_smooth_stone"));
    public static final Tag.Named<Item> ANCIENT_SMOOTH_STONE_ITEM = ItemTags.createOptional(Reference.location("allthemodium:ancient_smooth_stone"));
    public static final Tag.Named<Block> ANCIENT_POLISHED_STONE = BlockTags.createOptional(Reference.location("allthemodium:ancient_polished_stone"));
    public static final Tag.Named<Item> ANCIENT_POLISHED_STONE_ITEM = ItemTags.createOptional(Reference.location("allthemodium:ancient_polished_stone"));
    public static final Tag.Named<Block> ANCIENT_STONE_BRICKS = BlockTags.createOptional(Reference.location("allthemodium:ancient_stone_bricks"));
    public static final Tag.Named<Item> ANCIENT_STONE_BRICKS_ITEM = ItemTags.createOptional(Reference.location("allthemodium:ancient_stone_bricks"));
    public static final Tag.Named<Block> ANCIENT_CRACKED_STONE_BRICKS = BlockTags.createOptional(Reference.location("allthemodium:ancient_cracked_stone_bricks"));
    public static final Tag.Named<Item> ANCIENT_CRACKED_STONE_BRICKS_ITEM = ItemTags.createOptional(Reference.location("allthemodium:ancient_cracked_stone_bricks"));
    public static final Tag.Named<Block> ANCIENT_CHISELED_STONE_BRICKS = BlockTags.createOptional(Reference.location("allthemodium:ancient_chiseled_stone_bricks"));
    public static final Tag.Named<Item> ANCIENT_CHISELED_STONE_BRICKS_ITEM = ItemTags.createOptional(Reference.location("allthemodium:ancient_chiseled_stone_bricks"));


    public static final Tag.Named<Item> ALLTHEMODIUM_ORE_ITEM = ItemTags.createOptional(Reference.ore("allthemodium"));
    public static final Tag.Named<Item> VIBRANIUM_ORE_ITEM = ItemTags.createOptional(Reference.ore("vibranium"));
    public static final Tag.Named<Item> UNOBTAINIUM_ORE_ITEM = ItemTags.createOptional(Reference.ore("unobtainium"));

    public static final Tag.Named<Block> ALLTHEMODIUM_BLOCK = BlockTags.createOptional(Reference.block("allthemodium"));
    public static final Tag.Named<Block> VIBRANIUM_BLOCK = BlockTags.createOptional(Reference.block("vibranium"));
    public static final Tag.Named<Block> UNOBTAINIUM_BLOCK = BlockTags.createOptional(Reference.block("unobtainium"));

    public static final Tag.Named<Item> ALLTHEMODIUM_BLOCK_ITEM = ItemTags.createOptional(Reference.block("allthemodium"));
    public static final Tag.Named<Item> VIBRANIUM_BLOCK_ITEM = ItemTags.createOptional(Reference.block("vibranium"));
    public static final Tag.Named<Item> UNOBTAINIUM_BLOCK_ITEM = ItemTags.createOptional(Reference.block("unobtainium"));

    public static final Tag.Named<Item> ALLTHEMODIUM_INGOT = ItemTags.createOptional(Reference.ingot("allthemodium"));
    public static final Tag.Named<Item> VIBRANIUM_INGOT = ItemTags.createOptional(Reference.ingot("vibranium"));
    public static final Tag.Named<Item> UNOBTAINIUM_INGOT = ItemTags.createOptional(Reference.ingot("unobtainium"));
    public static final Tag.Named<Item> VIBRANIUM_ALLTHEMODIUM_INGOT = ItemTags.createOptional(Reference.ingot("vibranium_allthemodium_alloy"));
    public static final Tag.Named<Item> UNOBTAINIUM_VIBRANIUM_INGOT = ItemTags.createOptional(Reference.ingot("unobtainium_vibranium_alloy"));
    public static final Tag.Named<Item> UNOBTAINIUM_ALLTHEMODIUM_INGOT = ItemTags.createOptional(Reference.ingot("unobtainium_allthemodium_alloy"));

    public static final Tag.Named<Item> ALLTHEMODIUM_PLATE = ItemTags.createOptional(Reference.plate("allthemodium"));
    public static final Tag.Named<Item> VIBRANIUM_PLATE = ItemTags.createOptional(Reference.plate("vibranium"));
    public static final Tag.Named<Item> UNOBTAINIUM_PLATE = ItemTags.createOptional(Reference.plate("unobtainium"));

    public static final Tag.Named<Item> ALLTHEMODIUM_GEAR = ItemTags.createOptional(Reference.gear("allthemodium"));
    public static final Tag.Named<Item> VIBRANIUM_GEAR = ItemTags.createOptional(Reference.gear("vibranium"));
    public static final Tag.Named<Item> UNOBTAINIUM_GEAR = ItemTags.createOptional(Reference.gear("unobtainium"));

    public static final Tag.Named<Item> ALLTHEMODIUM_ROD = ItemTags.createOptional(Reference.rod("allthemodium"));
    public static final Tag.Named<Item> VIBRANIUM_ROD = ItemTags.createOptional(Reference.rod("vibranium"));
    public static final Tag.Named<Item> UNOBTAINIUM_ROD = ItemTags.createOptional(Reference.rod("unobtainium"));

    public static final Tag.Named<Item> ALLTHEMODIUM_DUST = ItemTags.createOptional(Reference.dust("allthemodium"));
    public static final Tag.Named<Item> VIBRANIUM_DUST = ItemTags.createOptional(Reference.dust("vibranium"));
    public static final Tag.Named<Item> UNOBTAINIUM_DUST = ItemTags.createOptional(Reference.dust("unobtainium"));

    public static final Tag.Named<Item> ALLTHEMODIUM_NUGGET = ItemTags.createOptional(Reference.nugget("allthemodium"));
    public static final Tag.Named<Item> VIBRANIUM_NUGGET = ItemTags.createOptional(Reference.nugget("vibranium"));
    public static final Tag.Named<Item> UNOBTAINIUM_NUGGET = ItemTags.createOptional(Reference.nugget("unobtainium"));

    public static final Tag.Named<Fluid> SOUL_LAVA = FluidTags.createOptional(Reference.forge("soul_lava"));

    private static Tags.IOptionalNamedTag<Item> forge(String name)
    {
        return net.minecraft.tags.ItemTags.createOptional(new ResourceLocation("forge", name));
    }
}
