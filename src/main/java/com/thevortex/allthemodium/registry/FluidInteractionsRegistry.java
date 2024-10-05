package com.thevortex.allthemodium.registry;

import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fluids.FluidInteractionRegistry;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FluidInteractionsRegistry {

    @SubscribeEvent
    public static void register(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            addInteraction(FluidTypeRegistry.SOULLAVA.get());
        });
    }

    // Lava + Water = Obsidian (Source Lava) / Cobblestone (Flowing Lava)
    private static void addInteraction(FluidType fluidType) {
        FluidInteractionRegistry.addInteraction(
                ForgeMod.LAVA_TYPE.get(),
                new FluidInteractionRegistry.InteractionInformation(
                        fluidType,
                        fluidState -> fluidState.isSource()
                                ? Blocks.GILDED_BLACKSTONE.defaultBlockState()
                                : Blocks.BLACKSTONE.defaultBlockState()));
        FluidInteractionRegistry.addInteraction(
                ForgeMod.WATER_TYPE.get(),
                new FluidInteractionRegistry.InteractionInformation(
                        fluidType,
                        fluidState -> fluidState.isSource()
                                ? Blocks.CRYING_OBSIDIAN.defaultBlockState()
                                : Blocks.OBSIDIAN.defaultBlockState()));
    }
}
