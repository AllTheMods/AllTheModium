package net.allthemods.allthemodium.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;

import net.allthemods.allthemodium.client.model.PiglichModel;
import net.allthemods.allthemodium.common.entity.PiglichEntity;

import com.geckolib.renderer.GeoEntityRenderer;

import org.jspecify.annotations.Nullable;

public class PiglichRenderer extends GeoEntityRenderer<PiglichEntity, LivingEntityRenderState> {

    public PiglichRenderer(EntityRendererProvider.Context context) {
        super(context, new PiglichModel());
        this.shadowRadius = 0.8F;
        this.withRenderLayer(PiglichGlowLayer::new);
    }

    @Override
    public @Nullable RenderType getRenderType(LivingEntityRenderState renderState, Identifier texture) {
        return renderState.isInvisible ? super.getRenderType(renderState, texture) : RenderTypes.entityTranslucent(texture);
    }
}
