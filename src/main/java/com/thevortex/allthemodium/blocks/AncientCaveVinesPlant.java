package com.thevortex.allthemodium.blocks;

import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class AncientCaveVinesPlant extends GrowingPlantBodyBlock implements BonemealableBlock, ACaveVines {
    public AncientCaveVinesPlant(Properties p_53886_, Direction p_53887_, VoxelShape p_53888_, boolean p_53889_) {
        super(p_53886_,Direction.DOWN, SHAPE, false);
    }

    @Override
    protected BlockState updateHeadAfterConvertedFromBody(BlockState p_153028_, BlockState p_153029_) {

        return p_153029_.setValue(BERRIES, p_153028_.getValue(BERRIES));
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter p_153007_, BlockPos p_153008_, BlockState p_153009_) {
        return new ItemStack(ModRegistry.ANCIENT_SOULBERRY.get());
    }

    @Override
    public InteractionResult use(BlockState p_153021_, Level p_153022_, BlockPos p_153023_, Player p_153024_, InteractionHand p_153025_, BlockHitResult p_153026_) {
        return ACaveVines.use(p_153021_, p_153022_, p_153023_);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_153031_) {
        p_153031_.add(BERRIES);
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter p_153011_, BlockPos p_153012_, BlockState p_153013_, boolean p_153014_) {
        return !p_153013_.getValue(BERRIES);
    }

    @Override
    public boolean isBonemealSuccess(Level p_153016_, Random p_153017_, BlockPos p_153018_, BlockState p_153019_) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel p_153002_, Random p_153003_, BlockPos p_153004_, BlockState p_153005_) {
        p_153002_.setBlock(p_153004_, p_153005_.setValue(BERRIES, Boolean.valueOf(true)), 2);
    }
    @Override
    protected GrowingPlantHeadBlock getHeadBlock() {
        return ModRegistry.ANCIENT_CAVEVINES;
    }
}
