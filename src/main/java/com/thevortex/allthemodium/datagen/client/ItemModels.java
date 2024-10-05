package com.thevortex.allthemodium.datagen.client;

import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModels extends ItemModelProvider {

    public ItemModels(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, Reference.MOD_ID, fileHelper);
    }

    private ResourceLocation res(String name) {
        return new ResourceLocation(Reference.MOD_ID, ITEM_FOLDER + "/" + name);
    }

    @Override
    protected void registerModels() {
        ResourceLocation generated = new ResourceLocation("item/generated");
        // ResourceLocation handheld = new ResourceLocation("item/handheld");
        ModRegistry.ITEMS
                .getEntries()
                .stream()
                .filter(item -> !(item.get() instanceof BlockItem))
                .filter(item -> !(item.get() instanceof SwordItem))
                .filter(item -> !(item.get() instanceof PickaxeItem))
                .filter(item -> !(item.get() instanceof ShovelItem))
                .filter(item -> !(item.get() instanceof AxeItem))
                .filter(item -> !(item.get() instanceof HoeItem))
                .forEach(item -> {
                    String name = item.getId().getPath();
                    if (!name.contains("bucket")) {
                        withExistingParent(name, generated)
                                .texture("layer0", res(name));
                    }
                });

        stairs(
                "ancient_wooden_stairs",
                new ResourceLocation(Reference.MOD_ID, "block/ancient_planks"),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_planks"),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_planks"));

        stairs(
                "demonic_wooden_stairs",
                new ResourceLocation(Reference.MOD_ID, "block/demonic_planks"),
                new ResourceLocation(Reference.MOD_ID, "block/demonic_planks"),
                new ResourceLocation(Reference.MOD_ID, "block/demonic_planks"));

        stairs(
                "soul_wooden_stairs",
                new ResourceLocation(Reference.MOD_ID, "block/soul_planks"),
                new ResourceLocation(Reference.MOD_ID, "block/soul_planks"),
                new ResourceLocation(Reference.MOD_ID, "block/soul_planks"));

        stairs(
                "ancient_stone_stairs",
                new ResourceLocation(Reference.MOD_ID, "block/ancient_stone"),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_stone"),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_stone"));

        stairs(
                "ancient_smooth_stone_stairs",
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_smooth_stone"),
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_smooth_stone"),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_smooth_stone"));

        stairs(
                "ancient_polished_stone_stairs",
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_polished_stone"),
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_polished_stone"),
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_polished_stone"));

        stairs(
                "ancient_mossy_stone_stairs",
                new ResourceLocation(Reference.MOD_ID, "block/ancient_mossy_stone"),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_mossy_stone"),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_mossy_stone"));

        stairs(
                "ancient_stone_brick_stairs",
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_stone_bricks"),
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_stone_bricks"),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_stone_bricks"));

        stairs(
                "ancient_chiseled_stone_brick_stairs",
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_chiseled_stone_bricks"),
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_chiseled_stone_bricks"),
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_chiseled_stone_bricks"));

        stairs(
                "ancient_cracked_stone_brick_stairs",
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_cracked_stone_bricks"),
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_cracked_stone_bricks"),
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_cracked_stone_bricks"));

        fenceInventory(
                "ancient_wooden_fence",
                new ResourceLocation(Reference.MOD_ID, "block/ancient_planks"));
        fenceGate(
                "ancient_wooden_fence_gate",
                new ResourceLocation(Reference.MOD_ID, "block/ancient_planks"));

        fenceInventory(
                "demonic_wooden_fence",
                new ResourceLocation(Reference.MOD_ID, "block/demonic_planks"));
        fenceGate(
                "demonic_wooden_fence_gate",
                new ResourceLocation(Reference.MOD_ID, "block/demonic_planks"));

        fenceInventory(
                "soul_wooden_fence",
                new ResourceLocation(Reference.MOD_ID, "block/soul_planks"));
        fenceGate(
                "soul_wooden_fence_gate",
                new ResourceLocation(Reference.MOD_ID, "block/soul_planks"));

        wallInventory(
                "ancient_stone_wall",
                new ResourceLocation(Reference.MOD_ID, "block/ancient_stone"));
        wallInventory(
                "ancient_smooth_stone_wall",
                new ResourceLocation(Reference.MOD_ID, "block/ancient_smooth_stone"));
        wallInventory(
                "ancient_polished_stone_wall",
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_polished_stone"));
        wallInventory(
                "ancient_mossy_stone_wall",
                new ResourceLocation(Reference.MOD_ID, "block/ancient_mossy_stone"));
        wallInventory(
                "ancient_stone_brick_wall",
                new ResourceLocation(Reference.MOD_ID, "block/ancient_stone_bricks"));
        wallInventory(
                "ancient_chiseled_stone_brick_wall",
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_chiseled_stone_bricks"));
        wallInventory(
                "ancient_cracked_stone_brick_wall",
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_cracked_stone_bricks"));

        slab(
                "ancient_wooden_slabs",
                new ResourceLocation(Reference.MOD_ID, "block/ancient_planks"),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_planks"),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_planks"));

        slab(
                "demonic_wooden_slabs",
                new ResourceLocation(Reference.MOD_ID, "block/demonic_planks"),
                new ResourceLocation(Reference.MOD_ID, "block/demonic_planks"),
                new ResourceLocation(Reference.MOD_ID, "block/demonic_planks"));

        slab(
                "soul_wooden_slabs",
                new ResourceLocation(Reference.MOD_ID, "block/soul_planks"),
                new ResourceLocation(Reference.MOD_ID, "block/soul_planks"),
                new ResourceLocation(Reference.MOD_ID, "block/soul_planks"));

        slab(
                "ancient_stone_slabs",
                new ResourceLocation(Reference.MOD_ID, "block/ancient_stone"),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_stone"),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_stone"));

        slab(
                "ancient_smooth_stone_slabs",
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_smooth_stone"),
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_smooth_stone"),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_smooth_stone"));

        slab(
                "ancient_polished_stone_slabs",
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_polished_stone"),
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_polished_stone"),
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_polished_stone"));

        slab(
                "ancient_mossy_stone_slabs",
                new ResourceLocation(Reference.MOD_ID, "block/ancient_mossy_stone"),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_mossy_stone"),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_mossy_stone"));

        slab(
                "ancient_stone_brick_slabs",
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_stone_bricks"),
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_stone_bricks"),
                new ResourceLocation(Reference.MOD_ID, "block/ancient_stone_bricks"));

        slab(
                "ancient_chiseled_stone_brick_slabs",
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_chiseled_stone_bricks"),
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_chiseled_stone_bricks"),
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_chiseled_stone_bricks"));

        slab(
                "ancient_cracked_stone_brick_slabs",
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_cracked_stone_bricks"),
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_cracked_stone_bricks"),
                new ResourceLocation(
                        Reference.MOD_ID,
                        "block/ancient_cracked_stone_bricks"));
        // trapdoorOrientableTop("ancient_trap_door",new
        // ResourceLocation(Reference.MOD_ID,"block/ancient_trap_door"));
    }
}
