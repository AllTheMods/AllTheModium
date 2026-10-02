package net.allthemods.allthemodium.core.mixin;

import net.minecraft.world.level.block.entity.BrushableBlockEntity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BrushableBlockEntity.class)
public interface BrushableBlockEntityAccessor {

    @Accessor("brushCount")
    int getBrushCount();

    @Accessor("brushCount")
    void setBrushCount(int brushCount);

    @Accessor("coolDownEndsAtTick")
    long getCoolDownEndsAtTick();
}
