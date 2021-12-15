package com.thevortex.allthemodium.worldgen;

import com.google.common.collect.ImmutableList;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ATMPlacedFeature {


    public static final PlacedFeature ORE_ALLTHEMODIUM = PlacementUtils.register("ore_allthemodium", ATMConfiguredFeature.ORE_ALLTHEMODIUM.placed(rareOrePlacement(9, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(15), VerticalAnchor.absolute(20)))));
    public static final PlacedFeature ORE_ALLTHEMODIUM_MOUNTAIN = PlacementUtils.register("ore_allthemodium_mountain", ATMConfiguredFeature.ORE_ALLTHEMODIUM.placed(commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(170),VerticalAnchor.belowTop(20)))));
    public static final PlacedFeature ORE_ATM_MINING = PlacementUtils.register("ore_atm_mining", ATMConfiguredFeature.ORE_ATM_MINING.placed(rareOrePlacement(9, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(5), VerticalAnchor.absolute(20)))));
    public static final PlacedFeature ORE_VIBRANIUM = PlacementUtils.register("ore_vibranium", ATMConfiguredFeature.ORE_VIBRANIUM.placed(rareOrePlacement(7, HeightRangePlacement.uniform(VerticalAnchor.belowTop(28), VerticalAnchor.belowTop(5)))));
    public static final PlacedFeature ORE_UNOBTAINIUM = PlacementUtils.register("ore_unobtainium", ATMConfiguredFeature.ORE_UNOBTAINIUM.placed(rareOrePlacement(9, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(15), VerticalAnchor.absolute(78)))));

    public static final PlacedFeature VOLCANO_CF = PlacementUtils.register("volcano", ATMConfiguredFeature.VOLCANO_CF.placed());
    public static final PlacedFeature MOD_DELTAS = PlacementUtils.register("other_deltas", ATMConfiguredFeature.MOD_DELTAS.placed());
    public static final PlacedFeature MOD_DRIPSTONE = PlacementUtils.register("other_dripstone", ATMConfiguredFeature.MOD_DRIPSTONE.placed());
    public static final PlacedFeature ANCIENT_TREE = PlacementUtils.register("ancient_tree", ATMConfiguredFeature.ANCIENT_TREE.placed(treePlacement(PlacementUtils.countExtra(10, 0.1F, 1))));
    public static final PlacedFeature ANCIENT_TREE_MEDIUM = PlacementUtils.register("ancient_tree_medium", ATMConfiguredFeature.ANCIENT_TREE_MEDIUM.placed(treePlacement(PlacementUtils.countExtra(10, 0.1F, 1))));
    public static final PlacedFeature ANCIENT_TREE_GIANT = PlacementUtils.register("ancient_tree_giant", ATMConfiguredFeature.ANCIENT_TREE_GIANT.placed(treePlacement(PlacementUtils.countExtra(10, 0.1F, 1))));
    private static List<PlacementModifier> orePlacement(PlacementModifier placement, PlacementModifier placement2) {
        return List.of(placement, InSquarePlacement.spread(), placement2, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier pm) {
        return orePlacement(CountPlacement.of(count), pm);
    }

    private static List<PlacementModifier> rareOrePlacement(int rarity, PlacementModifier pm) {
        return orePlacement(RarityFilter.onAverageOnceEvery(rarity), pm);
    }
    private static ImmutableList.Builder<PlacementModifier> treePlacementBase(PlacementModifier p_195485_) {
        return ImmutableList.<PlacementModifier>builder().add(p_195485_).add(InSquarePlacement.spread()).add(VegetationPlacements.TREE_THRESHOLD).add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE).add(BiomeFilter.biome());
    }

    public static List<PlacementModifier> treePlacement(PlacementModifier p_195480_) {
        return treePlacementBase(p_195480_).build();
    }

    public static List<PlacementModifier> treePlacement(PlacementModifier p_195482_, Block p_195483_) {
        return treePlacementBase(p_195482_).add(BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(p_195483_.defaultBlockState(), BlockPos.ZERO))).build();
    }
}
