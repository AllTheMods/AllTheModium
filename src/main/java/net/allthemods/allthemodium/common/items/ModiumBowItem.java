package net.allthemods.allthemodium.common.items;

import net.neoforged.neoforge.event.EventHooks;

import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

import java.util.List;

public class ModiumBowItem extends BowItem {
    
    public ModiumBowItem(Properties properties) {
        super(properties
                .rarity(Rarity.EPIC)
                .fireResistant()
                .durability(Short.MAX_VALUE)
                .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
                .enchantable(10)
        );
    }
    
    @Override
    public int getDefaultProjectileRange() {
        return 85;
    }
    
    @Override
    public boolean releaseUsing(ItemStack itemStack, Level level, LivingEntity entity, int remainingTime) {
        if (!(entity instanceof Player player)) return false;
        
        ItemStack projectile = player.getProjectile(itemStack);
        if (projectile.isEmpty()) return false;
        
        int timeHeld = this.getUseDuration(itemStack, entity) - remainingTime;
        timeHeld = EventHooks.onArrowLoose(itemStack, level, player, timeHeld, !projectile.isEmpty());
        if (timeHeld < 0) return false;
        float pow = ModiumBowItem.getPowerForTime(timeHeld);
        if (pow < 0.1) return false;
        
        List<ItemStack> firedProjectiles = ProjectileWeaponItem.draw(itemStack, projectile, player);
        if (level instanceof ServerLevel serverLevel && !firedProjectiles.isEmpty()) {
            this.shoot(serverLevel, player, player.getUsedItemHand(), itemStack, firedProjectiles, pow * 5.0F, 1.0F, pow == 1.0F, null);
        }
        
        level.playSound(
                null,
                player.getX(),
                player.getY(),
                player.getZ(),
                SoundEvents.ARROW_SHOOT,
                SoundSource.PLAYERS,
                1.0F,
                1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + pow * 0.4F
        );
        player.awardStat(Stats.ITEM_USED.get(this));
        return true;
    }
    
    @Override
    public int getUseDuration(ItemStack itemStack, LivingEntity user) {
        return 36000;
    }
    
    public static float getPowerForTime(int timeHeld) {
        float pow = timeHeld / 20.0F;
        pow = (pow * pow + pow * 2.0F) / 3.0F;
        if (pow > 2.0F) pow = 2.0F;
        return pow;
    }
}
