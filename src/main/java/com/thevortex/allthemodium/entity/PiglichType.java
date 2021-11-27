package com.thevortex.allthemodium.entity;

import com.google.common.collect.ImmutableSet;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.level.block.Block;

public class PiglichType {
    public static final EntityType<PiglichEntity> PIGLICH = register("piglich", EntityType.Builder.<PiglichEntity>of(PiglichEntity::new, MobCategory.MONSTER).sized(0.6F, 2.1F).clientTrackingRange(16));

    private static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        return Registry.register(Registry.ENTITY_TYPE, name, builder.build(name));
    }

}
