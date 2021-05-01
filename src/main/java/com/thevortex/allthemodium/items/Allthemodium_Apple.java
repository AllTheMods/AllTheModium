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

public class Allthemodium_Apple extends Item {

	public Allthemodium_Apple(Properties properties) {
		super(properties);
		
	}
	@Override
	public ItemStack finishUsingItem(ItemStack stack, World worldIn, LivingEntity entityLiving) {
	
		if((entityLiving instanceof PlayerEntity) && (stack.getItem() == ModItems.ALLTHEMODIUM_APPLE)) {
			PlayerEntity player = (PlayerEntity)entityLiving;
			player.addEffect(new EffectInstance(Effects.REGENERATION,600,9,false,false));
			player.addEffect(new EffectInstance(Effects.ABSORPTION,600,9,false,false));
		}
	return super.finishUsingItem(stack, worldIn, entityLiving);
	}
	@OnlyIn(Dist.CLIENT)
	@Override
	public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
		tooltip.add(this.getTooltip("quick.snack").withStyle(TextFormatting.GOLD));
		tooltip.add(this.getTooltip("low.cal").withStyle(TextFormatting.GOLD));
		tooltip.add(this.getTooltip("steel.skin").withStyle(TextFormatting.DARK_RED));
		tooltip.add(this.getTooltip("troll.blood").withStyle(TextFormatting.DARK_RED));
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
	}
	protected TextComponent getTooltip(String key){
		return new TranslationTextComponent(key);
	}

}
