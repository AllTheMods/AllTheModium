package com.thevortex.allthemodium;

import com.thevortex.allthemodium.init.*;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.thevortex.allthemodium.reference.Reference;

import static com.thevortex.allthemodium.reference.Reference.MOD_ID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.thevortex.allthemodium.crafting.ATMCraftingSetup;
import com.thevortex.allthemodium.events.ArmorEvents;
import com.thevortex.allthemodium.events.BlockBreak;
import com.thevortex.allthemodium.registry.ModRegistry;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("allthemodium")
@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AllTheModium
{
   
	public static final ResourceKey<Level> OverWorld = Level.OVERWORLD;
	public static final ResourceKey<Level> Nether = Level.NETHER;
	public static final ResourceKey<Level> The_End = Level.END;

	public static final ResourceKey<Level> Mining = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(MOD_ID,"mining"));
	//public static final ResourceKey<Level> THE_OTHER = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(Reference.MOD_ID,"the_other"));
	//public static final RegistryKey<World> THE_BEYOND = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(Reference.MOD_ID,"the_beyond"));
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	public static Boolean ALLOW_TELEPORT_MINING = false;
	public static final CreativeModeTab GROUP = new CreativeModeTab(MOD_ID) {
		public ItemStack makeIcon() { return new ItemStack(new BlockItem(ModRegistry.ALLTHEMODIUM_ORE.get(),new Item.Properties())); }
	};
	
    public AllTheModium() {
        // Register the setup method for modloading
    	IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    	ModRegistry.FLUIDS.register(modEventBus);
       	ModRegistry.BLOCKS.register(modEventBus);
    	ModRegistry.ITEMS.register(modEventBus);
    	ATMCraftingSetup.REGISTRY.register(modEventBus);

    	if(ModList.get().isLoaded("mekanism")) {
			//modEventBus.register(MekRegistry.class);
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
