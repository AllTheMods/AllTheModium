package com.thevortex.allthemodium.events;

import com.thevortex.allthemodium.entity.PiglichEntity;
import com.thevortex.allthemodium.entity.PiglichModel;
import com.thevortex.allthemodium.entity.PiglichRenderer;
import com.thevortex.allthemodium.entity.PiglichType;
import com.thevortex.allthemodium.items.toolitems.armor.models.allthemodium_helmet;
import com.thevortex.allthemodium.items.toolitems.armor.models.unobtainium_helmet;
import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEvents {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
                event.registerEntityRenderer(PiglichType.PIGLICH, p_174010_ -> PiglichRenderer.RENDERER);

    }

    @SubscribeEvent
    public static void registerMesh(EntityRenderersEvent.AddLayers event) {
        event.getEntityModels().bakeLayer(PiglichModel.LAYER_LOCATION);
    }
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(PiglichModel.LAYER_LOCATION, () -> LayerDefinition.create(PiglichModel.createMesh(),64,64));
        event.registerLayerDefinition(allthemodium_helmet.LAYER_LOCATION, allthemodium_helmet::createBodyLayer);
        event.registerLayerDefinition(unobtainium_helmet.LAYER_LOCATION, unobtainium_helmet::createBodyLayer);
    }

}
