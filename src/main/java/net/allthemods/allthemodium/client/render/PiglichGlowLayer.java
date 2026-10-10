package net.allthemods.allthemodium.client.render;

import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.common.entity.PiglichEntity;

import com.geckolib.constant.DataTickets;
import com.geckolib.constant.dataticket.DataTicket;
import com.geckolib.renderer.base.GeoRenderer;
import com.geckolib.renderer.base.RenderPassInfo;
import com.geckolib.renderer.layer.builtin.TextureLayerGeoLayer;

import org.jspecify.annotations.Nullable;

public class PiglichGlowLayer extends TextureLayerGeoLayer<PiglichEntity, Void, LivingEntityRenderState> {
    private static final Identifier TEXTURE = ATM.id("textures/entity/piglich_glow.png");
    private static final DataTicket<Boolean> SUMMONING = DataTicket.create("allthemodium_piglich_summoning", Boolean.class);
    private static final int COLOR = 0xFFFFA500;

    private final RenderType renderType = RenderTypes.energySwirl(PiglichGlowLayer.TEXTURE, 0.0F, 0.0F);

    public PiglichGlowLayer(GeoRenderer<PiglichEntity, Void, LivingEntityRenderState> renderer) {
        super(renderer, PiglichGlowLayer.TEXTURE);
    }

    @Override
    protected RenderType getRenderType(LivingEntityRenderState renderState) {
        return this.renderType;
    }

    @Override
    public void addRenderData(PiglichEntity piglich, @Nullable Void relatedObject, LivingEntityRenderState renderState, float partialTick) {
        renderState.addGeckolibData(PiglichGlowLayer.SUMMONING, piglich.isSummoning());
    }

    @Override
    public void submitRenderTask(RenderPassInfo<LivingEntityRenderState> renderPassInfo, SubmitNodeCollector renderTasks) {
        LivingEntityRenderState renderState = renderPassInfo.renderState();
        if (!Boolean.TRUE.equals(renderState.getGeckolibData(PiglichGlowLayer.SUMMONING))) return;

        int color = renderPassInfo.renderColor();
        renderState.addGeckolibData(DataTickets.RENDER_COLOR, PiglichGlowLayer.COLOR);
        super.submitRenderTask(renderPassInfo, renderTasks);
        renderState.addGeckolibData(DataTickets.RENDER_COLOR, color);
    }
}
