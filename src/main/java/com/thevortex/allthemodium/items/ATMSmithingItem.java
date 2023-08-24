package com.thevortex.allthemodium.items;

import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class ATMSmithingItem extends SmithingTemplateItem {
    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GOLD;
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;

    private static final ResourceLocation EMPTY_SLOT_INGOT = new ResourceLocation("item/empty_slot_ingot");
     private static final Component ALLTHEMODIUM_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation(Reference.MOD_ID,"allthemodium_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component ALLTHEMODIUM_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Reference.MOD_ID,"smithing_template.allthemodium_upgrade.applies_to"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component ALLTHEMODIUM_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Reference.MOD_ID,"smithing_template.allthemodium_upgrade.ingredients"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component ALLTHEMODIUM_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Reference.MOD_ID,"smithing_template.allthemodium_upgrade.base_slot_description")));
    private static final Component ALLTHEMODIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Reference.MOD_ID,"smithing_template.allthemodium_upgrade.additions_slot_description")));

    private static final Component VIBRANIUM_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation(Reference.MOD_ID,"vibranium_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component VIBRANIUM_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Reference.MOD_ID,"smithing_template.vibranium_upgrade.applies_to"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component VIBRANIUM_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Reference.MOD_ID,"smithing_template.vibranium_upgrade.ingredients"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component VIBRANIUM_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Reference.MOD_ID,"smithing_template.vibranium_upgrade.base_slot_description")));
    private static final Component VIBRANIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Reference.MOD_ID,"smithing_template.vibranium_upgrade.additions_slot_description")));

    private static final Component UNOBTAINIUM_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation(Reference.MOD_ID,"unobtainium_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component UNOBTAINIUM_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Reference.MOD_ID,"smithing_template.unobtainium_upgrade.applies_to"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component UNOBTAINIUM_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Reference.MOD_ID,"smithing_template.unobtainium_upgrade.ingredients"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component UNOBTAINIUM_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Reference.MOD_ID,"smithing_template.unobtainium_upgrade.base_slot_description")));
    private static final Component UNOBTAINIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Reference.MOD_ID,"smithing_template.unobtainium_upgrade.additions_slot_description")));

    private static final ResourceLocation EMPTY_SLOT_HELMET = new ResourceLocation("item/empty_armor_slot_helmet");
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE = new ResourceLocation("item/empty_armor_slot_chestplate");
    private static final ResourceLocation EMPTY_SLOT_LEGGINGS = new ResourceLocation("item/empty_armor_slot_leggings");
    private static final ResourceLocation EMPTY_SLOT_BOOTS = new ResourceLocation("item/empty_armor_slot_boots");
    private static final ResourceLocation EMPTY_SLOT_HOE = new ResourceLocation("item/empty_slot_hoe");
    private static final ResourceLocation EMPTY_SLOT_AXE = new ResourceLocation("item/empty_slot_axe");
    private static final ResourceLocation EMPTY_SLOT_SWORD = new ResourceLocation("item/empty_slot_sword");
    private static final ResourceLocation EMPTY_SLOT_SHOVEL = new ResourceLocation("item/empty_slot_shovel");
    private static final ResourceLocation EMPTY_SLOT_PICKAXE = new ResourceLocation("item/empty_slot_pickaxe");
    public ATMSmithingItem(Component p_266834_, Component p_267043_, Component p_267048_, Component p_267278_, Component p_267090_, List<ResourceLocation> p_266755_, List<ResourceLocation> p_267060_) {
        super(p_266834_, p_267043_, p_267048_, p_267278_, p_267090_, p_266755_, p_267060_);
    }

    public static SmithingTemplateItem createAllthemodiumUpgradeTemplate() {
        return new SmithingTemplateItem(ALLTHEMODIUM_UPGRADE_APPLIES_TO, ALLTHEMODIUM_UPGRADE_INGREDIENTS, ALLTHEMODIUM_UPGRADE, ALLTHEMODIUM_UPGRADE_BASE_SLOT_DESCRIPTION, ALLTHEMODIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createAllthemodiumUpgradeIconList(), createUpgradeMaterialList());
    }
    private static List<ResourceLocation> createAllthemodiumUpgradeIconList() {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_SWORD, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_AXE, EMPTY_SLOT_BOOTS, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL);
    }
    public static SmithingTemplateItem createVibraniumUpgradeTemplate() {
        return new SmithingTemplateItem(VIBRANIUM_UPGRADE_APPLIES_TO, VIBRANIUM_UPGRADE_INGREDIENTS, VIBRANIUM_UPGRADE, VIBRANIUM_UPGRADE_BASE_SLOT_DESCRIPTION, VIBRANIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createVibraniumUpgradeIconList(), createUpgradeMaterialList());
    }
    private static List<ResourceLocation> createVibraniumUpgradeIconList() {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_SWORD, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_AXE, EMPTY_SLOT_BOOTS, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL);
    }
    public static SmithingTemplateItem createUnobtainiumUpgradeTemplate() {
        return new SmithingTemplateItem(UNOBTAINIUM_UPGRADE_APPLIES_TO, UNOBTAINIUM_UPGRADE_INGREDIENTS, UNOBTAINIUM_UPGRADE, UNOBTAINIUM_UPGRADE_BASE_SLOT_DESCRIPTION, UNOBTAINIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createUnobtainiumUpgradeIconList(), createUpgradeMaterialList());
    }
    private static List<ResourceLocation> createUnobtainiumUpgradeIconList() {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_SWORD, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_AXE, EMPTY_SLOT_BOOTS, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL);
    }
    private static List<ResourceLocation> createUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_INGOT);
    }
}
