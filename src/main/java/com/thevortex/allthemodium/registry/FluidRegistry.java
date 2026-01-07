package com.thevortex.allthemodium.registry;

import com.thevortex.allthemodium.fluid.FluidATM;
import com.thevortex.allthemodium.fluid.FluidSoulLava;
import com.thevortex.allthemodium.fluid.FluidUNOB;
import com.thevortex.allthemodium.fluid.FluidVIB;
import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FluidRegistry {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, Reference.MOD_ID);

    public static final DeferredHolder<Fluid, com.thevortex.allthemodium.fluid.FluidSoulLava.Source> SOULLAVA = FLUIDS.register("soul_lava",
            FluidSoulLava.Source::new);
    public static final DeferredHolder<Fluid, com.thevortex.allthemodium.fluid.FluidSoulLava.Flowing> FLOWING_SOULLAVA = FLUIDS.register("flowing_soul_lava",
            FluidSoulLava.Flowing::new);


    public static final DeferredHolder<Fluid, com.thevortex.allthemodium.fluid.FluidATM.Source> ALLTHEMODIUM = FLUIDS.register("molten_allthemodium",
            FluidATM.Source::new);
    public static final DeferredHolder<Fluid, com.thevortex.allthemodium.fluid.FluidATM.Flowing> FLOWING_ALLTHEMODIUM = FLUIDS.register("flowing_molten_allthemodium",
            FluidATM.Flowing::new);

    public static final DeferredHolder<Fluid, com.thevortex.allthemodium.fluid.FluidVIB.Source> VIBRANIUM = FLUIDS.register("molten_vibranium",
            FluidVIB.Source::new);
    public static final DeferredHolder<Fluid, com.thevortex.allthemodium.fluid.FluidVIB.Flowing> FLOWING_VIBRANIUM = FLUIDS.register("flowing_molten_vibranium",
            FluidVIB.Flowing::new);

    public static final DeferredHolder<Fluid, com.thevortex.allthemodium.fluid.FluidUNOB.Source> UNOBTAINIUM = FLUIDS.register("molten_unobtainium",
            FluidUNOB.Source::new);
    public static final DeferredHolder<Fluid, com.thevortex.allthemodium.fluid.FluidUNOB.Flowing> FLOWING_UNOBTAINIUM = FLUIDS.register("flowing_molten_unobtainium",
            FluidUNOB.Flowing::new);

}
