package com.thevortex.allthemodium.items;

import com.thevortex.allthemodium.AllTheModium;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BrushableBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class Brush extends BrushItem
{
    private final int modifier;

    public Brush(Properties properties, int modifier) {
        super(properties);
        this.modifier = modifier;
    }

    public void onUseTick(Level level, LivingEntity livingEntity, ItemStack stack, int remainingUseDuration) {
        if (remainingUseDuration >= 0 && livingEntity instanceof Player player) {
            HitResult hitresult = this.calculateHitResult(player);
            if (hitresult instanceof BlockHitResult blockhitresult) {
                if (hitresult.getType() == HitResult.Type.BLOCK) {
                    int i = this.getUseDuration(stack, livingEntity) - remainingUseDuration + 1;
                    boolean flag = i % 10 == 5;
                    if (flag) {
                        BlockPos blockpos = blockhitresult.getBlockPos();
                        BlockState blockstate = level.getBlockState(blockpos);
                        HumanoidArm humanoidarm = livingEntity.getUsedItemHand() == InteractionHand.MAIN_HAND ? player.getMainArm() : player.getMainArm().getOpposite();
                        if (blockstate.shouldSpawnTerrainParticles() && blockstate.getRenderShape() != RenderShape.INVISIBLE) {
                            this.spawnDustParticles(level, blockhitresult, blockstate, livingEntity.getViewVector(0.0F), humanoidarm);
                        }

                        SoundEvent soundevent;
                        if (blockstate.getBlock() instanceof BrushableBlock brushableblock) {
                            soundevent = brushableblock.getBrushSound();
                        } else {
                            soundevent = SoundEvents.BRUSH_GENERIC;
                        }

                        level.playSound(player, blockpos, soundevent, SoundSource.BLOCKS);
                        if (!level.isClientSide()) {
                            BlockEntity blockEntity = level.getBlockEntity(blockpos);
                            if (blockEntity instanceof BrushableBlockEntity brushableblockentity) {
                                brushableblockentity.brushCount += this.modifier;
                                brushableblockentity.brush(level.getGameTime(), player, blockhitresult.getDirection());
                            }
                        }
                    }

                    return;
                }
            }

            livingEntity.releaseUsingItem();
        } else {
            livingEntity.releaseUsingItem();
        }
    }
}
