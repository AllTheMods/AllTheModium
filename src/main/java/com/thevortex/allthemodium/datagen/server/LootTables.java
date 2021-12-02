package com.thevortex.allthemodium.datagen.server;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LootTables extends LootTableProvider {

    public LootTables(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return ImmutableList.of(
                Pair.of(BlockLoots::new, LootContextParamSets.BLOCK)
        );
    }

    public static class BlockLoots extends BlockLoot {

        @Override
        public void addTables() {
            getKnownBlocks().forEach(this::dropRaw);
        }

        private void dropRaw(Block block) {
            if(block instanceof LiquidBlock) {
                return;
            }
            if (block instanceof OreBlock) {
                String oretype = block.getRegistryName().getPath();
                if (oretype.contains("allthemodium_ore") || oretype.contains("allthemodium_slate_ore")) {
                    this.add(block, (block1) -> createOreDrop(block1, ModRegistry.RAW_ALLTHEMODIUM.get()));
                }
                if (oretype.contains("vibranium_ore")) {
                    this.add(block, (block1) -> createOreDrop(block1, ModRegistry.RAW_VIBRANIUM.get()));
                }
                if (oretype.contains("unobtainium_ore")) {
                    this.add(block, (block1) -> createOreDrop(block1, ModRegistry.RAW_UNOBTAINIUM.get()));
                }
                if (oretype.contains("raw_")) {
                    this.dropSelf(block);
                }
            } else {
                this.dropSelf(block);
            }
        }


        @Override
        protected Iterable<Block> getKnownBlocks() {
            return ModRegistry.BLOCKS.getEntries()
                    .stream().map(RegistryObject::get)
                    .collect(Collectors.toList());

        }
    }
        @Override
        protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationtracker)
        {
            map.forEach((name, table) -> net.minecraft.world.level.storage.loot.LootTables.validate(validationtracker, name, table));
        }


}
