package com.thevortex.allthemodium.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class VolcanoConfig implements FeatureConfiguration {

        public static final Codec<VolcanoConfig> CODEC;
        public static final VolcanoConfig INSTANCE = new VolcanoConfig();

        static {
            CODEC = Codec.unit(() -> {
                return INSTANCE;
            });
        }

}
