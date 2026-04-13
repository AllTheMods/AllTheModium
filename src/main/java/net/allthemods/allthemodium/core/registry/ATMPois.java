package net.allthemods.allthemodium.core.registry;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.village.poi.PoiType;

import net.allthemods.allthemodium.api.ATM;

import com.google.common.collect.ImmutableSet;

public class ATMPois {
    
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(Registries.POINT_OF_INTEREST_TYPE, ATM.MOD_ID);
    
    public static final DeferredHolder<PoiType, PoiType> TELEPORT_PAD = ATMPois.POI_TYPES.register("teleport_pad", () -> new PoiType(
            ImmutableSet.copyOf(ATMBlocks.TELEPORT_PAD.get().getStateDefinition().getPossibleStates()), 1, 32
    ));
    
    public static void register(final IEventBus bus) {
        ATMPois.POI_TYPES.register(bus);
    }
}
