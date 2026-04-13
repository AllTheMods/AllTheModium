package net.allthemods.allthemodium.core.registry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import net.allthemods.allthemodium.api.ATM;

import com.google.common.collect.Maps;

import java.util.Map;

public class ATMArmorMaterials {
    
    public static final ResourceKey<EquipmentAsset> ALLTHEMODIUM_ASSET = ATM.key(EquipmentAssets.ROOT_ID, "allthemodium");
    public static final ResourceKey<EquipmentAsset> VIBRANIUM_ASSET = ATM.key(EquipmentAssets.ROOT_ID, "vibranium");
    public static final ResourceKey<EquipmentAsset> UNOBTAINIUM_ASSET = ATM.key(EquipmentAssets.ROOT_ID, "unobtainium");
    
    public static final ArmorMaterial ALLTHEMODIUM = new ArmorMaterial(
            Short.MAX_VALUE,
            ATMArmorMaterials.defense(4, 9, 7, 4, 8),
            85,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            5.0F,
            0.5f,
            ATMTags.Items.INGOTS_ALLTHEMODIUM,
            ATMArmorMaterials.ALLTHEMODIUM_ASSET
    );
    
    public static final ArmorMaterial VIBRANIUM = new ArmorMaterial(
            Short.MAX_VALUE,
            ATMArmorMaterials.defense(6, 11, 9, 6, 10),
            100,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            9.0F,
            0.8f,
            ATMTags.Items.INGOTS_VIBRANIUM,
            ATMArmorMaterials.VIBRANIUM_ASSET
    );
    
    public static final ArmorMaterial UNOBTAINIUM = new ArmorMaterial(
            Short.MAX_VALUE,
            ATMArmorMaterials.defense(8, 13, 11, 8, 12),
            125,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            15.0F,
            1.0f,
            ATMTags.Items.INGOTS_UNOBTAINIUM,
            ATMArmorMaterials.UNOBTAINIUM_ASSET
    );
    
    private static Map<ArmorType, Integer> defense(int helmet, int chest, int leggings, int boots, int body) {
        return Maps.newEnumMap(Map.of(ArmorType.BOOTS, boots, ArmorType.LEGGINGS, leggings, ArmorType.CHESTPLATE, chest, ArmorType.HELMET, helmet, ArmorType.BODY, body));
    }
}
