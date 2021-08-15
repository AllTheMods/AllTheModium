package com.thevortex.allthemodium.datagen.server;

import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.reference.TagRegistry;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.allthemods.alltheores.datagen.builder.ShapedBlockBuilder;
import net.minecraft.data.*;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class CraftingRecipes extends RecipeProvider {
    public CraftingRecipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    private ShapedRecipeBuilder shaped(ItemLike provider) {
        return ShapedRecipeBuilder.shaped(provider)
            .group(Reference.MOD_ID);
    }


    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

        shaped(ModRegistry.ALLTHEMODIUM_PICKAXE.get())
            .pattern("ara")
            .pattern(" r ")
            .pattern(" r ")
            .define('r', TagRegistry.ALLTHEMODIUM_ROD)
            .define('a', TagRegistry.ALLTHEMODIUM_PLATE)
            .unlockedBy("has_allthemodium_rod", has(TagRegistry.ALLTHEMODIUM_ROD))
            .save(consumer);

        shaped(ModRegistry.VIBRANIUM_PICKAXE.get())
                .pattern("ara")
                .pattern(" r ")
                .pattern(" r ")
                .define('r', TagRegistry.VIBRANIUM_ROD)
                .define('a', TagRegistry.VIBRANIUM_PLATE)
                .unlockedBy("has_vibranium_rod", has(TagRegistry.VIBRANIUM_ROD))
                .save(consumer);

        shaped(ModRegistry.UNOBTAINIUM_PICKAXE.get())
                .pattern("ara")
                .pattern(" r ")
                .pattern(" r ")
                .define('r', TagRegistry.UNOBTAINIUM_ROD)
                .define('a', TagRegistry.UNOBTAINIUM_PLATE)
                .unlockedBy("has_unobtainium_rod", has(TagRegistry.UNOBTAINIUM_ROD))
                .save(consumer);

        final String hasCondition = "has_item";

        ShapedBlockBuilder.builder(TagRegistry.ALLTHEMODIUM_INGOT)
                .setBlock(ModRegistry.ALLTHEMODIUM_BLOCK_ITEM)
                .setGear(ModRegistry.ATM_GEAR)
                .setPlate(ModRegistry.ATM_PLATE)
                .setRod(ModRegistry.ATM_ROD)
                .build(consumer);

        ShapedBlockBuilder.builder(TagRegistry.VIBRANIUM_INGOT)
                .setBlock(ModRegistry.VIBRANIUM_BLOCK_ITEM)
                .setGear(ModRegistry.VIB_GEAR)
                .setPlate(ModRegistry.VIB_PLATE)
                .setRod(ModRegistry.VIB_ROD)
                .build(consumer);

        ShapedBlockBuilder.builder(TagRegistry.UNOBTAINIUM_INGOT)
                .setBlock(ModRegistry.UNOBTAINIUM_BLOCK_ITEM)
                .setGear(ModRegistry.ONOB_GEAR)
                .setPlate(ModRegistry.ONOB_PLATE)
                .setRod(ModRegistry.ONOB_ROD)
                .build(consumer);

     /*
        ShapedIngotBuilder.builder(ItemTagRegistry.ALUMINUM_NUGGET)
                .setIngot(BlockList.ALUMINUM_INGOT)
                .build(consumer);

      */


    }
}
