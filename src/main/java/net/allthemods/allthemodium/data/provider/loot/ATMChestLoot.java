package net.allthemods.allthemodium.data.provider.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.EnchantWithLevelsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.core.registry.ATMItems;

import java.util.function.BiConsumer;

public record ATMChestLoot(HolderLookup.Provider registries) implements LootTableSubProvider {
    
    public static final ResourceKey<LootTable> ARCH = ATMChestLoot.create("arch");
    public static final ResourceKey<LootTable> ARCH2 = ATMChestLoot.create("arch2");
    
    public static final ResourceKey<LootTable> GENERIC_LOOT = ATMChestLoot.create("chest/generic_loot");
    public static final ResourceKey<LootTable> HALLWAY_LOOT = ATMChestLoot.create("chest/hallway_loot");
    public static final ResourceKey<LootTable> LIBRARY_LOOT = ATMChestLoot.create("chest/library_loot");
    public static final ResourceKey<LootTable> TEMPLATE = ATMChestLoot.create("chest/template");
    public static final ResourceKey<LootTable> TREASURE_ROOM = ATMChestLoot.create("chest/treasure_room");
    public static final ResourceKey<LootTable> TREASURE_ROOM_LOOT = ATMChestLoot.create("chest/treasure_room_loot");
    
    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output) {
        output.accept(ATMChestLoot.ARCH, ATMChestLoot.singleItemTable(ATMItems.ALLTHEMODIUM_SMITHING_TEMPLATE.get()));
        output.accept(ATMChestLoot.ARCH2, ATMChestLoot.singleItemTable(ATMItems.VIBRANIUM_SMITHING_TEMPLATE.get()));
        output.accept(ATMChestLoot.GENERIC_LOOT, this.commonLootTable(8, true));
        output.accept(ATMChestLoot.HALLWAY_LOOT, this.commonLootTable(10, true));
        output.accept(ATMChestLoot.LIBRARY_LOOT, this.commonLootTable(12, false));
        output.accept(ATMChestLoot.TREASURE_ROOM, this.commonLootTable(18, true));
        output.accept(ATMChestLoot.TREASURE_ROOM_LOOT, this.commonLootTable(18, true));
        output.accept(ATMChestLoot.TEMPLATE, ATMChestLoot.singleItemTable(ATMItems.UNOBTAINIUM_SMITHING_TEMPLATE.get()));
    }
    
    private LootTable.Builder commonLootTable(int maxRolls, boolean includeGoldenApple) {
        LootPool.Builder pool = LootPool.lootPool()
                .setRolls(UniformGenerator.between(1.0F, maxRolls))
                .add(this.weightedItem(ATMItems.VIBRANIUM_NUGGET.get(), 10, 4, 8))
                .add(this.weightedItem(Items.GOLD_INGOT, 7, 64, 128))
                .add(this.weightedItem(Items.GOLD_NUGGET, 12, 64, 128))
                .add(this.enchantedItem(Items.BOOK, 42, 80))
                .add(this.weightedItem(Items.DIAMOND, 12, 10, 40))
                .add(this.weightedItem(Items.EMERALD, 13, 10, 40))
                .add(this.weightedItem(ATMItems.ALLTHEMODIUM_NUGGET.get(), 10, 25, 50))
                .add(this.enchantedItem(Items.DIAMOND_SWORD, 5, 80))
                .add(this.enchantedItem(Items.NETHERITE_SWORD, 5, 55))
                .add(this.enchantedItem(Items.NETHERITE_HELMET, 5, 55))
                .add(this.enchantedItem(Items.NETHERITE_CHESTPLATE, 5, 55))
                .add(this.enchantedItem(Items.NETHERITE_LEGGINGS, 5, 55))
                .add(this.enchantedItem(Items.NETHERITE_BOOTS, 5, 55));
        
        if (includeGoldenApple) {
            pool.add(LootItem.lootTableItem(Items.GOLDEN_APPLE));
        }
        
        return LootTable.lootTable().withPool(pool);
    }
    
    private LootPoolSingletonContainer.Builder<?> weightedItem(ItemLike item, int weight, int min, int max) {
        return LootItem.lootTableItem(item)
                .setWeight(weight)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)));
    }
    
    private LootPoolSingletonContainer.Builder<?> enchantedItem(ItemLike item, int weight, int levels) {
        return LootItem.lootTableItem(item)
                .setWeight(weight)
                .apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, ConstantValue.exactly(levels)));
    }
    
    private static LootTable.Builder singleItemTable(ItemLike item) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(item)));
    }
    
    private static ResourceKey<LootTable> create(String path) {
        return ATM.key(Registries.LOOT_TABLE, path);
    }
}
