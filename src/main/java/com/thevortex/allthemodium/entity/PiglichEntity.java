package com.thevortex.allthemodium.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
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
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.NaturalSpawner;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.Animation.LoopType;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class PiglichEntity extends Piglin implements GeoEntity {
    public static final EntityDataAccessor<Boolean> DATA_SUMMON_TRIGGER = SynchedEntityData.defineId(PiglichEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DATA_ATTACK_TRIGGER = SynchedEntityData.defineId(PiglichEntity.class, EntityDataSerializers.BOOLEAN);

    private static final RawAnimation SUMMON_ANIM = RawAnimation.begin().then("summon.piglich.nik", LoopType.PLAY_ONCE);
    private static final RawAnimation ATTACK_ANIM = RawAnimation.begin().then("meleeattack.piglich.nik", LoopType.PLAY_ONCE);
    private static final RawAnimation WALK_ANIM = RawAnimation.begin().then("walk.piglich.nik", LoopType.LOOP);
    private static final RawAnimation IDLE_ANIM = RawAnimation.begin().then("idle.piglich.nik", LoopType.LOOP);

    private int summonTriggerTicks;
    private int attackTriggerTicks;

    private final SimpleContainer inventory = new SimpleContainer(8);
    private final AnimatableInstanceCache animationCache = GeckoLibUtil.createInstanceCache(this);
    private final Level level;

    public PiglichEntity(EntityType<? extends Piglin> type, Level world) {
            super(type, world);
            this.level = world;
            this.createAttributes();
            this.setImmuneToZombification(true);
            this.registerGoals();
        }

    @Override
    public boolean canAttack(LivingEntity entity) {
        if(entity instanceof Player) {
            if(((Player)entity).isCreative()) { return false; }
        }
        return true;
    }


    
    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_34717_, DifficultyInstance p_34718_, MobSpawnType p_34719_, @Nullable SpawnGroupData p_34720_) {
            return p_34720_;
    }

    @Override
        protected void registerGoals() {
            this.goalSelector.addGoal(3, new MeleeAttackGoal(this,3.0D,true));
            this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this,0.9D,32.0F));
            this.goalSelector.addGoal(1, new PigLichAttackGoal(this));
            this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Skeleton.class, true));
            this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, WitherSkeleton.class, true));
            this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
            this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Player.class, true));
            this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 8.0F));
            this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
            this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1.0D));


        }

      

    

    @Override
    public void setImmuneToZombification(boolean p_34671_) {
        super.setImmuneToZombification(true);
    }
   
    
    public static AttributeSupplier.Builder createAttributes() {
            return Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED,0.21F).add(Attributes.ATTACK_DAMAGE,12).add(Attributes.ARMOR,24).add(Attributes.ARMOR_TOUGHNESS,24).add(Attributes.MAX_HEALTH,9999);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_SUMMON_TRIGGER, false);
        builder.define(DATA_ATTACK_TRIGGER, false);
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.level().isClientSide) {
            if (this.summonTriggerTicks > 0 && --this.summonTriggerTicks == 0) {
                this.entityData.set(DATA_SUMMON_TRIGGER, false);
            }
            if (this.attackTriggerTicks > 0 && --this.attackTriggerTicks == 0) {
                this.entityData.set(DATA_ATTACK_TRIGGER, false);
            }
        } else {
            // Constant smoke trail around Piglich (always active on client).
            this.level().addParticle(
                net.minecraft.core.particles.ParticleTypes.LARGE_SMOKE,
                this.getX() + (this.random.nextDouble() - 0.5D) * 0.5D,
                this.getY() + 0.8D + this.random.nextDouble() * 0.6D,
                this.getZ() + (this.random.nextDouble() - 0.5D) * 0.5D,
                0.0D, 0.015D, 0.0D
            );

            // Client-side particle effects when summoning/shooting fireballs.
            if (this.entityData.get(DATA_SUMMON_TRIGGER)) {
                for (int i = 0; i < 2; i++) {
                    double xOffset = (this.random.nextDouble() - 0.5D) * 0.8D;
                    double yOffset = this.random.nextDouble() * 1.5D + 0.5D;
                    double zOffset = (this.random.nextDouble() - 0.5D) * 0.8D;

                    this.level().addParticle(
                        net.minecraft.core.particles.ParticleTypes.FLAME,
                        this.getX() + xOffset,
                        this.getY() + yOffset,
                        this.getZ() + zOffset,
                        0.0D, 0.05D, 0.0D
                    );

                    this.level().addParticle(
                        net.minecraft.core.particles.ParticleTypes.LARGE_SMOKE,
                        this.getX() + xOffset,
                        this.getY() + yOffset,
                        this.getZ() + zOffset,
                        0.0D, 0.02D, 0.0D
                    );
                }

                if (this.random.nextInt(3) == 0) {
                    this.level().addParticle(
                        net.minecraft.core.particles.ParticleTypes.SOUL_FIRE_FLAME,
                        this.getX() + (this.random.nextDouble() - 0.5D) * 0.8D,
                        this.getY() + this.random.nextDouble() * 1.5D + 0.5D,
                        this.getZ() + (this.random.nextDouble() - 0.5D) * 0.8D,
                        0.0D, 0.03D, 0.0D
                    );
                }
            }
        }
    }

    private void pulseSummonTrigger(int ticks) {
        this.summonTriggerTicks = Math.max(this.summonTriggerTicks, ticks);
        this.entityData.set(DATA_SUMMON_TRIGGER, true);
    }

    private void pulseAttackTrigger(int ticks) {
        this.attackTriggerTicks = Math.max(this.attackTriggerTicks, ticks);
        this.entityData.set(DATA_ATTACK_TRIGGER, true);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController<>(this, "controller", 2, state -> {
            boolean summonTrigger = this.entityData.get(DATA_SUMMON_TRIGGER);
            boolean attackTrigger = this.entityData.get(DATA_ATTACK_TRIGGER);

            // Prioritize summon while ranged volley trigger is active.
            if (summonTrigger) {
                state.getController().setAnimation(SUMMON_ANIM);
                return PlayState.CONTINUE;
            }

            // Then melee attack animation if active.
            if (attackTrigger) {
                state.getController().setAnimation(ATTACK_ANIM);
                return PlayState.CONTINUE;
            }

            if (state.isMoving()) {
                state.getController().setAnimation(WALK_ANIM);
                return PlayState.CONTINUE;
            }

            state.getController().setAnimation(IDLE_ANIM);
            return PlayState.CONTINUE;
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return animationCache;
    }

    static class PigLichAttackGoal extends Goal {
        private final PiglichEntity piglich;
        private int attackStep;
        private int attackTime;
        private int lastSeen;


        public PigLichAttackGoal(PiglichEntity p_32247_) {
            this.piglich = p_32247_;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Flag.TARGET));
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
                        if (this.piglich.doHurtTarget(livingentity)) {
                            this.piglich.pulseAttackTrigger(40);
                        }
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
                            double inaccuracy = Math.sqrt(Math.sqrt(d0)) * 0.5D;
                            if (!this.piglich.isSilent()) {
                                this.piglich.level.levelEvent((Player)null, 1018, this.piglich.blockPosition(), 0);
                            }

                            // Fire a small volley toward the current target.
                            for (int i = 0; i < 3; ++i) {
                                Vec3 shotDir = new Vec3(
                                        d1 + this.piglich.random.triangle(0.0D, inaccuracy),
                                        d2,
                                        d3 + this.piglich.random.triangle(0.0D, inaccuracy)
                                );
                                SmallFireball fireball = new SmallFireball(this.piglich.level, this.piglich, shotDir);
                                Vec3 view = this.piglich.getViewVector(1.0F);
                                fireball.setPos(
                                        this.piglich.getX() + view.x * 2.0D,
                                        this.piglich.getY(0.5D) + 0.5D,
                                        this.piglich.getZ() + view.z * 2.0D
                                );
                                this.piglich.level.addFreshEntity(fireball);
                            }

                            // Ranged volley should play summon animation.
                            this.piglich.pulseSummonTrigger(40);
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

    @Override
    public boolean hurt(DamageSource source, float damage) {
        if (!super.hurt(source, damage)) {
            return false;
        } else if (!(this.level instanceof ServerLevel)) {
            return false;
        } else {
            ServerLevel serverlevel = (ServerLevel)this.level;
            LivingEntity livingentity = this.getTarget();
            if (livingentity == null && source.getEntity() instanceof LivingEntity) {
                livingentity = (LivingEntity)source.getEntity();
            }

            if (!(livingentity instanceof Player)) {
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

        ServerLevel serverlevel = (ServerLevel)piglich.level;
        LivingEntity livingentity = piglich.getTarget();
        int mobType = Mth.nextInt(piglich.random, 1, 6);
        Monster spawnmob = (Monster)EntityType.PIGLIN_BRUTE.create(piglich.level);
        switch(mobType) {
            case 1:
                spawnmob = (Monster)EntityType.PIGLIN_BRUTE.create(piglich.level);
            case 2:
                spawnmob = (Monster)EntityType.BLAZE.create(piglich.level);
            case 3:
                spawnmob = (Monster)EntityType.ENDERMAN.create(piglich.level);
            case 4:
                spawnmob = (Monster)EntityType.EVOKER.create(piglich.level);
            case 5:
                spawnmob = (Monster)EntityType.VINDICATOR.create(piglich.level);
            case 6:
                spawnmob = (Monster)EntityType.WITCH.create(piglich.level);
            default:
                for(int l = 0; l < 5; ++l) {
                    int i1 = i + Mth.nextInt(piglich.random, 7, 40) * Mth.nextInt(piglich.random, -1, 1);
                    int j1 = j + Mth.nextInt(piglich.random, 7, 40) * Mth.nextInt(piglich.random, -1, 1);
                    int k1 = k + Mth.nextInt(piglich.random, 7, 40) * Mth.nextInt(piglich.random, -1, 1);
                    BlockPos blockpos = new BlockPos(i1, j1, k1);
                    EntityType<?> entitytype = spawnmob.getType();
                    SpawnPlacementType spawnplacements$type = SpawnPlacements.getPlacementType(entitytype);
                    if (NaturalSpawner.isValidEmptySpawnBlock((BlockGetter)piglich.level, blockpos, piglich.level().getBlockState(blockpos), piglich.level().getFluidState(blockpos), entitytype) && SpawnPlacements.checkSpawnRules(entitytype, serverlevel, MobSpawnType.REINFORCEMENT, blockpos, piglich.level.random)) {
                        spawnmob.setPos((double)i1, (double)j1, (double)k1);
                        if (!piglich.level.hasNearbyAlivePlayer((double)i1, (double)j1, (double)k1, 7.0D) && piglich.level.isUnobstructed(spawnmob) && piglich.level.noCollision(spawnmob) && !piglich.level.containsAnyLiquid(spawnmob.getBoundingBox())) {
                            if (livingentity != null) {
                                spawnmob.setTarget(livingentity);
                            }

                            spawnmob.finalizeSpawn((ServerLevelAccessor)serverlevel, piglich.level.getCurrentDifficultyAt(spawnmob.blockPosition()), MobSpawnType.REINFORCEMENT, (SpawnGroupData)null);
                            serverlevel.addFreshEntityWithPassengers(spawnmob);
                        }
                    }
                }
                this.pulseSummonTrigger(40);
                return true;
        }
    }

}
