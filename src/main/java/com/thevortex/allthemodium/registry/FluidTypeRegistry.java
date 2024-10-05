package com.thevortex.allthemodium.registry;

import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.resource.MoltenATMType;
import com.thevortex.allthemodium.registry.resource.MoltenUNOBType;
import com.thevortex.allthemodium.registry.resource.MoltenVIBType;
import com.thevortex.allthemodium.registry.resource.SoulLavaType;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FluidTypeRegistry {

    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(
            ForgeRegistries.Keys.FLUID_TYPES,
            Reference.MOD_ID);

    public static final RegistryObject<FluidType> SOULLAVA = FLUID_TYPES.register(
            "soul_lava",
            () -> new SoulLavaType(
                    FluidType.Properties
                            .create()
                            .descriptionId(
                                    "block." + Reference.MOD_ID + ".soul_lava")
                            .fallDistanceModifier(0F)
                            .canExtinguish(false)
                            .supportsBoating(true)
                            .sound(
                                    SoundActions.BUCKET_FILL,
                                    SoundEvents.BUCKET_FILL)
                            .sound(
                                    SoundActions.BUCKET_EMPTY,
                                    SoundEvents.BUCKET_EMPTY)
                            .sound(
                                    SoundActions.FLUID_VAPORIZE,
                                    SoundEvents.FIRE_EXTINGUISH)
                            .canHydrate(false)));

    public static final RegistryObject<FluidType> ATM = FLUID_TYPES.register(
            "molten_atm",
            () -> new MoltenATMType(
                    FluidType.Properties
                            .create()
                            .descriptionId(
                                    "block." + Reference.MOD_ID + ".molten_allthemodium")
                            .fallDistanceModifier(0F)
                            .canExtinguish(false)
                            .supportsBoating(true)
                            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                            .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                            .sound(
                                    SoundActions.FLUID_VAPORIZE,
                                    SoundEvents.FIRE_EXTINGUISH)
                            .canHydrate(false)));

    public static final RegistryObject<FluidType> VIB = FLUID_TYPES.register(
            "molten_vibranium",
            () -> new MoltenVIBType(
                    FluidType.Properties
                            .create()
                            .descriptionId(
                                    "block." + Reference.MOD_ID + ".molten_vibranium")
                            .fallDistanceModifier(0F)
                            .canExtinguish(false)
                            .supportsBoating(true)
                            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                            .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                            .sound(
                                    SoundActions.FLUID_VAPORIZE,
                                    SoundEvents.FIRE_EXTINGUISH)
                            .canHydrate(false)));

    public static final RegistryObject<FluidType> UNOB = FLUID_TYPES.register(
            "molten_unobtainium",
            () -> new MoltenUNOBType(
                    FluidType.Properties
                            .create()
                            .descriptionId(
                                    "block." + Reference.MOD_ID + ".molten_unobtainium")
                            .fallDistanceModifier(0F)
                            .canExtinguish(false)
                            .supportsBoating(true)
                            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                            .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                            .sound(
                                    SoundActions.FLUID_VAPORIZE,
                                    SoundEvents.FIRE_EXTINGUISH)
                            .canHydrate(false)));
}
