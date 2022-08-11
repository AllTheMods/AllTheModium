package com.thevortex.allthemodium.items.toolitems.armor;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.List;

import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Unobtainium_Leggings extends ArmorItem {
	   
	public Unobtainium_Leggings(ArmorMaterial materialIn, EquipmentSlot slot, Properties builder) {
		super(materialIn, slot, builder);
    
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

	@Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
    	if((stack.getItem() == ModRegistry.UNOBTAINIUM_LEGGINGS.get()) && (!world.isClientSide)) {

    		Collection<MobEffectInstance> potions = player.getActiveEffects();
			try {
    		for(MobEffectInstance effectInstance : potions) {
    			if(effectInstance.getEffect() == MobEffects.LEVITATION)
					player.removeEffect(MobEffects.LEVITATION);
				if(effectInstance.getEffect() == MobEffects.CONFUSION)
					player.removeEffect(MobEffects.CONFUSION);
	    	}
			} catch(ConcurrentModificationException exception) {

			}finally {
				super.onArmorTick(stack, world, player);
			}
    	}
    	super.onArmorTick(stack, world, player);
    }
}
