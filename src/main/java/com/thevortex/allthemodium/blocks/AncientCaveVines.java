package com.thevortex.allthemodium.blocks;

import com.mojang.serialization.MapCodec;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CaveVinesBlock;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AncientCaveVines extends GrowingPlantHeadBlock implements ACaveVines
{
    private static final float CHANCE_OF_BERRIES_ON_GROWTH = 0.11F;

    public static final MapCodec<CaveVinesBlock> CODEC = simpleCodec(CaveVinesBlock::new);

    public AncientCaveVines(Properties p_53928_, Direction p_53929_, VoxelShape p_53930_, boolean p_53931_, double p_53932_) {
        super(p_53928_, Direction.DOWN, SHAPE, false, 0.1D);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(BERRIES, false));
    }

    @Override
    protected int getBlocksToGrowWhenBonemealed(RandomSource p_152995_) {
        return 1;
    }

    @Override
    protected boolean canGrowInto(BlockState p_152998_) {
        return p_152998_.isAir();
    }

    @Override
    protected BlockState updateBodyAfterConvertedFromHead(BlockState p_152987_, BlockState p_152988_) {
        return p_152988_.setValue(BERRIES, false);
    }

    @Override
    protected BlockState getGrowIntoState(BlockState p_152990_, RandomSource p_152991_) {
        return super.getGrowIntoState(p_152990_, p_152991_).setValue(BERRIES, Boolean.valueOf(p_152991_.nextFloat() < 0.11F));
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
        return new ItemStack(ModRegistry.ANCIENT_CAVEVINES.get());
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        return ACaveVines.use(state, level, pos);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
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
    protected GrowingPlantBodyBlock getBodyBlock() {
        return (GrowingPlantBodyBlock) ModRegistry.ANCIENT_CAVEVINES_PLANT.get();
    }

    @Override
    protected MapCodec<CaveVinesBlock> codec() {
        return CODEC;
    }
}
