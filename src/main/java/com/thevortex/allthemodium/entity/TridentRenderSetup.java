package com.thevortex.allthemodium.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.client.model.TridentModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class TridentRenderSetup extends BlockEntityWithoutLevelRenderer{
   private ATMTridentModel tridentModel;
   private final EntityModelSet entityModelSet;

    public TridentRenderSetup(BlockEntityRenderDispatcher p_172550_, EntityModelSet p_172551_) {
        super(p_172550_, p_172551_);
        this.entityModelSet = p_172551_;

    }
    @Override
    public void onResourceManagerReload(ResourceManager manager) {
        this.tridentModel = new ATMTridentModel(this.entityModelSet.bakeLayer(alloy_trident.LAYER_LOCATION));
     }
     @Override
     public void renderByItem(ItemStack item, ItemDisplayContext context, PoseStack stack, MultiBufferSource bufferSource, int p_108834_, int p_108835_) {
    if (item.is(ModRegistry.ALLOY_TRIDENT.get())) {
         stack.pushPose();
         stack.scale(1.0F, -1.0F, -1.0F);
         VertexConsumer vertexconsumer1 = ItemRenderer.getFoilBufferDirect(bufferSource, this.tridentModel.renderType(TridentModel.TEXTURE), false, item.hasFoil());
         this.tridentModel.renderToBuffer(stack, vertexconsumer1, p_108834_, p_108835_);
         stack.popPose();
      }
     }

}
