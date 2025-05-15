package com.thevortex.allthemodium.mixins;

import java.util.Map;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Block;

@Mixin(AxeItem.class)
public class MixinAxeItem {

    @Shadow
    @Final
    protected static final Map<Block, Block> STRIPPABLES = null;

    @Accessor("STRIPPABLES")
    public static Map<Block, Block> getStrippables() {
        return STRIPPABLES;
    }
}
