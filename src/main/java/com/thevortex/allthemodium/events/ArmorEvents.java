package com.thevortex.allthemodium.events;

import java.util.Iterator;

import com.thevortex.allthemodium.entity.PiglichEntity;

import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
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
			if((armor.getItem() == ModRegistry.ALLTHEMODIUM_BOOTS.get())||(armor.getItem() == ModRegistry.VIBRANIUM_BOOTS.get())||(armor.getItem() == ModRegistry.UNOBTAINIUM_BOOTS.get())) { event.setCanceled(true);}
		}	
			
	}



	@SubscribeEvent
	public static void onEntityHurt(LivingAttackEvent event) {
		if(event.getEntity() instanceof PiglichEntity) {

		}
		if (!event.getEntity().getCommandSenderWorld().isClientSide) {
			Iterable<ItemStack> armorlist = event.getEntity().getArmorSlots();
			Iterator<ItemStack> iterator = armorlist.iterator();
			while (iterator.hasNext()) {
				ItemStack armor = iterator.next();
				if ((armor.getItem() == ModRegistry.ALLTHEMODIUM_CHESTPLATE.get())||(armor.getItem() == ModRegistry.VIBRANIUM_CHESTPLATE.get())||(armor.getItem() == ModRegistry.UNOBTAINIUM_CHESTPLATE.get())) {
					if ((event.getSource().is(DamageTypes.IN_FIRE)) || (event.getSource().is(DamageTypes.ON_FIRE)) || (event.getSource().is(DamageTypes.LAVA)) || (event.getSource().is(DamageTypes.HOT_FLOOR))) {
						event.getEntity().clearFire();
						event.setCanceled(true);
					}
				}
				if ((armor.getItem() == ModRegistry.ALLTHEMODIUM_HELMET.get())||(armor.getItem() == ModRegistry.VIBRANIUM_HELMET.get())||(armor.getItem() == ModRegistry.UNOBTAINIUM_HELMET.get())) {
					if (event.getSource().is(DamageTypes.FLY_INTO_WALL)) {
						event.setCanceled(true);
					}
					if (event.getSource().is(DamageTypes.DROWN)) {
						event.getEntity().setAirSupply(event.getEntity().getMaxAirSupply());
						event.setCanceled(true);
					}
				}
			}

		}

	}
	@SubscribeEvent
	public static void onEntityCollide(ProjectileImpactEvent event) {

	}
}

