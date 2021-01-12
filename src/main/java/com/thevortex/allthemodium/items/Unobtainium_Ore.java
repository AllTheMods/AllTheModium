package com.thevortex.allthemodium.items;

import com.thevortex.allthemodium.init.ModBlocks;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class Unobtainium_Ore extends BlockItem {

	public Unobtainium_Ore(Properties properties) {
		super(ModBlocks.UNOBTAINIUM_ORE, properties);
		
	}
	@OnlyIn(Dist.CLIENT)
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
		tooltip.add(this.getTooltip("unobtainium.loc").mergeStyle(TextFormatting.DARK_PURPLE));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	protected TextComponent getTooltip(String key){
		return new TranslationTextComponent(key);
	}
}
