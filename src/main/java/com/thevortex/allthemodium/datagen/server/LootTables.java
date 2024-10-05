package com.thevortex.allthemodium.datagen.server;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.thevortex.allthemodium.blocks.AllthemodiumOre;
import com.thevortex.allthemodium.blocks.UnobtainiumOre;
import com.thevortex.allthemodium.blocks.VibraniumOre;
import com.thevortex.allthemodium.registry.ModRegistry;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;

public class LootTables extends LootTableProvider {

    public LootTables(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return ImmutableList.of(
                Pair.of(BlockLoots::new, LootContextParamSets.BLOCK));
    }

    public static class BlockLoots extends BlockLoot {

        @Override
        public void addTables() {
            getKnownBlocks().forEach(this::dropRaw);
        }

        // private static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[] {
        // 0.05F, 0.0625F, 0.083333336F, 0.1F };

        private void dropRaw(Block block) {
            if (block instanceof LiquidBlock) {
                return;
            }

            if (block.getName().getString().contains("ancient_bookshelf")) {
                this.add(
                        ModRegistry.ANCIENT_BOOKSHELF.get(),
                        p_124241_ -> {
                            return createSingleItemTableWithSilkTouch(
                                    p_124241_,
                                    Items.BOOK,
                                    ConstantValue.exactly(3.0F));
                        });
            }
            String oreType = block.getName().getString();

            if (block instanceof AllthemodiumOre) {
                this.add(
                        block,
                        block1 -> createOreDrop(
                                block1,
                                ModRegistry.RAW_ALLTHEMODIUM.get()));
            } else if (block instanceof VibraniumOre) {
                this.add(
                        block,
                        block1 -> createOreDrop(
                                block1,
                                ModRegistry.RAW_VIBRANIUM.get()));
            } else if (block instanceof UnobtainiumOre) {
                this.add(
                        block,
                        block1 -> createOreDrop(
                                block1,
                                ModRegistry.RAW_UNOBTAINIUM.get()));
            } else if (oreType.contains("raw_")) {
                this.dropSelf(block);
            } else {
                this.dropSelf(block);
            }
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return Stream
                    .of(
                            ModRegistry.BLOCKS.getEntries(),
                            ModRegistry.STAIR_BLOCKS.getEntries(),
                            ModRegistry.SLAB_BLOCKS.getEntries(),
                            ModRegistry.WALL_BLOCKS.getEntries(),
                            ModRegistry.PILLAR_BLOCKS.getEntries())
                    .filter(block -> !(block instanceof LeavesBlock))
                    .flatMap(Collection::stream)
                    .map(RegistryObject::get)
                    .collect(Collectors.toList());
        }

        protected Iterable<Block> getKnownStairs() {
            return ModRegistry.STAIR_BLOCKS
                    .getEntries()
                    .stream()
                    .map(RegistryObject::get)
                    .collect(Collectors.toList());
        }

        protected Iterable<Block> getKnownSlabs() {
            return ModRegistry.SLAB_BLOCKS
                    .getEntries()
                    .stream()
                    .map(RegistryObject::get)
                    .collect(Collectors.toList());
        }

        protected Iterable<Block> getKnownWalls() {
            return ModRegistry.WALL_BLOCKS
                    .getEntries()
                    .stream()
                    .map(RegistryObject::get)
                    .collect(Collectors.toList());
        }

        protected Iterable<Block> getUnknownBlocks() {
            return ModRegistry.PILLAR_BLOCKS
                    .getEntries()
                    .stream()
                    .map(RegistryObject::get)
                    .collect(Collectors.toList());
        }
    }

    @Override
    protected void validate(
            Map<ResourceLocation, LootTable> map,
            ValidationContext validationTracker) {
        map.forEach((name, table) -> net.minecraft.world.level.storage.loot.LootTables.validate(
                validationTracker,
                name,
                table));
    }
}
