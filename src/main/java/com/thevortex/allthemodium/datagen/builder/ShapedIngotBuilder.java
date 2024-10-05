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

public class ShapedIngotBuilder {

    public enum Slot {
        INGOT;

        public String lower() {
            return toString().toLowerCase(Locale.ROOT);
        }
    }

    private final String criteriaName;
    private final InventoryChangeTrigger.TriggerInstance criterion;
    private final EnumMap<Slot, Item> pieces = new EnumMap<>(Slot.class);
    private final TagKey<Item> nugget;

    public ShapedIngotBuilder(TagKey<Item> nugget) {
        this.nugget = nugget;

        this.criteriaName = String.format("has_%s_nugget", nugget);

        ItemPredicate predicate = ItemPredicate.Builder
                .item()
                .of(nugget)
                .build();
        this.criterion = InventoryChangeTrigger.TriggerInstance.hasItems(predicate);
    }

    public static ShapedIngotBuilder builder(TagKey<Item> nugget) {
        return new ShapedIngotBuilder(nugget);
    }

    public ShapedIngotBuilder setIngot(RegistryObject<Item> object) {
        pieces.put(Slot.INGOT, object.get());
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
                .ofNullable(pieces.get(Slot.INGOT))
                .map(this::ingot)
                .map(this::addCriterionNugget)
                .ifPresent(register);
    }

    private ShapedRecipeBuilder shaped(ItemLike provider) {
        return ShapedRecipeBuilder.shaped(provider).group(Reference.MOD_ID);
    }

    private ShapedRecipeBuilder addCriterionNugget(
            ShapedRecipeBuilder builder) {
        return builder.define('a', nugget).unlockedBy(criteriaName, criterion);
    }

    private ShapedRecipeBuilder ingot(ItemLike provider) {
        return shaped(provider).pattern("aaa").pattern("aaa").pattern("aaa");
    }
}
