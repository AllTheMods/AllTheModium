package com.thevortex.allthemodium;

import com.mojang.serialization.Codec;
import com.thevortex.allthemodium.events.PlayerHarvest;
import com.thevortex.allthemodium.init.*;
import com.thevortex.allthemodium.worldgen.structures.ATMConfiguredStructures;
import com.thevortex.allthemodium.worldgen.structures.ATMStructures;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.FlatLevelSource;
import net.minecraft.world.level.levelgen.StructureSettings;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.StructureFeatureConfiguration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
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

	public static final ResourceKey<Level> Mining = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(MOD_ID,"mining"));
	public static final ResourceKey<Level> THE_OTHER = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(Reference.MOD_ID,"the_other"));
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
    	ModRegistry.ITEMS.register(modEventBus);
    	ModRegistry.ENTITIES.register(modEventBus);
    	ModRegistry.FEATURES.register(modEventBus);
    	ATMCraftingSetup.REGISTRY.register(modEventBus);
		ATMStructures.STRUCTURES.register(modEventBus);
		modEventBus.register(ModRegistry.class);
		modEventBus.addListener(this::setup);

    	if(ModList.get().isLoaded("mekanism")) {
			//modEventBus.register(MekRegistry.class);
		}
		MinecraftForge.EVENT_BUS.addListener(EventPriority.NORMAL, this::addDimensionalSpacing);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(BlockBreak.class);
        MinecraftForge.EVENT_BUS.register(ArmorEvents.class);
		MinecraftForge.EVENT_BUS.register(PlayerHarvest.class);
    }
	public void setup(final FMLCommonSetupEvent event)
	{
		event.enqueueWork(() -> {
			ATMStructures.setupStructures();
			ATMConfiguredStructures.registerConfiguredStructures();
		});
	}
	private static Method GETCODEC_METHOD;
	public void addDimensionalSpacing(final WorldEvent.Load event) {
		if(event.getWorld() instanceof ServerLevel){
			ServerLevel serverWorld = (ServerLevel)event.getWorld();
			try {
				if(GETCODEC_METHOD == null) GETCODEC_METHOD = ObfuscationReflectionHelper.findMethod(ChunkGenerator.class, "func_230347_a_");
				ResourceLocation cgRL = Registry.CHUNK_GENERATOR.getKey((Codec<? extends ChunkGenerator>) GETCODEC_METHOD.invoke(serverWorld.getChunkSource().generator));
				if(cgRL != null && cgRL.getNamespace().equals("terraforged")) return;
			}
			catch(Exception e){
				//AllTheModium.LOGGER.error("Was unable to check if " + serverWorld.dimension().location() + " is using Terraforged's ChunkGenerator.");
			}
			if(serverWorld.getChunkSource().getGenerator() instanceof FlatLevelSource &&
					serverWorld.dimension().equals(Level.OVERWORLD)){
				return;
			}
			Map<StructureFeature<?>, StructureFeatureConfiguration> tempMap = new HashMap<>(serverWorld.getChunkSource().generator.getSettings().structureConfig());
			tempMap.putIfAbsent(ATMStructures.DUNGEON.get(), StructureSettings.DEFAULTS.get(ATMStructures.DUNGEON.get()));
			tempMap.putIfAbsent(ATMStructures.PYRAMID.get(), StructureSettings.DEFAULTS.get(ATMStructures.PYRAMID.get()));
			tempMap.putIfAbsent(ATMStructures.VILLAGE.get(), StructureSettings.DEFAULTS.get(ATMStructures.VILLAGE.get()));
			serverWorld.getChunkSource().generator.getSettings().structureConfig = tempMap;
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = MOD_ID)
	public static class RegistryEvents {
		@SubscribeEvent
		public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {

			ModItems.init(event);
			if(ModList.get().isLoaded("iceandfire")) {
				//IAFForgeRecipes.init();
				//IAFForgeRecipes.regIaFItems(event); //for gold piles items
			}
		}

	}

}
