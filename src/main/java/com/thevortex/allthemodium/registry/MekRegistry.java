package com.thevortex.allthemodium.registry;

import com.thevortex.allthemodium.reference.Reference;
import mekanism.api.chemical.slurry.Slurry;
import mekanism.api.chemical.slurry.SlurryBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

public class MekRegistry {

    public static final ResourceLocation SLURRY_STILL = new ResourceLocation("minecraft","block/water_still");

    public static final Slurry DIRTY_ATM = new Slurry(SlurryBuilder.builder(SLURRY_STILL).ore(new ResourceLocation("forge","ores/allthemodium")).color(0xFFFFEF0E)).getChemical().setRegistryName(new ResourceLocation(Reference.MOD_ID,"dirty_allthemodium"));
    public static final Slurry DIRTY_VIB = new Slurry(SlurryBuilder.builder(SLURRY_STILL).ore(new ResourceLocation("forge","ores/vibranium")).color(0xFF26DE88)).getChemical().setRegistryName(new ResourceLocation(Reference.MOD_ID,"dirty_vibranium"));
    public static final Slurry DIRTY_UNOB = new Slurry(SlurryBuilder.builder(SLURRY_STILL).ore(new ResourceLocation("forge","ores/unobtainium")).color(0xFFD152E3)).getChemical().setRegistryName(new ResourceLocation(Reference.MOD_ID,"dirty_unobtainium"));

    public static final Slurry CLEAN_ATM = new Slurry(SlurryBuilder.builder(SLURRY_STILL).ore(new ResourceLocation("forge","ores/allthemodium")).color(0xFFFFEF0E)).getChemical().setRegistryName(new ResourceLocation(Reference.MOD_ID,"clean_allthemodium"));
    public static final Slurry CLEAN_VIB = new Slurry(SlurryBuilder.builder(SLURRY_STILL).ore(new ResourceLocation("forge","ores/vibranium")).color(0xFF26DE88)).getChemical().setRegistryName(new ResourceLocation(Reference.MOD_ID,"clean_vibranium"));
    public static final Slurry CLEAN_UNOB = new Slurry(SlurryBuilder.builder(SLURRY_STILL).ore(new ResourceLocation("forge","ores/unobtainium")).color(0xFFD152E3)).getChemical().setRegistryName(new ResourceLocation(Reference.MOD_ID,"clean_unobtainium"));

    @SubscribeEvent
    public static void init(RegistryEvent.Register<Slurry> event) {
        IForgeRegistry<Slurry> registry = event.getRegistry();


        registry.registerAll(
                DIRTY_ATM,DIRTY_VIB,DIRTY_UNOB,
                CLEAN_ATM,CLEAN_VIB,
                CLEAN_UNOB
        );

    }
}
