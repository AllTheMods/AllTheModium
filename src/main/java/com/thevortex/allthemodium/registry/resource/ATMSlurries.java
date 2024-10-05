package com.thevortex.allthemodium.registry.resource;

import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.MekRegistry;
import java.util.LinkedHashMap;
import java.util.Map;
import mekanism.api.chemical.slurry.Slurry;
import mekanism.common.registration.impl.SlurryRegistryObject;

public class ATMSlurries {

    public static final MekRegistry SLURRIES = new MekRegistry(
            Reference.MOD_ID);

    public static final Map<ATMResource, SlurryRegistryObject<Slurry, Slurry>> PROCESSED_RESOURCES = new LinkedHashMap<>();

    static {
        for (ATMResource resource : EnumFunc.PRIMARY_RESOURCES) {
            PROCESSED_RESOURCES.put(resource, SLURRIES.register(resource));
        }
    }
}
