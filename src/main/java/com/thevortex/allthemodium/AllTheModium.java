package com.thevortex.allthemodium;

import com.thevortex.allthemodium.init.*;
import mekanism.api.chemical.slurry.Slurry;
import net.allthemods.alltheores.events.BlockBreak;
import net.allthemods.alltheores.infos.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

//import com.thevortex.allthemodium.init.ModFluids;

import static com.thevortex.allthemodium.reference.Reference.MOD_ID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.thevortex.allthemodium.crafting.ATMCraftingSetup;
import com.thevortex.allthemodium.events.ArmorEvents;
import com.thevortex.allthemodium.fluids.FluidList;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("allthemodium")
@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AllTheModium
{
	public static final RegistryKey<World> OverWorld = World.OVERWORLD;
	public static final RegistryKey<World> Nether = World.NETHER;
	public static final RegistryKey<World> The_End = World.END;

	public static final RegistryKey<World> Mining = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(MOD_ID,"mining"));
	public static final RegistryKey<World> THE_OTHER = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(Reference.MOD_ID,"the_other"));
	//public static final RegistryKey<World> THE_BEYOND = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(Reference.MOD_ID,"the_beyond"));
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	public static Boolean ALLOW_TELEPORT_MINING = false;
	public static final ItemGroup GROUP = new ItemGroup(MOD_ID) {
		public ItemStack makeIcon() {
			return new ItemStack(ModBlocks.ALLTHEMODIUMBLOCK);
		}
	};
	
    public AllTheModium() {
        // Register the setup method for modloading
    	IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

	if(ModList.get().isLoaded("iceandfire")) {
		ModEntityTypes.ENTITIES.register(modEventBus);
	}
    	FluidList.FLUIDS.register(modEventBus);
       	FluidList.BLOCKS.register(modEventBus);
    	FluidList.ITEMS.register(modEventBus);
    	ATMCraftingSetup.REGISTRY.register(modEventBus);

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

    	if(ModList.get().isLoaded("mekanism")) {
			modEventBus.register(MekRegistry.class);
		}

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(BlockBreak.class);
        MinecraftForge.EVENT_BUS.register(ArmorEvents.class);
    }

   @SubscribeEvent
   public static void commonSetupEvent(FMLCommonSetupEvent event) {
	   //Worldgen.addFeatures();
   }

   private void doClientStuff(final FMLClientSetupEvent event)
   {
		ModRenderRegistry.registryEntityRenders();
   }

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = MOD_ID)
	public static class RegistryEvents {

		@SubscribeEvent
		public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {

			ModBlocks.init(event);
			if(ModList.get().isLoaded("iceandfire")) {
				GoldPiles.init(event);
			}
		}


		@SubscribeEvent
		public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {

			ModItems.init(event);
			if(ModList.get().isLoaded("iceandfire")) {
				IAFForgeRecipes.init();
				IAFForgeRecipes.regIaFItems(event);
			}
		}
	}
	public static class MekRegistry {
		@SubscribeEvent
		public static void onSlurryRegistry(final RegistryEvent.Register<Slurry> event) {	if(ModList.get().isLoaded("mekanism")) { ModSlurries.init(event);	} }

	}
}
