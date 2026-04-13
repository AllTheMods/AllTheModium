package net.allthemods.allthemodium.common.entity;

import net.neoforged.neoforge.event.EventHooks;

import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.skeleton.Skeleton;
import net.minecraft.world.entity.monster.skeleton.WitherSkeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.NaturalSpawner;
import net.minecraft.world.level.ServerLevelAccessor;

import com.geckolib.animatable.GeoEntity;
import com.geckolib.animatable.instance.AnimatableInstanceCache;
import com.geckolib.animatable.manager.AnimatableManager;
import com.geckolib.animation.AnimationController;
import com.geckolib.animation.RawAnimation;
import com.geckolib.animation.object.LoopType;
import com.geckolib.animation.object.PlayState;
import com.geckolib.util.GeckoLibUtil;

import java.util.EnumSet;
import java.util.List;
import javax.annotation.Nullable;

public class PiglichEntity extends Piglin implements GeoEntity {
    private static final Identifier SPEED_MODIFIER_ATTACKING_ID = Identifier.withDefaultNamespace("attacking");
    private static final AttributeModifier SPEED_MODIFIER_ATTACKING = new AttributeModifier(PiglichEntity.SPEED_MODIFIER_ATTACKING_ID, 0.08F, AttributeModifier.Operation.ADD_VALUE);
    private static final double ATTACK_SPEED_MODIFIER = 1.5D;
    private static final double SUPPORT_MIN_PLAYER_DISTANCE = 4.0D;
    private static final int SUPPORT_SUMMON_COOLDOWN = 200;
    private static final int SUPPORT_SPAWN_ATTEMPTS = 12;
    private static final int SUPPORT_SPAWN_VERTICAL_RANGE = 3;
    private static final EntityDataAccessor<Boolean> DATA_RUNNING = SynchedEntityData.defineId(PiglichEntity.class, EntityDataSerializers.BOOLEAN);
    
    private static final RawAnimation IDLE = RawAnimation.begin().thenLoop("idle.piglich.nik");
    private static final RawAnimation WALK = RawAnimation.begin().thenLoop("walk.piglich.nik");
    private static final RawAnimation RUN = RawAnimation.begin().thenLoop("run.piglich.nik");
    private static final RawAnimation SUMMON = RawAnimation.begin().then("summon.piglich.nik", LoopType.PLAY_ONCE);
    private static final RawAnimation MELEE = RawAnimation.begin().then("meleeattack.piglich.nik", LoopType.PLAY_ONCE);
    private static final List<EntityType<? extends Monster>> SUPPORT_TYPES = List.of(
            EntityType.PIGLIN_BRUTE,
            EntityType.BLAZE,
            EntityType.ENDERMAN,
            EntityType.EVOKER,
            EntityType.VINDICATOR,
            EntityType.WITCH
    );
    
    private final AnimatableInstanceCache animationCache = GeckoLibUtil.createInstanceCache(this);
    
    public PiglichEntity(EntityType<? extends Piglin> type, Level world) {
        super(type, world);
        this.setImmuneToZombification(true);
    }
    
    @Override
    public boolean canAttack(LivingEntity entity) {
        return !(entity instanceof Player player && player.isCreative()) && super.canAttack(entity);
    }
    
    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, EntitySpawnReason spawnReason, @Nullable SpawnGroupData data) {
        return data;
    }
    
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new PiglichAttackGoal(this, PiglichEntity.ATTACK_SPEED_MODIFIER));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, PiglichEntity.ATTACK_SPEED_MODIFIER, 48.0F));
        this.goalSelector.addGoal(2, new PiglichSupportGoal(this));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D));
        
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, WitherSkeleton.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Skeleton.class, true));
    }
    
    @Override
    public void setImmuneToZombification(boolean immuneToZombification) {
        super.setImmuneToZombification(true);
    }
    
    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(PiglichEntity.DATA_RUNNING, false);
    }
    
    @Override
    protected void customServerAiStep(ServerLevel level) {
        super.customServerAiStep(level);
        this.updateAttackingSpeed();
    }
    
    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.08F)
                .add(Attributes.FOLLOW_RANGE, 48.0D)
                .add(Attributes.ATTACK_DAMAGE, 16.0D)
                .add(Attributes.ARMOR, 24.0D)
                .add(Attributes.ARMOR_TOUGHNESS, 24.0D)
                .add(Attributes.MAX_HEALTH, 9999.0D);
    }
    
    public boolean isRunning() {
        return this.entityData.get(PiglichEntity.DATA_RUNNING);
    }
    
    private void setRunning(boolean running) {
        this.entityData.set(PiglichEntity.DATA_RUNNING, running);
    }
    
    private void updateAttackingSpeed() {
        boolean attacking = this.hasActiveTarget();
        this.setRunning(attacking);
        
        AttributeInstance speed = this.getAttribute(Attributes.MOVEMENT_SPEED);
        if (speed == null) return;
        
        if (attacking) {
            if (!speed.hasModifier(PiglichEntity.SPEED_MODIFIER_ATTACKING_ID)) {
                speed.addTransientModifier(PiglichEntity.SPEED_MODIFIER_ATTACKING);
            }
        } else {
            speed.removeModifier(PiglichEntity.SPEED_MODIFIER_ATTACKING_ID);
        }
    }
    
    private boolean hasActiveTarget() {
        LivingEntity target = this.getTarget();
        return target != null && target.isAlive() && this.canAttack(target);
    }
    
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<PiglichEntity>("main", 0, state -> {
            if (!state.isMoving()) return state.setAndContinue(PiglichEntity.IDLE);
            return state.setAndContinue(state.animatable().isRunning() ? PiglichEntity.RUN : PiglichEntity.WALK);
        }));
        controllers.add(new AnimationController<PiglichEntity>("actions", 0, _ -> PlayState.STOP)
                .triggerableAnim("summon", PiglichEntity.SUMMON)
                .triggerableAnim("melee", PiglichEntity.MELEE));
    }
    
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.animationCache;
    }
    
    private boolean spawnSupport(ServerLevel level, LivingEntity target) {
        BlockPos origin = this.blockPosition();
        
        for (int attempt = 0; attempt < PiglichEntity.SUPPORT_SPAWN_ATTEMPTS; ++attempt) {
            EntityType<? extends Monster> entityType = PiglichEntity.SUPPORT_TYPES.get(this.getRandom().nextInt(PiglichEntity.SUPPORT_TYPES.size()));
            Monster support = entityType.create(level, EntitySpawnReason.REINFORCEMENT);
            if (support == null) continue;
            
            BlockPos pos = this.findSupportSpawnPos(level, support, entityType, origin);
            if (!this.canSpawnSupport(level, support, entityType, pos)) continue;
            
            support.setTarget(target);
            EventHooks.finalizeMobSpawn(support, level, level.getCurrentDifficultyAt(pos), EntitySpawnReason.REINFORCEMENT, null);
            if (support.isSpawnCancelled()) return false;
            
            level.addFreshEntityWithPassengers(support);
            this.triggerAnim("actions", "summon");
            return true;
        }
        
        return false;
    }
    
    @Nullable
    private BlockPos findSupportSpawnPos(ServerLevel level, Monster support, EntityType<?> type, BlockPos origin) {
        int x = origin.getX() + this.randomSupportOffset();
        int z = origin.getZ() + this.randomSupportOffset();
        int y = origin.getY() + Mth.nextInt(this.getRandom(), -2, 2);
        
        for (int offsetY = 0; offsetY <= PiglichEntity.SUPPORT_SPAWN_VERTICAL_RANGE; ++offsetY) {
            BlockPos above = new BlockPos(x, y + offsetY, z);
            if (this.canSpawnSupport(level, support, type, above)) return above;
            
            if (offsetY > 0) {
                BlockPos below = new BlockPos(x, y - offsetY, z);
                if (this.canSpawnSupport(level, support, type, below)) return below;
            }
        }
        
        return null;
    }
    
    private boolean canSpawnSupport(ServerLevel level, Monster support, EntityType<?> type, BlockPos pos) {
        if (!NaturalSpawner.isValidEmptySpawnBlock(level, pos, level.getBlockState(pos), level.getFluidState(pos), type)) return false;
        support.snapTo(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D, this.getRandom().nextFloat() * 360.0F, 0.0F);
        return !level.hasNearbyAlivePlayer(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D, PiglichEntity.SUPPORT_MIN_PLAYER_DISTANCE)
                && level.loadedAndEntityCanStandOn(pos.below(), support)
                && level.isUnobstructed(support)
                && !level.containsAnyLiquid(support.getBoundingBox());
    }
    
    private int randomSupportOffset() {
        int offset = Mth.nextInt(this.getRandom(), 3, 10);
        return this.getRandom().nextBoolean() ? offset : -offset;
    }
    
    private static class PiglichAttackGoal extends MeleeAttackGoal {
        
        private final PiglichEntity piglich;
        
        public PiglichAttackGoal(PiglichEntity piglich, double speedModifier) {
            super(piglich, speedModifier, true);
            this.piglich = piglich;
        }
        
        @Override
        public boolean canUse() {
            LivingEntity target = this.piglich.getTarget();
            return target != null && this.piglich.canAttack(target) && super.canUse();
        }
        
        @Override
        public boolean canContinueToUse() {
            LivingEntity target = this.piglich.getTarget();
            return target != null && this.piglich.canAttack(target) && super.canContinueToUse();
        }
        
        @Override
        protected void checkAndPerformAttack(LivingEntity target) {
            if (this.canPerformAttack(target)) {
                this.piglich.triggerAnim("actions", "melee");
            }
            
            super.checkAndPerformAttack(target);
        }
    }
    
    private static class PiglichSupportGoal extends Goal {
        
        private final PiglichEntity piglich;
        @Nullable
        private LivingEntity target;
        private int lastHurtTimestamp;
        private long nextSummonTime;
        
        public PiglichSupportGoal(PiglichEntity piglich) {
            this.piglich = piglich;
            this.setFlags(EnumSet.of(Flag.TARGET));
        }
        
        @Override
        public boolean canUse() {
            int timestamp = this.piglich.getLastHurtByMobTimestamp();
            if (timestamp == this.lastHurtTimestamp) return false;
            this.lastHurtTimestamp = timestamp;
            
            LivingEntity attacker = this.piglich.getLastHurtByMob();
            if (!(attacker instanceof Player) || !this.piglich.canAttack(attacker)) return false;
            if (this.piglich.level().getGameTime() < this.nextSummonTime) return false;
            
            this.target = attacker;
            return true;
        }
        
        @Override
        public boolean canContinueToUse() {
            return false;
        }
        
        @Override
        public void start() {
            if (!(this.piglich.level() instanceof ServerLevel level) || this.target == null) return;
            
            this.nextSummonTime = level.getGameTime() + PiglichEntity.SUPPORT_SUMMON_COOLDOWN;
            this.piglich.setTarget(this.target);
            this.piglich.spawnSupport(level, this.target);
            this.target = null;
        }
        
        @Override
        public void stop() {
            this.target = null;
        }
    }
}
