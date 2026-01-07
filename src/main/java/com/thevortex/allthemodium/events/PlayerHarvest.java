package com.thevortex.allthemodium.events;

public class PlayerHarvest {

    /*
    @SubscribeEvent
    public static void on(PlayerEvent.HarvestCheck event) {
        Player player = event.getPlayer();
        BlockState blockstate = event.getTargetBlock();
        ItemStack heldItem = player.getMainHandItem();
        if (blockstate.getBlock() instanceof Allthemodium_Ore) {
            boolean b = net.minecraftforge.common.ForgeHooks.isCorrectToolForDrops(blockstate, player);
            event.setCanHarvest(b);
        }
        if(blockstate.getBlock() instanceof Vibranium_Ore) {
            event.setCanHarvest(net.minecraftforge.common.ForgeHooks.isCorrectToolForDrops(blockstate, player));
        }
        if(blockstate.getBlock() instanceof Unobtainium_Ore) {
            event.setCanHarvest(net.minecraftforge.common.ForgeHooks.isCorrectToolForDrops(blockstate, player));
        }
    }

    */
}
