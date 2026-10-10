package net.allthemods.allthemodium.compat.lootr.mixin;

import net.minecraft.world.level.block.entity.BlockEntity;

import net.allthemods.allthemodium.compat.lootr.LootrCompat;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import noobanidus.mods.lootr.common.api.interfaces.type.ILootrType;
import noobanidus.mods.lootr.common.block.entity.LootrBrushableBlockEntity;

@Mixin(LootrBrushableBlockEntity.class)
public class LootrBrushableBlockEntityMixin {

    @Inject(method = "getDataType", at = @At("HEAD"), cancellable = true)
    private void allthemodium$atmBrushableType(CallbackInfoReturnable<ILootrType> cir) {
        if ((Object) this instanceof BlockEntity blockEntity) {
            LootrCompat.lootrType(blockEntity.getBlockState()).ifPresent(cir::setReturnValue);
        }
    }
}
