package com.thevortex.allthemodium.mixins;

import com.mojang.authlib.GameProfile;
import com.thevortex.allthemodium.items.toolitems.armor.Vib_Shield;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.InteractionHand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

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
