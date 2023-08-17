package com.thevortex.allthemodium.datagen.server;

import com.thevortex.allthemodium.blocks.Allthemodium_Ore;
import com.thevortex.allthemodium.blocks.Unobtainium_Ore;
import com.thevortex.allthemodium.blocks.Vibranium_Ore;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ATMLootTables extends VanillaBlockLoot {




        @Override
        public void generate() {

            getKnownBlocks().forEach(this::dropRaw);



        }

        private static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
        private void dropRaw(Block block) {
            if(block instanceof LiquidBlock) {
                return;
            }

            if(block.getName().getString().contains("ancient_bookshelf")) {
                this.add(ModRegistry.ANCIENT_BOOKSHELF.get(), (p_124241_) -> {
                    return createSingleItemTableWithSilkTouch(p_124241_, Items.BOOK, ConstantValue.exactly(3.0F));
                });
            }
            String oretype = block.getName().getString();

            if (block instanceof Allthemodium_Ore) {
                this.add(block, (block1) -> createOreDrop(block1, ModRegistry.RAW_ALLTHEMODIUM.get()));
            }
            else if (block instanceof Vibranium_Ore) {
                this.add(block, (block1) -> createOreDrop(block1, ModRegistry.RAW_VIBRANIUM.get()));
            }
            else if (block instanceof Unobtainium_Ore) {
                this.add(block, (block1) -> createOreDrop(block1, ModRegistry.RAW_UNOBTAINIUM.get()));
            }
            else if (oretype.contains("raw_")) {
                this.dropSelf(block);
            }
            else { this.dropSelf(block); }

        }


        @Override
        protected Iterable<Block> getKnownBlocks() {
            return Stream.of(ModRegistry.BLOCKS.getEntries(),
                    ModRegistry.STAIRBLOCKS.getEntries(),
                    ModRegistry.SLABBLOCKS.getEntries(),
                    ModRegistry.WALLBLOCKS.getEntries(),
                    ModRegistry.PILLARBLOCKS.getEntries())
                    .filter(block -> !(block instanceof LeavesBlock))
                    .flatMap(Collection::stream)
                    .map(RegistryObject::get)
                    .collect(Collectors.toList());

        }
        protected Iterable<Block> getKnownStairs() {
            return ModRegistry.STAIRBLOCKS.getEntries()
                    .stream().map(RegistryObject::get)
                    .collect(Collectors.toList());

        }
        protected Iterable<Block> getKnownSlabs() {
            return ModRegistry.SLABBLOCKS.getEntries()
                    .stream().map(RegistryObject::get)
                    .collect(Collectors.toList());

        }

        protected Iterable<Block> getKnownWalls() {
            return ModRegistry.WALLBLOCKS.getEntries()
                    .stream().map(RegistryObject::get)
                    .collect(Collectors.toList());

        }
        protected Iterable<Block> getunKnownBlocks() {
            return ModRegistry.PILLARBLOCKS.getEntries()
                    .stream().map(RegistryObject::get)
                    .collect(Collectors.toList());

        }




}
