package com.thevortex.allthemodium.datagen.client;

import com.thevortex.allthemodium.blocks.ATMBrushableBlock;
import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.VariantBlockStateBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.List;
import java.util.stream.Collectors;

public class BlockStates extends BlockStateProvider {
    public BlockStates(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator.getPackOutput(), Reference.MOD_ID, fileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        List<Block> entries = ModRegistry.BLOCKS.getEntries()
            .stream()
            .filter(block -> !block.is(ModRegistry.ANCIENT_PODZOL))
            .filter(block -> !block.is(ModRegistry.ANCIENT_FERN))
            .map(DeferredHolder::get)
            .filter(block -> !(block instanceof GrassBlock))
            .filter(block -> !(block instanceof LiquidBlock))
            .filter(block -> !(block instanceof SaplingBlock))
            .filter(block -> !(block instanceof LeavesBlock))
            .filter(block -> !(block instanceof ATMBrushableBlock))
            .filter(block -> !(block.builtInRegistryHolder().unwrapKey().get().location().getPath().contains("planks")))
            .collect(Collectors.toList());

        entries.forEach(this::simpleBlockAndItem);

        simpleBlockWithItem(ModRegistry.ANCIENT_PLANKS.get(), cubeAll(ModRegistry.ANCIENT_PLANKS.get()));
        simpleBlockWithItem(ModRegistry.DEMONIC_PLANKS.get(), cubeAll(ModRegistry.DEMONIC_PLANKS.get()));
        simpleBlockWithItem(ModRegistry.SOUL_PLANKS.get(), cubeAll(ModRegistry.SOUL_PLANKS.get()));

        simpleBlockWithItem(ModRegistry.ANCIENT_LEAVES.get(), cubeAll(ModRegistry.ANCIENT_LEAVES.get()));
        simpleBlockWithItem(ModRegistry.DEMONIC_LEAVES.get(), cubeAll(ModRegistry.DEMONIC_LEAVES.get()));
        simpleBlockWithItem(ModRegistry.SOUL_LEAVES.get(), cubeAll(ModRegistry.SOUL_LEAVES.get()));

        crossBlock(ModRegistry.ANCIENT_SAPLING.get());
        crossBlock(ModRegistry.SOUL_SAPLING.get());
        crossBlock(ModRegistry.DEMONIC_SAPLING.get());

        logBlock((RotatedPillarBlock)ModRegistry.ANCIENT_LOG_0.get());
        logBlock((RotatedPillarBlock)ModRegistry.ANCIENT_LOG_1.get());
        logBlock((RotatedPillarBlock)ModRegistry.ANCIENT_LOG_2.get());
        logBlock((RotatedPillarBlock)ModRegistry.ANCIENT_LOG_STRIPPED.get());
        logBlock((RotatedPillarBlock)ModRegistry.ANCIENT_BOOKSHELF.get());

        simpleBlockItem(ModRegistry.ANCIENT_LOG_0.get(),models().getBuilder("ancient_log_0"));
        simpleBlockItem(ModRegistry.ANCIENT_LOG_1.get(),models().getBuilder("ancient_log_1"));
        simpleBlockItem(ModRegistry.ANCIENT_LOG_2.get(),models().getBuilder("ancient_log_2"));
        simpleBlockItem(ModRegistry.ANCIENT_LOG_STRIPPED.get(),models().getBuilder("stripped_ancient_log"));
        //trapdoorBlock(ModRegistry.ANCIENT_TRAPDOOR.get(),ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_trap_door"),true);
        simpleBlockItem(ModRegistry.ANCIENT_BOOKSHELF.get(),models().getBuilder("ancient_bookshelf"));
        //
        stairsBlock((StairBlock) ModRegistry.ANCIENT_WOODEN_STAIRS.get(), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_planks"));
        

        logBlock((RotatedPillarBlock)ModRegistry.SOUL_LOG.get());
        logBlock((RotatedPillarBlock)ModRegistry.SOUL_LOG_0.get());
        logBlock((RotatedPillarBlock)ModRegistry.SOUL_LOG_1.get());
        logBlock((RotatedPillarBlock)ModRegistry.SOUL_LOG_2.get());
        logBlock((RotatedPillarBlock)ModRegistry.SOUL_LOG_STRIPPED.get());
        logBlock((RotatedPillarBlock)ModRegistry.SOUL_BOOKSHELF.get());

        simpleBlockItem(ModRegistry.SOUL_LOG.get(),models().getBuilder("soul_log"));
        simpleBlockItem(ModRegistry.SOUL_LOG_0.get(),models().getBuilder("soul_log_0"));
        simpleBlockItem(ModRegistry.SOUL_LOG_1.get(),models().getBuilder("soul_log_1"));
        simpleBlockItem(ModRegistry.SOUL_LOG_2.get(),models().getBuilder("soul_log_2"));
        simpleBlockItem(ModRegistry.SOUL_LOG_STRIPPED.get(),models().getBuilder("stripped_soul_log"));
        simpleBlockItem(ModRegistry.SOUL_BOOKSHELF.get(),models().getBuilder("soul_bookshelf"));
        stairsBlock((StairBlock) ModRegistry.SOUL_WOODEN_STAIRS.get(), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/soul_planks"));

        logBlock((RotatedPillarBlock)ModRegistry.DEMONIC_LOG.get());
        logBlock((RotatedPillarBlock)ModRegistry.DEMONIC_LOG_STRIPPED.get());
        logBlock((RotatedPillarBlock)ModRegistry.DEMONIC_BOOKSHELF.get());

        simpleBlockItem(ModRegistry.DEMONIC_LOG.get(),models().getBuilder("demonic_log"));
        simpleBlockItem(ModRegistry.DEMONIC_LOG_STRIPPED.get(),models().getBuilder("stripped_demonic_log"));
        simpleBlockItem(ModRegistry.DEMONIC_BOOKSHELF.get(),models().getBuilder("demonic_bookshelf"));
        stairsBlock((StairBlock) ModRegistry.DEMONIC_WOODEN_STAIRS.get(), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/demonic_planks"));


        stairsBlock((StairBlock) ModRegistry.ANCIENT_STONE_STAIRS.get(), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_stone"));
        stairsBlock((StairBlock) ModRegistry.ANCIENT_SMOOTH_STONE_STAIRS.get(), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_smooth_stone"));
        stairsBlock((StairBlock) ModRegistry.ANCIENT_STONE_BRICK_STAIRS.get(), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_stone_bricks"));
        stairsBlock((StairBlock) ModRegistry.ANCIENT_MOSSY_STONE_STAIRS.get(), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_mossy_stone"));
        stairsBlock((StairBlock) ModRegistry.ANCIENT_CHISELED_STONE_STAIRS.get(), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_chiseled_stone_bricks"));
        stairsBlock((StairBlock) ModRegistry.ANCIENT_CRACKED_STONE_STAIRS.get(), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_cracked_stone_bricks"));
        stairsBlock((StairBlock) ModRegistry.ANCIENT_POLISHED_STONE_STAIRS.get(), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_polished_stone"));

        fenceBlock((FenceBlock) ModRegistry.ANCIENT_WOOD_FENCE.get(),"ancient_wooden_fence",ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_planks"));
        fenceGateBlock((FenceGateBlock) ModRegistry.ANCIENT_WOOD_FENCE_GATE.get(),"ancient_wooden_fence_gate", ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_planks"));
        fenceBlock((FenceBlock) ModRegistry.DEMONIC_WOOD_FENCE.get(),"demonic_wooden_fence", ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/demonic_planks"));
        fenceGateBlock((FenceGateBlock) ModRegistry.DEMONIC_WOOD_FENCE_GATE.get(),"demonic_wooden_fence_gate", ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/demonic_planks"));
        fenceBlock((FenceBlock) ModRegistry.SOUL_WOOD_FENCE.get(),"soul_wooden_fence", ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/soul_planks"));
        fenceGateBlock((FenceGateBlock) ModRegistry.SOUL_WOOD_FENCE_GATE.get(),"soul_wooden_fence_gate", ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/soul_planks"));

        wallBlock((WallBlock) ModRegistry.ANCIENT_STONE_WALL.get(),"ancient_stone_wall",ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_stone"));
        wallBlock((WallBlock) ModRegistry.ANCIENT_SMOOTH_STONE_WALL.get(),"ancient_smooth_stone_wall",ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_smooth_stone"));
        wallBlock((WallBlock) ModRegistry.ANCIENT_POLISHED_STONE_WALL.get(),"ancient_polished_stone_wall",ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_polished_stone"));
        wallBlock((WallBlock) ModRegistry.ANCIENT_MOSSY_STONE_WALL.get(),"ancient_mossy_stone_wall",ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_mossy_stone"));
        wallBlock((WallBlock) ModRegistry.ANCIENT_STONE_BRICK_WALL.get(),"ancient_stone_brick_wall",ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_stone_bricks"));
        wallBlock((WallBlock) ModRegistry.ANCIENT_CHISELED_STONE_BRICK_WALL.get(),"ancient_chiseled_stone_brick_wall",ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_chiseled_stone_bricks"));
        wallBlock((WallBlock) ModRegistry.ANCIENT_CRACKED_STONE_BRICK_WALL.get(),"ancient_cracked_stone_brick_wall",ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_cracked_stone_bricks"));

        slabBlock((SlabBlock) ModRegistry.ANCIENT_WOODEN_SLABS.get(), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_planks"), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_planks"));
        slabBlock((SlabBlock) ModRegistry.DEMONIC_WOODEN_SLABS.get(), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/demonic_planks"), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/demonic_planks"));
        slabBlock((SlabBlock) ModRegistry.SOUL_WOODEN_SLABS.get(), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/soul_planks"), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/soul_planks"));
        slabBlock((SlabBlock) ModRegistry.ANCIENT_STONE_SLABS.get(), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_stone"), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_stone"));
        slabBlock((SlabBlock) ModRegistry.ANCIENT_SMOOTH_STONE_SLABS.get(), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_smooth_stone"), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_smooth_stone"));
        slabBlock((SlabBlock) ModRegistry.ANCIENT_STONE_BRICK_SLABS.get(), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_stone_bricks"), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_stone_bricks"));
        slabBlock((SlabBlock) ModRegistry.ANCIENT_MOSSY_STONE_SLABS.get(), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_mossy_stone"), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_mossy_stone"));
        slabBlock((SlabBlock) ModRegistry.ANCIENT_CHISELED_STONE_SLABS.get(), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_chiseled_stone_bricks"), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_chiseled_stone_bricks"));
        slabBlock((SlabBlock) ModRegistry.ANCIENT_CRACKED_STONE_SLABS.get(), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_cracked_stone_bricks"), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_cracked_stone_bricks"));
        slabBlock((SlabBlock) ModRegistry.ANCIENT_POLISHED_STONE_SLABS.get(), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_polished_stone"), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_polished_stone"));

        doorBlock((DoorBlock) ModRegistry.ANCIENT_DOOR.get(),ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_door_bottom"),ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_door_top"));
        doorBlock((DoorBlock) ModRegistry.DEMONIC_DOOR.get(),ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/demonic_door_bottom"),ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/demonic_door_top"));
        doorBlock((DoorBlock) ModRegistry.SOUL_DOOR.get(),ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/soul_door_bottom"),ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/soul_door_top"));



    }




    /**
     * Generates an item model and block model/blockstate for a simple block
     * @param block the block
     */
    private void simpleBlockAndItem(Block block) {
        ResourceLocation blockName = Registries.BLOCK.registry();
        simpleBlock(block);
        BlockModelBuilder builder = models().getBuilder(blockName.toString());
        simpleBlockItem(block, builder);
    }

    private void crossBlock(Block block) {
        this.simpleBlock(block, this.models().cross(BuiltInRegistries.BLOCK.getKey(block).getPath(), this.blockTexture(block)).renderType("cutout"));
    }
}
