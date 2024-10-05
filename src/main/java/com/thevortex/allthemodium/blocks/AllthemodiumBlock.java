package com.thevortex.allthemodium.blocks;

import com.thevortex.allthemodium.registry.ModRegistry;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.storage.loot.LootContext;

public class AllthemodiumBlock extends Block {

    public AllthemodiumBlock() {
        super(
                Properties.of(Material.METAL).sound(SoundType.STONE).strength(7.0f));
    }

    @Deprecated
    @Override
    public List<ItemStack> getDrops(
            @Nonnull BlockState state,
            @Nonnull LootContext.Builder builder) {
        List<ItemStack> list = new ArrayList<ItemStack>();
        list.add(new ItemStack(ModRegistry.ALLTHEMODIUM_BLOCK.get()));
        return list;
    }
}
