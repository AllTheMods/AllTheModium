package net.allthemods.allthemodium.core.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

import net.allthemods.allthemodium.api.ATM;

public class ATMTags {
    
    public static final class Blocks {
        
        public static final TagKey<Block> SUPPORTS_OTHER_VEGETATION = Blocks.create("supports_other_vegetation");
        
        public static final TagKey<Block> OTHER_PROTECTION = Blocks.create("other_protection");
        
        public static final TagKey<Block> ORES_ALLTHEMODIUM = Blocks.neo("ores/allthemodium");
        public static final TagKey<Block> ORES_VIBRANIUM = Blocks.neo("ores/vibranium");
        public static final TagKey<Block> ORES_UNOBTANIUM = Blocks.neo("ores/unobtanium");
        
        public static final TagKey<Block> STORAGE_BLOCKS_RAW_ALLTHEMODIUM = Blocks.neo("storage_blocks/raw_allthemodium");
        public static final TagKey<Block> STORAGE_BLOCKS_RAW_VIBRANIUM = Blocks.neo("storage_blocks/raw_vibranium");
        public static final TagKey<Block> STORAGE_BLOCKS_RAW_UNOBTAINIUM = Blocks.neo("storage_blocks/raw_unobtainium");
        
        public static final TagKey<Block> STORAGE_BLOCKS_ALLTHEMODIUM = Blocks.neo("storage_blocks/allthemodium");
        public static final TagKey<Block> STORAGE_BLOCKS_VIBRANIUM = Blocks.neo("storage_blocks/vibranium");
        public static final TagKey<Block> STORAGE_BLOCKS_UNOBTAINIUM = Blocks.neo("storage_blocks/unobtainium");
        
        public static final TagKey<Block> STORAGE_BLOCKS_VIBRANIUM_ALLTHEMODIUM_ALLOY = Blocks.neo("storage_blocks/vibranium_allthemodium_alloy");
        public static final TagKey<Block> STORAGE_BLOCKS_UNOBTAINIUM_ALLTHEMODIUM_ALLOY = Blocks.neo("storage_blocks/unobtainium_allthemodium_alloy");
        public static final TagKey<Block> STORAGE_BLOCKS_UNOBTAINIUM_VIBRANIUM_ALLOY = Blocks.neo("storage_blocks/unobtainium_vibranium_alloy");
        
        public static final TagKey<Block> INCORRECT_FOR_ALLTHEMODIUM_TOOL = Blocks.create("incorrect_for_allthemodium_tool");
        public static final TagKey<Block> INCORRECT_FOR_VIBRANIUM_TOOL = Blocks.create("incorrect_for_vibranium_tool");
        public static final TagKey<Block> INCORRECT_FOR_UNOBTAINIUM_TOOL = Blocks.create("incorrect_for_unobtainium_tool");
        public static final TagKey<Block> INCORRECT_FOR_ALLOY_TOOL = Blocks.create("incorrect_for_alloy_tool");
        
        public static final TagKey<Block> MINEABLE_WITH_PAXEL = Blocks.neo("mineable/paxel");
        
        public static final TagKey<Block> ANCIENT_STONE = Blocks.create("ancient_stone");
        public static final TagKey<Block> SMOOTH_ANCIENT_STONE = Blocks.create("smooth_ancient_stone");
        public static final TagKey<Block> MOSSY_ANCIENT_STONE = Blocks.create("mossy_ancient_stone");
        public static final TagKey<Block> POLISHED_ANCIENT_STONE = Blocks.create("polished_ancient_stone");
        public static final TagKey<Block> ANCIENT_STONE_BRICKS = Blocks.create("ancient_stone_bricks");
        public static final TagKey<Block> CRACKED_ANCIENT_STONE_BRICKS = Blocks.create("cracked_ancient_stone_bricks");
        public static final TagKey<Block> CHISELED_ANCIENT_STONE_BRICKS = Blocks.create("chiseled_ancient_stone_bricks");
        public static final TagKey<Block> ANCIENT_PLANKS = Blocks.create("ancient_planks");
        public static final TagKey<Block> SOUL_PLANKS = Blocks.create("soul_planks");
        public static final TagKey<Block> DEMONIC_PLANKS = Blocks.create("demonic_planks");
        
        private static TagKey<Block> create(String path) {
            return BlockTags.create(ATM.id(path));
        }
        
        private static TagKey<Block> neo(String path) {
            return BlockTags.create(ATM.c(path));
        }
    }
    
    public static final class Items {
        
        public static final TagKey<Item> ANCIENT_STONE = Items.create("ancient_stone");
        public static final TagKey<Item> SMOOTH_ANCIENT_STONE = Items.create("smooth_ancient_stone");
        public static final TagKey<Item> MOSSY_ANCIENT_STONE = Items.create("mossy_ancient_stone");
        public static final TagKey<Item> POLISHED_ANCIENT_STONE = Items.create("polished_ancient_stone");
        public static final TagKey<Item> ANCIENT_STONE_BRICKS = Items.create("ancient_stone_bricks");
        public static final TagKey<Item> CRACKED_ANCIENT_STONE_BRICKS = Items.create("cracked_ancient_stone_bricks");
        public static final TagKey<Item> CHISELED_ANCIENT_STONE_BRICKS = Items.create("chiseled_ancient_stone_bricks");
        public static final TagKey<Item> ANCIENT_PLANKS = Items.create("ancient_planks");
        public static final TagKey<Item> SOUL_PLANKS = Items.create("soul_planks");
        public static final TagKey<Item> DEMONIC_PLANKS = Items.create("demonic_planks");
        
        public static final TagKey<Item> ORES_ALLTHEMODIUM = Items.neo("ores/allthemodium");
        public static final TagKey<Item> ORES_VIBRANIUM = Items.neo("ores/vibranium");
        public static final TagKey<Item> ORES_UNOBTAINIUM = Items.neo("ores/unobtanium");
        public static final TagKey<Item> ORES_IN_GROUND_ANCIENT_STONE = Items.neo("ores_in_ground/ancient_stone");
        public static final TagKey<Item> ORES_IN_GROUND_END_STONE = Items.neo("ores_in_ground/end_stone");
        
        public static final TagKey<Item> RAW_MATERIALS_ALLTHEMODIUM = Items.neo("raw_materials/allthemodium");
        public static final TagKey<Item> RAW_MATERIALS_VIBRANIUM = Items.neo("raw_materials/vibranium");
        public static final TagKey<Item> RAW_MATERIALS_UNOBTAINIUM = Items.neo("raw_materials/unobtainium");
        
        public static final TagKey<Item> NUGGETS_ALLTHEMODIUM = Items.neo("nuggets/allthemodium");
        public static final TagKey<Item> NUGGETS_VIBRANIUM = Items.neo("nuggets/vibranium");
        public static final TagKey<Item> NUGGETS_UNOBTAINIUM = Items.neo("nuggets/unobtainium");
        
        public static final TagKey<Item> DUSTS_ALLTHEMODIUM = Items.neo("dusts/allthemodium");
        public static final TagKey<Item> DUSTS_VIBRANIUM = Items.neo("dusts/vibranium");
        public static final TagKey<Item> DUSTS_UNOBTAINIUM = Items.neo("dusts/unobtainium");
        public static final TagKey<Item> DUSTS_VIBRANIUM_ALLTHEMODIUM_ALLOY = Items.neo("dusts/vibranium_allthemodium_alloy");
        public static final TagKey<Item> DUSTS_UNOBTAINIUM_ALLTHEMODIUM_ALLOY = Items.neo("dusts/unobtainium_allthemodium_alloy");
        public static final TagKey<Item> DUSTS_UNOBTAINIUM_VIBRANIUM_ALLOY = Items.neo("dusts/unobtainium_vibranium_alloy");
        
        public static final TagKey<Item> INGOTS_ALLTHEMODIUM = Items.neo("ingots/allthemodium");
        public static final TagKey<Item> INGOTS_VIBRANIUM = Items.neo("ingots/vibranium");
        public static final TagKey<Item> INGOTS_UNOBTAINIUM = Items.neo("ingots/unobtainium");
        public static final TagKey<Item> INGOTS_ALLOYS = Items.neo("ingots/modium_alloy");
        public static final TagKey<Item> INGOTS_VIBRANIUM_ALLTHEMODIUM_ALLOY = Items.neo("ingots/vibranium_allthemodium_alloy");
        public static final TagKey<Item> INGOTS_UNOBTAINIUM_ALLTHEMODIUM_ALLOY = Items.neo("ingots/unobtainium_allthemodium_alloy");
        public static final TagKey<Item> INGOTS_UNOBTAINIUM_VIBRANIUM_ALLOY = Items.neo("ingots/unobtainium_vibranium_alloy");
        
        public static final TagKey<Item> GEARS = Items.neo("gears");
        public static final TagKey<Item> GEARS_ALLTHEMODIUM = Items.neo("gears/allthemodium");
        public static final TagKey<Item> GEARS_VIBRANIUM = Items.neo("gears/vibranium");
        public static final TagKey<Item> GEARS_UNOBTAINIUM = Items.neo("gears/unobtainium");
        
        public static final TagKey<Item> PLATES = Items.neo("plates");
        public static final TagKey<Item> PLATES_ALLTHEMODIUM = Items.neo("plates/allthemodium");
        public static final TagKey<Item> PLATES_VIBRANIUM = Items.neo("plates/vibranium");
        public static final TagKey<Item> PLATES_UNOBTAINIUM = Items.neo("plates/unobtainium");
        
        public static final TagKey<Item> RODS_ALLTHEMODIUM = Items.neo("rods/allthemodium");
        public static final TagKey<Item> RODS_VIBRANIUM = Items.neo("rods/vibranium");
        public static final TagKey<Item> RODS_UNOBTAINIUM = Items.neo("rods/unobtainium");
        
        public static final TagKey<Item> STORAGE_BLOCKS_ALLTHEMODIUM = Items.neo("storage_blocks/allthemodium");
        public static final TagKey<Item> STORAGE_BLOCKS_VIBRANIUM = Items.neo("storage_blocks/vibranium");
        public static final TagKey<Item> STORAGE_BLOCKS_UNOBTAINIUM = Items.neo("storage_blocks/unobtainium");
        public static final TagKey<Item> STORAGE_BLOCKS_RAW_ALLTHEMODIUM = Items.neo("storage_blocks/raw_allthemodium");
        public static final TagKey<Item> STORAGE_BLOCKS_RAW_VIBRANIUM = Items.neo("storage_blocks/raw_vibranium");
        public static final TagKey<Item> STORAGE_BLOCKS_RAW_UNOBTAINIUM = Items.neo("storage_blocks/raw_unobtainium");
        public static final TagKey<Item> STORAGE_BLOCKS_VIBRANIUM_ALLTHEMODIUM_ALLOY = Items.neo("storage_blocks/vibranium_allthemodium_alloy");
        public static final TagKey<Item> STORAGE_BLOCKS_UNOBTAINIUM_ALLTHEMODIUM_ALLOY = Items.neo("storage_blocks/unobtainium_allthemodium_alloy");
        public static final TagKey<Item> STORAGE_BLOCKS_UNOBTAINIUM_VIBRANIUM_ALLOY = Items.neo("storage_blocks/unobtainium_vibranium_alloy");
        
        public static final TagKey<Item> ATM_FOODS = Items.neo("foods/allthemodium");
        
        private static TagKey<Item> create(String path) {
            return ItemTags.create(ATM.id(path));
        }
        
        private static TagKey<Item> neo(String path) {
            return ItemTags.create(ATM.c(path));
        }
    }
    
    public static final class Biomes {
        
        public static final TagKey<Biome> IS_OTHER = Biomes.neo("is_other"); // c namespace to match other dimension
        
        public static final TagKey<Biome> HAS_ANCIENT_PYRAMID = Biomes.create("has_structure/ancient_pyramid");
        public static final TagKey<Biome> HAS_DUNGEON = Biomes.create("has_structure/dungeon");
        public static final TagKey<Biome> HAS_PIGLICH_VILLAGE = Biomes.create("has_structure/piglin_village");
        
        private static TagKey<Biome> create(String path) {
            return TagKey.create(Registries.BIOME, ATM.id(path));
        }
        
        private static TagKey<Biome> neo(String path) {
            return TagKey.create(Registries.BIOME, ATM.c(path));
        }
    }
}
