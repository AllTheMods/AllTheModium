package com.thevortex.allthemodium.items.toolitems.tools;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.thevortex.allthemodium.AllTheModium;
import com.thevortex.allthemodium.material.ItemTier;

import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class Allthemodium_PickAxe extends PickaxeItem {
	 protected final float efficiency = ItemTier.UNOBTAINIUMALLOY.getSpeed();
	   
	public Allthemodium_PickAxe(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
		
	}
}
