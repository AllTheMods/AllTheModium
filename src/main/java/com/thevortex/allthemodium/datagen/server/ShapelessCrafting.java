package com.thevortex.allthemodium.datagen.server;

import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.ModRegistry;
import com.thevortex.allthemodium.registry.TagRegistry;
import java.util.function.Consumer;
import net.allthemods.alltheores.infos.ItemTagRegistry;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.*;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

public class ShapelessCrafting extends RecipeProvider {

    private ResourceLocation recipeDir(String typeIn, String typeOut) {
        return new ResourceLocation(
                Reference.MOD_ID,
                typeIn + "_from_" + typeOut);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        final String hasCondition = "has_item";

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.DEMONIC_PLANKS.get(), 4)
                .requires(ModRegistry.DEMONIC_LOG_ITEM.get())
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.DEMONIC_LOG_ITEM.get()))
                .save(consumer, recipeDir("demonic_planks", "shapelesscrafting"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.SOUL_PLANKS.get(), 4)
                .requires(ModRegistry.SOUL_LOG_ITEM.get())
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.SOUL_LOG_ITEM.get()))
                .save(consumer, recipeDir("soul_planks", "shapelesscrafting"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.SOUL_PLANKS.get(), 4)
                .requires(ModRegistry.SOUL_LOG_0_ITEM.get())
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.SOUL_LOG_0_ITEM.get()))
                .save(consumer, recipeDir("soul_planks_0", "shapelesscrafting"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.SOUL_PLANKS.get(), 4)
                .requires(ModRegistry.SOUL_LOG_1_ITEM.get())
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.SOUL_LOG_1_ITEM.get()))
                .save(consumer, recipeDir("soul_planks_1", "shapelesscrafting"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.SOUL_PLANKS.get(), 4)
                .requires(ModRegistry.SOUL_LOG_2_ITEM.get())
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.SOUL_LOG_2_ITEM.get()))
                .save(consumer, recipeDir("soul_planks_2", "shapelesscrafting"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.ANCIENT_PLANKS.get(), 4)
                .requires(ModRegistry.ANCIENT_LOG_0_ITEM.get())
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.ANCIENT_LOG_0_ITEM.get()))
                .save(consumer, recipeDir("ancient_planks", "shapelesscrafting"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.ANCIENT_PLANKS.get(), 4)
                .requires(ModRegistry.ANCIENT_LOG_1_ITEM.get())
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.ANCIENT_LOG_1_ITEM.get()))
                .save(consumer, recipeDir("ancient_planks_1", "shapelesscrafting"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.ANCIENT_PLANKS.get(), 4)
                .requires(ModRegistry.ANCIENT_LOG_2_ITEM.get())
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.ANCIENT_LOG_2_ITEM.get()))
                .save(consumer, recipeDir("ancient_planks_2", "shapelesscrafting"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.ANCIENT_PLANKS.get(), 4)
                .requires(ModRegistry.ANCIENT_LOG_STRIPPED_ITEM.get())
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.ANCIENT_LOG_STRIPPED_ITEM.get()))
                .save(consumer, recipeDir("ancient_planks_3", "shapelesscrafting"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.ANCIENT_MOSSY_STONE_ITEM.get(), 1)
                .requires(ModRegistry.ANCIENT_STONE_ITEM.get())
                .requires(Items.VINE)
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.ANCIENT_STONE_ITEM.get()))
                .save(consumer, recipeDir("ancient_mossy_stone", "vinecrafting"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.ANCIENT_POLISHED_STONE_ITEM.get(), 1)
                .requires(ModRegistry.ANCIENT_SMOOTH_STONE_ITEM.get())
                .requires(Items.HONEYCOMB)
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.ANCIENT_SMOOTH_STONE_ITEM.get()))
                .save(consumer, recipeDir("ancient_polished_stone", "waxing"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.ANCIENT_CRACKED_STONE_BRICKS_ITEM.get(), 1)
                .requires(TagRegistry.ANCIENT_STONE_BRICKS_ITEM)
                .requires(ItemTagRegistry.ORE_HAMMERS)
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.inventoryTrigger(
                                ItemPredicate.Builder
                                        .item()
                                        .of(TagRegistry.ANCIENT_STONE_BRICKS_ITEM)
                                        .build()))
                .save(
                        consumer,
                        recipeDir("ancient_cracked_stone_bricks", "crushing"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.ANCIENT_CHISELED_STONE_BRICKS_ITEM.get(), 1)
                .requires(TagRegistry.ANCIENT_CRACKED_STONE_BRICKS_ITEM)
                .requires(ItemTagRegistry.ORE_HAMMERS)
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.inventoryTrigger(
                                ItemPredicate.Builder
                                        .item()
                                        .of(TagRegistry.ANCIENT_CRACKED_STONE_BRICKS_ITEM)
                                        .build()))
                .save(
                        consumer,
                        recipeDir("ancient_chiseled_stone_bricks", "crushing"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.ALLTHEMODIUM_DUST.get(), 2)
                .requires(ModRegistry.RAW_ALLTHEMODIUM.get())
                .requires(ItemTagRegistry.ORE_HAMMERS)
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.RAW_ALLTHEMODIUM.get()))
                .save(consumer, recipeDir("allthemodium_dust", "ore_crushing"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.ALLTHEMODIUM_INGOT.get(), 9)
                .requires(TagRegistry.ALLTHEMODIUM_BLOCK_ITEM)
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.ALLTHEMODIUM_BLOCK_ITEM.get()))
                .save(consumer, recipeDir("allthemodium_ingot", "block"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.ALLTHEMODIUM_NUGGET.get(), 9)
                .requires(TagRegistry.ALLTHEMODIUM_INGOT)
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.ALLTHEMODIUM_INGOT.get()))
                .save(consumer, recipeDir("allthemodium_nugget", "ingot"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.VIBRANIUM_DUST.get(), 2)
                .requires(ModRegistry.RAW_VIBRANIUM.get())
                .requires(ItemTagRegistry.ORE_HAMMERS)
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.RAW_VIBRANIUM.get()))
                .save(consumer, recipeDir("vibranium_dust", "ore_crushing"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.UNOBTAINIUM_DUST.get(), 2)
                .requires(ModRegistry.RAW_UNOBTAINIUM.get())
                .requires(ItemTagRegistry.ORE_HAMMERS)
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.RAW_UNOBTAINIUM.get()))
                .save(consumer, recipeDir("unobtainium_dust", "ore_crushing"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.VIBRANIUM_INGOT.get(), 9)
                .requires(TagRegistry.VIBRANIUM_BLOCK_ITEM)
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.VIBRANIUM_BLOCK_ITEM.get()))
                .save(consumer, recipeDir("vibranium_ingot", "block"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.VIBRANIUM_NUGGET.get(), 9)
                .requires(TagRegistry.VIBRANIUM_INGOT)
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.VIBRANIUM_INGOT.get()))
                .save(consumer, recipeDir("vibranium_nugget", "ingot"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.UNOBTAINIUM_INGOT.get(), 9)
                .requires(TagRegistry.UNOBTAINIUM_BLOCK_ITEM)
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.UNOBTAINIUM_BLOCK_ITEM.get()))
                .save(consumer, recipeDir("unobtainium_ingot", "block"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.UNOBTAINIUM_NUGGET.get(), 9)
                .requires(TagRegistry.UNOBTAINIUM_INGOT)
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.UNOBTAINIUM_INGOT.get()))
                .save(consumer, recipeDir("unobtainium_nugget", "ingot"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.RAW_ALLTHEMODIUM.get(), 9)
                .requires(TagRegistry.RAW_ALLTHEMODIUM_BLOCK)
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(
                                ModRegistry.RAW_ALLTHEMODIUM_BLOCK_ITEM.get()))
                .save(consumer, recipeDir("raw_allthemodium", "block"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.RAW_VIBRANIUM.get(), 9)
                .requires(TagRegistry.RAW_VIBRANIUM_BLOCK)
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.RAW_VIBRANIUM_BLOCK_ITEM.get()))
                .save(consumer, recipeDir("raw_vibranium", "block"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.RAW_UNOBTAINIUM.get(), 9)
                .requires(TagRegistry.RAW_UNOBTAINIUM_BLOCK)
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.RAW_UNOBTAINIUM_BLOCK_ITEM.get()))
                .save(consumer, recipeDir("raw_unobtainium", "block"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.UNOBTAINIUM_ALLTHEMODIUM_ALLOY.get(), 9)
                .requires(TagRegistry.UNOBTAINIUM_ALLTHEMODIUM_BLOCK)
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.UA_ALLOY_ITEM.get()))
                .save(
                        consumer,
                        recipeDir("unobtainium_allthemodium_alloy_ingot", "block"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.UNOBTAINIUM_VIBRANIUM_ALLOY.get(), 9)
                .requires(TagRegistry.UNOBTAINIUM_VIBRANIUM_BLOCK)
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.UV_ALLOY_ITEM.get()))
                .save(
                        consumer,
                        recipeDir("unobtainium_vibranium_alloy_ingot", "block"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.VIBRANIUM_ALLTHEMODIUM_ALLOY.get(), 9)
                .requires(TagRegistry.VIBRANIUM_ALLTHEMODIUM_BLOCK)
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.VA_ALLOY_ITEM.get()))
                .save(
                        consumer,
                        recipeDir("vibranium_allthemodium_alloy_ingot", "block"));
    }

    public ShapelessCrafting(DataGenerator generatorIn) {
        super(generatorIn);
    }
}
