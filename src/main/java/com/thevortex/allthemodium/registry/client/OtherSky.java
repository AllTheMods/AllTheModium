package com.thevortex.allthemodium.registry.client;

import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.world.phys.Vec3;

public class OtherSky extends DimensionSpecialEffects {

    private final float cloudLevel;
    private final boolean hasGround;
    private final SkyType skyType;
    private final boolean forceBrightLightmap;
    private final boolean constantAmbientLight;


        public OtherSky(float cloudLevel, boolean hasGround, SkyType skyType, boolean forceBrightLightmap, boolean constantAmbientLight) {
            super(cloudLevel, hasGround, skyType, forceBrightLightmap, constantAmbientLight);
            this.cloudLevel = cloudLevel;
            this.hasGround = hasGround;
            this.skyType = skyType;
            this.forceBrightLightmap = forceBrightLightmap;
            this.constantAmbientLight = constantAmbientLight;
        }

        @Override
        public Vec3 getBrightnessDependentFogColor(Vec3 p_108878_, float p_108879_) {
            return p_108878_;
        }

        @Override
        public boolean isFoggyAt(int p_108874_, int p_108875_) {
            return false;
        }

        @Override
        public float getCloudHeight() { return Float.NaN; }
        
        

}
