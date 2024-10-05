package com.thevortex.allthemodium.entity;

import com.thevortex.allthemodium.registry.ModRegistry;
import java.util.EnumSet;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.NaturalSpawner;
import net.minecraft.world.level.ServerLevelAccessor;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class PiglichEntity extends Piglin implements IAnimatable {

    private final SimpleContainer inventory = new SimpleContainer(8);
    private AnimationFactory factory = new AnimationFactory(this);
    private boolean isSummoning = false;

    public PiglichEntity(EntityType<? extends Piglin> type, Level world) {
        super(type, world);
        this.setImmuneToZombification(true);
        this.registerGoals();
    }

    @Override
    public boolean canAttack(@Nonnull LivingEntity entity) {
        if (entity instanceof Player) {
            if (((Player) entity).isCreative()) {
                return false;
            }
        }
        return true;
    }

    protected void populateDefaultEquipmentSlots(DifficultyInstance diff) {
        if (this.isAdult()) {
            this.maybeWearArmor(
                    EquipmentSlot.HEAD,
                    new ItemStack(ModRegistry.ALLTHEMODIUM_HELMET.get()));
            this.maybeWearArmor(
                    EquipmentSlot.CHEST,
                    new ItemStack(ModRegistry.ALLTHEMODIUM_CHESTPLATE.get()));
            this.maybeWearArmor(
                    EquipmentSlot.LEGS,
                    new ItemStack(ModRegistry.ALLTHEMODIUM_LEGGINGS.get()));
            this.maybeWearArmor(
                    EquipmentSlot.FEET,
                    new ItemStack(ModRegistry.ALLTHEMODIUM_BOOTS.get()));
        }
    }

    private void maybeWearArmor(EquipmentSlot slot, ItemStack stack) {
        if (this.level.random.nextFloat() < 0.5F) {
            this.setItemSlot(slot, stack);
        }
    }

    @Override
    public void addAdditionalSaveData(@Nonnull CompoundTag tag) {
        super.addAdditionalSaveData(tag);

        tag.put("Inventory", this.inventory.createTag());
    }

    @Override
    public void readAdditionalSaveData(@Nonnull CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.inventory.fromTag(tag.getList("Inventory", 10));
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 3.0D, true));
        this.goalSelector.addGoal(
                2,
                new MoveTowardsTargetGoal(this, 0.9D, 32.0F));
        this.goalSelector.addGoal(1, new PigLichAttackGoal(this));
        this.targetSelector.addGoal(
                1,
                new NearestAttackableTargetGoal<Skeleton>(
                        this,
                        Skeleton.class,
                        true));
        this.targetSelector.addGoal(
                1,
                new NearestAttackableTargetGoal<WitherSkeleton>(
                        this,
                        WitherSkeleton.class,
                        true));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(
                3,
                new NearestAttackableTargetGoal<Player>(
                        this,
                        Player.class,
                        true));
        this.goalSelector.addGoal(
                4,
                new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1.0D));
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    private ItemStack createSpawnWeapon() {
        return (double) this.random.nextFloat() < 0.4D
                ? new ItemStack(ModRegistry.ALLTHEMODIUM_SWORD.get())
                : new ItemStack(Items.NETHERITE_SWORD);
    }

    @Override
    public void setImmuneToZombification(boolean p_34671_) {
        super.setImmuneToZombification(true);
    }

    @Override
    public SpawnGroupData finalizeSpawn(
            @Nonnull ServerLevelAccessor sla,
            @Nonnull DifficultyInstance difficultyInstance,
            @Nonnull MobSpawnType mobSpawnType,
            @Nullable SpawnGroupData spawnGroupData,
            @Nullable CompoundTag tag) {
        if (mobSpawnType != MobSpawnType.STRUCTURE) {
            this.setItemSlot(EquipmentSlot.MAINHAND, this.createSpawnWeapon());
        }

        this.populateDefaultEquipmentSlots(difficultyInstance);
        return super.finalizeSpawn(
                sla,
                difficultyInstance,
                mobSpawnType,
                spawnGroupData,
                tag);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster
                .createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.21F)
                .add(Attributes.ATTACK_DAMAGE, 12)
                .add(Attributes.ARMOR, 24)
                .add(Attributes.ARMOR_TOUGHNESS, 24)
                .add(Attributes.MAX_HEALTH, 9999);
    }

    private <E extends IAnimatable> PlayState predicate(
            AnimationEvent<E> event) {
        if (event.isMoving()) {
            event
                    .getController()
                    .setAnimation(
                            new AnimationBuilder()
                                    .addAnimation("walk.piglich.nik", true));
            return PlayState.CONTINUE;
        }
        if (this.isSummoning) {
            event
                    .getController()
                    .setAnimation(
                            new AnimationBuilder()
                                    .addAnimation("summon.piglich.nik", true));
            return PlayState.CONTINUE;
        }
        event
                .getController()
                .setAnimation(
                        new AnimationBuilder().addAnimation("idle.piglich.nik", true));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(
                new AnimationController<PiglichEntity>(
                        this,
                        "controller",
                        0,
                        this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    static class PigLichAttackGoal extends Goal {

        private final PiglichEntity piglich;
        private int attackStep;
        private int attackTime;
        private int lastSeen;

        public PigLichAttackGoal(PiglichEntity p_32247_) {
            this.piglich = p_32247_;
            this.setFlags(
                    EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Flag.TARGET));
        }

        public boolean canUse() {
            LivingEntity livingEntity = this.piglich.getTarget();
            return (livingEntity != null &&
                    livingEntity.isAlive() &&
                    this.piglich.canAttack(livingEntity));
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

        @SuppressWarnings("unused")
        public void tick() {
            --this.attackTime;
            LivingEntity livingEntity = this.piglich.getTarget();
            if (livingEntity != null) {
                boolean flag = this.piglich.getSensing().hasLineOfSight(livingEntity);
                if (flag) {
                    this.lastSeen = 0;
                } else {
                    ++this.lastSeen;
                }

                double d0 = this.piglich.distanceToSqr(livingEntity);
                if (d0 < 4.0D) {
                    if (!flag) {
                        return;
                    }

                    if (this.attackTime <= 0) {
                        this.attackTime = 20;
                        this.piglich.doHurtTarget(livingEntity);
                    }

                    this.piglich.getMoveControl()
                            .setWantedPosition(
                                    livingEntity.getX(),
                                    livingEntity.getY(),
                                    livingEntity.getZ(),
                                    1.0D);
                } else if (d0 < this.getFollowDistance() * this.getFollowDistance() &&
                        flag) {
                    double d1 = livingEntity.getX() - this.piglich.getX();
                    double d2 = livingEntity.getY(0.5D) - this.piglich.getY(0.5D);
                    double d3 = livingEntity.getZ() - this.piglich.getZ();
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
                                this.piglich.level.levelEvent(
                                        (Player) null,
                                        1018,
                                        this.piglich.blockPosition(),
                                        0);
                            }
                            // for (int i = 0; i < 3; ++i) {
                            //     Vec3 vec3 = this.piglich.getViewVector(1.0F);
                            //     this.piglich.isSummoning = true;
                            //     LargeFireball largeFireball = new LargeFireball(this.piglich.level, this.piglich, d2,
                            //             d3, d4,
                            //             (int) this.piglich.getHealth());
                            //     largeFireball.setPos(this.piglich.getX() +
                            //             vec3.x * 4.0D, this.piglich.getY(0.5D) + 0.5D,
                            //             largeFireball.getZ() + vec3.z
                            //                     * 4.0D);
                            //     this.piglich.level.addFreshEntity(largeFireball);
                            // }

                        }
                    }

                    this.piglich.getLookControl()
                            .setLookAt(livingEntity, 10.0F, 10.0F);
                } else if (this.lastSeen < 5) {
                    this.piglich.getMoveControl()
                            .setWantedPosition(
                                    livingEntity.getX(),
                                    livingEntity.getY(),
                                    livingEntity.getZ(),
                                    1.0D);
                }

                super.tick();
            }
        }

        private double getFollowDistance() {
            return this.piglich.getAttributeValue(Attributes.FOLLOW_RANGE);
        }
    }

    @Override
    public boolean hurt(@Nonnull DamageSource source, float damage) {
        if (!super.hurt(source, damage)) {
            return false;
        } else if (!(this.level instanceof ServerLevel)) {
            return false;
        } else {
            LivingEntity livingEntity = this.getTarget();
            if (livingEntity == null &&
                    source.getEntity() instanceof LivingEntity) {
                livingEntity = (LivingEntity) source.getEntity();
            }

            if (!(livingEntity instanceof Player)) {
                return false;
            } else {
                int i = Mth.floor(this.getX());
                int j = Mth.floor(this.getY());
                int k = Mth.floor(this.getZ());
                return this.spawnSupport(this, i, j, k);
            }
        }
    }

    protected boolean spawnSupport(PiglichEntity piglich, int i, int j, int k) {
        ServerLevel serverLevel = (ServerLevel) piglich.level;
        LivingEntity livingEntity = piglich.getTarget();
        int mobType = Mth.nextInt(piglich.random, 1, 6);
        Monster spawnMob = (Monster) EntityType.PIGLIN_BRUTE.create(
                piglich.level);
        switch (mobType) {
            case 1:
                spawnMob = (Monster) EntityType.PIGLIN_BRUTE.create(piglich.level);
            case 2:
                spawnMob = (Monster) EntityType.BLAZE.create(piglich.level);
            case 3:
                spawnMob = (Monster) EntityType.ENDERMAN.create(piglich.level);
            case 4:
                spawnMob = (Monster) EntityType.EVOKER.create(piglich.level);
            case 5:
                spawnMob = (Monster) EntityType.VINDICATOR.create(piglich.level);
            case 6:
                spawnMob = (Monster) EntityType.WITCH.create(piglich.level);
            default:
                for (int l = 0; l < 5; ++l) {
                    int i1 = i +
                            Mth.nextInt(piglich.random, 7, 40) *
                                    Mth.nextInt(piglich.random, -1, 1);
                    int j1 = j +
                            Mth.nextInt(piglich.random, 7, 40) *
                                    Mth.nextInt(piglich.random, -1, 1);
                    int k1 = k +
                            Mth.nextInt(piglich.random, 7, 40) *
                                    Mth.nextInt(piglich.random, -1, 1);
                    BlockPos blockPos = new BlockPos(i1, j1, k1);

                    if (spawnMob == null)
                        return false;

                    EntityType<?> entityType = spawnMob.getType();
                    SpawnPlacements.Type spawnPlacements$type = SpawnPlacements.getPlacementType(entityType);
                    if (NaturalSpawner.isSpawnPositionOk(
                            spawnPlacements$type,
                            piglich.level,
                            blockPos,
                            entityType) &&
                            SpawnPlacements.checkSpawnRules(
                                    entityType,
                                    serverLevel,
                                    MobSpawnType.REINFORCEMENT,
                                    blockPos,
                                    piglich.level.random)) {
                        spawnMob.setPos((double) i1, (double) j1, (double) k1);
                        if (!piglich.level.hasNearbyAlivePlayer(
                                (double) i1,
                                (double) j1,
                                (double) k1,
                                7.0D) &&
                                piglich.level.isUnobstructed(spawnMob) &&
                                piglich.level.noCollision(spawnMob) &&
                                !piglich.level.containsAnyLiquid(
                                        spawnMob.getBoundingBox())) {
                            if (livingEntity != null) {
                                spawnMob.setTarget(livingEntity);
                            }

                            spawnMob.finalizeSpawn(
                                    serverLevel,
                                    piglich.level.getCurrentDifficultyAt(
                                            spawnMob.blockPosition()),
                                    MobSpawnType.REINFORCEMENT,
                                    (SpawnGroupData) null,
                                    (CompoundTag) null);
                            serverLevel.addFreshEntityWithPassengers(spawnMob);
                        }
                    }
                }
                this.isSummoning = true;
                return true;
        }
    }
}
