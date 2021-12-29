package com.thevortex.allthemodium.worldgen;


import com.google.common.collect.ImmutableList;
import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.ModRegistry;
import com.thevortex.allthemodium.worldgen.features.VolcanoConfig;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ClampedNormalFloat;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;

import java.util.List;
import java.util.OptionalInt;

public class ATMConfiguredFeature {
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_ALLTHEMODIUM_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModRegistry.ALLTHEMODIUM_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModRegistry.ALLTHEMODIUM_SLATE_ORE.get().defaultBlockState()));
	public static final OreConfiguration ORE_ALLTHEMODIUM_CONFIG = new OreConfiguration(ORE_ALLTHEMODIUM_TARGET_LIST, 4);

	public static ConfiguredFeature<?, ?> ORE_ALLTHEMODIUM = newConfiguredFeature("ore_allthemodium",
			Feature.ORE
					.configured(ORE_ALLTHEMODIUM_CONFIG));

	public static ConfiguredFeature<?, ?> ORE_ATM_MINING = newConfiguredFeature("ore_atm_mining",
			Feature.ORE
					.configured(ORE_ALLTHEMODIUM_CONFIG));

	public static ConfiguredFeature<?, ?> ORE_VIBRANIUM = newConfiguredFeature("ore_vibranium",
			Feature.ORE
					.configured(new OreConfiguration(OreFeatures.NETHER_ORE_REPLACEABLES,
							ModRegistry.VIBRANIUM_ORE.get().defaultBlockState(), 4)));


	public static ConfiguredFeature<?, ?> ORE_UNOBTAINIUM = newConfiguredFeature("ore_unobtainium",
			Feature.ORE
					.configured(new OreConfiguration(new BlockMatchTest(Blocks.END_STONE),
							ModRegistry.UNOBTAINIUM_ORE.get().defaultBlockState(), 4)));

	public static ConfiguredFeature<?, ?> VOLCANO_CF = newVolcanoFeature("volcano", ModRegistry.VOLCANO.get());

	public static ConfiguredFeature<?, ?> MOD_DELTAS = newConfiguredFeature("other_deltas", Feature.DELTA_FEATURE.configured(new DeltaFeatureConfiguration(ModRegistry.ANCIENT_STONE.get().defaultBlockState(), Blocks.MAGMA_BLOCK.defaultBlockState(), UniformInt.of(3, 4), UniformInt.of(0, 2))));

	public static ConfiguredFeature<?, ?> MOD_DRIPSTONE = newConfiguredFeature("other_dripstone", ModRegistry.DRIPSTONE_F.configured(new DripstoneClusterConfiguration(52, UniformInt.of(3, 6), UniformInt.of(2, 8), 1, 3, UniformInt.of(2, 4), UniformFloat.of(0.3F, 0.7F), ClampedNormalFloat.of(0.1F, 0.3F, 0.1F, 0.9F), 0.1F, 3, 8)));

	public static final ConfiguredFeature<TreeConfiguration, ?> ANCIENT_TREE_GIANT = FeatureUtils.register("ancient_tree_giant", Feature.TREE.configured(createAncientGiantTree().build()));
	public static final ConfiguredFeature<TreeConfiguration, ?> ANCIENT_TREE_MEDIUM = FeatureUtils.register("ancient_tree_medium", Feature.TREE.configured(createAncientMediumTree().build()));
	public static final ConfiguredFeature<TreeConfiguration, ?> ANCIENT_TREE = FeatureUtils.register("ancient_tree", Feature.TREE.configured(createAncientTree().build()));

	public static final ConfiguredFeature<RandomPatchConfiguration, ?> PATCH_ANCIENT_HERB = FeatureUtils.register("patch_ancient_herb", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(ModRegistry.ANCIENT_HERB.get()))))));


	private static TreeConfiguration.TreeConfigurationBuilder createAncientGiantTree() {
		return (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModRegistry.ANCIENT_LOG_0.get()), new FancyTrunkPlacer(26, 7, 7), BlockStateProvider.simple(ModRegistry.ANCIENT_LEAVES.get()), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))));
	}
	private static TreeConfiguration.TreeConfigurationBuilder createAncientMediumTree() {
		return (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModRegistry.ANCIENT_LOG_1.get()), new FancyTrunkPlacer(17, 5, 5), BlockStateProvider.simple(ModRegistry.ANCIENT_LEAVES.get()), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))));
	}
	private static TreeConfiguration.TreeConfigurationBuilder createAncientTree() {
		return (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModRegistry.ANCIENT_LOG_2.get()), new FancyTrunkPlacer(8, 3, 3), BlockStateProvider.simple(ModRegistry.ANCIENT_LEAVES.get()), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))));
	}
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
