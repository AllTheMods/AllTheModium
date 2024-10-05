package com.thevortex.allthemodium.blocks;

import com.thevortex.allthemodium.registry.BlockRegistry;
import java.util.function.Supplier;
import javax.annotation.Nonnull;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.ForgeEventFactory;

public class SoulLava extends LiquidBlock {

    public int tickCount = 0;
    protected FlowingFluid fluid;

    public SoulLava(
            Supplier<? extends FlowingFluid> supplier,
            Properties p_i48368_1_) {
        super(supplier, p_i48368_1_);
    }

    @Override
    public boolean isBurning(
            BlockState state,
            BlockGetter world,
            BlockPos pos) {
        return true;
    }

    @Override
    public boolean isFireSource(
            BlockState state,
            LevelReader world,
            BlockPos pos,
            Direction side) {
        return true;
    }

    @Override
    public boolean canEntityDestroy(
            BlockState state,
            BlockGetter world,
            BlockPos pos,
            Entity entity) {
        return false;
    }

    @Override
    public boolean canBeReplaced(
            @Nonnull BlockState state,
            @Nonnull BlockPlaceContext context) {
        return false;
    }

    @Override
    public void randomTick(
            @Nonnull BlockState state,
            @Nonnull ServerLevel level,
            @Nonnull BlockPos pos,
            @Nonnull RandomSource random) {
        if (level.getGameRules().getBoolean(GameRules.RULE_DOFIRETICK)) {
            int i = random.nextInt(10);
            if (i > 0) {
                BlockPos blockPos = pos;

                for (int j = 0; j < i; ++j) {
                    blockPos = blockPos.offset(
                            random.nextInt(10) - 1,
                            1,
                            random.nextInt(10) - 1);
                    if (!level.isEmptyBlock(blockPos)) {
                        return;
                    }

                    BlockState blockState = level.getBlockState(blockPos);
                    @SuppressWarnings("unused")
                    BlockState FIRE = SoulFireBlock.canSurviveOnBlock(
                            blockState)
                                    ? Blocks.SOUL_FIRE.defaultBlockState()
                                    : ((FireBlock) Blocks.FIRE).defaultBlockState();
                }
            } else {
                for (int k = 0; k < 10; ++k) {
                    BlockPos blockPos1 = pos.offset(
                            random.nextInt(10) - 1,
                            0,
                            random.nextInt(10) - 1);
                    BlockState FIRE = SoulFireBlock.canSurviveOnBlock(
                            level.getBlockState(blockPos1))
                                    ? Blocks.SOUL_FIRE.defaultBlockState()
                                    : ((FireBlock) Blocks.FIRE).defaultBlockState();

                    if (!level.isEmptyBlock(blockPos1)) {
                        return;
                    }

                    level.setBlockAndUpdate(
                            blockPos1.above(),
                            ForgeEventFactory.fireFluidPlaceBlockEvent(
                                    level,
                                    blockPos1.above(),
                                    pos,
                                    FIRE));
                }
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void animateTick(
            @Nonnull BlockState stateIn,
            @Nonnull Level worldIn,
            @Nonnull BlockPos pos,
            @Nonnull RandomSource rand) {
        this.tickCount++;

        if (stateIn.is(BlockRegistry.SOULLAVA_BLOCK.get()) &&
                this.tickCount >= 40) {
            spawnParticles(worldIn, pos);
            this.tickCount = 0;
        }
        super.animateTick(stateIn, worldIn, pos, rand);
    }

    private static void spawnParticles(Level world, BlockPos worldIn) {
        // double d0 = 0.5625D;
        RandomSource random = world.random;

        if (world.getFluidState(worldIn).isSource() &&
                (random.nextBoolean() == true)) {
            for (Direction direction : Direction.values()) {
                BlockPos blockPos = worldIn.offset(direction.getNormal());
                if (!world
                        .getBlockState(blockPos)
                        .isSolidRender(world, blockPos)) {
                    Direction.Axis direction$axis = direction.getAxis();
                    double d1 = direction$axis == Direction.Axis.X
                            ? 0.5D + 0.5625D * (double) direction.getStepX()
                            : (double) random.nextFloat();
                    double d2 = direction$axis == Direction.Axis.Y
                            ? 0.5D + 0.5625D * (double) direction.getStepY()
                            : (double) random.nextFloat();
                    double d3 = direction$axis == Direction.Axis.Z
                            ? 0.5D + 0.5625D * (double) direction.getStepZ()
                            : (double) random.nextFloat();
                    world.addParticle(
                            ParticleTypes.SOUL_FIRE_FLAME,
                            (double) worldIn.getX() + d1,
                            (double) worldIn.getY() + d2,
                            (double) worldIn.getZ() + d3,
                            random.nextFloat(),
                            random.nextFloat(),
                            random.nextFloat());
                    world.addParticle(
                            ParticleTypes.SOUL_FIRE_FLAME,
                            (double) worldIn.getX() + d1,
                            (double) worldIn.getY() + d2,
                            (double) worldIn.getZ() + d3,
                            random.nextFloat(),
                            -random.nextFloat(),
                            -random.nextFloat());
                    world.addParticle(
                            ParticleTypes.SOUL_FIRE_FLAME,
                            (double) worldIn.getX() + d1,
                            (double) worldIn.getY() + d2,
                            (double) worldIn.getZ() + d3,
                            -random.nextFloat(),
                            random.nextFloat(),
                            -random.nextFloat());
                    world.addParticle(
                            ParticleTypes.SOUL_FIRE_FLAME,
                            (double) worldIn.getX() + d1,
                            (double) worldIn.getY() + d2,
                            (double) worldIn.getZ() + d3,
                            -random.nextFloat(),
                            -random.nextFloat(),
                            random.nextFloat());
                }
            }
        }
    }

    @Override
    public int getFireSpreadSpeed(
            BlockState state,
            BlockGetter world,
            BlockPos pos,
            Direction face) {
        return 1000;
    }
}
