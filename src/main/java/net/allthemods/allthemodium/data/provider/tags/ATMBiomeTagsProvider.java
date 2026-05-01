package net.allthemods.allthemodium.data.provider.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.core.registry.ATMTags;
import net.allthemods.allthemodium.data.worldgen.ATMBiomes;

import java.util.concurrent.CompletableFuture;

public class ATMBiomeTagsProvider extends BiomeTagsProvider {
    
    public ATMBiomeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, ATM.MOD_ID);
    }
    
    // Non-optional here will crash datagen since biomes are data and not registry entries
    @Override
    protected void addTags(HolderLookup.Provider registries) {
        this.tag(ATMTags.Biomes.IS_OTHER)
                .addOptional(ATMBiomes.THE_OTHER)
                .addOptional(ATMBiomes.BASALT_DELTAS)
                .addOptional(ATMBiomes.CRIMSON_FOREST)
                .addOptional(ATMBiomes.WARPED_FOREST)
                .addOptional(ATMBiomes.SOUL_SAND_VALLEY)
                .addOptional(ATMBiomes.DESERT)
                .addOptional(ATMBiomes.DESERT_HILLS)
                .addOptional(ATMBiomes.WRETCHED_CAVES);
        
        this.tag(ATMTags.Biomes.HAS_DUNGEON)
                .addOptional(ATMBiomes.WARPED_FOREST);
        
        this.tag(ATMTags.Biomes.HAS_ANCIENT_PYRAMID)
                .addOptional(ATMBiomes.SOUL_SAND_VALLEY);
        
        this.tag(ATMTags.Biomes.HAS_PIGLICH_VILLAGE)
                .addOptional(ATMBiomes.CRIMSON_FOREST)
                .addOptional(ATMBiomes.THE_OTHER);
    }
}
