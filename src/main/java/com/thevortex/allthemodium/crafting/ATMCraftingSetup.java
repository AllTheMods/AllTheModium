package com.thevortex.allthemodium.crafting;

import com.thevortex.allthemodium.reference.Reference;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class ATMCraftingSetup {

	public static final IRecipeSerializer<ATMShapedRecipe> SERIALIZER = new ATMRecipeSerializer();
	public static final IRecipeSerializer<ATMShapelessRecipe> SERIALIZER_SHAPELESS = new ATMShapelessRecipeSerializer();
	
	public static final IRecipeType<ATMShapedRecipe> ATMRECIPE_TYPE = registerType(IATMShapedRecipe.RECIPE_TYPE);
	public static final IRecipeType<ATMShapelessRecipe> ATMSHAPELESSRECIPE_TYPE = registerType(IATMShapelessRecipe.RECIPE_TYPE);
	
	public static final DeferredRegister<IRecipeSerializer<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Reference.MOD_ID);
	public static final RegistryObject<IRecipeSerializer<?>> ATM_DATA = REGISTRY.register("atmshaped_crafting", () -> SERIALIZER);
	public static final RegistryObject<IRecipeSerializer<?>> ATM_SHAPELESS_DATA = REGISTRY.register("atmshapeless_crafting", () -> SERIALIZER_SHAPELESS);
	
	private static class RecipeType<T extends IRecipe<?>> implements IRecipeType<T> {
		@Override
		public String toString(){
			return Registry.RECIPE_TYPE.getKey(this).toString();
		}
	}
	
	
	private static <T extends IRecipeType>T registerType(ResourceLocation recipeType) {
		
		return (T) Registry.register(Registry.RECIPE_TYPE, recipeType, new RecipeType());
	}
}
