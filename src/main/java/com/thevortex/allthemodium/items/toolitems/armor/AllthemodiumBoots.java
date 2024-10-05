package com.thevortex.allthemodium.items.toolitems.armor;

import com.thevortex.allthemodium.registry.ModRegistry;
import javax.annotation.Nonnull;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;

public class AllthemodiumBoots extends ArmorItem {

    public AllthemodiumBoots(
            ArmorMaterial materialIn,
            EquipmentSlot slot,
            Properties builder) {
        super(materialIn, slot, builder);
    }

    @Override
    public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer) {
        return stack.is(ModRegistry.ALLTHEMODIUM_BOOTS.get());
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
