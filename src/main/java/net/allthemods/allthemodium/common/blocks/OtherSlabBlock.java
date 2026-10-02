package net.allthemods.allthemodium.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;

public class OtherSlabBlock extends SlabBlock {
    
    public OtherSlabBlock(Properties properties) {
        super(properties);
    }
    
    @Override
    public boolean canEntityDestroy(BlockState state, BlockGetter level, BlockPos pos, Entity entity) {
        return OtherProtection.canEntityDestroy(pos, entity, super.canEntityDestroy(state, level, pos, entity));
    }
    
    @Override
    protected float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
        return OtherProtection.getDestroyProgress(state, player, level, pos, this.canEntityDestroy(state, level, pos, player));
    }
}
