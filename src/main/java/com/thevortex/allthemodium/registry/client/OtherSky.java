package com.thevortex.allthemodium.registry.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Matrix4f;
import javax.annotation.Nonnull;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.world.phys.Vec3;

public class OtherSky extends DimensionSpecialEffects {

    public OtherSky(
            float p_108866_,
            boolean p_108867_,
            SkyType p_108868_,
            boolean p_108869_,
            boolean p_108870_) {
        super(p_108866_, p_108867_, p_108868_, p_108869_, p_108870_);
    }

    @Override
    public Vec3 getBrightnessDependentFogColor(
            @Nonnull Vec3 p_108878_,
            float p_108879_) {
        return p_108878_;
    }

    @Override
    public boolean isFoggyAt(int p_108874_, int p_108875_) {
        return true;
    }

    @Override
    public float getCloudHeight() {
        return Float.NaN;
    }

    @Override
    public boolean renderClouds(
            @Nonnull ClientLevel level,
            int ticks,
            float partialTick,
            @Nonnull PoseStack poseStack,
            double camX,
            double camY,
            double camZ,
            @Nonnull Matrix4f projectionMatrix) {
        return false;
    }
    // @Override
    // public boolean renderSky(ClientLevel level, int ticks, float partialTick, PoseStack poseStack, Camera camera,
    //         Matrix4f projectionMatrix,
    //         boolean isFoggy, Runnable setupFog) {
    //     return ((level.getBiome(camera.getBlockPosition()).is(ATMBiomes.CRIMSON_FOREST)) ||
    //             (level.getBiome(camera.getBlockPosition()).is(ATMBiomes.WARPED_FOREST)) ||
    //             (level.getBiome(camera.getBlockPosition()).is(ATMBiomes.THE_OTHER)));
    // }

}
