package com.thevortex.allthemodium.datagen.client;

import com.thevortex.allthemodium.blocks.Ancient_Grass;
import com.thevortex.allthemodium.registry.ModRegistry;
import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

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
            .filter(block -> !(block instanceof GrassBlock))
            .filter(block -> !(block instanceof LiquidBlock))
            .collect(Collectors.toList());

        entries.forEach(this::simpleBlockAndItem);

        logBlock((RotatedPillarBlock)ModRegistry.ANCIENT_LOG_0.get());
        logBlock((RotatedPillarBlock)ModRegistry.ANCIENT_LOG_1.get());
        logBlock((RotatedPillarBlock)ModRegistry.ANCIENT_LOG_2.get());
        logBlock((RotatedPillarBlock)ModRegistry.ANCIENT_LOG_STRIPPED.get());
        logBlock((RotatedPillarBlock)ModRegistry.ANCIENT_BOOKSHELF.get());

        simpleBlockItem(ModRegistry.ANCIENT_LOG_0.get(),models().getBuilder("ancient_log_0"));
        simpleBlockItem(ModRegistry.ANCIENT_LOG_1.get(),models().getBuilder("ancient_log_1"));
        simpleBlockItem(ModRegistry.ANCIENT_LOG_2.get(),models().getBuilder("ancient_log_2"));
        simpleBlockItem(ModRegistry.ANCIENT_LOG_STRIPPED.get(),models().getBuilder("stripped_ancient_log"));
        //trapdoorBlock((TrapDoorBlock) ModRegistry.ANCIENT_TRAPDOOR.get(),new ResourceLocation(Reference.MOD_ID,"ancient_trapdoor"),true);
        simpleBlockItem(ModRegistry.ANCIENT_BOOKSHELF.get(),models().getBuilder("ancient_bookshelf"));

    }


    /**
     * Generates an item model and block model/blockstate for a simple block
     * @param block the block
     */
    private void simpleBlockAndItem(Block block) {
        String blockName = Objects.requireNonNull(block.getRegistryName()).toString();
        simpleBlock(block);
        BlockModelBuilder builder = models().getBuilder(blockName);
        simpleBlockItem(block, builder);
    }

}
