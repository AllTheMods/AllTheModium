package com.thevortex.allthemodium.worldgen.biomes;

import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class ATMBiomes {
    public static final TagKey<Biome> THE_OTHER = register("the_other");
    public static final TagKey<Biome> BASALT_DELTAS = register("basalt_deltas");
    public static final TagKey<Biome> CRIMSON_FOREST = register("crimson_forest");
    public static final TagKey<Biome> DESERT = register("desert");
    public static final TagKey<Biome> DESERT_HILLS = register("desert_hills");
    public static final TagKey<Biome> SOUL_SAND_VALLEY = register("soul_sand_valley");
    public static final TagKey<Biome> WARPED_FOREST = register("warped_forest");

    private static TagKey<Biome> register(String names) {
        return TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Reference.MOD_ID,names));
    }
}
