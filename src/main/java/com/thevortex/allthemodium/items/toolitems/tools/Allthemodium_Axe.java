package com.thevortex.allthemodium.items.toolitems.tools;

import com.thevortex.allthemodium.material.ItemTier;

import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;

public class Allthemodium_Axe extends AxeItem {
	
	   protected final float efficiency = ItemTier.UNOBTAINIUMALLOY.getSpeed();
	   
	 public Allthemodium_Axe(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
		// TODO Auto-generated constructor stub
	}


}
