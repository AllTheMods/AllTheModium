package com.thevortex.allthemodium.datagen.client;

import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.ModRegistry;
import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockStates extends BlockStateProvider {

    public BlockStates(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, Reference.MOD_ID, fileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        List<Block> entries = ModRegistry.BLOCKS
                .getEntries()
                .stream()
                .map(RegistryObject::get)
                .filter(block -> !(block instanceof GrassBlock))
                .filter(block -> !(block instanceof LiquidBlock))
                .collect(Collectors.toList());

        entries.forEach(this::simpleBlockAndItem);

        logBlock((RotatedPillarBlock) ModRegistry.ANCIENT_LOG_0.get());
        logBlock((RotatedPillarBlock) ModRegistry.ANCIENT_LOG_1.get());
        logBlock((RotatedPillarBlock) ModRegistry.ANCIENT_LOG_2.get());
        logBlock((RotatedPillarBlock) ModRegistry.ANCIENT_LOG_STRIPPED.get());
        logBlock((RotatedPillarBlock) ModRegistry.ANCIENT_BOOKSHELF.get());

        simpleBlockItem(
                ModRegistry.ANCIENT_LOG_0.get(),
                models().getBuilder("ancient_log_0"));
        simpleBlockItem(
                ModRegistry.ANCIENT_LOG_1.get(),
                models().getBuilder("ancient_log_1"));
        simpleBlockItem(
                ModRegistry.ANCIENT_LOG_2.get(),
                models().getBuilder("ancient_log_2"));
        simpleBlockItem(
                ModRegistry.ANCIENT_LOG_STRIPPED.get(),
                models().getBuilder("stripped_ancient_log"));
        // trapdoorBlock(ModRegistry.ANCIENT_TRAPDOOR.get(),new
        // ResourceLocation(Reference.MOD_ID,"block/ancient_trap_door"),true);
        simpleBlockItem(
                ModRegistry.ANCIENT_BOOKSHELF.get(),
                models().getBuilder("ancient_bookshelf"));
        stairsBlock(
                ModRegistry.ANCIENT_WOODEN_STAIRS.get(),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_planks"));

        logBlock((RotatedPillarBlock) ModRegistry.SOUL_LOG.get());
        logBlock((RotatedPillarBlock) ModRegistry.SOUL_LOG_0.get());
        logBlock((RotatedPillarBlock) ModRegistry.SOUL_LOG_1.get());
        logBlock((RotatedPillarBlock) ModRegistry.SOUL_LOG_2.get());
        logBlock((RotatedPillarBlock) ModRegistry.SOUL_LOG_STRIPPED.get());
        logBlock((RotatedPillarBlock) ModRegistry.SOUL_BOOKSHELF.get());

        simpleBlockItem(
                ModRegistry.SOUL_LOG.get(),
                models().getBuilder("soul_log"));
        simpleBlockItem(
                ModRegistry.SOUL_LOG_0.get(),
                models().getBuilder("soul_log_0"));
        simpleBlockItem(
                ModRegistry.SOUL_LOG_1.get(),
                models().getBuilder("soul_log_1"));
        simpleBlockItem(
                ModRegistry.SOUL_LOG_2.get(),
                models().getBuilder("soul_log_2"));
        simpleBlockItem(
                ModRegistry.SOUL_LOG_STRIPPED.get(),
                models().getBuilder("stripped_soul_log"));
        simpleBlockItem(
                ModRegistry.SOUL_BOOKSHELF.get(),
                models().getBuilder("soul_bookshelf"));
        stairsBlock(
                ModRegistry.SOUL_WOODEN_STAIRS.get(),
                new ResourceLocation(Reference.MOD_ID, "block/soul_planks"));

        logBlock((RotatedPillarBlock) ModRegistry.DEMONIC_LOG.get());
        logBlock((RotatedPillarBlock) ModRegistry.DEMONIC_LOG_STRIPPED.get());
        logBlock((RotatedPillarBlock) ModRegistry.DEMONIC_BOOKSHELF.get());

        simpleBlockItem(
                ModRegistry.DEMONIC_LOG.get(),
                models().getBuilder("demonic_log"));
        simpleBlockItem(
                ModRegistry.DEMONIC_LOG_STRIPPED.get(),
                models().getBuilder("stripped_demonic_log"));
        simpleBlockItem(
                ModRegistry.DEMONIC_BOOKSHELF.get(),
                models().getBuilder("demonic_bookshelf"));
        stairsBlock(
                ModRegistry.DEMONIC_WOODEN_STAIRS.get(),
                new ResourceLocation(Reference.MOD_ID, "block/demonic_planks"));

        stairsBlock(
                ModRegistry.ANCIENT_STONE_STAIRS.get(),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_stone"));
        stairsBlock(
                ModRegistry.ANCIENT_SMOOTH_STONE_STAIRS.get(),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_smooth_stone"));
        stairsBlock(
                ModRegistry.ANCIENT_STONE_BRICK_STAIRS.get(),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_stone_bricks"));
        stairsBlock(
                ModRegistry.ANCIENT_MOSSY_STONE_STAIRS.get(),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_mossy_stone"));
        stairsBlock(
                ModRegistry.ANCIENT_CHISELED_STONE_STAIRS.get(),
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_chiseled_stone_bricks"));
        stairsBlock(
                ModRegistry.ANCIENT_CRACKED_STONE_STAIRS.get(),
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_cracked_stone_bricks"));
        stairsBlock(
                ModRegistry.ANCIENT_POLISHED_STONE_STAIRS.get(),
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_polished_stone"));

        fenceBlock(
                ModRegistry.ANCIENT_WOOD_FENCE.get(),
                "ancient_wooden_fence",
                new ResourceLocation(Reference.MOD_ID, "block/ancient_planks"));
        fenceGateBlock(
                ModRegistry.ANCIENT_WOOD_FENCE_GATE.get(),
                "ancient_wooden_fence_gate",
                new ResourceLocation(Reference.MOD_ID, "block/ancient_planks"));
        fenceBlock(
                ModRegistry.DEMONIC_WOOD_FENCE.get(),
                "demonic_wooden_fence",
                new ResourceLocation(Reference.MOD_ID, "block/demonic_planks"));
        fenceGateBlock(
                ModRegistry.DEMONIC_WOOD_FENCE_GATE.get(),
                "demonic_wooden_fence_gate",
                new ResourceLocation(Reference.MOD_ID, "block/demonic_planks"));
        fenceBlock(
                ModRegistry.SOUL_WOOD_FENCE.get(),
                "soul_wooden_fence",
                new ResourceLocation(Reference.MOD_ID, "block/soul_planks"));
        fenceGateBlock(
                ModRegistry.SOUL_WOOD_FENCE_GATE.get(),
                "soul_wooden_fence_gate",
                new ResourceLocation(Reference.MOD_ID, "block/soul_planks"));

        wallBlock(
                ModRegistry.ANCIENT_STONE_WALL.get(),
                "ancient_stone_wall",
                new ResourceLocation(Reference.MOD_ID, "block/ancient_stone"));
        wallBlock(
                ModRegistry.ANCIENT_SMOOTH_STONE_WALL.get(),
                "ancient_smooth_stone_wall",
                new ResourceLocation(Reference.MOD_ID, "block/ancient_smooth_stone"));
        wallBlock(
                ModRegistry.ANCIENT_POLISHED_STONE_WALL.get(),
                "ancient_polished_stone_wall",
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_polished_stone"));
        wallBlock(
                ModRegistry.ANCIENT_MOSSY_STONE_WALL.get(),
                "ancient_mossy_stone_wall",
                new ResourceLocation(Reference.MOD_ID, "block/ancient_mossy_stone"));
        wallBlock(
                ModRegistry.ANCIENT_STONE_BRICK_WALL.get(),
                "ancient_stone_brick_wall",
                new ResourceLocation(Reference.MOD_ID, "block/ancient_stone_bricks"));
        wallBlock(
                ModRegistry.ANCIENT_CHISELED_STONE_BRICK_WALL.get(),
                "ancient_chiseled_stone_brick_wall",
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_chiseled_stone_bricks"));
        wallBlock(
                ModRegistry.ANCIENT_CRACKED_STONE_BRICK_WALL.get(),
                "ancient_cracked_stone_brick_wall",
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_cracked_stone_bricks"));

        slabBlock(
                ModRegistry.ANCIENT_WOODEN_SLABS.get(),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_planks"),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_planks"));
        slabBlock(
                ModRegistry.DEMONIC_WOODEN_SLABS.get(),
                new ResourceLocation(Reference.MOD_ID, "block/demonic_planks"),
                new ResourceLocation(Reference.MOD_ID, "block/demonic_planks"));
        slabBlock(
                ModRegistry.SOUL_WOODEN_SLABS.get(),
                new ResourceLocation(Reference.MOD_ID, "block/soul_planks"),
                new ResourceLocation(Reference.MOD_ID, "block/soul_planks"));
        slabBlock(
                ModRegistry.ANCIENT_STONE_SLABS.get(),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_stone"),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_stone"));
        slabBlock(
                ModRegistry.ANCIENT_SMOOTH_STONE_SLABS.get(),
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_smooth_stone"),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_smooth_stone"));
        slabBlock(
                ModRegistry.ANCIENT_STONE_BRICK_SLABS.get(),
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_stone_bricks"),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_stone_bricks"));
        slabBlock(
                ModRegistry.ANCIENT_MOSSY_STONE_SLABS.get(),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_mossy_stone"),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_mossy_stone"));
        slabBlock(
                ModRegistry.ANCIENT_CHISELED_STONE_SLABS.get(),
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_chiseled_stone_bricks"),
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_chiseled_stone_bricks"));
        slabBlock(
                ModRegistry.ANCIENT_CRACKED_STONE_SLABS.get(),
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_cracked_stone_bricks"),
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_cracked_stone_bricks"));
        slabBlock(
                ModRegistry.ANCIENT_POLISHED_STONE_SLABS.get(),
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_polished_stone"),
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_polished_stone"));

        doorBlock(
                ModRegistry.ANCIENT_DOOR_.get(),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_door_bottom"),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_door_top"));
        doorBlock(
                ModRegistry.DEMONIC_DOOR_.get(),
                new ResourceLocation(Reference.MOD_ID, "block/demonic_door_bottom"),
                new ResourceLocation(Reference.MOD_ID, "block/demonic_door_top"));
        doorBlock(
                ModRegistry.SOUL_DOOR_.get(),
                new ResourceLocation(Reference.MOD_ID, "block/soul_door_bottom"),
                new ResourceLocation(Reference.MOD_ID, "block/soul_door_top"));
    }

    /**
     * Generates an item model and block model/block state for a simple block
     *
     * @param block
     *            the block
     */
    private void simpleBlockAndItem(Block block) {
        ResourceLocation blockName = ForgeRegistries.BLOCKS.getKey(block);
        simpleBlock(block);
        BlockModelBuilder builder = models().getBuilder(blockName.toString());
        simpleBlockItem(block, builder);
    }
}
