package net.allthemods.allthemodium.common.items;

import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.component.BlocksAttacks;
import net.minecraft.world.item.component.UseEffects;

import java.util.List;
import java.util.Optional;

public class ModiumShieldItem extends ShieldItem {
    
    private static final UseEffects USE_EFFECTS = new UseEffects(false, false, 0.8F);
    
    public ModiumShieldItem(Properties properties) {
        super(properties
                .rarity(Rarity.EPIC)
                .fireResistant()
                .durability(Short.MAX_VALUE)
                .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
                .equippableUnswappable(EquipmentSlot.OFFHAND)
                .component(DataComponents.USE_EFFECTS, ModiumShieldItem.USE_EFFECTS)
                .delayedComponent(
                        DataComponents.BLOCKS_ATTACKS,
                        context -> new BlocksAttacks(
                                0.15F,
                                0.5F,
                                List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 0.8F)),
                                new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 0.5F),
                                Optional.of(context.getOrThrow(DamageTypeTags.BYPASSES_SHIELD)),
                                Optional.of(SoundEvents.SHIELD_BLOCK),
                                Optional.of(SoundEvents.SHIELD_BREAK)
                        )
                )
        );
    }
}
