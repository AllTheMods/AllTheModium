package com.thevortex.allthemodium.datagen.server;

import com.thevortex.allthemodium.datagen.builder.ShapedAncientStones;
import com.thevortex.allthemodium.datagen.builder.ShapedIngotBuilder;

import com.thevortex.allthemodium.datagen.builder.ShapedBlockBuilder;

import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.TagRegistry;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.allthemods.alltheores.infos.ItemTagRegistry;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.*;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.fml.ModList;

import java.util.function.Consumer;

public class ATMCraftingRecipes extends RecipeProvider {
    public ATMCraftingRecipes(PackOutput packOutput) {
        super(packOutput);
    }
    private ResourceLocation recipeDir(String typeIn, String typeOut) {
        return new ResourceLocation(Reference.MOD_ID,typeIn + "_from_" + typeOut);
    }
    private ShapedRecipeBuilder shaped(ItemLike provider, int integer) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC,provider,integer)
                .group(Reference.MOD_ID);
    }
    private ShapedRecipeBuilder shaped(ItemLike provider) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC,provider)
            .group(Reference.MOD_ID);
    }

    private static InventoryChangeTrigger.TriggerInstance hasTag(TagKey<Item> tagKey) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(tagKey).build());
    }


    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        buildShapedRecipes(consumer);
        buildShapelessRecipes(consumer);
        buildSmeltingRecipes(consumer);
        buildBlastingRecipes(consumer);
    }
    protected void buildShapedRecipes(Consumer<FinishedRecipe> consumer) {

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModRegistry.RAW_ALLTHEMODIUM_BLOCK.get())
            .group(Reference.MOD_ID)
            .requires(Ingredient.of(TagRegistry.RAW_ALLTHEMODIUM), 9)
            .unlockedBy("has_raw_allthemodium", hasTag(TagRegistry.RAW_ALLTHEMODIUM))
            .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModRegistry.RAW_VIBRANIUM_BLOCK.get())
            .group(Reference.MOD_ID)
            .requires(Ingredient.of(TagRegistry.RAW_VIBRANIUM), 9)
            .unlockedBy("has_raw_vibranium", hasTag(TagRegistry.RAW_VIBRANIUM))
            .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModRegistry.RAW_UNOBTAINIUM_BLOCK.get())
            .group(Reference.MOD_ID)
            .requires(Ingredient.of(TagRegistry.RAW_UNOBTAINIUM), 9)
            .unlockedBy("has_raw_unobtainium", hasTag(TagRegistry.RAW_UNOBTAINIUM))
            .save(consumer);

        shaped(ModRegistry.PIGLICH_HEART_BLOCK_ITEM.get())
                .pattern("nnn")
                .pattern("nnn")
                .pattern("nnn")
                .define('n', ModRegistry.PIGLICH_HEART.get())
                .unlockedBy("has_piglich_heartt", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(ModRegistry.PIGLICH_HEART.get()).build()))
                .save(consumer);

        shaped(ModRegistry.ALLTHEMODIUM_APPLE.get())
                .pattern("nnn")
                .pattern("nan")
                .pattern("nnn")
                .define('n', TagRegistry.ALLTHEMODIUM_NUGGET)
                .define('a', Items.APPLE)
                .unlockedBy("has_allthemodium_nugget", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.ALLTHEMODIUM_NUGGET).build()))
                .save(consumer);

        shaped(ModRegistry.ALLTHEMODIUM_CARROT.get())
                .pattern("nnn")
                .pattern("nan")
                .pattern("nnn")
                .define('n', TagRegistry.ALLTHEMODIUM_NUGGET)
                .define('a', Items.CARROT)
                .unlockedBy("has_allthemodium_nugget", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.ALLTHEMODIUM_NUGGET).build()))
                .save(consumer);

        shaped(ModRegistry.TELEPORT_PAD_ITEM.get())
                .pattern(" n ")
                .pattern("nan")
                .pattern(" n ")
                .define('n', TagRegistry.ALLTHEMODIUM_NUGGET)
                .define('a', Items.ENDER_PEARL)
                .unlockedBy("has_allthemodium_nugget", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.ALLTHEMODIUM_NUGGET).build()))
                .unlockedBy("has_ender_pearl", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(Items.ENDER_PEARL).build()))
                .save(consumer);

        shaped(ModRegistry.ALLTHEMODIUM_PICKAXE.get())
            .pattern("ara")
            .pattern(" r ")
            .pattern(" r ")
            .define('r', TagRegistry.ALLTHEMODIUM_ROD)
            .define('a', TagRegistry.ALLTHEMODIUM_PLATE)
            .unlockedBy("has_allthemodium_rod", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.ALLTHEMODIUM_ROD).build()))
            .save(consumer);



        shaped(ModRegistry.ALLTHEMODIUM_AXE.get())
                .pattern("aa ")
                .pattern("ar ")
                .pattern(" r ")
                .define('r', TagRegistry.ALLTHEMODIUM_ROD)
                .define('a', TagRegistry.ALLTHEMODIUM_PLATE)
                .unlockedBy("has_allthemodium_rod", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.ALLTHEMODIUM_ROD).build()))
                .save(consumer);




        shaped(ModRegistry.ALLTHEMODIUM_SHOVEL.get())
                .pattern(" a ")
                .pattern(" r ")
                .pattern(" r ")
                .define('r', TagRegistry.ALLTHEMODIUM_ROD)
                .define('a', TagRegistry.ALLTHEMODIUM_PLATE)
                .unlockedBy("has_allthemodium_rod", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.ALLTHEMODIUM_ROD).build()))
                .save(consumer);



        shaped(ModRegistry.ALLTHEMODIUM_HOE.get())
                .pattern("aa ")
                .pattern(" r ")
                .pattern(" r ")
                .define('r', TagRegistry.ALLTHEMODIUM_ROD)
                .define('a', TagRegistry.ALLTHEMODIUM_PLATE)
                .unlockedBy("has_allthemodium_rod", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.ALLTHEMODIUM_ROD).build()))
                .save(consumer);




        shaped(ModRegistry.ALLTHEMODIUM_SWORD.get())
                .pattern(" a ")
                .pattern(" a ")
                .pattern(" r ")
                .define('r', TagRegistry.ALLTHEMODIUM_ROD)
                .define('a', TagRegistry.ALLTHEMODIUM_PLATE)
                .unlockedBy("has_allthemodium_rod", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.ALLTHEMODIUM_ROD).build()))
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

        ShapedBlockBuilder.builder(TagRegistry.UNOBTAINIUM_ALLTHEMODIUM_INGOT)
                .setBlock(ModRegistry.UA_ALLOY_ITEM)
                .build(consumer);

        ShapedBlockBuilder.builder(TagRegistry.UNOBTAINIUM_VIBRANIUM_INGOT)
                .setBlock(ModRegistry.UV_ALLOY_ITEM)
                .build(consumer);

        ShapedBlockBuilder.builder(TagRegistry.VIBRANIUM_ALLTHEMODIUM_INGOT)
                .setBlock(ModRegistry.VA_ALLOY_ITEM)
                .build(consumer);

        ShapedIngotBuilder.builder(TagRegistry.ALLTHEMODIUM_NUGGET)
                .setIngot(ModRegistry.ALLTHEMODIUM_INGOT)
                .build(consumer);
        ShapedIngotBuilder.builder(TagRegistry.VIBRANIUM_NUGGET)
                .setIngot(ModRegistry.VIBRANIUM_INGOT)
                .build(consumer);
        ShapedIngotBuilder.builder(TagRegistry.UNOBTAINIUM_NUGGET)
                .setIngot(ModRegistry.UNOBTAINIUM_INGOT)
                .build(consumer);

    }



    protected void buildBlastingRecipes(Consumer<FinishedRecipe> consumer) {

        final String hasCondition = "has_item";

        SimpleCookingRecipeBuilder
                .blasting(Ingredient.of(ModRegistry.ANCIENT_STONE_ITEM.get()), RecipeCategory.MISC,ModRegistry.ANCIENT_SMOOTH_STONE_ITEM.get(),0.15f,200)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.ANCIENT_STONE_ITEM.get()))
                .save(consumer,recipeDir("ancient_smooth_stone","ancient_stone_blasting"));

        SimpleCookingRecipeBuilder
                .blasting(Ingredient.of(ModRegistry.RAW_ALLTHEMODIUM.get()), RecipeCategory.MISC,ModRegistry.ALLTHEMODIUM_INGOT.get(),0.15f,200)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.RAW_ALLTHEMODIUM.get()))
                .save(consumer,recipeDir("allthemodium_ingot","raw_blasting"));

        SimpleCookingRecipeBuilder
                .blasting(Ingredient.of(ModRegistry.RAW_VIBRANIUM.get()), RecipeCategory.MISC,ModRegistry.VIBRANIUM_INGOT.get(),0.15f,200)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.RAW_VIBRANIUM.get()))
                .save(consumer,recipeDir("vibranium_ingot","raw_blasting"));

        SimpleCookingRecipeBuilder
                .blasting(Ingredient.of(ModRegistry.RAW_UNOBTAINIUM.get()), RecipeCategory.MISC,ModRegistry.UNOBTAINIUM_INGOT.get(),0.15f,200)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.RAW_UNOBTAINIUM.get()))
                .save(consumer,recipeDir("unobtainium_ingot","raw_blasting"));

        SimpleCookingRecipeBuilder
                .blasting(Ingredient.of(ModRegistry.ALLTHEMODIUM_DUST.get()), RecipeCategory.MISC,ModRegistry.ALLTHEMODIUM_INGOT.get(),0.15f,200)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.ALLTHEMODIUM_DUST.get()))
                .save(consumer,recipeDir("allthemodium_ingot","dust_blasting"));

        SimpleCookingRecipeBuilder
                .blasting(Ingredient.of(ModRegistry.VIBRANIUM_DUST.get()), RecipeCategory.MISC,ModRegistry.VIBRANIUM_INGOT.get(),0.15f,200)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.VIBRANIUM_DUST.get()))
                .save(consumer,recipeDir("vibranium_ingot","dust_blasting"));

        SimpleCookingRecipeBuilder
                .blasting(Ingredient.of(ModRegistry.UNOBTAINIUM_DUST.get()), RecipeCategory.MISC,ModRegistry.UNOBTAINIUM_INGOT.get(),0.15f,200)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.UNOBTAINIUM_DUST.get()))
                .save(consumer,recipeDir("unobtainium_ingot","dust_blasting"));


    }


    protected void buildShapelessRecipes(Consumer<FinishedRecipe> consumer) {

        final String hasCondition = "has_item";

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,ModRegistry.DEMONIC_PLANKS.get(),4)
                .requires(ModRegistry.DEMONIC_LOG_ITEM.get())
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.DEMONIC_LOG_ITEM.get()))
                .save(consumer,recipeDir("demonic_planks","shapelesscrafting"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,ModRegistry.SOUL_PLANKS.get(),4)
                .requires(ModRegistry.SOUL_LOG_ITEM.get())
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.SOUL_LOG_ITEM.get()))
                .save(consumer,recipeDir("soul_planks","shapelesscrafting"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,ModRegistry.SOUL_PLANKS.get(),4)
                .requires(ModRegistry.SOUL_LOG_0_ITEM.get())
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.SOUL_LOG_0_ITEM.get()))
                .save(consumer,recipeDir("soul_planks_0","shapelesscrafting"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,ModRegistry.SOUL_PLANKS.get(),4)
                .requires(ModRegistry.SOUL_LOG_1_ITEM.get())
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.SOUL_LOG_1_ITEM.get()))
                .save(consumer,recipeDir("soul_planks_1","shapelesscrafting"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,ModRegistry.SOUL_PLANKS.get(),4)
                .requires(ModRegistry.SOUL_LOG_2_ITEM.get())
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.SOUL_LOG_2_ITEM.get()))
                .save(consumer,recipeDir("soul_planks_2","shapelesscrafting"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,ModRegistry.ANCIENT_PLANKS.get(),4)
                .requires(ModRegistry.ANCIENT_LOG_0_ITEM.get())
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.ANCIENT_LOG_0_ITEM.get()))
                .save(consumer,recipeDir("ancient_planks","shapelesscrafting"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,ModRegistry.ANCIENT_PLANKS.get(),4)
                .requires(ModRegistry.ANCIENT_LOG_1_ITEM.get())
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.ANCIENT_LOG_1_ITEM.get()))
                .save(consumer,recipeDir("ancient_planks_1","shapelesscrafting"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,ModRegistry.ANCIENT_PLANKS.get(),4)
                .requires(ModRegistry.ANCIENT_LOG_2_ITEM.get())
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.ANCIENT_LOG_2_ITEM.get()))
                .save(consumer,recipeDir("ancient_planks_2","shapelesscrafting"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,ModRegistry.ANCIENT_PLANKS.get(),4)
                .requires(ModRegistry.ANCIENT_LOG_STRIPPED_ITEM.get())
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.ANCIENT_LOG_STRIPPED_ITEM.get()))
                .save(consumer,recipeDir("ancient_planks_3","shapelesscrafting"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,ModRegistry.ANCIENT_MOSSY_STONE_ITEM.get(),1)
                .requires(ModRegistry.ANCIENT_STONE_ITEM.get())
                .requires(Items.VINE)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.ANCIENT_STONE_ITEM.get()))
                .save(consumer,recipeDir("ancient_mossy_stone","vinecrafting"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,ModRegistry.ANCIENT_POLISHED_STONE_ITEM.get(),1)
                .requires(ModRegistry.ANCIENT_SMOOTH_STONE_ITEM.get())
                .requires(Items.HONEYCOMB)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.ANCIENT_SMOOTH_STONE_ITEM.get()))
                .save(consumer,recipeDir("ancient_polished_stone","waxing"));


        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,ModRegistry.ANCIENT_CRACKED_STONE_BRICKS_ITEM.get(),1)
                .requires(TagRegistry.ANCIENT_STONE_BRICKS_ITEM)
                .requires(ItemTagRegistry.ORE_HAMMERS)
                .unlockedBy(hasCondition,RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.ANCIENT_STONE_BRICKS_ITEM).build()))
                .save(consumer,recipeDir("ancient_cracked_stone_bricks","crushing"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,ModRegistry.ANCIENT_CHISELED_STONE_BRICKS_ITEM.get(),1)
                .requires(TagRegistry.ANCIENT_CRACKED_STONE_BRICKS_ITEM)
                .requires(ItemTagRegistry.ORE_HAMMERS)
                .unlockedBy(hasCondition,RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(TagRegistry.ANCIENT_CRACKED_STONE_BRICKS_ITEM).build()))
                .save(consumer,recipeDir("ancient_chiseled_stone_bricks","crushing"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,ModRegistry.ALLTHEMODIUM_DUST.get(),2)
                .requires(ModRegistry.RAW_ALLTHEMODIUM.get())
                .requires(ItemTagRegistry.ORE_HAMMERS)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.RAW_ALLTHEMODIUM.get()))
                .save(consumer,recipeDir("allthemodium_dust","ore_crushing"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,ModRegistry.ALLTHEMODIUM_INGOT.get(),9)
                .requires(TagRegistry.ALLTHEMODIUM_BLOCK_ITEM)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.ALLTHEMODIUM_BLOCK_ITEM.get()))
                .save(consumer,recipeDir("allthemodium_ingot","block"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,ModRegistry.ALLTHEMODIUM_NUGGET.get(),9)
                .requires(TagRegistry.ALLTHEMODIUM_INGOT)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.ALLTHEMODIUM_INGOT.get()))
                .save(consumer,recipeDir("allthemodium_nugget","ingot"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,ModRegistry.VIBRANIUM_DUST.get(),2)
                .requires(ModRegistry.RAW_VIBRANIUM.get())
                .requires(ItemTagRegistry.ORE_HAMMERS)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.RAW_VIBRANIUM.get()))
                .save(consumer,recipeDir("vibranium_dust","ore_crushing"));


        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,ModRegistry.UNOBTAINIUM_DUST.get(),2)
                .requires(ModRegistry.RAW_UNOBTAINIUM.get())
                .requires(ItemTagRegistry.ORE_HAMMERS)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.RAW_UNOBTAINIUM.get()))
                .save(consumer,recipeDir("unobtainium_dust","ore_crushing"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,ModRegistry.VIBRANIUM_INGOT.get(),9)
                .requires(TagRegistry.VIBRANIUM_BLOCK_ITEM)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.VIBRANIUM_BLOCK_ITEM.get()))
                .save(consumer,recipeDir("vibranium_ingot","block"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,ModRegistry.VIBRANIUM_NUGGET.get(),9)
                .requires(TagRegistry.VIBRANIUM_INGOT)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.VIBRANIUM_INGOT.get()))
                .save(consumer,recipeDir("vibranium_nugget","ingot"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,ModRegistry.UNOBTAINIUM_INGOT.get(),9)
                .requires(TagRegistry.UNOBTAINIUM_BLOCK_ITEM)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.UNOBTAINIUM_BLOCK_ITEM.get()))
                .save(consumer,recipeDir("unobtainium_ingot","block"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,ModRegistry.UNOBTAINIUM_NUGGET.get(),9)
                .requires(TagRegistry.UNOBTAINIUM_INGOT)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.UNOBTAINIUM_INGOT.get()))
                .save(consumer,recipeDir("unobtainium_nugget","ingot"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,ModRegistry.RAW_ALLTHEMODIUM.get(),9)
                .requires(TagRegistry.RAW_ALLTHEMODIUM_BLOCK)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.RAW_ALLTHEMODIUM_BLOCK_ITEM.get()))
                .save(consumer,recipeDir("raw_allthemodium","block"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,ModRegistry.RAW_VIBRANIUM.get(),9)
                .requires(TagRegistry.RAW_VIBRANIUM_BLOCK)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.RAW_VIBRANIUM_BLOCK_ITEM.get()))
                .save(consumer,recipeDir("raw_vibranium","block"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,ModRegistry.RAW_UNOBTAINIUM.get(),9)
                .requires(TagRegistry.RAW_UNOBTAINIUM_BLOCK)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.RAW_UNOBTAINIUM_BLOCK_ITEM.get()))
                .save(consumer,recipeDir("raw_unobtainium","block"));


        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,ModRegistry.UNOBTAINIUM_ALLTHEMODIUM_ALLOY.get(),9)
                .requires(TagRegistry.UNOBTAINIUM_ALLTHEMODIUM_BLOCK)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.UA_ALLOY_ITEM.get()))
                .save(consumer,recipeDir("unobtainium_allthemodium_alloy_ingot","block"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,ModRegistry.UNOBTAINIUM_VIBRANIUM_ALLOY.get(),9)
                .requires(TagRegistry.UNOBTAINIUM_VIBRANIUM_BLOCK)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.UV_ALLOY_ITEM.get()))
                .save(consumer,recipeDir("unobtainium_vibranium_alloy_ingot","block"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,ModRegistry.VIBRANIUM_ALLTHEMODIUM_ALLOY.get(),9)
                .requires(TagRegistry.VIBRANIUM_ALLTHEMODIUM_BLOCK)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.VA_ALLOY_ITEM.get()))
                .save(consumer,recipeDir("vibranium_allthemodium_alloy_ingot","block"));


    }


    protected void buildSmeltingRecipes(Consumer<FinishedRecipe> consumer) {

        final String hasCondition = "has_item";

        SimpleCookingRecipeBuilder
                .smelting(Ingredient.of(ModRegistry.ANCIENT_STONE_ITEM.get()), RecipeCategory.MISC,ModRegistry.ANCIENT_SMOOTH_STONE_ITEM.get(),0.15f,200)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.ANCIENT_STONE_ITEM.get()))
                .save(consumer,recipeDir("ancient_smooth_stone","ancient_stone_smelting"));

        SimpleCookingRecipeBuilder
                .smelting(Ingredient.of(ModRegistry.RAW_ALLTHEMODIUM.get()),RecipeCategory.MISC,ModRegistry.ALLTHEMODIUM_INGOT.get(),0.15f,200)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.RAW_ALLTHEMODIUM.get()))
                .save(consumer,recipeDir("allthemodium_ingot","raw_smelting"));

        SimpleCookingRecipeBuilder
                .smelting(Ingredient.of(ModRegistry.RAW_VIBRANIUM.get()),RecipeCategory.MISC,ModRegistry.VIBRANIUM_INGOT.get(),0.15f,200)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.RAW_VIBRANIUM.get()))
                .save(consumer,recipeDir("vibranium_ingot","raw_smelting"));

        SimpleCookingRecipeBuilder
                .smelting(Ingredient.of(ModRegistry.RAW_UNOBTAINIUM.get()),RecipeCategory.MISC,ModRegistry.UNOBTAINIUM_INGOT.get(),0.15f,200)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.RAW_UNOBTAINIUM.get()))
                .save(consumer,recipeDir("unobtainium_ingot","raw_smelting"));

        SimpleCookingRecipeBuilder
                .smelting(Ingredient.of(ModRegistry.ALLTHEMODIUM_DUST.get()),RecipeCategory.MISC,ModRegistry.ALLTHEMODIUM_INGOT.get(),0.15f,200)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.ALLTHEMODIUM_DUST.get()))
                .save(consumer,recipeDir("allthemodium_ingot","dust_smelting"));

        SimpleCookingRecipeBuilder
                .smelting(Ingredient.of(ModRegistry.VIBRANIUM_DUST.get()),RecipeCategory.MISC,ModRegistry.VIBRANIUM_INGOT.get(),0.15f,200)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.VIBRANIUM_DUST.get()))
                .save(consumer,recipeDir("vibranium_ingot","dust_smelting"));

        SimpleCookingRecipeBuilder
                .smelting(Ingredient.of(ModRegistry.UNOBTAINIUM_DUST.get()),RecipeCategory.MISC,ModRegistry.UNOBTAINIUM_INGOT.get(),0.15f,200)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.UNOBTAINIUM_DUST.get()))
                .save(consumer,recipeDir("unobtainium_ingot","dust_smelting"));

    }
}
