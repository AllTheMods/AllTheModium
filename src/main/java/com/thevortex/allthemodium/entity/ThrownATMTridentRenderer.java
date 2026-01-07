package com.thevortex.allthemodium.entity;

import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class ThrownATMTridentRenderer extends EntityRenderer<ThrownATMTrident> {
public static final ResourceLocation TRIDENT_LOCATION = ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "textures/entity/alloy_trident.png");
private final ATMTridentModel model;
    public ThrownATMTridentRenderer(Context context) {
        super(context);
        this.model = new ATMTridentModel(context.bakeLayer(alloy_trident.LAYER_LOCATION));

    }
    @Override
    public ResourceLocation getTextureLocation(ThrownATMTrident arg0) {
        // TODO Auto-generated method stub
        return TRIDENT_LOCATION;
    }

}
