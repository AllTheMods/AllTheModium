package net.allthemods.allthemodium.core.registry;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Unit;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MaceItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.component.Weapon;
import net.minecraft.world.item.equipment.ArmorType;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.common.items.ModiumBootsItem;
import net.allthemods.allthemodium.common.items.ModiumBowItem;
import net.allthemods.allthemodium.common.items.ModiumChestplateItem;
import net.allthemods.allthemodium.common.items.ModiumCrossBowItem;
import net.allthemods.allthemodium.common.items.ModiumHelmetItem;
import net.allthemods.allthemodium.common.items.ModiumLeggingsItem;
import net.allthemods.allthemodium.common.items.ModiumShieldItem;
import net.allthemods.allthemodium.common.items.ModiumSmithingTemplateItem;
import net.allthemods.allthemodium.common.items.ModiumTrident;
import net.allthemods.allthemodium.common.items.PaxelItem;

import java.util.function.Function;

public class ATMItems {
    
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, ATM.MOD_ID);
    
    public static final DeferredHolder<Item, SpawnEggItem> PIGLICH_SPAWN_EGG = ATMItems.register("piglich_spawn_egg", p -> new SpawnEggItem(p.spawnEgg(ATMEntities.PIGLICH.get())));
    public static final DeferredHolder<Item, Item> PIGLICH_HEART = ATMItems.register("piglich_heart", p -> new Item(p.fireResistant().rarity(Rarity.EPIC)));
    
    public static final DeferredHolder<Item, Item> ALLTHEMODIUM_APPLE = ATMItems.register("allthemodium_apple", p -> new Item(p.fireResistant().food(ATMFoods.ALLTHEMODIUM_APPLE, ATMConsumables.ALLTHEMODIUM_APPLE).rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> ALLTHEMODIUM_CARROT = ATMItems.register("allthemodium_carrot", p -> new Item(p.fireResistant().food(ATMFoods.ALLTHEMODIUM_CARROT, ATMConsumables.ALLTHEMODIUM_CARROT).rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> SOUL_BERRIES = ATMItems.register("soul_berries", p -> new BlockItem(ATMBlocks.ANCIENT_CAVE_VINES.get(), p.food(ATMFoods.SOUL_BERRIES, ATMConsumables.SOUL_BERRIES)));
    
    public static final DeferredHolder<Item, Item> RAW_ALLTHEMODIUM = ATMItems.register("raw_allthemodium", Item::new);
    public static final DeferredHolder<Item, Item> RAW_VIBRANIUM = ATMItems.register("raw_vibranium", Item::new);
    public static final DeferredHolder<Item, Item> RAW_UNOBTAINIUM = ATMItems.register("raw_unobtainium", Item::new);
    
    public static final DeferredHolder<Item, Item> ALLTHEMODIUM_NUGGET = ATMItems.register("allthemodium_nugget", Item::new);
    public static final DeferredHolder<Item, Item> VIBRANIUM_NUGGET = ATMItems.register("vibranium_nugget", Item::new);
    public static final DeferredHolder<Item, Item> UNOBTAINIUM_NUGGET = ATMItems.register("unobtainium_nugget", Item::new);
    
    public static final DeferredHolder<Item, Item> ALLTHEMODIUM_DUST = ATMItems.register("allthemodium_dust", Item::new);
    public static final DeferredHolder<Item, Item> VIBRANIUM_DUST = ATMItems.register("vibranium_dust", Item::new);
    public static final DeferredHolder<Item, Item> UNOBTAINIUM_DUST = ATMItems.register("unobtainium_dust", Item::new);
    
    public static final DeferredHolder<Item, Item> ALLTHEMODIUM_INGOT = ATMItems.register("allthemodium_ingot", p -> new Item(p.trimMaterial(ATMTrimMaterials.ALLTHEMODIUM)));
    public static final DeferredHolder<Item, Item> VIBRANIUM_INGOT = ATMItems.register("vibranium_ingot", p -> new Item(p.trimMaterial(ATMTrimMaterials.VIBRANIUM)));
    public static final DeferredHolder<Item, Item> UNOBTAINIUM_INGOT = ATMItems.register("unobtainium_ingot", p -> new Item(p.trimMaterial(ATMTrimMaterials.UNOBTAINIUM)));
    
    public static final DeferredHolder<Item, Item> ALLTHEMODIUM_PLATE = ATMItems.register("allthemodium_plate", Item::new);
    public static final DeferredHolder<Item, Item> VIBRANIUM_PLATE = ATMItems.register("vibranium_plate", Item::new);
    public static final DeferredHolder<Item, Item> UNOBTAINIUM_PLATE = ATMItems.register("unobtainium_plate", Item::new);
    
    public static final DeferredHolder<Item, Item> ALLTHEMODIUM_GEAR = ATMItems.register("allthemodium_gear", Item::new);
    public static final DeferredHolder<Item, Item> VIBRANIUM_GEAR = ATMItems.register("vibranium_gear", Item::new);
    public static final DeferredHolder<Item, Item> UNOBTAINIUM_GEAR = ATMItems.register("unobtainium_gear", Item::new);
    
    public static final DeferredHolder<Item, Item> ALLTHEMODIUM_ROD = ATMItems.register("allthemodium_rod", Item::new);
    public static final DeferredHolder<Item, Item> VIBRANIUM_ROD = ATMItems.register("vibranium_rod", Item::new);
    public static final DeferredHolder<Item, Item> UNOBTAINIUM_ROD = ATMItems.register("unobtainium_rod", Item::new);
    
    public static final DeferredHolder<Item, Item> UNOBTAINIUM_ALLTHEMODIUM_DUST = ATMItems.register("unobtainium_allthemodium_alloy_dust", p -> new Item(p.fireResistant()));
    public static final DeferredHolder<Item, Item> UNOBTAINIUM_VIBRANIUM_DUST = ATMItems.register("unobtainium_vibranium_alloy_dust", p -> new Item(p.fireResistant()));
    public static final DeferredHolder<Item, Item> VIBRANIUM_ALLTHEMODIUM_DUST = ATMItems.register("vibranium_allthemodium_alloy_dust", p -> new Item(p.fireResistant()));
    
    public static final DeferredHolder<Item, Item> UNOBTAINIUM_ALLTHEMODIUM_ALLOY = ATMItems.register("unobtainium_allthemodium_alloy_ingot", p -> new Item(p.fireResistant()));
    public static final DeferredHolder<Item, Item> UNOBTAINIUM_VIBRANIUM_ALLOY = ATMItems.register("unobtainium_vibranium_alloy_ingot", p -> new Item(p.fireResistant()));
    public static final DeferredHolder<Item, Item> VIBRANIUM_ALLTHEMODIUM_ALLOY = ATMItems.register("vibranium_allthemodium_alloy_ingot", p -> new Item(p.fireResistant()));
    
    public static final DeferredHolder<Item, Item> ALLTHEMODIUM_HELMET = ATMItems.register("allthemodium_helmet", p -> new ModiumHelmetItem(p.humanoidArmor(ATMArmorMaterials.ALLTHEMODIUM, ArmorType.HELMET)));
    public static final DeferredHolder<Item, Item> ALLTHEMODIUM_CHESTPLATE = ATMItems.register("allthemodium_chestplate", p -> new ModiumChestplateItem(p.humanoidArmor(ATMArmorMaterials.ALLTHEMODIUM, ArmorType.CHESTPLATE)));
    public static final DeferredHolder<Item, Item> ALLTHEMODIUM_LEGGINGS = ATMItems.register("allthemodium_leggings", p -> new ModiumLeggingsItem(p.humanoidArmor(ATMArmorMaterials.ALLTHEMODIUM, ArmorType.LEGGINGS)));
    public static final DeferredHolder<Item, Item> ALLTHEMODIUM_BOOTS = ATMItems.register("allthemodium_boots", p -> new ModiumBootsItem(p.humanoidArmor(ATMArmorMaterials.ALLTHEMODIUM, ArmorType.BOOTS)));
    
    public static final DeferredHolder<Item, Item> VIBRANIUM_HELMET = ATMItems.register("vibranium_helmet", p -> new ModiumHelmetItem(p.humanoidArmor(ATMArmorMaterials.VIBRANIUM, ArmorType.HELMET)));
    public static final DeferredHolder<Item, Item> VIBRANIUM_CHESTPLATE = ATMItems.register("vibranium_chestplate", p -> new ModiumChestplateItem(p.humanoidArmor(ATMArmorMaterials.VIBRANIUM, ArmorType.CHESTPLATE)));
    public static final DeferredHolder<Item, Item> VIBRANIUM_LEGGINGS = ATMItems.register("vibranium_leggings", p -> new ModiumLeggingsItem(p.humanoidArmor(ATMArmorMaterials.VIBRANIUM, ArmorType.LEGGINGS)));
    public static final DeferredHolder<Item, Item> VIBRANIUM_BOOTS = ATMItems.register("vibranium_boots", p -> new ModiumBootsItem(p.humanoidArmor(ATMArmorMaterials.VIBRANIUM, ArmorType.BOOTS)));
    
    public static final DeferredHolder<Item, Item> UNOBTAINIUM_HELMET = ATMItems.register("unobtainium_helmet", p -> new ModiumHelmetItem(p.humanoidArmor(ATMArmorMaterials.UNOBTAINIUM, ArmorType.HELMET)));
    public static final DeferredHolder<Item, Item> UNOBTAINIUM_CHESTPLATE = ATMItems.register("unobtainium_chestplate", p -> new ModiumChestplateItem(p.humanoidArmor(ATMArmorMaterials.UNOBTAINIUM, ArmorType.CHESTPLATE)));
    public static final DeferredHolder<Item, Item> UNOBTAINIUM_LEGGINGS = ATMItems.register("unobtainium_leggings", p -> new ModiumLeggingsItem(p.humanoidArmor(ATMArmorMaterials.UNOBTAINIUM, ArmorType.LEGGINGS)));
    public static final DeferredHolder<Item, Item> UNOBTAINIUM_BOOTS = ATMItems.register("unobtainium_boots", p -> new ModiumBootsItem(p.humanoidArmor(ATMArmorMaterials.UNOBTAINIUM, ArmorType.BOOTS)));
    
    public static final DeferredHolder<Item, Item> ALLTHEMODIUM_SWORD = ATMItems.register("allthemodium_sword", p -> new Item(p.sword(ATMToolMaterials.ALLTHEMODIUM, 5.0F, -1.5F).component(DataComponents.UNBREAKABLE, Unit.INSTANCE).fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> ALLTHEMODIUM_PICKAXE = ATMItems.register("allthemodium_pickaxe", p -> new Item(p.pickaxe(ATMToolMaterials.ALLTHEMODIUM, 2.0F, -1.0F).component(DataComponents.UNBREAKABLE, Unit.INSTANCE).fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> ALLTHEMODIUM_AXE = ATMItems.register("allthemodium_axe", p -> new AxeItem(ATMToolMaterials.ALLTHEMODIUM, 9.0F, -3.2F, p.component(DataComponents.UNBREAKABLE, Unit.INSTANCE).fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> ALLTHEMODIUM_SHOVEL = ATMItems.register("allthemodium_shovel", p -> new ShovelItem(ATMToolMaterials.ALLTHEMODIUM, 2.0F, -1.0F, p.component(DataComponents.UNBREAKABLE, Unit.INSTANCE).fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> ALLTHEMODIUM_HOE = ATMItems.register("allthemodium_hoe", p -> new HoeItem(ATMToolMaterials.ALLTHEMODIUM, -3.0F, 0.0F, p.component(DataComponents.UNBREAKABLE, Unit.INSTANCE).fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> ALLTHEMODIUM_MACE = ATMItems.register("allthemodium_mace", p -> new MaceItem(p
            .rarity(Rarity.EPIC)
            .durability(Short.MAX_VALUE)
            .component(DataComponents.TOOL, ATMToolMaterials.createMaceTool(ATMToolMaterials.ALLTHEMODIUM))
            .repairable(ATMToolMaterials.ALLTHEMODIUM.repairItems())
            .attributes(ATMToolMaterials.createMaceAttributes(ATMToolMaterials.ALLTHEMODIUM))
            .enchantable(ATMToolMaterials.ALLTHEMODIUM.enchantmentValue())
            .component(DataComponents.WEAPON, new Weapon(1))
            .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
            .fireResistant()
    ));
    
    public static final DeferredHolder<Item, Item> VIBRANIUM_SWORD = ATMItems.register("vibranium_sword", p -> new Item(p.sword(ATMToolMaterials.VIBRANIUM, 10.0F, -0.5F).component(DataComponents.UNBREAKABLE, Unit.INSTANCE).fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> VIBRANIUM_PICKAXE = ATMItems.register("vibranium_pickaxe", p -> new Item(p.pickaxe(ATMToolMaterials.VIBRANIUM, 4.0F, -0.8F).component(DataComponents.UNBREAKABLE, Unit.INSTANCE).fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> VIBRANIUM_AXE = ATMItems.register("vibranium_axe", p -> new AxeItem(ATMToolMaterials.VIBRANIUM, 12.0F, -3.0F, p.component(DataComponents.UNBREAKABLE, Unit.INSTANCE).fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> VIBRANIUM_SHOVEL = ATMItems.register("vibranium_shovel", p -> new ShovelItem(ATMToolMaterials.VIBRANIUM, 4.0F, -0.8F, p.component(DataComponents.UNBREAKABLE, Unit.INSTANCE).fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> VIBRANIUM_HOE = ATMItems.register("vibranium_hoe", p -> new HoeItem(ATMToolMaterials.VIBRANIUM, -2.0F, 0.0F, p.component(DataComponents.UNBREAKABLE, Unit.INSTANCE).fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> VIBRANIUM_MACE = ATMItems.register("vibranium_mace", p -> new MaceItem(p
            .rarity(Rarity.EPIC)
            .durability(Short.MAX_VALUE)
            .component(DataComponents.TOOL, ATMToolMaterials.createMaceTool(ATMToolMaterials.VIBRANIUM))
            .repairable(ATMToolMaterials.VIBRANIUM.repairItems())
            .attributes(ATMToolMaterials.createMaceAttributes(ATMToolMaterials.VIBRANIUM))
            .enchantable(ATMToolMaterials.VIBRANIUM.enchantmentValue())
            .component(DataComponents.WEAPON, new Weapon(1))
            .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
            .fireResistant()
    ));
    
    public static final DeferredHolder<Item, Item> UNOBTAINIUM_SWORD = ATMItems.register("unobtainium_sword", p -> new Item(p.sword(ATMToolMaterials.UNOBTAINIUM, 15.0F, 0.5F).component(DataComponents.UNBREAKABLE, Unit.INSTANCE).fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> UNOBTAINIUM_PICKAXE = ATMItems.register("unobtainium_pickaxe", p -> new Item(p.pickaxe(ATMToolMaterials.UNOBTAINIUM, 6.0F, -0.6F).component(DataComponents.UNBREAKABLE, Unit.INSTANCE).fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> UNOBTAINIUM_AXE = ATMItems.register("unobtainium_axe", p -> new AxeItem(ATMToolMaterials.UNOBTAINIUM, 15.0F, -2.8F, p.component(DataComponents.UNBREAKABLE, Unit.INSTANCE).fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> UNOBTAINIUM_SHOVEL = ATMItems.register("unobtainium_shovel", p -> new ShovelItem(ATMToolMaterials.UNOBTAINIUM, 6.0F, -0.6F, p.component(DataComponents.UNBREAKABLE, Unit.INSTANCE).fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> UNOBTAINIUM_HOE = ATMItems.register("unobtainium_hoe", p -> new HoeItem(ATMToolMaterials.UNOBTAINIUM, -1.0F, 0.0F, p.component(DataComponents.UNBREAKABLE, Unit.INSTANCE).fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> UNOBTAINIUM_MACE = ATMItems.register("unobtainium_mace", p -> new MaceItem(p
            .rarity(Rarity.EPIC)
            .durability(Short.MAX_VALUE)
            .component(DataComponents.TOOL, ATMToolMaterials.createMaceTool(ATMToolMaterials.UNOBTAINIUM))
            .repairable(ATMToolMaterials.UNOBTAINIUM.repairItems())
            .attributes(ATMToolMaterials.createMaceAttributes(ATMToolMaterials.UNOBTAINIUM))
            .enchantable(ATMToolMaterials.UNOBTAINIUM.enchantmentValue())
            .component(DataComponents.WEAPON, new Weapon(1))
            .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
            .fireResistant()
    ));
    
    public static final DeferredHolder<Item, Item> ALLOY_SWORD = ATMItems.register("alloy_sword", p -> new Item(p.sword(ATMToolMaterials.ALLOY, 20.0F, 1.5F).component(DataComponents.UNBREAKABLE, Unit.INSTANCE).fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> ALLOY_PICKAXE = ATMItems.register("alloy_pickaxe", p -> new Item(p.pickaxe(ATMToolMaterials.ALLOY, 8.0F, -0.4F).component(DataComponents.UNBREAKABLE, Unit.INSTANCE).fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> ALLOY_AXE = ATMItems.register("alloy_axe", p -> new AxeItem(ATMToolMaterials.ALLOY, 18.0F, -2.6F, p.component(DataComponents.UNBREAKABLE, Unit.INSTANCE).fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> ALLOY_SHOVEL = ATMItems.register("alloy_shovel", p -> new ShovelItem(ATMToolMaterials.ALLOY, 8.0F, -0.4F, p.component(DataComponents.UNBREAKABLE, Unit.INSTANCE).fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> ALLOY_PAXEL = ATMItems.register("alloy_paxel", p -> new PaxelItem(p
            .rarity(Rarity.EPIC)
            .tool(ATMToolMaterials.ALLOY, ATMTags.Blocks.MINEABLE_WITH_PAXEL, 12.0F, -0.6F, 2.0F)
            .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
            .fireResistant()
    
    ));
    public static final DeferredHolder<Item, Item> ALLOY_MACE = ATMItems.register("alloy_mace", p -> new Item(p
            .rarity(Rarity.EPIC)
            .durability(Short.MAX_VALUE)
            .component(DataComponents.TOOL, ATMToolMaterials.createMaceTool(ATMToolMaterials.ALLOY))
            .repairable(ATMToolMaterials.ALLOY.repairItems())
            .attributes(ATMToolMaterials.createMaceAttributes(ATMToolMaterials.ALLOY))
            .enchantable(ATMToolMaterials.ALLOY.enchantmentValue())
            .component(DataComponents.WEAPON, new Weapon(1))
            .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
            .fireResistant()
    ));
    
    public static final DeferredHolder<Item, ModiumBowItem> ALLTHEMODIUM_BOW = ATMItems.register("allthemodium_bow", ModiumBowItem::new);
    public static final DeferredHolder<Item, ModiumShieldItem> VIBRANIUM_SHIELD = ATMItems.register("vibranium_shield", ModiumShieldItem::new);
    public static final DeferredHolder<Item, ModiumCrossBowItem> UNOBTAINIUM_CROSSBOW = ATMItems.register("unobtainium_crossbow", ModiumCrossBowItem::new);
    public static final DeferredHolder<Item, ModiumTrident> ALLOY_TRIDENT = ATMItems.register("alloy_trident", ModiumTrident::new);
    
    public static final DeferredHolder<Item, ModiumSmithingTemplateItem> ALLTHEMODIUM_SMITHING_TEMPLATE = ATMItems.register("allthemodium_upgrade_smithing_template", ModiumSmithingTemplateItem::createAllthemodiumUpgradeTemplate);
    public static final DeferredHolder<Item, ModiumSmithingTemplateItem> VIBRANIUM_SMITHING_TEMPLATE = ATMItems.register("vibranium_upgrade_smithing_template", ModiumSmithingTemplateItem::createVibraniumUpgradeTemplate);
    public static final DeferredHolder<Item, ModiumSmithingTemplateItem> UNOBTAINIUM_SMITHING_TEMPLATE = ATMItems.register("unobtainium_upgrade_smithing_template", ModiumSmithingTemplateItem::createUnobtainiumUpgradeTemplate);
    
    private static <T extends Item> DeferredHolder<Item, T> register(String name, Function<Item.Properties, T> factory) {
        return ATMItems.ITEMS.register(name, p -> factory.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, p))));
    }
    
    public static void register(final IEventBus bus) {
        ATMItems.ITEMS.register(bus);
    }
}
