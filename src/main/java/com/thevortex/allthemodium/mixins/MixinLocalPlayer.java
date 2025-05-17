package com.thevortex.allthemodium.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.At;
import com.mojang.authlib.GameProfile;
import com.thevortex.allthemodium.AllTheModium;
import com.thevortex.allthemodium.items.toolitems.armor.Vib_Shield;

import net.minecraft.client.ClientRecipeBook;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.ReceivingLevelScreen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.protocol.game.ServerboundPlayerCommandPacket;
import net.minecraft.stats.StatsCounter;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.PlayerRideableJumping;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Abilities;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Portal;

@Mixin(value = LocalPlayer.class, remap = true)
public class MixinLocalPlayer extends AbstractClientPlayer {

    
    public MixinLocalPlayer(ClientLevel level, GameProfile profile) {
        super(level, profile);
    }




    @Inject(method = "isUsingItem()Z", at = @At("HEAD"), cancellable = true)
    public void isUsingItem(CallbackInfoReturnable<Boolean> cir) {
        LocalPlayer self = (LocalPlayer)(Object)this;
        if ((self.getItemInHand(InteractionHand.OFF_HAND).getItem() instanceof Vib_Shield) && (self.getItemInHand(InteractionHand.MAIN_HAND).getItem().getFoodProperties(self.getItemInHand(InteractionHand.MAIN_HAND),null) == null)) {
            cir.setReturnValue(false);
            cir.cancel();
        }
    }

    @Inject(method = "aiStep()V",  at = @At(
        value = "INVOKE",
        target = "Lnet/minecraft/client/tutorial/Tutorial;onInput(Lnet/minecraft/client/player/Input;)V",
        shift = At.Shift.AFTER
    ), cancellable = true)
    public void aiStep(CallbackInfo ci) {
        LocalPlayer self = (LocalPlayer)(Object)this;
        if ((self.getItemInHand(InteractionHand.OFF_HAND).getItem() instanceof Vib_Shield) && self.isUsingItem()) {
            super.aiStep();
            ci.cancel();
        }
    }


   
}
