package com.thevortex.allthemodium.items.toolitems.tools;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSource;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.server.command.TextComponentHelper;

public class AlloySword extends SwordItem {

    public AlloySword(
            Tier tier,
            int damage,
            float speed,
            Properties properties) {
        super(tier, damage, speed, properties);
    }

    @Override
    public boolean isEnchantable(@Nonnull ItemStack stack) {
        return true;
    }

    @Override
    public boolean canBeDepleted() {
        return false;
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
                                "indestructible",
                                new Object())
                        .withStyle(ChatFormatting.GOLD));

        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    protected TranslatableContents getTooltip(String key) {
        return new TranslatableContents(key);
    }
}
