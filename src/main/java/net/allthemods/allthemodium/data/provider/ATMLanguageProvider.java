package net.allthemods.allthemodium.data.provider;

import net.neoforged.neoforge.common.data.LanguageProvider;

import net.minecraft.data.PackOutput;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.client.lang.ATMLanguage;
import net.allthemods.allthemodium.core.registry.ATMBlocks;
import net.allthemods.allthemodium.core.registry.ATMFluids;
import net.allthemods.allthemodium.core.registry.ATMItems;
import net.allthemods.allthemodium.data.worldgen.ATMDimensions;

public class ATMLanguageProvider extends LanguageProvider {
    public ATMLanguageProvider(PackOutput output) {
        super(output, ATM.MOD_ID, "en_us");
    }
    
    @Override
    protected void addTranslations() {
        ATMLanguage.translate(this::add);
        this.addBlocks();
        this.addItems();
        this.addTrimMaterials();
        
        this.addDimension(ATMDimensions.MINING, "Mining Dimension");
        this.addDimension(ATMDimensions.THE_BEYOND, "The Beyond");
        this.addDimension(ATMDimensions.THE_OTHER, "The Other");
    }
    
    private void addBlocks() {
        this.addBlock(ATMBlocks.ALLTHEMODIUM_ORE, "Allthemodium Ore");
        this.addBlock(ATMBlocks.DEEPSLATE_ALLTHEMODIUM_ORE, "Deepslate Allthemodium Ore");
        this.addBlock(ATMBlocks.VIBRANIUM_ORE, "Vibranium Ore");
        this.addBlock(ATMBlocks.OTHER_VIBRANIUM_ORE, "Other Vibranium Ore");
        this.addBlock(ATMBlocks.UNOBTAINIUM_ORE, "Unobtainium Ore");
        
        this.addBlock(ATMBlocks.RAW_ALLTHEMODIUM_BLOCK, "Block of Raw Allthemodium");
        this.addBlock(ATMBlocks.RAW_VIBRANIUM_BLOCK, "Block of Raw Vibranium");
        this.addBlock(ATMBlocks.RAW_UNOBTAINIUM_BLOCK, "Block of Raw Unobtainium");
        
        this.addBlock(ATMBlocks.ALLTHEMODIUM_BLOCK, "Block of Allthemodium");
        this.addBlock(ATMBlocks.VIBRANIUM_BLOCK, "Block of Vibranium");
        this.addBlock(ATMBlocks.UNOBTAINIUM_BLOCK, "Block of Unobtainium");
        
        this.addBlock(ATMBlocks.UNOBTAINIUM_ALLTHEMODIUM_BLOCK, "Block of Unobtainium - Allthemodium Alloy");
        this.addBlock(ATMBlocks.UNOBTAINIUM_VIBRANIUM_BLOCK, "Block of Unobtainium - Vibranium Alloy");
        this.addBlock(ATMBlocks.VIBRANIUM_ALLTHEMODIUM_BLOCK, "Block of Vibranium - Allthemodium Alloy");
        
        this.addBlock(ATMBlocks.PIGLICH_HEART_BLOCK, "Block of Piglich Hearts");
        this.addBlock(ATMBlocks.ANCIENT_CAVE_VINES_PLANT, "Ancient Vines");
        this.addBlock(ATMBlocks.ANCIENT_CAVE_VINES, "Ancient Vines");
        this.addBlock(ATMBlocks.ANCIENT_DIRT, "Ancient Dirt");
        this.addBlock(ATMBlocks.ANCIENT_GRASS, "Ancient Grass");
        
        this.addBlock(ATMBlocks.ANCIENT_SAPLING, "Ancient Sapling");
        this.addBlock(ATMBlocks.ANCIENT_HERB, "Ancient Herbs");
        this.addBlock(ATMBlocks.ANCIENT_LOG_0, "Ancient Log");
        this.addBlock(ATMBlocks.ANCIENT_LOG_1, "Ancient Log");
        this.addBlock(ATMBlocks.ANCIENT_LOG_2, "Ancient Log");
        this.addBlock(ATMBlocks.STRIPPED_ANCIENT_LOG, "Stripped Ancient Log");
        this.addBlock(ATMBlocks.ANCIENT_LEAVES, "Ancient Leaves");
        this.addBlock(ATMBlocks.ANCIENT_LEAVES_BOTTOM, "Ancient Leaves");
        this.addBlock(ATMBlocks.ANCIENT_PLANKS, "Ancient Planks");
        this.addBlock(ATMBlocks.ANCIENT_TRAPDOOR, "Ancient Trapdoor");
        this.addBlock(ATMBlocks.ANCIENT_FENCE, "Ancient Fence");
        this.addBlock(ATMBlocks.ANCIENT_FENCE_GATE, "Ancient Fence Gate");
        this.addBlock(ATMBlocks.ANCIENT_DOOR, "Ancient Door");
        this.addBlock(ATMBlocks.ANCIENT_BOOKSHELF, "Ancient Bookshelf");
        this.addBlock(ATMBlocks.ANCIENT_STAIRS, "Ancient Stairs");
        this.addBlock(ATMBlocks.ANCIENT_SLAB, "Ancient Slab");
        
        this.addBlock(ATMBlocks.ANCIENT_STONE, "Ancient Stone");
        this.addBlock(ATMBlocks.SMOOTH_ANCIENT_STONE, "Smooth Ancient Stone");
        this.addBlock(ATMBlocks.MOSSY_ANCIENT_STONE, "Mossy Ancient Stone");
        this.addBlock(ATMBlocks.ANCIENT_STONE_BRICKS, "Ancient Stone Bricks");
        this.addBlock(ATMBlocks.CHISELED_ANCIENT_STONE_BRICKS, "Chiseled Ancient Stone Bricks");
        this.addBlock(ATMBlocks.CRACKED_ANCIENT_STONE_BRICKS, "Cracked Ancient Stone Bricks");
        this.addBlock(ATMBlocks.POLISHED_ANCIENT_STONE, "Polished Ancient Stone");
        this.addBlock(ATMBlocks.ANCIENT_STONE_WALL, "Ancient Stone Wall");
        this.addBlock(ATMBlocks.SMOOTH_ANCIENT_STONE_WALL, "Smooth Ancient Stone Wall");
        this.addBlock(ATMBlocks.MOSSY_ANCIENT_STONE_WALL, "Mossy Ancient Stone Wall");
        this.addBlock(ATMBlocks.ANCIENT_STONE_BRICK_WALL, "Ancient Stone Brick Wall");
        this.addBlock(ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_WALL, "Chiseled Ancient Stone Brick Wall");
        this.addBlock(ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_WALL, "Cracked Ancient Stone Brick Wall");
        this.addBlock(ATMBlocks.POLISHED_ANCIENT_STONE_WALL, "Polished Ancient Stone Wall");
        this.addBlock(ATMBlocks.ANCIENT_STONE_STAIRS, "Ancient Stone Stairs");
        this.addBlock(ATMBlocks.SMOOTH_ANCIENT_STONE_STAIRS, "Smooth Ancient Stone Stairs");
        this.addBlock(ATMBlocks.MOSSY_ANCIENT_STONE_STAIRS, "Mossy Ancient Stone Stairs");
        this.addBlock(ATMBlocks.ANCIENT_STONE_BRICK_STAIRS, "Ancient Stone Brick Stairs");
        this.addBlock(ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_STAIRS, "Chiseled Ancient Stone Brick Stairs");
        this.addBlock(ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_STAIRS, "Cracked Ancient Stone Brick Stairs");
        this.addBlock(ATMBlocks.POLISHED_ANCIENT_STONE_STAIRS, "Polished Ancient Stone Stairs");
        this.addBlock(ATMBlocks.ANCIENT_STONE_SLAB, "Ancient Stone Slab");
        this.addBlock(ATMBlocks.SMOOTH_ANCIENT_STONE_SLAB, "Smooth Ancient Stone Slab");
        this.addBlock(ATMBlocks.MOSSY_ANCIENT_STONE_SLAB, "Mossy Ancient Stone Slab");
        this.addBlock(ATMBlocks.ANCIENT_STONE_BRICK_SLAB, "Ancient Stone Brick Slab");
        this.addBlock(ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_SLAB, "Chiseled Ancient Stone Brick Slab");
        this.addBlock(ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_SLAB, "Cracked Ancient Stone Brick Slab");
        this.addBlock(ATMBlocks.POLISHED_ANCIENT_STONE_SLAB, "Polished Ancient Stone Slab");
        
        this.addBlock(ATMBlocks.SOUL_SAPLING, "Soul Sapling");
        this.addBlock(ATMBlocks.SOUL_HERB, "Soul Herbs");
        this.addBlock(ATMBlocks.SOUL_LOG_0, "Soul Log");
        this.addBlock(ATMBlocks.SOUL_LOG_1, "Soul Log");
        this.addBlock(ATMBlocks.SOUL_LOG_2, "Soul Log");
        this.addBlock(ATMBlocks.STRIPPED_SOUL_LOG, "Stripped Soul Log");
        this.addBlock(ATMBlocks.SOUL_LEAVES, "Soul Leaves");
        this.addBlock(ATMBlocks.SOUL_LEAVES_BOTTOM, "Soul Leaves");
        this.addBlock(ATMBlocks.SOUL_PLANKS, "Soul Planks");
        this.addBlock(ATMBlocks.SOUL_TRAPDOOR, "Soul Trapdoor");
        this.addBlock(ATMBlocks.SOUL_FENCE, "Soul Fence");
        this.addBlock(ATMBlocks.SOUL_FENCE_GATE, "Soul Fence Gate");
        this.addBlock(ATMBlocks.SOUL_DOOR, "Soul Door");
        this.addBlock(ATMBlocks.SOUL_BOOKSHELF, "Soul Bookshelf");
        this.addBlock(ATMBlocks.SOUL_STAIRS, "Soul Stairs");
        this.addBlock(ATMBlocks.SOUL_SLAB, "Soul Slab");
        
        this.addBlock(ATMBlocks.DEMONIC_SAPLING, "Demonic Sapling");
        this.addBlock(ATMBlocks.DEMONIC_HERB, "Demonic Herbs");
        this.addBlock(ATMBlocks.DEMONIC_LOG, "Demonic Log");
        this.addBlock(ATMBlocks.STRIPPED_DEMONIC_LOG, "Stripped Demonic Log");
        this.addBlock(ATMBlocks.DEMONIC_LEAVES, "Demonic Leaves");
        this.addBlock(ATMBlocks.DEMONIC_LEAVES_BOTTOM, "Demonic Leaves");
        this.addBlock(ATMBlocks.DEMONIC_PLANKS, "Demonic Planks");
        this.addBlock(ATMBlocks.DEMONIC_TRAPDOOR, "Demonic Trapdoor");
        this.addBlock(ATMBlocks.DEMONIC_FENCE, "Demonic Fence");
        this.addBlock(ATMBlocks.DEMONIC_FENCE_GATE, "Demonic Fence Gate");
        this.addBlock(ATMBlocks.DEMONIC_DOOR, "Demonic Door");
        this.addBlock(ATMBlocks.DEMONIC_BOOKSHELF, "Demonic Bookshelf");
        this.addBlock(ATMBlocks.DEMONIC_STAIRS, "Demonic Stairs");
        this.addBlock(ATMBlocks.DEMONIC_SLAB, "Demonic Slab");
        
        this.addBlock(ATMBlocks.SUS_CLAY, "Suspicious Clay");
        this.addBlock(ATMBlocks.SUS_SOUL_SAND, "Suspicious Soul Sand");
        
        this.addBlock(ATMBlocks.TELEPORT_PAD, "Teleport Pad");
        
        this.addBlock(ATMFluids.SOUL_LAVA_BLOCK, "Soul Lava");
        this.addBlock(ATMFluids.MOLTEN_ALLTHEMODIUM_BLOCK, "Molten Allthemodium");
        this.addBlock(ATMFluids.MOLTEN_VIBRANIUM_BLOCK, "Molten Vibranium");
        this.addBlock(ATMFluids.MOLTEN_UNOBTAINIUM_BLOCK, "Molten Unobtainium");
    }
    
    private void addItems() {
        this.addItem(ATMItems.PIGLICH_SPAWN_EGG, "Piglich Spawn Egg");
        this.addItem(ATMItems.PIGLICH_HEART, "Piglich Heart");
        
        this.addItem(ATMItems.ALLTHEMODIUM_APPLE, "Allthemodium Apple");
        this.addItem(ATMItems.ALLTHEMODIUM_CARROT, "Allthemodium Carrot");
        this.addItem(ATMItems.SOUL_BERRIES, "Soul Berries");
        
        this.addItem(ATMItems.RAW_ALLTHEMODIUM, "Raw Allthemodium Ore");
        this.addItem(ATMItems.RAW_VIBRANIUM, "Raw Vibranium Ore");
        this.addItem(ATMItems.RAW_UNOBTAINIUM, "Raw Unobtainium Ore");
        
        this.addItem(ATMItems.ALLTHEMODIUM_NUGGET, "Allthemodium Nugget");
        this.addItem(ATMItems.VIBRANIUM_NUGGET, "Vibranium Nugget");
        this.addItem(ATMItems.UNOBTAINIUM_NUGGET, "Unobtainium Nugget");
        
        this.addItem(ATMItems.ALLTHEMODIUM_DUST, "Allthemodium Dust");
        this.addItem(ATMItems.VIBRANIUM_DUST, "Vibranium Dust");
        this.addItem(ATMItems.UNOBTAINIUM_DUST, "Unobtainium Dust");
        
        this.addItem(ATMItems.ALLTHEMODIUM_INGOT, "Allthemodium Ingot");
        this.addItem(ATMItems.VIBRANIUM_INGOT, "Vibranium Ingot");
        this.addItem(ATMItems.UNOBTAINIUM_INGOT, "Unobtainium Ingot");
        
        this.addItem(ATMItems.ALLTHEMODIUM_PLATE, "Allthemodium Plate");
        this.addItem(ATMItems.VIBRANIUM_PLATE, "Vibranium Plate");
        this.addItem(ATMItems.UNOBTAINIUM_PLATE, "Unobtainium Plate");
        
        this.addItem(ATMItems.ALLTHEMODIUM_GEAR, "Allthemodium Gear");
        this.addItem(ATMItems.VIBRANIUM_GEAR, "Vibranium Gear");
        this.addItem(ATMItems.UNOBTAINIUM_GEAR, "Unobtainium Gear");
        
        this.addItem(ATMItems.ALLTHEMODIUM_ROD, "Allthemodium Rod");
        this.addItem(ATMItems.VIBRANIUM_ROD, "Vibranium Rod");
        this.addItem(ATMItems.UNOBTAINIUM_ROD, "Unobtainium Rod");
        
        this.addItem(ATMItems.UNOBTAINIUM_ALLTHEMODIUM_DUST, "Unobtainium - Allthemodium Alloy Dust");
        this.addItem(ATMItems.UNOBTAINIUM_VIBRANIUM_DUST, "Unobtainium - Vibranium Alloy Dust");
        this.addItem(ATMItems.VIBRANIUM_ALLTHEMODIUM_DUST, "Vibranium - Allthemodium Alloy Dust");
        
        this.addItem(ATMItems.UNOBTAINIUM_ALLTHEMODIUM_ALLOY, "Unobtainium - Allthemodium Alloy Ingot");
        this.addItem(ATMItems.UNOBTAINIUM_VIBRANIUM_ALLOY, "Unobtainium - Vibranium Alloy Ingot");
        this.addItem(ATMItems.VIBRANIUM_ALLTHEMODIUM_ALLOY, "Vibranium - Allthemodium Alloy Ingot");
        
        this.addItem(ATMItems.ALLTHEMODIUM_HELMET, "Allthemodium Helmet");
        this.addItem(ATMItems.ALLTHEMODIUM_CHESTPLATE, "Allthemodium Chestplate");
        this.addItem(ATMItems.ALLTHEMODIUM_LEGGINGS, "Allthemodium Leggings");
        this.addItem(ATMItems.ALLTHEMODIUM_BOOTS, "Allthemodium Boots");
        
        this.addItem(ATMItems.VIBRANIUM_HELMET, "Vibranium Helmet");
        this.addItem(ATMItems.VIBRANIUM_CHESTPLATE, "Vibranium Chestplate");
        this.addItem(ATMItems.VIBRANIUM_LEGGINGS, "Vibranium Leggings");
        this.addItem(ATMItems.VIBRANIUM_BOOTS, "Vibranium Boots");
        
        this.addItem(ATMItems.UNOBTAINIUM_HELMET, "Unobtainium Helmet");
        this.addItem(ATMItems.UNOBTAINIUM_CHESTPLATE, "Unobtainium Chestplate");
        this.addItem(ATMItems.UNOBTAINIUM_LEGGINGS, "Unobtainium Leggings");
        this.addItem(ATMItems.UNOBTAINIUM_BOOTS, "Unobtainium Boots");
        
        this.addItem(ATMItems.ALLTHEMODIUM_SWORD, "Allthemodium Sword");
        this.addItem(ATMItems.ALLTHEMODIUM_PICKAXE, "Allthemodium Pickaxe");
        this.addItem(ATMItems.ALLTHEMODIUM_AXE, "Allthemodium Axe");
        this.addItem(ATMItems.ALLTHEMODIUM_SHOVEL, "Allthemodium Shovel");
        this.addItem(ATMItems.ALLTHEMODIUM_HOE, "Allthemodium Hoe");
        this.addItem(ATMItems.ALLTHEMODIUM_MACE, "Allthemodium Mace");
        
        this.addItem(ATMItems.VIBRANIUM_SWORD, "Vibranium Sword");
        this.addItem(ATMItems.VIBRANIUM_PICKAXE, "Vibranium Pickaxe");
        this.addItem(ATMItems.VIBRANIUM_AXE, "Vibranium Axe");
        this.addItem(ATMItems.VIBRANIUM_SHOVEL, "Vibranium Shovel");
        this.addItem(ATMItems.VIBRANIUM_HOE, "Vibranium Hoe");
        this.addItem(ATMItems.VIBRANIUM_MACE, "Vibranium Mace");
        
        this.addItem(ATMItems.UNOBTAINIUM_SWORD, "Unobtainium Sword");
        this.addItem(ATMItems.UNOBTAINIUM_PICKAXE, "Unobtainium Pickaxe");
        this.addItem(ATMItems.UNOBTAINIUM_AXE, "Unobtainium Axe");
        this.addItem(ATMItems.UNOBTAINIUM_SHOVEL, "Unobtainium Shovel");
        this.addItem(ATMItems.UNOBTAINIUM_HOE, "Unobtainium Hoe");
        this.addItem(ATMItems.UNOBTAINIUM_MACE, "Unobtainium Mace");
        
        this.addItem(ATMItems.ALLOY_SWORD, "Allthemodium Alloy Sword");
        this.addItem(ATMItems.ALLOY_AXE, "Allthemodium Alloy Axe");
        this.addItem(ATMItems.ALLOY_SHOVEL, "Allthemodium Alloy Shovel");
        this.addItem(ATMItems.ALLOY_PAXEL, "Allthemodium Alloy Paxel");
        this.addItem(ATMItems.ALLOY_MACE, "Allthemodium Alloy Mace");
        
        this.addItem(ATMItems.ALLTHEMODIUM_BOW, "Allthemodium Bow");
        this.addItem(ATMItems.VIBRANIUM_SHIELD, "Vibranium Shield");
        this.addItem(ATMItems.UNOBTAINIUM_CROSSBOW, "Unobtainium Crossbow");
        this.addItem(ATMItems.ALLOY_TRIDENT, "Allthemodium Alloy Trident");
        
        this.addItem(ATMItems.ALLTHEMODIUM_SMITHING_TEMPLATE, "Allthemodium Smithing Template");
        this.addItem(ATMItems.VIBRANIUM_SMITHING_TEMPLATE, "Vibranium Smithing Template");
        this.addItem(ATMItems.UNOBTAINIUM_SMITHING_TEMPLATE, "Unobtainium Smithing Template");
        
        this.addItem(ATMFluids.SOUL_LAVA_BUCKET, "Soul Lava Bucket");
        this.addItem(ATMFluids.MOLTEN_ALLTHEMODIUM_BUCKET, "Molten Allthemodium Bucket");
        this.addItem(ATMFluids.MOLTEN_VIBRANIUM_BUCKET, "Molten Vibranium Bucket");
        this.addItem(ATMFluids.MOLTEN_UNOBTAINIUM_BUCKET, "Molten Unobtainium Bucket");
    }
    
    private void addTrimMaterials() {
        this.add("trim_material.allthemodium.allthemodium", "Allthemodium");
        this.add("trim_material.allthemodium.vibranium", "Vibranium");
        this.add("trim_material.allthemodium.unobtainium", "Unobtainium");
    }
}
