package com.thevortex.allthemodium.items.toolitems.armor;

import com.thevortex.allthemodium.registry.TagRegistry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredHolder;


public class Allthemodium_Chestplate extends ArmorItem {



    public Allthemodium_Chestplate(DeferredHolder<ArmorMaterial, ArmorMaterial> atm, EquipmentSlot slot, Properties builder) {
		super(atm, Type.CHESTPLATE, builder);

	}
    
    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int slot, boolean selected) {
        if((entity instanceof LivingEntity) && (entity.isOnFire()) && stack.is(TagRegistry.ATM_CHESTPLATES)&& (slot == 38)){
            entity.clearFire();
       
        }
        
    }


    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }
 
    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer)
    {
        return true;
    }


}