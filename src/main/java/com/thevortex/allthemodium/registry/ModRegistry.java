package com.thevortex.allthemodium.registry;

import com.google.common.collect.ImmutableSet;
import com.thevortex.allthemodium.blocks.*;
import com.thevortex.allthemodium.blocks.entity.ATMBrushableBlockEntity;
import com.thevortex.allthemodium.entity.PiglichEntity;
import com.thevortex.allthemodium.init.ModFoods;
import com.thevortex.allthemodium.entity.ThrownTrident;
import com.thevortex.allthemodium.items.*;
import com.thevortex.allthemodium.items.toolitems.armor.*;
import com.thevortex.allthemodium.items.toolitems.tools.*;
import com.thevortex.allthemodium.material.ATMTier;
import com.thevortex.allthemodium.material.ToolTiers;
import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.worldgen.feature.BottomBranchDecorator;
import com.thevortex.allthemodium.worldgen.structures.APStructure;
import com.thevortex.allthemodium.worldgen.structures.DungeonStructure;
import com.thevortex.allthemodium.worldgen.structures.PVStructure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Supplier;

@EventBusSubscriber(modid = Reference.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModRegistry
{
    public static final DeferredRegister<Block> SHAPED_BLOCKS = DeferredRegister.createBlocks(Reference.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.createBlocks(Reference.MOD_ID);
    public static final DeferredRegister<Block> STAIRBLOCKS = DeferredRegister.createBlocks(Reference.MOD_ID);
    public static final DeferredRegister<Block> WALLBLOCKS = DeferredRegister.createBlocks(Reference.MOD_ID);
    public static final DeferredRegister<Block> SLABBLOCKS = DeferredRegister.createBlocks(Reference.MOD_ID);
    public static final DeferredRegister<Block> PILLARBLOCKS = DeferredRegister.createBlocks(Reference.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(Reference.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, Reference.MOD_ID);
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(Registries.BIOME, Reference.MOD_ID);
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(Registries.POINT_OF_INTEREST_TYPE, Reference.MOD_ID);
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, Reference.MOD_ID);
    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS = DeferredRegister.create(Registries.TREE_DECORATOR_TYPE, Reference.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> ENTITY = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Reference.MOD_ID);
    public static final DeferredRegister<WorldCarver<?>> CARVERS = DeferredRegister.create(Registries.CARVER, Reference.MOD_ID);
    public static final DeferredRegister<StructureType<?>> STRUCTURES = DeferredRegister.create(Registries.STRUCTURE_TYPE, Reference.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Reference.MOD_ID);


    // BIOMES
    public static final DeferredHolder<Biome, Biome> MINING = BIOMES.register("mining", ATMBiomes::mining);

    // POI TYPES
    public static final DeferredHolder<PoiType, PoiType> TELEPORT_PAD_POI = POI_TYPES.register("teleport_pad",
            () -> new PoiType(ImmutableSet.copyOf(ModRegistry.TELEPORT_PAD.get().getStateDefinition().getPossibleStates()), 1, 1)
    );

    // FOOD
    public static final DeferredHolder<Item, Item> ALLTHEMODIUM_APPLE = registerItem("allthemodium_apple", () -> new Allthemodium_Apple(new Item.Properties().fireResistant().food(ModFoods.ALLTHEMODIUM_APPLE).rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> ALLTHEMODIUM_CARROT = registerItem("allthemodium_carrot", () -> new Allthemodium_Carrot(new Item.Properties().fireResistant().food(ModFoods.ALLTHEMODIUM_CARROT).rarity(Rarity.EPIC)));

    // ARMORS
    public static final DeferredHolder<Item, Item> ALLTHEMODIUM_HELMET = registerItem("allthemodium_helmet", () -> new Allthemodium_Helmet(ArmorRegistries.ATM, EquipmentSlot.HEAD, new Item.Properties().fireResistant().rarity(Rarity.EPIC).stacksTo(1)));
    public static final DeferredHolder<Item, Item> ALLTHEMODIUM_CHESTPLATE = registerItem("allthemodium_chestplate", () -> new Allthemodium_Chestplate(ArmorRegistries.ATM, EquipmentSlot.CHEST, new Item.Properties().fireResistant().rarity(Rarity.EPIC).stacksTo(1)));
    public static final DeferredHolder<Item, Item> ALLTHEMODIUM_LEGGINGS = registerItem("allthemodium_leggings", () -> new Allthemodium_Leggings(ArmorRegistries.ATM, EquipmentSlot.LEGS, new Item.Properties().fireResistant().rarity(Rarity.EPIC).stacksTo(1)));
    public static final DeferredHolder<Item, Item> ALLTHEMODIUM_BOOTS = registerItem("allthemodium_boots", () -> new Allthemodium_Boots(ArmorRegistries.ATM, EquipmentSlot.FEET, new Item.Properties().fireResistant().rarity(Rarity.EPIC).stacksTo(1)));

    public static final DeferredHolder<Item, Item> VIBRANIUM_HELMET = registerItem("vibranium_helmet", () -> new Allthemodium_Helmet(ArmorRegistries.VIB, EquipmentSlot.HEAD, new Item.Properties().fireResistant().rarity(Rarity.EPIC).stacksTo(1)));
    public static final DeferredHolder<Item, Item> VIBRANIUM_CHESTPLATE = registerItem("vibranium_chestplate", () -> new Allthemodium_Chestplate(ArmorRegistries.VIB, EquipmentSlot.CHEST, new Item.Properties().fireResistant().rarity(Rarity.EPIC).stacksTo(1)));
    public static final DeferredHolder<Item, Item> VIBRANIUM_LEGGINGS = registerItem("vibranium_leggings", () -> new Allthemodium_Leggings(ArmorRegistries.VIB, EquipmentSlot.LEGS, new Item.Properties().fireResistant().rarity(Rarity.EPIC).stacksTo(1)));
    public static final DeferredHolder<Item, Item> VIBRANIUM_BOOTS = registerItem("vibranium_boots", () -> new Allthemodium_Boots(ArmorRegistries.VIB, EquipmentSlot.FEET, new Item.Properties().fireResistant().rarity(Rarity.EPIC).stacksTo(1)));

    public static final DeferredHolder<Item, Item> UNOBTAINIUM_HELMET = registerItem("unobtainium_helmet", () -> new Allthemodium_Helmet(ArmorRegistries.UNOB, EquipmentSlot.HEAD, new Item.Properties().fireResistant().rarity(Rarity.EPIC).stacksTo(1)));
    public static final DeferredHolder<Item, Item> UNOBTAINIUM_CHESTPLATE = registerItem("unobtainium_chestplate", () -> new Allthemodium_Chestplate(ArmorRegistries.UNOB, EquipmentSlot.CHEST, new Item.Properties().fireResistant().rarity(Rarity.EPIC).stacksTo(1)));
    public static final DeferredHolder<Item, Item> UNOBTAINIUM_LEGGINGS = registerItem("unobtainium_leggings", () -> new Allthemodium_Leggings(ArmorRegistries.UNOB, EquipmentSlot.LEGS, new Item.Properties().fireResistant().rarity(Rarity.EPIC).stacksTo(1)));
    public static final DeferredHolder<Item, Item> UNOBTAINIUM_BOOTS = registerItem("unobtainium_boots", () -> new Allthemodium_Boots(ArmorRegistries.UNOB, EquipmentSlot.FEET, new Item.Properties().fireResistant().rarity(Rarity.EPIC).stacksTo(1)));

    // Worldgen
    public static final DeferredHolder<TreeDecoratorType<?>, TreeDecoratorType<BottomBranchDecorator>> BOTTOM_BRANCH_DECORATOR = TREE_DECORATORS.register("bottom_branch", () -> new TreeDecoratorType<>(BottomBranchDecorator.CODEC));

    public static final DeferredHolder<StructureType<?>, StructureType<APStructure>> ANCIENT_PYRAMID = STRUCTURES.register("ancient_pyramid", () -> () -> APStructure.CODEC);
    public static final DeferredHolder<StructureType<?>, StructureType<PVStructure>> PIGLIN_VILLAGE = STRUCTURES.register("piglin_village", () -> () -> PVStructure.CODEC);
    public static final DeferredHolder<StructureType<?>, StructureType<DungeonStructure>> ANCIENT_DUNGEON = STRUCTURES.register("dungeon", () -> () -> DungeonStructure.CODEC);


    // Block entities
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ATMBrushableBlockEntity>> BRUSHABLE_BLOCK = ENTITY.register("brushable_block", () ->
            BlockEntityType.Builder.of(ATMBrushableBlockEntity::new,
                    ModRegistry.SUS_CLAY.get(),
                    ModRegistry.SUS_SOUL_SAND.get()
            ).build(null)
    );

    public static final DeferredHolder<Block, Block> ANCIENT_CAVEVINES = registerBlock(PILLARBLOCKS, "ancient_cavevines", () -> new AncientCaveVines(BlockBehaviour.Properties.of()
            .randomTicks()
            .noCollission()
            .noOcclusion()
            .lightLevel(ACaveVines.emission(14))
            .instabreak()
            .sound(SoundType.CAVE_VINES)
            , Direction.DOWN
            , ACaveVines.SHAPE
            , false
            , 0.1D), false);

    public static final DeferredHolder<Block, Block> ANCIENT_CAVEVINES_PLANT = registerBlock(PILLARBLOCKS, "ancient_cavevines_plant", () -> new AncientCaveVinesPlant(BlockBehaviour.Properties.of()
            .noCollission()
            .noOcclusion()
            .lightLevel(ACaveVines.emission(14))
            .instabreak()
            .sound(SoundType.CAVE_VINES)
            , Direction.DOWN
            , ACaveVines.SHAPE
            , false), false);

    public static final DeferredHolder<Item, BlockItem> ANCIENT_SOULBERRY = ITEMS.register("ancient_soulberries", () -> new SoulBerries(ANCIENT_CAVEVINES.get(), (new Item.Properties()).food(ModFoods.SOUL_BERRIES)));

    public static final DeferredHolder<Block, Block> ANCIENT_FERN = registerBlock("ancient_fern", () -> new TallGrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FERN)));

    public static final DeferredHolder<Block, Block> PIGLICH_HEART_BLOCK = registerBlock("piglich_heart_block", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.AMETHYST)));

    public static final DeferredHolder<Block, Block> ANCIENT_HERB = registerBlock(PILLARBLOCKS, "ancient_herb", () -> new AncientHerb(BlockBehaviour.Properties.of().sound(SoundType.WET_GRASS).instabreak().noCollission()));
    public static final DeferredHolder<Block, Block> DEMONIC_HERB = registerBlock(PILLARBLOCKS, "demonic_herb", () -> new AncientHerb(BlockBehaviour.Properties.of().sound(SoundType.WET_GRASS).instabreak().noCollission()));
    public static final DeferredHolder<Block, Block> SOUL_HERB = registerBlock(PILLARBLOCKS, "soul_herb", () -> new AncientHerb(BlockBehaviour.Properties.of().sound(SoundType.WET_GRASS).instabreak().noCollission()));

    public static final DeferredHolder<Block, Block> ANCIENT_SMOOTH_STONE = registerBlock("ancient_smooth_stone", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).isRedstoneConductor((BlockState state, BlockGetter level, BlockPos pos) -> false).strength(2.25f)));
    public static final DeferredHolder<Block, Block> ANCIENT_STONE = registerBlock("ancient_stone", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).isRedstoneConductor((BlockState state, BlockGetter level, BlockPos pos) -> false).strength(1.5f)));
    public static final DeferredHolder<Block, Block> ANCIENT_DIRT = registerBlock("ancient_dirt", () -> new AncientDirt(BlockBehaviour.Properties.of().sound(SoundType.WET_GRASS).strength(0.6f)));
    public static final DeferredHolder<Block, Block> ANCIENT_GRASS = registerBlock("ancient_grass", () -> new Ancient_Grass(BlockBehaviour.Properties.of().sound(SoundType.MOSS).strength(0.6f)));
    public static final DeferredHolder<Block, Block> ANCIENT_PODZOL = registerBlock("ancient_podzol", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PODZOL)));
    public static final DeferredHolder<Block, Block> ANCIENT_MOSSY_STONE = registerBlock("ancient_mossy_stone", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.MOSS_CARPET).isRedstoneConductor((BlockState state, BlockGetter level, BlockPos pos) -> false).strength(1.5f)));
    public static final DeferredHolder<Block, Block> ANCIENT_STONE_BRICKS = registerBlock("ancient_stone_bricks", AncientStone::new);
    public static final DeferredHolder<Block, Block> ANCIENT_CHISELED_STONE_BRICKS = registerBlock("ancient_chiseled_stone_bricks", AncientStone::new);
    public static final DeferredHolder<Block, Block> ANCIENT_CRACKED_STONE_BRICKS = registerBlock("ancient_cracked_stone_bricks", AncientStone::new);
    public static final DeferredHolder<Block, Block> ANCIENT_POLISHED_STONE = registerBlock("ancient_polished_stone", AncientStone::new);

    public static final DeferredHolder<Block, Block> ANCIENT_LOG_0 = registerBlock(PILLARBLOCKS, "ancient_log_0", () -> log(DyeColor.BLUE, DyeColor.BLUE));
    public static final DeferredHolder<Block, Block> ANCIENT_LOG_1 = registerBlock(PILLARBLOCKS, "ancient_log_1", () -> log(DyeColor.BLUE, DyeColor.BLUE));
    public static final DeferredHolder<Block, Block> ANCIENT_LOG_2 = registerBlock(PILLARBLOCKS, "ancient_log_2", () -> log(DyeColor.BLUE, DyeColor.BLUE));
    public static final DeferredHolder<Block, Block> ANCIENT_LOG_STRIPPED = registerBlock(PILLARBLOCKS, "stripped_ancient_log", () -> log(DyeColor.BLUE, DyeColor.BLUE));
    public static final DeferredHolder<Block, Block> ANCIENT_LEAVES = registerBlock("ancient_leaves", () -> new AncientLeaves(BlockBehaviour.Properties.of().strength(0.2F).randomTicks().sound(SoundType.AZALEA_LEAVES).noOcclusion().mapColor(DyeColor.PURPLE)));
    public static final DeferredHolder<Block, Block> ANCIENT_LEAVES_BOTTOM = registerBlock(PILLARBLOCKS, "ancient_leaves_bottom", () -> new AncientLeavesBottom(BlockBehaviour.Properties.of().strength(0.2F).randomTicks().sound(SoundType.AZALEA_LEAVES).noCollission().noOcclusion()));
    public static final DeferredHolder<Block, Block> ANCIENT_PLANKS = registerBlock("ancient_planks", () -> new Block(BlockBehaviour.Properties.of().strength(0.8F).randomTicks().sound(SoundType.WOOD)));
    public static final DeferredHolder<Block, Block> ANCIENT_TRAPDOOR = registerBlock(PILLARBLOCKS, "ancient_trap_door", () -> new TrapDoorBlock(ATMBlockSets.ANCIENT, BlockBehaviour.Properties.of().strength(0.2F).randomTicks().sound(SoundType.WOOD).noOcclusion()));
    public static final DeferredHolder<Block, Block> ANCIENT_WOOD_FENCE = registerBlock(PILLARBLOCKS, "ancient_wooden_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().strength(0.8F).dynamicShape().sound(SoundType.WOOD)));
    public static final DeferredHolder<Block, Block> ANCIENT_WOOD_FENCE_GATE = registerBlock(PILLARBLOCKS, "ancient_wooden_fence_gate", () -> new FenceGateBlock(ATMBlockSets.ANCIENTWOOD, BlockBehaviour.Properties.of().strength(0.8F).dynamicShape().sound(SoundType.WOOD)));
    public static final DeferredHolder<Block, Block> ANCIENT_DOOR = registerBlock(PILLARBLOCKS, "ancient_door", () -> new DoorBlock(ATMBlockSets.ANCIENT, BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD)));

    public static final DeferredHolder<Block, Block> DEMONIC_LOG = registerBlock(PILLARBLOCKS, "demonic_log", () -> log(DyeColor.RED, DyeColor.RED));
    public static final DeferredHolder<Block, Block> DEMONIC_LOG_STRIPPED = registerBlock(PILLARBLOCKS, "stripped_demonic_log", () -> log(DyeColor.RED, DyeColor.RED));
    public static final DeferredHolder<Block, Block> DEMONIC_LEAVES = registerBlock("demonic_leaves", () -> new DemonicLeaves(BlockBehaviour.Properties.of().strength(0.2F).randomTicks().sound(SoundType.AZALEA_LEAVES).noOcclusion()));
    public static final DeferredHolder<Block, Block> DEMONIC_LEAVES_BOTTOM = registerBlock(PILLARBLOCKS, "demonic_leaves_bottom", () -> new DemonicLeavesBottom(BlockBehaviour.Properties.of().strength(0.2F).randomTicks().sound(SoundType.AZALEA_LEAVES).noCollission().noOcclusion()));
    public static final DeferredHolder<Block, Block> DEMONIC_PLANKS = registerBlock("demonic_planks", () -> new Block(BlockBehaviour.Properties.of().strength(0.8F).randomTicks().sound(SoundType.WOOD)));
    public static final DeferredHolder<Block, Block> DEMONIC_TRAPDOOR = registerBlock(PILLARBLOCKS, "demonic_trap_door", () -> new TrapDoorBlock(ATMBlockSets.DEMONIC, BlockBehaviour.Properties.of().strength(0.2F).randomTicks().sound(SoundType.WOOD).noOcclusion()));
    public static final DeferredHolder<Block, Block> DEMONIC_WOOD_FENCE = registerBlock(PILLARBLOCKS, "demonic_wooden_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().strength(0.8F).dynamicShape().sound(SoundType.WOOD)));
    public static final DeferredHolder<Block, Block> DEMONIC_WOOD_FENCE_GATE = registerBlock(PILLARBLOCKS, "demonic_wooden_fence_gate", () -> new FenceGateBlock(ATMBlockSets.DEMONICWOOD, BlockBehaviour.Properties.of().strength(0.8F).dynamicShape().sound(SoundType.WOOD)));
    public static final DeferredHolder<Block, Block> DEMONIC_DOOR = registerBlock(PILLARBLOCKS, "demonic_door", () -> new DoorBlock(ATMBlockSets.DEMONIC, BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD)));

    public static final DeferredHolder<Block, Block> SOUL_SAPLING = registerBlock("soul_sapling", () -> new AncientSaplingBlock(new TreeGrower("soul_tree", 0.9F, Optional.empty(), Optional.empty(), Optional.of(Reference.SOUL_TREE), Optional.empty(), Optional.empty(), Optional.empty()), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredHolder<Block, Block> ANCIENT_SAPLING = registerBlock("ancient_sapling", () -> new AncientSaplingBlock(new TreeGrower("ancient_tree", 0.9F, Optional.empty(), Optional.empty(), Optional.of(Reference.ANCIENT_TREE), Optional.empty(), Optional.empty(), Optional.empty()), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredHolder<Block, Block> DEMONIC_SAPLING = registerBlock("demonic_sapling", () -> new AncientSaplingBlock(new TreeGrower("demonic_tree", 0.9F, Optional.empty(), Optional.empty(), Optional.of(Reference.DEMONIC_TREE), Optional.empty(), Optional.empty(), Optional.empty()), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));

    public static final DeferredHolder<Block, Block> SOULLAVA_BLOCK = registerBlock("soul_lava", () -> new SoulLava(FluidRegistry.SOULLAVA, Block.Properties.of().noCollission().strength(100f).noOcclusion().jumpFactor(0.1F).speedFactor(0.01F).lightLevel((light) -> {
        return 15;
    }).mapColor(DyeColor.BLUE).noLootTable()), false);

    public static final DeferredHolder<Block, Block> MOLTEN_ATM_BLOCK = registerBlock("molten_allthemodium_block", () -> new LiquidBlock(FluidRegistry.ALLTHEMODIUM.value(), Block.Properties.of().noCollission().strength(100f).mapColor(DyeColor.YELLOW).noLootTable()), false);
    public static final DeferredHolder<Block, Block> MOLTEN_VIB_BLOCK = registerBlock("molten_vibranium_block", () -> new LiquidBlock(FluidRegistry.VIBRANIUM.value(), Block.Properties.of().noCollission().strength(100f).mapColor(DyeColor.GREEN).noLootTable()), false);
    public static final DeferredHolder<Block, Block> MOLTEN_UNOB_BLOCK = registerBlock("molten_unobtainium_block", () -> new LiquidBlock(FluidRegistry.UNOBTAINIUM.value(), Block.Properties.of().noCollission().strength(100f).mapColor(DyeColor.PURPLE).noLootTable()), false);

    public static final DeferredHolder<Block, Block> SUS_CLAY = registerBlock("suspicious_clay", () -> new ATMBrushableBlock(Blocks.CLAY, BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.SNARE).strength(0.25F).sound(SoundType.SUSPICIOUS_SAND).pushReaction(PushReaction.DESTROY), SoundEvents.BRUSH_SAND, SoundEvents.BRUSH_SAND_COMPLETED));
    public static final DeferredHolder<Block, Block> SUS_SOUL_SAND = registerBlock("suspicious_soul_sand", () -> new ATMBrushableBlock(Blocks.SOUL_SAND, BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.SNARE).strength(0.25F).sound(SoundType.SUSPICIOUS_SAND).pushReaction(PushReaction.DESTROY), SoundEvents.BRUSH_SAND, SoundEvents.BRUSH_SAND_COMPLETED));

    public static final DeferredHolder<Item, Item> SOUL_LAVA_BUCKET = registerItem("soul_lava_bucket", () -> new BucketItem(FluidRegistry.SOULLAVA.value(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredHolder<Item, Item> MOLTEN_ATM_BUCKET = registerItem("molten_allthemodium_bucket", () -> new BucketItem(FluidRegistry.ALLTHEMODIUM.value(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredHolder<Item, Item> MOLTEN_VIB_BUCKET = registerItem("molten_vibranium_bucket", () -> new BucketItem(FluidRegistry.VIBRANIUM.value(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredHolder<Item, Item> MOLTEN_UNOB_BUCKET = registerItem("molten_unobtainium_bucket", () -> new BucketItem(FluidRegistry.UNOBTAINIUM.value(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final DeferredHolder<Block, Block> SOUL_LOG = registerBlock(PILLARBLOCKS, "soul_log", () -> log(DyeColor.LIGHT_BLUE, DyeColor.LIGHT_BLUE));
    public static final DeferredHolder<Block, Block> SOUL_LOG_0 = registerBlock(PILLARBLOCKS, "soul_log_0", () -> log(DyeColor.LIGHT_BLUE, DyeColor.LIGHT_BLUE));
    public static final DeferredHolder<Block, Block> SOUL_LOG_1 = registerBlock(PILLARBLOCKS, "soul_log_1", () -> log(DyeColor.LIGHT_BLUE, DyeColor.LIGHT_BLUE));
    public static final DeferredHolder<Block, Block> SOUL_LOG_2 = registerBlock(PILLARBLOCKS, "soul_log_2", () -> log(DyeColor.LIGHT_BLUE, DyeColor.LIGHT_BLUE));
    public static final DeferredHolder<Block, Block> SOUL_LOG_STRIPPED = registerBlock(PILLARBLOCKS, "stripped_soul_log", () -> log(DyeColor.LIGHT_BLUE, DyeColor.LIGHT_BLUE));
    public static final DeferredHolder<Block, Block> SOUL_LEAVES = registerBlock("soul_leaves", () -> new SoulLeaves(BlockBehaviour.Properties.of().strength(0.2F).randomTicks().sound(SoundType.AZALEA_LEAVES).noOcclusion()));
    public static final DeferredHolder<Block, Block> SOUL_LEAVES_BOTTOM = registerBlock(PILLARBLOCKS, "soul_leaves_bottom", () -> new SoulLeavesBottom(BlockBehaviour.Properties.of().strength(0.2F).randomTicks().sound(SoundType.AZALEA_LEAVES).noCollission().noOcclusion()));
    public static final DeferredHolder<Block, Block> SOUL_PLANKS = registerBlock("soul_planks", () -> new Block(BlockBehaviour.Properties.of().strength(0.8F).randomTicks().sound(SoundType.WOOD)));
    public static final DeferredHolder<Block, Block> SOUL_TRAPDOOR = registerBlock(PILLARBLOCKS, "soul_trap_door", () -> new TrapDoorBlock(ATMBlockSets.SOUL, BlockBehaviour.Properties.of().strength(0.2F).randomTicks().sound(SoundType.WOOD).noOcclusion()));
    public static final DeferredHolder<Block, Block> SOUL_WOOD_FENCE = registerBlock(PILLARBLOCKS, "soul_wooden_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().strength(0.8F).dynamicShape().sound(SoundType.WOOD)));
    public static final DeferredHolder<Block, Block> SOUL_WOOD_FENCE_GATE = registerBlock(PILLARBLOCKS, "soul_wooden_fence_gate", () -> new FenceGateBlock(ATMBlockSets.SOULWOOD, BlockBehaviour.Properties.of().strength(0.8F).dynamicShape().sound(SoundType.WOOD)));
    public static final DeferredHolder<Block, Block> SOUL_DOOR = registerBlock(PILLARBLOCKS, "soul_door", () -> new DoorBlock(ATMBlockSets.SOUL, BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD)));

    public static final DeferredHolder<Block, Block> ANCIENT_STONE_WALL = registerBlock(WALLBLOCKS, "ancient_stone_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(ANCIENT_STONE.get())));
    public static final DeferredHolder<Block, Block> ANCIENT_SMOOTH_STONE_WALL = registerBlock(WALLBLOCKS, "ancient_smooth_stone_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(ANCIENT_SMOOTH_STONE.get())));
    public static final DeferredHolder<Block, Block> ANCIENT_POLISHED_STONE_WALL = registerBlock(WALLBLOCKS, "ancient_polished_stone_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(ANCIENT_POLISHED_STONE.get())));
    public static final DeferredHolder<Block, Block> ANCIENT_STONE_BRICK_WALL = registerBlock(WALLBLOCKS, "ancient_stone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(ANCIENT_STONE_BRICKS.get())));
    public static final DeferredHolder<Block, Block> ANCIENT_CHISELED_STONE_BRICK_WALL = registerBlock(WALLBLOCKS, "ancient_chiseled_stone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(ANCIENT_CHISELED_STONE_BRICKS.get())));
    public static final DeferredHolder<Block, Block> ANCIENT_CRACKED_STONE_BRICK_WALL = registerBlock(WALLBLOCKS, "ancient_cracked_stone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(ANCIENT_CRACKED_STONE_BRICKS.get())));
    public static final DeferredHolder<Block, Block> ANCIENT_MOSSY_STONE_WALL = registerBlock(WALLBLOCKS, "ancient_mossy_stone_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(ANCIENT_MOSSY_STONE.get())));

    public static final DeferredHolder<Block, Block> ANCIENT_BOOKSHELF = registerBlock(PILLARBLOCKS, "ancient_bookshelf", () -> new AncientBookShelf(BlockBehaviour.Properties.of().strength(0.8F).randomTicks().sound(SoundType.WOOD)));
    public static final DeferredHolder<Block, Block> DEMONIC_BOOKSHELF = registerBlock(PILLARBLOCKS, "demonic_bookshelf", () -> new AncientBookShelf(BlockBehaviour.Properties.of().strength(0.8F).randomTicks().sound(SoundType.WOOD)));
    public static final DeferredHolder<Block, Block> SOUL_BOOKSHELF = registerBlock(PILLARBLOCKS, "soul_bookshelf", () -> new AncientBookShelf(BlockBehaviour.Properties.of().strength(0.8F).randomTicks().sound(SoundType.WOOD)));

    public static final DeferredHolder<Block, Block> ANCIENT_WOODEN_STAIRS = registerBlock(STAIRBLOCKS, "ancient_wooden_stairs", () -> new StairBlock(ANCIENT_PLANKS.get().defaultBlockState(), ANCIENT_PLANKS.get().properties()));
    public static final DeferredHolder<Block, Block> DEMONIC_WOODEN_STAIRS = registerBlock(STAIRBLOCKS, "demonic_wooden_stairs", () -> new StairBlock(DEMONIC_PLANKS.get().defaultBlockState(), DEMONIC_PLANKS.get().properties()));
    public static final DeferredHolder<Block, Block> SOUL_WOODEN_STAIRS = registerBlock(STAIRBLOCKS, "soul_wooden_stairs", () -> new StairBlock(SOUL_PLANKS.get().defaultBlockState(), SOUL_PLANKS.get().properties()));
    public static final DeferredHolder<Block, Block> ANCIENT_STONE_STAIRS = registerBlock(STAIRBLOCKS, "ancient_stone_stairs", () -> new StairBlock(ANCIENT_STONE.get().defaultBlockState(), ANCIENT_STONE.get().properties()));
    public static final DeferredHolder<Block, Block> ANCIENT_SMOOTH_STONE_STAIRS = registerBlock(STAIRBLOCKS, "ancient_smooth_stone_stairs", () -> new StairBlock(ANCIENT_SMOOTH_STONE.get().defaultBlockState(), ANCIENT_SMOOTH_STONE.get().properties()));
    public static final DeferredHolder<Block, Block> ANCIENT_STONE_BRICK_STAIRS = registerBlock(STAIRBLOCKS, "ancient_stone_brick_stairs", () -> new StairBlock(ANCIENT_STONE_BRICKS.get().defaultBlockState(), ANCIENT_STONE.get().properties()));

    public static final DeferredHolder<Block, Block> ANCIENT_MOSSY_STONE_STAIRS = registerBlock(STAIRBLOCKS, "ancient_mossy_stone_stairs", () -> new StairBlock(ANCIENT_MOSSY_STONE.get().defaultBlockState(), ANCIENT_MOSSY_STONE.get().properties()));
    public static final DeferredHolder<Block, Block> ANCIENT_CHISELED_STONE_STAIRS = registerBlock(STAIRBLOCKS, "ancient_chiseled_stone_brick_stairs", () -> new StairBlock(ANCIENT_CHISELED_STONE_BRICKS.get().defaultBlockState(), ANCIENT_MOSSY_STONE.get().properties()));
    public static final DeferredHolder<Block, Block> ANCIENT_CRACKED_STONE_STAIRS = registerBlock(STAIRBLOCKS, "ancient_cracked_stone_brick_stairs", () -> new StairBlock(ANCIENT_CRACKED_STONE_BRICKS.get().defaultBlockState(), ANCIENT_MOSSY_STONE.get().properties()));
    public static final DeferredHolder<Block, Block> ANCIENT_POLISHED_STONE_STAIRS = registerBlock(STAIRBLOCKS, "ancient_polished_stone_stairs", () -> new StairBlock(ANCIENT_POLISHED_STONE.get().defaultBlockState(), ANCIENT_MOSSY_STONE.get().properties()));

    public static final DeferredHolder<Block, Block> ANCIENT_WOODEN_SLABS = registerBlock(SLABBLOCKS, "ancient_wooden_slabs", () -> new SlabBlock(ANCIENT_PLANKS.get().properties()));
    public static final DeferredHolder<Block, Block> DEMONIC_WOODEN_SLABS = registerBlock(SLABBLOCKS, "demonic_wooden_slabs", () -> new SlabBlock(DEMONIC_PLANKS.get().properties()));
    public static final DeferredHolder<Block, Block> SOUL_WOODEN_SLABS = registerBlock(SLABBLOCKS, "soul_wooden_slabs", () -> new SlabBlock(SOUL_PLANKS.get().properties()));
    public static final DeferredHolder<Block, Block> ANCIENT_STONE_SLABS = registerBlock(SLABBLOCKS, "ancient_stone_slabs", () -> new SlabBlock(ANCIENT_STONE.get().properties()));
    public static final DeferredHolder<Block, Block> ANCIENT_SMOOTH_STONE_SLABS = registerBlock(SLABBLOCKS, "ancient_smooth_stone_slabs", () -> new SlabBlock(ANCIENT_SMOOTH_STONE.get().properties()));
    public static final DeferredHolder<Block, Block> ANCIENT_STONE_BRICK_SLABS = registerBlock(SLABBLOCKS, "ancient_stone_brick_slabs", () -> new SlabBlock(ANCIENT_STONE.get().properties()));
    public static final DeferredHolder<Block, Block> ANCIENT_MOSSY_STONE_SLABS = registerBlock(SLABBLOCKS, "ancient_mossy_stone_slabs", () -> new SlabBlock(ANCIENT_MOSSY_STONE.get().properties()));
    public static final DeferredHolder<Block, Block> ANCIENT_CHISELED_STONE_SLABS = registerBlock(SLABBLOCKS, "ancient_chiseled_stone_brick_slabs", () -> new SlabBlock(ANCIENT_MOSSY_STONE.get().properties()));
    public static final DeferredHolder<Block, Block> ANCIENT_CRACKED_STONE_SLABS = registerBlock(SLABBLOCKS, "ancient_cracked_stone_brick_slabs", () -> new SlabBlock(ANCIENT_MOSSY_STONE.get().properties()));
    public static final DeferredHolder<Block, Block> ANCIENT_POLISHED_STONE_SLABS = registerBlock(SLABBLOCKS, "ancient_polished_stone_slabs", () -> new SlabBlock(ANCIENT_MOSSY_STONE.get().properties()));

    public static final DeferredHolder<Block, Block> ALLTHEMODIUM_ORE = registerBlock("allthemodium_ore", Allthemodium_Ore::new);
    public static final DeferredHolder<Block, Block> ALLTHEMODIUM_SLATE_ORE = registerBlock("allthemodium_slate_ore", Allthemodium_Ore::new);

    public static final DeferredHolder<Block, Block> VIBRANIUM_ORE = registerBlock("vibranium_ore", Vibranium_Ore::new);
    public static final DeferredHolder<Block, Block> OTHER_VIBRANIUM_ORE = registerBlock("other_vibranium_ore", Vibranium_Ore::new);
    public static final DeferredHolder<Block, Block> UNOBTAINIUM_ORE = registerBlock("unobtainium_ore", Unobtainium_Ore::new);

    public static final DeferredHolder<Block, Block> ALLTHEMODIUM_BLOCK = registerBlock("allthemodium_block", ATM_Block::new);
    public static final DeferredHolder<Block, Block> VIBRANIUM_BLOCK = registerBlock("vibranium_block", VIB_Block::new);
    public static final DeferredHolder<Block, Block> UNOBTAINIUM_BLOCK = registerBlock("unobtainium_block", UNOB_Block::new);

    public static final DeferredHolder<Block, Block> RAW_ALLTHEMODIUM_BLOCK = registerBlock("raw_allthemodium_block", () -> new Block(BlockBehaviour.Properties.of().strength(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final DeferredHolder<Block, Block> RAW_VIBRANIUM_BLOCK = registerBlock("raw_vibranium_block", () -> new Block(BlockBehaviour.Properties.of().strength(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final DeferredHolder<Block, Block> RAW_UNOBTAINIUM_BLOCK = registerBlock("raw_unobtainium_block", () -> new Block(BlockBehaviour.Properties.of().strength(3.0F, 3.0F).sound(SoundType.METAL)));

    public static final DeferredHolder<Item, Item> RAW_ALLTHEMODIUM = registerItem("raw_allthemodium", () -> new RawOre(new Item.Properties()));
    public static final DeferredHolder<Item, Item> RAW_VIBRANIUM = registerItem("raw_vibranium", () -> new RawOre(new Item.Properties()));
    public static final DeferredHolder<Item, Item> RAW_UNOBTAINIUM = registerItem("raw_unobtainium", () -> new RawOre(new Item.Properties()));

    public static final DeferredHolder<Item, Item> ALLTHEMODIUM_INGOT = registerItem("allthemodium_ingot", () -> new Ingot(new Item.Properties()));
    public static final DeferredHolder<Item, Item> VIBRANIUM_INGOT = registerItem("vibranium_ingot", () -> new Ingot(new Item.Properties()));
    public static final DeferredHolder<Item, Item> UNOBTAINIUM_INGOT = registerItem("unobtainium_ingot", () -> new Ingot(new Item.Properties()));
    public static final DeferredHolder<Item, Item> ATM_PLATE = registerItem("allthemodium_plate", () -> new Plate(new Item.Properties()));
    public static final DeferredHolder<Item, Item> VIB_PLATE = registerItem("vibranium_plate", () -> new Plate(new Item.Properties()));
    public static final DeferredHolder<Item, Item> ONOB_PLATE = registerItem("unobtainium_plate", () -> new Plate(new Item.Properties()));

    public static final DeferredHolder<Item, Item> ATM_GEAR = registerItem("allthemodium_gear", () -> new Gear(new Item.Properties()));
    public static final DeferredHolder<Item, Item> VIB_GEAR = registerItem("vibranium_gear", () -> new Gear(new Item.Properties()));
    public static final DeferredHolder<Item, Item> ONOB_GEAR = registerItem("unobtainium_gear", () -> new Gear(new Item.Properties()));

    public static final DeferredHolder<Item, Item> ATM_ROD = registerItem("allthemodium_rod", () -> new Rod(new Item.Properties()));
    public static final DeferredHolder<Item, Item> VIB_ROD = registerItem("vibranium_rod", () -> new Rod(new Item.Properties()));
    public static final DeferredHolder<Item, Item> ONOB_ROD = registerItem("unobtainium_rod", () -> new Rod(new Item.Properties()));

    public static final DeferredHolder<Item, Item> ALLTHEMODIUM_NUGGET = registerItem("allthemodium_nugget", () -> new Nugget(new Item.Properties()));
    public static final DeferredHolder<Item, Item> VIBRANIUM_NUGGET = registerItem("vibranium_nugget", () -> new Nugget(new Item.Properties()));
    public static final DeferredHolder<Item, Item> UNOBTAINIUM_NUGGET = registerItem("unobtainium_nugget", () -> new Nugget(new Item.Properties()));

    public static final DeferredHolder<Item, Item> ALLTHEMODIUM_DUST = registerItem("allthemodium_dust", () -> new Dust(new Item.Properties()));
    public static final DeferredHolder<Item, Item> VIBRANIUM_DUST = registerItem("vibranium_dust", () -> new Dust(new Item.Properties()));
    public static final DeferredHolder<Item, Item> UNOBTAINIUM_DUST = registerItem("unobtainium_dust", () -> new Dust(new Item.Properties()));

    public static final DeferredHolder<Item, Item> UNOBTAINIUM_ALLTHEMODIUM_DUST = registerItem("unobtainium_allthemodium_alloy_dust", () -> new Alloy_Dust(new Item.Properties().fireResistant()));
    public static final DeferredHolder<Item, Item> UNOBTAINIUM_VIBRANIUM_DUST = registerItem("unobtainium_vibranium_alloy_dust", () -> new Alloy_Dust(new Item.Properties().fireResistant()));
    public static final DeferredHolder<Item, Item> VIBRANIUM_ALLTHEMODIUM_DUST = registerItem("vibranium_allthemodium_alloy_dust", () -> new Alloy_Dust(new Item.Properties().fireResistant()));

    public static final DeferredHolder<Item, Item> UNOBTAINIUM_ALLTHEMODIUM_ALLOY = registerItem("unobtainium_allthemodium_alloy_ingot", () -> new Alloy_Ingot(new Item.Properties().fireResistant()));
    public static final DeferredHolder<Item, Item> UNOBTAINIUM_VIBRANIUM_ALLOY = registerItem("unobtainium_vibranium_alloy_ingot", () -> new Alloy_Ingot(new Item.Properties().fireResistant()));
    public static final DeferredHolder<Item, Item> VIBRANIUM_ALLTHEMODIUM_ALLOY = registerItem("vibranium_allthemodium_alloy_ingot", () -> new Alloy_Ingot(new Item.Properties().fireResistant()));

    public static final DeferredHolder<Block, Block> TELEPORT_PAD = registerBlock(SHAPED_BLOCKS, "teleport_pad", () -> new TeleportPad(Block.Properties.of().noOcclusion().strength(20.0F)));

    public static final DeferredHolder<Block, Block> UA_ALLOY = registerBlock("unobtainium_allthemodium_alloy_block", UAAlloy_Block::new);
    public static final DeferredHolder<Block, Block> UV_ALLOY = registerBlock("unobtainium_vibranium_alloy_block", UVAlloy_Block::new);
    public static final DeferredHolder<Block, Block> VA_ALLOY = registerBlock("vibranium_allthemodium_alloy_block", VAAlloy_Block::new);

    public static final DeferredHolder<Item, Item> ATM_SMITHING = registerItem("allthemodium_upgrade_smithing_template", ATMSmithingItem::createAllthemodiumUpgradeTemplate);
    public static final DeferredHolder<Item, Item> VIB_SMITHING = registerItem("vibranium_upgrade_smithing_template", ATMSmithingItem::createVibraniumUpgradeTemplate);
    public static final DeferredHolder<Item, Item> UNO_SMITHING = registerItem("unobtainium_upgrade_smithing_template", ATMSmithingItem::createUnobtainiumUpgradeTemplate);

    public static final DeferredHolder<Item, Item> PIGLICH_HEART = registerItem("piglich_heart", () -> new PiglichHeart(new Item.Properties()));
    public static final DeferredHolder<EntityType<?>, EntityType<PiglichEntity>> PIGLICH = createMonsterEntity("piglich", PiglichEntity::new, 0.6F, 3.0F, 0x000000, 0xebe834);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATIVE_TAB = CREATIVE_TABS.register("creative_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable(Reference.tab()))
            .icon(() -> RAW_ALLTHEMODIUM.get().getDefaultInstance())
            .displayItems((parameters, output) -> ITEMS.getEntries().stream()
                    .map(DeferredHolder::get)
                    .map(Item::getDefaultInstance)
                    .forEach(output::accept))
            .build()
    );

	private static ArrayList<Item> SPAWN_EGGS = new ArrayList<Item>();

    private static <T extends Monster> DeferredHolder<EntityType<?>, EntityType<T>> createMonsterEntity(String name, EntityType.EntityFactory<T> factory, float width, float height, int eggPrimary, int eggSecondary) {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, name);

        return ENTITIES.register(name, () -> EntityType.Builder.of(factory, MobCategory.MONSTER).sized(width, height).setTrackingRange(64).setUpdateInterval(1).fireImmune().build(location.toString()));
        //EntityType<T> entity = EntityType.Builder.of(factory, MobCategory.MONSTER).sized(width, height).setTrackingRange(64).setUpdateInterval(1).build(location.toString());
        //Item spawnEgg = new SpawnEggItem(entity, eggPrimary, eggSecondary, (new Item.Properties()));
        //spawnEgg.setRegistryName(new ResourceLocation(Reference.MOD_ID, name + "_spawn_egg"));
        //SPAWN_EGGS.add(spawnEgg);

        //return ENTITIES.register(name, () -> entity);
    }
/*
	private static <T extends AbstractGolem> RegistryObject<EntityType<T>> createShulkerEntity(String name, EntityType.EntityFactory<T> factory, float width, float height, int eggPrimary, int eggSecondary) {
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
		EntityType<T> entity = EntityType.Builder.of(factory, MobCategory.MONSTER).sized(width, height).setTrackingRange(64).setUpdateInterval(1).build(location.toString());
		Item spawnEgg = new SpawnEggItem(entity, eggPrimary, eggSecondary, (new Item.Properties()));
		spawnEgg.setRegistryName(new ResourceLocation(Reference.MOD_ID, name + "_spawn_egg"));
		SPAWN_EGGS.add(spawnEgg);

		return ENTITIES.register(name, () -> entity);
	}

 */

    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(PIGLICH.get(), PiglichEntity.createAttributes().build());
        //event.put(ATM_SHULKER.get(), UNOBShulkerEntity.createAttributes().build());

    }

    private static RotatedPillarBlock log(DyeColor color1, DyeColor color2) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD));
    }

    public static final DeferredHolder<Item, Item> ATM_SWORD = registerItem("allthemodium_sword", () -> new SwordItem(ATMTier.ALLTHEMODIUM, (new Item.Properties()).rarity(Rarity.EPIC).fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).attributes(SwordItem.createAttributes(ATMTier.ALLTHEMODIUM, 5, -1.4F))));
    public static final DeferredHolder<Item, Item> VIB_SWORD = registerItem("vibranium_sword", () -> new SwordItem(ATMTier.VIBRANIUM, (new Item.Properties()).rarity(Rarity.EPIC).fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).attributes(SwordItem.createAttributes(ATMTier.VIBRANIUM, 10, -0.4F))));
    public static final DeferredHolder<Item, Item> UNO_SWORD = registerItem("unobtainium_sword", () -> new SwordItem(ATMTier.UNOBTAINIUM, (new Item.Properties()).rarity(Rarity.EPIC).fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).attributes(SwordItem.createAttributes(ATMTier.UNOBTAINIUM, 15, 0.4F))));

    public static final DeferredHolder<Item, Item> ATM_PICKAXE = registerItem("allthemodium_pickaxe", () -> new PickaxeItem(ATMTier.ALLTHEMODIUM, (new Item.Properties()).rarity(Rarity.EPIC).fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).attributes(PickaxeItem.createAttributes(ATMTier.ALLTHEMODIUM, 2.0F, -1.0F))));
    public static final DeferredHolder<Item, Item> VIB_PICKAXE = registerItem("vibranium_pickaxe", () -> new PickaxeItem(ATMTier.VIBRANIUM, (new Item.Properties()).rarity(Rarity.EPIC).fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).attributes(PickaxeItem.createAttributes(ATMTier.VIBRANIUM, 4.0F, -0.8F))));
    public static final DeferredHolder<Item, Item> UNO_PICKAXE = registerItem("unobtainium_pickaxe", () -> new PickaxeItem(ATMTier.UNOBTAINIUM, (new Item.Properties()).rarity(Rarity.EPIC).fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).attributes(PickaxeItem.createAttributes(ATMTier.UNOBTAINIUM, 6.0F, -0.6F))));

    public static final DeferredHolder<Item, Item> ATM_AXE = registerItem("allthemodium_axe", () -> new AxeItem(ATMTier.ALLTHEMODIUM, (new Item.Properties()).fireResistant().rarity(Rarity.EPIC).component(DataComponents.UNBREAKABLE, new Unbreakable(true)).attributes(AxeItem.createAttributes(ATMTier.ALLTHEMODIUM, 9.0F, -3.2F))));
    public static final DeferredHolder<Item, Item> VIB_AXE = registerItem("vibranium_axe", () -> new AxeItem(ATMTier.VIBRANIUM, (new Item.Properties()).fireResistant().rarity(Rarity.EPIC).component(DataComponents.UNBREAKABLE, new Unbreakable(true)).attributes(AxeItem.createAttributes(ATMTier.VIBRANIUM, 12.0F, -3.0F))));
    public static final DeferredHolder<Item, Item> UNO_AXE = registerItem("unobtainium_axe", () -> new AxeItem(ATMTier.UNOBTAINIUM, (new Item.Properties()).fireResistant().rarity(Rarity.EPIC).component(DataComponents.UNBREAKABLE, new Unbreakable(true)).attributes(AxeItem.createAttributes(ATMTier.UNOBTAINIUM, 15.0F, -2.8F))));

    public static final DeferredHolder<Item, Item> ATM_SHOVEL = registerItem("allthemodium_shovel", () -> new ShovelItem(ATMTier.ALLTHEMODIUM, (new Item.Properties()).rarity(Rarity.EPIC).fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).attributes(ShovelItem.createAttributes(ATMTier.ALLTHEMODIUM, 2.0F, -1.0F))));
    public static final DeferredHolder<Item, Item> VIB_SHOVEL = registerItem("vibranium_shovel", () -> new ShovelItem(ATMTier.VIBRANIUM, (new Item.Properties()).rarity(Rarity.EPIC).fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).attributes(ShovelItem.createAttributes(ATMTier.VIBRANIUM, 4.0F, -0.8F))));
    public static final DeferredHolder<Item, Item> UNO_SHOVEL = registerItem("unobtainium_shovel", () -> new ShovelItem(ATMTier.UNOBTAINIUM, (new Item.Properties()).rarity(Rarity.EPIC).fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).attributes(ShovelItem.createAttributes(ATMTier.UNOBTAINIUM, 6.0F, -0.6F))));

    public static final DeferredHolder<Item, Item> ATM_HOE = registerItem("allthemodium_hoe", () -> new HoeItem(ATMTier.ALLTHEMODIUM, (new Item.Properties()).rarity(Rarity.EPIC).fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).attributes(HoeItem.createAttributes(ATMTier.ALLTHEMODIUM, -3, 0.0F))));
    public static final DeferredHolder<Item, Item> VIB_HOE = registerItem("vibranium_hoe", () -> new HoeItem(ATMTier.VIBRANIUM, (new Item.Properties()).rarity(Rarity.EPIC).fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).attributes(HoeItem.createAttributes(ATMTier.VIBRANIUM, -2, 0.0F))));
    public static final DeferredHolder<Item, Item> UNO_HOE = registerItem("unobtainium_hoe", () -> new HoeItem(ATMTier.UNOBTAINIUM, (new Item.Properties()).rarity(Rarity.EPIC).fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).attributes(HoeItem.createAttributes(ATMTier.UNOBTAINIUM, -1, 0.0F))));

    public static final DeferredHolder<Item, Item> ATM_MACE = registerItem("allthemodium_mace", () -> new ATMMace(ATMTier.ALLTHEMODIUM, (new Item.Properties()).rarity(Rarity.EPIC).fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).component(DataComponents.TOOL, ATMMace.createToolProperties(ATMTier.ALLTHEMODIUM)).attributes(ATMMace.createAttributes(ATMTier.ALLTHEMODIUM)).stacksTo(1)));
    public static final DeferredHolder<Item, Item> VIB_MACE = registerItem("vibranium_mace", () -> new ATMMace(ATMTier.VIBRANIUM, (new Item.Properties()).rarity(Rarity.EPIC).fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).component(DataComponents.TOOL, ATMMace.createToolProperties(ATMTier.VIBRANIUM)).attributes(ATMMace.createAttributes(ATMTier.VIBRANIUM)).stacksTo(1)));
    public static final DeferredHolder<Item, Item> UNO_MACE = registerItem("unobtainium_mace", () -> new ATMMace(ATMTier.UNOBTAINIUM, (new Item.Properties()).rarity(Rarity.EPIC).fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).component(DataComponents.TOOL, ATMMace.createToolProperties(ATMTier.UNOBTAINIUM)).attributes(ATMMace.createAttributes(ATMTier.UNOBTAINIUM)).stacksTo(1)));

    public static final DeferredHolder<Item, Item> ATM_BRUSH = registerItem("allthemodium_brush", () -> new Brush((new Item.Properties()).rarity(Rarity.EPIC).fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).stacksTo(1), 2));
    public static final DeferredHolder<Item, Item> VIB_BRUSH = registerItem("vibranium_brush", () -> new Brush((new Item.Properties()).rarity(Rarity.EPIC).fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).stacksTo(1), 5));
    public static final DeferredHolder<Item, Item> UNO_BRUSH = registerItem("unobtainium_brush", () -> new Brush((new Item.Properties()).rarity(Rarity.EPIC).fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).stacksTo(1), 10));

    //public static final DeferredHolder<Item, Item> ATM_BOW = registerItem("allthemodium_bow", () -> new ATMBow((new Item.Properties()).fireResistant().rarity(Rarity.EPIC)));

    //public static final DeferredHolder<Item, Item> UNO_BOW = registerItem("unobtainium_crossbow", () -> new Unobow((new Item.Properties()).fireResistant().rarity(Rarity.EPIC)));

    //public static final DeferredHolder<Item, Item> VIB_SHIELD = registerItem("vibranium_shield", () -> new Vib_Shield((new Item.Properties()).fireResistant().stacksTo(1).rarity(Rarity.EPIC)));

    public static final DeferredHolder<Item, Item> ALLOY_TRIDENT = registerItem("alloy_trident", () -> new ATMTrident((new Item.Properties()).fireResistant().rarity(Rarity.EPIC).attributes(ATMTrident.createAttributes()).component(DataComponents.UNBREAKABLE, new Unbreakable(true)).component(DataComponents.TOOL, ATMTrident.createToolProperties())));
    public static final DeferredHolder<EntityType<?>, EntityType<ThrownTrident>> ALLOY_TRIDENT_ENTITY = ENTITIES.register("alloy_trident", () -> EntityType.Builder.<ThrownTrident>of(ThrownTrident::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(10).build("alloy_trident"));

    public static final DeferredHolder<Item, Item> ALLOY_SWORD = registerItem("alloy_sword", () -> new SwordItem(ATMTier.ALLOY, new Item.Properties().rarity(Rarity.EPIC).fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).attributes(SwordItem.createAttributes(ATMTier.ALLOY, 3, 2.9F))));
    public static final DeferredHolder<Item, Item> ALLOY_AXE = registerItem("alloy_axe", () -> new AxeItem(ATMTier.ALLOY, new Item.Properties().rarity(Rarity.EPIC).fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true)).attributes(AxeItem.createAttributes(ATMTier.ALLOY, 4, 2.4F))));
    public static final DeferredHolder<Item, Item> ALLOY_PICKAXE = registerItem("alloy_pick", () -> new PickaxeItem(ATMTier.ALLOY, new Item.Properties().rarity(Rarity.EPIC).component(DataComponents.UNBREAKABLE, new Unbreakable(true)).fireResistant().attributes(PickaxeItem.createAttributes(ATMTier.ALLOY, 2, 2.0F))));
    public static final DeferredHolder<Item, Item> ALLOY_SHOVEL = registerItem("alloy_shovel", () -> new ShovelItem(ATMTier.ALLOY, new Item.Properties().rarity(Rarity.EPIC).component(DataComponents.UNBREAKABLE, new Unbreakable(true)).fireResistant().attributes(ShovelItem.createAttributes(ATMTier.ALLOY, 1, 1.9F))));
    public static final DeferredHolder<Item, Item> ALLOY_DIGGER = registerItem("alloy_paxel", () -> new ATMPaxel(ATMTier.ALLOY, ToolTiers.ALLOY_TOOL_TAG, new Item.Properties().rarity(Rarity.EPIC).component(DataComponents.UNBREAKABLE, new Unbreakable(true)).fireResistant().attributes(DiggerItem.createAttributes(ATMTier.ALLOY, 5, 2.9F))));


    public static DeferredHolder<Block, Block> registerBlock(String name, Supplier<Block> supplier) {
        return registerBlock(name, supplier, true);
    }
    
    public static DeferredHolder<Block, Block> registerBlock(DeferredRegister<Block> registry, String name, Supplier<Block> supplier) {
        return registerBlock(registry, name, supplier, true);
    }

    public static DeferredHolder<Block, Block> registerBlock(String name, Supplier<Block> supplier, boolean hasItem) {
        return registerBlock(BLOCKS, name, supplier, hasItem);
    }
    
    public static DeferredHolder<Block, Block> registerBlock(DeferredRegister<Block> registry, String name, Supplier<Block> supplier, boolean hasItem) {
        var block = registry.register(name, supplier);
        if (hasItem) {
            registerItem(name, () -> new BlockItem(block.get(), new Item.Properties()));
        }
        return block;
    }

    public static DeferredHolder<Item, Item> registerItem(String name, Supplier<Item> supplier) {
        return ITEMS.register(name, supplier);
    }
}