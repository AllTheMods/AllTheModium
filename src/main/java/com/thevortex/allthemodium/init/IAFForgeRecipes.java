package com.thevortex.allthemodium.init;

import com.github.alexthe666.iceandfire.block.BlockGoldPile;
import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import com.github.alexthe666.iceandfire.recipe.DragonForgeRecipe;
import com.github.alexthe666.iceandfire.recipe.IafRecipeRegistry;
import com.thevortex.allthemodium.AllTheModium;
import com.thevortex.allthemodium.fluids.FluidList;
import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class IAFForgeRecipes {






    public static void init() {

/*

        IafRecipeRegistry.FIRE_FORGE_RECIPES.add(new DragonForgeRecipe(new ItemStack(ModItems.VIBRANIUM_INGOT), new ItemStack(ModItems.ALLTHEMODIUM_INGOT), new ItemStack(ModItems.VIBRANIUM_ALLTHEMODIUM_ALLOY)));
        IafRecipeRegistry.FIRE_FORGE_RECIPES.add(new DragonForgeRecipe(new ItemStack(ModItems.VIBRANIUM_DUST), new ItemStack(ModItems.ALLTHEMODIUM_DUST), new ItemStack(ModItems.VIBRANIUM_ALLTHEMODIUM_ALLOY)));
        IafRecipeRegistry.FIRE_FORGE_RECIPES.add(new DragonForgeRecipe(new ItemStack(ModItems.VIBRANIUM_BLOCK), new ItemStack(ModItems.ALLTHEMODIUM_BLOCK), new ItemStack(FluidList.VA_ALLOY_ITEM.get())));

        IafRecipeRegistry.LIGHTNING_FORGE_RECIPES.add(new DragonForgeRecipe(new ItemStack(ModItems.UNOBTAINIUM_INGOT), new ItemStack(ModItems.ALLTHEMODIUM_INGOT), new ItemStack(ModItems.UNOBTAINIUM_ALLTHEMODIUM_ALLOY)));
        IafRecipeRegistry.LIGHTNING_FORGE_RECIPES.add(new DragonForgeRecipe(new ItemStack(ModItems.UNOBTAINIUM_DUST), new ItemStack(ModItems.ALLTHEMODIUM_DUST), new ItemStack(ModItems.UNOBTAINIUM_ALLTHEMODIUM_ALLOY)));
        IafRecipeRegistry.LIGHTNING_FORGE_RECIPES.add(new DragonForgeRecipe(new ItemStack(ModItems.UNOBTAINIUM_BLOCK), new ItemStack(ModItems.ALLTHEMODIUM_BLOCK), new ItemStack(FluidList.UA_ALLOY_ITEM.get())));

        IafRecipeRegistry.ICE_FORGE_RECIPES.add(new DragonForgeRecipe(new ItemStack(ModItems.VIBRANIUM_INGOT), new ItemStack(ModItems.UNOBTAINIUM_INGOT), new ItemStack(ModItems.UNOBTAINIUM_VIBRANIUM_ALLOY)));
        IafRecipeRegistry.ICE_FORGE_RECIPES.add(new DragonForgeRecipe(new ItemStack(ModItems.VIBRANIUM_DUST), new ItemStack(ModItems.UNOBTAINIUM_DUST), new ItemStack(ModItems.UNOBTAINIUM_VIBRANIUM_ALLOY)));
        IafRecipeRegistry.ICE_FORGE_RECIPES.add(new DragonForgeRecipe(new ItemStack(ModItems.VIBRANIUM_BLOCK), new ItemStack(ModItems.UNOBTAINIUM_BLOCK), new ItemStack(FluidList.UV_ALLOY_ITEM.get())));
  */
    }
    public static void regIaFItems(RegistryEvent.Register<Item> event){

            event.getRegistry().register(GoldPiles.ALLTHEMODIUM_PILE.asItem());
            event.getRegistry().register(GoldPiles.VIBRANIUM_PILE.asItem());
            event.getRegistry().register(GoldPiles.UNOBTAINIUM_PILE.asItem());

    }
}
