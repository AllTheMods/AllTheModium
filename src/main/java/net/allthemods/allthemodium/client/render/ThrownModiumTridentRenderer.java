package net.allthemods.allthemodium.client.render;

import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.ThrownItemRenderState;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import net.allthemods.allthemodium.common.entity.ThrownModiumTrident;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import org.jspecify.annotations.NonNull;

public class ThrownModiumTridentRenderer extends EntityRenderer<ThrownModiumTrident, ThrownModiumTridentRenderer.RenderState> {
    
    private final ItemModelResolver itemModelResolver;
    
    public ThrownModiumTridentRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.itemModelResolver = context.getItemModelResolver();
    }
    
    @Override
    public void submit(RenderState state, PoseStack poseStack, SubmitNodeCollector collector, @NonNull CameraRenderState camera) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(state.yRot + 90.0F));
        poseStack.mulPose(Axis.ZN.rotationDegrees(state.xRot - 90.0F));
        poseStack.translate(0.0D, -0.75D, 0.0D);
        state.item.submit(poseStack, collector, state.lightCoords, OverlayTexture.NO_OVERLAY, state.outlineColor);
        poseStack.popPose();
        super.submit(state, poseStack, collector, camera);
    }
    
    @Override
    public RenderState createRenderState() {
        return new RenderState();
    }
    
    @Override
    public void extractRenderState(ThrownModiumTrident entity, RenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.yRot = entity.getYRot(partialTicks);
        state.xRot = entity.getXRot(partialTicks);
        state.isFoiled = entity.isFoil();
        ItemStack renderStack = entity.getPickupItemStackOrigin().copy();
        renderStack.set(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, state.isFoiled);
        this.itemModelResolver.updateForNonLiving(state.item, renderStack, ItemDisplayContext.NONE, entity);
    }
    
    public static final class RenderState extends ThrownItemRenderState {
        public float xRot;
        public float yRot;
        public boolean isFoiled;
    }
}
