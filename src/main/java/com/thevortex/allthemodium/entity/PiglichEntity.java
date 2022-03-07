package com.thevortex.allthemodium.entity;

import com.thevortex.allthemodium.init.ModItems;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.RandomSwim;
import net.minecraft.world.entity.ai.behavior.Swim;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;


public class PiglichEntity extends Piglin {
    private final SimpleContainer inventory = new SimpleContainer(8);

    public PiglichEntity(EntityType<? extends Piglin> type, Level world) {
            super(type, world);
            this.setImmuneToZombification(true);
            this.registerGoals();
        }

    @Override
    public boolean canAttack(LivingEntity entity) {
        return true;
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
        if (this.level.random.nextFloat() < 0.5F) {
            this.setItemSlot(slot, stack);
        }

    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        if (this.isBaby()) {
            tag.putBoolean("IsBaby", true);
        }

        tag.put("Inventory", this.inventory.createTag());
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setBaby(tag.getBoolean("IsBaby"));

        this.inventory.fromTag(tag.getList("Inventory", 10));
    }
    @Override
        protected void registerGoals() {
            this.goalSelector.addGoal(1, new MeleeAttackGoal(this,3.0D,true));
            this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this,0.9D,32.0F));
            this.goalSelector.addGoal(3, new PigLichAttackGoal(this));
            this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Skeleton.class, true));
            this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, WitherSkeleton.class, true));
            this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Zombie.class, true));
            this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Spider.class, true));
            this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Creeper.class, true));
            this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Evoker.class, true));
            this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Illusioner.class, true));
            this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
            this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Player.class, true));
            this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 8.0F));
            this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
            this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1.0D));


        }

        @Override
        public MobType getMobType() {
            return MobType.UNDEFINED;
        }

    private ItemStack createSpawnWeapon() {
        return (double)this.random.nextFloat() < 0.4D ? new ItemStack(ModRegistry.ALLTHEMODIUM_SWORD.get()) : new ItemStack(Items.NETHERITE_SWORD);
    }

    @Override
    public void setImmuneToZombification(boolean p_34671_) {
        super.setImmuneToZombification(true);
    }
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor sla, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag tag) {
        if (mobSpawnType != MobSpawnType.STRUCTURE) {
            if (sla.getRandom().nextFloat() < 0.2F) {
                this.setBaby(true);
            } else if (this.isAdult()) {
                this.setItemSlot(EquipmentSlot.MAINHAND, this.createSpawnWeapon());
            }
        }

        this.populateDefaultEquipementSlots(difficultyInstance);
        this.populateDefaultEquipmentEnchantments(difficultyInstance);
        return super.finalizeSpawn(sla, difficultyInstance, mobSpawnType, spawnGroupData, tag);
    }

    public static AttributeSupplier.Builder createAttributes() {
            return Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED,0.21F).add(Attributes.ATTACK_DAMAGE,4).add(Attributes.ARMOR,18).add(Attributes.ARMOR_TOUGHNESS,12).add(Attributes.MAX_HEALTH,99);
    }

    static class PigLichAttackGoal extends Goal {
        private final PiglichEntity piglich;
        private int attackStep;
        private int attackTime;
        private int lastSeen;

        public PigLichAttackGoal(PiglichEntity p_32247_) {
            this.piglich = p_32247_;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        public boolean canUse() {
            LivingEntity livingentity = this.piglich.getTarget();
            return livingentity != null && livingentity.isAlive() && this.piglich.canAttack(livingentity);
        }

        public void start() {
            this.attackStep = 0;
        }

        public void stop() {
            this.lastSeen = 0;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            --this.attackTime;
            LivingEntity livingentity = this.piglich.getTarget();
            if (livingentity != null) {
                boolean flag = this.piglich.getSensing().hasLineOfSight(livingentity);
                if (flag) {
                    this.lastSeen = 0;
                } else {
                    ++this.lastSeen;
                }

                double d0 = this.piglich.distanceToSqr(livingentity);
                if (d0 < 4.0D) {
                    if (!flag) {
                        return;
                    }

                    if (this.attackTime <= 0) {
                        this.attackTime = 20;
                        this.piglich.doHurtTarget(livingentity);
                    }

                    this.piglich.getMoveControl().setWantedPosition(livingentity.getX(), livingentity.getY(), livingentity.getZ(), 1.0D);
                } else if (d0 < this.getFollowDistance() * this.getFollowDistance() && flag) {
                    double d1 = livingentity.getX() - this.piglich.getX();
                    double d2 = livingentity.getY(0.5D) - this.piglich.getY(0.5D);
                    double d3 = livingentity.getZ() - this.piglich.getZ();
                    if (this.attackTime <= 0) {
                        ++this.attackStep;
                        if (this.attackStep == 1) {
                            this.attackTime = 60;

                        } else if (this.attackStep <= 4) {
                            this.attackTime = 6;
                        } else {
                            this.attackTime = 100;
                            this.attackStep = 0;

                        }

                        if (this.attackStep > 1) {
                            double d4 = Math.sqrt(Math.sqrt(d0)) * 0.5D;
                            if (!this.piglich.isSilent()) {
                                this.piglich.level.levelEvent((Player)null, 1018, this.piglich.blockPosition(), 0);
                            }

                            for(int i = 0; i < 1; ++i) {
                                Vec3 vec3 = this.piglich.getViewVector(1.0F);

                                LargeFireball largefireball = new LargeFireball(this.piglich.level, this.piglich, d2, d3, d4, (int)this.piglich.getHealth());
                                largefireball.setPos(this.piglich.getX() + vec3.x * 4.0D, this.piglich.getY(0.5D) + 0.5D, largefireball.getZ() + vec3.z * 4.0D);
                                this.piglich.level.addFreshEntity(largefireball);
                            }
                        }
                    }

                    this.piglich.getLookControl().setLookAt(livingentity, 10.0F, 10.0F);
                } else if (this.lastSeen < 5) {
                    this.piglich.getMoveControl().setWantedPosition(livingentity.getX(), livingentity.getY(), livingentity.getZ(), 1.0D);
                }

                super.tick();
            }
        }

        private double getFollowDistance() {
            return this.piglich.getAttributeValue(Attributes.FOLLOW_RANGE);
        }
    }

}
