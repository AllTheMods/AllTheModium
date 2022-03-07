package com.thevortex.allthemodium;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.serialization.Codec;
import com.thevortex.allthemodium.events.PlayerHarvest;
import com.thevortex.allthemodium.init.*;
import com.thevortex.allthemodium.worldgen.MiningDimSource;
import com.thevortex.allthemodium.worldgen.TheOtherDimSource;
import com.thevortex.allthemodium.worldgen.biomes.ATMBiomes;
import com.thevortex.allthemodium.worldgen.structures.*;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.BastionPieces;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.NetherFortressFeature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.thevortex.allthemodium.reference.Reference;

import static com.thevortex.allthemodium.reference.Reference.MOD_ID;

import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.thevortex.allthemodium.crafting.ATMCraftingSetup;
import com.thevortex.allthemodium.events.ArmorEvents;
import com.thevortex.allthemodium.events.BlockBreak;
import com.thevortex.allthemodium.registry.ModRegistry;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("allthemodium")
@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AllTheModium
{

	public static final ResourceKey<Level> OverWorld = Level.OVERWORLD;
	public static final ResourceKey<Level> Nether = Level.NETHER;
	public static final ResourceKey<Level> The_End = Level.END;
	public static final ResourceLocation MINING_DIM_ID = new ResourceLocation(MOD_ID,"mining");
	public static final ResourceLocation THE_OTHER_DIM_ID = new ResourceLocation(MOD_ID,"the_other");
	public static final ResourceKey<Level> Mining = ResourceKey.create(Registry.DIMENSION_REGISTRY, MINING_DIM_ID);
	public static final ResourceKey<Level> THE_OTHER = ResourceKey.create(Registry.DIMENSION_REGISTRY, THE_OTHER_DIM_ID);
	public static final ResourceKey<DimensionType> Mining_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, MINING_DIM_ID);
	public static final ResourceKey<DimensionType> THE_OTHER_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, THE_OTHER_DIM_ID);
	//public static final RegistryKey<World> THE_BEYOND = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(Reference.MOD_ID,"the_beyond"));
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	public static boolean ALLOW_TELEPORT_MINING = false;
	public static final CreativeModeTab GROUP = new CreativeModeTab(MOD_ID) {
		public ItemStack makeIcon() { return new ItemStack(ModRegistry.ALLTHEMODIUM_ORE_ITEM.get()); }
	};

    public AllTheModium() {
        // Register the setup method for modloading

    	IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    	ModRegistry.FLUIDS.register(modEventBus);
       	ModRegistry.BLOCKS.register(modEventBus);
		ModRegistry.SHAPED_BLOCKS.register(modEventBus);
		ModRegistry.STAIRBLOCKS.register(modEventBus);
		ModRegistry.SLABBLOCKS.register(modEventBus);
		ModRegistry.WALLBLOCKS.register(modEventBus);
		ModRegistry.PILLARBLOCKS.register(modEventBus);

    	ModRegistry.ITEMS.register(modEventBus);
    	ModRegistry.ENTITIES.register(modEventBus);
    	ModRegistry.FEATURES.register(modEventBus);
		ModRegistry.CARVERS.register(modEventBus);
    	ATMCraftingSetup.REGISTRY.register(modEventBus);
    	ATMStructures.STRUCTURES.register(modEventBus);
		modEventBus.register(ModRegistry.class);
		modEventBus.addListener(this::setup);

    	if(ModList.get().isLoaded("mekanism")) {
			//modEventBus.register(MekRegistry.class);
		}

		MinecraftForge.EVENT_BUS.addListener(EventPriority.NORMAL, APStructure::setupStructureSpawns);
		MinecraftForge.EVENT_BUS.addListener(EventPriority.NORMAL, DungeonStructure::setupStructureSpawns);
		MinecraftForge.EVENT_BUS.addListener(EventPriority.NORMAL, PVStructure::setupStructureSpawns);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(BlockBreak.class);
        MinecraftForge.EVENT_BUS.register(ArmorEvents.class);
		//MinecraftForge.EVENT_BUS.register(PlayerHarvest.class);

    }
	public void setup(final FMLCommonSetupEvent event)
	{
		event.enqueueWork(() -> {
			ATMConfiguredStructures.registerConfiguredStructures();
		});
	}
	public void setupClient(final FMLClientSetupEvent event)
	{
		event.enqueueWork(() -> {

		});
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = MOD_ID)
	public static class RegistryEvents {
		@SubscribeEvent
		public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
			AxeItem.STRIPPABLES = (new ImmutableMap.Builder<Block, Block>()).put(ModRegistry.SOUL_LOG.get(),ModRegistry.SOUL_LOG_STRIPPED.get()).put(ModRegistry.SOUL_LOG_0.get(),ModRegistry.SOUL_LOG_STRIPPED.get()).put(ModRegistry.SOUL_LOG_1.get(),ModRegistry.SOUL_LOG_STRIPPED.get()).put(ModRegistry.SOUL_LOG_2.get(),ModRegistry.SOUL_LOG_STRIPPED.get()).put(ModRegistry.DEMONIC_LOG.get(),ModRegistry.DEMONIC_LOG_STRIPPED.get()).put(ModRegistry.ANCIENT_LOG_0.get(),ModRegistry.ANCIENT_LOG_STRIPPED.get()).put(ModRegistry.ANCIENT_LOG_1.get(),ModRegistry.ANCIENT_LOG_STRIPPED.get()).put(ModRegistry.ANCIENT_LOG_2.get(),ModRegistry.ANCIENT_LOG_STRIPPED.get()).put(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD).put(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG).put(Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD).put(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG).put(Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD).put(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG).put(Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD).put(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG).put(Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD).put(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG).put(Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD).put(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG).put(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM).put(Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE).put(Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM).put(Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE).build();
			ModItems.init(event);
			if(ModList.get().isLoaded("iceandfire")) {
				//IAFForgeRecipes.init();
				//IAFForgeRecipes.regIaFItems(event); //for gold piles items
			}
		}

	}

}
