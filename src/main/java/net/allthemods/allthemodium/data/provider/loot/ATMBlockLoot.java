package net.allthemods.allthemodium.data.provider.loot;

import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;

import net.allthemods.allthemodium.common.blocks.AncientCaveVines;
import net.allthemods.allthemodium.core.registry.ATMBlocks;
import net.allthemods.allthemodium.core.registry.ATMItems;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class ATMBlockLoot extends BlockLootSubProvider {
    private final Map<ResourceKey<LootTable>, LootTable.Builder> tables = new HashMap<>();
    
    protected ATMBlockLoot(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.DEFAULT_FLAGS, registries);
    }
    
    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output) {
        this.generate();
        this.tables.forEach(output);
    }
    
    @Override
    protected void generate() {
        this.dropOre(ATMBlocks.ALLTHEMODIUM_ORE, ATMItems.RAW_ALLTHEMODIUM);
        this.dropOre(ATMBlocks.DEEPSLATE_ALLTHEMODIUM_ORE, ATMItems.RAW_ALLTHEMODIUM);
        this.dropOre(ATMBlocks.VIBRANIUM_ORE, ATMItems.RAW_VIBRANIUM);
        this.dropOre(ATMBlocks.OTHER_VIBRANIUM_ORE, ATMItems.RAW_VIBRANIUM);
        this.dropOre(ATMBlocks.UNOBTAINIUM_ORE, ATMItems.RAW_UNOBTAINIUM);
        
        this.dropSelf(ATMBlocks.RAW_ALLTHEMODIUM_BLOCK);
        this.dropSelf(ATMBlocks.RAW_VIBRANIUM_BLOCK);
        this.dropSelf(ATMBlocks.RAW_UNOBTAINIUM_BLOCK);
        this.dropSelf(ATMBlocks.ALLTHEMODIUM_BLOCK);
        this.dropSelf(ATMBlocks.VIBRANIUM_BLOCK);
        this.dropSelf(ATMBlocks.UNOBTAINIUM_BLOCK);
        this.dropSelf(ATMBlocks.UNOBTAINIUM_ALLTHEMODIUM_BLOCK);
        this.dropSelf(ATMBlocks.UNOBTAINIUM_VIBRANIUM_BLOCK);
        this.dropSelf(ATMBlocks.VIBRANIUM_ALLTHEMODIUM_BLOCK);
        this.dropSelf(ATMBlocks.PIGLICH_HEART_BLOCK);
        
        this.add(ATMBlocks.ANCIENT_CAVE_VINES.get(), this::createSoulBerriesVineDrops);
        this.add(ATMBlocks.ANCIENT_CAVE_VINES_PLANT.get(), this::createSoulBerriesVineDrops);
        
        this.dropSelf(ATMBlocks.ANCIENT_DIRT);
        this.add(ATMBlocks.ANCIENT_GRASS.get(), block -> this.createSingleItemTableWithSilkTouch(block, ATMBlocks.ANCIENT_DIRT.get()));
        this.dropSelf(ATMBlocks.ANCIENT_SAPLING);
        this.dropTallFlower(ATMBlocks.ANCIENT_HERB);
        this.dropSelf(ATMBlocks.ANCIENT_LOG_0);
        this.dropSelf(ATMBlocks.ANCIENT_LOG_1);
        this.dropSelf(ATMBlocks.ANCIENT_LOG_2);
        this.dropSelf(ATMBlocks.STRIPPED_ANCIENT_LOG);
        this.dropLeaves(ATMBlocks.ANCIENT_LEAVES, ATMBlocks.ANCIENT_SAPLING);
        this.dropLeaves(ATMBlocks.ANCIENT_LEAVES_BOTTOM, ATMBlocks.ANCIENT_SAPLING);
        this.dropSelf(ATMBlocks.ANCIENT_PLANKS);
        this.dropSelf(ATMBlocks.ANCIENT_TRAPDOOR);
        this.dropSelf(ATMBlocks.ANCIENT_FENCE);
        this.dropSelf(ATMBlocks.ANCIENT_FENCE_GATE);
        this.dropDoor(ATMBlocks.ANCIENT_DOOR);
        this.dropSelf(ATMBlocks.ANCIENT_BOOKSHELF);
        this.dropSelf(ATMBlocks.ANCIENT_STAIRS);
        this.dropSlab(ATMBlocks.ANCIENT_SLAB);
        
        this.dropSelf(ATMBlocks.ANCIENT_STONE);
        this.dropSelf(ATMBlocks.SMOOTH_ANCIENT_STONE);
        this.dropSelf(ATMBlocks.MOSSY_ANCIENT_STONE);
        this.dropSelf(ATMBlocks.ANCIENT_STONE_BRICKS);
        this.dropSelf(ATMBlocks.CHISELED_ANCIENT_STONE_BRICKS);
        this.dropSelf(ATMBlocks.CRACKED_ANCIENT_STONE_BRICKS);
        this.dropSelf(ATMBlocks.POLISHED_ANCIENT_STONE);
        this.dropSelf(ATMBlocks.ANCIENT_STONE_WALL);
        this.dropSelf(ATMBlocks.SMOOTH_ANCIENT_STONE_WALL);
        this.dropSelf(ATMBlocks.MOSSY_ANCIENT_STONE_WALL);
        this.dropSelf(ATMBlocks.ANCIENT_STONE_BRICK_WALL);
        this.dropSelf(ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_WALL);
        this.dropSelf(ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_WALL);
        this.dropSelf(ATMBlocks.POLISHED_ANCIENT_STONE_WALL);
        this.dropSelf(ATMBlocks.ANCIENT_STONE_STAIRS);
        this.dropSelf(ATMBlocks.SMOOTH_ANCIENT_STONE_STAIRS);
        this.dropSelf(ATMBlocks.MOSSY_ANCIENT_STONE_STAIRS);
        this.dropSelf(ATMBlocks.ANCIENT_STONE_BRICK_STAIRS);
        this.dropSelf(ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_STAIRS);
        this.dropSelf(ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_STAIRS);
        this.dropSelf(ATMBlocks.POLISHED_ANCIENT_STONE_STAIRS);
        this.dropSlab(ATMBlocks.ANCIENT_STONE_SLAB);
        this.dropSlab(ATMBlocks.SMOOTH_ANCIENT_STONE_SLAB);
        this.dropSlab(ATMBlocks.MOSSY_ANCIENT_STONE_SLAB);
        this.dropSlab(ATMBlocks.ANCIENT_STONE_BRICK_SLAB);
        this.dropSlab(ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_SLAB);
        this.dropSlab(ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_SLAB);
        this.dropSlab(ATMBlocks.POLISHED_ANCIENT_STONE_SLAB);
        
        this.dropSelf(ATMBlocks.SOUL_SAPLING);
        this.dropTallFlower(ATMBlocks.SOUL_HERB);
        this.dropSelf(ATMBlocks.SOUL_LOG_0);
        this.dropSelf(ATMBlocks.SOUL_LOG_1);
        this.dropSelf(ATMBlocks.SOUL_LOG_2);
        this.dropSelf(ATMBlocks.STRIPPED_SOUL_LOG);
        this.dropLeaves(ATMBlocks.SOUL_LEAVES, ATMBlocks.SOUL_SAPLING);
        this.dropLeaves(ATMBlocks.SOUL_LEAVES_BOTTOM, ATMBlocks.SOUL_SAPLING);
        this.dropSelf(ATMBlocks.SOUL_PLANKS);
        this.dropSelf(ATMBlocks.SOUL_TRAPDOOR);
        this.dropSelf(ATMBlocks.SOUL_FENCE);
        this.dropSelf(ATMBlocks.SOUL_FENCE_GATE);
        this.dropDoor(ATMBlocks.SOUL_DOOR);
        this.dropSelf(ATMBlocks.SOUL_BOOKSHELF);
        this.dropSelf(ATMBlocks.SOUL_STAIRS);
        this.dropSlab(ATMBlocks.SOUL_SLAB);
        
        this.dropSelf(ATMBlocks.DEMONIC_SAPLING);
        this.dropTallFlower(ATMBlocks.DEMONIC_HERB);
        this.dropSelf(ATMBlocks.DEMONIC_LOG);
        this.dropSelf(ATMBlocks.STRIPPED_DEMONIC_LOG);
        this.dropLeaves(ATMBlocks.DEMONIC_LEAVES, ATMBlocks.DEMONIC_SAPLING);
        this.dropLeaves(ATMBlocks.DEMONIC_LEAVES_BOTTOM, ATMBlocks.DEMONIC_SAPLING);
        this.dropSelf(ATMBlocks.DEMONIC_PLANKS);
        this.dropSelf(ATMBlocks.DEMONIC_TRAPDOOR);
        this.dropSelf(ATMBlocks.DEMONIC_FENCE);
        this.dropSelf(ATMBlocks.DEMONIC_FENCE_GATE);
        this.dropDoor(ATMBlocks.DEMONIC_DOOR);
        this.dropSelf(ATMBlocks.DEMONIC_BOOKSHELF);
        this.dropSelf(ATMBlocks.DEMONIC_STAIRS);
        this.dropSlab(ATMBlocks.DEMONIC_SLAB);
        
        this.add(ATMBlocks.SUS_CLAY.get(), BlockLootSubProvider.noDrop());
        this.add(ATMBlocks.SUS_SOUL_SAND.get(), BlockLootSubProvider.noDrop());
        
        this.dropSelf(ATMBlocks.TELEPORT_PAD);
    }
    
    private void dropOre(DeferredHolder<Block, ? extends Block> block, DeferredHolder<Item, ? extends Item> item) {
        this.add(block.get(), ore -> this.createOreDrop(ore, item.get()));
    }
    
    private void dropSelf(DeferredHolder<Block, ? extends Block> block) {
        this.dropSelf(block.get());
    }
    
    private void dropSlab(DeferredHolder<Block, ? extends Block> block) {
        this.add(block.get(), this::createSlabItemTable);
    }
    
    private void dropDoor(DeferredHolder<Block, ? extends Block> block) {
        this.add(block.get(), this::createDoorTable);
    }
    
    private void dropTallFlower(DeferredHolder<Block, ? extends Block> block) {
        this.add(block.get(), tallFlower -> this.createSinglePropConditionTable(tallFlower, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
    }
    
    private void dropLeaves(DeferredHolder<Block, ? extends Block> leaves, DeferredHolder<Block, ? extends Block> sapling) {
        this.add(leaves.get(), leafBlock -> this.createLeavesDrops(leafBlock, sapling.get(), BlockLootSubProvider.NORMAL_LEAVES_SAPLING_CHANCES));
    }
    
    private LootTable.Builder createSoulBerriesVineDrops(Block block) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(ATMItems.SOUL_BERRIES.get())
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(AncientCaveVines.BERRIES, true)
                                        )
                                )
                        )
                );
    }
    
    @Override
    protected void add(Block block, LootTable.Builder builder) {
        block.getLootTable().ifPresent(key -> this.tables.put(key, builder));
    }
}
