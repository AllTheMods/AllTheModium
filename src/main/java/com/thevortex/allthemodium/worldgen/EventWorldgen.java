package com.thevortex.allthemodium.worldgen;


import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.data.worldgen.Features;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.entity.EntityAccess;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.system.CallbackI;

import java.util.Objects;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.FORGE)
public class EventWorldgen {
    @SubscribeEvent
    public static void biomeModification(final BiomeLoadingEvent event) {
        String mod = Objects.requireNonNull(event.getName()).getNamespace();
        String biome = event.getName().getPath();
        if(event.getCategory() == Biome.BiomeCategory.OCEAN) {
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATMConfiguredFeature.ORE_ALLTHEMODIUM);
        }
        if((mod.equals(Reference.MOD_ID)) && (biome.equals("mining"))) {
            //Allthemodium ore
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATMConfiguredFeature.ORE_ATM_MINING);
            if(ModList.get().isLoaded("alltheores")) {
                //Alltheores
                /*
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_ALUMINUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_COPPER);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_LEAD);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_NICKEL);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_OSMIUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_PLATINUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_SILVER);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_TIN);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_URANIUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_ZINC);
                */

            }
            //Vanilla Ores
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_COAL);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_DIAMOND);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_GOLD);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_IRON);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_LAPIS);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_EMERALD);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_REDSTONE);

        }
        if((biome.equals("crimson_forest")) || (biome.equals("warped_forest"))){
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATMConfiguredFeature.ORE_VIBRANIUM);
        }
        if(event.getName().getPath().equals("end_highlands")) {
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATMConfiguredFeature.ORE_UNOBTAINIUM);
        }

    }

}
