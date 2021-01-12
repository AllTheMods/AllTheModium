package com.thevortex.allthemodium.crafting;

import com.thevortex.allthemodium.reference.Reference;

import net.minecraft.item.crafting.ICraftingRecipe;
import net.minecraft.util.ResourceLocation;

public interface IATMShapelessRecipe extends ICraftingRecipe {
ResourceLocation RECIPE_TYPE = new ResourceLocation(Reference.MOD_ID,"atmshapeless_crafting");
}
