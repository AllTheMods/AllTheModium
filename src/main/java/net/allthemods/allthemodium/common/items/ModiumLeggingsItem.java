package net.allthemods.allthemodium.common.items;

import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Unit;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

import org.jspecify.annotations.Nullable;

public class ModiumLeggingsItem extends Item {
    
    public ModiumLeggingsItem(Properties properties) {
        super(properties
                .fireResistant()
                .rarity(Rarity.EPIC)
                .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
        );
    }
    
    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity owner, @Nullable EquipmentSlot slot) {
        if (!(owner instanceof ServerPlayer player && slot == EquipmentSlot.LEGS && player.tickCount % 20 == 0)) return;
        if (player.hasEffect(MobEffects.WITHER)) player.removeEffect(MobEffects.WITHER);
        if (player.hasEffect(MobEffects.POISON)) player.removeEffect(MobEffects.POISON);
        if (player.isInWater()) player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 100, 0));
    }
    
    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return true;
    }
}
