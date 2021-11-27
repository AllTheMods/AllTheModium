package com.thevortex.allthemodium.entity;

import com.thevortex.allthemodium.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.RandomSwim;
import net.minecraft.world.entity.ai.behavior.Swim;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class PiglichEntity extends Piglin {

        public PiglichEntity(EntityType<? extends Piglin> type, Level world) {
            super(type, world);
            this.setImmuneToZombification(true);
            this.populateDefaultEquipementSlots(world.getCurrentDifficultyAt(new BlockPos(0,64,0)));
        }


        protected void populateDefaultEquipementSlots(DifficultyInstance diff) {
            if (this.isAdult()) {
                this.maybeWearArmor(EquipmentSlot.HEAD, new ItemStack(ModItems.ALLTHEMODIUM_HELMET));
                this.maybeWearArmor(EquipmentSlot.CHEST, new ItemStack(ModItems.ALLTHEMODIUM_CHESTPLATE));
                this.maybeWearArmor(EquipmentSlot.LEGS, new ItemStack(ModItems.ALLTHEMODIUM_LEGGINGS));
                this.maybeWearArmor(EquipmentSlot.FEET, new ItemStack(ModItems.ALLTHEMODIUM_BOOTS));
            }

        }
    private void maybeWearArmor(EquipmentSlot slot, ItemStack stack) {
        if (this.level.random.nextFloat() < 0.10F) {
            this.setItemSlot(slot, stack);
        }

    }
    @Override
        protected void registerGoals() {
            this.goalSelector.addGoal(1, new MeleeAttackGoal(this,3.0D,true));
            this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this,0.9D,32.0F));
            this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Piglin.class, false));
            this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, PiglinBrute.class, false));
            this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Player.class, true));
            this.targetSelector.addGoal(4, new HurtByTargetGoal(this));
            this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 8.0F));
            this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
            this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.0D));
        }

        @Override
        public MobType getMobType() {
            return MobType.UNDEAD;
        }

    @Override
    public void setImmuneToZombification(boolean p_34671_) {
        super.setImmuneToZombification(true);
    }

    public static AttributeSupplier.Builder createAttributes() {
            return Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED,0.25F).add(Attributes.ATTACK_DAMAGE,16).add(Attributes.ARMOR,18).add(Attributes.ARMOR_TOUGHNESS,12).add(Attributes.MAX_HEALTH,420);
    }



}
