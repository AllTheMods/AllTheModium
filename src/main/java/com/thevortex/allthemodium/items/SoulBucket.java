package com.thevortex.allthemodium.items;

import java.util.function.Supplier;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper;

public class SoulBucket extends BucketItem {

    public SoulBucket(Supplier<? extends Fluid> supplier, Properties builder) {
        super(supplier, builder);
    }

    @Override
    public ICapabilityProvider initCapabilities(
            @Nonnull ItemStack stack,
            @Nullable CompoundTag nbt) {
        return new FluidBucketWrapper(stack);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, RecipeType<?> provider) {
        return 100000;
    }
}
