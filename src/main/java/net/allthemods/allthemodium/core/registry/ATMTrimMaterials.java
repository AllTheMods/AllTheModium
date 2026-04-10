package net.allthemods.allthemodium.core.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import net.minecraft.world.item.equipment.trim.TrimMaterial;

import net.allthemods.allthemodium.api.ATM;

import java.util.Map;

public final class ATMTrimMaterials {
    public static final ResourceKey<TrimMaterial> ALLTHEMODIUM = ATM.key(Registries.TRIM_MATERIAL, "allthemodium");
    public static final ResourceKey<TrimMaterial> VIBRANIUM = ATM.key(Registries.TRIM_MATERIAL, "vibranium");
    public static final ResourceKey<TrimMaterial> UNOBTAINIUM = ATM.key(Registries.TRIM_MATERIAL, "unobtainium");
    
    public static final MaterialAssetGroup ALLTHEMODIUM_ASSETS = MaterialAssetGroup.create(
            "allthemodium",
            Map.of(ATMArmorMaterials.ALLTHEMODIUM_ASSET, "allthemodium_darker")
    );
    public static final MaterialAssetGroup VIBRANIUM_ASSETS = MaterialAssetGroup.create("vibranium");
    public static final MaterialAssetGroup UNOBTAINIUM_ASSETS = MaterialAssetGroup.create("unobtainium");
    
    private ATMTrimMaterials() {
    }
}
