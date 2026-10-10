package net.allthemods.allthemodium.compat.jade;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

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

import java.util.List;

@WailaPlugin
public class ATMJadePlugin implements IWailaPlugin {
    
    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerBlockComponent(TeleportPadComponentProvider.INSTANCE, TeleportPad.class);
        registration.addHarvestPlugin(ATMJadePlugin::registerPickaxes);
    }

    private static void registerPickaxes(ToolTypeRegistry registry) {
        Identifier pickaxe = JadeIds.JADE("pickaxe");
        Identifier previous = BuiltInRegistries.ITEM.getKey(Items.NETHERITE_PICKAXE);
        for (Item item : List.of(
                ATMItems.ALLTHEMODIUM_PICKAXE.get(),
                ATMItems.VIBRANIUM_PICKAXE.get(),
                ATMItems.UNOBTAINIUM_PICKAXE.get(),
                ATMItems.ALLOY_PICKAXE.get()
        )) {
            registry.insertTierAfter(pickaxe, previous, ToolTier.item(item));
            previous = BuiltInRegistries.ITEM.getKey(item);
        }
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
