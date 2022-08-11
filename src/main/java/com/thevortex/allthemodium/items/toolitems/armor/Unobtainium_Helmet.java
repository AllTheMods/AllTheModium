package com.thevortex.allthemodium.items.toolitems.armor;

import com.thevortex.allthemodium.items.toolitems.armor.models.unobtainium_helmet;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.function.Consumer;

public class Unobtainium_Helmet extends ArmorItem {

	public Unobtainium_Helmet(ArmorMaterial materialIn, EquipmentSlot slot, Properties builder) {
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
        if((stack.getItem() == ModRegistry.UNOBTAINIUM_HELMET.get()) && (!world.isClientSide)) {

            if(player.isInWater() && player.isSwimming()){

                player.setAirSupply(300);
            }
        }
        super.onArmorTick(stack, world, player);
    }
}
