package com.thevortex.allthemodium.events;

import com.thevortex.allthemodium.entity.PiglichModel;
import com.thevortex.allthemodium.entity.PiglichRenderer;
import com.thevortex.allthemodium.entity.ThrownTridentRenderer;
import com.thevortex.allthemodium.entity.alloy_trident;
import com.thevortex.allthemodium.items.toolitems.armor.models.allthemodium_helmet;
import com.thevortex.allthemodium.items.toolitems.tools.Unobow;
import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.reference.RenderHelpers;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BrushableBlockRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ChargedProjectiles;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = Reference.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ClientEvents {
   
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
                event.registerEntityRenderer(ModRegistry.PIGLICH.get(), PiglichRenderer::new);
        event.registerBlockEntityRenderer(ModRegistry.BRUSHABLE_BLOCK.get(), BrushableBlockRenderer::new);
        
        event.registerEntityRenderer(ModRegistry.ALLOY_TRIDENT_ENTITY.get(), ThrownTridentRenderer::new);

    }

    @SubscribeEvent
    public static void registerTree(FMLClientSetupEvent event){
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.ANCIENT_HERB.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.ANCIENT_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.ANCIENT_LEAVES.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.ANCIENT_LEAVES_BOTTOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.ANCIENT_TRAPDOOR.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.ANCIENT_DOOR.get(), RenderType.cutoutMipped());

        ItemBlockRenderTypes.setRenderLayer(ModRegistry.DEMONIC_HERB.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.DEMONIC_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.DEMONIC_LEAVES.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.DEMONIC_LEAVES_BOTTOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.DEMONIC_TRAPDOOR.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.DEMONIC_DOOR.get(), RenderType.cutoutMipped());

        ItemBlockRenderTypes.setRenderLayer(ModRegistry.SOUL_HERB.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.SOUL_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.SOUL_LEAVES.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.SOUL_LEAVES_BOTTOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.SOUL_TRAPDOOR.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.SOUL_DOOR.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.ANCIENT_CAVEVINES.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.ANCIENT_CAVEVINES_PLANT.get(), RenderType.cutoutMipped());
/*
        ItemProperties.register(ModRegistry.ATM_BOW.get(), ResourceLocation.withDefaultNamespace("pull"), (itemStack, clientWorld, livingEntity, i) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                return (livingEntity.getUseItem() != itemStack) ? 0.0F : (float)(itemStack.getUseDuration(livingEntity) - livingEntity.getUseItemRemainingTicks()) / 20.0F;
            }
        });
        ItemProperties.register(ModRegistry.ATM_BOW.get(), ResourceLocation.withDefaultNamespace("pulling"), (itemStack, clientWorld, livingEntity, i) -> {
            return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem().is(ModRegistry.ATM_BOW.get()) ? 1.0F : 0.0F;
        });

        ItemProperties.register(ModRegistry.UNO_BOW.get(), ResourceLocation.withDefaultNamespace("pull"), (itemStack, clientWorld, livingEntity, i) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                if (Unobow.isCharged(itemStack)) {
                    return 0.0F;
                }
                int used = itemStack.getUseDuration(livingEntity) - livingEntity.getUseItemRemainingTicks();
                int charge = Unobow.getSafeChargeDuration(itemStack, livingEntity);
                return Math.max(0.0F, Math.min(1.0F, (float) used / (float) charge));
            }
        });
        ItemProperties.register(ModRegistry.UNO_BOW.get(), ResourceLocation.withDefaultNamespace("pulling"), (itemStack, clientWorld, livingEntity, i) -> {
            return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem().is(ModRegistry.UNO_BOW.get()) && !Unobow.isCharged(itemStack) ? 1.0F : 0.0F;
        });
        ItemProperties.register(ModRegistry.UNO_BOW.get(), ResourceLocation.withDefaultNamespace("charged"), (itemStack, clientWorld, livingEntity, i) -> {
            return Unobow.isCharged(itemStack) ? 1.0F : 0.0F;
        });
        ItemProperties.register(ModRegistry.UNO_BOW.get(), ResourceLocation.withDefaultNamespace("firework"), (itemStack, clientWorld, livingEntity, i) -> {
            ChargedProjectiles chargedprojectiles = itemStack.get(DataComponents.CHARGED_PROJECTILES);
            return chargedprojectiles != null && Unobow.isCharged(itemStack) && chargedprojectiles.contains(Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
        });

 */
        ItemProperties.register(ModRegistry.ALLOY_TRIDENT.get(), ResourceLocation.withDefaultNamespace("throwing"), (itemStack, clientWorld, livingEntity, i) -> {
            if (livingEntity == null) {
                return 0.0F;
        
            } else {
                  return (livingEntity.isUsingItem() && livingEntity.getUseItem().is(ModRegistry.ALLOY_TRIDENT.get())) ? 1.0F : 0.0F;
            }
        });
    }
    @SubscribeEvent
    public static void registerMesh(EntityRenderersEvent.AddLayers event) {
        event.getEntityModels().bakeLayer(PiglichModel.LAYER_LOCATION);
        event.getEntityModels().bakeLayer(allthemodium_helmet.LAYER_LOCATION);
    }
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(PiglichModel.LAYER_LOCATION, () -> PiglichModel.createBodyLayer());
        event.registerLayerDefinition(allthemodium_helmet.LAYER_LOCATION, allthemodium_helmet::createBodyLayer);
        event.registerLayerDefinition(RenderHelpers.layerId("alloy_trident"), alloy_trident::createBodyLayer);
    }



}
