package net.allthemods.allthemodium.data.provider.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import net.allthemods.allthemodium.core.registry.ATMEntities;
import net.allthemods.allthemodium.core.registry.ATMItems;

public class ATMEntityLoot extends EntityLootSubProvider {
    
    protected ATMEntityLoot(HolderLookup.Provider registries) {
        super(FeatureFlags.DEFAULT_FLAGS, FeatureFlagSet.of(), registries);
    }
    
    @Override
    public void generate() {
        this.add(
                ATMEntities.PIGLICH.get(),
                LootTable.lootTable().withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ATMItems.PIGLICH_HEART.get())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                )
                )
        );
    }
}
