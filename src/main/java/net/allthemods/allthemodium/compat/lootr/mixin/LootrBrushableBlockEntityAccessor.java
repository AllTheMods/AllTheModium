package net.allthemods.allthemodium.compat.lootr.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import noobanidus.mods.lootr.common.block.entity.LootrBrushableBlockEntity;

@Mixin(LootrBrushableBlockEntity.class)
public interface LootrBrushableBlockEntityAccessor {

    @Accessor("brushCount")
    int allthemodium$getBrushCount();

    @Accessor("brushCount")
    void allthemodium$setBrushCount(int brushCount);

    @Accessor("coolDownEndsAtTick")
    long allthemodium$getCoolDownEndsAtTick();
}
