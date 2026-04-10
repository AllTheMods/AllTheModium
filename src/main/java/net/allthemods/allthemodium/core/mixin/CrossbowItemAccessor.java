package net.allthemods.allthemodium.core.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(CrossbowItem.class)
public interface CrossbowItemAccessor {
    
    @Accessor("startSoundPlayed")
    boolean getStartSoundPlayed();
    
    @Accessor("startSoundPlayed")
    void setStartSoundPlayed(boolean startSoundPlayed);
    
    @Accessor("midLoadSoundPlayed")
    boolean getMidLoadSoundPlayed();
    
    @Accessor("midLoadSoundPlayed")
    void setMidLoadSoundPlayed(boolean midLoadSoundPlayed);
    
    @Invoker("getChargingSounds")
    CrossbowItem.ChargingSounds doGetChargingSounds(ItemStack itemStack);
    
    @Invoker("tryLoadProjectiles")
    static boolean doTryLoadProjectiles(LivingEntity shooter, ItemStack heldItem) {
        throw new AssertionError();
    }
}
