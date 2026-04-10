package net.allthemods.allthemodium.common.entity;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileDeflection;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

import net.allthemods.allthemodium.core.registry.ATMEntities;
import net.allthemods.allthemodium.core.registry.ATMItems;

import org.jspecify.annotations.Nullable;

import java.util.Collection;
import java.util.List;

public class ThrownModiumTrident extends AbstractArrow {
    
    private static final EntityDataAccessor<Byte> ID_LOYALTY = SynchedEntityData.defineId(ThrownModiumTrident.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Boolean> ID_FOIL = SynchedEntityData.defineId(ThrownModiumTrident.class, EntityDataSerializers.BOOLEAN);
    private static final float WATER_INERTIA = 0.99F;
    private static final boolean DEFAULT_DEALT_DAMAGE = false;
    private boolean dealtDamage = false;
    public int clientSideReturnTridentTickCount;
    
    public ThrownModiumTrident(EntityType<ThrownModiumTrident> type, Level level) {
        super(type, level);
    }
    
    public ThrownModiumTrident(Level level, LivingEntity owner, ItemStack stack) {
        super(ATMEntities.ALLOY_TRIDENT_ENTITY.get(), owner, level, stack, null);
        this.entityData.set(ThrownModiumTrident.ID_LOYALTY, this.getLoyaltyFromItem(stack));
        this.entityData.set(ThrownModiumTrident.ID_FOIL, stack.hasFoil());
    }
    
    public ThrownModiumTrident(Level level, double x, double y, double z, ItemStack stack) {
        super(ATMEntities.ALLOY_TRIDENT_ENTITY.get(), x, y, z, level, stack, stack);
        this.entityData.set(ThrownModiumTrident.ID_LOYALTY, this.getLoyaltyFromItem(stack));
        this.entityData.set(ThrownModiumTrident.ID_FOIL, stack.hasFoil());
    }
    
    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(ThrownModiumTrident.ID_LOYALTY, (byte) 0);
        builder.define(ThrownModiumTrident.ID_FOIL, false);
    }
    
    @Override
    public void tick() {
        if (this.inGroundTime > 2) this.dealtDamage = true;
        
        Entity currentOwner = this.getOwner();
        int loyalty = this.entityData.get(ThrownModiumTrident.ID_LOYALTY);
        if (loyalty > 0 && (this.dealtDamage || this.isNoPhysics()) && currentOwner != null) {
            
            if (!this.isAcceptableReturnOwner()) {
                if (this.level() instanceof ServerLevel level && this.pickup == AbstractArrow.Pickup.ALLOWED) this.spawnAtLocation(level, this.getPickupItem(), 0.1F);
                this.discard();
                return;
            }
            
            if (!(currentOwner instanceof Player) && this.position().distanceTo(currentOwner.getEyePosition()) < currentOwner.getBbWidth() + 1.0) {
                this.discard();
                return;
            }
            
            this.setNoPhysics(true);
            Vec3 vec = currentOwner.getEyePosition().subtract(this.position());
            this.setPosRaw(this.getX(), this.getY() + vec.y * 0.015 * loyalty, this.getZ());
            double acceleration = 0.1 * loyalty;
            this.setDeltaMovement(this.getDeltaMovement().scale(0.95).add(vec.normalize().scale(acceleration)));
            if (this.clientSideReturnTridentTickCount == 0) this.playSound(SoundEvents.TRIDENT_RETURN, 10.0F, 1.0F);
            
            this.clientSideReturnTridentTickCount++;
        }
        
        super.tick();
    }
    
    private boolean isAcceptableReturnOwner() {
        Entity owner = this.getOwner();
        return owner != null && owner.isAlive() && (!(owner instanceof ServerPlayer) || !owner.isSpectator());
    }
    
    public boolean isFoil() {
        return this.entityData.get(ThrownModiumTrident.ID_FOIL);
    }
    
    @Override
    protected @Nullable EntityHitResult findHitEntity(Vec3 from, Vec3 to) {
        return this.dealtDamage ? null : super.findHitEntity(from, to);
    }
    
    @Override
    protected Collection<EntityHitResult> findHitEntities(Vec3 from, Vec3 to) {
        EntityHitResult result = this.findHitEntity(from, to);
        return result != null ? List.of(result) : List.of();
    }
    
    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        Entity entity = hitResult.getEntity();
        float damage = 8.0F;
        Entity owner = this.getOwner();
        DamageSource source = this.damageSources().trident(this, owner == null ? this : owner);
        if (this.level() instanceof ServerLevel level) damage = EnchantmentHelper.modifyDamage(level, this.getWeaponItem(), entity, source, damage);
        
        this.dealtDamage = true;
        if (entity.hurtOrSimulate(source, damage)) {
            if (entity.is(EntityType.ENDERMAN)) return;
            
            if (this.level() instanceof ServerLevel level) {
                EnchantmentHelper.doPostAttackEffectsWithItemSourceOnBreak(level, entity, source, this.getWeaponItem(), _ -> this.kill(level));
            }
            
            if (entity instanceof LivingEntity mob) {
                this.doKnockback(mob, source);
                this.doPostHurtEffects(mob);
            }
        }
        
        this.deflect(ProjectileDeflection.REVERSE, entity, this.owner, false);
        this.setDeltaMovement(this.getDeltaMovement().multiply(0.02, 0.6, 0.02));
        this.playSound(SoundEvents.TRIDENT_HIT, 1.0F, 1.0F);
    }
    
    @Override
    protected void hitBlockEnchantmentEffects(ServerLevel level, BlockHitResult hit, ItemStack weapon) {
        EnchantmentHelper.onHitBlock(
                level,
                weapon,
                this.getOwner() instanceof LivingEntity living ? living : null,
                this,
                null,
                hit.getBlockPos().clampLocationWithin(hit.getLocation()),
                level.getBlockState(hit.getBlockPos()),
                _ -> this.kill(level)
        );
    }
    
    @Override
    public ItemStack getWeaponItem() {
        return this.getPickupItemStackOrigin();
    }
    
    @Override
    protected boolean tryPickup(Player player) {
        return super.tryPickup(player) || this.isNoPhysics() && this.ownedBy(player) && player.getInventory().add(this.getPickupItem());
    }
    
    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ATMItems.ALLOY_TRIDENT.get());
    }
    
    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.TRIDENT_HIT_GROUND;
    }
    
    @Override
    public void playerTouch(Player player) {
        if (this.ownedBy(player) || this.getOwner() == null) super.playerTouch(player);
    }
    
    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        this.dealtDamage = input.getBooleanOr("DealtDamage", ThrownModiumTrident.DEFAULT_DEALT_DAMAGE);
        this.entityData.set(ThrownModiumTrident.ID_LOYALTY, this.getLoyaltyFromItem(this.getPickupItemStackOrigin()));
    }
    
    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        output.putBoolean("DealtDamage", this.dealtDamage);
    }
    
    private byte getLoyaltyFromItem(ItemStack stack) {
        return this.level() instanceof ServerLevel level ? (byte) Mth.clamp(EnchantmentHelper.getTridentReturnToOwnerAcceleration(level, stack, this), 0, 127) : 0;
    }
    
    @Override
    public void tickDespawn() {
        int loyalty = this.entityData.get(ThrownModiumTrident.ID_LOYALTY);
        if (this.pickup != AbstractArrow.Pickup.ALLOWED || loyalty <= 0) super.tickDespawn();
    }
    
    @Override
    protected float getWaterInertia() {
        return ThrownModiumTrident.WATER_INERTIA;
    }
    
    @Override
    public boolean shouldRender(double camX, double camY, double camZ) {
        return true;
    }
}
