package com.thevortex.allthemodium.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.reference.RenderHelpers;
import com.thevortex.allthemodium.entity.ThrownTrident;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;

public class ThrownTridentRenderer extends EntityRenderer<ThrownTrident> {
    public static final ResourceLocation DEFAULT_TEXTURE = Reference.atm("textures/entity/alloy_trident.png");


    private final alloy_trident model;

    public ThrownTridentRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new alloy_trident(context.bakeLayer(RenderHelpers.layerId("alloy_trident")));
    }

    @Override
    public void render(ThrownTrident javelin, float ageInTicks, float pitch, PoseStack poseStack, MultiBufferSource buffers, int packedLight) {
        poseStack.pushPose();

        float degrees = Mth.lerp(pitch, javelin.yRotO, javelin.getYRot()) - 90.0F;
        poseStack.mulPose(Axis.YP.rotationDegrees(degrees));
        float degrees1 = Mth.lerp(pitch, javelin.xRotO, javelin.getXRot()) + 90.0F;
        poseStack.mulPose(Axis.ZP.rotationDegrees(degrees1));

        final VertexConsumer buffer = ItemRenderer.getFoilBufferDirect(buffers, this.model.renderType(getTextureLocation(javelin)), false, false);
        this.model.renderToBuffer(poseStack, buffer, packedLight, OverlayTexture.NO_OVERLAY, -1);

        poseStack.popPose();
        super.render(javelin, ageInTicks, pitch, poseStack, buffers, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(ThrownTrident entity) {
        return DEFAULT_TEXTURE;
    }
}