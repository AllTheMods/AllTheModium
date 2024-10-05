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
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.RegistryObject;

public class ShapedBlockBuilder {

    public enum Slot {
        BLOCK, GEAR, ROD, PLATE;

        public String lower() {
            return toString().toLowerCase(Locale.ROOT);
        }
    }

    private final String criteriaName;
    private final InventoryChangeTrigger.TriggerInstance criterion;
    private final EnumMap<Slot, Item> pieces = new EnumMap<>(Slot.class);
    private final TagKey<Item> ingot;

    public ShapedBlockBuilder(TagKey<Item> ingot) {
        this.ingot = ingot;

        this.criteriaName = String.format("has_%s_ingot", ingot);

        ItemPredicate predicate = ItemPredicate.Builder
                .item()
                .of(ingot)
                .build();
        this.criterion = InventoryChangeTrigger.TriggerInstance.hasItems(predicate);
    }

    public static ShapedBlockBuilder builder(TagKey<Item> ingot) {
        return new ShapedBlockBuilder(ingot);
    }

    public ShapedBlockBuilder setBlock(RegistryObject<Item> object) {
        pieces.put(Slot.BLOCK, object.get());
        return this;
    }

    public ShapedBlockBuilder setGear(RegistryObject<Item> object) {
        pieces.put(Slot.GEAR, object.get());
        return this;
    }

    public ShapedBlockBuilder setPlate(RegistryObject<Item> object) {
        pieces.put(Slot.PLATE, object.get());
        return this;
    }

    public ShapedBlockBuilder setRod(RegistryObject<Item> object) {
        pieces.put(Slot.ROD, object.get());
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
                .ofNullable(pieces.get(Slot.BLOCK))
                .map(this::block)
                .map(this::addCriterionIngot)
                .ifPresent(register);
        Optional
                .ofNullable(pieces.get(Slot.GEAR))
                .map(this::gear)
                .map(this::addCriterionIngot)
                .ifPresent(register);
        Optional
                .ofNullable(pieces.get(Slot.ROD))
                .map(this::rod)
                .map(this::addCriterionIngot)
                .ifPresent(register);
        Optional
                .ofNullable(pieces.get(Slot.PLATE))
                .map(this::plate)
                .map(this::addCriterionIngot)
                .ifPresent(register);
    }

    private ShapedRecipeBuilder shaped(ItemLike provider) {
        return ShapedRecipeBuilder.shaped(provider).group(Reference.MOD_ID);
    }

    private ShapedRecipeBuilder addCriterionIngot(ShapedRecipeBuilder builder) {
        return builder.define('a', ingot).unlockedBy(criteriaName, criterion);
    }

    private ShapedRecipeBuilder block(ItemLike provider) {
        return shaped(provider).pattern("aaa").pattern("aaa").pattern("aaa");
    }

    // private ShapedRecipeBuilder ingot(ItemLike provider) {
    // return shaped(provider)
    // .pattern("aaa")
    // .pattern("aaa")
    // .pattern("aaa");

    // }

    private ShapedRecipeBuilder gear(ItemLike provider) {
        return shaped(provider).pattern("aaa").pattern("a a").pattern("aaa");
    }

    private ShapedRecipeBuilder rod(ItemLike provider) {
        return shaped(provider).pattern("a  ").pattern("a  ").pattern("a  ");
    }

    private ShapedRecipeBuilder plate(ItemLike provider) {
        return shaped(provider).pattern("aa ").pattern("aa ").pattern("   ");
    }
}
