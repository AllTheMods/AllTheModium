package com.thevortex.allthemodium.worldgen;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.thevortex.allthemodium.AllTheModium;
import com.thevortex.allthemodium.worldgen.ATMConfiguredFeature;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.Level;

public class Worldgen {

	public static void addFeatures() {

		for (Biome biome : ForgeRegistries.BIOMES) {
			if ((biome.getCategory() == Biome.Category.OCEAN) && (biome.getCategory() != Biome.Category.NONE)
					&& !(biome == null)) {
				addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES,
						ATMConfiguredFeature.ORE_ALLTHEMODIUM);
			}
			if ((biome.getCategory() == Biome.Category.NETHER) && (biome.getCategory() != Biome.Category.NONE)
					&& !(biome == null)) {
				if(biome.getRegistryName().getPath().equals("crimson_forest")) { //Crimson Forest
				addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES,
						ATMConfiguredFeature.ORE_VIBRANIUM);
				}
				if(biome.getRegistryName().getPath().equals("warped_forest")) { //Warped Forest
					addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES,
							ATMConfiguredFeature.ORE_VIBRANIUM);
					}
				addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES,
						ATMConfiguredFeature.SOUL_LAVA_SPRING);
			}
			if ((biome.getCategory() == Biome.Category.THEEND) && (biome.getCategory() != Biome.Category.NONE)
					&& !(biome == null)) {
				if (biome.getRegistryName().getPath().equals("end_highlands")) {
					addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES,
							ATMConfiguredFeature.ORE_UNOBTAINIUM);
				}
			}

			}


			

	}

	// Use these to add our features to vanilla's biomes.
	public static void addFeatureToBiome(Biome biome, GenerationStage.Decoration feature,
			ConfiguredFeature<?, ?> configuredFeature) {
		ConvertImmutableFeatures(biome);
		List<List<Supplier<ConfiguredFeature<?, ?>>>> biomeFeatures = biome.getGenerationSettings().features;
		while (biomeFeatures.size() <= feature.ordinal()) {
			biomeFeatures.add(Lists.newArrayList());
		}
		biomeFeatures.get(feature.ordinal()).add(() -> configuredFeature);

	}

	private static void ConvertImmutableFeatures(Biome biome) {
		if (biome.getGenerationSettings().features instanceof ImmutableList) {
			biome.getGenerationSettings().features = biome.getGenerationSettings().features.stream()
					.map(Lists::newArrayList).collect(Collectors.toList());
		}
	}
}
