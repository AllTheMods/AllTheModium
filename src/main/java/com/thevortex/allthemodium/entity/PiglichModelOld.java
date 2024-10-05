package com.thevortex.allthemodium.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.thevortex.allthemodium.reference.Reference;
import javax.annotation.Nonnull;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Mob;

@SuppressWarnings("unused") // TODO: Determine if we will keep this model around
public class PiglichModelOld<T extends Mob> extends PlayerModel<T> {

    private final ModelPart rightEar = this.head.getChild("right_ear");
    private final ModelPart leftEar = this.head.getChild("left_ear");
    private final PartPose bodyDefault = this.body.storePose();
    private final PartPose headDefault = this.head.storePose();
    private final PartPose leftArmDefault = this.leftArm.storePose();
    private final PartPose rightArmDefault = this.rightArm.storePose();

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "piglich"),
            "main");

    public PiglichModelOld(ModelPart p_170821_, boolean p_170822_) {
        super(p_170821_, p_170822_);
    }

    public static MeshDefinition createMesh() {
        CubeDeformation cubeDeformation = CubeDeformation.NONE;
        MeshDefinition meshDefinition = PlayerModel.createMesh(
                cubeDeformation,
                false);
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.addOrReplaceChild(
                "body",
                CubeListBuilder
                        .create()
                        .texOffs(16, 16)
                        .addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, cubeDeformation),
                PartPose.ZERO);
        PartDefinition partDefinition1 = partDefinition.addOrReplaceChild(
                "head",
                CubeListBuilder
                        .create()
                        .texOffs(0, 0)
                        .addBox(-5.0F, -8.0F, -4.0F, 10.0F, 8.0F, 8.0F, cubeDeformation)
                        .texOffs(31, 1)
                        .addBox(-2.0F, -4.0F, -5.0F, 4.0F, 4.0F, 1.0F, cubeDeformation)
                        .texOffs(2, 4)
                        .addBox(2.0F, -2.0F, -5.0F, 1.0F, 2.0F, 1.0F, cubeDeformation)
                        .texOffs(2, 0)
                        .addBox(-3.0F, -2.0F, -5.0F, 1.0F, 2.0F, 1.0F, cubeDeformation),
                PartPose.ZERO);
        partDefinition1.addOrReplaceChild(
                "left_ear",
                CubeListBuilder
                        .create()
                        .texOffs(51, 6)
                        .addBox(0.0F, 0.0F, -2.0F, 1.0F, 5.0F, 4.0F, cubeDeformation),
                PartPose.offsetAndRotation(
                        4.5F,
                        -6.0F,
                        0.0F,
                        0.0F,
                        0.0F,
                        (-(float) Math.PI / 6F)));
        partDefinition1.addOrReplaceChild(
                "right_ear",
                CubeListBuilder
                        .create()
                        .texOffs(39, 6)
                        .addBox(-1.0F, 0.0F, -2.0F, 1.0F, 5.0F, 4.0F, cubeDeformation),
                PartPose.offsetAndRotation(
                        -4.5F,
                        -6.0F,
                        0.0F,
                        0.0F,
                        0.0F,
                        ((float) Math.PI / 6F)));

        partDefinition1.addOrReplaceChild(
                "hat",
                CubeListBuilder.create(),
                PartPose.ZERO);
        partDefinition1.addOrReplaceChild(
                "right_arm",
                CubeListBuilder.create(),
                PartPose.ZERO);
        partDefinition1.addOrReplaceChild(
                "left_arm",
                CubeListBuilder.create(),
                PartPose.ZERO);
        partDefinition1.addOrReplaceChild(
                "right_leg",
                CubeListBuilder.create(),
                PartPose.ZERO);
        partDefinition1.addOrReplaceChild(
                "left_leg",
                CubeListBuilder.create(),
                PartPose.ZERO);

        return meshDefinition;
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
        return super.bodyParts();
    }

    @Override
    public void renderEars(
            @Nonnull PoseStack stack,
            @Nonnull VertexConsumer consumer,
            int p_103404_,
            int p_103405_) {
        super.renderEars(stack, consumer, p_103404_, p_103405_);
    }

    @Override
    public void renderCloak(
            @Nonnull PoseStack p_103412_,
            @Nonnull VertexConsumer p_103413_,
            int p_103414_,
            int p_103415_) {
        super.renderCloak(p_103412_, p_103413_, p_103414_, p_103415_);
    }

    @Override
    public void setAllVisible(boolean p_103419_) {
        super.setAllVisible(p_103419_);
    }

    @Override
    public ModelPart getRandomModelPart(@Nonnull RandomSource p_103407_) {
        return super.getRandomModelPart(p_103407_);
    }

    public void setupAnim(
            @Nonnull T p_103366_,
            float p_103367_,
            float p_103368_,
            float p_103369_,
            float p_103370_,
            float p_103371_) {
        super.setupAnim(
                p_103366_,
                p_103367_,
                p_103368_,
                p_103369_,
                p_103370_,
                p_103371_);
    }

    protected void setupAttackAnimation(@Nonnull T p_103363_, float p_103364_) {
        super.setupAttackAnimation(p_103363_, p_103364_);
    }

    @Override
    public void prepareMobModel(
            @Nonnull T p_102861_,
            float p_102862_,
            float p_102863_,
            float p_102864_) {
        super.prepareMobModel(p_102861_, p_102862_, p_102863_, p_102864_);
        setPartVisibility();
    }

    @Override
    public void renderToBuffer(
            @Nonnull PoseStack poseStack,
            @Nonnull VertexConsumer buffer,
            int packedLight,
            int packedOverlay,
            float red,
            float green,
            float blue,
            float alpha) {
        setPartVisibility();
        super.renderToBuffer(
                poseStack,
                buffer,
                packedLight,
                packedOverlay,
                red,
                green,
                blue,
                alpha);
    }

    private void setPartVisibility() {
        head.visible = true;
        hat.visible = true;
        body.visible = true;
        rightArm.visible = true;
        leftArm.visible = true;
        rightLeg.visible = true;
        leftLeg.visible = true;
    }
}
