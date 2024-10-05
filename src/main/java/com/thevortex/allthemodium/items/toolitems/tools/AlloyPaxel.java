package com.thevortex.allthemodium.items.toolitems.tools;

import com.thevortex.allthemodium.material.ToolTiers;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.commands.CommandSource;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.server.command.TextComponentHelper;

public class AlloyPaxel extends DiggerItem {

    public static Map<Block, Block> STRIPPABLES = AxeItem.STRIPPABLES;

    public AlloyPaxel(
            float attack,
            float speed,
            Tier tier,
            TagKey<Block> effectiveBlocks,
            Properties properties) {
        super(attack, speed, tier, effectiveBlocks, properties);
    }

    @Override
    public float getDestroySpeed(
            @Nonnull ItemStack stack,
            @Nonnull BlockState state) {
        if (state.is(BlockTags.MINEABLE_WITH_PICKAXE))
            return speed * 1.4f;
        if (state.is(BlockTags.MINEABLE_WITH_SHOVEL))
            return speed * 1.8f;
        if (state.is(BlockTags.MINEABLE_WITH_AXE))
            return speed * 1.8f;
        if (state.is(BlockTags.MINEABLE_WITH_HOE))
            return speed * 1.9f;
        if (state.is(Tags.Blocks.GLASS))
            return speed * 3.0F;
        return super.getDestroySpeed(stack, state);
    }

    @Override
    public net.minecraft.world.InteractionResult interactLivingEntity(
            @Nonnull ItemStack stack,
            @Nonnull net.minecraft.world.entity.player.Player playerIn,
            @Nonnull LivingEntity entity,
            @Nonnull net.minecraft.world.InteractionHand hand) {
        if (entity instanceof net.minecraftforge.common.IForgeShearable target) {
            if (entity.level.isClientSide)
                return net.minecraft.world.InteractionResult.SUCCESS;
            BlockPos pos = new BlockPos(
                    entity.getX(),
                    entity.getY(),
                    entity.getZ());
            if (target.isShearable(stack, entity.level, pos)) {
                @SuppressWarnings("deprecation")
                java.util.List<ItemStack> drops = target.onSheared(
                        playerIn,
                        stack,
                        entity.level,
                        pos,
                        net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(
                                net.minecraft.world.item.enchantment.Enchantments.BLOCK_FORTUNE,
                                stack));
                java.util.Random rand = new java.util.Random();
                drops.forEach(d -> {
                    net.minecraft.world.entity.item.ItemEntity dropEntity = entity.spawnAtLocation(d, 1.0F);
                    if (dropEntity == null)
                        return;

                    dropEntity.setDeltaMovement(
                            dropEntity
                                    .getDeltaMovement()
                                    .add(
                                            (double) ((rand.nextFloat() -
                                                    rand.nextFloat()) *
                                                    0.1F),
                                            (double) (rand.nextFloat() * 0.05F),
                                            (double) ((rand.nextFloat() -
                                                    rand.nextFloat()) *
                                                    0.1F)));
                });
                stack.hurtAndBreak(
                        1,
                        playerIn,
                        e -> e.broadcastBreakEvent(hand));
            }
            return net.minecraft.world.InteractionResult.SUCCESS;
        }
        return net.minecraft.world.InteractionResult.PASS;
    }

    @Override
    public boolean canPerformAction(
            ItemStack stack,
            net.minecraftforge.common.ToolAction toolAction) {
        return net.minecraftforge.common.ToolActions.DEFAULT_SHEARS_ACTIONS.contains(
                toolAction);
    }

    @Override
    public boolean hurtEnemy(
            @Nonnull ItemStack stack,
            @Nonnull LivingEntity entity,
            @Nonnull LivingEntity player) {
        // entity.setSecondsOnFire(30);
        return super.hurtEnemy(stack, entity, player);
    }

    @Override
    public InteractionResult useOn(@Nonnull UseOnContext context) {
        Level world = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.getBlock() == Blocks.OBSIDIAN) {
            BlockState defaultBlockState = Blocks.CRYING_OBSIDIAN.defaultBlockState();
            Player playerEntity = context.getPlayer();
            world.playSound(
                    playerEntity,
                    blockPos,
                    SoundEvents.NETHER_ORE_BREAK,
                    SoundSource.BLOCKS,
                    1.0F,
                    1.0F);
            if (!world.isClientSide) {
                world.setBlock(blockPos, defaultBlockState, 11);
                if (playerEntity != null) {
                    context
                            .getItemInHand()
                            .hurtAndBreak(
                                    1,
                                    playerEntity,
                                    p_220040_1_ -> {
                                        p_220040_1_.broadcastBreakEvent(
                                                context.getHand());
                                    });
                }
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        }
        if (blockState.getBlock() instanceof GrowingPlantHeadBlock growingPlantHeadBlock) {
            if (!growingPlantHeadBlock.isMaxAge(blockState)) {
                Player player = context.getPlayer();

                if (player == null)
                    return InteractionResult.PASS;

                ItemStack itemStack = context.getItemInHand();
                if (player instanceof ServerPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(
                            (ServerPlayer) player,
                            blockPos,
                            itemStack);
                }

                world.playSound(
                        player,
                        blockPos,
                        SoundEvents.GROWING_PLANT_CROP,
                        SoundSource.BLOCKS,
                        1.0F,
                        1.0F);
                world.setBlockAndUpdate(
                        blockPos,
                        growingPlantHeadBlock.getMaxAgeState(blockState));
                itemStack.hurtAndBreak(
                        1,
                        player,
                        p_186374_ -> {
                            p_186374_.broadcastBreakEvent(context.getHand());
                        });

                return InteractionResult.sidedSuccess(world.isClientSide);
            }
        }
        if ((blockState.is(BlockTags.DIRT))) {
            Player player = context.getPlayer();
            if (player == null)
                return InteractionResult.PASS;

            // tags dirt
            boolean isSneaking = player.isCrouching();
            BlockState blockPath = isSneaking
                    ? Blocks.FARMLAND.defaultBlockState()
                    : Blocks.DIRT_PATH.defaultBlockState();

            world.playSound(
                    player,
                    blockPos,
                    SoundEvents.SHOVEL_FLATTEN,
                    SoundSource.BLOCKS,
                    1.0F,
                    1.0F);
            if (!world.isClientSide) {
                world.setBlock(blockPos, blockPath, 11);

                context
                        .getItemInHand()
                        .hurtAndBreak(
                                1,
                                player,
                                p_220040_1_ -> {
                                    p_220040_1_.broadcastBreakEvent(context.getHand());
                                });
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        }
        if (blockState.is(BlockTags.LOGS)) {
            // tags logs
            Block check = STRIPPABLES.get(blockState.getBlock());
            if (check != null) {
                BlockState block = check.defaultBlockState();
                Player playerEntity = context.getPlayer();
                world.playSound(
                        playerEntity,
                        blockPos,
                        SoundEvents.AXE_STRIP,
                        SoundSource.BLOCKS,
                        1.0F,
                        1.0F);
                if (!world.isClientSide) {
                    world.setBlock(blockPos, block, 11);
                    if (playerEntity != null) {
                        context
                                .getItemInHand()
                                .hurtAndBreak(
                                        1,
                                        playerEntity,
                                        p_220040_1_ -> {
                                            p_220040_1_.broadcastBreakEvent(
                                                    context.getHand());
                                        });
                    }
                }
                return InteractionResult.sidedSuccess(world.isClientSide);
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public boolean isEnchantable(@Nonnull ItemStack stack) {
        return true;
    }

    @Override
    public boolean canBeDepleted() {
        return false;
    }

    @Override
    public void appendHoverText(
            @Nonnull ItemStack stack,
            @Nullable Level worldIn,
            @Nonnull List<Component> tooltip,
            @Nonnull TooltipFlag flagIn) {
        tooltip.add(
                TextComponentHelper
                        .createComponentTranslation(
                                CommandSource.NULL,
                                "indestructible",
                                new Object())
                        .withStyle(ChatFormatting.GOLD));

        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    protected TranslatableContents getTooltip(String key) {
        return new TranslatableContents(key);
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        if (state.is(BlockTags.MINEABLE_WITH_PICKAXE))
            return TierSortingRegistry.isCorrectTierForDrops(
                    ToolTiers.ALLTHEMODIUM_TIER,
                    state);
        if (state.is(BlockTags.MINEABLE_WITH_HOE))
            return TierSortingRegistry.isCorrectTierForDrops(
                    ToolTiers.ALLTHEMODIUM_TIER,
                    state);
        if (state.is(BlockTags.MINEABLE_WITH_SHOVEL))
            return TierSortingRegistry.isCorrectTierForDrops(
                    ToolTiers.ALLTHEMODIUM_TIER,
                    state);
        if (state.is(BlockTags.MINEABLE_WITH_AXE))
            return TierSortingRegistry.isCorrectTierForDrops(
                    ToolTiers.ALLTHEMODIUM_TIER,
                    state);
        if (state.is(ToolTiers.ALLTHEMODIUM_TOOL_TAG))
            return TierSortingRegistry.isCorrectTierForDrops(
                    ToolTiers.ALLTHEMODIUM_TIER,
                    state);
        return false;
    }
}
