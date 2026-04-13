package net.allthemods.allthemodium.common.items;

import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.Unit;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.ChargedProjectiles;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;

import net.allthemods.allthemodium.core.mixin.CrossbowItemAccessor;

public class ModiumCrossBowItem extends CrossbowItem {
    
    public ModiumCrossBowItem(Properties properties) {
        super(properties
                .rarity(Rarity.EPIC)
                .fireResistant()
                .durability(Short.MAX_VALUE)
                .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
                .component(DataComponents.CHARGED_PROJECTILES, ChargedProjectiles.EMPTY)
                .enchantable(15)
        );
    }
    
    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        ChargedProjectiles chargedProjectiles = itemStack.get(DataComponents.CHARGED_PROJECTILES);
        if (chargedProjectiles != null && !chargedProjectiles.isEmpty()) {
            this.performShooting(level, player, hand, itemStack, ModiumCrossBowItem.getShootingPower(chargedProjectiles), 1.0F, null);
            return InteractionResult.CONSUME;
        } else if (!player.getProjectile(itemStack).isEmpty()) {
            ((CrossbowItemAccessor) this).setStartSoundPlayed(false);
            ((CrossbowItemAccessor) this).setMidLoadSoundPlayed(false);
            player.startUsingItem(hand);
            return InteractionResult.CONSUME;
        } else {
            return InteractionResult.FAIL;
        }
    }
    
    private static float getShootingPower(ChargedProjectiles projectiles) {
        return projectiles.contains(Items.FIREWORK_ROCKET) ? 2.4F : 4.6F;
    }
    
    @Override
    public boolean releaseUsing(ItemStack itemStack, Level level, LivingEntity entity, int remainingTime) {
        int timeHeld = this.getUseDuration(itemStack, entity) - remainingTime;
        return ModiumCrossBowItem.getPowerForTime(timeHeld, itemStack, entity) >= 1.0F && CrossbowItem.isCharged(itemStack);
    }
    
    @Override
    @SuppressWarnings("ConstantValue")
    public void onUseTick(Level level, LivingEntity entity, ItemStack itemStack, int ticksRemaining) {
        if (level.isClientSide()) return;
        
        CrossbowItem.ChargingSounds sounds = ((CrossbowItemAccessor) this).doGetChargingSounds(itemStack);
        float tickPercent = (float) (itemStack.getUseDuration(entity) - ticksRemaining) / ModiumCrossBowItem.getChargeDuration(itemStack, entity);
        if (tickPercent < 0.2F) {
            ((CrossbowItemAccessor) this).setStartSoundPlayed(false);
            ((CrossbowItemAccessor) this).setMidLoadSoundPlayed(false);
        }
        
        if (tickPercent >= 0.2F && !((CrossbowItemAccessor) this).getStartSoundPlayed()) {
            ((CrossbowItemAccessor) this).setStartSoundPlayed(true);
            sounds.start().ifPresent(sound -> level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), sound.value(), SoundSource.PLAYERS, 0.5F, 1.0F));
        }
        
        if (tickPercent >= 0.5F && !((CrossbowItemAccessor) this).getMidLoadSoundPlayed()) {
            ((CrossbowItemAccessor) this).setStartSoundPlayed(true);
            sounds.mid().ifPresent(sound -> level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), sound.value(), SoundSource.PLAYERS, 0.5F, 1.0F));
        }
        
        if (tickPercent >= 1.0F && !CrossbowItem.isCharged(itemStack) && CrossbowItemAccessor.doTryLoadProjectiles(entity, itemStack)) {
            sounds.end().ifPresent(
                    sound -> level.playSound(
                            null,
                            entity.getX(),
                            entity.getY(),
                            entity.getZ(),
                            sound.value(),
                            entity.getSoundSource(),
                            1.0F,
                            1.0F / (level.getRandom().nextFloat() * 0.5F + 1.0F) + 0.2F
                    )
            );
        }
    }
    
    @Override
    public int getUseDuration(ItemStack itemStack, LivingEntity user) {
        return 12000;
    }
    
    private static float getPowerForTime(int timeHeld, ItemStack itemStack, LivingEntity holder) {
        float pow = (float) timeHeld / ModiumCrossBowItem.getChargeDuration(itemStack, holder);
        if (pow > 2.0F) pow = 2.0F;
        return pow;
    }
    
    public static int getChargeDuration(ItemStack crossbow, LivingEntity user) {
        float duration = EnchantmentHelper.modifyCrossbowChargingTime(crossbow, user, 1.0F);
        return Mth.floor(duration * 15.0F);
    }
}
