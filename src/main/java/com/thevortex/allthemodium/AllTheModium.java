package com.thevortex.allthemodium;


import com.thevortex.allthemodium.compat.ars_nouveau.ArsClientHandler;
import com.thevortex.allthemodium.compat.ars_nouveau.ArsCompat;
import com.thevortex.allthemodium.compat.jade.ATMJadePlugin;
import com.thevortex.allthemodium.events.ArmorEvents;
import com.thevortex.allthemodium.events.BlockBreak;
import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.*;
import com.thevortex.allthemodium.registry.mek_reg.ATMSlurries;
import com.thevortex.allthemodium.registry.mek_reg.MekProcReg;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.launch.MixinBootstrap;

import static com.thevortex.allthemodium.reference.Reference.MOD_ID;

@Mod(Reference.MOD_ID)
public class AllTheModium
{

	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	public static boolean ALLOW_TELEPORT_MINING = false;

    public AllTheModium(IEventBus modEventBus, ModContainer modContainer) {
        // Register the setup method for modloading
		MixinBootstrap.init();
		modEventBus.register(ModRegistry.class);

		FluidTypeRegistry.FLUID_TYPES.register(modEventBus);
    	FluidRegistry.FLUIDS.register(modEventBus);
		
       	ModRegistry.BLOCKS.register(modEventBus);
		ModRegistry.SHAPED_BLOCKS.register(modEventBus);
		ModRegistry.STAIRBLOCKS.register(modEventBus);
		ModRegistry.SLABBLOCKS.register(modEventBus);
		ModRegistry.WALLBLOCKS.register(modEventBus);
		ModRegistry.PILLARBLOCKS.register(modEventBus);

		ModRegistry.ITEMS.register(modEventBus);

		ArmorRegistries.ARMOR_MATERIALS.register(modEventBus);
		
    	ModRegistry.ENTITIES.register(modEventBus);
    	ModRegistry.ENTITY.register(modEventBus);

    	ModRegistry.CARVERS.register(modEventBus);
		ModRegistry.BIOMES.register(modEventBus);
    	//ATMCraftingSetup.REGISTRY.register(modEventBus);
		ModRegistry.STRUCTURES.register(modEventBus);
		ModRegistry.FEATURES.register(modEventBus);
		ModRegistry.TREE_DECORATORS.register(modEventBus);
		ModRegistry.POI_TYPES.register(modEventBus);
		ModRegistry.CREATIVE_TABS.register(modEventBus);
		ChunkGenRegistry.CHUNKGENERATORS.register(modEventBus);

		if(ModList.get().isLoaded("mekanism")) {

			ATMSlurries.SLURRIES.register(modEventBus);
			MekProcReg.ITEMS.register(modEventBus);
			MekProcReg.CREATIVE_TABS.register(modEventBus);
		}
		if (ModList.get().isLoaded("ars_nouveau")) {
			ArsCompat.ARS_BLOCKS.register(modEventBus);
			ArsCompat.ARS_ITEMS.register(modEventBus);
			ArsCompat.ARS_BLOCK_ENTITIES.register(modEventBus);
			modEventBus.addListener(ArsCompat::registerCapabilities);
			modEventBus.addListener(ArsClientHandler::init);
		}

		//MinecraftForge.EVENT_BUS.addListener(EventPriority.NORMAL, APStructure::setupStructureSpawns);
		//MinecraftForge.EVENT_BUS.addListener(EventPriority.NORMAL, DungeonStructure::setupStructureSpawns);
		//MinecraftForge.EVENT_BUS.addListener(EventPriority.NORMAL, PVStructure::setupStructureSpawns);
        // Register ourselves for server and other game events we are interested in
        NeoForge.EVENT_BUS.register(BlockBreak.class);
		NeoForge.EVENT_BUS.register(ArmorEvents.class);
		modEventBus.addListener(this::onModsLoaded);
		setupLogFilter();
	}


	private static void setupLogFilter() {
		var rootLogger = LogManager.getRootLogger();
		if (rootLogger instanceof org.apache.logging.log4j.core.Logger logger) {
			logger.addFilter(new MsgFilter());
		} else {
			LOGGER.error("Registration failed with unexpected class: {}", rootLogger.getClass());
		}
	}

	public void onModsLoaded(FMLLoadCompleteEvent event) {
		if (FMLEnvironment.dist.isClient() && ModList.get().isLoaded("jade")) {
			event.enqueueWork(ATMJadePlugin::registerPickaxes);
		}
	}

}
