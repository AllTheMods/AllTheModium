package com.thevortex.allthemodium.items;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper;

public class SoulBucket extends BucketItem {
	
	

	public SoulBucket(Supplier<? extends Fluid> supplier, Properties builder) {
		super(supplier, builder);
	}

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
        return new FluidBucketWrapper(stack);
    }

	
	@Override
	public int getBurnTime(ItemStack itemStack) {
		return 100000;
	}
}
