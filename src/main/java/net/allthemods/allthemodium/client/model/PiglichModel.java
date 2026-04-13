package net.allthemods.allthemodium.client.model;

import net.minecraft.resources.Identifier;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.common.entity.PiglichEntity;

import com.geckolib.model.GeoModel;
import com.geckolib.renderer.base.GeoRenderState;

public class PiglichModel extends GeoModel<PiglichEntity> {
    private static final Identifier MODEL = ATM.id("piglich_anim");
    private static final Identifier TEXTURE = ATM.id("textures/entity/piglich.png");
    private static final Identifier ANIMATIONS = ATM.id("piglich");
    
    @Override
    public Identifier getModelResource(GeoRenderState renderState) {
        return PiglichModel.MODEL;
    }
    
    @Override
    public Identifier getTextureResource(GeoRenderState renderState) {
        return PiglichModel.TEXTURE;
    }
    
    @Override
    public Identifier getAnimationResource(PiglichEntity piglich) {
        return PiglichModel.ANIMATIONS;
    }
}
