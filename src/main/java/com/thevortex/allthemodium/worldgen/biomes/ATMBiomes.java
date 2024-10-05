package com.thevortex.allthemodium.worldgen.biomes;

import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.NetherPlacements;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ATMBiomes {

    public static Biome The_Other = the_other();
    public static Biome Basalt_Deltas = basalt_deltas();
    public static Biome Crimson_Forest = crimson_forest();
    public static Biome Desert = desert();
    public static Biome Desert_Hills = desert_hills();
    public static Biome Soul_Sand_Valley = soul_sand_valley();
    public static Biome Warped_Forest = warped_forest();

    public static void addDefaultCarvers(
            BiomeGenerationSettings.Builder builder) {
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.NETHER_CAVE);
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CANYON);
    }

    public static Biome mining() {
        return new Biome.BiomeBuilder()
                .precipitation(Biome.Precipitation.NONE)
                .mobSpawnSettings(new MobSpawnSettings.Builder().build())
                .temperature(1.0f)
                .downfall(0f)
                .specialEffects(
                        new BiomeSpecialEffects.Builder()
                                .fogColor(12341234)
                                .waterColor(4159204)
                                .waterFogColor(329011)
                                .skyColor(7254527)
                                .foliageColorOverride(1787717)
                                .grassColorOverride(9470000)
                                .build())
                .generationSettings(new BiomeGenerationSettings.Builder().build())
                .build();
    }

    public static Biome the_other() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
                .fogColor(3343107)
                .waterColor(3343107)
                .waterFogColor(3343107)
                .skyColor(3343107)
                .foliageColorOverride(1787717)
                .grassColorOverride(1787717)
                .build();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.addDripstone(biomeGenerationSettings);
        addDefaultCarvers(biomeGenerationSettings);

        MobSpawnSettings mobSpawnInfo = (new MobSpawnSettings.Builder()).addSpawn(
                MobCategory.MONSTER,
                new MobSpawnSettings.SpawnerData(
                        EntityType.WITHER_SKELETON,
                        100,
                        5,
                        10))
                .addSpawn(
                        MobCategory.MONSTER,
                        new MobSpawnSettings.SpawnerData(
                                EntityType.BLAZE,
                                120,
                                3,
                                5))
                .addSpawn(
                        MobCategory.MONSTER,
                        new MobSpawnSettings.SpawnerData(
                                EntityType.PIGLIN,
                                140,
                                8,
                                12))
                .build();

        return new Biome.BiomeBuilder()
                .precipitation(Biome.Precipitation.NONE)
                .mobSpawnSettings(mobSpawnInfo)
                .temperature(1.5f)
                .downfall(0f)
                .specialEffects(effects)
                .generationSettings(biomeGenerationSettings.build())
                .build();
    }

    public static Biome basalt_deltas() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
                .fogColor(6840176)
                .waterColor(3343107)
                .waterFogColor(3343107)
                .skyColor(3343107)
                .foliageColorOverride(1787717)
                .grassColorOverride(1787717)
                .build();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.addLushCavesVegetationFeatures(
                biomeGenerationSettings);
        addDefaultCarvers(biomeGenerationSettings);
        biomeGenerationSettings.addFeature(
                GenerationStep.Decoration.LOCAL_MODIFICATIONS,
                NetherPlacements.BASALT_BLOBS);
        biomeGenerationSettings.addFeature(
                GenerationStep.Decoration.LOCAL_MODIFICATIONS,
                NetherPlacements.SMALL_BASALT_COLUMNS);
        biomeGenerationSettings.addFeature(
                GenerationStep.Decoration.LOCAL_MODIFICATIONS,
                NetherPlacements.LARGE_BASALT_COLUMNS);

        MobSpawnSettings mobSpawnInfo = (new MobSpawnSettings.Builder()).addSpawn(
                MobCategory.MONSTER,
                new MobSpawnSettings.SpawnerData(
                        EntityType.MAGMA_CUBE,
                        100,
                        5,
                        10))
                .addSpawn(
                        MobCategory.MONSTER,
                        new MobSpawnSettings.SpawnerData(
                                EntityType.BLAZE,
                                120,
                                3,
                                5))
                .addSpawn(
                        MobCategory.MONSTER,
                        new MobSpawnSettings.SpawnerData(
                                EntityType.PIGLIN,
                                140,
                                8,
                                12))
                .build();

        return new Biome.BiomeBuilder()
                .precipitation(Biome.Precipitation.NONE)
                .mobSpawnSettings(mobSpawnInfo)
                .temperature(2.0f)
                .downfall(0f)
                .specialEffects(effects)
                .generationSettings(biomeGenerationSettings.build())
                .build();
    }

    public static Biome crimson_forest() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
                .fogColor(3343107)
                .waterColor(3343107)
                .waterFogColor(3343107)
                .skyColor(3343107)
                .foliageColorOverride(1787717)
                .grassColorOverride(1787717)
                .build();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.addDripstone(biomeGenerationSettings);
        addDefaultCarvers(biomeGenerationSettings);

        MobSpawnSettings mobSpawnInfo = (new MobSpawnSettings.Builder()).addSpawn(
                MobCategory.MONSTER,
                new MobSpawnSettings.SpawnerData(
                        EntityType.WITHER_SKELETON,
                        100,
                        5,
                        10))
                .addSpawn(
                        MobCategory.MONSTER,
                        new MobSpawnSettings.SpawnerData(
                                EntityType.BLAZE,
                                120,
                                3,
                                5))
                .addSpawn(
                        MobCategory.MONSTER,
                        new MobSpawnSettings.SpawnerData(
                                EntityType.PIGLIN,
                                140,
                                8,
                                12))
                .build();

        return new Biome.BiomeBuilder()
                .precipitation(Biome.Precipitation.NONE)
                .mobSpawnSettings(mobSpawnInfo)
                .temperature(1.3f)
                .downfall(0f)
                .specialEffects(effects)
                .generationSettings(biomeGenerationSettings.build())
                .build();
    }

    public static Biome desert() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
                .fogColor(3343107)
                .waterColor(3343107)
                .waterFogColor(3343107)
                .skyColor(3343107)
                .foliageColorOverride(1787717)
                .grassColorOverride(1787717)
                .build();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.addDripstone(biomeGenerationSettings);
        addDefaultCarvers(biomeGenerationSettings);

        MobSpawnSettings mobSpawnInfo = (new MobSpawnSettings.Builder()).addSpawn(
                MobCategory.MONSTER,
                new MobSpawnSettings.SpawnerData(
                        EntityType.WITHER_SKELETON,
                        100,
                        5,
                        10))
                .addSpawn(
                        MobCategory.CREATURE,
                        new MobSpawnSettings.SpawnerData(
                                EntityType.RABBIT,
                                120,
                                3,
                                5))
                .addSpawn(
                        MobCategory.MONSTER,
                        new MobSpawnSettings.SpawnerData(
                                EntityType.PIGLIN,
                                140,
                                8,
                                12))
                .build();

        return new Biome.BiomeBuilder()
                .precipitation(Biome.Precipitation.NONE)
                .mobSpawnSettings(mobSpawnInfo)
                .temperature(1.8f)
                .downfall(0f)
                .specialEffects(effects)
                .generationSettings(biomeGenerationSettings.build())
                .build();
    }

    public static Biome desert_hills() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
                .fogColor(3343107)
                .waterColor(3343107)
                .waterFogColor(3343107)
                .skyColor(3343107)
                .foliageColorOverride(1787717)
                .grassColorOverride(1787717)
                .build();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.addDripstone(biomeGenerationSettings);
        addDefaultCarvers(biomeGenerationSettings);

        MobSpawnSettings mobSpawnInfo = (new MobSpawnSettings.Builder()).addSpawn(
                MobCategory.MONSTER,
                new MobSpawnSettings.SpawnerData(
                        EntityType.WITHER_SKELETON,
                        100,
                        5,
                        10))
                .addSpawn(
                        MobCategory.CREATURE,
                        new MobSpawnSettings.SpawnerData(
                                EntityType.RABBIT,
                                120,
                                3,
                                5))
                .addSpawn(
                        MobCategory.MONSTER,
                        new MobSpawnSettings.SpawnerData(
                                EntityType.PIGLIN,
                                140,
                                8,
                                12))
                .build();

        return new Biome.BiomeBuilder()
                .precipitation(Biome.Precipitation.NONE)
                .mobSpawnSettings(mobSpawnInfo)
                .temperature(1.7f)
                .downfall(0f)
                .specialEffects(effects)
                .generationSettings(biomeGenerationSettings.build())
                .build();
    }

    public static Biome soul_sand_valley() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
                .fogColor(3343107)
                .waterColor(3343107)
                .waterFogColor(3343107)
                .skyColor(3343107)
                .foliageColorOverride(1787717)
                .grassColorOverride(1787717)
                .build();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.addDripstone(biomeGenerationSettings);
        addDefaultCarvers(biomeGenerationSettings);

        MobSpawnSettings mobSpawnInfo = (new MobSpawnSettings.Builder()).addSpawn(
                MobCategory.MONSTER,
                new MobSpawnSettings.SpawnerData(
                        EntityType.WITHER_SKELETON,
                        100,
                        5,
                        10))
                .addSpawn(
                        MobCategory.MONSTER,
                        new MobSpawnSettings.SpawnerData(
                                EntityType.GHAST,
                                120,
                                3,
                                3))
                .addSpawn(
                        MobCategory.MONSTER,
                        new MobSpawnSettings.SpawnerData(
                                EntityType.PIGLIN,
                                140,
                                8,
                                12))
                .build();

        return new Biome.BiomeBuilder()
                .precipitation(Biome.Precipitation.NONE)
                .mobSpawnSettings(mobSpawnInfo)
                .temperature(1.1f)
                .downfall(0f)
                .specialEffects(effects)
                .generationSettings(biomeGenerationSettings.build())
                .build();
    }

    public static Biome warped_forest() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
                .fogColor(1705242)
                .waterColor(3343107)
                .waterFogColor(3343107)
                .skyColor(1705242)
                .foliageColorOverride(1787717)
                .grassColorOverride(1787717)
                .build();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.addDripstone(biomeGenerationSettings);
        addDefaultCarvers(biomeGenerationSettings);

        MobSpawnSettings mobSpawnInfo = (new MobSpawnSettings.Builder()).addSpawn(
                MobCategory.MONSTER,
                new MobSpawnSettings.SpawnerData(
                        EntityType.WITHER_SKELETON,
                        100,
                        5,
                        10))
                .addSpawn(
                        MobCategory.MONSTER,
                        new MobSpawnSettings.SpawnerData(
                                EntityType.ENDERMAN,
                                160,
                                3,
                                7))
                .addSpawn(
                        MobCategory.MONSTER,
                        new MobSpawnSettings.SpawnerData(
                                EntityType.PIGLIN_BRUTE,
                                140,
                                8,
                                12))
                .build();

        return new Biome.BiomeBuilder()
                .precipitation(Biome.Precipitation.NONE)
                .mobSpawnSettings(mobSpawnInfo)
                .temperature(1.2f)
                .downfall(0f)
                .specialEffects(effects)
                .generationSettings(biomeGenerationSettings.build())
                .build();
    }
}
