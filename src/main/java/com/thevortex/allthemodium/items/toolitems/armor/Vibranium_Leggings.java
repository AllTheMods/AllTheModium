package com.thevortex.allthemodium.items.toolitems.armor;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.List;

import com.thevortex.allthemodium.init.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Vibranium_Leggings extends ArmorItem {
	   
	public Vibranium_Leggings(ArmorMaterial materialIn, EquipmentSlot slot, Properties builder) {
		super(materialIn, slot, builder);
    
	   }
	
    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer)
    {
        return true;
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn){
        tooltip.add(this.getTooltip("piglin.friend").withStyle(ChatFormatting.GOLD));
        tooltip.add(this.getTooltip("wither.proof").withStyle(ChatFormatting.DARK_GREEN));
        tooltip.add(this.getTooltip("magic.resistance").withStyle(ChatFormatting.GREEN));
        tooltip.add(this.getTooltip("steady.guts").withStyle(ChatFormatting.GREEN));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
    protected TextComponent getTooltip(String key){
        return new TextComponent(key);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
	    if((stack.getItem() == ModItems.VIBRANIUM_LEGGINGS) && (!world.isClientSide)) {
            Collection<MobEffectInstance> potions = player.getActiveEffects();
            try {
                for (MobEffectInstance effectInstance : potions) {
                    if (effectInstance.getEffect() == MobEffects.CONFUSION)
                        player.removeEffect(MobEffects.CONFUSION);
                }
            } catch(ConcurrentModificationException exception) {

            }finally {
                super.onArmorTick(stack, world, player);
            }
        }
        super.onArmorTick(stack, world, player);
    }
}
