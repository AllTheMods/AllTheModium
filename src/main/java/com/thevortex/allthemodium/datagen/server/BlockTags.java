package com.thevortex.allthemodium.datagen.server;

import static net.minecraftforge.common.Tags.Blocks.NEEDS_NETHERITE_TOOL;

import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.ModRegistry;
import com.thevortex.allthemodium.registry.TagRegistry;
import net.allthemods.alltheores.blocks.BlockList;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class BlockTags extends BlockTagsProvider {

    public BlockTags(
            DataGenerator generator,
            @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, Reference.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(TagRegistry.OTHER_TILE_WHITELIST).add(Blocks.FURNACE);
        tag(TagRegistry.OTHER_TILE_WHITELIST).add(Blocks.BLAST_FURNACE);
        tag(TagRegistry.OTHER_TILE_WHITELIST).add(Blocks.BREWING_STAND);
        tag(TagRegistry.OTHER_TILE_WHITELIST).add(Blocks.BARREL);
        tag(TagRegistry.OTHER_TILE_WHITELIST).add(Blocks.CHEST);
        tag(TagRegistry.OTHER_TILE_WHITELIST).add(Blocks.CAMPFIRE);
        tag(TagRegistry.OTHER_TILE_WHITELIST).add(Blocks.SOUL_CAMPFIRE);

        tag(TagRegistry.PAXEL_TARGETS)
                .addTag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE);
        tag(TagRegistry.PAXEL_TARGETS)
                .addTag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE);
        tag(TagRegistry.PAXEL_TARGETS)
                .addTag(net.minecraft.tags.BlockTags.MINEABLE_WITH_SHOVEL);
        tag(TagRegistry.PAXEL_TARGETS)
                .addTag(net.minecraft.tags.BlockTags.MINEABLE_WITH_HOE);

        tag(net.minecraft.tags.BlockTags.SOUL_FIRE_BASE_BLOCKS)
                .add(ModRegistry.ANCIENT_DIRT.get());
        tag(net.minecraft.tags.BlockTags.SOUL_FIRE_BASE_BLOCKS)
                .add(ModRegistry.ANCIENT_GRASS.get());
        tag(net.minecraft.tags.BlockTags.SOUL_FIRE_BASE_BLOCKS)
                .add(ModRegistry.ANCIENT_LOG_0.get());
        tag(net.minecraft.tags.BlockTags.SOUL_FIRE_BASE_BLOCKS)
                .add(ModRegistry.ANCIENT_LOG_1.get());
        tag(net.minecraft.tags.BlockTags.SOUL_FIRE_BASE_BLOCKS)
                .add(ModRegistry.ANCIENT_LOG_2.get());
        tag(TagRegistry.ANCIENT_WOODEN_PLANKS)
                .add(ModRegistry.ANCIENT_PLANKS.get());
        tag(TagRegistry.DEMONIC_WOODEN_PLANKS)
                .add(ModRegistry.DEMONIC_PLANKS.get());
        tag(TagRegistry.SOUL_WOODEN_PLANKS).add(ModRegistry.SOUL_PLANKS.get());
        tag(TagRegistry.ANCIENT_STONE).add(ModRegistry.ANCIENT_STONE.get());
        tag(TagRegistry.ANCIENT_DIRT).add(ModRegistry.ANCIENT_DIRT.get());
        tag(TagRegistry.ANCIENT_MOSSY_STONE)
                .add(ModRegistry.ANCIENT_MOSSY_STONE.get());
        tag(TagRegistry.ANCIENT_POLISHED_STONE)
                .add(ModRegistry.ANCIENT_POLISHED_STONE.get());
        tag(TagRegistry.ANCIENT_SMOOTH_STONE)
                .add(ModRegistry.ANCIENT_SMOOTH_STONE.get());
        tag(TagRegistry.ANCIENT_STONE_BRICKS)
                .add(ModRegistry.ANCIENT_STONE_BRICKS.get());
        tag(TagRegistry.ANCIENT_CRACKED_STONE_BRICKS)
                .add(ModRegistry.ANCIENT_CRACKED_STONE_BRICKS.get());
        tag(TagRegistry.ANCIENT_CHISELED_STONE_BRICKS)
                .add(ModRegistry.ANCIENT_CHISELED_STONE_BRICKS.get());

        tag(net.minecraft.tags.BlockTags.LOGS)
                .add(ModRegistry.DEMONIC_LOG.get());
        tag(net.minecraft.tags.BlockTags.PLANKS)
                .add(ModRegistry.DEMONIC_PLANKS.get());
        tag(net.minecraft.tags.BlockTags.LOGS).add(ModRegistry.SOUL_LOG.get());
        tag(net.minecraft.tags.BlockTags.LOGS)
                .add(ModRegistry.SOUL_LOG_0.get());
        tag(net.minecraft.tags.BlockTags.LOGS)
                .add(ModRegistry.SOUL_LOG_1.get());
        tag(net.minecraft.tags.BlockTags.LOGS)
                .add(ModRegistry.SOUL_LOG_2.get());
        tag(net.minecraft.tags.BlockTags.PLANKS)
                .add(ModRegistry.SOUL_PLANKS.get());
        tag(net.minecraft.tags.BlockTags.LOGS)
                .add(ModRegistry.ANCIENT_LOG_0.get());
        tag(net.minecraft.tags.BlockTags.LOGS)
                .add(ModRegistry.ANCIENT_LOG_1.get());
        tag(net.minecraft.tags.BlockTags.LOGS)
                .add(ModRegistry.ANCIENT_LOG_2.get());
        tag(net.minecraft.tags.BlockTags.PLANKS)
                .add(ModRegistry.ANCIENT_PLANKS.get());

        tag(net.minecraft.tags.BlockTags.CLIMBABLE)
                .add(ModRegistry.ANCIENT_CAVEVINES_.get());
        tag(net.minecraft.tags.BlockTags.CLIMBABLE)
                .add(ModRegistry.ANCIENT_CAVEVINES_PLANT_.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModRegistry.ANCIENT_STONE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModRegistry.ANCIENT_DIRT.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModRegistry.ANCIENT_GRASS.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModRegistry.ANCIENT_MOSSY_STONE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModRegistry.ANCIENT_POLISHED_STONE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModRegistry.ANCIENT_SMOOTH_STONE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModRegistry.ANCIENT_STONE_BRICKS.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModRegistry.ANCIENT_CRACKED_STONE_BRICKS.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModRegistry.ANCIENT_CHISELED_STONE_BRICKS.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE)
                .add(ModRegistry.ANCIENT_PLANKS.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE)
                .add(ModRegistry.ANCIENT_LOG_0.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE)
                .add(ModRegistry.ANCIENT_LOG_1.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE)
                .add(ModRegistry.ANCIENT_LOG_2.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE)
                .add(ModRegistry.ANCIENT_LOG_STRIPPED.get());

        tag(NEEDS_NETHERITE_TOOL).add(ModRegistry.ALLTHEMODIUM_ORE.get());
        tag(NEEDS_NETHERITE_TOOL).add(ModRegistry.ALLTHEMODIUM_SLATE_ORE.get());
        tag(TagRegistry.NEEDS_ALLTHEMODIUM_TOOL)
                .add(ModRegistry.VIBRANIUM_ORE.get());
        tag(TagRegistry.NEEDS_ALLTHEMODIUM_TOOL)
                .add(ModRegistry.OTHER_VIBRANIUM_ORE.get());
        tag(TagRegistry.NEEDS_ALLTHEMODIUM_TOOL)
                .add(ModRegistry.UNOBTAINIUM_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE)
                .add(ModRegistry.DEMONIC_PLANKS.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE)
                .add(ModRegistry.DEMONIC_LOG.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE)
                .add(ModRegistry.DEMONIC_LOG_STRIPPED.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE)
                .add(ModRegistry.SOUL_PLANKS.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE)
                .add(ModRegistry.SOUL_LOG.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE)
                .add(ModRegistry.SOUL_LOG_0.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE)
                .add(ModRegistry.SOUL_LOG_1.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE)
                .add(ModRegistry.SOUL_LOG_2.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE)
                .add(ModRegistry.SOUL_LOG_STRIPPED.get());

        tag(net.minecraft.tags.BlockTags.NYLIUM)
                .add(ModRegistry.ANCIENT_STONE.get());
        tag(net.minecraft.tags.BlockTags.INFINIBURN_NETHER)
                .add(ModRegistry.ANCIENT_STONE.get());
        tag(net.minecraft.tags.BlockTags.INFINIBURN_NETHER)
                .add(ModRegistry.ANCIENT_GRASS.get());
        tag(net.minecraft.tags.BlockTags.INFINIBURN_NETHER)
                .add(ModRegistry.ANCIENT_DIRT.get());
        tag(net.minecraft.tags.BlockTags.BEE_GROWABLES)
                .add(ModRegistry.ANCIENT_SAPLING.get());
        tag(net.minecraft.tags.BlockTags.DIRT)
                .add(ModRegistry.ANCIENT_GRASS.get());
        tag(net.minecraft.tags.BlockTags.DIRT)
                .add(ModRegistry.ANCIENT_DIRT.get());
        tag(net.minecraft.tags.BlockTags.SAPLINGS)
                .add(ModRegistry.ANCIENT_SAPLING.get());

        tag(net.minecraft.tags.BlockTags.WOODEN_FENCES)
                .add(ModRegistry.ANCIENT_WOOD_FENCE.get());
        tag(net.minecraft.tags.BlockTags.FENCES)
                .add(ModRegistry.ANCIENT_WOOD_FENCE.get());
        tag(net.minecraft.tags.BlockTags.FENCE_GATES)
                .add(ModRegistry.ANCIENT_WOOD_FENCE_GATE.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_FENCES)
                .add(ModRegistry.DEMONIC_WOOD_FENCE.get());
        tag(net.minecraft.tags.BlockTags.FENCES)
                .add(ModRegistry.DEMONIC_WOOD_FENCE.get());
        tag(net.minecraft.tags.BlockTags.FENCE_GATES)
                .add(ModRegistry.DEMONIC_WOOD_FENCE_GATE.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_FENCES)
                .add(ModRegistry.SOUL_WOOD_FENCE.get());
        tag(net.minecraft.tags.BlockTags.FENCES)
                .add(ModRegistry.SOUL_WOOD_FENCE.get());
        tag(net.minecraft.tags.BlockTags.FENCE_GATES)
                .add(ModRegistry.SOUL_WOOD_FENCE_GATE.get());

        tag(net.minecraft.tags.BlockTags.WALLS)
                .add(ModRegistry.ANCIENT_WOOD_FENCE.get());
        tag(net.minecraft.tags.BlockTags.WALLS)
                .add(ModRegistry.DEMONIC_WOOD_FENCE.get());
        tag(net.minecraft.tags.BlockTags.WALLS)
                .add(ModRegistry.SOUL_WOOD_FENCE.get());
        tag(net.minecraft.tags.BlockTags.WALLS)
                .add(ModRegistry.ANCIENT_STONE_WALL.get());
        tag(net.minecraft.tags.BlockTags.WALLS)
                .add(ModRegistry.ANCIENT_POLISHED_STONE_WALL.get());
        tag(net.minecraft.tags.BlockTags.WALLS)
                .add(ModRegistry.ANCIENT_MOSSY_STONE_WALL.get());
        tag(net.minecraft.tags.BlockTags.WALLS)
                .add(ModRegistry.ANCIENT_CRACKED_STONE_BRICK_WALL.get());
        tag(net.minecraft.tags.BlockTags.WALLS)
                .add(ModRegistry.ANCIENT_CHISELED_STONE_BRICK_WALL.get());
        tag(net.minecraft.tags.BlockTags.WALLS)
                .add(ModRegistry.ANCIENT_STONE_BRICK_WALL.get());

        tag(net.minecraft.tags.BlockTags.SLABS)
                .add(ModRegistry.ANCIENT_WOODEN_SLABS.get());
        tag(net.minecraft.tags.BlockTags.SLABS)
                .add(ModRegistry.DEMONIC_WOODEN_SLABS.get());
        tag(net.minecraft.tags.BlockTags.SLABS)
                .add(ModRegistry.SOUL_WOODEN_SLABS.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_SLABS)
                .add(ModRegistry.ANCIENT_WOODEN_SLABS.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_SLABS)
                .add(ModRegistry.DEMONIC_WOODEN_SLABS.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_SLABS)
                .add(ModRegistry.SOUL_WOODEN_SLABS.get());
        tag(net.minecraft.tags.BlockTags.SLABS)
                .add(ModRegistry.ANCIENT_STONE_SLABS.get());
        tag(net.minecraft.tags.BlockTags.SLABS)
                .add(ModRegistry.ANCIENT_POLISHED_STONE_SLABS.get());
        tag(net.minecraft.tags.BlockTags.SLABS)
                .add(ModRegistry.ANCIENT_MOSSY_STONE_SLABS.get());
        tag(net.minecraft.tags.BlockTags.SLABS)
                .add(ModRegistry.ANCIENT_CRACKED_STONE_SLABS.get());
        tag(net.minecraft.tags.BlockTags.SLABS)
                .add(ModRegistry.ANCIENT_CHISELED_STONE_SLABS.get());
        tag(net.minecraft.tags.BlockTags.SLABS)
                .add(ModRegistry.ANCIENT_STONE_BRICK_SLABS.get());

        tag(net.minecraft.tags.BlockTags.WOODEN_FENCES)
                .add(ModRegistry.ANCIENT_STONE_WALL.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_FENCES)
                .add(ModRegistry.ANCIENT_POLISHED_STONE_WALL.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_FENCES)
                .add(ModRegistry.ANCIENT_MOSSY_STONE_WALL.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_FENCES)
                .add(ModRegistry.ANCIENT_CRACKED_STONE_BRICK_WALL.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_FENCES)
                .add(ModRegistry.ANCIENT_CHISELED_STONE_BRICK_WALL.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_FENCES)
                .add(ModRegistry.ANCIENT_STONE_BRICK_WALL.get());

        tag(net.minecraft.tags.BlockTags.STAIRS)
                .add(ModRegistry.ANCIENT_WOODEN_STAIRS.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_STAIRS)
                .add(ModRegistry.ANCIENT_WOODEN_STAIRS.get());
        tag(net.minecraft.tags.BlockTags.STAIRS)
                .add(ModRegistry.DEMONIC_WOODEN_STAIRS.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_STAIRS)
                .add(ModRegistry.DEMONIC_WOODEN_STAIRS.get());
        tag(net.minecraft.tags.BlockTags.STAIRS)
                .add(ModRegistry.SOUL_WOODEN_STAIRS.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_STAIRS)
                .add(ModRegistry.SOUL_WOODEN_STAIRS.get());
        tag(net.minecraft.tags.BlockTags.STAIRS)
                .add(ModRegistry.ANCIENT_STONE_STAIRS.get());
        tag(net.minecraft.tags.BlockTags.STAIRS)
                .add(ModRegistry.ANCIENT_POLISHED_STONE_STAIRS.get());
        tag(net.minecraft.tags.BlockTags.STAIRS)
                .add(ModRegistry.ANCIENT_MOSSY_STONE_STAIRS.get());
        tag(net.minecraft.tags.BlockTags.STAIRS)
                .add(ModRegistry.ANCIENT_CRACKED_STONE_STAIRS.get());
        tag(net.minecraft.tags.BlockTags.STAIRS)
                .add(ModRegistry.ANCIENT_CHISELED_STONE_STAIRS.get());
        tag(net.minecraft.tags.BlockTags.STAIRS)
                .add(ModRegistry.ANCIENT_STONE_BRICK_STAIRS.get());

        tag(net.minecraft.tags.BlockTags.LEAVES)
                .add(ModRegistry.ANCIENT_LEAVES.get());
        tag(net.minecraft.tags.BlockTags.LEAVES)
                .add(ModRegistry.SOUL_LEAVES.get());
        tag(net.minecraft.tags.BlockTags.LEAVES)
                .add(ModRegistry.DEMONIC_LEAVES.get());

        tag(TagRegistry.ALLTHEMODIUM_BLOCK)
                .add(ModRegistry.ALLTHEMODIUM_BLOCK.get());
        tag(TagRegistry.ALLTHEMODIUM_ORE)
                .add(ModRegistry.ALLTHEMODIUM_ORE.get());
        tag(TagRegistry.ALLTHEMODIUM_ORE)
                .add(ModRegistry.ALLTHEMODIUM_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModRegistry.RAW_ALLTHEMODIUM_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModRegistry.ALLTHEMODIUM_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModRegistry.ALLTHEMODIUM_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModRegistry.ALLTHEMODIUM_SLATE_ORE.get());
        tag(TagRegistry.VIBRANIUM_BLOCK).add(ModRegistry.VIBRANIUM_BLOCK.get());
        tag(TagRegistry.VIBRANIUM_ORE).add(ModRegistry.VIBRANIUM_ORE.get());
        tag(TagRegistry.VIBRANIUM_ORE)
                .add(ModRegistry.OTHER_VIBRANIUM_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModRegistry.VIBRANIUM_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModRegistry.RAW_VIBRANIUM_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModRegistry.VIBRANIUM_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModRegistry.OTHER_VIBRANIUM_ORE.get());
        tag(TagRegistry.UNOBTAINIUM_BLOCK)
                .add(ModRegistry.UNOBTAINIUM_BLOCK.get());
        tag(TagRegistry.UNOBTAINIUM_ORE).add(ModRegistry.UNOBTAINIUM_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModRegistry.UNOBTAINIUM_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModRegistry.RAW_UNOBTAINIUM_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModRegistry.UNOBTAINIUM_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModRegistry.UV_ALLOY.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModRegistry.UA_ALLOY.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModRegistry.VA_ALLOY.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModRegistry.TELEPORT_PAD.get());

        ModRegistry.BLOCKS
                .getEntries()
                .stream()
                .forEach(blockRegistryObject -> {
                    tag(TagRegistry.OTHER_PROTECTION)
                            .add(blockRegistryObject.get());
                });
        ModRegistry.SHAPED_BLOCKS
                .getEntries()
                .stream()
                .forEach(blockRegistryObject -> {
                    tag(TagRegistry.OTHER_PROTECTION)
                            .add(blockRegistryObject.get());
                });
        ModRegistry.STAIR_BLOCKS
                .getEntries()
                .stream()
                .forEach(blockRegistryObject -> {
                    tag(TagRegistry.OTHER_PROTECTION)
                            .add(blockRegistryObject.get());
                });
        ModRegistry.SLAB_BLOCKS
                .getEntries()
                .stream()
                .forEach(blockRegistryObject -> {
                    tag(TagRegistry.OTHER_PROTECTION)
                            .add(blockRegistryObject.get());
                });
        ModRegistry.WALL_BLOCKS
                .getEntries()
                .stream()
                .forEach(blockRegistryObject -> {
                    tag(TagRegistry.OTHER_PROTECTION)
                            .add(blockRegistryObject.get());
                });
        ModRegistry.PILLAR_BLOCKS
                .getEntries()
                .stream()
                .forEach(blockRegistryObject -> {
                    tag(TagRegistry.OTHER_PROTECTION)
                            .add(blockRegistryObject.get());
                });
        tag(TagRegistry.OTHER_PROTECTION).add(Blocks.SAND);
        tag(TagRegistry.OTHER_PROTECTION).add(Blocks.SANDSTONE);
        tag(TagRegistry.OTHER_PROTECTION).add(Blocks.CRIMSON_NYLIUM);
        tag(TagRegistry.OTHER_PROTECTION).add(Blocks.WARPED_NYLIUM);
        tag(TagRegistry.OTHER_PROTECTION).add(Blocks.NETHERRACK);
        tag(TagRegistry.OTHER_PROTECTION).add(Blocks.SOUL_SAND);
        tag(TagRegistry.OTHER_PROTECTION).add(Blocks.SOUL_SOIL);
        tag(TagRegistry.OTHER_PROTECTION).add(Blocks.DEEPSLATE);

        tag(TagRegistry.OTHER_PROTECTION)
                .add(BlockList.OTHER_ALUMINUM_ORE.get());
        tag(TagRegistry.OTHER_PROTECTION).add(BlockList.OTHER_COAL_ORE.get());
        tag(TagRegistry.OTHER_PROTECTION).add(BlockList.OTHER_COPPER_ORE.get());
        tag(TagRegistry.OTHER_PROTECTION)
                .add(BlockList.OTHER_DIAMOND_ORE.get());
        tag(TagRegistry.OTHER_PROTECTION).add(BlockList.OTHER_LEAD_ORE.get());
        tag(TagRegistry.OTHER_PROTECTION).add(BlockList.OTHER_NICKEL_ORE.get());
        tag(TagRegistry.OTHER_PROTECTION)
                .add(BlockList.OTHER_IRIDIUM_ORE.get());
        tag(TagRegistry.OTHER_PROTECTION).add(BlockList.OTHER_LAPIS_ORE.get());
        tag(TagRegistry.OTHER_PROTECTION)
                .add(BlockList.OTHER_PLATINUM_ORE.get());
        tag(TagRegistry.OTHER_PROTECTION).add(BlockList.OTHER_SILVER_ORE.get());
        tag(TagRegistry.OTHER_PROTECTION).add(BlockList.OTHER_OSMIUM_ORE.get());
        tag(TagRegistry.OTHER_PROTECTION)
                .add(BlockList.OTHER_URANIUM_ORE.get());
        tag(TagRegistry.OTHER_PROTECTION).add(BlockList.OTHER_ZINC_ORE.get());
        tag(TagRegistry.OTHER_PROTECTION).add(BlockList.OTHER_TIN_ORE.get());
        tag(TagRegistry.OTHER_PROTECTION).add(BlockList.OTHER_IRON_ORE.get());
        tag(TagRegistry.OTHER_PROTECTION)
                .add(BlockList.OTHER_REDSTONE_ORE.get());
        tag(TagRegistry.OTHER_PROTECTION).add(BlockList.OTHER_GOLD_ORE.get());
        tag(TagRegistry.OTHER_PROTECTION).add(BlockList.OTHER_QUARTZ_ORE.get());
        tag(TagRegistry.OTHER_PROTECTION)
                .add(BlockList.OTHER_EMERALD_ORE.get());

        tag(TagRegistry.OTHER_PROTECTION)
                .add(BlockList.ALUMINUM_SLATE_ORE.get());
        tag(TagRegistry.OTHER_PROTECTION).add(BlockList.LEAD_SLATE_ORE.get());
        tag(TagRegistry.OTHER_PROTECTION).add(BlockList.NICKEL_SLATE_ORE.get());
        tag(TagRegistry.OTHER_PROTECTION).add(BlockList.OSMIUM_SLATE_ORE.get());
        tag(TagRegistry.OTHER_PROTECTION)
                .add(BlockList.PLATINUM_SLATE_ORE.get());
        tag(TagRegistry.OTHER_PROTECTION).add(BlockList.SILVER_SLATE_ORE.get());
        tag(TagRegistry.OTHER_PROTECTION).add(BlockList.TIN_SLATE_ORE.get());
        tag(TagRegistry.OTHER_PROTECTION)
                .add(BlockList.URANIUM_SLATE_ORE.get());
        tag(TagRegistry.OTHER_PROTECTION).add(BlockList.ZINC_SLATE_ORE.get());

        tag(TagRegistry.OTHER_PROTECTION)
                .add(BlockList.IRIDIUM_SLATE_ORE.get());

        tag(TagRegistry.OTHER_PROTECTION)
                .add(BlockList.RAW_ALUMINUM_BLOCK.get());
        tag(TagRegistry.OTHER_PROTECTION).add(BlockList.RAW_LEAD_BLOCK.get());
        tag(TagRegistry.OTHER_PROTECTION).add(BlockList.RAW_NICKEL_BLOCK.get());
        tag(TagRegistry.OTHER_PROTECTION).add(BlockList.RAW_OSMIUM_BLOCK.get());
        tag(TagRegistry.OTHER_PROTECTION)
                .add(BlockList.RAW_PLATINUM_BLOCK.get());
        tag(TagRegistry.OTHER_PROTECTION).add(BlockList.RAW_SILVER_BLOCK.get());
        tag(TagRegistry.OTHER_PROTECTION).add(BlockList.RAW_TIN_BLOCK.get());
        tag(TagRegistry.OTHER_PROTECTION)
                .add(BlockList.RAW_URANIUM_BLOCK.get());
        tag(TagRegistry.OTHER_PROTECTION).add(BlockList.RAW_ZINC_BLOCK.get());

        tag(TagRegistry.OTHER_PROTECTION)
                .add(BlockList.RAW_IRIDIUM_BLOCK.get());

        tag(TagRegistry.OTHER_PROTECTION).add(Blocks.NETHERITE_BLOCK);
        tag(TagRegistry.OTHER_PROTECTION).add(Blocks.DIAMOND_BLOCK);
        tag(TagRegistry.OTHER_PROTECTION).add(Blocks.AMETHYST_BLOCK);
        tag(TagRegistry.OTHER_PROTECTION).add(Blocks.AMETHYST_CLUSTER);
        tag(TagRegistry.OTHER_PROTECTION).add(Blocks.GOLD_BLOCK);

        tag(TagRegistry.OTHER_PROTECTION).addTag(TagRegistry.BLOCK_ORES);
    }
}
