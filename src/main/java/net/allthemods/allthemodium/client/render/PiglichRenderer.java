package net.allthemods.allthemodium.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

import net.allthemods.allthemodium.client.model.PiglichModel;
import net.allthemods.allthemodium.common.entity.PiglichEntity;

import com.geckolib.renderer.GeoEntityRenderer;

public class PiglichRenderer extends GeoEntityRenderer<PiglichEntity, LivingEntityRenderState> {
    
    public PiglichRenderer(EntityRendererProvider.Context context) {
        super(context, new PiglichModel());
        this.shadowRadius = 0.8F;
    }
}
