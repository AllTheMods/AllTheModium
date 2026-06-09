package net.allthemods.allthemodium.data.provider.tags;

import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.core.registry.ATMBlocks;
import net.allthemods.allthemodium.core.registry.ATMFluids;
import net.allthemods.allthemodium.core.registry.ATMItems;
import net.allthemods.allthemodium.core.registry.ATMTags;

import java.util.concurrent.CompletableFuture;

public class ATMItemTagsProvider extends ItemTagsProvider {
    
    public ATMItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, ATM.MOD_ID);
    }
    
    @Override
    protected void addTags(HolderLookup.Provider registries) {
        this.tag(ItemTags.PLANKS)
                .add(
                        ATMBlocks.ANCIENT_PLANKS.get().asItem(),
                        ATMBlocks.SOUL_PLANKS.get().asItem(),
                        ATMBlocks.DEMONIC_PLANKS.get().asItem()
                );
        this.tag(ATMTags.Items.ANCIENT_PLANKS).add(ATMBlocks.ANCIENT_PLANKS.get().asItem());
        this.tag(ATMTags.Items.SOUL_PLANKS).add(ATMBlocks.SOUL_PLANKS.get().asItem());
        this.tag(ATMTags.Items.DEMONIC_PLANKS).add(ATMBlocks.DEMONIC_PLANKS.get().asItem());
        
        this.tag(ItemTags.LOGS)
                .add(
                        ATMBlocks.ANCIENT_LOG_0.get().asItem(),
                        ATMBlocks.ANCIENT_LOG_1.get().asItem(),
                        ATMBlocks.ANCIENT_LOG_2.get().asItem(),
                        ATMBlocks.STRIPPED_ANCIENT_LOG.get().asItem(),
                        ATMBlocks.SOUL_LOG_0.get().asItem(),
                        ATMBlocks.SOUL_LOG_1.get().asItem(),
                        ATMBlocks.SOUL_LOG_2.get().asItem(),
                        ATMBlocks.STRIPPED_SOUL_LOG.get().asItem(),
                        ATMBlocks.DEMONIC_LOG.get().asItem(),
                        ATMBlocks.STRIPPED_DEMONIC_LOG.get().asItem()
                );
        
        this.tag(ItemTags.SAPLINGS)
                .add(
                        ATMBlocks.ANCIENT_SAPLING.get().asItem(),
                        ATMBlocks.SOUL_SAPLING.get().asItem(),
                        ATMBlocks.DEMONIC_SAPLING.get().asItem()
                );
        this.tag(ItemTags.LEAVES)
                .add(
                        ATMBlocks.ANCIENT_LEAVES.get().asItem(),
                        ATMBlocks.ANCIENT_LEAVES_BOTTOM.get().asItem(),
                        ATMBlocks.SOUL_LEAVES.get().asItem(),
                        ATMBlocks.SOUL_LEAVES_BOTTOM.get().asItem(),
                        ATMBlocks.DEMONIC_LEAVES.get().asItem(),
                        ATMBlocks.DEMONIC_LEAVES_BOTTOM.get().asItem()
                );
        
        this.tag(ItemTags.WOODEN_SLABS)
                .add(
                        ATMBlocks.ANCIENT_SLAB.get().asItem(),
                        ATMBlocks.SOUL_SLAB.get().asItem(),
                        ATMBlocks.DEMONIC_SLAB.get().asItem()
                );
        this.tag(ItemTags.SLABS)
                .add(
                        ATMBlocks.ANCIENT_SLAB.get().asItem(),
                        ATMBlocks.SOUL_SLAB.get().asItem(),
                        ATMBlocks.DEMONIC_SLAB.get().asItem(),
                        ATMBlocks.ANCIENT_STONE_SLAB.get().asItem(),
                        ATMBlocks.SMOOTH_ANCIENT_STONE_SLAB.get().asItem(),
                        ATMBlocks.MOSSY_ANCIENT_STONE_SLAB.get().asItem(),
                        ATMBlocks.ANCIENT_STONE_BRICK_SLAB.get().asItem(),
                        ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_SLAB.get().asItem(),
                        ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_SLAB.get().asItem(),
                        ATMBlocks.POLISHED_ANCIENT_STONE_SLAB.get().asItem()
                );
        
        this.tag(ItemTags.WOODEN_STAIRS)
                .add(
                        ATMBlocks.ANCIENT_STAIRS.get().asItem(),
                        ATMBlocks.SOUL_STAIRS.get().asItem(),
                        ATMBlocks.DEMONIC_STAIRS.get().asItem()
                );
        this.tag(ItemTags.STAIRS)
                .add(
                        ATMBlocks.ANCIENT_STAIRS.get().asItem(),
                        ATMBlocks.SOUL_STAIRS.get().asItem(),
                        ATMBlocks.DEMONIC_STAIRS.get().asItem(),
                        ATMBlocks.ANCIENT_STONE_STAIRS.get().asItem(),
                        ATMBlocks.SMOOTH_ANCIENT_STONE_STAIRS.get().asItem(),
                        ATMBlocks.MOSSY_ANCIENT_STONE_STAIRS.get().asItem(),
                        ATMBlocks.ANCIENT_STONE_BRICK_STAIRS.get().asItem(),
                        ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_STAIRS.get().asItem(),
                        ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_STAIRS.get().asItem(),
                        ATMBlocks.POLISHED_ANCIENT_STONE_STAIRS.get().asItem()
                );
        
        this.tag(ItemTags.WOODEN_FENCES)
                .add(
                        ATMBlocks.ANCIENT_FENCE.get().asItem(),
                        ATMBlocks.SOUL_FENCE.get().asItem(),
                        ATMBlocks.DEMONIC_FENCE.get().asItem()
                );
        this.tag(ItemTags.FENCE_GATES)
                .add(
                        ATMBlocks.ANCIENT_FENCE_GATE.get().asItem(),
                        ATMBlocks.SOUL_FENCE_GATE.get().asItem(),
                        ATMBlocks.DEMONIC_FENCE_GATE.get().asItem()
                );
        
        this.tag(ItemTags.WOODEN_DOORS)
                .add(
                        ATMBlocks.ANCIENT_DOOR.get().asItem(),
                        ATMBlocks.SOUL_DOOR.get().asItem(),
                        ATMBlocks.DEMONIC_DOOR.get().asItem()
                );
        this.tag(ItemTags.WOODEN_TRAPDOORS)
                .add(
                        ATMBlocks.ANCIENT_TRAPDOOR.get().asItem(),
                        ATMBlocks.SOUL_TRAPDOOR.get().asItem(),
                        ATMBlocks.DEMONIC_TRAPDOOR.get().asItem()
                );
        this.tag(ItemTags.WALLS)
                .add(
                        ATMBlocks.ANCIENT_STONE_WALL.get().asItem(),
                        ATMBlocks.SMOOTH_ANCIENT_STONE_WALL.get().asItem(),
                        ATMBlocks.MOSSY_ANCIENT_STONE_WALL.get().asItem(),
                        ATMBlocks.ANCIENT_STONE_BRICK_WALL.get().asItem(),
                        ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_WALL.get().asItem(),
                        ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_WALL.get().asItem(),
                        ATMBlocks.POLISHED_ANCIENT_STONE_WALL.get().asItem()
                );
        
        this.tag(ItemTags.DIRT)
                .add(
                        ATMBlocks.ANCIENT_DIRT.get().asItem(),
                        ATMBlocks.ANCIENT_GRASS.get().asItem()
                );
        this.tag(ItemTags.STONE_BRICKS)
                .add(
                        ATMBlocks.ANCIENT_STONE_BRICKS.get().asItem(),
                        ATMBlocks.CHISELED_ANCIENT_STONE_BRICKS.get().asItem(),
                        ATMBlocks.CRACKED_ANCIENT_STONE_BRICKS.get().asItem()
                );
        this.tag(ATMTags.Items.ANCIENT_STONE).add(ATMBlocks.ANCIENT_STONE.get().asItem());
        this.tag(ATMTags.Items.SMOOTH_ANCIENT_STONE).add(ATMBlocks.SMOOTH_ANCIENT_STONE.get().asItem());
        this.tag(ATMTags.Items.MOSSY_ANCIENT_STONE).add(ATMBlocks.MOSSY_ANCIENT_STONE.get().asItem());
        this.tag(ATMTags.Items.POLISHED_ANCIENT_STONE).add(ATMBlocks.POLISHED_ANCIENT_STONE.get().asItem());
        this.tag(ATMTags.Items.ANCIENT_STONE_BRICKS).add(ATMBlocks.ANCIENT_STONE_BRICKS.get().asItem());
        this.tag(ATMTags.Items.CRACKED_ANCIENT_STONE_BRICKS).add(ATMBlocks.CRACKED_ANCIENT_STONE_BRICKS.get().asItem());
        this.tag(ATMTags.Items.CHISELED_ANCIENT_STONE_BRICKS).add(ATMBlocks.CHISELED_ANCIENT_STONE_BRICKS.get().asItem());
        
        this.tag(ItemTags.HEAD_ARMOR)
                .add(
                        ATMItems.ALLTHEMODIUM_HELMET.get(),
                        ATMItems.VIBRANIUM_HELMET.get(),
                        ATMItems.UNOBTAINIUM_HELMET.get()
                );
        this.tag(ItemTags.CHEST_ARMOR)
                .add(
                        ATMItems.ALLTHEMODIUM_CHESTPLATE.get(),
                        ATMItems.VIBRANIUM_CHESTPLATE.get(),
                        ATMItems.UNOBTAINIUM_CHESTPLATE.get()
                );
        this.tag(ItemTags.LEG_ARMOR)
                .add(
                        ATMItems.ALLTHEMODIUM_LEGGINGS.get(),
                        ATMItems.VIBRANIUM_LEGGINGS.get(),
                        ATMItems.UNOBTAINIUM_LEGGINGS.get()
                );
        this.tag(ItemTags.FOOT_ARMOR)
                .add(
                        ATMItems.ALLTHEMODIUM_BOOTS.get(),
                        ATMItems.VIBRANIUM_BOOTS.get(),
                        ATMItems.UNOBTAINIUM_BOOTS.get()
                );
        this.tag(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(
                        ATMItems.ALLTHEMODIUM_HELMET.get(),
                        ATMItems.VIBRANIUM_HELMET.get(),
                        ATMItems.UNOBTAINIUM_HELMET.get()
                );
        this.tag(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(
                        ATMItems.ALLTHEMODIUM_CHESTPLATE.get(),
                        ATMItems.VIBRANIUM_CHESTPLATE.get(),
                        ATMItems.UNOBTAINIUM_CHESTPLATE.get()
                );
        this.tag(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(
                        ATMItems.ALLTHEMODIUM_LEGGINGS.get(),
                        ATMItems.VIBRANIUM_LEGGINGS.get(),
                        ATMItems.UNOBTAINIUM_LEGGINGS.get()
                );
        this.tag(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(
                        ATMItems.ALLTHEMODIUM_BOOTS.get(),
                        ATMItems.VIBRANIUM_BOOTS.get(),
                        ATMItems.UNOBTAINIUM_BOOTS.get()
                );
        this.tag(ItemTags.ARMOR_ENCHANTABLE)
                .add(
                        ATMItems.ALLTHEMODIUM_HELMET.get(), ATMItems.ALLTHEMODIUM_CHESTPLATE.get(), ATMItems.ALLTHEMODIUM_LEGGINGS.get(), ATMItems.ALLTHEMODIUM_BOOTS.get(),
                        ATMItems.VIBRANIUM_HELMET.get(), ATMItems.VIBRANIUM_CHESTPLATE.get(), ATMItems.VIBRANIUM_LEGGINGS.get(), ATMItems.VIBRANIUM_BOOTS.get(),
                        ATMItems.UNOBTAINIUM_HELMET.get(), ATMItems.UNOBTAINIUM_CHESTPLATE.get(), ATMItems.UNOBTAINIUM_LEGGINGS.get(), ATMItems.UNOBTAINIUM_BOOTS.get()
                );
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(
                        ATMItems.ALLTHEMODIUM_HELMET.get(), ATMItems.ALLTHEMODIUM_CHESTPLATE.get(), ATMItems.ALLTHEMODIUM_LEGGINGS.get(), ATMItems.ALLTHEMODIUM_BOOTS.get(),
                        ATMItems.VIBRANIUM_HELMET.get(), ATMItems.VIBRANIUM_CHESTPLATE.get(), ATMItems.VIBRANIUM_LEGGINGS.get(), ATMItems.VIBRANIUM_BOOTS.get(),
                        ATMItems.UNOBTAINIUM_HELMET.get(), ATMItems.UNOBTAINIUM_CHESTPLATE.get(), ATMItems.UNOBTAINIUM_LEGGINGS.get(), ATMItems.UNOBTAINIUM_BOOTS.get()
                );
        this.tag(ItemTags.EQUIPPABLE_ENCHANTABLE)
                .add(
                        ATMItems.ALLTHEMODIUM_HELMET.get(), ATMItems.ALLTHEMODIUM_CHESTPLATE.get(), ATMItems.ALLTHEMODIUM_LEGGINGS.get(), ATMItems.ALLTHEMODIUM_BOOTS.get(),
                        ATMItems.VIBRANIUM_HELMET.get(), ATMItems.VIBRANIUM_CHESTPLATE.get(), ATMItems.VIBRANIUM_LEGGINGS.get(), ATMItems.VIBRANIUM_BOOTS.get(),
                        ATMItems.UNOBTAINIUM_HELMET.get(), ATMItems.UNOBTAINIUM_CHESTPLATE.get(), ATMItems.UNOBTAINIUM_LEGGINGS.get(), ATMItems.UNOBTAINIUM_BOOTS.get()
                )
                .add(ATMItems.VIBRANIUM_SHIELD.get());
        this.tag(ItemTags.DURABILITY_ENCHANTABLE)
                .add(
                        ATMItems.ALLTHEMODIUM_HELMET.get(), ATMItems.ALLTHEMODIUM_CHESTPLATE.get(), ATMItems.ALLTHEMODIUM_LEGGINGS.get(), ATMItems.ALLTHEMODIUM_BOOTS.get(),
                        ATMItems.VIBRANIUM_HELMET.get(), ATMItems.VIBRANIUM_CHESTPLATE.get(), ATMItems.VIBRANIUM_LEGGINGS.get(), ATMItems.VIBRANIUM_BOOTS.get(),
                        ATMItems.UNOBTAINIUM_HELMET.get(), ATMItems.UNOBTAINIUM_CHESTPLATE.get(), ATMItems.UNOBTAINIUM_LEGGINGS.get(), ATMItems.UNOBTAINIUM_BOOTS.get(),
                        ATMItems.ALLTHEMODIUM_SWORD.get(), ATMItems.ALLTHEMODIUM_PICKAXE.get(), ATMItems.ALLTHEMODIUM_AXE.get(), ATMItems.ALLTHEMODIUM_SHOVEL.get(), ATMItems.ALLTHEMODIUM_HOE.get(), ATMItems.ALLTHEMODIUM_MACE.get(), ATMItems.ALLTHEMODIUM_BOW.get(),
                        ATMItems.VIBRANIUM_SWORD.get(), ATMItems.VIBRANIUM_PICKAXE.get(), ATMItems.VIBRANIUM_AXE.get(), ATMItems.VIBRANIUM_SHOVEL.get(), ATMItems.VIBRANIUM_HOE.get(), ATMItems.VIBRANIUM_MACE.get(), ATMItems.VIBRANIUM_SHIELD.get(),
                        ATMItems.UNOBTAINIUM_SWORD.get(), ATMItems.UNOBTAINIUM_PICKAXE.get(), ATMItems.UNOBTAINIUM_AXE.get(), ATMItems.UNOBTAINIUM_SHOVEL.get(), ATMItems.UNOBTAINIUM_HOE.get(), ATMItems.UNOBTAINIUM_MACE.get(), ATMItems.UNOBTAINIUM_CROSSBOW.get(),
                        ATMItems.ALLOY_SWORD.get(), ATMItems.ALLOY_PICKAXE.get(), ATMItems.ALLOY_AXE.get(), ATMItems.ALLOY_SHOVEL.get(), ATMItems.ALLOY_PAXEL.get(), ATMItems.ALLOY_MACE.get(), ATMItems.ALLOY_TRIDENT.get()
                );
        this.tag(ItemTags.VANISHING_ENCHANTABLE)
                .add(ATMItems.ALLTHEMODIUM_HELMET.get(), ATMItems.ALLTHEMODIUM_CHESTPLATE.get(), ATMItems.ALLTHEMODIUM_LEGGINGS.get(), ATMItems.ALLTHEMODIUM_BOOTS.get(),
                        ATMItems.VIBRANIUM_HELMET.get(), ATMItems.VIBRANIUM_CHESTPLATE.get(), ATMItems.VIBRANIUM_LEGGINGS.get(), ATMItems.VIBRANIUM_BOOTS.get(),
                        ATMItems.UNOBTAINIUM_HELMET.get(), ATMItems.UNOBTAINIUM_CHESTPLATE.get(), ATMItems.UNOBTAINIUM_LEGGINGS.get(), ATMItems.UNOBTAINIUM_BOOTS.get(),
                        ATMItems.ALLTHEMODIUM_SWORD.get(), ATMItems.ALLTHEMODIUM_PICKAXE.get(), ATMItems.ALLTHEMODIUM_AXE.get(), ATMItems.ALLTHEMODIUM_SHOVEL.get(), ATMItems.ALLTHEMODIUM_HOE.get(), ATMItems.ALLTHEMODIUM_MACE.get(), ATMItems.ALLTHEMODIUM_BOW.get(),
                        ATMItems.VIBRANIUM_SWORD.get(), ATMItems.VIBRANIUM_PICKAXE.get(), ATMItems.VIBRANIUM_AXE.get(), ATMItems.VIBRANIUM_SHOVEL.get(), ATMItems.VIBRANIUM_HOE.get(), ATMItems.VIBRANIUM_MACE.get(), ATMItems.VIBRANIUM_SHIELD.get(),
                        ATMItems.UNOBTAINIUM_SWORD.get(), ATMItems.UNOBTAINIUM_PICKAXE.get(), ATMItems.UNOBTAINIUM_AXE.get(), ATMItems.UNOBTAINIUM_SHOVEL.get(), ATMItems.UNOBTAINIUM_HOE.get(), ATMItems.UNOBTAINIUM_MACE.get(), ATMItems.UNOBTAINIUM_CROSSBOW.get(),
                        ATMItems.ALLOY_SWORD.get(), ATMItems.ALLOY_PICKAXE.get(), ATMItems.ALLOY_AXE.get(), ATMItems.ALLOY_SHOVEL.get(), ATMItems.ALLOY_PAXEL.get(), ATMItems.ALLOY_MACE.get(), ATMItems.ALLOY_TRIDENT.get()
                );
        
        this.tag(ItemTags.SWORDS).add(ATMItems.ALLTHEMODIUM_SWORD.get(), ATMItems.VIBRANIUM_SWORD.get(), ATMItems.UNOBTAINIUM_SWORD.get(), ATMItems.ALLOY_SWORD.get()).add(ATMItems.ALLOY_PAXEL.get());
        this.tag(ItemTags.AXES)
                .add(ATMItems.ALLTHEMODIUM_AXE.get(), ATMItems.VIBRANIUM_AXE.get(), ATMItems.UNOBTAINIUM_AXE.get(), ATMItems.ALLOY_AXE.get())
                .add(ATMItems.ALLOY_PAXEL.get());
        this.tag(ItemTags.PICKAXES)
                .add(ATMItems.ALLTHEMODIUM_PICKAXE.get(), ATMItems.VIBRANIUM_PICKAXE.get(), ATMItems.UNOBTAINIUM_PICKAXE.get(), ATMItems.ALLOY_PICKAXE.get())
                .add(ATMItems.ALLOY_PAXEL.get());
        this.tag(ItemTags.SHOVELS)
                .add(ATMItems.ALLTHEMODIUM_SHOVEL.get(), ATMItems.VIBRANIUM_SHOVEL.get(), ATMItems.UNOBTAINIUM_SHOVEL.get(), ATMItems.ALLOY_SHOVEL.get())
                .add(ATMItems.ALLOY_PAXEL.get());
        this.tag(ItemTags.HOES)
                .add(ATMItems.ALLTHEMODIUM_HOE.get(), ATMItems.VIBRANIUM_HOE.get(), ATMItems.UNOBTAINIUM_HOE.get())
                .add(ATMItems.ALLOY_PAXEL.get());
        this.tag(ItemTags.MACE_ENCHANTABLE)
                .add(ATMItems.ALLTHEMODIUM_MACE.get(), ATMItems.VIBRANIUM_MACE.get(), ATMItems.UNOBTAINIUM_MACE.get(), ATMItems.ALLOY_MACE.get());
        this.tag(ItemTags.BREAKS_DECORATED_POTS)
                .add(ATMItems.ALLTHEMODIUM_MACE.get(), ATMItems.VIBRANIUM_MACE.get(), ATMItems.UNOBTAINIUM_MACE.get(), ATMItems.ALLOY_MACE.get());
        
        this.tag(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .add(ATMItems.ALLTHEMODIUM_SWORD.get(), ATMItems.VIBRANIUM_SWORD.get(), ATMItems.UNOBTAINIUM_SWORD.get(), ATMItems.ALLOY_SWORD.get())
                .add(ATMItems.ALLTHEMODIUM_AXE.get(), ATMItems.VIBRANIUM_AXE.get(), ATMItems.UNOBTAINIUM_AXE.get(), ATMItems.ALLOY_AXE.get())
                .add(ATMItems.ALLOY_PAXEL.get());
        this.tag(ItemTags.WEAPON_ENCHANTABLE)
                .add(ATMItems.ALLTHEMODIUM_SWORD.get(), ATMItems.VIBRANIUM_SWORD.get(), ATMItems.UNOBTAINIUM_SWORD.get(), ATMItems.ALLOY_SWORD.get())
                .add(ATMItems.ALLTHEMODIUM_AXE.get(), ATMItems.VIBRANIUM_AXE.get(), ATMItems.UNOBTAINIUM_AXE.get(), ATMItems.ALLOY_AXE.get())
                .add(ATMItems.ALLTHEMODIUM_MACE.get(), ATMItems.VIBRANIUM_MACE.get(), ATMItems.UNOBTAINIUM_MACE.get(), ATMItems.ALLOY_MACE.get())
                .add(ATMItems.ALLOY_PAXEL.get());
        this.tag(ItemTags.FIRE_ASPECT_ENCHANTABLE)
                .add(ATMItems.ALLTHEMODIUM_SWORD.get(), ATMItems.VIBRANIUM_SWORD.get(), ATMItems.UNOBTAINIUM_SWORD.get(), ATMItems.ALLOY_SWORD.get())
                .add(ATMItems.ALLTHEMODIUM_AXE.get(), ATMItems.VIBRANIUM_AXE.get(), ATMItems.UNOBTAINIUM_AXE.get(), ATMItems.ALLOY_AXE.get())
                .add(ATMItems.ALLTHEMODIUM_MACE.get(), ATMItems.VIBRANIUM_MACE.get(), ATMItems.UNOBTAINIUM_MACE.get(), ATMItems.ALLOY_MACE.get())
                .add(ATMItems.ALLOY_PAXEL.get());
        this.tag(ItemTags.MINING_ENCHANTABLE)
                .add(
                        ATMItems.ALLTHEMODIUM_PICKAXE.get(), ATMItems.VIBRANIUM_PICKAXE.get(), ATMItems.UNOBTAINIUM_PICKAXE.get(), ATMItems.ALLOY_PICKAXE.get(),
                        ATMItems.ALLTHEMODIUM_AXE.get(), ATMItems.VIBRANIUM_AXE.get(), ATMItems.UNOBTAINIUM_AXE.get(), ATMItems.ALLOY_AXE.get(),
                        ATMItems.ALLTHEMODIUM_SHOVEL.get(), ATMItems.VIBRANIUM_SHOVEL.get(), ATMItems.UNOBTAINIUM_SHOVEL.get(), ATMItems.ALLOY_SHOVEL.get(),
                        ATMItems.ALLTHEMODIUM_HOE.get(), ATMItems.VIBRANIUM_HOE.get(), ATMItems.UNOBTAINIUM_HOE.get(),
                        ATMItems.ALLOY_PAXEL.get()
                );
        this.tag(ItemTags.MINING_LOOT_ENCHANTABLE)
                .add(
                        ATMItems.ALLTHEMODIUM_PICKAXE.get(), ATMItems.VIBRANIUM_PICKAXE.get(), ATMItems.UNOBTAINIUM_PICKAXE.get(), ATMItems.ALLOY_PICKAXE.get(),
                        ATMItems.ALLTHEMODIUM_AXE.get(), ATMItems.VIBRANIUM_AXE.get(), ATMItems.UNOBTAINIUM_AXE.get(), ATMItems.ALLOY_AXE.get(),
                        ATMItems.ALLTHEMODIUM_SHOVEL.get(), ATMItems.VIBRANIUM_SHOVEL.get(), ATMItems.UNOBTAINIUM_SHOVEL.get(), ATMItems.ALLOY_SHOVEL.get(),
                        ATMItems.ALLTHEMODIUM_HOE.get(), ATMItems.VIBRANIUM_HOE.get(), ATMItems.UNOBTAINIUM_HOE.get(),
                        ATMItems.ALLOY_PAXEL.get()
                );
        this.tag(ItemTags.BOW_ENCHANTABLE).add(ATMItems.ALLTHEMODIUM_BOW.get());
        this.tag(ItemTags.CROSSBOW_ENCHANTABLE).add(ATMItems.UNOBTAINIUM_CROSSBOW.get());
        this.tag(ItemTags.TRIDENT_ENCHANTABLE).add(ATMItems.ALLOY_TRIDENT.get());
        
        this.tag(Tags.Items.TOOLS)
                .add(
                        ATMItems.ALLTHEMODIUM_PICKAXE.get(), ATMItems.VIBRANIUM_PICKAXE.get(), ATMItems.UNOBTAINIUM_PICKAXE.get(), ATMItems.ALLOY_PICKAXE.get(),
                        ATMItems.ALLTHEMODIUM_AXE.get(), ATMItems.VIBRANIUM_AXE.get(), ATMItems.UNOBTAINIUM_AXE.get(), ATMItems.ALLOY_AXE.get(),
                        ATMItems.ALLTHEMODIUM_SHOVEL.get(), ATMItems.VIBRANIUM_SHOVEL.get(), ATMItems.UNOBTAINIUM_SHOVEL.get(), ATMItems.ALLOY_SHOVEL.get(),
                        ATMItems.ALLTHEMODIUM_HOE.get(), ATMItems.VIBRANIUM_HOE.get(), ATMItems.UNOBTAINIUM_HOE.get(),
                        ATMItems.ALLOY_PAXEL.get()
                )
                .add(ATMItems.ALLTHEMODIUM_SWORD.get(), ATMItems.VIBRANIUM_SWORD.get(), ATMItems.UNOBTAINIUM_SWORD.get(), ATMItems.ALLOY_SWORD.get())
                .add(ATMItems.ALLTHEMODIUM_MACE.get(), ATMItems.VIBRANIUM_MACE.get(), ATMItems.UNOBTAINIUM_MACE.get(), ATMItems.ALLOY_MACE.get())
                .add(ATMItems.ALLTHEMODIUM_BOW.get(), ATMItems.VIBRANIUM_SHIELD.get(), ATMItems.UNOBTAINIUM_CROSSBOW.get(), ATMItems.ALLOY_TRIDENT.get());
        this.tag(Tags.Items.TOOLS_MACE).add(ATMItems.ALLTHEMODIUM_MACE.get(), ATMItems.VIBRANIUM_MACE.get(), ATMItems.UNOBTAINIUM_MACE.get(), ATMItems.ALLOY_MACE.get());
        this.tag(Tags.Items.TOOLS_BOW).add(ATMItems.ALLTHEMODIUM_BOW.get());
        this.tag(Tags.Items.TOOLS_CROSSBOW).add(ATMItems.UNOBTAINIUM_CROSSBOW.get());
        this.tag(Tags.Items.TOOLS_SHIELD).add(ATMItems.VIBRANIUM_SHIELD.get());
        this.tag(Tags.Items.MELEE_WEAPON_TOOLS)
                .add(ATMItems.ALLTHEMODIUM_SWORD.get(), ATMItems.VIBRANIUM_SWORD.get(), ATMItems.UNOBTAINIUM_SWORD.get(), ATMItems.ALLOY_SWORD.get())
                .add(ATMItems.ALLTHEMODIUM_AXE.get(), ATMItems.VIBRANIUM_AXE.get(), ATMItems.UNOBTAINIUM_AXE.get(), ATMItems.ALLOY_AXE.get())
                .add(ATMItems.ALLTHEMODIUM_MACE.get(), ATMItems.VIBRANIUM_MACE.get(), ATMItems.UNOBTAINIUM_MACE.get(), ATMItems.ALLOY_MACE.get())
                .add(ATMItems.ALLOY_PAXEL.get());
        this.tag(Tags.Items.RANGED_WEAPON_TOOLS).add(ATMItems.ALLTHEMODIUM_BOW.get(), ATMItems.UNOBTAINIUM_CROSSBOW.get());
        this.tag(Tags.Items.MINING_TOOL_TOOLS)
                .add(
                        ATMItems.ALLTHEMODIUM_PICKAXE.get(), ATMItems.VIBRANIUM_PICKAXE.get(), ATMItems.UNOBTAINIUM_PICKAXE.get(), ATMItems.ALLOY_PICKAXE.get(),
                        ATMItems.ALLTHEMODIUM_AXE.get(), ATMItems.VIBRANIUM_AXE.get(), ATMItems.UNOBTAINIUM_AXE.get(), ATMItems.ALLOY_AXE.get(),
                        ATMItems.ALLTHEMODIUM_SHOVEL.get(), ATMItems.VIBRANIUM_SHOVEL.get(), ATMItems.UNOBTAINIUM_SHOVEL.get(), ATMItems.ALLOY_SHOVEL.get(),
                        ATMItems.ALLTHEMODIUM_HOE.get(), ATMItems.VIBRANIUM_HOE.get(), ATMItems.UNOBTAINIUM_HOE.get(),
                        ATMItems.ALLOY_PAXEL.get()
                );
        this.tag(Tags.Items.ENCHANTABLES).add(
                ATMItems.ALLTHEMODIUM_HELMET.get(), ATMItems.ALLTHEMODIUM_CHESTPLATE.get(), ATMItems.ALLTHEMODIUM_LEGGINGS.get(), ATMItems.ALLTHEMODIUM_BOOTS.get(),
                ATMItems.VIBRANIUM_HELMET.get(), ATMItems.VIBRANIUM_CHESTPLATE.get(), ATMItems.VIBRANIUM_LEGGINGS.get(), ATMItems.VIBRANIUM_BOOTS.get(),
                ATMItems.UNOBTAINIUM_HELMET.get(), ATMItems.UNOBTAINIUM_CHESTPLATE.get(), ATMItems.UNOBTAINIUM_LEGGINGS.get(), ATMItems.UNOBTAINIUM_BOOTS.get(),
                ATMItems.ALLTHEMODIUM_SWORD.get(), ATMItems.ALLTHEMODIUM_PICKAXE.get(), ATMItems.ALLTHEMODIUM_AXE.get(), ATMItems.ALLTHEMODIUM_SHOVEL.get(), ATMItems.ALLTHEMODIUM_HOE.get(), ATMItems.ALLTHEMODIUM_MACE.get(), ATMItems.ALLTHEMODIUM_BOW.get(),
                ATMItems.VIBRANIUM_SWORD.get(), ATMItems.VIBRANIUM_PICKAXE.get(), ATMItems.VIBRANIUM_AXE.get(), ATMItems.VIBRANIUM_SHOVEL.get(), ATMItems.VIBRANIUM_HOE.get(), ATMItems.VIBRANIUM_MACE.get(), ATMItems.VIBRANIUM_SHIELD.get(),
                ATMItems.UNOBTAINIUM_SWORD.get(), ATMItems.UNOBTAINIUM_PICKAXE.get(), ATMItems.UNOBTAINIUM_AXE.get(), ATMItems.UNOBTAINIUM_SHOVEL.get(), ATMItems.UNOBTAINIUM_HOE.get(), ATMItems.UNOBTAINIUM_MACE.get(), ATMItems.UNOBTAINIUM_CROSSBOW.get(),
                ATMItems.ALLOY_SWORD.get(), ATMItems.ALLOY_PICKAXE.get(), ATMItems.ALLOY_AXE.get(), ATMItems.ALLOY_SHOVEL.get(), ATMItems.ALLOY_PAXEL.get(), ATMItems.ALLOY_MACE.get(), ATMItems.ALLOY_TRIDENT.get()
        );
        
        this.tag(ItemTags.CLUSTER_MAX_HARVESTABLES)
                .add(ATMItems.ALLTHEMODIUM_PICKAXE.get(), ATMItems.VIBRANIUM_PICKAXE.get(), ATMItems.UNOBTAINIUM_PICKAXE.get(), ATMItems.ALLOY_PICKAXE.get())
                .add(ATMItems.ALLOY_PAXEL.get());
        
        this.tag(ItemTags.TRIM_MATERIALS).add(ATMItems.ALLTHEMODIUM_INGOT.get(), ATMItems.VIBRANIUM_INGOT.get(), ATMItems.UNOBTAINIUM_INGOT.get());
        this.tag(ItemTags.BEACON_PAYMENT_ITEMS).add(ATMItems.ALLTHEMODIUM_INGOT.get(), ATMItems.VIBRANIUM_INGOT.get(), ATMItems.UNOBTAINIUM_INGOT.get());
        
        this.tag(ItemTags.PIGLIN_LOVED)
                .add(
                        ATMItems.ALLTHEMODIUM_HELMET.get(),
                        ATMItems.ALLTHEMODIUM_CHESTPLATE.get(),
                        ATMItems.ALLTHEMODIUM_LEGGINGS.get(),
                        ATMItems.ALLTHEMODIUM_BOOTS.get()
                );
        
        this.tag(ATMTags.Items.RAW_MATERIALS_ALLTHEMODIUM).add(ATMItems.RAW_ALLTHEMODIUM.get());
        this.tag(ATMTags.Items.RAW_MATERIALS_VIBRANIUM).add(ATMItems.RAW_VIBRANIUM.get());
        this.tag(ATMTags.Items.RAW_MATERIALS_UNOBTAINIUM).add(ATMItems.RAW_UNOBTAINIUM.get());
        this.tag(Tags.Items.RAW_MATERIALS).add(ATMItems.RAW_ALLTHEMODIUM.get(), ATMItems.RAW_VIBRANIUM.get(), ATMItems.RAW_UNOBTAINIUM.get());
        
        this.tag(ATMTags.Items.NUGGETS_ALLTHEMODIUM).add(ATMItems.ALLTHEMODIUM_NUGGET.get());
        this.tag(ATMTags.Items.NUGGETS_VIBRANIUM).add(ATMItems.VIBRANIUM_NUGGET.get());
        this.tag(ATMTags.Items.NUGGETS_UNOBTAINIUM).add(ATMItems.UNOBTAINIUM_NUGGET.get());
        this.tag(Tags.Items.NUGGETS).add(ATMItems.ALLTHEMODIUM_NUGGET.get(), ATMItems.VIBRANIUM_NUGGET.get(), ATMItems.UNOBTAINIUM_NUGGET.get());
        
        this.tag(ATMTags.Items.INGOTS_ALLTHEMODIUM).add(ATMItems.ALLTHEMODIUM_INGOT.get());
        this.tag(ATMTags.Items.INGOTS_VIBRANIUM).add(ATMItems.VIBRANIUM_INGOT.get());
        this.tag(ATMTags.Items.INGOTS_UNOBTAINIUM).add(ATMItems.UNOBTAINIUM_INGOT.get());
        this.tag(ATMTags.Items.INGOTS_ALLOYS).add(ATMItems.VIBRANIUM_ALLTHEMODIUM_ALLOY.get(), ATMItems.UNOBTAINIUM_ALLTHEMODIUM_ALLOY.get(), ATMItems.UNOBTAINIUM_VIBRANIUM_ALLOY.get());
        this.tag(ATMTags.Items.INGOTS_VIBRANIUM_ALLTHEMODIUM_ALLOY).add(ATMItems.VIBRANIUM_ALLTHEMODIUM_ALLOY.get());
        this.tag(ATMTags.Items.INGOTS_UNOBTAINIUM_ALLTHEMODIUM_ALLOY).add(ATMItems.UNOBTAINIUM_ALLTHEMODIUM_ALLOY.get());
        this.tag(ATMTags.Items.INGOTS_UNOBTAINIUM_VIBRANIUM_ALLOY).add(ATMItems.UNOBTAINIUM_VIBRANIUM_ALLOY.get());
        this.tag(Tags.Items.INGOTS)
                .add(
                        ATMItems.ALLTHEMODIUM_INGOT.get(),
                        ATMItems.VIBRANIUM_INGOT.get(),
                        ATMItems.UNOBTAINIUM_INGOT.get(),
                        ATMItems.VIBRANIUM_ALLTHEMODIUM_ALLOY.get(),
                        ATMItems.UNOBTAINIUM_ALLTHEMODIUM_ALLOY.get(),
                        ATMItems.UNOBTAINIUM_VIBRANIUM_ALLOY.get()
                );
        
        this.tag(ATMTags.Items.DUSTS_ALLTHEMODIUM).add(ATMItems.ALLTHEMODIUM_DUST.get());
        this.tag(ATMTags.Items.DUSTS_VIBRANIUM).add(ATMItems.VIBRANIUM_DUST.get());
        this.tag(ATMTags.Items.DUSTS_UNOBTAINIUM).add(ATMItems.UNOBTAINIUM_DUST.get());
        this.tag(ATMTags.Items.DUSTS_VIBRANIUM_ALLTHEMODIUM_ALLOY).add(ATMItems.VIBRANIUM_ALLTHEMODIUM_DUST.get());
        this.tag(ATMTags.Items.DUSTS_UNOBTAINIUM_ALLTHEMODIUM_ALLOY).add(ATMItems.UNOBTAINIUM_ALLTHEMODIUM_DUST.get());
        this.tag(ATMTags.Items.DUSTS_UNOBTAINIUM_VIBRANIUM_ALLOY).add(ATMItems.UNOBTAINIUM_VIBRANIUM_DUST.get());
        this.tag(Tags.Items.DUSTS)
                .add(
                        ATMItems.ALLTHEMODIUM_DUST.get(),
                        ATMItems.VIBRANIUM_DUST.get(),
                        ATMItems.UNOBTAINIUM_DUST.get(),
                        ATMItems.VIBRANIUM_ALLTHEMODIUM_DUST.get(),
                        ATMItems.UNOBTAINIUM_ALLTHEMODIUM_DUST.get(),
                        ATMItems.UNOBTAINIUM_VIBRANIUM_DUST.get()
                );
        
        this.tag(ATMTags.Items.PLATES).add(ATMItems.ALLTHEMODIUM_PLATE.get(), ATMItems.VIBRANIUM_PLATE.get(), ATMItems.UNOBTAINIUM_PLATE.get());
        this.tag(ATMTags.Items.PLATES_ALLTHEMODIUM).add(ATMItems.ALLTHEMODIUM_PLATE.get());
        this.tag(ATMTags.Items.PLATES_VIBRANIUM).add(ATMItems.VIBRANIUM_PLATE.get());
        this.tag(ATMTags.Items.PLATES_UNOBTAINIUM).add(ATMItems.UNOBTAINIUM_PLATE.get());
        
        this.tag(ATMTags.Items.GEARS).add(ATMItems.ALLTHEMODIUM_GEAR.get(), ATMItems.VIBRANIUM_GEAR.get(), ATMItems.UNOBTAINIUM_GEAR.get());
        this.tag(ATMTags.Items.GEARS_ALLTHEMODIUM).add(ATMItems.ALLTHEMODIUM_GEAR.get());
        this.tag(ATMTags.Items.GEARS_VIBRANIUM).add(ATMItems.VIBRANIUM_GEAR.get());
        this.tag(ATMTags.Items.GEARS_UNOBTAINIUM).add(ATMItems.UNOBTAINIUM_GEAR.get());
        
        this.tag(ATMTags.Items.RODS_ALLTHEMODIUM).add(ATMItems.ALLTHEMODIUM_ROD.get());
        this.tag(ATMTags.Items.RODS_VIBRANIUM).add(ATMItems.VIBRANIUM_ROD.get());
        this.tag(ATMTags.Items.RODS_UNOBTAINIUM).add(ATMItems.UNOBTAINIUM_ROD.get());
        this.tag(Tags.Items.RODS).add(ATMItems.ALLTHEMODIUM_ROD.get(), ATMItems.VIBRANIUM_ROD.get(), ATMItems.UNOBTAINIUM_ROD.get());
        
        this.tag(Tags.Items.ORES)
                .add(
                        ATMBlocks.ALLTHEMODIUM_ORE.get().asItem(),
                        ATMBlocks.DEEPSLATE_ALLTHEMODIUM_ORE.get().asItem(),
                        ATMBlocks.VIBRANIUM_ORE.get().asItem(),
                        ATMBlocks.OTHER_VIBRANIUM_ORE.get().asItem(),
                        ATMBlocks.UNOBTAINIUM_ORE.get().asItem()
                );
        this.tag(ATMTags.Items.ORES_ALLTHEMODIUM).add(ATMBlocks.ALLTHEMODIUM_ORE.get().asItem(), ATMBlocks.DEEPSLATE_ALLTHEMODIUM_ORE.get().asItem());
        this.tag(ATMTags.Items.ORES_VIBRANIUM).add(ATMBlocks.VIBRANIUM_ORE.get().asItem(), ATMBlocks.OTHER_VIBRANIUM_ORE.get().asItem());
        this.tag(ATMTags.Items.ORES_UNOBTAINIUM).add(ATMBlocks.UNOBTAINIUM_ORE.get().asItem());
        this.tag(Tags.Items.ORES_IN_GROUND_STONE).add(ATMBlocks.ALLTHEMODIUM_ORE.get().asItem());
        this.tag(Tags.Items.ORES_IN_GROUND_DEEPSLATE).add(ATMBlocks.DEEPSLATE_ALLTHEMODIUM_ORE.get().asItem());
        this.tag(Tags.Items.ORES_IN_GROUND_NETHERRACK).add(ATMBlocks.VIBRANIUM_ORE.get().asItem());
        this.tag(ATMTags.Items.ORES_IN_GROUND_ANCIENT_STONE).add(ATMBlocks.OTHER_VIBRANIUM_ORE.get().asItem());
        this.tag(ATMTags.Items.ORES_IN_GROUND_END_STONE).add(ATMBlocks.UNOBTAINIUM_ORE.get().asItem());
        
        this.tag(Tags.Items.STONES).add(ATMBlocks.ANCIENT_STONE.get().asItem());
        this.tag(ItemTags.STONE_CRAFTING_MATERIALS).add(ATMBlocks.ANCIENT_STONE.get().asItem());
        this.tag(ItemTags.STONE_TOOL_MATERIALS).add(ATMBlocks.ANCIENT_STONE.get().asItem());
        
        this.tag(Tags.Items.STORAGE_BLOCKS)
                .add(
                        ATMBlocks.PIGLICH_HEART_BLOCK.get().asItem(),
                        ATMBlocks.ALLTHEMODIUM_BLOCK.get().asItem(),
                        ATMBlocks.VIBRANIUM_BLOCK.get().asItem(),
                        ATMBlocks.UNOBTAINIUM_BLOCK.get().asItem(),
                        ATMBlocks.RAW_ALLTHEMODIUM_BLOCK.get().asItem(),
                        ATMBlocks.RAW_VIBRANIUM_BLOCK.get().asItem(),
                        ATMBlocks.RAW_UNOBTAINIUM_BLOCK.get().asItem(),
                        ATMBlocks.VIBRANIUM_ALLTHEMODIUM_BLOCK.get().asItem(),
                        ATMBlocks.UNOBTAINIUM_ALLTHEMODIUM_BLOCK.get().asItem(),
                        ATMBlocks.UNOBTAINIUM_VIBRANIUM_BLOCK.get().asItem()
                );
        this.tag(ATMTags.Items.STORAGE_BLOCKS_ALLTHEMODIUM).add(ATMBlocks.ALLTHEMODIUM_BLOCK.get().asItem());
        this.tag(ATMTags.Items.STORAGE_BLOCKS_VIBRANIUM).add(ATMBlocks.VIBRANIUM_BLOCK.get().asItem());
        this.tag(ATMTags.Items.STORAGE_BLOCKS_UNOBTAINIUM).add(ATMBlocks.UNOBTAINIUM_BLOCK.get().asItem());
        this.tag(ATMTags.Items.STORAGE_BLOCKS_RAW_ALLTHEMODIUM).add(ATMBlocks.RAW_ALLTHEMODIUM_BLOCK.get().asItem());
        this.tag(ATMTags.Items.STORAGE_BLOCKS_RAW_VIBRANIUM).add(ATMBlocks.RAW_VIBRANIUM_BLOCK.get().asItem());
        this.tag(ATMTags.Items.STORAGE_BLOCKS_RAW_UNOBTAINIUM).add(ATMBlocks.RAW_UNOBTAINIUM_BLOCK.get().asItem());
        this.tag(ATMTags.Items.STORAGE_BLOCKS_VIBRANIUM_ALLTHEMODIUM_ALLOY).add(ATMBlocks.VIBRANIUM_ALLTHEMODIUM_BLOCK.get().asItem());
        this.tag(ATMTags.Items.STORAGE_BLOCKS_UNOBTAINIUM_ALLTHEMODIUM_ALLOY).add(ATMBlocks.UNOBTAINIUM_ALLTHEMODIUM_BLOCK.get().asItem());
        this.tag(ATMTags.Items.STORAGE_BLOCKS_UNOBTAINIUM_VIBRANIUM_ALLOY).add(ATMBlocks.UNOBTAINIUM_VIBRANIUM_BLOCK.get().asItem());
        
        this.tag(ATMTags.Items.ATM_FOODS).add(ATMItems.ALLTHEMODIUM_APPLE.get(), ATMItems.ALLTHEMODIUM_CARROT.get());
        this.tag(Tags.Items.FOODS).addTag(ATMTags.Items.ATM_FOODS).add(ATMItems.SOUL_BERRIES.get());
        this.tag(Tags.Items.FOODS_FRUIT).add(ATMItems.ALLTHEMODIUM_APPLE.get(), ATMItems.SOUL_BERRIES.get());
        this.tag(Tags.Items.FOODS_VEGETABLE).add(ATMItems.ALLTHEMODIUM_CARROT.get());
        this.tag(Tags.Items.FOODS_BERRY).add(ATMItems.SOUL_BERRIES.get());
        
        this.tag(Tags.Items.BOOKSHELVES)
                .add(
                        ATMBlocks.ANCIENT_BOOKSHELF.get().asItem(),
                        ATMBlocks.SOUL_BOOKSHELF.get().asItem(),
                        ATMBlocks.DEMONIC_BOOKSHELF.get().asItem()
                );
        this.tag(Tags.Items.BUCKETS)
                .add(
                        ATMFluids.SOUL_LAVA_BUCKET.get(),
                        ATMFluids.MOLTEN_ALLTHEMODIUM_BUCKET.get(),
                        ATMFluids.MOLTEN_VIBRANIUM_BUCKET.get(),
                        ATMFluids.MOLTEN_UNOBTAINIUM_BUCKET.get()
                );
    }
    
}
