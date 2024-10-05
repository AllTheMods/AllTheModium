package com.thevortex.allthemodium.datagen.server;

import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.ItemRegistry;
import com.thevortex.allthemodium.registry.ModRegistry;
import com.thevortex.allthemodium.registry.TagRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemTags extends ItemTagsProvider {

    public ItemTags(
            DataGenerator generator,
            BlockTagsProvider blockTagsProvider,
            ExistingFileHelper existingFileHelper) {
        super(
                generator,
                blockTagsProvider,
                Reference.MOD_ID,
                existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(net.minecraft.tags.ItemTags.PLANKS)
                .add(ModRegistry.ANCIENT_PLANKS_ITEM.get());
        tag(net.minecraft.tags.ItemTags.LOGS)
                .add(ModRegistry.ANCIENT_LOG_0_ITEM.get());
        tag(net.minecraft.tags.ItemTags.LOGS)
                .add(ModRegistry.ANCIENT_LOG_1_ITEM.get());
        tag(net.minecraft.tags.ItemTags.LOGS)
                .add(ModRegistry.ANCIENT_LOG_2_ITEM.get());

        tag(net.minecraft.tags.ItemTags.PLANKS)
                .add(ModRegistry.DEMONIC_PLANKS_ITEM.get());
        tag(net.minecraft.tags.ItemTags.LOGS)
                .add(ModRegistry.DEMONIC_LOG_ITEM.get());

        tag(net.minecraft.tags.ItemTags.PLANKS)
                .add(ModRegistry.SOUL_PLANKS_ITEM.get());
        tag(net.minecraft.tags.ItemTags.LOGS)
                .add(ModRegistry.SOUL_LOG_ITEM.get());
        tag(net.minecraft.tags.ItemTags.LOGS)
                .add(ModRegistry.SOUL_LOG_0_ITEM.get());
        tag(net.minecraft.tags.ItemTags.LOGS)
                .add(ModRegistry.SOUL_LOG_1_ITEM.get());
        tag(net.minecraft.tags.ItemTags.LOGS)
                .add(ModRegistry.SOUL_LOG_2_ITEM.get());

        tag(TagRegistry.SAPLINGS).add(ModRegistry.SOUL_SAPLING_ITEM.get());
        tag(TagRegistry.SAPLINGS).add(ModRegistry.DEMONIC_SAPLING_ITEM.get());
        tag(TagRegistry.SAPLINGS).add(ModRegistry.ANCIENT_SAPLING_ITEM.get());

        tag(net.minecraft.tags.ItemTags.STONE_CRAFTING_MATERIALS)
                .add(ModRegistry.ANCIENT_STONE_ITEM.get());
        tag(net.minecraft.tags.ItemTags.STONE_TOOL_MATERIALS)
                .add(ModRegistry.ANCIENT_STONE_ITEM.get());

        tag(TagRegistry.FORGE_PICKAXES)
                .add(ModRegistry.ALLTHEMODIUM_PICKAXE.get());

        tag(TagRegistry.FORGE_AXES).add(ModRegistry.ALLTHEMODIUM_AXE.get());

        tag(TagRegistry.FORGE_SHOVELS)
                .add(ModRegistry.ALLTHEMODIUM_SHOVEL.get());

        tag(TagRegistry.FORGE_HOES).add(ModRegistry.ALLTHEMODIUM_HOE.get());

        tag(TagRegistry.FORGE_SWORDS).add(ModRegistry.ALLTHEMODIUM_SWORD.get());
        tag(TagRegistry.FORGE_SWORDS).add(ItemRegistry.ATM_ALLOY_SWORD.get());

        tag(TagRegistry.FORGE_PICKAXES).add(ItemRegistry.ATM_ALLOY_PICK.get());
        tag(TagRegistry.FORGE_PICKAXES).add(ItemRegistry.ATM_ALLOY_PAXEL.get());

        tag(TagRegistry.FORGE_AXES).add(ItemRegistry.ATM_ALLOY_AXE.get());

        tag(TagRegistry.FORGE_AXES).add(ItemRegistry.ATM_ALLOY_PAXEL.get());

        tag(TagRegistry.FORGE_SHOVELS).add(ItemRegistry.ATM_ALLOY_SHOVEL.get());
        tag(TagRegistry.FORGE_SHOVELS).add(ItemRegistry.ATM_ALLOY_PAXEL.get());

        tag(Tags.Items.SHEARS).add(ItemRegistry.ATM_ALLOY_PAXEL.get());

        tag(TagRegistry.FORGE_HOES).add(ItemRegistry.ATM_ALLOY_PAXEL.get());

        tag(TagRegistry.PIGLIN_LOVED)
                .add(ModRegistry.ALLTHEMODIUM_PICKAXE.get());

        tag(TagRegistry.PIGLIN_LOVED).add(ModRegistry.ALLTHEMODIUM_AXE.get());

        tag(TagRegistry.PIGLIN_LOVED)
                .add(ModRegistry.ALLTHEMODIUM_SHOVEL.get());

        tag(TagRegistry.PIGLIN_LOVED).add(ModRegistry.ALLTHEMODIUM_HOE.get());

        tag(TagRegistry.PIGLIN_LOVED).add(ModRegistry.ALLTHEMODIUM_BOOTS.get());
        tag(TagRegistry.PIGLIN_LOVED)
                .add(ModRegistry.ALLTHEMODIUM_LEGGINGS.get());
        tag(TagRegistry.PIGLIN_LOVED)
                .add(ModRegistry.ALLTHEMODIUM_CHESTPLATE.get());
        tag(TagRegistry.PIGLIN_LOVED)
                .add(ModRegistry.ALLTHEMODIUM_HELMET.get());

        tag(TagRegistry.ANCIENT_WOODEN_PLANKS_ITEM)
                .add(ModRegistry.ANCIENT_PLANKS_ITEM.get());
        tag(TagRegistry.DEMONIC_WOODEN_PLANKS_ITEM)
                .add(ModRegistry.DEMONIC_PLANKS_ITEM.get());
        tag(TagRegistry.SOUL_WOODEN_PLANKS_ITEM)
                .add(ModRegistry.SOUL_PLANKS_ITEM.get());
        tag(TagRegistry.ANCIENT_STONE_ITEM)
                .add(ModRegistry.ANCIENT_STONE_ITEM.get());
        tag(TagRegistry.ANCIENT_MOSSY_STONE_ITEM)
                .add(ModRegistry.ANCIENT_MOSSY_STONE_ITEM.get());
        tag(TagRegistry.ANCIENT_POLISHED_STONE_ITEM)
                .add(ModRegistry.ANCIENT_POLISHED_STONE_ITEM.get());
        tag(TagRegistry.ANCIENT_SMOOTH_STONE_ITEM)
                .add(ModRegistry.ANCIENT_SMOOTH_STONE_ITEM.get());
        tag(TagRegistry.ANCIENT_STONE_BRICKS_ITEM)
                .add(ModRegistry.ANCIENT_STONE_BRICKS_ITEM.get());
        tag(TagRegistry.ANCIENT_CRACKED_STONE_BRICKS_ITEM)
                .add(ModRegistry.ANCIENT_CRACKED_STONE_BRICKS_ITEM.get());
        tag(TagRegistry.ANCIENT_CHISELED_STONE_BRICKS_ITEM)
                .add(ModRegistry.ANCIENT_CHISELED_STONE_BRICKS_ITEM.get());

        tag(TagRegistry.RAW_ALLTHEMODIUM)
                .add(ModRegistry.RAW_ALLTHEMODIUM.get());
        tag(TagRegistry.RAW_VIBRANIUM).add(ModRegistry.RAW_VIBRANIUM.get());
        tag(TagRegistry.RAW_UNOBTAINIUM).add(ModRegistry.RAW_UNOBTAINIUM.get());

        tag(TagRegistry.RAW_MATERIALS).add(ModRegistry.RAW_ALLTHEMODIUM.get());
        tag(TagRegistry.RAW_MATERIALS).add(ModRegistry.RAW_VIBRANIUM.get());
        tag(TagRegistry.RAW_MATERIALS).add(ModRegistry.RAW_UNOBTAINIUM.get());

        tag(TagRegistry.RAW_ALLTHEMODIUM_FORGE)
                .add(ModRegistry.RAW_ALLTHEMODIUM.get());
        tag(TagRegistry.RAW_VIBRANIUM_FORGE)
                .add(ModRegistry.RAW_VIBRANIUM.get());
        tag(TagRegistry.RAW_UNOBTAINIUM_FORGE)
                .add(ModRegistry.RAW_UNOBTAINIUM.get());

        tag(TagRegistry.ALLTHEMODIUM_INGOT)
                .add(ModRegistry.ALLTHEMODIUM_INGOT.get());
        tag(TagRegistry.VIBRANIUM_INGOT).add(ModRegistry.VIBRANIUM_INGOT.get());
        tag(TagRegistry.UNOBTAINIUM_INGOT)
                .add(ModRegistry.UNOBTAINIUM_INGOT.get());

        tag(TagRegistry.VIBRANIUM_ALLTHEMODIUM_INGOT)
                .add(ModRegistry.VIBRANIUM_ALLTHEMODIUM_ALLOY.get());
        tag(TagRegistry.UNOBTAINIUM_ALLTHEMODIUM_INGOT)
                .add(ModRegistry.UNOBTAINIUM_ALLTHEMODIUM_ALLOY.get());
        tag(TagRegistry.UNOBTAINIUM_VIBRANIUM_INGOT)
                .add(ModRegistry.UNOBTAINIUM_VIBRANIUM_ALLOY.get());

        tag(TagRegistry.VIBRANIUM_ALLTHEMODIUM_BLOCK)
                .add(ModRegistry.VA_ALLOY_ITEM.get());
        tag(TagRegistry.UNOBTAINIUM_ALLTHEMODIUM_BLOCK)
                .add(ModRegistry.UA_ALLOY_ITEM.get());
        tag(TagRegistry.UNOBTAINIUM_VIBRANIUM_BLOCK)
                .add(ModRegistry.UV_ALLOY_ITEM.get());

        tag(TagRegistry.ALLTHEMODIUM_DUST)
                .add(ModRegistry.ALLTHEMODIUM_DUST.get());
        tag(TagRegistry.VIBRANIUM_DUST).add(ModRegistry.VIBRANIUM_DUST.get());
        tag(TagRegistry.UNOBTAINIUM_DUST)
                .add(ModRegistry.UNOBTAINIUM_DUST.get());

        tag(TagRegistry.DUSTS).add(ModRegistry.ALLTHEMODIUM_DUST.get());
        tag(TagRegistry.DUSTS).add(ModRegistry.VIBRANIUM_DUST.get());
        tag(TagRegistry.DUSTS).add(ModRegistry.UNOBTAINIUM_DUST.get());

        tag(TagRegistry.INGOTS).add(ModRegistry.ALLTHEMODIUM_INGOT.get());
        tag(TagRegistry.INGOTS).add(ModRegistry.VIBRANIUM_INGOT.get());
        tag(TagRegistry.INGOTS).add(ModRegistry.UNOBTAINIUM_INGOT.get());

        tag(TagRegistry.ALLTHEMODIUM_NUGGET)
                .add(ModRegistry.ALLTHEMODIUM_NUGGET.get());
        tag(TagRegistry.VIBRANIUM_NUGGET)
                .add(ModRegistry.VIBRANIUM_NUGGET.get());
        tag(TagRegistry.UNOBTAINIUM_NUGGET)
                .add(ModRegistry.UNOBTAINIUM_NUGGET.get());

        tag(TagRegistry.ALLTHEMODIUM_BLOCK_ITEM)
                .add(ModRegistry.ALLTHEMODIUM_BLOCK_ITEM.get());
        tag(TagRegistry.VIBRANIUM_BLOCK_ITEM)
                .add(ModRegistry.VIBRANIUM_BLOCK_ITEM.get());
        tag(TagRegistry.UNOBTAINIUM_BLOCK_ITEM)
                .add(ModRegistry.UNOBTAINIUM_BLOCK_ITEM.get());

        tag(TagRegistry.RAW_ALLTHEMODIUM_BLOCK)
                .add(ModRegistry.RAW_ALLTHEMODIUM_BLOCK_ITEM.get());
        tag(TagRegistry.RAW_VIBRANIUM_BLOCK)
                .add(ModRegistry.RAW_VIBRANIUM_BLOCK_ITEM.get());
        tag(TagRegistry.RAW_UNOBTAINIUM_BLOCK)
                .add(ModRegistry.RAW_UNOBTAINIUM_BLOCK_ITEM.get());

        tag(TagRegistry.ALLTHEMODIUM_ORE_ITEM)
                .add(ModRegistry.ALLTHEMODIUM_ORE_ITEM.get());
        tag(TagRegistry.ALLTHEMODIUM_ORE_ITEM)
                .add(ModRegistry.ALLTHEMODIUM_SLATE_ORE_ITEM.get());
        tag(TagRegistry.VIBRANIUM_ORE_ITEM)
                .add(ModRegistry.VIBRANIUM_ORE_ITEM.get());
        tag(TagRegistry.VIBRANIUM_ORE_ITEM)
                .add(ModRegistry.OTHER_VIBRANIUM_ORE_ITEM.get());
        tag(TagRegistry.UNOBTAINIUM_ORE_ITEM)
                .add(ModRegistry.UNOBTAINIUM_ORE_ITEM.get());

        tag(TagRegistry.ORES).add(ModRegistry.ALLTHEMODIUM_ORE_ITEM.get());
        tag(TagRegistry.ORES)
                .add(ModRegistry.ALLTHEMODIUM_SLATE_ORE_ITEM.get());
        tag(TagRegistry.ORES).add(ModRegistry.VIBRANIUM_ORE_ITEM.get());
        tag(TagRegistry.ORES).add(ModRegistry.OTHER_VIBRANIUM_ORE_ITEM.get());
        tag(TagRegistry.ORES).add(ModRegistry.UNOBTAINIUM_ORE_ITEM.get());

        tag(TagRegistry.ALLTHEMODIUM_GEAR).add(ModRegistry.ATM_GEAR.get());
        tag(TagRegistry.VIBRANIUM_GEAR).add(ModRegistry.VIB_GEAR.get());
        tag(TagRegistry.UNOBTAINIUM_GEAR).add(ModRegistry.UNOB_GEAR.get());

        tag(TagRegistry.ALLTHEMODIUM_PLATE).add(ModRegistry.ATM_PLATE.get());
        tag(TagRegistry.VIBRANIUM_PLATE).add(ModRegistry.VIB_PLATE.get());
        tag(TagRegistry.UNOBTAINIUM_PLATE).add(ModRegistry.UNOB_PLATE.get());

        tag(TagRegistry.ALLTHEMODIUM_ROD).add(ModRegistry.ATM_ROD.get());
        tag(TagRegistry.VIBRANIUM_ROD).add(ModRegistry.VIB_ROD.get());
        tag(TagRegistry.UNOBTAINIUM_ROD).add(ModRegistry.UNOB_ROD.get());

        tag(TagRegistry.ALLTHEMODIUM_SHARD).add(ModRegistry.ATM_SHARD.get());
        tag(TagRegistry.VIBRANIUM_SHARD).add(ModRegistry.VIB_SHARD.get());
        tag(TagRegistry.UNOBTAINIUM_SHARD).add(ModRegistry.UNOB_SHARD.get());

        tag(TagRegistry.ALLTHEMODIUM_CLUMP).add(ModRegistry.ATM_CLUMP.get());
        tag(TagRegistry.VIBRANIUM_CLUMP).add(ModRegistry.VIB_CLUMP.get());
        tag(TagRegistry.UNOBTAINIUM_CLUMP).add(ModRegistry.UNOB_CLUMP.get());

        tag(TagRegistry.ALLTHEMODIUM_CRYSTAL)
                .add(ModRegistry.ATM_CRYSTAL.get());
        tag(TagRegistry.VIBRANIUM_CRYSTAL).add(ModRegistry.VIB_CRYSTAL.get());
        tag(TagRegistry.UNOBTAINIUM_CRYSTAL)
                .add(ModRegistry.UNOB_CRYSTAL.get());

        tag(TagRegistry.ALLTHEMODIUM_DIRTY_DUST)
                .add(ModRegistry.ATM_DIRTY.get());
        tag(TagRegistry.VIBRANIUM_DIRTY_DUST).add(ModRegistry.VIB_DIRTY.get());
        tag(TagRegistry.UNOBTAINIUM_DIRTY_DUST)
                .add(ModRegistry.UNOB_DIRTY.get());

        tag(TagRegistry.SHARD).add(ModRegistry.ATM_SHARD.get());
        tag(TagRegistry.SHARD).add(ModRegistry.VIB_SHARD.get());
        tag(TagRegistry.SHARD).add(ModRegistry.UNOB_SHARD.get());

        tag(TagRegistry.CLUMP).add(ModRegistry.ATM_CLUMP.get());
        tag(TagRegistry.CLUMP).add(ModRegistry.VIB_CLUMP.get());
        tag(TagRegistry.CLUMP).add(ModRegistry.UNOB_CLUMP.get());

        tag(TagRegistry.CRYSTAL).add(ModRegistry.ATM_CRYSTAL.get());
        tag(TagRegistry.CRYSTAL).add(ModRegistry.VIB_CRYSTAL.get());
        tag(TagRegistry.CRYSTAL).add(ModRegistry.UNOB_CRYSTAL.get());

        tag(TagRegistry.DIRTY_DUST).add(ModRegistry.ATM_DIRTY.get());
        tag(TagRegistry.DIRTY_DUST).add(ModRegistry.VIB_DIRTY.get());
        tag(TagRegistry.DIRTY_DUST).add(ModRegistry.UNOB_DIRTY.get());
    }
}
