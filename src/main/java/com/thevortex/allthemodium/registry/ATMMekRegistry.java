package com.thevortex.allthemodium.registry;

import mekanism.api.chemical.slurry.Slurry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;

public class ATMMekRegistry {
    @SubscribeEvent
    public static void onSlurryRegistry(final RegistryEvent.Register<Slurry> event) {	if(ModList.get().isLoaded("mekanism")) { MekRegistry.init(event);		} }
}
