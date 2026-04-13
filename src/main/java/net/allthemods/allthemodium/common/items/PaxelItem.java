package net.allthemods.allthemodium.common.items;

import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import net.allthemods.allthemodium.core.mixin.AxeItemAccessor;

import org.jspecify.annotations.Nullable;

import java.util.Optional;

public class PaxelItem extends Item {
    
    public PaxelItem(Properties properties) {
        super(properties);
    }
    
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        
        Optional<BlockState> updated = PaxelItem.updateBlockState(level, pos, state, player, context);
        if (updated.isEmpty()) return InteractionResult.PASS;
        
        ItemStack stack = context.getItemInHand();
        if (player instanceof ServerPlayer serverPlayer) CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, pos, stack);
        
        level.setBlock(pos, updated.get(), Block.UPDATE_ALL_IMMEDIATE);
        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, updated.get()));
        if (player != null) stack.hurtAndBreak(1, player, context.getHand().asEquipmentSlot());
        return InteractionResult.SUCCESS;
    }
    
    private static Optional<BlockState> updateBlockState(Level level, BlockPos pos, BlockState state, @Nullable Player player, UseOnContext context) {
        Optional<BlockState> stripped = Optional.ofNullable(state.getToolModifiedState(context, ItemAbilities.AXE_STRIP, false));
        if (stripped.isPresent()) {
            level.playSound(player, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            return stripped;
        }
        
        Optional<BlockState> scraped = Optional.ofNullable(state.getToolModifiedState(context, ItemAbilities.AXE_SCRAPE, false));
        if (scraped.isPresent()) {
            AxeItemAccessor.spawnSoundAndParticle(level, pos, player, state, SoundEvents.AXE_SCRAPE, LevelEvent.PARTICLES_SCRAPE);
            return scraped;
        }
        
        Optional<BlockState> waxOff = Optional.ofNullable(state.getToolModifiedState(context, ItemAbilities.AXE_WAX_OFF, false));
        if (waxOff.isPresent()) {
            AxeItemAccessor.spawnSoundAndParticle(level, pos, player, state, SoundEvents.AXE_WAX_OFF, LevelEvent.PARTICLES_WAX_OFF);
            return waxOff;
        }
        
        Optional<BlockState> flattened = Optional.ofNullable(state.getToolModifiedState(context, ItemAbilities.SHOVEL_FLATTEN, false));
        if (flattened.isPresent()) {
            level.playSound(player, pos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
            return flattened;
        }
        
        Optional<BlockState> doused = Optional.ofNullable(state.getToolModifiedState(context, ItemAbilities.SHOVEL_DOUSE, false));
        if (doused.isPresent()) {
            level.levelEvent(player, LevelEvent.SOUND_EXTINGUISH_FIRE, pos, 0);
            return doused;
        }
        
        return Optional.empty();
    }
    
    @Override
    public boolean canPerformAction(ItemInstance stack, ItemAbility ability) {
        return ItemAbilities.DEFAULT_SHOVEL_ACTIONS.contains(ability) || ItemAbilities.DEFAULT_AXE_ACTIONS.contains(ability);
    }
}
