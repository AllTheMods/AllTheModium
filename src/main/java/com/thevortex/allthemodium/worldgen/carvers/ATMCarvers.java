package com.thevortex.allthemodium.worldgen.carvers;

import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantFloat;
import net.minecraft.util.valueproviders.TrapezoidFloat;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.carver.*;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.RegistryObject;

public class ATMCarvers {
    public static final Lazy<ConfiguredWorldCarver<CaveCarverConfiguration>> NETHER_CAVE_CWC = configure("other_caves", ModRegistry.OTHER_CARVER, new CaveCarverConfiguration(0.1F, UniformHeight.of(VerticalAnchor.aboveBottom(64), VerticalAnchor.belowTop(280)), ConstantFloat.of(0.5F), VerticalAnchor.aboveBottom(1), false, ConstantFloat.of(1.0F), ConstantFloat.of(1.0F), ConstantFloat.of(-0.7F)));
    public static final Lazy<ConfiguredWorldCarver<CaveCarverConfiguration>> OTHER_CAVE_CWC = configure("other_caverns", ModRegistry.OTHER_CAVE_CARVER, new CaveCarverConfiguration(0.12F, UniformHeight.of(VerticalAnchor.aboveBottom(1), VerticalAnchor.belowTop(250)), ConstantFloat.of(0.5F), VerticalAnchor.aboveBottom(1), false, ConstantFloat.of(1.0F), ConstantFloat.of(1.0F), ConstantFloat.of(-0.7F)));
    public static final Lazy<ConfiguredWorldCarver<CanyonCarverConfiguration>> OTHER_CANYON_CWC = configure("other_canyons", ModRegistry.OTHER_CANYON_CARVER, new CanyonCarverConfiguration(0.05F, UniformHeight.of(VerticalAnchor.aboveBottom(75), VerticalAnchor.absolute(107)), ConstantFloat.of(3.0F), VerticalAnchor.aboveBottom(8), CarverDebugSettings.of(false, Blocks.WARPED_BUTTON.defaultBlockState()), UniformFloat.of(-0.125F, 0.125F), new CanyonCarverConfiguration.CanyonShapeConfiguration(UniformFloat.of(0.75F, 1.0F), TrapezoidFloat.of(0.0F, 6.0F, 2.0F), 3, UniformFloat.of(0.75F, 1.0F), 1.0F, 0.0F)));

    public static final Holder<ConfiguredWorldCarver<?>> NETHER_CAVE_CWC_HOLDER = getHolder("other_caves");
    public static final Holder<ConfiguredWorldCarver<?>> OTHER_CAVE_CWC_HOLDER = getHolder("other_caverns");
    public static final Holder<ConfiguredWorldCarver<?>> OTHER_CANYON_CWC_HOLDER = getHolder("other_canyons");

    public static void register() {

            NETHER_CAVE_CWC.get();
            OTHER_CAVE_CWC.get();
            OTHER_CANYON_CWC.get();

    }

    public static <T extends CarverConfiguration> Lazy<ConfiguredWorldCarver<T>> configure(String registryId, RegistryObject<WorldCarver<T>> carver, T configuration) {
        var registryName = new ResourceLocation(Reference.MOD_ID, registryId);
        return Lazy.of(() -> Registry.register(BuiltinRegistries.CONFIGURED_CARVER, registryName, carver.get().configured(configuration)));
    }

    public static Holder<ConfiguredWorldCarver<?>> getHolder(String registryId) {
        var registryName = new ResourceLocation(Reference.MOD_ID, registryId);
        var resourceKey = ResourceKey.create(BuiltinRegistries.CONFIGURED_CARVER.key(), registryName);
        return Holder.Reference.createStandAlone(BuiltinRegistries.CONFIGURED_CARVER, resourceKey);
    }
}
