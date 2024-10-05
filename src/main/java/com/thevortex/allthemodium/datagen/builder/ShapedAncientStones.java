package com.thevortex.allthemodium.datagen.builder;

import com.thevortex.allthemodium.datagen.RecipeException;
import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.TagRegistry;
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
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.RegistryObject;

public class ShapedAncientStones {

    public enum Slot {
        BOOKSHELF, TRAPDOOR, BRICK, FENCE, FENCEGATE, STAIRS, WALL, SLAB, DOOR;

        public String lower() {
            return toString().toLowerCase(Locale.ROOT);
        }
    }

    private final String criteriaName;
    private final InventoryChangeTrigger.TriggerInstance criterion;
    private final EnumMap<Slot, Item> pieces = new EnumMap<>(Slot.class);
    private final TagKey<Item> ancientStone;

    public ShapedAncientStones(TagKey<Item> ancientStone) {
        this.ancientStone = ancientStone;

        this.criteriaName = String.format("has_%s_block", TagRegistry.ANCIENT_STONE.toString());

        ItemPredicate predicate = ItemPredicate.Builder
                .item()
                .of(ancientStone)
                .build();
        this.criterion = InventoryChangeTrigger.TriggerInstance.hasItems(predicate);
    }

    public static ShapedAncientStones builder(TagKey<Item> ancientStone) {
        return new ShapedAncientStones(ancientStone);
    }

    public ShapedAncientStones setBookShelf(RegistryObject<Item> object) {
        pieces.put(Slot.BOOKSHELF, object.get());
        return this;
    }

    public ShapedAncientStones setDoor(RegistryObject<Item> object) {
        pieces.put(Slot.DOOR, object.get());
        return this;
    }

    public ShapedAncientStones setTrapDoor(RegistryObject<Item> object) {
        pieces.put(Slot.TRAPDOOR, object.get());
        return this;
    }

    public ShapedAncientStones setBrick(RegistryObject<Item> object) {
        pieces.put(Slot.BRICK, object.get());
        return this;
    }

    public ShapedAncientStones setStairs(RegistryObject<Item> object) {
        pieces.put(Slot.STAIRS, object.get());
        return this;
    }

    public ShapedAncientStones setFence(RegistryObject<Item> object) {
        pieces.put(Slot.FENCE, object.get());
        return this;
    }

    public ShapedAncientStones setFenceGate(RegistryObject<Item> object) {
        pieces.put(Slot.FENCEGATE, object.get());
        return this;
    }

    public ShapedAncientStones setSlab(RegistryObject<Item> object) {
        pieces.put(Slot.SLAB, object.get());
        return this;
    }

    public ShapedAncientStones setWall(RegistryObject<Item> object) {
        pieces.put(Slot.WALL, object.get());
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
                .ofNullable(pieces.get(Slot.BOOKSHELF))
                .map(this::bookshelf)
                .map(this::addBookCriterion)
                .ifPresent(register);
        Optional
                .ofNullable(pieces.get(Slot.TRAPDOOR))
                .map(this::trapdoor)
                .map(this::addCriterion)
                .ifPresent(register);
        Optional
                .ofNullable(pieces.get(Slot.WALL))
                .map(this::wall)
                .map(this::addCriterion)
                .ifPresent(register);
        Optional
                .ofNullable(pieces.get(Slot.BRICK))
                .map(this::brick)
                .map(this::addCriterion)
                .ifPresent(register);
        Optional
                .ofNullable(pieces.get(Slot.SLAB))
                .map(this::slab)
                .map(this::addCriterion)
                .ifPresent(register);
        Optional
                .ofNullable(pieces.get(Slot.DOOR))
                .map(this::door)
                .map(this::addCriterion)
                .ifPresent(register);
        Optional
                .ofNullable(pieces.get(Slot.STAIRS))
                .map(this::stairs)
                .map(this::addCriterion)
                .ifPresent(register);
        Optional
                .ofNullable(pieces.get(Slot.FENCE))
                .map(this::fence)
                .map(this::addStickCriterion)
                .ifPresent(register);
        Optional
                .ofNullable(pieces.get(Slot.FENCEGATE))
                .map(this::fencegate)
                .map(this::addStickCriterion)
                .ifPresent(register);
    }

    private ShapedRecipeBuilder shaped(ItemLike provider, int integer) {
        return ShapedRecipeBuilder
                .shaped(provider, integer)
                .group(Reference.MOD_ID);
    }

    private ShapedRecipeBuilder shaped(ItemLike provider) {
        return ShapedRecipeBuilder.shaped(provider).group(Reference.MOD_ID);
    }

    private ShapedRecipeBuilder addCriterion(ShapedRecipeBuilder builder) {
        return builder
                .define('a', ancientStone)
                .unlockedBy(criteriaName, criterion);
    }

    private ShapedRecipeBuilder addStickCriterion(ShapedRecipeBuilder builder) {
        return builder
                .define('a', ancientStone)
                .define('s', Items.STICK)
                .unlockedBy(criteriaName, criterion);
    }

    private ShapedRecipeBuilder addBookCriterion(ShapedRecipeBuilder builder) {
        return builder
                .define('a', ancientStone)
                .define('b', Items.BOOK)
                .unlockedBy(criteriaName, criterion);
    }

    private ShapedRecipeBuilder bookshelf(ItemLike provider) {
        return shaped(provider).pattern("aaa").pattern("bbb").pattern("aaa");
    }

    private ShapedRecipeBuilder fence(ItemLike provider) {
        return shaped(provider, 3).pattern("   ").pattern("asa").pattern("asa");
    }

    private ShapedRecipeBuilder trapdoor(ItemLike provider) {
        return shaped(provider, 2).pattern("   ").pattern("aaa").pattern("aaa");
    }

    private ShapedRecipeBuilder door(ItemLike provider) {
        return shaped(provider, 3).pattern("aa ").pattern("aa ").pattern("aa ");
    }

    private ShapedRecipeBuilder brick(ItemLike provider) {
        return shaped(provider, 4).pattern("   ").pattern("aa ").pattern("aa ");
    }

    private ShapedRecipeBuilder fencegate(ItemLike provider) {
        return shaped(provider).pattern("   ").pattern("sas").pattern("sas");
    }

    private ShapedRecipeBuilder stairs(ItemLike provider) {
        return shaped(provider, 4).pattern("a  ").pattern("aa ").pattern("aaa");
    }

    private ShapedRecipeBuilder wall(ItemLike provider) {
        return shaped(provider, 6).pattern("   ").pattern("aaa").pattern("aaa");
    }

    private ShapedRecipeBuilder slab(ItemLike provider) {
        return shaped(provider, 6).pattern("   ").pattern("   ").pattern("aaa");
    }
}
