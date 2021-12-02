package com.thevortex.allthemodium.worldgen;


import com.thevortex.allthemodium.reference.Reference;
import net.allthemods.alltheores.worldgen.ATOConfiguredFeature;
import net.allthemods.alltheores.worldgen.ATOPlacedFeatures;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.data.worldgen.placement.*;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.DesertPyramidFeature;
import net.minecraft.world.level.levelgen.feature.NetherFortressFeature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
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
        if (event.getCategory() == Biome.BiomeCategory.OCEAN) {
           // event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> ATMPlacedFeature.VOLCANO_CF);
        }
        if ((mod.equals(Reference.MOD_ID)) && (biome.equals("mining"))) {
            //Allthemodium ore
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
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COAL_UPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COAL_LOWER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_COPPER_LARGE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_DIAMOND);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_DIAMOND_BURIED);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_DIAMOND_LARGE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_GOLD);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_IRON_MIDDLE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_IRON_SMALL);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_IRON_UPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_LAPIS);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_EMERALD);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> OrePlacements.ORE_REDSTONE);



        }

        if ((event.getCategory() == Biome.BiomeCategory.NETHER) && (mod.equals(Reference.MOD_ID))) {
            //Allthemodium(Vibranium/Soul Lava)
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATMPlacedFeature.ORE_ALLTHEMODIUM);
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

    /*
            event.getGeneration().getStructures().add(() -> StructureFeature.BASTION_REMNANT);
            event.getGeneration().getStructures().add(() -> StructureFeature.MINESHAFT);
            event.getGeneration().getStructures().add(() -> StructureFeature.PILLAGER_OUTPOST);
*/
            event.getGeneration().getFeatures(GenerationStep.Decoration.LOCAL_MODIFICATIONS).add(() -> CavePlacements.LARGE_DRIPSTONE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> CavePlacements.DRIPSTONE_CLUSTER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> CavePlacements.POINTED_DRIPSTONE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> CavePlacements.CAVE_VINES);
            event.getGeneration().getFeatures(GenerationStep.Decoration.TOP_LAYER_MODIFICATION).add(() -> CavePlacements.LUSH_CAVES_VEGETATION);
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

            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_DECORATION).add(() -> MiscOverworldPlacements.DISK_SAND);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_DECORATION).add(() -> MiscOverworldPlacements.DISK_CLAY);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_DECORATION).add(() -> MiscOverworldPlacements.DISK_GRAVEL);

            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> MiscOverworldPlacements.SPRING_LAVA);
            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> NetherPlacements.PATCH_FIRE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> NetherPlacements.PATCH_SOUL_FIRE);


            //Biome Specific Features
            if (biome.contains("badlands")) {
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> VegetationPlacements.PATCH_DEAD_BUSH_BADLANDS);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> VegetationPlacements.PATCH_CACTUS_DESERT);
                event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> ATMPlacedFeature.MOD_DELTAS);

                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> VegetationPlacements.DARK_FOREST_VEGETATION);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> TreePlacements.DARK_OAK_CHECKED);
                if (ModList.get().isLoaded("iceandfire")) {
                }
            }
            if (biome.equals("crimson_forest")) {

                //event.getGeneration().getFeatures().add(() -> ATMConfiguredStructures.CONFIGURED_DUNGEON);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> NetherPlacements.WEEPING_VINES);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> NetherPlacements.CRIMSON_FOREST_VEGETATION);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> NetherPlacements.PATCH_CRIMSON_ROOTS);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> TreePlacements.CRIMSON_FUNGI);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> VegetationPlacements.RED_MUSHROOM_NETHER);
                if (ModList.get().isLoaded("byg")) {
                }
                if (ModList.get().isLoaded("iceandfire")) {

                }
            }
            if (biome.equals("basalt_deltas")) {
                //event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> Features.DELTA);
                event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> NetherPlacements.SMALL_BASALT_COLUMNS);
                event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> NetherPlacements.LARGE_BASALT_COLUMNS);
                event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> ATMPlacedFeature.VOLCANO_CF);
                event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> ATMPlacedFeature.MOD_DELTAS);

                if (ModList.get().isLoaded("byg")) {
                    //event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> BYGConfiguredFeatures.VOLCANO);
                }
                if (ModList.get().isLoaded("iceandfire")) {
                }


            }
            if (biome.contains("mountain")) {

                //event.getGeneration().getStructures().add(() -> StructureFeature.RUINED_PORTAL);
               // event.getGeneration().getStructures().add(() -> StructureFeature.VILLAGE);
                if (ModList.get().isLoaded("iceandfire")) {
                }
            }
            if (biome.contains("desert")) {

                //event.getGeneration().getStructures().add(() -> StructureFeature.DESERT_PYRAMID);
               // event.getGeneration().getStructures().add(() -> StructureFeature.VILLAGE);
                //event.getGeneration().getStructures().add(() -> StructureFeature.SHIPWRECK);
                //event.getGeneration().getStructures().add(() -> StructureFeature.RUINED_PORTAL);
                if (ModList.get().isLoaded("iceandfire")) {
                }
            }
            if (biome.contains("edge")) {


                //event.getGeneration().getStructures().add(() -> ATMConfiguredStructures.CONFIGURED_VILLAGE);

                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> TreePlacements.MEGA_PINE_CHECKED);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> TreePlacements.MEGA_SPRUCE_CHECKED);
                if (ModList.get().isLoaded("iceandfire")) {


                }
            }
            if (biome.equals("nether_wastes")) {
                if (ModList.get().isLoaded("byg")) {
                }
                if (ModList.get().isLoaded("iceandfire")) {
                }
            }

            if (biome.equals("warped_forest")) {

                //event.getGeneration().getStructures().add(() -> ATMConfiguredStructures.CONFIGURED_PYRAMID);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> NetherPlacements.WARPED_FOREST_VEGETATION);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> NetherPlacements.WEEPING_VINES);

                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> TreePlacements.WARPED_FUNGI);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> NetherPlacements.NETHER_SPROUTS);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> NetherPlacements.TWISTING_VINES);
                if (ModList.get().isLoaded("byg")) {
                }
                if (ModList.get().isLoaded("iceandfire")) {


                }

            }
            if (biome.contains("soul_sand")) {
                if (ModList.get().isLoaded("byg")) {
                }
                if (ModList.get().isLoaded("iceandfire")) {

                }
            }
            if (biome.equals("the_other")) {

                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> NetherPlacements.WEEPING_VINES);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> NetherPlacements.CRIMSON_FOREST_VEGETATION);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> NetherPlacements.PATCH_CRIMSON_ROOTS);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> TreePlacements.CRIMSON_FUNGI);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> VegetationPlacements.RED_MUSHROOM_NETHER);
                if (ModList.get().isLoaded("byg")) {
                }
                if (ModList.get().isLoaded("iceandfire")) {

                }
            }
            if ((biome.equals("crimson_forest")) || (biome.equals("warped_forest"))) {
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATMPlacedFeature.ORE_VIBRANIUM);
            }
            if (event.getName().getPath().equals("end_highlands")) {
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATMPlacedFeature.ORE_UNOBTAINIUM);
            }

        }

    }
}
