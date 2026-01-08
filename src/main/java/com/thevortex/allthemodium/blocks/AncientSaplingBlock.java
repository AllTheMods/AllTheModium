package com.thevortex.allthemodium.blocks;

import com.mojang.serialization.MapCodec;
import com.thevortex.allthemodium.AllTheModium;
import com.thevortex.allthemodium.registry.ModRegistry;
import com.thevortex.allthemodium.registry.TagRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.SpecialPlantable;
import org.jetbrains.annotations.Nullable;
public class AncientSaplingBlock extends SaplingBlock implements SpecialPlantable
{
    public static final IntegerProperty STAGE = BlockStateProperties.STAGE;
    protected static final float AABB_OFFSET = 6.0F;
    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
    private final TreeGrower treeGrower;

    public AncientSaplingBlock(TreeGrower p_55978_, BlockBehaviour.Properties p_55979_) {
        super(p_55978_,p_55979_);
        this.treeGrower = p_55978_;
        
        this.registerDefaultState(this.stateDefinition.any().setValue(STAGE, Integer.valueOf(0)));
    }

    @Override
    public MapCodec<? extends SaplingBlock> codec() {
      return CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState p_56008_, BlockGetter p_56009_, BlockPos p_56010_, CollisionContext p_56011_) {
        return SHAPE;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(TagRegistry.ANCIENT_DIRT) || state.is(Blocks.WARPED_NYLIUM) || state.is(Blocks.CRIMSON_NYLIUM) || state.is(ModRegistry.ANCIENT_GRASS.get()) || state.is(ModRegistry.ANCIENT_PODZOL.get());
    }

    @Override
    public VoxelShape getBlockSupportShape(BlockState p_60581_, BlockGetter p_60582_, BlockPos p_60583_) {
        return Shapes.empty();
    }

    public void randomTick(BlockState p_56003_, ServerLevel p_56004_, BlockPos p_56005_, RandomSource p_56006_) {
        if (p_56004_.getMaxLocalRawBrightness(p_56005_.above()) >= 9 && p_56006_.nextInt(7) == 0) {
            if (!p_56004_.isAreaLoaded(p_56005_, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
            this.advanceTree(p_56004_, p_56005_, p_56003_, p_56006_);
        }
    }

    public void advanceTree(ServerLevel p_55981_, BlockPos p_55982_, BlockState p_55983_, RandomSource p_55984_) {
        if (p_55983_.getValue(STAGE) == 0) {
            p_55981_.setBlock(p_55982_, p_55983_.cycle(STAGE), 4);
        } else {
                this.treeGrower.growTree(p_55981_, p_55981_.getChunkSource().getGenerator(), p_55982_, p_55983_, p_55984_);
        }
    }

    @Override
    public boolean isBonemealSuccess(Level p_55996_, RandomSource p_55997_, BlockPos p_55998_, BlockState p_55999_) {
        return (double)p_55996_.random.nextFloat() < 0.45D;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        this.advanceTree(level, pos, state, random);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }

    @Override
    public boolean canPlacePlantAtPosition(ItemStack arg0, LevelReader level, BlockPos pos, @Nullable Direction arg3) {
        return mayPlaceOn(level.getBlockState(pos), level, pos);
    }

    @Override
    public void spawnPlantAtPosition(ItemStack arg0, LevelAccessor arg1, BlockPos arg2, @Nullable Direction arg3) {

    }
}
