package com.thevortex.allthemodium.registry;



import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

import static com.thevortex.allthemodium.AllTheModium.*;

public class LevelRegistry {
    public static final ResourceKey<Level> Mining = ResourceKey.create(Registries.DIMENSION, MINING_DIM_ID);

    public static final ResourceKey<Level> THE_OTHER = ResourceKey.create(Registries.DIMENSION, THE_OTHER_DIM_ID);
    public static final ResourceKey<Level> THE_BEYOND = ResourceKey.create(Registries.DIMENSION, THE_BEYOND_DIM_ID);
}
