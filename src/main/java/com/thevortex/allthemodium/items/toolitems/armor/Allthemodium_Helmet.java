package com.thevortex.allthemodium.items.toolitems.armor;

import com.thevortex.allthemodium.init.ModItems;

import com.thevortex.allthemodium.items.toolitems.armor.models.allthemodium_helmet;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.IItemRenderProperties;

import java.util.List;
import java.util.function.Consumer;

public class Allthemodium_Helmet extends ArmorItem {

	public Allthemodium_Helmet(ArmorMaterial materialIn, EquipmentSlot slot, Properties builder) {
		super(materialIn, slot, builder);
		
	}

    @Override
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(new IItemRenderProperties() {
            @Override
            public HumanoidModel<?> getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> _default) {
                return new allthemodium_helmet<LivingEntity>(Minecraft.getInstance().getEntityModels().bakeLayer(allthemodium_helmet.LAYER_LOCATION), armorSlot);
            }
        });
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
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer)
    {
        return true;
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn){
        tooltip.add(this.getTooltip("indestructible").withStyle(ChatFormatting.GOLD));
        tooltip.add(this.getTooltip("piglin.friend").withStyle(ChatFormatting.YELLOW));
        tooltip.add(this.getTooltip("hard.head").withStyle(ChatFormatting.YELLOW));
        tooltip.add(this.getTooltip("aqua.lungs").withStyle(ChatFormatting.DARK_AQUA));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    protected TranslatableComponent getTooltip(String key){
        return new TranslatableComponent(key);
    }
    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if((stack.getItem() == ModItems.ALLTHEMODIUM_HELMET) && (!world.isClientSide)) {

            if(player.isInWater() && player.isSwimming()){

                player.setAirSupply(300);
            }
        }
        super.onArmorTick(stack, world, player);
    }
}
