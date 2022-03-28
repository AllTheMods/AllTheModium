package com.thevortex.allthemodium.worldgen.structures;

import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.worldgen.biomes.ATMBiomes;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;

public class ATMConfiguredStructures {
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_DUNGEON = ATMStructures.DUNGEON.get().configured(new JigsawConfiguration(DungeonPieces.START,6), ATMBiomes.SOUL_SAND_VALLEY);
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_PYRAMID = ATMStructures.PYRAMID.get().configured(new JigsawConfiguration(PyramidPieces.START,6), ATMBiomes.DESERT);
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_VILLAGE = ATMStructures.VILLAGE.get().configured(new JigsawConfiguration(VillagePieces.START,6), ATMBiomes.WARPED_FOREST);

    public static void registerConfiguredStructures() {
        Registry<ConfiguredStructureFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(registry, new ResourceLocation(Reference.MOD_ID, "dungeon"), CONFIGURED_DUNGEON);
        Registry.register(registry, new ResourceLocation(Reference.MOD_ID, "ancient_pyramid"), CONFIGURED_PYRAMID);
        Registry.register(registry, new ResourceLocation(Reference.MOD_ID, "piglin_village"), CONFIGURED_VILLAGE);
    }
}