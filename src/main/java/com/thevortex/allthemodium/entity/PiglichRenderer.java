package com.thevortex.allthemodium.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PiglichRenderer extends EntityRenderer<PiglichEntity> {


    public PiglichRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(PiglichEntity p_114485_, float p_114486_, float p_114487_, PoseStack p_114488_, MultiBufferSource p_114489_, int p_114490_) {
        super.render(p_114485_, p_114486_, p_114487_, p_114488_, p_114489_, p_114490_);
    }

    @Override
    public ResourceLocation getTextureLocation(PiglichEntity p_114482_) {
        return new ResourceLocation(Reference.MOD_ID, "textures/entity/piglich.png");

    }
}
