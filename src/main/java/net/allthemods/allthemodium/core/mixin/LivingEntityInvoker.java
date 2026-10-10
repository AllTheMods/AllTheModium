package net.allthemods.allthemodium.core.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(LivingEntity.class)
public interface LivingEntityInvoker {
    
    @Invoker("travelInWater")
    void doTravelInWater(Vec3 input, double baseGravity, boolean isFalling, double oldY);
}
