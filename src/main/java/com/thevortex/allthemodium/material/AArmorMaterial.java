package com.thevortex.allthemodium.material;

import com.thevortex.allthemodium.registry.ModRegistry;
import java.util.function.Supplier;
import javax.annotation.Nonnull;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@SuppressWarnings("deprecation") // TODO: Determine alternative to LazyLoadedValue
public enum AArmorMaterial implements ArmorMaterial {
    ALLTHEMODIUM(
            "allthemodium",
            42,
            new int[] { 4, 7, 9, 4 },
            85,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            5.0F,
            0.5f,
            () -> {
                return Ingredient.of(ModRegistry.ALLTHEMODIUM_INGOT.get());
            });

    private static final int[] MAX_DAMAGE_ARRAY = new int[] { 25, 45, 45, 25 };
    private final String name;

    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float knockback;

    private final LazyLoadedValue<Ingredient> repairMaterial;

    AArmorMaterial(
            String nameIn,
            int maxDamageFactorIn,
            int[] damageReductionAmountsIn,
            int enchantabilityIn,
            SoundEvent equipSoundIn,
            float toughness,
            float knockback,
            Supplier<Ingredient> repairMaterialSupplier) {
        this.name = nameIn;
        this.maxDamageFactor = maxDamageFactorIn;
        this.damageReductionAmountArray = damageReductionAmountsIn;
        this.enchantability = enchantabilityIn;
        this.soundEvent = equipSoundIn;
        this.toughness = toughness;
        this.repairMaterial = new LazyLoadedValue<Ingredient>(repairMaterialSupplier);
        this.knockback = knockback;
    }

    @Override
    public int getDurabilityForSlot(@Nonnull EquipmentSlot slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDefenseForSlot(@Nonnull EquipmentSlot slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
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
    public float getKnockbackResistance() {
        return this.knockback;
    }
}
