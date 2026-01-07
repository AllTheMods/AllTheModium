package com.thevortex.allthemodium.items.toolitems.tools;

import com.thevortex.allthemodium.entity.ThrownATMTrident;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow.Pickup;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.List;


public class ATMTrident extends TridentItem implements ProjectileItem {

   private Object renderProperties;
    public ATMTrident(Properties p_43381_) {
        super(p_43381_);
        
    }

    public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 75.0, Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, -2.9000000953674316, Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
     }
  
     public static Tool createToolProperties() {
        return new Tool(List.of(), 1.0F, 2);
     }
     @Override
     public void releaseUsing(ItemStack trident, Level level, LivingEntity thrower, int power) {
      if (thrower instanceof Player player) {
         int i = this.getUseDuration(trident, thrower) - power;
         if (i >= 10) {
            float f = EnchantmentHelper.getTridentSpinAttackStrength(trident, player);
            if ((!(f > 0.0F) || player.isInWaterOrRain())) {
               Holder<SoundEvent> holder = (Holder)EnchantmentHelper.pickHighestLevel(trident, EnchantmentEffectComponents.TRIDENT_SOUND).orElse(SoundEvents.TRIDENT_THROW);
               if (!level.isClientSide) {
                  trident.hurtAndBreak(1, player, LivingEntity.getSlotForHand(thrower.getUsedItemHand()));
                  if (f == 0.0F) {
                     ThrownATMTrident throwntrident = new ThrownATMTrident(level, player, trident);
                     throwntrident.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F, 1.0F);
                     if (player.hasInfiniteMaterials()) {
                        throwntrident.pickup = Pickup.CREATIVE_ONLY;
                     }

                     level.addFreshEntity(throwntrident);
                     level.playSound((Player)null, throwntrident, (SoundEvent)holder.value(), SoundSource.PLAYERS, 1.0F, 1.0F);
                     if (!player.hasInfiniteMaterials()) {
                        player.getInventory().removeItem(trident);
                     }
                  }
               }

               player.awardStat(Stats.ITEM_USED.get(this));
               if (f > 0.0F) {
                  float f7 = player.getYRot();
                  float f1 = player.getXRot();
                  float f2 = -Mth.sin(f7 * 0.017453292F) * Mth.cos(f1 * 0.017453292F);
                  float f3 = -Mth.sin(f1 * 0.017453292F);
                  float f4 = Mth.cos(f7 * 0.017453292F) * Mth.cos(f1 * 0.017453292F);
                  float f5 = Mth.sqrt(f2 * f2 + f3 * f3 + f4 * f4);
                  f2 *= f / f5;
                  f3 *= f / f5;
                  f4 *= f / f5;
                  player.push((double)f2, (double)f3, (double)f4);
                  player.startAutoSpinAttack(20, 8.0F, trident);
                  if (player.onGround()) {
                     float f6 = 1.1999999F;
                     player.move(MoverType.SELF, new Vec3(0.0, 1.1999999284744263, 0.0));
                  }

                  level.playSound((Player)null, player, (SoundEvent)holder.value(), SoundSource.PLAYERS, 1.0F, 1.0F);
               }
            }
         }
      }

   }
   @Override
   public InteractionResultHolder<ItemStack> use(Level p_43405_, Player p_43406_, InteractionHand p_43407_) {
      ItemStack itemstack = p_43406_.getItemInHand(p_43407_);
      if (EnchantmentHelper.getTridentSpinAttackStrength(itemstack, p_43406_) > 0.0F && !p_43406_.isInWaterOrRain()) {
         return InteractionResultHolder.fail(itemstack);
      } else {
         p_43406_.startUsingItem(p_43407_);
         return InteractionResultHolder.consume(itemstack);
      }
   }
  

}
