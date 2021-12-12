package com.thevortex.allthemodium.items;

import com.thevortex.allthemodium.init.ModItems;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class Allthemodium_Apple extends Item {

	public Allthemodium_Apple(Properties properties) {
		super(properties);
		
	}
	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
	
		if((entityLiving instanceof Player) && (stack.getItem() == ModItems.ALLTHEMODIUM_APPLE)) {
			Player player = (Player)entityLiving;
			player.addEffect(new MobEffectInstance(MobEffects.REGENERATION,600,1,false,false));
			player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION,600,1,false,false));

		}
	return super.finishUsingItem(stack, worldIn, entityLiving);
	}
	@OnlyIn(Dist.CLIENT)
	@Override
	public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn){
		tooltip.add(this.getTooltip("quick.snack").withStyle(ChatFormatting.GOLD));
		tooltip.add(this.getTooltip("low.cal").withStyle(ChatFormatting.GOLD));
		tooltip.add(this.getTooltip("steel.skin").withStyle(ChatFormatting.DARK_RED));
		tooltip.add(this.getTooltip("troll.blood").withStyle(ChatFormatting.DARK_RED));
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
	}
	protected TranslatableComponent getTooltip(String key){
		return new TranslatableComponent(key);
	}

}
