package com.thevortex.allthemodium.worldgen;

import com.google.common.collect.ImmutableList;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.allthemods.alltheores.infos.Configuration;
import net.allthemods.alltheores.worldgen.ATOConfiguredFeature;
import net.allthemods.alltheores.worldgen.features.ATOOtherFeatures;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.features.NetherFeatures;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ATMPlacedFeature {


    public static final Holder<PlacedFeature> ORE_ALLTHEMODIUM = PlacementUtils.register("ore_allthemodium", ATMConfiguredFeature.ORE_ALLTHEMODIUM,rareOrePlacement(9, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(15), VerticalAnchor.absolute(20))));
    public static final Holder<PlacedFeature> ORE_ALLTHEMODIUM_MOUNTAIN = PlacementUtils.register("ore_allthemodium_mountain", ATMConfiguredFeature.ORE_ALLTHEMODIUM,commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(170),VerticalAnchor.belowTop(20))));
    public static final Holder<PlacedFeature> ORE_ATM_MINING = PlacementUtils.register("ore_atm_mining", ATMConfiguredFeature.ORE_ATM_MINING,rareOrePlacement(9, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(5), VerticalAnchor.absolute(20))));
    public static final Holder<PlacedFeature> ORE_VIBRANIUM = PlacementUtils.register("ore_vibranium", ATMConfiguredFeature.ORE_VIBRANIUM,rareOrePlacement(7, HeightRangePlacement.uniform(VerticalAnchor.belowTop(28), VerticalAnchor.belowTop(5))));
    public static final Holder<PlacedFeature> ORE_VIBRANIUM_OTHER = PlacementUtils.register("other_vibranium_ore", ATMConfiguredFeature.OTHER_ORE_VIBRANIUM,commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(1), VerticalAnchor.absolute(20))));

    public static final Holder<PlacedFeature> ORE_UNOBTAINIUM = PlacementUtils.register("ore_unobtainium", ATMConfiguredFeature.ORE_UNOBTAINIUM,rareOrePlacement(9, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(15), VerticalAnchor.absolute(78))));

    public static final Holder<PlacedFeature> VOLCANO_CF = PlacementUtils.register("volcano", ATMConfiguredFeature.VOLCANO_CF);
    public static final Holder<PlacedFeature> MOD_DELTAS = PlacementUtils.register("other_deltas", ATMConfiguredFeature.MOD_DELTAS);
    public static final Holder<PlacedFeature> ANCIENT_TREE = PlacementUtils.register("ancient_tree", ATMConfiguredFeature.ANCIENT_TREE,treePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));
    public static final Holder<PlacedFeature> ANCIENT_TREE_MEDIUM = PlacementUtils.register("ancient_tree_medium", ATMConfiguredFeature.ANCIENT_TREE_MEDIUM,treePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));
    public static final Holder<PlacedFeature> ANCIENT_TREE_GIANT = PlacementUtils.register("ancient_tree_giant", ATMConfiguredFeature.ANCIENT_TREE_GIANT,treePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));

    public static final Holder<PlacedFeature> DEMONIC_TREE = PlacementUtils.register("demonic_tree", ATMConfiguredFeature.DEMONIC_TREE,treePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));
    public static final Holder<PlacedFeature> DEMONIC_TREE_MEDIUM = PlacementUtils.register("demonic_tree_medium", ATMConfiguredFeature.DEMONIC_TREE_MEDIUM,treePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));
    public static final Holder<PlacedFeature> DEMONIC_TREE_GIANT = PlacementUtils.register("demonic_tree_giant", ATMConfiguredFeature.DEMONIC_TREE_GIANT,treePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));

    public static final Holder<PlacedFeature> SOUL_TREE = PlacementUtils.register("soul_tree", ATMConfiguredFeature.SOUL_TREE,treePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));
    public static final Holder<PlacedFeature> SOUL_TREE_MEDIUM = PlacementUtils.register("soul_tree_medium", ATMConfiguredFeature.SOUL_TREE_MEDIUM,treePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));
    public static final Holder<PlacedFeature> SOUL_TREE_GIANT = PlacementUtils.register("soul_tree_giant", ATMConfiguredFeature.SOUL_TREE_GIANT,treePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));

    public static final Holder<PlacedFeature> CAVE_VINES = PlacementUtils.register("cave_vines", ATMConfiguredFeature.CAVE_VINE,CountPlacement.of(188), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.hasSturdyFace(Direction.DOWN), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BiomeFilter.biome());


    public static final Holder<PlacedFeature> CAVE_ATM = PlacementUtils.register("cave_ore", ATMConfiguredFeature.ORE_ALLTHEMODIUM,CountPlacement.of(50), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.hasSturdyFace(Direction.DOWN), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BiomeFilter.biome());





    public static final Holder<PlacedFeature> OTHER_ORE_COAL = PlacementUtils.register("ore_coal", ATOOtherFeatures.OTHER_ORE_COAL,commonOrePlacement(30, HeightRangePlacement.uniform(VerticalAnchor.absolute(136), VerticalAnchor.top())));
    public static final Holder<PlacedFeature> OTHER_ORE_COPPER = PlacementUtils.register("ore_copper", ATOOtherFeatures.OTHER_ORE_COPPER,commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));
    public static final Holder<PlacedFeature> OTHER_ORE_DIAMOND = PlacementUtils.register("ore_diamond", ATOOtherFeatures.OTHER_ORE_DIAMOND,commonOrePlacement(14, HeightRangePlacement.triangle(VerticalAnchor.absolute(-10), VerticalAnchor.absolute(129))));
    public static final Holder<PlacedFeature> OTHER_ORE_EMERALD = PlacementUtils.register("ore_emerald", ATOOtherFeatures.OTHER_ORE_EMERALD,commonOrePlacement(20, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(480))));
    public static final Holder<PlacedFeature> OTHER_ORE_GOLD = PlacementUtils.register("ore_gold", ATOOtherFeatures.OTHER_ORE_GOLD,commonOrePlacement(20, PlacementUtils.RANGE_10_10));
    public static final Holder<PlacedFeature> OTHER_ORE_IRON = PlacementUtils.register("ore_iron", ATOOtherFeatures.OTHER_ORE_IRON,commonOrePlacement(50, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(384))));
    public static final Holder<PlacedFeature> OTHER_ORE_LAPIS = PlacementUtils.register("ore_lapis", ATOOtherFeatures.OTHER_ORE_LAPIS,commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64))));
    public static final Holder<PlacedFeature> OTHER_ORE_QUARTZ = PlacementUtils.register("ore_quartz", ATOOtherFeatures.OTHER_ORE_QUARTZ,commonOrePlacement(16, PlacementUtils.RANGE_10_10));
    public static final Holder<PlacedFeature> OTHER_ORE_REDSTONE = PlacementUtils.register("ore_redstone", ATOOtherFeatures.OTHER_ORE_REDSTONE,commonOrePlacement(14, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(15))));






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
