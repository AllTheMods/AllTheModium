package com.thevortex.allthemodium.worldgen.structures;

import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ATMStructures {

    public static final DeferredRegister<StructureType<?>> STRUCTURES = DeferredRegister.create(
            Registry.STRUCTURE_TYPE_REGISTRY,
            Reference.MOD_ID);

    public static final RegistryObject<StructureType<APStructure>> ANCIENT_PYRAMID = STRUCTURES.register(
            "ancient_pyramid",
            () -> () -> APStructure.CODEC);
    public static final RegistryObject<StructureType<PVStructure>> PIGLIN_VILLAGE = STRUCTURES.register(
            "piglin_village",
            () -> () -> PVStructure.CODEC);
    public static final RegistryObject<StructureType<DungeonStructure>> ANCIENT_DUNGEON = STRUCTURES.register(
            "dungeon",
            () -> () -> DungeonStructure.CODEC);
}
