package com.thevortex.allthemodium.init;

import com.thevortex.allthemodium.AllTheModium;
import com.thevortex.allthemodium.datagen.server.BlockTags;
import com.thevortex.allthemodium.items.*;
import com.thevortex.allthemodium.items.toolitems.armor.*;
import com.thevortex.allthemodium.items.toolitems.tools.*;
import com.thevortex.allthemodium.material.AArmorMaterial;
import com.thevortex.allthemodium.reference.Reference;

import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ObjectHolder;

public class ModItems {

	@ObjectHolder("allthemodium:allthemodium_apple")
	public static Item ALLTHEMODIUM_APPLE;
	@ObjectHolder("allthemodium:allthemodium_carrot")
	public static Item ALLTHEMODIUM_CARROT;

	/*
	@ObjectHolder("allthemodium:alloy_paxel")
	public static DiggerItem ALLTHEMODIUM_PAXEL;

	@ObjectHolder("allthemodium:alloy_pick")
	public static PickaxeItem ALLTHEMODIUM_PICKAXE;
	@ObjectHolder("allthemodium:alloy_axe")
	public static AxeItem ALLTHEMODIUM_AXE;
	@ObjectHolder("allthemodium:alloy_sword")
	public static SwordItem ALLTHEMODIUM_SWORD;
	@ObjectHolder("allthemodium:alloy_shovel")
	public static ShovelItem ALLTHEMODIUM_SHOVEL;
	*/
	@ObjectHolder("allthemodium:allthemodium_helmet")
	public static ArmorItem ALLTHEMODIUM_HELMET;
	@ObjectHolder("allthemodium:allthemodium_chestplate")
	public static ArmorItem ALLTHEMODIUM_CHESTPLATE;
	@ObjectHolder("allthemodium:allthemodium_leggings")
	public static ArmorItem ALLTHEMODIUM_LEGGINGS;
	@ObjectHolder("allthemodium:allthemodium_boots")
	public static ArmorItem ALLTHEMODIUM_BOOTS;

	@ObjectHolder("allthemodium:vibranium_helmet")
	public static ArmorItem VIBRANIUM_HELMET;
	@ObjectHolder("allthemodium:vibranium_chestplate")
	public static ArmorItem VIBRANIUM_CHESTPLATE;
	@ObjectHolder("allthemodium:vibranium_leggings")
	public static ArmorItem VIBRANIUM_LEGGINGS;
	@ObjectHolder("allthemodium:vibranium_boots")
	public static ArmorItem VIBRANIUM_BOOTS;

	@ObjectHolder("allthemodium:unobtainium_helmet")
	public static ArmorItem UNOBTAINIUM_HELMET;
	@ObjectHolder("allthemodium:unobtainium_chestplate")
	public static ArmorItem UNOBTAINIUM_CHESTPLATE;
	@ObjectHolder("allthemodium:unobtainium_leggings")
	public static ArmorItem UNOBTAINIUM_LEGGINGS;
	@ObjectHolder("allthemodium:unobtainium_boots")
	public static ArmorItem UNOBTAINIUM_BOOTS;

	@ObjectHolder("allthemodium:unobtainium_allthemodium_alloy_dust")
	public static Item UNOBTAINIUM_ALLTHEMODIUM_DUST;
	@ObjectHolder("allthemodium:unobtainium_vibranium_alloy_dust")
	public static Item UNOBTAINIUM_VIBRANIUM_DUST;
	@ObjectHolder("allthemodium:vibranium_allthemodium_alloy_dust")
	public static Item VIBRANIUM_ALLTHEMODIUM_DUST;
	
	@ObjectHolder("allthemodium:unobtainium_allthemodium_alloy_ingot")
	public static Item UNOBTAINIUM_ALLTHEMODIUM_ALLOY;
	@ObjectHolder("allthemodium:unobtainium_vibranium_alloy_ingot")
	public static Item UNOBTAINIUM_VIBRANIUM_ALLOY;
	@ObjectHolder("allthemodium:vibranium_allthemodium_alloy_ingot")
	public static Item VIBRANIUM_ALLTHEMODIUM_ALLOY;

	public static CreativeModeTab group = AllTheModium.GROUP;
	public static void init(Register<Item> event) {

		
		
		ALLTHEMODIUM_APPLE = new Allthemodium_Apple(new Item.Properties().tab(group).fireResistant().food(ModFoods.ALLTHEMODIUM_APPLE)).setRegistryName(location("allthemodium_apple"));
		ALLTHEMODIUM_CARROT = new Allthemodium_Carrot(new Item.Properties().tab(group).fireResistant().food(ModFoods.ALLTHEMODIUM_CARROT)).setRegistryName(location("allthemodium_carrot"));

		UNOBTAINIUM_ALLTHEMODIUM_DUST = new Alloy_Dust(new Item.Properties().tab(group).fireResistant()).setRegistryName(location("unobtainium_allthemodium_alloy_dust"));
		UNOBTAINIUM_VIBRANIUM_DUST = new Alloy_Dust(new Item.Properties().tab(group).fireResistant()).setRegistryName(location("unobtainium_vibranium_alloy_dust"));
		VIBRANIUM_ALLTHEMODIUM_DUST = new Alloy_Dust(new Item.Properties().tab(group).fireResistant()).setRegistryName(location("vibranium_allthemodium_alloy_dust"));

		UNOBTAINIUM_ALLTHEMODIUM_ALLOY = new Alloy_Ingot(new Item.Properties().tab(group).fireResistant()).setRegistryName(location("unobtainium_allthemodium_alloy_ingot"));
		UNOBTAINIUM_VIBRANIUM_ALLOY = new Alloy_Ingot(new Item.Properties().tab(group).fireResistant()).setRegistryName(location("unobtainium_vibranium_alloy_ingot"));
		VIBRANIUM_ALLTHEMODIUM_ALLOY = new Alloy_Ingot(new Item.Properties().tab(group).fireResistant()).setRegistryName(location("vibranium_allthemodium_alloy_ingot"));
		
		ALLTHEMODIUM_BOOTS = (ArmorItem) new Allthemodium_Boots(AArmorMaterial.ALLTHEMODIUM, EquipmentSlot.FEET, new Item.Properties().tab(group).stacksTo(1).fireResistant()).setRegistryName(location("allthemodium_boots"));
		ALLTHEMODIUM_LEGGINGS = (ArmorItem) new Allthemodium_Leggings(AArmorMaterial.ALLTHEMODIUM, EquipmentSlot.LEGS, new Item.Properties().tab(group).stacksTo(1).fireResistant()).setRegistryName(location("allthemodium_leggings"));
		ALLTHEMODIUM_CHESTPLATE = (ArmorItem) new Allthemodium_Chestplate(AArmorMaterial.ALLTHEMODIUM, EquipmentSlot.CHEST, new Item.Properties().tab(group).stacksTo(1).fireResistant()).setRegistryName(location("allthemodium_chestplate"));
		ALLTHEMODIUM_HELMET = (ArmorItem) new Allthemodium_Helmet(AArmorMaterial.ALLTHEMODIUM, EquipmentSlot.HEAD, new Item.Properties().tab(group).stacksTo(1).fireResistant()).setRegistryName(location("allthemodium_helmet"));
		
		VIBRANIUM_BOOTS = (ArmorItem) new Vibranium_Boots(AArmorMaterial.VIBRANIUM, EquipmentSlot.FEET, new Item.Properties().tab(group).stacksTo(1).fireResistant()).setRegistryName(location("vibranium_boots"));
		VIBRANIUM_LEGGINGS = (ArmorItem) new Vibranium_Leggings(AArmorMaterial.VIBRANIUM, EquipmentSlot.LEGS, new Item.Properties().tab(group).stacksTo(1).fireResistant()).setRegistryName(location("vibranium_leggings"));
		VIBRANIUM_CHESTPLATE = (ArmorItem) new Vibranium_Chestplate(AArmorMaterial.VIBRANIUM, EquipmentSlot.CHEST, new Item.Properties().tab(group).stacksTo(1).fireResistant()).setRegistryName(location("vibranium_chestplate"));
		VIBRANIUM_HELMET = (ArmorItem) new Vibranium_Helmet(AArmorMaterial.VIBRANIUM, EquipmentSlot.HEAD, new Item.Properties().tab(group).stacksTo(1).fireResistant()).setRegistryName(location("vibranium_helmet"));
		
		UNOBTAINIUM_BOOTS = (ArmorItem) new Unobtainium_Boots(AArmorMaterial.UNOBTAINIUM, EquipmentSlot.FEET, new Item.Properties().tab(group).stacksTo(1).fireResistant()).setRegistryName(location("unobtainium_boots"));
		UNOBTAINIUM_LEGGINGS = (ArmorItem) new Unobtainium_Leggings(AArmorMaterial.UNOBTAINIUM, EquipmentSlot.LEGS, new Item.Properties().tab(group).stacksTo(1).fireResistant()).setRegistryName(location("unobtainium_leggings"));
		UNOBTAINIUM_CHESTPLATE = (ArmorItem) new Unobtainium_Chestplate(AArmorMaterial.UNOBTAINIUM, EquipmentSlot.CHEST, new Item.Properties().tab(group).stacksTo(1).fireResistant()).setRegistryName(location("unobtainium_chestplate"));
		UNOBTAINIUM_HELMET = (ArmorItem) new Unobtainium_Helmet(AArmorMaterial.UNOBTAINIUM, EquipmentSlot.HEAD, new Item.Properties().tab(group).stacksTo(1).fireResistant()).setRegistryName(location("unobtainium_helmet"));

		//ALLTHEMODIUM_PICKAXE = (PickaxeItem) new Allthemodium_PickAxe(ItemTier.UNOBTAINIUMALLOY, 3, 2.8F, new PickaxeItem.Properties().tab(group).stacksTo(1).fireResistant()).setRegistryName(location("alloy_pick"));
		//ALLTHEMODIUM_AXE = (AxeItem) new Allthemodium_Axe(ItemTier.UNOBTAINIUMALLOY, 5, 7.8F, new AxeItem.Properties().tab(group).stacksTo(1).fireResistant()).setRegistryName(location("alloy_axe"));
		//ALLTHEMODIUM_SWORD = (SwordItem) new Allthemodium_Sword(ItemTier.UNOBTAINIUMALLOY, 10, 10.8F, new SwordItem.Properties().tab(group).stacksTo(1).fireResistant()).setRegistryName(location("alloy_sword"));
		//ALLTHEMODIUM_SHOVEL = (ShovelItem) new Allthemodium_Shovel(ItemTier.UNOBTAINIUMALLOY, 0, 4.8F, new ShovelItem.Properties().tab(group).stacksTo(1).fireResistant()).setRegistryName(location("alloy_shovel"));
		//ALLTHEMODIUM_PAXEL = (DiggerItem) new Allthemodium_Paxel(25,18.6F,ItemTier.UNOBTAINIUMALLOY,  ,new DiggerItem.Properties().tab(group).stacksTo(1).fireResistant()).setRegistryName(location("alloy_paxel"));

		event.getRegistry().register(ModItems.ALLTHEMODIUM_APPLE);
		event.getRegistry().register(ModItems.ALLTHEMODIUM_CARROT);

		//event.getRegistry().register(ModItems.ALLTHEMODIUM_BOOTS);
		//event.getRegistry().register(ModItems.ALLTHEMODIUM_LEGGINGS);
		//event.getRegistry().register(ModItems.ALLTHEMODIUM_CHESTPLATE);
		//event.getRegistry().register(ModItems.ALLTHEMODIUM_HELMET);
		
		//event.getRegistry().register(ModItems.ALLTHEMODIUM_PICKAXE);
		//event.getRegistry().register(ModItems.ALLTHEMODIUM_AXE);
		//event.getRegistry().register(ModItems.ALLTHEMODIUM_SWORD);
		//event.getRegistry().register(ModItems.ALLTHEMODIUM_SHOVEL);
		//event.getRegistry().register(ModItems.ALLTHEMODIUM_PAXEL);

		//event.getRegistry().register(ModItems.UNOBTAINIUM_BOOTS);
		//event.getRegistry().register(ModItems.UNOBTAINIUM_LEGGINGS);
		//event.getRegistry().register(ModItems.UNOBTAINIUM_CHESTPLATE);
		//event.getRegistry().register(ModItems.UNOBTAINIUM_HELMET);

		//event.getRegistry().register(ModItems.VIBRANIUM_BOOTS);
		//event.getRegistry().register(ModItems.VIBRANIUM_LEGGINGS);
		//event.getRegistry().register(ModItems.VIBRANIUM_CHESTPLATE);
		//event.getRegistry().register(ModItems.VIBRANIUM_HELMET);

		event.getRegistry().register(ModItems.UNOBTAINIUM_ALLTHEMODIUM_DUST);
		event.getRegistry().register(ModItems.UNOBTAINIUM_VIBRANIUM_DUST);
		event.getRegistry().register(ModItems.VIBRANIUM_ALLTHEMODIUM_DUST);
		event.getRegistry().register(ModItems.UNOBTAINIUM_ALLTHEMODIUM_ALLOY);
		event.getRegistry().register(ModItems.UNOBTAINIUM_VIBRANIUM_ALLOY);
		event.getRegistry().register(ModItems.VIBRANIUM_ALLTHEMODIUM_ALLOY);


	}
	private static ResourceLocation location(String name) {
		return new ResourceLocation(Reference.MOD_ID, name);
	}
}
