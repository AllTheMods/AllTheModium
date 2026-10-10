package net.allthemods.allthemodium.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.VegetationBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import net.allthemods.allthemodium.core.registry.ATMTags;

import com.mojang.serialization.MapCodec;

public class OtherHerbBlock extends VegetationBlock {
    
    private static final MapCodec<OtherHerbBlock> CODEC = BlockBehaviour.simpleCodec(OtherHerbBlock::new);
    private static final VoxelShape SHAPE = Block.column(12.0D, 0.0D, 13.0D);
    
    public OtherHerbBlock(Properties properties) {
        super(properties);
    }
    
    @Override
    public MapCodec<OtherHerbBlock> codec() {
        return OtherHerbBlock.CODEC;
    }
    
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return OtherHerbBlock.SHAPE;
    }
    
    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(ATMTags.Blocks.SUPPORTS_OTHER_VEGETATION)
                || state.is(BlockTags.NYLIUM)
                || state.is(Blocks.SOUL_SOIL)
                || super.mayPlaceOn(state, level, pos);
    }
}
