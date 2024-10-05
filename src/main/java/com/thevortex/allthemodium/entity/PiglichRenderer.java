package com.thevortex.allthemodium.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.thevortex.allthemodium.reference.Reference;
import javax.annotation.Nullable;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

@OnlyIn(Dist.CLIENT)
public class PiglichRenderer extends GeoEntityRenderer<PiglichEntity> {

    public PiglichRenderer(EntityRendererProvider.Context context) {
        super(context, new PiglichModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(PiglichEntity instance) {
        return new ResourceLocation(
                Reference.MOD_ID,
                "textures/entity/piglich.png");
    }

    @Override
    public RenderType getRenderType(
            PiglichEntity animatable,
            float partialTicks,
            PoseStack stack,
            @Nullable MultiBufferSource renderTypeBuffer,
            @Nullable VertexConsumer vertexBuilder,
            int packedLightIn,
            ResourceLocation textureLocation) {
        stack.scale(1.1f, 1.1f, 1.1f);
        return super.getRenderType(
                animatable,
                partialTicks,
                stack,
                renderTypeBuffer,
                vertexBuilder,
                packedLightIn,
                textureLocation);
    }
}
