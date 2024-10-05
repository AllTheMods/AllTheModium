package com.thevortex.allthemodium.crafting;

import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.CraftingRecipe;

public interface IATMShapedRecipe extends CraftingRecipe {
    ResourceLocation RECIPE_TYPE = new ResourceLocation(
            Reference.MOD_ID,
            "atmshaped_crafting");
}
