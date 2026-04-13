package net.allthemods.allthemodium.common.blocks;

import net.neoforged.neoforge.event.EventHooks;

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
        if (!(entity instanceof Player player && !player.isFakePlayer())) return false;
        return super.canEntityDestroy(state, level, pos, entity) && ModiumOreBlock.distanceTo(pos, player.blockPosition()) < (player.blockInteractionRange() * 1.5F);
    }
    
    @Override
    protected float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
        if (this.canEntityDestroy(state, level, pos, player)) {
            int i = EventHooks.doPlayerHarvestCheck(player, state, level, pos) ? 30 : 100;
            return player.getDestroySpeed(state, pos) / 2.0F / i;
        }
        return 0.0F;
    }
    
    @Override
    public int getExpDrop(BlockState state, LevelAccessor level, BlockPos pos, @Nullable BlockEntity blockEntity, @Nullable Entity breaker, ItemStack stack) {
        return this.xp.sample(level.getRandom());
    }
    
    private static double distanceTo(BlockPos target, BlockPos origin) {
        return Math.sqrt(
                Math.pow(origin.getX() - target.getX(), 2) +
                        Math.pow(origin.getY() - target.getY(), 2) +
                        Math.pow(origin.getZ() - target.getZ(), 2)
        );
    }
}
