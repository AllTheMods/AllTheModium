package com.thevortex.allthemodium.worldgen;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryOps;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class TheOtherDimSource extends NoiseBasedChunkGenerator {

    public static final Codec<TheOtherDimSource> CODEC = RecordCodecBuilder.create(p_188643_ -> {
        return commonCodec(p_188643_)
                .and(
                        p_188643_.group(
                                RegistryOps
                                        .retrieveRegistry(Registry.NOISE_REGISTRY)
                                        .forGetter(p_188716_ -> {
                                            return p_188716_.noises;
                                        }),
                                BiomeSource.CODEC
                                        .fieldOf("biome_source")
                                        .forGetter(p_188711_ -> {
                                            return p_188711_.biomeSource;
                                        }),
                                NoiseGeneratorSettings.CODEC
                                        .fieldOf("settings")
                                        .forGetter(p_204585_ -> {
                                            return p_204585_.settings;
                                        })))
                .apply(p_188643_, p_188643_.stable(TheOtherDimSource::new));
    });

    public TheOtherDimSource(
            Registry<StructureSet> p_224206_,
            Registry<NormalNoise.NoiseParameters> p_224207_,
            BiomeSource p_224208_,
            Holder<NoiseGeneratorSettings> p_224209_) {
        super(p_224206_, p_224207_, p_224208_, p_224209_);
    }
}
