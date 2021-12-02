package com.thevortex.allthemodium.worldgen;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ATMPlacedFeature {

    public static final PlacedFeature ORE_ALLTHEMODIUM = PlacementUtils.register("ore_allthemodium", ATMConfiguredFeature.ORE_ALLTHEMODIUM.placed(rareOrePlacement(1, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(15), VerticalAnchor.absolute(20)))));
    public static final PlacedFeature ORE_ALLTHEMODIUM_MOUNTAIN = PlacementUtils.register("ore_allthemodium_mountain", ATMConfiguredFeature.ORE_ALLTHEMODIUM.placed(commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(170),VerticalAnchor.belowTop(20)))));
    public static final PlacedFeature ORE_ATM_MINING = PlacementUtils.register("ore_atm_mining", ATMConfiguredFeature.ORE_ATM_MINING.placed(rareOrePlacement(1, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(5), VerticalAnchor.absolute(10)))));
    public static final PlacedFeature ORE_VIBRANIUM = PlacementUtils.register("ore_vibranium", ATMConfiguredFeature.ORE_VIBRANIUM.placed(rareOrePlacement(1, HeightRangePlacement.uniform(VerticalAnchor.belowTop(5), VerticalAnchor.belowTop(15)))));
    public static final PlacedFeature ORE_UNOBTAINIUM = PlacementUtils.register("ore_unobtainium", ATMConfiguredFeature.ORE_UNOBTAINIUM.placed(rareOrePlacement(1, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(15), VerticalAnchor.absolute(78)))));

    public static final PlacedFeature VOLCANO_CF = PlacementUtils.register("volcano", ATMConfiguredFeature.VOLCANO_CF.placed());
    public static final PlacedFeature MOD_DELTAS = PlacementUtils.register("other_deltas", ATMConfiguredFeature.MOD_DELTAS.placed());

    private static List<PlacementModifier> orePlacement(PlacementModifier placement, PlacementModifier placement2) {
        return List.of(placement, InSquarePlacement.spread(), placement2, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier pm) {
        return orePlacement(CountPlacement.of(count), pm);
    }

    private static List<PlacementModifier> rareOrePlacement(int rarity, PlacementModifier pm) {
        return orePlacement(RarityFilter.onAverageOnceEvery(rarity), pm);
    }
}
