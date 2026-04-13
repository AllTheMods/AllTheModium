package net.allthemods.allthemodium.core.mixin;

import net.minecraft.world.level.levelgen.FlatLevelSource;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.function.Function;

//TODO: Remove me once https://github.com/neoforged/NeoForge/pull/3086 is merged!
@Deprecated(forRemoval = true)
@Mixin(FlatLevelSource.class)
public class FlatLevelSourceMixin {
    
    @Redirect(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/util/Util;memoize(Ljava/util/function/Function;)Ljava/util/function/Function;"
            )
    )
    private static Function<?, ?> removeMemoize(Function<?, ?> original) {
        return original;
    }
}
