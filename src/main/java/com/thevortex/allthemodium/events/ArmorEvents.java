package com.thevortex.allthemodium.events;

import java.util.Iterator;

import com.thevortex.allthemodium.init.ModItems;

import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.FORGE)
public class ArmorEvents {
	


	@SubscribeEvent
	public static void onPlayerFall(LivingFallEvent event) {
		Iterable<ItemStack> armorlist = event.getEntityLiving().getArmorSlots();
		Iterator<ItemStack> iterator = armorlist.iterator();
		while(iterator.hasNext()) {
			ItemStack armor = iterator.next();
			if((armor.getItem() == ModItems.ALLTHEMODIUM_BOOTS) || (armor.getItem() == ModItems.VIBRANIUM_BOOTS) || (armor.getItem() == ModItems.UNOBTAINIUM_BOOTS)) { event.setCanceled(true);}
		}	
			
	}



	@SubscribeEvent
	public static void onEntityHurt(LivingAttackEvent event) {
		if (!event.getEntityLiving().getCommandSenderWorld().isClientSide) {
			Iterable<ItemStack> armorlist = event.getEntityLiving().getArmorSlots();
			Iterator<ItemStack> iterator = armorlist.iterator();
			while (iterator.hasNext()) {
				ItemStack armor = iterator.next();
				if ((armor.getItem() == ModItems.ALLTHEMODIUM_CHESTPLATE) || (armor.getItem() == ModItems.VIBRANIUM_CHESTPLATE) || (armor.getItem() == ModItems.UNOBTAINIUM_CHESTPLATE)) {
					if ((event.getSource() == DamageSource.DRAGON_BREATH) && (armor.getItem() == ModItems.UNOBTAINIUM_CHESTPLATE)) {
						event.setCanceled(true);
					}
					if ((event.getSource() == DamageSource.HOT_FLOOR) || (event.getSource() == DamageSource.IN_FIRE) || (event.getSource() == DamageSource.LAVA) || (event.getSource() == DamageSource.ON_FIRE)) {
						event.getEntityLiving().clearFire();
						event.setCanceled(true);
					}
				}
				if ((armor.getItem() == ModItems.VIBRANIUM_LEGGINGS) || (armor.getItem() == ModItems.UNOBTAINIUM_LEGGINGS)) {
					if (event.getSource() == DamageSource.WITHER) {
						event.getEntityLiving().removeEffect(Effects.WITHER);
						event.setCanceled(true);
					}
					if (!event.isCanceled() && armor.getItem() == ModItems.UNOBTAINIUM_LEGGINGS) {
						event.getEntityLiving().removeEffect(Effects.LEVITATION);
					}
				}

				if ((armor.getItem() == ModItems.ALLTHEMODIUM_HELMET) || (armor.getItem() == ModItems.VIBRANIUM_HELMET) || (armor.getItem() == ModItems.UNOBTAINIUM_HELMET)) {
					if (event.getSource() == DamageSource.FLY_INTO_WALL) {
						event.setCanceled(true);
					}
					if (event.getSource() == DamageSource.DROWN) {
						event.getEntityLiving().setAirSupply(event.getEntityLiving().getMaxAirSupply());
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

