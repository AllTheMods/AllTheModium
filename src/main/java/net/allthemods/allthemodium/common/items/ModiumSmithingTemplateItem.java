package net.allthemods.allthemodium.common.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SmithingTemplateItem;

import net.allthemods.allthemodium.client.lang.ATMLanguage;

import java.util.List;

public class ModiumSmithingTemplateItem extends SmithingTemplateItem {
    
    private static final Identifier EMPTY_SLOT_INGOT = Identifier.withDefaultNamespace("item/empty_slot_ingot");
    
    private static final Identifier EMPTY_SLOT_HELMET = Identifier.withDefaultNamespace("item/empty_armor_slot_helmet");
    private static final Identifier EMPTY_SLOT_CHESTPLATE = Identifier.withDefaultNamespace("item/empty_armor_slot_chestplate");
    private static final Identifier EMPTY_SLOT_LEGGINGS = Identifier.withDefaultNamespace("item/empty_armor_slot_leggings");
    private static final Identifier EMPTY_SLOT_BOOTS = Identifier.withDefaultNamespace("item/empty_armor_slot_boots");
    private static final Identifier EMPTY_SLOT_HOE = Identifier.withDefaultNamespace("item/empty_slot_hoe");
    private static final Identifier EMPTY_SLOT_AXE = Identifier.withDefaultNamespace("item/empty_slot_axe");
    private static final Identifier EMPTY_SLOT_SWORD = Identifier.withDefaultNamespace("item/empty_slot_sword");
    private static final Identifier EMPTY_SLOT_SHOVEL = Identifier.withDefaultNamespace("item/empty_slot_shovel");
    private static final Identifier EMPTY_SLOT_PICKAXE = Identifier.withDefaultNamespace("item/empty_slot_pickaxe");
    
    public ModiumSmithingTemplateItem(Component appliesTo, Component ingredients, Component baseSlotDescription, Component additionsSlotDescription, List<Identifier> baseSlotEmptyIcons, List<Identifier> additionalSlotEmptyIcons, Properties properties) {
        super(appliesTo, ingredients, baseSlotDescription, additionsSlotDescription, baseSlotEmptyIcons, additionalSlotEmptyIcons, properties.fireResistant().rarity(Rarity.EPIC));
    }
    
    public static ModiumSmithingTemplateItem createAllthemodiumUpgradeTemplate(Properties properties) {
        return new ModiumSmithingTemplateItem(
                ATMLanguage.ALLTHEMODIUM_UPGRADE_APPLIES_TO.translate(ChatFormatting.BLUE),
                ATMLanguage.ALLTHEMODIUM_UPGRADE_INGREDIENTS.translate(ChatFormatting.BLUE),
                ATMLanguage.ALLTHEMODIUM_UPGRADE_BASE_SLOT_DESCRIPTION.translate(),
                ATMLanguage.ALLTHEMODIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION.translate(),
                ModiumSmithingTemplateItem.createUpgradeIconList(),
                ModiumSmithingTemplateItem.createUpgradeMaterialList(),
                properties
        );
    }
    
    public static ModiumSmithingTemplateItem createVibraniumUpgradeTemplate(Properties properties) {
        return new ModiumSmithingTemplateItem(
                ATMLanguage.VIBRANIUM_UPGRADE_APPLIES_TO.translate(ChatFormatting.BLUE),
                ATMLanguage.VIBRANIUM_UPGRADE_INGREDIENTS.translate(ChatFormatting.BLUE),
                ATMLanguage.VIBRANIUM_UPGRADE_BASE_SLOT_DESCRIPTION.translate(),
                ATMLanguage.VIBRANIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION.translate(),
                ModiumSmithingTemplateItem.createUpgradeIconList(),
                ModiumSmithingTemplateItem.createUpgradeMaterialList(),
                properties
        );
    }
    
    public static ModiumSmithingTemplateItem createUnobtainiumUpgradeTemplate(Properties properties) {
        return new ModiumSmithingTemplateItem(
                ATMLanguage.UNOBTAINIUM_UPGRADE_APPLIES_TO.translate(ChatFormatting.BLUE),
                ATMLanguage.UNOBTAINIUM_UPGRADE_INGREDIENTS.translate(ChatFormatting.BLUE),
                ATMLanguage.UNOBTAINIUM_UPGRADE_BASE_SLOT_DESCRIPTION.translate(),
                ATMLanguage.UNOBTAINIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION.translate(),
                ModiumSmithingTemplateItem.createUpgradeIconList(),
                ModiumSmithingTemplateItem.createUpgradeMaterialList(),
                properties
        );
    }
    
    private static List<Identifier> createUpgradeIconList() {
        return List.of(
                ModiumSmithingTemplateItem.EMPTY_SLOT_HELMET,
                ModiumSmithingTemplateItem.EMPTY_SLOT_SWORD,
                ModiumSmithingTemplateItem.EMPTY_SLOT_CHESTPLATE,
                ModiumSmithingTemplateItem.EMPTY_SLOT_PICKAXE,
                ModiumSmithingTemplateItem.EMPTY_SLOT_LEGGINGS,
                ModiumSmithingTemplateItem.EMPTY_SLOT_AXE,
                ModiumSmithingTemplateItem.EMPTY_SLOT_BOOTS,
                ModiumSmithingTemplateItem.EMPTY_SLOT_HOE,
                ModiumSmithingTemplateItem.EMPTY_SLOT_SHOVEL
        );
    }
    
    private static List<Identifier> createUpgradeMaterialList() {
        return List.of(ModiumSmithingTemplateItem.EMPTY_SLOT_INGOT);
    }
}
