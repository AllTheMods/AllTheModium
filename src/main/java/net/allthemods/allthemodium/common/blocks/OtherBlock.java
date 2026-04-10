package net.allthemods.allthemodium.common.blocks;

import net.neoforged.neoforge.event.EventHooks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;

public class OtherBlock extends Block {
    
    public OtherBlock(Properties properties) {
        super(properties.requiresCorrectToolForDrops()
                .isRedstoneConductor((_, _, _) -> false)
                .sound(SoundType.ANCIENT_DEBRIS)
                .strength(-1.0f, 1500.0f)
        );
    }
    
    @Override
    public boolean canEntityDestroy(BlockState state, BlockGetter level, BlockPos pos, Entity entity) {
        if (!(entity instanceof ServerPlayer player && !player.isFakePlayer())) return false;
        return super.canEntityDestroy(state, level, pos, entity) && OtherBlock.distanceTo(pos, player.blockPosition()) < (player.blockInteractionRange() * 1.5F);
    }
    
    @Override
    protected float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
        if (this.canEntityDestroy(state, level, pos, player)) {
            int i = EventHooks.doPlayerHarvestCheck(player, state, level, pos) ? 30 : 100;
            return player.getDestroySpeed(state, pos) / 2.0F / i;
        }
        return 0.0F;
    }
    
    private static double distanceTo(BlockPos target, BlockPos origin) {
        return Math.sqrt(
                Math.pow(origin.getX() - target.getX(), 2) +
                        Math.pow(origin.getY() - target.getY(), 2) +
                        Math.pow(origin.getZ() - target.getZ(), 2)
        );
    }
}
