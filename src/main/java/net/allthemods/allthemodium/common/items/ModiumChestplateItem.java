package net.allthemods.allthemodium.common.items;

import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

import org.jspecify.annotations.Nullable;

public class ModiumChestplateItem extends Item {
    
    public ModiumChestplateItem(Properties properties) {
        super(properties
                .fireResistant()
                .rarity(Rarity.EPIC)
                .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
        );
    }
    
    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity owner, @Nullable EquipmentSlot slot) {
        if (!(owner instanceof Player player && slot == EquipmentSlot.CHEST)) return;
        player.clearFreeze(); // Clear visual freezing
    }
    
    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return true;
    }
}
