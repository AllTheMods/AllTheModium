package com.thevortex.allthemodium.items.toolitems.armor;

import com.thevortex.allthemodium.init.ModItems;


import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
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

import java.util.List;

public class Unobtainium_Chestplate extends ArmorItem {

	public Unobtainium_Chestplate(ArmorMaterial materialIn, EquipmentSlot slot, Properties builder) {
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
        //tooltip.add(this.getTooltip("breath.proof").mergeStyle(TextFormatting.GOLD));
        tooltip.add(this.getTooltip("piglin.friend").withStyle(ChatFormatting.GOLD));
        tooltip.add(this.getTooltip("fire.proof").withStyle(ChatFormatting.RED));

        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
    protected TextComponent getTooltip(String key){
        return new TextComponent(key);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if((stack.getItem() == ModItems.UNOBTAINIUM_CHESTPLATE) && (!world.isClientSide)) {

        }
        super.onArmorTick(stack, world, player);
    }
}