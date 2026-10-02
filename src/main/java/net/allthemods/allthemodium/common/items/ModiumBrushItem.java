package net.allthemods.allthemodium.common.items;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import net.allthemods.allthemodium.core.mixin.BrushableBlockEntityAccessor;

public class ModiumBrushItem extends BrushItem {

    private final int bonus;

    public ModiumBrushItem(Properties properties, int bonus) {
        super(properties);
        this.bonus = bonus;
    }

    @Override
    public void onUseTick(Level level, LivingEntity user, ItemStack stack, int ticksRemaining) {
        this.addBonusProgress(level, user, stack, ticksRemaining);
        super.onUseTick(level, user, stack, ticksRemaining);
    }

    /**
     * Adds {@link #bonus} to the block entity's brush counter on the ticks where {@link BrushItem#onUseTick} is about
     * to call {@link BrushableBlockEntity#brush}, so the ten brushes a block needs are reached in fewer passes. The
     * conditions mirror the ones the superclass checks, including the block entity's own ten-tick cooldown, so a pass
     * the superclass skips does not count either.
     */
    private void addBonusProgress(Level level, LivingEntity user, ItemStack stack, int ticksRemaining) {
        if (!(level instanceof ServerLevel serverLevel) || ticksRemaining < 0 || !(user instanceof Player player)) return;
        if ((this.getUseDuration(stack, user) - ticksRemaining + 1) % 10 != 5) return;

        HitResult hitResult = ProjectileUtil.getHitResultOnViewVector(player, EntitySelector.CAN_BE_PICKED, player.blockInteractionRange());
        if (!(hitResult instanceof BlockHitResult blockHitResult) || hitResult.getType() != HitResult.Type.BLOCK) return;
        if (!(level.getBlockEntity(blockHitResult.getBlockPos()) instanceof BrushableBlockEntity brushable)) return;

        BrushableBlockEntityAccessor accessor = (BrushableBlockEntityAccessor) brushable;
        if (serverLevel.getGameTime() < accessor.getCoolDownEndsAtTick()) return;

        accessor.setBrushCount(accessor.getBrushCount() + this.bonus);
    }
}
