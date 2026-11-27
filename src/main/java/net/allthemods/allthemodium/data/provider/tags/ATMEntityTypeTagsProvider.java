package net.allthemods.allthemodium.data.provider.tags;

import net.neoforged.neoforge.common.Tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.core.registry.ATMEntities;

import java.util.concurrent.CompletableFuture;

public class ATMEntityTypeTagsProvider extends EntityTypeTagsProvider {
    
    public ATMEntityTypeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, ATM.MOD_ID);
    }
    
    @Override
    protected void addTags(HolderLookup.Provider registries) {
        this.tag(Tags.EntityTypes.BOSSES)
                .add(ATMEntities.PIGLICH.get());
    }
}
