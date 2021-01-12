package com.thevortex.allthemodium.material;

import java.util.function.Supplier;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import com.thevortex.allthemodium.init.ModItems;

public enum ArmorMaterial implements IArmorMaterial {
	   ALLTHEMODIUM("allthemodium", 500, new int[]{100, 100, 200, 100}, 185, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 42.0F, () -> {
		      return Ingredient.fromItems(ModItems.ALLTHEMODIUM_INGOT);
		   }),
	   VIBRANIUM("vibranium", 1000, new int[]{150, 300, 400, 150}, 235, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 62.0F, () -> {
	      return Ingredient.fromItems(ModItems.VIBRANIUM_INGOT);
	   }),
	   UNOBTAINIUM("unobtainium",2000, new int[]{400, 600, 600, 400}, 285, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 82.0F, () -> {
	      return Ingredient.fromItems(ModItems.UNOBTAINIUM_INGOT);
	   });
    

   private static final int[] MAX_DAMAGE_ARRAY = new int[]{400, 600, 600, 400};
   private final String name;
   
   private final int maxDamageFactor;
   private final int[] damageReductionAmountArray;
   private final int enchantability;
   private final SoundEvent soundEvent;
   private final float toughness;
   private final float knockback;
   private final LazyValue<Ingredient> repairMaterial;

   private ArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountsIn, int enchantabilityIn, SoundEvent equipSoundIn, float p_i48533_8_, Supplier<Ingredient> repairMaterialSupplier) {
      this.name = nameIn;
      this.maxDamageFactor = maxDamageFactorIn;
      this.damageReductionAmountArray = damageReductionAmountsIn;
      this.enchantability = enchantabilityIn;
      this.soundEvent = equipSoundIn;
      this.toughness = p_i48533_8_;
      this.repairMaterial = new LazyValue<>(repairMaterialSupplier);
      this.knockback = this.toughness;
   }

   public int getDurability(EquipmentSlotType slotIn) {
      return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
   }

   public int getDamageReductionAmount(EquipmentSlotType slotIn) {
      return this.damageReductionAmountArray[slotIn.getIndex()];
   }

   public int getEnchantability() {
      return this.enchantability;
   }

   public SoundEvent getSoundEvent() {
      return this.soundEvent;
   }

   public Ingredient getRepairMaterial() {
      return this.repairMaterial.getValue();
   }

   @OnlyIn(Dist.CLIENT)
   public String getName() {
      return this.name;
   }

   public float getToughness() {
      return this.toughness;
   }

@Override
public float getKnockbackResistance() {
	// TODO Auto-generated method stub
	return this.knockback;
}

}
