package net.allthemods.allthemodium.core.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import java.util.List;

public class ATMConsumables {
    
    public static final Consumable ALLTHEMODIUM_APPLE = Consumables.defaultFood()
            .consumeSeconds(0.8F)
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    List.of(
                            new MobEffectInstance(MobEffects.RESISTANCE, 300, 1),
                            new MobEffectInstance(MobEffects.REGENERATION, 600, 1),
                            new MobEffectInstance(MobEffects.ABSORPTION, 600, 1),
                            new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 1)
                    )
            ))
            .build();
    
    public static final Consumable ALLTHEMODIUM_CARROT = Consumables.defaultFood()
            .consumeSeconds(0.3F)
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    List.of(
                            new MobEffectInstance(MobEffects.REGENERATION, 600, 1),
                            new MobEffectInstance(MobEffects.ABSORPTION, 600, 1),
                            new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 1)
                    )
            ))
            .build();
    
    public static final Consumable SOUL_BERRIES = Consumables.defaultFood()
            .consumeSeconds(1.2F)
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    List.of(
                            new MobEffectInstance(MobEffects.NIGHT_VISION, 1200, 1)
                    )
            ))
            .build();
}
