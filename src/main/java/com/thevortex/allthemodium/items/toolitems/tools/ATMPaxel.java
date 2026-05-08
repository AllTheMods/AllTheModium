package com.thevortex.allthemodium.items.toolitems.tools;

import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Maps;
import com.thevortex.allthemodium.registry.TagRegistry;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.ItemAbilities;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Optional;

public class ATMPaxel extends DiggerItem {
    @SuppressWarnings("unchecked")
    protected static final Map<Block, BlockState> FLATTENABLES = Maps.newHashMap(
        new Builder()
            .put(Blocks.GRASS_BLOCK, Blocks.DIRT_PATH.defaultBlockState())
            .put(Blocks.DIRT, Blocks.DIRT_PATH.defaultBlockState())
            .put(Blocks.PODZOL, Blocks.DIRT_PATH.defaultBlockState())
            .put(Blocks.COARSE_DIRT, Blocks.DIRT_PATH.defaultBlockState())
            .put(Blocks.MYCELIUM, Blocks.DIRT_PATH.defaultBlockState())
            .put(Blocks.ROOTED_DIRT, Blocks.DIRT_PATH.defaultBlockState())
            .build()
    );
    public ATMPaxel(Tier p_204110_, TagKey<Block> p_204111_, Properties p_204112_) {
        super(p_204110_, TagRegistry.PAXEL_TARGETS, p_204112_);
        
        }

 @Override
    public InteractionResult useOn(UseOnContext p_40529_) {
        Level level = p_40529_.getLevel();
        BlockPos blockpos = p_40529_.getClickedPos();
        Player player = p_40529_.getPlayer();
        if (playerHasShieldUseIntent(p_40529_)) {
            return InteractionResult.PASS;
        } else {
            Optional<BlockState> optional = this.evaluateNewBlockState(level, blockpos, player, level.getBlockState(blockpos), p_40529_);
            if (optional.isEmpty()) {
                return InteractionResult.PASS;
            } else {
                ItemStack itemstack = p_40529_.getItemInHand();
                if (player instanceof ServerPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockpos, itemstack);
                }

                level.setBlock(blockpos, optional.get(), 11);
                level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, optional.get()));
                if (player != null) {
                    itemstack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(p_40529_.getHand()));
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
    }

    private static boolean playerHasShieldUseIntent(UseOnContext p_345141_) {
        Player player = p_345141_.getPlayer();
        return p_345141_.getHand().equals(InteractionHand.MAIN_HAND) && player.getOffhandItem().is(Items.SHIELD) && !player.isSecondaryUseActive();
    }

    private Optional<BlockState> evaluateNewBlockState(Level level, BlockPos pos, @Nullable Player player, BlockState state, UseOnContext context) {
            Optional<BlockState> optional = Optional.ofNullable(state.getToolModifiedState(context,ItemAbilities.AXE_STRIP, false));
            if(optional.isPresent()) {
                level.playSound(player, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
                return optional;
            } else {
                Optional<BlockState> optional1 = Optional.ofNullable(state.getToolModifiedState(context,ItemAbilities.AXE_SCRAPE, false));
                if(optional1.isPresent()) {
                    level.playSound(player, pos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    return optional1;
                } else {
                    Optional<BlockState> optional2 = Optional.ofNullable(state.getToolModifiedState(context,ItemAbilities.AXE_WAX_OFF, false));
                    if(optional2.isPresent()) {
                        level.playSound(player, pos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
                        return optional2;
                    }   else {
                            Optional<BlockState> optional3 = Optional.ofNullable(FLATTENABLES.get(state.getBlock()));
                            if(optional3.isPresent()) {
                                level.playSound(player, pos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                                return optional3;
                            } else {
                                Optional<BlockState> optional4 = Optional.ofNullable(state.getToolModifiedState(context,ItemAbilities.SHOVEL_DOUSE, false));
                                if(optional4.isPresent()) {
                                    level.playSound(player, pos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 1.0F, 1.0F);
                                    return optional4;
                                } else {
                                }
                            }
                        }
                    }
                }
        return Optional.empty();            
    }

    @Nullable
    public static BlockState getAxeStrippingState(BlockState originalState) {
        Block block = AxeItem.STRIPPABLES.get(originalState.getBlock());
        return block != null ? block.defaultBlockState().setValue(RotatedPillarBlock.AXIS, originalState.getValue(RotatedPillarBlock.AXIS)) : null;
    }

    private Optional<BlockState> getStripped(BlockState p_150691_) {
        return Optional.ofNullable(AxeItem.STRIPPABLES.get(p_150691_.getBlock()))
            .map(p_150689_ -> p_150689_.defaultBlockState().setValue(RotatedPillarBlock.AXIS, p_150691_.getValue(RotatedPillarBlock.AXIS)));
    }

    @Override
    public boolean canPerformAction(ItemStack stack, net.neoforged.neoforge.common.ItemAbility itemAbility) {
        return net.neoforged.neoforge.common.ItemAbilities.DEFAULT_AXE_ACTIONS.contains(itemAbility);
    }
    @org.jetbrains.annotations.Nullable
    public static BlockState getShovelPathingState(BlockState originalState) {
        return FLATTENABLES.get(originalState.getBlock());
    }
}

    
