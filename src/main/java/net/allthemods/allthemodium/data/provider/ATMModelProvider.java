package net.allthemods.allthemodium.data.provider;

import net.neoforged.neoforge.client.model.item.DynamicFluidContainerModel;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.client.renderer.item.SelectItemModel;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MaceItem;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.core.registry.ATMArmorMaterials;
import net.allthemods.allthemodium.core.registry.ATMBlockFamilies;
import net.allthemods.allthemodium.core.registry.ATMBlocks;
import net.allthemods.allthemodium.core.registry.ATMFluids;
import net.allthemods.allthemodium.core.registry.ATMItems;
import net.allthemods.allthemodium.core.registry.ATMTrimMaterials;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class ATMModelProvider extends ModelProvider {
    
    public ATMModelProvider(PackOutput output) {
        super(output, ATM.MOD_ID);
    }
    
    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        this.generateFamilies(blockModels);
        this.generateStandaloneBlocks(blockModels);
        this.generateStandaloneItems(itemModels);
        this.generateArmors(itemModels);
        this.generateBuckets(itemModels);
    }
    
    private void generateFamilies(BlockModelGenerators blockModels) {
        blockModels.family(ATMBlocks.ANCIENT_PLANKS.get()).generateFor(ATMBlockFamilies.ANCIENT_PLANKS);
        blockModels.family(ATMBlocks.ANCIENT_STONE.get()).generateFor(ATMBlockFamilies.ANCIENT_STONE);
        blockModels.family(ATMBlocks.SMOOTH_ANCIENT_STONE.get()).generateFor(ATMBlockFamilies.SMOOTH_ANCIENT_STONE);
        blockModels.family(ATMBlocks.MOSSY_ANCIENT_STONE.get()).generateFor(ATMBlockFamilies.MOSSY_ANCIENT_STONE);
        
        blockModels.family(ATMBlocks.ANCIENT_STONE_BRICKS.get())
                .wall(ATMBlocks.ANCIENT_STONE_BRICK_WALL.get())
                .stairs(ATMBlocks.ANCIENT_STONE_BRICK_STAIRS.get())
                .slab(ATMBlocks.ANCIENT_STONE_BRICK_SLAB.get());
        
        blockModels.family(ATMBlocks.CHISELED_ANCIENT_STONE_BRICKS.get()).generateFor(ATMBlockFamilies.CHISELED_ANCIENT_STONE_BRICKS);
        blockModels.family(ATMBlocks.CRACKED_ANCIENT_STONE_BRICKS.get()).generateFor(ATMBlockFamilies.CRACKED_ANCIENT_STONE_BRICKS);
        blockModels.family(ATMBlocks.POLISHED_ANCIENT_STONE.get()).generateFor(ATMBlockFamilies.POLISHED_ANCIENT_STONE);
        blockModels.family(ATMBlocks.SOUL_PLANKS.get()).generateFor(ATMBlockFamilies.SOUL_PLANKS);
        blockModels.family(ATMBlocks.DEMONIC_PLANKS.get()).generateFor(ATMBlockFamilies.DEMONIC_PLANKS);
    }
    
    private void generateStandaloneBlocks(BlockModelGenerators blockModels) {
        for (var block : List.of(
                ATMBlocks.ALLTHEMODIUM_ORE.get(),
                ATMBlocks.DEEPSLATE_ALLTHEMODIUM_ORE.get(),
                ATMBlocks.VIBRANIUM_ORE.get(),
                ATMBlocks.OTHER_VIBRANIUM_ORE.get(),
                ATMBlocks.UNOBTAINIUM_ORE.get(),
                ATMBlocks.RAW_ALLTHEMODIUM_BLOCK.get(),
                ATMBlocks.RAW_VIBRANIUM_BLOCK.get(),
                ATMBlocks.RAW_UNOBTAINIUM_BLOCK.get(),
                ATMBlocks.ALLTHEMODIUM_BLOCK.get(),
                ATMBlocks.VIBRANIUM_BLOCK.get(),
                ATMBlocks.UNOBTAINIUM_BLOCK.get(),
                ATMBlocks.UNOBTAINIUM_ALLTHEMODIUM_BLOCK.get(),
                ATMBlocks.UNOBTAINIUM_VIBRANIUM_BLOCK.get(),
                ATMBlocks.VIBRANIUM_ALLTHEMODIUM_BLOCK.get(),
                ATMBlocks.PIGLICH_HEART_BLOCK.get(),
                ATMBlocks.ANCIENT_DIRT.get()
        )) {
            blockModels.createTrivialCube(block);
        }
        
        blockModels.createTrivialBlock(
                ATMBlocks.ANCIENT_GRASS.get(),
                TexturedModel.CUBE_TOP_BOTTOM.updateTexture(mapping -> mapping.put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(ATMBlocks.ANCIENT_DIRT.get())))
        );
        
        for (var block : List.of(ATMBlocks.ANCIENT_LEAVES.get(), ATMBlocks.SOUL_LEAVES.get(), ATMBlocks.DEMONIC_LEAVES.get())) {
            blockModels.createTrivialBlock(block, TexturedModel.LEAVES);
        }
        
        this.generateAncientCaveVines(blockModels);
        
        this.createBookshelf(blockModels, ATMBlocks.ANCIENT_BOOKSHELF.get());
        this.createBookshelf(blockModels, ATMBlocks.SOUL_BOOKSHELF.get());
        this.createBookshelf(blockModels, ATMBlocks.DEMONIC_BOOKSHELF.get());
        
        for (var block : List.of(
                ATMBlocks.ANCIENT_LOG_0.get(),
                ATMBlocks.ANCIENT_LOG_1.get(),
                ATMBlocks.ANCIENT_LOG_2.get(),
                ATMBlocks.STRIPPED_ANCIENT_LOG.get(),
                ATMBlocks.SOUL_LOG_0.get(),
                ATMBlocks.SOUL_LOG_1.get(),
                ATMBlocks.SOUL_LOG_2.get(),
                ATMBlocks.STRIPPED_SOUL_LOG.get(),
                ATMBlocks.DEMONIC_LOG.get(),
                ATMBlocks.STRIPPED_DEMONIC_LOG.get()
        )) {
            blockModels.createAxisAlignedPillarBlock(block, TexturedModel.COLUMN_ALT);
        }
        
        for (var block : List.of(
                ATMBlocks.ANCIENT_SAPLING.get(),
                ATMBlocks.ANCIENT_HERB.get(),
                ATMBlocks.ANCIENT_LEAVES_BOTTOM.get(),
                ATMBlocks.SOUL_SAPLING.get(),
                ATMBlocks.SOUL_HERB.get(),
                ATMBlocks.SOUL_LEAVES_BOTTOM.get(),
                ATMBlocks.DEMONIC_SAPLING.get(),
                ATMBlocks.DEMONIC_HERB.get(),
                ATMBlocks.DEMONIC_LEAVES_BOTTOM.get()
        )) {
            blockModels.createCrossBlockWithDefaultItem(block, BlockModelGenerators.PlantType.NOT_TINTED);
        }
        
        blockModels.createBrushableBlock(ATMBlocks.SUS_CLAY.get());
        blockModels.createBrushableBlock(ATMBlocks.SUS_SOUL_SAND.get());
        
        blockModels.createNonTemplateModelBlock(ATMBlocks.TELEPORT_PAD.get());
        
        ATMFluids.BLOCKS.getEntries().stream().map(DeferredHolder::get).forEach(blockModels::createNonTemplateModelBlock);
    }
    
    private void createBookshelf(BlockModelGenerators blockModels, Block block) {
        blockModels.createTrivialBlock(
                block,
                TexturedModel.COLUMN.updateTexture(mapping -> {
                    mapping.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block));
                    mapping.put(TextureSlot.END, TextureMapping.getBlockTexture(block, "_top"));
                })
        );
    }
    
    private void generateAncientCaveVines(BlockModelGenerators blockModels) {
        MultiVariant offHead = BlockModelGenerators.plainVariant(blockModels.createSuffixedVariant(ATMBlocks.ANCIENT_CAVE_VINES.get(), "", ModelTemplates.CROSS, TextureMapping::cross));
        MultiVariant onHead = BlockModelGenerators.plainVariant(blockModels.createSuffixedVariant(ATMBlocks.ANCIENT_CAVE_VINES.get(), "_lit", ModelTemplates.CROSS, TextureMapping::cross));
        blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(ATMBlocks.ANCIENT_CAVE_VINES.get()).with(BlockModelGenerators.createBooleanModelDispatch(BlockStateProperties.BERRIES, onHead, offHead)));
        MultiVariant offBody = BlockModelGenerators.plainVariant(blockModels.createSuffixedVariant(ATMBlocks.ANCIENT_CAVE_VINES_PLANT.get(), "", ModelTemplates.CROSS, TextureMapping::cross));
        MultiVariant onBody = BlockModelGenerators.plainVariant(blockModels.createSuffixedVariant(ATMBlocks.ANCIENT_CAVE_VINES_PLANT.get(), "_lit", ModelTemplates.CROSS, TextureMapping::cross));
        blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(ATMBlocks.ANCIENT_CAVE_VINES_PLANT.get()).with(BlockModelGenerators.createBooleanModelDispatch(BlockStateProperties.BERRIES, onBody, offBody)));
    }
    
    private void generateStandaloneItems(ItemModelGenerators itemModels) {
        for (DeferredHolder<Item, ?> holder : ATMItems.ITEMS.getEntries()) {
            Item item = holder.get();
            String path = holder.getKey().identifier().getPath();
            if (ATMModelProvider.isArmorItem(path)) continue;
            
            if (item instanceof BowItem) {
                itemModels.createFlatItemModel(item, ModelTemplates.BOW);
                itemModels.generateBow(item);
            } else if (item instanceof CrossbowItem) {
                itemModels.createFlatItemModel(item, ModelTemplates.CROSSBOW);
                itemModels.generateCrossbow(item);
            } else if (item instanceof ShieldItem) {
                itemModels.itemModelOutput.accept(
                        item,
                        ItemModelUtils.conditional(
                                ItemModelUtils.isUsingItem(),
                                ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(item, "_blocking")),
                                ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(item))
                        )
                );
            } else if (item instanceof TridentItem) {
                Identifier flatModel = ModelTemplates.FLAT_ITEM.create(
                        ModelLocationUtils.getModelLocation(item, "_inventory"),
                        TextureMapping.layer0(item),
                        itemModels.modelOutput
                );
                itemModels.itemModelOutput.accept(
                        item,
                        ItemModelGenerators.createFlatModelDispatch(
                                ItemModelUtils.plainModel(flatModel),
                                ItemModelUtils.conditional(
                                        ItemModelUtils.isUsingItem(),
                                        ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(item, "_throwing")),
                                        ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(item, "_in_hand"))
                                )
                        )
                );
            } else if (item instanceof AxeItem || item instanceof HoeItem || item instanceof ShovelItem || path.endsWith("_sword") || path.endsWith("_pickaxe") || path.endsWith("_paxel")) {
                itemModels.generateFlatItem(item, ModelTemplates.FLAT_HANDHELD_ITEM);
            } else if (item instanceof MaceItem || path.endsWith("_mace")) {
                itemModels.generateFlatItem(item, ModelTemplates.FLAT_HANDHELD_MACE_ITEM);
            } else {
                itemModels.generateFlatItem(item, ModelTemplates.FLAT_ITEM);
            }
        }
    }
    
    private static boolean isArmorItem(String path) {
        return path.endsWith("_helmet") || path.endsWith("_chestplate") || path.endsWith("_leggings") || path.endsWith("_boots");
    }
    
    private void generateArmors(ItemModelGenerators itemModels) {
        this.generateTrimmableItem(itemModels, ATMItems.ALLTHEMODIUM_HELMET.get(), ATMArmorMaterials.ALLTHEMODIUM_ASSET, ItemModelGenerators.TRIM_PREFIX_HELMET);
        this.generateTrimmableItem(itemModels, ATMItems.ALLTHEMODIUM_CHESTPLATE.get(), ATMArmorMaterials.ALLTHEMODIUM_ASSET, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE);
        this.generateTrimmableItem(itemModels, ATMItems.ALLTHEMODIUM_LEGGINGS.get(), ATMArmorMaterials.ALLTHEMODIUM_ASSET, ItemModelGenerators.TRIM_PREFIX_LEGGINGS);
        this.generateTrimmableItem(itemModels, ATMItems.ALLTHEMODIUM_BOOTS.get(), ATMArmorMaterials.ALLTHEMODIUM_ASSET, ItemModelGenerators.TRIM_PREFIX_BOOTS);
        
        this.generateTrimmableItem(itemModels, ATMItems.VIBRANIUM_HELMET.get(), ATMArmorMaterials.VIBRANIUM_ASSET, ItemModelGenerators.TRIM_PREFIX_HELMET);
        this.generateTrimmableItem(itemModels, ATMItems.VIBRANIUM_CHESTPLATE.get(), ATMArmorMaterials.VIBRANIUM_ASSET, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE);
        this.generateTrimmableItem(itemModels, ATMItems.VIBRANIUM_LEGGINGS.get(), ATMArmorMaterials.VIBRANIUM_ASSET, ItemModelGenerators.TRIM_PREFIX_LEGGINGS);
        this.generateTrimmableItem(itemModels, ATMItems.VIBRANIUM_BOOTS.get(), ATMArmorMaterials.VIBRANIUM_ASSET, ItemModelGenerators.TRIM_PREFIX_BOOTS);
        
        this.generateTrimmableItem(itemModels, ATMItems.UNOBTAINIUM_HELMET.get(), ATMArmorMaterials.UNOBTAINIUM_ASSET, ItemModelGenerators.TRIM_PREFIX_HELMET);
        this.generateTrimmableItem(itemModels, ATMItems.UNOBTAINIUM_CHESTPLATE.get(), ATMArmorMaterials.UNOBTAINIUM_ASSET, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE);
        this.generateTrimmableItem(itemModels, ATMItems.UNOBTAINIUM_LEGGINGS.get(), ATMArmorMaterials.UNOBTAINIUM_ASSET, ItemModelGenerators.TRIM_PREFIX_LEGGINGS);
        this.generateTrimmableItem(itemModels, ATMItems.UNOBTAINIUM_BOOTS.get(), ATMArmorMaterials.UNOBTAINIUM_ASSET, ItemModelGenerators.TRIM_PREFIX_BOOTS);
    }
    
    private void generateTrimmableItem(ItemModelGenerators itemModels, Item armor, ResourceKey<EquipmentAsset> equipmentAssetId, Identifier slotTrimPrefix) {
        Identifier modelLocation = ModelLocationUtils.getModelLocation(armor);
        Material itemTexture = TextureMapping.getItemTexture(armor);
        List<SelectItemModel.SwitchCase<ResourceKey<TrimMaterial>>> cases = new ArrayList<>();
        
        for (ItemModelGenerators.TrimMaterialData material : ATMModelProvider.trimMaterialModels()) {
            Identifier trimModelLocation = modelLocation.withSuffix("_" + material.assets().base().suffix() + "_trim");
            Material trimOverlayTexture = new Material(slotTrimPrefix.withSuffix("_" + material.assets().assetId(equipmentAssetId).suffix()));
            itemModels.generateLayeredItem(trimModelLocation, itemTexture, trimOverlayTexture);
            cases.add(ItemModelUtils.when(material.materialKey(), ItemModelUtils.plainModel(trimModelLocation)));
        }
        
        ModelTemplates.FLAT_ITEM.create(modelLocation, TextureMapping.layer0(itemTexture), itemModels.modelOutput);
        itemModels.itemModelOutput.accept(armor, ItemModelUtils.select(new net.minecraft.client.renderer.item.properties.select.TrimMaterialProperty(), ItemModelUtils.plainModel(modelLocation), cases));
    }
    
    private static List<ItemModelGenerators.TrimMaterialData> trimMaterialModels() {
        List<ItemModelGenerators.TrimMaterialData> materials = new ArrayList<>(ItemModelGenerators.TRIM_MATERIAL_MODELS);
        materials.add(new ItemModelGenerators.TrimMaterialData(ATMTrimMaterials.ALLTHEMODIUM_ASSETS, ATMTrimMaterials.ALLTHEMODIUM));
        materials.add(new ItemModelGenerators.TrimMaterialData(ATMTrimMaterials.VIBRANIUM_ASSETS, ATMTrimMaterials.VIBRANIUM));
        materials.add(new ItemModelGenerators.TrimMaterialData(ATMTrimMaterials.UNOBTAINIUM_ASSETS, ATMTrimMaterials.UNOBTAINIUM));
        return materials;
    }
    
    private void generateBuckets(ItemModelGenerators itemModels) {
        this.createBucket(itemModels, ATMFluids.SOUL_LAVA_BUCKET, ATMFluids.SOUL_LAVA);
        this.createBucket(itemModels, ATMFluids.MOLTEN_ALLTHEMODIUM_BUCKET, ATMFluids.MOLTEN_ALLTHEMODIUM);
        this.createBucket(itemModels, ATMFluids.MOLTEN_VIBRANIUM_BUCKET, ATMFluids.MOLTEN_VIBRANIUM);
        this.createBucket(itemModels, ATMFluids.MOLTEN_UNOBTAINIUM_BUCKET, ATMFluids.MOLTEN_UNOBTAINIUM);
    }
    
    private void createBucket(ItemModelGenerators itemModels, DeferredHolder<Item, ? extends BucketItem> bucket, DeferredHolder<Fluid, ? extends FlowingFluid> fluid) {
        itemModels.itemModelOutput.accept(
                bucket.get(),
                new DynamicFluidContainerModel.Unbaked(
                        new DynamicFluidContainerModel.Textures(
                                Optional.of(new Material(Identifier.withDefaultNamespace("item/bucket"), false)),
                                Optional.of(new Material(Identifier.withDefaultNamespace("item/bucket"), false)),
                                Optional.of(new Material(Identifier.fromNamespaceAndPath("neoforge", "item/mask/bucket_fluid"), false)),
                                Optional.empty()
                        ),
                        fluid.get(),
                        false,
                        true,
                        true
                )
        );
    }
}
