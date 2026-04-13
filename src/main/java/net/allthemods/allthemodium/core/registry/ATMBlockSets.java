package net.allthemods.allthemodium.core.registry;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ATMBlockSets {
    
    public static BlockSetType ANCIENT = BlockSetType.register(new BlockSetType("ancient"));
    public static BlockSetType DEMONIC = BlockSetType.register(new BlockSetType("demonic"));
    public static BlockSetType SOUL = BlockSetType.register(new BlockSetType("soul"));
    
    public static WoodType ANCIENT_WOOD = WoodType.register(new WoodType("ancient", ATMBlockSets.ANCIENT));
    public static WoodType DEMONIC_WOOD = WoodType.register(new WoodType("demonic", ATMBlockSets.DEMONIC));
    public static WoodType SOUL_WOOD = WoodType.register(new WoodType("soul", ATMBlockSets.SOUL));
}
