package com.thevortex.allthemodium.registry;

import com.thevortex.allthemodium.AllTheModium;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

import static com.thevortex.allthemodium.AllTheModium.MINING_DIM_ID;
import static com.thevortex.allthemodium.AllTheModium.THE_OTHER_DIM_ID;

public class LevelRegistry {
    public static final ResourceKey<Level> Mining = ResourceKey.create(Registries.DIMENSION, MINING_DIM_ID);

    public static final ResourceKey<Level> THE_OTHER = ResourceKey.create(Registries.DIMENSION, THE_OTHER_DIM_ID);

}
