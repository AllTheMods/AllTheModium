package com.thevortex.allthemodium.worldgen;

import com.google.common.collect.ImmutableList;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.*;

public class ATMPlacedFeature {

    public static final Holder<PlacedFeature> ORE_ALLTHEMODIUM = PlacementUtils.register(
            "allthemodium:ore_allthemodium",
            ATMConfiguredFeature.ORE_ALLTHEMODIUM,
            rareOrePlacement(
                    9,
                    HeightRangePlacement.uniform(
                            VerticalAnchor.aboveBottom(15),
                            VerticalAnchor.absolute(20))));
    public static final Holder<PlacedFeature> ORE_ALLTHEMODIUM_MOUNTAIN = PlacementUtils.register(
            "allthemodium:ore_allthemodium_mountain",
            ATMConfiguredFeature.ORE_ALLTHEMODIUM,
            commonOrePlacement(
                    10,
                    HeightRangePlacement.uniform(
                            VerticalAnchor.absolute(170),
                            VerticalAnchor.belowTop(20))));
    public static final Holder<PlacedFeature> ORE_ATM_MINING = PlacementUtils.register(
            "allthemodium:ore_atm_mining",
            ATMConfiguredFeature.ORE_ATM_MINING,
            rareOrePlacement(
                    9,
                    HeightRangePlacement.uniform(
                            VerticalAnchor.aboveBottom(5),
                            VerticalAnchor.absolute(20))));
    public static final Holder<PlacedFeature> ORE_VIBRANIUM = PlacementUtils.register(
            "allthemodium:ore_vibranium",
            ATMConfiguredFeature.ORE_VIBRANIUM,
            rareOrePlacement(
                    7,
                    HeightRangePlacement.uniform(
                            VerticalAnchor.belowTop(28),
                            VerticalAnchor.belowTop(5))));
    public static final Holder<PlacedFeature> ORE_VIBRANIUM_OTHER = PlacementUtils.register(
            "allthemodium:other_vibranium_ore",
            ATMConfiguredFeature.OTHER_ORE_VIBRANIUM,
            commonOrePlacement(
                    2,
                    HeightRangePlacement.uniform(
                            VerticalAnchor.absolute(1),
                            VerticalAnchor.absolute(20))));

    public static final Holder<PlacedFeature> ORE_UNOBTAINIUM = PlacementUtils.register(
            "allthemodium:ore_unobtainium",
            ATMConfiguredFeature.ORE_UNOBTAINIUM,
            rareOrePlacement(
                    9,
                    HeightRangePlacement.uniform(
                            VerticalAnchor.aboveBottom(15),
                            VerticalAnchor.absolute(78))));

    public static final Holder<PlacedFeature> VOLCANO_CF = PlacementUtils.register(
            "allthemodium:volcano",
            ATMConfiguredFeature.VOLCANO_CF);
    public static final Holder<PlacedFeature> MOD_DELTAS = PlacementUtils.register(
            "allthemodium:other_deltas",
            ATMConfiguredFeature.MOD_DELTAS);
    public static final Holder<PlacedFeature> ANCIENT_TREE = PlacementUtils.register(
            "allthemodium:ancient_tree",
            ATMConfiguredFeature.ANCIENT_TREE,
            treePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));
    public static final Holder<PlacedFeature> ANCIENT_TREE_MEDIUM = PlacementUtils.register(
            "allthemodium:ancient_tree_medium",
            ATMConfiguredFeature.ANCIENT_TREE_MEDIUM,
            treePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));
    public static final Holder<PlacedFeature> ANCIENT_TREE_GIANT = PlacementUtils.register(
            "allthemodium:ancient_tree_giant",
            ATMConfiguredFeature.ANCIENT_TREE_GIANT,
            treePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));

    public static final Holder<PlacedFeature> DEMONIC_TREE = PlacementUtils.register(
            "allthemodium:demonic_tree",
            ATMConfiguredFeature.DEMONIC_TREE,
            treePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));
    public static final Holder<PlacedFeature> DEMONIC_TREE_MEDIUM = PlacementUtils.register(
            "allthemodium:demonic_tree_medium",
            ATMConfiguredFeature.DEMONIC_TREE_MEDIUM,
            treePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));
    public static final Holder<PlacedFeature> DEMONIC_TREE_GIANT = PlacementUtils.register(
            "allthemodium:demonic_tree_giant",
            ATMConfiguredFeature.DEMONIC_TREE_GIANT,
            treePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));

    public static final Holder<PlacedFeature> SOUL_TREE = PlacementUtils.register(
            "allthemodium:soul_tree",
            ATMConfiguredFeature.SOUL_TREE,
            treePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));
    public static final Holder<PlacedFeature> SOUL_TREE_MEDIUM = PlacementUtils.register(
            "allthemodium:soul_tree_medium",
            ATMConfiguredFeature.SOUL_TREE_MEDIUM,
            treePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));
    public static final Holder<PlacedFeature> SOUL_TREE_GIANT = PlacementUtils.register(
            "allthemodium:soul_tree_giant",
            ATMConfiguredFeature.SOUL_TREE_GIANT,
            treePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));

    public static final Holder<PlacedFeature> CAVE_VINES = PlacementUtils.register(
            "allthemodium:cave_vines",
            ATMConfiguredFeature.CAVE_VINE,
            CountPlacement.of(188),
            InSquarePlacement.spread(),
            PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
            EnvironmentScanPlacement.scanningFor(
                    Direction.UP,
                    BlockPredicate.hasSturdyFace(Direction.DOWN),
                    BlockPredicate.ONLY_IN_AIR_PREDICATE,
                    12),
            RandomOffsetPlacement.vertical(ConstantInt.of(-1)),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> CAVE_ATM = PlacementUtils.register(
            "allthemodium:cave_ore",
            ATMConfiguredFeature.ORE_ALLTHEMODIUM,
            CountPlacement.of(50),
            InSquarePlacement.spread(),
            PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
            EnvironmentScanPlacement.scanningFor(
                    Direction.UP,
                    BlockPredicate.hasSturdyFace(Direction.DOWN),
                    BlockPredicate.ONLY_IN_AIR_PREDICATE,
                    12),
            RandomOffsetPlacement.vertical(ConstantInt.of(-1)),
            BiomeFilter.biome());

    private static List<PlacementModifier> orePlacement(
            PlacementModifier placement,
            PlacementModifier placement2) {
        return List.of(
                placement,
                InSquarePlacement.spread(),
                placement2,
                BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(
            int count,
            PlacementModifier pm) {
        return orePlacement(CountPlacement.of(count), pm);
    }

    private static List<PlacementModifier> rareOrePlacement(
            int rarity,
            PlacementModifier pm) {
        return orePlacement(RarityFilter.onAverageOnceEvery(rarity), pm);
    }

    private static ImmutableList.Builder<PlacementModifier> treePlacementBase(
            PlacementModifier p_195485_) {
        return ImmutableList
                .<PlacementModifier>builder()
                .add(p_195485_)
                .add(InSquarePlacement.spread())
                .add(VegetationPlacements.TREE_THRESHOLD)
                .add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE)
                .add(BiomeFilter.biome());
    }

    public static List<PlacementModifier> treePlacement(
            PlacementModifier p_195480_) {
        return treePlacementBase(p_195480_).build();
    }

    public static List<PlacementModifier> treePlacement(
            PlacementModifier p_195482_,
            Block p_195483_) {
        return treePlacementBase(p_195482_)
                .add(
                        BlockPredicateFilter.forPredicate(
                                BlockPredicate.wouldSurvive(
                                        p_195483_.defaultBlockState(),
                                        BlockPos.ZERO)))
                .build();
    }
}
