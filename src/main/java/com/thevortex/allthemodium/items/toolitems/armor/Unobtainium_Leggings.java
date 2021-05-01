package com.thevortex.allthemodium.items.toolitems.armor;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.UUID;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.thevortex.allthemodium.init.ModItems;
import com.google.common.collect.ImmutableMultimap.Builder;

import net.minecraft.block.DispenserBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
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

public class Unobtainium_Leggings extends ArmorItem {
	   
	public Unobtainium_Leggings(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder);
    
	   }
    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer)
    {
        return true;
    }
	@OnlyIn(Dist.CLIENT)
	@Override
	public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
		tooltip.add(this.getTooltip("piglin.friend").withStyle(TextFormatting.GOLD));
		tooltip.add(this.getTooltip("wither.proof").withStyle(TextFormatting.DARK_PURPLE));
		tooltip.add(this.getTooltip("magic.resistance").withStyle(TextFormatting.LIGHT_PURPLE));
		tooltip.add(this.getTooltip("steady.legs").withStyle(TextFormatting.LIGHT_PURPLE));
		tooltip.add(this.getTooltip("steady.guts").withStyle(TextFormatting.LIGHT_PURPLE));
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
	}
	protected TextComponent getTooltip(String key){
		return new TranslationTextComponent(key);
	}

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
    	if((stack.getItem() == ModItems.UNOBTAINIUM_LEGGINGS) && (!world.isClientSide)) {

    		Collection<EffectInstance> potions = player.getActiveEffects();
			try {
    		for(EffectInstance effectInstance : potions) {
    			if(effectInstance.getEffect() == Effects.LEVITATION)
					player.removeEffect(Effects.LEVITATION);
				if(effectInstance.getEffect() == Effects.CONFUSION)
					player.removeEffect(Effects.CONFUSION);
	    	}
			} catch(ConcurrentModificationException exception) {

			}finally {
				super.onArmorTick(stack, world, player);
			}
    	}
    	super.onArmorTick(stack, world, player);
    }
}
