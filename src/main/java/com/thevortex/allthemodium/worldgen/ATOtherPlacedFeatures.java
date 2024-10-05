package com.thevortex.allthemodium.worldgen;

import java.util.List;
import net.allthemods.alltheores.worldgen.features.ATOOtherFeatures;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

public class ATOtherPlacedFeatures {

    public static final Holder<PlacedFeature> OTHER_ORE_COAL = PlacementUtils.register(
            "allthemodium:ore_coal",
            ATOOtherFeatures.OTHER_ORE_COAL,
            commonOrePlacement(
                    30,
                    HeightRangePlacement.uniform(
                            VerticalAnchor.absolute(136),
                            VerticalAnchor.top())));
    public static final Holder<PlacedFeature> OTHER_ORE_COPPER = PlacementUtils.register(
            "allthemodium:ore_copper",
            ATOOtherFeatures.OTHER_ORE_COPPER,
            commonOrePlacement(
                    16,
                    HeightRangePlacement.triangle(
                            VerticalAnchor.absolute(-16),
                            VerticalAnchor.absolute(112))));
    public static final Holder<PlacedFeature> OTHER_ORE_DIAMOND = PlacementUtils.register(
            "allthemodium:ore_diamond",
            ATOOtherFeatures.OTHER_ORE_DIAMOND,
            commonOrePlacement(
                    14,
                    HeightRangePlacement.triangle(
                            VerticalAnchor.absolute(-10),
                            VerticalAnchor.absolute(129))));
    public static final Holder<PlacedFeature> OTHER_ORE_EMERALD = PlacementUtils.register(
            "allthemodium:ore_emerald",
            ATOOtherFeatures.OTHER_ORE_EMERALD,
            commonOrePlacement(
                    20,
                    HeightRangePlacement.triangle(
                            VerticalAnchor.absolute(-16),
                            VerticalAnchor.absolute(480))));
    public static final Holder<PlacedFeature> OTHER_ORE_GOLD = PlacementUtils.register(
            "allthemodium:ore_gold",
            ATOOtherFeatures.OTHER_ORE_GOLD,
            commonOrePlacement(20, PlacementUtils.RANGE_10_10));
    public static final Holder<PlacedFeature> OTHER_ORE_IRON = PlacementUtils.register(
            "allthemodium:ore_iron",
            ATOOtherFeatures.OTHER_ORE_IRON,
            commonOrePlacement(
                    50,
                    HeightRangePlacement.triangle(
                            VerticalAnchor.absolute(-24),
                            VerticalAnchor.absolute(384))));
    public static final Holder<PlacedFeature> OTHER_ORE_LAPIS = PlacementUtils.register(
            "allthemodium:ore_lapis",
            ATOOtherFeatures.OTHER_ORE_LAPIS,
            commonOrePlacement(
                    4,
                    HeightRangePlacement.uniform(
                            VerticalAnchor.bottom(),
                            VerticalAnchor.absolute(64))));
    public static final Holder<PlacedFeature> OTHER_ORE_QUARTZ = PlacementUtils.register(
            "allthemodium:ore_quartz",
            ATOOtherFeatures.OTHER_ORE_QUARTZ,
            commonOrePlacement(16, PlacementUtils.RANGE_10_10));
    public static final Holder<PlacedFeature> OTHER_ORE_REDSTONE = PlacementUtils.register(
            "allthemodium:ore_redstone",
            ATOOtherFeatures.OTHER_ORE_REDSTONE,
            commonOrePlacement(
                    14,
                    HeightRangePlacement.uniform(
                            VerticalAnchor.bottom(),
                            VerticalAnchor.absolute(15))));

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
}
