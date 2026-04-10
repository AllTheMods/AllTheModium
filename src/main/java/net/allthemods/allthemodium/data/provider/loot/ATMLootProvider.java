package net.allthemods.allthemodium.data.provider.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ATMLootProvider {
    
    public static LootTableProvider create(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        return new LootTableProvider(
                output,
                Set.of(),
                List.of(
                        new LootTableProvider.SubProviderEntry(ATMChestLoot::new, LootContextParamSets.CHEST),
                        new LootTableProvider.SubProviderEntry(ATMEntityLoot::new, LootContextParamSets.ENTITY),
                        new LootTableProvider.SubProviderEntry(ATMBlockLoot::new, LootContextParamSets.BLOCK)
                ),
                registries
        );
    }
}
