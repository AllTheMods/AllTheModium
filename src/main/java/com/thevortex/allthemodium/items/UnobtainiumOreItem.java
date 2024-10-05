package com.thevortex.allthemodium.items;

import com.thevortex.allthemodium.config.AllthemodiumServerConfigs;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSource;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.server.command.TextComponentHelper;

public class UnobtainiumOreItem extends BlockItem {

    public UnobtainiumOreItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void appendHoverText(
            @Nonnull ItemStack stack,
            @Nullable Level worldIn,
            @Nonnull List<Component> tooltip,
            @Nonnull TooltipFlag flagIn) {
        tooltip.add(
                TextComponentHelper
                        .createComponentTranslation(
                                CommandSource.NULL,
                                "unobtainium.loc",
                                new Object())
                        .withStyle(ChatFormatting.GOLD));
        if (!AllthemodiumServerConfigs.UNOBTAINIUM_QUARRYABLE.get())
            tooltip.add(
                    TextComponentHelper
                            .createComponentTranslation(
                                    CommandSource.NULL,
                                    "allthemodium.mine",
                                    new Object())
                            .withStyle(ChatFormatting.GOLD));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}
