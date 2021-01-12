package com.thevortex.allthemodium.items.toolitems.tools;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.thevortex.allthemodium.AllTheModium;
import com.thevortex.allthemodium.material.ItemTier;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolItem;
import net.minecraft.util.ActionResultType;

public class Allthemodium_PickAxe extends PickaxeItem {
	 protected final float efficiency = ItemTier.UNOBTAINIUMALLOY.getEfficiency();
	   
	public Allthemodium_PickAxe(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
		
	}
}
