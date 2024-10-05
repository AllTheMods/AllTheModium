package com.thevortex.allthemodium.registry;

import com.thevortex.allthemodium.AllTheModium;
import com.thevortex.allthemodium.blocks.*;
import com.thevortex.allthemodium.blocks.AllthemodiumBlock;
import com.thevortex.allthemodium.blocks.AllthemodiumOre;
import com.thevortex.allthemodium.blocks.TeleportPad;
import com.thevortex.allthemodium.blocks.UnobtainiumBlock;
import com.thevortex.allthemodium.blocks.UnobtainiumOre;
import com.thevortex.allthemodium.blocks.VibraniumBlock;
import com.thevortex.allthemodium.blocks.VibraniumOre;
import com.thevortex.allthemodium.entity.PiglichEntity;
import com.thevortex.allthemodium.init.ModFoods;
import com.thevortex.allthemodium.items.*;
import com.thevortex.allthemodium.items.toolitems.armor.*;
import com.thevortex.allthemodium.material.AArmorMaterial;
import com.thevortex.allthemodium.material.ToolTiers;
import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.worldgen.biomes.ATMBiomes;
import com.thevortex.allthemodium.worldgen.features.*;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSource;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.server.command.TextComponentHelper;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModRegistry {

    public static final DeferredRegister<Block> SHAPED_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            Reference.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            Reference.MOD_ID);
    public static final DeferredRegister<Block> STAIR_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            Reference.MOD_ID);
    public static final DeferredRegister<Block> WALL_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            Reference.MOD_ID);
    public static final DeferredRegister<Block> SLAB_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            Reference.MOD_ID);
    public static final DeferredRegister<Block> PILLAR_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            Reference.MOD_ID);
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES,
            Reference.MOD_ID);

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
            ForgeRegistries.ITEMS,
            Reference.MOD_ID);

    public static final DeferredRegister<BlockEntityType<?>> ENTITY = DeferredRegister.create(
            ForgeRegistries.BLOCK_ENTITY_TYPES,
            Reference.MOD_ID);
    public static final DeferredRegister<WorldCarver<?>> CARVERS = DeferredRegister.create(
            ForgeRegistries.WORLD_CARVERS,
            Reference.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES,
            Reference.MOD_ID);

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES,
            Reference.MOD_ID);

    // TODO: Add spawn eggs for mobs
    // private static ArrayList<Item> SPAWN_EGGS = new ArrayList<Item>()

    // BIOMES

    RegistryObject<Biome> MINING = BIOMES.register(
            "mining",
            () -> ATMBiomes.mining());
    RegistryObject<Biome> THE_OTHER = BIOMES.register(
            "the_other",
            () -> ATMBiomes.the_other());
    RegistryObject<Biome> DESERT = BIOMES.register(
            "desert",
            () -> ATMBiomes.desert());
    RegistryObject<Biome> DESERT_HILLS = BIOMES.register(
            "desert_hills",
            () -> ATMBiomes.desert_hills());
    RegistryObject<Biome> SOULSAND = BIOMES.register(
            "soul_sand_valley",
            () -> ATMBiomes.soul_sand_valley());
    RegistryObject<Biome> WARPED_FOREST = BIOMES.register(
            "warped_forest",
            () -> ATMBiomes.warped_forest());
    RegistryObject<Biome> CRIMSON_FOREST = BIOMES.register(
            "crimson_forest",
            () -> ATMBiomes.crimson_forest());
    RegistryObject<Biome> BASALT_DELTAS = BIOMES.register(
            "basalt_deltas",
            () -> ATMBiomes.basalt_deltas());

    // FOOD

    public static RegistryObject<Item> ALLTHEMODIUM_APPLE = ITEMS.register(
            "allthemodium_apple",
            () -> new AllthemodiumApple(
                    new Item.Properties()
                            .tab(AllTheModium.GROUP)
                            .fireResistant()
                            .food(ModFoods.ALLTHEMODIUM_APPLE)
                            .rarity(Rarity.EPIC)));
    public static RegistryObject<Item> ALLTHEMODIUM_CARROT = ITEMS.register(
            "allthemodium_carrot",
            () -> new AllthemodiumCarrot(
                    new Item.Properties()
                            .tab(AllTheModium.GROUP)
                            .fireResistant()
                            .food(ModFoods.ALLTHEMODIUM_CARROT)
                            .rarity(Rarity.EPIC)));

    // ARMORS

    public static RegistryObject<ArmorItem> ALLTHEMODIUM_BOOTS = ITEMS.register(
            "allthemodium_boots",
            () -> (ArmorItem) new AllthemodiumBoots(
                    AArmorMaterial.ALLTHEMODIUM,
                    EquipmentSlot.FEET,
                    new Item.Properties()
                            .tab(AllTheModium.GROUP)
                            .stacksTo(1)
                            .fireResistant()
                            .rarity(Rarity.EPIC)));
    public static RegistryObject<ArmorItem> ALLTHEMODIUM_LEGGINGS = ITEMS.register(
            "allthemodium_leggings",
            () -> (ArmorItem) new AllthemodiumLeggings(
                    AArmorMaterial.ALLTHEMODIUM,
                    EquipmentSlot.LEGS,
                    new Item.Properties()
                            .tab(AllTheModium.GROUP)
                            .stacksTo(1)
                            .fireResistant()
                            .rarity(Rarity.EPIC)));
    public static RegistryObject<ArmorItem> ALLTHEMODIUM_CHESTPLATE = ITEMS.register(
            "allthemodium_chestplate",
            () -> (ArmorItem) new AllthemodiumChestplate(
                    AArmorMaterial.ALLTHEMODIUM,
                    EquipmentSlot.CHEST,
                    new Item.Properties()
                            .tab(AllTheModium.GROUP)
                            .stacksTo(1)
                            .fireResistant()
                            .rarity(Rarity.EPIC)));
    public static RegistryObject<ArmorItem> ALLTHEMODIUM_HELMET = ITEMS.register(
            "allthemodium_helmet",
            () -> (ArmorItem) new AllthemodiumHelmet(
                    AArmorMaterial.ALLTHEMODIUM,
                    EquipmentSlot.HEAD,
                    new Item.Properties()
                            .tab(AllTheModium.GROUP)
                            .stacksTo(1)
                            .fireResistant()
                            .rarity(Rarity.EPIC)));

    // Volcano

    public static Feature<VolcanoConfig> VOLCANO_F = new Volcano(
            VolcanoConfig.CODEC);
    public static RegistryObject<Feature<VolcanoConfig>> VOLCANO = FEATURES.register("volcano", () -> VOLCANO_F);

    public static final RegistryObject<AncientCaveVines> ANCIENT_CAVEVINES_ = PILLAR_BLOCKS.register(
            "ancient_cavevines",
            () -> new AncientCaveVines(
                    BlockBehaviour.Properties
                            .of(Material.PLANT)
                            .randomTicks()
                            .noCollission()
                            .noOcclusion()
                            .lightLevel(ACaveVines.emission(14))
                            .instabreak()
                            .sound(SoundType.CAVE_VINES),
                    Direction.DOWN,
                    ACaveVines.SHAPE,
                    false,
                    0.1D));

    public static final RegistryObject<AncientCaveVinesPlant> ANCIENT_CAVEVINES_PLANT_ = PILLAR_BLOCKS.register(
            "ancient_cavevines_plant",
            () -> new AncientCaveVinesPlant(
                    BlockBehaviour.Properties
                            .of(Material.PLANT)
                            .noCollission()
                            .noOcclusion()
                            .lightLevel(ACaveVines.emission(14))
                            .instabreak()
                            .sound(SoundType.CAVE_VINES),
                    Direction.DOWN,
                    ACaveVines.SHAPE,
                    false));

    public static final RegistryObject<Block> ANCIENT_HERB = PILLAR_BLOCKS.register(
            "ancient_herb",
            () -> new AncientHerb(
                    BlockBehaviour.Properties
                            .of(Material.GRASS)
                            .sound(SoundType.WET_GRASS)
                            .instabreak()
                            .noCollission()));

    public static final RegistryObject<Block> ANCIENT_SMOOTH_STONE = BLOCKS.register(
            "ancient_smooth_stone",
            () -> new Block(
                    BlockBehaviour.Properties
                            .of(Material.STONE)
                            .sound(SoundType.STONE)
                            .strength(2.25f)));
    public static final RegistryObject<Block> ANCIENT_STONE = BLOCKS.register(
            "ancient_stone",
            () -> new Block(
                    BlockBehaviour.Properties
                            .of(Material.STONE)
                            .sound(SoundType.STONE)
                            .strength(1.5f)));
    public static final RegistryObject<Block> ANCIENT_DIRT = BLOCKS.register(
            "ancient_dirt",
            () -> new AncientDirt(
                    BlockBehaviour.Properties
                            .of(Material.DIRT)
                            .sound(SoundType.WET_GRASS)
                            .strength(0.6f)));
    public static final RegistryObject<Block> ANCIENT_GRASS = BLOCKS.register(
            "ancient_grass",
            () -> new AncientGrass(
                    BlockBehaviour.Properties
                            .of(Material.DIRT)
                            .sound(SoundType.MOSS)
                            .strength(0.6f)));
    public static final RegistryObject<Block> ANCIENT_MOSSY_STONE = BLOCKS.register(
            "ancient_mossy_stone",
            () -> new Block(
                    BlockBehaviour.Properties
                            .of(Material.STONE)
                            .sound(SoundType.MOSS_CARPET)
                            .strength(1.5f)));
    public static final RegistryObject<Block> ANCIENT_STONE_BRICKS = BLOCKS.register(
            "ancient_stone_bricks",
            () -> new Block(
                    BlockBehaviour.Properties
                            .of(Material.STONE)
                            .sound(SoundType.NETHER_BRICKS)
                            .strength(3.5f)));
    public static final RegistryObject<Block> ANCIENT_CHISELED_STONE_BRICKS = BLOCKS.register(
            "ancient_chiseled_stone_bricks",
            () -> new Block(
                    BlockBehaviour.Properties
                            .of(Material.STONE)
                            .sound(SoundType.NETHER_BRICKS)
                            .strength(3.0f)));
    public static final RegistryObject<Block> ANCIENT_CRACKED_STONE_BRICKS = BLOCKS.register(
            "ancient_cracked_stone_bricks",
            () -> new Block(
                    BlockBehaviour.Properties
                            .of(Material.STONE)
                            .sound(SoundType.NETHER_BRICKS)
                            .strength(3.25f)));
    public static final RegistryObject<Block> ANCIENT_POLISHED_STONE = BLOCKS.register(
            "ancient_polished_stone",
            () -> new Block(
                    BlockBehaviour.Properties
                            .of(Material.STONE)
                            .sound(SoundType.METAL)
                            .strength(2.5f)));

    public static final RegistryObject<Block> ANCIENT_LOG_0 = PILLAR_BLOCKS.register(
            "ancient_log_0",
            () -> log(MaterialColor.WOOD, MaterialColor.WOOD));
    public static final RegistryObject<Block> ANCIENT_LOG_1 = PILLAR_BLOCKS.register(
            "ancient_log_1",
            () -> log(MaterialColor.WOOD, MaterialColor.WOOD));
    public static final RegistryObject<Block> ANCIENT_LOG_2 = PILLAR_BLOCKS.register(
            "ancient_log_2",
            () -> log(MaterialColor.WOOD, MaterialColor.WOOD));
    public static final RegistryObject<Block> ANCIENT_LOG_STRIPPED = PILLAR_BLOCKS.register(
            "stripped_ancient_log",
            () -> log(MaterialColor.WOOD, MaterialColor.WOOD));
    public static final RegistryObject<Block> ANCIENT_LEAVES = BLOCKS.register(
            "ancient_leaves",
            () -> new AncientLeaves(
                    BlockBehaviour.Properties
                            .of(Material.LEAVES)
                            .strength(0.2F)
                            .randomTicks()
                            .sound(SoundType.AZALEA_LEAVES)
                            .noOcclusion()
                            .color(MaterialColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> ANCIENT_LEAVES_BOTTOM = PILLAR_BLOCKS.register(
            "ancient_leaves_bottom",
            () -> new AncientLeavesBottom(
                    BlockBehaviour.Properties
                            .of(Material.LEAVES)
                            .strength(0.2F)
                            .randomTicks()
                            .sound(SoundType.AZALEA_LEAVES)
                            .noCollission()
                            .noOcclusion()
                            .color(MaterialColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> ANCIENT_PLANKS = BLOCKS.register(
            "ancient_planks",
            () -> new Block(
                    BlockBehaviour.Properties
                            .of(Material.NETHER_WOOD)
                            .strength(0.8F)
                            .randomTicks()
                            .sound(SoundType.WOOD)));
    public static final RegistryObject<TrapDoorBlock> ANCIENT_TRAPDOOR = PILLAR_BLOCKS.register(
            "ancient_trap_door",
            () -> new TrapDoorBlock(
                    BlockBehaviour.Properties
                            .of(Material.NETHER_WOOD)
                            .strength(0.2F)
                            .randomTicks()
                            .sound(SoundType.WOOD)
                            .noOcclusion()));
    public static final RegistryObject<FenceBlock> ANCIENT_WOOD_FENCE = PILLAR_BLOCKS.register(
            "ancient_wooden_fence",
            () -> new FenceBlock(
                    BlockBehaviour.Properties
                            .of(Material.NETHER_WOOD)
                            .strength(0.8F)
                            .dynamicShape()
                            .sound(SoundType.WOOD)));
    public static final RegistryObject<FenceGateBlock> ANCIENT_WOOD_FENCE_GATE = PILLAR_BLOCKS.register(
            "ancient_wooden_fence_gate",
            () -> new FenceGateBlock(
                    BlockBehaviour.Properties
                            .of(Material.NETHER_WOOD)
                            .strength(0.8F)
                            .dynamicShape()
                            .sound(SoundType.WOOD)));
    public static final RegistryObject<DoorBlock> ANCIENT_DOOR_ = PILLAR_BLOCKS.register(
            "ancient_door",
            () -> new DoorBlock(
                    BlockBehaviour.Properties
                            .of(Material.NETHER_WOOD)
                            .strength(2.0F)
                            .sound(SoundType.WOOD)));

    public static final RegistryObject<Block> DEMONIC_HERB = PILLAR_BLOCKS.register(
            "demonic_herb",
            () -> new AncientHerb(
                    BlockBehaviour.Properties
                            .of(Material.GRASS)
                            .sound(SoundType.WET_GRASS)
                            .instabreak()
                            .noCollission()));
    public static final RegistryObject<Block> DEMONIC_LOG = PILLAR_BLOCKS.register(
            "demonic_log",
            () -> log(MaterialColor.WOOD, MaterialColor.WOOD));
    public static final RegistryObject<Block> DEMONIC_LOG_STRIPPED = PILLAR_BLOCKS.register(
            "stripped_demonic_log",
            () -> log(MaterialColor.WOOD, MaterialColor.WOOD));
    public static final RegistryObject<Block> DEMONIC_LEAVES = BLOCKS.register(
            "demonic_leaves",
            () -> new DemonicLeaves(
                    BlockBehaviour.Properties
                            .of(Material.LEAVES)
                            .strength(0.2F)
                            .randomTicks()
                            .sound(SoundType.AZALEA_LEAVES)
                            .noOcclusion()
                            .color(MaterialColor.COLOR_RED)));
    public static final RegistryObject<Block> DEMONIC_LEAVES_BOTTOM = PILLAR_BLOCKS.register(
            "demonic_leaves_bottom",
            () -> new DemonicLeavesBottom(
                    BlockBehaviour.Properties
                            .of(Material.LEAVES)
                            .strength(0.2F)
                            .randomTicks()
                            .sound(SoundType.AZALEA_LEAVES)
                            .noCollission()
                            .noOcclusion()
                            .color(MaterialColor.COLOR_RED)));
    public static final RegistryObject<Block> DEMONIC_PLANKS = BLOCKS.register(
            "demonic_planks",
            () -> new Block(
                    BlockBehaviour.Properties
                            .of(Material.NETHER_WOOD)
                            .strength(0.8F)
                            .randomTicks()
                            .sound(SoundType.WOOD)));
    public static final RegistryObject<TrapDoorBlock> DEMONIC_TRAPDOOR = PILLAR_BLOCKS.register(
            "demonic_trap_door",
            () -> new TrapDoorBlock(
                    BlockBehaviour.Properties
                            .of(Material.NETHER_WOOD)
                            .strength(0.2F)
                            .randomTicks()
                            .sound(SoundType.WOOD)
                            .noOcclusion()));
    public static final RegistryObject<FenceBlock> DEMONIC_WOOD_FENCE = PILLAR_BLOCKS.register(
            "demonic_wooden_fence",
            () -> new FenceBlock(
                    BlockBehaviour.Properties
                            .of(Material.NETHER_WOOD)
                            .strength(0.8F)
                            .dynamicShape()
                            .sound(SoundType.WOOD)));
    public static final RegistryObject<FenceGateBlock> DEMONIC_WOOD_FENCE_GATE = PILLAR_BLOCKS.register(
            "demonic_wooden_fence_gate",
            () -> new FenceGateBlock(
                    BlockBehaviour.Properties
                            .of(Material.NETHER_WOOD)
                            .strength(0.8F)
                            .dynamicShape()
                            .sound(SoundType.WOOD)));
    public static final RegistryObject<DoorBlock> DEMONIC_DOOR_ = PILLAR_BLOCKS.register(
            "demonic_door",
            () -> new DoorBlock(
                    BlockBehaviour.Properties
                            .of(Material.NETHER_WOOD)
                            .strength(2.0F)
                            .sound(SoundType.WOOD)));

    public static final RegistryObject<Block> SOUL_HERB = PILLAR_BLOCKS.register(
            "soul_herb",
            () -> new AncientHerb(
                    BlockBehaviour.Properties
                            .of(Material.GRASS)
                            .sound(SoundType.WET_GRASS)
                            .instabreak()
                            .noCollission()));
    public static final RegistryObject<Block> SOUL_LOG = PILLAR_BLOCKS.register(
            "soul_log",
            () -> log(MaterialColor.WOOD, MaterialColor.WOOD));
    public static final RegistryObject<Block> SOUL_LOG_0 = PILLAR_BLOCKS.register(
            "soul_log_0",
            () -> log(MaterialColor.WOOD, MaterialColor.WOOD));
    public static final RegistryObject<Block> SOUL_LOG_1 = PILLAR_BLOCKS.register(
            "soul_log_1",
            () -> log(MaterialColor.WOOD, MaterialColor.WOOD));
    public static final RegistryObject<Block> SOUL_LOG_2 = PILLAR_BLOCKS.register(
            "soul_log_2",
            () -> log(MaterialColor.WOOD, MaterialColor.WOOD));
    public static final RegistryObject<Block> SOUL_LOG_STRIPPED = PILLAR_BLOCKS.register(
            "stripped_soul_log",
            () -> log(MaterialColor.WOOD, MaterialColor.WOOD));
    public static final RegistryObject<Block> SOUL_LEAVES = BLOCKS.register(
            "soul_leaves",
            () -> new SoulLeaves(
                    BlockBehaviour.Properties
                            .of(Material.LEAVES)
                            .strength(0.2F)
                            .randomTicks()
                            .sound(SoundType.AZALEA_LEAVES)
                            .noOcclusion()
                            .color(MaterialColor.COLOR_BLUE)));
    public static final RegistryObject<Block> SOUL_LEAVES_BOTTOM = PILLAR_BLOCKS.register(
            "soul_leaves_bottom",
            () -> new SoulLeavesBottom(
                    BlockBehaviour.Properties
                            .of(Material.LEAVES)
                            .strength(0.2F)
                            .randomTicks()
                            .sound(SoundType.AZALEA_LEAVES)
                            .noCollission()
                            .noOcclusion()
                            .color(MaterialColor.COLOR_BLUE)));
    public static final RegistryObject<Block> SOUL_PLANKS = BLOCKS.register(
            "soul_planks",
            () -> new Block(
                    BlockBehaviour.Properties
                            .of(Material.NETHER_WOOD)
                            .strength(0.8F)
                            .randomTicks()
                            .sound(SoundType.WOOD)));
    public static final RegistryObject<TrapDoorBlock> SOUL_TRAPDOOR = PILLAR_BLOCKS.register(
            "soul_trap_door",
            () -> new TrapDoorBlock(
                    BlockBehaviour.Properties
                            .of(Material.NETHER_WOOD)
                            .strength(0.2F)
                            .randomTicks()
                            .sound(SoundType.WOOD)
                            .noOcclusion()));
    public static final RegistryObject<FenceBlock> SOUL_WOOD_FENCE = PILLAR_BLOCKS.register(
            "soul_wooden_fence",
            () -> new FenceBlock(
                    BlockBehaviour.Properties
                            .of(Material.NETHER_WOOD)
                            .strength(0.8F)
                            .dynamicShape()
                            .sound(SoundType.WOOD)));
    public static final RegistryObject<FenceGateBlock> SOUL_WOOD_FENCE_GATE = PILLAR_BLOCKS.register(
            "soul_wooden_fence_gate",
            () -> new FenceGateBlock(
                    BlockBehaviour.Properties
                            .of(Material.NETHER_WOOD)
                            .strength(0.8F)
                            .dynamicShape()
                            .sound(SoundType.WOOD)));
    public static final RegistryObject<DoorBlock> SOUL_DOOR_ = PILLAR_BLOCKS.register(
            "soul_door",
            () -> new DoorBlock(
                    BlockBehaviour.Properties
                            .of(Material.NETHER_WOOD)
                            .strength(2.0F)
                            .sound(SoundType.WOOD)));

    public static final RegistryObject<WallBlock> ANCIENT_STONE_WALL = WALL_BLOCKS.register(
            "ancient_stone_wall",
            () -> new WallBlock(
                    BlockBehaviour.Properties.copy(ANCIENT_STONE.get())));
    public static final RegistryObject<WallBlock> ANCIENT_SMOOTH_STONE_WALL = WALL_BLOCKS.register(
            "ancient_smooth_stone_wall",
            () -> new WallBlock(
                    BlockBehaviour.Properties.copy(ANCIENT_SMOOTH_STONE.get())));
    public static final RegistryObject<WallBlock> ANCIENT_POLISHED_STONE_WALL = WALL_BLOCKS.register(
            "ancient_polished_stone_wall",
            () -> new WallBlock(
                    BlockBehaviour.Properties.copy(ANCIENT_POLISHED_STONE.get())));
    public static final RegistryObject<WallBlock> ANCIENT_STONE_BRICK_WALL = WALL_BLOCKS.register(
            "ancient_stone_brick_wall",
            () -> new WallBlock(
                    BlockBehaviour.Properties.copy(ANCIENT_STONE_BRICKS.get())));
    public static final RegistryObject<WallBlock> ANCIENT_CHISELED_STONE_BRICK_WALL = WALL_BLOCKS.register(
            "ancient_chiseled_stone_brick_wall",
            () -> new WallBlock(
                    BlockBehaviour.Properties.copy(
                            ANCIENT_CHISELED_STONE_BRICKS.get())));
    public static final RegistryObject<WallBlock> ANCIENT_CRACKED_STONE_BRICK_WALL = WALL_BLOCKS.register(
            "ancient_cracked_stone_brick_wall",
            () -> new WallBlock(
                    BlockBehaviour.Properties.copy(
                            ANCIENT_CRACKED_STONE_BRICKS.get())));
    public static final RegistryObject<WallBlock> ANCIENT_MOSSY_STONE_WALL = WALL_BLOCKS.register(
            "ancient_mossy_stone_wall",
            () -> new WallBlock(
                    BlockBehaviour.Properties.copy(ANCIENT_MOSSY_STONE.get())));

    public static final RegistryObject<Item> ANCIENT_CAVEVINE_PLANT_ITEM = ITEMS.register(
            "ancient_cavevines_plant",
            () -> new BlockItem(
                    ANCIENT_CAVEVINES_PLANT_.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_SOULBERRY = ITEMS.register(
            "ancient_soulberries",
            () -> new SoulBerries(
                    ANCIENT_CAVEVINES_.get(),
                    (new Item.Properties()).food(ModFoods.SOUL_BERRIES)
                            .tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_TRAP_DOOR_ITEM = ITEMS.register(
            "ancient_trap_door",
            () -> new BlockItem(
                    ANCIENT_TRAPDOOR.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> DEMONIC_TRAP_DOOR_ITEM = ITEMS.register(
            "demonic_trap_door",
            () -> new BlockItem(
                    DEMONIC_TRAPDOOR.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> SOUL_TRAP_DOOR_ITEM = ITEMS.register(
            "soul_trap_door",
            () -> new BlockItem(
                    SOUL_TRAPDOOR.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_DOOR_ITEM = ITEMS.register(
            "ancient_door",
            () -> new BlockItem(
                    ANCIENT_DOOR_.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> DEMONIC_DOOR_ITEM = ITEMS.register(
            "demonic_door",
            () -> new BlockItem(
                    DEMONIC_DOOR_.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> SOUL_DOOR_ITEM = ITEMS.register(
            "soul_door",
            () -> new BlockItem(
                    SOUL_DOOR_.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));

    public static final RegistryObject<Item> ANCIENT_STONE_WALL_ITEM = ITEMS.register(
            "ancient_stone_wall",
            () -> new BlockItem(
                    ANCIENT_STONE_WALL.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_SMOOTH_STONE_WALL_ITEM = ITEMS.register(
            "ancient_smooth_stone_wall",
            () -> new BlockItem(
                    ANCIENT_SMOOTH_STONE_WALL.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_POLISHED_STONE_WALL_ITEM = ITEMS.register(
            "ancient_polished_stone_wall",
            () -> new BlockItem(
                    ANCIENT_POLISHED_STONE_WALL.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_STONE_BRICK_WALL_ITEM = ITEMS.register(
            "ancient_stone_brick_wall",
            () -> new BlockItem(
                    ANCIENT_STONE_BRICK_WALL.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_CHISELED_STONE_BRICK_WALL_ITEM = ITEMS.register(
            "ancient_chiseled_stone_brick_wall",
            () -> new BlockItem(
                    ANCIENT_CHISELED_STONE_BRICK_WALL.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_CRACKED_STONE_BRICK_WALL_ITEM = ITEMS.register(
            "ancient_cracked_stone_brick_wall",
            () -> new BlockItem(
                    ANCIENT_CRACKED_STONE_BRICK_WALL.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_MOSSY_STONE_WALL_ITEM = ITEMS.register(
            "ancient_mossy_stone_wall",
            () -> new BlockItem(
                    ANCIENT_MOSSY_STONE_WALL.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));

    public static final RegistryObject<Block> ANCIENT_BOOKSHELF = PILLAR_BLOCKS.register(
            "ancient_bookshelf",
            () -> new AncientBookShelf(
                    BlockBehaviour.Properties
                            .of(Material.NETHER_WOOD)
                            .strength(0.8F)
                            .randomTicks()
                            .sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DEMONIC_BOOKSHELF = PILLAR_BLOCKS.register(
            "demonic_bookshelf",
            () -> new AncientBookShelf(
                    BlockBehaviour.Properties
                            .of(Material.NETHER_WOOD)
                            .strength(0.8F)
                            .randomTicks()
                            .sound(SoundType.WOOD)));
    public static final RegistryObject<Block> SOUL_BOOKSHELF = PILLAR_BLOCKS.register(
            "soul_bookshelf",
            () -> new AncientBookShelf(
                    BlockBehaviour.Properties
                            .of(Material.NETHER_WOOD)
                            .strength(0.8F)
                            .randomTicks()
                            .sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ANCIENT_SAPLING = PILLAR_BLOCKS.register(
            "ancient_sapling",
            () -> new SaplingBlock(
                    new AncientTreeGrower(),
                    BlockBehaviour.Properties
                            .of(Material.PLANT)
                            .noCollission()
                            .randomTicks()
                            .instabreak()
                            .dynamicShape()
                            .sound(SoundType.GRASS)));
    public static final RegistryObject<Block> DEMONIC_SAPLING = PILLAR_BLOCKS.register(
            "demonic_sapling",
            () -> new SaplingBlock(
                    new DemonicTreeGrower(),
                    BlockBehaviour.Properties
                            .of(Material.PLANT)
                            .noCollission()
                            .randomTicks()
                            .instabreak()
                            .dynamicShape()
                            .sound(SoundType.GRASS)));
    public static final RegistryObject<Block> SOUL_SAPLING = PILLAR_BLOCKS.register(
            "soul_sapling",
            () -> new SaplingBlock(
                    new SoulTreeGrower(),
                    BlockBehaviour.Properties
                            .of(Material.PLANT)
                            .noCollission()
                            .randomTicks()
                            .instabreak()
                            .dynamicShape()
                            .sound(SoundType.GRASS)));

    public static final RegistryObject<StairBlock> ANCIENT_WOODEN_STAIRS = STAIR_BLOCKS.register(
            "ancient_wooden_stairs",
            () -> new StairBlock(
                    () -> ANCIENT_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(ANCIENT_PLANKS.get())));
    public static final RegistryObject<StairBlock> DEMONIC_WOODEN_STAIRS = STAIR_BLOCKS.register(
            "demonic_wooden_stairs",
            () -> new StairBlock(
                    () -> DEMONIC_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(DEMONIC_PLANKS.get())));
    public static final RegistryObject<StairBlock> SOUL_WOODEN_STAIRS = STAIR_BLOCKS.register(
            "soul_wooden_stairs",
            () -> new StairBlock(
                    () -> SOUL_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(SOUL_PLANKS.get())));
    public static final RegistryObject<StairBlock> ANCIENT_STONE_STAIRS = STAIR_BLOCKS.register(
            "ancient_stone_stairs",
            () -> new StairBlock(
                    () -> ANCIENT_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(ANCIENT_STONE.get())));
    public static final RegistryObject<StairBlock> ANCIENT_SMOOTH_STONE_STAIRS = STAIR_BLOCKS.register(
            "ancient_smooth_stone_stairs",
            () -> new StairBlock(
                    () -> ANCIENT_SMOOTH_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(ANCIENT_SMOOTH_STONE.get())));
    public static final RegistryObject<StairBlock> ANCIENT_STONE_BRICK_STAIRS = STAIR_BLOCKS.register(
            "ancient_stone_brick_stairs",
            () -> new StairBlock(
                    () -> ANCIENT_STONE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(ANCIENT_STONE.get())));

    public static final RegistryObject<StairBlock> ANCIENT_MOSSY_STONE_STAIRS = STAIR_BLOCKS.register(
            "ancient_mossy_stone_stairs",
            () -> new StairBlock(
                    () -> ANCIENT_MOSSY_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(ANCIENT_MOSSY_STONE.get())));
    public static final RegistryObject<StairBlock> ANCIENT_CHISELED_STONE_STAIRS = STAIR_BLOCKS.register(
            "ancient_chiseled_stone_brick_stairs",
            () -> new StairBlock(
                    () -> ANCIENT_CHISELED_STONE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(ANCIENT_MOSSY_STONE.get())));
    public static final RegistryObject<StairBlock> ANCIENT_CRACKED_STONE_STAIRS = STAIR_BLOCKS.register(
            "ancient_cracked_stone_brick_stairs",
            () -> new StairBlock(
                    () -> ANCIENT_CRACKED_STONE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(ANCIENT_MOSSY_STONE.get())));
    public static final RegistryObject<StairBlock> ANCIENT_POLISHED_STONE_STAIRS = STAIR_BLOCKS.register(
            "ancient_polished_stone_stairs",
            () -> new StairBlock(
                    () -> ANCIENT_POLISHED_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(ANCIENT_MOSSY_STONE.get())));

    public static final RegistryObject<SlabBlock> ANCIENT_WOODEN_SLABS = SLAB_BLOCKS.register(
            "ancient_wooden_slabs",
            () -> new SlabBlock(
                    BlockBehaviour.Properties.copy(ANCIENT_PLANKS.get())));
    public static final RegistryObject<SlabBlock> DEMONIC_WOODEN_SLABS = SLAB_BLOCKS.register(
            "demonic_wooden_slabs",
            () -> new SlabBlock(
                    BlockBehaviour.Properties.copy(DEMONIC_PLANKS.get())));
    public static final RegistryObject<SlabBlock> SOUL_WOODEN_SLABS = SLAB_BLOCKS.register(
            "soul_wooden_slabs",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(SOUL_PLANKS.get())));
    public static final RegistryObject<SlabBlock> ANCIENT_STONE_SLABS = SLAB_BLOCKS.register(
            "ancient_stone_slabs",
            () -> new SlabBlock(
                    BlockBehaviour.Properties.copy(ANCIENT_STONE.get())));
    public static final RegistryObject<SlabBlock> ANCIENT_SMOOTH_STONE_SLABS = SLAB_BLOCKS.register(
            "ancient_smooth_stone_slabs",
            () -> new SlabBlock(
                    BlockBehaviour.Properties.copy(ANCIENT_SMOOTH_STONE.get())));
    public static final RegistryObject<SlabBlock> ANCIENT_STONE_BRICK_SLABS = SLAB_BLOCKS.register(
            "ancient_stone_brick_slabs",
            () -> new SlabBlock(
                    BlockBehaviour.Properties.copy(ANCIENT_STONE.get())));
    public static final RegistryObject<SlabBlock> ANCIENT_MOSSY_STONE_SLABS = SLAB_BLOCKS.register(
            "ancient_mossy_stone_slabs",
            () -> new SlabBlock(
                    BlockBehaviour.Properties.copy(ANCIENT_MOSSY_STONE.get())));
    public static final RegistryObject<SlabBlock> ANCIENT_CHISELED_STONE_SLABS = SLAB_BLOCKS.register(
            "ancient_chiseled_stone_brick_slabs",
            () -> new SlabBlock(
                    BlockBehaviour.Properties.copy(ANCIENT_MOSSY_STONE.get())));
    public static final RegistryObject<SlabBlock> ANCIENT_CRACKED_STONE_SLABS = SLAB_BLOCKS.register(
            "ancient_cracked_stone_brick_slabs",
            () -> new SlabBlock(
                    BlockBehaviour.Properties.copy(ANCIENT_MOSSY_STONE.get())));
    public static final RegistryObject<SlabBlock> ANCIENT_POLISHED_STONE_SLABS = SLAB_BLOCKS.register(
            "ancient_polished_stone_slabs",
            () -> new SlabBlock(
                    BlockBehaviour.Properties.copy(ANCIENT_MOSSY_STONE.get())));

    public static final RegistryObject<Item> ANCIENT_WOODEN_SLABS_ITEM = ITEMS.register(
            "ancient_wooden_slabs",
            () -> new BlockItem(
                    ANCIENT_WOODEN_SLABS.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> DEMONIC_WOODEN_SLABS_ITEM = ITEMS.register(
            "demonic_wooden_slabs",
            () -> new BlockItem(
                    DEMONIC_WOODEN_SLABS.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> SOUL_WOODEN_SLABS_ITEM = ITEMS.register(
            "soul_wooden_slabs",
            () -> new BlockItem(
                    SOUL_WOODEN_SLABS.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_STONE_SLABS_ITEM = ITEMS.register(
            "ancient_stone_slabs",
            () -> new BlockItem(
                    ANCIENT_STONE_SLABS.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_SMOOTH_STONE_SLABS_ITEM = ITEMS.register(
            "ancient_smooth_stone_slabs",
            () -> new BlockItem(
                    ANCIENT_SMOOTH_STONE_SLABS.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_STONE_BRICK_SLABS_ITEM = ITEMS.register(
            "ancient_stone_brick_slabs",
            () -> new BlockItem(
                    ANCIENT_STONE_BRICK_SLABS.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_MOSSY_STONE_SLABS_ITEM = ITEMS.register(
            "ancient_mossy_stone_slabs",
            () -> new BlockItem(
                    ANCIENT_MOSSY_STONE_SLABS.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_CHISELED_STONE_SLABS_ITEM = ITEMS.register(
            "ancient_chiseled_stone_brick_slabs",
            () -> new BlockItem(
                    ANCIENT_CHISELED_STONE_SLABS.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_CRACKED_STONE_SLABS_ITEM = ITEMS.register(
            "ancient_cracked_stone_brick_slabs",
            () -> new BlockItem(
                    ANCIENT_CRACKED_STONE_SLABS.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_POLISHED_STONE_SLABS_ITEM = ITEMS.register(
            "ancient_polished_stone_slabs",
            () -> new BlockItem(
                    ANCIENT_POLISHED_STONE_SLABS.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));

    public static final RegistryObject<Item> ANCIENT_HERB_ITEM = ITEMS.register(
            "ancient_herb",
            () -> new BlockItem(
                    ANCIENT_HERB.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> DEMONIC_HERB_ITEM = ITEMS.register(
            "demonic_herb",
            () -> new BlockItem(
                    DEMONIC_HERB.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> SOUL_HERB_ITEM = ITEMS.register(
            "soul_herb",
            () -> new BlockItem(
                    SOUL_HERB.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));

    public static final RegistryObject<Item> ANCIENT_LOG_0_ITEM = ITEMS.register(
            "ancient_log_0",
            () -> new BlockItem(
                    ANCIENT_LOG_0.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_LOG_1_ITEM = ITEMS.register(
            "ancient_log_1",
            () -> new BlockItem(
                    ANCIENT_LOG_1.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_LOG_2_ITEM = ITEMS.register(
            "ancient_log_2",
            () -> new BlockItem(
                    ANCIENT_LOG_2.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_LOG_STRIPPED_ITEM = ITEMS.register(
            "stripped_ancient_log",
            () -> new BlockItem(
                    ANCIENT_LOG_STRIPPED.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_LEAVES_ITEM = ITEMS.register(
            "ancient_leaves",
            () -> new BlockItem(
                    ANCIENT_LEAVES.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_PLANKS_ITEM = ITEMS.register(
            "ancient_planks",
            () -> new BlockItem(
                    ANCIENT_PLANKS.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_BOOKSHELF_ITEM = ITEMS.register(
            "ancient_bookshelf",
            () -> new BlockItem(
                    ANCIENT_BOOKSHELF.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_SAPLING_ITEM = ITEMS.register(
            "ancient_sapling",
            () -> new BlockItem(
                    ANCIENT_SAPLING.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));

    public static final RegistryObject<Item> SOUL_LOG_ITEM = ITEMS.register(
            "soul_log",
            () -> new BlockItem(
                    SOUL_LOG.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> SOUL_LOG_0_ITEM = ITEMS.register(
            "soul_log_0",
            () -> new BlockItem(
                    SOUL_LOG_0.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> SOUL_LOG_1_ITEM = ITEMS.register(
            "soul_log_1",
            () -> new BlockItem(
                    SOUL_LOG_1.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> SOUL_LOG_2_ITEM = ITEMS.register(
            "soul_log_2",
            () -> new BlockItem(
                    SOUL_LOG_2.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> SOUL_LOG_STRIPPED_ITEM = ITEMS.register(
            "stripped_soul_log",
            () -> new BlockItem(
                    SOUL_LOG_STRIPPED.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> SOUL_LEAVES_ITEM = ITEMS.register(
            "soul_leaves",
            () -> new BlockItem(
                    SOUL_LEAVES.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> SOUL_PLANKS_ITEM = ITEMS.register(
            "soul_planks",
            () -> new BlockItem(
                    SOUL_PLANKS.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> SOUL_BOOKSHELF_ITEM = ITEMS.register(
            "soul_bookshelf",
            () -> new BlockItem(
                    SOUL_BOOKSHELF.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> SOUL_SAPLING_ITEM = ITEMS.register(
            "soul_sapling",
            () -> new BlockItem(
                    SOUL_SAPLING.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));

    public static final RegistryObject<Item> DEMONIC_LOG_ITEM = ITEMS.register(
            "demonic_log",
            () -> new BlockItem(
                    DEMONIC_LOG.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> DEMONIC_LOG_STRIPPED_ITEM = ITEMS.register(
            "stripped_demonic_log",
            () -> new BlockItem(
                    DEMONIC_LOG_STRIPPED.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> DEMONIC_LEAVES_ITEM = ITEMS.register(
            "demonic_leaves",
            () -> new BlockItem(
                    DEMONIC_LEAVES.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> DEMONIC_PLANKS_ITEM = ITEMS.register(
            "demonic_planks",
            () -> new BlockItem(
                    DEMONIC_PLANKS.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> DEMONIC_BOOKSHELF_ITEM = ITEMS.register(
            "demonic_bookshelf",
            () -> new BlockItem(
                    DEMONIC_BOOKSHELF.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> DEMONIC_SAPLING_ITEM = ITEMS.register(
            "demonic_sapling",
            () -> new BlockItem(
                    DEMONIC_SAPLING.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));

    public static final RegistryObject<Item> ANCIENT_WOODEN_STAIRS_ITEM = ITEMS.register(
            "ancient_wooden_stairs",
            () -> new BlockItem(
                    ANCIENT_WOODEN_STAIRS.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> DEMONIC_WOODEN_STAIRS_ITEM = ITEMS.register(
            "demonic_wooden_stairs",
            () -> new BlockItem(
                    DEMONIC_WOODEN_STAIRS.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> SOUL_WOODEN_STAIRS_ITEM = ITEMS.register(
            "soul_wooden_stairs",
            () -> new BlockItem(
                    SOUL_WOODEN_STAIRS.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_STONE_STAIRS_ITEM = ITEMS.register(
            "ancient_stone_stairs",
            () -> new BlockItem(
                    ANCIENT_STONE_STAIRS.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_SMOOTH_STONE_STAIRS_ITEM = ITEMS.register(
            "ancient_smooth_stone_stairs",
            () -> new BlockItem(
                    ANCIENT_SMOOTH_STONE_STAIRS.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_STONE_BRICK_STAIRS_ITEM = ITEMS.register(
            "ancient_stone_brick_stairs",
            () -> new BlockItem(
                    ANCIENT_STONE_BRICK_STAIRS.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_MOSSY_STONE_STAIRS_ITEM = ITEMS.register(
            "ancient_mossy_stone_stairs",
            () -> new BlockItem(
                    ANCIENT_MOSSY_STONE_STAIRS.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_CHISELED_STONE_STAIRS_ITEM = ITEMS.register(
            "ancient_chiseled_stone_brick_stairs",
            () -> new BlockItem(
                    ANCIENT_CHISELED_STONE_STAIRS.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_CRACKED_STONE_STAIRS_ITEM = ITEMS.register(
            "ancient_cracked_stone_brick_stairs",
            () -> new BlockItem(
                    ANCIENT_CRACKED_STONE_STAIRS.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_POLISHED_STONE_STAIRS_ITEM = ITEMS.register(
            "ancient_polished_stone_stairs",
            () -> new BlockItem(
                    ANCIENT_POLISHED_STONE_STAIRS.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));

    public static final RegistryObject<Item> ANCIENT_WOOD_FENCE_ITEM = ITEMS.register(
            "ancient_wooden_fence",
            () -> new BlockItem(
                    ANCIENT_WOOD_FENCE.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_WOOD_FENCE_GATE_ITEM = ITEMS.register(
            "ancient_wooden_fence_gate",
            () -> new BlockItem(
                    ANCIENT_WOOD_FENCE_GATE.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> DEMONIC_WOOD_FENCE_ITEM = ITEMS.register(
            "demonic_wooden_fence",
            () -> new BlockItem(
                    DEMONIC_WOOD_FENCE.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> DEMONIC_WOOD_FENCE_GATE_ITEM = ITEMS.register(
            "demonic_wooden_fence_gate",
            () -> new BlockItem(
                    DEMONIC_WOOD_FENCE_GATE.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> SOUL_WOOD_FENCE_ITEM = ITEMS.register(
            "soul_wooden_fence",
            () -> new BlockItem(
                    SOUL_WOOD_FENCE.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> SOUL_WOOD_FENCE_GATE_ITEM = ITEMS.register(
            "soul_wooden_fence_gate",
            () -> new BlockItem(
                    SOUL_WOOD_FENCE_GATE.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));

    public static final RegistryObject<Item> ANCIENT_SMOOTH_STONE_ITEM = ITEMS.register(
            "ancient_smooth_stone",
            () -> new BlockItem(
                    ANCIENT_SMOOTH_STONE.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_STONE_ITEM = ITEMS.register(
            "ancient_stone",
            () -> new BlockItem(
                    ANCIENT_STONE.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_DIRT_ITEM = ITEMS.register(
            "ancient_dirt",
            () -> new BlockItem(
                    ANCIENT_DIRT.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_GRASS_ITEM = ITEMS.register(
            "ancient_grass",
            () -> new BlockItem(
                    ANCIENT_GRASS.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_MOSSY_STONE_ITEM = ITEMS.register(
            "ancient_mossy_stone",
            () -> new BlockItem(
                    ANCIENT_MOSSY_STONE.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_STONE_BRICKS_ITEM = ITEMS.register(
            "ancient_stone_bricks",
            () -> new BlockItem(
                    ANCIENT_STONE_BRICKS.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_CHISELED_STONE_BRICKS_ITEM = ITEMS.register(
            "ancient_chiseled_stone_bricks",
            () -> new BlockItem(
                    ANCIENT_CHISELED_STONE_BRICKS.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_CRACKED_STONE_BRICKS_ITEM = ITEMS.register(
            "ancient_cracked_stone_bricks",
            () -> new BlockItem(
                    ANCIENT_CRACKED_STONE_BRICKS.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ANCIENT_POLISHED_STONE_ITEM = ITEMS.register(
            "ancient_polished_stone",
            () -> new BlockItem(
                    ANCIENT_POLISHED_STONE.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));

    public static final RegistryObject<AllthemodiumOre> ALLTHEMODIUM_ORE = BLOCKS.register("allthemodium_ore",
            AllthemodiumOre::new);
    public static final RegistryObject<AllthemodiumOre> ALLTHEMODIUM_SLATE_ORE = BLOCKS
            .register("allthemodium_slate_ore", AllthemodiumOre::new);

    public static final RegistryObject<Block> VIBRANIUM_ORE = BLOCKS.register(
            "vibranium_ore",
            VibraniumOre::new);
    public static final RegistryObject<Block> OTHER_VIBRANIUM_ORE = BLOCKS.register("other_vibranium_ore",
            VibraniumOre::new);
    public static final RegistryObject<Block> UNOBTAINIUM_ORE = BLOCKS.register(
            "unobtainium_ore",
            UnobtainiumOre::new);

    public static final RegistryObject<Block> ALLTHEMODIUM_BLOCK = BLOCKS.register("allthemodium_block",
            AllthemodiumBlock::new);
    public static final RegistryObject<Block> VIBRANIUM_BLOCK = BLOCKS.register(
            "vibranium_block",
            VibraniumBlock::new);
    public static final RegistryObject<Block> UNOBTAINIUM_BLOCK = BLOCKS.register("unobtainium_block",
            UnobtainiumBlock::new);

    public static final RegistryObject<Block> RAW_ALLTHEMODIUM_BLOCK = BLOCKS.register("raw_allthemodium_block",
            RawATM::new);
    public static final RegistryObject<Block> RAW_VIBRANIUM_BLOCK = BLOCKS.register("raw_vibranium_block", RawVIB::new);
    public static final RegistryObject<Block> RAW_UNOBTAINIUM_BLOCK = BLOCKS.register("raw_unobtainium_block",
            RawUNO::new);

    public static final RegistryObject<Item> RAW_ALLTHEMODIUM_BLOCK_ITEM = ITEMS.register(
            "raw_allthemodium_block",
            () -> new BlockItem(
                    RAW_ALLTHEMODIUM_BLOCK.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> RAW_VIBRANIUM_BLOCK_ITEM = ITEMS.register(
            "raw_vibranium_block",
            () -> new BlockItem(
                    RAW_VIBRANIUM_BLOCK.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> RAW_UNOBTAINIUM_BLOCK_ITEM = ITEMS.register(
            "raw_unobtainium_block",
            () -> new BlockItem(
                    RAW_UNOBTAINIUM_BLOCK.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));

    public static final RegistryObject<Item> ALLTHEMODIUM_ORE_ITEM = ITEMS.register(
            "allthemodium_ore",
            () -> new AllthemodiumOreItem(
                    ALLTHEMODIUM_ORE.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ALLTHEMODIUM_SLATE_ORE_ITEM = ITEMS.register(
            "allthemodium_slate_ore",
            () -> new AllthemodiumOreItem(
                    ALLTHEMODIUM_SLATE_ORE.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));

    public static final RegistryObject<Item> VIBRANIUM_ORE_ITEM = ITEMS.register(
            "vibranium_ore",
            () -> new VibraniumOreItem(
                    VIBRANIUM_ORE.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> OTHER_VIBRANIUM_ORE_ITEM = ITEMS.register(
            "other_vibranium_ore",
            () -> new VibraniumOreItem(
                    OTHER_VIBRANIUM_ORE.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> UNOBTAINIUM_ORE_ITEM = ITEMS.register(
            "unobtainium_ore",
            () -> new UnobtainiumOreItem(
                    UNOBTAINIUM_ORE.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));

    public static final RegistryObject<Item> ALLTHEMODIUM_BLOCK_ITEM = ITEMS.register(
            "allthemodium_block",
            () -> new BlockItem(
                    ALLTHEMODIUM_BLOCK.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> VIBRANIUM_BLOCK_ITEM = ITEMS.register(
            "vibranium_block",
            () -> new BlockItem(
                    VIBRANIUM_BLOCK.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> UNOBTAINIUM_BLOCK_ITEM = ITEMS.register(
            "unobtainium_block",
            () -> new BlockItem(
                    UNOBTAINIUM_BLOCK.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));

    public static final RegistryObject<Item> RAW_ALLTHEMODIUM = ITEMS.register(
            "raw_allthemodium",
            () -> new RawOre(new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> RAW_VIBRANIUM = ITEMS.register(
            "raw_vibranium",
            () -> new RawOre(new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> RAW_UNOBTAINIUM = ITEMS.register(
            "raw_unobtainium",
            () -> new RawOre(new Item.Properties().tab(AllTheModium.GROUP)));

    public static final RegistryObject<Item> ALLTHEMODIUM_INGOT = ITEMS.register(
            "allthemodium_ingot",
            () -> new Ingot(new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> VIBRANIUM_INGOT = ITEMS.register(
            "vibranium_ingot",
            () -> new Ingot(new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> UNOBTAINIUM_INGOT = ITEMS.register(
            "unobtainium_ingot",
            () -> new Ingot(new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> ATM_PLATE = ITEMS.register(
            "allthemodium_plate",
            () -> new Plate(new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> VIB_PLATE = ITEMS.register(
            "vibranium_plate",
            () -> new Plate(new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> UNOB_PLATE = ITEMS.register(
            "unobtainium_plate",
            () -> new Plate(new Item.Properties().tab(AllTheModium.GROUP)));

    public static final RegistryObject<Item> ATM_GEAR = ITEMS.register(
            "allthemodium_gear",
            () -> new Gear(new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> VIB_GEAR = ITEMS.register(
            "vibranium_gear",
            () -> new Gear(new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> UNOB_GEAR = ITEMS.register(
            "unobtainium_gear",
            () -> new Gear(new Item.Properties().tab(AllTheModium.GROUP)));

    public static final RegistryObject<Item> ATM_ROD = ITEMS.register(
            "allthemodium_rod",
            () -> new Rod(new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> VIB_ROD = ITEMS.register(
            "vibranium_rod",
            () -> new Rod(new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> UNOB_ROD = ITEMS.register(
            "unobtainium_rod",
            () -> new Rod(new Item.Properties().tab(AllTheModium.GROUP)));

    public static final RegistryObject<Item> ALLTHEMODIUM_NUGGET = ITEMS.register(
            "allthemodium_nugget",
            () -> new Nugget(new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> VIBRANIUM_NUGGET = ITEMS.register(
            "vibranium_nugget",
            () -> new Nugget(new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> UNOBTAINIUM_NUGGET = ITEMS.register(
            "unobtainium_nugget",
            () -> new Nugget(new Item.Properties().tab(AllTheModium.GROUP)));

    public static final RegistryObject<Item> ALLTHEMODIUM_DUST = ITEMS.register(
            "allthemodium_dust",
            () -> new Dust(new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> VIBRANIUM_DUST = ITEMS.register(
            "vibranium_dust",
            () -> new Dust(new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> UNOBTAINIUM_DUST = ITEMS.register(
            "unobtainium_dust",
            () -> new Dust(new Item.Properties().tab(AllTheModium.GROUP)));

    public static final RegistryObject<Item> ATM_CLUMP = ITEMS.register(
            "allthemodium_clump",
            () -> new Clump(new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> VIB_CLUMP = ITEMS.register(
            "vibranium_clump",
            () -> new Clump(new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> UNOB_CLUMP = ITEMS.register(
            "unobtainium_clump",
            () -> new Clump(new Item.Properties().tab(AllTheModium.GROUP)));

    public static final RegistryObject<Item> ATM_SHARD = ITEMS.register(
            "allthemodium_shard",
            () -> new Shard(new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> VIB_SHARD = ITEMS.register(
            "vibranium_shard",
            () -> new Shard(new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> UNOB_SHARD = ITEMS.register(
            "unobtainium_shard",
            () -> new Shard(new Item.Properties().tab(AllTheModium.GROUP)));

    public static final RegistryObject<Item> ATM_DIRTY = ITEMS.register(
            "dirty_allthemodium_dust",
            () -> new DirtyDust(new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> VIB_DIRTY = ITEMS.register(
            "dirty_vibranium_dust",
            () -> new DirtyDust(new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> UNOB_DIRTY = ITEMS.register(
            "dirty_unobtainium_dust",
            () -> new DirtyDust(new Item.Properties().tab(AllTheModium.GROUP)));

    public static final RegistryObject<Item> ATM_CRYSTAL = ITEMS.register(
            "allthemodium_crystal",
            () -> new Crystal(new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> VIB_CRYSTAL = ITEMS.register(
            "vibranium_crystal",
            () -> new Crystal(new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> UNOB_CRYSTAL = ITEMS.register(
            "unobtainium_crystal",
            () -> new Crystal(new Item.Properties().tab(AllTheModium.GROUP)));

    public static final RegistryObject<Item> UNOBTAINIUM_ALLTHEMODIUM_DUST = ITEMS.register(
            "unobtainium_allthemodium_alloy_dust",
            () -> new AlloyDust(
                    new Item.Properties()
                            .tab(AllTheModium.GROUP)
                            .fireResistant()));
    public static final RegistryObject<Item> UNOBTAINIUM_VIBRANIUM_DUST = ITEMS.register(
            "unobtainium_vibranium_alloy_dust",
            () -> new AlloyDust(
                    new Item.Properties()
                            .tab(AllTheModium.GROUP)
                            .fireResistant()));
    public static final RegistryObject<Item> VIBRANIUM_ALLTHEMODIUM_DUST = ITEMS.register(
            "vibranium_allthemodium_alloy_dust",
            () -> new AlloyDust(
                    new Item.Properties()
                            .tab(AllTheModium.GROUP)
                            .fireResistant()));

    public static final RegistryObject<Item> UNOBTAINIUM_ALLTHEMODIUM_ALLOY = ITEMS.register(
            "unobtainium_allthemodium_alloy_ingot",
            () -> new AlloyIngot(
                    new Item.Properties()
                            .tab(AllTheModium.GROUP)
                            .fireResistant()));
    public static final RegistryObject<Item> UNOBTAINIUM_VIBRANIUM_ALLOY = ITEMS.register(
            "unobtainium_vibranium_alloy_ingot",
            () -> new AlloyIngot(
                    new Item.Properties()
                            .tab(AllTheModium.GROUP)
                            .fireResistant()));
    public static final RegistryObject<Item> VIBRANIUM_ALLTHEMODIUM_ALLOY = ITEMS.register(
            "vibranium_allthemodium_alloy_ingot",
            () -> new AlloyIngot(
                    new Item.Properties()
                            .tab(AllTheModium.GROUP)
                            .fireResistant()));

    public static final RegistryObject<Block> TELEPORT_PAD = SHAPED_BLOCKS.register(
            "teleport_pad",
            () -> new TeleportPad(
                    Block.Properties
                            .of(Material.METAL)
                            .noLootTable()
                            .noOcclusion()
                            .strength(20.0F)));
    public static final RegistryObject<Item> TELEPORT_PAD_ITEM = ITEMS.register(
            "teleport_pad",
            () -> new BlockItem(
                    TELEPORT_PAD.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));

    public static final RegistryObject<SwordItem> ALLTHEMODIUM_SWORD = ITEMS.register(
            "allthemodium_sword",
            () -> new SwordItem(
                    ToolTiers.ALLTHEMODIUM_TIER,
                    4,
                    1.5f,
                    new Item.Properties()
                            .fireResistant()
                            .tab(AllTheModium.GROUP)
                            .rarity(Rarity.EPIC)) {
                @Override
                public boolean isEnchantable(@Nonnull ItemStack stack) {
                    return true;
                }

                @Override
                public boolean canBeDepleted() {
                    return false;
                }

                @Override
                public void appendHoverText(
                        @Nonnull ItemStack stack,
                        @Nullable Level worldIn,
                        @Nonnull List<Component> tooltip,
                        @Nonnull TooltipFlag flagIn) {
                    tooltip.add(
                            TextComponentHelper
                                    .createComponentTranslation(
                                            CommandSource.NULL,
                                            "indestructible",
                                            new Object())
                                    .withStyle(ChatFormatting.GOLD));

                    super.appendHoverText(stack, worldIn, tooltip, flagIn);
                }
            });

    public static final RegistryObject<PickaxeItem> ALLTHEMODIUM_PICKAXE = ITEMS.register(
            "allthemodium_pickaxe",
            () -> new PickaxeItem(
                    ToolTiers.ALLTHEMODIUM_TIER,
                    2,
                    1.0f,
                    new Item.Properties()
                            .fireResistant()
                            .tab(AllTheModium.GROUP)
                            .rarity(Rarity.EPIC)) {
                @Override
                public float getDestroySpeed(
                        @Nonnull ItemStack stack,
                        @Nonnull BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_PICKAXE))
                        return speed;
                    return super.getDestroySpeed(stack, state);
                }

                @Override
                public boolean isEnchantable(@Nonnull ItemStack stack) {
                    return true;
                }

                @Override
                public boolean canBeDepleted() {
                    return false;
                }

                @Override
                public void appendHoverText(
                        @Nonnull ItemStack stack,
                        @Nullable Level worldIn,
                        @Nonnull List<Component> tooltip,
                        @Nonnull TooltipFlag flagIn) {
                    tooltip.add(
                            TextComponentHelper
                                    .createComponentTranslation(
                                            CommandSource.NULL,
                                            "indestructible",
                                            new Object())
                                    .withStyle(ChatFormatting.GOLD));

                    super.appendHoverText(stack, worldIn, tooltip, flagIn);
                }

                @Override
                public boolean isCorrectToolForDrops(
                        ItemStack stack,
                        BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_PICKAXE))
                        return TierSortingRegistry.isCorrectTierForDrops(
                                ToolTiers.ALLTHEMODIUM_TIER,
                                state);
                    if (state.is(ToolTiers.ALLTHEMODIUM_TOOL_TAG))
                        return TierSortingRegistry.isCorrectTierForDrops(
                                ToolTiers.ALLTHEMODIUM_TIER,
                                state);
                    return false;
                }
            });

    public static final RegistryObject<AxeItem> ALLTHEMODIUM_AXE = ITEMS.register(
            "allthemodium_axe",
            () -> new AxeItem(
                    ToolTiers.ALLTHEMODIUM_TIER,
                    6,
                    1.0f,
                    new Item.Properties()
                            .fireResistant()
                            .tab(AllTheModium.GROUP)
                            .rarity(Rarity.EPIC)) {
                @Override
                public float getDestroySpeed(
                        @Nonnull ItemStack stack,
                        @Nonnull BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_AXE))
                        return speed;
                    return super.getDestroySpeed(stack, state);
                }

                @Override
                public boolean isEnchantable(@Nonnull ItemStack stack) {
                    return true;
                }

                @Override
                public boolean canBeDepleted() {
                    return false;
                }

                @Override
                public void appendHoverText(
                        @Nonnull ItemStack stack,
                        @Nullable Level worldIn,
                        @Nonnull List<Component> tooltip,
                        @Nonnull TooltipFlag flagIn) {
                    tooltip.add(
                            TextComponentHelper
                                    .createComponentTranslation(
                                            CommandSource.NULL,
                                            "indestructible",
                                            new Object())
                                    .withStyle(ChatFormatting.GOLD));

                    super.appendHoverText(stack, worldIn, tooltip, flagIn);
                }

                @Override
                public boolean isCorrectToolForDrops(
                        ItemStack stack,
                        BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_AXE))
                        return TierSortingRegistry.isCorrectTierForDrops(
                                ToolTiers.ALLTHEMODIUM_TIER,
                                state);
                    if (state.is(ToolTiers.ALLTHEMODIUM_TOOL_TAG))
                        return TierSortingRegistry.isCorrectTierForDrops(
                                ToolTiers.ALLTHEMODIUM_TIER,
                                state);
                    return false;
                }
            });

    public static final RegistryObject<ShovelItem> ALLTHEMODIUM_SHOVEL = ITEMS.register(
            "allthemodium_shovel",
            () -> new ShovelItem(
                    ToolTiers.ALLTHEMODIUM_TIER,
                    1,
                    1.5f,
                    new Item.Properties()
                            .fireResistant()
                            .tab(AllTheModium.GROUP)
                            .rarity(Rarity.EPIC)) {
                @Override
                public float getDestroySpeed(
                        @Nonnull ItemStack stack,
                        @Nonnull BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_SHOVEL))
                        return speed;
                    return super.getDestroySpeed(stack, state);
                }

                @Override
                public void appendHoverText(
                        @Nonnull ItemStack stack,
                        @Nullable Level worldIn,
                        @Nonnull List<Component> tooltip,
                        @Nonnull TooltipFlag flagIn) {
                    tooltip.add(
                            TextComponentHelper
                                    .createComponentTranslation(
                                            CommandSource.NULL,
                                            "indestructible",
                                            new Object())
                                    .withStyle(ChatFormatting.GOLD));

                    super.appendHoverText(stack, worldIn, tooltip, flagIn);
                }

                @Override
                public boolean isEnchantable(@Nonnull ItemStack stack) {
                    return true;
                }

                @Override
                public boolean canBeDepleted() {
                    return false;
                }

                @Override
                public boolean isCorrectToolForDrops(
                        ItemStack stack,
                        BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_SHOVEL))
                        return TierSortingRegistry.isCorrectTierForDrops(
                                ToolTiers.ALLTHEMODIUM_TIER,
                                state);
                    if (state.is(ToolTiers.ALLTHEMODIUM_TOOL_TAG))
                        return TierSortingRegistry.isCorrectTierForDrops(
                                ToolTiers.ALLTHEMODIUM_TIER,
                                state);
                    return false;
                }
            });

    public static final RegistryObject<HoeItem> ALLTHEMODIUM_HOE = ITEMS.register(
            "allthemodium_hoe",
            () -> new HoeItem(
                    ToolTiers.ALLTHEMODIUM_TIER,
                    0,
                    1.5f,
                    new Item.Properties()
                            .fireResistant()
                            .tab(AllTheModium.GROUP)
                            .rarity(Rarity.EPIC)) {
                @Override
                public float getDestroySpeed(
                        @Nonnull ItemStack stack,
                        @Nonnull BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_HOE))
                        return speed;
                    return super.getDestroySpeed(stack, state);
                }

                @Override
                public boolean isEnchantable(@Nonnull ItemStack stack) {
                    return true;
                }

                @Override
                public boolean canBeDepleted() {
                    return false;
                }

                @Override
                public void appendHoverText(
                        @Nonnull ItemStack stack,
                        @Nullable Level worldIn,
                        @Nonnull List<Component> tooltip,
                        @Nonnull TooltipFlag flagIn) {
                    tooltip.add(
                            TextComponentHelper
                                    .createComponentTranslation(
                                            CommandSource.NULL,
                                            "indestructible",
                                            new Object())
                                    .withStyle(ChatFormatting.GOLD));

                    super.appendHoverText(stack, worldIn, tooltip, flagIn);
                }

                @Override
                public boolean isCorrectToolForDrops(
                        ItemStack stack,
                        BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_HOE))
                        return TierSortingRegistry.isCorrectTierForDrops(
                                ToolTiers.ALLTHEMODIUM_TIER,
                                state);
                    if (state.is(ToolTiers.ALLTHEMODIUM_TOOL_TAG))
                        return TierSortingRegistry.isCorrectTierForDrops(
                                ToolTiers.ALLTHEMODIUM_TIER,
                                state);
                    return false;
                }
            });

    public static final RegistryObject<Block> UA_ALLOY = BLOCKS.register(
            "unobtainium_allthemodium_alloy_block",
            UAAlloyBlock::new);
    public static final RegistryObject<Block> UV_ALLOY = BLOCKS.register(
            "unobtainium_vibranium_alloy_block",
            UVAlloyBlock::new);
    public static final RegistryObject<Block> VA_ALLOY = BLOCKS.register(
            "vibranium_allthemodium_alloy_block",
            VAAlloyBlock::new);

    public static final RegistryObject<Item> UA_ALLOY_ITEM = ITEMS.register(
            "unobtainium_allthemodium_alloy_block",
            () -> new BlockItem(
                    UA_ALLOY.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> UV_ALLOY_ITEM = ITEMS.register(
            "unobtainium_vibranium_alloy_block",
            () -> new BlockItem(
                    UV_ALLOY.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<Item> VA_ALLOY_ITEM = ITEMS.register(
            "vibranium_allthemodium_alloy_block",
            () -> new BlockItem(
                    VA_ALLOY.get(),
                    new Item.Properties().tab(AllTheModium.GROUP)));

    public static final RegistryObject<Item> PIGLICH_HEART = ITEMS.register(
            "piglich_heart",
            () -> new PiglichHeart(new Item.Properties().tab(AllTheModium.GROUP)));
    public static final RegistryObject<EntityType<PiglichEntity>> PIGLICH = createMonsterEntity(
            "piglich",
            PiglichEntity::new,
            0.6F,
            3.0F,
            0x000000,
            0xebe834);

    private static <T extends Monster> RegistryObject<EntityType<T>> createMonsterEntity(
            String name,
            EntityType.EntityFactory<T> factory,
            float width,
            float height,
            int eggPrimary,
            int eggSecondary) {
        ResourceLocation location = new ResourceLocation(
                Reference.MOD_ID,
                name);

        return ENTITIES.register(
                name,
                () -> EntityType.Builder
                        .of(factory, MobCategory.MONSTER)
                        .sized(width, height)
                        .setTrackingRange(64)
                        .setUpdateInterval(1)
                        .build(location.toString()));
        // EntityType<T> entity = EntityType.Builder.of(factory,
        //         MobCategory.MONSTER).sized(width,
        //                 height)
        //         .setTrackingRange(64).setUpdateInterval(1).build(location.toString());
        // Item spawnEgg = new SpawnEggItem(entity, eggPrimary, eggSecondary,
        //         (new Item.Properties()).tab(AllTheModium.GROUP));
        // spawnEgg.setRegistryName(new ResourceLocation(Reference.MOD_ID, name +
        //         "_spawn_egg"));
        // SPAWN_EGGS.add(spawnEgg);

        // return ENTITIES.register(name, () -> entity);
    }

    // private static <T extends AbstractGolem> RegistryObject<EntityType<T>> createShulkerEntity(String name,
    //         EntityType.EntityFactory<T> factory, float width, float height, int eggPrimary, int eggSecondary) {
    //     ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
    //     EntityType<T> entity = EntityType.Builder.of(factory,
    //             MobCategory.MONSTER).sized(width,
    //                     height)
    //             .setTrackingRange(64).setUpdateInterval(1).build(location.toString());
    //     Item spawnEgg = new SpawnEggItem(entity, eggPrimary, eggSecondary,
    //             (new Item.Properties()).tab(AllTheModium.GROUP));
    //     spawnEgg.setRegistryName(new ResourceLocation(Reference.MOD_ID, name +
    //             "_spawn_egg"));
    //     SPAWN_EGGS.add(spawnEgg);

    //     return ENTITIES.register(name, () -> entity);
    // }

    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(PIGLICH.get(), PiglichEntity.createAttributes().build());
        // event.put(ATM_SHULKER.get(), UNOBShulkerEntity.createAttributes().build());
    }

    private static RotatedPillarBlock log(
            MaterialColor color1,
            MaterialColor color2) {
        return new RotatedPillarBlock(
                BlockBehaviour.Properties
                        .of(
                                Material.NETHER_WOOD,
                                woodLog -> {
                                    return (woodLog.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y)
                                            ? color1
                                            : color2;
                                })
                        .strength(2.0F)
                        .sound(SoundType.WOOD));
    }
}
