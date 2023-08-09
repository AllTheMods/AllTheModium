package com.thevortex.allthemodium.registry;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ATMBlockSets {

    public static BlockSetType ANCIENT = BlockSetType.register(new BlockSetType("ancient"));
    public static BlockSetType DEMONIC = BlockSetType.register(new BlockSetType("demonic"));
    public static BlockSetType SOUL = BlockSetType.register(new BlockSetType("soul"));

    public static WoodType ANCIENTWOOD = WoodType.register(new WoodType("ancient", ANCIENT));
    public static WoodType DEMONICWOOD = WoodType.register(new WoodType("demonic", DEMONIC));
    public static WoodType SOULWOOD = WoodType.register(new WoodType("soul", SOUL));


}
