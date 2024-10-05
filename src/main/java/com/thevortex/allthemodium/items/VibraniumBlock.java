/**
 *
 */
package com.thevortex.allthemodium.items;

import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.world.item.BlockItem;

/**
 * @author thevortex
 *
 */
public class VibraniumBlock extends BlockItem {

    public VibraniumBlock(Properties properties) {
        super(ModRegistry.VIBRANIUM_BLOCK.get(), properties);
    }
}
