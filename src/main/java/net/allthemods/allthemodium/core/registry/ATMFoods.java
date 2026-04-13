package net.allthemods.allthemodium.core.registry;

import net.minecraft.world.food.FoodProperties;

public class ATMFoods {
    
    public static final FoodProperties ALLTHEMODIUM_APPLE = new FoodProperties.Builder().nutrition(20).saturationModifier(2.0F).alwaysEdible().build();
    public static final FoodProperties ALLTHEMODIUM_CARROT = new FoodProperties.Builder().nutrition(40).saturationModifier(4.0F).alwaysEdible().build();
    public static final FoodProperties SOUL_BERRIES = new FoodProperties.Builder().nutrition(5).saturationModifier(4.0F).alwaysEdible().build();
}
