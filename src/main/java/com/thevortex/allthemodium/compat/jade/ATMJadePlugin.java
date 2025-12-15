package com.thevortex.allthemodium.compat.jade;

import com.thevortex.allthemodium.reference.TweakProxy;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

import com.thevortex.allthemodium.blocks.TeleportPad;
import com.thevortex.allthemodium.reference.Reference;

import org.jetbrains.annotations.Nullable;

import snownee.jade.addon.harvest.HarvestToolProvider;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;
import snownee.jade.api.config.IPluginConfig;

@WailaPlugin
public class ATMJadePlugin implements IWailaPlugin {

    private static final ResourceLocation TELEPORT_PAD = ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "teleport_pad");

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerBlockComponent(TeleportPadComponentProvider.INSTANCE, TeleportPad.class);
    }

    enum TeleportPadComponentProvider implements IBlockComponentProvider {
        INSTANCE;

        @Override
        public void appendTooltip(
                ITooltip tooltip,
                BlockAccessor accessor,
                IPluginConfig config
        ) {
            tooltip.add(Component.translatable(String.format("jade.%s.teleport_pad.tip", Reference.MOD_ID)));
            tooltip.add(getTranslation(TeleportPad.getPartner(accessor.getLevel().dimension(), TeleportPad.isLoaded() ? TweakProxy.packMode() : 0)));
            if(accessor.getBlockState().getValue(TeleportPad.SPAWNED))
                tooltip.add(Component.translatable(String.format("jade.%s.teleport_pad.no_drop", Reference.MOD_ID)).withStyle(ChatFormatting.RED));
        }

        @Override
        public ResourceLocation getUid() {
            return ATMJadePlugin.TELEPORT_PAD;
        }
    }

    private static Component getTranslation(@Nullable ResourceKey<Level> dimension) {
        Component target = dimension == null ?
                Component.translatable(String.format("dimension.%s.unknown", Reference.MOD_ID)).withStyle(ChatFormatting.RED) :
                Component.translatable(String.join(".",
                        dimension.registry().getPath(),
                        dimension.location().getNamespace(),
                        dimension.location().getPath())
                ).withStyle(ChatFormatting.GRAY);
        return Component.translatable(String.format("jade.%s.teleport_pad.transports_to", Reference.MOD_ID)).withStyle(ChatFormatting.GRAY)
                .append(Component.literal(": ")).withStyle(ChatFormatting.GRAY)
                .append(target);
    }

    public static void registerPickaxes(){
        var handler = HarvestToolProvider.TOOL_HANDLERS.get(ResourceLocation.fromNamespaceAndPath("jade","pickaxe"));
        var tools = handler.getTools();
        tools.add(ModRegistry.ATM_PICKAXE.get().getDefaultInstance());
        tools.add(ModRegistry.VIB_PICKAXE.get().getDefaultInstance());
        tools.add(ModRegistry.UNO_PICKAXE.get().getDefaultInstance());
        tools.add(ModRegistry.ALLOY_PICKAXE.get().getDefaultInstance());
    }
}
