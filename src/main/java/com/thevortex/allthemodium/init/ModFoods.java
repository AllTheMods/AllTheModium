package com.thevortex.allthemodium.init;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {

    public static final FoodProperties ALLTHEMODIUM_APPLE;
    public static final FoodProperties ALLTHEMODIUM_CARROT;

    public static final FoodProperties SOUL_BERRIES;

    static {
        ALLTHEMODIUM_APPLE = new FoodProperties.Builder()
                .nutrition(20)
                .saturationMod(2.0F)
                .alwaysEat()
                .fast()
                .build();
        ALLTHEMODIUM_CARROT = new FoodProperties.Builder()
                .nutrition(40)
                .saturationMod(4.0F)
                .alwaysEat()
                .fast()
                .build();
        SOUL_BERRIES = new FoodProperties.Builder()
                .nutrition(5)
                .saturationMod(4.0F)
                .alwaysEat()
                .fast()
                .build();
    }
}
