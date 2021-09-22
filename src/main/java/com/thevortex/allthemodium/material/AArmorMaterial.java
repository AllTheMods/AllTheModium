package com.thevortex.allthemodium.material;

import java.util.function.Supplier;

import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import com.thevortex.allthemodium.init.ModItems;

import javax.swing.*;

public enum AArmorMaterial implements ArmorMaterial {
	   ALLTHEMODIUM("allthemodium", 45, new int[]{10, 15, 15, 10}, 185, SoundEvents.ARMOR_EQUIP_CHAIN, 125.0F, () -> {
		      return Ingredient.of(ModRegistry.ALLTHEMODIUM_INGOT.get());
		   }),
	   VIBRANIUM("vibranium", 75, new int[]{15, 30, 30, 15}, 235, SoundEvents.ARMOR_EQUIP_CHAIN, 250.0F, () -> {
	      return Ingredient.of(ModRegistry.VIBRANIUM_INGOT.get());
	   }),
	   UNOBTAINIUM("unobtainium",100, new int[]{25, 45, 45, 25}, 485, SoundEvents.ARMOR_EQUIP_CHAIN, 500.0F, () -> {
	      return Ingredient.of(ModRegistry.UNOBTAINIUM_INGOT.get());
	   });
    

   private static final int[] MAX_DAMAGE_ARRAY = new int[]{25, 45, 45, 25};
   private final String name;
   
   private final int maxDamageFactor;
   private final int[] damageReductionAmountArray;
   private final int enchantability;
   private final SoundEvent soundEvent;
   private final float toughness;
   private final float knockback;
   private final LazyLoadedValue<Ingredient> repairMaterial;

   AArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountsIn, int enchantabilityIn, SoundEvent equipSoundIn, float p_i48533_8_, Supplier<Ingredient> repairMaterialSupplier) {
      this.name = nameIn;
      this.maxDamageFactor = maxDamageFactorIn;
      this.damageReductionAmountArray = damageReductionAmountsIn;
      this.enchantability = enchantabilityIn;
      this.soundEvent = equipSoundIn;
      this.toughness = p_i48533_8_;
      this.repairMaterial = new LazyLoadedValue(repairMaterialSupplier);
      this.knockback = this.toughness/100.0F;
   }
   @Override
   public int getDurabilityForSlot(EquipmentSlot slotIn) { return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor; }
   @Override
   public int getDefenseForSlot(EquipmentSlot slotIn) { return this.damageReductionAmountArray[slotIn.getIndex()];  }
   @Override
   public int getEnchantmentValue() {
      return this.enchantability;
   }
   @Override
   public SoundEvent getEquipSound() {
      return this.soundEvent;
   }
   @Override
   public Ingredient getRepairIngredient() {
      return this.repairMaterial.get();
   }
   @OnlyIn(Dist.CLIENT)
   public String getName() {
      return this.name;
   }
   @Override
   public float getToughness() {
      return this.toughness;
   }
   @Override
   public float getKnockbackResistance() { return this.knockback;   }

}
