package com.thevortex.allthemodium.material;

import java.util.function.Supplier;

import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum AArmorMaterial implements ArmorMaterial {
	   ALLTHEMODIUM("allthemodium", 42, new int[]{4, 7, 9, 4}, 85, SoundEvents.ARMOR_EQUIP_NETHERITE, 5.0F, 0.5f, () -> {
		      return Ingredient.of(ModRegistry.ALLTHEMODIUM_INGOT.get());
       }),
       VIBRANIUM("vibranium", 62, new int[]{6, 9, 11, 6}, 105, SoundEvents.ARMOR_EQUIP_NETHERITE, 9.0F, 0.8f, () -> {
      return Ingredient.of(ModRegistry.VIBRANIUM_INGOT.get());
       }),
      UNOBTAINIUM("unobtainium", 82, new int[]{8, 11, 13, 8}, 125, SoundEvents.ARMOR_EQUIP_NETHERITE, 15.0F, 1.0f, () -> {
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

   AArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountsIn, int enchantabilityIn, SoundEvent equipSoundIn, float toughness, float knockback, Supplier<Ingredient> repairMaterialSupplier) {
      this.name = nameIn;
      this.maxDamageFactor = maxDamageFactorIn;
      this.damageReductionAmountArray = damageReductionAmountsIn;
      this.enchantability = enchantabilityIn;
      this.soundEvent = equipSoundIn;
      this.toughness = toughness;
      this.repairMaterial = new LazyLoadedValue(repairMaterialSupplier);
      this.knockback = knockback;
   }

   public int getDurabilityForSlot(EquipmentSlot slotIn) { return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor; }

   public int getDefenseForSlot(EquipmentSlot slotIn) { return this.damageReductionAmountArray[slotIn.getIndex()];  }

   @Override
   public int getDurabilityForType(ArmorItem.Type type) {
      return this.getDurabilityForSlot(type.getSlot());
   }

   @Override
   public int getDefenseForType(ArmorItem.Type type) {
      return this.getDefenseForSlot(type.getSlot());
   }

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
