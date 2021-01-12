package com.thevortex.allthemodium.crafting;

import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import javax.annotation.ParametersAreNonnullByDefault;

import com.thevortex.allthemodium.AllTheModium;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.INBTType;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import org.codehaus.plexus.util.CachedMap;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ATMShapedRecipe implements IATMShapedRecipe {

	private final ShapedRecipe internal;

	public ATMShapedRecipe(ShapedRecipe internal) {
		this.internal = internal;
	}

	public ShapedRecipe getInternal() {
		return internal;
	}

	@Override
	public IRecipeSerializer<?> getSerializer() {
		return ATMCraftingSetup.ATM_DATA.get();
	}

	@Override
	public boolean matches(CraftingInventory inv, World world) {
		// Note: We do not override the matches method if it matches ignoring NBT,
		// to ensure that we return the proper value for if there is a match that gives
		// a proper output
		return internal.matches(inv, world) && !getCraftingResult(inv).isEmpty();
	}

	@Override
	public ItemStack getCraftingResult(CraftingInventory inv) {
		if (getRecipeOutput().isEmpty()) {
			return ItemStack.EMPTY;
		}
		ItemStack toReturn = getRecipeOutput().copy();
		Map<Enchantment,Integer> enchant = new HashMap<>();

		for (int i = 0; i < inv.getSizeInventory(); i++) {
			ItemStack stack = inv.getStackInSlot(i);
			if (!stack.isEmpty() && (!stack.getEnchantmentTagList().isEmpty())) {
					Map<Enchantment,Integer> temp = EnchantmentHelper.getEnchantments(stack);
					for(Enchantment e : temp.keySet()) {
						if(enchant.containsKey(e) && (enchant.get(e) == temp.get(e))) {	enchant.put(e, temp.get(e) + 1); }
						if(enchant.containsKey(e) && (enchant.get(e) < temp.get(e))) {	enchant.put(e, temp.get(e)); }
						if(enchant.containsKey(e) && (enchant.get(e) > temp.get(e))) { break; }
						else { enchant.put(e,temp.get(e)); }
					}
				}
		}
		EnchantmentHelper.setEnchantments(enchant,toReturn);
		return toReturn;
	}

	@Override
	public boolean canFit(int width, int height) {
		return internal.canFit(width, height);
	}

	@Override
	public ItemStack getRecipeOutput() {
		return internal.getRecipeOutput();
	}

	@Override
	public NonNullList<ItemStack> getRemainingItems(CraftingInventory inv) {
		return internal.getRemainingItems(inv);
	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		return internal.getIngredients();
	}

	@Override
	public boolean isDynamic() {
		return internal.isDynamic();
	}

	@Override
	public String getGroup() {
		return internal.getGroup();
	}

	@Override
	public ItemStack getIcon() {
		return internal.getIcon();
	}

	@Override
	public ResourceLocation getId() {
		return internal.getId();
	}

}