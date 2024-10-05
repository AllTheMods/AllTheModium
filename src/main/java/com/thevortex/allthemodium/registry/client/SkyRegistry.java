package com.thevortex.allthemodium.registry.client;

import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SkyRegistry {

    @SubscribeEvent
    public static void register(RegisterDimensionSpecialEffectsEvent event) {
        event.register(
                new ResourceLocation(Reference.MOD_ID, "the_other"),
                new OtherSky(
                        Float.NaN,
                        true,
                        DimensionSpecialEffects.SkyType.NORMAL,
                        false,
                        false));
        event.register(
                new ResourceLocation(Reference.MOD_ID, "mining"),
                new OtherSky(
                        Float.NaN,
                        true,
                        DimensionSpecialEffects.SkyType.NORMAL,
                        true,
                        true));
    }
}
