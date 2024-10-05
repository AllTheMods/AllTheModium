package com.thevortex.allthemodium.registry;

import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.core.Registry;
import net.minecraft.tags.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class TagRegistry {

    public static final TagKey<Block> ALLTHEMODIUM_ORE = BlockTags.create(
            Reference.ore("allthemodium"));
    public static final TagKey<Block> VIBRANIUM_ORE = BlockTags.create(
            Reference.ore("vibranium"));
    public static final TagKey<Block> UNOBTAINIUM_ORE = BlockTags.create(
            Reference.ore("unobtainium"));

    public static final TagKey<Block> OTHER_PROTECTION = BlockTags.create(
            Reference.atm("blocks/blocklist"));

    public static final TagKey<Block> NEEDS_ALLTHEMODIUM_TOOL = BlockTags
            .create(Reference.forge("needs_allthemodium_tool"));
    public static final TagKey<Block> NEEDS_ALLOY_TOOL = BlockTags.create(
            Reference.forge("needs_allthemodiumalloy_tool"));

    public static final TagKey<Item> FORGE_SWORDS = ItemTags.create(
            Reference.forge("tools/swords"));
    public static final TagKey<Item> FORGE_PICKAXES = ItemTags.create(
            Reference.forge("tools/pickaxes"));
    public static final TagKey<Item> FORGE_AXES = ItemTags.create(
            Reference.forge("tools/axes"));
    public static final TagKey<Item> FORGE_SHOVELS = ItemTags.create(
            Reference.forge("tools/shovels"));
    public static final TagKey<Item> FORGE_HOES = ItemTags.create(
            Reference.forge("tools/hoes"));
    public static final TagKey<Block> PAXEL_TARGETS = BlockTags.create(
            Reference.atm("paxel_effective"));

    public static final TagKey<Item> PIGLIN_LOVED = ItemTags.create(
            Reference.location("minecraft:items/piglin_loved"));
    public static final TagKey<Item> RAW_MATERIALS = ItemTags.create(
            Reference.forge("raw_materials"));

    public static final TagKey<Item> SAPLINGS = ItemTags.create(
            Reference.location("saplings"));
    public static final TagKey<Item> DUSTS = ItemTags.create(
            Reference.forge("dusts"));
    public static final TagKey<Item> INGOTS = ItemTags.create(
            Reference.forge("ingots"));
    public static final TagKey<Item> ORES = ItemTags.create(
            Reference.forge("ores"));
    public static final TagKey<Block> BLOCK_ORES = BlockTags.create(
            Reference.forge("ores"));

    public static final TagKey<Biome> OTHER_BIOMES = TagKey.create(
            Registry.BIOME_REGISTRY,
            Reference.location("allthemodium:other_biomes"));

    public static final TagKey<Block> OTHER_TILE_WHITELIST = BlockTags.create(
            Reference.location("allthemodium:other_te_whitelist"));
    public static final TagKey<Block> ANCIENT_DIRT = BlockTags.create(
            Reference.location("allthemodium:ancient_dirt"));
    public static final TagKey<Block> ANCIENT_STONE = BlockTags.create(
            Reference.location("allthemodium:ancient_stone"));
    public static final TagKey<Item> ANCIENT_STONE_ITEM = ItemTags.create(
            Reference.location("allthemodium:ancient_stone"));
    public static final TagKey<Block> ANCIENT_WOODEN_PLANKS = BlockTags.create(
            Reference.location("allthemodium:ancient_planks"));
    public static final TagKey<Item> ANCIENT_WOODEN_PLANKS_ITEM = ItemTags
            .create(Reference.location("allthemodium:ancient_planks"));
    public static final TagKey<Block> DEMONIC_WOODEN_PLANKS = BlockTags.create(
            Reference.location("allthemodium:demonic_planks"));
    public static final TagKey<Item> DEMONIC_WOODEN_PLANKS_ITEM = ItemTags
            .create(Reference.location("allthemodium:demonic_planks"));
    public static final TagKey<Block> SOUL_WOODEN_PLANKS = BlockTags.create(
            Reference.location("allthemodium:soul_planks"));
    public static final TagKey<Item> SOUL_WOODEN_PLANKS_ITEM = ItemTags.create(
            Reference.location("allthemodium:soul_planks"));

    public static final TagKey<Block> ANCIENT_MOSSY_STONE = BlockTags.create(
            Reference.location("allthemodium:ancient_mossy_stone"));
    public static final TagKey<Item> ANCIENT_MOSSY_STONE_ITEM = ItemTags.create(
            Reference.location("allthemodium:ancient_mossy_stone"));
    public static final TagKey<Block> ANCIENT_SMOOTH_STONE = BlockTags.create(
            Reference.location("allthemodium:ancient_smooth_stone"));
    public static final TagKey<Item> ANCIENT_SMOOTH_STONE_ITEM = ItemTags.create(
            Reference.location("allthemodium:ancient_smooth_stone"));
    public static final TagKey<Block> ANCIENT_POLISHED_STONE = BlockTags.create(
            Reference.location("allthemodium:ancient_polished_stone"));
    public static final TagKey<Item> ANCIENT_POLISHED_STONE_ITEM = ItemTags.create(
            Reference.location("allthemodium:ancient_polished_stone"));
    public static final TagKey<Block> ANCIENT_STONE_BRICKS = BlockTags.create(
            Reference.location("allthemodium:ancient_stone_bricks"));
    public static final TagKey<Item> ANCIENT_STONE_BRICKS_ITEM = ItemTags.create(
            Reference.location("allthemodium:ancient_stone_bricks"));
    public static final TagKey<Block> ANCIENT_CRACKED_STONE_BRICKS = BlockTags.create(
            Reference.location("allthemodium:ancient_cracked_stone_bricks"));
    public static final TagKey<Item> ANCIENT_CRACKED_STONE_BRICKS_ITEM = ItemTags.create(
            Reference.location("allthemodium:ancient_cracked_stone_bricks"));
    public static final TagKey<Block> ANCIENT_CHISELED_STONE_BRICKS = BlockTags.create(
            Reference.location("allthemodium:ancient_chiseled_stone_bricks"));
    public static final TagKey<Item> ANCIENT_CHISELED_STONE_BRICKS_ITEM = ItemTags.create(
            Reference.location("allthemodium:ancient_chiseled_stone_bricks"));

    public static final TagKey<Item> ALLTHEMODIUM_ORE_ITEM = ItemTags.create(
            Reference.ore("allthemodium"));
    public static final TagKey<Item> VIBRANIUM_ORE_ITEM = ItemTags.create(
            Reference.ore("vibranium"));
    public static final TagKey<Item> UNOBTAINIUM_ORE_ITEM = ItemTags.create(
            Reference.ore("unobtainium"));

    public static final TagKey<Block> ALLTHEMODIUM_BLOCK = BlockTags.create(
            Reference.block("allthemodium"));
    public static final TagKey<Block> VIBRANIUM_BLOCK = BlockTags.create(
            Reference.block("vibranium"));
    public static final TagKey<Block> UNOBTAINIUM_BLOCK = BlockTags.create(
            Reference.block("unobtainium"));

    public static final TagKey<Item> RAW_ALLTHEMODIUM_BLOCK = ItemTags.create(
            Reference.block("raw_allthemodium"));
    public static final TagKey<Item> RAW_VIBRANIUM_BLOCK = ItemTags.create(
            Reference.block("raw_vibranium"));
    public static final TagKey<Item> RAW_UNOBTAINIUM_BLOCK = ItemTags.create(
            Reference.block("raw_unobtainium"));

    public static final TagKey<Item> ALLTHEMODIUM_BLOCK_ITEM = ItemTags.create(
            Reference.block("allthemodium"));
    public static final TagKey<Item> VIBRANIUM_BLOCK_ITEM = ItemTags.create(
            Reference.block("vibranium"));
    public static final TagKey<Item> UNOBTAINIUM_BLOCK_ITEM = ItemTags.create(
            Reference.block("unobtainium"));

    public static final TagKey<Item> ALLTHEMODIUM_INGOT = ItemTags.create(
            Reference.ingot("allthemodium"));
    public static final TagKey<Item> VIBRANIUM_INGOT = ItemTags.create(
            Reference.ingot("vibranium"));
    public static final TagKey<Item> UNOBTAINIUM_INGOT = ItemTags.create(
            Reference.ingot("unobtainium"));
    public static final TagKey<Item> VIBRANIUM_ALLTHEMODIUM_INGOT = ItemTags
            .create(Reference.ingot("vibranium_allthemodium_alloy"));
    public static final TagKey<Item> UNOBTAINIUM_VIBRANIUM_INGOT = ItemTags
            .create(Reference.ingot("unobtainium_vibranium_alloy"));
    public static final TagKey<Item> UNOBTAINIUM_ALLTHEMODIUM_INGOT = ItemTags
            .create(Reference.ingot("unobtainium_allthemodium_alloy"));

    public static final TagKey<Item> VIBRANIUM_ALLTHEMODIUM_BLOCK = ItemTags
            .create(Reference.block("vibranium_allthemodium_alloy"));
    public static final TagKey<Item> UNOBTAINIUM_VIBRANIUM_BLOCK = ItemTags
            .create(Reference.block("unobtainium_vibranium_alloy"));
    public static final TagKey<Item> UNOBTAINIUM_ALLTHEMODIUM_BLOCK = ItemTags
            .create(Reference.block("unobtainium_allthemodium_alloy"));

    public static final TagKey<Item> ALLTHEMODIUM_PLATE = ItemTags.create(
            Reference.plate("allthemodium"));
    public static final TagKey<Item> VIBRANIUM_PLATE = ItemTags.create(
            Reference.plate("vibranium"));
    public static final TagKey<Item> UNOBTAINIUM_PLATE = ItemTags.create(
            Reference.plate("unobtainium"));

    public static final TagKey<Item> ALLTHEMODIUM_GEAR = ItemTags.create(
            Reference.gear("allthemodium"));
    public static final TagKey<Item> VIBRANIUM_GEAR = ItemTags.create(
            Reference.gear("vibranium"));
    public static final TagKey<Item> UNOBTAINIUM_GEAR = ItemTags.create(
            Reference.gear("unobtainium"));

    public static final TagKey<Item> ALLTHEMODIUM_ROD = ItemTags.create(
            Reference.rod("allthemodium"));
    public static final TagKey<Item> VIBRANIUM_ROD = ItemTags.create(
            Reference.rod("vibranium"));
    public static final TagKey<Item> UNOBTAINIUM_ROD = ItemTags.create(
            Reference.rod("unobtainium"));

    public static final TagKey<Item> ALLTHEMODIUM_DUST = ItemTags.create(
            Reference.dust("allthemodium"));
    public static final TagKey<Item> VIBRANIUM_DUST = ItemTags.create(
            Reference.dust("vibranium"));
    public static final TagKey<Item> UNOBTAINIUM_DUST = ItemTags.create(
            Reference.dust("unobtainium"));

    public static final TagKey<Item> ALLTHEMODIUM_NUGGET = ItemTags.create(
            Reference.nugget("allthemodium"));
    public static final TagKey<Item> VIBRANIUM_NUGGET = ItemTags.create(
            Reference.nugget("vibranium"));
    public static final TagKey<Item> UNOBTAINIUM_NUGGET = ItemTags.create(
            Reference.nugget("unobtainium"));

    public static final TagKey<Fluid> SOUL_LAVA = FluidTags.create(
            Reference.forge("soul_lava"));
    public static final TagKey<Fluid> ALLTHEMODIUM = FluidTags.create(
            Reference.forge("molten_allthemodium"));
    public static final TagKey<Fluid> VIBRANIUM = FluidTags.create(
            Reference.forge("molten_vibranium"));
    public static final TagKey<Fluid> UNOBTAINIUM = FluidTags.create(
            Reference.forge("molten_unobtainium"));

    public static final TagKey<Item> RAW_ALLTHEMODIUM_FORGE = ItemTags.create(
            Reference.raw_ores("allthemodium"));
    public static final TagKey<Item> RAW_VIBRANIUM_FORGE = ItemTags.create(
            Reference.raw_ores("vibranium"));
    public static final TagKey<Item> RAW_UNOBTAINIUM_FORGE = ItemTags.create(
            Reference.raw_ores("unobtainium"));

    public static final TagKey<Item> RAW_ALLTHEMODIUM = ItemTags.create(
            Reference.material("allthemodium"));
    public static final TagKey<Item> RAW_VIBRANIUM = ItemTags.create(
            Reference.material("vibranium"));
    public static final TagKey<Item> RAW_UNOBTAINIUM = ItemTags.create(
            Reference.material("unobtainium"));

    public static final TagKey<Item> DIRTY_DUST = ItemTags.create(
            Reference.mek("dirty_dusts"));
    public static final TagKey<Item> CRYSTAL = ItemTags.create(
            Reference.mek("crystals"));
    public static final TagKey<Item> CLUMP = ItemTags.create(
            Reference.mek("clumps"));
    public static final TagKey<Item> SHARD = ItemTags.create(
            Reference.mek("shards"));

    public static final TagKey<Item> ALLTHEMODIUM_DIRTY_DUST = ItemTags.create(
            Reference.dirty("allthemodium"));
    public static final TagKey<Item> VIBRANIUM_DIRTY_DUST = ItemTags.create(
            Reference.dirty("vibranium"));
    public static final TagKey<Item> UNOBTAINIUM_DIRTY_DUST = ItemTags.create(
            Reference.dirty("unobtainium"));

    public static final TagKey<Item> ALLTHEMODIUM_CRYSTAL = ItemTags.create(
            Reference.crystal("allthemodium"));
    public static final TagKey<Item> VIBRANIUM_CRYSTAL = ItemTags.create(
            Reference.crystal("vibranium"));
    public static final TagKey<Item> UNOBTAINIUM_CRYSTAL = ItemTags.create(
            Reference.crystal("unobtainium"));

    public static final TagKey<Item> ALLTHEMODIUM_CLUMP = ItemTags.create(
            Reference.clump("allthemodium"));
    public static final TagKey<Item> VIBRANIUM_CLUMP = ItemTags.create(
            Reference.clump("vibranium"));
    public static final TagKey<Item> UNOBTAINIUM_CLUMP = ItemTags.create(
            Reference.clump("unobtainium"));

    public static final TagKey<Item> ALLTHEMODIUM_SHARD = ItemTags.create(
            Reference.shard("allthemodium"));
    public static final TagKey<Item> VIBRANIUM_SHARD = ItemTags.create(
            Reference.shard("vibranium"));
    public static final TagKey<Item> UNOBTAINIUM_SHARD = ItemTags.create(
            Reference.shard("unobtainium"));
}
