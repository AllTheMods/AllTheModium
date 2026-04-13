package net.allthemods.allthemodium;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

import net.allthemods.allthemodium.api.ATM;

@Mod(value = ATM.MOD_ID, dist = Dist.CLIENT)
public class AllTheModiumClient {
    
    public AllTheModiumClient(final IEventBus bus, final ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}
