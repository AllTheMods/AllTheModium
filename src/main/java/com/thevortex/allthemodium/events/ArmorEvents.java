package com.thevortex.allthemodium.events;

import com.thevortex.allthemodium.entity.PiglichEntity;
import com.thevortex.allthemodium.registry.ModRegistry;
import java.util.Iterator;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ArmorEvents {

    @SubscribeEvent
    public static void onPlayerFall(LivingFallEvent event) {
        Iterable<ItemStack> armorList = event.getEntity().getArmorSlots();
        Iterator<ItemStack> iterator = armorList.iterator();
        while (iterator.hasNext()) {
            ItemStack armor = iterator.next();
            if ((armor.getItem() == ModRegistry.ALLTHEMODIUM_BOOTS.get())) {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void onEntityHurt(LivingAttackEvent event) {
        LivingEntity entity = event.getEntity();

        if (entity instanceof PiglichEntity) {
        }

        if (!entity.getCommandSenderWorld().isClientSide()) {
            Iterable<ItemStack> armorList = event.getEntity().getArmorSlots();
            Iterator<ItemStack> iterator = armorList.iterator();
            while (iterator.hasNext()) {
                ItemStack armor = iterator.next();
                if ((armor.getItem() == ModRegistry.ALLTHEMODIUM_CHESTPLATE.get())) {
                    if ((event.getSource() == DamageSource.HOT_FLOOR) ||
                            (event.getSource() == DamageSource.IN_FIRE) ||
                            (event.getSource() == DamageSource.LAVA) ||
                            (event.getSource() == DamageSource.ON_FIRE)) {
                        event.getEntity().clearFire();
                        event.setCanceled(true);
                    }
                }
                if ((armor.getItem() == ModRegistry.ALLTHEMODIUM_HELMET.get())) {
                    if (event.getSource() == DamageSource.FLY_INTO_WALL) {
                        event.setCanceled(true);
                    }
                    if (event.getSource() == DamageSource.DROWN) {
                        event
                                .getEntity()
                                .setAirSupply(event.getEntity().getMaxAirSupply());
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
