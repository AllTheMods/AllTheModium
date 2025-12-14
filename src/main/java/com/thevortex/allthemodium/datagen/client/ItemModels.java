package com.thevortex.allthemodium.datagen.client;

import com.thevortex.allthemodium.registry.ModRegistry;
import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.mek_reg.MekProcReg;
import net.minecraft.client.model.Model;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class ItemModels extends ItemModelProvider {

    public ItemModels(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator.getPackOutput(), Reference.MOD_ID, fileHelper);
    }

    private ResourceLocation res(String name) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, ITEM_FOLDER + "/" + name);
    }

    @Override
    protected void registerModels() {
        ResourceLocation generated = ResourceLocation.withDefaultNamespace("item/generated");
        ResourceLocation mace = ResourceLocation.withDefaultNamespace("item/handheld_mace");
        var manualModels = Set.of("alloy_paxel","alloy_trident","allthemodium_bow","unobtainium_crossbow","vibranium_shield");
        Stream.concat(MekProcReg.ITEMS.getEntries().stream(),ModRegistry.ITEMS.getEntries().stream())
            .filter(item -> !(item.get() instanceof BlockItem))
            .filter(item -> !(item.get() instanceof SwordItem))
            .filter(item -> !(item.get() instanceof PickaxeItem))
            .filter(item -> !(item.get() instanceof ShovelItem))
            .filter(item -> !(item.get() instanceof AxeItem))
            .filter(item -> !(item.get() instanceof HoeItem))
            .forEach(item -> {
                String name = item.getId().getPath();
                if(!name.contains("bucket") && !manualModels.contains(name)) {
                if (item.get() instanceof MaceItem) {
                    withExistingParent(name, mace)
                        .texture("layer0", res(name));
                } else {
                    withExistingParent(name, generated)
                        .texture("layer0", res(name));
                }
            }});

        basicItem(ModRegistry.ATM_SMITHING.get());
        basicItem(ModRegistry.VIB_SMITHING.get());
        basicItem(ModRegistry.UNO_SMITHING.get());
        
        // Saplings
        basicItem(ModRegistry.ANCIENT_SAPLING_Item.get());
        basicItem(ModRegistry.DEMONIC_SAPLING_Item.get());
        basicItem(ModRegistry.SOUL_SAPLING_Item.get());

        cubeAll("ancient_dirt", ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "block/ancient_dirt"));
        cubeAll("piglich_heart_block", ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "block/piglich_heart_block"));
        cubeAll("ancient_smooth_stone", ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "block/ancient_smooth_stone"));
        cubeAll("ancient_stone", ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "block/ancient_stone"));
        cubeAll("ancient_mossy_stone", ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "block/ancient_mossy_stone"));
        cubeAll("ancient_polished_stone", ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "block/ancient_polished_stone"));
        cubeAll("ancient_stone_bricks", ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "block/ancient_stone_bricks"));
        cubeAll("ancient_chiseled_stone_bricks", ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "block/ancient_chiseled_stone_bricks"));
        cubeAll("ancient_cracked_stone_bricks", ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "block/ancient_cracked_stone_bricks"));
        cubeAll("raw_allthemodium_block", ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "block/raw_allthemodium_block"));
        cubeAll("allthemodium_block", ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "block/allthemodium_block"));
        cubeAll("allthemodium_ore", ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "block/allthemodium_ore"));
        cubeAll("allthemodium_slate_ore", ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "block/allthemodium_slate_ore"));
        cubeAll("raw_vibranium_block", ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "block/raw_vibranium_block"));
        cubeAll("vibranium_block", ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "block/vibranium_block"));
        cubeAll("vibranium_ore", ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "block/vibranium_ore"));
        cubeAll("other_vibranium_ore", ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "block/other_vibranium_ore"));
        cubeAll("raw_unobtainium_block", ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "block/raw_unobtainium_block"));
        cubeAll("unobtainium_block", ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "block/unobtainium_block"));
        cubeAll("unobtainium_ore", ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "block/unobtainium_ore"));

        cubeAll("unobtainium_allthemodium_alloy_block", ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "block/unobtainium_allthemodium_alloy_block"));
        cubeAll("unobtainium_vibranium_alloy_block", ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "block/unobtainium_vibranium_alloy_block"));
        cubeAll("vibranium_allthemodium_alloy_block", ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "block/vibranium_allthemodium_alloy_block"));


        stairs("ancient_wooden_stairs",
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_planks"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_planks"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_planks"));

        stairs("demonic_wooden_stairs",
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/demonic_planks"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/demonic_planks"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/demonic_planks"));

        stairs("soul_wooden_stairs",
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/soul_planks"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/soul_planks"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/soul_planks"));

        stairs("ancient_stone_stairs",
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_stone"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_stone"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_stone"));

        stairs("ancient_smooth_stone_stairs",
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_smooth_stone"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_smooth_stone"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_smooth_stone"));

        stairs("ancient_polished_stone_stairs",
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_polished_stone"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_polished_stone"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_polished_stone"));

        stairs("ancient_mossy_stone_stairs",
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_mossy_stone"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_mossy_stone"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_mossy_stone"));

        stairs("ancient_stone_brick_stairs",
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_stone_bricks"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_stone_bricks"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_stone_bricks"));

        stairs("ancient_chiseled_stone_brick_stairs",
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_chiseled_stone_bricks"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_chiseled_stone_bricks"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_chiseled_stone_bricks"));

        stairs("ancient_cracked_stone_brick_stairs",
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_cracked_stone_bricks"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_cracked_stone_bricks"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_cracked_stone_bricks"));

        fenceInventory("ancient_wooden_fence",ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_planks"));
        fenceGate("ancient_wooden_fence_gate",ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_planks"));

        fenceInventory("demonic_wooden_fence",ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/demonic_planks"));
        fenceGate("demonic_wooden_fence_gate",ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/demonic_planks"));

        fenceInventory("soul_wooden_fence",ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/soul_planks"));
        fenceGate("soul_wooden_fence_gate",ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/soul_planks"));


        wallInventory("ancient_stone_wall",ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_stone"));
        wallInventory("ancient_smooth_stone_wall",ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_smooth_stone"));
        wallInventory("ancient_polished_stone_wall",ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_polished_stone"));
        wallInventory("ancient_mossy_stone_wall",ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_mossy_stone"));
        wallInventory("ancient_stone_brick_wall",ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_stone_bricks"));
        wallInventory("ancient_chiseled_stone_brick_wall",ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_chiseled_stone_bricks"));
        wallInventory("ancient_cracked_stone_brick_wall",ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_cracked_stone_bricks"));

        slab("ancient_wooden_slabs",
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_planks"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_planks"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_planks"));

        slab("demonic_wooden_slabs",
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/demonic_planks"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/demonic_planks"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/demonic_planks"));

        slab("soul_wooden_slabs",
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/soul_planks"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/soul_planks"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/soul_planks"));

        slab("ancient_stone_slabs",
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_stone"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_stone"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_stone"));

        slab("ancient_smooth_stone_slabs",
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_smooth_stone"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_smooth_stone"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_smooth_stone"));

        slab("ancient_polished_stone_slabs",
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_polished_stone"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_polished_stone"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_polished_stone"));

        slab("ancient_mossy_stone_slabs",
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_mossy_stone"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_mossy_stone"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_mossy_stone"));

        slab("ancient_stone_brick_slabs",
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_stone_bricks"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_stone_bricks"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_stone_bricks"));

        slab("ancient_chiseled_stone_brick_slabs",
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_chiseled_stone_bricks"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_chiseled_stone_bricks"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_chiseled_stone_bricks"));

        slab("ancient_cracked_stone_brick_slabs",
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_cracked_stone_bricks"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_cracked_stone_bricks"),
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_cracked_stone_bricks"));


        

        //trapdoorOrientableTop("ancient_trap_door",ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"block/ancient_trap_door"));
    }
}
