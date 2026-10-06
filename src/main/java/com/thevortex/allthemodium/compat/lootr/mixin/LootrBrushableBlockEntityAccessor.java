package com.thevortex.allthemodium.compat.lootr.mixin;

import noobanidus.mods.lootr.common.block.entity.LootrBrushableBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = LootrBrushableBlockEntity.class, remap = false)
public interface LootrBrushableBlockEntityAccessor {

    @Accessor("brushCount")
    int allthemodium$getBrushCount();

    @Accessor("brushCount")
    void allthemodium$setBrushCount(int brushCount);

    @Accessor("coolDownEndsAtTick")
    long allthemodium$getCoolDownEndsAtTick();
}
