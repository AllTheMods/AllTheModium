package net.allthemods.allthemodium.common.items;

import net.neoforged.fml.ModList;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import net.allthemods.allthemodium.compat.lootr.LootrCompat;
import net.allthemods.allthemodium.core.mixin.BrushableBlockEntityAccessor;

public class ModiumBrushItem extends BrushItem {

    private static final boolean LOOTR_LOADED = ModList.get().isLoaded("lootr");

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

    private void addBonusProgress(Level level, LivingEntity user, ItemStack stack, int ticksRemaining) {
        if (!(level instanceof ServerLevel serverLevel) || ticksRemaining < 0 || !(user instanceof Player player)) return;
        if ((this.getUseDuration(stack, user) - ticksRemaining + 1) % 10 != 5) return;

        HitResult hitResult = ProjectileUtil.getHitResultOnViewVector(player, EntitySelector.CAN_BE_PICKED, player.blockInteractionRange());
        if (!(hitResult instanceof BlockHitResult blockHitResult) || hitResult.getType() != HitResult.Type.BLOCK) return;

        BlockEntity blockEntity = level.getBlockEntity(blockHitResult.getBlockPos());
        if (blockEntity instanceof BrushableBlockEntity brushable) {
            BrushableBlockEntityAccessor accessor = (BrushableBlockEntityAccessor) brushable;
            if (serverLevel.getGameTime() < accessor.getCoolDownEndsAtTick()) return;

            accessor.setBrushCount(accessor.getBrushCount() + this.bonus);
        } else if (ModiumBrushItem.LOOTR_LOADED) {
            LootrCompat.addBrushBonus(blockEntity, this.bonus, serverLevel.getGameTime());
        }
    }
}
