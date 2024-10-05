package com.thevortex.allthemodium.items.toolitems.armor.models;

// Made with Blockbench 4.0.0-beta.0

// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.thevortex.allthemodium.reference.Reference;
import javax.annotation.Nonnull;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;

public class AllthemodiumHelmetModel<T extends LivingEntity>
        extends HumanoidModel<T> {

    // This layer location should be baked with EntityRendererProvider.Context in
    // the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "allthemodium_armor"),
            "main");
    protected final EquipmentSlot slot;

    public AllthemodiumHelmetModel(ModelPart root, EquipmentSlot slot) {
        super(root);
        this.slot = slot;
    }

    @SuppressWarnings("unused")
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition head = partDefinition.addOrReplaceChild(
                "head",
                CubeListBuilder
                        .create()
                        .texOffs(0, 0)
                        .addBox(
                                -4.0F,
                                -8.5F,
                                -4.0F,
                                8.0F,
                                8.0F,
                                8.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition horn_r_1_r1 = head.addOrReplaceChild(
                "horn_r_1_r1",
                CubeListBuilder
                        .create()
                        .texOffs(0, 2)
                        .addBox(
                                -1.0F,
                                -3.0F,
                                1.0F,
                                1.0F,
                                1.0F,
                                1.0F,
                                new CubeDeformation(0.0F))
                        .texOffs(2, 2)
                        .addBox(
                                -1.0F,
                                -3.0F,
                                -1.0F,
                                1.0F,
                                4.0F,
                                2.0F,
                                new CubeDeformation(0.0F))
                        .texOffs(28, 2)
                        .addBox(
                                8.0F,
                                -3.0F,
                                1.0F,
                                1.0F,
                                1.0F,
                                1.0F,
                                new CubeDeformation(0.0F))
                        .texOffs(24, 2)
                        .addBox(
                                8.0F,
                                -3.0F,
                                -1.0F,
                                1.0F,
                                4.0F,
                                2.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-4.0F, -6.0F, -3.0F, 0.7854F, 0.0F, 0.0F));

        partDefinition.addOrReplaceChild(
                "hat",
                CubeListBuilder.create(),
                PartPose.ZERO);
        partDefinition.addOrReplaceChild(
                "body",
                CubeListBuilder.create(),
                PartPose.ZERO);
        partDefinition.addOrReplaceChild(
                "right_arm",
                CubeListBuilder.create(),
                PartPose.ZERO);
        partDefinition.addOrReplaceChild(
                "left_arm",
                CubeListBuilder.create(),
                PartPose.ZERO);
        partDefinition.addOrReplaceChild(
                "right_leg",
                CubeListBuilder.create(),
                PartPose.ZERO);
        partDefinition.addOrReplaceChild(
                "left_leg",
                CubeListBuilder.create(),
                PartPose.ZERO);

        return LayerDefinition.create(meshDefinition, 64, 32);
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
        setPartVisibility(slot);
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

    private void setPartVisibility(EquipmentSlot slot) {
        setAllVisible(false);
        switch (slot) {
            case HEAD:
                head.visible = true;
                hat.visible = true;
                break;
            case CHEST:
                body.visible = true;
                rightArm.visible = true;
                leftArm.visible = true;
                break;
            case LEGS:
                body.visible = true;
                rightLeg.visible = true;
                leftLeg.visible = true;
                break;
            case FEET:
                rightLeg.visible = true;
                leftLeg.visible = true;
            case MAINHAND:
            case OFFHAND:
                break;
        }
    }
}
