package com.thevortex.allthemodium.items;

import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Allthemodium_Apple extends Item {

	public Allthemodium_Apple(Properties properties) {
		super(properties);
		
	}
	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
	
		if((entityLiving instanceof Player) && (stack.getItem() == ModRegistry.ALLTHEMODIUM_APPLE.get())) {
			Player player = (Player)entityLiving;
			player.addEffect(new MobEffectInstance(MobEffects.REGENERATION,600,1,false,false));
			player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION,600,1,false,false));

		}
	return super.finishUsingItem(stack, worldIn, entityLiving);
	}

}
