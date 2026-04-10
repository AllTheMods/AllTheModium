package net.allthemods.allthemodium.common.items;

import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Unit;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

import org.jspecify.annotations.Nullable;

public class ModiumHelmetItem extends Item {
    
    public ModiumHelmetItem(Properties properties) {
        super(properties
                .fireResistant()
                .rarity(Rarity.EPIC)
                .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
        );
    }
    
    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity owner, @Nullable EquipmentSlot slot) {
        if (!(owner instanceof Player player && slot == EquipmentSlot.HEAD)) return;
        player.setAirSupply(player.getMaxAirSupply());
        if (player.tickCount % 20 == 0) {
            if (player.hasEffect(MobEffects.BLINDNESS)) player.removeEffect(MobEffects.BLINDNESS);
            if (player.hasEffect(MobEffects.DARKNESS)) player.removeEffect(MobEffects.DARKNESS);
        }
    }
    
    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return true;
    }
}
