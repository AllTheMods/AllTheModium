package net.allthemods.allthemodium.client.render;

import net.minecraft.client.renderer.block.FluidModel;
import net.minecraft.client.resources.model.sprite.Material;

import net.allthemods.allthemodium.api.ATM;

public class ATMFluidModels {
    
    public static final FluidModel.Unbaked SOUL_LAVA_MODEL = new FluidModel.Unbaked(
            new Material(ATM.id("block/soul_lava_still")),
            new Material(ATM.id("block/soul_lava_flow")),
            null,
            null
    );
    
    public static final FluidModel.Unbaked MOLTEN_ALLTHEMODIUM_MODEL = new FluidModel.Unbaked(
            new Material(ATM.id("block/molten_allthemodium_still")),
            new Material(ATM.id("block/molten_allthemodium_flow")),
            null,
            null
    );
    
    public static final FluidModel.Unbaked MOLTEN_VIBRANIUM_MODEL = new FluidModel.Unbaked(
            new Material(ATM.id("block/molten_vibranium_still")),
            new Material(ATM.id("block/molten_vibranium_flow")),
            null,
            null
    );
    
    public static final FluidModel.Unbaked MOLTEN_UNOBTAINIUM_MODEL = new FluidModel.Unbaked(
            new Material(ATM.id("block/molten_unobtainium_still")),
            new Material(ATM.id("block/molten_unobtainium_flow")),
            null,
            null
    );
}
