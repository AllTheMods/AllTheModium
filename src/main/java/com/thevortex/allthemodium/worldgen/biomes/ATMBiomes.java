package com.thevortex.allthemodium.worldgen.biomes;

import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class ATMBiomes {
    public static final ResourceKey<Biome> THE_OTHER = register("the_other");
    public static final ResourceKey<Biome> BASALT_DELTAS = register("basalt_deltas");
    public static final ResourceKey<Biome> CRIMSON_FOREST = register("crimson_forest");
    public static final ResourceKey<Biome> DESERT = register("desert");
    public static final ResourceKey<Biome> DESERT_HILLS = register("desert_hills");
    public static final ResourceKey<Biome> SOUL_SAND_VALLEY = register("soul_sand_valley");
    public static final ResourceKey<Biome> WARPED_FOREST = register("warped_forest");

    private static ResourceKey<Biome> register(String names) {
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Reference.MOD_ID,names));
    }
}
