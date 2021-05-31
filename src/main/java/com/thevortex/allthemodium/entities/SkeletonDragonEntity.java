package com.thevortex.allthemodium.entities;

import com.github.alexthe666.iceandfire.entity.EntityLightningDragon;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.world.World;

public class SkeletonDragonEntity extends EntityLightningDragon {

    public SkeletonDragonEntity(EntityType t, World worldIn) {
        super(t, worldIn);
        setModelDead(true);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
    }
}
