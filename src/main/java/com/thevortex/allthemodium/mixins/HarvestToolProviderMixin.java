package com.thevortex.allthemodium.mixins;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import snownee.jade.addon.harvest.HarvestToolProvider;

@Pseudo
@Mixin(HarvestToolProvider.class)
public class HarvestToolProviderMixin {
    @Definition(id = "destroySpeed", local = @Local(type = float.class, name = "destroySpeed"))
    @Expression("destroySpeed < 0.0")
    @ModifyExpressionValue(method = "appendTooltip(Lsnownee/jade/api/ITooltip;Lsnownee/jade/api/BlockAccessor;Lsnownee/jade/api/config/IPluginConfig;)V", at = @At("MIXINEXTRAS:EXPRESSION"), require = 0)
    private boolean skipThisCheck(boolean original){
        return false;
    }
}
