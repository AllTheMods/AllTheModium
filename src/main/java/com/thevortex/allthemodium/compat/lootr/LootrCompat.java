package com.thevortex.allthemodium.compat.lootr;

import com.thevortex.allthemodium.compat.lootr.mixin.LootrBrushableBlockEntityAccessor;
import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import noobanidus.mods.lootr.common.api.ILootrType;
import noobanidus.mods.lootr.common.api.LootrAPI;
import noobanidus.mods.lootr.common.block.LootrBrushableBlock;

import java.util.Optional;

/**
 * Lootr variants of the ATM suspicious blocks, so their loot is per player like vanilla's suspicious sand and gravel.
 * Lootr converts a block in {@link #CONVERT_CLAYS} or {@link #CONVERT_SOUL_SANDS} into the matching variant through
 * the replacement providers listed in {@code META-INF/services}. Only loaded when Lootr is present.
 */
public class LootrCompat {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, Reference.MOD_ID);

    public static final DeferredHolder<Block, Block> SUSPICIOUS_CLAY = BLOCKS.register("lootr_suspicious_clay", () -> new LootrBrushableBlock(Blocks.CLAY, SoundEvents.BRUSH_SAND, SoundEvents.BRUSH_SAND_COMPLETED, ModRegistry.suspiciousBlockProperties()));
    public static final DeferredHolder<Block, Block> SUSPICIOUS_SOUL_SAND = BLOCKS.register("lootr_suspicious_soul_sand", () -> new LootrBrushableBlock(Blocks.SOUL_SAND, SoundEvents.BRUSH_SAND, SoundEvents.BRUSH_SAND_COMPLETED, ModRegistry.suspiciousBlockProperties()));

    public static final TagKey<Block> CONVERT_CLAYS = BlockTags.create(Reference.atm("lootr/convert/clays"));
    public static final TagKey<Block> CONVERT_SOUL_SANDS = BlockTags.create(Reference.atm("lootr/convert/soul_sands"));

    public static final String CLAY_TYPE = Reference.atm("clay").toString();
    public static final String SOUL_SAND_TYPE = Reference.atm("soul_sand").toString();

    private static final ResourceKey<BlockEntityType<?>> BRUSHABLE_BLOCK_ENTITY = ResourceKey.create(Registries.BLOCK_ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath("lootr", "brushable_block"));

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        modEventBus.addListener(LootrCompat::addBrushableBlocks);
    }

    private static void addBrushableBlocks(BlockEntityTypeAddBlocksEvent event) {
        event.modify(BRUSHABLE_BLOCK_ENTITY, SUSPICIOUS_CLAY.get(), SUSPICIOUS_SOUL_SAND.get());
    }

    /** The Lootr type registered for a variant block, as Lootr's own registry holds it. */
    public static Optional<ILootrType> lootrType(BlockState state) {
        if (state.is(SUSPICIOUS_CLAY.get())) return Optional.of(LootrAPI.getType(CLAY_TYPE));
        if (state.is(SUSPICIOUS_SOUL_SAND.get())) return Optional.of(LootrAPI.getType(SOUL_SAND_TYPE));
        return Optional.empty();
    }

    /**
     * Adds an ATM brush's bonus to a Lootr brushable block entity, on the ticks where its cooldown lets the brush
     * through — the same bonus vanilla brushable blocks get from {@code Brush}.
     */
    public static void addBrushBonus(BlockEntity blockEntity, int bonus, long gameTime) {
        if (blockEntity instanceof LootrBrushableBlockEntityAccessor accessor && gameTime >= accessor.allthemodium$getCoolDownEndsAtTick()) {
            accessor.allthemodium$setBrushCount(accessor.allthemodium$getBrushCount() + bonus);
        }
    }
}
