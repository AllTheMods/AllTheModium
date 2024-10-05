package com.thevortex.allthemodium.datagen.server;

import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.ModRegistry;
import java.util.function.Consumer;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

public class BlastingRecipes extends RecipeProvider {

    public BlastingRecipes(DataGenerator generator) {
        super(generator);
    }

    private ResourceLocation recipeDir(String typeIn, String typeOut) {
        return new ResourceLocation(
                Reference.MOD_ID,
                typeIn + "_from_" + typeOut + "_blasting");
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        final String hasCondition = "has_item";

        SimpleCookingRecipeBuilder
                .blasting(
                        Ingredient.of(ModRegistry.ANCIENT_STONE_ITEM.get()),
                        ModRegistry.ANCIENT_SMOOTH_STONE_ITEM.get(),
                        0.15f,
                        200)
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.ANCIENT_STONE_ITEM.get()))
                .save(consumer, recipeDir("ancient_smooth_stone", "ancient_stone"));

        SimpleCookingRecipeBuilder
                .blasting(
                        Ingredient.of(ModRegistry.RAW_ALLTHEMODIUM.get()),
                        ModRegistry.ALLTHEMODIUM_INGOT.get(),
                        0.15f,
                        200)
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.RAW_ALLTHEMODIUM.get()))
                .save(consumer, recipeDir("allthemodium_ingot", "raw_blasting"));

        SimpleCookingRecipeBuilder
                .blasting(
                        Ingredient.of(ModRegistry.RAW_VIBRANIUM.get()),
                        ModRegistry.VIBRANIUM_INGOT.get(),
                        0.15f,
                        200)
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.RAW_VIBRANIUM.get()))
                .save(consumer, recipeDir("vibranium_ingot", "raw_blasting"));

        SimpleCookingRecipeBuilder
                .blasting(
                        Ingredient.of(ModRegistry.RAW_UNOBTAINIUM.get()),
                        ModRegistry.UNOBTAINIUM_INGOT.get(),
                        0.15f,
                        200)
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.RAW_UNOBTAINIUM.get()))
                .save(consumer, recipeDir("unobtainium_ingot", "raw_blasting"));

        SimpleCookingRecipeBuilder
                .blasting(
                        Ingredient.of(ModRegistry.ALLTHEMODIUM_DUST.get()),
                        ModRegistry.ALLTHEMODIUM_INGOT.get(),
                        0.15f,
                        200)
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.ALLTHEMODIUM_DUST.get()))
                .save(consumer, recipeDir("allthemodium_ingot", "dust_blasting"));

        SimpleCookingRecipeBuilder
                .blasting(
                        Ingredient.of(ModRegistry.VIBRANIUM_DUST.get()),
                        ModRegistry.VIBRANIUM_INGOT.get(),
                        0.15f,
                        200)
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.VIBRANIUM_DUST.get()))
                .save(consumer, recipeDir("vibranium_ingot", "dust_blasting"));

        SimpleCookingRecipeBuilder
                .blasting(
                        Ingredient.of(ModRegistry.UNOBTAINIUM_DUST.get()),
                        ModRegistry.UNOBTAINIUM_INGOT.get(),
                        0.15f,
                        200)
                .unlockedBy(
                        hasCondition,
                        RecipeProvider.has(ModRegistry.UNOBTAINIUM_DUST.get()))
                .save(consumer, recipeDir("unobtainium_ingot", "dust_blasting"));
    }
}
