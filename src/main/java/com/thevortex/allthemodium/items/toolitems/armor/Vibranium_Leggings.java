package com.thevortex.allthemodium.items.toolitems.armor;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap.Builder;

import com.thevortex.allthemodium.init.ModItems;
import net.minecraft.block.DispenserBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Vibranium_Leggings extends ArmorItem {
	   
	public Vibranium_Leggings(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder);
    
	   }
	
    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer)
    {
        return true;
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        tooltip.add(this.getTooltip("piglin.friend").mergeStyle(TextFormatting.GOLD));
        tooltip.add(this.getTooltip("wither.proof").mergeStyle(TextFormatting.DARK_GREEN));
        tooltip.add(this.getTooltip("magic.resistance").mergeStyle(TextFormatting.GREEN));
        tooltip.add(this.getTooltip("steady.guts").mergeStyle(TextFormatting.GREEN));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
    protected TextComponent getTooltip(String key){
        return new TranslationTextComponent(key);
    }

}
