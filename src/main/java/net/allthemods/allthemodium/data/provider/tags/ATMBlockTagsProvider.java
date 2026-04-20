package net.allthemods.allthemodium.data.provider.tags;

import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.core.registry.ATMBlocks;
import net.allthemods.allthemodium.core.registry.ATMFluids;
import net.allthemods.allthemodium.core.registry.ATMTags;
import net.allthemods.alltheores.core.registry.ATORegistry;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ATMBlockTagsProvider extends BlockTagsProvider {
    
    
    public ATMBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, ATM.MOD_ID);
    }
    
    @Override
    protected void addTags(HolderLookup.Provider registries) {
        this.tag(BlockTags.OVERWORLD_CARVER_REPLACEABLES).add(ATMBlocks.ANCIENT_STONE.get());
        
        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(
                        ATMBlocks.ALLTHEMODIUM_ORE.get(),
                        ATMBlocks.DEEPSLATE_ALLTHEMODIUM_ORE.get(),
                        ATMBlocks.RAW_ALLTHEMODIUM_BLOCK.get(),
                        ATMBlocks.ALLTHEMODIUM_BLOCK.get()
                );
        
        this.tag(ATMTags.Blocks.INCORRECT_FOR_ALLTHEMODIUM_TOOL)
                .add(
                        ATMBlocks.UNOBTAINIUM_ORE.get(),
                        ATMBlocks.RAW_UNOBTAINIUM_BLOCK.get(),
                        ATMBlocks.UNOBTAINIUM_BLOCK.get()
                )
                .addTag(ATMTags.Blocks.INCORRECT_FOR_VIBRANIUM_TOOL);
        
        this.tag(ATMTags.Blocks.INCORRECT_FOR_VIBRANIUM_TOOL)
                .add(
                        ATMBlocks.UNOBTAINIUM_ALLTHEMODIUM_BLOCK.get(),
                        ATMBlocks.UNOBTAINIUM_VIBRANIUM_BLOCK.get(),
                        ATMBlocks.VIBRANIUM_ALLTHEMODIUM_BLOCK.get()
                );
        
        this.tag(ATMTags.Blocks.INCORRECT_FOR_UNOBTAINIUM_TOOL);
        this.tag(ATMTags.Blocks.INCORRECT_FOR_ALLOY_TOOL);
        
        List.of(
                BlockTags.INCORRECT_FOR_WOODEN_TOOL,
                BlockTags.INCORRECT_FOR_STONE_TOOL,
                BlockTags.INCORRECT_FOR_IRON_TOOL,
                BlockTags.INCORRECT_FOR_GOLD_TOOL,
                BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
                BlockTags.INCORRECT_FOR_NETHERITE_TOOL
        ).forEach(tag -> this.tag(tag)
                .addTag(ATMTags.Blocks.INCORRECT_FOR_ALLTHEMODIUM_TOOL)
                .addTag(ATMTags.Blocks.INCORRECT_FOR_VIBRANIUM_TOOL)
                .addTag(ATMTags.Blocks.INCORRECT_FOR_UNOBTAINIUM_TOOL)
                .addTag(ATMTags.Blocks.INCORRECT_FOR_ALLOY_TOOL)
        );
        
        this.tag(ATMTags.Blocks.MINEABLE_WITH_PAXEL)
                .addTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.MINEABLE_WITH_SHOVEL)
                .addTag(BlockTags.MINEABLE_WITH_HOE);
        
        this.tag(ATMTags.Blocks.SUPPORTS_OTHER_VEGETATION)
                .add(
                        ATMBlocks.ANCIENT_DIRT.get(),
                        ATMBlocks.ANCIENT_GRASS.get(),
                        Blocks.WARPED_NYLIUM,
                        Blocks.CRIMSON_NYLIUM
                );
        
        this.tag(BlockTags.BEACON_BASE_BLOCKS)
                .add(
                        ATMBlocks.ALLTHEMODIUM_BLOCK.get(), 
                        ATMBlocks.VIBRANIUM_BLOCK.get(), 
                        ATMBlocks.UNOBTAINIUM_BLOCK.get()
                );
        
        this.tag(BlockTags.SOUL_FIRE_BASE_BLOCKS)
                .add(
                        ATMBlocks.ANCIENT_DIRT.get(),
                        ATMBlocks.ANCIENT_GRASS.get(),
                        ATMBlocks.ANCIENT_LOG_0.get(),
                        ATMBlocks.ANCIENT_LOG_1.get(),
                        ATMBlocks.ANCIENT_LOG_2.get(),
                        ATMBlocks.STRIPPED_ANCIENT_LOG.get()
                );
        
        this.tag(BlockTags.PLANKS).add(ATMBlocks.ANCIENT_PLANKS.get(), ATMBlocks.SOUL_PLANKS.get(), ATMBlocks.DEMONIC_PLANKS.get());
        this.tag(ATMTags.Blocks.ANCIENT_PLANKS).add(ATMBlocks.ANCIENT_PLANKS.get());
        this.tag(ATMTags.Blocks.SOUL_PLANKS).add(ATMBlocks.SOUL_PLANKS.get());
        this.tag(ATMTags.Blocks.DEMONIC_PLANKS).add(ATMBlocks.DEMONIC_PLANKS.get());
        
        this.tag(BlockTags.LOGS)
                .add(
                        ATMBlocks.ANCIENT_LOG_0.get(),
                        ATMBlocks.ANCIENT_LOG_1.get(),
                        ATMBlocks.ANCIENT_LOG_2.get(),
                        ATMBlocks.STRIPPED_ANCIENT_LOG.get(),
                        ATMBlocks.SOUL_LOG_0.get(),
                        ATMBlocks.SOUL_LOG_1.get(),
                        ATMBlocks.SOUL_LOG_2.get(),
                        ATMBlocks.STRIPPED_SOUL_LOG.get(),
                        ATMBlocks.DEMONIC_LOG.get(),
                        ATMBlocks.STRIPPED_DEMONIC_LOG.get()
                );
        
        this.tag(BlockTags.SAPLINGS).add(ATMBlocks.ANCIENT_SAPLING.get(), ATMBlocks.SOUL_SAPLING.get(), ATMBlocks.DEMONIC_SAPLING.get());
        this.tag(BlockTags.LEAVES)
                .add(
                        ATMBlocks.ANCIENT_LEAVES.get(),
                        ATMBlocks.ANCIENT_LEAVES_BOTTOM.get(),
                        ATMBlocks.SOUL_LEAVES.get(),
                        ATMBlocks.SOUL_LEAVES_BOTTOM.get(),
                        ATMBlocks.DEMONIC_LEAVES.get(),
                        ATMBlocks.DEMONIC_LEAVES_BOTTOM.get()
                );
        
        this.tag(BlockTags.CAVE_VINES).add(ATMBlocks.ANCIENT_CAVE_VINES.get(), ATMBlocks.ANCIENT_CAVE_VINES_PLANT.get());
        this.tag(BlockTags.CLIMBABLE).add(ATMBlocks.ANCIENT_CAVE_VINES.get(), ATMBlocks.ANCIENT_CAVE_VINES_PLANT.get());
        
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        ATMBlocks.ALLTHEMODIUM_ORE.get(),
                        ATMBlocks.DEEPSLATE_ALLTHEMODIUM_ORE.get(),
                        ATMBlocks.VIBRANIUM_ORE.get(),
                        ATMBlocks.OTHER_VIBRANIUM_ORE.get(),
                        ATMBlocks.UNOBTAINIUM_ORE.get(),
                        ATMBlocks.RAW_ALLTHEMODIUM_BLOCK.get(),
                        ATMBlocks.RAW_VIBRANIUM_BLOCK.get(),
                        ATMBlocks.RAW_UNOBTAINIUM_BLOCK.get(),
                        ATMBlocks.ALLTHEMODIUM_BLOCK.get(),
                        ATMBlocks.VIBRANIUM_BLOCK.get(),
                        ATMBlocks.UNOBTAINIUM_BLOCK.get(),
                        ATMBlocks.UNOBTAINIUM_ALLTHEMODIUM_BLOCK.get(),
                        ATMBlocks.UNOBTAINIUM_VIBRANIUM_BLOCK.get(),
                        ATMBlocks.VIBRANIUM_ALLTHEMODIUM_BLOCK.get(),
                        ATMBlocks.PIGLICH_HEART_BLOCK.get(),
                        ATMBlocks.ANCIENT_STONE.get(),
                        ATMBlocks.SMOOTH_ANCIENT_STONE.get(),
                        ATMBlocks.MOSSY_ANCIENT_STONE.get(),
                        ATMBlocks.ANCIENT_STONE_BRICKS.get(),
                        ATMBlocks.CHISELED_ANCIENT_STONE_BRICKS.get(),
                        ATMBlocks.CRACKED_ANCIENT_STONE_BRICKS.get(),
                        ATMBlocks.POLISHED_ANCIENT_STONE.get(),
                        ATMBlocks.ANCIENT_STONE_WALL.get(),
                        ATMBlocks.SMOOTH_ANCIENT_STONE_WALL.get(),
                        ATMBlocks.MOSSY_ANCIENT_STONE_WALL.get(),
                        ATMBlocks.ANCIENT_STONE_BRICK_WALL.get(),
                        ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_WALL.get(),
                        ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_WALL.get(),
                        ATMBlocks.POLISHED_ANCIENT_STONE_WALL.get(),
                        ATMBlocks.ANCIENT_STONE_STAIRS.get(),
                        ATMBlocks.SMOOTH_ANCIENT_STONE_STAIRS.get(),
                        ATMBlocks.MOSSY_ANCIENT_STONE_STAIRS.get(),
                        ATMBlocks.ANCIENT_STONE_BRICK_STAIRS.get(),
                        ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_STAIRS.get(),
                        ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_STAIRS.get(),
                        ATMBlocks.POLISHED_ANCIENT_STONE_STAIRS.get(),
                        ATMBlocks.ANCIENT_STONE_SLAB.get(),
                        ATMBlocks.SMOOTH_ANCIENT_STONE_SLAB.get(),
                        ATMBlocks.MOSSY_ANCIENT_STONE_SLAB.get(),
                        ATMBlocks.ANCIENT_STONE_BRICK_SLAB.get(),
                        ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_SLAB.get(),
                        ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_SLAB.get(),
                        ATMBlocks.POLISHED_ANCIENT_STONE_SLAB.get(),
                        ATMBlocks.TELEPORT_PAD.get()
                );
        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(
                        ATMBlocks.ANCIENT_PLANKS.get(),
                        ATMBlocks.ANCIENT_LOG_0.get(),
                        ATMBlocks.ANCIENT_LOG_1.get(),
                        ATMBlocks.ANCIENT_LOG_2.get(),
                        ATMBlocks.STRIPPED_ANCIENT_LOG.get(),
                        ATMBlocks.ANCIENT_TRAPDOOR.get(),
                        ATMBlocks.ANCIENT_FENCE.get(),
                        ATMBlocks.ANCIENT_FENCE_GATE.get(),
                        ATMBlocks.ANCIENT_DOOR.get(),
                        ATMBlocks.ANCIENT_BOOKSHELF.get(),
                        ATMBlocks.ANCIENT_STAIRS.get(),
                        ATMBlocks.ANCIENT_SLAB.get(),
                        ATMBlocks.SOUL_PLANKS.get(),
                        ATMBlocks.SOUL_LOG_0.get(),
                        ATMBlocks.SOUL_LOG_1.get(),
                        ATMBlocks.SOUL_LOG_2.get(),
                        ATMBlocks.STRIPPED_SOUL_LOG.get(),
                        ATMBlocks.SOUL_TRAPDOOR.get(),
                        ATMBlocks.SOUL_FENCE.get(),
                        ATMBlocks.SOUL_FENCE_GATE.get(),
                        ATMBlocks.SOUL_DOOR.get(),
                        ATMBlocks.SOUL_BOOKSHELF.get(),
                        ATMBlocks.SOUL_STAIRS.get(),
                        ATMBlocks.SOUL_SLAB.get(),
                        ATMBlocks.DEMONIC_PLANKS.get(),
                        ATMBlocks.DEMONIC_LOG.get(),
                        ATMBlocks.STRIPPED_DEMONIC_LOG.get(),
                        ATMBlocks.DEMONIC_TRAPDOOR.get(),
                        ATMBlocks.DEMONIC_FENCE.get(),
                        ATMBlocks.DEMONIC_FENCE_GATE.get(),
                        ATMBlocks.DEMONIC_DOOR.get(),
                        ATMBlocks.DEMONIC_BOOKSHELF.get(),
                        ATMBlocks.DEMONIC_STAIRS.get(),
                        ATMBlocks.DEMONIC_SLAB.get()
                );
        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(
                        ATMBlocks.ANCIENT_LEAVES.get(),
                        ATMBlocks.ANCIENT_LEAVES_BOTTOM.get(),
                        ATMBlocks.SOUL_LEAVES.get(),
                        ATMBlocks.SOUL_LEAVES_BOTTOM.get(),
                        ATMBlocks.DEMONIC_LEAVES.get(),
                        ATMBlocks.DEMONIC_LEAVES_BOTTOM.get()
                );
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(
                        ATMBlocks.ANCIENT_DIRT.get(),
                        ATMBlocks.ANCIENT_GRASS.get(),
                        ATMBlocks.SUS_CLAY.get(),
                        ATMBlocks.SUS_SOUL_SAND.get()
                );
        
        this.tag(BlockTags.DIRT).add(ATMBlocks.ANCIENT_DIRT.get(), ATMBlocks.ANCIENT_GRASS.get());
        this.tag(BlockTags.NYLIUM).add(ATMBlocks.ANCIENT_STONE.get());
        this.tag(BlockTags.INFINIBURN_NETHER).add(ATMBlocks.ANCIENT_STONE.get(), ATMBlocks.ANCIENT_GRASS.get(), ATMBlocks.ANCIENT_DIRT.get());
        
        this.tag(BlockTags.WOODEN_FENCES).add(ATMBlocks.ANCIENT_FENCE.get(), ATMBlocks.SOUL_FENCE.get(), ATMBlocks.DEMONIC_FENCE.get());
        this.tag(BlockTags.FENCES).addTag(BlockTags.WOODEN_FENCES);
        this.tag(Tags.Blocks.FENCES_WOODEN).addTag(BlockTags.WOODEN_FENCES);
        
        this.tag(BlockTags.FENCE_GATES).add(ATMBlocks.ANCIENT_FENCE_GATE.get(), ATMBlocks.SOUL_FENCE_GATE.get(), ATMBlocks.DEMONIC_FENCE_GATE.get());
        this.tag(Tags.Blocks.FENCE_GATES_WOODEN).addTag(BlockTags.FENCE_GATES);
        
        this.tag(BlockTags.WOODEN_SLABS).add(ATMBlocks.ANCIENT_SLAB.get(), ATMBlocks.SOUL_SLAB.get(), ATMBlocks.DEMONIC_SLAB.get());
        this.tag(BlockTags.WOODEN_STAIRS).add(ATMBlocks.ANCIENT_STAIRS.get(), ATMBlocks.SOUL_STAIRS.get(), ATMBlocks.DEMONIC_STAIRS.get());
        this.tag(BlockTags.WOODEN_DOORS).add(ATMBlocks.ANCIENT_DOOR.get(), ATMBlocks.SOUL_DOOR.get(), ATMBlocks.DEMONIC_DOOR.get());
        this.tag(BlockTags.DOORS).addTag(BlockTags.WOODEN_DOORS);
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(ATMBlocks.ANCIENT_TRAPDOOR.get(), ATMBlocks.SOUL_TRAPDOOR.get(), ATMBlocks.DEMONIC_TRAPDOOR.get());
        this.tag(BlockTags.TRAPDOORS).addTag(BlockTags.WOODEN_TRAPDOORS);
        
        this.tag(BlockTags.SLABS)
                .addTag(BlockTags.WOODEN_SLABS)
                .add(
                        ATMBlocks.ANCIENT_STONE_SLAB.get(),
                        ATMBlocks.SMOOTH_ANCIENT_STONE_SLAB.get(),
                        ATMBlocks.MOSSY_ANCIENT_STONE_SLAB.get(),
                        ATMBlocks.ANCIENT_STONE_BRICK_SLAB.get(),
                        ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_SLAB.get(),
                        ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_SLAB.get(),
                        ATMBlocks.POLISHED_ANCIENT_STONE_SLAB.get()
                );
        this.tag(BlockTags.STAIRS)
                .addTag(BlockTags.WOODEN_STAIRS)
                .add(
                        ATMBlocks.ANCIENT_STONE_STAIRS.get(),
                        ATMBlocks.SMOOTH_ANCIENT_STONE_STAIRS.get(),
                        ATMBlocks.MOSSY_ANCIENT_STONE_STAIRS.get(),
                        ATMBlocks.ANCIENT_STONE_BRICK_STAIRS.get(),
                        ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_STAIRS.get(),
                        ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_STAIRS.get(),
                        ATMBlocks.POLISHED_ANCIENT_STONE_STAIRS.get()
                );
        this.tag(BlockTags.WALLS)
                .add(
                        ATMBlocks.ANCIENT_STONE_WALL.get(),
                        ATMBlocks.SMOOTH_ANCIENT_STONE_WALL.get(),
                        ATMBlocks.MOSSY_ANCIENT_STONE_WALL.get(),
                        ATMBlocks.ANCIENT_STONE_BRICK_WALL.get(),
                        ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_WALL.get(),
                        ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_WALL.get(),
                        ATMBlocks.POLISHED_ANCIENT_STONE_WALL.get()
                );
        
        this.tag(BlockTags.STONE_BRICKS)
                .add(
                        ATMBlocks.ANCIENT_STONE_BRICKS.get(),
                        ATMBlocks.CHISELED_ANCIENT_STONE_BRICKS.get(),
                        ATMBlocks.CRACKED_ANCIENT_STONE_BRICKS.get()
                );
        
        this.tag(Tags.Blocks.BOOKSHELVES)
                .add(
                        ATMBlocks.ANCIENT_BOOKSHELF.get(),
                        ATMBlocks.SOUL_BOOKSHELF.get(),
                        ATMBlocks.DEMONIC_BOOKSHELF.get()
                );
        
        this.tag(ATMTags.Blocks.ANCIENT_STONE).add(ATMBlocks.ANCIENT_STONE.get());
        this.tag(ATMTags.Blocks.SMOOTH_ANCIENT_STONE).add(ATMBlocks.SMOOTH_ANCIENT_STONE.get());
        this.tag(ATMTags.Blocks.MOSSY_ANCIENT_STONE).add(ATMBlocks.MOSSY_ANCIENT_STONE.get());
        this.tag(ATMTags.Blocks.POLISHED_ANCIENT_STONE).add(ATMBlocks.POLISHED_ANCIENT_STONE.get());
        this.tag(ATMTags.Blocks.ANCIENT_STONE_BRICKS).add(ATMBlocks.ANCIENT_STONE_BRICKS.get());
        this.tag(ATMTags.Blocks.CRACKED_ANCIENT_STONE_BRICKS).add(ATMBlocks.CRACKED_ANCIENT_STONE_BRICKS.get());
        this.tag(ATMTags.Blocks.CHISELED_ANCIENT_STONE_BRICKS).add(ATMBlocks.CHISELED_ANCIENT_STONE_BRICKS.get());
        
        this.tag(ATMTags.Blocks.ORES_ALLTHEMODIUM).add(ATMBlocks.ALLTHEMODIUM_ORE.get(), ATMBlocks.DEEPSLATE_ALLTHEMODIUM_ORE.get());
        this.tag(ATMTags.Blocks.ORES_VIBRANIUM).add(ATMBlocks.VIBRANIUM_ORE.get(), ATMBlocks.OTHER_VIBRANIUM_ORE.get());
        this.tag(ATMTags.Blocks.ORES_UNOBTANIUM).add(ATMBlocks.UNOBTAINIUM_ORE.get());
        this.tag(Tags.Blocks.ORES)
                .add(
                        ATMBlocks.ALLTHEMODIUM_ORE.get(),
                        ATMBlocks.DEEPSLATE_ALLTHEMODIUM_ORE.get(),
                        ATMBlocks.VIBRANIUM_ORE.get(),
                        ATMBlocks.OTHER_VIBRANIUM_ORE.get(),
                        ATMBlocks.UNOBTAINIUM_ORE.get()
                );
        this.tag(Tags.Blocks.ORES_IN_GROUND_STONE).add(ATMBlocks.ALLTHEMODIUM_ORE.get());
        this.tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE).add(ATMBlocks.DEEPSLATE_ALLTHEMODIUM_ORE.get());
        this.tag(Tags.Blocks.ORES_IN_GROUND_NETHERRACK).add(ATMBlocks.VIBRANIUM_ORE.get());
        this.tag(ATORegistry.ORES_IN_GROUND_ANCIENT_STONE).add(ATMBlocks.OTHER_VIBRANIUM_ORE.get());
        
        this.tag(Tags.Blocks.STORAGE_BLOCKS)
                .add(
                        ATMBlocks.PIGLICH_HEART_BLOCK.get(),
                        ATMBlocks.ALLTHEMODIUM_BLOCK.get(),
                        ATMBlocks.VIBRANIUM_BLOCK.get(),
                        ATMBlocks.UNOBTAINIUM_BLOCK.get(),
                        ATMBlocks.RAW_ALLTHEMODIUM_BLOCK.get(),
                        ATMBlocks.RAW_VIBRANIUM_BLOCK.get(),
                        ATMBlocks.RAW_UNOBTAINIUM_BLOCK.get(),
                        ATMBlocks.UNOBTAINIUM_ALLTHEMODIUM_BLOCK.get(),
                        ATMBlocks.UNOBTAINIUM_VIBRANIUM_BLOCK.get(),
                        ATMBlocks.VIBRANIUM_ALLTHEMODIUM_BLOCK.get()
                );
        this.tag(ATMTags.Blocks.STORAGE_BLOCKS_ALLTHEMODIUM).add(ATMBlocks.ALLTHEMODIUM_BLOCK.get());
        this.tag(ATMTags.Blocks.STORAGE_BLOCKS_VIBRANIUM).add(ATMBlocks.VIBRANIUM_BLOCK.get());
        this.tag(ATMTags.Blocks.STORAGE_BLOCKS_UNOBTAINIUM).add(ATMBlocks.UNOBTAINIUM_BLOCK.get());
        this.tag(ATMTags.Blocks.STORAGE_BLOCKS_RAW_ALLTHEMODIUM).add(ATMBlocks.RAW_ALLTHEMODIUM_BLOCK.get());
        this.tag(ATMTags.Blocks.STORAGE_BLOCKS_RAW_VIBRANIUM).add(ATMBlocks.RAW_VIBRANIUM_BLOCK.get());
        this.tag(ATMTags.Blocks.STORAGE_BLOCKS_RAW_UNOBTAINIUM).add(ATMBlocks.RAW_UNOBTAINIUM_BLOCK.get());
        this.tag(ATMTags.Blocks.STORAGE_BLOCKS_VIBRANIUM_ALLTHEMODIUM_ALLOY).add(ATMBlocks.VIBRANIUM_ALLTHEMODIUM_BLOCK.get());
        this.tag(ATMTags.Blocks.STORAGE_BLOCKS_UNOBTAINIUM_ALLTHEMODIUM_ALLOY).add(ATMBlocks.UNOBTAINIUM_ALLTHEMODIUM_BLOCK.get());
        this.tag(ATMTags.Blocks.STORAGE_BLOCKS_UNOBTAINIUM_VIBRANIUM_ALLOY).add(ATMBlocks.UNOBTAINIUM_VIBRANIUM_BLOCK.get());
        
        for (var entry : ATMBlocks.BLOCKS.getEntries()) {
            this.tag(ATMTags.Blocks.OTHER_PROTECTION).add(entry.get());
        }
        
        for (var entry : ATMFluids.BLOCKS.getEntries()) {
            this.tag(ATMTags.Blocks.OTHER_PROTECTION).add(entry.get());
        }
        
        this.tag(ATMTags.Blocks.OTHER_PROTECTION)
                .add(
                        Blocks.SAND,
                        Blocks.SANDSTONE,
                        Blocks.CRIMSON_NYLIUM,
                        Blocks.WARPED_NYLIUM,
                        Blocks.NETHERRACK,
                        Blocks.SOUL_SAND,
                        Blocks.SOUL_SOIL,
                        Blocks.DEEPSLATE,
                        Blocks.NETHERITE_BLOCK,
                        Blocks.DIAMOND_BLOCK,
                        Blocks.AMETHYST_BLOCK,
                        Blocks.AMETHYST_CLUSTER,
                        Blocks.GOLD_BLOCK,
                        Blocks.SPAWNER
                )
                .addTag(Tags.Blocks.ORES);
        
        this.tag(Tags.Blocks.RELOCATION_NOT_SUPPORTED)
                .add(
                        ATMBlocks.ALLTHEMODIUM_ORE.get(),
                        ATMBlocks.DEEPSLATE_ALLTHEMODIUM_ORE.get(),
                        ATMBlocks.VIBRANIUM_ORE.get(),
                        ATMBlocks.OTHER_VIBRANIUM_ORE.get(),
                        ATMBlocks.UNOBTAINIUM_ORE.get()
                );
    }
    
    private static TagKey<Block> atm(String path) {
        return TagKey.create(Registries.BLOCK, ATM.id(path));
    }
    
    private static TagKey<Block> c(String path) {
        return TagKey.create(Registries.BLOCK, ATM.c(path));
    }
}
