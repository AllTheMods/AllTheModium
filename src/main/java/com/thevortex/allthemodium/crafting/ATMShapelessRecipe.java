package com.thevortex.allthemodium.crafting;

import java.util.*;

import javax.annotation.ParametersAreNonnullByDefault;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapelessRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class 	ATMShapelessRecipe implements IATMShapelessRecipe {

	private final ShapelessRecipe recipe;

	public ATMShapelessRecipe(ShapelessRecipe recipe) {
		this.recipe = recipe;

	}

	@Override
	public IRecipeSerializer<?> getSerializer() {
		return ATMCraftingSetup.ATM_SHAPELESS_DATA.get();
	}

	@Override
	public boolean matches(CraftingInventory inv, World world) {
		// Note: We do not override the matches method if it matches ignoring NBT,
		// to ensure that we return the proper value for if there is a match that gives
		// a proper output
		return recipe.matches(inv, world) && !assemble(inv).isEmpty();
	}

	@Override
	public ItemStack assemble(CraftingInventory inv) {
		if (getResultItem().isEmpty()) {
			return ItemStack.EMPTY;
		}
		ItemStack toReturn = getResultItem().copy();

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

	@Override
	public NonNullList<ItemStack> getRemainingItems(CraftingInventory inv) {
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
	public ItemStack getResultItem() {
		return recipe.getResultItem();
	}

	@Override
	public ResourceLocation getId() {
		return recipe.getId();
	}

}