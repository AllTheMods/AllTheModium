package com.thevortex.allthemodium.worldgen;

import com.google.common.collect.ImmutableList;
import com.thevortex.allthemodium.blocks.ACaveVines;
import com.thevortex.allthemodium.blocks.AncientCaveVines;
import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.ModRegistry;
import com.thevortex.allthemodium.registry.TagRegistry;
import com.thevortex.allthemodium.worldgen.features.VolcanoConfig;
import java.util.List;
import java.util.OptionalInt;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.*;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class ATMConfiguredFeature {

    public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_ALLTHEMODIUM_TARGET_LIST = ImmutableList
            .of(
                    OreConfiguration.target(
                            OreFeatures.STONE_ORE_REPLACEABLES,
                            ModRegistry.ALLTHEMODIUM_ORE.get().defaultBlockState()),
                    OreConfiguration.target(
                            OreFeatures.DEEPSLATE_ORE_REPLACEABLES,
                            ModRegistry.ALLTHEMODIUM_SLATE_ORE.get().defaultBlockState()));
    public static final OreConfiguration ORE_ALLTHEMODIUM_CONFIG = new OreConfiguration(ORE_ALLTHEMODIUM_TARGET_LIST,
            4);

    public static Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_ALLTHEMODIUM = FeatureUtils.register(
            "allthemodium:ore_allthemodium",
            Feature.ORE,
            ORE_ALLTHEMODIUM_CONFIG);

    public static Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_ATM_MINING = FeatureUtils.register(
            "allthemodium:ore_atm_mining",
            Feature.ORE,
            ORE_ALLTHEMODIUM_CONFIG);

    public static Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_VIBRANIUM = FeatureUtils.register(
            "allthemodium:ore_vibranium",
            Feature.ORE,
            new OreConfiguration(
                    OreFeatures.NETHER_ORE_REPLACEABLES,
                    ModRegistry.VIBRANIUM_ORE.get().defaultBlockState(),
                    4));

    public static Holder<ConfiguredFeature<OreConfiguration, ?>> OTHER_ORE_VIBRANIUM = FeatureUtils.register(
            "allthemodium:other_ore_vibranium",
            Feature.ORE,
            new OreConfiguration(
                    new TagMatchTest(TagRegistry.ANCIENT_STONE),
                    ModRegistry.OTHER_VIBRANIUM_ORE.get().defaultBlockState(),
                    3));

    public static Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_UNOBTAINIUM = FeatureUtils.register(
            "allthemodium:ore_unobtainium",
            Feature.ORE,
            new OreConfiguration(
                    new BlockMatchTest(Blocks.END_STONE),
                    ModRegistry.UNOBTAINIUM_ORE.get().defaultBlockState(),
                    4));

    public static Holder<ConfiguredFeature<VolcanoConfig, ?>> VOLCANO_CF = FeatureUtils.register(
            "allthemodium:volcano",
            ModRegistry.VOLCANO.get(),
            VolcanoConfig.INSTANCE);

    public static final Holder<ConfiguredFeature<DeltaFeatureConfiguration, ?>> MOD_DELTAS = FeatureUtils.register(
            "allthemodium:other_deltas",
            Feature.DELTA_FEATURE,
            new DeltaFeatureConfiguration(
                    ModRegistry.ANCIENT_STONE.get().defaultBlockState(),
                    Blocks.MAGMA_BLOCK.defaultBlockState(),
                    UniformInt.of(3, 4),
                    UniformInt.of(0, 2)));

    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> ANCIENT_TREE_GIANT = FeatureUtils.register(
            "allthemodium:ancient_tree_giant",
            Feature.TREE,
            createAncientGiantTree().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> ANCIENT_TREE_MEDIUM = FeatureUtils.register(
            "allthemodium:ancient_tree_medium",
            Feature.TREE,
            createAncientMediumTree().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> ANCIENT_TREE = FeatureUtils.register(
            "allthemodium:ancient_tree",
            Feature.TREE,
            createAncientTree().build());

    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> DEMONIC_TREE_GIANT = FeatureUtils.register(
            "allthemodium:demonic_tree_giant",
            Feature.TREE,
            createDemonicGiantTree().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> DEMONIC_TREE_MEDIUM = FeatureUtils.register(
            "allthemodium:demonic_tree_medium",
            Feature.TREE,
            createDemonicMediumTree().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> DEMONIC_TREE = FeatureUtils.register(
            "allthemodium:demonic_tree",
            Feature.TREE,
            createDemonicTree().build());

    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> SOUL_TREE_GIANT = FeatureUtils.register(
            "allthemodium:soul_tree_giant",
            Feature.TREE,
            createSoulGiantTree().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> SOUL_TREE_MEDIUM = FeatureUtils.register(
            "allthemodium:soul_tree_medium",
            Feature.TREE,
            createSoulMediumTree().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> SOUL_TREE = FeatureUtils.register(
            "allthemodium:soul_tree",
            Feature.TREE,
            createSoulTree().build());

    private static final WeightedStateProvider CAVE_VINES_BODY_PROVIDER = new WeightedStateProvider(
            SimpleWeightedRandomList
                    .<BlockState>builder()
                    .add(
                            ModRegistry.ANCIENT_CAVEVINES_PLANT_
                                    .get()
                                    .defaultBlockState(),
                            4)
                    .add(
                            ModRegistry.ANCIENT_CAVEVINES_PLANT_
                                    .get()
                                    .defaultBlockState()
                                    .setValue(ACaveVines.BERRIES, Boolean.valueOf(true)),
                            1));
    private static final RandomizedIntStateProvider CAVE_VINES_HEAD_PROVIDER = new RandomizedIntStateProvider(
            new WeightedStateProvider(
                    SimpleWeightedRandomList
                            .<BlockState>builder()
                            .add(
                                    ModRegistry.ANCIENT_CAVEVINES_
                                            .get()
                                            .defaultBlockState(),
                                    4)
                            .add(
                                    ModRegistry.ANCIENT_CAVEVINES_
                                            .get()
                                            .defaultBlockState()
                                            .setValue(
                                                    ACaveVines.BERRIES,
                                                    Boolean.valueOf(true)),
                                    1)),
            AncientCaveVines.AGE,
            UniformInt.of(23, 25));
    public static final Holder<ConfiguredFeature<BlockColumnConfiguration, ?>> CAVE_VINE = FeatureUtils.register(
            "allthemodium:cave_vine",
            Feature.BLOCK_COLUMN,
            new BlockColumnConfiguration(
                    List.of(
                            BlockColumnConfiguration.layer(
                                    new WeightedListInt(
                                            SimpleWeightedRandomList
                                                    .<IntProvider>builder()
                                                    .add(UniformInt.of(0, 19), 2)
                                                    .add(UniformInt.of(0, 2), 3)
                                                    .add(UniformInt.of(0, 6), 10)
                                                    .build()),
                                    CAVE_VINES_BODY_PROVIDER),
                            BlockColumnConfiguration.layer(
                                    ConstantInt.of(1),
                                    CAVE_VINES_HEAD_PROVIDER)),
                    Direction.DOWN,
                    BlockPredicate.ONLY_IN_AIR_PREDICATE,
                    true));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_ANCIENT_HERB = FeatureUtils
            .register(
                    "allthemodium:patch_ancient_herb",
                    Feature.RANDOM_PATCH,
                    FeatureUtils.simplePatchConfiguration(
                            Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(
                                    BlockStateProvider.simple(ModRegistry.ANCIENT_HERB.get()))));

    private static TreeConfiguration.TreeConfigurationBuilder createAncientGiantTree() {
        return (new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModRegistry.ANCIENT_LOG_0.get()),
                new FancyTrunkPlacer(26, 7, 7),
                BlockStateProvider.simple(ModRegistry.ANCIENT_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))
                .dirt(
                        new SimpleStateProvider(
                                ModRegistry.ANCIENT_DIRT.get().defaultBlockState())));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createAncientMediumTree() {
        return (new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModRegistry.ANCIENT_LOG_1.get()),
                new FancyTrunkPlacer(17, 5, 5),
                BlockStateProvider.simple(ModRegistry.ANCIENT_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))
                .dirt(
                        new SimpleStateProvider(
                                ModRegistry.ANCIENT_DIRT.get().defaultBlockState())));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createAncientTree() {
        return (new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModRegistry.ANCIENT_LOG_2.get()),
                new FancyTrunkPlacer(8, 3, 3),
                BlockStateProvider.simple(ModRegistry.ANCIENT_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))
                .dirt(
                        new SimpleStateProvider(
                                ModRegistry.ANCIENT_DIRT.get().defaultBlockState())));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createDemonicGiantTree() {
        return (new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModRegistry.DEMONIC_LOG.get()),
                new FancyTrunkPlacer(26, 7, 7),
                BlockStateProvider.simple(ModRegistry.DEMONIC_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))
                .dirt(
                        new SimpleStateProvider(
                                ModRegistry.ANCIENT_DIRT.get().defaultBlockState())));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createDemonicMediumTree() {
        return (new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModRegistry.DEMONIC_LOG.get()),
                new FancyTrunkPlacer(17, 5, 5),
                BlockStateProvider.simple(ModRegistry.DEMONIC_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))
                .dirt(
                        new SimpleStateProvider(
                                ModRegistry.ANCIENT_DIRT.get().defaultBlockState())));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createDemonicTree() {
        return (new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModRegistry.DEMONIC_LOG.get()),
                new FancyTrunkPlacer(8, 3, 3),
                BlockStateProvider.simple(ModRegistry.DEMONIC_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))
                .dirt(
                        new SimpleStateProvider(
                                ModRegistry.ANCIENT_DIRT.get().defaultBlockState())));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createSoulGiantTree() {
        return (new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModRegistry.SOUL_LOG.get()),
                new FancyTrunkPlacer(26, 7, 7),
                BlockStateProvider.simple(ModRegistry.SOUL_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))
                .dirt(
                        new SimpleStateProvider(
                                ModRegistry.SOUL_LOG_1.get().defaultBlockState())));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createSoulMediumTree() {
        return (new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModRegistry.SOUL_LOG.get()),
                new FancyTrunkPlacer(17, 5, 5),
                BlockStateProvider.simple(ModRegistry.SOUL_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))
                .dirt(
                        new SimpleStateProvider(
                                ModRegistry.SOUL_LOG_2.get().defaultBlockState())));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createSoulTree() {
        return (new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModRegistry.SOUL_LOG.get()),
                new FancyTrunkPlacer(8, 3, 3),
                BlockStateProvider.simple(ModRegistry.SOUL_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))
                .dirt(
                        new SimpleStateProvider(
                                ModRegistry.SOUL_LOG_0.get().defaultBlockState())));
    }

    public static ConfiguredFeature<?, ?> newConfiguredFeature(
            String registryName,
            ConfiguredFeature<?, ?> configuredFeature) {
        Registry.register(
                BuiltinRegistries.CONFIGURED_FEATURE,
                new ResourceLocation(Reference.MOD_ID, registryName),
                configuredFeature);
        return configuredFeature;
    }
}
