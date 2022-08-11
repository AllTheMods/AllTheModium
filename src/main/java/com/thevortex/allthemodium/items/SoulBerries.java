package com.thevortex.allthemodium.items;

import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class SoulBerries extends ItemNameBlockItem {
    public SoulBerries(Block block, Properties properties) {
        super(block, properties);
    }
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {

        if((entityLiving instanceof Player) && (stack.getItem() == ModRegistry.ANCIENT_SOULBERRY.get())) {
            Player player = (Player)entityLiving;
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION,1200,2,false,false));

        }
        return super.finishUsingItem(stack, worldIn, entityLiving);
    }

   }

