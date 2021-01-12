package com.thevortex.allthemodium.crafting;

import com.google.gson.JsonObject;

import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class ATMRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>>
		implements IRecipeSerializer<ATMShapedRecipe> {

	@Override
	public ATMShapedRecipe read(ResourceLocation recipeId, JsonObject json) {
		return new ATMShapedRecipe(IRecipeSerializer.CRAFTING_SHAPED.read(recipeId, json));
	}

	@Override
	public ATMShapedRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
		try {
			return new ATMShapedRecipe(IRecipeSerializer.CRAFTING_SHAPED.read(recipeId, buffer));
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void write(PacketBuffer buffer, ATMShapedRecipe recipe) {
		try {
			IRecipeSerializer.CRAFTING_SHAPED.write(buffer, recipe.getInternal());
		} catch (Exception e) {
			throw e;
		}
	}
}
