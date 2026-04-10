package net.allthemods.allthemodium.core.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public final class ATMBlockFamilies {
    
    private static final Map<Block, BlockFamily> MAP = new HashMap<>();
    
    public static final BlockFamily ANCIENT_PLANKS = ATMBlockFamilies.familyBuilder(ATMBlocks.ANCIENT_PLANKS.get())
            .fence(ATMBlocks.ANCIENT_FENCE.get())
            .fenceGate(ATMBlocks.ANCIENT_FENCE_GATE.get())
            .slab(ATMBlocks.ANCIENT_SLAB.get())
            .stairs(ATMBlocks.ANCIENT_STAIRS.get())
            .door(ATMBlocks.ANCIENT_DOOR.get())
            .trapdoor(ATMBlocks.ANCIENT_TRAPDOOR.get())
            .recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_planks")
            .getFamily();
    public static final BlockFamily ANCIENT_STONE = ATMBlockFamilies.familyBuilder(ATMBlocks.ANCIENT_STONE.get())
            .wall(ATMBlocks.ANCIENT_STONE_WALL.get())
            .stairs(ATMBlocks.ANCIENT_STONE_STAIRS.get())
            .slab(ATMBlocks.ANCIENT_STONE_SLAB.get())
            .getFamily();
    public static final BlockFamily SMOOTH_ANCIENT_STONE = ATMBlockFamilies.familyBuilder(ATMBlocks.SMOOTH_ANCIENT_STONE.get())
            .wall(ATMBlocks.SMOOTH_ANCIENT_STONE_WALL.get())
            .stairs(ATMBlocks.SMOOTH_ANCIENT_STONE_STAIRS.get())
            .slab(ATMBlocks.SMOOTH_ANCIENT_STONE_SLAB.get())
            .getFamily();
    public static final BlockFamily MOSSY_ANCIENT_STONE = ATMBlockFamilies.familyBuilder(ATMBlocks.MOSSY_ANCIENT_STONE.get())
            .wall(ATMBlocks.MOSSY_ANCIENT_STONE_WALL.get())
            .stairs(ATMBlocks.MOSSY_ANCIENT_STONE_STAIRS.get())
            .slab(ATMBlocks.MOSSY_ANCIENT_STONE_SLAB.get())
            .getFamily();
    public static final BlockFamily ANCIENT_STONE_BRICKS = ATMBlockFamilies.familyBuilder(ATMBlocks.ANCIENT_STONE_BRICKS.get())
            .wall(ATMBlocks.ANCIENT_STONE_BRICK_WALL.get())
            .stairs(ATMBlocks.ANCIENT_STONE_BRICK_STAIRS.get())
            .slab(ATMBlocks.ANCIENT_STONE_BRICK_SLAB.get())
            .chiseled(ATMBlocks.CHISELED_ANCIENT_STONE_BRICKS.get())
            .cracked(ATMBlocks.CRACKED_ANCIENT_STONE_BRICKS.get())
            .getFamily();
    public static final BlockFamily CHISELED_ANCIENT_STONE_BRICKS = ATMBlockFamilies.familyBuilder(ATMBlocks.CHISELED_ANCIENT_STONE_BRICKS.get())
            .wall(ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_WALL.get())
            .stairs(ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_STAIRS.get())
            .slab(ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_SLAB.get())
            .getFamily();
    public static final BlockFamily CRACKED_ANCIENT_STONE_BRICKS = ATMBlockFamilies.familyBuilder(ATMBlocks.CRACKED_ANCIENT_STONE_BRICKS.get())
            .wall(ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_WALL.get())
            .stairs(ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_STAIRS.get())
            .slab(ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_SLAB.get())
            .getFamily();
    public static final BlockFamily POLISHED_ANCIENT_STONE = ATMBlockFamilies.familyBuilder(ATMBlocks.POLISHED_ANCIENT_STONE.get())
            .wall(ATMBlocks.POLISHED_ANCIENT_STONE_WALL.get())
            .stairs(ATMBlocks.POLISHED_ANCIENT_STONE_STAIRS.get())
            .slab(ATMBlocks.POLISHED_ANCIENT_STONE_SLAB.get())
            .getFamily();
    public static final BlockFamily SOUL_PLANKS = ATMBlockFamilies.familyBuilder(ATMBlocks.SOUL_PLANKS.get())
            .fence(ATMBlocks.SOUL_FENCE.get())
            .fenceGate(ATMBlocks.SOUL_FENCE_GATE.get())
            .slab(ATMBlocks.SOUL_SLAB.get())
            .stairs(ATMBlocks.SOUL_STAIRS.get())
            .door(ATMBlocks.SOUL_DOOR.get())
            .trapdoor(ATMBlocks.SOUL_TRAPDOOR.get())
            .recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_planks")
            .getFamily();
    public static final BlockFamily DEMONIC_PLANKS = ATMBlockFamilies.familyBuilder(ATMBlocks.DEMONIC_PLANKS.get())
            .fence(ATMBlocks.DEMONIC_FENCE.get())
            .fenceGate(ATMBlocks.DEMONIC_FENCE_GATE.get())
            .slab(ATMBlocks.DEMONIC_SLAB.get())
            .stairs(ATMBlocks.DEMONIC_STAIRS.get())
            .door(ATMBlocks.DEMONIC_DOOR.get())
            .trapdoor(ATMBlocks.DEMONIC_TRAPDOOR.get())
            .recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_planks")
            .getFamily();
    
    private ATMBlockFamilies() { }
    
    private static BlockFamily.Builder familyBuilder(Block block) {
        BlockFamily.Builder builder = new BlockFamily.Builder(block);
        BlockFamily family = ATMBlockFamilies.MAP.put(block, builder.getFamily());
        if (family != null) {
            throw new IllegalStateException("Duplicate family definition for " + BuiltInRegistries.BLOCK.getKey(block));
        }
        return builder;
    }
    
    public static Stream<BlockFamily> getAllFamilies() {
        return ATMBlockFamilies.MAP.values().stream();
    }
}
