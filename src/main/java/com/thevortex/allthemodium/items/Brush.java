package com.thevortex.allthemodium.items;

import com.thevortex.allthemodium.compat.lootr.LootrCompat;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.neoforged.fml.ModList;

/**
 * A brush that adds {@code modifier} to a block's brushing progress on every brush stroke, on top of the stroke itself.
 * The stroke is vanilla's {@link BrushItem#onUseTick}, so blocks that other mods make brushable through it — Lootr's
 * among them — can be brushed too.
 */
public class Brush extends BrushItem
{
    private static final boolean LOOTR_LOADED = ModList.get().isLoaded("lootr");

    private final int modifier;

    public Brush(Properties properties, int modifier) {
        super(properties);
        this.modifier = modifier;
    }

    @Override
    public void onUseTick(Level level, LivingEntity livingEntity, ItemStack stack, int remainingUseDuration) {
        if (!level.isClientSide() && remainingUseDuration >= 0 && livingEntity instanceof Player player
                && (this.getUseDuration(stack, livingEntity) - remainingUseDuration + 1) % 10 == 5
                && this.calculateHitResult(player) instanceof BlockHitResult hit && hit.getType() == HitResult.Type.BLOCK) {
            BlockEntity blockEntity = level.getBlockEntity(hit.getBlockPos());
            if (blockEntity instanceof BrushableBlockEntity brushable) {
                brushable.brushCount += this.modifier;
            } else if (LOOTR_LOADED) {
                LootrCompat.addBrushBonus(blockEntity, this.modifier, level.getGameTime());
            }
        }
        super.onUseTick(level, livingEntity, stack, remainingUseDuration);
    }
}
