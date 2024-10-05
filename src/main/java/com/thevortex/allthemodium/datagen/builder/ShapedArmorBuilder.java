package com.thevortex.allthemodium.datagen.builder;

import com.thevortex.allthemodium.datagen.RecipeException;
import com.thevortex.allthemodium.reference.Reference;
import java.util.EnumMap;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Consumer;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.RegistryObject;

public class ShapedArmorBuilder {

    public enum Slot {
        HELMET, CHESTPLATE, LEGGINGS, BOOTS;

        public String lower() {
            return toString().toLowerCase(Locale.ROOT);
        }
    }

    private final String criteriaName;
    private final InventoryChangeTrigger.TriggerInstance criterion;
    private final EnumMap<Slot, Item> pieces = new EnumMap<>(Slot.class);
    private final TagKey<Item> ingot;

    public ShapedArmorBuilder(TagKey<Item> ingot) {
        this.ingot = ingot;

        this.criteriaName = String.format("has_%s_ingot", ingot);

        ItemPredicate predicate = ItemPredicate.Builder
                .item()
                .of(ingot)
                .build();
        this.criterion = InventoryChangeTrigger.TriggerInstance.hasItems(predicate);
    }

    public static ShapedArmorBuilder builder(TagKey<Item> ingot) {
        return new ShapedArmorBuilder(ingot);
    }

    public ShapedArmorBuilder setHelmet(RegistryObject<ArmorItem> object) {
        pieces.put(Slot.HELMET, object.get());
        return this;
    }

    public ShapedArmorBuilder setChestplate(RegistryObject<ArmorItem> object) {
        pieces.put(Slot.CHESTPLATE, object.get());
        return this;
    }

    public ShapedArmorBuilder setLeggings(RegistryObject<ArmorItem> object) {
        pieces.put(Slot.LEGGINGS, object.get());
        return this;
    }

    public ShapedArmorBuilder setBoots(RegistryObject<ArmorItem> object) {
        pieces.put(Slot.BOOTS, object.get());
        return this;
    }

    protected void validate(ResourceLocation id) {
        if (pieces.isEmpty()) {
            throw new RecipeException(
                    id.toString(),
                    "recipe must have at least 1 output");
        }
    }

    public void build(Consumer<FinishedRecipe> consumer) {
        Consumer<ShapedRecipeBuilder> register = builder -> builder.save(consumer);

        Optional
                .ofNullable(pieces.get(Slot.HELMET))
                .map(this::helmet)
                .map(this::addCriterion)
                .ifPresent(register);

        Optional
                .ofNullable(pieces.get(Slot.CHESTPLATE))
                .map(this::chestplate)
                .map(this::addCriterion)
                .ifPresent(register);

        Optional
                .ofNullable(pieces.get(Slot.LEGGINGS))
                .map(this::leggings)
                .map(this::addCriterion)
                .ifPresent(register);

        Optional
                .ofNullable(pieces.get(Slot.BOOTS))
                .map(this::boots)
                .map(this::addCriterion)
                .ifPresent(register);
    }

    private ShapedRecipeBuilder shaped(ItemLike provider) {
        return ShapedRecipeBuilder.shaped(provider).group(Reference.MOD_ID);
    }

    private ShapedRecipeBuilder addCriterion(ShapedRecipeBuilder builder) {
        return builder.define('a', ingot).unlockedBy(criteriaName, criterion);
    }

    private ShapedRecipeBuilder helmet(ItemLike provider) {
        return shaped(provider).pattern("aaa").pattern("a a").pattern("   ");
    }

    private ShapedRecipeBuilder chestplate(ItemLike provider) {
        return shaped(provider).pattern("a a").pattern("aaa").pattern("aaa");
    }

    private ShapedRecipeBuilder leggings(ItemLike provider) {
        return shaped(provider).pattern("aaa").pattern("a a").pattern("a a");
    }

    private ShapedRecipeBuilder boots(ItemLike provider) {
        return shaped(provider).pattern("a a").pattern("a a").pattern("   ");
    }
}
