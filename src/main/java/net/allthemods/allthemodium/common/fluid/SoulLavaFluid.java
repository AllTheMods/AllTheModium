package net.allthemods.allthemodium.common.fluid;

import net.neoforged.neoforge.fluids.FluidType;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.LavaFluid;

import net.allthemods.allthemodium.core.registry.ATMFluids;

public abstract class SoulLavaFluid extends LavaFluid {
    
    @Override
    public FluidType getFluidType() {
        return ATMFluids.SOUL_LAVA_TYPE.get();
    }
    
    @Override
    public Flowing getFlowing() {
        return ATMFluids.SOUL_LAVA_FLOWING.get();
    }
    
    @Override
    public Source getSource() {
        return ATMFluids.SOUL_LAVA.get();
    }
    
    @Override
    public BucketItem getBucket() {
        return ATMFluids.SOUL_LAVA_BUCKET.get();
    }
    
    @Override
    public BlockState createLegacyBlock(FluidState fluidState) {
        return ATMFluids.SOUL_LAVA_BLOCK.get().defaultBlockState().setValue(LiquidBlock.LEVEL, FlowingFluid.getLegacyLevel(fluidState));
    }
    
    @Override
    public boolean canBeReplacedWith(FluidState state, BlockGetter level, BlockPos pos, Fluid other, Direction direction) {
        return false;
    }
    
    @Override
    public boolean isSame(Fluid other) {
        return other == ATMFluids.SOUL_LAVA.get() || other == ATMFluids.SOUL_LAVA_FLOWING.get();
    }
    
    @Override
    public int getSlopeFindDistance(LevelReader level) {
        return 4;
    }
    
    @Override
    public int getTickDelay(LevelReader level) {
        return 5;
    }
    
    @Override
    public int getDropOff(LevelReader level) {
        return 1;
    }
    
    @Override
    public void animateTick(Level level, BlockPos pos, FluidState fluidState, RandomSource random) {
        BlockPos above = pos.above();
        if (level.getBlockState(above).isAir() && !level.getBlockState(above).isSolidRender()) {
            if (random.nextInt(50) == 0) {
                double xx = pos.getX() + random.nextDouble();
                double yy = pos.getY() + 1.0;
                double zz = pos.getZ() + random.nextDouble();
                level.addParticle(ParticleTypes.SOUL_FIRE_FLAME, xx, yy, zz, 0.0, 0.0, 0.0);
                level.playLocalSound(xx, yy, zz, SoundEvents.LAVA_POP, SoundSource.AMBIENT, 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
            }
            
            if (random.nextInt(180) == 0) {
                level.playLocalSound(
                        pos.getX(),
                        pos.getY(),
                        pos.getZ(),
                        SoundEvents.LAVA_AMBIENT,
                        SoundSource.AMBIENT,
                        0.2F + random.nextFloat() * 0.2F,
                        0.9F + random.nextFloat() * 0.15F,
                        false
                );
            }
        }
    }
    
    public static final class Flowing extends SoulLavaFluid {
        
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
    
    public static final class Source extends SoulLavaFluid {
        
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
