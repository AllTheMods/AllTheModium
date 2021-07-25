package com.thevortex.allthemodium.items.toolitems.tools;

import com.thevortex.allthemodium.init.ModItems;
import com.thevortex.allthemodium.material.ItemTier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class Allthemodium_Sword extends SwordItem {
	 protected final float efficiency = ItemTier.UNOBTAINIUMALLOY.getSpeed();
	   
	public Allthemodium_Sword(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}

}
