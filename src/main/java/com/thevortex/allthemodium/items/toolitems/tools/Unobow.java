package com.thevortex.allthemodium.items.toolitems.tools;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.ChargedProjectiles;

import java.util.function.Predicate;

public class Unobow extends CrossbowItem {

    public Unobow(Properties p_40850_) {
        super(p_40850_.rarity(Rarity.EPIC));
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

    public static boolean isCharged(ItemStack stack) {
        ChargedProjectiles charged = stack.get(DataComponents.CHARGED_PROJECTILES);
        return charged != null && !charged.isEmpty();
    }

    /**
     * Wraps {@link CrossbowItem#getChargeDuration} with a floor of 1 tick to
     * prevent divide-by-zero when high Quick Charge levels reduce duration to 0.
     */
    public static int getSafeChargeDuration(ItemStack stack, LivingEntity entity) {
        int duration = CrossbowItem.getChargeDuration(stack, entity);
        return duration <= 0 ? 1 : duration;
    }
}
