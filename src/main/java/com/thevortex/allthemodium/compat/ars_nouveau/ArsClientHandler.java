package com.thevortex.allthemodium.compat.ars_nouveau;

import com.hollingsworth.arsnouveau.ArsNouveau;
import com.hollingsworth.arsnouveau.common.items.data.BlockFillContents;
import net.minecraft.client.renderer.item.ItemProperties;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;


public class ArsClientHandler {
    
    public static void init(final FMLClientSetupEvent fmlClientSetupEvent) {
        fmlClientSetupEvent.enqueueWork(() -> ItemProperties.register(ArsCompat.ALLTHEMODIUM_SOURCE_JAR.asItem(), ArsNouveau.prefix("source"), (stack, level, entity, seed) -> {
            int amount = BlockFillContents.get(stack);
            return amount / 100000.0F;
        }));
    }
}