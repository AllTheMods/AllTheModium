package com.thevortex.allthemodium.entity;

import com.thevortex.allthemodium.AllTheModium;
import com.thevortex.allthemodium.items.toolitems.tools.ATMTrident;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;

import java.util.Comparator;
import java.util.List;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.Objects;

public class ThrownTrident extends AbstractArrow
{
    // ...existing code...
    private static final EntityDataAccessor<Boolean> DATA_ENCHANT_GLOW = SynchedEntityData.defineId(ThrownTrident.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<ItemStack> DATA_ITEM = SynchedEntityData.defineId(ThrownTrident.class, EntityDataSerializers.ITEM_STACK);

    // Tuning parameters
    private static final double CHAIN_SEARCH_RADIUS = 20.0D;    // How far to search for the next monster
    private static final double CHAIN_SPEED = 2.5D;              // Speed of the trident when chaining
    private static final double RETURN_DETECTION_DISTANCE = 1.0D; // Distance to player before auto-pickup
    private static final double RETURN_ACCELERATION = 0.05D;     // How fast the trident accelerates back
    private static final int CHAIN_CHECK_INTERVAL = 5;           // Check for chaining every N ticks

    public int clientSideReturnTridentTickCount;
    private boolean dealtDamage = false;
    private boolean returning = false;
    private int chainCheckTick = 0;

    public ThrownTrident(EntityType<? extends ThrownTrident> type, Level level)
    {
        super(type, level);
    }

    public ThrownTrident(Level level, LivingEntity entity, ItemStack stack)
    {
        super(ModRegistry.ALLOY_TRIDENT_ENTITY.get(), entity, level, stack, null);
        setItem(stack);
        setIsEnchantGlowing(stack.hasFoil());
    }



    @Override
    protected void onHitEntity(EntityHitResult result)
    {

        final Entity entity = result.getEntity();
        float dmg = 75.0F;
        final Entity owner = this.getOwner();
        final DamageSource src = this.damageSources().trident(this, (owner == null ? this : owner));
        final Level level = this.level();
        if (level instanceof ServerLevel server)
        {
            // Spawn lightning strike at the target entity's position
            EntityType.LIGHTNING_BOLT.spawn(server, entity.blockPosition(), null);
        }

        this.dealtDamage = true;
        if (entity.hurt(src, dmg))
        {
            if (entity.getType() == EntityType.ENDERMAN)
            {
                return;
            }



            if (entity instanceof LivingEntity livingentity)
            {
                this.doKnockback(livingentity, src);
                this.doPostHurtEffects(livingentity);
            }
        }

        this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01, -0.1, -0.01));
        this.playSound(SoundEvents.TRIDENT_HIT, 1.0F, 1.0F);

    }

    @Override
    public ItemStack getWeaponItem()
    {
        return this.getPickupItemStackOrigin();
    }

    @Override
    protected boolean tryPickup(Player player)
    {
        return super.tryPickup(player) || this.isNoPhysics() && this.ownedBy(player) && player.getInventory().add(this.getPickupItem());
    }

    @Override
    public void tickDespawn()
    {
        if (this.pickup != AbstractArrow.Pickup.ALLOWED)
        {
            super.tickDespawn();
        }
    }

    @Override
    public boolean shouldRender(double x, double y, double z)
    {
        return true;
    }

    @Nullable
    protected EntityHitResult findHitEntity(Vec3 pos1, Vec3 pos2)
    {
        return this.dealtDamage ? null : super.findHitEntity(pos1, pos2);
    }


    @Override
    protected float getWaterInertia()
    {
        return 0.99F;
    }

    @Override
    public SoundEvent getDefaultHitGroundSoundEvent()
    {
        return SoundEvent.createVariableRangeEvent(SoundEvents.TRIDENT_HIT_GROUND.getLocation());
    }

    /**
     * if not a javelin inside (for some reason), default to 8 which is the trident damage value
     */
    public float getItemAttackDamage()
    {
        return getItem().getItem() instanceof ATMTrident javelin ? javelin.getThrownDamage() : 8F;
    }

    @Override
    public ItemStack getPickupItem()
    {
        return getItem().copy();
    }

    @Override
    protected ItemStack getDefaultPickupItem()
    {
        return new ItemStack(ModRegistry.ALLOY_TRIDENT.get());
    }


    private boolean isAcceptibleReturnOwner() { return true; }
    public void tick() {
        Entity owner = this.getOwner();

        // If trident is in return mode, keep returning to owner
        if (this.returning && owner instanceof Player player) {
            this.returnToOwner(player);

            // Check if we've reached the owner
            if (this.distanceTo(player) < RETURN_DETECTION_DISTANCE) {
                // Discard once we reach the owner
                this.discard();
                return;
            }
        }

        // Only check for chaining every N ticks for performance
        if (!this.returning) {
            chainCheckTick++;
            if (chainCheckTick >= CHAIN_CHECK_INTERVAL) {
                chainCheckTick = 0;

                // If this trident has dealt damage, spawn a new one and discard this one
                if (this.dealtDamage && owner instanceof Player player) {
                    List<Monster> nearbyMonsters = this.level().getEntitiesOfClass(Monster.class, this.getBoundingBox().inflate(CHAIN_SEARCH_RADIUS));
                    if(!nearbyMonsters.isEmpty()) {
                        // Remove dead monsters
                        nearbyMonsters.removeIf(m -> m.isDeadOrDying());

                        if(!nearbyMonsters.isEmpty()) {
                            // Sort by distance and get the nearest one
                            nearbyMonsters.sort(Comparator.comparingDouble(m -> m.distanceTo(this)));
                            Entity target = nearbyMonsters.get(0);
                            AllTheModium.LOGGER.info("Spawning new trident to chain to: " + target.getName().getString());

                            // Create and launch a new trident at the nearest monster
                            ThrownTrident newTrident = new ThrownTrident(this.level(), player, this.getPickupItem());
                            Vec3 targetPos = target.getEyePosition();
                            Vec3 thisPos = this.position();
                            Vec3 direction = targetPos.subtract(thisPos).normalize();

                            // Set the new trident's position and velocity
                            newTrident.moveTo(this.position());
                            newTrident.setDeltaMovement(direction.scale(CHAIN_SPEED));
                            this.level().addFreshEntity(newTrident);

                            // Discard the current trident after spawning the new one
                            this.discard();
                            return;
                        } else {
                            // No more monsters found, enter return mode
                            AllTheModium.LOGGER.info("No more monsters found, returning to owner");
                            this.returning = true;
                        }
                    } else {
                        // No monsters in range, enter return mode
                        AllTheModium.LOGGER.info("No monsters in range, returning to owner");
                        this.returning = true;
                    }
                }
            }
        }

        // Mark as dealt damage if in ground long enough
        if (this.inGroundTime > 4) {
            this.dealtDamage = true;
        }

        super.tick();
    }

    private void returnToOwner(Player player) {
        int i = 10;
        this.setNoPhysics(true);
        Vec3 vec3 = player.getEyePosition().subtract(this.position());
        this.setPosRaw(this.getX(), this.getY() + vec3.y * 0.015 * (double)i, this.getZ());
        if (this.level().isClientSide) {
            this.yOld = this.getY();
        }

        double d0 = RETURN_ACCELERATION * (double)i;
        this.setDeltaMovement(this.getDeltaMovement().scale(0.95).add(vec3.normalize().scale(d0)));
        if (this.clientSideReturnTridentTickCount == 0) {

            this.playSound(SoundEvents.TRIDENT_RETURN, 10.0F, 10.0F);
        }
        ++this.clientSideReturnTridentTickCount;

        // Spin attack logic
        float f = EnchantmentHelper.getTridentSpinAttackStrength(this.getPickupItem(), player);
        if (f > 0.0F) {
            float f7 = player.getYRot();
            float f1 = player.getXRot();
            float f2 = -Mth.sin(f7 * 0.017453292F) * Mth.cos(f1 * 0.017453292F);
            float f3 = -Mth.sin(f1 * 0.017453292F);
            float f4 = Mth.cos(f7 * 0.017453292F) * Mth.cos(f1 * 0.017453292F);
            float f5 = Mth.sqrt(f2 * f2 + f3 * f3 + f4 * f4);
            f2 *= f / f5;
            f3 *= f / f5;
            f4 *= f / f5;
            player.push(f2, f3, f4);
            player.startAutoSpinAttack(20, 8.0F, this.getPickupItem());
            if (player.onGround()) {
                player.move(MoverType.SELF, new Vec3(0.0, 1.1999999284744263, 0.0));
            }
            player.level().playSound(null, player, SoundEvents.TRIDENT_RETURN, SoundSource.PLAYERS, 1.0F, 1.0F);
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder)
    {
        super.defineSynchedData(builder);
        builder.define(DATA_ENCHANT_GLOW, false);
        builder.define(DATA_ITEM, ItemStack.EMPTY);
    }

    public ItemStack getItem()
    {
        return entityData.get(DATA_ITEM);
    }

    public void setItem(ItemStack item)
    {
        entityData.set(DATA_ITEM, item.copy());
    }

    public boolean isEnchantGlowing()
    {
        return entityData.get(DATA_ENCHANT_GLOW);
    }

    public void setIsEnchantGlowing(boolean glow)
    {
        entityData.set(DATA_ENCHANT_GLOW, glow);
    }




}