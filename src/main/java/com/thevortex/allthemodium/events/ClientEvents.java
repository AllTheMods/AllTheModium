package com.thevortex.allthemodium.events;

import com.thevortex.allthemodium.entity.PiglichEntity;
import com.thevortex.allthemodium.entity.PiglichModel;
import com.thevortex.allthemodium.entity.PiglichRenderer;
import com.thevortex.allthemodium.items.toolitems.armor.models.allthemodium_helmet;
import com.thevortex.allthemodium.items.toolitems.armor.models.unobtainium_helmet;
import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEvents {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModRegistry.PIGLICH.get(), PiglichRenderer::new);

    }
    @SubscribeEvent
    public static void registerMesh(EntityRenderersEvent.AddLayers event) {
        event.getEntityModels().bakeLayer(PiglichModel.LAYER_LOCATION);
    }
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(PiglichModel.LAYER_LOCATION, PiglichModel::createMesh);
        event.registerLayerDefinition(allthemodium_helmet.LAYER_LOCATION, allthemodium_helmet::createBodyLayer);
        event.registerLayerDefinition(unobtainium_helmet.LAYER_LOCATION, unobtainium_helmet::createBodyLayer);
    }

}
