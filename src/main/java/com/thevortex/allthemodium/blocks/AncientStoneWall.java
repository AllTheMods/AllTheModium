package com.thevortex.allthemodium.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;

/**
 * A wall copied from an {@link AncientStone} base. It inherits that base's -1 hardness, so it needs the same breaking
 * rules to be breakable at all.
 */
public class AncientStoneWall extends WallBlock {

    public AncientStoneWall(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canEntityDestroy(BlockState state, BlockGetter level, BlockPos pos, Entity entity) {
        return super.canEntityDestroy(state, level, pos, entity) && AncientStone.canBreak(pos, entity);
    }

    @Override
    protected float getDestroyProgress(BlockState state, Player player, BlockGetter getter, BlockPos pos) {
        return this.canEntityDestroy(state, getter, pos, player) ? AncientStone.destroyProgress(state, player, pos) : 0.0F;
    }
}
