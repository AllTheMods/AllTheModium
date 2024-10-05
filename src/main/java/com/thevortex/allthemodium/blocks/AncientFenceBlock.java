package com.thevortex.allthemodium.blocks;

import javax.annotation.Nonnull;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.LeadItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AncientFenceBlock extends FenceBlock {

    private final VoxelShape[] occlusionByIndex;

    public AncientFenceBlock(Properties props) {
        super(props);
        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(NORTH, Boolean.valueOf(false))
                        .setValue(EAST, Boolean.valueOf(false))
                        .setValue(SOUTH, Boolean.valueOf(false))
                        .setValue(WEST, Boolean.valueOf(false))
                        .setValue(WATERLOGGED, Boolean.valueOf(false)));
        this.occlusionByIndex = this.makeShapes(2.0F, 1.0F, 16.0F, 6.0F, 15.0F);
    }

    public VoxelShape getOcclusionShape(
            @Nonnull BlockState p_53338_,
            @Nonnull BlockGetter p_53339_,
            @Nonnull BlockPos p_53340_) {
        return this.occlusionByIndex[this.getAABBIndex(p_53338_)];
    }

    public VoxelShape getVisualShape(
            @Nonnull BlockState p_53311_,
            @Nonnull BlockGetter p_53312_,
            @Nonnull BlockPos p_53313_,
            @Nonnull CollisionContext p_53314_) {
        return this.getShape(p_53311_, p_53312_, p_53313_, p_53314_);
    }

    public boolean isPathfindable(
            @Nonnull BlockState p_53306_,
            @Nonnull BlockGetter p_53307_,
            @Nonnull BlockPos p_53308_,
            @Nonnull PathComputationType p_53309_) {
        return false;
    }

    public boolean connectsTo(
            @Nonnull BlockState p_53330_,
            boolean p_53331_,
            @Nonnull Direction p_53332_) {
        Block block = p_53330_.getBlock();
        boolean flag = this.isSameFence(p_53330_);
        boolean flag1 = block instanceof FenceGateBlock &&
                FenceGateBlock.connectsToDirection(p_53330_, p_53332_);
        return ((!isExceptionForConnection(p_53330_) && p_53331_) || flag || flag1);
    }

    private boolean isSameFence(BlockState p_153255_) {
        return (p_153255_.is(BlockTags.FENCES) &&
                p_153255_.is(BlockTags.WOODEN_FENCES) == this.defaultBlockState().is(BlockTags.WOODEN_FENCES));
    }

    public InteractionResult use(
            @Nonnull BlockState p_53316_,
            @Nonnull Level p_53317_,
            @Nonnull BlockPos p_53318_,
            @Nonnull Player p_53319_,
            @Nonnull InteractionHand p_53320_,
            @Nonnull BlockHitResult p_53321_) {
        if (p_53317_.isClientSide) {
            ItemStack itemStack = p_53319_.getItemInHand(p_53320_);
            return itemStack.is(Items.LEAD)
                    ? InteractionResult.SUCCESS
                    : InteractionResult.PASS;
        } else {
            return LeadItem.bindPlayerMobs(p_53319_, p_53317_, p_53318_);
        }
    }

    public BlockState getStateForPlacement(
            @Nonnull BlockPlaceContext p_53304_) {
        BlockGetter blockGetter = p_53304_.getLevel();
        BlockPos blockPos = p_53304_.getClickedPos();
        FluidState fluidState = p_53304_
                .getLevel()
                .getFluidState(p_53304_.getClickedPos());
        BlockPos blockPos1 = blockPos.north();
        BlockPos blockPos2 = blockPos.east();
        BlockPos blockPos3 = blockPos.south();
        BlockPos blockPos4 = blockPos.west();
        BlockState blockState = blockGetter.getBlockState(blockPos1);
        BlockState blockState1 = blockGetter.getBlockState(blockPos2);
        BlockState blockState2 = blockGetter.getBlockState(blockPos3);
        BlockState blockState3 = blockGetter.getBlockState(blockPos4);
        return super.getStateForPlacement(p_53304_)
                .setValue(
                        NORTH,
                        Boolean.valueOf(
                                this.connectsTo(
                                        blockState,
                                        blockState.isFaceSturdy(
                                                blockGetter,
                                                blockPos1,
                                                Direction.SOUTH),
                                        Direction.SOUTH)))
                .setValue(
                        EAST,
                        Boolean.valueOf(
                                this.connectsTo(
                                        blockState1,
                                        blockState1.isFaceSturdy(
                                                blockGetter,
                                                blockPos2,
                                                Direction.WEST),
                                        Direction.WEST)))
                .setValue(
                        SOUTH,
                        Boolean.valueOf(
                                this.connectsTo(
                                        blockState2,
                                        blockState2.isFaceSturdy(
                                                blockGetter,
                                                blockPos3,
                                                Direction.NORTH),
                                        Direction.NORTH)))
                .setValue(
                        WEST,
                        Boolean.valueOf(
                                this.connectsTo(
                                        blockState3,
                                        blockState3.isFaceSturdy(
                                                blockGetter,
                                                blockPos4,
                                                Direction.EAST),
                                        Direction.EAST)))
                .setValue(
                        WATERLOGGED,
                        Boolean.valueOf(fluidState.getType() == Fluids.WATER));
    }

    public BlockState updateShape(
            @Nonnull BlockState p_53323_,
            @Nonnull Direction p_53324_,
            @Nonnull BlockState p_53325_,
            @Nonnull LevelAccessor p_53326_,
            @Nonnull BlockPos p_53327_,
            @Nonnull BlockPos p_53328_) {
        if (p_53323_.getValue(WATERLOGGED)) {
            p_53326_.scheduleTick(
                    p_53327_,
                    Fluids.WATER,
                    Fluids.WATER.getTickDelay(p_53326_));
        }

        return p_53324_.getAxis().getPlane() == Direction.Plane.HORIZONTAL
                ? p_53323_.setValue(
                        PROPERTY_BY_DIRECTION.get(p_53324_),
                        Boolean.valueOf(
                                this.connectsTo(
                                        p_53325_,
                                        p_53325_.isFaceSturdy(
                                                p_53326_,
                                                p_53328_,
                                                p_53324_.getOpposite()),
                                        p_53324_.getOpposite())))
                : super.updateShape(
                        p_53323_,
                        p_53324_,
                        p_53325_,
                        p_53326_,
                        p_53327_,
                        p_53328_);
    }

    protected void createBlockStateDefinition(
            @Nonnull StateDefinition.Builder<Block, BlockState> p_53334_) {
        p_53334_.add(NORTH, EAST, WEST, SOUTH, WATERLOGGED);
    }
}
