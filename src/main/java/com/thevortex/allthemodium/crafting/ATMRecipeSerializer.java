package com.thevortex.allthemodium.crafting;

import com.google.gson.JsonObject;

import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class ATMRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>>
		implements IRecipeSerializer<ATMShapedRecipe> {

	@Override
	public ATMShapedRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
		return new ATMShapedRecipe(IRecipeSerializer.SHAPED_RECIPE.fromJson(recipeId, json));
	}

	@Override
	public ATMShapedRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
		try {
			return new ATMShapedRecipe(IRecipeSerializer.SHAPED_RECIPE.fromNetwork(recipeId, buffer));
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void toNetwork(PacketBuffer buffer, ATMShapedRecipe recipe) {
		try {
			IRecipeSerializer.SHAPED_RECIPE.toNetwork(buffer, recipe.getInternal());
		} catch (Exception e) {
			throw e;
		}
	}
}
