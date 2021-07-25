package com.thevortex.allthemodium.init;


import net.minecraft.world.food.FoodData;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;

public class ModFoods {
	public static final FoodProperties ALLTHEMODIUM_APPLE;
	public static final FoodProperties ALLTHEMODIUM_CARROT;
	static {
		ALLTHEMODIUM_APPLE = new FoodProperties.Builder().nutrition(20).saturationMod(2.0F).alwaysEat().fast().build();
		ALLTHEMODIUM_CARROT = new FoodProperties.Builder().nutrition(40).saturationMod(4.0F).alwaysEat().fast().build();
	}
}
