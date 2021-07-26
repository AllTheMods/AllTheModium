package com.thevortex.allthemodium.items;


import com.thevortex.allthemodium.registry.ModRegistry;
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

public class Unobtainium_Ore extends BlockItem {

	public Unobtainium_Ore(Properties properties) {
		super(ModRegistry.UNOBTAINIUM_ORE.get(), properties);
		
	}
	@OnlyIn(Dist.CLIENT)
	@Override
	public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn){
		tooltip.add(this.getTooltip("unobtainium.loc").withStyle(ChatFormatting.DARK_PURPLE));
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
	}
	protected TextComponent getTooltip(String key){
		return new TextComponent(key);
	}
}
