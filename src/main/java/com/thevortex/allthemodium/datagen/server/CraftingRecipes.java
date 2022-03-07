package com.thevortex.allthemodium.datagen.server;

import com.thevortex.allthemodium.datagen.builder.ShapedAncientStones;
import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.reference.TagRegistry;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.allthemods.alltheores.datagen.builder.ShapedBlockBuilder;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.*;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class CraftingRecipes extends RecipeProvider {
    public CraftingRecipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    private ShapedRecipeBuilder shaped(ItemLike provider, int integer) {
        return ShapedRecipeBuilder.shaped(provider,integer)
                .group(Reference.MOD_ID);
    }
    private ShapedRecipeBuilder shaped(ItemLike provider) {
        return ShapedRecipeBuilder.shaped(provider)
            .group(Reference.MOD_ID);
    }


    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

        shaped(ModRegistry.ALLTHEMODIUM_PICKAXE.get())
            .pattern("ara")
            .pattern(" r ")
            .pattern(" r ")
            .define('r', TagRegistry.ALLTHEMODIUM_ROD)
            .define('a', TagRegistry.ALLTHEMODIUM_PLATE)
            .unlockedBy("has_allthemodium_rod", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.ALLTHEMODIUM_ROD).build()))
            .save(consumer);

        shaped(ModRegistry.VIBRANIUM_PICKAXE.get())
                .pattern("ara")
                .pattern(" r ")
                .pattern(" r ")
                .define('r', TagRegistry.VIBRANIUM_ROD)
                .define('a', TagRegistry.VIBRANIUM_PLATE)
                .unlockedBy("has_vibranium_rod", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.VIBRANIUM_ROD).build()))
                .save(consumer);

        shaped(ModRegistry.UNOBTAINIUM_PICKAXE.get())
                .pattern("ara")
                .pattern(" r ")
                .pattern(" r ")
                .define('r', TagRegistry.UNOBTAINIUM_ROD)
                .define('a', TagRegistry.UNOBTAINIUM_PLATE)
                .unlockedBy("has_unobtainium_rod", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.UNOBTAINIUM_ROD).build()))
                .save(consumer);


        shaped(ModRegistry.ALLTHEMODIUM_AXE.get())
                .pattern("aa ")
                .pattern("ar ")
                .pattern(" r ")
                .define('r', TagRegistry.ALLTHEMODIUM_ROD)
                .define('a', TagRegistry.ALLTHEMODIUM_PLATE)
                .unlockedBy("has_allthemodium_rod", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.ALLTHEMODIUM_ROD).build()))
                .save(consumer);

        shaped(ModRegistry.VIBRANIUM_AXE.get())
                .pattern("aa ")
                .pattern("ar ")
                .pattern(" r ")
                .define('r', TagRegistry.VIBRANIUM_ROD)
                .define('a', TagRegistry.VIBRANIUM_PLATE)
                .unlockedBy("has_vibranium_rod", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.VIBRANIUM_ROD).build()))
                .save(consumer);

        shaped(ModRegistry.UNOBTAINIUM_AXE.get())
                .pattern("aa ")
                .pattern("ar ")
                .pattern(" r ")
                .define('r', TagRegistry.UNOBTAINIUM_ROD)
                .define('a', TagRegistry.UNOBTAINIUM_PLATE)
                .unlockedBy("has_unobtainium_rod", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.UNOBTAINIUM_ROD).build()))
                .save(consumer);


        shaped(ModRegistry.ALLTHEMODIUM_SHOVEL.get())
                .pattern(" a ")
                .pattern(" r ")
                .pattern(" r ")
                .define('r', TagRegistry.ALLTHEMODIUM_ROD)
                .define('a', TagRegistry.ALLTHEMODIUM_PLATE)
                .unlockedBy("has_allthemodium_rod", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.ALLTHEMODIUM_ROD).build()))
                .save(consumer);

        shaped(ModRegistry.VIBRANIUM_SHOVEL.get())
                .pattern(" a ")
                .pattern(" r ")
                .pattern(" r ")
                .define('r', TagRegistry.VIBRANIUM_ROD)
                .define('a', TagRegistry.VIBRANIUM_PLATE)
                .unlockedBy("has_vibranium_rod", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.VIBRANIUM_ROD).build()))
                .save(consumer);

        shaped(ModRegistry.UNOBTAINIUM_SHOVEL.get())
                .pattern(" a ")
                .pattern(" r ")
                .pattern(" r ")
                .define('r', TagRegistry.UNOBTAINIUM_ROD)
                .define('a', TagRegistry.UNOBTAINIUM_PLATE)
                .unlockedBy("has_unobtainium_rod", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.UNOBTAINIUM_ROD).build()))
                .save(consumer);


        shaped(ModRegistry.ALLTHEMODIUM_HOE.get())
                .pattern("aa ")
                .pattern(" r ")
                .pattern(" r ")
                .define('r', TagRegistry.ALLTHEMODIUM_ROD)
                .define('a', TagRegistry.ALLTHEMODIUM_PLATE)
                .unlockedBy("has_allthemodium_rod", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.ALLTHEMODIUM_ROD).build()))
                .save(consumer);

        shaped(ModRegistry.VIBRANIUM_HOE.get())
                .pattern("aa ")
                .pattern(" r ")
                .pattern(" r ")
                .define('r', TagRegistry.VIBRANIUM_ROD)
                .define('a', TagRegistry.VIBRANIUM_PLATE)
                .unlockedBy("has_vibranium_rod", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.VIBRANIUM_ROD).build()))
                .save(consumer);

        shaped(ModRegistry.UNOBTAINIUM_HOE.get())
                .pattern("aa ")
                .pattern(" r ")
                .pattern(" r ")
                .define('r', TagRegistry.UNOBTAINIUM_ROD)
                .define('a', TagRegistry.UNOBTAINIUM_PLATE)
                .unlockedBy("has_unobtainium_rod", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.UNOBTAINIUM_ROD).build()))
                .save(consumer);


        shaped(ModRegistry.ALLTHEMODIUM_SWORD.get())
                .pattern(" a ")
                .pattern(" a ")
                .pattern(" r ")
                .define('r', TagRegistry.ALLTHEMODIUM_ROD)
                .define('a', TagRegistry.ALLTHEMODIUM_PLATE)
                .unlockedBy("has_allthemodium_rod", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.ALLTHEMODIUM_ROD).build()))
                .save(consumer);

        shaped(ModRegistry.VIBRANIUM_SWORD.get())
                .pattern(" a ")
                .pattern(" a ")
                .pattern(" r ")
                .define('r', TagRegistry.VIBRANIUM_ROD)
                .define('a', TagRegistry.VIBRANIUM_PLATE)
                .unlockedBy("has_vibranium_rod", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.VIBRANIUM_ROD).build()))
                .save(consumer);

        shaped(ModRegistry.UNOBTAINIUM_SWORD.get())
                .pattern(" a ")
                .pattern(" a ")
                .pattern(" r ")
                .define('r', TagRegistry.UNOBTAINIUM_ROD)
                .define('a', TagRegistry.UNOBTAINIUM_PLATE)
                .unlockedBy("has_unobtainium_rod", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.UNOBTAINIUM_ROD).build()))
                .save(consumer);

        final String hasCondition = "has_item";

        ShapedAncientStones.builder(TagRegistry.DEMONIC_WOODEN_PLANKS_ITEM)
                .setBookShelf(ModRegistry.DEMONIC_BOOKSHELF_ITEM)
                .setDoor(ModRegistry.DEMONIC_DOOR_ITEM)
                .setTrapDoor(ModRegistry.DEMONIC_TRAP_DOOR_ITEM)
                .setStairs(ModRegistry.DEMONIC_WOODEN_STAIRS_ITEM)
                .setFence(ModRegistry.DEMONIC_WOOD_FENCE_ITEM)
                .setFenceGate(ModRegistry.DEMONIC_WOOD_FENCE_GATE_ITEM)
                .setSlab(ModRegistry.DEMONIC_WOODEN_SLABS_ITEM)
                .build(consumer);

        ShapedAncientStones.builder(TagRegistry.SOUL_WOODEN_PLANKS_ITEM)
                .setBookShelf(ModRegistry.SOUL_BOOKSHELF_ITEM)
                .setDoor(ModRegistry.SOUL_DOOR_ITEM)
                .setTrapDoor(ModRegistry.SOUL_TRAP_DOOR_ITEM)
                .setStairs(ModRegistry.SOUL_WOODEN_STAIRS_ITEM)
                .setFence(ModRegistry.SOUL_WOOD_FENCE_ITEM)
                .setFenceGate(ModRegistry.SOUL_WOOD_FENCE_GATE_ITEM)
                .setSlab(ModRegistry.SOUL_WOODEN_SLABS_ITEM)
                .build(consumer);

        ShapedAncientStones.builder(TagRegistry.ANCIENT_WOODEN_PLANKS_ITEM)
                .setBookShelf(ModRegistry.ANCIENT_BOOKSHELF_ITEM)
                .setTrapDoor(ModRegistry.ANCIENT_TRAP_DOOR_ITEM)
                .setDoor(ModRegistry.ANCIENT_DOOR_ITEM)
                .setStairs(ModRegistry.ANCIENT_WOODEN_STAIRS_ITEM)
                .setFence(ModRegistry.ANCIENT_WOOD_FENCE_ITEM)
                .setFenceGate(ModRegistry.ANCIENT_WOOD_FENCE_GATE_ITEM)
                .setSlab(ModRegistry.ANCIENT_WOODEN_SLABS_ITEM)
                .build(consumer);

        ShapedAncientStones.builder(TagRegistry.ANCIENT_STONE_BRICKS_ITEM)
                .setStairs(ModRegistry.ANCIENT_STONE_BRICK_STAIRS_ITEM)
                .setWall(ModRegistry.ANCIENT_STONE_BRICK_WALL_ITEM)
                .setSlab(ModRegistry.ANCIENT_STONE_BRICK_SLABS_ITEM)
                .build(consumer);

        ShapedAncientStones.builder(TagRegistry.ANCIENT_STONE_ITEM)
                .setBrick(ModRegistry.ANCIENT_STONE_BRICKS_ITEM)
                .setStairs(ModRegistry.ANCIENT_STONE_STAIRS_ITEM)
                .setWall(ModRegistry.ANCIENT_STONE_WALL_ITEM)
                .setSlab(ModRegistry.ANCIENT_STONE_SLABS_ITEM)
                .build(consumer);

        ShapedAncientStones.builder(TagRegistry.ANCIENT_MOSSY_STONE_ITEM)
                .setStairs(ModRegistry.ANCIENT_MOSSY_STONE_STAIRS_ITEM)
                .setWall(ModRegistry.ANCIENT_MOSSY_STONE_WALL_ITEM)
                .setSlab(ModRegistry.ANCIENT_MOSSY_STONE_SLABS_ITEM)
                .build(consumer);

        ShapedAncientStones.builder(TagRegistry.ANCIENT_SMOOTH_STONE_ITEM)
                .setStairs(ModRegistry.ANCIENT_SMOOTH_STONE_STAIRS_ITEM)
                .setWall(ModRegistry.ANCIENT_SMOOTH_STONE_WALL_ITEM)
                .setSlab(ModRegistry.ANCIENT_SMOOTH_STONE_SLABS_ITEM)
                .build(consumer);

        ShapedAncientStones.builder(TagRegistry.ANCIENT_POLISHED_STONE_ITEM)
                .setStairs(ModRegistry.ANCIENT_POLISHED_STONE_STAIRS_ITEM)
                .setWall(ModRegistry.ANCIENT_POLISHED_STONE_WALL_ITEM)
                .setSlab(ModRegistry.ANCIENT_POLISHED_STONE_SLABS_ITEM)
                .build(consumer);

        ShapedAncientStones.builder(TagRegistry.ANCIENT_CHISELED_STONE_BRICKS_ITEM)
                .setStairs(ModRegistry.ANCIENT_CHISELED_STONE_STAIRS_ITEM)
                .setWall(ModRegistry.ANCIENT_CHISELED_STONE_BRICK_WALL_ITEM)
                .setSlab(ModRegistry.ANCIENT_CHISELED_STONE_SLABS_ITEM)
                .build(consumer);

        ShapedAncientStones.builder(TagRegistry.ANCIENT_CRACKED_STONE_BRICKS_ITEM)
                .setStairs(ModRegistry.ANCIENT_CRACKED_STONE_STAIRS_ITEM)
                .setWall(ModRegistry.ANCIENT_CRACKED_STONE_BRICK_WALL_ITEM)
                .setSlab(ModRegistry.ANCIENT_CRACKED_STONE_SLABS_ITEM)
                .build(consumer);

        ShapedBlockBuilder.builder(TagRegistry.ALLTHEMODIUM_INGOT)
                .setBlock(ModRegistry.ALLTHEMODIUM_BLOCK_ITEM)
                .setGear(ModRegistry.ATM_GEAR)
                .setPlate(ModRegistry.ATM_PLATE)
                .setRod(ModRegistry.ATM_ROD)
                .build(consumer);
        ShapedBlockBuilder.builder(TagRegistry.VIBRANIUM_INGOT)
                .setBlock(ModRegistry.VIBRANIUM_BLOCK_ITEM)
                .setGear(ModRegistry.VIB_GEAR)
                .setPlate(ModRegistry.VIB_PLATE)
                .setRod(ModRegistry.VIB_ROD)
                .build(consumer);

        ShapedBlockBuilder.builder(TagRegistry.UNOBTAINIUM_INGOT)
                .setBlock(ModRegistry.UNOBTAINIUM_BLOCK_ITEM)
                .setGear(ModRegistry.ONOB_GEAR)
                .setPlate(ModRegistry.ONOB_PLATE)
                .setRod(ModRegistry.ONOB_ROD)
                .build(consumer);

     /*
        ShapedIngotBuilder.builder(ItemTagRegistry.ALUMINUM_NUGGET)
                .setIngot(BlockList.ALUMINUM_INGOT)
                .build(consumer);

      */


    }
}
