package com.thevortex.allthemodium;

import static com.thevortex.allthemodium.reference.Reference.MOD_ID;

import com.thevortex.allthemodium.config.AllthemodiumServerConfigs;
import com.thevortex.allthemodium.crafting.ATMCraftingSetup;
import com.thevortex.allthemodium.events.ArmorEvents;
import com.thevortex.allthemodium.events.BlockBreak;
import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.*;
import com.thevortex.allthemodium.registry.resource.ATMSlurries;
import com.thevortex.allthemodium.worldgen.MiningDimSource;
import com.thevortex.allthemodium.worldgen.TheOtherDimSource;
import com.thevortex.allthemodium.worldgen.structures.ATMStructures;
import com.thevortex.allthetweaks.config.Configuration;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("allthemodium")
@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AllTheModium {

    public static final ResourceKey<Level> OverWorld = Level.OVERWORLD;
    public static final ResourceKey<Level> Nether = Level.NETHER;
    public static final ResourceKey<Level> The_End = Level.END;
    public static final ResourceLocation MINING_DIM_ID = new ResourceLocation(
            MOD_ID,
            "mining");
    public static final ResourceLocation THE_OTHER_DIM_ID = new ResourceLocation(MOD_ID, "the_other");
    public static final ResourceKey<Level> THE_OTHER = ResourceKey.create(
            Registry.DIMENSION_REGISTRY,
            THE_OTHER_DIM_ID);
    // public static final ResourceKey<DimensionType> Mining_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, MINING_DIM_ID);
    // public static final ResourceKey<DimensionType> THE_OTHER_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, THE_OTHER_DIM_ID);
    // public static final RegistryKey<World> THE_BEYOND = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(Reference.MOD_ID,"the_beyond"));
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    public static boolean ALLOW_TELEPORT_MINING = true;
    public static final CreativeModeTab GROUP = new CreativeModeTab(MOD_ID) {
        public ItemStack makeIcon() {
            return new ItemStack(ModRegistry.ALLTHEMODIUM_ORE_ITEM.get());
        }
    };

    public AllTheModium() {
        // Register the setup method for mod loading

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        FluidTypeRegistry.FLUID_TYPES.register(modEventBus);
        FluidRegistry.FLUIDS.register(modEventBus);
        BlockRegistry.BLOCKS.register(modEventBus);
        ModRegistry.BLOCKS.register(modEventBus);
        ModRegistry.SHAPED_BLOCKS.register(modEventBus);
        ModRegistry.STAIR_BLOCKS.register(modEventBus);
        ModRegistry.SLAB_BLOCKS.register(modEventBus);
        ModRegistry.WALL_BLOCKS.register(modEventBus);
        ModRegistry.PILLAR_BLOCKS.register(modEventBus);

        ItemRegistry.ITEMS.register(modEventBus);
        ModRegistry.ITEMS.register(modEventBus);
        ModRegistry.ENTITIES.register(modEventBus);

        ModRegistry.CARVERS.register(modEventBus);
        ModRegistry.BIOMES.register(modEventBus);
        ATMCraftingSetup.REGISTRY.register(modEventBus);
        ATMStructures.STRUCTURES.register(modEventBus);
        ModRegistry.FEATURES.register(modEventBus);

        modEventBus.register(ModRegistry.class);
        modEventBus.addListener(this::setup);

        GeckoLib.initialize();

        // load configs
        ModLoadingContext
                .get()
                .registerConfig(Type.SERVER, AllthemodiumServerConfigs.SPEC);

        if (ModList.get().isLoaded("mekanism")) {
            ATMSlurries.SLURRIES.register(modEventBus);
        }

        // MinecraftForge.EVENT_BUS.addListener(EventPriority.NORMAL, APStructure::setupStructureSpawns);
        // MinecraftForge.EVENT_BUS.addListener(EventPriority.NORMAL, DungeonStructure::setupStructureSpawns);
        // MinecraftForge.EVENT_BUS.addListener(EventPriority.NORMAL, PVStructure::setupStructureSpawns);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(BlockBreak.class);
        MinecraftForge.EVENT_BUS.register(ArmorEvents.class);
    }

    public void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            AxeItem.STRIPPABLES.put(
                    ModRegistry.SOUL_LOG.get(),
                    ModRegistry.SOUL_LOG_STRIPPED.get());
            AxeItem.STRIPPABLES.put(
                    ModRegistry.SOUL_LOG_0.get(),
                    ModRegistry.SOUL_LOG_STRIPPED.get());
            AxeItem.STRIPPABLES.put(
                    ModRegistry.SOUL_LOG_1.get(),
                    ModRegistry.SOUL_LOG_STRIPPED.get());
            AxeItem.STRIPPABLES.put(
                    ModRegistry.SOUL_LOG_2.get(),
                    ModRegistry.SOUL_LOG_STRIPPED.get());
            AxeItem.STRIPPABLES.put(
                    ModRegistry.DEMONIC_LOG.get(),
                    ModRegistry.DEMONIC_LOG_STRIPPED.get());
            AxeItem.STRIPPABLES.put(
                    ModRegistry.ANCIENT_LOG_0.get(),
                    ModRegistry.ANCIENT_LOG_STRIPPED.get());
            AxeItem.STRIPPABLES.put(
                    ModRegistry.ANCIENT_LOG_1.get(),
                    ModRegistry.ANCIENT_LOG_STRIPPED.get());
            AxeItem.STRIPPABLES.put(
                    ModRegistry.ANCIENT_LOG_2.get(),
                    ModRegistry.ANCIENT_LOG_STRIPPED.get());
            // ATMConfiguredStructures.registerConfiguredStructures();
            Registry.register(
                    Registry.CHUNK_GENERATOR,
                    MINING_DIM_ID,
                    MiningDimSource.CODEC);
            Registry.register(
                    Registry.CHUNK_GENERATOR,
                    THE_OTHER_DIM_ID,
                    TheOtherDimSource.CODEC);
            if (ModList.get().isLoaded("allthetweaks")) {
                if (5 == Configuration.COMMON.mainmode.get()) {
                    ALLOW_TELEPORT_MINING = false;
                }
            }
        });
    }

    public void setupClient(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
        });
    }
}
