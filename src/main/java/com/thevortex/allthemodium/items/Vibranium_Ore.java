package com.thevortex.allthemodium.items;

import com.thevortex.allthemodium.init.ModBlocks;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class Vibranium_Ore extends BlockItem {

	public Vibranium_Ore(Properties properties) {
		super(ModBlocks.VIBRANIUM_ORE, properties);
		
	}
	@OnlyIn(Dist.CLIENT)
	@Override
	public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn){
		tooltip.add(this.getTooltip("vibranium.loc").withStyle(ChatFormatting.GREEN));
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
	}
	protected TextComponent getTooltip(String key){
		return new TextComponent(key);
	}
}
