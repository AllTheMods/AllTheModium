package com.thevortex.allthemodium.crafting;

import java.util.*;
import java.util.Map.Entry;


import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.crafting.IShapedRecipe;

public class 	ATMShapelessRecipe implements IATMShapelessRecipe {

	private final ShapelessRecipe recipe;

	public ATMShapelessRecipe(ShapelessRecipe recipe) {
		this.recipe = recipe;

	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ATMCraftingSetup.ATM_SHAPELESS_DATA.get();
	}

	@Override
	public boolean matches(CraftingContainer inv, Level world) {
		// Note: We do not override the matches method if it matches ignoring NBT,
		// to ensure that we return the proper value for if there is a match that gives
		// a proper output
		return recipe.matches(inv, world);
	}

	@Override
	public ItemStack assemble(CraftingContainer inv, RegistryAccess blah) {
		if (getResultItem(blah).isEmpty()) {
			return ItemStack.EMPTY;
		}
		ItemStack toReturn = getResultItem(blah).copy();

		Map<Enchantment,Integer> enchant = new HashMap<>();

		for (int i = 0; i < inv.getContainerSize(); i++) {
			ItemStack stack = inv.getItem(i);
			if (!stack.isEmpty() && (!stack.getEnchantmentTags().isEmpty())) {
				Map<Enchantment,Integer> temp = EnchantmentHelper.getEnchantments(stack);
				for(Enchantment e : temp.keySet()) {
					if(enchant.containsKey(e) && (enchant.get(e) == temp.get(e))) {	enchant.put(e, temp.get(e) + 1); }
					else { enchant.put(e,temp.get(e)); }
				}
			}
		}
		EnchantmentHelper.setEnchantments(enchant,toReturn);
		return toReturn;
	}
	public ShapelessRecipe getInternal() {
		return recipe;
	}
	@Override
	public NonNullList<ItemStack> getRemainingItems(CraftingContainer inv) {
		return recipe.getRemainingItems(inv);
	}

	@Override
	public ItemStack getToastSymbol() {	return recipe.getToastSymbol();	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		return recipe.getIngredients();
	}

	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return recipe.canCraftInDimensions(width, height);
	}

	@Override
	public ItemStack getResultItem(RegistryAccess blah) {
		return recipe.getResultItem(blah);
	}


	@Override
	public ResourceLocation getId() {
		return recipe.getId();
	}

	@Override
	public CraftingBookCategory category() {
		return CraftingBookCategory.MISC;
	}
}