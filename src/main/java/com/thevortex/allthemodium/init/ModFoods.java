package com.thevortex.allthemodium.init;

import net.minecraft.item.Food;

public class ModFoods {
	public static final Food ALLTHEMODIUM_APPLE;
	public static final Food ALLTHEMODIUM_CARROT;
	static {
		ALLTHEMODIUM_APPLE = (new Food.Builder()).hunger(20).saturation(2.0F).setAlwaysEdible().fastToEat().build();
		ALLTHEMODIUM_CARROT = (new Food.Builder()).hunger(40).saturation(4.0F).setAlwaysEdible().fastToEat().build();
	}
}
