package com.thevortex.allthemodium.datagen.server;


import com.thevortex.allthemodium.registry.ModRegistry;
import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.reference.TagRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.FluidTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeBlockTagsProvider;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import static net.minecraftforge.common.Tags.Blocks.NEEDS_NETHERITE_TOOL;


public class BlockTags extends BlockTagsProvider {

    public BlockTags(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, Reference.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {

        tag(net.minecraft.tags.BlockTags.SOUL_FIRE_BASE_BLOCKS).add(ModRegistry.ANCIENT_DIRT.get());
        tag(net.minecraft.tags.BlockTags.SOUL_FIRE_BASE_BLOCKS).add(ModRegistry.ANCIENT_GRASS.get());
        tag(net.minecraft.tags.BlockTags.SOUL_FIRE_BASE_BLOCKS).add(ModRegistry.ANCIENT_LOG_0.get());
        tag(net.minecraft.tags.BlockTags.SOUL_FIRE_BASE_BLOCKS).add(ModRegistry.ANCIENT_LOG_1.get());
        tag(net.minecraft.tags.BlockTags.SOUL_FIRE_BASE_BLOCKS).add(ModRegistry.ANCIENT_LOG_2.get());
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

        tag(net.minecraft.tags.BlockTags.LOGS).add(ModRegistry.DEMONIC_LOG.get());
        tag(net.minecraft.tags.BlockTags.PLANKS).add(ModRegistry.DEMONIC_PLANKS.get());
        tag(net.minecraft.tags.BlockTags.LOGS).add(ModRegistry.SOUL_LOG.get());
        tag(net.minecraft.tags.BlockTags.LOGS).add(ModRegistry.SOUL_LOG_0.get());
        tag(net.minecraft.tags.BlockTags.LOGS).add(ModRegistry.SOUL_LOG_1.get());
        tag(net.minecraft.tags.BlockTags.LOGS).add(ModRegistry.SOUL_LOG_2.get());
        tag(net.minecraft.tags.BlockTags.PLANKS).add(ModRegistry.SOUL_PLANKS.get());
        tag(net.minecraft.tags.BlockTags.LOGS).add(ModRegistry.ANCIENT_LOG_0.get());
        tag(net.minecraft.tags.BlockTags.LOGS).add(ModRegistry.ANCIENT_LOG_1.get());
        tag(net.minecraft.tags.BlockTags.LOGS).add(ModRegistry.ANCIENT_LOG_2.get());
        tag(net.minecraft.tags.BlockTags.PLANKS).add(ModRegistry.ANCIENT_PLANKS.get());

        tag(net.minecraft.tags.BlockTags.CLIMBABLE).add(ModRegistry.ANCIENT_CAVEVINES_.get());
        tag(net.minecraft.tags.BlockTags.CLIMBABLE).add(ModRegistry.ANCIENT_CAVEVINES_PLANT_.get());
        
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(ModRegistry.ANCIENT_STONE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_SHOVEL).add(ModRegistry.ANCIENT_DIRT.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_SHOVEL).add(ModRegistry.ANCIENT_GRASS.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(ModRegistry.ANCIENT_MOSSY_STONE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(ModRegistry.ANCIENT_POLISHED_STONE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(ModRegistry.ANCIENT_SMOOTH_STONE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(ModRegistry.ANCIENT_STONE_BRICKS.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(ModRegistry.ANCIENT_CRACKED_STONE_BRICKS.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(ModRegistry.ANCIENT_CHISELED_STONE_BRICKS.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE).add(ModRegistry.ANCIENT_PLANKS.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE).add(ModRegistry.ANCIENT_LOG_0.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE).add(ModRegistry.ANCIENT_LOG_1.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE).add(ModRegistry.ANCIENT_LOG_2.get());

        tag(NEEDS_NETHERITE_TOOL).add(ModRegistry.ALLTHEMODIUM_ORE.get());
        tag(NEEDS_NETHERITE_TOOL).add(ModRegistry.ALLTHEMODIUM_SLATE_ORE.get());
        tag(TagRegistry.NEEDS_ALLTHEMODIUM_TOOL).add(ModRegistry.VIBRANIUM_ORE.get());
        tag(TagRegistry.NEEDS_ALLTHEMODIUM_TOOL).add(ModRegistry.OTHER_VIBRANIUM_ORE.get());
        tag(TagRegistry.NEEDS_VIBRANIUM_TOOL).add(ModRegistry.UNOBTAINIUM_ORE.get());


        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE).add(ModRegistry.DEMONIC_PLANKS.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE).add(ModRegistry.DEMONIC_LOG.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE).add(ModRegistry.SOUL_PLANKS.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE).add(ModRegistry.SOUL_LOG.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE).add(ModRegistry.SOUL_LOG_0.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE).add(ModRegistry.SOUL_LOG_1.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE).add(ModRegistry.SOUL_LOG_2.get());

        tag(net.minecraft.tags.BlockTags.NYLIUM).add(ModRegistry.ANCIENT_STONE.get());
        tag(net.minecraft.tags.BlockTags.INFINIBURN_NETHER).add(ModRegistry.ANCIENT_STONE.get());
        tag(net.minecraft.tags.BlockTags.INFINIBURN_NETHER).add(ModRegistry.ANCIENT_GRASS.get());
        tag(net.minecraft.tags.BlockTags.INFINIBURN_NETHER).add(ModRegistry.ANCIENT_DIRT.get());
        tag(net.minecraft.tags.BlockTags.BEE_GROWABLES).add(ModRegistry.ANCIENT_SAPLING.get());
        tag(net.minecraft.tags.BlockTags.DIRT).add(ModRegistry.ANCIENT_GRASS.get());
        tag(net.minecraft.tags.BlockTags.DIRT).add(ModRegistry.ANCIENT_DIRT.get());
        tag(net.minecraft.tags.BlockTags.SAPLINGS).add(ModRegistry.ANCIENT_SAPLING.get());

        tag(net.minecraft.tags.BlockTags.WOODEN_FENCES).add(ModRegistry.ANCIENT_WOOD_FENCE.get());
        tag(net.minecraft.tags.BlockTags.FENCES).add(ModRegistry.ANCIENT_WOOD_FENCE.get());
        tag(net.minecraft.tags.BlockTags.FENCE_GATES).add(ModRegistry.ANCIENT_WOOD_FENCE_GATE.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_FENCES).add(ModRegistry.DEMONIC_WOOD_FENCE.get());
        tag(net.minecraft.tags.BlockTags.FENCES).add(ModRegistry.DEMONIC_WOOD_FENCE.get());
        tag(net.minecraft.tags.BlockTags.FENCE_GATES).add(ModRegistry.DEMONIC_WOOD_FENCE_GATE.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_FENCES).add(ModRegistry.SOUL_WOOD_FENCE.get());
        tag(net.minecraft.tags.BlockTags.FENCES).add(ModRegistry.SOUL_WOOD_FENCE.get());
        tag(net.minecraft.tags.BlockTags.FENCE_GATES).add(ModRegistry.SOUL_WOOD_FENCE_GATE.get());

        tag(net.minecraft.tags.BlockTags.WALLS).add(ModRegistry.ANCIENT_WOOD_FENCE.get());
        tag(net.minecraft.tags.BlockTags.WALLS).add(ModRegistry.DEMONIC_WOOD_FENCE.get());
        tag(net.minecraft.tags.BlockTags.WALLS).add(ModRegistry.SOUL_WOOD_FENCE.get());
        tag(net.minecraft.tags.BlockTags.WALLS).add(ModRegistry.ANCIENT_STONE_WALL.get());
        tag(net.minecraft.tags.BlockTags.WALLS).add(ModRegistry.ANCIENT_POLISHED_STONE_WALL.get());
        tag(net.minecraft.tags.BlockTags.WALLS).add(ModRegistry.ANCIENT_MOSSY_STONE_WALL.get());
        tag(net.minecraft.tags.BlockTags.WALLS).add(ModRegistry.ANCIENT_CRACKED_STONE_BRICK_WALL.get());
        tag(net.minecraft.tags.BlockTags.WALLS).add(ModRegistry.ANCIENT_CHISELED_STONE_BRICK_WALL.get());
        tag(net.minecraft.tags.BlockTags.WALLS).add(ModRegistry.ANCIENT_STONE_BRICK_WALL.get());

        tag(net.minecraft.tags.BlockTags.SLABS).add(ModRegistry.ANCIENT_WOODEN_SLABS.get());
        tag(net.minecraft.tags.BlockTags.SLABS).add(ModRegistry.DEMONIC_WOODEN_SLABS.get());
        tag(net.minecraft.tags.BlockTags.SLABS).add(ModRegistry.SOUL_WOODEN_SLABS.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_SLABS).add(ModRegistry.ANCIENT_WOODEN_SLABS.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_SLABS).add(ModRegistry.DEMONIC_WOODEN_SLABS.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_SLABS).add(ModRegistry.SOUL_WOODEN_SLABS.get());
        tag(net.minecraft.tags.BlockTags.SLABS).add(ModRegistry.ANCIENT_STONE_SLABS.get());
        tag(net.minecraft.tags.BlockTags.SLABS).add(ModRegistry.ANCIENT_POLISHED_STONE_SLABS.get());
        tag(net.minecraft.tags.BlockTags.SLABS).add(ModRegistry.ANCIENT_MOSSY_STONE_SLABS.get());
        tag(net.minecraft.tags.BlockTags.SLABS).add(ModRegistry.ANCIENT_CRACKED_STONE_SLABS.get());
        tag(net.minecraft.tags.BlockTags.SLABS).add(ModRegistry.ANCIENT_CHISELED_STONE_SLABS.get());
        tag(net.minecraft.tags.BlockTags.SLABS).add(ModRegistry.ANCIENT_STONE_BRICK_SLABS.get());


        tag(net.minecraft.tags.BlockTags.WOODEN_FENCES).add(ModRegistry.ANCIENT_STONE_WALL.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_FENCES).add(ModRegistry.ANCIENT_POLISHED_STONE_WALL.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_FENCES).add(ModRegistry.ANCIENT_MOSSY_STONE_WALL.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_FENCES).add(ModRegistry.ANCIENT_CRACKED_STONE_BRICK_WALL.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_FENCES).add(ModRegistry.ANCIENT_CHISELED_STONE_BRICK_WALL.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_FENCES).add(ModRegistry.ANCIENT_STONE_BRICK_WALL.get());

        tag(net.minecraft.tags.BlockTags.STAIRS).add(ModRegistry.ANCIENT_WOODEN_STAIRS.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_STAIRS).add(ModRegistry.ANCIENT_WOODEN_STAIRS.get());
        tag(net.minecraft.tags.BlockTags.STAIRS).add(ModRegistry.DEMONIC_WOODEN_STAIRS.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_STAIRS).add(ModRegistry.DEMONIC_WOODEN_STAIRS.get());
        tag(net.minecraft.tags.BlockTags.STAIRS).add(ModRegistry.SOUL_WOODEN_STAIRS.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_STAIRS).add(ModRegistry.SOUL_WOODEN_STAIRS.get());
        tag(net.minecraft.tags.BlockTags.STAIRS).add(ModRegistry.ANCIENT_STONE_STAIRS.get());
        tag(net.minecraft.tags.BlockTags.STAIRS).add(ModRegistry.ANCIENT_POLISHED_STONE_STAIRS.get());
        tag(net.minecraft.tags.BlockTags.STAIRS).add(ModRegistry.ANCIENT_MOSSY_STONE_STAIRS.get());
        tag(net.minecraft.tags.BlockTags.STAIRS).add(ModRegistry.ANCIENT_CRACKED_STONE_STAIRS.get());
        tag(net.minecraft.tags.BlockTags.STAIRS).add(ModRegistry.ANCIENT_CHISELED_STONE_STAIRS.get());
        tag(net.minecraft.tags.BlockTags.STAIRS).add(ModRegistry.ANCIENT_STONE_BRICK_STAIRS.get());

        tag(TagRegistry.ALLTHEMODIUM_BLOCK).add(ModRegistry.ALLTHEMODIUM_BLOCK.get());
        tag(TagRegistry.ALLTHEMODIUM_ORE).add(ModRegistry.ALLTHEMODIUM_ORE.get());
        tag(TagRegistry.ALLTHEMODIUM_ORE).add(ModRegistry.ALLTHEMODIUM_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(ModRegistry.RAW_ALLTHEMODIUM_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(ModRegistry.ALLTHEMODIUM_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(ModRegistry.ALLTHEMODIUM_SLATE_ORE.get());
        tag(TagRegistry.VIBRANIUM_BLOCK).add(ModRegistry.VIBRANIUM_BLOCK.get());
        tag(TagRegistry.VIBRANIUM_ORE).add(ModRegistry.VIBRANIUM_ORE.get());
        tag(TagRegistry.VIBRANIUM_ORE).add(ModRegistry.OTHER_VIBRANIUM_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(ModRegistry.RAW_VIBRANIUM_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(ModRegistry.VIBRANIUM_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(ModRegistry.OTHER_VIBRANIUM_ORE.get());
        tag(TagRegistry.UNOBTAINIUM_BLOCK).add(ModRegistry.UNOBTAINIUM_BLOCK.get());
        tag(TagRegistry.UNOBTAINIUM_ORE).add(ModRegistry.UNOBTAINIUM_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(ModRegistry.RAW_UNOBTAINIUM_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(ModRegistry.UNOBTAINIUM_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(ModRegistry.TELEPORT_PAD.get());
        }

}
