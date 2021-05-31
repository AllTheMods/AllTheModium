package com.thevortex.allthemodium.items.toolitems.tools;

import com.thevortex.allthemodium.material.ItemTier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ShovelItem;

public class Allthemodium_Shovel extends ShovelItem {
	 protected final float efficiency = ItemTier.UNOBTAINIUMALLOY.getSpeed();
	   
	public Allthemodium_Shovel(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}
	
}
