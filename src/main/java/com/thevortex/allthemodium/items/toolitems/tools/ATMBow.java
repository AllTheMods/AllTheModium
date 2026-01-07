package com.thevortex.allthemodium.items.toolitems.tools;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ATMBow extends BowItem {

    public ATMBow(Properties p_40660_) {

        super(p_40660_.rarity(Rarity.EPIC));
        //TODO Auto-generated constructor stub
    }
    
    @Override
        public int getUseDuration(ItemStack p_40680_, LivingEntity p_345962_) {
        return 12000;
    }

    @Override
        public int getDefaultProjectileRange() {
        return 60;
    }
    @Override
        public int getEnchantmentValue() {
        return 85;
    }
    
     @Override
    public UseAnim getUseAnimation(ItemStack p_40678_) {
        return UseAnim.BOW;
    }

     @Override
    protected void shootProjectile(
        LivingEntity p_331372_, Projectile p_332000_, int p_330631_, float p_331251_, float p_331199_, float p_330857_, @Nullable LivingEntity p_331572_
    ) {
        p_332000_.shootFromRotation(p_331372_, p_331372_.getXRot(), p_331372_.getYRot() + p_330857_, 0.0F, p_331251_, p_331199_);
    }

    @Override
    protected void shoot(
        ServerLevel p_346125_,
        LivingEntity p_330728_,
        InteractionHand p_331152_,
        ItemStack p_330646_,
        List<ItemStack> p_331726_,
        float p_331007_,
        float p_331445_,
        boolean p_331107_,
        @Nullable LivingEntity p_331167_
    ) {
        float f = EnchantmentHelper.processProjectileSpread(p_346125_, p_330646_, p_330728_, 0.0F);
        float f1 = p_331726_.size() == 1 ? 0.0F : 2.0F * f / (float)(p_331726_.size() - 1);
        float f2 = (float)((p_331726_.size() - 1) % 2) * f1 / 2.0F;
        float f3 = 1.0F;

        for (int i = 0; i < p_331726_.size(); i++) {
            ItemStack itemstack = p_331726_.get(i);
            if (!itemstack.isEmpty()) {
                float f4 = f2 + f3 * (float)((i + 1) / 2) * f1;
                f3 = -f3;
                Projectile projectile = this.createProjectile(p_346125_, p_330728_, p_330646_, itemstack, p_331107_);
                this.shootProjectile(p_330728_, projectile, i, p_331007_, p_331445_, f4, p_331167_);
                p_346125_.addFreshEntity(projectile);
                p_330646_.hurtAndBreak(this.getDurabilityUse(itemstack), p_330728_, LivingEntity.getSlotForHand(p_331152_));
                if (p_330646_.isEmpty()) {
                    break;
                }
            }
        }
    }
}