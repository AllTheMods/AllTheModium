package net.allthemods.allthemodium.data.provider;

import net.neoforged.neoforge.common.Tags;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.core.registry.ATMBlocks;
import net.allthemods.allthemodium.core.registry.ATMItems;
import net.allthemods.allthemodium.core.registry.ATMTags;
import net.allthemods.alltheores.core.registry.ATORegistry;

import java.util.concurrent.CompletableFuture;

public class ATMRecipeProvider extends RecipeProvider {
    
    private static final String GROUP = ATM.MOD_ID;
    
    private final HolderGetter<Item> items;
    private final RecipeOutput output;
    
    public ATMRecipeProvider(HolderLookup.Provider lookupProvider, RecipeOutput output) {
        super(lookupProvider, output);
        this.items = lookupProvider.lookupOrThrow(Registries.ITEM);
        this.output = output;
    }
    
    @Override
    protected void buildRecipes() {
        this.addFoodRecipes();
        this.addMetalRecipes();
        this.addAlloyBlockRecipes();
        this.addWoodRecipes();
        this.addAncientStoneRecipes();
        this.addSmithingRecipes();
        this.addSpecialRecipes();
    }
    
    private void addFoodRecipes() {
        this.food(Items.APPLE, ATMItems.ALLTHEMODIUM_APPLE.get());
        this.food(Items.CARROT, ATMItems.ALLTHEMODIUM_CARROT.get());
    }
    
    private void addMetalRecipes() {
        this.addMetalRecipes(
                "allthemodium",
                ATMTags.Items.ORES_ALLTHEMODIUM,
                ATMTags.Items.RAW_MATERIALS_ALLTHEMODIUM,
                ATMTags.Items.STORAGE_BLOCKS_RAW_ALLTHEMODIUM,
                ATMTags.Items.NUGGETS_ALLTHEMODIUM,
                ATMTags.Items.DUSTS_ALLTHEMODIUM,
                ATMTags.Items.INGOTS_ALLTHEMODIUM,
                ATMTags.Items.STORAGE_BLOCKS_ALLTHEMODIUM,
                ATMItems.RAW_ALLTHEMODIUM.get(),
                ATMBlocks.RAW_ALLTHEMODIUM_BLOCK.get().asItem(),
                ATMItems.ALLTHEMODIUM_DUST.get(),
                ATMItems.ALLTHEMODIUM_NUGGET.get(),
                ATMItems.ALLTHEMODIUM_INGOT.get(),
                ATMItems.ALLTHEMODIUM_PLATE.get(),
                ATMItems.ALLTHEMODIUM_GEAR.get(),
                ATMItems.ALLTHEMODIUM_ROD.get(),
                ATMBlocks.ALLTHEMODIUM_BLOCK.get().asItem()
        );
        this.addMetalRecipes(
                "vibranium",
                ATMTags.Items.ORES_VIBRANIUM,
                ATMTags.Items.RAW_MATERIALS_VIBRANIUM,
                ATMTags.Items.STORAGE_BLOCKS_RAW_VIBRANIUM,
                ATMTags.Items.NUGGETS_VIBRANIUM,
                ATMTags.Items.DUSTS_VIBRANIUM,
                ATMTags.Items.INGOTS_VIBRANIUM,
                ATMTags.Items.STORAGE_BLOCKS_VIBRANIUM,
                ATMItems.RAW_VIBRANIUM.get(),
                ATMBlocks.RAW_VIBRANIUM_BLOCK.get().asItem(),
                ATMItems.VIBRANIUM_DUST.get(),
                ATMItems.VIBRANIUM_NUGGET.get(),
                ATMItems.VIBRANIUM_INGOT.get(),
                ATMItems.VIBRANIUM_PLATE.get(),
                ATMItems.VIBRANIUM_GEAR.get(),
                ATMItems.VIBRANIUM_ROD.get(),
                ATMBlocks.VIBRANIUM_BLOCK.get().asItem()
        );
        this.addMetalRecipes(
                "unobtainium",
                ATMTags.Items.ORES_UNOBTAINIUM,
                ATMTags.Items.RAW_MATERIALS_UNOBTAINIUM,
                ATMTags.Items.STORAGE_BLOCKS_RAW_UNOBTAINIUM,
                ATMTags.Items.NUGGETS_UNOBTAINIUM,
                ATMTags.Items.DUSTS_UNOBTAINIUM,
                ATMTags.Items.INGOTS_UNOBTAINIUM,
                ATMTags.Items.STORAGE_BLOCKS_UNOBTAINIUM,
                ATMItems.RAW_UNOBTAINIUM.get(),
                ATMBlocks.RAW_UNOBTAINIUM_BLOCK.get().asItem(),
                ATMItems.UNOBTAINIUM_DUST.get(),
                ATMItems.UNOBTAINIUM_NUGGET.get(),
                ATMItems.UNOBTAINIUM_INGOT.get(),
                ATMItems.UNOBTAINIUM_PLATE.get(),
                ATMItems.UNOBTAINIUM_GEAR.get(),
                ATMItems.UNOBTAINIUM_ROD.get(),
                ATMBlocks.UNOBTAINIUM_BLOCK.get().asItem()
        );
    }
    
    private void addMetalRecipes(
            String name,
            TagKey<Item> oreTag,
            TagKey<Item> rawTag,
            TagKey<Item> rawBlockTag,
            TagKey<Item> nuggetTag,
            TagKey<Item> dustTag,
            TagKey<Item> ingotTag,
            TagKey<Item> storageBlockTag,
            Item raw,
            Item rawBlock,
            Item dust,
            Item nugget,
            Item ingot,
            Item plate,
            Item gear,
            Item rod,
            Item storageBlock
    ) {
        this.compress(nuggetTag, ingot, name + "_ingot", name + "_nugget");
        this.decompress(ingotTag, nugget, name + "_nugget_from_ingot", name + "_ingot");
        this.compress(ingotTag, storageBlock, name + "_block", name + "_ingot");
        this.decompress(storageBlockTag, ingot, name + "_ingot_from_block", name + "_block");
        
        this.compress(rawTag, rawBlock, "raw_" + name + "_block", "raw_" + name);
        this.decompress(rawBlockTag, raw, "raw_" + name + "_from_block", "raw_" + name + "_block");
        
        this.hammer(ingotTag, 1, dust, name + "_dust_from_ingot_hammering", name + "_ingot");
        this.hammer(rawTag, 2, dust, name + "_dust_from_ore_crushing", "raw_" + name);
        this.smelting(dustTag, ingot, 0.15F, 200, RecipeCategory.MISC, CookingBookCategory.MISC, name + "_ingot_from_dust_smelting", name + "_dust");
        this.blasting(dustTag, ingot, 0.15F, 100, RecipeCategory.MISC, CookingBookCategory.MISC, name + "_ingot_from_dust_blasting", name + "_dust");
        this.smelting(rawTag, ingot, 0.15F, 200, RecipeCategory.MISC, CookingBookCategory.MISC, name + "_ingot_from_raw_smelting", "raw_" + name);
        this.blasting(rawTag, ingot, 0.15F, 100, RecipeCategory.MISC, CookingBookCategory.MISC, name + "_ingot_from_raw_blasting", "raw_" + name);
        this.smelting(oreTag, ingot, 0.15F, 200, RecipeCategory.MISC, CookingBookCategory.MISC, name + "_ingot_from_ore_smelting", name + "_ore");
        this.blasting(oreTag, ingot, 0.15F, 100, RecipeCategory.MISC, CookingBookCategory.MISC, name + "_ingot_from_ore_blasting", name + "_ore");
        
        this.gear(ingotTag, gear, name + "_ingot");
        this.plate(ingotTag, plate, name + "_ingot");
        this.rod(ingotTag, rod, name + "_ingot");
    }
    
    private void addAlloyBlockRecipes() {
        this.addAlloyBlockRecipes(
                "vibranium_allthemodium_block",
                "vibranium_allthemodium_alloy_ingot",
                ATMTags.Items.INGOTS_VIBRANIUM_ALLTHEMODIUM_ALLOY,
                ATMTags.Items.STORAGE_BLOCKS_VIBRANIUM_ALLTHEMODIUM_ALLOY,
                ATMItems.VIBRANIUM_ALLTHEMODIUM_ALLOY.get(),
                ATMBlocks.VIBRANIUM_ALLTHEMODIUM_BLOCK.get().asItem()
        );
        this.addAlloyBlockRecipes(
                "unobtainium_allthemodium_block",
                "unobtainium_allthemodium_alloy_ingot",
                ATMTags.Items.INGOTS_UNOBTAINIUM_ALLTHEMODIUM_ALLOY,
                ATMTags.Items.STORAGE_BLOCKS_UNOBTAINIUM_ALLTHEMODIUM_ALLOY,
                ATMItems.UNOBTAINIUM_ALLTHEMODIUM_ALLOY.get(),
                ATMBlocks.UNOBTAINIUM_ALLTHEMODIUM_BLOCK.get().asItem()
        );
        this.addAlloyBlockRecipes(
                "unobtainium_vibranium_block",
                "unobtainium_vibranium_alloy_ingot",
                ATMTags.Items.INGOTS_UNOBTAINIUM_VIBRANIUM_ALLOY,
                ATMTags.Items.STORAGE_BLOCKS_UNOBTAINIUM_VIBRANIUM_ALLOY,
                ATMItems.UNOBTAINIUM_VIBRANIUM_ALLOY.get(),
                ATMBlocks.UNOBTAINIUM_VIBRANIUM_BLOCK.get().asItem()
        );
    }
    
    private void addAlloyBlockRecipes(String blockPath, String ingotPath, TagKey<Item> ingotTag, TagKey<Item> blockTag, Item ingot, Item block) {
        this.compress(ingotTag, block, blockPath, ingotPath);
        this.decompress(blockTag, ingot, ingotPath + "_from_block", blockPath);
    }
    
    private void addWoodRecipes() {
        this.addWoodRecipes(
                "ancient",
                ATMTags.Items.ANCIENT_PLANKS,
                ATMBlocks.ANCIENT_PLANKS.get().asItem(),
                ATMBlocks.ANCIENT_STAIRS.get().asItem(),
                ATMBlocks.ANCIENT_SLAB.get().asItem(),
                ATMBlocks.ANCIENT_FENCE.get().asItem(),
                ATMBlocks.ANCIENT_FENCE_GATE.get().asItem(),
                ATMBlocks.ANCIENT_DOOR.get().asItem(),
                ATMBlocks.ANCIENT_TRAPDOOR.get().asItem(),
                ATMBlocks.ANCIENT_BOOKSHELF.get().asItem(),
                ATMBlocks.ANCIENT_LOG_0.get().asItem(),
                ATMBlocks.ANCIENT_LOG_1.get().asItem(),
                ATMBlocks.ANCIENT_LOG_2.get().asItem(),
                ATMBlocks.STRIPPED_ANCIENT_LOG.get().asItem()
        );
        this.addWoodRecipes(
                "soul",
                ATMTags.Items.SOUL_PLANKS,
                ATMBlocks.SOUL_PLANKS.get().asItem(),
                ATMBlocks.SOUL_STAIRS.get().asItem(),
                ATMBlocks.SOUL_SLAB.get().asItem(),
                ATMBlocks.SOUL_FENCE.get().asItem(),
                ATMBlocks.SOUL_FENCE_GATE.get().asItem(),
                ATMBlocks.SOUL_DOOR.get().asItem(),
                ATMBlocks.SOUL_TRAPDOOR.get().asItem(),
                ATMBlocks.SOUL_BOOKSHELF.get().asItem(),
                ATMBlocks.SOUL_LOG_0.get().asItem(),
                ATMBlocks.SOUL_LOG_1.get().asItem(),
                ATMBlocks.SOUL_LOG_2.get().asItem(),
                ATMBlocks.STRIPPED_SOUL_LOG.get().asItem()
        );
        this.addWoodRecipes(
                "demonic",
                ATMTags.Items.DEMONIC_PLANKS,
                ATMBlocks.DEMONIC_PLANKS.get().asItem(),
                ATMBlocks.DEMONIC_STAIRS.get().asItem(),
                ATMBlocks.DEMONIC_SLAB.get().asItem(),
                ATMBlocks.DEMONIC_FENCE.get().asItem(),
                ATMBlocks.DEMONIC_FENCE_GATE.get().asItem(),
                ATMBlocks.DEMONIC_DOOR.get().asItem(),
                ATMBlocks.DEMONIC_TRAPDOOR.get().asItem(),
                ATMBlocks.DEMONIC_BOOKSHELF.get().asItem(),
                ATMBlocks.DEMONIC_LOG.get().asItem(),
                ATMBlocks.STRIPPED_DEMONIC_LOG.get().asItem()
        );
    }
    
    private void addWoodRecipes(
            String name,
            TagKey<Item> planksTag,
            Item planks,
            Item stairs,
            Item slab,
            Item fence,
            Item fenceGate,
            Item door,
            Item trapdoor,
            Item bookshelf,
            Item... planksSources
    ) {
        for (int i = 0; i < planksSources.length; i++) {
            String suffix = i == 0 ? "" : "_" + i;
            this.logToPlanks(planksSources[i], planks, name + "_planks" + suffix + "_from_shapelesscrafting");
        }
        
        this.stairs(planksTag, stairs, name + "_planks");
        this.slab(planksTag, slab, name + "_planks");
        this.fence(planksTag, fence, name + "_planks");
        this.fenceGate(planksTag, fenceGate, name + "_planks");
        this.door(planksTag, door, name + "_planks");
        this.trapdoor(planksTag, trapdoor, name + "_planks");
        this.bookshelf(planksTag, bookshelf, name + "_planks");
    }
    
    private void addAncientStoneRecipes() {
        this.smelting(ATMRecipeProvider.itemTag(ATMTags.Blocks.ANCIENT_STONE), ATMBlocks.SMOOTH_ANCIENT_STONE.get().asItem(), 0.15F, 200, RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, "smooth_ancient_stone_from_ancient_stone_smelting", "ancient_stone");
        this.blasting(ATMRecipeProvider.itemTag(ATMTags.Blocks.ANCIENT_STONE), ATMBlocks.SMOOTH_ANCIENT_STONE.get().asItem(), 0.15F, 100, RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, "smooth_ancient_stone_from_ancient_stone_blasting", "ancient_stone");
        
        this.shapeless(ATMBlocks.MOSSY_ANCIENT_STONE.get().asItem(), 1, "mossy_ancient_stone_from_mosscrafting", "ancient_stone", ATMTags.Items.ANCIENT_STONE, Items.MOSS_BLOCK);
        this.shapeless(ATMBlocks.MOSSY_ANCIENT_STONE.get().asItem(), 1, "mossy_ancient_stone_from_vinecrafting", "ancient_stone", ATMTags.Items.ANCIENT_STONE, Items.VINE);
        this.shapeless(ATMBlocks.POLISHED_ANCIENT_STONE.get().asItem(), 1, "polished_ancient_stone_from_waxing", "smooth_ancient_stone", ATMTags.Items.SMOOTH_ANCIENT_STONE, Items.HONEYCOMB);
        
        ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, ATMBlocks.ANCIENT_STONE_BRICKS.get().asItem(), 4)
                .group(ATMRecipeProvider.GROUP)
                .pattern("aa")
                .pattern("aa")
                .define('a', ATMTags.Items.ANCIENT_STONE)
                .unlockedBy("has_ancient_stone", this.has(ATMTags.Items.ANCIENT_STONE))
                .save(this.output);
        
        this.hammer(ATMTags.Items.ANCIENT_STONE_BRICKS, 1, ATMBlocks.CRACKED_ANCIENT_STONE_BRICKS.get().asItem(), "cracked_ancient_stone_bricks_from_crushing", "ancient_stone_bricks");
        this.hammer(ATMTags.Items.CRACKED_ANCIENT_STONE_BRICKS, 1, ATMBlocks.CHISELED_ANCIENT_STONE_BRICKS.get().asItem(), "chiseled_ancient_stone_bricks_from_crushing", "cracked_ancient_stone_bricks");
        
        this.addStoneFamilyRecipes(
                ATMBlocks.ANCIENT_STONE.get().asItem(),
                ATMTags.Items.ANCIENT_STONE,
                ATMBlocks.ANCIENT_STONE_STAIRS.get().asItem(),
                ATMBlocks.ANCIENT_STONE_SLAB.get().asItem(),
                ATMBlocks.ANCIENT_STONE_WALL.get().asItem()
        );
        this.addStoneFamilyRecipes(
                ATMBlocks.SMOOTH_ANCIENT_STONE.get().asItem(),
                ATMTags.Items.SMOOTH_ANCIENT_STONE,
                ATMBlocks.SMOOTH_ANCIENT_STONE_STAIRS.get().asItem(),
                ATMBlocks.SMOOTH_ANCIENT_STONE_SLAB.get().asItem(),
                ATMBlocks.SMOOTH_ANCIENT_STONE_WALL.get().asItem()
        );
        this.addStoneFamilyRecipes(
                ATMBlocks.MOSSY_ANCIENT_STONE.get().asItem(),
                ATMTags.Items.MOSSY_ANCIENT_STONE,
                ATMBlocks.MOSSY_ANCIENT_STONE_STAIRS.get().asItem(),
                ATMBlocks.MOSSY_ANCIENT_STONE_SLAB.get().asItem(),
                ATMBlocks.MOSSY_ANCIENT_STONE_WALL.get().asItem()
        );
        this.addStoneFamilyRecipes(
                ATMBlocks.POLISHED_ANCIENT_STONE.get().asItem(),
                ATMTags.Items.POLISHED_ANCIENT_STONE,
                ATMBlocks.POLISHED_ANCIENT_STONE_STAIRS.get().asItem(),
                ATMBlocks.POLISHED_ANCIENT_STONE_SLAB.get().asItem(),
                ATMBlocks.POLISHED_ANCIENT_STONE_WALL.get().asItem()
        );
        this.addStoneFamilyRecipes(
                ATMBlocks.ANCIENT_STONE_BRICKS.get().asItem(),
                ATMTags.Items.ANCIENT_STONE_BRICKS,
                ATMBlocks.ANCIENT_STONE_BRICK_STAIRS.get().asItem(),
                ATMBlocks.ANCIENT_STONE_BRICK_SLAB.get().asItem(),
                ATMBlocks.ANCIENT_STONE_BRICK_WALL.get().asItem()
        );
        this.addStoneFamilyRecipes(
                ATMBlocks.CRACKED_ANCIENT_STONE_BRICKS.get().asItem(),
                ATMTags.Items.CRACKED_ANCIENT_STONE_BRICKS,
                ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_STAIRS.get().asItem(),
                ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_SLAB.get().asItem(),
                ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_WALL.get().asItem()
        );
        this.addStoneFamilyRecipes(
                ATMBlocks.CHISELED_ANCIENT_STONE_BRICKS.get().asItem(),
                ATMTags.Items.CHISELED_ANCIENT_STONE_BRICKS,
                ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_STAIRS.get().asItem(),
                ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_SLAB.get().asItem(),
                ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_WALL.get().asItem()
        );
    }
    
    private void addSmithingRecipes() {
        this.smithingTemplate(ATMItems.ALLTHEMODIUM_SMITHING_TEMPLATE.get(), Items.NETHERITE_INGOT, Items.DEEPSLATE);
        this.smithingTemplate(ATMItems.VIBRANIUM_SMITHING_TEMPLATE.get(), ATMItems.ALLTHEMODIUM_INGOT.get(), ATMBlocks.ANCIENT_STONE.get());
        this.smithingTemplate(ATMItems.UNOBTAINIUM_SMITHING_TEMPLATE.get(), ATMItems.VIBRANIUM_INGOT.get(), Items.END_STONE);
        
        this.smithing(ATMItems.ALLTHEMODIUM_SMITHING_TEMPLATE.get(), Items.NETHERITE_HELMET, ATMItems.ALLTHEMODIUM_INGOT.get(), ATMItems.ALLTHEMODIUM_HELMET.get());
        this.smithing(ATMItems.ALLTHEMODIUM_SMITHING_TEMPLATE.get(), Items.NETHERITE_CHESTPLATE, ATMItems.ALLTHEMODIUM_INGOT.get(), ATMItems.ALLTHEMODIUM_CHESTPLATE.get());
        this.smithing(ATMItems.ALLTHEMODIUM_SMITHING_TEMPLATE.get(), Items.NETHERITE_LEGGINGS, ATMItems.ALLTHEMODIUM_INGOT.get(), ATMItems.ALLTHEMODIUM_LEGGINGS.get());
        this.smithing(ATMItems.ALLTHEMODIUM_SMITHING_TEMPLATE.get(), Items.NETHERITE_BOOTS, ATMItems.ALLTHEMODIUM_INGOT.get(), ATMItems.ALLTHEMODIUM_BOOTS.get());
        this.smithing(ATMItems.ALLTHEMODIUM_SMITHING_TEMPLATE.get(), Items.NETHERITE_SWORD, ATMItems.ALLTHEMODIUM_INGOT.get(), ATMItems.ALLTHEMODIUM_SWORD.get());
        this.smithing(ATMItems.ALLTHEMODIUM_SMITHING_TEMPLATE.get(), Items.NETHERITE_PICKAXE, ATMItems.ALLTHEMODIUM_INGOT.get(), ATMItems.ALLTHEMODIUM_PICKAXE.get());
        this.smithing(ATMItems.ALLTHEMODIUM_SMITHING_TEMPLATE.get(), Items.NETHERITE_AXE, ATMItems.ALLTHEMODIUM_INGOT.get(), ATMItems.ALLTHEMODIUM_AXE.get());
        this.smithing(ATMItems.ALLTHEMODIUM_SMITHING_TEMPLATE.get(), Items.NETHERITE_SHOVEL, ATMItems.ALLTHEMODIUM_INGOT.get(), ATMItems.ALLTHEMODIUM_SHOVEL.get());
        this.smithing(ATMItems.ALLTHEMODIUM_SMITHING_TEMPLATE.get(), Items.NETHERITE_HOE, ATMItems.ALLTHEMODIUM_INGOT.get(), ATMItems.ALLTHEMODIUM_HOE.get());
        this.smithing(ATMItems.ALLTHEMODIUM_SMITHING_TEMPLATE.get(), Items.MACE, ATMBlocks.ALLTHEMODIUM_BLOCK.get().asItem(), ATMItems.ALLTHEMODIUM_MACE.get());
        
        this.smithing(ATMItems.VIBRANIUM_SMITHING_TEMPLATE.get(), ATMItems.ALLTHEMODIUM_HELMET.get(), ATMItems.VIBRANIUM_INGOT.get(), ATMItems.VIBRANIUM_HELMET.get());
        this.smithing(ATMItems.VIBRANIUM_SMITHING_TEMPLATE.get(), ATMItems.ALLTHEMODIUM_CHESTPLATE.get(), ATMItems.VIBRANIUM_INGOT.get(), ATMItems.VIBRANIUM_CHESTPLATE.get());
        this.smithing(ATMItems.VIBRANIUM_SMITHING_TEMPLATE.get(), ATMItems.ALLTHEMODIUM_LEGGINGS.get(), ATMItems.VIBRANIUM_INGOT.get(), ATMItems.VIBRANIUM_LEGGINGS.get());
        this.smithing(ATMItems.VIBRANIUM_SMITHING_TEMPLATE.get(), ATMItems.ALLTHEMODIUM_BOOTS.get(), ATMItems.VIBRANIUM_INGOT.get(), ATMItems.VIBRANIUM_BOOTS.get());
        this.smithing(ATMItems.VIBRANIUM_SMITHING_TEMPLATE.get(), ATMItems.ALLTHEMODIUM_SWORD.get(), ATMItems.VIBRANIUM_INGOT.get(), ATMItems.VIBRANIUM_SWORD.get());
        this.smithing(ATMItems.VIBRANIUM_SMITHING_TEMPLATE.get(), ATMItems.ALLTHEMODIUM_PICKAXE.get(), ATMItems.VIBRANIUM_INGOT.get(), ATMItems.VIBRANIUM_PICKAXE.get());
        this.smithing(ATMItems.VIBRANIUM_SMITHING_TEMPLATE.get(), ATMItems.ALLTHEMODIUM_AXE.get(), ATMItems.VIBRANIUM_INGOT.get(), ATMItems.VIBRANIUM_AXE.get());
        this.smithing(ATMItems.VIBRANIUM_SMITHING_TEMPLATE.get(), ATMItems.ALLTHEMODIUM_SHOVEL.get(), ATMItems.VIBRANIUM_INGOT.get(), ATMItems.VIBRANIUM_SHOVEL.get());
        this.smithing(ATMItems.VIBRANIUM_SMITHING_TEMPLATE.get(), ATMItems.ALLTHEMODIUM_HOE.get(), ATMItems.VIBRANIUM_INGOT.get(), ATMItems.VIBRANIUM_HOE.get());
        this.smithing(ATMItems.VIBRANIUM_SMITHING_TEMPLATE.get(), ATMItems.ALLTHEMODIUM_MACE.get(), ATMBlocks.VIBRANIUM_BLOCK.get().asItem(), ATMItems.VIBRANIUM_MACE.get());
        
        this.smithing(ATMItems.UNOBTAINIUM_SMITHING_TEMPLATE.get(), ATMItems.VIBRANIUM_HELMET.get(), ATMItems.UNOBTAINIUM_INGOT.get(), ATMItems.UNOBTAINIUM_HELMET.get());
        this.smithing(ATMItems.UNOBTAINIUM_SMITHING_TEMPLATE.get(), ATMItems.VIBRANIUM_CHESTPLATE.get(), ATMItems.UNOBTAINIUM_INGOT.get(), ATMItems.UNOBTAINIUM_CHESTPLATE.get());
        this.smithing(ATMItems.UNOBTAINIUM_SMITHING_TEMPLATE.get(), ATMItems.VIBRANIUM_LEGGINGS.get(), ATMItems.UNOBTAINIUM_INGOT.get(), ATMItems.UNOBTAINIUM_LEGGINGS.get());
        this.smithing(ATMItems.UNOBTAINIUM_SMITHING_TEMPLATE.get(), ATMItems.VIBRANIUM_BOOTS.get(), ATMItems.UNOBTAINIUM_INGOT.get(), ATMItems.UNOBTAINIUM_BOOTS.get());
        this.smithing(ATMItems.UNOBTAINIUM_SMITHING_TEMPLATE.get(), ATMItems.VIBRANIUM_SWORD.get(), ATMItems.UNOBTAINIUM_INGOT.get(), ATMItems.UNOBTAINIUM_SWORD.get());
        this.smithing(ATMItems.UNOBTAINIUM_SMITHING_TEMPLATE.get(), ATMItems.VIBRANIUM_PICKAXE.get(), ATMItems.UNOBTAINIUM_INGOT.get(), ATMItems.UNOBTAINIUM_PICKAXE.get());
        this.smithing(ATMItems.UNOBTAINIUM_SMITHING_TEMPLATE.get(), ATMItems.VIBRANIUM_AXE.get(), ATMItems.UNOBTAINIUM_INGOT.get(), ATMItems.UNOBTAINIUM_AXE.get());
        this.smithing(ATMItems.UNOBTAINIUM_SMITHING_TEMPLATE.get(), ATMItems.VIBRANIUM_SHOVEL.get(), ATMItems.UNOBTAINIUM_INGOT.get(), ATMItems.UNOBTAINIUM_SHOVEL.get());
        this.smithing(ATMItems.UNOBTAINIUM_SMITHING_TEMPLATE.get(), ATMItems.VIBRANIUM_HOE.get(), ATMItems.UNOBTAINIUM_INGOT.get(), ATMItems.UNOBTAINIUM_HOE.get());
        this.smithing(ATMItems.UNOBTAINIUM_SMITHING_TEMPLATE.get(), ATMItems.VIBRANIUM_MACE.get(), ATMBlocks.UNOBTAINIUM_BLOCK.get().asItem(), ATMItems.UNOBTAINIUM_MACE.get());
    }
    
    private void addStoneFamilyRecipes(Item input, TagKey<Item> inputTag, Item stairs, Item slab, Item wall) {
        String unlockName = this.name(input);
        this.stairs(inputTag, stairs, unlockName);
        this.slab(inputTag, slab, unlockName);
        this.wall(inputTag, wall, unlockName);
        
        this.stonecutting(input, stairs, 1);
        this.stonecutting(input, slab, 2);
        this.stonecutting(input, wall, 1);
    }
    
    private void addSpecialRecipes() {
        this.teleportPad();
        this.compressSimple(ATMItems.PIGLICH_HEART.get(), ATMBlocks.PIGLICH_HEART_BLOCK.get().asItem(), "piglich_heart_block", "piglich_heart");
        this.decompressSimple(ATMBlocks.PIGLICH_HEART_BLOCK.get().asItem(), ATMItems.PIGLICH_HEART.get(), "piglich_heart", "piglich_heart_block");
    }
    
    private void food(Item input, Item output) {
        ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, output)
                .group(ATMRecipeProvider.GROUP)
                .pattern("nnn")
                .pattern("nan")
                .pattern("nnn")
                .define('a', input)
                .define('n', ATMTags.Items.NUGGETS_ALLTHEMODIUM)
                .unlockedBy("has_allthemodium_nugget", this.has(ATMTags.Items.NUGGETS_ALLTHEMODIUM))
                .save(this.output);
    }
    
    private void compress(TagKey<Item> input, Item output, String path, String unlockName) {
        this.saveRecipe(
                ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, output)
                        .group(ATMRecipeProvider.GROUP)
                        .pattern("aaa")
                        .pattern("aaa")
                        .pattern("aaa")
                        .define('a', input)
                        .unlockedBy("has_" + unlockName, this.has(input)),
                output,
                path
        );
    }
    
    private void compressSimple(Item input, Item output, String path, String unlockName) {
        this.saveRecipe(
                ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, output)
                        .group(ATMRecipeProvider.GROUP)
                        .pattern("aaa")
                        .pattern("aaa")
                        .pattern("aaa")
                        .define('a', input)
                        .unlockedBy("has_" + unlockName, this.has(input)),
                output,
                path
        );
    }
    
    private void decompress(TagKey<Item> input, Item output, String path, String unlockName) {
        this.saveRecipe(
                ShapelessRecipeBuilder.shapeless(this.items, RecipeCategory.MISC, output, 9)
                        .group(ATMRecipeProvider.GROUP)
                        .requires(input)
                        .unlockedBy("has_" + unlockName, this.has(input)),
                output,
                path
        );
    }
    
    private void decompressSimple(Item input, Item output, String path, String unlockName) {
        this.saveRecipe(
                ShapelessRecipeBuilder.shapeless(this.items, RecipeCategory.MISC, output, 9)
                        .group(ATMRecipeProvider.GROUP)
                        .requires(input)
                        .unlockedBy("has_" + unlockName, this.has(input)),
                output,
                path
        );
    }
    
    private void hammer(TagKey<Item> input, int amount, Item output, String path, String unlockName) {
        this.saveRecipe(
                ShapelessRecipeBuilder.shapeless(this.items, RecipeCategory.MISC, output, amount)
                        .group(ATMRecipeProvider.GROUP)
                        .requires(input)
                        .requires(ATORegistry.ORE_HAMMER)
                        .unlockedBy("has_" + unlockName, this.has(input)),
                output,
                path
        );
    }
    
    private void smelting(TagKey<Item> input, Item output, float experience, int cookingTime, RecipeCategory recipeCategory, CookingBookCategory cookingBookCategory, String path, String unlockName) {
        this.saveRecipe(
                SimpleCookingRecipeBuilder.smelting(Ingredient.of(this.items.getOrThrow(input)), recipeCategory, cookingBookCategory, output, experience, cookingTime)
                        .unlockedBy("has_" + unlockName, this.has(input)),
                output,
                path
        );
    }
    
    private void blasting(TagKey<Item> input, Item output, float experience, int cookingTime, RecipeCategory recipeCategory, CookingBookCategory cookingBookCategory, String path, String unlockName) {
        this.saveRecipe(
                SimpleCookingRecipeBuilder.blasting(Ingredient.of(this.items.getOrThrow(input)), recipeCategory, cookingBookCategory, output, experience, cookingTime)
                        .unlockedBy("has_" + unlockName, this.has(input)),
                output,
                path
        );
    }
    
    private void gear(TagKey<Item> input, Item output, String unlockName) {
        this.saveRecipe(
                ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, output)
                        .group(ATMRecipeProvider.GROUP)
                        .pattern(" a ")
                        .pattern("ana")
                        .pattern(" a ")
                        .define('a', input)
                        .define('n', Tags.Items.NUGGETS_IRON)
                        .unlockedBy("has_" + unlockName, this.has(input)),
                output
        );
    }
    
    private void plate(TagKey<Item> input, Item output, String unlockName) {
        this.saveRecipe(
                ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, output)
                        .group(ATMRecipeProvider.GROUP)
                        .pattern("ha ")
                        .pattern("a  ")
                        .define('a', input)
                        .define('h', ATORegistry.ORE_HAMMER)
                        .unlockedBy("has_" + unlockName, this.has(input)),
                output
        );
    }
    
    private void rod(TagKey<Item> input, Item output, String unlockName) {
        this.saveRecipe(
                ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, output)
                        .group(ATMRecipeProvider.GROUP)
                        .pattern("  a")
                        .pattern("ha ")
                        .define('a', input)
                        .define('h', ATORegistry.ORE_HAMMER)
                        .unlockedBy("has_" + unlockName, this.has(input)),
                output
        );
    }
    
    private void logToPlanks(Item input, Item output, String path) {
        this.saveRecipe(
                ShapelessRecipeBuilder.shapeless(this.items, RecipeCategory.MISC, output, 4)
                        .requires(input)
                        .unlockedBy("has_" + this.name(input), this.has(input)),
                output,
                path
        );
    }
    
    private void stairs(TagKey<Item> input, Item output, String unlockName) {
        this.saveRecipe(
                ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, output, 4)
                        .group(ATMRecipeProvider.GROUP)
                        .pattern("a  ")
                        .pattern("aa ")
                        .pattern("aaa")
                        .define('a', input)
                        .unlockedBy("has_" + unlockName, this.has(input)),
                output
        );
    }
    
    private void slab(TagKey<Item> input, Item output, String unlockName) {
        this.saveRecipe(
                ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, output, 6)
                        .group(ATMRecipeProvider.GROUP)
                        .pattern("aaa")
                        .define('a', input)
                        .unlockedBy("has_" + unlockName, this.has(input)),
                output
        );
    }
    
    private void wall(TagKey<Item> input, Item output, String unlockName) {
        this.saveRecipe(
                ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, output, 6)
                        .group(ATMRecipeProvider.GROUP)
                        .pattern("aaa")
                        .pattern("aaa")
                        .define('a', input)
                        .unlockedBy("has_" + unlockName, this.has(input)),
                output
        );
    }
    
    private void fence(TagKey<Item> input, Item output, String unlockName) {
        this.saveRecipe(
                ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, output, 3)
                        .group(ATMRecipeProvider.GROUP)
                        .pattern("asa")
                        .pattern("asa")
                        .define('a', input)
                        .define('s', Items.STICK)
                        .unlockedBy("has_" + unlockName, this.has(input)),
                output
        );
    }
    
    private void fenceGate(TagKey<Item> input, Item output, String unlockName) {
        this.saveRecipe(
                ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, output)
                        .group(ATMRecipeProvider.GROUP)
                        .pattern("sas")
                        .pattern("sas")
                        .define('a', input)
                        .define('s', Items.STICK)
                        .unlockedBy("has_" + unlockName, this.has(input)),
                output
        );
    }
    
    private void door(TagKey<Item> input, Item output, String unlockName) {
        this.saveRecipe(
                ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, output, 3)
                        .group(ATMRecipeProvider.GROUP)
                        .pattern("aa")
                        .pattern("aa")
                        .pattern("aa")
                        .define('a', input)
                        .unlockedBy("has_" + unlockName, this.has(input)),
                output
        );
    }
    
    private void trapdoor(TagKey<Item> input, Item output, String unlockName) {
        this.saveRecipe(
                ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, output, 2)
                        .group(ATMRecipeProvider.GROUP)
                        .pattern("aaa")
                        .pattern("aaa")
                        .define('a', input)
                        .unlockedBy("has_" + unlockName, this.has(input)),
                output
        );
    }
    
    private void bookshelf(TagKey<Item> input, Item output, String unlockName) {
        this.saveRecipe(
                ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, output)
                        .group(ATMRecipeProvider.GROUP)
                        .pattern("aaa")
                        .pattern("bbb")
                        .pattern("aaa")
                        .define('a', input)
                        .define('b', Items.BOOK)
                        .unlockedBy("has_" + unlockName, this.has(input)),
                output
        );
    }
    
    private void stonecutting(Item input, Item output, int count) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), RecipeCategory.MISC, output, count)
                .unlockedBy("has_" + this.name(input), this.has(input))
                .save(this.output, this.id(this.name(output) + "_from_stone_cutting"));
    }
    
    private void shapeless(Item output, int count, String path, String unlockName, TagKey<Item> first, Item second) {
        this.saveRecipe(
                ShapelessRecipeBuilder.shapeless(this.items, RecipeCategory.MISC, output, count)
                        .group(ATMRecipeProvider.GROUP)
                        .requires(first)
                        .requires(second)
                        .unlockedBy("has_" + unlockName, this.has(first)),
                output,
                path
        );
    }
    
    private void teleportPad() {
        this.saveRecipe(
                ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, ATMBlocks.TELEPORT_PAD.get().asItem())
                        .group(ATMRecipeProvider.GROUP)
                        .pattern(" n ")
                        .pattern("nan")
                        .pattern(" n ")
                        .define('a', Items.ENDER_PEARL)
                        .define('n', ATMTags.Items.NUGGETS_ALLTHEMODIUM)
                        .unlockedBy("has_allthemodium_nugget", this.has(ATMTags.Items.NUGGETS_ALLTHEMODIUM)),
                ATMBlocks.TELEPORT_PAD.get().asItem(),
                "teleport_pad"
        );
    }
    
    private void smithingTemplate(Item template, Item material, ItemLike baseBlock) {
        this.saveRecipe(
                ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, template, 2)
                        .pattern("#S#")
                        .pattern("#C#")
                        .pattern("###")
                        .define('#', material)
                        .define('C', baseBlock)
                        .define('S', template)
                        .unlockedBy("has_" + this.name(template), this.has(template)),
                template
        );
    }
    
    private void smithing(Item template, Item base, Item addition, Item result) {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(template),
                        Ingredient.of(base),
                        Ingredient.of(addition),
                        RecipeCategory.MISC,
                        result
                )
                .unlocks("has_" + this.name(addition), this.has(addition))
                .save(this.output, this.id(this.name(result) + "_smithing"));
    }
    
    private String name(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).getPath();
    }
    
    private String id(String path) {
        return ATM.id(path).toString();
    }
    
    private void saveRecipe(RecipeBuilder builder, Item output) {
        builder.save(this.output);
    }
    
    private void saveRecipe(RecipeBuilder builder, Item output, String path) {
        if (path.equals(this.name(output))) {
            builder.save(this.output);
            return;
        }
        builder.save(this.output, this.id(path));
    }
    
    private static TagKey<Item> itemTag(TagKey<Block> tag) {
        return TagKey.create(Registries.ITEM, tag.location());
    }
    
    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
            super(output, lookupProvider);
        }
        
        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider lookupProvider, RecipeOutput output) {
            return new ATMRecipeProvider(lookupProvider, output);
        }
        
        @Override
        public String getName() {
            return "AllTheModium recipes";
        }
    }
}
