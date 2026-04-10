package net.allthemods.allthemodium.data.worldgen;

import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RedStoneOreBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockColumnConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.DeltaFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RandomizedIntStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.common.blocks.AncientCaveVines;
import net.allthemods.allthemodium.core.registry.ATMBlocks;
import net.allthemods.allthemodium.core.registry.ATMFluids;

import java.util.List;
import java.util.OptionalInt;

public class ATMConfiguredFeatures {
    
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALLTHEMODIUM = ATMConfiguredFeatures.create("allthemodium");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VIBRANIUM = ATMConfiguredFeatures.create("vibranium");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OTHER_VIBRANIUM = ATMConfiguredFeatures.create("other_vibranium");
    public static final ResourceKey<ConfiguredFeature<?, ?>> UNOBTAINIUM = ATMConfiguredFeatures.create("unobtainium");
    
    public static final ResourceKey<ConfiguredFeature<?, ?>> COAL = ATMConfiguredFeatures.create("coal");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COPPER_LARGE = ATMConfiguredFeatures.create("copper_large");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DIAMOND_LARGE = ATMConfiguredFeatures.create("diamond_large");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EMERALD = ATMConfiguredFeatures.create("emerald");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GOLD = ATMConfiguredFeatures.create("gold");
    public static final ResourceKey<ConfiguredFeature<?, ?>> IRON = ATMConfiguredFeatures.create("iron");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LAPIS = ATMConfiguredFeatures.create("lapis");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHERITE = ATMConfiguredFeatures.create("netherite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> QUARTZ = ATMConfiguredFeatures.create("quartz");
    public static final ResourceKey<ConfiguredFeature<?, ?>> REDSTONE = ATMConfiguredFeatures.create("redstone");
    
    public static final ResourceKey<ConfiguredFeature<?, ?>> ANCIENT_TREE = ATMConfiguredFeatures.create("ancient_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAVE_VINE = ATMConfiguredFeatures.create("cave_vine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEMONIC_TREE = ATMConfiguredFeatures.create("demonic_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SOUL_DELTAS = ATMConfiguredFeatures.create("soul_deltas");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SOUL_TREE = ATMConfiguredFeatures.create("soul_tree");
    
    public static void bootstrap(final BootstrapContext<ConfiguredFeature<?, ?>> ctx) {
        ATMConfiguredFeatures.register(ctx, ATMConfiguredFeatures.ALLTHEMODIUM, Feature.ORE, new OreConfiguration(List.of(
                OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ATMBlocks.ALLTHEMODIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ATMBlocks.DEEPSLATE_ALLTHEMODIUM_ORE.get().defaultBlockState())
        ), 4));
        ATMConfiguredFeatures.register(ctx, ATMConfiguredFeatures.VIBRANIUM, Feature.ORE, new OreConfiguration(List.of(
                OreConfiguration.target(new BlockMatchTest(Blocks.NETHERRACK), ATMBlocks.VIBRANIUM_ORE.get().defaultBlockState())
        ), 5));
        ATMConfiguredFeatures.register(ctx, ATMConfiguredFeatures.UNOBTAINIUM, Feature.ORE, new OreConfiguration(List.of(
                OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ATMBlocks.UNOBTAINIUM_ORE.get().defaultBlockState())
        ), 5));
        ATMConfiguredFeatures.register(ctx, ATMConfiguredFeatures.OTHER_VIBRANIUM, Feature.ORE, new OreConfiguration(List.of(
                OreConfiguration.target(new BlockMatchTest(ATMBlocks.ANCIENT_STONE.get()), ATMBlocks.OTHER_VIBRANIUM_ORE.get().defaultBlockState())
        ), 5));
        ATMConfiguredFeatures.register(ctx, ATMConfiguredFeatures.COAL, Feature.ORE, new OreConfiguration(List.of(
                OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), Blocks.COAL_ORE.defaultBlockState()),
                OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), Blocks.DEEPSLATE_COAL_ORE.defaultBlockState())
        ), 17));
        ATMConfiguredFeatures.register(ctx, ATMConfiguredFeatures.COPPER_LARGE, Feature.ORE, new OreConfiguration(List.of(
                OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), Blocks.COPPER_ORE.defaultBlockState()),
                OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), Blocks.DEEPSLATE_COPPER_ORE.defaultBlockState())
        ), 20));
        ATMConfiguredFeatures.register(ctx, ATMConfiguredFeatures.DIAMOND_LARGE, Feature.ORE, new OreConfiguration(List.of(
                OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), Blocks.DIAMOND_ORE.defaultBlockState()),
                OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), Blocks.DEEPSLATE_DIAMOND_ORE.defaultBlockState())
        ), 12, 0.7F));
        ATMConfiguredFeatures.register(ctx, ATMConfiguredFeatures.EMERALD, Feature.ORE, new OreConfiguration(List.of(
                OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), Blocks.EMERALD_ORE.defaultBlockState()),
                OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), Blocks.DEEPSLATE_EMERALD_ORE.defaultBlockState())
        ), 3));
        ATMConfiguredFeatures.register(ctx, ATMConfiguredFeatures.GOLD, Feature.ORE, new OreConfiguration(List.of(
                OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), Blocks.GOLD_ORE.defaultBlockState()),
                OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), Blocks.DEEPSLATE_GOLD_ORE.defaultBlockState()),
                OreConfiguration.target(new TagMatchTest(BlockTags.BASE_STONE_NETHER), Blocks.NETHER_GOLD_ORE.defaultBlockState())
        ), 18));
        ATMConfiguredFeatures.register(ctx, ATMConfiguredFeatures.IRON, Feature.ORE, new OreConfiguration(List.of(
                OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), Blocks.IRON_ORE.defaultBlockState()),
                OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), Blocks.DEEPSLATE_IRON_ORE.defaultBlockState())
        ), 9));
        ATMConfiguredFeatures.register(ctx, ATMConfiguredFeatures.LAPIS, Feature.ORE, new OreConfiguration(List.of(
                OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), Blocks.LAPIS_ORE.defaultBlockState()),
                OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), Blocks.DEEPSLATE_LAPIS_ORE.defaultBlockState())
        ), 7));
        ATMConfiguredFeatures.register(ctx, ATMConfiguredFeatures.NETHERITE, Feature.ORE, new OreConfiguration(List.of(
                OreConfiguration.target(new BlockMatchTest(Blocks.NETHERRACK), Blocks.ANCIENT_DEBRIS.defaultBlockState())
        ), 5));
        ATMConfiguredFeatures.register(ctx, ATMConfiguredFeatures.QUARTZ, Feature.ORE, new OreConfiguration(List.of(
                OreConfiguration.target(new BlockMatchTest(Blocks.NETHERRACK), Blocks.NETHER_QUARTZ_ORE.defaultBlockState())
        ), 14));
        ATMConfiguredFeatures.register(ctx, ATMConfiguredFeatures.REDSTONE, Feature.ORE, new OreConfiguration(List.of(
                OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), Blocks.REDSTONE_ORE.defaultBlockState().setValue(RedStoneOreBlock.LIT, false)),
                OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), Blocks.DEEPSLATE_REDSTONE_ORE.defaultBlockState().setValue(RedStoneOreBlock.LIT, false))
        ), 8));
        
        ATMConfiguredFeatures.register(
                ctx,
                ATMConfiguredFeatures.ANCIENT_TREE,
                Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        new WeightedStateProvider(WeightedList.<BlockState>builder()
                                .add(ATMBlocks.ANCIENT_LOG_0.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y), 10)
                                .add(ATMBlocks.ANCIENT_LOG_1.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y), 10)
                                .add(ATMBlocks.ANCIENT_LOG_2.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y), 10)
                                .build()
                        ),
                        new ForkingTrunkPlacer(5, 2, 2),
                        BlockStateProvider.simple(ATMBlocks.ANCIENT_LEAVES.get().defaultBlockState()
                                .setValue(LeavesBlock.DISTANCE, 7)
                                .setValue(LeavesBlock.PERSISTENT, false)
                                .setValue(LeavesBlock.WATERLOGGED, false)
                        ),
                        new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
                        new TwoLayersFeatureSize(1, 0, 2)
                ).ignoreVines().build()
        );
        ATMConfiguredFeatures.register(
                ctx,
                ATMConfiguredFeatures.SOUL_TREE,
                Feature.TREE,
                ATMConfiguredFeatures.fancyTree(
                        new WeightedStateProvider(WeightedList.<BlockState>builder()
                                .add(ATMBlocks.SOUL_LOG_0.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y), 10)
                                .add(ATMBlocks.SOUL_LOG_1.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y), 10)
                                .add(ATMBlocks.SOUL_LOG_2.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y), 10)
                                .build()
                        ),
                        ATMBlocks.SOUL_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 7).setValue(LeavesBlock.PERSISTENT, false)
                )
        );
        ATMConfiguredFeatures.register(
                ctx,
                ATMConfiguredFeatures.DEMONIC_TREE,
                Feature.TREE,
                ATMConfiguredFeatures.fancyTree(
                        BlockStateProvider.simple(ATMBlocks.DEMONIC_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)),
                        ATMBlocks.DEMONIC_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 7).setValue(LeavesBlock.PERSISTENT, false)
                ));
        ATMConfiguredFeatures.register(ctx, ATMConfiguredFeatures.CAVE_VINE, Feature.BLOCK_COLUMN, new BlockColumnConfiguration(
                List.of(
                        BlockColumnConfiguration.layer(
                                new WeightedListInt(WeightedList.<IntProvider>builder()
                                        .add(UniformInt.of(0, 19), 2)
                                        .add(UniformInt.of(0, 2), 3)
                                        .add(UniformInt.of(0, 6), 10)
                                        .build()),
                                new WeightedStateProvider(WeightedList.<BlockState>builder()
                                        .add(ATMBlocks.ANCIENT_CAVE_VINES_PLANT.get().defaultBlockState().setValue(AncientCaveVines.BERRIES, false), 4)
                                        .add(ATMBlocks.ANCIENT_CAVE_VINES_PLANT.get().defaultBlockState().setValue(AncientCaveVines.BERRIES, true), 1)
                                        .build())
                        ),
                        BlockColumnConfiguration.layer(
                                ConstantInt.of(1),
                                new RandomizedIntStateProvider(
                                        new WeightedStateProvider(WeightedList.<BlockState>builder()
                                                .add(ATMBlocks.ANCIENT_CAVE_VINES.get().defaultBlockState().setValue(AncientCaveVines.BERRIES, false), 4)
                                                .add(ATMBlocks.ANCIENT_CAVE_VINES.get().defaultBlockState().setValue(AncientCaveVines.BERRIES, true), 1)
                                                .build()),
                                        BlockStateProperties.AGE_25,
                                        UniformInt.of(23, 25)
                                )
                        )
                ),
                Direction.DOWN,
                BlockPredicate.matchesBlocks(Blocks.AIR),
                true
        ));
        ATMConfiguredFeatures.register(ctx, ATMConfiguredFeatures.SOUL_DELTAS, Feature.DELTA_FEATURE, new DeltaFeatureConfiguration(
                ATMFluids.SOUL_LAVA_BLOCK.get().defaultBlockState(),
                Blocks.MAGMA_BLOCK.defaultBlockState(),
                UniformInt.of(3, 7),
                UniformInt.of(0, 2)
        ));
    }
    
    private static TreeConfiguration fancyTree(BlockStateProvider provider, BlockState leaves) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                provider,
                new FancyTrunkPlacer(3, 11, 0),
                BlockStateProvider.simple(leaves),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))
        ).ignoreVines().build();
    }
    
    private static <FC extends FeatureConfiguration> void register(
            BootstrapContext<ConfiguredFeature<?, ?>> ctx,
            ResourceKey<ConfiguredFeature<?, ?>> key,
            Feature<FC> feature,
            FC config
    ) {
        ctx.register(key, new ConfiguredFeature<>(feature, config));
    }
    
    private static ResourceKey<ConfiguredFeature<?, ?>> create(String path) {
        return ATM.key(Registries.CONFIGURED_FEATURE, path);
    }
}
