package net.allthemods.allthemodium.common.fluid;

import net.neoforged.neoforge.fluids.FluidType;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

import net.allthemods.allthemodium.core.mixin.LivingEntityInvoker;

public class ATMFluidType extends FluidType {
    
    public ATMFluidType(Properties properties) {
        super(properties);
    }
    
    @Override
    public boolean move(LivingEntity entity, Vec3 movementVector, double gravity) {
        if (!(entity instanceof LivingEntityInvoker invoker)) return false;
        invoker.doTravelInWater(movementVector, gravity, entity.getDeltaMovement().y <= 0.0D, entity.getY());
        return true;
    }
}
