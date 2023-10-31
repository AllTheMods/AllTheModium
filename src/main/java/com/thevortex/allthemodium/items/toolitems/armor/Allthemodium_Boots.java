package com.thevortex.allthemodium.items.toolitems.armor;

import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class Allthemodium_Boots extends ArmorItem {


    public Allthemodium_Boots(ArmorMaterial materialIn, EquipmentSlot slot, Properties builder) {
		super(materialIn, Type.BOOTS, builder);

	}
    @Override
    public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer)
    {
        if(stack.is(ModRegistry.ALLTHEMODIUM_BOOTS.get())){ return true; }
        if(stack.is(ModRegistry.VIBRANIUM_BOOTS.get())){ return true; }

        if(stack.is(ModRegistry.UNOBTAINIUM_BOOTS.get())){ return true; }
        return false;
    }


    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }
    @Override
    public boolean canBeDepleted() {
        return false;
    }
    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer)
    {
        return true;
    }
}
