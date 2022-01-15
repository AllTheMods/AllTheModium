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
import net.minecraft.world.level.levelgen.FlatLevelSource;
import net.minecraft.world.level.levelgen.StructureSettings;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.NetherFortressFeature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RuinedPortalConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.StructureFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraftforge.client.ForgeRenderTypes;
import net.minecraftforge.client.RenderProperties;
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
	//public static final RegistryKey<World> THE_BEYOND = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(Reference.MOD_ID,"the_beyond"));
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	public static boolean ALLOW_TELEPORT_MINING = false;
	public static final CreativeModeTab GROUP = new CreativeModeTab(MOD_ID) {
		public ItemStack makeIcon() { return new ItemStack(ModRegistry.ALLTHEMODIUM_ORE_ITEM.get()); }
	};

    public AllTheModium() {
        // Register the setup method for modloading
		Registry.register(Registry.CHUNK_GENERATOR, MINING_DIM_ID, MiningDimSource.CODEC);
		Registry.register(Registry.CHUNK_GENERATOR, THE_OTHER_DIM_ID, TheOtherDimSource.CODEC);

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
		MinecraftForge.EVENT_BUS.addListener(EventPriority.NORMAL, this::addDimensionalSpacing);
		MinecraftForge.EVENT_BUS.addListener(EventPriority.NORMAL, APStructure::setupStructureSpawns);
		MinecraftForge.EVENT_BUS.addListener(EventPriority.NORMAL, DungeonStructure::setupStructureSpawns);
		MinecraftForge.EVENT_BUS.addListener(EventPriority.NORMAL, PVStructure::setupStructureSpawns);
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
	public void setupClient(final FMLClientSetupEvent event)
	{
		event.enqueueWork(() -> {


		});
	}
	private static Method GETCODEC_METHOD;
	public void addDimensionalSpacing(final WorldEvent.Load event) {
		if(event.getWorld() instanceof ServerLevel serverLevel){
			ChunkGenerator chunkGenerator = serverLevel.getChunkSource().getGenerator();
			// Skip superflat to prevent issues with it. Plus, users don't want structures clogging up their superflat worlds.
			if (chunkGenerator instanceof FlatLevelSource && serverLevel.dimension().equals(Level.OVERWORLD)) {
				return;
			}

			StructureSettings worldStructureConfig = chunkGenerator.getSettings();

			//////////// BIOME BASED STRUCTURE SPAWNING ////////////
			/*
			 * NOTE: BiomeLoadingEvent from Forge API does not work with structures anymore.
			 * Instead, we will use the below to add our structure to overworld biomes.
			 * Remember, this is temporary until Forge API finds a better solution for adding structures to biomes.
			 */

			// Create a mutable map we will use for easier adding to biomes
			HashMap<StructureFeature<?>, HashMultimap<ConfiguredStructureFeature<?, ?>, ResourceKey<Biome>>> STStructureToMultiMap = new HashMap<>();

			// Add the resourcekey of all biomes that this Configured Structure can spawn in.
					associateBiomeToConfiguredStructure(STStructureToMultiMap, ATMConfiguredStructures.CONFIGURED_VILLAGE, ATMBiomes.WARPED_FOREST);
					associateBiomeToConfiguredStructure(STStructureToMultiMap, ATMConfiguredStructures.CONFIGURED_DUNGEON, ATMBiomes.THE_OTHER);
					associateBiomeToConfiguredStructure(STStructureToMultiMap, ATMConfiguredStructures.CONFIGURED_VILLAGE, ATMBiomes.CRIMSON_FOREST);
					associateBiomeToConfiguredStructure(STStructureToMultiMap, ATMConfiguredStructures.CONFIGURED_PYRAMID, ATMBiomes.DESERT);
					associateBiomeToConfiguredStructure(STStructureToMultiMap, ATMConfiguredStructures.CONFIGURED_PYRAMID, ATMBiomes.DESERT_HILLS);



			// Alternative way to add our structures to a fixed set of biomes by creating a set of biome resource keys.
			// To create a custom resource key that points to your own biome, do this:
			// ResourceKey.of(Registry.BIOME_REGISTRY, new ResourceLocation("modid", "custom_biome"))
//            ImmutableSet<ResourceKey<Biome>> overworldBiomes = ImmutableSet.<ResourceKey<Biome>>builder()
//                    .add(Biomes.FOREST)
//                    .add(Biomes.MEADOW)
//                    .add(Biomes.PLAINS)
//                    .add(Biomes.SAVANNA)
//                    .add(Biomes.SNOWY_PLAINS)
//                    .add(Biomes.SWAMP)
//                    .add(Biomes.SUNFLOWER_PLAINS)
//                    .add(Biomes.TAIGA)
//                    .build();
//            overworldBiomes.forEach(biomeKey -> associateBiomeToConfiguredStructure(STStructureToMultiMap, STConfiguredStructures.CONFIGURED_RUN_DOWN_HOUSE, biomeKey));

			// Grab the map that holds what ConfigureStructures a structure has and what biomes it can spawn in.
			// Requires AccessTransformer  (see resources/META-INF/accesstransformer.cfg)
			ImmutableMap.Builder<StructureFeature<?>, ImmutableMultimap<ConfiguredStructureFeature<?, ?>, ResourceKey<Biome>>> tempStructureToMultiMap = ImmutableMap.builder();
			worldStructureConfig.configuredStructures.entrySet().stream().filter(entry -> !STStructureToMultiMap.containsKey(entry.getKey())).forEach(tempStructureToMultiMap::put);

			// Add our structures to the structure map/multimap and set the world to use this combined map/multimap.
			STStructureToMultiMap.forEach((key, value) -> tempStructureToMultiMap.put(key, ImmutableMultimap.copyOf(value)));

			// Requires AccessTransformer  (see resources/META-INF/accesstransformer.cfg)
			worldStructureConfig.configuredStructures = tempStructureToMultiMap.build();


			//////////// DIMENSION BASED STRUCTURE SPAWNING (OPTIONAL) ////////////
			/*
			 * Skip Terraforged's chunk generator as they are a special case of a mod locking down their chunkgenerator.
			 * They will handle your structure spacing for your if you add to BuiltinRegistries.NOISE_GENERATOR_SETTINGS in your structure's registration.
			 * This here is done with reflection as this tutorial is not about setting up and using Mixins.
			 * If you are using mixins, you can call the codec method with an invoker mixin instead of using reflection.
			 */
			try {
				if(GETCODEC_METHOD == null) GETCODEC_METHOD = ObfuscationReflectionHelper.findMethod(ChunkGenerator.class, "codec");
				ResourceLocation cgRL = Registry.CHUNK_GENERATOR.getKey((Codec<? extends ChunkGenerator>) GETCODEC_METHOD.invoke(chunkGenerator));
				if(cgRL != null && cgRL.getNamespace().equals("terraforged")) return;
			}
			catch(Exception e){
				AllTheModium.LOGGER.error("Was unable to check if " + serverLevel.dimension().location() + " is using Terraforged's ChunkGenerator.");
			}

			/*
			 * Prevent spawning our structure in Vanilla's superflat world as
			 * people seem to want their superflat worlds free of modded structures.
			 * Also that vanilla superflat is really tricky and buggy to work with in my experience.
			 */
			if(chunkGenerator instanceof FlatLevelSource &&
					serverLevel.dimension().equals(Level.OVERWORLD)){
				return;
			}

			/*
			 * putIfAbsent so people can override the spacing with dimension datapacks themselves if they wish to customize spacing more precisely per dimension.
			 * Requires AccessTransformer  (see resources/META-INF/accesstransformer.cfg)
			 *
			 * NOTE: if you add per-dimension spacing configs, you can't use putIfAbsent as BuiltinRegistries.NOISE_GENERATOR_SETTINGS in FMLCommonSetupEvent
			 * already added your default structure spacing to some dimensions. You would need to override the spacing with .put(...)
			 * And if you want to do dimension blacklisting, you need to remove the spacing entry entirely from the map below to prevent generation safely.
			 */
			Map<StructureFeature<?>, StructureFeatureConfiguration> tempMap = new HashMap<>(worldStructureConfig.structureConfig());
			tempMap.putIfAbsent(ATMStructures.PYRAMID.get(), StructureSettings.DEFAULTS.get(ATMStructures.PYRAMID.get()));
			tempMap.putIfAbsent(ATMStructures.DUNGEON.get(), StructureSettings.DEFAULTS.get(ATMStructures.DUNGEON.get()));
			tempMap.putIfAbsent(ATMStructures.VILLAGE.get(), StructureSettings.DEFAULTS.get(ATMStructures.VILLAGE.get()));
			worldStructureConfig.structureConfig = tempMap;
		}
	}

	/**
	 * Helper method that handles setting up the map to multimap relationship to help prevent issues.
	 */
	private static void associateBiomeToConfiguredStructure(Map<StructureFeature<?>, HashMultimap<ConfiguredStructureFeature<?, ?>, ResourceKey<Biome>>> STStructureToMultiMap, ConfiguredStructureFeature<?, ?> configuredStructureFeature, ResourceKey<Biome> biomeRegistryKey) {
		STStructureToMultiMap.putIfAbsent(configuredStructureFeature.feature, HashMultimap.create());
		HashMultimap<ConfiguredStructureFeature<?, ?>, ResourceKey<Biome>> configuredStructureToBiomeMultiMap = STStructureToMultiMap.get(configuredStructureFeature.feature);
		if(configuredStructureToBiomeMultiMap.containsValue(biomeRegistryKey)) {
			AllTheModium.LOGGER.error("""
                    Detected 2 ConfiguredStructureFeatures that share the same base StructureFeature trying to be added to same biome. One will be prevented from spawning.
                    This issue happens with vanilla too and is why a Snowy Village and Plains Village cannot spawn in the same biome because they both use the Village base structure.
                    The two conflicting ConfiguredStructures are: {}, {}
                    The biome that is attempting to be shared: {}
                """,
					BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE.getId(configuredStructureFeature),
					BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE.getId(configuredStructureToBiomeMultiMap.entries().stream().filter(e -> e.getValue() == biomeRegistryKey).findFirst().get().getKey()),
					biomeRegistryKey
			);
		}
		else{
			configuredStructureToBiomeMultiMap.put(configuredStructureFeature, biomeRegistryKey);
		}
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
