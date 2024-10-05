package com.thevortex.allthemodium.items;

import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.world.item.BlockItem;

public class AllthemodiumBlock extends BlockItem {

    public AllthemodiumBlock(Properties properties) {
        super(ModRegistry.ALLTHEMODIUM_BLOCK.get(), properties);
    }
}
