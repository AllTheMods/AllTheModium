package com.thevortex.allthemodium.events;

// import com.mojang.datafixers.TypeRewriteRule;
// import com.thevortex.allthemodium.blocks.Allthemodium_Ore;
// import com.thevortex.allthemodium.blocks.Unobtainium_Ore;
// import com.thevortex.allthemodium.blocks.Vibranium_Ore;
// import com.thevortex.allthemodium.material.ToolTiers;
// import com.thevortex.allthemodium.registry.ModRegistry;
// import net.minecraft.world.entity.player.Player;
// import net.minecraft.world.item.*;
// import net.minecraft.world.level.block.Block;
// import net.minecraft.world.level.block.state.BlockState;
// import net.minecraftforge.event.entity.player.PlayerEvent;
// import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerHarvest {
    // TODO: Determine if this class should be kept
    // @SubscribeEvent
    // public static void on(PlayerEvent.HarvestCheck event) {
    //     Player player = event.getPlayer();
    //     BlockState blockstate = event.getTargetBlock();
    //     ItemStack heldItem = player.getMainHandItem();
    //     if (blockstate.getBlock() instanceof Allthemodium_Ore) {
    //         boolean b = net.minecraftforge.common.ForgeHooks.isCorrectToolForDrops(blockstate,
    //                 player);
    //         event.setCanHarvest(b);
    //     }
    //     if (blockstate.getBlock() instanceof Vibranium_Ore) {
    //         event.setCanHarvest(net.minecraftforge.common.ForgeHooks.isCorrectToolForDrops(blockstate, player));
    //     }
    //     if (blockstate.getBlock() instanceof Unobtainium_Ore) {
    //         event.setCanHarvest(net.minecraftforge.common.ForgeHooks.isCorrectToolForDrops(blockstate, player));
    //     }
    // }
}
