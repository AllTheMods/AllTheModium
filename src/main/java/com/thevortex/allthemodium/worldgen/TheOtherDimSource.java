package com.thevortex.allthemodium.worldgen;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryLookupCodec;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.FlatLevelSource;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.flat.FlatLevelGeneratorSettings;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.function.Supplier;

public class TheOtherDimSource extends NoiseBasedChunkGenerator {

    ; public static final Codec<NoiseBasedChunkGenerator> CODEC = RecordCodecBuilder.create((p_188643_) -> {
        return p_188643_.group(RegistryLookupCodec.create(Registry.NOISE_REGISTRY).forGetter((p_188716_) -> {
            return p_188716_.noises;
        }), BiomeSource.CODEC.fieldOf("biome_source").forGetter((p_188711_) -> {
            return p_188711_.biomeSource;
        }), Codec.LONG.fieldOf("seed").stable().forGetter((p_188690_) -> {
            return p_188690_.seed;
        }), NoiseGeneratorSettings.CODEC.fieldOf("settings").forGetter((p_188652_) -> {
            return p_188652_.settings;
        })).apply(p_188643_, p_188643_.stable(NoiseBasedChunkGenerator::new));
    });


    public TheOtherDimSource(Registry<NormalNoise.NoiseParameters> p_188609_, BiomeSource p_188610_, long p_188611_, Supplier<NoiseGeneratorSettings> p_188612_) {
        super(p_188609_, p_188610_, p_188611_, p_188612_);
    }
}