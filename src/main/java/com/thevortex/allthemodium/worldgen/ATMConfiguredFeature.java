package com.thevortex.allthemodium.worldgen;


import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;

public class ATMConfiguredFeature {

	public static ConfiguredFeature<?, ?> ORE_ALLTHEMODIUM = newConfiguredFeature("ore_allthemodium",
			Feature.ORE
					.configured(new OreConfiguration(OreConfiguration.Predicates.NATURAL_STONE,
							ModRegistry.ALLTHEMODIUM_ORE.get().defaultBlockState(), 3))
					.rarity(1).squared());


	public static ConfiguredFeature<?, ?> ORE_ATM_MINING = newConfiguredFeature("ore_atm_mining",
			Feature.ORE
					.configured(new OreConfiguration(OreConfiguration.Predicates.NATURAL_STONE,
							ModRegistry.ALLTHEMODIUM_ORE.get().defaultBlockState(), 3))
					.rarity(1).squared());

	public static ConfiguredFeature<?, ?> ORE_VIBRANIUM = newConfiguredFeature("ore_vibranium",
			Feature.ORE
					.configured(new OreConfiguration(OreConfiguration.Predicates.NETHER_ORE_REPLACEABLES,
							ModRegistry.VIBRANIUM_ORE.get().defaultBlockState(), 3))
					.rarity(1).squared());


	public static ConfiguredFeature<?, ?> ORE_UNOBTAINIUM = newConfiguredFeature("ore_unobtainium",
			Feature.ORE
					.configured(new OreConfiguration(new BlockMatchTest(Blocks.END_STONE),
							ModRegistry.UNOBTAINIUM_ORE.get().defaultBlockState(), 3))
					.rarity(1).squared());



		public static ConfiguredFeature<?, ?> newConfiguredFeature(String registryName,
			ConfiguredFeature<?, ?> configuredFeature) {
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Reference.MOD_ID, registryName),
				configuredFeature);
		return configuredFeature;
	}
}
