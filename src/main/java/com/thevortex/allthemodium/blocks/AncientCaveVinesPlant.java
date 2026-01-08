package com.thevortex.allthemodium.blocks;

import com.mojang.serialization.MapCodec;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;


public class AncientCaveVinesPlant extends GrowingPlantBodyBlock implements BonemealableBlock, ACaveVines
{
    public static final MapCodec<CaveVinesPlantBlock> CODEC = simpleCodec(CaveVinesPlantBlock::new);

    public AncientCaveVinesPlant(Properties p_53886_, Direction p_53887_, VoxelShape p_53888_, boolean p_53889_) {
        super(p_53886_, Direction.DOWN, SHAPE, false);
        this.registerDefaultState(this.stateDefinition.any().setValue(BERRIES, false));
    }

    @Override
    protected BlockState updateHeadAfterConvertedFromBody(BlockState p_153028_, BlockState state) {
        return state.setValue(BERRIES, false);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BERRIES);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return !state.getValue(BERRIES);
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState sate) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState sate) {
        level.setBlock(pos, sate.setValue(BERRIES, true), 2);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        return ACaveVines.use(state, level, pos);
    }

    @Override
    protected GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock) ModRegistry.ANCIENT_CAVEVINES.get();
    }

    @Override
    protected MapCodec<CaveVinesPlantBlock> codec() {
        return CODEC;
    }
}
