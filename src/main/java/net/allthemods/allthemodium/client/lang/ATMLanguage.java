package net.allthemods.allthemodium.client.lang;

import net.minecraft.util.Util;

import net.allthemods.allthemodium.api.ATM;

import java.util.function.BiConsumer;

public enum
ATMLanguage implements ATMTranslatable {
    // @formatter:off
    TABS_DEFAULT                                   ("creative_tab", "default_tab",                                                       "AllTheModium"),
                                                                    
    // Allthemodium                                                 
    ALLTHEMODIUM_UPGRADE                           ("upgrade",      "allthemodium_upgrade",                                              "Allthemodium Upgrade"),
    ALLTHEMODIUM_UPGRADE_APPLIES_TO                ("item",         "smithing_template.allthemodium_upgrade.applies_to",                 "Netherite Equipment"),
    ALLTHEMODIUM_UPGRADE_INGREDIENTS               ("item",         "smithing_template.allthemodium_upgrade.ingredients",                "Allthemodium Ingot"),
    ALLTHEMODIUM_UPGRADE_BASE_SLOT_DESCRIPTION     ("item",         "smithing_template.allthemodium_upgrade.base_slot_description",      "Add Netherite Armor, Weapon, or Tool"),
    ALLTHEMODIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION("item",         "smithing_template.allthemodium_upgrade.additions_slot_description", "Add Allthemodium Ingot"),
                                                                    
    // Vibranium                                                    
    VIBRANIUM_UPGRADE                              ("upgrade",      "vibranium_upgrade",                                                 "Vibranium Upgrade"),
    VIBRANIUM_UPGRADE_APPLIES_TO                   ("item",         "smithing_template.vibranium_upgrade.applies_to",                    "Allthemodium Equipment"),
    VIBRANIUM_UPGRADE_INGREDIENTS                  ("item",         "smithing_template.vibranium_upgrade.ingredients",                   "Vibranium Ingot"),
    VIBRANIUM_UPGRADE_BASE_SLOT_DESCRIPTION        ("item",         "smithing_template.vibranium_upgrade.base_slot_description",         "Add Allthemodium Armor, Weapon, or Tool"),
    VIBRANIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION   ("item",         "smithing_template.vibranium_upgrade.additions_slot_description",    "Add Vibranium Ingot"),
                                                                    
    UNOBTAINIUM_UPGRADE                            ("upgrade",      "unobtainium_upgrade",                                               "Unobtainium Upgrade"),
    UNOBTAINIUM_UPGRADE_APPLIES_TO                 ("item",         "smithing_template.unobtainium_upgrade.applies_to",                  "Vibranium Equipment"),
    UNOBTAINIUM_UPGRADE_INGREDIENTS                ("item",         "smithing_template.unobtainium_upgrade.ingredients",                 "Unobtainium Ingot"),
    UNOBTAINIUM_UPGRADE_BASE_SLOT_DESCRIPTION      ("item",         "smithing_template.unobtainium_upgrade.base_slot_description",       "Add Vibranium Armor, Weapon, or Tool"),
    UNOBTAINIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION ("item",         "smithing_template.unobtainium_upgrade.additions_slot_description",  "Add Unobtainium Ingot"),
    
    TOOLTIP_SILENT_PLATE                           ("item",         "silent_plate.tooltip",                                              "It's less... talkative now"),
    
    MESSAGE_NO_DESTINATION                         ("message",      "no_destination",                                                    "No Destination!"),
    MESSAGE_TRANSFER_FAILED                        ("message",      "transfer_failed",                                                   "Transfer Failed! Try moving the Teleport Pad to a different location"),
    MESSAGE_TELEPORT_PAD_USAGE                     ("message",      "teleport_pad.usage",                                                "Sneak + Right-Click to teleport"),
    MESSAGE_TELEPORT_TARGET                        ("message",      "teleport_pad.target",                                               "Target: %s"),
    MESSAGE_TELEPORT_PAD_NO_DROP                   ("message",      "teleport_pad.no_drop",                                              "Will not drop when mined"),
    
    JADE_TELEPORT_PAD                              ("config.jade.plugin_allthemodium.teleport_pad",                                            "Teleport Pad")
    // @formatter:on
    ;
    
    ATMLanguage(String group, String key, String translation) {
        this(Util.makeDescriptionId(group, ATM.id(key)), translation);
    }
    
    ATMLanguage(String key, String translation) {
        this.key = key;
        this.translation = translation;
    }
    
    private final String key;
    private final String translation;
    
    @Override
    public String key() {
        return this.key;
    }
    
    @Override
    public String translation() {
        return this.translation;
    }
    
    public static void translate(BiConsumer<String, String> consumer) {
        for (ATMLanguage entry : ATMLanguage.values()) {
            consumer.accept(entry.key(), entry.translation());
        }
    }
}
