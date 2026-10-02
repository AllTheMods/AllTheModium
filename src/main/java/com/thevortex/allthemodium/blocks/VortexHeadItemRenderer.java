package com.thevortex.allthemodium.blocks;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.SkullModel;
import net.minecraft.client.model.SkullModelBase;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.SkullBlockRenderer;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ResolvableProfile;
import net.minecraft.world.level.block.SkullBlock;

/**
 * Vortex_Block always represents the same fixed player, so its item icon/hand/ground render ignores any
 * "SkullOwner" NBT (which /give and most acquisition paths never set anyway) and always renders theVortex.
 */
public class VortexHeadItemRenderer extends BlockEntityWithoutLevelRenderer {

	private static VortexHeadItemRenderer instance;
	private static volatile ResolvableProfile resolvedProfile = Vortex_Block.OWNER_PROFILE;

	private final EntityModelSet entityModelSet;
	private SkullModelBase playerHeadModel;

	private VortexHeadItemRenderer(BlockEntityRenderDispatcher dispatcher, EntityModelSet modelSet) {
		super(dispatcher, modelSet);
		this.entityModelSet = modelSet;
	}

	public static VortexHeadItemRenderer get() {
		if (instance == null) {
			Minecraft minecraft = Minecraft.getInstance();
			instance = new VortexHeadItemRenderer(minecraft.getBlockEntityRenderDispatcher(), minecraft.getEntityModels());
			instance.onResourceManagerReload(minecraft.getResourceManager());
		}
		return instance;
	}

	@Override
	public void onResourceManagerReload(ResourceManager resourceManager) {
		super.onResourceManagerReload(resourceManager);
		this.playerHeadModel = new SkullModel(this.entityModelSet.bakeLayer(ModelLayers.PLAYER_HEAD));
	}

	@Override
	public void renderByItem(ItemStack stack, ItemDisplayContext displayContext, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay) {
		if (!resolvedProfile.isResolved()) {
			resolvedProfile.resolve().thenAccept(profile -> resolvedProfile = profile);
		}

		RenderType renderType = SkullBlockRenderer.getRenderType(SkullBlock.Types.PLAYER, resolvedProfile);
		SkullBlockRenderer.renderSkull(null, 180.0F, 0.0F, poseStack, buffer, light, this.playerHeadModel, renderType);
	}

}
