package com.thevortex.allthemodium.init;

import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import com.github.alexthe666.iceandfire.recipe.DragonForgeRecipe;
import com.github.alexthe666.iceandfire.recipe.IafRecipeRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
public class IAFForgeRecipes {

    public static void init() {

        IafRecipeRegistry.FIRE_FORGE_RECIPES.add(new DragonForgeRecipe(new ItemStack(ModItems.VIBRANIUM_INGOT), new ItemStack(ModItems.ALLTHEMODIUM_INGOT), new ItemStack(ModItems.VIBRANIUM_ALLTHEMODIUM_ALLOY)));
        IafRecipeRegistry.FIRE_FORGE_RECIPES.add(new DragonForgeRecipe(new ItemStack(ModItems.VIBRANIUM_DUST), new ItemStack(ModItems.ALLTHEMODIUM_DUST), new ItemStack(ModItems.VIBRANIUM_ALLTHEMODIUM_ALLOY)));
        IafRecipeRegistry.LIGHTNING_FORGE_RECIPES.add(new DragonForgeRecipe(new ItemStack(ModItems.UNOBTAINIUM_INGOT), new ItemStack(ModItems.ALLTHEMODIUM_INGOT), new ItemStack(ModItems.UNOBTAINIUM_ALLTHEMODIUM_ALLOY)));
        IafRecipeRegistry.LIGHTNING_FORGE_RECIPES.add(new DragonForgeRecipe(new ItemStack(ModItems.UNOBTAINIUM_DUST), new ItemStack(ModItems.ALLTHEMODIUM_DUST), new ItemStack(ModItems.UNOBTAINIUM_ALLTHEMODIUM_ALLOY)));
        IafRecipeRegistry.ICE_FORGE_RECIPES.add(new DragonForgeRecipe(new ItemStack(ModItems.VIBRANIUM_INGOT), new ItemStack(ModItems.UNOBTAINIUM_INGOT), new ItemStack(ModItems.UNOBTAINIUM_VIBRANIUM_ALLOY)));
        IafRecipeRegistry.ICE_FORGE_RECIPES.add(new DragonForgeRecipe(new ItemStack(ModItems.VIBRANIUM_DUST), new ItemStack(ModItems.UNOBTAINIUM_DUST), new ItemStack(ModItems.UNOBTAINIUM_VIBRANIUM_ALLOY)));
    }
}
