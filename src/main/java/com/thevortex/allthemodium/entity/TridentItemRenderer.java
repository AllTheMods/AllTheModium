package com.thevortex.allthemodium.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.thevortex.allthemodium.items.toolitems.tools.ATMTrident;
import com.thevortex.allthemodium.reference.RenderHelpers;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.TridentModel;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class TridentItemRenderer extends BlockEntityWithoutLevelRenderer {
    private final ResourceLocation textureLocation;
    private final alloy_trident model;

    public TridentItemRenderer(ATMTrident item)
    {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        this.model = new alloy_trident(Minecraft.getInstance().getEntityModels().bakeLayer(RenderHelpers.layerId("alloy_trident")));
        this.textureLocation = ThrownTridentRenderer.DEFAULT_TEXTURE;
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext transforms, PoseStack poseStack, MultiBufferSource buffers, int packedLight, int packedOverlay)
    {
        poseStack.pushPose();
        poseStack.scale(1.0F, -1.0F, -1.0F);
        VertexConsumer buffer = ItemRenderer.getFoilBufferDirect(buffers, this.model.renderType(textureLocation), false, stack.hasFoil());
        model.renderToBuffer(poseStack, buffer, packedLight, packedOverlay);
        poseStack.popPose();
    }
}
