package net.allthemods.allthemodium.core.registry;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.common.entity.PiglichEntity;
import net.allthemods.allthemodium.common.entity.ThrownModiumTrident;

public class ATMEntities {
    
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, ATM.MOD_ID);
    
    public static final DeferredHolder<EntityType<?>, EntityType<ThrownModiumTrident>> ALLOY_TRIDENT_ENTITY = ATMEntities.ENTITIES.register("alloy_trident",
            k -> EntityType.Builder.<ThrownModiumTrident>of(ThrownModiumTrident::new, MobCategory.MISC).noLootTable().sized(0.5F, 0.5F).eyeHeight(0.13F).clientTrackingRange(4).updateInterval(20).build(ResourceKey.create(Registries.ENTITY_TYPE, k))
    );
    
    public static final DeferredHolder<EntityType<?>, EntityType<PiglichEntity>> PIGLICH = ATMEntities.ENTITIES.register("piglich",
            k -> EntityType.Builder.of(PiglichEntity::new, MobCategory.MONSTER).fireImmune().sized(1.0F, 2.8F).eyeHeight(2.2F).clientTrackingRange(10).build(ResourceKey.create(Registries.ENTITY_TYPE, k))
    );
    
    public static void register(final IEventBus bus) {
        ATMEntities.ENTITIES.register(bus);
    }
}
