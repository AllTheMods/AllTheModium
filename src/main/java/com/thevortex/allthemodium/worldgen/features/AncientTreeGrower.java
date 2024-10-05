package com.thevortex.allthemodium.worldgen.features;

import com.thevortex.allthemodium.worldgen.ATMConfiguredFeature;
import javax.annotation.Nonnull;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import org.jetbrains.annotations.Nullable;

public class AncientTreeGrower extends AbstractTreeGrower {

    @Nullable
    @Override
    protected Holder<ConfiguredFeature<TreeConfiguration, ?>> getConfiguredFeature(@Nonnull RandomSource random,
            boolean bool) {
        int temp = random.nextInt(10);
        if (temp == 1) {
            return ATMConfiguredFeature.ANCIENT_TREE_GIANT;
        }
        if (temp > 6) {
            return ATMConfiguredFeature.ANCIENT_TREE;
        }
        return ATMConfiguredFeature.ANCIENT_TREE_MEDIUM;
    }
}
