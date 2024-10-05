package com.thevortex.allthemodium.blocks;

import com.thevortex.allthemodium.registry.ModRegistry;
import java.util.Random;
import javax.annotation.Nonnull;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SoulLeaves extends LeavesBlock {

    public static final int DECAY_DISTANCE = 7;
    public static final IntegerProperty DISTANCE = BlockStateProperties.DISTANCE;
    public static final BooleanProperty PERSISTENT = BlockStateProperties.PERSISTENT;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    private static final int TICK_DELAY = 80;
    private static int TICK_COUNT;

    public SoulLeaves(Properties p_54422_) {
        super(p_54422_.randomTicks());
        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(DISTANCE, Integer.valueOf(7))
                        .setValue(PERSISTENT, Boolean.valueOf(false))
                        .setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    @Override
    public VoxelShape getBlockSupportShape(
            @Nonnull BlockState p_54456_,
            @Nonnull BlockGetter p_54457_,
            @Nonnull BlockPos p_54458_) {
        return Shapes.empty();
    }

    @Override
    public boolean isRandomlyTicking(@Nonnull BlockState p_54449_) {
        return (p_54449_.getValue(DISTANCE) == 7 && !p_54449_.getValue(PERSISTENT));
    }

    @Override
    public void randomTick(
            @Nonnull BlockState state,
            @Nonnull ServerLevel level,
            @Nonnull BlockPos pos,
            @Nonnull RandomSource rand) {
        if (!state.getValue(PERSISTENT) && state.getValue(DISTANCE) == 7) {
            dropResources(state, level, pos);
            level.removeBlock(pos, false);
        }
        if (level.getBlockState(pos.below()).isAir()) {
            level.setBlock(
                    pos.below(),
                    ModRegistry.SOUL_LEAVES_BOTTOM.get().defaultBlockState(),
                    3);
        }
    }

    @Override
    public boolean onDestroyedByPlayer(
            BlockState state,
            Level world,
            BlockPos pos,
            Player player,
            boolean willHarvest,
            FluidState fluid) {
        if (world.getBlockState(pos.below()).getBlock() instanceof SoulLeavesBottom) {
            world.setBlockAndUpdate(
                    pos.below(),
                    Blocks.AIR.defaultBlockState());
        }
        return super.onDestroyedByPlayer(
                state,
                world,
                pos,
                player,
                willHarvest,
                fluid);
    }

    public void tick(
            BlockState state,
            ServerLevel level,
            BlockPos pos,
            Random p_54429_) {
        SoulLeaves.TICK_COUNT++;
        if (SoulLeaves.TICK_COUNT >= SoulLeaves.TICK_DELAY) {
            level.setBlock(pos, updateDistance(state, level, pos), 3);
            if (level.getBlockState(pos.below()).isAir()) {
                level.setBlock(
                        pos.below(),
                        ModRegistry.SOUL_LEAVES_BOTTOM.get().defaultBlockState(),
                        3);
            }
            SoulLeaves.TICK_COUNT = 0;
        }
    }

    @Override
    public int getLightBlock(
            @Nonnull BlockState p_54460_,
            @Nonnull BlockGetter p_54461_,
            @Nonnull BlockPos p_54462_) {
        return 1;
    }

    @Override
    public BlockState updateShape(
            @Nonnull BlockState p_54440_,
            @Nonnull Direction p_54441_,
            @Nonnull BlockState p_54442_,
            @Nonnull LevelAccessor p_54443_,
            @Nonnull BlockPos p_54444_,
            @Nonnull BlockPos p_54445_) {
        int i = getDistanceAt(p_54442_) + 1;
        if (i != 1 || p_54440_.getValue(DISTANCE) != i) {
            p_54443_.scheduleTick(p_54444_, this, 1);
        }

        return p_54440_;
    }

    private static BlockState updateDistance(
            BlockState p_54436_,
            LevelAccessor p_54437_,
            BlockPos p_54438_) {
        int i = 7;
        BlockPos.MutableBlockPos blockPos$mutableBlockPos = new BlockPos.MutableBlockPos();

        for (Direction direction : Direction.values()) {
            blockPos$mutableBlockPos.setWithOffset(p_54438_, direction);
            i = Math.min(
                    i,
                    getDistanceAt(
                            p_54437_.getBlockState(blockPos$mutableBlockPos)) +
                            1);
            if (i == 1) {
                break;
            }
        }

        return p_54436_.setValue(DISTANCE, Integer.valueOf(i));
    }

    private static int getDistanceAt(BlockState p_54464_) {
        if (p_54464_.is(BlockTags.LOGS)) {
            return 0;
        } else {
            return p_54464_.getBlock() instanceof LeavesBlock
                    ? p_54464_.getValue(DISTANCE)
                    : 7;
        }
    }

    @Override
    public void animateTick(
            @Nonnull BlockState p_54431_,
            @Nonnull Level p_54432_,
            @Nonnull BlockPos p_54433_,
            @Nonnull RandomSource p_54434_) {
        if (p_54432_.isRainingAt(p_54433_.above())) {
            if (p_54434_.nextInt(15) == 1) {
                BlockPos blockPos = p_54433_.below();
                BlockState blockState = p_54432_.getBlockState(blockPos);
                if (!blockState.canOcclude() ||
                        !blockState.isFaceSturdy(p_54432_, blockPos, Direction.UP)) {
                    double d0 = (double) p_54433_.getX() + p_54434_.nextDouble();
                    double d1 = (double) p_54433_.getY() - 0.05D;
                    double d2 = (double) p_54433_.getZ() + p_54434_.nextDouble();
                    p_54432_.addParticle(
                            ParticleTypes.DRIPPING_WATER,
                            d0,
                            d1,
                            d2,
                            0.0D,
                            0.0D,
                            0.0D);
                }
            }
        }
    }

    protected void createBlockStateDefinition(
            @Nonnull StateDefinition.Builder<Block, BlockState> p_54447_) {
        p_54447_.add(DISTANCE, PERSISTENT, WATERLOGGED);
    }

    @Override
    public BlockState getStateForPlacement(
            @Nonnull BlockPlaceContext p_54424_) {
        return updateDistance(
                this.defaultBlockState()
                        .setValue(PERSISTENT, Boolean.valueOf(true)),
                p_54424_.getLevel(),
                p_54424_.getClickedPos());
    }
}
