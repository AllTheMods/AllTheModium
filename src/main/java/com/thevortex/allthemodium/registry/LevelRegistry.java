package com.thevortex.allthemodium.registry;

import static com.thevortex.allthemodium.AllTheModium.MINING_DIM_ID;
import static com.thevortex.allthemodium.AllTheModium.THE_OTHER_DIM_ID;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

public class LevelRegistry {

    public static final ResourceKey<Level> Mining = ResourceKey.create(
            Registry.DIMENSION_REGISTRY,
            MINING_DIM_ID);

    public static final ResourceKey<Level> THE_OTHER = ResourceKey.create(
            Registry.DIMENSION_REGISTRY,
            THE_OTHER_DIM_ID);
}
