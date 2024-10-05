package com.thevortex.allthemodium.items;

import com.thevortex.allthemodium.registry.ModRegistry;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AllthemodiumApple extends Item {

    public AllthemodiumApple(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(
            @Nonnull ItemStack stack,
            @Nonnull Level worldIn,
            @Nonnull LivingEntity entityLiving) {
        if ((entityLiving instanceof Player) &&
                (stack.getItem() == ModRegistry.ALLTHEMODIUM_APPLE.get())) {
            Player player = (Player) entityLiving;
            player.addEffect(
                    new MobEffectInstance(
                            MobEffects.REGENERATION,
                            600,
                            1,
                            false,
                            false));
            player.addEffect(
                    new MobEffectInstance(
                            MobEffects.ABSORPTION,
                            600,
                            1,
                            false,
                            false));
        }
        return super.finishUsingItem(stack, worldIn, entityLiving);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(
            @Nonnull ItemStack stack,
            @Nullable Level worldIn,
            @Nonnull List<Component> tooltip,
            @Nonnull TooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}
