package com.thevortex.allthemodium.items.toolitems.armor;

import com.thevortex.allthemodium.init.ModItems;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class Unobtainium_Chestplate extends ArmorItem {

	public Unobtainium_Chestplate(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
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
        //tooltip.add(this.getTooltip("breath.proof").mergeStyle(TextFormatting.GOLD));
        tooltip.add(this.getTooltip("piglin.friend").withStyle(TextFormatting.GOLD));
        tooltip.add(this.getTooltip("fire.proof").withStyle(TextFormatting.RED));

        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
    protected TextComponent getTooltip(String key){
        return new TranslationTextComponent(key);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if((stack.getItem() == ModItems.UNOBTAINIUM_CHESTPLATE) && (!world.isClientSide)) {

        }
        super.onArmorTick(stack, world, player);
    }
}