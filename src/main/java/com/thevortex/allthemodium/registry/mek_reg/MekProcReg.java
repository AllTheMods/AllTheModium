package com.thevortex.allthemodium.registry.mek_reg;

import com.thevortex.allthemodium.items.Clump;
import com.thevortex.allthemodium.items.Crystal;
import com.thevortex.allthemodium.items.DirtyDust;
import com.thevortex.allthemodium.items.Shard;
import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MekProcReg {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(Reference.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Reference.MOD_ID);


	public static final DeferredHolder<Item,Item> ATM_CLUMP = ITEMS.register("allthemodium_clump", () -> new Clump(new Item.Properties()));
	public static final DeferredHolder<Item,Item> VIB_CLUMP = ITEMS.register("vibranium_clump", () -> new Clump(new Item.Properties()));
	public static final DeferredHolder<Item,Item> ONOB_CLUMP = ITEMS.register("unobtainium_clump", () -> new Clump(new Item.Properties()));

	public static final DeferredHolder<Item,Item> ATM_SHARD = ITEMS.register("allthemodium_shard", () -> new Shard(new Item.Properties()));
	public static final DeferredHolder<Item,Item> VIB_SHARD = ITEMS.register("vibranium_shard", () -> new Shard(new Item.Properties()));
	public static final DeferredHolder<Item,Item> ONOB_SHARD = ITEMS.register("unobtainium_shard", () -> new Shard(new Item.Properties()));

	public static final DeferredHolder<Item,Item> ATM_DIRTY = ITEMS.register("dirty_allthemodium_dust", () -> new DirtyDust(new Item.Properties()));
	public static final DeferredHolder<Item,Item> VIB_DIRTY = ITEMS.register("dirty_vibranium_dust", () -> new DirtyDust(new Item.Properties()));
	public static final DeferredHolder<Item,Item> ONOB_DIRTY = ITEMS.register("dirty_unobtainium_dust", () -> new DirtyDust(new Item.Properties()));

	public static final DeferredHolder<Item,Item> ATM_CRYSTAL = ITEMS.register("allthemodium_crystal", () -> new Crystal(new Item.Properties()));
	public static final DeferredHolder<Item,Item> VIB_CRYSTAL = ITEMS.register("vibranium_crystal", () -> new Crystal(new Item.Properties()));
	public static final DeferredHolder<Item,Item> ONOB_CRYSTAL = ITEMS.register("unobtainium_crystal", () -> new Crystal(new Item.Properties()));


    public static final DeferredHolder<CreativeModeTab,CreativeModeTab> CREATIVE_TAB = CREATIVE_TABS.register("creative_tab_mek", () -> CreativeModeTab.builder()
			.title(Component.translatable(Reference.tabmek()))
			.icon(() -> ATM_CRYSTAL.get().getDefaultInstance())
			.displayItems((parameters, output) -> ITEMS.getEntries().stream()
					.map(DeferredHolder::get)
					.map(Item::getDefaultInstance)
					.forEach(output::accept))
			.build()
	);
}
