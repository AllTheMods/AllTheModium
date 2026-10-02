package net.allthemods.allthemodium.common.blocks;

import net.neoforged.neoforge.event.EventHooks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;

public final class OtherProtection {

    private OtherProtection() {
    }

    public static boolean canEntityDestroy(BlockPos pos, Entity entity, boolean allowedByDefault) {
        if (!(entity instanceof Player player && !player.isFakePlayer())) return false;
        return allowedByDefault && OtherProtection.distanceTo(pos, player.blockPosition()) < (player.blockInteractionRange() * 1.5F);
    }

    public static float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos, boolean canDestroy) {
        if (!canDestroy) return 0.0F;
        int i = EventHooks.doPlayerHarvestCheck(player, state, level, pos) ? 30 : 100;
        return player.getDestroySpeed(state, pos) / 2.0F / i;
    }

    private static double distanceTo(BlockPos target, BlockPos origin) {
        return Math.sqrt(
                Math.pow(origin.getX() - target.getX(), 2) +
                        Math.pow(origin.getY() - target.getY(), 2) +
                        Math.pow(origin.getZ() - target.getZ(), 2)
        );
    }
}
