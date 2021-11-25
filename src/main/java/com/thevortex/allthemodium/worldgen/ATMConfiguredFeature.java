package com.thevortex.allthemodium.worldgen;


import com.google.common.collect.ImmutableList;
import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.allthemods.alltheores.blocks.BlockList;
import net.allthemods.alltheores.infos.Configuration;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.predicate.BlockMaterialPredicate;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.NoOpFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.heightproviders.HeightProviderType;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.placement.Spread32Decorator;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.surfacebuilders.BasaltDeltasSurfaceBuilder;
import net.minecraftforge.registries.ForgeRegistryEntry;

import java.net.http.HttpResponse;
import java.util.Random;
import java.util.stream.Collectors;

public class ATMConfiguredFeature {
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_ALLTHEMODIUM_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, ModRegistry.ALLTHEMODIUM_ORE.get().defaultBlockState()), OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, ModRegistry.ALLTHEMODIUM_SLATE_ORE.get().defaultBlockState()));
	public static final OreConfiguration ORE_ALLTHEMODIUM_CONFIG = new OreConfiguration(ORE_ALLTHEMODIUM_TARGET_LIST, 3);

	public static ConfiguredFeature<?, ?> ORE_ALLTHEMODIUM = newConfiguredFeature("ore_allthemodium",
			Feature.ORE
					.configured(ORE_ALLTHEMODIUM_CONFIG)
					.rarity(100).rangeTriangle(VerticalAnchor.aboveBottom(15), VerticalAnchor.absolute(20)).squared().count(1));

	public static ConfiguredFeature<?, ?> ORE_ATM_MINING = newConfiguredFeature("ore_atm_mining",
			Feature.ORE
					.configured(ORE_ALLTHEMODIUM_CONFIG)
					.rarity(1).rangeTriangle(VerticalAnchor.aboveBottom(5), VerticalAnchor.absolute(10)).squared().count(1));

	public static ConfiguredFeature<?, ?> ORE_VIBRANIUM = newConfiguredFeature("ore_vibranium",
			Feature.ORE
					.configured(new OreConfiguration(OreConfiguration.Predicates.NETHER_ORE_REPLACEABLES,
							ModRegistry.VIBRANIUM_ORE.get().defaultBlockState(), 3))
					.rarity(1).rangeTriangle(VerticalAnchor.belowTop(5), VerticalAnchor.belowTop(15)).squared().count(1));


	public static ConfiguredFeature<?, ?> ORE_UNOBTAINIUM = newConfiguredFeature("ore_unobtainium",
			Feature.ORE
					.configured(new OreConfiguration(new BlockMatchTest(Blocks.END_STONE),
							ModRegistry.UNOBTAINIUM_ORE.get().defaultBlockState(), 3))
					.rarity(1).rangeTriangle(VerticalAnchor.aboveBottom(15), VerticalAnchor.absolute(78)).squared().count(1));

	public static ConfiguredFeature<?, ?> VOLCANO_CF = newVolcanoFeature("volcano", ModRegistry.VOLCANO.get());

	public static ConfiguredFeature<?, ?> MOD_DELTAS = newConfiguredFeature("other_deltas", Feature.DELTA_FEATURE.configured(new DeltaFeatureConfiguration(ModRegistry.ANCIENT_STONE.get().defaultBlockState(), Blocks.MAGMA_BLOCK.defaultBlockState(), UniformInt.of(3, 4), UniformInt.of(0, 2))).decorated(FeatureDecorator.COUNT_MULTILAYER.configured(new CountConfiguration(40))));


	public static ConfiguredFeature<?, ?> newVolcanoFeature(String registryName,
															   Feature<VolcanoConfig> volcanoFeature) {
		ConfiguredFeature<VolcanoConfig, ?> configuredVolcanoFeature = volcanoFeature.configured(VolcanoConfig.INSTANCE);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Reference.MOD_ID, registryName),
				configuredVolcanoFeature);
		return configuredVolcanoFeature;
	}

		public static ConfiguredFeature<?, ?> newConfiguredFeature(String registryName,
			ConfiguredFeature<?, ?> configuredFeature) {
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Reference.MOD_ID, registryName),
				configuredFeature);
		return configuredFeature;
		}


}
