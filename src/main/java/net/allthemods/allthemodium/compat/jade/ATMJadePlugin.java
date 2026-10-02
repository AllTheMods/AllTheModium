package net.allthemods.allthemodium.compat.jade;

import net.minecraft.ChatFormatting;
import net.minecraft.resources.Identifier;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.client.lang.ATMLanguage;
import net.allthemods.allthemodium.common.blocks.TeleportPad;
import net.allthemods.allthemodium.core.registry.ATMItems;

import org.jspecify.annotations.NonNull;

import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.JadeIds;
import snownee.jade.api.WailaPlugin;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.harvest.ToolTier;
import snownee.jade.api.harvest.ToolTypeRegistry;

@WailaPlugin
public class ATMJadePlugin implements IWailaPlugin {
    
    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerBlockComponent(TeleportPadComponentProvider.INSTANCE, TeleportPad.class);
        registration.addHarvestPlugin(ATMJadePlugin::registerPickaxes);
    }

    private static void registerPickaxes(ToolTypeRegistry registry) {
        registry.modifyType(JadeIds.JADE("pickaxe"), type -> type
                .addTier(ToolTier.item(ATMItems.ALLTHEMODIUM_PICKAXE.get()))
                .addTier(ToolTier.item(ATMItems.VIBRANIUM_PICKAXE.get()))
                .addTier(ToolTier.item(ATMItems.UNOBTAINIUM_PICKAXE.get()))
                .addTier(ToolTier.item(ATMItems.ALLOY_PICKAXE.get()))
        );
    }
    
    enum TeleportPadComponentProvider implements IBlockComponentProvider {
        INSTANCE;
        
        private static final Identifier TELEPORT_PAD = ATM.id("teleport_pad");
        
        @Override
        public void appendTooltip(
                ITooltip tooltip,
                BlockAccessor accessor,
                @NonNull IPluginConfig config
        ) {
            tooltip.add(ATMLanguage.MESSAGE_TELEPORT_PAD_USAGE.translate(ChatFormatting.GRAY));
            tooltip.add(ATMLanguage.MESSAGE_TELEPORT_TARGET.translate(TeleportPad.display(accessor.getLevel().dimension())));
            if (accessor.getBlockState().getValue(TeleportPad.SPAWNED)) tooltip.add(ATMLanguage.MESSAGE_TELEPORT_PAD_NO_DROP.translate(ChatFormatting.RED));
        }
        
        @Override
        public @NonNull Identifier getUid() {
            return TeleportPadComponentProvider.TELEPORT_PAD;
        }
    }
}
