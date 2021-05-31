package com.thevortex.allthemodium.items.toolitems.tools;

import com.thevortex.allthemodium.material.ItemTier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.PickaxeItem;

public class Allthemodium_PickAxe extends PickaxeItem {
	 protected final float efficiency = ItemTier.UNOBTAINIUMALLOY.getSpeed();
	   
	public Allthemodium_PickAxe(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
		
	}
}
