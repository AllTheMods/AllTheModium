package net.allthemods.allthemodium.core.event;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterFluidModelsEvent;
import net.neoforged.neoforge.client.event.ViewportEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.util.FakePlayer;
import net.neoforged.neoforge.event.AddAttributeTooltipsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.EntityInvulnerabilityCheckEvent;
import net.neoforged.neoforge.event.entity.living.LivingFallEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.level.block.BreakBlockEvent;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.fog.FogData;
import net.minecraft.client.renderer.fog.environment.FogEnvironment;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.ARGB;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.client.lang.ATMLanguage;
import net.allthemods.allthemodium.client.render.ATMFluidModels;
import net.allthemods.allthemodium.client.render.PiglichRenderer;
import net.allthemods.allthemodium.client.render.ThrownModiumTridentRenderer;
import net.allthemods.allthemodium.common.blocks.TeleportPad;
import net.allthemods.allthemodium.common.entity.PiglichEntity;
import net.allthemods.allthemodium.common.items.ModiumBootsItem;
import net.allthemods.allthemodium.common.items.ModiumChestplateItem;
import net.allthemods.allthemodium.common.items.ModiumHelmetItem;
import net.allthemods.allthemodium.common.items.ModiumLeggingsItem;
import net.allthemods.allthemodium.core.registry.ATMEntities;
import net.allthemods.allthemodium.core.registry.ATMFluids;
import net.allthemods.allthemodium.core.registry.ATMItems;
import net.allthemods.allthemodium.core.registry.ATMTags;

import org.joml.Vector4f;
import org.jspecify.annotations.Nullable;

import java.util.List;

public final class ATMEventListener {
    
    @EventBusSubscriber(modid = ATM.MOD_ID, value = Dist.CLIENT)
    private static final class Client {
        
        @SubscribeEvent
        private static void onTooltipEvent(final AddAttributeTooltipsEvent event) {
            ItemStack stack = event.getStack();
            if (!(stack.getItem() instanceof BlockItem bi && bi.getBlock() instanceof TeleportPad)) return;
            
            event.addTooltipLines(ATMLanguage.MESSAGE_TELEPORT_PAD_USAGE.translate(ChatFormatting.GRAY));
            List<Component> components = TeleportPad.display();
            for (Component component : components) {
                event.addTooltipLines(component);
            }
        }
        
        @SubscribeEvent
        private static void onRegisterRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(ATMEntities.ALLOY_TRIDENT_ENTITY.get(), ThrownModiumTridentRenderer::new);
            event.registerEntityRenderer(ATMEntities.PIGLICH.get(), PiglichRenderer::new);
        }
        
        @SubscribeEvent
        private static void onRegisterFluidModels(final RegisterFluidModelsEvent event) {
            event.register(ATMFluidModels.SOUL_LAVA_MODEL, ATMFluids.SOUL_LAVA, ATMFluids.SOUL_LAVA_FLOWING);
            event.register(ATMFluidModels.MOLTEN_ALLTHEMODIUM_MODEL, ATMFluids.MOLTEN_ALLTHEMODIUM, ATMFluids.MOLTEN_ALLTHEMODIUM_FLOWING);
            event.register(ATMFluidModels.MOLTEN_VIBRANIUM_MODEL, ATMFluids.MOLTEN_VIBRANIUM, ATMFluids.MOLTEN_VIBRANIUM_FLOWING);
            event.register(ATMFluidModels.MOLTEN_UNOBTAINIUM_MODEL, ATMFluids.MOLTEN_UNOBTAINIUM, ATMFluids.MOLTEN_UNOBTAINIUM_FLOWING);
        }
        
        @SubscribeEvent(priority = EventPriority.LOWEST)
        private static void onRenderFog(final ViewportEvent.RenderFog event) {
            Camera camera = event.getCamera();
            if (!(camera.entity() instanceof Player player)) return;
            if (ATMEventListener.getStackInSlot(player, EquipmentSlot.HEAD).isEmpty()) return;
            event.setFarPlaneDistance(event.getFarPlaneDistance() * 5.0F);
        }
        
        @SubscribeEvent
        private static void onRegisterClientExtensions(final RegisterClientExtensionsEvent event) {
            event.registerFluidType(ATMEventListener.Client.lavaLikeFluidExtensions(0x536BA9), ATMFluids.SOUL_LAVA_TYPE.get());
            event.registerFluidType(ATMEventListener.Client.lavaLikeFluidExtensions(0xFEB216), ATMFluids.MOLTEN_ALLTHEMODIUM_TYPE.get());
            event.registerFluidType(ATMEventListener.Client.lavaLikeFluidExtensions(0x2CB996), ATMFluids.MOLTEN_VIBRANIUM_TYPE.get());
            event.registerFluidType(ATMEventListener.Client.lavaLikeFluidExtensions(0xAD3FEF), ATMFluids.MOLTEN_UNOBTAINIUM_TYPE.get());
        }
        
        private static IClientFluidTypeExtensions lavaLikeFluidExtensions(int fogColor) {
            return new IClientFluidTypeExtensions() {
                
                @Override
                public void modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector4f fluidFogColor) {
                    float red = ARGB.redFloat(fogColor);
                    float green = ARGB.greenFloat(fogColor);
                    float blue = ARGB.blueFloat(fogColor);
                    
                    if (darkenWorldAmount > 0.0F) {
                        red = Mth.lerp(darkenWorldAmount, red, red * 0.7F);
                        green = Mth.lerp(darkenWorldAmount, green, green * 0.6F);
                        blue = Mth.lerp(darkenWorldAmount, blue, blue * 0.6F);
                    }
                    
                    fluidFogColor.set(red, green, blue, 1.0F);
                }
                
                @Override
                public void modifyFogRender(Camera camera, @Nullable FogEnvironment environment, float renderDistance, float partialTick, FogData fogData) {
                    Entity entity = camera.entity();
                    if (entity == null) return;
                    
                    if (entity.isSpectator()) {
                        float renderDistanceBlocks = renderDistance * 16.0F;
                        fogData.environmentalStart = -8.0F;
                        fogData.environmentalEnd = renderDistanceBlocks * 0.5F;
                    } else if (entity instanceof LivingEntity living && living.hasEffect(MobEffects.FIRE_RESISTANCE)) {
                        fogData.environmentalStart = 0.0F;
                        fogData.environmentalEnd = 5.0F;
                    } else {
                        fogData.environmentalStart = 0.25F;
                        fogData.environmentalEnd = 1.0F;
                    }
                    
                    fogData.skyEnd = fogData.environmentalEnd;
                    fogData.cloudEnd = fogData.environmentalEnd;
                }
                
            };
        }
    }
    
    @EventBusSubscriber(modid = ATM.MOD_ID)
    private static final class Common {
        
        @SubscribeEvent
        private static void onEntityAttributeCreation(final EntityAttributeCreationEvent event) {
            event.put(ATMEntities.PIGLICH.get(), PiglichEntity.createAttributes().build());
        }
        
        @SubscribeEvent
        private static void onBreakSpeed(final PlayerEvent.BreakSpeed event) {
            BlockState state = event.getState();
            if (Common.isNotModiumOres(state)) return;
            
            Player player = event.getEntity();
            ItemStack stack = player.getMainHandItem();
            Tool tool = stack.get(DataComponents.TOOL);
            if (tool == null || !tool.isCorrectForDrops(state)) event.setCanceled(true);
        }
        
        @SubscribeEvent(priority = EventPriority.LOWEST)
        private static void onHarvestCheck(final PlayerEvent.HarvestCheck event) {
            BlockState state = event.getTargetBlock();
            if (Common.isNotModiumOres(state)) return;
            
            Player player = event.getEntity();
            ItemStack stack = player.getMainHandItem();
            Tool tool = stack.get(DataComponents.TOOL);
            event.setCanHarvest(tool != null && tool.isCorrectForDrops(state) && event.canHarvest());
        }
        
        @SubscribeEvent
        private static void onBlockBreak(final BreakBlockEvent event) {
            final Player player = event.getPlayer();
            final LevelAccessor level = event.getLevel();
            final BlockState state = event.getState();
            final BlockPos pos = event.getPos();
            if (player.isCreative() || Common.isNotModiumOres(state)) return;
            
            boolean isFake = (player instanceof FakePlayer || player.isFakePlayer() || player.getMainHandItem().isEmpty());
            
            if (state.is(ATMTags.Blocks.ORES_ALLTHEMODIUM) && isFake) {
                level.setBlock(pos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                event.setCanceled(true);
                return;
            }
            
            if ((state.is(ATMTags.Blocks.ORES_VIBRANIUM) || state.is(ATMTags.Blocks.ORES_UNOBTANIUM)) && isFake) {
                event.setCanceled(true);
                return;
            }
            
            if (state.is(ATMTags.Blocks.OTHER_PROTECTION) && level.getBiome(pos).is(ATMTags.Biomes.IS_OTHER) && isFake) {
                event.setCanceled(true);
            }
        }
        
        private static boolean isNotModiumOres(BlockState state) {
            return !(state.is(ATMTags.Blocks.ORES_ALLTHEMODIUM) || state.is(ATMTags.Blocks.ORES_VIBRANIUM) || state.is(ATMTags.Blocks.ORES_UNOBTANIUM));
        }
        
        @SubscribeEvent
        private static void onLivingFall(final LivingFallEvent event) {
            if (!(event.getEntity() instanceof ServerPlayer player)) return;
            if (ATMEventListener.getStackInSlot(player, EquipmentSlot.FEET).isEmpty()) return;
            event.setCanceled(true);
        }
        
        @SubscribeEvent
        private static void onLivingIncomingDamage(final LivingIncomingDamageEvent event) {
            if (!(event.getEntity() instanceof ServerPlayer player)) return;
            final DamageSource source = event.getSource();
            final float original = event.getOriginalAmount();
            final ItemStack chestplate = ATMEventListener.getStackInSlot(player, EquipmentSlot.CHEST);
            
            if (source.is(Tags.DamageTypes.IS_MAGIC)) {
                event.setAmount(switch (chestplate.getItem()) {
                    case ModiumChestplateItem _ when chestplate.is(ATMItems.ALLTHEMODIUM_CHESTPLATE) -> original * 0.5F;
                    case ModiumChestplateItem _ when chestplate.is(ATMItems.VIBRANIUM_CHESTPLATE) -> original * 0.25F;
                    case ModiumChestplateItem _ when chestplate.is(ATMItems.UNOBTAINIUM_CHESTPLATE) -> original * 0.1F;
                    default -> original;
                });
            }
        }
        
        @SubscribeEvent
        private static void onEntityInvulnerabilityCheck(final EntityInvulnerabilityCheckEvent event) {
            if (!(event.getEntity() instanceof ServerPlayer player)) return;
            final DamageSource source = event.getSource();
            final ItemStack helmet = ATMEventListener.getStackInSlot(player, EquipmentSlot.HEAD);
            final ItemStack chestplate = ATMEventListener.getStackInSlot(player, EquipmentSlot.CHEST);
            final ItemStack leggings = ATMEventListener.getStackInSlot(player, EquipmentSlot.LEGS);
            final ItemStack boots = ATMEventListener.getStackInSlot(player, EquipmentSlot.FEET);
            
            if (source.is(DamageTypes.FLY_INTO_WALL) && !helmet.isEmpty()) {
                event.setInvulnerable(true);
                return;
            }
            
            if (source.is(DamageTypeTags.IS_DROWNING) && !helmet.isEmpty()) {
                player.setAirSupply(player.getMaxAirSupply());
                event.setInvulnerable(true);
                return;
            }
            
            if (source.is(DamageTypeTags.IS_FIRE) && !(chestplate.isEmpty() && boots.isEmpty())) {
                event.setInvulnerable(true);
                player.clearFire();
                return;
            }
            
            if (source.is(DamageTypeTags.IS_FREEZING) && !chestplate.isEmpty()) {
                event.setInvulnerable(true);
                player.clearFreeze();
                return;
            }
            
            if (source.is(DamageTypes.FELL_OUT_OF_WORLD) && chestplate.is(ATMItems.UNOBTAINIUM_CHESTPLATE)) {
                event.setInvulnerable(true);
            }
        }
    }
    
    private static ItemStack getStackInSlot(Player player, EquipmentSlot slot) {
        final ItemStack stack = player.getItemBySlot(slot);
        return switch (stack.getItem()) {
            case ModiumHelmetItem _ when slot == EquipmentSlot.HEAD -> stack;
            case ModiumChestplateItem _ when slot == EquipmentSlot.CHEST -> stack;
            case ModiumLeggingsItem _ when slot == EquipmentSlot.LEGS -> stack;
            case ModiumBootsItem _ when slot == EquipmentSlot.FEET -> stack;
            default -> ItemStack.EMPTY;
        };
    }
}
