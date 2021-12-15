package com.thevortex.allthemodium.worldgen;


import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.worldgen.carvers.ATMCarvers;
import net.allthemods.alltheores.worldgen.ATOConfiguredFeature;
import net.allthemods.alltheores.worldgen.ATOPlacedFeatures;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.data.worldgen.placement.*;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.feature.DesertPyramidFeature;
import net.minecraft.world.level.levelgen.feature.GeodeFeature;
import net.minecraft.world.level.levelgen.feature.NetherFortressFeature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.placement.CarvingMaskPlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.FORGE)
public class EventWorldgen {
    @SubscribeEvent
    public static void biomeModification(final BiomeLoadingEvent event) {
        String mod = Objects.requireNonNull(event.getName()).getNamespace();
        String biome = event.getName().getPath();
        if (event.getCategory() == Biome.BiomeCategory.MOUNTAIN) {
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATMPlacedFeature.ORE_ALLTHEMODIUM_MOUNTAIN);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATMPlacedFeature.ORE_ALLTHEMODIUM);
        }
        if ((biome.equals("crimson_forest")) || (biome.equals("warped_forest"))) {
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_DECORATION).add(() -> ATMPlacedFeature.ORE_VIBRANIUM);
        }
        if (event.getName().getPath().equals("end_highlands")) {
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATMPlacedFeature.ORE_UNOBTAINIUM);
        }
        if (event.getCategory() == Biome.BiomeCategory.OCEAN) {
           // event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> ATMPlacedFeature.VOLCANO_CF);
        }
        if ((mod.equals(Reference.MOD_ID)) && (biome.equals("mining"))) {
            //clear out the trash
            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).clear();
            event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).clear();
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_STRUCTURES).clear();
            event.getSpawns().getSpawnerTypes().forEach(spawner -> event.getSpawns().getSpawner(spawner).clear());
            event.getGeneration().getFeatures(GenerationStep.Decoration.LAKES).clear();
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATMPlacedFeature.ORE_ATM_MINING);
            if (ModList.get().isLoaded("alltheores")) {
                //Alltheores

                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_ALUMINIUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_LEAD);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_NICKEL);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_OSMIUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_PLATINUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_SILVER);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_TIN);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_URANIUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_ZINC);


            }
            //Vanilla Ores
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_TUFF);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COAL_UPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COAL_LOWER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COPPER_LARGE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_DIAMOND);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_DIAMOND_BURIED);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_DIAMOND_LARGE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_GOLD);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_GOLD_LOWER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_IRON_MIDDLE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_IRON_SMALL);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_IRON_UPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_LAPIS);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_LAPIS_BURIED);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_EMERALD);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_REDSTONE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_REDSTONE_LOWER);



        }
        if ((mod.equals(Reference.MOD_ID)) && (biome.equals("basalt_deltas"))) {
            event.getGeneration().getCarvers(GenerationStep.Carving.AIR).add(() -> ATMCarvers.NETHER_CAVE_CWC);
            event.getGeneration().getCarvers(GenerationStep.Carving.AIR).add(() -> ATMCarvers.OTHER_CAVE_CWC);
            event.getGeneration().getCarvers(GenerationStep.Carving.AIR).add(() -> ATMCarvers.OTHER_CANYON_CWC);
            event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> ATMPlacedFeature.VOLCANO_CF);
            event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> ATMPlacedFeature.MOD_DELTAS);

            event.getGeneration().getFeatures(GenerationStep.Decoration.LOCAL_MODIFICATIONS).add(() -> NetherPlacements.LARGE_BASALT_COLUMNS);
            event.getGeneration().getFeatures(GenerationStep.Decoration.LOCAL_MODIFICATIONS).add(() -> NetherPlacements.SMALL_BASALT_COLUMNS);
            event.getGeneration().getFeatures(GenerationStep.Decoration.LOCAL_MODIFICATIONS).add(() -> NetherPlacements.BASALT_BLOBS);
            if (ModList.get().isLoaded("alltheores")) {
                //Alltheores


                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_ALUMINIUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_LEAD);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_NICKEL);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_OSMIUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_PLATINUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_SILVER);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_TIN);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_URANIUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_ZINC);

                //ATO Vanilla Other Ores
            }
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COAL_LOWER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COAL_UPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COPPER_LARGE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_DIAMOND);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_DIAMOND_LARGE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_DIAMOND_BURIED);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_GOLD);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_IRON_UPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_IRON_MIDDLE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_IRON_SMALL);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_LAPIS);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_EMERALD);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_REDSTONE);
        }
        if ((mod.equals(Reference.MOD_ID)) && (biome.equals("soul_sand_valley"))) {
            event.getGeneration().getCarvers(GenerationStep.Carving.AIR).add(() -> ATMCarvers.NETHER_CAVE_CWC);
            event.getGeneration().getCarvers(GenerationStep.Carving.AIR).add(() -> ATMCarvers.OTHER_CAVE_CWC);
            event.getGeneration().getCarvers(GenerationStep.Carving.AIR).add(() -> ATMCarvers.OTHER_CANYON_CWC);
            if (ModList.get().isLoaded("alltheores")) {
                //Alltheores


                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_ALUMINIUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_LEAD);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_NICKEL);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_OSMIUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_PLATINUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_SILVER);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_TIN);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_URANIUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_ZINC);

                //ATO Vanilla Other Ores
            }
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COAL_LOWER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COAL_UPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COPPER_LARGE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_DIAMOND);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_DIAMOND_LARGE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_DIAMOND_BURIED);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_GOLD);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_IRON_UPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_IRON_MIDDLE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_IRON_SMALL);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_LAPIS);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_EMERALD);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_REDSTONE);
        }
        if ((mod.equals(Reference.MOD_ID)) && (biome.equals("desert"))) {
            event.getGeneration().getCarvers(GenerationStep.Carving.AIR).add(() -> ATMCarvers.NETHER_CAVE_CWC);
            event.getGeneration().getCarvers(GenerationStep.Carving.AIR).add(() -> ATMCarvers.OTHER_CAVE_CWC);
            event.getGeneration().getCarvers(GenerationStep.Carving.AIR).add(() -> ATMCarvers.OTHER_CANYON_CWC);

        }
        if ((mod.equals(Reference.MOD_ID)) && (biome.equals("desert_hills"))) {
            event.getGeneration().getCarvers(GenerationStep.Carving.AIR).add(() -> ATMCarvers.NETHER_CAVE_CWC);
            event.getGeneration().getCarvers(GenerationStep.Carving.AIR).add(() -> ATMCarvers.OTHER_CAVE_CWC);
            event.getGeneration().getCarvers(GenerationStep.Carving.AIR).add(() -> ATMCarvers.OTHER_CANYON_CWC);
            if (ModList.get().isLoaded("alltheores")) {
                //Alltheores


                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_ALUMINIUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_LEAD);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_NICKEL);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_OSMIUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_PLATINUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_SILVER);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_TIN);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_URANIUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_ZINC);

                //ATO Vanilla Other Ores
            }
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COAL_LOWER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COAL_UPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COPPER_LARGE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_DIAMOND);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_DIAMOND_LARGE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_DIAMOND_BURIED);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_GOLD);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_IRON_UPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_IRON_MIDDLE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_IRON_SMALL);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_LAPIS);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_EMERALD);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_REDSTONE);
        }
        if ((mod.equals(Reference.MOD_ID)) && (biome.equals("warped_forest"))) {
            event.getGeneration().getCarvers(GenerationStep.Carving.AIR).add(() -> ATMCarvers.NETHER_CAVE_CWC);
            event.getGeneration().getCarvers(GenerationStep.Carving.AIR).add(() -> ATMCarvers.OTHER_CAVE_CWC);
            event.getGeneration().getCarvers(GenerationStep.Carving.AIR).add(() -> ATMCarvers.OTHER_CANYON_CWC);
            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> NetherPlacements.WARPED_FOREST_VEGETATION);
            if (ModList.get().isLoaded("alltheores")) {
                //Alltheores


                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_ALUMINIUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_LEAD);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_NICKEL);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_OSMIUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_PLATINUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_SILVER);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_TIN);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_URANIUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_ZINC);

                //ATO Vanilla Other Ores
            }
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COAL_LOWER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COAL_UPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COPPER_LARGE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_DIAMOND);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_DIAMOND_LARGE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_DIAMOND_BURIED);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_GOLD);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_IRON_UPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_IRON_MIDDLE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_IRON_SMALL);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_LAPIS);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_EMERALD);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_REDSTONE);
        }
        if ((mod.equals(Reference.MOD_ID)) && (biome.equals("crimson_forest"))) {
            event.getGeneration().getCarvers(GenerationStep.Carving.AIR).add(() -> ATMCarvers.NETHER_CAVE_CWC);
            event.getGeneration().getCarvers(GenerationStep.Carving.AIR).add(() -> ATMCarvers.OTHER_CAVE_CWC);
            event.getGeneration().getCarvers(GenerationStep.Carving.AIR).add(() -> ATMCarvers.OTHER_CANYON_CWC);
            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> NetherPlacements.CRIMSON_FOREST_VEGETATION);
            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> NetherPlacements.PATCH_CRIMSON_ROOTS);
            if (ModList.get().isLoaded("alltheores")) {
                //Alltheores


                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_ALUMINIUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_LEAD);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_NICKEL);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_OSMIUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_PLATINUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_SILVER);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_TIN);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_URANIUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_ZINC);

                //ATO Vanilla Other Ores
            }
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COAL_LOWER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COAL_UPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COPPER_LARGE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_DIAMOND);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_DIAMOND_LARGE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_DIAMOND_BURIED);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_GOLD);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_IRON_UPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_IRON_MIDDLE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_IRON_SMALL);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_LAPIS);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_EMERALD);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_REDSTONE);
        }
        if (biome.equals("the_other")) {
            //Allthemodium(Vibranium/Soul Lava)
            event.getGeneration().getCarvers(GenerationStep.Carving.AIR).add(() -> ATMCarvers.NETHER_CAVE_CWC);
            event.getGeneration().getCarvers(GenerationStep.Carving.AIR).add(() -> ATMCarvers.OTHER_CAVE_CWC);
            event.getGeneration().getCarvers(GenerationStep.Carving.AIR).add(() -> ATMCarvers.OTHER_CANYON_CWC);

            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> NetherPlacements.WEEPING_VINES);
            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> ATMPlacedFeature.ANCIENT_TREE_GIANT);
            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> ATMPlacedFeature.ANCIENT_TREE_MEDIUM);
            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> ATMPlacedFeature.ANCIENT_TREE);


            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATMPlacedFeature.ORE_ALLTHEMODIUM_MOUNTAIN);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATMPlacedFeature.ORE_ALLTHEMODIUM);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATMPlacedFeature.ORE_VIBRANIUM);
            //event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> ATMPlacedFeature.MOD_DRIPSTONE);
            if (ModList.get().isLoaded("alltheores")) {
                //Alltheores


                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_ALUMINIUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_LEAD);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_NICKEL);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_OSMIUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_PLATINUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_SILVER);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_TIN);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_URANIUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOPlacedFeatures.ORE_ZINC);

                //ATO Vanilla Other Ores
            }
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COAL_LOWER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COAL_UPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COPPER_LARGE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_DIAMOND);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_DIAMOND_LARGE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_DIAMOND_BURIED);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_GOLD);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_IRON_UPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_IRON_MIDDLE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_IRON_SMALL);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_LAPIS);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_EMERALD);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_REDSTONE);

            //Generic Nether Features
            event.getGeneration().getFeatures(GenerationStep.Decoration.LAKES).add(() -> MiscOverworldPlacements.LAKE_LAVA_SURFACE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.LAKES).add(() -> MiscOverworldPlacements.LAKE_LAVA_UNDERGROUND);
            event.getGeneration().getFeatures(GenerationStep.Decoration.LAKES).add(() -> NetherPlacements.SPRING_OPEN);
            event.getGeneration().getFeatures(GenerationStep.Decoration.LAKES).add(() -> NetherPlacements.SPRING_DELTA);
            event.getGeneration().getFeatures(GenerationStep.Decoration.LAKES).add(() -> NetherPlacements.SPRING_CLOSED_DOUBLE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> NetherPlacements.PATCH_SOUL_FIRE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> NetherPlacements.PATCH_FIRE);

            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_STRUCTURES).add(() -> CavePlacements.MONSTER_ROOM);
            event.getGeneration().getFeatures(GenerationStep.Decoration.LOCAL_MODIFICATIONS).add(() -> CavePlacements.LARGE_DRIPSTONE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> CavePlacements.DRIPSTONE_CLUSTER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> CavePlacements.POINTED_DRIPSTONE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> CavePlacements.CAVE_VINES);
            //event.getGeneration().getFeatures(GenerationStep.Decoration.TOP_LAYER_MODIFICATION).add(() -> CavePlacements.LUSH_CAVES_VEGETATION);
            event.getGeneration().getFeatures(GenerationStep.Decoration.TOP_LAYER_MODIFICATION).add(() -> CavePlacements.GLOW_LICHEN);
            event.getGeneration().getFeatures(GenerationStep.Decoration.TOP_LAYER_MODIFICATION).add(() -> CavePlacements.LUSH_CAVES_CEILING_VEGETATION);


            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_DIRT);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_GRAVEL);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> NetherPlacements.GLOWSTONE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> NetherPlacements.GLOWSTONE_EXTRA);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_BLACKSTONE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_QUARTZ_NETHER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_GOLD_NETHER);

            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_ANCIENT_DEBRIS_LARGE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_ANCIENT_DEBRIS_SMALL);


}/*



        }
*/
    }
}
