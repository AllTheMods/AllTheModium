package com.thevortex.allthemodium.entity;

import com.thevortex.allthemodium.init.ModItems;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
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
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;


public class PiglichEntity extends Piglin {
    private final SimpleContainer inventory = new SimpleContainer(8);

    public PiglichEntity(EntityType<? extends Piglin> type, Level world) {
            super(type, world);
            this.setImmuneToZombification(true);
            this.registerGoals();
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
        if (this.level.random.nextFloat() < 0.1F) {
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
            this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Piglin.class, false));
            this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, PiglinBrute.class, false));
            this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Player.class, true));
            this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Skeleton.class, true));
            this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Zombie.class, true));
            this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Spider.class, true));
            this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Creeper.class, true));
            this.targetSelector.addGoal(4, new HurtByTargetGoal(this));
            this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 8.0F));
            this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
            this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.0D));


        }

        @Override
        public MobType getMobType() {
            return MobType.UNDEAD;
        }
    private ItemStack createSpawnWeapon() {
        return (double)this.random.nextFloat() < 0.2D ? new ItemStack(ModRegistry.ALLTHEMODIUM_SWORD.get()) : new ItemStack(Items.NETHERITE_SWORD);
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
            return Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED,0.4F).add(Attributes.ATTACK_DAMAGE,4).add(Attributes.ARMOR,18).add(Attributes.ARMOR_TOUGHNESS,12).add(Attributes.MAX_HEALTH,99);
    }



}
