package com.thevortex.allthemodium.crafting;

import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.CraftingRecipe;

public interface IATMShapelessRecipe extends CraftingRecipe {
    ResourceLocation RECIPE_TYPE = new ResourceLocation(
            Reference.MOD_ID,
            "atmshapeless_crafting");
}
