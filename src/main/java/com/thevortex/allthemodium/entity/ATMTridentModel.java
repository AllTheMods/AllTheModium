package com.thevortex.allthemodium.entity;

import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.client.model.TridentModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;

public class ATMTridentModel extends TridentModel {

   public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID,"textures/entity/alloy_trident.png");
   private final ModelPart root;

    public ATMTridentModel(ModelPart p_171016_) {
        super(p_171016_);
        this.root = p_171016_;
    }

}
