package com.thevortex.allthemodium.entity.shulkers.unob;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.level.Level;

public class UNOBShulkerEntity extends Shulker {

    public UNOBShulkerEntity(
            EntityType<? extends Shulker> p_33404_,
            Level p_33405_) {
        super(p_33404_, p_33405_);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster
                .createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.21F)
                .add(Attributes.ATTACK_DAMAGE, 4)
                .add(Attributes.ARMOR, 18)
                .add(Attributes.ARMOR_TOUGHNESS, 12)
                .add(Attributes.MAX_HEALTH, 45);
    }
}
