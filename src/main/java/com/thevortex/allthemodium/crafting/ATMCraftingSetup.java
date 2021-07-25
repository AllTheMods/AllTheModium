package com.thevortex.allthemodium.crafting;

import com.thevortex.allthemodium.reference.Reference;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class ATMCraftingSetup {

	public static final RecipeSerializer<ATMShapedRecipe> SERIALIZER = new ATMRecipeSerializer();
	public static final RecipeSerializer<ATMShapelessRecipe> SERIALIZER_SHAPELESS = new ATMShapelessRecipeSerializer();
	
	public static final RecipeType<ATMShapedRecipe> ATMRECIPE_TYPE = registerType(IATMShapedRecipe.RECIPE_TYPE);
	public static final RecipeType<ATMShapelessRecipe> ATMSHAPELESSRECIPE_TYPE = registerType(IATMShapelessRecipe.RECIPE_TYPE);
	
	public static final DeferredRegister<RecipeSerializer<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Reference.MOD_ID);
	public static final RegistryObject<RecipeSerializer<?>> ATM_DATA = REGISTRY.register("atmshaped_crafting", () -> SERIALIZER);
	public static final RegistryObject<RecipeSerializer<?>> ATM_SHAPELESS_DATA = REGISTRY.register("atmshapeless_crafting", () -> SERIALIZER_SHAPELESS);
	
	private static class RecType<T extends Recipe<?>> implements RecipeType<T> {
		@Override
		public String toString(){
			return Registry.RECIPE_TYPE.getKey(this).toString();
		}
	}

	
	private static <T extends RecType>T registerType(ResourceLocation recipeType) {
		
		return (T) Registry.register(Registry.RECIPE_TYPE, recipeType, new RecType());
	}
}
