package com.thevortex.allthemodium.blocks;

import com.thevortex.allthemodium.registry.ModRegistry;
import com.thevortex.allthemodium.registry.TagRegistry;
import javax.annotation.Nonnull;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AncientSaplingBlock extends SaplingBlock {

    public static final IntegerProperty STAGE = BlockStateProperties.STAGE;
    protected static final float AABB_OFFSET = 6.0F;
    protected static final VoxelShape SHAPE = Block.box(
            2.0D,
            0.0D,
            2.0D,
            14.0D,
            12.0D,
            14.0D);
    private final AbstractTreeGrower treeGrower;

    public AncientSaplingBlock(
            AbstractTreeGrower p_55978_,
            BlockBehaviour.Properties p_55979_) {
        super(p_55978_, p_55979_);
        this.treeGrower = p_55978_;
        this.registerDefaultState(
                this.stateDefinition.any().setValue(STAGE, Integer.valueOf(0)));
    }

    public VoxelShape getShape(
            @Nonnull BlockState p_56008_,
            @Nonnull BlockGetter p_56009_,
            @Nonnull BlockPos p_56010_,
            @Nonnull CollisionContext p_56011_) {
        return SHAPE;
    }

    @Override
    protected boolean mayPlaceOn(
            @Nonnull BlockState state,
            @Nonnull BlockGetter p_51043_,
            @Nonnull BlockPos p_51044_) {
        return (state.is(TagRegistry.ANCIENT_DIRT) ||
                state.is(Blocks.WARPED_NYLIUM) ||
                state.is(Blocks.CRIMSON_NYLIUM) ||
                state.is(ModRegistry.ANCIENT_GRASS.get()));
    }

    @Override
    public VoxelShape getBlockSupportShape(
            @Nonnull BlockState p_60581_,
            @Nonnull BlockGetter p_60582_,
            @Nonnull BlockPos p_60583_) {
        return Shapes.empty();
    }

    @Override
    public boolean canSurvive(
            @Nonnull BlockState state,
            @Nonnull LevelReader reader,
            @Nonnull BlockPos pos) {
        return (state.is(TagRegistry.ANCIENT_DIRT) ||
                state.is(Blocks.WARPED_NYLIUM) ||
                state.is(Blocks.CRIMSON_NYLIUM) ||
                state.is(ModRegistry.ANCIENT_GRASS.get()));
    }

    @SuppressWarnings("deprecation")
    public void randomTick(
            @Nonnull BlockState p_56003_,
            @Nonnull ServerLevel p_56004_,
            @Nonnull BlockPos p_56005_,
            @Nonnull RandomSource p_56006_) {
        if (p_56004_.getMaxLocalRawBrightness(p_56005_.above()) >= 9 &&
                p_56006_.nextInt(7) == 0) {
            if (!p_56004_.isAreaLoaded(p_56005_, 1))
                return; // Forge: prevent loading unloaded chunks when checking neighbor's light
            this.advanceTree(p_56004_, p_56005_, p_56003_, p_56006_);
        }
    }

    public void advanceTree(
            @Nonnull ServerLevel p_55981_,
            @Nonnull BlockPos p_55982_,
            @Nonnull BlockState p_55983_,
            @Nonnull RandomSource p_55984_) {
        if (p_55983_.getValue(STAGE) == 0) {
            p_55981_.setBlock(p_55982_, p_55983_.cycle(STAGE), 4);
        } else {
            if (!net.minecraftforge.event.ForgeEventFactory.saplingGrowTree(
                    p_55981_,
                    p_55984_,
                    p_55982_))
                return;
            this.treeGrower.growTree(
                    p_55981_,
                    p_55981_.getChunkSource().getGenerator(),
                    p_55982_,
                    p_55983_,
                    p_55984_);
        }
    }

    public boolean isValidBonemealTarget(
            @Nonnull BlockGetter p_55991_,
            @Nonnull BlockPos p_55992_,
            @Nonnull BlockState p_55993_,
            boolean p_55994_) {
        return true;
    }

    public boolean isBonemealSuccess(
            @Nonnull Level p_55996_,
            @Nonnull RandomSource p_55997_,
            @Nonnull BlockPos p_55998_,
            @Nonnull BlockState p_55999_) {
        return (double) p_55996_.random.nextFloat() < 0.45D;
    }

    public void performBonemeal(
            @Nonnull ServerLevel p_55986_,
            @Nonnull RandomSource p_55987_,
            @Nonnull BlockPos p_55988_,
            @Nonnull BlockState p_55989_) {
        this.advanceTree(p_55986_, p_55988_, p_55989_, p_55987_);
    }

    protected void createBlockStateDefinition(
            @Nonnull StateDefinition.Builder<Block, BlockState> p_56001_) {
        p_56001_.add(STAGE);
    }
}
