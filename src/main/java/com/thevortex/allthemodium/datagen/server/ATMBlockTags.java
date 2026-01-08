package com.thevortex.allthemodium.datagen.server;


import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.ModRegistry;
import com.thevortex.allthemodium.registry.TagRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;


public class ATMBlockTags extends BlockTagsProvider {

    public ATMBlockTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput,lookupProvider, Reference.MOD_ID, existingFileHelper);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
            .add(ModRegistry.ALLTHEMODIUM_ORE.get())
            .add(ModRegistry.ALLTHEMODIUM_SLATE_ORE.get())
            .add(ModRegistry.RAW_ALLTHEMODIUM_BLOCK.get())
            .add(ModRegistry.ALLTHEMODIUM_BLOCK.get());

        tag(TagRegistry.NEEDS_ALLTHEMODIUM_TOOL)
            .add(ModRegistry.VIBRANIUM_ORE.get())
            .add(ModRegistry.OTHER_VIBRANIUM_ORE.get())
            .add(ModRegistry.RAW_VIBRANIUM_BLOCK.get())
            .add(ModRegistry.VIBRANIUM_BLOCK.get());

        tag(TagRegistry.NEEDS_VIBRANIUM_TOOL)
            .add(ModRegistry.UNOBTAINIUM_ORE.get())
            .add(ModRegistry.RAW_UNOBTAINIUM_BLOCK.get())
            .add(ModRegistry.UNOBTAINIUM_BLOCK.get())
        ;

        tag(TagRegistry.NEEDS_UNOBTAINIUM_TOOL)
            .add(ModRegistry.ANCIENT_STONE_BRICKS.get())
            .add(ModRegistry.ANCIENT_CHISELED_STONE_BRICK_WALL.get())
            .add(ModRegistry.ANCIENT_CHISELED_STONE_BRICKS.get())
            .add(ModRegistry.ANCIENT_CHISELED_STONE_SLABS.get())
            .add(ModRegistry.ANCIENT_CHISELED_STONE_STAIRS.get())
            .add(ModRegistry.ANCIENT_POLISHED_STONE.get())
            .add(ModRegistry.ANCIENT_POLISHED_STONE_WALL.get())
            .add(ModRegistry.ANCIENT_POLISHED_STONE_SLABS.get())
            .add(ModRegistry.ANCIENT_POLISHED_STONE_STAIRS.get())
            .add(ModRegistry.ANCIENT_CRACKED_STONE_BRICK_WALL.get())
            .add(ModRegistry.ANCIENT_CRACKED_STONE_BRICKS.get())
            .add(ModRegistry.ANCIENT_CRACKED_STONE_SLABS.get())
            .add(ModRegistry.ANCIENT_CRACKED_STONE_STAIRS.get())
            .add(ModRegistry.ANCIENT_SMOOTH_STONE_WALL.get())
            .add(ModRegistry.ANCIENT_SMOOTH_STONE.get())
            .add(ModRegistry.ANCIENT_SMOOTH_STONE_STAIRS.get())
            .add(ModRegistry.ANCIENT_SMOOTH_STONE_SLABS.get())
            .add(ModRegistry.UV_ALLOY.get())
            .add(ModRegistry.VA_ALLOY.get())
            .add(ModRegistry.UA_ALLOY.get());

        // Nothing exclusively needs it yet?
        tag(TagRegistry.NEEDS_ALLOY_TOOL);

        // Update vanilla tiers
        List<TagKey<Block>> vanillaTiers = List.of(BlockTags.INCORRECT_FOR_WOODEN_TOOL,BlockTags.INCORRECT_FOR_STONE_TOOL,BlockTags.INCORRECT_FOR_IRON_TOOL,BlockTags.INCORRECT_FOR_GOLD_TOOL,BlockTags.INCORRECT_FOR_DIAMOND_TOOL,BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
        vanillaTiers.forEach(tag -> {
            tag(tag)
                .addTags(
                    TagRegistry.NEEDS_ALLTHEMODIUM_TOOL,
                    TagRegistry.NEEDS_VIBRANIUM_TOOL,
                    TagRegistry.NEEDS_UNOBTAINIUM_TOOL,
                    TagRegistry.NEEDS_ALLOY_TOOL
                );
        });

        // Mystical Agiculture up to tier 4
        List<TagKey<Block>> maTiers = Stream.of("incorrect_for_inferium_tool","incorrect_for_prudentium_tool","incorrect_for_tertium_tool","incorrect_for_imperium_tool").map(path -> TagKey.create(Registries.BLOCK,ResourceLocation.fromNamespaceAndPath("mysticalagriculture",path))).toList();
        maTiers.forEach(tag -> {
            tag(tag)
                .addTags(
                    Tags.Blocks.NEEDS_NETHERITE_TOOL,
                    TagRegistry.NEEDS_ALLTHEMODIUM_TOOL,
                    TagRegistry.NEEDS_VIBRANIUM_TOOL,
                    TagRegistry.NEEDS_UNOBTAINIUM_TOOL,
                    TagRegistry.NEEDS_ALLOY_TOOL
                );
        });

        // Update our own tiers
        tag(TagRegistry.INCORRECT_FOR_ALLTHEMODIUM_TOOL)
            .addTags(
                TagRegistry.NEEDS_VIBRANIUM_TOOL,
                TagRegistry.NEEDS_UNOBTAINIUM_TOOL,
                TagRegistry.NEEDS_ALLOY_TOOL
            );

        tag(TagRegistry.INCORRECT_FOR_VIBRANIUM_TOOL)
            .addTags(
                TagRegistry.NEEDS_UNOBTAINIUM_TOOL,
                TagRegistry.NEEDS_ALLOY_TOOL
            );

        tag(TagRegistry.INCORRECT_FOR_UNOBTAINIUM_TOOL)
            .addTags(
                TagRegistry.NEEDS_ALLOY_TOOL
            );

        tag(TagRegistry.INCORRECT_FOR_ALLOY_TOOL);

        tag(TagRegistry.OTHER_TILE_WHITELIST).add(Blocks.FURNACE);
        tag(TagRegistry.OTHER_TILE_WHITELIST).add(Blocks.BLAST_FURNACE);
        tag(TagRegistry.OTHER_TILE_WHITELIST).add(Blocks.BREWING_STAND);
        tag(TagRegistry.OTHER_TILE_WHITELIST).add(Blocks.BARREL);
        tag(TagRegistry.OTHER_TILE_WHITELIST).add(Blocks.CHEST);
        tag(TagRegistry.OTHER_TILE_WHITELIST).add(Blocks.CAMPFIRE);
        tag(TagRegistry.OTHER_TILE_WHITELIST).add(Blocks.SOUL_CAMPFIRE);

        tag(TagRegistry.PAXEL_TARGETS).addTag(BlockTags.MINEABLE_WITH_PICKAXE);
        tag(TagRegistry.PAXEL_TARGETS).addTag(BlockTags.MINEABLE_WITH_AXE);
        tag(TagRegistry.PAXEL_TARGETS).addTag(BlockTags.MINEABLE_WITH_SHOVEL);
        tag(TagRegistry.PAXEL_TARGETS).addTag(BlockTags.MINEABLE_WITH_HOE);

        tag(BlockTags.SOUL_FIRE_BASE_BLOCKS).add(ModRegistry.ANCIENT_DIRT.get());
        tag(BlockTags.SOUL_FIRE_BASE_BLOCKS).add(ModRegistry.ANCIENT_GRASS.get());
        tag(BlockTags.SOUL_FIRE_BASE_BLOCKS).add(ModRegistry.ANCIENT_LOG_0.get());
        tag(BlockTags.SOUL_FIRE_BASE_BLOCKS).add(ModRegistry.ANCIENT_LOG_1.get());
        tag(BlockTags.SOUL_FIRE_BASE_BLOCKS).add(ModRegistry.ANCIENT_LOG_2.get());
        tag(TagRegistry.ANCIENT_WOODEN_PLANKS).add(ModRegistry.ANCIENT_PLANKS.get());
        tag(TagRegistry.DEMONIC_WOODEN_PLANKS).add(ModRegistry.DEMONIC_PLANKS.get());
        tag(TagRegistry.SOUL_WOODEN_PLANKS).add(ModRegistry.SOUL_PLANKS.get());
        tag(TagRegistry.ANCIENT_STONE).add(ModRegistry.ANCIENT_STONE.get());
        tag(TagRegistry.ANCIENT_DIRT).add(ModRegistry.ANCIENT_DIRT.get());
        tag(TagRegistry.ANCIENT_MOSSY_STONE).add(ModRegistry.ANCIENT_MOSSY_STONE.get());
        tag(TagRegistry.ANCIENT_POLISHED_STONE).add(ModRegistry.ANCIENT_POLISHED_STONE.get());
        tag(TagRegistry.ANCIENT_SMOOTH_STONE).add(ModRegistry.ANCIENT_SMOOTH_STONE.get());
        tag(TagRegistry.ANCIENT_STONE_BRICKS).add(ModRegistry.ANCIENT_STONE_BRICKS.get());
        tag(TagRegistry.ANCIENT_CRACKED_STONE_BRICKS).add(ModRegistry.ANCIENT_CRACKED_STONE_BRICKS.get());
        tag(TagRegistry.ANCIENT_CHISELED_STONE_BRICKS).add(ModRegistry.ANCIENT_CHISELED_STONE_BRICKS.get());

        tag(BlockTags.PLANKS)
                .add(ModRegistry.DEMONIC_PLANKS.get())
                .add(ModRegistry.SOUL_PLANKS.get())
                .add(ModRegistry.ANCIENT_PLANKS.get());
        tag(BlockTags.LOGS)
                .add(ModRegistry.DEMONIC_LOG.get())
                .add(ModRegistry.SOUL_LOG.get())
                .add(ModRegistry.SOUL_LOG_0.get())
                .add(ModRegistry.SOUL_LOG_1.get())
                .add(ModRegistry.SOUL_LOG_2.get())
                .add(ModRegistry.ANCIENT_LOG_0.get())
                .add(ModRegistry.ANCIENT_LOG_1.get())
                .add(ModRegistry.ANCIENT_LOG_2.get());

        tag(BlockTags.CLIMBABLE).add(ModRegistry.ANCIENT_CAVEVINES.get());
        tag(BlockTags.CLIMBABLE).add(ModRegistry.ANCIENT_CAVEVINES_PLANT.get());
        
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModRegistry.ANCIENT_STONE.get());
        tag(BlockTags.MINEABLE_WITH_SHOVEL).add(ModRegistry.ANCIENT_DIRT.get(), ModRegistry.ANCIENT_GRASS.get(), ModRegistry.ANCIENT_PODZOL.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModRegistry.ANCIENT_MOSSY_STONE.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModRegistry.ANCIENT_POLISHED_STONE.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModRegistry.ANCIENT_SMOOTH_STONE.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModRegistry.ANCIENT_STONE_BRICKS.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModRegistry.ANCIENT_CRACKED_STONE_BRICKS.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModRegistry.ANCIENT_CHISELED_STONE_BRICKS.get());

        tag(BlockTags.MINEABLE_WITH_AXE).add(ModRegistry.ANCIENT_PLANKS.get());
        tag(BlockTags.MINEABLE_WITH_AXE).add(ModRegistry.ANCIENT_LOG_0.get());
        tag(BlockTags.MINEABLE_WITH_AXE).add(ModRegistry.ANCIENT_LOG_1.get());
        tag(BlockTags.MINEABLE_WITH_AXE).add(ModRegistry.ANCIENT_LOG_2.get());
        tag(BlockTags.MINEABLE_WITH_AXE).add(ModRegistry.ANCIENT_LOG_STRIPPED.get());

        tag(BlockTags.MINEABLE_WITH_AXE).add(ModRegistry.DEMONIC_PLANKS.get());
        tag(BlockTags.MINEABLE_WITH_AXE).add(ModRegistry.DEMONIC_LOG.get());
        tag(BlockTags.MINEABLE_WITH_AXE).add(ModRegistry.DEMONIC_LOG_STRIPPED.get());

        tag(BlockTags.MINEABLE_WITH_AXE).add(ModRegistry.SOUL_PLANKS.get());
        tag(BlockTags.MINEABLE_WITH_AXE).add(ModRegistry.SOUL_LOG.get());
        tag(BlockTags.MINEABLE_WITH_AXE).add(ModRegistry.SOUL_LOG_0.get());
        tag(BlockTags.MINEABLE_WITH_AXE).add(ModRegistry.SOUL_LOG_1.get());
        tag(BlockTags.MINEABLE_WITH_AXE).add(ModRegistry.SOUL_LOG_2.get());
        tag(BlockTags.MINEABLE_WITH_AXE).add(ModRegistry.SOUL_LOG_STRIPPED.get());

        tag(BlockTags.NYLIUM).add(ModRegistry.ANCIENT_STONE.get());
        tag(BlockTags.INFINIBURN_NETHER)
                .add(ModRegistry.ANCIENT_STONE.get())
                .add(ModRegistry.ANCIENT_GRASS.get())
                .add(ModRegistry.ANCIENT_DIRT.get());

        tag(BlockTags.DIRT)
                .add(ModRegistry.ANCIENT_GRASS.get())
                .add(ModRegistry.ANCIENT_DIRT.get())
                .add(ModRegistry.ANCIENT_PODZOL.get());

        tag(BlockTags.WOODEN_FENCES)
                .add(ModRegistry.ANCIENT_WOOD_FENCE.get())
                .add(ModRegistry.DEMONIC_WOOD_FENCE.get())
                .add(ModRegistry.SOUL_WOOD_FENCE.get());
        tag(BlockTags.FENCE_GATES)
                .add(ModRegistry.ANCIENT_WOOD_FENCE_GATE.get())
                .add(ModRegistry.DEMONIC_WOOD_FENCE_GATE.get())
                .add(ModRegistry.SOUL_WOOD_FENCE_GATE.get());

        tag(BlockTags.WALLS)
                .add(ModRegistry.ANCIENT_STONE_WALL.get())
                .add(ModRegistry.ANCIENT_POLISHED_STONE_WALL.get())
                .add(ModRegistry.ANCIENT_MOSSY_STONE_WALL.get())
                .add(ModRegistry.ANCIENT_CRACKED_STONE_BRICK_WALL.get())
                .add(ModRegistry.ANCIENT_CHISELED_STONE_BRICK_WALL.get())
                .add(ModRegistry.ANCIENT_STONE_BRICK_WALL.get());

        tag(BlockTags.WOODEN_SLABS)
                .add(ModRegistry.ANCIENT_WOODEN_SLABS.get())
                .add(ModRegistry.DEMONIC_WOODEN_SLABS.get())
                .add(ModRegistry.SOUL_WOODEN_SLABS.get());
        tag(BlockTags.SLABS)
                .add(ModRegistry.ANCIENT_STONE_SLABS.get())
                .add(ModRegistry.ANCIENT_POLISHED_STONE_SLABS.get())
                .add(ModRegistry.ANCIENT_MOSSY_STONE_SLABS.get())
                .add(ModRegistry.ANCIENT_CRACKED_STONE_SLABS.get())
                .add(ModRegistry.ANCIENT_CHISELED_STONE_SLABS.get())
                .add(ModRegistry.ANCIENT_STONE_BRICK_SLABS.get());

        tag(BlockTags.WOODEN_STAIRS)
                .add(ModRegistry.ANCIENT_WOODEN_STAIRS.get())
                .add(ModRegistry.DEMONIC_WOODEN_STAIRS.get())
                .add(ModRegistry.SOUL_WOODEN_STAIRS.get());
        tag(BlockTags.STAIRS)
                .add(ModRegistry.ANCIENT_STONE_STAIRS.get())
                .add(ModRegistry.ANCIENT_POLISHED_STONE_STAIRS.get())
                .add(ModRegistry.ANCIENT_MOSSY_STONE_STAIRS.get())
                .add(ModRegistry.ANCIENT_CRACKED_STONE_STAIRS.get())
                .add(ModRegistry.ANCIENT_CHISELED_STONE_STAIRS.get())
                .add(ModRegistry.ANCIENT_STONE_BRICK_STAIRS.get());

        tag(BlockTags.LEAVES)
                .add(ModRegistry.ANCIENT_LEAVES.get())
                .add(ModRegistry.SOUL_LEAVES.get())
                .add(ModRegistry.DEMONIC_LEAVES.get());

        tag(TagRegistry.ALLTHEMODIUM_BLOCK).add(ModRegistry.ALLTHEMODIUM_BLOCK.get());
        tag(TagRegistry.VIBRANIUM_BLOCK).add(ModRegistry.VIBRANIUM_BLOCK.get());
        tag(TagRegistry.UNOBTAINIUM_BLOCK).add(ModRegistry.UNOBTAINIUM_BLOCK.get());

        tag(TagRegistry.ALLTHEMODIUM_ORE).add(ModRegistry.ALLTHEMODIUM_ORE.get());
        tag(TagRegistry.ALLTHEMODIUM_ORE).add(ModRegistry.ALLTHEMODIUM_SLATE_ORE.get());
        tag(TagRegistry.VIBRANIUM_ORE).add(ModRegistry.VIBRANIUM_ORE.get());
        tag(TagRegistry.VIBRANIUM_ORE).add(ModRegistry.OTHER_VIBRANIUM_ORE.get());
        tag(TagRegistry.UNOBTAINIUM_ORE).add(ModRegistry.UNOBTAINIUM_ORE.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModRegistry.RAW_ALLTHEMODIUM_BLOCK.get())
                .add(ModRegistry.ALLTHEMODIUM_BLOCK.get())
                .add(ModRegistry.ALLTHEMODIUM_ORE.get())
                .add(ModRegistry.ALLTHEMODIUM_SLATE_ORE.get())
                .add(ModRegistry.VIBRANIUM_BLOCK.get())
                .add(ModRegistry.RAW_VIBRANIUM_BLOCK.get())
                .add(ModRegistry.VIBRANIUM_ORE.get())
                .add(ModRegistry.OTHER_VIBRANIUM_ORE.get())
                .add(ModRegistry.UNOBTAINIUM_BLOCK.get())
                .add(ModRegistry.RAW_UNOBTAINIUM_BLOCK.get())
                .add(ModRegistry.UNOBTAINIUM_ORE.get())
                .add(ModRegistry.UV_ALLOY.get())
                .add(ModRegistry.UA_ALLOY.get())
                .add(ModRegistry.VA_ALLOY.get())
                .add(ModRegistry.TELEPORT_PAD.get());


        ModRegistry.BLOCKS.getEntries().stream()
                .forEach(blockRegistryObject -> {
                    tag(TagRegistry.OTHER_PROTECTION).add(blockRegistryObject.get());
                });
        ModRegistry.SHAPED_BLOCKS.getEntries().stream()
                .forEach(blockRegistryObject -> {
                    tag(TagRegistry.OTHER_PROTECTION).add(blockRegistryObject.get());
                });
        ModRegistry.STAIRBLOCKS.getEntries().stream()
                .forEach(blockRegistryObject -> {
                    tag(TagRegistry.OTHER_PROTECTION).add(blockRegistryObject.get());
                });
        ModRegistry.SLABBLOCKS.getEntries().stream()
                .forEach(blockRegistryObject -> {
                    tag(TagRegistry.OTHER_PROTECTION).add(blockRegistryObject.get());
                });
        ModRegistry.WALLBLOCKS.getEntries().stream()
                .forEach(blockRegistryObject -> {
                    tag(TagRegistry.OTHER_PROTECTION).add(blockRegistryObject.get());
                });
        ModRegistry.PILLARBLOCKS.getEntries().stream()
                .forEach(blockRegistryObject -> {
                    tag(TagRegistry.OTHER_PROTECTION).add(blockRegistryObject.get());
                });
        tag(TagRegistry.OTHER_PROTECTION).add(Blocks.SAND);
        tag(TagRegistry.OTHER_PROTECTION).add(Blocks.SANDSTONE);
        tag(TagRegistry.OTHER_PROTECTION).add(Blocks.CRIMSON_NYLIUM);
        tag(TagRegistry.OTHER_PROTECTION).add(Blocks.WARPED_NYLIUM);
        tag(TagRegistry.OTHER_PROTECTION).add(Blocks.NETHERRACK);
        tag(TagRegistry.OTHER_PROTECTION).add(Blocks.SOUL_SAND);
        tag(TagRegistry.OTHER_PROTECTION).add(Blocks.SOUL_SOIL);
        tag(TagRegistry.OTHER_PROTECTION).add(Blocks.DEEPSLATE);

   

        tag(TagRegistry.OTHER_PROTECTION).add(Blocks.NETHERITE_BLOCK);
        tag(TagRegistry.OTHER_PROTECTION).add(Blocks.DIAMOND_BLOCK);
        tag(TagRegistry.OTHER_PROTECTION).add(Blocks.AMETHYST_BLOCK);
        tag(TagRegistry.OTHER_PROTECTION).add(Blocks.AMETHYST_CLUSTER);
        tag(TagRegistry.OTHER_PROTECTION).add(Blocks.GOLD_BLOCK);

        tag(TagRegistry.OTHER_PROTECTION).addTag(Tags.Blocks.ORES);
        tag(TagRegistry.OTHER_PROTECTION).add(Blocks.SPAWNER);
        tag(Tags.Blocks.RELOCATION_NOT_SUPPORTED).add(ModRegistry.ALLTHEMODIUM_ORE.get());
        tag(Tags.Blocks.RELOCATION_NOT_SUPPORTED).add(ModRegistry.ALLTHEMODIUM_SLATE_ORE.get());
        tag(Tags.Blocks.RELOCATION_NOT_SUPPORTED).add(ModRegistry.VIBRANIUM_ORE.get());
        tag(Tags.Blocks.RELOCATION_NOT_SUPPORTED).add(ModRegistry.OTHER_VIBRANIUM_ORE.get());
        tag(Tags.Blocks.RELOCATION_NOT_SUPPORTED).add(ModRegistry.UNOBTAINIUM_ORE.get());
        tag(Tags.Blocks.RELOCATION_NOT_SUPPORTED).add(ModRegistry.TELEPORT_PAD.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE).addOptional(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"allthemodium_source_jar"));
    }

}
