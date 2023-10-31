package com.thevortex.allthemodium.registry.mek_reg;
import mekanism.api.MekanismAPI;
import mekanism.api.chemical.slurry.Slurry;
import mekanism.api.chemical.slurry.SlurryBuilder;
import mekanism.common.registration.WrappedDeferredRegister;
import mekanism.common.registration.impl.SlurryRegistryObject;

import java.util.function.UnaryOperator;

public class SlurryRegistry extends WrappedDeferredRegister<Slurry> {


    public SlurryRegistry(String modid) {
        super(modid,MekanismAPI.SLURRY_REGISTRY_NAME);
    }

    public SlurryRegistryObject<Slurry, Slurry> register(ATMResource resource) {
        return register(resource.getRegistrySuffix(), builder -> builder.tint(resource.getTint()).ore(resource.getOreTag()));
    }

    public SlurryRegistryObject<Slurry, Slurry> register(String baseName, UnaryOperator<SlurryBuilder> builderModifier) {
        return new SlurryRegistryObject<>(internal.register("dirty_" + baseName, () -> new Slurry(builderModifier.apply(SlurryBuilder.dirty()))),
                internal.register("clean_" + baseName, () -> new Slurry(builderModifier.apply(SlurryBuilder.clean()))));
    }


}
