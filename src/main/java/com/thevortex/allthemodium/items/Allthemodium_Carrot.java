package com.thevortex.allthemodium.items;

import com.thevortex.allthemodium.init.ModItems;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
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

import java.util.List;

public class Allthemodium_Carrot extends Item {

	public Allthemodium_Carrot(Properties properties) {
		super(properties);
		
	}
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
	
		if((entityLiving instanceof PlayerEntity) && (stack.getItem() == ModItems.ALLTHEMODIUM_CARROT)) {
			PlayerEntity player = (PlayerEntity)entityLiving;
			player.addPotionEffect(new EffectInstance(Effects.REGENERATION,600,4,false,false));
			player.addPotionEffect(new EffectInstance(Effects.ABSORPTION,600,4,false,false));
		}
	return super.onItemUseFinish(stack, worldIn, entityLiving);
	}
	@OnlyIn(Dist.CLIENT)
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
		tooltip.add(this.getTooltip("quick.snack").mergeStyle(TextFormatting.GOLD));
		tooltip.add(this.getTooltip("low.cal").mergeStyle(TextFormatting.GOLD));
		tooltip.add(this.getTooltip("steel.skin").mergeStyle(TextFormatting.DARK_RED));
		tooltip.add(this.getTooltip("troll.blood").mergeStyle(TextFormatting.DARK_RED));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	protected TextComponent getTooltip(String key){
		return new TranslationTextComponent(key);
	}
}
