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
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;

import net.allthemods.allthemodium.core.registry.ATMBlocks;
import net.allthemods.allthemodium.core.registry.ATMItems;

import com.mojang.serialization.MapCodec;

public class AncientCaveVinesBodyBlock extends GrowingPlantBodyBlock implements AncientCaveVines {
    
    public static final MapCodec<AncientCaveVinesBodyBlock> CODEC = BlockBehaviour.simpleCodec(AncientCaveVinesBodyBlock::new);
    
    public AncientCaveVinesBodyBlock(Properties properties) {
        super(properties.noCollision()
                        .noOcclusion()
                        .lightLevel(AncientCaveVines.emission(14))
                        .instabreak()
                        .sound(SoundType.CAVE_VINES)
                , Direction.DOWN, AncientCaveVines.SHAPE, false);
        this.registerDefaultState(this.stateDefinition.any().setValue(AncientCaveVines.BERRIES, false));
    }
    
    @Override
    protected MapCodec<AncientCaveVinesBodyBlock> codec() {
        return AncientCaveVinesBodyBlock.CODEC;
    }
    
    @Override
    protected AncientCaveVinesHeadBlock getHeadBlock() {
        return ATMBlocks.ANCIENT_CAVE_VINES.get();
    }
    
    @Override
    protected BlockState updateHeadAfterConvertedFromBody(BlockState bodyState, BlockState headState) {
        return headState.setValue(AncientCaveVines.BERRIES, bodyState.getValue(AncientCaveVines.BERRIES));
    }
    
    @Override
    protected ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean includeData) {
        return new ItemStack(ATMItems.SOUL_BERRIES.get());
    }
    
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        return AncientCaveVines.use(player, state, level, pos);
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
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
