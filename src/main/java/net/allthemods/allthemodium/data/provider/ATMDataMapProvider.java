package net.allthemods.allthemodium.data.provider;

import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.neoforged.neoforge.registries.datamaps.builtin.Strippable;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;

import net.allthemods.allthemodium.core.registry.ATMBlocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ATMDataMapProvider extends DataMapProvider {

    public ATMDataMapProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
        Builder<Strippable, Block> strippables = this.builder(NeoForgeDataMaps.STRIPPABLES);

        ATMDataMapProvider.strip(strippables, ATMBlocks.STRIPPED_ANCIENT_LOG, List.of(ATMBlocks.ANCIENT_LOG_0, ATMBlocks.ANCIENT_LOG_1, ATMBlocks.ANCIENT_LOG_2));
        ATMDataMapProvider.strip(strippables, ATMBlocks.STRIPPED_SOUL_LOG, List.of(ATMBlocks.SOUL_LOG_0, ATMBlocks.SOUL_LOG_1, ATMBlocks.SOUL_LOG_2));
        ATMDataMapProvider.strip(strippables, ATMBlocks.STRIPPED_DEMONIC_LOG, List.of(ATMBlocks.DEMONIC_LOG));
    }

    private static void strip(
            Builder<Strippable, Block> strippables,
            DeferredHolder<Block, ? extends Block> stripped,
            List<DeferredHolder<Block, ? extends Block>> logs
    ) {
        Strippable value = new Strippable(stripped.get());
        for (DeferredHolder<Block, ? extends Block> log : logs) {
            strippables.add(log.getKey(), value, false);
        }
    }
}
