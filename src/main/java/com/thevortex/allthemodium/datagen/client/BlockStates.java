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
        //trapdoorBlock(ModRegistry.ANCIENT_TRAPDOOR.get(),new ResourceLocation(Reference.MOD_ID,"block/ancient_trap_door"),true);
        simpleBlockItem(ModRegistry.ANCIENT_BOOKSHELF.get(),models().getBuilder("ancient_bookshelf"));
        //
        stairsBlock(ModRegistry.ANCIENT_WOODEN_STAIRS.get(), new ResourceLocation(Reference.MOD_ID,"block/ancient_planks"));
        stairsBlock(ModRegistry.ANCIENT_STONE_STAIRS.get(), new ResourceLocation(Reference.MOD_ID,"block/ancient_stone"));
        stairsBlock(ModRegistry.ANCIENT_SMOOTH_STONE_STAIRS.get(), new ResourceLocation(Reference.MOD_ID,"block/ancient_smooth_stone"));
        stairsBlock(ModRegistry.ANCIENT_STONE_BRICK_STAIRS.get(), new ResourceLocation(Reference.MOD_ID,"block/ancient_stone_bricks"));
        stairsBlock(ModRegistry.ANCIENT_MOSSY_STONE_STAIRS.get(), new ResourceLocation(Reference.MOD_ID,"block/ancient_mossy_stone"));
        stairsBlock(ModRegistry.ANCIENT_CHISELED_STONE_STAIRS.get(), new ResourceLocation(Reference.MOD_ID,"block/ancient_chiseled_stone_bricks"));
        stairsBlock(ModRegistry.ANCIENT_CRACKED_STONE_STAIRS.get(), new ResourceLocation(Reference.MOD_ID,"block/ancient_cracked_stone_bricks"));
        stairsBlock(ModRegistry.ANCIENT_POLISHED_STONE_STAIRS.get(), new ResourceLocation(Reference.MOD_ID,"block/ancient_polished_stone"));

        fenceBlock(ModRegistry.ANCIENT_WOOD_FENCE_,"ancient_wooden_fence",new ResourceLocation(Reference.MOD_ID,"block/ancient_planks"));
        fenceGateBlock(ModRegistry.ANCIENT_WOOD_FENCE_GATE_,"ancient_wooden_fence_gate",new ResourceLocation(Reference.MOD_ID,"block/ancient_planks"));

        wallBlock(ModRegistry.ANCIENT_STONE_WALL_,"ancient_stone_wall",new ResourceLocation(Reference.MOD_ID,"block/ancient_stone"));
        wallBlock(ModRegistry.ANCIENT_SMOOTH_STONE_WALL_,"ancient_smooth_stone_wall",new ResourceLocation(Reference.MOD_ID,"block/ancient_smooth_stone"));
        wallBlock(ModRegistry.ANCIENT_POLISHED_STONE_WALL_,"ancient_polished_stone_wall",new ResourceLocation(Reference.MOD_ID,"block/ancient_polished_stone"));
        wallBlock(ModRegistry.ANCIENT_MOSSY_STONE_WALL_,"ancient_mossy_stone_wall",new ResourceLocation(Reference.MOD_ID,"block/ancient_mossy_stone"));
        wallBlock(ModRegistry.ANCIENT_STONE_BRICK_WALL_,"ancient_stone_brick_wall",new ResourceLocation(Reference.MOD_ID,"block/ancient_stone_bricks"));
        wallBlock(ModRegistry.ANCIENT_CHISELED_STONE_BRICK_WALL_,"ancient_chiseled_stone_brick_wall",new ResourceLocation(Reference.MOD_ID,"block/ancient_chiseled_stone_bricks"));
        wallBlock(ModRegistry.ANCIENT_CRACKED_STONE_BRICK_WALL_,"ancient_cracked_stone_brick_wall",new ResourceLocation(Reference.MOD_ID,"block/ancient_cracked_stone_bricks"));

        slabBlock(ModRegistry.ANCIENT_WOODEN_SLABS.get(), new ResourceLocation(Reference.MOD_ID,"block/ancient_planks"), new ResourceLocation(Reference.MOD_ID,"block/ancient_planks"));
        slabBlock(ModRegistry.ANCIENT_STONE_SLABS.get(), new ResourceLocation(Reference.MOD_ID,"block/ancient_stone"), new ResourceLocation(Reference.MOD_ID,"block/ancient_stone"));
        slabBlock(ModRegistry.ANCIENT_SMOOTH_STONE_SLABS.get(), new ResourceLocation(Reference.MOD_ID,"block/ancient_smooth_stone"), new ResourceLocation(Reference.MOD_ID,"block/ancient_smooth_stone"));
        slabBlock(ModRegistry.ANCIENT_STONE_BRICK_SLABS.get(), new ResourceLocation(Reference.MOD_ID,"block/ancient_stone_bricks"), new ResourceLocation(Reference.MOD_ID,"block/ancient_stone_bricks"));
        slabBlock(ModRegistry.ANCIENT_MOSSY_STONE_SLABS.get(), new ResourceLocation(Reference.MOD_ID,"block/ancient_mossy_stone"), new ResourceLocation(Reference.MOD_ID,"block/ancient_mossy_stone"));
        slabBlock(ModRegistry.ANCIENT_CHISELED_STONE_SLABS.get(), new ResourceLocation(Reference.MOD_ID,"block/ancient_chiseled_stone_bricks"), new ResourceLocation(Reference.MOD_ID,"block/ancient_chiseled_stone_bricks"));
        slabBlock(ModRegistry.ANCIENT_CRACKED_STONE_SLABS.get(), new ResourceLocation(Reference.MOD_ID,"block/ancient_cracked_stone_bricks"), new ResourceLocation(Reference.MOD_ID,"block/ancient_cracked_stone_bricks"));
        slabBlock(ModRegistry.ANCIENT_POLISHED_STONE_SLABS.get(), new ResourceLocation(Reference.MOD_ID,"block/ancient_polished_stone"), new ResourceLocation(Reference.MOD_ID,"block/ancient_polished_stone"));

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
