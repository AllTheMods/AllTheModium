package com.thevortex.allthemodium.registry;

import com.thevortex.allthemodium.AllTheModium;
import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);

    public static final RegistryObject<BucketItem> SOUL_LAVA_BUCKET = ITEMS.register("soul_lava_bucket", () -> new BucketItem(FluidRegistry.SOULLAVA, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(AllTheModium.GROUP)));

    public static final RegistryObject<BucketItem> MOLTEN_ATM_BUCKET = ITEMS.register("molten_allthemodium_bucket", () -> new BucketItem(FluidRegistry.ALLTHEMODIUM, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(AllTheModium.GROUP)));
    public static final RegistryObject<BucketItem> MOLTEN_VIB_BUCKET = ITEMS.register("molten_vibranium_bucket", () -> new BucketItem(FluidRegistry.VIBRANIUM, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(AllTheModium.GROUP)));
    public static final RegistryObject<BucketItem> MOLTEN_UNOB_BUCKET = ITEMS.register("molten_unobtainium_bucket", () -> new BucketItem(FluidRegistry.UNOBTAINIUM, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(AllTheModium.GROUP)));

}
