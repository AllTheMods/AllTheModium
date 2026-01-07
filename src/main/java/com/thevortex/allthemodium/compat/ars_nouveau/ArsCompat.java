package com.thevortex.allthemodium.compat.ars_nouveau;

import com.hollingsworth.arsnouveau.common.items.ModBlockItem;
import com.hollingsworth.arsnouveau.setup.registry.BlockEntityTypeRegistryWrapper;
import com.hollingsworth.arsnouveau.setup.registry.BlockRegistryWrapper;
import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.hollingsworth.arsnouveau.setup.registry.CapabilityRegistry.SOURCE_CAPABILITY;

public class ArsCompat {

    public static final DeferredRegister<Block> ARS_BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK, Reference.MOD_ID);
    public static final DeferredRegister<Item> ARS_ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, Reference.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> ARS_BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Reference.MOD_ID);

    public static BlockRegistryWrapper<AllTheModiumSourceJar> ALLTHEMODIUM_SOURCE_JAR = registerBlockAndItem("allthemodium_source_jar", AllTheModiumSourceJar::new);
    public static BlockEntityTypeRegistryWrapper<AllTheModiumSourceJarTile> ALLTHEMODIUM_SOURCE_JAR_TILE = registerTile("allthemodium_source_jar", AllTheModiumSourceJarTile::new, ALLTHEMODIUM_SOURCE_JAR);

    public static ModBlockItem getDefaultBlockItem(Block block) {
        return new ModBlockItem(block, new Item.Properties().rarity(Rarity.EPIC));
    }

    public static <T extends Block> BlockRegistryWrapper<T> registerBlockAndItem(String name, Supplier<T> blockSupp) {
        BlockRegistryWrapper<T> blockReg = new BlockRegistryWrapper<>(ARS_BLOCKS.register(name, blockSupp));
        ARS_ITEMS.register(name, () -> getDefaultBlockItem(blockReg.get()));
        return blockReg;
    }

    public static <T extends BlockEntity> BlockEntityTypeRegistryWrapper<T> registerTile(String regName, BlockEntityType.BlockEntitySupplier<T> tile, BlockRegistryWrapper<? extends Block> block){
        return new BlockEntityTypeRegistryWrapper<>(ARS_BLOCK_ENTITIES.register(regName, () -> BlockEntityType.Builder.of(tile, block.get()).build(null)));
    }

    public static void registerCapabilities(RegisterCapabilitiesEvent registerCapabilitiesEvent) {
        registerCapabilitiesEvent.registerBlockEntity(SOURCE_CAPABILITY, ALLTHEMODIUM_SOURCE_JAR_TILE.get(), (sourceJar, side) -> sourceJar.getSourceStorage());
    }
}