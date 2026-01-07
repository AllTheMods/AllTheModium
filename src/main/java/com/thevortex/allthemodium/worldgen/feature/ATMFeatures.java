package com.thevortex.allthemodium.worldgen.feature;

import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ATMFeatures
{
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, Reference.MOD_ID);
    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS = DeferredRegister.create(Registries.TREE_DECORATOR_TYPE, Reference.MOD_ID);

    public static final DeferredHolder<TreeDecoratorType<?>, TreeDecoratorType<BottomBranchDecorator>> BOTTOM_BRANCH_DECORATOR = TREE_DECORATORS.register("bottom_branch", () -> new TreeDecoratorType<>(BottomBranchDecorator.CODEC));;
}
