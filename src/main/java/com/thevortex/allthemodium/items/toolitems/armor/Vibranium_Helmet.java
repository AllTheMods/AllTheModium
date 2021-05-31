package com.thevortex.allthemodium.items.toolitems.armor;

import com.thevortex.allthemodium.init.ModItems;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class Vibranium_Helmet extends ArmorItem {

	public Vibranium_Helmet(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder);
		
	}



    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer)
    {
        return true;
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        tooltip.add(this.getTooltip("piglin.friend").withStyle(TextFormatting.GOLD));
        tooltip.add(this.getTooltip("hard.head").withStyle(TextFormatting.YELLOW));
        tooltip.add(this.getTooltip("aqua.lungs").withStyle(TextFormatting.DARK_AQUA));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
    protected TextComponent getTooltip(String key){
        return new TranslationTextComponent(key);
    }
    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if((stack.getItem() == ModItems.VIBRANIUM_HELMET) && (!world.isClientSide)) {

            if(player.isInWater() && player.isSwimming()){

                player.setAirSupply(300);
            }
        }
        super.onArmorTick(stack, world, player);
    }
}
