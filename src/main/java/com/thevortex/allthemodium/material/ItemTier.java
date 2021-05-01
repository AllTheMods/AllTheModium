package com.thevortex.allthemodium.material;

import java.util.function.Supplier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import com.thevortex.allthemodium.init.ModItems;

public enum ItemTier implements IItemTier {
	ALLTHEMODIUM(5, 5500, 12.0F, 30.0F, 185, () -> {
	      return Ingredient.of(ModItems.ALLTHEMODIUM_INGOT);
	   }),
    VIBRANIUM(6, 7500, 18.0F, 35.0F, 235, () -> {
	      return Ingredient.of(ModItems.VIBRANIUM_INGOT);
	   }),
    UNOBTAINIUM(7, 9500, 24.0F, 40.0F, 285, () -> {
	      return Ingredient.of(ModItems.UNOBTAINIUM_INGOT);
	   }),
    UNOBTAINIUMALLOY(8, 17000, 44.0F, 1500.0F, 515, () -> {
	      return Ingredient.of(ModItems.UNOBTAINIUM_VIBRANIUM_ALLOY);
	   });
   private final int harvestLevel;
   private final int maxUses;
   private final float efficiency;
   private final float attackDamage;
   private final int enchantability;
   private final LazyValue<Ingredient> repairMaterial;

   ItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
      this.harvestLevel = harvestLevelIn;
      this.maxUses = maxUsesIn;
      this.efficiency = efficiencyIn;
      this.attackDamage = attackDamageIn;
      this.enchantability = enchantabilityIn;
      this.repairMaterial = new LazyValue<>(repairMaterialIn);
   }
    @Override
    public int getUses() {
      return this.maxUses;
   }
    @Override
    public float getSpeed() { return this.efficiency; }
    @Override
    public float getAttackDamageBonus() {
      return this.attackDamage;
   }
    @Override
    public int getLevel() {
      return this.harvestLevel;
   }
    @Override
    public int getEnchantmentValue() { return this.enchantability; }
    @Override
    public Ingredient getRepairIngredient() {
      return this.repairMaterial.get();
   }
}
