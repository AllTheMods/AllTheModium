package com.thevortex.allthemodium.fluids;

import com.thevortex.allthemodium.AllTheModium;
import com.thevortex.allthemodium.blocks.FluidBlock;
import com.thevortex.allthemodium.blocks.UAAlloy_Block;
import com.thevortex.allthemodium.blocks.UVAlloy_Block;
import com.thevortex.allthemodium.blocks.VAAlloy_Block;
import com.thevortex.allthemodium.blocks.portals.OtherPortalBlock;
import com.thevortex.allthemodium.blocks.portals.OtherPortalFrameBlock;
import com.thevortex.allthemodium.blocks.portals.OtherPortalTileEntity;
import com.thevortex.allthemodium.init.ModItems;
import com.thevortex.allthemodium.items.*;
import com.thevortex.allthemodium.reference.Reference;

import mekanism.api.MekanismAPI;
import mekanism.api.chemical.slurry.Slurry;
import mekanism.api.chemical.slurry.SlurryBuilder;
import mekanism.common.registration.impl.SlurryDeferredRegister;
import mekanism.common.resource.PrimaryResource;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tileentity.EndPortalTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.ForgeFlowingFluid.Flowing;
import net.minecraftforge.fluids.ForgeFlowingFluid.Source;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

public class FluidList {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			Reference.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS,
			Reference.MOD_ID);
	public static final DeferredRegister<TileEntityType<?>> ENTITY = DeferredRegister
			.create(ForgeRegistries.TILE_ENTITIES, Reference.MOD_ID);

	public static final RegistryObject<Block> OTHERPORTAL_BLOCK = BLOCKS.register("otherportal_block", () -> new OtherPortalBlock(AbstractBlock.Properties.create(Material.PORTAL, MaterialColor.BLACK).doesNotBlockMovement().setLightLevel((p_235460_0_) -> {
		return 15;
	}).hardnessAndResistance(-1.0F, 3600000.0F).noDrops()));

	public static final RegistryObject<Block> OTHERPORTAL_FRAME = BLOCKS.register("otherportal_frame_block", () -> new OtherPortalFrameBlock(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GREEN).sound(SoundType.GLASS).setLightLevel((p_235459_0_) -> {
		return 1;
	}).hardnessAndResistance(-1.0F, 3600000.0F).noDrops()));

	public static final ResourceLocation SOUL_LAVA_STILL = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/soul_lava_still");
	public static final ResourceLocation SOUL_LAVA_FLOW = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/soul_lava_flow");

	public static final ResourceLocation ATM_MOLTEN_STILL = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/atm_molten_still");
	public static final ResourceLocation ATM_MOLTEN_FLOW = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/atm_molten_flow");
	public static final ResourceLocation ATM_SHULKER = new ResourceLocation("minecraft", "block/shulker_box");

	public static final ResourceLocation UNOBTAINIUM_MOLTEN_STILL = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/unobtainium_molten_still");
	public static final ResourceLocation UNOBTAINIUM_MOLTEN_FLOW = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/unobtainium_molten_flow");
	public static final ResourceLocation UNOB_SHULKER = new ResourceLocation("minecraft", "block/shulker_box");

	public static final ResourceLocation VIBRANIUM_MOLTEN_STILL = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/vibranium_molten_still");
	public static final ResourceLocation VIBRANIUM_MOLTEN_FLOW = new ResourceLocation(Reference.MOD_ID,
			"block/fluid/vibranium_molten_flow");
	public static final ResourceLocation VIB_SHULKER = new ResourceLocation("minecraft", "block/shulker_box");



	public static final RegistryObject<Source> moltenAllthemodium = FLUIDS.register("molten_allthemodium",
			() -> new ForgeFlowingFluid.Source(makeATMProperties()));
	public static final RegistryObject<Flowing> flowing_moltenAllthemodium = FLUIDS
			.register("flowing_molten_allthemodium", () -> new ForgeFlowingFluid.Flowing(makeATMProperties()));

	public static final RegistryObject<FlowingFluidBlock> molten_allthemodium_block = BLOCKS
			.register("molten_allthemodium_block", () -> new FlowingFluidBlock(moltenAllthemodium,
					Block.Properties.create(Material.LAVA).setLightLevel((state) -> {
						return 12;
					}).hardnessAndResistance(100.0F).noDrops()));
	public static final RegistryObject<Item> moltenAllthemodium_bucket = ITEMS.register("molten_allthemodium_bucket",
			() -> new BucketItem(moltenAllthemodium,
					new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModItems.group)));

	public static final RegistryObject<Source> moltenVibranium = FLUIDS.register("molten_vibranium",
			() -> new ForgeFlowingFluid.Source(makeVibProperties()));
	public static final RegistryObject<Flowing> flowing_moltenVibranium = FLUIDS.register("flowing_molten_vibranium",
			() -> new ForgeFlowingFluid.Flowing(makeVibProperties()));

	public static final RegistryObject<FlowingFluidBlock> molten_vibranium_block = BLOCKS
			.register("molten_vibranium_block", () -> new FlowingFluidBlock(moltenVibranium,
					Block.Properties.create(Material.LAVA).setLightLevel((state) -> {
						return 10;
					}).hardnessAndResistance(100.0F).noDrops()));
	public static final RegistryObject<Item> moltenVibranium_bucket = ITEMS.register("molten_vibranium_bucket",
			() -> new BucketItem(moltenVibranium,
					new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModItems.group)));

	public static final RegistryObject<Source> moltenUnobtainium = FLUIDS.register("molten_unobtainium",
			() -> new ForgeFlowingFluid.Source(makeUnobProperties()));
	public static final RegistryObject<Flowing> flowing_moltenUnobtainium = FLUIDS
			.register("flowing_molten_unobtainium", () -> new ForgeFlowingFluid.Flowing(makeUnobProperties()));
	public static final RegistryObject<FlowingFluidBlock> molten_unobtainium_block = BLOCKS
			.register("molten_unobtainium_block", () -> new FlowingFluidBlock(moltenUnobtainium,
					Block.Properties.create(Material.LAVA).setLightLevel((state) -> {
						return 6;
					}).hardnessAndResistance(100.0F).noDrops()));
	public static final RegistryObject<Item> moltenUnobtainium_bucket = ITEMS.register("molten_unobtainium_bucket",
			() -> new BucketItem(moltenUnobtainium,
					new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModItems.group)));

	public static final RegistryObject<Source> blueLava = FLUIDS.register("molten_bluelava",
			() -> new ForgeFlowingFluid.Source(makeBlueLavaProperties()));
	public static final RegistryObject<Flowing> flowing_blueLava = FLUIDS.register("flowing_molten_bluelava",
			() -> new ForgeFlowingFluid.Flowing(makeBlueLavaProperties()));

	public static final RegistryObject<FlowingFluidBlock> molten_BlueLava_block = BLOCKS
			.register("molten_bluelava_block", () -> new FluidBlock(blueLava,
					Block.Properties.create(Material.LAVA).tickRandomly().setLightLevel((state) -> {
						return 15;
					}).variableOpacity().hardnessAndResistance(100.0F).jumpFactor(0.1F).speedFactor(0.01F).noDrops()));
	public static final RegistryObject<Item> moltenBluelava_bucket = ITEMS.register("molten_bluelava_bucket",
			() -> new SoulBucket(blueLava,
					new BucketItem.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModItems.group)));

	private static ForgeFlowingFluid.Properties makeATMProperties() {
		return new ForgeFlowingFluid.Properties(moltenAllthemodium, flowing_moltenAllthemodium,
				FluidAttributes.builder(ATM_MOLTEN_STILL, ATM_MOLTEN_FLOW).overlay(ATM_MOLTEN_STILL).color(0xFFFFEF0E))
						.bucket(moltenAllthemodium_bucket).block(molten_allthemodium_block);
	}

	private static ForgeFlowingFluid.Properties makeVibProperties() {
		return new ForgeFlowingFluid.Properties(moltenVibranium, flowing_moltenVibranium,
				FluidAttributes.builder(VIBRANIUM_MOLTEN_STILL, VIBRANIUM_MOLTEN_FLOW).overlay(VIBRANIUM_MOLTEN_STILL)
						.color(0xFF26DE88)).bucket(moltenVibranium_bucket).block(molten_vibranium_block);

	}

	private static ForgeFlowingFluid.Properties makeUnobProperties() {
		return new ForgeFlowingFluid.Properties(moltenUnobtainium, flowing_moltenUnobtainium,
				FluidAttributes.builder(UNOBTAINIUM_MOLTEN_STILL, UNOBTAINIUM_MOLTEN_FLOW)
						.overlay(UNOBTAINIUM_MOLTEN_STILL).color(0xFFD152E3)).bucket(moltenUnobtainium_bucket)
								.block(molten_unobtainium_block);
	}

	private static ForgeFlowingFluid.Properties makeBlueLavaProperties() {
		return new ForgeFlowingFluid.Properties(blueLava, flowing_blueLava,
				FluidAttributes.builder(SOUL_LAVA_STILL, SOUL_LAVA_FLOW).overlay(SOUL_LAVA_STILL).color(0xFF8AFBFF)
						.luminosity(15).density(3000).viscosity(3000).temperature(5000)).bucket(moltenBluelava_bucket)
								.block(molten_BlueLava_block);
	}

	public static final RegistryObject<Block> ANCIENT_STONE = BLOCKS.register("ancient_stone", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5f)));
	public static final RegistryObject<Block> ANCIENT_DIRT = BLOCKS.register("ancient_dirt", () -> new Block(AbstractBlock.Properties.create(Material.EARTH).sound(SoundType.GROUND).hardnessAndResistance(0.6f)));
	public static final RegistryObject<Block> ANCIENT_GRASS = BLOCKS.register("ancient_grass", () -> new Block(AbstractBlock.Properties.create(Material.EARTH).sound(SoundType.WET_GRASS).hardnessAndResistance(0.6f)));

	public static final RegistryObject<Item> ANCIENT_STONE_ITEM = ITEMS.register("ancient_stone", () -> new BlockItem(ANCIENT_STONE.get(), new Item.Properties().group(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ANCIENT_DIRT_ITEM = ITEMS.register("ancient_dirt", () -> new BlockItem(ANCIENT_DIRT.get(), new Item.Properties().group(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ANCIENT_GRASS_ITEM = ITEMS.register("ancient_grass", () -> new BlockItem(ANCIENT_GRASS.get(), new Item.Properties().group(AllTheModium.GROUP)));

	public static final RegistryObject<Block> UA_ALLOY = BLOCKS.register("unobtainium_allthemodium_alloy_block", UAAlloy_Block::new);
	public static final RegistryObject<Block> UV_ALLOY = BLOCKS.register("unobtainium_vibranium_alloy_block", UVAlloy_Block::new);
	public static final RegistryObject<Block> VA_ALLOY = BLOCKS.register("vibranium_allthemodium_alloy_block", VAAlloy_Block::new);

	public static final RegistryObject<Item> UA_ALLOY_ITEM = ITEMS.register("unobtainium_allthemodium_alloy_block", () -> new BlockItem(UA_ALLOY.get(),new Item.Properties().group(AllTheModium.GROUP)));
	public static final RegistryObject<Item> UV_ALLOY_ITEM = ITEMS.register("unobtainium_vibranium_alloy_block", () -> new BlockItem(UV_ALLOY.get(),new Item.Properties().group(AllTheModium.GROUP)));
	public static final RegistryObject<Item> VA_ALLOY_ITEM = ITEMS.register("vibranium_allthemodium_alloy_block", () -> new BlockItem(VA_ALLOY.get(),new Item.Properties().group(AllTheModium.GROUP)));

	public static final RegistryObject<Item> ATM_CLUMP = ITEMS.register("allthemodium_clump", () -> new Clump(new Item.Properties().group(AllTheModium.GROUP)));
	public static final RegistryObject<Item> VIB_CLUMP = ITEMS.register("vibranium_clump", () -> new Clump(new Item.Properties().group(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ONOB_CLUMP = ITEMS.register("unobtainium_clump", () -> new Clump(new Item.Properties().group(AllTheModium.GROUP)));

	public static final RegistryObject<Item> ATM_SHARD = ITEMS.register("allthemodium_shard", () -> new Shard(new Item.Properties().group(AllTheModium.GROUP)));
	public static final RegistryObject<Item> VIB_SHARD = ITEMS.register("vibranium_shard", () -> new Shard(new Item.Properties().group(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ONOB_SHARD = ITEMS.register("unobtainium_shard", () -> new Shard(new Item.Properties().group(AllTheModium.GROUP)));

	public static final RegistryObject<Item> ATM_DIRTY = ITEMS.register("dirty_allthemodium_dust", () -> new DirtyDust(new Item.Properties().group(AllTheModium.GROUP)));
	public static final RegistryObject<Item> VIB_DIRTY = ITEMS.register("dirty_vibranium_dust", () -> new DirtyDust(new Item.Properties().group(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ONOB_DIRTY = ITEMS.register("dirty_unobtainium_dust", () -> new DirtyDust(new Item.Properties().group(AllTheModium.GROUP)));

	public static final RegistryObject<Item> ATM_CRYSTAL = ITEMS.register("allthemodium_crystal", () -> new Crystal(new Item.Properties().group(AllTheModium.GROUP)));
	public static final RegistryObject<Item> VIB_CRYSTAL = ITEMS.register("vibranium_crystal", () -> new Crystal(new Item.Properties().group(AllTheModium.GROUP)));
	public static final RegistryObject<Item> ONOB_CRYSTAL = ITEMS.register("unobtainium_crystal", () -> new Crystal(new Item.Properties().group(AllTheModium.GROUP)));




/*


	// *********************************** SLURRIES *************************************************

	public static final ResourceLocation SLURRY_STILL = new ResourceLocation("minecraft","block/water_still");
	public static final ResourceLocation SLURRY_FLOW = new ResourceLocation("minecraft","block/water_flow");

	// **************************************ATM*****************************************************
	public static final RegistryObject<Source> ATM_DIRTY_SLURRY = FLUIDS.register("allthemodium_dirty_slurry",
			() -> new ForgeFlowingFluid.Source(makeATMDirtySlurryProperties()));
	public static final RegistryObject<Flowing> flowing_ATM_DIRTY_SLURRY = FLUIDS
			.register("flowing_allthemodium_dirty_slurry", () -> new ForgeFlowingFluid.Flowing(makeATMDirtySlurryProperties()));
	public static final RegistryObject<FlowingFluidBlock> ATM_DIRTY_SLURRY_BLOCK = BLOCKS
			.register("allthemodium_dirty_slurry_block", () -> new FlowingFluidBlock(ATM_DIRTY_SLURRY,
					Block.Properties.create(Material.WATER).setLightLevel((state) -> 3).hardnessAndResistance(100.0F).noDrops()));
	public static final RegistryObject<Item> ATM_DIRTY_SLURRY_BUCKET = ITEMS.register("allthemodium_dirty_slurry_bucket",
			() -> new BucketItem(ATM_DIRTY_SLURRY,
					new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModItems.group)));

	private static ForgeFlowingFluid.Properties makeATMDirtySlurryProperties() {
		return new ForgeFlowingFluid.Properties(ATM_DIRTY_SLURRY, flowing_ATM_DIRTY_SLURRY,
				FluidAttributes.builder(SLURRY_STILL, SLURRY_FLOW).overlay(SLURRY_STILL).color(0xFFFFEF0E))
				.bucket(ATM_DIRTY_SLURRY_BUCKET).block(ATM_DIRTY_SLURRY_BLOCK);
	}

	public static final RegistryObject<Source> ATM_CLEAN_SLURRY = FLUIDS.register("allthemodium_clean_slurry",
			() -> new ForgeFlowingFluid.Source(makeATMCleanSlurryProperties()));
	public static final RegistryObject<Flowing> flowing_ATM_CLEAN_SLURRY = FLUIDS
			.register("flowing_allthemodium_clean_slurry", () -> new ForgeFlowingFluid.Flowing(makeATMCleanSlurryProperties()));
	public static final RegistryObject<FlowingFluidBlock> ATM_CLEAN_SLURRY_BLOCK = BLOCKS
			.register("allthemodium_clean_slurry_block", () -> new FlowingFluidBlock(ATM_CLEAN_SLURRY,
					Block.Properties.create(Material.WATER).setLightLevel((state) -> 12).hardnessAndResistance(100.0F).noDrops()));
	public static final RegistryObject<Item> ATM_CLEAN_SLURRY_BUCKET = ITEMS.register("allthemodium_clean_slurry_bucket",
			() -> new BucketItem(ATM_CLEAN_SLURRY,
					new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModItems.group)));

	private static ForgeFlowingFluid.Properties makeATMCleanSlurryProperties() {
		return new ForgeFlowingFluid.Properties(ATM_CLEAN_SLURRY, flowing_ATM_CLEAN_SLURRY,
				FluidAttributes.builder(SLURRY_STILL, SLURRY_FLOW).overlay(SLURRY_STILL).color(0x80FFEF0E))
				.bucket(ATM_CLEAN_SLURRY_BUCKET).block(ATM_CLEAN_SLURRY_BLOCK);
	}

	// **************************************VIB**************************************************************

	public static final RegistryObject<Source> VIB_DIRTY_SLURRY = FLUIDS.register("vibranium_dirty_slurry",
			() -> new ForgeFlowingFluid.Source(makeVIBDirtySlurryProperties()));
	public static final RegistryObject<Flowing> flowing_VIB_DIRTY_SLURRY = FLUIDS
			.register("flowing_vibranium_dirty_slurry", () -> new ForgeFlowingFluid.Flowing(makeVIBDirtySlurryProperties()));
	public static final RegistryObject<FlowingFluidBlock> VIB_DIRTY_SLURRY_BLOCK = BLOCKS
			.register("vibranium_dirty_slurry_block", () -> new FlowingFluidBlock(VIB_DIRTY_SLURRY,
					Block.Properties.create(Material.WATER).setLightLevel((state) -> 3).hardnessAndResistance(100.0F).noDrops()));
	public static final RegistryObject<Item> VIB_DIRTY_SLURRY_BUCKET = ITEMS.register("vibranium_dirty_slurry_bucket",
			() -> new BucketItem(VIB_DIRTY_SLURRY,
					new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModItems.group)));

	private static ForgeFlowingFluid.Properties makeVIBDirtySlurryProperties() {
		return new ForgeFlowingFluid.Properties(VIB_DIRTY_SLURRY, flowing_VIB_DIRTY_SLURRY,
				FluidAttributes.builder(SLURRY_STILL, SLURRY_FLOW).overlay(SLURRY_STILL).color(0xFF26DE88))
				.bucket(VIB_DIRTY_SLURRY_BUCKET).block(VIB_DIRTY_SLURRY_BLOCK);
	}

	public static final RegistryObject<Source> VIB_CLEAN_SLURRY = FLUIDS.register("vibranium_clean_slurry",
			() -> new ForgeFlowingFluid.Source(makeVIBCleanSlurryProperties()));
	public static final RegistryObject<Flowing> flowing_VIB_CLEAN_SLURRY = FLUIDS
			.register("flowing_vibranium_clean_slurry", () -> new ForgeFlowingFluid.Flowing(makeVIBCleanSlurryProperties()));
	public static final RegistryObject<FlowingFluidBlock> VIB_CLEAN_SLURRY_BLOCK = BLOCKS
			.register("vibranium_clean_slurry_block", () -> new FlowingFluidBlock(VIB_CLEAN_SLURRY,
					Block.Properties.create(Material.WATER).setLightLevel((state) -> 12).hardnessAndResistance(100.0F).noDrops()));
	public static final RegistryObject<Item> VIB_CLEAN_SLURRY_BUCKET = ITEMS.register("vibranium_clean_slurry_bucket",
			() -> new BucketItem(VIB_CLEAN_SLURRY,
					new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModItems.group)));

	private static ForgeFlowingFluid.Properties makeVIBCleanSlurryProperties() {
		return new ForgeFlowingFluid.Properties(VIB_CLEAN_SLURRY, flowing_VIB_CLEAN_SLURRY,
				FluidAttributes.builder(SLURRY_STILL, SLURRY_FLOW).overlay(SLURRY_STILL).color(0x8026DE88))
				.bucket(VIB_CLEAN_SLURRY_BUCKET).block(VIB_CLEAN_SLURRY_BLOCK);

	}


	// **********************************UNOB***************************************************************



	public static final RegistryObject<Source> UNOB_DIRTY_SLURRY = FLUIDS.register("unobtainium_dirty_slurry",
			() -> new ForgeFlowingFluid.Source(makeUNOBDirtySlurryProperties()));
	public static final RegistryObject<Flowing> flowing_UNOB_DIRTY_SLURRY = FLUIDS
			.register("flowing_unobtainium_dirty_slurry", () -> new ForgeFlowingFluid.Flowing(makeUNOBDirtySlurryProperties()));
	public static final RegistryObject<FlowingFluidBlock> UNOB_DIRTY_SLURRY_BLOCK = BLOCKS
			.register("unobtainium_dirty_slurry_block", () -> new FlowingFluidBlock(UNOB_DIRTY_SLURRY,
					Block.Properties.create(Material.WATER).setLightLevel((state) -> 3).hardnessAndResistance(100.0F).noDrops()));
	public static final RegistryObject<Item> UNOB_DIRTY_SLURRY_BUCKET = ITEMS.register("unobtainium_dirty_slurry_bucket",
			() -> new BucketItem(UNOB_DIRTY_SLURRY,
					new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModItems.group)));

	private static ForgeFlowingFluid.Properties makeUNOBDirtySlurryProperties() {
		return new ForgeFlowingFluid.Properties(UNOB_DIRTY_SLURRY, flowing_UNOB_DIRTY_SLURRY,
				FluidAttributes.builder(SLURRY_STILL, SLURRY_FLOW).overlay(SLURRY_STILL).color(0xFFD152E3))
				.bucket(UNOB_DIRTY_SLURRY_BUCKET).block(UNOB_DIRTY_SLURRY_BLOCK);
	}

	public static final RegistryObject<Source> UNOB_CLEAN_SLURRY = FLUIDS.register("unobtainium_clean_slurry",
			() -> new ForgeFlowingFluid.Source(makeUNOBCleanSlurryProperties()));
	public static final RegistryObject<Flowing> flowing_UNOB_CLEAN_SLURRY = FLUIDS
			.register("flowing_unobtainium_clean_slurry", () -> new ForgeFlowingFluid.Flowing(makeUNOBCleanSlurryProperties()));
	public static final RegistryObject<FlowingFluidBlock> UNOB_CLEAN_SLURRY_BLOCK = BLOCKS
			.register("unobtainium_clean_slurry_block", () -> new FlowingFluidBlock(UNOB_CLEAN_SLURRY,
					Block.Properties.create(Material.WATER).setLightLevel((state) -> 12).hardnessAndResistance(100.0F).noDrops()));
	public static final RegistryObject<Item> UNOB_CLEAN_SLURRY_BUCKET = ITEMS.register("unobtainium_clean_slurry_bucket",
			() -> new BucketItem(UNOB_CLEAN_SLURRY,
					new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModItems.group)));

	private static ForgeFlowingFluid.Properties makeUNOBCleanSlurryProperties() {
		return new ForgeFlowingFluid.Properties(UNOB_CLEAN_SLURRY, flowing_UNOB_CLEAN_SLURRY,
				FluidAttributes.builder(SLURRY_STILL, SLURRY_FLOW).overlay(SLURRY_STILL).color(0x80D152E3))
				.bucket(UNOB_CLEAN_SLURRY_BUCKET).block(UNOB_CLEAN_SLURRY_BLOCK);

	}
*/


	public static void init(){

	}




	//public static final RegistryObject<Item> UNOBTAINIUM_BATTERY = ITEMS.register("unobtainium_battery", () -> {
	//	return new Battery(new Item.Properties().group(AllTheModium.GROUP).maxStackSize(1));
	//			
	//});

}
