package net.allthemods.allthemodium.core.registry;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidInteractionRegistry;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.PushReaction;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.common.fluid.AllTheModiumFluid;
import net.allthemods.allthemodium.common.fluid.SoulLavaFluid;
import net.allthemods.allthemodium.common.fluid.UnobtaniumFluid;
import net.allthemods.allthemodium.common.fluid.VibraniumFluid;

import java.util.function.Function;

public class ATMFluids {
    
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, ATM.MOD_ID);
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, ATM.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, ATM.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, ATM.MOD_ID);
    
    public static final DeferredHolder<Item, BucketItem> SOUL_LAVA_BUCKET = ATMFluids.registerItem("soul_lava_bucket", p -> new BucketItem(ATMFluids.SOUL_LAVA.get(), p));
    public static final DeferredHolder<Fluid, SoulLavaFluid.Source> SOUL_LAVA = ATMFluids.FLUIDS.register("soul_lava", SoulLavaFluid.Source::new);
    public static final DeferredHolder<Fluid, SoulLavaFluid.Flowing> SOUL_LAVA_FLOWING = ATMFluids.FLUIDS.register("flowing_soul_lava", SoulLavaFluid.Flowing::new);
    public static final DeferredHolder<Block, LiquidBlock> SOUL_LAVA_BLOCK = ATMFluids.registerBlock("soul_lava", p -> new LiquidBlock(ATMFluids.SOUL_LAVA_FLOWING.get(), p
            .mapColor(DyeColor.BLUE)
            .noCollision()
            .replaceable()
            .randomTicks()
            .strength(100.0F)
            .lightLevel(_ -> 15)
            .pushReaction(PushReaction.BLOCK)
            .noLootTable()
            .liquid()
            .sound(SoundType.EMPTY)
    ) {
        
        @Override
        protected boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
            final Player player = context.getPlayer();
            return player != null && player.isCreative();
        }
        
        @Override
        protected boolean canBeReplaced(BlockState state, Fluid fluid) {
            return false;
        }
    });
    public static final DeferredHolder<FluidType, FluidType> SOUL_LAVA_TYPE = ATMFluids.FLUID_TYPES.register("soul_lava", () -> new FluidType(FluidType.Properties.create()
            .descriptionId(ATMFluids.SOUL_LAVA_BLOCK.get().getDescriptionId())
            .lightLevel(15)
            .density(3000)
            .viscosity(6000)
            .temperature(6000)
            .motionScale(0.007D)
            .canExtinguish(false)
            .supportsBoating(true)
            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
            .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
            .sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)
            .canHydrate(false)
    ));
    
    public static final DeferredHolder<Item, BucketItem> MOLTEN_ALLTHEMODIUM_BUCKET = ATMFluids.registerItem("molten_allthemodium_bucket", p -> new BucketItem(ATMFluids.MOLTEN_ALLTHEMODIUM.get(), p));
    public static final DeferredHolder<Fluid, AllTheModiumFluid.Source> MOLTEN_ALLTHEMODIUM = ATMFluids.FLUIDS.register("molten_allthemodium", AllTheModiumFluid.Source::new);
    public static final DeferredHolder<Fluid, AllTheModiumFluid.Flowing> MOLTEN_ALLTHEMODIUM_FLOWING = ATMFluids.FLUIDS.register("flowing_molten_allthemodium", AllTheModiumFluid.Flowing::new);
    public static final DeferredHolder<Block, LiquidBlock> MOLTEN_ALLTHEMODIUM_BLOCK = ATMFluids.registerBlock("molten_allthemodium", p -> new LiquidBlock(ATMFluids.MOLTEN_ALLTHEMODIUM_FLOWING.get(), p
            .mapColor(DyeColor.YELLOW)
            .noCollision()
            .replaceable()
            .randomTicks()
            .strength(100.0F)
            .lightLevel(_ -> 15)
            .pushReaction(PushReaction.DESTROY)
            .noLootTable()
            .liquid()
            .sound(SoundType.EMPTY)
    ));
    public static final DeferredHolder<FluidType, FluidType> MOLTEN_ALLTHEMODIUM_TYPE = ATMFluids.FLUID_TYPES.register("molten_allthemodium", () -> new FluidType(FluidType.Properties.create()
            .descriptionId(ATMFluids.MOLTEN_ALLTHEMODIUM_BLOCK.get().getDescriptionId())
            .lightLevel(15)
            .density(3000)
            .viscosity(6000)
            .temperature(3000)
            .motionScale(0.0023333333333333335D)
            .canExtinguish(false)
            .supportsBoating(true)
            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
            .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
            .sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)
            .canHydrate(false)
    ));
    
    public static final DeferredHolder<Item, BucketItem> MOLTEN_VIBRANIUM_BUCKET = ATMFluids.registerItem("molten_vibranium_bucket", p -> new BucketItem(ATMFluids.MOLTEN_VIBRANIUM.get(), p));
    public static final DeferredHolder<Fluid, VibraniumFluid.Source> MOLTEN_VIBRANIUM = ATMFluids.FLUIDS.register("molten_vibranium", VibraniumFluid.Source::new);
    public static final DeferredHolder<Fluid, VibraniumFluid.Flowing> MOLTEN_VIBRANIUM_FLOWING = ATMFluids.FLUIDS.register("flowing_molten_vibranium", VibraniumFluid.Flowing::new);
    public static final DeferredHolder<Block, LiquidBlock> MOLTEN_VIBRANIUM_BLOCK = ATMFluids.registerBlock("molten_vibranium", p -> new LiquidBlock(ATMFluids.MOLTEN_VIBRANIUM_FLOWING.get(), p
            .mapColor(DyeColor.GREEN)
            .noCollision()
            .replaceable()
            .randomTicks()
            .strength(100.0F)
            .lightLevel(_ -> 15)
            .pushReaction(PushReaction.DESTROY)
            .noLootTable()
            .liquid()
            .sound(SoundType.EMPTY)
    ));
    public static final DeferredHolder<FluidType, FluidType> MOLTEN_VIBRANIUM_TYPE = ATMFluids.FLUID_TYPES.register("molten_vibranium", () -> new FluidType(FluidType.Properties.create()
            .descriptionId(ATMFluids.MOLTEN_VIBRANIUM_BLOCK.get().getDescriptionId())
            .lightLevel(15)
            .density(3000)
            .viscosity(6000)
            .temperature(3000)
            .motionScale(0.0023333333333333335D)
            .canExtinguish(false)
            .supportsBoating(true)
            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
            .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
            .sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)
            .canHydrate(false)
    ));
    
    public static final DeferredHolder<Item, BucketItem> MOLTEN_UNOBTAINIUM_BUCKET = ATMFluids.registerItem("molten_unobtainium_bucket", p -> new BucketItem(ATMFluids.MOLTEN_UNOBTAINIUM.get(), p));
    public static final DeferredHolder<Fluid, UnobtaniumFluid.Source> MOLTEN_UNOBTAINIUM = ATMFluids.FLUIDS.register("molten_unobtainium", UnobtaniumFluid.Source::new);
    public static final DeferredHolder<Fluid, UnobtaniumFluid.Flowing> MOLTEN_UNOBTAINIUM_FLOWING = ATMFluids.FLUIDS.register("flowing_molten_unobtainium", UnobtaniumFluid.Flowing::new);
    public static final DeferredHolder<Block, LiquidBlock> MOLTEN_UNOBTAINIUM_BLOCK = ATMFluids.registerBlock("molten_unobtainium", p -> new LiquidBlock(ATMFluids.MOLTEN_UNOBTAINIUM_FLOWING.get(), p
            .mapColor(DyeColor.PURPLE)
            .noCollision()
            .replaceable()
            .randomTicks()
            .strength(100.0F)
            .lightLevel(_ -> 15)
            .pushReaction(PushReaction.DESTROY)
            .noLootTable()
            .liquid()
            .sound(SoundType.EMPTY)
    ));
    public static final DeferredHolder<FluidType, FluidType> MOLTEN_UNOBTAINIUM_TYPE = ATMFluids.FLUID_TYPES.register("molten_unobtainium", () -> new FluidType(FluidType.Properties.create()
            .descriptionId(ATMFluids.MOLTEN_UNOBTAINIUM_BLOCK.get().getDescriptionId())
            .lightLevel(15)
            .density(3000)
            .viscosity(6000)
            .temperature(3000)
            .motionScale(0.0023333333333333335D)
            .canExtinguish(false)
            .supportsBoating(true)
            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
            .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
            .sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)
            .canHydrate(false)
    ));
    
    private static <T extends Block> DeferredHolder<Block, T> registerBlock(String name, Function<BlockBehaviour.Properties, T> factory) {
        return ATMFluids.BLOCKS.register(name, k -> factory.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, k))));
    }
    
    private static <T extends Item> DeferredHolder<Item, T> registerItem(String name, Function<Item.Properties, T> factory) {
        return ATMFluids.ITEMS.register(name, p -> factory.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, p))));
    }
    
    public static void register(final IEventBus bus) {
        ATMFluids.FLUIDS.register(bus);
        ATMFluids.FLUID_TYPES.register(bus);
        ATMFluids.BLOCKS.register(bus);
        ATMFluids.ITEMS.register(bus);
        bus.addListener(ATMFluids::commonSetup);
    }
    
    private static void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            FluidInteractionRegistry.addInteraction(NeoForgeMod.LAVA_TYPE.value(), new FluidInteractionRegistry.InteractionInformation(
                    ATMFluids.SOUL_LAVA_TYPE.get(), state -> state.isSource() ? Blocks.GILDED_BLACKSTONE.defaultBlockState() : Blocks.BLACKSTONE.defaultBlockState())
            );
            FluidInteractionRegistry.addInteraction(NeoForgeMod.WATER_TYPE.value(), new FluidInteractionRegistry.InteractionInformation(
                    ATMFluids.SOUL_LAVA_TYPE.get(), state -> state.isSource() ? Blocks.CRYING_OBSIDIAN.defaultBlockState() : Blocks.OBSIDIAN.defaultBlockState())
            );
        });
    }
}
