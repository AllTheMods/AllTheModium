package com.thevortex.allthemodium.datagen.server;


import com.thevortex.allthemodium.init.ModItems;
import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.reference.TagRegistry;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemTags extends ItemTagsProvider {


    public ItemTags(DataGenerator generator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(generator, blockTagsProvider, Reference.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {

        tag(net.minecraft.tags.ItemTags.PLANKS).add(ModRegistry.ANCIENT_PLANKS_ITEM.get());
        tag(net.minecraft.tags.ItemTags.LOGS).add(ModRegistry.ANCIENT_LOG_0_ITEM.get());
        tag(net.minecraft.tags.ItemTags.LOGS).add(ModRegistry.ANCIENT_LOG_1_ITEM.get());
        tag(net.minecraft.tags.ItemTags.LOGS).add(ModRegistry.ANCIENT_LOG_2_ITEM.get());

        tag(net.minecraft.tags.ItemTags.PLANKS).add(ModRegistry.DEMONIC_PLANKS_ITEM.get());
        tag(net.minecraft.tags.ItemTags.LOGS).add(ModRegistry.DEMONIC_LOG_ITEM.get());

        tag(net.minecraft.tags.ItemTags.PLANKS).add(ModRegistry.SOUL_PLANKS_ITEM.get());
        tag(net.minecraft.tags.ItemTags.LOGS).add(ModRegistry.SOUL_LOG_ITEM.get());
        tag(net.minecraft.tags.ItemTags.LOGS).add(ModRegistry.SOUL_LOG_0_ITEM.get());
        tag(net.minecraft.tags.ItemTags.LOGS).add(ModRegistry.SOUL_LOG_1_ITEM.get());
        tag(net.minecraft.tags.ItemTags.LOGS).add(ModRegistry.SOUL_LOG_2_ITEM.get());

        tag(net.minecraft.tags.ItemTags.STONE_CRAFTING_MATERIALS).add(ModRegistry.ANCIENT_STONE_ITEM.get());
        tag(net.minecraft.tags.ItemTags.STONE_TOOL_MATERIALS).add(ModRegistry.ANCIENT_STONE_ITEM.get());

        tag(TagRegistry.FORGE_PICKAXES).add(ModRegistry.ALLTHEMODIUM_PICKAXE.get());
        tag(TagRegistry.FORGE_PICKAXES).add(ModRegistry.VIBRANIUM_PICKAXE.get());
        tag(TagRegistry.FORGE_PICKAXES).add(ModRegistry.UNOBTAINIUM_PICKAXE.get());

        tag(TagRegistry.FORGE_AXES).add(ModRegistry.ALLTHEMODIUM_AXE.get());
        tag(TagRegistry.FORGE_AXES).add(ModRegistry.VIBRANIUM_AXE.get());
        tag(TagRegistry.FORGE_AXES).add(ModRegistry.UNOBTAINIUM_AXE.get());

        tag(TagRegistry.FORGE_SHOVELS).add(ModRegistry.ALLTHEMODIUM_SHOVEL.get());
        tag(TagRegistry.FORGE_SHOVELS).add(ModRegistry.VIBRANIUM_SHOVEL.get());
        tag(TagRegistry.FORGE_SHOVELS).add(ModRegistry.UNOBTAINIUM_SHOVEL.get());

        tag(TagRegistry.FORGE_HOES).add(ModRegistry.ALLTHEMODIUM_HOE.get());
        tag(TagRegistry.FORGE_HOES).add(ModRegistry.VIBRANIUM_HOE.get());
        tag(TagRegistry.FORGE_HOES).add(ModRegistry.UNOBTAINIUM_HOE.get());


        tag(TagRegistry.PIGLIN_LOVED).add(ModRegistry.ALLTHEMODIUM_PICKAXE.get());
        tag(TagRegistry.PIGLIN_LOVED).add(ModRegistry.VIBRANIUM_PICKAXE.get());
        tag(TagRegistry.PIGLIN_LOVED).add(ModRegistry.UNOBTAINIUM_PICKAXE.get());

        tag(TagRegistry.PIGLIN_LOVED).add(ModRegistry.ALLTHEMODIUM_AXE.get());
        tag(TagRegistry.PIGLIN_LOVED).add(ModRegistry.VIBRANIUM_AXE.get());
        tag(TagRegistry.PIGLIN_LOVED).add(ModRegistry.UNOBTAINIUM_AXE.get());

        tag(TagRegistry.PIGLIN_LOVED).add(ModRegistry.ALLTHEMODIUM_SHOVEL.get());
        tag(TagRegistry.PIGLIN_LOVED).add(ModRegistry.VIBRANIUM_SHOVEL.get());
        tag(TagRegistry.PIGLIN_LOVED).add(ModRegistry.UNOBTAINIUM_SHOVEL.get());

        tag(TagRegistry.PIGLIN_LOVED).add(ModRegistry.ALLTHEMODIUM_HOE.get());
        tag(TagRegistry.PIGLIN_LOVED).add(ModRegistry.VIBRANIUM_HOE.get());
        tag(TagRegistry.PIGLIN_LOVED).add(ModRegistry.UNOBTAINIUM_HOE.get());

        tag(TagRegistry.PIGLIN_LOVED).add(ModItems.ALLTHEMODIUM_BOOTS);
        tag(TagRegistry.PIGLIN_LOVED).add(ModItems.VIBRANIUM_BOOTS);
        tag(TagRegistry.PIGLIN_LOVED).add(ModItems.UNOBTAINIUM_BOOTS);

        tag(TagRegistry.PIGLIN_LOVED).add(ModItems.ALLTHEMODIUM_LEGGINGS);
        tag(TagRegistry.PIGLIN_LOVED).add(ModItems.VIBRANIUM_LEGGINGS);
        tag(TagRegistry.PIGLIN_LOVED).add(ModItems.UNOBTAINIUM_LEGGINGS);

        tag(TagRegistry.PIGLIN_LOVED).add(ModItems.ALLTHEMODIUM_CHESTPLATE);
        tag(TagRegistry.PIGLIN_LOVED).add(ModItems.VIBRANIUM_CHESTPLATE);
        tag(TagRegistry.PIGLIN_LOVED).add(ModItems.UNOBTAINIUM_CHESTPLATE);

        tag(TagRegistry.PIGLIN_LOVED).add(ModItems.ALLTHEMODIUM_HELMET);
        tag(TagRegistry.PIGLIN_LOVED).add(ModItems.VIBRANIUM_HELMET);
        tag(TagRegistry.PIGLIN_LOVED).add(ModItems.UNOBTAINIUM_HELMET);

        tag(TagRegistry.ANCIENT_WOODEN_PLANKS_ITEM).add(ModRegistry.ANCIENT_PLANKS_ITEM.get());
        tag(TagRegistry.DEMONIC_WOODEN_PLANKS_ITEM).add(ModRegistry.DEMONIC_PLANKS_ITEM.get());
        tag(TagRegistry.SOUL_WOODEN_PLANKS_ITEM).add(ModRegistry.SOUL_PLANKS_ITEM.get());
        tag(TagRegistry.ANCIENT_STONE_ITEM).add(ModRegistry.ANCIENT_STONE_ITEM.get());
        tag(TagRegistry.ANCIENT_MOSSY_STONE_ITEM).add(ModRegistry.ANCIENT_MOSSY_STONE_ITEM.get());
        tag(TagRegistry.ANCIENT_POLISHED_STONE_ITEM).add(ModRegistry.ANCIENT_POLISHED_STONE_ITEM.get());
        tag(TagRegistry.ANCIENT_SMOOTH_STONE_ITEM).add(ModRegistry.ANCIENT_SMOOTH_STONE_ITEM.get());
        tag(TagRegistry.ANCIENT_STONE_BRICKS_ITEM).add(ModRegistry.ANCIENT_STONE_BRICKS_ITEM.get());
        tag(TagRegistry.ANCIENT_CRACKED_STONE_BRICKS_ITEM).add(ModRegistry.ANCIENT_CRACKED_STONE_BRICKS_ITEM.get());
        tag(TagRegistry.ANCIENT_CHISELED_STONE_BRICKS_ITEM).add(ModRegistry.ANCIENT_CHISELED_STONE_BRICKS_ITEM.get());

        tag(TagRegistry.RAW_ALLTHEMODIUM).add(ModRegistry.RAW_ALLTHEMODIUM.get());
        tag(TagRegistry.RAW_VIBRANIUM).add(ModRegistry.RAW_VIBRANIUM.get());
        tag(TagRegistry.RAW_UNOBTAINIUM).add(ModRegistry.RAW_UNOBTAINIUM.get());

        tag(TagRegistry.RAW_ALLTHEMODIUM_FORGE).add(ModRegistry.RAW_ALLTHEMODIUM.get());
        tag(TagRegistry.RAW_VIBRANIUM_FORGE).add(ModRegistry.RAW_VIBRANIUM.get());
        tag(TagRegistry.RAW_UNOBTAINIUM_FORGE).add(ModRegistry.RAW_UNOBTAINIUM.get());

        tag(TagRegistry.ALLTHEMODIUM_INGOT).add(ModRegistry.ALLTHEMODIUM_INGOT.get());
        tag(TagRegistry.VIBRANIUM_INGOT).add(ModRegistry.VIBRANIUM_INGOT.get());
        tag(TagRegistry.UNOBTAINIUM_INGOT).add(ModRegistry.UNOBTAINIUM_INGOT.get());

        tag(TagRegistry.VIBRANIUM_ALLTHEMODIUM_INGOT).add(ModItems.VIBRANIUM_ALLTHEMODIUM_ALLOY);
        tag(TagRegistry.UNOBTAINIUM_ALLTHEMODIUM_INGOT).add(ModItems.UNOBTAINIUM_ALLTHEMODIUM_ALLOY);
        tag(TagRegistry.UNOBTAINIUM_VIBRANIUM_INGOT).add(ModItems.UNOBTAINIUM_VIBRANIUM_ALLOY);

        tag(TagRegistry.VIBRANIUM_ALLTHEMODIUM_BLOCK).add(ModRegistry.VA_ALLOY_ITEM.get());
        tag(TagRegistry.UNOBTAINIUM_ALLTHEMODIUM_BLOCK).add(ModRegistry.UA_ALLOY_ITEM.get());
        tag(TagRegistry.UNOBTAINIUM_VIBRANIUM_BLOCK).add(ModRegistry.UV_ALLOY_ITEM.get());

        tag(TagRegistry.ALLTHEMODIUM_DUST).add(ModRegistry.ALLTHEMODIUM_DUST.get());
        tag(TagRegistry.VIBRANIUM_DUST).add(ModRegistry.VIBRANIUM_DUST.get());
        tag(TagRegistry.UNOBTAINIUM_DUST).add(ModRegistry.UNOBTAINIUM_DUST.get());

        tag(TagRegistry.ALLTHEMODIUM_NUGGET).add(ModRegistry.ALLTHEMODIUM_NUGGET.get());
        tag(TagRegistry.VIBRANIUM_NUGGET).add(ModRegistry.VIBRANIUM_NUGGET.get());
        tag(TagRegistry.UNOBTAINIUM_NUGGET).add(ModRegistry.UNOBTAINIUM_NUGGET.get());

        tag(TagRegistry.ALLTHEMODIUM_BLOCK_ITEM).add(ModRegistry.ALLTHEMODIUM_BLOCK_ITEM.get());
        tag(TagRegistry.VIBRANIUM_BLOCK_ITEM).add(ModRegistry.VIBRANIUM_BLOCK_ITEM.get());
        tag(TagRegistry.UNOBTAINIUM_BLOCK_ITEM).add(ModRegistry.UNOBTAINIUM_BLOCK_ITEM.get());

        tag(TagRegistry.RAW_ALLTHEMODIUM_BLOCK).add(ModRegistry.RAW_ALLTHEMODIUM_BLOCK_ITEM.get());
        tag(TagRegistry.RAW_VIBRANIUM_BLOCK).add(ModRegistry.RAW_VIBRANIUM_BLOCK_ITEM.get());
        tag(TagRegistry.RAW_UNOBTAINIUM_BLOCK).add(ModRegistry.RAW_UNOBTAINIUM_BLOCK_ITEM.get());


        tag(TagRegistry.ALLTHEMODIUM_ORE_ITEM).add(ModRegistry.ALLTHEMODIUM_ORE_ITEM.get());
        tag(TagRegistry.ALLTHEMODIUM_ORE_ITEM).add(ModRegistry.ALLTHEMODIUM_SLATE_ORE_ITEM.get());
        tag(TagRegistry.VIBRANIUM_ORE_ITEM).add(ModRegistry.VIBRANIUM_ORE_ITEM.get());
        tag(TagRegistry.VIBRANIUM_ORE_ITEM).add(ModRegistry.OTHER_VIBRANIUM_ORE_ITEM.get());
        tag(TagRegistry.UNOBTAINIUM_ORE_ITEM).add(ModRegistry.UNOBTAINIUM_ORE_ITEM.get());

        tag(TagRegistry.ALLTHEMODIUM_GEAR).add(ModRegistry.ATM_GEAR.get());
        tag(TagRegistry.VIBRANIUM_GEAR).add(ModRegistry.VIB_GEAR.get());
        tag(TagRegistry.UNOBTAINIUM_GEAR).add(ModRegistry.ONOB_GEAR.get());

        tag(TagRegistry.ALLTHEMODIUM_PLATE).add(ModRegistry.ATM_PLATE.get());
        tag(TagRegistry.VIBRANIUM_PLATE).add(ModRegistry.VIB_PLATE.get());
        tag(TagRegistry.UNOBTAINIUM_PLATE).add(ModRegistry.ONOB_PLATE.get());

        tag(TagRegistry.ALLTHEMODIUM_ROD).add(ModRegistry.ATM_ROD.get());
        tag(TagRegistry.VIBRANIUM_ROD).add(ModRegistry.VIB_ROD.get());
        tag(TagRegistry.UNOBTAINIUM_ROD).add(ModRegistry.ONOB_ROD.get());

    }
}
