package net.allthemods.allthemodium.core.registry;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.common.world.BottomBranchDecorator;

public class ATMTreeDecorators {
    
    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS = DeferredRegister.create(Registries.TREE_DECORATOR_TYPE, ATM.MOD_ID);
    
    public static final DeferredHolder<TreeDecoratorType<?>, TreeDecoratorType<BottomBranchDecorator>> BOTTOM_BRANCH = ATMTreeDecorators.TREE_DECORATORS.register(
            "bottom_branch", () -> new TreeDecoratorType<>(BottomBranchDecorator.CODEC)
    );
    
    public static void register(final IEventBus bus) {
        ATMTreeDecorators.TREE_DECORATORS.register(bus);
    }
}
