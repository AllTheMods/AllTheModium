package com.thevortex.allthemodium.items;

import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class Allthemodium_Ore_Item extends BlockItem {

	public Allthemodium_Ore_Item(Block block, Properties properties) {
		super(block, properties);
		
	}
	@OnlyIn(Dist.CLIENT)
	@Override
	public void appendHoverText(ItemStack stack, Level worldIn, List<net.minecraft.network.chat.Component> tooltip, TooltipFlag flagIn){
		tooltip.add(this.getTooltip("allthemodium.loc").withStyle(ChatFormatting.GOLD));
		tooltip.add(this.getTooltip("allthemodium.mine").withStyle(ChatFormatting.RED));
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
	}
	protected TranslatableComponent getTooltip(String key){
		return new TranslatableComponent(key);
	}
}
