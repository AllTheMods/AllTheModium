package com.thevortex.allthemodium.blocks;

import com.thevortex.allthemodium.registry.ModRegistry;
import javax.annotation.Nonnull;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;

public class AncientGrass extends GrassBlock {

    public AncientGrass(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public boolean canSustainPlant(
            BlockState state,
            BlockGetter world,
            BlockPos pos,
            Direction facing,
            IPlantable plantable) {
        return true;
    }

    @Override
    public void randomTick(
            @Nonnull BlockState state,
            @Nonnull ServerLevel level,
            @Nonnull BlockPos pos,
            @Nonnull RandomSource random) {
        if (!level.getBlockState(pos.above()).isAir()) {
            level.setBlock(
                    pos,
                    ModRegistry.ANCIENT_DIRT.get().defaultBlockState(),
                    1);
        }
    }
}
