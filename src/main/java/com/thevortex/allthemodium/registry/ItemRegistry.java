package com.thevortex.allthemodium.registry;

import com.thevortex.allthemodium.AllTheModium;
import com.thevortex.allthemodium.items.toolitems.tools.*;
import com.thevortex.allthemodium.material.ToolTiers;
import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
            ForgeRegistries.ITEMS,
            Reference.MOD_ID);

    public static final RegistryObject<BucketItem> SOUL_LAVA_BUCKET = ITEMS.register(
            "soul_lava_bucket",
            () -> new BucketItem(
                    FluidRegistry.SOULLAVA,
                    new Item.Properties()
                            .craftRemainder(Items.BUCKET)
                            .stacksTo(1)
                            .tab(AllTheModium.GROUP)));

    public static final RegistryObject<BucketItem> MOLTEN_ATM_BUCKET = ITEMS.register(
            "molten_allthemodium_bucket",
            () -> new BucketItem(
                    FluidRegistry.ALLTHEMODIUM,
                    new Item.Properties()
                            .craftRemainder(Items.BUCKET)
                            .stacksTo(1)
                            .tab(AllTheModium.GROUP)));
    public static final RegistryObject<BucketItem> MOLTEN_VIB_BUCKET = ITEMS.register(
            "molten_vibranium_bucket",
            () -> new BucketItem(
                    FluidRegistry.VIBRANIUM,
                    new Item.Properties()
                            .craftRemainder(Items.BUCKET)
                            .stacksTo(1)
                            .tab(AllTheModium.GROUP)));
    public static final RegistryObject<BucketItem> MOLTEN_UNOB_BUCKET = ITEMS.register(
            "molten_unobtainium_bucket",
            () -> new BucketItem(
                    FluidRegistry.UNOBTAINIUM,
                    new Item.Properties()
                            .craftRemainder(Items.BUCKET)
                            .stacksTo(1)
                            .tab(AllTheModium.GROUP)));

    public static final RegistryObject<SwordItem> ATM_ALLOY_SWORD = ITEMS.register(
            "alloy_sword",
            () -> new AlloySword(
                    ToolTiers.ALLOY_TIER,
                    35,
                    5.0F,
                    new Item.Properties()
                            .fireResistant()
                            .stacksTo(1)
                            .rarity(Rarity.EPIC)
                            .tab(AllTheModium.GROUP)));
    public static final RegistryObject<AxeItem> ATM_ALLOY_AXE = ITEMS.register(
            "alloy_axe",
            () -> new AlloyAxe(
                    ToolTiers.ALLOY_TIER,
                    39,
                    5.0F,
                    new Item.Properties()
                            .fireResistant()
                            .stacksTo(1)
                            .rarity(Rarity.EPIC)
                            .tab(AllTheModium.GROUP)));
    public static final RegistryObject<PickaxeItem> ATM_ALLOY_PICK = ITEMS.register(
            "alloy_pick",
            () -> new AlloyPick(
                    ToolTiers.ALLOY_TIER,
                    15,
                    5.0F,
                    new Item.Properties()
                            .fireResistant()
                            .stacksTo(1)
                            .rarity(Rarity.EPIC)
                            .tab(AllTheModium.GROUP)));
    public static final RegistryObject<ShovelItem> ATM_ALLOY_SHOVEL = ITEMS.register(
            "alloy_shovel",
            () -> new AlloyShovel(
                    ToolTiers.ALLOY_TIER,
                    13,
                    5.0F,
                    new Item.Properties()
                            .fireResistant()
                            .stacksTo(1)
                            .rarity(Rarity.EPIC)
                            .tab(AllTheModium.GROUP)));
    public static final RegistryObject<DiggerItem> ATM_ALLOY_PAXEL = ITEMS.register(
            "alloy_paxel",
            () -> new AlloyPaxel(
                    33,
                    5.0F,
                    ToolTiers.ALLOY_TIER,
                    TagRegistry.PAXEL_TARGETS,
                    new Item.Properties()
                            .fireResistant()
                            .stacksTo(1)
                            .rarity(Rarity.EPIC)
                            .tab(AllTheModium.GROUP)));
}
