package com.thevortex.allthemodium.items.toolitems.armor;

import com.google.common.collect.ImmutableMultimap;
import com.thevortex.allthemodium.init.ModItems;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;
import java.util.UUID;

public class Allthemodium_Boots extends ArmorItem {


    public Allthemodium_Boots(ArmorMaterial materialIn, EquipmentSlot slot, Properties builder) {
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
    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn){
        tooltip.add(this.getTooltip("indestructible").withStyle(ChatFormatting.GOLD));
        tooltip.add(this.getTooltip("piglin.friend").withStyle(ChatFormatting.GOLD));
        tooltip.add(this.getTooltip("light.step").withStyle(ChatFormatting.BLUE));

        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
    protected TranslatableComponent getTooltip(String key){
        return new TranslatableComponent(key);
    }
}
