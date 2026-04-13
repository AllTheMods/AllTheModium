package net.allthemods.allthemodium.core.registry;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.client.lang.ATMLanguage;

import java.util.Collection;
import java.util.stream.Stream;

public class ATMCreativeTabs {
    
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ATM.MOD_ID);
    
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> DEFAULT = ATMCreativeTabs.TABS.register("default_tab", () -> CreativeModeTab.builder()
            .title(ATMLanguage.TABS_DEFAULT.translate())
            .icon(() -> ATMItems.RAW_ALLTHEMODIUM.get().getDefaultInstance())
            .displayItems((_, out) -> {
                ATMCreativeTabs.map(ATMItems.ITEMS.getEntries()).forEach(out::accept);
                ATMCreativeTabs.map(ATMBlocks.ITEMS.getEntries()).forEach(out::accept);
                ATMCreativeTabs.map(ATMFluids.ITEMS.getEntries()).forEach(out::accept);
            })
            .build()
    );
    
    private static Stream<ItemStack> map(Collection<DeferredHolder<Item, ? extends Item>> collection) {
        return collection.stream().map(DeferredHolder::get).map(Item::getDefaultInstance);
    }
    
    public static void register(final IEventBus bus) {
        ATMCreativeTabs.TABS.register(bus);
    }
}
