package com.thevortex.allthemodium.registry;

import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ArmorRegistries {

    @SuppressWarnings("unchecked")
    public static final Map<ArmorItem.Type,Integer> ALLTHEMODIUM = (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), (allthemodium) -> {
    allthemodium.put(ArmorItem.Type.HELMET, 4);
    allthemodium.put(ArmorItem.Type.CHESTPLATE, 7);
    allthemodium.put(ArmorItem.Type.LEGGINGS, 9);
    allthemodium.put(ArmorItem.Type.BOOTS, 4);
    allthemodium.put(ArmorItem.Type.BODY, 8);});

    @SuppressWarnings("unchecked")
    public static final Map<ArmorItem.Type,Integer> VIBRANIUM = (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), (vibranium) -> {
    vibranium.put(ArmorItem.Type.HELMET, 6);
    vibranium.put(ArmorItem.Type.CHESTPLATE, 9);
    vibranium.put(ArmorItem.Type.LEGGINGS, 11);
    vibranium.put(ArmorItem.Type.BOOTS, 6);
    vibranium.put(ArmorItem.Type.BODY, 10);});

    @SuppressWarnings("unchecked")
    public static final Map<ArmorItem.Type,Integer> UNOBTAINIUM = (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), (unobtainium) -> {
    unobtainium.put(ArmorItem.Type.HELMET, 8);
    unobtainium.put(ArmorItem.Type.CHESTPLATE, 11);
    unobtainium.put(ArmorItem.Type.LEGGINGS, 13);
    unobtainium.put(ArmorItem.Type.BOOTS, 8);
    unobtainium.put(ArmorItem.Type.BODY, 12);});


    
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, Reference.MOD_ID);

    public static final DeferredHolder<ArmorMaterial,ArmorMaterial> ATM = ARMOR_MATERIALS.register("allthemodium", () -> new ArmorMaterial(ALLTHEMODIUM, 85, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(ModRegistry.ALLTHEMODIUM_INGOT.get()), List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"allthemodium"))), 5.0F, 0.5f));
    public static final DeferredHolder<ArmorMaterial,ArmorMaterial> VIB = ARMOR_MATERIALS.register("vibranium", () -> new ArmorMaterial(VIBRANIUM, 105, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(ModRegistry.VIBRANIUM_INGOT.get()), List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"vibranium"))), 9.0F, 0.8f));
    public static final DeferredHolder<ArmorMaterial,ArmorMaterial> UNOB = ARMOR_MATERIALS.register("unobtainium", () -> new ArmorMaterial(UNOBTAINIUM, 125, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(ModRegistry.UNOBTAINIUM_INGOT.get()), List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"unobtainium"))), 15.0F, 1.0f));


}
