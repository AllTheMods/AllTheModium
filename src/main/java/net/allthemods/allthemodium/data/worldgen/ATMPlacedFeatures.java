package net.allthemods.allthemodium.data.worldgen;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.BiasedToBottomHeight;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountOnEveryLayerPlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.EnvironmentScanPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.core.registry.ATMBlocks;
import net.allthemods.alltheores.common.material.Material;

import java.util.List;

public class ATMPlacedFeatures {
    
    private static final int MINING_FULL_MIN_Y = -63;
    private static final int MINING_FULL_MAX_Y = 247;
    private static final int MINING_FULL_INNER = 216;
    
    private static final int MINING_STONE_MIN_Y = 65;
    private static final int MINING_STONE_MAX_Y = 247;
    private static final int MINING_STONE_INNER = 112;
    
    private static final int MINING_NETHER_MIN_Y = 1;
    private static final int MINING_NETHER_MAX_Y = 64;
    private static final int MINING_NETHER_INNER = 24;
    
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
    
    public static final ResourceKey<PlacedFeature> ORE_COAL_LOWER = ATMPlacedFeatures.create("mining/ore_coal_lower");
    public static final ResourceKey<PlacedFeature> ORE_COAL_UPPER = ATMPlacedFeatures.create("mining/ore_coal_upper");
    public static final ResourceKey<PlacedFeature> ORE_COPPER = ATMPlacedFeatures.create("mining/ore_copper");
    public static final ResourceKey<PlacedFeature> ORE_COPPER_LARGE = ATMPlacedFeatures.create("mining/ore_copper_large");
    public static final ResourceKey<PlacedFeature> ORE_IRON_SMALL = ATMPlacedFeatures.create("mining/ore_iron_small");
    public static final ResourceKey<PlacedFeature> ORE_IRON_MIDDLE = ATMPlacedFeatures.create("mining/ore_iron_middle");
    public static final ResourceKey<PlacedFeature> ORE_IRON_UPPER = ATMPlacedFeatures.create("mining/ore_iron_upper");
    public static final ResourceKey<PlacedFeature> ORE_GOLD = ATMPlacedFeatures.create("mining/ore_gold");
    public static final ResourceKey<PlacedFeature> ORE_GOLD_EXTRA = ATMPlacedFeatures.create("mining/ore_gold_extra");
    public static final ResourceKey<PlacedFeature> ORE_GOLD_LOWER = ATMPlacedFeatures.create("mining/ore_gold_lower");
    public static final ResourceKey<PlacedFeature> ORE_GOLD_DELTAS = ATMPlacedFeatures.create("mining/ore_gold_deltas");
    public static final ResourceKey<PlacedFeature> ORE_GOLD_NETHER = ATMPlacedFeatures.create("mining/ore_gold_nether");
    public static final ResourceKey<PlacedFeature> ORE_REDSTONE = ATMPlacedFeatures.create("mining/ore_redstone");
    public static final ResourceKey<PlacedFeature> ORE_REDSTONE_LOWER = ATMPlacedFeatures.create("mining/ore_redstone_lower");
    public static final ResourceKey<PlacedFeature> ORE_LAPIS = ATMPlacedFeatures.create("mining/ore_lapis");
    public static final ResourceKey<PlacedFeature> ORE_LAPIS_BURIED = ATMPlacedFeatures.create("mining/ore_lapis_buried");
    public static final ResourceKey<PlacedFeature> ORE_DIAMOND = ATMPlacedFeatures.create("mining/ore_diamond");
    public static final ResourceKey<PlacedFeature> ORE_DIAMOND_BURIED = ATMPlacedFeatures.create("mining/ore_diamond_buried");
    public static final ResourceKey<PlacedFeature> ORE_DIAMOND_MEDIUM = ATMPlacedFeatures.create("mining/ore_diamond_medium");
    public static final ResourceKey<PlacedFeature> ORE_DIAMOND_LARGE = ATMPlacedFeatures.create("mining/ore_diamond_large");
    public static final ResourceKey<PlacedFeature> ORE_EMERALD = ATMPlacedFeatures.create("mining/ore_emerald");
    public static final ResourceKey<PlacedFeature> ORE_QUARTZ_DELTAS = ATMPlacedFeatures.create("mining/ore_quartz_deltas");
    public static final ResourceKey<PlacedFeature> ORE_QUARTZ_NETHER = ATMPlacedFeatures.create("mining/ore_quartz_nether");
    public static final ResourceKey<PlacedFeature> ORE_GLOWSTONE = ATMPlacedFeatures.create("mining/glowstone");
    public static final ResourceKey<PlacedFeature> ORE_DEBRIS_SMALL = ATMPlacedFeatures.create("mining/ore_debris_small");
    public static final ResourceKey<PlacedFeature> ORE_ANCIENT_DEBRIS_LARGE = ATMPlacedFeatures.create("mining/ore_ancient_debris_large");
    
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
                        ATMPlacedFeatures.stoneRange()
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
                ATMPlacedFeatures.ORE_GLOWSTONE,
                configured.getOrThrow(ATMConfiguredFeatures.GLOWSTONE),
                ATMPlacedFeatures.ore(
                        8,
                        ATMPlacedFeatures.netherRange()
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.ORE_COAL_LOWER,
                configured.getOrThrow(ATMConfiguredFeatures.ORE_COAL),
                ATMPlacedFeatures.ore(
                        20,
                        ATMPlacedFeatures.stoneRange()
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.ORE_COAL_UPPER,
                configured.getOrThrow(ATMConfiguredFeatures.ORE_COAL),
                ATMPlacedFeatures.ore(
                        30,
                        ATMPlacedFeatures.stoneRange()
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.ORE_COPPER,
                configured.getOrThrow(ATMConfiguredFeatures.ORE_COPPER_SMALL),
                ATMPlacedFeatures.ore(
                        16,
                        ATMPlacedFeatures.stoneRange()
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.ORE_COPPER_LARGE,
                configured.getOrThrow(ATMConfiguredFeatures.ORE_COPPER_LARGE),
                ATMPlacedFeatures.ore(
                        16,
                        ATMPlacedFeatures.stoneRange()
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.ORE_IRON_SMALL,
                configured.getOrThrow(ATMConfiguredFeatures.ORE_IRON_SMALL),
                ATMPlacedFeatures.ore(
                        10,
                        ATMPlacedFeatures.stoneRange()
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.ORE_IRON_MIDDLE,
                configured.getOrThrow(ATMConfiguredFeatures.ORE_IRON),
                ATMPlacedFeatures.ore(
                        10,
                        ATMPlacedFeatures.stoneRange()
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.ORE_IRON_UPPER,
                configured.getOrThrow(ATMConfiguredFeatures.ORE_IRON),
                ATMPlacedFeatures.ore(
                        90,
                        ATMPlacedFeatures.stoneRange()
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.ORE_GOLD,
                configured.getOrThrow(ATMConfiguredFeatures.ORE_GOLD_BURIED),
                ATMPlacedFeatures.ore(
                        4,
                        ATMPlacedFeatures.stoneRange()
                )
        );
        
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.ORE_GOLD_EXTRA,
                configured.getOrThrow(ATMConfiguredFeatures.ORE_GOLD),
                ATMPlacedFeatures.ore(
                        50,
                        ATMPlacedFeatures.stoneRange()
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.ORE_GOLD_LOWER,
                configured.getOrThrow(ATMConfiguredFeatures.ORE_GOLD_BURIED),
                ATMPlacedFeatures.ore(
                        CountPlacement.of(UniformInt.of(0, 1)),
                        ATMPlacedFeatures.stoneRange()
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.ORE_GOLD_DELTAS,
                configured.getOrThrow(ATMConfiguredFeatures.ORE_NETHER_GOLD),
                ATMPlacedFeatures.ore(
                        20,
                        ATMPlacedFeatures.netherRange()
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.ORE_GOLD_NETHER,
                configured.getOrThrow(ATMConfiguredFeatures.ORE_NETHER_GOLD),
                ATMPlacedFeatures.ore(
                        10,
                        ATMPlacedFeatures.netherRange()
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.ORE_REDSTONE,
                configured.getOrThrow(ATMConfiguredFeatures.ORE_REDSTONE),
                ATMPlacedFeatures.ore(
                        4,
                        ATMPlacedFeatures.stoneRange()
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.ORE_REDSTONE_LOWER,
                configured.getOrThrow(ATMConfiguredFeatures.ORE_REDSTONE),
                ATMPlacedFeatures.ore(
                        8,
                        ATMPlacedFeatures.stoneRange()
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.ORE_LAPIS,
                configured.getOrThrow(ATMConfiguredFeatures.ORE_LAPIS),
                ATMPlacedFeatures.ore(
                        2,
                        ATMPlacedFeatures.stoneRange()
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.ORE_LAPIS_BURIED,
                configured.getOrThrow(ATMConfiguredFeatures.ORE_LAPIS_BURIED),
                ATMPlacedFeatures.ore(
                        4,
                        ATMPlacedFeatures.stoneRange()
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.ORE_DIAMOND,
                configured.getOrThrow(ATMConfiguredFeatures.ORE_DIAMOND_SMALL),
                ATMPlacedFeatures.ore(
                        7,
                        ATMPlacedFeatures.stoneRange()
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.ORE_DIAMOND_BURIED,
                configured.getOrThrow(ATMConfiguredFeatures.ORE_DIAMOND_BURIED),
                ATMPlacedFeatures.ore(
                        4,
                        ATMPlacedFeatures.stoneRange()
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.ORE_DIAMOND_MEDIUM,
                configured.getOrThrow(ATMConfiguredFeatures.ORE_DIAMOND_MEDIUM),
                ATMPlacedFeatures.ore(
                        2,
                        ATMPlacedFeatures.stoneRange()
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.ORE_DIAMOND_LARGE,
                configured.getOrThrow(ATMConfiguredFeatures.ORE_DIAMOND_LARGE),
                ATMPlacedFeatures.rarityOre(
                        9,
                        ATMPlacedFeatures.stoneRange()
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.ORE_EMERALD,
                configured.getOrThrow(ATMConfiguredFeatures.ORE_EMERALD),
                ATMPlacedFeatures.ore(
                        100,
                        ATMPlacedFeatures.stoneRange()
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.ORE_QUARTZ_DELTAS,
                configured.getOrThrow(ATMConfiguredFeatures.ORE_QUARTZ),
                ATMPlacedFeatures.ore(
                        32,
                        ATMPlacedFeatures.netherRange()
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.ORE_QUARTZ_NETHER,
                configured.getOrThrow(ATMConfiguredFeatures.ORE_QUARTZ),
                ATMPlacedFeatures.ore(
                        16,
                        ATMPlacedFeatures.netherRange()
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.ORE_DEBRIS_SMALL,
                configured.getOrThrow(ATMConfiguredFeatures.ORE_ANCIENT_DEBRIS_SMALL),
                List.of(
                        InSquarePlacement.spread(),
                        ATMPlacedFeatures.netherRange(),
                        BiomeFilter.biome()
                )
        );
        ATMPlacedFeatures.register(
                ctx,
                ATMPlacedFeatures.ORE_ANCIENT_DEBRIS_LARGE,
                configured.getOrThrow(ATMConfiguredFeatures.ORE_ANCIENT_DEBRIS_LARGE),
                List.of(
                        InSquarePlacement.spread(),
                        ATMPlacedFeatures.netherRange(),
                        BiomeFilter.biome()
                )
        );
        
        Material.forAll(material -> {
            Material.WorldGen worldGen = material.getWorldGen();
            if (worldGen == null) return;
            
            ATMPlacedFeatures.register(
                    ctx,
                    ATMPlacedFeatures.mining(material),
                    configured.getOrThrow(ATMConfiguredFeatures.mining(material)),
                    ATMPlacedFeatures.ore(
                            worldGen.count(),
                            ATMPlacedFeatures.fullRange()
                    )
            );
        });
        
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
        
    }
    
    private static List<PlacementModifier> ore(int count, PlacementModifier heightRange) {
        return ATMPlacedFeatures.ore(CountPlacement.of(count), heightRange);
    }
    
    private static List<PlacementModifier> ore(PlacementModifier count, PlacementModifier heightRange) {
        return List.of(count, InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }
    
    private static List<PlacementModifier> rarityOre(int chance, PlacementModifier heightRange) {
        return List.of(RarityFilter.onAverageOnceEvery(chance), InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }
    
    private static PlacementModifier fullRange() {
        return HeightRangePlacement.of(BiasedToBottomHeight.of(
                VerticalAnchor.absolute(ATMPlacedFeatures.MINING_FULL_MIN_Y),
                VerticalAnchor.absolute(ATMPlacedFeatures.MINING_FULL_MAX_Y),
                ATMPlacedFeatures.MINING_FULL_INNER
        ));
    }
    
    private static PlacementModifier stoneRange() {
        return HeightRangePlacement.of(BiasedToBottomHeight.of(
                VerticalAnchor.absolute(ATMPlacedFeatures.MINING_STONE_MIN_Y),
                VerticalAnchor.absolute(ATMPlacedFeatures.MINING_STONE_MAX_Y),
                ATMPlacedFeatures.MINING_STONE_INNER
        ));
    }
    
    private static PlacementModifier netherRange() {
        return HeightRangePlacement.of(BiasedToBottomHeight.of(
                VerticalAnchor.absolute(ATMPlacedFeatures.MINING_NETHER_MIN_Y),
                VerticalAnchor.absolute(ATMPlacedFeatures.MINING_NETHER_MAX_Y),
                ATMPlacedFeatures.MINING_NETHER_INNER
        ));
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
    
    public static ResourceKey<PlacedFeature> mining(Material material) {
        return ATMPlacedFeatures.create("mining/ore_" + material.getGroup());
    }
}
