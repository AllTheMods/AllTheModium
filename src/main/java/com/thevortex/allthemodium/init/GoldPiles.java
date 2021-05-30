package com.thevortex.allthemodium.init;

import com.github.alexthe666.iceandfire.block.BlockGoldPile;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.ModList;

public class GoldPiles {

    public static Block ALLTHEMODIUM_PILE;
    public static Block UNOBTAINIUM_PILE;
    public static Block VIBRANIUM_PILE;
    public static void init(RegistryEvent.Register<Block> event)
    {
        if (ModList.get().isLoaded("iceandfire")) {
            ALLTHEMODIUM_PILE = new BlockGoldPile("allthemodium_pile");
            UNOBTAINIUM_PILE = new BlockGoldPile("unobtainium_pile");
            VIBRANIUM_PILE = new BlockGoldPile("vibranium_pile");

            event.getRegistry().register(ALLTHEMODIUM_PILE);
            event.getRegistry().register(UNOBTAINIUM_PILE);
            event.getRegistry().register(VIBRANIUM_PILE);
        }
    }
}
