package com.thevortex.allthemodium.items;

import com.thevortex.allthemodium.registry.ModRegistry;
import javax.annotation.Nonnull;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class SoulBerries extends ItemNameBlockItem {

    public SoulBerries(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public ItemStack finishUsingItem(
            @Nonnull ItemStack stack,
            @Nonnull Level worldIn,
            @Nonnull LivingEntity entityLiving) {
        if ((entityLiving instanceof Player) &&
                (stack.getItem() == ModRegistry.ANCIENT_SOULBERRY.get())) {
            Player player = (Player) entityLiving;
            player.addEffect(
                    new MobEffectInstance(
                            MobEffects.NIGHT_VISION,
                            1200,
                            2,
                            false,
                            false));
        }
        return super.finishUsingItem(stack, worldIn, entityLiving);
    }
}
