package com.thevortex.allthemodium.worldgen;

import com.github.alexthe666.iceandfire.IafConfig;
import com.github.alexthe666.iceandfire.entity.IafEntityRegistry;
import com.github.alexthe666.iceandfire.world.IafWorldRegistry;
import com.thevortex.allthemodium.reference.Reference;
import corgiaoc.byg.core.world.BYGConfiguredFeatures;
import corgiaoc.byg.core.world.BYGFeatures;
import net.allthemods.alltheores.AllTheOres;
import net.allthemods.alltheores.worldgen.ATOConfiguredFeature;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.RuinedPortalFeature;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.*;
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
        if(event.getCategory() == Biome.Category.OCEAN) {
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATMConfiguredFeature.ORE_ALLTHEMODIUM);
        }
        if(event.getCategory() == Biome.Category.NETHER) {
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATMConfiguredFeature.SOUL_LAVA_SPRING);
        }
        if((event.getCategory() == Biome.Category.NETHER) && (mod.equals(Reference.MOD_ID))) {
            //Allthemodium(Vibranium/Soul Lava)
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATMConfiguredFeature.ORE_OTHER_VIBRANIUM);
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATMConfiguredFeature.SOUL_LAVA_SPRING);
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATMConfiguredFeature.SOUL_LAVA_SPRING);
            if(ModList.get().isLoaded("alltheores")) {
                //Alltheores
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_OTHER_ALUMINUM);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_OTHER_COPPER);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_OTHER_LEAD);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_OTHER_NICKEL);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_OTHER_OSMIUM);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_OTHER_PLATINUM);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_OTHER_SILVER);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_OTHER_TIN);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_OTHER_URANIUM);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_OTHER_ZINC);

                //ATO Vanilla Other Ores
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_OTHER_COAL);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_OTHER_DIAMOND);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_OTHER_REDSTONE);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_OTHER_IRON);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_OTHER_LAPIS);
            }
            //Generic Nether Features
            event.getGeneration().getFeatures(GenerationStage.Decoration.LAKES).add(() -> Features.LAKE_LAVA);
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_STRUCTURES).add(() -> Features.MONSTER_ROOM);

            event.getGeneration().getStructures().add(() -> FortressStructure.NETHER_BRIDGE.configured(NoFeatureConfig.NONE));

            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_DIRT);
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_GRAVEL);
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> Features.GLOWSTONE);
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> Features.GLOWSTONE_EXTRA);
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_BLACKSTONE);
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_QUARTZ_NETHER);
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_GOLD_NETHER);

            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_DEBRIS_LARGE);
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_DEBRIS_SMALL);

            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION).add(() -> Features.DISK_SAND);
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION).add(() -> Features.DISK_CLAY);
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION).add(() -> Features.DISK_GRAVEL);

            event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> Features.SPRING_OPEN);
            event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> Features.PATCH_FIRE);
            event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> Features.PATCH_SOUL_FIRE);
            event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> Features.SPRING_LAVA);

            //Biome Specific Features
            if(biome.contains("badlands")){
                event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> Features.PATCH_DEAD_BUSH_BADLANDS);
                event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> Features.PATCH_CACTUS_DESERT);
                if(ModList.get().isLoaded("iceandfire")) {
                    event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_STRUCTURES).add(() -> IafWorldRegistry.MYRMEX_HIVE_DESERT_CF);
                    event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> IafWorldRegistry.SPAWN_DRAGON_SKELETON_L_CF);
                    event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> IafWorldRegistry.SPAWN_DRAGON_SKELETON_I_CF);
                    event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> IafWorldRegistry.SPAWN_DRAGON_SKELETON_F_CF);
                }
            }
            if(biome.equals("crimson_forest")) {
                event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> Features.WEEPING_VINES);
                event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> Features.CRIMSON_FOREST_VEGETATION);
                event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> Features.PATCH_CRIMSON_ROOTS);
                event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> Features.CRIMSON_FUNGI);
                event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> Features.CRIMSON_FUNGI_PLANTED);
                event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> Features.RED_MUSHROOM_NETHER);
                if(ModList.get().isLoaded("byg")) {
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> BYGConfiguredFeatures.CRIMSON_ROOTS_TALL);
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> BYGConfiguredFeatures.CRIMSON_BERRY_BUSH);
                }
                if(ModList.get().isLoaded("iceandfire")) {
                    event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> IafWorldRegistry.PIXIE_VILLAGE_CF);

                }
            }
            if(biome.equals("basalt_deltas")) {
                event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> Features.DELTA);
                event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> Features.SMALL_BASALT_COLUMNS);
                event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> Features.LARGE_BASALT_COLUMNS);
                if(ModList.get().isLoaded("byg")) {
                    event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> BYGConfiguredFeatures.VOLCANO);
                }
                if(ModList.get().isLoaded("iceandfire")) {
                    event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> IafWorldRegistry.FIRE_DRAGON_ROOST_CF);
                    event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_STRUCTURES).add(() -> IafWorldRegistry.FIRE_DRAGON_CAVE_CF);
                }
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION).add(() -> Features.BASALT_BLOBS);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION).add(() -> Features.BLACKSTONE_BLOBS);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION).add(() -> Features.SPRING_DELTA);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_MAGMA);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_GOLD_DELTAS);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_QUARTZ_DELTAS);

                event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> Features.SPRING_LAVA_DOUBLE);
            }
            if(biome.equals("gravelly_mountains")){
                if(ModList.get().isLoaded("iceandfire")) {
                    event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> IafWorldRegistry.CYCLOPS_CAVE_CF);

                }
            }
            if(biome.contains("desert")){
                event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> Features.PATCH_DEAD_BUSH_2);
                event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> Features.PATCH_CACTUS_DESERT);
                event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> Features.WELL);
                if(ModList.get().isLoaded("iceandfire")) {
                    event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> IafWorldRegistry.LIGHTNING_DRAGON_ROOST_CF);
                    event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_STRUCTURES).add(() -> IafWorldRegistry.LIGHTNING_DRAGON_CAVE_CF);

                }
            }
            if(biome.contains("edge")){
                event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> Features.TREES_GIANT);
                event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> Features.TREES_MOUNTAIN_EDGE);
                if(ModList.get().isLoaded("iceandfire")) {
                    event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(IafEntityRegistry.TROLL, 150, 1, 3));
                    event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> IafWorldRegistry.HYDRA_CAVE_CF);
                    event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_STRUCTURES).add(() -> IafWorldRegistry.MYRMEX_HIVE_JUNGLE_CF);
                }
            }
            if(biome.equals("nether_wastes")) {
                if(ModList.get().isLoaded("byg")) {
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> BYGConfiguredFeatures.RANDOM_NIGHTSHADE_PLANT);
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> BYGConfiguredFeatures.RANDOM_NIGHTSHADE_TREE);
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> BYGConfiguredFeatures.RANDOM_NIGHTSHADE_BUSH);

                }
            }
            if(biome.equals("mountains")){
                if(ModList.get().isLoaded("iceandfire")) {
                    event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> IafWorldRegistry.ICE_DRAGON_ROOST_CF);
                    event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_STRUCTURES).add(() -> IafWorldRegistry.ICE_DRAGON_CAVE_CF);
                }
            }
            if(biome.equals("the_other")){
                if(ModList.get().isLoaded("iceandfire")) {

                }
            }
            if(biome.equals("warped_forest")) {

                event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> Features.WARPED_FOREST_VEGETATION);
                event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> Features.WARPED_FUNGI);
                event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> Features.WARPED_FUNGI_PLANTED);
                event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> Features.NETHER_SPROUTS);
                event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> Features.TWISTING_VINES);
                if(ModList.get().isLoaded("byg")) {
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> BYGConfiguredFeatures.WARPED_BUSH);
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> BYGConfiguredFeatures.WARPED_FUNGUS1);
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> BYGConfiguredFeatures.WARPED_FUNGUS2);
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> BYGConfiguredFeatures.RANDOM_WAILING_VEGETATION);
                }
                if(ModList.get().isLoaded("iceandfire")) {
                    event.getGeneration().addStructureStart(IafWorldRegistry.GORGON_TEMPLE_CF);


                }

            }
            if(biome.contains("soul_sand")) {
                if (ModList.get().isLoaded("byg")) {
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> BYGConfiguredFeatures.RANDOM_SOUL_SHROOM_TREES);
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> BYGConfiguredFeatures.HANGING_SOUL_SHROOM_SPORES);
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> BYGConfiguredFeatures.SOUL_SHROOM);
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> BYGConfiguredFeatures.SOUL_SOIL_PILLARS);
                }
                if(ModList.get().isLoaded("iceandfire")) {
                    event.getGeneration().getStructures().add(() -> IafWorldRegistry.GRAVEYARD_CF);
                    event.getGeneration().addStructureStart(IafWorldRegistry.GRAVEYARD_CF).build();

                }
            }
            if(biome.equals("the_other")){
                if(ModList.get().isLoaded("iceandfire")) {
                    event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(IafEntityRegistry.DREAD_BEAST,150,1,1));
                    event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(IafEntityRegistry.AMPHITHERE,150,1,1));
                    event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(IafEntityRegistry.HIPPOGRYPH,150,1,1));
                }
            }
        }
        if((mod.equals(Reference.MOD_ID)) && (biome.equals("mining"))) {
            //Allthemodium ore
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATMConfiguredFeature.ORE_ATM_MINING);
            if(ModList.get().isLoaded("alltheores")) {
                //Alltheores
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_ALUMINUM);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_COPPER);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_LEAD);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_NICKEL);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_OSMIUM);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_PLATINUM);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_SILVER);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_TIN);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_URANIUM);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATOConfiguredFeature.ORE_ZINC);
            }
            //Vanilla Ores
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_COAL);
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_DIAMOND);
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_GOLD);
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_IRON);
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_LAPIS);
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_EMERALD);
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> Features.ORE_REDSTONE);

        }
        if((biome.equals("crimson_forest")) || (biome.equals("warped_forest"))){
            if(mod.equals(Reference.MOD_ID)) {
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATMConfiguredFeature.ORE_OTHER_VIBRANIUM);
            } else {
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATMConfiguredFeature.ORE_VIBRANIUM);
            }
        }
        if(event.getName().getPath().equals("end_highlands")) {
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ATMConfiguredFeature.ORE_UNOBTAINIUM);
        }

    }

}
