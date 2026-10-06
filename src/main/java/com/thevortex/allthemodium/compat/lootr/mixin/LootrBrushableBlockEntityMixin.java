package com.thevortex.allthemodium.compat.lootr.mixin;

import com.thevortex.allthemodium.compat.lootr.LootrCompat;
import net.minecraft.world.level.block.entity.BlockEntity;
import noobanidus.mods.lootr.common.api.ILootrType;
import noobanidus.mods.lootr.common.block.entity.LootrBrushableBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Lootr resolves a brushable's type from its sand and gravel tags only, so it gives the ATM variants their own
 * brushable types here instead of letting them fall back to the chest-like 'simple' type.
 */
@Mixin(value = LootrBrushableBlockEntity.class, remap = false)
public class LootrBrushableBlockEntityMixin {

    @Inject(method = "getInfoNewType", at = @At("HEAD"), cancellable = true)
    private void allthemodium$atmBrushableType(CallbackInfoReturnable<ILootrType> cir) {
        if ((Object) this instanceof BlockEntity blockEntity) {
            LootrCompat.lootrType(blockEntity.getBlockState()).ifPresent(cir::setReturnValue);
        }
    }
}
