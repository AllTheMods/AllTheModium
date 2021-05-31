package com.thevortex.allthemodium.init;

import com.thevortex.allthemodium.AllTheModium;
import com.thevortex.allthemodium.reference.Reference;
import mekanism.api.chemical.slurry.Slurry;
import mekanism.api.chemical.slurry.SlurryBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ModSlurries {

    public static final Slurry ATM_Dirty = new Slurry(SlurryBuilder.builder(new ResourceLocation("minecraft","block/water_still")).ore(new ResourceLocation("forge","ores/allthemodium")).color(0xFFFFEF0E)).getChemical().setRegistryName(new ResourceLocation(Reference.MOD_ID,"dirty_allthemodium"));
    public static final Slurry VIB_Dirty = new Slurry(SlurryBuilder.builder(new ResourceLocation("minecraft","block/water_still")).ore(new ResourceLocation("forge","ores/vibranium")).color(0xFF26DE88)).getChemical().setRegistryName(new ResourceLocation(Reference.MOD_ID,"dirty_vibranium"));
    public static final Slurry UNOB_Dirty = new Slurry(SlurryBuilder.builder(new ResourceLocation("minecraft","block/water_still")).ore(new ResourceLocation("forge","ores/unobtainium")).color(0xFFD152E3)).getChemical().setRegistryName(new ResourceLocation(Reference.MOD_ID,"dirty_unobtainium"));

    public static final Slurry ATM_Clean = new Slurry(SlurryBuilder.builder(new ResourceLocation("minecraft","block/water_still")).ore(new ResourceLocation("forge","ores/allthemodium")).color(0xFFFFEF0E)).getChemical().setRegistryName(new ResourceLocation(Reference.MOD_ID,"clean_allthemodium"));
    public static final Slurry VIB_Clean = new Slurry(SlurryBuilder.builder(new ResourceLocation("minecraft","block/water_still")).ore(new ResourceLocation("forge","ores/vibranium")).color(0xFF26DE88)).getChemical().setRegistryName(new ResourceLocation(Reference.MOD_ID,"clean_vibranium"));
    public static final Slurry UNOB_Clean = new Slurry(SlurryBuilder.builder(new ResourceLocation("minecraft","block/water_still")).ore(new ResourceLocation("forge","ores/unobtainium")).color(0xFFD152E3)).getChemical().setRegistryName(new ResourceLocation(Reference.MOD_ID,"clean_unobtainium"));

    public static ItemGroup group = AllTheModium.GROUP;
    public static void init(RegistryEvent.Register<Slurry> event) {
        IForgeRegistry<Slurry> registry = event.getRegistry();

        registry.register(ATM_Dirty);
        registry.register(VIB_Dirty);
        registry.register(UNOB_Dirty);
        registry.register(ATM_Clean);
        registry.register(VIB_Clean);
        registry.register(UNOB_Clean);

    }
}
