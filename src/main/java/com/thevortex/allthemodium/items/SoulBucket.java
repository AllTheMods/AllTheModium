package com.thevortex.allthemodium.items;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.material.Fluid;

import java.util.function.Supplier;

public class SoulBucket extends BucketItem {
	
	

	public SoulBucket(Supplier<? extends Fluid> supplier, Properties builder) {
		super((Fluid) supplier, builder);
	}


	@Override
	public int getBurnTime(ItemStack itemStack, RecipeType<?> provider) {
		return 100000;
	}
}
