package net.allthemods.allthemodium.common.fluid;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

public abstract class MoltenMetalFluid extends FlowingFluid {
    
    @Override
    protected void animateTick(Level level, BlockPos pos, FluidState fluidState, RandomSource random) {
        if (!fluidState.isSource() && !fluidState.getValue(FlowingFluid.FALLING)) {
            if (random.nextInt(64) == 0) {
                level.playLocalSound(
                        pos.getX() + 0.5D,
                        pos.getY() + 0.5D,
                        pos.getZ() + 0.5D,
                        SoundEvents.WATER_AMBIENT,
                        SoundSource.BLOCKS,
                        random.nextFloat() * 0.25F + 0.75F,
                        random.nextFloat() + 0.5F,
                        false
                );
            }
        } else if (random.nextInt(10) == 0) {
            level.addParticle(ParticleTypes.UNDERWATER, pos.getX() + random.nextDouble(), pos.getY() + random.nextDouble(), pos.getZ() + random.nextDouble(), 0.0D, 0.0D, 0.0D);
        }
    }
    
    @Override
    protected boolean canConvertToSource(ServerLevel level) {
        return false;
    }
    
    @Override
    protected void beforeDestroyingBlock(LevelAccessor level, BlockPos pos, BlockState state) {
        BlockEntity blockEntity = state.hasBlockEntity() ? level.getBlockEntity(pos) : null;
        Block.dropResources(state, level, pos, blockEntity);
    }
    
    @Override
    protected int getSlopeFindDistance(LevelReader level) {
        return 4;
    }
    
    @Override
    protected int getDropOff(LevelReader level) {
        return 1;
    }
    
    @Override
    public int getTickDelay(LevelReader level) {
        return 8;
    }
    
    @Override
    protected boolean canBeReplacedWith(FluidState state, BlockGetter level, BlockPos pos, Fluid other, Direction direction) {
        return false;
    }
    
    @Override
    protected float getExplosionResistance() {
        return 100.0F;
    }
}
