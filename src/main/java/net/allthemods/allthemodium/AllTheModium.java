package net.allthemods.allthemodium;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.compat.lootr.LootrCompat;
import net.allthemods.allthemodium.core.registry.ATMBlocks;
import net.allthemods.allthemodium.core.registry.ATMCreativeTabs;
import net.allthemods.allthemodium.core.registry.ATMEntities;
import net.allthemods.allthemodium.core.registry.ATMFluids;
import net.allthemods.allthemodium.core.registry.ATMItems;
import net.allthemods.allthemodium.core.registry.ATMPois;
import net.allthemods.allthemodium.core.registry.ATMStructureTypes;
import net.allthemods.allthemodium.core.registry.ATMTreeDecorators;

@Mod(ATM.MOD_ID)
public class AllTheModium {
    
    public AllTheModium(final IEventBus bus, final ModContainer container) {
        ATMFluids.register(bus);
        ATMBlocks.register(bus);
        ATMItems.register(bus);
        ATMEntities.register(bus);
        ATMStructureTypes.register(bus);
        ATMTreeDecorators.register(bus);
        ATMPois.register(bus);
        ATMCreativeTabs.register(bus);
        if (ModList.get().isLoaded("lootr")) LootrCompat.register(bus);
    }
}
