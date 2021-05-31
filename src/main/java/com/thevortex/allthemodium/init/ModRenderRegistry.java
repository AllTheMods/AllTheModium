package com.thevortex.allthemodium.init;

import com.github.alexthe666.citadel.client.model.TabulaModel;
import com.github.alexthe666.citadel.client.model.TabulaModelHandler;
import com.github.alexthe666.iceandfire.client.model.animator.LightningTabulaDragonAnimator;
import com.thevortex.allthemodium.entities.renderer.SkeletonDragonRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import java.io.IOException;

@OnlyIn(Dist.CLIENT)
public class ModRenderRegistry {

    public static  void registryEntityRenders()
    {
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SKELETON_DRAGON.get(), manager -> {
            try {
                return new SkeletonDragonRenderer(manager, new TabulaModel(TabulaModelHandler.INSTANCE.loadTabulaModel("/assets/iceandfire/models/tabula/lightningdragon/dragonLightningGround"), new LightningTabulaDragonAnimator()), 2);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        });
    }
}
