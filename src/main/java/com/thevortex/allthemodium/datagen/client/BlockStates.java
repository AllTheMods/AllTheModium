package com.thevortex.allthemodium.datagen.client;

import com.thevortex.allthemodium.registry.ModRegistry;
import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fmllegacy.RegistryObject;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BlockStates extends BlockStateProvider {
    public BlockStates(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, Reference.MOD_ID, fileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        List<Block> entries = ModRegistry.BLOCKS.getEntries()
            .stream().map(RegistryObject::get)
            .filter(block -> !(block instanceof LiquidBlock))
            .collect(Collectors.toList());

        entries.forEach(this::simpleBlockAndItem);
    }

    /**
     * Generates an item model and block model/blockstate for a simple block
     * @param block the block
     */
    private void simpleBlockAndItem(Block block) {
        simpleBlock(block);

        String blockName = Objects.requireNonNull(block.getRegistryName()).toString();
        BlockModelBuilder builder = models().getBuilder(blockName);
        simpleBlockItem(block, builder);
    }
}
