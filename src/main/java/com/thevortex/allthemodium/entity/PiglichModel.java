package com.thevortex.allthemodium.entity;

import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PiglichModel extends AnimatedGeoModel<PiglichEntity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "piglich"),
            "main");

    public PiglichModel() {
    }

    @SuppressWarnings("unused")
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition head = partDefinition.addOrReplaceChild(
                "head",
                CubeListBuilder
                        .create()
                        .texOffs(84, 0)
                        .addBox(
                                -5.0F,
                                -14.0F,
                                -4.0F,
                                10.0F,
                                8.0F,
                                8.0F,
                                new CubeDeformation(0.5F))
                        .texOffs(48, 0)
                        .addBox(
                                -5.1F,
                                -8.0F,
                                -4.0F,
                                10.0F,
                                8.0F,
                                8.0F,
                                new CubeDeformation(0.35F))
                        .texOffs(0, 0)
                        .addBox(
                                -5.0F,
                                -8.0F,
                                -4.0F,
                                10.0F,
                                8.0F,
                                8.0F,
                                new CubeDeformation(0.0F))
                        .texOffs(29, 1)
                        .addBox(
                                -2.0F,
                                -4.0F,
                                -5.0F,
                                4.0F,
                                4.0F,
                                1.0F,
                                new CubeDeformation(0.0F))
                        .texOffs(2, 0)
                        .addBox(
                                -3.0F,
                                -2.0F,
                                -5.0F,
                                1.0F,
                                2.0F,
                                1.0F,
                                new CubeDeformation(0.0F))
                        .texOffs(2, 4)
                        .addBox(
                                2.0F,
                                -2.0F,
                                -5.0F,
                                1.0F,
                                2.0F,
                                1.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -4.0F, -3.0F));

        PartDefinition rightEar_r1 = head.addOrReplaceChild(
                "rightEar_r1",
                CubeListBuilder
                        .create()
                        .texOffs(104, 18)
                        .addBox(
                                -1.0F,
                                0.0F,
                                -2.0F,
                                1.0F,
                                5.0F,
                                4.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-5.0F, -6.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition leftEar_r1 = head.addOrReplaceChild(
                "leftEar_r1",
                CubeListBuilder
                        .create()
                        .texOffs(115, 18)
                        .addBox(
                                0.0F,
                                0.0F,
                                -2.0F,
                                1.0F,
                                5.0F,
                                4.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(5.0F, -6.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition leftHornTop_r1 = head.addOrReplaceChild(
                "leftHornTop_r1",
                CubeListBuilder
                        .create()
                        .texOffs(88, 0)
                        .addBox(
                                0.0F,
                                -4.0F,
                                0.0F,
                                1.0F,
                                4.0F,
                                1.0F,
                                new CubeDeformation(0.3F)),
                PartPose.offsetAndRotation(6.0F, -9.0F, 1.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition leftHorn_r1 = head.addOrReplaceChild(
                "leftHorn_r1",
                CubeListBuilder
                        .create()
                        .texOffs(76, 0)
                        .addBox(
                                -1.0F,
                                -4.0F,
                                -1.0F,
                                3.0F,
                                5.0F,
                                3.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(4.0F, -7.0F, 1.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition rightHorn_r1 = head.addOrReplaceChild(
                "rightHorn_r1",
                CubeListBuilder
                        .create()
                        .texOffs(44, 0)
                        .addBox(
                                -2.0F,
                                -4.0F,
                                -1.0F,
                                3.0F,
                                5.0F,
                                3.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-4.0F, -7.0F, 1.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition rightHornTop_r1 = head.addOrReplaceChild(
                "rightHornTop_r1",
                CubeListBuilder
                        .create()
                        .texOffs(40, 0)
                        .addBox(
                                -1.0F,
                                -4.0F,
                                0.0F,
                                1.0F,
                                4.0F,
                                1.0F,
                                new CubeDeformation(0.3F)),
                PartPose.offsetAndRotation(-6.0F, -9.0F, 1.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition body = partDefinition.addOrReplaceChild(
                "body",
                CubeListBuilder
                        .create()
                        .texOffs(81, 38)
                        .addBox(
                                -5.0F,
                                -7.0F,
                                -3.0F,
                                10.0F,
                                10.0F,
                                6.0F,
                                new CubeDeformation(0.2F))
                        .texOffs(33, 35)
                        .addBox(
                                -3.0F,
                                -7.0F,
                                -2.0F,
                                6.0F,
                                7.0F,
                                5.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 10.0F, 2.0F));

        PartDefinition bodyTop = body.addOrReplaceChild(
                "bodyTop",
                CubeListBuilder
                        .create()
                        .texOffs(48, 46)
                        .addBox(
                                -6.0F,
                                -10.0F,
                                -4.0F,
                                12.0F,
                                10.0F,
                                8.0F,
                                new CubeDeformation(0.5F))
                        .texOffs(0, 40)
                        .addBox(
                                -6.0F,
                                -10.0F,
                                -4.0F,
                                12.0F,
                                10.0F,
                                8.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

        PartDefinition leftArm = bodyTop.addOrReplaceChild(
                "leftArm",
                CubeListBuilder
                        .create()
                        .texOffs(84, 16)
                        .addBox(
                                -2.0F,
                                -2.0F,
                                -3.0F,
                                4.0F,
                                15.0F,
                                6.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-8.0F, -8.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

        PartDefinition rightArm = bodyTop.addOrReplaceChild(
                "rightArm",
                CubeListBuilder
                        .create()
                        .texOffs(64, 16)
                        .addBox(
                                -2.0F,
                                -2.0F,
                                -3.0F,
                                4.0F,
                                15.0F,
                                6.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(8.0F, -8.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

        PartDefinition leftLeg = partDefinition.addOrReplaceChild(
                "leftLeg",
                CubeListBuilder
                        .create()
                        .texOffs(48, 16)
                        .addBox(
                                -2.0F,
                                -2.0F,
                                -2.0F,
                                4.0F,
                                8.0F,
                                4.0F,
                                new CubeDeformation(0.5F))
                        .texOffs(32, 16)
                        .addBox(
                                -2.0F,
                                -2.0F,
                                -2.0F,
                                4.0F,
                                8.0F,
                                4.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(
                        -2.0F,
                        12.0F,
                        1.0F,
                        -0.6109F,
                        0.6109F,
                        0.0F));

        PartDefinition leftLegDown = leftLeg.addOrReplaceChild(
                "leftLegDown",
                CubeListBuilder
                        .create()
                        .texOffs(16, 28)
                        .addBox(
                                -2.0F,
                                0.0F,
                                -2.0F,
                                4.0F,
                                8.0F,
                                4.0F,
                                new CubeDeformation(-0.1F)),
                PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.6109F, 0.0F, 0.0F));

        PartDefinition rightLeg = partDefinition.addOrReplaceChild(
                "rightLeg",
                CubeListBuilder
                        .create()
                        .texOffs(16, 16)
                        .addBox(
                                -2.0F,
                                -2.0F,
                                -2.0F,
                                4.0F,
                                8.0F,
                                4.0F,
                                new CubeDeformation(0.5F))
                        .texOffs(0, 16)
                        .addBox(
                                -2.0F,
                                -2.0F,
                                -2.0F,
                                4.0F,
                                8.0F,
                                4.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(
                        2.0F,
                        12.0F,
                        1.0F,
                        -0.6109F,
                        -0.6109F,
                        0.0F));

        PartDefinition rightLegDown = rightLeg.addOrReplaceChild(
                "rightLegDown",
                CubeListBuilder
                        .create()
                        .texOffs(0, 28)
                        .addBox(
                                -2.0F,
                                0.0F,
                                -2.0F,
                                4.0F,
                                8.0F,
                                4.0F,
                                new CubeDeformation(-0.1F)),
                PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.6109F, 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 128, 64);
    }

    @Override
    public ResourceLocation getModelResource(PiglichEntity piglichEntity) {
        return new ResourceLocation(
                Reference.MOD_ID,
                "geo/piglich_anim.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PiglichEntity piglichEntity) {
        return new ResourceLocation(
                Reference.MOD_ID,
                "textures/entity/piglich.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PiglichEntity piglichEntity) {
        return new ResourceLocation(
                Reference.MOD_ID,
                "animations/piglich.animation.json");
    }
}
