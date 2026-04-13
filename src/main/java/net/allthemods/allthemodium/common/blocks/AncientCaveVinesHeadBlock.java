package net.allthemods.allthemodium.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;

import net.allthemods.allthemodium.core.registry.ATMBlocks;
import net.allthemods.allthemodium.core.registry.ATMItems;

import com.mojang.serialization.MapCodec;

public class AncientCaveVinesHeadBlock extends GrowingPlantHeadBlock implements AncientCaveVines {
    
    private static final double GROWTH_PER_TICK_PROBABILITY = 0.1D;
    private static final float CHANCE_OF_BERRIES_ON_GROWTH = 0.11F;
    
    public static final MapCodec<AncientCaveVinesHeadBlock> CODEC = BlockBehaviour.simpleCodec(AncientCaveVinesHeadBlock::new);
    
    public AncientCaveVinesHeadBlock(Properties properties) {
        super(properties.randomTicks()
                        .noCollision()
                        .noOcclusion()
                        .lightLevel(AncientCaveVines.emission(14))
                        .instabreak()
                        .sound(SoundType.CAVE_VINES),
                Direction.DOWN, AncientCaveVines.SHAPE, false, AncientCaveVinesHeadBlock.GROWTH_PER_TICK_PROBABILITY);
        this.registerDefaultState(this.defaultBlockState().setValue(GrowingPlantHeadBlock.AGE, 0).setValue(AncientCaveVines.BERRIES, false));
    }
    
    @Override
    protected MapCodec<AncientCaveVinesHeadBlock> codec() {
        return AncientCaveVinesHeadBlock.CODEC;
    }
    
    @Override
    protected int getBlocksToGrowWhenBonemealed(RandomSource random) {
        return 1;
    }
    
    @Override
    protected boolean canGrowInto(BlockState state) {
        return state.isAir();
    }
    
    @Override
    protected AncientCaveVinesBodyBlock getBodyBlock() {
        return ATMBlocks.ANCIENT_CAVE_VINES_PLANT.get();
    }
    
    @Override
    protected BlockState updateBodyAfterConvertedFromHead(BlockState headState, BlockState bodyState) {
        return bodyState.setValue(AncientCaveVines.BERRIES, headState.getValue(AncientCaveVines.BERRIES));
    }
    
    @Override
    protected BlockState getGrowIntoState(BlockState growFromState, RandomSource random) {
        return super.getGrowIntoState(growFromState, random).setValue(AncientCaveVines.BERRIES, random.nextFloat() < AncientCaveVinesHeadBlock.CHANCE_OF_BERRIES_ON_GROWTH);
    }
    
    @Override
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean includeData, Player player) {
        return new ItemStack(ATMItems.SOUL_BERRIES.get());
    }
    
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        return AncientCaveVines.use(player, state, level, pos);
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(AncientCaveVines.BERRIES);
    }
    
    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return !state.getValue(AncientCaveVines.BERRIES);
    }
    
    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        level.setBlock(pos, state.setValue(AncientCaveVines.BERRIES, true), Block.UPDATE_CLIENTS);
    }
}
