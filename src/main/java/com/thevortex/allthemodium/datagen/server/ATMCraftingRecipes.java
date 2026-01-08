package com.thevortex.allthemodium.datagen.server;

import com.thevortex.allthemodium.datagen.builder.ShapedAncientStones;
import com.thevortex.allthemodium.datagen.builder.ShapedBlockBuilder;
import com.thevortex.allthemodium.datagen.builder.ShapedIngotBuilder;
import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.ModRegistry;
import com.thevortex.allthemodium.registry.TagRegistry;
import net.allthemods.alltheores.registry.ATOTagRegistry;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger.TriggerInstance;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

public class ATMCraftingRecipes extends RecipeProvider
{
    public ATMCraftingRecipes(PackOutput packOutput, CompletableFuture<Provider> provider) {
        super(packOutput, provider);
    }

    private ResourceLocation recipeDir(String typeIn, String typeOut) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, typeIn + "_from_" + typeOut);
    }

    private ShapedRecipeBuilder shaped(ItemLike provider, int integer) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, provider, integer)
                .group(Reference.MOD_ID);
    }

    private ShapedRecipeBuilder shaped(ItemLike provider) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, provider)
                .group(Reference.MOD_ID);
    }

    private static Criterion<TriggerInstance> hasTag(TagKey<Item> tagKey) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(tagKey).build());
    }


    @Override
    protected void buildRecipes(RecipeOutput consumer) {
        buildShapedRecipes(consumer);
        buildShapelessRecipes(consumer);
        buildSmeltingRecipes(consumer);
        buildBlastingRecipes(consumer);
    }

    protected void buildShapedRecipes(RecipeOutput consumer) {

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModRegistry.RAW_ALLTHEMODIUM_BLOCK.get())
                .group(Reference.MOD_ID)
                .requires(Ingredient.of(TagRegistry.RAW_ALLTHEMODIUM), 9)
                .unlockedBy("has_raw_allthemodium", hasTag(TagRegistry.RAW_ALLTHEMODIUM))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModRegistry.RAW_VIBRANIUM_BLOCK.get())
                .group(Reference.MOD_ID)
                .requires(Ingredient.of(TagRegistry.RAW_VIBRANIUM), 9)
                .unlockedBy("has_raw_vibranium", hasTag(TagRegistry.RAW_VIBRANIUM))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModRegistry.RAW_UNOBTAINIUM_BLOCK.get())
                .group(Reference.MOD_ID)
                .requires(Ingredient.of(TagRegistry.RAW_UNOBTAINIUM), 9)
                .unlockedBy("has_raw_unobtainium", hasTag(TagRegistry.RAW_UNOBTAINIUM))
                .save(consumer);

        shaped(ModRegistry.PIGLICH_HEART_BLOCK.get())
                .pattern("nnn")
                .pattern("nnn")
                .pattern("nnn")
                .define('n', ModRegistry.PIGLICH_HEART.get())
                .unlockedBy(getHasName(ModRegistry.PIGLICH_HEART.get()), has(ModRegistry.PIGLICH_HEART.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModRegistry.PIGLICH_HEART.get(), 9)
                .group(Reference.MOD_ID)
                .requires(ModRegistry.PIGLICH_HEART_BLOCK.get())
                .unlockedBy(getHasName(ModRegistry.PIGLICH_HEART.get()), has(ModRegistry.PIGLICH_HEART.get()))
                .save(consumer);

        shaped(ModRegistry.ALLTHEMODIUM_APPLE.get())
                .pattern("nnn")
                .pattern("nan")
                .pattern("nnn")
                .define('n', TagRegistry.ALLTHEMODIUM_NUGGET)
                .define('a', Items.APPLE)
                .unlockedBy("has_allthemodium_nugget", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.ALLTHEMODIUM_NUGGET).build()))
                .save(consumer);

        shaped(ModRegistry.ALLTHEMODIUM_CARROT.get())
                .pattern("nnn")
                .pattern("nan")
                .pattern("nnn")
                .define('n', TagRegistry.ALLTHEMODIUM_NUGGET)
                .define('a', Items.CARROT)
                .unlockedBy("has_allthemodium_nugget", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.ALLTHEMODIUM_NUGGET).build()))
                .save(consumer);

        shaped(ModRegistry.TELEPORT_PAD.get())
                .pattern(" n ")
                .pattern("nan")
                .pattern(" n ")
                .define('n', TagRegistry.ALLTHEMODIUM_NUGGET)
                .define('a', Items.ENDER_PEARL)
                .unlockedBy("has_allthemodium_nugget", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.ALLTHEMODIUM_NUGGET).build()))
                .unlockedBy("has_ender_pearl", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(Items.ENDER_PEARL).build()))
                .save(consumer);
/*
        shaped(ModRegistry.ALLTHEMODIUM_PICKAXE.get())
            .pattern("ara")
            .pattern(" r ")
            .pattern(" r ")
            .define('r', TagRegistry.ALLTHEMODIUM_ROD)
            .define('a', TagRegistry.ALLTHEMODIUM_PLATE)
            .unlockedBy("has_allthemodium_rod", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.ALLTHEMODIUM_ROD).build()))
            .save(consumer);



        shaped(ModRegistry.ALLTHEMODIUM_AXE.get())
                .pattern("aa ")
                .pattern("ar ")
                .pattern(" r ")
                .define('r', TagRegistry.ALLTHEMODIUM_ROD)
                .define('a', TagRegistry.ALLTHEMODIUM_PLATE)
                .unlockedBy("has_allthemodium_rod", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.ALLTHEMODIUM_ROD).build()))
                .save(consumer);




        shaped(ModRegistry.ALLTHEMODIUM_SHOVEL.get())
                .pattern(" a ")
                .pattern(" r ")
                .pattern(" r ")
                .define('r', TagRegistry.ALLTHEMODIUM_ROD)
                .define('a', TagRegistry.ALLTHEMODIUM_PLATE)
                .unlockedBy("has_allthemodium_rod", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.ALLTHEMODIUM_ROD).build()))
                .save(consumer);



        shaped(ModRegistry.ALLTHEMODIUM_HOE.get())
                .pattern("aa ")
                .pattern(" r ")
                .pattern(" r ")
                .define('r', TagRegistry.ALLTHEMODIUM_ROD)
                .define('a', TagRegistry.ALLTHEMODIUM_PLATE)
                .unlockedBy("has_allthemodium_rod", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.ALLTHEMODIUM_ROD).build()))
                .save(consumer);




        shaped(ModRegistry.ALLTHEMODIUM_SWORD.get())
                .pattern(" a ")
                .pattern(" a ")
                .pattern(" r ")
                .define('r', TagRegistry.ALLTHEMODIUM_ROD)
                .define('a', TagRegistry.ALLTHEMODIUM_PLATE)
                .unlockedBy("has_allthemodium_rod", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.ALLTHEMODIUM_ROD).build()))
                .save(consumer);
*/

        final String hasCondition = "has_item";

        ShapedAncientStones.builder(TagRegistry.DEMONIC_WOODEN_PLANKS_ITEM)
                .setBookShelf(ModRegistry.DEMONIC_BOOKSHELF.get().asItem())
                .setDoor(ModRegistry.DEMONIC_DOOR.get().asItem())
                .setTrapDoor(ModRegistry.DEMONIC_TRAPDOOR.get().asItem())
                .setStairs(ModRegistry.DEMONIC_WOODEN_STAIRS.get().asItem())
                .setFence(ModRegistry.DEMONIC_WOOD_FENCE.get().asItem())
                .setFenceGate(ModRegistry.DEMONIC_WOOD_FENCE_GATE.get().asItem())
                .setSlab(ModRegistry.DEMONIC_WOODEN_SLABS.get().asItem())
                .build(consumer);

        ShapedAncientStones.builder(TagRegistry.SOUL_WOODEN_PLANKS_ITEM)
                .setBookShelf(ModRegistry.SOUL_BOOKSHELF.get().asItem())
                .setDoor(ModRegistry.SOUL_DOOR.get().asItem())
                .setTrapDoor(ModRegistry.SOUL_TRAPDOOR.get().asItem())
                .setStairs(ModRegistry.SOUL_WOODEN_STAIRS.get().asItem())
                .setFence(ModRegistry.SOUL_WOOD_FENCE.get().asItem())
                .setFenceGate(ModRegistry.SOUL_WOOD_FENCE_GATE.get().asItem())
                .setSlab(ModRegistry.SOUL_WOODEN_SLABS.get().asItem())
                .build(consumer);

        ShapedAncientStones.builder(TagRegistry.ANCIENT_WOODEN_PLANKS_ITEM)
                .setBookShelf(ModRegistry.ANCIENT_BOOKSHELF.get().asItem())
                .setTrapDoor(ModRegistry.ANCIENT_TRAPDOOR.get().asItem())
                .setDoor(ModRegistry.ANCIENT_DOOR.get().asItem())
                .setStairs(ModRegistry.ANCIENT_WOODEN_STAIRS.get().asItem())
                .setFence(ModRegistry.ANCIENT_WOOD_FENCE.get().asItem())
                .setFenceGate(ModRegistry.ANCIENT_WOOD_FENCE_GATE.get().asItem())
                .setSlab(ModRegistry.ANCIENT_WOODEN_SLABS.get().asItem())
                .build(consumer);

        ShapedAncientStones.builder(TagRegistry.ANCIENT_STONE_BRICKS_ITEM)
                .setStairs(ModRegistry.ANCIENT_STONE_BRICK_STAIRS.get().asItem())
                .setWall(ModRegistry.ANCIENT_STONE_BRICK_WALL.get().asItem())
                .setSlab(ModRegistry.ANCIENT_STONE_BRICK_SLABS.get().asItem())
                .build(consumer);

        ShapedAncientStones.builder(TagRegistry.ANCIENT_STONE_ITEM)
                .setBrick(ModRegistry.ANCIENT_STONE_BRICKS.get().asItem())
                .setStairs(ModRegistry.ANCIENT_STONE_STAIRS.get().asItem())
                .setWall(ModRegistry.ANCIENT_STONE_WALL.get().asItem())
                .setSlab(ModRegistry.ANCIENT_STONE_SLABS.get().asItem())
                .build(consumer);

        ShapedAncientStones.builder(TagRegistry.ANCIENT_MOSSY_STONE_ITEM)
                .setStairs(ModRegistry.ANCIENT_MOSSY_STONE_STAIRS.get().asItem())
                .setWall(ModRegistry.ANCIENT_MOSSY_STONE_WALL.get().asItem())
                .setSlab(ModRegistry.ANCIENT_MOSSY_STONE_SLABS.get().asItem())
                .build(consumer);

        ShapedAncientStones.builder(TagRegistry.ANCIENT_SMOOTH_STONE_ITEM)
                .setStairs(ModRegistry.ANCIENT_SMOOTH_STONE_STAIRS.get().asItem())
                .setWall(ModRegistry.ANCIENT_SMOOTH_STONE_WALL.get().asItem())
                .setSlab(ModRegistry.ANCIENT_SMOOTH_STONE_SLABS.get().asItem())
                .build(consumer);

        ShapedAncientStones.builder(TagRegistry.ANCIENT_POLISHED_STONE_ITEM)
                .setStairs(ModRegistry.ANCIENT_POLISHED_STONE_STAIRS.get().asItem())
                .setWall(ModRegistry.ANCIENT_POLISHED_STONE_WALL.get().asItem())
                .setSlab(ModRegistry.ANCIENT_POLISHED_STONE_SLABS.get().asItem())
                .build(consumer);

        ShapedAncientStones.builder(TagRegistry.ANCIENT_CHISELED_STONE_BRICKS_ITEM)
                .setStairs(ModRegistry.ANCIENT_CHISELED_STONE_STAIRS.get().asItem())
                .setWall(ModRegistry.ANCIENT_CHISELED_STONE_BRICK_WALL.get().asItem())
                .setSlab(ModRegistry.ANCIENT_CHISELED_STONE_SLABS.get().asItem())
                .build(consumer);

        ShapedAncientStones.builder(TagRegistry.ANCIENT_CRACKED_STONE_BRICKS_ITEM)
                .setStairs(ModRegistry.ANCIENT_CRACKED_STONE_STAIRS.get().asItem())
                .setWall(ModRegistry.ANCIENT_CRACKED_STONE_BRICK_WALL.get().asItem())
                .setSlab(ModRegistry.ANCIENT_CRACKED_STONE_SLABS.get().asItem())
                .build(consumer);

        ShapedBlockBuilder.builder(TagRegistry.ALLTHEMODIUM_INGOT)
                .setBlock(ModRegistry.ALLTHEMODIUM_BLOCK.get().asItem())
                .setGear(ModRegistry.ATM_GEAR)
                .setPlate(ModRegistry.ATM_PLATE)
                .setRod(ModRegistry.ATM_ROD)
                .build(consumer);

        ShapedBlockBuilder.builder(TagRegistry.VIBRANIUM_INGOT)
                .setBlock(ModRegistry.VIBRANIUM_BLOCK.get().asItem())
                .setGear(ModRegistry.VIB_GEAR)
                .setPlate(ModRegistry.VIB_PLATE)
                .setRod(ModRegistry.VIB_ROD)
                .build(consumer);

        ShapedBlockBuilder.builder(TagRegistry.UNOBTAINIUM_INGOT)
                .setBlock(ModRegistry.UNOBTAINIUM_BLOCK.get().asItem())
                .setGear(ModRegistry.ONOB_GEAR)
                .setPlate(ModRegistry.ONOB_PLATE)
                .setRod(ModRegistry.ONOB_ROD)
                .build(consumer);

        ShapedBlockBuilder.builder(TagRegistry.UNOBTAINIUM_ALLTHEMODIUM_INGOT)
                .setBlock(ModRegistry.UA_ALLOY.get().asItem())
                .build(consumer);

        ShapedBlockBuilder.builder(TagRegistry.UNOBTAINIUM_VIBRANIUM_INGOT)
                .setBlock(ModRegistry.UV_ALLOY.get().asItem())
                .build(consumer);

        ShapedBlockBuilder.builder(TagRegistry.VIBRANIUM_ALLTHEMODIUM_INGOT)
                .setBlock(ModRegistry.VA_ALLOY.get().asItem())
                .build(consumer);

        ShapedIngotBuilder.builder(TagRegistry.ALLTHEMODIUM_NUGGET)
                .setIngot(ModRegistry.ALLTHEMODIUM_INGOT)
                .build(consumer);
        ShapedIngotBuilder.builder(TagRegistry.VIBRANIUM_NUGGET)
                .setIngot(ModRegistry.VIBRANIUM_INGOT)
                .build(consumer);
        ShapedIngotBuilder.builder(TagRegistry.UNOBTAINIUM_NUGGET)
                .setIngot(ModRegistry.UNOBTAINIUM_INGOT)
                .build(consumer);

    }


    protected void buildBlastingRecipes(RecipeOutput consumer) {

        final String hasCondition = "has_item";

        SimpleCookingRecipeBuilder
                .blasting(Ingredient.of(ModRegistry.ANCIENT_STONE.get()), RecipeCategory.MISC, ModRegistry.ANCIENT_SMOOTH_STONE.get(), 0.15f, 100)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.ANCIENT_STONE.get()))
                .save(consumer, recipeDir("ancient_smooth_stone", "ancient_stone_blasting"));

        SimpleCookingRecipeBuilder
                .blasting(Ingredient.of(TagRegistry.RAW_ALLTHEMODIUM), RecipeCategory.MISC, ModRegistry.ALLTHEMODIUM_INGOT.get(), 0.15f, 100)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.RAW_ALLTHEMODIUM.get()))
                .save(consumer, recipeDir("allthemodium_ingot", "raw_blasting"));

        SimpleCookingRecipeBuilder
                .blasting(Ingredient.of(TagRegistry.RAW_VIBRANIUM), RecipeCategory.MISC, ModRegistry.VIBRANIUM_INGOT.get(), 0.15f, 100)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.RAW_VIBRANIUM.get()))
                .save(consumer, recipeDir("vibranium_ingot", "raw_blasting"));

        SimpleCookingRecipeBuilder
                .blasting(Ingredient.of(TagRegistry.RAW_UNOBTAINIUM), RecipeCategory.MISC, ModRegistry.UNOBTAINIUM_INGOT.get(), 0.15f, 100)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.RAW_UNOBTAINIUM.get()))
                .save(consumer, recipeDir("unobtainium_ingot", "raw_blasting"));

        SimpleCookingRecipeBuilder
                .blasting(Ingredient.of(TagRegistry.ALLTHEMODIUM_DUST), RecipeCategory.MISC, ModRegistry.ALLTHEMODIUM_INGOT.get(), 0.15f, 100)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.ALLTHEMODIUM_DUST.get()))
                .save(consumer, recipeDir("allthemodium_ingot", "dust_blasting"));

        SimpleCookingRecipeBuilder
                .blasting(Ingredient.of(TagRegistry.VIBRANIUM_DUST), RecipeCategory.MISC, ModRegistry.VIBRANIUM_INGOT.get(), 0.15f, 100)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.VIBRANIUM_DUST.get()))
                .save(consumer, recipeDir("vibranium_ingot", "dust_blasting"));

        SimpleCookingRecipeBuilder
                .blasting(Ingredient.of(TagRegistry.UNOBTAINIUM_DUST), RecipeCategory.MISC, ModRegistry.UNOBTAINIUM_INGOT.get(), 0.15f, 100)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.UNOBTAINIUM_DUST.get()))
                .save(consumer, recipeDir("unobtainium_ingot", "dust_blasting"));

        SimpleCookingRecipeBuilder
                .blasting(Ingredient.of(TagRegistry.ALLTHEMODIUM_ORE_ITEM), RecipeCategory.MISC, ModRegistry.ALLTHEMODIUM_INGOT.get(), 0.15f, 100)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.ALLTHEMODIUM_DUST.get()))
                .save(consumer, recipeDir("allthemodium_ingot", "ore_blasting"));

        SimpleCookingRecipeBuilder
                .blasting(Ingredient.of(TagRegistry.VIBRANIUM_ORE_ITEM), RecipeCategory.MISC, ModRegistry.VIBRANIUM_INGOT.get(), 0.15f, 100)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.VIBRANIUM_DUST.get()))
                .save(consumer, recipeDir("vibranium_ingot", "ore_blasting"));

        SimpleCookingRecipeBuilder
                .blasting(Ingredient.of(TagRegistry.UNOBTAINIUM_ORE_ITEM), RecipeCategory.MISC, ModRegistry.UNOBTAINIUM_INGOT.get(), 0.15f, 100)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.UNOBTAINIUM_DUST.get()))
                .save(consumer, recipeDir("unobtainium_ingot", "ore_blasting"));
    }


    protected void buildShapelessRecipes(RecipeOutput consumer) {

        final String hasCondition = "has_item";

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ModRegistry.DEMONIC_PLANKS.get(), 4)
                .requires(ModRegistry.DEMONIC_LOG.get().asItem())
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.DEMONIC_LOG.get().asItem()))
                .save(consumer, recipeDir("demonic_planks", "shapelesscrafting"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ModRegistry.SOUL_PLANKS.get(), 4)
                .requires(ModRegistry.SOUL_LOG.get().asItem())
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.SOUL_LOG.get().asItem()))
                .save(consumer, recipeDir("soul_planks", "shapelesscrafting"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ModRegistry.SOUL_PLANKS.get(), 4)
                .requires(ModRegistry.SOUL_LOG_0.get().asItem())
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.SOUL_LOG_0.get().asItem()))
                .save(consumer, recipeDir("soul_planks_0", "shapelesscrafting"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ModRegistry.SOUL_PLANKS.get(), 4)
                .requires(ModRegistry.SOUL_LOG_1.get().asItem())
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.SOUL_LOG_1.get().asItem()))
                .save(consumer, recipeDir("soul_planks_1", "shapelesscrafting"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ModRegistry.SOUL_PLANKS.get(), 4)
                .requires(ModRegistry.SOUL_LOG_2.get().asItem())
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.SOUL_LOG_2.get().asItem()))
                .save(consumer, recipeDir("soul_planks_2", "shapelesscrafting"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ModRegistry.ANCIENT_PLANKS.get(), 4)
                .requires(ModRegistry.ANCIENT_LOG_0.get())
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.ANCIENT_LOG_0.get()))
                .save(consumer, recipeDir("ancient_planks", "shapelesscrafting"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ModRegistry.ANCIENT_PLANKS.get(), 4)
                .requires(ModRegistry.ANCIENT_LOG_1.get())
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.ANCIENT_LOG_1.get()))
                .save(consumer, recipeDir("ancient_planks_1", "shapelesscrafting"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ModRegistry.ANCIENT_PLANKS.get(), 4)
                .requires(ModRegistry.ANCIENT_LOG_2.get())
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.ANCIENT_LOG_2.get()))
                .save(consumer, recipeDir("ancient_planks_2", "shapelesscrafting"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ModRegistry.ANCIENT_PLANKS.get(), 4)
                .requires(ModRegistry.ANCIENT_LOG_STRIPPED.get().asItem())
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.ANCIENT_LOG_STRIPPED.get().asItem()))
                .save(consumer, recipeDir("ancient_planks_3", "shapelesscrafting"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ModRegistry.ANCIENT_MOSSY_STONE.get(), 1)
                .requires(ModRegistry.ANCIENT_STONE.get())
                .requires(Items.VINE)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.ANCIENT_STONE.get()))
                .save(consumer, recipeDir("ancient_mossy_stone", "vinecrafting"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ModRegistry.ANCIENT_POLISHED_STONE.get(), 1)
                .requires(ModRegistry.ANCIENT_SMOOTH_STONE.get())
                .requires(Items.HONEYCOMB)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.ANCIENT_SMOOTH_STONE.get()))
                .save(consumer, recipeDir("ancient_polished_stone", "waxing"));


        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ModRegistry.ANCIENT_CRACKED_STONE_BRICKS.get(), 1)
                .requires(TagRegistry.ANCIENT_STONE_BRICKS_ITEM)
                .requires(ATOTagRegistry.ORE_HAMMERS)
                .unlockedBy(hasCondition, RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.ANCIENT_STONE_BRICKS_ITEM).build()))
                .save(consumer, recipeDir("ancient_cracked_stone_bricks", "crushing"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ModRegistry.ANCIENT_CHISELED_STONE_BRICKS.get(), 1)
                .requires(TagRegistry.ANCIENT_CRACKED_STONE_BRICKS_ITEM)
                .requires(ATOTagRegistry.ORE_HAMMERS)
                .unlockedBy(hasCondition, RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.ANCIENT_CRACKED_STONE_BRICKS_ITEM).build()))
                .save(consumer, recipeDir("ancient_chiseled_stone_bricks", "crushing"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ModRegistry.ALLTHEMODIUM_DUST.get(), 2)
                .requires(ModRegistry.RAW_ALLTHEMODIUM.get())
                .requires(ATOTagRegistry.ORE_HAMMERS)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.RAW_ALLTHEMODIUM.get()))
                .save(consumer, recipeDir("allthemodium_dust", "ore_crushing"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ModRegistry.ALLTHEMODIUM_INGOT.get(), 9)
                .requires(TagRegistry.ALLTHEMODIUM_BLOCK_ITEM)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.ALLTHEMODIUM_BLOCK.get()))
                .save(consumer, recipeDir("allthemodium_ingot", "block"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ModRegistry.ALLTHEMODIUM_NUGGET.get(), 9)
                .requires(TagRegistry.ALLTHEMODIUM_INGOT)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.ALLTHEMODIUM_INGOT.get()))
                .save(consumer, recipeDir("allthemodium_nugget", "ingot"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ModRegistry.VIBRANIUM_DUST.get(), 2)
                .requires(ModRegistry.RAW_VIBRANIUM.get())
                .requires(ATOTagRegistry.ORE_HAMMERS)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.RAW_VIBRANIUM.get()))
                .save(consumer, recipeDir("vibranium_dust", "ore_crushing"));


        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ModRegistry.UNOBTAINIUM_DUST.get(), 2)
                .requires(ModRegistry.RAW_UNOBTAINIUM.get())
                .requires(ATOTagRegistry.ORE_HAMMERS)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.RAW_UNOBTAINIUM.get()))
                .save(consumer, recipeDir("unobtainium_dust", "ore_crushing"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ModRegistry.VIBRANIUM_INGOT.get(), 9)
                .requires(TagRegistry.VIBRANIUM_BLOCK_ITEM)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.VIBRANIUM_BLOCK.get()))
                .save(consumer, recipeDir("vibranium_ingot", "block"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ModRegistry.VIBRANIUM_NUGGET.get(), 9)
                .requires(TagRegistry.VIBRANIUM_INGOT)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.VIBRANIUM_INGOT.get()))
                .save(consumer, recipeDir("vibranium_nugget", "ingot"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ModRegistry.UNOBTAINIUM_INGOT.get(), 9)
                .requires(TagRegistry.UNOBTAINIUM_BLOCK_ITEM)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.UNOBTAINIUM_BLOCK.get()))
                .save(consumer, recipeDir("unobtainium_ingot", "block"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ModRegistry.UNOBTAINIUM_NUGGET.get(), 9)
                .requires(TagRegistry.UNOBTAINIUM_INGOT)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.UNOBTAINIUM_INGOT.get()))
                .save(consumer, recipeDir("unobtainium_nugget", "ingot"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ModRegistry.RAW_ALLTHEMODIUM.get(), 9)
                .requires(TagRegistry.RAW_ALLTHEMODIUM_BLOCK)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.RAW_ALLTHEMODIUM_BLOCK.get()))
                .save(consumer, recipeDir("raw_allthemodium", "block"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ModRegistry.RAW_VIBRANIUM.get(), 9)
                .requires(TagRegistry.RAW_VIBRANIUM_BLOCK)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.RAW_VIBRANIUM_BLOCK.get()))
                .save(consumer, recipeDir("raw_vibranium", "block"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ModRegistry.RAW_UNOBTAINIUM.get(), 9)
                .requires(TagRegistry.RAW_UNOBTAINIUM_BLOCK)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.RAW_UNOBTAINIUM_BLOCK.get()))
                .save(consumer, recipeDir("raw_unobtainium", "block"));


        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ModRegistry.UNOBTAINIUM_ALLTHEMODIUM_ALLOY.get(), 9)
                .requires(TagRegistry.UNOBTAINIUM_ALLTHEMODIUM_BLOCK)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.UA_ALLOY.get()))
                .save(consumer, recipeDir("unobtainium_allthemodium_alloy_ingot", "block"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ModRegistry.UNOBTAINIUM_VIBRANIUM_ALLOY.get(), 9)
                .requires(TagRegistry.UNOBTAINIUM_VIBRANIUM_BLOCK)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.UV_ALLOY.get()))
                .save(consumer, recipeDir("unobtainium_vibranium_alloy_ingot", "block"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ModRegistry.VIBRANIUM_ALLTHEMODIUM_ALLOY.get(), 9)
                .requires(TagRegistry.VIBRANIUM_ALLTHEMODIUM_BLOCK)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.VA_ALLOY.get()))
                .save(consumer, recipeDir("vibranium_allthemodium_alloy_ingot", "block"));


    }


    protected void buildSmeltingRecipes(RecipeOutput consumer) {

        final String hasCondition = "has_item";

        SimpleCookingRecipeBuilder
                .smelting(Ingredient.of(ModRegistry.ANCIENT_STONE.get()), RecipeCategory.MISC, ModRegistry.ANCIENT_SMOOTH_STONE.get(), 0.15f, 200)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.ANCIENT_STONE.get()))
                .save(consumer, recipeDir("ancient_smooth_stone", "ancient_stone_smelting"));

        SimpleCookingRecipeBuilder
                .smelting(Ingredient.of(TagRegistry.RAW_ALLTHEMODIUM), RecipeCategory.MISC, ModRegistry.ALLTHEMODIUM_INGOT.get(), 0.15f, 200)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.RAW_ALLTHEMODIUM.get()))
                .save(consumer, recipeDir("allthemodium_ingot", "raw_smelting"));

        SimpleCookingRecipeBuilder
                .smelting(Ingredient.of(TagRegistry.RAW_VIBRANIUM), RecipeCategory.MISC, ModRegistry.VIBRANIUM_INGOT.get(), 0.15f, 200)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.RAW_VIBRANIUM.get()))
                .save(consumer, recipeDir("vibranium_ingot", "raw_smelting"));

        SimpleCookingRecipeBuilder
                .smelting(Ingredient.of(TagRegistry.RAW_UNOBTAINIUM), RecipeCategory.MISC, ModRegistry.UNOBTAINIUM_INGOT.get(), 0.15f, 200)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.RAW_UNOBTAINIUM.get()))
                .save(consumer, recipeDir("unobtainium_ingot", "raw_smelting"));

        SimpleCookingRecipeBuilder
                .smelting(Ingredient.of(TagRegistry.ALLTHEMODIUM_DUST), RecipeCategory.MISC, ModRegistry.ALLTHEMODIUM_INGOT.get(), 0.15f, 200)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.ALLTHEMODIUM_DUST.get()))
                .save(consumer, recipeDir("allthemodium_ingot", "dust_smelting"));

        SimpleCookingRecipeBuilder
                .smelting(Ingredient.of(TagRegistry.VIBRANIUM_DUST), RecipeCategory.MISC, ModRegistry.VIBRANIUM_INGOT.get(), 0.15f, 200)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.VIBRANIUM_DUST.get()))
                .save(consumer, recipeDir("vibranium_ingot", "dust_smelting"));

        SimpleCookingRecipeBuilder
                .smelting(Ingredient.of(TagRegistry.UNOBTAINIUM_DUST), RecipeCategory.MISC, ModRegistry.UNOBTAINIUM_INGOT.get(), 0.15f, 200)
                .unlockedBy(hasCondition, RecipeProvider.has(ModRegistry.UNOBTAINIUM_DUST.get()))
                .save(consumer, recipeDir("unobtainium_ingot", "dust_smelting"));

        SimpleCookingRecipeBuilder
                .smelting(Ingredient.of(TagRegistry.ALLTHEMODIUM_ORE_ITEM), RecipeCategory.MISC, ModRegistry.ALLTHEMODIUM_INGOT.get(), 0.15f, 200)
                .unlockedBy(hasCondition, has(TagRegistry.ALLTHEMODIUM_ORE_ITEM))
                .save(consumer, recipeDir("allthemodium_ingot", "ore_smelting"));

        SimpleCookingRecipeBuilder
                .smelting(Ingredient.of(TagRegistry.VIBRANIUM_ORE_ITEM), RecipeCategory.MISC, ModRegistry.VIBRANIUM_INGOT.get(), 0.15f, 200)
                .unlockedBy(hasCondition, has(TagRegistry.VIBRANIUM_ORE_ITEM))
                .save(consumer, recipeDir("vibranium_ingot", "ore_smelting"));

        SimpleCookingRecipeBuilder
                .smelting(Ingredient.of(TagRegistry.UNOBTAINIUM_ORE_ITEM), RecipeCategory.MISC, ModRegistry.UNOBTAINIUM_INGOT.get(), 0.15f, 200)
                .unlockedBy(hasCondition, has(TagRegistry.UNOBTAINIUM_ORE_ITEM))
                .save(consumer, recipeDir("unobtainium_ingot", "ore_smelting"));

    }
}
