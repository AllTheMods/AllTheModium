package com.thevortex.allthemodium.datagen.server;

import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ATMEntityTypeTags extends EntityTypeTagsProvider {

    public ATMEntityTypeTags(PackOutput packOutPut, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(packOutPut, lookupProvider, Reference.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(Tags.EntityTypes.BOSSES).add(ModRegistry.PIGLICH.get());
    }
}
