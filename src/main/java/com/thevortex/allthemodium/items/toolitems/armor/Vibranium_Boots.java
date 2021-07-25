package com.thevortex.allthemodium.items.toolitems.armor;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class Vibranium_Boots extends ArmorItem {

	public Vibranium_Boots(ArmorMaterial materialIn, EquipmentSlot slot, Properties builder) {
		super(materialIn, slot, builder);
		
	}
    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer)
    {
        return true;
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn){
        tooltip.add(this.getTooltip("piglin.friend").withStyle(ChatFormatting.GOLD));
        tooltip.add(this.getTooltip("light.step").withStyle(ChatFormatting.BLUE));

        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
    protected TextComponent getTooltip(String key){
        return new TextComponent(key);
    }
}
