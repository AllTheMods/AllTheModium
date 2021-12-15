package com.thevortex.allthemodium.registry;

import com.thevortex.allthemodium.AllTheModium;
import com.thevortex.allthemodium.blocks.*;
import com.thevortex.allthemodium.blocks.Allthemodium_Block;
import com.thevortex.allthemodium.blocks.Allthemodium_Ore;
import com.thevortex.allthemodium.blocks.TeleportPad;
import com.thevortex.allthemodium.blocks.Unobtainium_Block;
import com.thevortex.allthemodium.blocks.Unobtainium_Ore;
import com.thevortex.allthemodium.blocks.Vibranium_Block;
import com.thevortex.allthemodium.blocks.Vibranium_Ore;
import com.thevortex.allthemodium.entity.PiglichEntity;
import com.thevortex.allthemodium.items.*;
import com.thevortex.allthemodium.material.ToolTiers;
import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.worldgen.features.AncientTreeGrower;
import com.thevortex.allthemodium.worldgen.features.OtherDripstoneCluster;
import com.thevortex.allthemodium.worldgen.features.Volcano;
import com.thevortex.allthemodium.worldgen.features.VolcanoConfig;
import com.thevortex.allthemodium.worldgen.carvers.OtherCanyonCarver;
import com.thevortex.allthemodium.worldgen.carvers.OtherCarver;
import com.thevortex.allthemodium.worldgen.carvers.OtherCaveCarver;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.carver.CanyonCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.DripstoneClusterConfiguration;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;

import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModRegistry {


	public static final DeferredRegister<Block> SHAPED_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			Reference.MOD_ID);
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			Reference.MOD_ID);
	public static final DeferredRegister<Block> PILLARBLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			Reference.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS,
			Reference.MOD_ID);
	public static final DeferredRegister<BlockEntityType<?>> ENTITY = DeferredRegister
			.create(ForgeRegistries.BLOCK_ENTITIES, Reference.MOD_ID);
	public static final DeferredRegister<WorldCarver<?>> CARVERS = DeferredRegister
			.create(ForgeRegistries.WORLD_CARVERS, Reference.MOD_ID);
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister
			.create(ForgeRegistries.ENTITIES, Reference.MOD_ID);

	public static final DeferredRegister<Feature<?>> FEATURES =
			DeferredRegister.create(ForgeRegistries.FEATURES, Reference.MOD_ID);

	private static ArrayList<Item> SPAWN_EGGS = new ArrayList<Item>();

	public static final ResourceLocation SOUL_LAVA_STILL = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/soul_lava_still");
	public static final ResourceLocation SOUL_LAVA_FLOW = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/soul_lava_flow");

	public static final ResourceLocation ATM_MOLTEN_STILL = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/atm_molten_still");
	public static final ResourceLocation ATM_MOLTEN_FLOW = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/atm_molten_flow");

	public static final ResourceLocation ATM_VAPOR_STILL = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/molten_metal");
	public static final ResourceLocation ATM_VAPOR_FLOW = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/molten_metal_flow");


	public static final ResourceLocation ATM_SHULKER = new ResourceLocation("minecraft", "block/shulker_box");

	public static final ResourceLocation UNOBTAINIUM_MOLTEN_STILL = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/unobtainium_molten_still");
	public static final ResourceLocation UNOBTAINIUM_MOLTEN_FLOW = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/unobtainium_molten_flow");

	public static final ResourceLocation UNOBTAINIUM_VAPOR_STILL = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/molten_metal");
	public static final ResourceLocation UNOBTAINIUM_VAPOR_FLOW = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/molten_metal_flow");
	public static final ResourceLocation UNOB_SHULKER = new ResourceLocation("minecraft", "block/shulker_box");

	public static final ResourceLocation VIBRANIUM_MOLTEN_STILL = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/vibranium_molten_still");
	public static final ResourceLocation VIBRANIUM_MOLTEN_FLOW = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/vibranium_molten_flow");
	public static final ResourceLocation VIBRANIUM_VAPOR_STILL = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/molten_metal");
	public static final ResourceLocation VIBRANIUM_VAPOR_FLOW = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/molten_metal_flow");
	public static final ResourceLocation VIB_SHULKER = new ResourceLocation("minecraft", "block/shulker_box");

	public static Feature<VolcanoConfig> VOLCANO_F = new Volcano(VolcanoConfig.CODEC);
	public static RegistryObject<Feature<VolcanoConfig>> VOLCANO = FEATURES.register("volcano", () -> VOLCANO_F);
	public static Feature<DripstoneClusterConfiguration> DRIPSTONE_F = new OtherDripstoneCluster(DripstoneClusterConfiguration.CODEC);
	public static RegistryObject<Feature<DripstoneClusterConfiguration>> DRIPSTONE_CLUSTER = FEATURES.register("dripstone_cluster", () -> DRIPSTONE_F);


	/* public static final RegistryObject<Source> moltenAllthemodium = FLUIDS.register("molten_allthemodium",
			() -> new ForgeFlowingFluid.Source(makeATMProperties()));
	public static final RegistryObject<Flowing> flowing_moltenAllthemodium = FLUIDS
			.register("flowing_molten_allthemodium", () -> new ForgeFlowingFluid.Flowing(makeATMProperties()));

	public static final RegistryObject<Source> vaporAllthemodium = FLUIDS.register("vapor_allthemodium",
			() -> new ForgeFlowingFluid.Source(makeATMGasProperties()));

	public static final RegistryObject<Flowing> flowing_vaporAllthemodium = FLUIDS
			.register("flowing_vapor_allthemodium", () -> new ForgeFlowingFluid.Flowing(makeATMGasProperties()));

	public static final RegistryObject<LiquidBlock> molten_allthemodium_block = BLOCKS
			.register("molten_allthemodium_block", () -> new LiquidBlock(moltenAllthemodium,
					Block.Properties.of(Material.LAVA).lightLevel((state) -> {
						return 12;
					}).strength(100.0F).noDrops()));
	public static final RegistryObject<LiquidBlock> vapor_allthemodium_block = BLOCKS
			.register("vapor_allthemodium_block", () -> new LiquidBlock(vaporAllthemodium,
					Block.Properties.of(Material.LAVA).lightLevel((state) -> {
						return 12;
					}).strength(100.0F).noDrops()));
	public static final RegistryObject<Item> moltenAllthemodium_bucket = ITEMS.register("molten_allthemodium_bucket",
			() -> new BucketItem(moltenAllthemodium,
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(ModItems.group)));
	public static final RegistryObject<Item> vaporAllthemodium_bucket = ITEMS.register("vapor_allthemodium_bucket",
			() -> new BucketItem(vaporAllthemodium,
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(ModItems.group)));

	public static final RegistryObject<Source> moltenVibranium = FLUIDS.register("molten_vibranium",
			() -> new ForgeFlowingFluid.Source(makeVibProperties()));
	public static final RegistryObject<Flowing> flowing_moltenVibranium = FLUIDS.register("flowing_molten_vibranium",
			() -> new ForgeFlowingFluid.Flowing(makeVibProperties()));

	public static final RegistryObject<Source> vaporVibranium = FLUIDS.register("vapor_vibranium",
			() -> new ForgeFlowingFluid.Source(makeVibGasProperties()));
	public static final RegistryObject<Flowing> flowing_vaporVibranium = FLUIDS.register("flowing_vapor_vibranium",
			() -> new ForgeFlowingFluid.Flowing(makeVibGasProperties()));

	public static final RegistryObject<LiquidBlock> molten_vibranium_block = BLOCKS
			.register("molten_vibranium_block", () -> new LiquidBlock(moltenVibranium,
					Block.Properties.of(Material.LAVA).lightLevel((state) -> {
						return 10;
					}).strength(100.0F).noDrops()));
	public static final RegistryObject<LiquidBlock> vapor_vibranium_block = BLOCKS
			.register("vapor_vibranium_block", () -> new LiquidBlock(moltenVibranium,
					Block.Properties.of(Material.LAVA).lightLevel((state) -> {
						return 10;
					}).strength(100.0F).noDrops()));
	public static final RegistryObject<Item> moltenVibranium_bucket = ITEMS.register("molten_vibranium_bucket",
			() -> new BucketItem(moltenVibranium,
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(ModItems.group)));
	public static final RegistryObject<Item> vaporVibranium_bucket = ITEMS.register("vapor_vibranium_bucket",
			() -> new BucketItem(moltenVibranium,
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(ModItems.group)));

	public static final RegistryObject<Source> moltenUnobtainium = FLUIDS.register("molten_unobtainium",
			() -> new ForgeFlowingFluid.Source(makeUnobProperties()));
	public static final RegistryObject<Flowing> flowing_moltenUnobtainium = FLUIDS
			.register("flowing_molten_unobtainium", () -> new ForgeFlowingFluid.Flowing(makeUnobProperties()));
	public static final RegistryObject<Source> vaporUnobtainium = FLUIDS.register("vapor_unobtainium",
			() -> new ForgeFlowingFluid.Source(makeUnobGasProperties()));
	public static final RegistryObject<Flowing> flowing_vaporUnobtainium = FLUIDS
			.register("flowing_vapor_unobtainium", () -> new ForgeFlowingFluid.Flowing(makeUnobGasProperties()));

	public static final RegistryObject<LiquidBlock> molten_unobtainium_block = BLOCKS
			.register("molten_unobtainium_block", () -> new LiquidBlock(moltenUnobtainium,
					Block.Properties.of(Material.LAVA).lightLevel((state) -> {
						return 6;
					}).strength(100.0F).noDrops()));
	public static final RegistryObject<LiquidBlock> vapor_unobtainium_block = BLOCKS
			.register("vapor_unobtainium_block", () -> new LiquidBlock(moltenUnobtainium,
					Block.Properties.of(Material.LAVA).lightLevel((state) -> {
						return 6;
					}).strength(100.0F).noDrops()));
	public static final RegistryObject<Item> moltenUnobtainium_bucket = ITEMS.register("molten_unobtainium_bucket",
			() -> new BucketItem(moltenUnobtainium,
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(ModItems.group)));
	public static final RegistryObject<Item> vaporUnobtainium_bucket = ITEMS.register("vapor_unobtainium_bucket",
			() -> new BucketItem(vaporUnobtainium,
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(ModItems.group)));

*//*
	public static final RegistryObject<Source> blueLava = FLUIDS.register("soul_lava",
			() -> new ForgeFlowingFluid.Source(makeBlueLavaProperties()));
	public static final RegistryObject<Flowing> flowing_blueLava = FLUIDS.register("flowing_soul_lava",
			() -> new ForgeFlowingFluid.Flowing(makeBlueLavaProperties()));

	public static final RegistryObject<LiquidBlock> molten_BlueLava_block = BLOCKS
			.register("soul_lava_block", () -> new FluidBlock(blueLava,
					Block.Properties.of(Material.LAVA).randomTicks().lightLevel((state) -> {
						return 15;
					}).noOcclusion().strength(100.0F).jumpFactor(0.1F).speedFactor(0.01F).noDrops()));
	public static final RegistryObject<Item> moltenBluelava_bucket = ITEMS.register("soul_lava_bucket",
			() -> new SoulBucket(blueLava,
					new BucketItem.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(ModItems.group)));


	private static ForgeFlowingFluid.Properties makeATMProperties() {
		return new ForgeFlowingFluid.Properties(moltenAllthemodium, flowing_moltenAllthemodium,
				FluidAttributes.builder(ATM_MOLTEN_STILL, ATM_MOLTEN_FLOW).overlay(ATM_MOLTEN_STILL).color(0xFFFFEF0E))
						.bucket(moltenAllthemodium_bucket).block(molten_allthemodium_block);
	}
	private static ForgeFlowingFluid.Properties makeATMGasProperties() {
		return new ForgeFlowingFluid.Properties(vaporAllthemodium, flowing_vaporAllthemodium,
				FluidAttributes.builder(ATM_VAPOR_STILL, ATM_VAPOR_FLOW).gaseous().overlay(ATM_MOLTEN_STILL).color(0xFFFFEF0E))
				.bucket(vaporAllthemodium_bucket).block(vapor_allthemodium_block);
	}
	private static ForgeFlowingFluid.Properties makeVibProperties() {
		return new ForgeFlowingFluid.Properties(moltenVibranium, flowing_moltenVibranium,
				FluidAttributes.builder(VIBRANIUM_MOLTEN_STILL, VIBRANIUM_MOLTEN_FLOW).overlay(VIBRANIUM_MOLTEN_STILL)
						.color(0xFF26DE88)).bucket(moltenVibranium_bucket).block(molten_vibranium_block);

	}
	private static ForgeFlowingFluid.Properties makeVibGasProperties() {
		return new ForgeFlowingFluid.Properties(vaporVibranium, flowing_vaporVibranium,
				FluidAttributes.builder(VIBRANIUM_VAPOR_STILL, VIBRANIUM_VAPOR_FLOW).gaseous().overlay(VIBRANIUM_MOLTEN_STILL)
						.color(0xFF26DE88)).bucket(vaporVibranium_bucket).block(vapor_vibranium_block);

	}
	private static ForgeFlowingFluid.Properties makeUnobProperties() {
		return new ForgeFlowingFluid.Properties(moltenUnobtainium, flowing_moltenUnobtainium,
				FluidAttributes.builder(UNOBTAINIUM_MOLTEN_STILL, UNOBTAINIUM_MOLTEN_FLOW)
						.overlay(UNOBTAINIUM_MOLTEN_STILL).color(0xFFD152E3)).bucket(moltenUnobtainium_bucket)
								.block(molten_unobtainium_block);
	}
	private static ForgeFlowingFluid.Properties makeUnobGasProperties() {
		return new ForgeFlowingFluid.Properties(vaporUnobtainium, flowing_vaporUnobtainium,
				FluidAttributes.builder(UNOBTAINIUM_VAPOR_STILL, UNOBTAINIUM_VAPOR_FLOW).gaseous()
						.overlay(UNOBTAINIUM_MOLTEN_STILL).color(0xFFD152E3)).bucket(vaporUnobtainium_bucket)
				.block(vapor_unobtainium_block);
	}


	private static ForgeFlowingFluid.Properties makeBlueLavaProperties() {
		return new ForgeFlowingFluid.Properties(blueLava, flowing_blueLava,
				FluidAttributes.builder(SOUL_LAVA_STILL, SOUL_LAVA_FLOW).overlay(SOUL_LAVA_STILL).color(0xFF8AFBFF)
						.luminosity(15).density(3000).viscosity(3000).temperature(5000)).bucket(moltenBluelava_bucket)
								.block(molten_BlueLava_block);
	}
*/
	public static final Block ANCIENT_STONE_WORLDGEN = new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5f));
	public static final RegistryObject<Block> ANCIENT_SMOOTH_STONE = BLOCKS.register("ancient_smooth_stone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5f)));
	public static final RegistryObject<Block> ANCIENT_STONE = BLOCKS.register("ancient_stone", () -> ANCIENT_STONE_WORLDGEN);
	public static final RegistryObject<Block> ANCIENT_DIRT = BLOCKS.register("ancient_dirt", () -> new AncientDirt(BlockBehaviour.Properties.of(Material.DIRT).sound(SoundType.WET_GRASS).strength(0.6f)));
	public static final RegistryObject<Block> ANCIENT_GRASS = BLOCKS.register("ancient_grass", () -> new Ancient_Grass(BlockBehaviour.Properties.of(Material.DIRT).sound(SoundType.MOSS).strength(0.6f)));
	public static final RegistryObject<Block> ANCIENT_MOSSY_STONE = BLOCKS.register("ancient_mossy_stone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.MOSS_CARPET).strength(1.5f)));
	public static final RegistryObject<Block> ANCIENT_STONE_BRICKS = BLOCKS.register("ancient_stone_bricks", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.NETHER_BRICKS).strength(1.5f)));
	public static final RegistryObject<Block> ANCIENT_CHISELED_STONE_BRICKS = BLOCKS.register("ancient_chiseled_stone_bricks", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.NETHER_BRICKS).strength(1.5f)));
	public static final RegistryObject<Block> ANCIENT_CRACKED_STONE_BRICKS = BLOCKS.register("ancient_cracked_stone_bricks", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.NETHER_BRICKS).strength(1.5f)));
	public static final RegistryObject<Block> ANCIENT_POLISHED_STONE = BLOCKS.register("ancient_polished_stone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.METAL).strength(1.5f)));
	public static final RegistryObject<Block> ANCIENT_LOG_0 = PILLARBLOCKS.register("ancient_log_0",() -> log(MaterialColor.WOOD, MaterialColor.WOOD));
	public static final RegistryObject<Block> ANCIENT_LOG_1 = PILLARBLOCKS.register("ancient_log_1",() -> log(MaterialColor.WOOD, MaterialColor.WOOD));
	public static final RegistryObject<Block> ANCIENT_LOG_2 = PILLARBLOCKS.register("ancient_log_2",() -> log(MaterialColor.WOOD, MaterialColor.WOOD));
	public static final RegistryObject<Block> ANCIENT_LOG_STRIPPED = PILLARBLOCKS.register("stripped_ancient_log",() -> log(MaterialColor.WOOD, MaterialColor.WOOD));
	public static final RegistryObject<Block> ANCIENT_LEAVES = BLOCKS.register("ancient_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.AZALEA_LEAVES).noOcclusion().color(MaterialColor.COLOR_PURPLE)));
	public static final RegistryObject<Block> ANCIENT_PLANKS = BLOCKS.register("ancient_planks", () -> new Block(BlockBehaviour.Properties.of(Material.NETHER_WOOD).strength(0.8F).randomTicks().sound(SoundType.WOOD)));
	//public static final RegistryObject<Block> ANCIENT_TRAPDOOR = PILLARBLOCKS.register("ancient_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.NETHER_WOOD).strength(0.2F).randomTicks().sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ANCIENT_BOOKSHELF = PILLARBLOCKS.register("ancient_bookshelf", () -> log(MaterialColor.WOOD, MaterialColor.WOOD));
	public static final RegistryObject<Block> ANCIENT_SAPLING = PILLARBLOCKS.register("ancient_sapling",() -> new AncientSaplingBlock(new AncientTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().dynamicShape().sound(SoundType.GRASS)));

	public static final RegistryObject<Item> ANCIENT_LOG_0_ITEM = ITEMS.register("ancient_log_0",() -> new BlockItem(ANCIENT_LOG_0.get(),new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ANCIENT_LOG_1_ITEM = ITEMS.register("ancient_log_1",() -> new BlockItem(ANCIENT_LOG_1.get(),new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ANCIENT_LOG_2_ITEM = ITEMS.register("ancient_log_2",() -> new BlockItem(ANCIENT_LOG_2.get(),new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ANCIENT_LOG_STRIPPED_ITEM = ITEMS.register("stripped_ancient_log",() -> new BlockItem(ANCIENT_LOG_STRIPPED.get(),new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ANCIENT_LEAVES_ITEM = ITEMS.register("ancient_leaves", () -> new BlockItem(ANCIENT_LEAVES.get(),new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ANCIENT_PLANKS_ITEM = ITEMS.register("ancient_planks", () -> new BlockItem(ANCIENT_PLANKS.get(),new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ANCIENT_BOOKSHELF_ITEM = ITEMS.register("ancient_bookshelf", () -> new BlockItem(ANCIENT_BOOKSHELF.get(),new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ANCIENT_SAPLING_ITEM = ITEMS.register("ancient_sapling", () -> new BlockItem(ANCIENT_SAPLING.get(),new Item.Properties().tab(AllTheModium.GROUP)));

	public static final RegistryObject<Item> ANCIENT_SMOOTH_STONE_ITEM = ITEMS.register("ancient_smooth_stone", () -> new BlockItem(ANCIENT_SMOOTH_STONE.get(), new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ANCIENT_STONE_ITEM = ITEMS.register("ancient_stone", () -> new BlockItem(ANCIENT_STONE.get(), new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ANCIENT_DIRT_ITEM = ITEMS.register("ancient_dirt", () -> new BlockItem(ANCIENT_DIRT.get(), new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ANCIENT_GRASS_ITEM = ITEMS.register("ancient_grass", () -> new BlockItem(ANCIENT_GRASS.get(), new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ANCIENT_MOSSY_STONE_ITEM = ITEMS.register("ancient_mossy_stone", () -> new BlockItem(ANCIENT_MOSSY_STONE.get(), new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ANCIENT_STONE_BRICKS_ITEM = ITEMS.register("ancient_stone_bricks", () -> new BlockItem(ANCIENT_STONE_BRICKS.get(), new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ANCIENT_CHISELED_STONE_BRICKS_ITEM = ITEMS.register("ancient_chiseled_stone_bricks", () -> new BlockItem(ANCIENT_CHISELED_STONE_BRICKS.get(), new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ANCIENT_CRACKED_STONE_BRICKS_ITEM = ITEMS.register("ancient_cracked_stone_bricks", () -> new BlockItem(ANCIENT_CRACKED_STONE_BRICKS.get(), new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ANCIENT_POLISHED_STONE_ITEM = ITEMS.register("ancient_polished_stone", () -> new BlockItem(ANCIENT_POLISHED_STONE.get(), new Item.Properties().tab(AllTheModium.GROUP)));

	public static final RegistryObject<Block> ALLTHEMODIUM_ORE = BLOCKS.register("allthemodium_ore", Allthemodium_Ore::new);
	public static final RegistryObject<Block> ALLTHEMODIUM_SLATE_ORE = BLOCKS.register("allthemodium_slate_ore", Allthemodium_Ore::new);

	public static final RegistryObject<Block> VIBRANIUM_ORE = BLOCKS.register("vibranium_ore", Vibranium_Ore::new);
	public static final RegistryObject<Block> UNOBTAINIUM_ORE = BLOCKS.register("unobtainium_ore", Unobtainium_Ore::new);

	public static final RegistryObject<Block> ALLTHEMODIUM_BLOCK = BLOCKS.register("allthemodium_block", Allthemodium_Block::new);
	public static final RegistryObject<Block> VIBRANIUM_BLOCK = BLOCKS.register("vibranium_block", Vibranium_Block::new);
	public static final RegistryObject<Block> UNOBTAINIUM_BLOCK = BLOCKS.register("unobtainium_block", Unobtainium_Block::new);

	public static final RegistryObject<Block> RAW_ALLTHEMODIUM_BLOCK = BLOCKS.register("raw_allthemodium_block", Raw_ATM::new);
	public static final RegistryObject<Block> RAW_VIBRANIUM_BLOCK = BLOCKS.register("raw_vibranium_block", Raw_VIB::new);
	public static final RegistryObject<Block> RAW_UNOBTAINIUM_BLOCK = BLOCKS.register("raw_unobtainium_block", Raw_UNO::new);

	public static final RegistryObject<Item> RAW_ALLTHEMODIUM_BLOCK_ITEM = ITEMS.register("raw_allthemodium_block", () -> new BlockItem(RAW_ALLTHEMODIUM_BLOCK.get(), new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> RAW_VIBRANIUM_BLOCK_ITEM = ITEMS.register("raw_vibranium_block", () -> new BlockItem(RAW_VIBRANIUM_BLOCK.get(), new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> RAW_UNOBTAINIUM_BLOCK_ITEM = ITEMS.register("raw_unobtainium_block", () -> new BlockItem(RAW_UNOBTAINIUM_BLOCK.get(), new Item.Properties().tab(AllTheModium.GROUP)));

	public static final RegistryObject<Item> ALLTHEMODIUM_ORE_ITEM = ITEMS.register("allthemodium_ore", () -> new Allthemodium_Ore_Item(ALLTHEMODIUM_ORE.get(), new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ALLTHEMODIUM_SLATE_ORE_ITEM = ITEMS.register("allthemodium_slate_ore", () -> new Allthemodium_Ore_Item(ALLTHEMODIUM_SLATE_ORE.get(), new Item.Properties().tab(AllTheModium.GROUP)));

	public static final RegistryObject<Item> VIBRANIUM_ORE_ITEM = ITEMS.register("vibranium_ore", () -> new Vibranium_Ore_Item(VIBRANIUM_ORE.get(), new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> UNOBTAINIUM_ORE_ITEM = ITEMS.register("unobtainium_ore", () -> new Unobtainium_Ore_Item(UNOBTAINIUM_ORE.get(), new Item.Properties().tab(AllTheModium.GROUP)));

	public static final RegistryObject<Item> ALLTHEMODIUM_BLOCK_ITEM = ITEMS.register("allthemodium_block", () -> new BlockItem(ALLTHEMODIUM_BLOCK.get(), new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> VIBRANIUM_BLOCK_ITEM = ITEMS.register("vibranium_block", () -> new BlockItem(VIBRANIUM_BLOCK.get(), new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> UNOBTAINIUM_BLOCK_ITEM = ITEMS.register("unobtainium_block", () -> new BlockItem(UNOBTAINIUM_BLOCK.get(), new Item.Properties().tab(AllTheModium.GROUP)));

	public static final RegistryObject<Item> RAW_ALLTHEMODIUM = ITEMS.register("raw_allthemodium", () -> new RawOre(new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> RAW_VIBRANIUM = ITEMS.register("raw_vibranium", () -> new RawOre(new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> RAW_UNOBTAINIUM = ITEMS.register("raw_unobtainium", () -> new RawOre(new Item.Properties().tab(AllTheModium.GROUP)));

	public static final RegistryObject<Item> ALLTHEMODIUM_INGOT = ITEMS.register("allthemodium_ingot", () -> new Ingot(new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> VIBRANIUM_INGOT = ITEMS.register("vibranium_ingot", () -> new Ingot(new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> UNOBTAINIUM_INGOT = ITEMS.register("unobtainium_ingot", () -> new Ingot(new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ATM_PLATE = ITEMS.register("allthemodium_plate", () -> new Plate(new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> VIB_PLATE = ITEMS.register("vibranium_plate", () -> new Plate(new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ONOB_PLATE = ITEMS.register("unobtainium_plate", () -> new Plate(new Item.Properties().tab(AllTheModium.GROUP)));

	public static final RegistryObject<Item> ATM_GEAR = ITEMS.register("allthemodium_gear", () -> new Gear(new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> VIB_GEAR = ITEMS.register("vibranium_gear", () -> new Gear(new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ONOB_GEAR = ITEMS.register("unobtainium_gear", () -> new Gear(new Item.Properties().tab(AllTheModium.GROUP)));

	public static final RegistryObject<Item> ATM_ROD = ITEMS.register("allthemodium_rod", () -> new Rod(new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> VIB_ROD = ITEMS.register("vibranium_rod", () -> new Rod(new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ONOB_ROD = ITEMS.register("unobtainium_rod", () -> new Rod(new Item.Properties().tab(AllTheModium.GROUP)));

	public static final RegistryObject<Item> ALLTHEMODIUM_NUGGET = ITEMS.register("allthemodium_nugget", () -> new Nugget(new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> VIBRANIUM_NUGGET = ITEMS.register("vibranium_nugget", () -> new Nugget(new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> UNOBTAINIUM_NUGGET = ITEMS.register("unobtainium_nugget", () -> new Nugget(new Item.Properties().tab(AllTheModium.GROUP)));

	public static final RegistryObject<Item> ALLTHEMODIUM_DUST = ITEMS.register("allthemodium_dust", () -> new Dust(new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> VIBRANIUM_DUST = ITEMS.register("vibranium_dust", () -> new Dust(new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> UNOBTAINIUM_DUST = ITEMS.register("unobtainium_dust", () -> new Dust(new Item.Properties().tab(AllTheModium.GROUP)));

	public static final RegistryObject<Item> ATM_CLUMP = ITEMS.register("allthemodium_clump", () -> new Clump(new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> VIB_CLUMP = ITEMS.register("vibranium_clump", () -> new Clump(new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ONOB_CLUMP = ITEMS.register("unobtainium_clump", () -> new Clump(new Item.Properties().tab(AllTheModium.GROUP)));

	public static final RegistryObject<Item> ATM_SHARD = ITEMS.register("allthemodium_shard", () -> new Shard(new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> VIB_SHARD = ITEMS.register("vibranium_shard", () -> new Shard(new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ONOB_SHARD = ITEMS.register("unobtainium_shard", () -> new Shard(new Item.Properties().tab(AllTheModium.GROUP)));

	public static final RegistryObject<Item> ATM_DIRTY = ITEMS.register("dirty_allthemodium_dust", () -> new DirtyDust(new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> VIB_DIRTY = ITEMS.register("dirty_vibranium_dust", () -> new DirtyDust(new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ONOB_DIRTY = ITEMS.register("dirty_unobtainium_dust", () -> new DirtyDust(new Item.Properties().tab(AllTheModium.GROUP)));

	public static final RegistryObject<Item> ATM_CRYSTAL = ITEMS.register("allthemodium_crystal", () -> new Crystal(new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> VIB_CRYSTAL = ITEMS.register("vibranium_crystal", () -> new Crystal(new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ONOB_CRYSTAL = ITEMS.register("unobtainium_crystal", () -> new Crystal(new Item.Properties().tab(AllTheModium.GROUP)));

	public static final RegistryObject<Block> TELEPORT_PAD = SHAPED_BLOCKS.register("teleport_pad", () -> new TeleportPad(Block.Properties.of(Material.METAL).noDrops().noOcclusion().strength(20.0F)));
	public static final RegistryObject<Item> TELEPORT_PAD_ITEM = ITEMS.register("teleport_pad", () -> new BlockItem(TELEPORT_PAD.get(), new Item.Properties().tab(AllTheModium.GROUP)));

	public static final RegistryObject<Item> ALLTHEMODIUM_SWORD = ITEMS.register("allthemodium_sword",() -> new SwordItem(ToolTiers.ALLTHEMODIUM_TIER,8,1.5f, new Item.Properties().fireResistant().tab(AllTheModium.GROUP)));

	public static final RegistryObject<Item> ALLTHEMODIUM_PICKAXE = ITEMS.register("allthemodium_pickaxe",() -> new PickaxeItem(ToolTiers.ALLTHEMODIUM_TIER,6,1.5f, new Item.Properties().fireResistant().tab(AllTheModium.GROUP)) {
		@Override
		public float getDestroySpeed(ItemStack stack, BlockState state)
		{
			if (state.is(BlockTags.MINEABLE_WITH_PICKAXE)) return speed;
			return super.getDestroySpeed(stack, state);
		}

		@Override
		public boolean isCorrectToolForDrops(ItemStack stack, BlockState state)
		{
			if (state.is(BlockTags.MINEABLE_WITH_PICKAXE))
				return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.ALLTHEMODIUM_TIER, state);
			if (state.is(ToolTiers.ALLTHEMODIUM_TOOL_TAG))
				return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.ALLTHEMODIUM_TIER, state);
			return false;
		}
	});

	public static final RegistryObject<Item> ALLTHEMODIUM_AXE = ITEMS.register("allthemodium_axe",() -> new AxeItem(ToolTiers.ALLTHEMODIUM_TIER,6,1.5f, new Item.Properties().fireResistant().tab(AllTheModium.GROUP)) {
		@Override
		public float getDestroySpeed(ItemStack stack, BlockState state)
		{
			if (state.is(BlockTags.MINEABLE_WITH_AXE)) return speed;
			return super.getDestroySpeed(stack, state);
		}

		@Override
		public boolean isCorrectToolForDrops(ItemStack stack, BlockState state)
		{
			if (state.is(BlockTags.MINEABLE_WITH_AXE))
				return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.ALLTHEMODIUM_TIER, state);
			if (state.is(ToolTiers.ALLTHEMODIUM_TOOL_TAG))
				return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.ALLTHEMODIUM_TIER, state);
			return false;
		}
	});

	public static final RegistryObject<Item> ALLTHEMODIUM_SHOVEL = ITEMS.register("allthemodium_shovel",() -> new ShovelItem(ToolTiers.ALLTHEMODIUM_TIER,4,1.5f, new Item.Properties().fireResistant().tab(AllTheModium.GROUP)) {
		@Override
		public float getDestroySpeed(ItemStack stack, BlockState state)
		{
			if (state.is(BlockTags.MINEABLE_WITH_SHOVEL)) return speed;
			return super.getDestroySpeed(stack, state);
		}

		@Override
		public boolean isCorrectToolForDrops(ItemStack stack, BlockState state)
		{
			if (state.is(BlockTags.MINEABLE_WITH_SHOVEL))
				return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.ALLTHEMODIUM_TIER, state);
			if (state.is(ToolTiers.ALLTHEMODIUM_TOOL_TAG))
				return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.ALLTHEMODIUM_TIER, state);
			return false;
		}
	});

	public static final RegistryObject<Item> ALLTHEMODIUM_HOE = ITEMS.register("allthemodium_hoe",() -> new HoeItem(ToolTiers.ALLTHEMODIUM_TIER,4,1.5f, new Item.Properties().fireResistant().tab(AllTheModium.GROUP)) {
		@Override
		public float getDestroySpeed(ItemStack stack, BlockState state)
		{
			if (state.is(BlockTags.MINEABLE_WITH_HOE)) return speed;
			return super.getDestroySpeed(stack, state);
		}

		@Override
		public boolean isCorrectToolForDrops(ItemStack stack, BlockState state)
		{
			if (state.is(BlockTags.MINEABLE_WITH_HOE))
				return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.ALLTHEMODIUM_TIER, state);
			if (state.is(ToolTiers.ALLTHEMODIUM_TOOL_TAG))
				return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.ALLTHEMODIUM_TIER, state);
			return false;
		}
	});
	public static final RegistryObject<Item> VIBRANIUM_SWORD = ITEMS.register("vibranium_sword",() -> new SwordItem(ToolTiers.VIBRANIUM_TIER,16,3.0f, new Item.Properties().fireResistant().tab(AllTheModium.GROUP)));

	public static final RegistryObject<Item> VIBRANIUM_PICKAXE = ITEMS.register("vibranium_pickaxe",() -> new PickaxeItem(ToolTiers.VIBRANIUM_TIER,12,3.0f, new Item.Properties().fireResistant().tab(AllTheModium.GROUP)) {
		@Override
		public float getDestroySpeed(ItemStack stack, BlockState state)
		{
			if (state.is(BlockTags.MINEABLE_WITH_PICKAXE)) return speed;
			return super.getDestroySpeed(stack, state);
		}

		@Override
		public boolean isCorrectToolForDrops(ItemStack stack, BlockState state)
		{
			if (state.is(BlockTags.MINEABLE_WITH_PICKAXE))
				return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.VIBRANIUM_TIER, state);
			if (state.is(ToolTiers.VIBRANIUM_TOOL_TAG))
				return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.VIBRANIUM_TIER, state);
			return false;
		}
	});

	public static final RegistryObject<Item> VIBRANIUM_AXE = ITEMS.register("vibranium_axe",() -> new AxeItem(ToolTiers.VIBRANIUM_TIER,12,3.0f, new Item.Properties().fireResistant().tab(AllTheModium.GROUP)) {
		@Override
		public float getDestroySpeed(ItemStack stack, BlockState state)
		{
			if (state.is(BlockTags.MINEABLE_WITH_AXE)) return speed;
			return super.getDestroySpeed(stack, state);
		}

		@Override
		public boolean isCorrectToolForDrops(ItemStack stack, BlockState state)
		{
			if (state.is(BlockTags.MINEABLE_WITH_AXE))
				return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.VIBRANIUM_TIER, state);
			if (state.is(ToolTiers.VIBRANIUM_TOOL_TAG))
				return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.VIBRANIUM_TIER, state);
			return false;
		}
	});

	public static final RegistryObject<Item> VIBRANIUM_SHOVEL = ITEMS.register("vibranium_shovel",() -> new ShovelItem(ToolTiers.VIBRANIUM_TIER,8,3.0f, new Item.Properties().fireResistant().tab(AllTheModium.GROUP)) {
		@Override
		public float getDestroySpeed(ItemStack stack, BlockState state)
		{
			if (state.is(BlockTags.MINEABLE_WITH_SHOVEL)) return speed;
			return super.getDestroySpeed(stack, state);
		}

		@Override
		public boolean isCorrectToolForDrops(ItemStack stack, BlockState state)
		{
			if (state.is(BlockTags.MINEABLE_WITH_SHOVEL))
				return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.VIBRANIUM_TIER, state);
			if (state.is(ToolTiers.VIBRANIUM_TOOL_TAG))
				return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.VIBRANIUM_TIER, state);
			return false;
		}
	});

	public static final RegistryObject<Item> VIBRANIUM_HOE = ITEMS.register("vibranium_hoe",() -> new HoeItem(ToolTiers.VIBRANIUM_TIER,8,3.0f, new Item.Properties().fireResistant().tab(AllTheModium.GROUP)) {
		@Override
		public float getDestroySpeed(ItemStack stack, BlockState state)
		{
			if (state.is(BlockTags.MINEABLE_WITH_HOE)) return speed;
			return super.getDestroySpeed(stack, state);
		}

		@Override
		public boolean isCorrectToolForDrops(ItemStack stack, BlockState state)
		{
			if (state.is(BlockTags.MINEABLE_WITH_HOE))
				return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.VIBRANIUM_TIER, state);
			if (state.is(ToolTiers.VIBRANIUM_TOOL_TAG))
				return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.VIBRANIUM_TIER, state);
			return false;
		}
	});
		public static final RegistryObject<Item> UNOBTAINIUM_SWORD = ITEMS.register("unobtainium_sword",() -> new SwordItem(ToolTiers.UNOBTAINIUM_TIER,32,5.0f, new Item.Properties().fireResistant().tab(AllTheModium.GROUP)));

		public static final RegistryObject<Item> UNOBTAINIUM_PICKAXE = ITEMS.register("unobtainium_pickaxe",() -> new PickaxeItem(ToolTiers.UNOBTAINIUM_TIER,24,5.0f, new Item.Properties().fireResistant().tab(AllTheModium.GROUP)) {
		@Override
		public float getDestroySpeed(ItemStack stack, BlockState state)
		{
			if (state.is(BlockTags.MINEABLE_WITH_PICKAXE)) return speed;
			return super.getDestroySpeed(stack, state);
		}

		@Override
		public boolean isCorrectToolForDrops(ItemStack stack, BlockState state)
		{
			if (state.is(BlockTags.MINEABLE_WITH_PICKAXE))
				return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.UNOBTAINIUM_TIER, state);
			if (state.is(ToolTiers.UNOBTAINIUM_TOOL_TAG))
				return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.UNOBTAINIUM_TIER, state);
			return false;
		}
	});

	public static final RegistryObject<Item> UNOBTAINIUM_AXE = ITEMS.register("unobtainium_axe",() -> new AxeItem(ToolTiers.UNOBTAINIUM_TIER,24,5.0f, new Item.Properties().fireResistant().tab(AllTheModium.GROUP)) {
		@Override
		public float getDestroySpeed(ItemStack stack, BlockState state)
		{
			if (state.is(BlockTags.MINEABLE_WITH_AXE)) return speed;
			return super.getDestroySpeed(stack, state);
		}

		@Override
		public boolean isCorrectToolForDrops(ItemStack stack, BlockState state)
		{
			if (state.is(BlockTags.MINEABLE_WITH_AXE))
				return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.UNOBTAINIUM_TIER, state);
			if (state.is(ToolTiers.UNOBTAINIUM_TOOL_TAG))
				return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.UNOBTAINIUM_TIER, state);
			return false;
		}
	});

	public static final RegistryObject<Item> UNOBTAINIUM_SHOVEL = ITEMS.register("unobtainium_shovel",() -> new ShovelItem(ToolTiers.UNOBTAINIUM_TIER,16,5.0f, new Item.Properties().fireResistant().tab(AllTheModium.GROUP)) {
		@Override
		public float getDestroySpeed(ItemStack stack, BlockState state)
		{
			if (state.is(BlockTags.MINEABLE_WITH_SHOVEL)) return speed;
			return super.getDestroySpeed(stack, state);
		}

		@Override
		public boolean isCorrectToolForDrops(ItemStack stack, BlockState state)
		{
			if (state.is(BlockTags.MINEABLE_WITH_SHOVEL))
				return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.UNOBTAINIUM_TIER, state);
			if (state.is(ToolTiers.UNOBTAINIUM_TOOL_TAG))
				return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.UNOBTAINIUM_TIER, state);
			return false;
		}
	});

	public static final RegistryObject<Item> UNOBTAINIUM_HOE = ITEMS.register("unobtainium_hoe",() -> new HoeItem(ToolTiers.UNOBTAINIUM_TIER,16,5.0f, new Item.Properties().fireResistant().tab(AllTheModium.GROUP)) {
		@Override
		public float getDestroySpeed(ItemStack stack, BlockState state)
		{
			if (state.is(BlockTags.MINEABLE_WITH_HOE)) return speed;
			return super.getDestroySpeed(stack, state);
		}

		@Override
		public boolean isCorrectToolForDrops(ItemStack stack, BlockState state)
		{
			if (state.is(BlockTags.MINEABLE_WITH_HOE))
				return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.UNOBTAINIUM_TIER, state);
			if (state.is(ToolTiers.UNOBTAINIUM_TOOL_TAG))
				return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.UNOBTAINIUM_TIER, state);
			return false;
		}
	});
	public static final RegistryObject<Block> UA_ALLOY = BLOCKS.register("unobtainium_allthemodium_alloy_block", UAAlloy_Block::new);
	public static final RegistryObject<Block> UV_ALLOY = BLOCKS.register("unobtainium_vibranium_alloy_block", UVAlloy_Block::new);
	public static final RegistryObject<Block> VA_ALLOY = BLOCKS.register("vibranium_allthemodium_alloy_block", VAAlloy_Block::new);

	public static final RegistryObject<Item> UA_ALLOY_ITEM = ITEMS.register("unobtainium_allthemodium_alloy_block", () -> new BlockItem(UA_ALLOY.get(),new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> UV_ALLOY_ITEM = ITEMS.register("unobtainium_vibranium_alloy_block", () -> new BlockItem(UV_ALLOY.get(),new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> VA_ALLOY_ITEM = ITEMS.register("vibranium_allthemodium_alloy_block", () -> new BlockItem(VA_ALLOY.get(),new Item.Properties().tab(AllTheModium.GROUP)));

	public static final RegistryObject<EntityType<PiglichEntity>> PIGLICH = createMonsterEntity("piglich",PiglichEntity::new,0.6F,3.0F,0x000000,0xebe834);

	public static final WorldCarver<CanyonCarverConfiguration> OTHER_CANYON_CARVER_C = new OtherCanyonCarver(CanyonCarverConfiguration.CODEC);
	public static final RegistryObject<WorldCarver<?>> OTHER_CANYON_CARVER = CARVERS.register("other_canyons", () -> OTHER_CANYON_CARVER_C);
	public static final WorldCarver<CaveCarverConfiguration> OTHER_CARVER_C = new OtherCarver(CaveCarverConfiguration.CODEC);
	public static final RegistryObject<WorldCarver<?>> OTHER_CARVER = CARVERS.register("other_caves", () -> OTHER_CARVER_C);
	public static final WorldCarver<CaveCarverConfiguration> OTHER_CAVE_CARVER_C = new OtherCaveCarver(CaveCarverConfiguration.CODEC);
	public static final RegistryObject<WorldCarver<?>> OTHER_CAVE_CARVER = CARVERS.register("other_caves_2", () -> OTHER_CAVE_CARVER_C);

	private static <T extends Monster> RegistryObject<EntityType<T>> createMonsterEntity(String name, EntityType.EntityFactory<T> factory, float width, float height, int eggPrimary, int eggSecondary) {
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
		EntityType<T> entity = EntityType.Builder.of(factory, MobCategory.MONSTER).sized(width, height).setTrackingRange(64).setUpdateInterval(1).build(location.toString());
		Item spawnEgg = new SpawnEggItem(entity, eggPrimary, eggSecondary, (new Item.Properties()).tab(AllTheModium.GROUP));
		spawnEgg.setRegistryName(new ResourceLocation(Reference.MOD_ID, name + "_spawn_egg"));
		SPAWN_EGGS.add(spawnEgg);

		return ENTITIES.register(name, () -> entity);
	}

	@SubscribeEvent
	public static void addEntityAttributes(EntityAttributeCreationEvent event) {
		event.put(PIGLICH.get(), PiglichEntity.createAttributes().build());
	}
	private static RotatedPillarBlock log(MaterialColor color1, MaterialColor color2) {
		return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.NETHER_WOOD, (woodLog) -> {
			return woodLog.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? color1 : color2;
		}).strength(2.0F).sound(SoundType.WOOD));
	}
/*
	@SubscribeEvent
	public static void registerSpawnEggs(RegistryEvent.Register<Item> event) {
		for (Item spawnEgg : SPAWN_EGGS) {
			Preconditions.checkNotNull(spawnEgg.getRegistryName(), "registryName");
			event.getRegistry().register(spawnEgg);
		}
	}

 */
}
