package net.allthemods.allthemodium.core.registry;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.common.world.structures.AncientPyramidStructure;
import net.allthemods.allthemodium.common.world.structures.OtherDungeonStructure;
import net.allthemods.allthemodium.common.world.structures.PiglichVillageStructure;

public class ATMStructureTypes {
    
    public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES = DeferredRegister.create(Registries.STRUCTURE_TYPE, ATM.MOD_ID);
    
    public static final DeferredHolder<StructureType<?>, StructureType<AncientPyramidStructure>> ANCIENT_PYRAMID = ATMStructureTypes.STRUCTURE_TYPES.register(
            "ancient_pyramid", () -> () -> AncientPyramidStructure.CODEC
    );
    public static final DeferredHolder<StructureType<?>, StructureType<OtherDungeonStructure>> OTHER_DUNGEON = ATMStructureTypes.STRUCTURE_TYPES.register(
            "other_dungeon", () -> () -> OtherDungeonStructure.CODEC
    );
    public static final DeferredHolder<StructureType<?>, StructureType<PiglichVillageStructure>> PIGLICH_VILLAGE = ATMStructureTypes.STRUCTURE_TYPES.register(
            "piglich_village", () -> () -> PiglichVillageStructure.CODEC
    );
    
    public static void register(final IEventBus bus) {
        ATMStructureTypes.STRUCTURE_TYPES.register(bus);
    }
}
