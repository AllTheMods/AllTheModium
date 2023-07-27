package com.thevortex.allthemodium.crafting;

import com.google.gson.JsonObject;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapelessRecipe;

public class ATMShapelessRecipeSerializer implements RecipeSerializer<ATMShapelessRecipe> {

	@Override
	public ATMShapelessRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
		return new ATMShapelessRecipe(RecipeSerializer.SHAPELESS_RECIPE.fromJson(recipeId, json));
	}

	@Override
	public ATMShapelessRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
		try {
			return new ATMShapelessRecipe(RecipeSerializer.SHAPELESS_RECIPE.fromNetwork(recipeId, buffer));
		} catch (Exception e) {
			throw e;
		}
	}

	private void write(FriendlyByteBuf buffer, ShapelessRecipe recipe) {

		try {
			RecipeSerializer.SHAPELESS_RECIPE.toNetwork(buffer, recipe);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void toNetwork(FriendlyByteBuf buffer, ATMShapelessRecipe recipe) {
		try {
			RecipeSerializer.SHAPELESS_RECIPE.toNetwork(buffer, recipe.getInternal());
		} catch (Exception e) {
			throw e;
		}
	}
}

