package com.thevortex.allthemodium.items;


import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class TeleportPad extends BlockItem {

    public TeleportPad(Block blockIn, Properties builder) {
        super(blockIn, builder);
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn){
        tooltip.add(this.getTooltip("teleport.pad").withStyle(ChatFormatting.GOLD));
        tooltip.add(this.getTooltip("how.to.teleport").withStyle(ChatFormatting.DARK_AQUA));

        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
    protected TextComponent getTooltip(String key){
        return new TextComponent(key);
    }
}
