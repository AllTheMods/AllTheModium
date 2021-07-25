package com.thevortex.allthemodium.crafting;

import com.google.gson.JsonObject;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class ATMRecipeSerializer extends ForgeRegistryEntry<RecipeSerializer<?>>
		implements RecipeSerializer<ATMShapedRecipe> {

	@Override
	public ATMShapedRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
		return new ATMShapedRecipe(RecipeSerializer.SHAPED_RECIPE.fromJson(recipeId, json));
	}



	@Override
	public ATMShapedRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
		try {
			return new ATMShapedRecipe(RecipeSerializer.SHAPED_RECIPE.fromNetwork(recipeId, buffer));
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void toNetwork(FriendlyByteBuf buffer, ATMShapedRecipe recipe) {
		try {
			RecipeSerializer.SHAPED_RECIPE.toNetwork(buffer, recipe.getInternal());
		} catch (Exception e) {
			throw e;
		}
	}
}
