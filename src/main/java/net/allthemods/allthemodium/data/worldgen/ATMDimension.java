package net.allthemods.allthemodium.data.worldgen;

import com.mojang.datafixers.util.Pair;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

import net.allthemods.allthemodium.api.ATM;

import java.util.List;

public class ATMDimension {

    public static final ResourceKey<LevelStem> THE_OTHER = ATM.key(Registries.LEVEL_STEM, "the_other");

    public static void bootstrap(final BootstrapContext<LevelStem> ctx) {
        HolderGetter<Biome> biomes = ctx.lookup(Registries.BIOME);
        HolderGetter<NoiseGeneratorSettings> noiseSettings = ctx.lookup(Registries.NOISE_SETTINGS);
        HolderGetter<DimensionType> types = ctx.lookup(Registries.DIMENSION_TYPE);

        MultiNoiseBiomeSource biomeSource = MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<>(List.of(
                point(biomes, ATMBiomes.SOUL_SAND_VALLEY, -0.1F, 0.0F, -0.3F, 0.1F, 0.2F, 0.3F),
                point(biomes, ATMBiomes.THE_OTHER, 0.4F, 0.0F, 0.3F, 0.5F, 0.0F, 0.2F),
                point(biomes, ATMBiomes.DESERT, 0.6F, 0.0F, 0.1F, 0.9F, 0.0F, 0.0F),
                point(biomes, ATMBiomes.BASALT_DELTAS, 1.0F, 0.0F, 0.0F, 0.1F, 0.8F, 0.0F),
                point(biomes, ATMBiomes.WARPED_FOREST, 0.5F, 0.0F, -0.7F, 0.3F, 0.0F, 0.0F),
                point(biomes, ATMBiomes.DESERT_HILLS, 0.8F, 0.0F, 0.23F, 0.6F, 0.0F, 0.0F),
                point(biomes, ATMBiomes.CRIMSON_FOREST, 0.3F, 0.0F, 0.3F, 0.4F, 0.0F, 0.0F)
        )));

        NoiseBasedChunkGenerator generator = new NoiseBasedChunkGenerator(
                biomeSource,
                noiseSettings.getOrThrow(ATMNoiseSettings.THE_OTHER)
        );

        ctx.register(ATMDimension.THE_OTHER, new LevelStem(
                types.getOrThrow(ATMDimensions.THE_OTHER_TYPE),
                generator
        ));
    }

    private static Pair<Climate.ParameterPoint, Holder<Biome>> point(
            HolderGetter<Biome> biomes,
            ResourceKey<Biome> biome,
            float temperature,
            float humidity,
            float continentalness,
            float erosion,
            float depth,
            float weirdness
    ) {
        return Pair.of(
                Climate.parameters(temperature, humidity, continentalness, erosion, depth, weirdness, 0.0F),
                biomes.getOrThrow(biome)
        );
    }
}
