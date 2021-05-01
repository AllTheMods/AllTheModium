package com.thevortex.allthemodium.init;

import net.minecraft.item.Food;

public class ModFoods {
	public static final Food ALLTHEMODIUM_APPLE;
	public static final Food ALLTHEMODIUM_CARROT;
	static {
		ALLTHEMODIUM_APPLE = (new Food.Builder()).nutrition(20).saturationMod(2.0F).alwaysEat().fast().build();
		ALLTHEMODIUM_CARROT = (new Food.Builder()).nutrition(40).saturationMod(4.0F).alwaysEat().fast().build();
	}
}
