package com.thevortex.allthemodium.datagen.server;


import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.TagRegistry;
import com.thevortex.allthemodium.registry.mek_reg.MekProcReg;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.internal.NeoForgeItemTagsProvider;

import java.util.concurrent.CompletableFuture;

import org.checkerframework.checker.units.qual.t;

public class ATMItemTags extends ItemTagsProvider {


    public ATMItemTags(PackOutput packOutPut, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagsProvider.TagLookup<Block>> tagLookup, ExistingFileHelper existingFileHelper) {
        super(packOutPut, lookupProvider,tagLookup, Reference.MOD_ID, existingFileHelper);
    }


    @Override
    protected void addTags(HolderLookup.Provider provider) {
        
        tag(TagRegistry.ATM_CHESTPLATES).add(ModRegistry.ALLTHEMODIUM_CHESTPLATE.get());
        tag(TagRegistry.ATM_CHESTPLATES).add(ModRegistry.VIBRANIUM_CHESTPLATE.get());
        tag(TagRegistry.ATM_CHESTPLATES).add(ModRegistry.UNOBTAINIUM_CHESTPLATE.get());

        tag(TagRegistry.ATM_HELMETS).add(ModRegistry.ALLTHEMODIUM_HELMET.get());
        tag(TagRegistry.ATM_HELMETS).add(ModRegistry.VIBRANIUM_HELMET.get());
        tag(TagRegistry.ATM_HELMETS).add(ModRegistry.UNOBTAINIUM_HELMET.get());

        tag(TagRegistry.ATM_LEGGINGS).add(ModRegistry.ALLTHEMODIUM_LEGGINGS.get());
        tag(TagRegistry.ATM_LEGGINGS).add(ModRegistry.VIBRANIUM_LEGGINGS.get());
        tag(TagRegistry.ATM_LEGGINGS).add(ModRegistry.UNOBTAINIUM_LEGGINGS.get());

        tag(TagRegistry.ATM_BOOTS).add(ModRegistry.ALLTHEMODIUM_BOOTS.get());
        tag(TagRegistry.ATM_BOOTS).add(ModRegistry.VIBRANIUM_BOOTS.get());
        tag(TagRegistry.ATM_BOOTS).add(ModRegistry.UNOBTAINIUM_BOOTS.get());
        
        tag(TagRegistry.UNOBATM_ALLOY).add(ModRegistry.UNOBTAINIUM_ALLTHEMODIUM_ALLOY.get());
        tag(ItemTags.ARMOR_ENCHANTABLE).add(ModRegistry.ALLTHEMODIUM_HELMET.get());
        tag(ItemTags.ARMOR_ENCHANTABLE).add(ModRegistry.ALLTHEMODIUM_CHESTPLATE.get());
        tag(ItemTags.ARMOR_ENCHANTABLE).add(ModRegistry.ALLTHEMODIUM_LEGGINGS.get());
        tag(ItemTags.ARMOR_ENCHANTABLE).add(ModRegistry.ALLTHEMODIUM_BOOTS.get());

        tag(ItemTags.ARMOR_ENCHANTABLE).add(ModRegistry.VIBRANIUM_HELMET.get());
        tag(ItemTags.ARMOR_ENCHANTABLE).add(ModRegistry.VIBRANIUM_CHESTPLATE.get());
        tag(ItemTags.ARMOR_ENCHANTABLE).add(ModRegistry.VIBRANIUM_LEGGINGS.get());
        tag(ItemTags.ARMOR_ENCHANTABLE).add(ModRegistry.VIBRANIUM_BOOTS.get());

        tag(ItemTags.ARMOR_ENCHANTABLE).add(ModRegistry.UNOBTAINIUM_HELMET.get());
        tag(ItemTags.ARMOR_ENCHANTABLE).add(ModRegistry.UNOBTAINIUM_CHESTPLATE.get());
        tag(ItemTags.ARMOR_ENCHANTABLE).add(ModRegistry.UNOBTAINIUM_LEGGINGS.get());
        tag(ItemTags.ARMOR_ENCHANTABLE).add(ModRegistry.UNOBTAINIUM_BOOTS.get());

        tag(ItemTags.TRIMMABLE_ARMOR).add(ModRegistry.ALLTHEMODIUM_HELMET.get());
        tag(ItemTags.TRIMMABLE_ARMOR).add(ModRegistry.ALLTHEMODIUM_CHESTPLATE.get());
        tag(ItemTags.TRIMMABLE_ARMOR).add(ModRegistry.ALLTHEMODIUM_LEGGINGS.get());
        tag(ItemTags.TRIMMABLE_ARMOR).add(ModRegistry.ALLTHEMODIUM_BOOTS.get());

        tag(ItemTags.TRIMMABLE_ARMOR).add(ModRegistry.VIBRANIUM_HELMET.get());
        tag(ItemTags.TRIMMABLE_ARMOR).add(ModRegistry.VIBRANIUM_CHESTPLATE.get());
        tag(ItemTags.TRIMMABLE_ARMOR).add(ModRegistry.VIBRANIUM_LEGGINGS.get());
        tag(ItemTags.TRIMMABLE_ARMOR).add(ModRegistry.VIBRANIUM_BOOTS.get());

        tag(ItemTags.TRIMMABLE_ARMOR).add(ModRegistry.UNOBTAINIUM_HELMET.get());
        tag(ItemTags.TRIMMABLE_ARMOR).add(ModRegistry.UNOBTAINIUM_CHESTPLATE.get());
        tag(ItemTags.TRIMMABLE_ARMOR).add(ModRegistry.UNOBTAINIUM_LEGGINGS.get());
        tag(ItemTags.TRIMMABLE_ARMOR).add(ModRegistry.UNOBTAINIUM_BOOTS.get());

        tag(ItemTags.TRIM_MATERIALS).add(ModRegistry.ALLTHEMODIUM_INGOT.get());
        tag(ItemTags.TRIM_MATERIALS).add(ModRegistry.VIBRANIUM_INGOT.get());
        tag(ItemTags.TRIM_MATERIALS).add(ModRegistry.UNOBTAINIUM_INGOT.get());


        tag(net.minecraft.tags.ItemTags.HEAD_ARMOR).add(ModRegistry.ALLTHEMODIUM_HELMET.get());
        tag(net.minecraft.tags.ItemTags.CHEST_ARMOR).add(ModRegistry.ALLTHEMODIUM_CHESTPLATE.get());
        tag(net.minecraft.tags.ItemTags.LEG_ARMOR).add(ModRegistry.ALLTHEMODIUM_LEGGINGS.get());
        tag(net.minecraft.tags.ItemTags.FOOT_ARMOR).add(ModRegistry.ALLTHEMODIUM_BOOTS.get());

        tag(net.minecraft.tags.ItemTags.HEAD_ARMOR_ENCHANTABLE).add(ModRegistry.ALLTHEMODIUM_HELMET.get());
        tag(net.minecraft.tags.ItemTags.CHEST_ARMOR_ENCHANTABLE).add(ModRegistry.ALLTHEMODIUM_CHESTPLATE.get());
        tag(net.minecraft.tags.ItemTags.LEG_ARMOR_ENCHANTABLE).add(ModRegistry.ALLTHEMODIUM_LEGGINGS.get());
        tag(net.minecraft.tags.ItemTags.FOOT_ARMOR_ENCHANTABLE).add(ModRegistry.ALLTHEMODIUM_BOOTS.get());

        tag(ItemTags.EQUIPPABLE_ENCHANTABLE).add(ModRegistry.ALLTHEMODIUM_HELMET.get());
        tag(ItemTags.EQUIPPABLE_ENCHANTABLE).add(ModRegistry.ALLTHEMODIUM_CHESTPLATE.get());
        tag(ItemTags.EQUIPPABLE_ENCHANTABLE).add(ModRegistry.ALLTHEMODIUM_LEGGINGS.get());
        tag(ItemTags.EQUIPPABLE_ENCHANTABLE).add(ModRegistry.ALLTHEMODIUM_BOOTS.get());
        
        tag(net.minecraft.tags.ItemTags.HEAD_ARMOR).add(ModRegistry.VIBRANIUM_HELMET.get());
        tag(net.minecraft.tags.ItemTags.CHEST_ARMOR).add(ModRegistry.VIBRANIUM_CHESTPLATE.get());
        tag(net.minecraft.tags.ItemTags.LEG_ARMOR).add(ModRegistry.VIBRANIUM_LEGGINGS.get());
        tag(net.minecraft.tags.ItemTags.FOOT_ARMOR).add(ModRegistry.VIBRANIUM_BOOTS.get());

        tag(net.minecraft.tags.ItemTags.HEAD_ARMOR_ENCHANTABLE).add(ModRegistry.VIBRANIUM_HELMET.get());
        tag(net.minecraft.tags.ItemTags.CHEST_ARMOR_ENCHANTABLE).add(ModRegistry.VIBRANIUM_CHESTPLATE.get());
        tag(net.minecraft.tags.ItemTags.LEG_ARMOR_ENCHANTABLE).add(ModRegistry.VIBRANIUM_LEGGINGS.get());
        tag(net.minecraft.tags.ItemTags.FOOT_ARMOR_ENCHANTABLE).add(ModRegistry.VIBRANIUM_BOOTS.get());

        tag(ItemTags.EQUIPPABLE_ENCHANTABLE).add(ModRegistry.VIBRANIUM_HELMET.get());
        tag(ItemTags.EQUIPPABLE_ENCHANTABLE).add(ModRegistry.VIBRANIUM_CHESTPLATE.get());
        tag(ItemTags.EQUIPPABLE_ENCHANTABLE).add(ModRegistry.VIBRANIUM_LEGGINGS.get());
        tag(ItemTags.EQUIPPABLE_ENCHANTABLE).add(ModRegistry.VIBRANIUM_BOOTS.get());
        
        tag(net.minecraft.tags.ItemTags.HEAD_ARMOR).add(ModRegistry.UNOBTAINIUM_HELMET.get());
        tag(net.minecraft.tags.ItemTags.CHEST_ARMOR).add(ModRegistry.UNOBTAINIUM_CHESTPLATE.get());
        tag(net.minecraft.tags.ItemTags.LEG_ARMOR).add(ModRegistry.UNOBTAINIUM_LEGGINGS.get());
        tag(net.minecraft.tags.ItemTags.FOOT_ARMOR).add(ModRegistry.UNOBTAINIUM_BOOTS.get());

        tag(net.minecraft.tags.ItemTags.HEAD_ARMOR_ENCHANTABLE).add(ModRegistry.UNOBTAINIUM_HELMET.get());
        tag(net.minecraft.tags.ItemTags.CHEST_ARMOR_ENCHANTABLE).add(ModRegistry.UNOBTAINIUM_CHESTPLATE.get());
        tag(net.minecraft.tags.ItemTags.LEG_ARMOR_ENCHANTABLE).add(ModRegistry.UNOBTAINIUM_LEGGINGS.get());
        tag(net.minecraft.tags.ItemTags.FOOT_ARMOR_ENCHANTABLE).add(ModRegistry.UNOBTAINIUM_BOOTS.get());

        tag(ItemTags.EQUIPPABLE_ENCHANTABLE).add(ModRegistry.UNOBTAINIUM_HELMET.get());
        tag(ItemTags.EQUIPPABLE_ENCHANTABLE).add(ModRegistry.UNOBTAINIUM_CHESTPLATE.get());
        tag(ItemTags.EQUIPPABLE_ENCHANTABLE).add(ModRegistry.UNOBTAINIUM_LEGGINGS.get());
        tag(ItemTags.EQUIPPABLE_ENCHANTABLE).add(ModRegistry.UNOBTAINIUM_BOOTS.get());



        tag(ItemTags.SWORDS).add(ModRegistry.ATM_SWORD.get());
        tag(ItemTags.SWORD_ENCHANTABLE).add(ModRegistry.ATM_SWORD.get());
        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE).add(ModRegistry.ATM_SWORD.get());
        tag(ItemTags.WEAPON_ENCHANTABLE).add(ModRegistry.ATM_SWORD.get());
        tag(ItemTags.FIRE_ASPECT_ENCHANTABLE).add(ModRegistry.ATM_SWORD.get());

        tag(ItemTags.AXES).add(ModRegistry.ATM_AXE.get());
        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE).add(ModRegistry.ATM_AXE.get());
        tag(ItemTags.WEAPON_ENCHANTABLE).add(ModRegistry.ATM_AXE.get());

        tag(ItemTags.PICKAXES).add(ModRegistry.ATM_PICKAXE.get());
        tag(ItemTags.MINING_ENCHANTABLE).add(ModRegistry.ATM_PICKAXE.get());
        tag(ItemTags.MINING_LOOT_ENCHANTABLE).add(ModRegistry.ATM_PICKAXE.get());

        tag(ItemTags.SHOVELS).add(ModRegistry.ATM_SHOVEL.get());
        tag(ItemTags.MINING_ENCHANTABLE).add(ModRegistry.ATM_SHOVEL.get());
        tag(ItemTags.MINING_LOOT_ENCHANTABLE).add(ModRegistry.ATM_SHOVEL.get());

        tag(ItemTags.HOES).add(ModRegistry.ATM_HOE.get());

        tag(ItemTags.BREAKS_DECORATED_POTS).add(ModRegistry.ATM_MACE.get());
        tag(ItemTags.FIRE_ASPECT_ENCHANTABLE).add(ModRegistry.ATM_MACE.get());
        tag(Tags.Items.ENCHANTABLES).add(ModRegistry.ATM_MACE.get());
        tag(Tags.Items.TOOLS).add(ModRegistry.ATM_MACE.get());
        tag(Tags.Items.TOOLS_MACE).add(ModRegistry.ATM_MACE.get());
        tag(Tags.Items.MELEE_WEAPON_TOOLS).add(ModRegistry.ATM_MACE.get());
        tag(ItemTags.MACE_ENCHANTABLE).add(ModRegistry.ATM_MACE.get());
        tag(ItemTags.WEAPON_ENCHANTABLE).add(ModRegistry.ATM_MACE.get());

        tag(ItemTags.BREAKS_DECORATED_POTS).add(ModRegistry.VIB_MACE.get());
        tag(ItemTags.FIRE_ASPECT_ENCHANTABLE).add(ModRegistry.VIB_MACE.get());
        tag(Tags.Items.ENCHANTABLES).add(ModRegistry.VIB_MACE.get());
        tag(Tags.Items.TOOLS).add(ModRegistry.VIB_MACE.get());
        tag(Tags.Items.TOOLS_MACE).add(ModRegistry.VIB_MACE.get());
        tag(Tags.Items.MELEE_WEAPON_TOOLS).add(ModRegistry.VIB_MACE.get());
        tag(ItemTags.MACE_ENCHANTABLE).add(ModRegistry.VIB_MACE.get());
        tag(ItemTags.WEAPON_ENCHANTABLE).add(ModRegistry.VIB_MACE.get());

        tag(ItemTags.BREAKS_DECORATED_POTS).add(ModRegistry.UNO_MACE.get());
        tag(ItemTags.FIRE_ASPECT_ENCHANTABLE).add(ModRegistry.UNO_MACE.get());
        tag(Tags.Items.ENCHANTABLES).add(ModRegistry.UNO_MACE.get());
        tag(Tags.Items.TOOLS).add(ModRegistry.UNO_MACE.get());
        tag(Tags.Items.TOOLS_MACE).add(ModRegistry.UNO_MACE.get());
        tag(Tags.Items.MELEE_WEAPON_TOOLS).add(ModRegistry.UNO_MACE.get());
        tag(ItemTags.MACE_ENCHANTABLE).add(ModRegistry.UNO_MACE.get());
        tag(ItemTags.WEAPON_ENCHANTABLE).add(ModRegistry.UNO_MACE.get());

        
        tag(ItemTags.SWORDS).add(ModRegistry.VIB_SWORD.get());
        tag(ItemTags.SWORD_ENCHANTABLE).add(ModRegistry.VIB_SWORD.get());
        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE).add(ModRegistry.VIB_SWORD.get());
        tag(ItemTags.WEAPON_ENCHANTABLE).add(ModRegistry.VIB_SWORD.get());
        tag(ItemTags.FIRE_ASPECT_ENCHANTABLE).add(ModRegistry.VIB_SWORD.get());

        tag(ItemTags.AXES).add(ModRegistry.VIB_AXE.get());
        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE).add(ModRegistry.VIB_AXE.get());
        tag(ItemTags.WEAPON_ENCHANTABLE).add(ModRegistry.VIB_AXE.get());

        tag(ItemTags.PICKAXES).add(ModRegistry.VIB_PICKAXE.get());
        tag(ItemTags.MINING_ENCHANTABLE).add(ModRegistry.VIB_PICKAXE.get());
        tag(ItemTags.MINING_LOOT_ENCHANTABLE).add(ModRegistry.VIB_PICKAXE.get());

        tag(ItemTags.SHOVELS).add(ModRegistry.VIB_SHOVEL.get());
        tag(ItemTags.MINING_ENCHANTABLE).add(ModRegistry.VIB_SHOVEL.get());
        tag(ItemTags.MINING_LOOT_ENCHANTABLE).add(ModRegistry.VIB_SHOVEL.get());

        tag(ItemTags.HOES).add(ModRegistry.VIB_HOE.get());

        tag(ItemTags.SWORDS).add(ModRegistry.UNO_SWORD.get());
        tag(ItemTags.SWORD_ENCHANTABLE).add(ModRegistry.UNO_SWORD.get());
        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE).add(ModRegistry.UNO_SWORD.get());
        tag(ItemTags.WEAPON_ENCHANTABLE).add(ModRegistry.UNO_SWORD.get());
        tag(ItemTags.FIRE_ASPECT_ENCHANTABLE).add(ModRegistry.UNO_SWORD.get());

        tag(ItemTags.AXES).add(ModRegistry.UNO_AXE.get());
        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE).add(ModRegistry.UNO_AXE.get());
        tag(ItemTags.WEAPON_ENCHANTABLE).add(ModRegistry.UNO_AXE.get());

        tag(ItemTags.PICKAXES).add(ModRegistry.UNO_PICKAXE.get());
        tag(ItemTags.MINING_ENCHANTABLE).add(ModRegistry.UNO_PICKAXE.get());
        tag(ItemTags.MINING_LOOT_ENCHANTABLE).add(ModRegistry.UNO_PICKAXE.get());

        tag(ItemTags.SHOVELS).add(ModRegistry.UNO_SHOVEL.get());
        tag(ItemTags.MINING_ENCHANTABLE).add(ModRegistry.UNO_SHOVEL.get());
        tag(ItemTags.MINING_LOOT_ENCHANTABLE).add(ModRegistry.UNO_SHOVEL.get());

        tag(ItemTags.HOES).add(ModRegistry.UNO_HOE.get());

        tag(ItemTags.TRIDENT_ENCHANTABLE).add(ModRegistry.ALLOY_TRIDENT.get());
        
        tag(ItemTags.SWORDS).add(ModRegistry.ALLOY_SWORD.get());
        tag(ItemTags.SWORD_ENCHANTABLE).add(ModRegistry.ALLOY_SWORD.get());
        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE).add(ModRegistry.ALLOY_SWORD.get());
        tag(ItemTags.WEAPON_ENCHANTABLE).add(ModRegistry.ALLOY_SWORD.get());
        tag(ItemTags.FIRE_ASPECT_ENCHANTABLE).add(ModRegistry.ALLOY_SWORD.get());

        tag(ItemTags.AXES).add(ModRegistry.ALLOY_AXE.get());
        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE).add(ModRegistry.ALLOY_AXE.get());
        tag(ItemTags.WEAPON_ENCHANTABLE).add(ModRegistry.ALLOY_AXE.get());
        tag(ItemTags.FIRE_ASPECT_ENCHANTABLE).add(ModRegistry.ALLOY_AXE.get());

        tag(ItemTags.PICKAXES).add(ModRegistry.ALLOY_PICKAXE.get());
        tag(ItemTags.MINING_ENCHANTABLE).add(ModRegistry.ALLOY_PICKAXE.get());
        tag(ItemTags.MINING_LOOT_ENCHANTABLE).add(ModRegistry.ALLOY_PICKAXE.get());

        tag(ItemTags.SHOVELS).add(ModRegistry.ALLOY_SHOVEL.get());
        tag(ItemTags.MINING_ENCHANTABLE).add(ModRegistry.ALLOY_SHOVEL.get());
        tag(ItemTags.MINING_LOOT_ENCHANTABLE).add(ModRegistry.ALLOY_SHOVEL.get());

        tag(ItemTags.HOES).add(ModRegistry.ALLOY_DIGGER.get());
        tag(ItemTags.SHOVELS).add(ModRegistry.ALLOY_DIGGER.get());
        tag(ItemTags.AXES).add(ModRegistry.ALLOY_DIGGER.get());
        tag(ItemTags.PICKAXES).add(ModRegistry.ALLOY_DIGGER.get());
        tag(ItemTags.SWORDS).add(ModRegistry.ALLOY_DIGGER.get());
        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE).add(ModRegistry.ALLOY_DIGGER.get());
        tag(ItemTags.WEAPON_ENCHANTABLE).add(ModRegistry.ALLOY_DIGGER.get());
        tag(ItemTags.FIRE_ASPECT_ENCHANTABLE).add(ModRegistry.ALLOY_DIGGER.get());
        tag(ItemTags.MINING_ENCHANTABLE).add(ModRegistry.ALLOY_DIGGER.get());
        tag(ItemTags.MINING_LOOT_ENCHANTABLE).add(ModRegistry.ALLOY_DIGGER.get());
        
        tag(ItemTags.EQUIPPABLE_ENCHANTABLE).add(ModRegistry.VIB_SHIELD.get());
        tag(ItemTags.CROSSBOW_ENCHANTABLE).add(ModRegistry.UNO_BOW.get());
        tag(ItemTags.BOW_ENCHANTABLE).add(ModRegistry.ATM_BOW.get());

        tag(Tags.Items.TOOLS_BOW).add(ModRegistry.ATM_BOW.get());
        tag(Tags.Items.TOOLS_CROSSBOW).add(ModRegistry.UNO_BOW.get());

        tag(Tags.Items.TOOLS_SHIELD).add(ModRegistry.VIB_SHIELD.get());

        
        tag(TagRegistry.PIGLIN_LOVED).add(ModRegistry.ALLTHEMODIUM_BOOTS.get());
        tag(TagRegistry.PIGLIN_LOVED).add(ModRegistry.ALLTHEMODIUM_LEGGINGS.get());
        tag(TagRegistry.PIGLIN_LOVED).add(ModRegistry.ALLTHEMODIUM_CHESTPLATE.get());
        tag(TagRegistry.PIGLIN_LOVED).add(ModRegistry.ALLTHEMODIUM_HELMET.get());

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

        tag(TagRegistry.RAW_MATERIALS).add(ModRegistry.RAW_ALLTHEMODIUM.get());
        tag(TagRegistry.RAW_MATERIALS).add(ModRegistry.RAW_VIBRANIUM.get());
        tag(TagRegistry.RAW_MATERIALS).add(ModRegistry.RAW_UNOBTAINIUM.get());

        tag(TagRegistry.RAW_ALLTHEMODIUM_FORGE).add(ModRegistry.RAW_ALLTHEMODIUM.get());
        tag(TagRegistry.RAW_VIBRANIUM_FORGE).add(ModRegistry.RAW_VIBRANIUM.get());
        tag(TagRegistry.RAW_UNOBTAINIUM_FORGE).add(ModRegistry.RAW_UNOBTAINIUM.get());

        tag(TagRegistry.ALLTHEMODIUM_INGOT).add(ModRegistry.ALLTHEMODIUM_INGOT.get());
        tag(TagRegistry.VIBRANIUM_INGOT).add(ModRegistry.VIBRANIUM_INGOT.get());
        tag(TagRegistry.UNOBTAINIUM_INGOT).add(ModRegistry.UNOBTAINIUM_INGOT.get());

        tag(TagRegistry.VIBRANIUM_ALLTHEMODIUM_INGOT).add(ModRegistry.VIBRANIUM_ALLTHEMODIUM_ALLOY.get());
        tag(TagRegistry.UNOBTAINIUM_ALLTHEMODIUM_INGOT).add(ModRegistry.UNOBTAINIUM_ALLTHEMODIUM_ALLOY.get());
        tag(TagRegistry.UNOBTAINIUM_VIBRANIUM_INGOT).add(ModRegistry.UNOBTAINIUM_VIBRANIUM_ALLOY.get());

        tag(TagRegistry.VIBRANIUM_ALLTHEMODIUM_BLOCK).add(ModRegistry.VA_ALLOY_ITEM.get());
        tag(TagRegistry.UNOBTAINIUM_ALLTHEMODIUM_BLOCK).add(ModRegistry.UA_ALLOY_ITEM.get());
        tag(TagRegistry.UNOBTAINIUM_VIBRANIUM_BLOCK).add(ModRegistry.UV_ALLOY_ITEM.get());

        tag(TagRegistry.ALLTHEMODIUM_DUST).add(ModRegistry.ALLTHEMODIUM_DUST.get());
        tag(TagRegistry.VIBRANIUM_DUST).add(ModRegistry.VIBRANIUM_DUST.get());
        tag(TagRegistry.UNOBTAINIUM_DUST).add(ModRegistry.UNOBTAINIUM_DUST.get());

        tag(TagRegistry.DUSTS).add(ModRegistry.ALLTHEMODIUM_DUST.get());
        tag(TagRegistry.DUSTS).add(ModRegistry.VIBRANIUM_DUST.get());
        tag(TagRegistry.DUSTS).add(ModRegistry.UNOBTAINIUM_DUST.get());

        tag(TagRegistry.INGOTS).add(ModRegistry.ALLTHEMODIUM_INGOT.get());
        tag(TagRegistry.INGOTS).add(ModRegistry.VIBRANIUM_INGOT.get());
        tag(TagRegistry.INGOTS).add(ModRegistry.UNOBTAINIUM_INGOT.get());

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

        tag(TagRegistry.ORES).add(ModRegistry.ALLTHEMODIUM_ORE_ITEM.get());
        tag(TagRegistry.ORES).add(ModRegistry.ALLTHEMODIUM_SLATE_ORE_ITEM.get());
        tag(TagRegistry.ORES).add(ModRegistry.VIBRANIUM_ORE_ITEM.get());
        tag(TagRegistry.ORES).add(ModRegistry.OTHER_VIBRANIUM_ORE_ITEM.get());
        tag(TagRegistry.ORES).add(ModRegistry.UNOBTAINIUM_ORE_ITEM.get());

        tag(TagRegistry.ALLTHEMODIUM_GEAR).add(ModRegistry.ATM_GEAR.get());
        tag(TagRegistry.VIBRANIUM_GEAR).add(ModRegistry.VIB_GEAR.get());
        tag(TagRegistry.UNOBTAINIUM_GEAR).add(ModRegistry.ONOB_GEAR.get());

        tag(TagRegistry.ALLTHEMODIUM_PLATE).add(ModRegistry.ATM_PLATE.get());
        tag(TagRegistry.VIBRANIUM_PLATE).add(ModRegistry.VIB_PLATE.get());
        tag(TagRegistry.UNOBTAINIUM_PLATE).add(ModRegistry.ONOB_PLATE.get());

        tag(TagRegistry.ALLTHEMODIUM_ROD).add(ModRegistry.ATM_ROD.get());
        tag(TagRegistry.VIBRANIUM_ROD).add(ModRegistry.VIB_ROD.get());
        tag(TagRegistry.UNOBTAINIUM_ROD).add(ModRegistry.ONOB_ROD.get());

        tag(TagRegistry.ALLTHEMODIUM_SHARD).addOptional(MekProcReg.ATM_SHARD.getId());
        tag(TagRegistry.VIBRANIUM_SHARD).addOptional(MekProcReg.VIB_SHARD.getId());
        tag(TagRegistry.UNOBTAINIUM_SHARD).addOptional(MekProcReg.ONOB_SHARD.getId());

        tag(TagRegistry.ALLTHEMODIUM_CLUMP).addOptional(MekProcReg.ATM_CLUMP.getId());
        tag(TagRegistry.VIBRANIUM_CLUMP).addOptional(MekProcReg.VIB_CLUMP.getId());
        tag(TagRegistry.UNOBTAINIUM_CLUMP).addOptional(MekProcReg.ONOB_CLUMP.getId());

        tag(TagRegistry.ALLTHEMODIUM_CRYSTAL).addOptional(MekProcReg.ATM_CRYSTAL.getId());
        tag(TagRegistry.VIBRANIUM_CRYSTAL).addOptional(MekProcReg.VIB_CRYSTAL.getId());
        tag(TagRegistry.UNOBTAINIUM_CRYSTAL).addOptional(MekProcReg.ONOB_CRYSTAL.getId());

        tag(TagRegistry.ALLTHEMODIUM_DIRTYDUST).addOptional(MekProcReg.ATM_DIRTY.getId());
        tag(TagRegistry.VIBRANIUM_DIRTYDUST).addOptional(MekProcReg.VIB_DIRTY.getId());
        tag(TagRegistry.UNOBTAINIUM_DIRTYDUST).addOptional(MekProcReg.ONOB_DIRTY.getId());

        tag(TagRegistry.SHARD).addOptional(MekProcReg.ATM_SHARD.getId());
        tag(TagRegistry.SHARD).addOptional(MekProcReg.VIB_SHARD.getId());
        tag(TagRegistry.SHARD).addOptional(MekProcReg.ONOB_SHARD.getId());

        tag(TagRegistry.CLUMP).addOptional(MekProcReg.ATM_CLUMP.getId());
        tag(TagRegistry.CLUMP).addOptional(MekProcReg.VIB_CLUMP.getId());
        tag(TagRegistry.CLUMP).addOptional(MekProcReg.ONOB_CLUMP.getId());

        tag(TagRegistry.CRYSTAL).addOptional(MekProcReg.ATM_CRYSTAL.getId());
        tag(TagRegistry.CRYSTAL).addOptional(MekProcReg.VIB_CRYSTAL.getId());
        tag(TagRegistry.CRYSTAL).addOptional(MekProcReg.ONOB_CRYSTAL.getId());

        tag(TagRegistry.DIRTYDUST).addOptional(MekProcReg.ATM_DIRTY.getId());
        tag(TagRegistry.DIRTYDUST).addOptional(MekProcReg.VIB_DIRTY.getId());
        tag(TagRegistry.DIRTYDUST).addOptional(MekProcReg.ONOB_DIRTY.getId());

    }
}
