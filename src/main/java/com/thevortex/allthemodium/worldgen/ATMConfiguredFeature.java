package com.thevortex.allthemodium.worldgen;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.thevortex.allthemodium.blocks.Allthemodium_Ore;
import com.thevortex.allthemodium.fluids.FluidList;
import com.thevortex.allthemodium.init.ModBlocks;
import com.thevortex.allthemodium.reference.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.LiquidsConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraft.world.gen.placement.DepthAveragePlacement;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;

public class ATMConfiguredFeature {
	public static ConfiguredFeature<?, ?> ORE_ALLTHEMODIUM = newConfiguredFeature("ore_allthemodium",
			Feature.ORE
					.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
							ModBlocks.ALLTHEMODIUMORE.getDefaultState(), 3))
					.range(45).square().func_242731_b(4));
	public static ConfiguredFeature<?, ?> ORE_ATM_MINING = newConfiguredFeature("ore_atmium",
			Feature.ORE
					.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
							ModBlocks.ALLTHEMODIUMORE.getDefaultState(), 3)).withPlacement(Placement.DEPTH_AVERAGE.configure(new DepthAverageConfig(30, 8))).square().func_242731_b(4));
	public static ConfiguredFeature<?, ?> ORE_VIBRANIUM = newConfiguredFeature("ore_vibranium",
			Feature.ORE
					.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER,
							ModBlocks.VIBRANIUM_ORE.getDefaultState(), 3))
					.withPlacement(Placement.DEPTH_AVERAGE.configure(new DepthAverageConfig(110, 3))).func_242731_b(2));

	public static ConfiguredFeature<?, ?> ORE_OTHER_VIBRANIUM = newConfiguredFeature("ore_other_vibranium",
			Feature.ORE
					.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER,
							ModBlocks.VIBRANIUM_ORE.getDefaultState(), 5))
					.withPlacement(Placement.DEPTH_AVERAGE.configure(new DepthAverageConfig(100, 18)))).square().func_242731_b(4);

	public static ConfiguredFeature<?, ?> ORE_UNOBTAINIUM = newConfiguredFeature("ore_unobtainium",
			Feature.ORE
					.withConfiguration(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE),
							ModBlocks.UNOBTAINIUM_ORE.getDefaultState(), 3))
					.range(78).square().func_242731_b(1));

	public static ConfiguredFeature<?, ?> SOUL_LAVA_SPRING = newConfiguredFeature("soul_lava_spring",
			Feature.SPRING_FEATURE
					.withConfiguration(new LiquidsConfig(FluidList.blueLava.get().getDefaultState(), false, 5, 0,
							ImmutableSet.of(Blocks.SOUL_SAND, Blocks.NETHERRACK)))
					.withPlacement(Placement.LAVA_LAKE.configure(new ChanceConfig(100))).square()
					.func_242731_b(20));

	public static ConfiguredFeature<?, ?> newConfiguredFeature(String registryName,
			ConfiguredFeature<?, ?> configuredFeature) {
		Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(Reference.MOD_ID, registryName),
				configuredFeature);
		return configuredFeature;
	}
}
