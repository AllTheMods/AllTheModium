package net.allthemods.allthemodium.common.fluid;

import net.neoforged.neoforge.fluids.FluidType;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

import net.allthemods.allthemodium.core.registry.ATMFluids;

import org.jspecify.annotations.Nullable;

public abstract class VibraniumFluid extends MoltenMetalFluid {
    
    @Override
    public FluidType getFluidType() {
        return ATMFluids.MOLTEN_VIBRANIUM_TYPE.get();
    }
    
    @Override
    public Flowing getFlowing() {
        return ATMFluids.MOLTEN_VIBRANIUM_FLOWING.get();
    }
    
    @Override
    public Source getSource() {
        return ATMFluids.MOLTEN_VIBRANIUM.get();
    }
    
    @Override
    public BucketItem getBucket() {
        return ATMFluids.MOLTEN_VIBRANIUM_BUCKET.get();
    }
    
    @Override
    public BlockState createLegacyBlock(FluidState fluidState) {
        return ATMFluids.MOLTEN_VIBRANIUM_BLOCK.get().defaultBlockState().setValue(LiquidBlock.LEVEL, FlowingFluid.getLegacyLevel(fluidState));
    }
    
    @Override
    protected @Nullable ParticleOptions getDripParticle() {
        return ParticleTypes.ELECTRIC_SPARK;
    }
    
    @Override
    public boolean isSame(Fluid other) {
        return other == ATMFluids.MOLTEN_VIBRANIUM.get() || other == ATMFluids.MOLTEN_VIBRANIUM_FLOWING.get();
    }
    
    public static final class Flowing extends VibraniumFluid {
        
        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(FlowingFluid.LEVEL);
        }
        
        @Override
        public boolean isSource(FluidState state) {
            return false;
        }
        
        @Override
        public int getAmount(FluidState state) {
            return state.getValue(FlowingFluid.LEVEL);
        }
    }
    
    public static final class Source extends VibraniumFluid {
        
        @Override
        public boolean isSource(FluidState state) {
            return true;
        }
        
        @Override
        public int getAmount(FluidState state) {
            return 8;
        }
    }
}
