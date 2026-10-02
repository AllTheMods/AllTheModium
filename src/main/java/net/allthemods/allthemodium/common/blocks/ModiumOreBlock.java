package net.allthemods.allthemodium.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.RedStoneOreBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class ModiumOreBlock extends RedStoneOreBlock {
    
    private final UniformInt xp;
    
    public ModiumOreBlock(UniformInt xp, Properties properties) {
        super(properties.requiresCorrectToolForDrops().lightLevel(_ -> 15));
        this.xp = xp;
    }
    
    @Override
    public boolean canEntityDestroy(BlockState state, BlockGetter level, BlockPos pos, Entity entity) {
        return OtherProtection.canEntityDestroy(pos, entity, super.canEntityDestroy(state, level, pos, entity));
    }
    
    @Override
    protected float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
        return OtherProtection.getDestroyProgress(state, player, level, pos, this.canEntityDestroy(state, level, pos, player));
    }
    
    @Override
    public int getExpDrop(BlockState state, LevelAccessor level, BlockPos pos, @Nullable BlockEntity blockEntity, @Nullable Entity breaker, ItemStack stack) {
        return this.xp.sample(level.getRandom());
    }
}
