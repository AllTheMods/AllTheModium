package com.thevortex.allthemodium.worldgen.carvers;

import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.util.valueproviders.ConstantFloat;
import net.minecraft.util.valueproviders.TrapezoidFloat;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.carver.*;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;

public class ATMCarvers {


    public static final ConfiguredWorldCarver<CaveCarverConfiguration> NETHER_CAVE_CWC = register("allthemodium:nether_cave", ModRegistry.OTHER_CARVER_C.configured(new CaveCarverConfiguration(0.1F, UniformHeight.of(VerticalAnchor.aboveBottom(64), VerticalAnchor.belowTop(280)), ConstantFloat.of(0.5F), VerticalAnchor.aboveBottom(1), false, ConstantFloat.of(1.0F), ConstantFloat.of(1.0F), ConstantFloat.of(-0.7F))));
    public static final ConfiguredWorldCarver<CaveCarverConfiguration> OTHER_CAVE_CWC = register("allthemodium:nether_caverns", ModRegistry.OTHER_CAVE_CARVER_C.configured(new CaveCarverConfiguration(0.12F, UniformHeight.of(VerticalAnchor.aboveBottom(1), VerticalAnchor.belowTop(250)), ConstantFloat.of(0.5F), VerticalAnchor.aboveBottom(1), false, ConstantFloat.of(1.0F), ConstantFloat.of(1.0F), ConstantFloat.of(-0.7F))));
    public static final ConfiguredWorldCarver<CanyonCarverConfiguration> OTHER_CANYON_CWC = register("allthemodium:other_canyons", ModRegistry.OTHER_CANYON_CARVER_C.configured(new CanyonCarverConfiguration(0.05F, UniformHeight.of(VerticalAnchor.aboveBottom(75), VerticalAnchor.absolute(107)), ConstantFloat.of(3.0F), VerticalAnchor.aboveBottom(8), CarverDebugSettings.of(false, Blocks.WARPED_BUTTON.defaultBlockState()), UniformFloat.of(-0.125F, 0.125F), new CanyonCarverConfiguration.CanyonShapeConfiguration(UniformFloat.of(0.75F, 1.0F), TrapezoidFloat.of(0.0F, 6.0F, 2.0F), 3, UniformFloat.of(0.75F, 1.0F), 1.0F, 0.0F))));

    private static <WC extends CarverConfiguration> ConfiguredWorldCarver<WC> register(String name, ConfiguredWorldCarver<WC> carver) {
        return BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_CARVER, name, carver);
    }
}
