package com.thevortex.allthemodium.worldgen;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.FlatLevelSource;
import net.minecraft.world.level.levelgen.flat.FlatLevelGeneratorSettings;
import net.minecraft.world.level.levelgen.structure.StructureSet;

public class MiningDimSource extends FlatLevelSource {

    public static final Codec<MiningDimSource> CODEC = RecordCodecBuilder.create(p_204551_ -> {
        return commonCodec(p_204551_)
                .and(
                        FlatLevelGeneratorSettings.CODEC
                                .fieldOf("settings")
                                .forGetter(FlatLevelSource::settings))
                .apply(p_204551_, p_204551_.stable(MiningDimSource::new));
    });
    private final FlatLevelGeneratorSettings settings;

    public MiningDimSource(
            Registry<StructureSet> structureSetRegistry,
            FlatLevelGeneratorSettings settings) {
        super(structureSetRegistry, settings);
        this.settings = settings;
    }

    @Override
    protected Codec<? extends ChunkGenerator> codec() {
        return CODEC;
    }

    @Override
    public FlatLevelGeneratorSettings settings() {
        return this.settings;
    }

    public int getMinY() {
        return -64;
    }
}
