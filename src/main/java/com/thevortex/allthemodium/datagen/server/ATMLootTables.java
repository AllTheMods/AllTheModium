package com.thevortex.allthemodium.datagen.server;

import com.thevortex.allthemodium.blocks.ATMBrushableBlock;
import com.thevortex.allthemodium.blocks.Allthemodium_Ore;
import com.thevortex.allthemodium.blocks.Unobtainium_Ore;
import com.thevortex.allthemodium.blocks.Vibranium_Ore;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ATMLootTables extends VanillaBlockLoot
{
    public ATMLootTables(Provider p_344962_) {
        super(p_344962_);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void generate() {
        getKnownBlocks().forEach(this::dropRaw);

        this.add(ModRegistry.ANCIENT_PODZOL.get(), b -> this.createSingleItemTableWithSilkTouch(b, Blocks.DIRT));
        dropWhenSilkTouch(ModRegistry.ANCIENT_FERN.get());
    }

    private static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};

    private void dropRaw(Block block) {
        if (block instanceof LiquidBlock) {
            return;
        }

        if (block.getName().getString().contains("ancient_bookshelf")) {
            this.add(ModRegistry.ANCIENT_BOOKSHELF.get(), (p_124241_) -> {
                return createSingleItemTableWithSilkTouch(p_124241_, Items.BOOK, ConstantValue.exactly(3.0F));
            });
        }
        String oretype = block.getName().getString();

        if (block instanceof Allthemodium_Ore) {
            this.add(block, (block1) -> createOreDrop(block1, ModRegistry.RAW_ALLTHEMODIUM.get()));
        } else if (block instanceof Vibranium_Ore) {
            this.add(block, (block1) -> createOreDrop(block1, ModRegistry.RAW_VIBRANIUM.get()));
        } else if (block instanceof Unobtainium_Ore) {
            this.add(block, (block1) -> createOreDrop(block1, ModRegistry.RAW_UNOBTAINIUM.get()));
        } else if (oretype.contains("raw_")) {
            this.dropSelf(block);
        } else {
            this.dropSelf(block);
        }
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        List<Block> list = Stream.of(ModRegistry.BLOCKS.getEntries(),
                        ModRegistry.STAIRBLOCKS.getEntries(),
                        ModRegistry.SLABBLOCKS.getEntries(),
                        ModRegistry.WALLBLOCKS.getEntries(),
                        ModRegistry.PILLARBLOCKS.getEntries())
                .filter(block -> !(block instanceof LeavesBlock)) // this does nothing
                .flatMap(Collection::stream)
                .map(DeferredHolder::get)
                .filter(block -> !(block instanceof ATMBrushableBlock))
                .collect(Collectors.toList());
        list.add(ModRegistry.TELEPORT_PAD.get());
        return list;
    }
}
