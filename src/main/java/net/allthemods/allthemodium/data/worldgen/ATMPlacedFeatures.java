package net.allthemods.allthemodium.data.worldgen;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountOnEveryLayerPlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.EnvironmentScanPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;
import net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.core.registry.ATMBlocks;

import java.util.List;

public class ATMPlacedFeatures {
    
    public static final ResourceKey<PlacedFeature> ALLTHEMODIUM = ATMPlacedFeatures.create("allthemodium");
    public static final ResourceKey<PlacedFeature> ALLTHEMODIUM_MINING = ATMPlacedFeatures.create("allthemodium_mining");
    public static final ResourceKey<PlacedFeature> VIBRANIUM = ATMPlacedFeatures.create("vibranium");
    public static final ResourceKey<PlacedFeature> VIBRANIUM_OTHER = ATMPlacedFeatures.create("vibranium_other");
    public static final ResourceKey<PlacedFeature> UNOBTAINIUM = ATMPlacedFeatures.create("unobtainium");
    
    public static final ResourceKey<PlacedFeature> ANCIENT_TREE = ATMPlacedFeatures.create("ancient_tree");
    public static final ResourceKey<PlacedFeature> CAVE_VINES = ATMPlacedFeatures.create("cave_vines");
    public static final ResourceKey<PlacedFeature> DEMONIC_TREE = ATMPlacedFeatures.create("demonic_tree");
    public static final ResourceKey<PlacedFeature> SOUL_DELTA = ATMPlacedFeatures.create("soul_delta");
    public static final ResourceKey<PlacedFeature> SOUL_TREE = ATMPlacedFeatures.create("soul_tree");
    
    public static final ResourceKey<PlacedFeature> COAL_LOWER = ATMPlacedFeatures.create("coal_lower");
    public static final ResourceKey<PlacedFeature> COAL_UPPER = ATMPlacedFeatures.create("coal_upper");
    public static final ResourceKey<PlacedFeature> COPPER_LARGE = ATMPlacedFeatures.create("copper_large");
    public static final ResourceKey<PlacedFeature> DIAMOND_LARGE = ATMPlacedFeatures.create("diamond_large");
    public static final ResourceKey<PlacedFeature> EMERALD = ATMPlacedFeatures.create("emerald");
    public static final ResourceKey<PlacedFeature> GOLD = ATMPlacedFeatures.create("gold");
    public static final ResourceKey<PlacedFeature> IRON_MIDDLE = ATMPlacedFeatures.create("iron_middle");
    public static final ResourceKey<PlacedFeature> IRON_SMALL = ATMPlacedFeatures.create("iron_small");
    public static final ResourceKey<PlacedFeature> IRON_UPPER = ATMPlacedFeatures.create("iron_upper");
    public static final ResourceKey<PlacedFeature> LAPIS = ATMPlacedFeatures.create("lapis");
    public static final ResourceKey<PlacedFeature> NETHERITE = ATMPlacedFeatures.create("netherite");
    public static final ResourceKey<PlacedFeature> QUARTZ_NETHER = ATMPlacedFeatures.create("quartz_nether");
    public static final ResourceKey<PlacedFeature> REDSTONE = ATMPlacedFeatures.create("redstone");
    public static final ResourceKey<PlacedFeature> REDSTONE_LOWER = ATMPlacedFeatures.create("redstone_lower");
    
    public static void bootstrap(final BootstrapContext<PlacedFeature> ctx) {
        var configured = ctx.lookup(Registries.CONFIGURED_FEATURE);
        
        
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.ALLTHEMODIUM,
                configured.getOrThrow(ATMConfiguredFeatures.ALLTHEMODIUM),
                CountPlacement.of(10),
                InSquarePlacement.spread(),
                HeightRangePlacement.uniform(
                        VerticalAnchor.aboveBottom(0),
                        VerticalAnchor.absolute(10)
                ),
                ATMPlacedFeatures.scan(Direction.UP, Direction.DOWN),
                RandomOffsetPlacement.vertical(ConstantInt.of(-1)),
                BiomeFilter.biome()
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.ALLTHEMODIUM_MINING,
                configured.getOrThrow(ATMConfiguredFeatures.ALLTHEMODIUM),
                ATMPlacedFeatures.ore(
                        1,
                        HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(65),
                                VerticalAnchor.absolute(129)
                        )
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.VIBRANIUM,
                configured.getOrThrow(ATMConfiguredFeatures.VIBRANIUM),
                CountPlacement.of(10),
                InSquarePlacement.spread(),
                HeightRangePlacement.uniform(
                        VerticalAnchor.aboveBottom(64),
                        VerticalAnchor.absolute(127)
                ),
                ATMPlacedFeatures.scan(Direction.UP, Direction.DOWN),
                RandomOffsetPlacement.vertical(ConstantInt.of(-1)),
                BiomeFilter.biome()
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.VIBRANIUM_OTHER,
                configured.getOrThrow(ATMConfiguredFeatures.OTHER_VIBRANIUM),
                CountPlacement.of(10),
                InSquarePlacement.spread(),
                HeightRangePlacement.uniform(
                        VerticalAnchor.aboveBottom(64),
                        VerticalAnchor.absolute(40)
                ),
                ATMPlacedFeatures.scan(Direction.UP, Direction.DOWN),
                RandomOffsetPlacement.vertical(ConstantInt.of(-1)),
                BiomeFilter.biome()
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.UNOBTAINIUM,
                configured.getOrThrow(ATMConfiguredFeatures.UNOBTAINIUM),
                CountPlacement.of(3),
                InSquarePlacement.spread(),
                HeightRangePlacement.uniform(
                        VerticalAnchor.aboveBottom(0),
                        VerticalAnchor.absolute(128)
                ),
                ATMPlacedFeatures.scan(Direction.DOWN, Direction.UP),
                RandomOffsetPlacement.vertical(ConstantInt.of(-1)),
                BiomeFilter.biome()
        );
        
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.ANCIENT_TREE,
                configured.getOrThrow(ATMConfiguredFeatures.ANCIENT_TREE),
                ATMPlacedFeatures.tree(ATMBlocks.ANCIENT_SAPLING.get())
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.SOUL_TREE,
                configured.getOrThrow(ATMConfiguredFeatures.SOUL_TREE),
                ATMPlacedFeatures.tree(ATMBlocks.SOUL_SAPLING.get())
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.DEMONIC_TREE,
                configured.getOrThrow(ATMConfiguredFeatures.DEMONIC_TREE),
                ATMPlacedFeatures.tree(ATMBlocks.DEMONIC_SAPLING.get())
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.CAVE_VINES,
                configured.getOrThrow(ATMConfiguredFeatures.CAVE_VINE),
                CountPlacement.of(188),
                InSquarePlacement.spread(),
                HeightRangePlacement.uniform(
                        VerticalAnchor.aboveBottom(0),
                        VerticalAnchor.absolute(256)
                ),
                ATMPlacedFeatures.scan(Direction.UP, Direction.DOWN),
                RandomOffsetPlacement.vertical(ConstantInt.of(-1)),
                BiomeFilter.biome()
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.SOUL_DELTA,
                configured.getOrThrow(ATMConfiguredFeatures.SOUL_DELTAS),
                CountOnEveryLayerPlacement.of(80),
                BiomeFilter.biome()
        );
        
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.COAL_LOWER,
                configured.getOrThrow(OreFeatures.ORE_COAL_BURIED),
                ATMPlacedFeatures.ore(
                        20,
                        HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(64),
                                VerticalAnchor.absolute(192)
                        )
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.COAL_UPPER,
                configured.getOrThrow(OreFeatures.ORE_COAL),
                ATMPlacedFeatures.ore(
                        30,
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(136),
                                VerticalAnchor.top()
                        )
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.COPPER_LARGE,
                configured.getOrThrow(OreFeatures.ORE_COPPER_LARGE),
                ATMPlacedFeatures.ore(
                        16,
                        HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(-16),
                                VerticalAnchor.absolute(312)
                        )
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.DIAMOND_LARGE,
                configured.getOrThrow(ATMConfiguredFeatures.DIAMOND_LARGE),
                ATMPlacedFeatures.ore(
                        6,
                        HeightRangePlacement.triangle(
                                VerticalAnchor.aboveBottom(96),
                                VerticalAnchor.aboveBottom(176)
                        )
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.EMERALD,
                configured.getOrThrow(ATMConfiguredFeatures.EMERALD),
                ATMPlacedFeatures.ore(
                        100,
                        HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(-16),
                                VerticalAnchor.absolute(480)
                        )
                )
        );
        ATMPlacedFeatures.register(
                ctx, ATMPlacedFeatures.GOLD,
                configured.getOrThrow(ATMConfiguredFeatures.GOLD),
                ATMPlacedFeatures.ore(
                        4,
                        HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(0),
                                VerticalAnchor.absolute(132)
                        )
                )
        );
        ATMPlacedFeatures.register(
                ctx, ATMPlacedFeatures.IRON_MIDDLE,
                configured.getOrThrow(OreFeatures.ORE_IRON),
                ATMPlacedFeatures.ore(
                        10,
                        HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(64),
                                VerticalAnchor.absolute(156)
                        )
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.IRON_SMALL,
                configured.getOrThrow(OreFeatures.ORE_IRON_SMALL),
                ATMPlacedFeatures.ore(
                        10,
                        HeightRangePlacement.uniform(
                                VerticalAnchor.aboveBottom(128),
                                VerticalAnchor.absolute(200)
                        )
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.IRON_UPPER,
                configured.getOrThrow(OreFeatures.ORE_IRON),
                ATMPlacedFeatures.ore(
                        90,
                        HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(80),
                                VerticalAnchor.absolute(384)
                        )
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.LAPIS,
                configured.getOrThrow(OreFeatures.ORE_LAPIS),
                ATMPlacedFeatures.ore(
                        2,
                        HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(64),
                                VerticalAnchor.absolute(150)
                        )
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.NETHERITE,
                configured.getOrThrow(ATMConfiguredFeatures.NETHERITE),
                ATMPlacedFeatures.ore(
                        4,
                        HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(0),
                                VerticalAnchor.absolute(132)
                        )
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.QUARTZ_NETHER,
                configured.getOrThrow(ATMConfiguredFeatures.QUARTZ),
                ATMPlacedFeatures.ore(16,
                        HeightRangePlacement.uniform(
                                VerticalAnchor.aboveBottom(64),
                                VerticalAnchor.aboveBottom(128)
                        )
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.REDSTONE,
                configured.getOrThrow(OreFeatures.ORE_REDSTONE),
                ATMPlacedFeatures.ore(
                        4,
                        HeightRangePlacement.uniform(
                                VerticalAnchor.aboveBottom(128),
                                VerticalAnchor.absolute(205)
                        )
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.REDSTONE_LOWER,
                configured.getOrThrow(OreFeatures.ORE_REDSTONE),
                ATMPlacedFeatures.ore(
                        8,
                        HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(64),
                                VerticalAnchor.aboveBottom(190)
                        )
                )
        );
    }
    
    private static List<PlacementModifier> ore(int count, PlacementModifier heightRange) {
        return List.of(CountPlacement.of(count), InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }
    
    private static List<PlacementModifier> tree(Block sapling) {
        return List.of(
                PlacementUtils.countExtra(10, 0.1F, 1),
                InSquarePlacement.spread(),
                SurfaceWaterDepthFilter.forMaxDepth(0),
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                PlacementUtils.filteredByBlockSurvival(sapling),
                BiomeFilter.biome()
        );
    }
    
    private static EnvironmentScanPlacement scan(Direction directionOfSearch, Direction sturdyFace) {
        return EnvironmentScanPlacement.scanningFor(
                directionOfSearch,
                BlockPredicate.hasSturdyFace(sturdyFace),
                BlockPredicate.matchesBlocks(Blocks.AIR),
                12
        );
    }
    
    private static void register(
            BootstrapContext<PlacedFeature> ctx,
            ResourceKey<PlacedFeature> key,
            Holder<ConfiguredFeature<?, ?>> feature,
            PlacementModifier... modifiers
    ) {
        ATMPlacedFeatures.register(ctx, key, feature, List.of(modifiers));
    }
    
    private static void register(
            BootstrapContext<PlacedFeature> ctx,
            ResourceKey<PlacedFeature> key,
            Holder<ConfiguredFeature<?, ?>> feature,
            List<PlacementModifier> modifiers
    ) {
        ctx.register(key, new PlacedFeature(feature, modifiers));
    }
    
    private static ResourceKey<PlacedFeature> create(String path) {
        return ATM.key(Registries.PLACED_FEATURE, path);
    }
}
