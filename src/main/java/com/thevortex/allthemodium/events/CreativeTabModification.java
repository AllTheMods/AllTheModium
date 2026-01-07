package com.thevortex.allthemodium.events;

import com.thevortex.allthemodium.compat.ars_nouveau.ArsCompat;
import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@EventBusSubscriber(modid = Reference.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class CreativeTabModification {
    

    @SubscribeEvent
    public static void tabModification(BuildCreativeModeTabContentsEvent event) {
        if(ModList.get().isLoaded("ars_nouveau")) {
            if(event.getTab().equals(ModRegistry.CREATIVE_TAB.get())) {
                event.accept(ArsCompat.ALLTHEMODIUM_SOURCE_JAR.get().asItem());
            }
        
        }
    }
}
