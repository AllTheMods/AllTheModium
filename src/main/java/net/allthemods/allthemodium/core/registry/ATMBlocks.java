package net.allthemods.allthemodium.core.registry;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.common.blocks.AncientCaveVinesBodyBlock;
import net.allthemods.allthemodium.common.blocks.AncientCaveVinesHeadBlock;
import net.allthemods.allthemodium.common.blocks.AncientGrassBlock;
import net.allthemods.allthemodium.common.blocks.ModiumBrushableBlock;
import net.allthemods.allthemodium.common.blocks.ModiumOreBlock;
import net.allthemods.allthemodium.common.blocks.OtherBlock;
import net.allthemods.allthemodium.common.blocks.OtherBookshelfBlock;
import net.allthemods.allthemodium.common.blocks.OtherLeaveBlock;
import net.allthemods.allthemodium.common.blocks.OtherSaplingBlock;
import net.allthemods.allthemodium.common.blocks.TeleportPad;
import net.allthemods.allthemodium.common.blocks.entity.ModiumBrushableBlockEntity;
import net.allthemods.allthemodium.data.worldgen.ATMConfiguredFeatures;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public class ATMBlocks {
    
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, ATM.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, ATM.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, ATM.MOD_ID);
    
    public static final DeferredHolder<Block, ModiumOreBlock> ALLTHEMODIUM_ORE = ATMBlocks.register("allthemodium_ore", p -> new ModiumOreBlock(UniformInt.of(10, 30), p.sound(SoundType.ANCIENT_DEBRIS).strength(-1, 1500.0f)));
    public static final DeferredHolder<Block, ModiumOreBlock> DEEPSLATE_ALLTHEMODIUM_ORE = ATMBlocks.register("deepslate_allthemodium_ore", p -> new ModiumOreBlock(UniformInt.of(15, 35), p.sound(SoundType.ANCIENT_DEBRIS).strength(-1, 1500.0f)));
    public static final DeferredHolder<Block, ModiumOreBlock> VIBRANIUM_ORE = ATMBlocks.register("vibranium_ore", p -> new ModiumOreBlock(UniformInt.of(20, 40), p.sound(SoundType.NETHER_ORE).strength(-1, 2500.0f)));
    public static final DeferredHolder<Block, ModiumOreBlock> OTHER_VIBRANIUM_ORE = ATMBlocks.register("other_vibranium_ore", p -> new ModiumOreBlock(UniformInt.of(25, 45), p.sound(SoundType.NETHER_ORE).strength(-1, 2500.0f)));
    public static final DeferredHolder<Block, ModiumOreBlock> UNOBTAINIUM_ORE = ATMBlocks.register("unobtainium_ore", p -> new ModiumOreBlock(UniformInt.of(30, 50), p.sound(SoundType.NETHER_GOLD_ORE).strength(-1, 5000.0f)));
    
    public static final DeferredHolder<Block, Block> RAW_ALLTHEMODIUM_BLOCK = ATMBlocks.register("raw_allthemodium_block", p -> new Block(p.strength(3.0F).sound(SoundType.STONE)));
    public static final DeferredHolder<Block, Block> RAW_VIBRANIUM_BLOCK = ATMBlocks.register("raw_vibranium_block", p -> new Block(p.strength(3.0F).sound(SoundType.STONE)));
    public static final DeferredHolder<Block, Block> RAW_UNOBTAINIUM_BLOCK = ATMBlocks.register("raw_unobtainium_block", p -> new Block(p.strength(3.0F).sound(SoundType.STONE)));
    
    public static final DeferredHolder<Block, Block> ALLTHEMODIUM_BLOCK = ATMBlocks.register("allthemodium_block", p -> new Block(p.strength(7.0f).sound(SoundType.METAL)));
    public static final DeferredHolder<Block, Block> VIBRANIUM_BLOCK = ATMBlocks.register("vibranium_block", p -> new Block(p.strength(7.0f).sound(SoundType.METAL)));
    public static final DeferredHolder<Block, Block> UNOBTAINIUM_BLOCK = ATMBlocks.register("unobtainium_block", p -> new Block(p.strength(7.0F).sound(SoundType.METAL)));
    
    public static final DeferredHolder<Block, Block> UNOBTAINIUM_ALLTHEMODIUM_BLOCK = ATMBlocks.register("unobtainium_allthemodium_block", p -> new Block(p.strength(7.0f).sound(SoundType.METAL)));
    public static final DeferredHolder<Block, Block> UNOBTAINIUM_VIBRANIUM_BLOCK = ATMBlocks.register("unobtainium_vibranium_block", p -> new Block(p.strength(7.0f).sound(SoundType.METAL)));
    public static final DeferredHolder<Block, Block> VIBRANIUM_ALLTHEMODIUM_BLOCK = ATMBlocks.register("vibranium_allthemodium_block", p -> new Block(p.strength(7.0F).sound(SoundType.METAL)));
    
    public static final DeferredHolder<Block, Block> PIGLICH_HEART_BLOCK = ATMBlocks.register("piglich_heart_block", p -> new Block(p.sound(SoundType.AMETHYST)));
    
    public static final DeferredHolder<Block, AncientCaveVinesBodyBlock> ANCIENT_CAVE_VINES_PLANT = ATMBlocks.BLOCKS.register("ancient_cave_vines_plant", k -> new AncientCaveVinesBodyBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, k))));
    public static final DeferredHolder<Block, AncientCaveVinesHeadBlock> ANCIENT_CAVE_VINES = ATMBlocks.BLOCKS.register("ancient_cave_vines", k -> new AncientCaveVinesHeadBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, k))));
    
    public static final DeferredHolder<Block, Block> ANCIENT_DIRT = ATMBlocks.register("ancient_dirt", p -> new Block(p.sound(SoundType.WET_GRASS).strength(0.6F)));
    public static final DeferredHolder<Block, AncientGrassBlock> ANCIENT_GRASS = ATMBlocks.register("ancient_grass", p -> new AncientGrassBlock(p.randomTicks().sound(SoundType.MOSS).strength(0.6F)));
    
    public static final DeferredHolder<Block, OtherSaplingBlock> ANCIENT_SAPLING = ATMBlocks.register("ancient_sapling", p -> new OtherSaplingBlock(
            new TreeGrower("ancient_tree", 0.9F, Optional.empty(), Optional.empty(), Optional.of(ATMConfiguredFeatures.ANCIENT_TREE), Optional.empty(), Optional.empty(), Optional.empty()),
            p.mapColor(MapColor.PLANT).noCollision().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY))
    );
    public static final DeferredHolder<Block, TallFlowerBlock> ANCIENT_HERB = ATMBlocks.register("ancient_herb", p -> new TallFlowerBlock(p.sound(SoundType.WET_GRASS).instabreak().noCollision()));
    public static final DeferredHolder<Block, RotatedPillarBlock> ANCIENT_LOG_0 = ATMBlocks.register("ancient_log_0", p -> new RotatedPillarBlock(p.sound(SoundType.WOOD).strength(2.0F)));
    public static final DeferredHolder<Block, RotatedPillarBlock> ANCIENT_LOG_1 = ATMBlocks.register("ancient_log_1", p -> new RotatedPillarBlock(p.sound(SoundType.WOOD).strength(2.0F)));
    public static final DeferredHolder<Block, RotatedPillarBlock> ANCIENT_LOG_2 = ATMBlocks.register("ancient_log_2", p -> new RotatedPillarBlock(p.sound(SoundType.WOOD).strength(2.0F)));
    public static final DeferredHolder<Block, RotatedPillarBlock> STRIPPED_ANCIENT_LOG = ATMBlocks.register("stripped_ancient_log", p -> new RotatedPillarBlock(p.sound(SoundType.WOOD).strength(2.0F)));
    public static final DeferredHolder<Block, OtherLeaveBlock.Ancient> ANCIENT_LEAVES = ATMBlocks.register("ancient_leaves", p -> new OtherLeaveBlock.Ancient(p.strength(0.2F).randomTicks().sound(SoundType.AZALEA_LEAVES).noOcclusion().mapColor(DyeColor.PURPLE)));
    public static final DeferredHolder<Block, OtherLeaveBlock.Ancient> ANCIENT_LEAVES_BOTTOM = ATMBlocks.register("ancient_leaves_bottom", p -> new OtherLeaveBlock.Ancient(p.strength(0.2F).sound(SoundType.AZALEA_LEAVES).noOcclusion().mapColor(DyeColor.PURPLE)));
    public static final DeferredHolder<Block, Block> ANCIENT_PLANKS = ATMBlocks.register("ancient_planks", p -> new Block(p.strength(0.8F).randomTicks().sound(SoundType.WOOD)));
    public static final DeferredHolder<Block, TrapDoorBlock> ANCIENT_TRAPDOOR = ATMBlocks.register("ancient_trapdoor", p -> new TrapDoorBlock(ATMBlockSets.ANCIENT, p.strength(0.2F).randomTicks().sound(SoundType.WOOD).noOcclusion()));
    public static final DeferredHolder<Block, FenceBlock> ANCIENT_FENCE = ATMBlocks.register("ancient_fence", p -> new FenceBlock(p.strength(0.8F).dynamicShape().sound(SoundType.WOOD)));
    public static final DeferredHolder<Block, FenceGateBlock> ANCIENT_FENCE_GATE = ATMBlocks.register("ancient_fence_gate", p -> new FenceGateBlock(ATMBlockSets.ANCIENT_WOOD, p.strength(0.8F).dynamicShape().sound(SoundType.WOOD)));
    public static final DeferredHolder<Block, DoorBlock> ANCIENT_DOOR = ATMBlocks.register("ancient_door", p -> new DoorBlock(ATMBlockSets.ANCIENT, p.strength(2.0F).sound(SoundType.WOOD)));
    public static final DeferredHolder<Block, OtherBookshelfBlock> ANCIENT_BOOKSHELF = ATMBlocks.register("ancient_bookshelf", p -> new OtherBookshelfBlock(p.strength(0.8F).randomTicks().sound(SoundType.WOOD)));
    public static final DeferredHolder<Block, StairBlock> ANCIENT_STAIRS = ATMBlocks.register("ancient_stairs", p -> new StairBlock(ATMBlocks.ANCIENT_PLANKS.get().defaultBlockState(), p), () -> ATMBlocks.ANCIENT_PLANKS.get().properties());
    public static final DeferredHolder<Block, SlabBlock> ANCIENT_SLAB = ATMBlocks.register("ancient_slab", SlabBlock::new, () -> ATMBlocks.ANCIENT_PLANKS.get().properties());
    
    public static final DeferredHolder<Block, Block> ANCIENT_STONE = ATMBlocks.register("ancient_stone", p -> new Block(p.sound(SoundType.STONE).isRedstoneConductor((state, level, pos) -> false).strength(1.5f)));
    public static final DeferredHolder<Block, Block> SMOOTH_ANCIENT_STONE = ATMBlocks.register("smooth_ancient_stone", p -> new Block(p.sound(SoundType.STONE).isRedstoneConductor((state, level, pos) -> false).strength(2.25f)));
    public static final DeferredHolder<Block, Block> MOSSY_ANCIENT_STONE = ATMBlocks.register("mossy_ancient_stone", p -> new Block(p.sound(SoundType.MOSS_CARPET).isRedstoneConductor((state, level, pos) -> false).strength(1.5f)));
    public static final DeferredHolder<Block, OtherBlock> ANCIENT_STONE_BRICKS = ATMBlocks.register("ancient_stone_bricks", OtherBlock::new);
    public static final DeferredHolder<Block, OtherBlock> CHISELED_ANCIENT_STONE_BRICKS = ATMBlocks.register("chiseled_ancient_stone_bricks", OtherBlock::new);
    public static final DeferredHolder<Block, OtherBlock> CRACKED_ANCIENT_STONE_BRICKS = ATMBlocks.register("cracked_ancient_stone_bricks", OtherBlock::new);
    public static final DeferredHolder<Block, OtherBlock> POLISHED_ANCIENT_STONE = ATMBlocks.register("polished_ancient_stone", OtherBlock::new);
    public static final DeferredHolder<Block, WallBlock> ANCIENT_STONE_WALL = ATMBlocks.register("ancient_stone_wall", WallBlock::new, () -> ATMBlocks.ANCIENT_STONE.get().properties());
    public static final DeferredHolder<Block, WallBlock> SMOOTH_ANCIENT_STONE_WALL = ATMBlocks.register("smooth_ancient_stone_wall", WallBlock::new, () -> ATMBlocks.SMOOTH_ANCIENT_STONE.get().properties());
    public static final DeferredHolder<Block, WallBlock> MOSSY_ANCIENT_STONE_WALL = ATMBlocks.register("mossy_ancient_stone_wall", WallBlock::new, () -> ATMBlocks.MOSSY_ANCIENT_STONE.get().properties());
    public static final DeferredHolder<Block, WallBlock> ANCIENT_STONE_BRICK_WALL = ATMBlocks.register("ancient_stone_brick_wall", WallBlock::new, () -> ATMBlocks.ANCIENT_STONE_BRICKS.get().properties());
    public static final DeferredHolder<Block, WallBlock> CHISELED_ANCIENT_STONE_BRICK_WALL = ATMBlocks.register("chiseled_ancient_stone_brick_wall", WallBlock::new, () -> ATMBlocks.CHISELED_ANCIENT_STONE_BRICKS.get().properties());
    public static final DeferredHolder<Block, WallBlock> CRACKED_ANCIENT_STONE_BRICK_WALL = ATMBlocks.register("cracked_ancient_stone_brick_wall", WallBlock::new, () -> ATMBlocks.CRACKED_ANCIENT_STONE_BRICKS.get().properties());
    public static final DeferredHolder<Block, WallBlock> POLISHED_ANCIENT_STONE_WALL = ATMBlocks.register("polished_ancient_stone_wall", WallBlock::new, () -> ATMBlocks.POLISHED_ANCIENT_STONE.get().properties());
    public static final DeferredHolder<Block, StairBlock> ANCIENT_STONE_STAIRS = ATMBlocks.register("ancient_stone_stairs", p -> new StairBlock(ATMBlocks.ANCIENT_STONE.get().defaultBlockState(), p), () -> ATMBlocks.ANCIENT_STONE.get().properties());
    public static final DeferredHolder<Block, StairBlock> SMOOTH_ANCIENT_STONE_STAIRS = ATMBlocks.register("smooth_ancient_stone_stairs", p -> new StairBlock(ATMBlocks.SMOOTH_ANCIENT_STONE.get().defaultBlockState(), p), () -> ATMBlocks.SMOOTH_ANCIENT_STONE.get().properties());
    public static final DeferredHolder<Block, StairBlock> MOSSY_ANCIENT_STONE_STAIRS = ATMBlocks.register("mossy_ancient_stone_stairs", p -> new StairBlock(ATMBlocks.MOSSY_ANCIENT_STONE.get().defaultBlockState(), p), () -> ATMBlocks.MOSSY_ANCIENT_STONE.get().properties());
    public static final DeferredHolder<Block, StairBlock> ANCIENT_STONE_BRICK_STAIRS = ATMBlocks.register("ancient_stone_brick_stairs", p -> new StairBlock(ATMBlocks.ANCIENT_STONE_BRICKS.get().defaultBlockState(), p), () -> ATMBlocks.ANCIENT_STONE_BRICKS.get().properties());
    public static final DeferredHolder<Block, StairBlock> CHISELED_ANCIENT_STONE_BRICK_STAIRS = ATMBlocks.register("chiseled_ancient_stone_brick_stairs", p -> new StairBlock(ATMBlocks.CHISELED_ANCIENT_STONE_BRICKS.get().defaultBlockState(), p), () -> ATMBlocks.CHISELED_ANCIENT_STONE_BRICKS.get().properties());
    public static final DeferredHolder<Block, StairBlock> CRACKED_ANCIENT_STONE_BRICK_STAIRS = ATMBlocks.register("cracked_ancient_stone_brick_stairs", p -> new StairBlock(ATMBlocks.CRACKED_ANCIENT_STONE_BRICKS.get().defaultBlockState(), p), () -> ATMBlocks.CRACKED_ANCIENT_STONE_BRICKS.get().properties());
    public static final DeferredHolder<Block, StairBlock> POLISHED_ANCIENT_STONE_STAIRS = ATMBlocks.register("polished_ancient_stone_stairs", p -> new StairBlock(ATMBlocks.POLISHED_ANCIENT_STONE.get().defaultBlockState(), p), () -> ATMBlocks.POLISHED_ANCIENT_STONE.get().properties());
    public static final DeferredHolder<Block, SlabBlock> ANCIENT_STONE_SLAB = ATMBlocks.register("ancient_stone_slab", SlabBlock::new, () -> ATMBlocks.ANCIENT_STONE.get().properties());
    public static final DeferredHolder<Block, SlabBlock> SMOOTH_ANCIENT_STONE_SLAB = ATMBlocks.register("smooth_ancient_stone_slab", SlabBlock::new, () -> ATMBlocks.SMOOTH_ANCIENT_STONE.get().properties());
    public static final DeferredHolder<Block, SlabBlock> MOSSY_ANCIENT_STONE_SLAB = ATMBlocks.register("mossy_ancient_stone_slab", SlabBlock::new, () -> ATMBlocks.MOSSY_ANCIENT_STONE.get().properties());
    public static final DeferredHolder<Block, SlabBlock> ANCIENT_STONE_BRICK_SLAB = ATMBlocks.register("ancient_stone_brick_slab", SlabBlock::new, () -> ATMBlocks.ANCIENT_STONE_BRICKS.get().properties());
    public static final DeferredHolder<Block, SlabBlock> CHISELED_ANCIENT_STONE_BRICK_SLAB = ATMBlocks.register("chiseled_ancient_stone_brick_slab", SlabBlock::new, () -> ATMBlocks.CHISELED_ANCIENT_STONE_BRICKS.get().properties());
    public static final DeferredHolder<Block, SlabBlock> CRACKED_ANCIENT_STONE_BRICK_SLAB = ATMBlocks.register("cracked_ancient_stone_brick_slab", SlabBlock::new, () -> ATMBlocks.CRACKED_ANCIENT_STONE_BRICKS.get().properties());
    public static final DeferredHolder<Block, SlabBlock> POLISHED_ANCIENT_STONE_SLAB = ATMBlocks.register("polished_ancient_stone_slab", SlabBlock::new, () -> ATMBlocks.POLISHED_ANCIENT_STONE.get().properties());
    
    public static final DeferredHolder<Block, OtherSaplingBlock> SOUL_SAPLING = ATMBlocks.register("soul_sapling", p -> new OtherSaplingBlock(
            new TreeGrower("soul_tree", 0.9F, Optional.empty(), Optional.empty(), Optional.of(ATMConfiguredFeatures.SOUL_TREE), Optional.empty(), Optional.empty(), Optional.empty()),
            p.mapColor(MapColor.PLANT).noCollision().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY))
    );
    public static final DeferredHolder<Block, TallFlowerBlock> SOUL_HERB = ATMBlocks.register("soul_herb", p -> new TallFlowerBlock(p.sound(SoundType.WET_GRASS).instabreak().noCollision()));
    public static final DeferredHolder<Block, RotatedPillarBlock> SOUL_LOG_0 = ATMBlocks.register("soul_log_0", p -> new RotatedPillarBlock(p.sound(SoundType.WOOD).strength(2.0F).mapColor(DyeColor.LIGHT_BLUE)));
    public static final DeferredHolder<Block, RotatedPillarBlock> SOUL_LOG_1 = ATMBlocks.register("soul_log_1", p -> new RotatedPillarBlock(p.sound(SoundType.WOOD).strength(2.0F).mapColor(DyeColor.LIGHT_BLUE)));
    public static final DeferredHolder<Block, RotatedPillarBlock> SOUL_LOG_2 = ATMBlocks.register("soul_log_2", p -> new RotatedPillarBlock(p.sound(SoundType.WOOD).strength(2.0F).mapColor(DyeColor.LIGHT_BLUE)));
    public static final DeferredHolder<Block, RotatedPillarBlock> STRIPPED_SOUL_LOG = ATMBlocks.register("stripped_soul_log", p -> new RotatedPillarBlock(p.sound(SoundType.WOOD).strength(2.0F).mapColor(DyeColor.LIGHT_BLUE)));
    public static final DeferredHolder<Block, OtherLeaveBlock.Soul> SOUL_LEAVES = ATMBlocks.register("soul_leaves", p -> new OtherLeaveBlock.Soul(p.strength(0.2F).randomTicks().sound(SoundType.AZALEA_LEAVES).noOcclusion()));
    public static final DeferredHolder<Block, OtherLeaveBlock.Soul> SOUL_LEAVES_BOTTOM = ATMBlocks.register("soul_leaves_bottom", p -> new OtherLeaveBlock.Soul(p.strength(0.2F).sound(SoundType.AZALEA_LEAVES).noCollision().noOcclusion()));
    public static final DeferredHolder<Block, Block> SOUL_PLANKS = ATMBlocks.register("soul_planks", p -> new Block(p.strength(0.8F).randomTicks().sound(SoundType.WOOD)));
    public static final DeferredHolder<Block, TrapDoorBlock> SOUL_TRAPDOOR = ATMBlocks.register("soul_trapdoor", p -> new TrapDoorBlock(ATMBlockSets.SOUL, p.strength(0.2F).randomTicks().sound(SoundType.WOOD).noOcclusion()));
    public static final DeferredHolder<Block, FenceBlock> SOUL_FENCE = ATMBlocks.register("soul_fence", p -> new FenceBlock(p.strength(0.8F).dynamicShape().sound(SoundType.WOOD)));
    public static final DeferredHolder<Block, FenceGateBlock> SOUL_FENCE_GATE = ATMBlocks.register("soul_fence_gate", p -> new FenceGateBlock(ATMBlockSets.SOUL_WOOD, p.strength(0.8F).dynamicShape().sound(SoundType.WOOD)));
    public static final DeferredHolder<Block, DoorBlock> SOUL_DOOR = ATMBlocks.register("soul_door", p -> new DoorBlock(ATMBlockSets.SOUL, p.strength(2.0F).sound(SoundType.WOOD)));
    public static final DeferredHolder<Block, OtherBookshelfBlock> SOUL_BOOKSHELF = ATMBlocks.register("soul_bookshelf", p -> new OtherBookshelfBlock(p.strength(0.8F).randomTicks().sound(SoundType.WOOD)));
    public static final DeferredHolder<Block, StairBlock> SOUL_STAIRS = ATMBlocks.register("soul_stairs", p -> new StairBlock(ATMBlocks.SOUL_PLANKS.get().defaultBlockState(), p), () -> ATMBlocks.SOUL_PLANKS.get().properties());
    public static final DeferredHolder<Block, SlabBlock> SOUL_SLAB = ATMBlocks.register("soul_slab", SlabBlock::new, () -> ATMBlocks.SOUL_PLANKS.get().properties());
    
    public static final DeferredHolder<Block, OtherSaplingBlock> DEMONIC_SAPLING = ATMBlocks.register("demonic_sapling", p -> new OtherSaplingBlock(
            new TreeGrower("demonic_tree", 0.9F, Optional.empty(), Optional.empty(), Optional.of(ATMConfiguredFeatures.DEMONIC_TREE), Optional.empty(), Optional.empty(), Optional.empty()),
            p.mapColor(MapColor.PLANT).noCollision().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY))
    );
    public static final DeferredHolder<Block, TallFlowerBlock> DEMONIC_HERB = ATMBlocks.register("demonic_herb", p -> new TallFlowerBlock(p.sound(SoundType.WET_GRASS).instabreak().noCollision()));
    public static final DeferredHolder<Block, RotatedPillarBlock> DEMONIC_LOG = ATMBlocks.register("demonic_log", p -> new RotatedPillarBlock(p.sound(SoundType.WOOD).strength(2.0F).mapColor(DyeColor.RED)));
    public static final DeferredHolder<Block, RotatedPillarBlock> STRIPPED_DEMONIC_LOG = ATMBlocks.register("stripped_demonic_log", p -> new RotatedPillarBlock(p.sound(SoundType.WOOD).strength(2.0F).mapColor(DyeColor.RED)));
    public static final DeferredHolder<Block, OtherLeaveBlock.Demonic> DEMONIC_LEAVES = ATMBlocks.register("demonic_leaves", p -> new OtherLeaveBlock.Demonic(p.strength(0.2F).randomTicks().sound(SoundType.AZALEA_LEAVES).noOcclusion()));
    public static final DeferredHolder<Block, OtherLeaveBlock.Demonic> DEMONIC_LEAVES_BOTTOM = ATMBlocks.register("demonic_leaves_bottom", p -> new OtherLeaveBlock.Demonic(p.strength(0.2F).sound(SoundType.AZALEA_LEAVES).noCollision().noOcclusion()));
    public static final DeferredHolder<Block, Block> DEMONIC_PLANKS = ATMBlocks.register("demonic_planks", p -> new Block(p.strength(0.8F).randomTicks().sound(SoundType.WOOD)));
    public static final DeferredHolder<Block, TrapDoorBlock> DEMONIC_TRAPDOOR = ATMBlocks.register("demonic_trapdoor", p -> new TrapDoorBlock(ATMBlockSets.DEMONIC, p.strength(0.2F).randomTicks().sound(SoundType.WOOD).noOcclusion()));
    public static final DeferredHolder<Block, FenceBlock> DEMONIC_FENCE = ATMBlocks.register("demonic_fence", p -> new FenceBlock(p.strength(0.8F).dynamicShape().sound(SoundType.WOOD)));
    public static final DeferredHolder<Block, FenceGateBlock> DEMONIC_FENCE_GATE = ATMBlocks.register("demonic_fence_gate", p -> new FenceGateBlock(ATMBlockSets.DEMONIC_WOOD, p.strength(0.8F).dynamicShape().sound(SoundType.WOOD)));
    public static final DeferredHolder<Block, DoorBlock> DEMONIC_DOOR = ATMBlocks.register("demonic_door", p -> new DoorBlock(ATMBlockSets.DEMONIC, p.strength(2.0F).sound(SoundType.WOOD)));
    public static final DeferredHolder<Block, OtherBookshelfBlock> DEMONIC_BOOKSHELF = ATMBlocks.register("demonic_bookshelf", p -> new OtherBookshelfBlock(p.strength(0.8F).randomTicks().sound(SoundType.WOOD)));
    public static final DeferredHolder<Block, StairBlock> DEMONIC_STAIRS = ATMBlocks.register("demonic_stairs", p -> new StairBlock(ATMBlocks.DEMONIC_PLANKS.get().defaultBlockState(), p), () -> ATMBlocks.DEMONIC_PLANKS.get().properties());
    public static final DeferredHolder<Block, SlabBlock> DEMONIC_SLAB = ATMBlocks.register("demonic_slab", SlabBlock::new, () -> ATMBlocks.DEMONIC_PLANKS.get().properties());
    
    public static final DeferredHolder<Block, ModiumBrushableBlock> SUS_CLAY = ATMBlocks.register("suspicious_clay", p -> new ModiumBrushableBlock(Blocks.CLAY, SoundEvents.BRUSH_SAND, SoundEvents.BRUSH_SAND_COMPLETED,
            p.mapColor(MapColor.SAND).instrument(NoteBlockInstrument.SNARE).strength(0.25F).sound(SoundType.SUSPICIOUS_SAND).pushReaction(PushReaction.DESTROY))
    );
    public static final DeferredHolder<Block, ModiumBrushableBlock> SUS_SOUL_SAND = ATMBlocks.register("suspicious_soul_sand", p -> new ModiumBrushableBlock(Blocks.SOUL_SAND, SoundEvents.BRUSH_SAND, SoundEvents.BRUSH_SAND_COMPLETED,
            p.mapColor(MapColor.SAND).instrument(NoteBlockInstrument.SNARE).strength(0.25F).sound(SoundType.SUSPICIOUS_SAND).pushReaction(PushReaction.DESTROY))
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ModiumBrushableBlockEntity>> BRUSHABLE_BLOCK = ATMBlocks.BLOCK_ENTITIES.register("brushable_block", () -> new BlockEntityType<>(ModiumBrushableBlockEntity::new, ATMBlocks.SUS_CLAY.get(), ATMBlocks.SUS_SOUL_SAND.get()));
    
    public static final DeferredHolder<Block, TeleportPad> TELEPORT_PAD = ATMBlocks.register("teleport_pad", TeleportPad::new);
    
    private static <T extends Block> DeferredHolder<Block, T> register(String name, Function<BlockBehaviour.Properties, T> factory) {
        return ATMBlocks.register(name, factory, BlockBehaviour.Properties::of);
    }
    
    private static <T extends Block> DeferredHolder<Block, T> register(String name, Function<BlockBehaviour.Properties, T> factory, Supplier<BlockBehaviour.Properties> properties) {
        DeferredHolder<Block, T> holder = ATMBlocks.BLOCKS.register(name, k -> factory.apply(properties.get().setId(ResourceKey.create(Registries.BLOCK, k))));
        ATMBlocks.ITEMS.register(name, k -> new BlockItem(holder.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, k)).useBlockDescriptionPrefix()));
        return holder;
    }
    
    public static void register(final IEventBus bus) {
        ATMBlocks.BLOCKS.register(bus);
        ATMBlocks.ITEMS.register(bus);
        ATMBlocks.BLOCK_ENTITIES.register(bus);
    }
}
