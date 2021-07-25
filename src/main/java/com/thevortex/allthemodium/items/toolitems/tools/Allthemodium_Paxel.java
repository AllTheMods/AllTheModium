package com.thevortex.allthemodium.items.toolitems.tools;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import com.thevortex.allthemodium.material.ItemTier;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.Tag;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.property.Properties;

import java.util.Map;
import java.util.Set;

public class Allthemodium_Paxel extends DiggerItem {
    protected final float efficiency = ItemTier.UNOBTAINIUMALLOY.getSpeed();
    private static final Set<Material> EFFECTIVE_ON_MATERIALS = Sets.newHashSet(Material.WOOD, Material.NETHER_WOOD, Material.PLANT, Material.REPLACEABLE_PLANT, Material.BAMBOO, Material.REPLACEABLE_FIREPROOF_PLANT, Material.VEGETABLE, Material.SAND, Material.CLAY, Material.DIRT, Material.STONE, Material.GLASS, Material.WOOL, Material.SNOW, Material.SNOW, Material.ICE, Material.WEB, Material.SHULKER_SHELL, Material.SPONGE, Material.METAL);
    public static final Set<Block> EFFECTIVE_ON_BLOCKS = Sets.newHashSet(Blocks.LADDER, Blocks.SCAFFOLDING, Blocks.OBSIDIAN, Blocks.CRYING_OBSIDIAN, Blocks.GRASS_BLOCK, Blocks.OAK_BUTTON, Blocks.SPRUCE_BUTTON, Blocks.BIRCH_BUTTON, Blocks.JUNGLE_BUTTON, Blocks.DARK_OAK_BUTTON, Blocks.ACACIA_BUTTON, Blocks.CRIMSON_BUTTON, Blocks.WARPED_BUTTON);
    protected static final Map<Block, Block> BLOCK_STRIPPING_MAP = (new ImmutableMap.Builder<Block, Block>()).put(Blocks.OBSIDIAN, Blocks.CRYING_OBSIDIAN).put(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD).put(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG).put(Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD).put(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG).put(Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD).put(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG).put(Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD).put(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG).put(Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD).put(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG).put(Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD).put(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG).put(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM).put(Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE).put(Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM).put(Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE).build();
    protected static final Set<ToolType> toolType = Sets.newHashSet(ToolType.PICKAXE,ToolType.AXE,ToolType.SHOVEL);

    public Allthemodium_Paxel(float attackDamageIn, float attackSpeedIn, Tier tier, Tag<Block> effectiveBlocksIn, Properties builderIn) {
        super(attackDamageIn, attackSpeedIn, tier, effectiveBlocksIn, builderIn);
    }
    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        Material material = state.getMaterial();
        return EFFECTIVE_ON_MATERIALS.contains(material) ? this.efficiency : super.getDestroySpeed(stack, state);
    }


    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = world.getBlockState(blockpos);
        if(blockstate.getBlock() == Blocks.OBSIDIAN) {
            BlockState bpos = Blocks.CRYING_OBSIDIAN.defaultBlockState();
            Player playerentity = context.getPlayer();
            world.playSound(playerentity, blockpos, SoundEvents.NETHER_ORE_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
            if (!world.isClientSide) {
                world.setBlock(blockpos, bpos, 11);
                if (playerentity != null) {
                    context.getItemInHand().hurtAndBreak(1, playerentity, (p_220040_1_) -> {
                        p_220040_1_.broadcastBreakEvent(context.getHand());
                    });
                }
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        }

        if((blockstate.getBlock().getTags().contains(new ResourceLocation("forge","dirt")))) {
            //tags dirt
            BlockState blockPath = Blocks.DIRT_PATH.defaultBlockState();
            if (blockPath != null) {
                Player playerentity = context.getPlayer();
                world.playSound(playerentity, blockpos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (!world.isClientSide) {
                    world.setBlock(blockpos, blockPath, 11);
                    if (playerentity != null) {
                        context.getItemInHand().hurtAndBreak(1, playerentity, (p_220040_1_) -> {
                            p_220040_1_.broadcastBreakEvent(context.getHand());
                        });
                    }
                }

                return InteractionResult.sidedSuccess(world.isClientSide);
            }
        }
        if(blockstate.getBlock().getTags().contains(new ResourceLocation("minecraft","logs"))) {

            //tags logs
            BlockState block = blockstate.getToolModifiedState(world, blockpos, context.getPlayer(), context.getItemInHand(), net.minecraftforge.common.ToolType.AXE);
            if (block != null) {
                Player playerentity = context.getPlayer();
                world.playSound(playerentity, blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (!world.isClientSide) {
                    world.setBlock(blockpos, block, 11);
                    if (playerentity != null) {
                        context.getItemInHand().hurtAndBreak(1, playerentity, (p_220040_1_) -> {
                            p_220040_1_.broadcastBreakEvent(context.getHand());
                        });
                    }
                }
                 return InteractionResult.sidedSuccess(world.isClientSide);
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public Set<ToolType> getToolTypes(ItemStack stack) {

        return toolType;
    }



    @Override
    public int getHarvestLevel(ItemStack stack, ToolType tool, Player player, BlockState blockState) {
        return super.getHarvestLevel(stack, tool, player, blockState);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        if((enchantment.category == EnchantmentCategory.WEAPON) || (enchantment.category == EnchantmentCategory.DIGGER)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) { return true; }

    @Override
    public boolean isShield(ItemStack stack, LivingEntity entity) {
        return true;
    }

    @Override
    public boolean canHarvestBlock(ItemStack stack, BlockState state) {
        return true;
    }
}
