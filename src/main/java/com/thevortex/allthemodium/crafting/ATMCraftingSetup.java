package com.thevortex.allthemodium.crafting;

import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ATMCraftingSetup {

    public static final RecipeSerializer<ATMShapedRecipe> SERIALIZER = new ATMRecipeSerializer();
    public static final RecipeSerializer<ATMShapelessRecipe> SERIALIZER_SHAPELESS = new ATMShapelessRecipeSerializer();

    public static final DeferredRegister<RecipeSerializer<?>> REGISTRY = DeferredRegister.create(
            ForgeRegistries.RECIPE_SERIALIZERS,
            Reference.MOD_ID);
    public static final RegistryObject<RecipeSerializer<?>> ATM_DATA = REGISTRY.register("atmshaped_crafting",
            () -> SERIALIZER);
    public static final RegistryObject<RecipeSerializer<?>> ATM_SHAPELESS_DATA = REGISTRY
            .register("atmshapeless_crafting", () -> SERIALIZER_SHAPELESS);
}
