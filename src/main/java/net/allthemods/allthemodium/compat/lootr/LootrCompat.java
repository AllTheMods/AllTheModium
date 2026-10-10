package net.allthemods.allthemodium.compat.lootr;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.compat.lootr.mixin.LootrBrushableBlockEntityAccessor;
import net.allthemods.allthemodium.core.registry.ATMBlocks;

import noobanidus.mods.lootr.common.api.LootrAPI;
import noobanidus.mods.lootr.common.api.interfaces.type.ILootrType;
import noobanidus.mods.lootr.common.block.LootrBrushableBlock;

import java.util.Optional;

public class LootrCompat {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, ATM.MOD_ID);

    public static final DeferredHolder<Block, LootrBrushableBlock> SUSPICIOUS_CLAY = LootrCompat.register("lootr_suspicious_clay", Blocks.CLAY);
    public static final DeferredHolder<Block, LootrBrushableBlock> SUSPICIOUS_SOUL_SAND = LootrCompat.register("lootr_suspicious_soul_sand", Blocks.SOUL_SAND);

    public static final String CLAY_TYPE = ATM.id("clay").toString();
    public static final String SOUL_SAND_TYPE = ATM.id("soul_sand").toString();

    private static final ResourceKey<BlockEntityType<?>> BRUSHABLE_BLOCK_ENTITY = ResourceKey.create(Registries.BLOCK_ENTITY_TYPE, Identifier.fromNamespaceAndPath("lootr", "brushable_block"));

    public static void register(IEventBus bus) {
        LootrCompat.BLOCKS.register(bus);
        bus.addListener(LootrCompat::addBrushableBlocks);
    }

    private static DeferredHolder<Block, LootrBrushableBlock> register(String name, Block turnsInto) {
        return LootrCompat.BLOCKS.register(name, k -> new LootrBrushableBlock(turnsInto, SoundEvents.BRUSH_SAND, SoundEvents.BRUSH_SAND_COMPLETED,
                ATMBlocks.suspicious(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, k)))));
    }

    private static void addBrushableBlocks(BlockEntityTypeAddBlocksEvent event) {
        event.modify(LootrCompat.BRUSHABLE_BLOCK_ENTITY, LootrCompat.SUSPICIOUS_CLAY.get(), LootrCompat.SUSPICIOUS_SOUL_SAND.get());
    }

    public static Optional<ILootrType> lootrType(BlockState state) {
        if (state.is(LootrCompat.SUSPICIOUS_CLAY.get())) return Optional.ofNullable(LootrAPI.getType(LootrCompat.CLAY_TYPE));
        if (state.is(LootrCompat.SUSPICIOUS_SOUL_SAND.get())) return Optional.ofNullable(LootrAPI.getType(LootrCompat.SOUL_SAND_TYPE));
        return Optional.empty();
    }

    public static void addBrushBonus(BlockEntity blockEntity, int bonus, long gameTime) {
        if (blockEntity instanceof LootrBrushableBlockEntityAccessor accessor && gameTime >= accessor.allthemodium$getCoolDownEndsAtTick()) {
            accessor.allthemodium$setBrushCount(accessor.allthemodium$getBrushCount() + bonus);
        }
    }
}
