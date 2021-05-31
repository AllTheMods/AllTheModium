package com.thevortex.allthemodium.items.toolitems.tools;

import com.thevortex.allthemodium.material.ItemTier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.SwordItem;

public class Allthemodium_Sword extends SwordItem {
	 protected final float efficiency = ItemTier.UNOBTAINIUMALLOY.getSpeed();
	   
	public Allthemodium_Sword(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}

}
