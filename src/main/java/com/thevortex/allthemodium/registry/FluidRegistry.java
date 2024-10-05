package com.thevortex.allthemodium.registry;

import com.thevortex.allthemodium.fluid.FluidATM;
import com.thevortex.allthemodium.fluid.FluidSoulLava;
import com.thevortex.allthemodium.fluid.FluidUNOB;
import com.thevortex.allthemodium.fluid.FluidVIB;
import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FluidRegistry {

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS,
            Reference.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOULLAVA = FLUIDS.register(
            "soul_lava",
            FluidSoulLava.Source::new);
    public static final RegistryObject<FlowingFluid> FLOWING_SOULLAVA = FLUIDS.register("flowing_soul_lava",
            FluidSoulLava.Flowing::new);

    public static final RegistryObject<FlowingFluid> ALLTHEMODIUM = FLUIDS.register("molten_allthemodium",
            FluidATM.Source::new);
    public static final RegistryObject<FlowingFluid> FLOWING_ALLTHEMODIUM = FLUIDS
            .register("flowing_molten_allthemodium", FluidATM.Flowing::new);

    public static final RegistryObject<FlowingFluid> VIBRANIUM = FLUIDS.register("molten_vibranium",
            FluidVIB.Source::new);
    public static final RegistryObject<FlowingFluid> FLOWING_VIBRANIUM = FLUIDS.register("flowing_molten_vibranium",
            FluidVIB.Flowing::new);

    public static final RegistryObject<FlowingFluid> UNOBTAINIUM = FLUIDS.register("molten_unobtainium",
            FluidUNOB.Source::new);
    public static final RegistryObject<FlowingFluid> FLOWING_UNOBTAINIUM = FLUIDS.register("flowing_molten_unobtainium",
            FluidUNOB.Flowing::new);
}
