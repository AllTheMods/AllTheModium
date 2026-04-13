package net.allthemods.allthemodium.data.provider;

import net.neoforged.neoforge.client.data.SpriteSourceProvider;

import net.minecraft.client.renderer.texture.atlas.sources.SingleFile;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.AtlasIds;
import net.minecraft.data.PackOutput;

import net.allthemods.allthemodium.api.ATM;

import java.util.concurrent.CompletableFuture;

public class ATMSpriteSourceProvider extends SpriteSourceProvider {
    
    public ATMSpriteSourceProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, ATM.MOD_ID);
    }
    
    @Override
    protected void gather() {
        this.atlas(AtlasIds.ARMOR_TRIMS)
                .addSource(new SingleFile(ATM.id("trims/color_palettes/allthemodium")))
                .addSource(new SingleFile(ATM.id("trims/color_palettes/allthemodium_darker")))
                .addSource(new SingleFile(ATM.id("trims/color_palettes/vibranium")))
                .addSource(new SingleFile(ATM.id("trims/color_palettes/unobtainium")));
    }
}
