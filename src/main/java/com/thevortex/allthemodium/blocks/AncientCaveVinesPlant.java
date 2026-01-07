package com.thevortex.allthemodium.blocks;

import com.mojang.serialization.MapCodec;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.VoxelShape;


public class AncientCaveVinesPlant extends GrowingPlantBodyBlock implements BonemealableBlock, ACaveVines {
    
   public static final MapCodec<CaveVinesPlantBlock> CODEC = simpleCodec(CaveVinesPlantBlock::new);

    public AncientCaveVinesPlant(Properties p_53886_, Direction p_53887_, VoxelShape p_53888_, boolean p_53889_) {
        super(p_53886_,Direction.DOWN, SHAPE, false);
    }

    @Override
    protected BlockState updateHeadAfterConvertedFromBody(BlockState p_153028_, BlockState p_153029_) {

        return p_153029_.setValue(BERRIES, Boolean.FALSE);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_153031_) {
        p_153031_.add(BERRIES);
    }

    @Override
    public boolean isBonemealSuccess(Level p_153016_, RandomSource p_153017_, BlockPos p_153018_, BlockState p_153019_) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel p_153002_, RandomSource p_153003_, BlockPos p_153004_, BlockState p_153005_) {
        p_153002_.setBlock(p_153004_, p_153005_.setValue(BERRIES, Boolean.valueOf(true)), 2);
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
