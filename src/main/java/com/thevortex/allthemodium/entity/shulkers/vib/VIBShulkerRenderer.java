package com.thevortex.allthemodium.entity.shulkers.vib;

import com.mojang.blaze3d.vertex.PoseStack;
import com.thevortex.allthemodium.reference.Reference;
import javax.annotation.Nonnull;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class VIBShulkerRenderer
        extends MobRenderer<VIBShulkerEntity, VIBShulkerModel<VIBShulkerEntity>> {

    public VIBShulkerRenderer(EntityRendererProvider.Context context) {
        super(
                context,
                new VIBShulkerModel<>(
                        context.bakeLayer(VIBShulkerModel.LAYER_LOCATION),
                        true),
                0.5F);
    }

    @Override
    public void render(
            @Nonnull VIBShulkerEntity p_114485_,
            float p_114486_,
            float p_114487_,
            @Nonnull PoseStack p_114488_,
            @Nonnull MultiBufferSource p_114489_,
            int p_114490_) {
        super.render(
                p_114485_,
                p_114486_,
                p_114487_,
                p_114488_,
                p_114489_,
                p_114490_);
    }

    @Override
    public ResourceLocation getTextureLocation(
            @Nonnull VIBShulkerEntity p_114482_) {
        return new ResourceLocation(
                Reference.MOD_ID,
                "textures/entity/vibranium_shulker.png");
    }
}
