package com.thevortex.allthemodium.items.toolitems.armor;

import javax.annotation.Nonnull;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class AllthemodiumLeggings extends ArmorItem {

    public AllthemodiumLeggings(
            ArmorMaterial materialIn,
            EquipmentSlot slot,
            Properties builder) {
        super(materialIn, slot, builder);
    }

    @Override
    public boolean isEnchantable(@Nonnull ItemStack stack) {
        return true;
    }

    @Override
    public boolean canBeDepleted() {
        return false;
    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return true;
    }
}
