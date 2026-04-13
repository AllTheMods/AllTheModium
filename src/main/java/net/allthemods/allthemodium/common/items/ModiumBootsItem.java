package net.allthemods.allthemodium.common.items;

import net.minecraft.core.component.DataComponents;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class ModiumBootsItem extends Item {
    
    public ModiumBootsItem(Properties properties) {
        super(properties
                .fireResistant()
                .rarity(Rarity.EPIC)
                .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
        );
    }
    
    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return true;
    }
    
    @Override
    public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer) {
        return true;
    }
}
