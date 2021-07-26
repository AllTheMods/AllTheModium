package com.thevortex.allthemodium.material;

import java.util.function.Supplier;


import com.thevortex.allthemodium.init.ModItems;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;


public enum ItemTier implements Tier {
	ALLTHEMODIUM(5, 5500, 12.0F, 30.0F, 185, () -> {
	      return Ingredient.of(ModRegistry.ALLTHEMODIUM_INGOT.get());
	   }),
    VIBRANIUM(6, 7500, 18.0F, 35.0F, 235, () -> {
	      return Ingredient.of(ModRegistry.VIBRANIUM_INGOT.get());
	   }),
    UNOBTAINIUM(7, 9500, 24.0F, 40.0F, 285, () -> {
	      return Ingredient.of(ModRegistry.UNOBTAINIUM_INGOT.get());
	   }),
    UNOBTAINIUMALLOY(8, 17000, 44.0F, 1500.0F, 515, () -> {
	      return Ingredient.of(ModItems.UNOBTAINIUM_VIBRANIUM_ALLOY);
	   });
   private final int harvestLevel;
   private final int maxUses;
   private final float efficiency;
   private final float attackDamage;
   private final int enchantability;
   private final LazyLoadedValue<Ingredient> repairMaterial;

   ItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
      this.harvestLevel = harvestLevelIn;
      this.maxUses = maxUsesIn;
      this.efficiency = efficiencyIn;
      this.attackDamage = attackDamageIn;
      this.enchantability = enchantabilityIn;
      this.repairMaterial = new LazyLoadedValue<>(repairMaterialIn);
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
