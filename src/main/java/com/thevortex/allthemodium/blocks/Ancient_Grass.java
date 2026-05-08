package com.thevortex.allthemodium.blocks;

import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.SpecialPlantable;
import org.jetbrains.annotations.Nullable;

public class Ancient_Grass extends GrassBlock implements SpecialPlantable {
    public Ancient_Grass(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if(!level.getBlockState(pos.above()).isAir()) {
            level.setBlock(pos, ModRegistry.ANCIENT_DIRT.get().defaultBlockState(),1 );
        }
    }

    @Override
    public boolean canPlacePlantAtPosition(ItemStack arg0, LevelReader arg1, BlockPos arg2, @Nullable Direction arg3) {
        return true;
    }

    @Override
    public void spawnPlantAtPosition(ItemStack arg0, LevelAccessor arg1, BlockPos arg2, @Nullable Direction arg3) {
    }


}
