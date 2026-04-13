package net.allthemods.allthemodium.data.worldgen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.common.world.structures.AncientPyramidStructure;
import net.allthemods.allthemodium.common.world.structures.OtherDungeonStructure;
import net.allthemods.allthemodium.common.world.structures.PiglichVillageStructure;
import net.allthemods.allthemodium.core.registry.ATMEntities;
import net.allthemods.allthemodium.core.registry.ATMTags;

import java.util.Map;

public class ATMStructures {
    
    public static final ResourceKey<Structure> ANCIENT_PYRAMID = ATMStructures.create("ancient_pyramid");
    public static final ResourceKey<Structure> DUNGEON = ATMStructures.create("dungeon");
    public static final ResourceKey<Structure> PIGLIN_VILLAGE = ATMStructures.create("piglin_village");
    
    public static void bootstrap(final BootstrapContext<Structure> ctx) {
        HolderGetter<Biome> biomes = ctx.lookup(Registries.BIOME);
        HolderGetter<StructureTemplatePool> pools = ctx.lookup(Registries.TEMPLATE_POOL);
        
        ctx.register(ATMStructures.ANCIENT_PYRAMID, new AncientPyramidStructure(
                new Structure.StructureSettings.Builder(biomes.getOrThrow(ATMTags.Biomes.HAS_ANCIENT_PYRAMID))
                        .spawnOverrides(Map.of(MobCategory.MONSTER, new StructureSpawnOverride(
                                StructureSpawnOverride.BoundingBoxType.PIECE,
                                WeightedList.<MobSpawnSettings.SpawnerData>builder()
                                        .add(new MobSpawnSettings.SpawnerData(ATMEntities.PIGLICH.get(), 1, 1), 4500)
                                        .build()
                        )))
                        .generationStep(GenerationStep.Decoration.SURFACE_STRUCTURES)
                        .terrainAdapation(TerrainAdjustment.BEARD_THIN)
                        .build(),
                pools.getOrThrow(ATMTemplatePools.PYRAMID_START_POOL),
                7,
                0,
                false,
                Heightmap.Types.WORLD_SURFACE_WG,
                80
        ));
        ctx.register(ATMStructures.DUNGEON, new OtherDungeonStructure(
                new Structure.StructureSettings.Builder(biomes.getOrThrow(ATMTags.Biomes.HAS_DUNGEON))
                        .generationStep(GenerationStep.Decoration.SURFACE_STRUCTURES)
                        .terrainAdapation(TerrainAdjustment.BEARD_BOX)
                        .build(),
                pools.getOrThrow(ATMTemplatePools.DUNGEON_START_POOL),
                15,
                0,
                false,
                Heightmap.Types.WORLD_SURFACE_WG,
                80
        ));
        ctx.register(ATMStructures.PIGLIN_VILLAGE, new PiglichVillageStructure(
                new Structure.StructureSettings.Builder(biomes.getOrThrow(ATMTags.Biomes.HAS_PIGLICH_VILLAGE))
                        .spawnOverrides(Map.of(MobCategory.MONSTER, new StructureSpawnOverride(
                                StructureSpawnOverride.BoundingBoxType.PIECE,
                                WeightedList.<MobSpawnSettings.SpawnerData>builder()
                                        .add(new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 5, 10), 200)
                                        .build()
                        )))
                        .generationStep(GenerationStep.Decoration.UNDERGROUND_STRUCTURES)
                        .terrainAdapation(TerrainAdjustment.BEARD_BOX)
                        .build(),
                pools.getOrThrow(ATMTemplatePools.VILLAGE_START_POOL),
                20,
                -89,
                false,
                Heightmap.Types.WORLD_SURFACE_WG,
                65
        ));
    }
    
    private static ResourceKey<Structure> create(String path) {
        return ATM.key(Registries.STRUCTURE, path);
    }
}
