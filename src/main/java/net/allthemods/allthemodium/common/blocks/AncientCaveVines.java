package net.allthemods.allthemodium.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.shapes.VoxelShape;

import net.allthemods.allthemodium.core.registry.ATMItems;

import java.util.function.ToIntFunction;

public interface AncientCaveVines {
    
    VoxelShape SHAPE = Block.column(14.0F, 0.0F, 16.0F);
    BooleanProperty BERRIES = BlockStateProperties.BERRIES;
    
    static InteractionResult use(Entity sourceEntity, BlockState state, Level level, BlockPos pos) {
        if (!state.getValue(AncientCaveVines.BERRIES)) return InteractionResult.PASS;
        if (!(level instanceof ServerLevel)) return InteractionResult.SUCCESS;
        
        Block.popResource(level, pos, new ItemStack(ATMItems.SOUL_BERRIES.get()));
        float pitch = Mth.randomBetween(level.getRandom(), 0.8F, 1.2F);
        level.playSound(null, pos, SoundEvents.CAVE_VINES_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, pitch);
        BlockState newState = state.setValue(AncientCaveVines.BERRIES, false);
        level.setBlock(pos, newState, 2);
        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(sourceEntity, newState));
        return InteractionResult.SUCCESS;
    }
    
    
    static boolean hasGlowBerries(BlockState state) {
        return state.hasProperty(AncientCaveVines.BERRIES) && state.getValue(AncientCaveVines.BERRIES);
    }
    
    static ToIntFunction<BlockState> emission(int light) {
        return state -> state.getValue(BlockStateProperties.BERRIES) ? light : 0;
    }
}
