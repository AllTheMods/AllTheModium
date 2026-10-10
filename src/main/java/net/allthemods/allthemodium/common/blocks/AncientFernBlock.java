package net.allthemods.allthemodium.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.VegetationBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import com.mojang.serialization.MapCodec;

public class AncientFernBlock extends VegetationBlock {
    
    private static final MapCodec<AncientFernBlock> CODEC = BlockBehaviour.simpleCodec(AncientFernBlock::new);
    private static final VoxelShape SHAPE = Block.column(12.0D, 0.0D, 13.0D);
    
    public AncientFernBlock(Properties properties) {
        super(properties);
    }
    
    @Override
    public MapCodec<AncientFernBlock> codec() {
        return AncientFernBlock.CODEC;
    }
    
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return AncientFernBlock.SHAPE;
    }
}
