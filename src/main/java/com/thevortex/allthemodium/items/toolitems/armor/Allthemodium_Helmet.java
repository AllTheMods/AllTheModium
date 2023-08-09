package com.thevortex.allthemodium.items.toolitems.armor;

import com.thevortex.allthemodium.items.toolitems.armor.models.allthemodium_helmet;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.network.chat.Component;
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
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.List;
import java.util.function.Consumer;

public class Allthemodium_Helmet extends ArmorItem {

	public Allthemodium_Helmet(ArmorMaterial materialIn, EquipmentSlot slot, Properties builder) {
		super(materialIn, Type.HELMET, builder);
		
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
        if((stack.getItem() == ModRegistry.ALLTHEMODIUM_HELMET.get()) && (!world.isClientSide)) {

            if(player.isInWater() && player.isSwimming()){

                player.setAirSupply(300);
            }
        }
        super.onArmorTick(stack, world, player);
    }
}
