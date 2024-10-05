package com.thevortex.allthemodium.events;

import com.thevortex.allthemodium.entity.PiglichModel;
import com.thevortex.allthemodium.entity.PiglichRenderer;
import com.thevortex.allthemodium.entity.shulkers.atm.ATMShulkerModel;
import com.thevortex.allthemodium.items.toolitems.armor.models.AllthemodiumHelmetModel;
import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEvents {

    @SubscribeEvent
    public static void registerRenderers(
            EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(
                ModRegistry.PIGLICH.get(),
                PiglichRenderer::new);
        // event.registerEntityRenderer(ModRegistry.ATM_SHULKER.get(),
        // UNOBShulkerRenderer::new);
        // event.registerEntityRenderer(ModRegistry.ATM_SHULKER.get(),
        // UNOBShulkerRenderer::new);
    }

    @SuppressWarnings("removal") // TODO: Alternative required for 1.20+
    @SubscribeEvent
    public static void registerTree(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(
                ModRegistry.ANCIENT_HERB.get(),
                RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(
                ModRegistry.ANCIENT_SAPLING.get(),
                RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(
                ModRegistry.ANCIENT_LEAVES.get(),
                RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ModRegistry.ANCIENT_LEAVES_BOTTOM.get(),
                RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(
                ModRegistry.ANCIENT_TRAPDOOR.get(),
                RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ModRegistry.ANCIENT_DOOR_.get(),
                RenderType.cutoutMipped());

        ItemBlockRenderTypes.setRenderLayer(
                ModRegistry.DEMONIC_HERB.get(),
                RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(
                ModRegistry.DEMONIC_SAPLING.get(),
                RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(
                ModRegistry.DEMONIC_LEAVES.get(),
                RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ModRegistry.DEMONIC_LEAVES_BOTTOM.get(),
                RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(
                ModRegistry.DEMONIC_TRAPDOOR.get(),
                RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ModRegistry.DEMONIC_DOOR_.get(),
                RenderType.cutoutMipped());

        ItemBlockRenderTypes.setRenderLayer(
                ModRegistry.SOUL_HERB.get(),
                RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(
                ModRegistry.SOUL_SAPLING.get(),
                RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(
                ModRegistry.SOUL_LEAVES.get(),
                RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ModRegistry.SOUL_LEAVES_BOTTOM.get(),
                RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(
                ModRegistry.SOUL_TRAPDOOR.get(),
                RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ModRegistry.SOUL_DOOR_.get(),
                RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ModRegistry.ANCIENT_CAVEVINES_.get(),
                RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ModRegistry.ANCIENT_CAVEVINES_PLANT_.get(),
                RenderType.cutoutMipped());
    }

    @SubscribeEvent
    public static void registerMesh(EntityRenderersEvent.AddLayers event) {
        event.getEntityModels().bakeLayer(PiglichModel.LAYER_LOCATION);
        event.getEntityModels().bakeLayer(ATMShulkerModel.LAYER_LOCATION);
    }

    @SubscribeEvent
    public static void registerLayer(
            EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(
                PiglichModel.LAYER_LOCATION,
                () -> PiglichModel.createBodyLayer());
        event.registerLayerDefinition(
                ATMShulkerModel.LAYER_LOCATION,
                () -> ATMShulkerModel.createBodyLayer());
        event.registerLayerDefinition(
                AllthemodiumHelmetModel.LAYER_LOCATION,
                AllthemodiumHelmetModel::createBodyLayer);
    }
}
