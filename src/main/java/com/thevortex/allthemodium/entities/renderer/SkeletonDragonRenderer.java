package com.thevortex.allthemodium.entities.renderer;

import com.github.alexthe666.iceandfire.client.particle.LightningBoltData;
import com.github.alexthe666.iceandfire.client.particle.LightningRender;
import com.github.alexthe666.iceandfire.client.particle.LightningBoltData.BoltRenderInfo;
import com.github.alexthe666.iceandfire.client.particle.LightningBoltData.SpawnFunction;
import com.github.alexthe666.iceandfire.client.render.entity.RenderDragonBase;
import com.github.alexthe666.iceandfire.entity.EntityDragonBase;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.thevortex.allthemodium.entities.SkeletonDragonEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.culling.ClippingHelper;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;

public class SkeletonDragonRenderer extends RenderDragonBase {
    private LightningRender lightningRender = new LightningRender();

    public SkeletonDragonRenderer(EntityRendererManager manager, SegmentedModel model, int dragonType) {
        super(manager, model, dragonType);
    }

    public boolean shouldRender(EntityDragonBase livingEntityIn, ClippingHelper camera, double camX, double camY, double camZ) {
        if (super.shouldRender(livingEntityIn, camera, camX, camY, camZ)) {
            return true;
        } else {
            SkeletonDragonEntity lightningDragon = (SkeletonDragonEntity)livingEntityIn;
            if (lightningDragon.hasLightningTarget()) {
                Vector3d Vector3d1 = lightningDragon.getHeadPosition();
                Vector3d Vector3d = new Vector3d(lightningDragon.getLightningTargetX(), lightningDragon.getLightningTargetY(), lightningDragon.getLightningTargetZ());
                return camera.isVisible(new AxisAlignedBB(Vector3d1.x, Vector3d1.y, Vector3d1.z, Vector3d.x, Vector3d.y, Vector3d.z));
            } else {
                return false;
            }
        }
    }

    public void render(EntityDragonBase entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        SkeletonDragonEntity lightningDragon = (SkeletonDragonEntity)entityIn;
        matrixStackIn.pushPose();
        if (lightningDragon.hasLightningTarget()) {
            double dist = Minecraft.getInstance().player.distanceTo(lightningDragon);
            if (dist <= (double)Math.max(256.0F, (float)Minecraft.getInstance().options.renderDistance * 16.0F)) {
                Vector3d Vector3d1 = lightningDragon.getHeadPosition();
                Vector3d Vector3d = new Vector3d(lightningDragon.getLightningTargetX(), (double)lightningDragon.getLightningTargetY(), lightningDragon.getLightningTargetZ());
                float energyScale = 0.4F * lightningDragon.getScale();
                LightningBoltData bolt = (new LightningBoltData(BoltRenderInfo.ELECTRICITY, Vector3d1, Vector3d, 15)).size(0.05F * getBoundedScale(energyScale, 0.5F, 2.0F)).lifespan(4).spawn(SpawnFunction.NO_DELAY);
                this.lightningRender.update(null, bolt, partialTicks);
                matrixStackIn.translate(-lightningDragon.getX(), -lightningDragon.getY(), -lightningDragon.getZ());
                this.lightningRender.render(partialTicks, matrixStackIn, bufferIn);
            }
        }

        matrixStackIn.popPose();
    }

    private static float getBoundedScale(float scale, float min, float max) {
        return min + scale * (max - min);
    }
}
