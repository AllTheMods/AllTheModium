package com.thevortex.allthemodium.items.toolitems.tools;

import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

import java.util.function.Predicate;

public class Unobow extends CrossbowItem{

    public Unobow(Properties p_40850_) {
        super(p_40850_.rarity(Rarity.EPIC));
        //TODO Auto-generated constructor stub
    }

    @Override
    public int getDefaultProjectileRange() {
        return 90;
    }
    @Override
        public int getEnchantmentValue() {
        return 145;
    }
    @Override
    public Predicate<ItemStack> getSupportedHeldProjectiles() {
        return ARROW_OR_FIREWORK;
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_ONLY;
    }

}
