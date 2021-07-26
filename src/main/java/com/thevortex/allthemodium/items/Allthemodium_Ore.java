package com.thevortex.allthemodium.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class Allthemodium_Ore extends BlockItem {

	public Allthemodium_Ore(Properties properties) {
		super(ModBlocks.ALLTHEMODIUMORE, properties);
		
	}
	@OnlyIn(Dist.CLIENT)
	@Override
	public void appendHoverText(ItemStack stack, Level worldIn, List<net.minecraft.network.chat.Component> tooltip, TooltipFlag flagIn){
		tooltip.add(this.getTooltip("allthemodium.loc").withStyle(ChatFormatting.GOLD));
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
	}
	protected TextComponent getTooltip(String key){
		return new TextComponent(key);
	}
}
