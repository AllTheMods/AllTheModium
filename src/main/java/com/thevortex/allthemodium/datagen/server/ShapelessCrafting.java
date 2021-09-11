package com.thevortex.allthemodium.datagen.server;

import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.reference.TagRegistry;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.allthemods.alltheores.blocks.BlockList;
import net.allthemods.alltheores.infos.ItemTagRegistry;
import net.minecraft.data.*;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;

import java.io.IOException;
import java.nio.file.Path;
import java.util.function.Consumer;

public class ShapelessCrafting extends RecipeProvider {

private ResourceLocation recipeDir(String typeIn, String typeOut) {
    return new ResourceLocation(Reference.MOD_ID,typeIn + "_from_" + typeOut);
}
    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

        final String hasCondition = "has_item";

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.ALLTHEMODIUM_DUST.get(),2)
                .requires(ModRegistry.RAW_ALLTHEMODIUM.get())
                .requires(ItemTagRegistry.ORE_HAMMERS)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.RAW_ALLTHEMODIUM.get()))
                .save(consumer,recipeDir("allthemodium_dust","ore_crushing"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.ALLTHEMODIUM_INGOT.get(),9)
                .requires(TagRegistry.ALLTHEMODIUM_BLOCK_ITEM)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.ALLTHEMODIUM_BLOCK_ITEM.get()))
                .save(consumer,recipeDir("allthemodium_ingot","block"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.ALLTHEMODIUM_NUGGET.get(),9)
                .requires(TagRegistry.ALLTHEMODIUM_INGOT)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.ALLTHEMODIUM_INGOT.get()))
                .save(consumer,recipeDir("allthemodium_nugget","ingot"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.VIBRANIUM_DUST.get(),2)
                .requires(ModRegistry.RAW_VIBRANIUM.get())
                .requires(ItemTagRegistry.ORE_HAMMERS)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.RAW_VIBRANIUM.get()))
                .save(consumer,recipeDir("vibranium_dust","ore_crushing"));


        ShapelessRecipeBuilder
                .shapeless(ModRegistry.UNOBTAINIUM_DUST.get(),2)
                .requires(ModRegistry.RAW_UNOBTAINIUM.get())
                .requires(ItemTagRegistry.ORE_HAMMERS)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.RAW_UNOBTAINIUM.get()))
                .save(consumer,recipeDir("unobtainium_dust","ore_crushing"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.VIBRANIUM_INGOT.get(),9)
                .requires(TagRegistry.VIBRANIUM_BLOCK_ITEM)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.VIBRANIUM_BLOCK_ITEM.get()))
                .save(consumer,recipeDir("vibranium_ingot","block"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.VIBRANIUM_NUGGET.get(),9)
                .requires(TagRegistry.VIBRANIUM_INGOT)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.VIBRANIUM_INGOT.get()))
                .save(consumer,recipeDir("vibranium_nugget","ingot"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.UNOBTAINIUM_INGOT.get(),9)
                .requires(TagRegistry.UNOBTAINIUM_BLOCK_ITEM)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.UNOBTAINIUM_BLOCK_ITEM.get()))
                .save(consumer,recipeDir("unobtainium_ingot","block"));

        ShapelessRecipeBuilder
                .shapeless(ModRegistry.UNOBTAINIUM_NUGGET.get(),9)
                .requires(TagRegistry.UNOBTAINIUM_INGOT)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.UNOBTAINIUM_INGOT.get()))
                .save(consumer,recipeDir("unobtainium_nugget","ingot"));
    }

    public ShapelessCrafting(DataGenerator generatorIn) {
        super(generatorIn);
    }
}
