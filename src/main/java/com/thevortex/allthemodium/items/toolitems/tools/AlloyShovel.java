package com.thevortex.allthemodium.items.toolitems.tools;

import com.thevortex.allthemodium.material.ToolTiers;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.server.command.TextComponentHelper;

import java.util.List;

public class AlloyShovel extends ShovelItem {

    public AlloyShovel(Tier tier, int damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }
    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state)
    {
        if (state.is(BlockTags.MINEABLE_WITH_SHOVEL)) return speed;
        return super.getDestroySpeed(stack, state);
    }
    @Override
    public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn){
        tooltip.add(TextComponentHelper.createComponentTranslation(null,"indestructible" , new Object()).withStyle(ChatFormatting.GOLD));

        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }
    @Override
    public boolean canBeDepleted() {
        return false;
    }
    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state)
    {
        if (state.is(BlockTags.MINEABLE_WITH_SHOVEL))
            return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.ALLOY_TIER, state);
        if (state.is(ToolTiers.ALLTHEMODIUM_TOOL_TAG))
            return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.ALLOY_TIER, state);
        return false;
    }
}
