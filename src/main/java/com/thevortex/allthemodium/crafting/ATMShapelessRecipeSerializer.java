package com.thevortex.allthemodium.crafting;

import com.google.gson.JsonObject;

import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.ShapelessRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class ATMShapelessRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>>
		implements IRecipeSerializer<ATMShapelessRecipe> {

	@Override
	public ATMShapelessRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
		return new ATMShapelessRecipe(IRecipeSerializer.SHAPELESS_RECIPE.fromJson(recipeId, json));
	}

	@Override
	public ATMShapelessRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
		try {
			return new ATMShapelessRecipe(IRecipeSerializer.SHAPELESS_RECIPE.fromNetwork(recipeId, buffer));
		} catch (Exception e) {
			throw e;
		}
	}

	private void write(PacketBuffer buffer,ShapelessRecipe recipe) {
		
			try {
				IRecipeSerializer.SHAPELESS_RECIPE.toNetwork(buffer, recipe);
			} catch (Exception e) {
				throw e;
			}
		}

	@Override
	public void toNetwork(PacketBuffer buffer, ATMShapelessRecipe recipe) {
		ShapelessRecipe recip = new ShapelessRecipe(recipe.getId(),recipe.getGroup(),recipe.getResultItem(),recipe.getIngredients());
		write(buffer,recip);
		
	}
		
	}

