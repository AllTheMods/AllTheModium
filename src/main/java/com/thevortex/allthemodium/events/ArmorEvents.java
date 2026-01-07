package com.thevortex.allthemodium.events;

import com.thevortex.allthemodium.entity.PiglichEntity;
import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingFallEvent;

import java.util.Iterator;

@EventBusSubscriber(bus=EventBusSubscriber.Bus.GAME, modid = Reference.MOD_ID)
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
	public static void onEntityHurt(LivingDamageEvent.Pre event) {
		if(event.getEntity() instanceof PiglichEntity) {

		}
		if (!event.getEntity().getCommandSenderWorld().isClientSide) {
			Iterable<ItemStack> armorlist = event.getEntity().getArmorSlots();
			Iterator<ItemStack> iterator = armorlist.iterator();
			if (event.getSource().is(DamageTypes.MAGIC)) {
			
						while (iterator.hasNext()) {
							ItemStack armor = iterator.next();
							if (armor.getItem() == ModRegistry.ALLTHEMODIUM_CHESTPLATE.get()){
								event.setNewDamage(event.getNewDamage() * 0.5F);
							}
							if (armor.getItem() == ModRegistry.VIBRANIUM_CHESTPLATE.get()){
								event.setNewDamage(event.getNewDamage() * 0.25F);
							}
							if (armor.getItem() == ModRegistry.UNOBTAINIUM_CHESTPLATE.get()){
								event.setNewDamage(event.getNewDamage() * 0.1F);
							}

						}
						return;
			}
			if(event.getSource().is(DamageTypes.FELL_OUT_OF_WORLD)) {

				while (iterator.hasNext()) {
					ItemStack armor = iterator.next();
					if (armor.getItem() == ModRegistry.UNOBTAINIUM_CHESTPLATE.get()){
						event.setNewDamage(0.0F);
					}
				}
			}
			while (iterator.hasNext()) {
				ItemStack armor = iterator.next();
				if ((armor.getItem() == ModRegistry.ALLTHEMODIUM_CHESTPLATE.get())||(armor.getItem() == ModRegistry.VIBRANIUM_CHESTPLATE.get())||(armor.getItem() == ModRegistry.UNOBTAINIUM_CHESTPLATE.get())) {
					if ((event.getSource().is(DamageTypes.IN_FIRE)) || (event.getSource().is(DamageTypes.ON_FIRE)) || (event.getSource().is(DamageTypes.LAVA)) || (event.getSource().is(DamageTypes.HOT_FLOOR))) {
						event.getEntity().clearFire();
						event.setNewDamage(0);
					}
				}
				if ((armor.getItem() == ModRegistry.ALLTHEMODIUM_HELMET.get())||(armor.getItem() == ModRegistry.VIBRANIUM_HELMET.get())||(armor.getItem() == ModRegistry.UNOBTAINIUM_HELMET.get())) {
					if (event.getSource().is(DamageTypes.FLY_INTO_WALL)) {
						event.setNewDamage(0);
					}
					if (event.getSource().is(DamageTypes.DROWN)) {
						event.getEntity().setAirSupply(event.getEntity().getMaxAirSupply());
						event.setNewDamage(0);
					}
				}
			}

		}

	}
}
