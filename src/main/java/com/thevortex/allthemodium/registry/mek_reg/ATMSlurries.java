package com.thevortex.allthemodium.registry.mek_reg;



import com.thevortex.allthemodium.reference.Reference;
import mekanism.api.chemical.slurry.Slurry;
import mekanism.common.registration.impl.SlurryRegistryObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class ATMSlurries {

    public static final SlurryRegistry SLURRIES = new SlurryRegistry(Reference.MOD_ID);

    public static final Map<ATMResource, SlurryRegistryObject<Slurry, Slurry>> PROCESSED_RESOURCES = new LinkedHashMap<>();

    static {
        for (ATMResource resource : EnumFunc.PRIMARY_RESOURCES) {
            PROCESSED_RESOURCES.put(resource, SLURRIES.register(resource));
        }
    }


}
