package com.thevortex.allthemodium.events;

import java.util.Iterator;

import com.thevortex.allthemodium.entity.PiglichEntity;

import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.FORGE)
public class ArmorEvents {
	


	@SubscribeEvent
	public static void onPlayerFall(LivingFallEvent event) {
		Iterable<ItemStack> armorlist = event.getEntity().getArmorSlots();
		Iterator<ItemStack> iterator = armorlist.iterator();
		while(iterator.hasNext()) {
			ItemStack armor = iterator.next();
			if((armor.getItem() == ModRegistry.ALLTHEMODIUM_BOOTS.get())) { event.setCanceled(true);}
		}	
			
	}



	@SubscribeEvent
	public static void onEntityHurt(LivingAttackEvent event) {
		if(event.getEntity() instanceof PiglichEntity) {

		}


	}
	@SubscribeEvent
	public static void onEntityCollide(ProjectileImpactEvent event) {

	}
}

