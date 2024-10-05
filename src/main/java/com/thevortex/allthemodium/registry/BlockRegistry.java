package com.thevortex.allthemodium.registry;

import com.thevortex.allthemodium.blocks.SoulLava;
import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistry {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            Reference.MOD_ID);

    public static final RegistryObject<LiquidBlock> SOULLAVA_BLOCK = BLOCKS.register(
            "soul_lava",
            () -> new SoulLava(
                    FluidRegistry.SOULLAVA,
                    Block.Properties
                            .of(Material.LAVA)
                            .noCollission()
                            .strength(100f)
                            .noOcclusion()
                            .jumpFactor(0.1F)
                            .speedFactor(0.01F)
                            .lightLevel(light -> {
                                return 15;
                            })
                            .color(MaterialColor.COLOR_BLUE)
                            .noLootTable()));

    public static final RegistryObject<LiquidBlock> MOLTEN_ATM_BLOCK = BLOCKS.register(
            "molten_allthemodium_block",
            () -> new LiquidBlock(
                    FluidRegistry.ALLTHEMODIUM,
                    Block.Properties
                            .of(Material.LAVA)
                            .noCollission()
                            .strength(100f)
                            .noLootTable()));
    public static final RegistryObject<LiquidBlock> MOLTEN_VIB_BLOCK = BLOCKS.register(
            "molten_vibranium_block",
            () -> new LiquidBlock(
                    FluidRegistry.VIBRANIUM,
                    Block.Properties
                            .of(Material.LAVA)
                            .noCollission()
                            .strength(100f)
                            .noLootTable()));
    public static final RegistryObject<LiquidBlock> MOLTEN_UNOB_BLOCK = BLOCKS.register(
            "molten_unobtainium_block",
            () -> new LiquidBlock(
                    FluidRegistry.UNOBTAINIUM,
                    Block.Properties
                            .of(Material.LAVA)
                            .noCollission()
                            .strength(100f)
                            .noLootTable()));
}
