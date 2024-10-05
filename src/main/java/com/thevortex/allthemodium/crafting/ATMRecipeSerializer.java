package com.thevortex.allthemodium.crafting;

import com.google.gson.JsonObject;
import javax.annotation.Nonnull;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class ATMRecipeSerializer implements RecipeSerializer<ATMShapedRecipe> {

    @Override
    public ATMShapedRecipe fromJson(
            @Nonnull ResourceLocation recipeId,
            @Nonnull JsonObject json) {
        return new ATMShapedRecipe(
                RecipeSerializer.SHAPED_RECIPE.fromJson(recipeId, json));
    }

    @Override
    public ATMShapedRecipe fromNetwork(
            @Nonnull ResourceLocation recipeId,
            @Nonnull FriendlyByteBuf buffer) {
        try {
            return new ATMShapedRecipe(
                    RecipeSerializer.SHAPED_RECIPE.fromNetwork(recipeId, buffer));
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void toNetwork(
            @Nonnull FriendlyByteBuf buffer,
            @Nonnull ATMShapedRecipe recipe) {
        try {
            RecipeSerializer.SHAPED_RECIPE.toNetwork(
                    buffer,
                    recipe.getInternal());
        } catch (Exception e) {
            throw e;
        }
    }
}
