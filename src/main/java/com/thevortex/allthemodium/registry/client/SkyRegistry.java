package com.thevortex.allthemodium.registry.client;

import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterDimensionSpecialEffectsEvent;


@EventBusSubscriber(modid = Reference.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SkyRegistry {
        @SubscribeEvent
        public static void register(RegisterDimensionSpecialEffectsEvent event) {
            event.register(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "the_other"), new OtherSky(Float.NaN, true, DimensionSpecialEffects.SkyType.END, false, false));
            event.register(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "mining"), new OtherSky(Float.NaN, true, DimensionSpecialEffects.SkyType.NORMAL, true, true));

        }
}
