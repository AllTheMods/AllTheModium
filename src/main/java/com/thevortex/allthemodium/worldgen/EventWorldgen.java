package com.thevortex.allthemodium.worldgen;


import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.worldgen.structures.ATMConfiguredStructures;
import net.allthemods.alltheores.worldgen.ATOConfiguredFeature;
import net.minecraft.data.worldgen.Features;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.NetherFortressFeature;
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
        if (event.getCategory() == Biome.BiomeCategory.DESERT) {
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATMConfiguredFeature.ORE_ALLTHEMODIUM);
        }
        if ((mod.equals(Reference.MOD_ID)) && (biome.equals("mining"))) {
            //Allthemodium ore
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATMConfiguredFeature.ORE_ATM_MINING);
            if (ModList.get().isLoaded("alltheores")) {
                //Alltheores

                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_ALUMINUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_LEAD);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_NICKEL);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_OSMIUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_PLATINUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_SILVER);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_TIN);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_URANIUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_ZINC);


            }
            //Vanilla Ores
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_COAL);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_COPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_DIAMOND);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_GOLD);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_IRON);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_LAPIS);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_EMERALD);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_REDSTONE);

            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.PROTOTYPE_ORE_COAL_LOWER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.PROTOTYPE_ORE_COPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.PROTOTYPE_ORE_COAL_UPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.PROTOTYPE_ORE_DIAMOND);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.PROTOTYPE_ORE_GOLD);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.PROTOTYPE_ORE_IRON_MIDDLE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.PROTOTYPE_ORE_IRON_UPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.PROTOTYPE_ORE_LAPIS_BURIED);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.PROTOTYPE_ORE_EMERALD);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.PROTOTYPE_ORE_REDSTONE_LOWER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.PROTOTYPE_ORE_REDSTONE);


        }

        if ((event.getCategory() == Biome.BiomeCategory.NETHER) && (mod.equals(Reference.MOD_ID))) {
            //Allthemodium(Vibranium/Soul Lava)
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATMConfiguredFeature.ORE_ALLTHEMODIUM);
            if (ModList.get().isLoaded("alltheores")) {
                //Alltheores

                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_ALUMINUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_LEAD);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_NICKEL);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_OSMIUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_PLATINUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_SILVER);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_TIN);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_URANIUM);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_ZINC);

                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.NETHER_ORE_ALUMINUM.rangeTriangle(VerticalAnchor.aboveBottom(120),VerticalAnchor.belowTop(50)));
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.NETHER_ORE_LEAD.rangeTriangle(VerticalAnchor.aboveBottom(64),VerticalAnchor.belowTop(150)));
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.NETHER_ORE_NICKEL.rangeTriangle(VerticalAnchor.aboveBottom(64),VerticalAnchor.belowTop(175)));
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.NETHER_ORE_OSMIUM.rangeTriangle(VerticalAnchor.aboveBottom(64),VerticalAnchor.belowTop(175)));
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.NETHER_ORE_PLATINUM.rangeTriangle(VerticalAnchor.aboveBottom(64),VerticalAnchor.belowTop(175)));
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.NETHER_ORE_SILVER.rangeTriangle(VerticalAnchor.aboveBottom(64),VerticalAnchor.belowTop(175)));
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.NETHER_ORE_TIN.rangeTriangle(VerticalAnchor.aboveBottom(64),VerticalAnchor.belowTop(175)));
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.NETHER_ORE_URANIUM.rangeTriangle(VerticalAnchor.aboveBottom(64),VerticalAnchor.belowTop(175)));
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.NETHER_ORE_ZINC.rangeTriangle(VerticalAnchor.aboveBottom(64),VerticalAnchor.belowTop(175)));

                //ATO Vanilla Other Ores
            }
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_COAL);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_COPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_DIAMOND);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_GOLD);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_IRON);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_LAPIS);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_EMERALD);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_REDSTONE);

            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.PROTOTYPE_ORE_COAL_LOWER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.PROTOTYPE_ORE_COPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.PROTOTYPE_ORE_COAL_UPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.PROTOTYPE_ORE_DIAMOND);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.PROTOTYPE_ORE_GOLD);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.PROTOTYPE_ORE_IRON_MIDDLE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.PROTOTYPE_ORE_IRON_UPPER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.PROTOTYPE_ORE_LAPIS_BURIED);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.PROTOTYPE_ORE_EMERALD);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.PROTOTYPE_ORE_REDSTONE_LOWER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.PROTOTYPE_ORE_REDSTONE);

            //Generic Nether Features
            event.getGeneration().getFeatures(GenerationStep.Decoration.LAKES).add(() -> Features.LAKE_WATER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.LAKES).add(() -> Features.LAKE_LAVA);
            event.getGeneration().getFeatures(GenerationStep.Decoration.LAKES).add(() -> Features.SPRING_LAVA);
            event.getGeneration().getFeatures(GenerationStep.Decoration.LAKES).add(() -> Features.SPRING_LAVA_DOUBLE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.LAKES).add(() -> Features.SPRING_LAVA_DOUBLE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.BROWN_MUSHROOM_GIANT);
            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.RED_MUSHROOM_GIANT);



            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_STRUCTURES).add(() -> Features.MONSTER_ROOM);

            event.getGeneration().getStructures().add(() -> NetherFortressFeature.NETHER_BRIDGE.configured(FeatureConfiguration.NONE));
            event.getGeneration().getStructures().add(() -> StructureFeatures.BASTION_REMNANT);
            event.getGeneration().getStructures().add(() -> StructureFeatures.MINESHAFT);
            event.getGeneration().getStructures().add(() -> StructureFeatures.PILLAGER_OUTPOST);

            event.getGeneration().getFeatures(GenerationStep.Decoration.LOCAL_MODIFICATIONS).add(() -> Features.LARGE_DRIPSTONE_FEATURE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.DRIPSTONE_CLUSTER_FEATURE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.RARE_DRIPSTONE_CLUSTER_FEATURE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.RARE_DRIPSTONE_CLUSTER_FEATURE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.TOP_LAYER_MODIFICATION).add(() -> Features.PATCH_TALL_GRASS_2);
            event.getGeneration().getFeatures(GenerationStep.Decoration.TOP_LAYER_MODIFICATION).add(() -> Features.PROTOTYPE_GLOW_LICHEN);

            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.RARE_DRIPSTONE_CLUSTER_FEATURE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.RARE_DRIPSTONE_CLUSTER_FEATURE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.TOP_LAYER_MODIFICATION).add(() -> Features.PATCH_TALL_GRASS_2);
            event.getGeneration().getFeatures(GenerationStep.Decoration.TOP_LAYER_MODIFICATION).add(() -> Features.PROTOTYPE_GLOW_LICHEN);
            event.getGeneration().getFeatures(GenerationStep.Decoration.TOP_LAYER_MODIFICATION).add(() -> Features.LUSH_CAVES_CEILING_VEGETATION);
            event.getGeneration().getFeatures(GenerationStep.Decoration.TOP_LAYER_MODIFICATION).add(() -> Features.CAVE_VINES);
            event.getGeneration().getFeatures(GenerationStep.Decoration.TOP_LAYER_MODIFICATION).add(() -> Features.LUSH_CAVES_CLAY);
            event.getGeneration().getFeatures(GenerationStep.Decoration.TOP_LAYER_MODIFICATION).add(() -> Features.LUSH_CAVES_VEGETATION);
            event.getGeneration().getFeatures(GenerationStep.Decoration.TOP_LAYER_MODIFICATION).add(() -> Features.ROOTED_AZALEA_TREES);
            event.getGeneration().getFeatures(GenerationStep.Decoration.TOP_LAYER_MODIFICATION).add(() -> Features.SPORE_BLOSSOM_FEATURE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.TOP_LAYER_MODIFICATION).add(() -> Features.CLASSIC_VINES_CAVE_FEATURE);

            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_DIRT);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_GRAVEL);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.GLOWSTONE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.GLOWSTONE_EXTRA);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_BLACKSTONE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_QUARTZ_NETHER);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_GOLD_NETHER);

            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_DEBRIS_LARGE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_DEBRIS_SMALL);

            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_DECORATION).add(() -> Features.DISK_SAND);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_DECORATION).add(() -> Features.DISK_CLAY);
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_DECORATION).add(() -> Features.DISK_GRAVEL);

            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.SPRING_OPEN);
            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.PATCH_FIRE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.PATCH_SOUL_FIRE);
            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.SPRING_LAVA);


            //Biome Specific Features
            if (biome.contains("badlands")) {
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.PATCH_DEAD_BUSH_BADLANDS);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.PATCH_CACTUS_DESERT);
                event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> ATMConfiguredFeature.MOD_DELTAS);
                event.getGeneration().getStructures().add(() -> StructureFeatures.MINESHAFT_MESA);
                event.getGeneration().getStructures().add(() -> StructureFeatures.NETHER_FOSSIL);
                event.getGeneration().getStructures().add(() -> StructureFeatures.VILLAGE_SAVANNA);

                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.DARK_OAK);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.DARK_FOREST_VEGETATION_BROWN);
                if (ModList.get().isLoaded("iceandfire")) {
                }
            }
            if (biome.equals("crimson_forest")) {

                event.getGeneration().getStructures().add(() -> ATMConfiguredStructures.CONFIGURED_DUNGEON);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.WEEPING_VINES);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.CRIMSON_FOREST_VEGETATION);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.PATCH_CRIMSON_ROOTS);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.CRIMSON_FUNGI);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.CRIMSON_FUNGI_PLANTED);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.RED_MUSHROOM_NETHER);
                if (ModList.get().isLoaded("byg")) {
                }
                if (ModList.get().isLoaded("iceandfire")) {

                }
            }
            if (biome.equals("basalt_deltas")) {
                //event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> Features.DELTA);
                event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> Features.SMALL_BASALT_COLUMNS);
                event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> Features.LARGE_BASALT_COLUMNS);
                event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> ATMConfiguredFeature.VOLCANO_CF);
                event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> ATMConfiguredFeature.MOD_DELTAS);

                if (ModList.get().isLoaded("byg")) {
                    //event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> BYGConfiguredFeatures.VOLCANO);
                }
                if (ModList.get().isLoaded("iceandfire")) {
                }
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_DECORATION).add(() -> Features.BASALT_BLOBS);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_DECORATION).add(() -> Features.BLACKSTONE_BLOBS);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_DECORATION).add(() -> Features.SPRING_DELTA);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_MAGMA);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_GOLD_DELTAS);
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_QUARTZ_DELTAS);

                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.SPRING_LAVA_DOUBLE);
            }
            if (biome.contains("mountain")) {

                event.getGeneration().getStructures().add(() -> StructureFeatures.RUINED_PORTAL_MOUNTAIN);
                event.getGeneration().getStructures().add(() -> StructureFeatures.VILLAGE_TAIGA);
                if (ModList.get().isLoaded("iceandfire")) {
                }
            }
            if (biome.contains("desert")) {

                event.getGeneration().getStructures().add(() -> StructureFeatures.DESERT_PYRAMID);
                event.getGeneration().getStructures().add(() -> StructureFeatures.VILLAGE_DESERT);
                event.getGeneration().getStructures().add(() -> StructureFeatures.SHIPWRECH_BEACHED);
                event.getGeneration().getStructures().add(() -> StructureFeatures.RUINED_PORTAL_DESERT);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.PATCH_DEAD_BUSH_2);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.PATCH_CACTUS_DESERT);
                event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> Features.WELL);
                if (ModList.get().isLoaded("iceandfire")) {
                }
            }
            if (biome.contains("edge")) {


                event.getGeneration().getStructures().add(() -> ATMConfiguredStructures.CONFIGURED_VILLAGE);

                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.TREES_GIANT);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.TREES_MOUNTAIN_EDGE);
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

                event.getGeneration().getStructures().add(() -> ATMConfiguredStructures.CONFIGURED_PYRAMID);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.WARPED_FOREST_VEGETATION);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.WARPED_FUNGI);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.WARPED_FUNGI_PLANTED);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.NETHER_SPROUTS);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.TWISTING_VINES);
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

                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.WEEPING_VINES);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.CRIMSON_FOREST_VEGETATION);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.PATCH_CRIMSON_ROOTS);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.CRIMSON_FUNGI);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.CRIMSON_FUNGI_PLANTED);
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> Features.RED_MUSHROOM_NETHER);
                if (ModList.get().isLoaded("byg")) {
                }
                if (ModList.get().isLoaded("iceandfire")) {

                }
            }
            if ((biome.equals("crimson_forest")) || (biome.equals("warped_forest"))) {
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATMConfiguredFeature.ORE_VIBRANIUM);
            }
            if (event.getName().getPath().equals("end_highlands")) {
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ATMConfiguredFeature.ORE_UNOBTAINIUM);
            }

        }

    }
}
