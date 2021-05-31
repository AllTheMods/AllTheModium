package com.thevortex.allthemodium.fluids;

import com.thevortex.allthemodium.AllTheModium;
import com.thevortex.allthemodium.blocks.FluidBlock;
import com.thevortex.allthemodium.blocks.UAAlloy_Block;
import com.thevortex.allthemodium.blocks.UVAlloy_Block;
import com.thevortex.allthemodium.blocks.VAAlloy_Block;
import com.thevortex.allthemodium.init.ModItems;
import com.thevortex.allthemodium.items.SoulBucket;
import com.thevortex.allthemodium.reference.Reference;

import net.allthemods.alltheores.meka.Clump;
import net.allthemods.alltheores.meka.Crystal;
import net.allthemods.alltheores.meka.DirtyDust;
import net.allthemods.alltheores.meka.Shard;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.ForgeFlowingFluid.Flowing;
import net.minecraftforge.fluids.ForgeFlowingFluid.Source;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FluidList {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			Reference.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS,
			Reference.MOD_ID);
	public static final DeferredRegister<TileEntityType<?>> ENTITY = DeferredRegister
			.create(ForgeRegistries.TILE_ENTITIES, Reference.MOD_ID);


	public static final ResourceLocation SOUL_LAVA_STILL = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/soul_lava_still");
	public static final ResourceLocation SOUL_LAVA_FLOW = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/soul_lava_flow");

	public static final ResourceLocation ATM_MOLTEN_STILL = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/atm_molten_still");
	public static final ResourceLocation ATM_MOLTEN_FLOW = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/atm_molten_flow");

	public static final ResourceLocation ATM_VAPOR_STILL = new ResourceLocation(Reference.MOD_ID,
			"blocks/fluids/molten_metal");
	public static final ResourceLocation ATM_VAPOR_FLOW = new ResourceLocation(Reference.MOD_ID,
			"blocks/fluids/molten_metal_flow");


	public static final ResourceLocation ATM_SHULKER = new ResourceLocation("minecraft", "block/shulker_box");

	public static final ResourceLocation UNOBTAINIUM_MOLTEN_STILL = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/unobtainium_molten_still");
	public static final ResourceLocation UNOBTAINIUM_MOLTEN_FLOW = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/unobtainium_molten_flow");

	public static final ResourceLocation UNOBTAINIUM_VAPOR_STILL = new ResourceLocation(Reference.MOD_ID,
			"blocks/fluids/molten_metal");
	public static final ResourceLocation UNOBTAINIUM_VAPOR_FLOW = new ResourceLocation(Reference.MOD_ID,
			"blocks/fluids/molten_metal_flow");
	public static final ResourceLocation UNOB_SHULKER = new ResourceLocation("minecraft", "block/shulker_box");

	public static final ResourceLocation VIBRANIUM_MOLTEN_STILL = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/vibranium_molten_still");
	public static final ResourceLocation VIBRANIUM_MOLTEN_FLOW = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/vibranium_molten_flow");
	public static final ResourceLocation VIBRANIUM_VAPOR_STILL = new ResourceLocation(Reference.MOD_ID,
			"blocks/fluids/molten_metal");
	public static final ResourceLocation VIBRANIUM_VAPOR_FLOW = new ResourceLocation(Reference.MOD_ID,
			"blocks/fluids/molten_metal_flow");
	public static final ResourceLocation VIB_SHULKER = new ResourceLocation("minecraft", "block/shulker_box");



	public static final RegistryObject<Source> moltenAllthemodium = FLUIDS.register("molten_allthemodium",
			() -> new ForgeFlowingFluid.Source(makeATMProperties()));
	public static final RegistryObject<Flowing> flowing_moltenAllthemodium = FLUIDS
			.register("flowing_molten_allthemodium", () -> new ForgeFlowingFluid.Flowing(makeATMProperties()));

	public static final RegistryObject<Source> vaporAllthemodium = FLUIDS.register("vapor_allthemodium",
			() -> new ForgeFlowingFluid.Source(makeATMGasProperties()));

	public static final RegistryObject<Flowing> flowing_vaporAllthemodium = FLUIDS
			.register("flowing_vapor_allthemodium", () -> new ForgeFlowingFluid.Flowing(makeATMGasProperties()));

	public static final RegistryObject<FlowingFluidBlock> molten_allthemodium_block = BLOCKS
			.register("molten_allthemodium_block", () -> new FlowingFluidBlock(moltenAllthemodium,
					Block.Properties.of(Material.LAVA).lightLevel((state) -> {
						return 12;
					}).strength(100.0F).noDrops()));
	public static final RegistryObject<FlowingFluidBlock> vapor_allthemodium_block = BLOCKS
			.register("vapor_allthemodium_block", () -> new FlowingFluidBlock(vaporAllthemodium,
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

	public static final RegistryObject<FlowingFluidBlock> molten_vibranium_block = BLOCKS
			.register("molten_vibranium_block", () -> new FlowingFluidBlock(moltenVibranium,
					Block.Properties.of(Material.LAVA).lightLevel((state) -> {
						return 10;
					}).strength(100.0F).noDrops()));
	public static final RegistryObject<FlowingFluidBlock> vapor_vibranium_block = BLOCKS
			.register("vapor_vibranium_block", () -> new FlowingFluidBlock(moltenVibranium,
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

	public static final RegistryObject<FlowingFluidBlock> molten_unobtainium_block = BLOCKS
			.register("molten_unobtainium_block", () -> new FlowingFluidBlock(moltenUnobtainium,
					Block.Properties.of(Material.LAVA).lightLevel((state) -> {
						return 6;
					}).strength(100.0F).noDrops()));
	public static final RegistryObject<FlowingFluidBlock> vapor_unobtainium_block = BLOCKS
			.register("vapor_unobtainium_block", () -> new FlowingFluidBlock(moltenUnobtainium,
					Block.Properties.of(Material.LAVA).lightLevel((state) -> {
						return 6;
					}).strength(100.0F).noDrops()));
	public static final RegistryObject<Item> moltenUnobtainium_bucket = ITEMS.register("molten_unobtainium_bucket",
			() -> new BucketItem(moltenUnobtainium,
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(ModItems.group)));
	public static final RegistryObject<Item> vaporUnobtainium_bucket = ITEMS.register("vapor_unobtainium_bucket",
			() -> new BucketItem(vaporUnobtainium,
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(ModItems.group)));

	public static final RegistryObject<Source> blueLava = FLUIDS.register("molten_bluelava",
			() -> new ForgeFlowingFluid.Source(makeBlueLavaProperties()));
	public static final RegistryObject<Flowing> flowing_blueLava = FLUIDS.register("flowing_molten_bluelava",
			() -> new ForgeFlowingFluid.Flowing(makeBlueLavaProperties()));

	public static final RegistryObject<FlowingFluidBlock> molten_BlueLava_block = BLOCKS
			.register("molten_bluelava_block", () -> new FluidBlock(blueLava,
					Block.Properties.of(Material.LAVA).randomTicks().lightLevel((state) -> {
						return 15;
					}).noOcclusion().strength(100.0F).jumpFactor(0.1F).speedFactor(0.01F).noDrops()));
	public static final RegistryObject<Item> moltenBluelava_bucket = ITEMS.register("molten_bluelava_bucket",
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

	public static final RegistryObject<Block> ANCIENT_STONE = BLOCKS.register("ancient_stone", () -> new Block(AbstractBlock.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5f)));
	public static final RegistryObject<Block> ANCIENT_DIRT = BLOCKS.register("ancient_dirt", () -> new Block(AbstractBlock.Properties.of(Material.DIRT).sound(SoundType.GRASS).strength(0.6f)));
	public static final RegistryObject<Block> ANCIENT_GRASS = BLOCKS.register("ancient_grass", () -> new Block(AbstractBlock.Properties.of(Material.DIRT).sound(SoundType.WET_GRASS).strength(0.6f)));

	public static final RegistryObject<Item> ANCIENT_STONE_ITEM = ITEMS.register("ancient_stone", () -> new BlockItem(ANCIENT_STONE.get(), new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ANCIENT_DIRT_ITEM = ITEMS.register("ancient_dirt", () -> new BlockItem(ANCIENT_DIRT.get(), new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ANCIENT_GRASS_ITEM = ITEMS.register("ancient_grass", () -> new BlockItem(ANCIENT_GRASS.get(), new Item.Properties().tab(AllTheModium.GROUP)));

	public static final RegistryObject<Block> UA_ALLOY = BLOCKS.register("unobtainium_allthemodium_alloy_block", UAAlloy_Block::new);
	public static final RegistryObject<Block> UV_ALLOY = BLOCKS.register("unobtainium_vibranium_alloy_block", UVAlloy_Block::new);
	public static final RegistryObject<Block> VA_ALLOY = BLOCKS.register("vibranium_allthemodium_alloy_block", VAAlloy_Block::new);

	public static final RegistryObject<Item> UA_ALLOY_ITEM = ITEMS.register("unobtainium_allthemodium_alloy_block", () -> new BlockItem(UA_ALLOY.get(),new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> UV_ALLOY_ITEM = ITEMS.register("unobtainium_vibranium_alloy_block", () -> new BlockItem(UV_ALLOY.get(),new Item.Properties().tab(AllTheModium.GROUP)));
	public static final RegistryObject<Item> VA_ALLOY_ITEM = ITEMS.register("vibranium_allthemodium_alloy_block", () -> new BlockItem(VA_ALLOY.get(),new Item.Properties().tab(AllTheModium.GROUP)));

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

	public static void init(){

	}

}
