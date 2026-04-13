package net.allthemods.allthemodium.data.worldgen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

import net.allthemods.allthemodium.api.ATM;

public class ATMStructureSets {
    
    public static final ResourceKey<StructureSet> ANCIENT_PYRAMID = ATMStructureSets.create("ancient_pyramid");
    public static final ResourceKey<StructureSet> DUNGEON = ATMStructureSets.create("dungeon");
    public static final ResourceKey<StructureSet> PIGLIN_VILLAGE = ATMStructureSets.create("piglin_village");
    
    public static void bootstrap(final BootstrapContext<StructureSet> ctx) {
        HolderGetter<Structure> structures = ctx.lookup(Registries.STRUCTURE);
        
        ctx.register(ATMStructureSets.ANCIENT_PYRAMID, new StructureSet(
                structures.getOrThrow(ATMStructures.ANCIENT_PYRAMID),
                new RandomSpreadStructurePlacement(50, 45, RandomSpreadType.LINEAR, 185645172)
        ));
        ctx.register(ATMStructureSets.DUNGEON, new StructureSet(
                structures.getOrThrow(ATMStructures.DUNGEON),
                new RandomSpreadStructurePlacement(50, 45, RandomSpreadType.LINEAR, 1546875896)
        ));
        ctx.register(ATMStructureSets.PIGLIN_VILLAGE, new StructureSet(
                structures.getOrThrow(ATMStructures.PIGLIN_VILLAGE),
                new RandomSpreadStructurePlacement(15, 10, RandomSpreadType.LINEAR, 1236549879)
        ));
    }
    
    private static ResourceKey<StructureSet> create(String path) {
        return ATM.key(Registries.STRUCTURE_SET, path);
    }
}
