package com.thevortex.allthemodium.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.FlatLevelSource;
import net.minecraft.world.level.levelgen.flat.FlatLevelGeneratorSettings;

public class MiningDimSource extends FlatLevelSource {

    public static final Codec<MiningDimSource> CODEC = FlatLevelGeneratorSettings.CODEC.fieldOf("settings").xmap(MiningDimSource::new, MiningDimSource::settings).codec();


    public MiningDimSource(FlatLevelGeneratorSettings settings) {
        super(settings);
    }

    @Override
    protected Codec<? extends ChunkGenerator> codec() {
        return CODEC;
    }

    public int getMinY() {
        return -64;
    }
}