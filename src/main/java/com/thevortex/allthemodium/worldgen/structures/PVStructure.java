package com.thevortex.allthemodium.worldgen.structures;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.structures.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.NoiseAffectingStructureStart;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;

import java.util.List;

public class PVStructure extends StructureFeature<NoneFeatureConfiguration> {
    public PVStructure(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

     @Override
    public StructureStartFactory<NoneFeatureConfiguration> getStartFactory() {
        return PVStructure.Start::new;
    }

  @Override
    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.SURFACE_STRUCTURES;
    }

    private static final List<MobSpawnSettings.SpawnerData> STRUCTURE_MONSTERS = ImmutableList.of(
            new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 100, 4, 9)

    );
    @Override
    public List<MobSpawnSettings.SpawnerData> getDefaultSpawnList() {
        return STRUCTURE_MONSTERS;
    }

    private static final List<MobSpawnSettings.SpawnerData> STRUCTURE_CREATURES = ImmutableList.of(
            new MobSpawnSettings.SpawnerData(EntityType.HOGLIN, 30, 10, 15),
            new MobSpawnSettings.SpawnerData(EntityType.ZOGLIN, 100, 1, 2)
    );
    @Override
    public List<MobSpawnSettings.SpawnerData> getDefaultCreatureSpawnList() {
        return STRUCTURE_CREATURES;
    }



    @Override
    protected boolean isFeatureChunk(ChunkGenerator chunkGenerator, BiomeSource biomeSource, long seed, WorldgenRandom random, ChunkPos chunkPos1, Biome biome, ChunkPos chunkPos2, NoneFeatureConfiguration featureConfig, LevelHeightAccessor heightLimitView) {
        BlockPos blockPos = chunkPos1.getWorldPosition();
        int landHeight = chunkGenerator.getFirstOccupiedHeight(blockPos.getX(), blockPos.getZ(), Heightmap.Types.WORLD_SURFACE_WG, heightLimitView);
        NoiseColumn columnOfBlocks = chunkGenerator.getBaseColumn(blockPos.getX(), blockPos.getZ(), heightLimitView);
        BlockState topBlock = columnOfBlocks.getBlockState(blockPos.below(landHeight));
        return topBlock.getFluidState().isEmpty() && topBlock.isAir(); //landHeight > 100;
    }
    public static class Start extends NoiseAffectingStructureStart<NoneFeatureConfiguration> {
        public Start(StructureFeature<NoneFeatureConfiguration> structureIn, ChunkPos chunkPos, int referenceIn, long seedIn) {
            super(structureIn, chunkPos, referenceIn, seedIn);
        }

        @Override
        public void generatePieces(RegistryAccess dynamicRegistryAccess, ChunkGenerator chunkGenerator, StructureManager structureManager, ChunkPos chunkPos, Biome biomeIn, NoneFeatureConfiguration config, LevelHeightAccessor heightLimitView) {
            BlockPos structureBlockPos = new BlockPos(chunkPos.getMinBlockX(), 0, chunkPos.getMinBlockZ());
            JigsawPlacement.addPieces(
                    dynamicRegistryAccess,
                    new JigsawConfiguration(() -> dynamicRegistryAccess.registryOrThrow(Registry.TEMPLATE_POOL_REGISTRY)
                            .get(new ResourceLocation(Reference.MOD_ID, "village/start_pool")),
                            10),
                    PoolElementStructurePiece::new,
                    chunkGenerator,
                    structureManager,
                    structureBlockPos,
                    this,
                    this.random,
                    false,
                    true,
                    heightLimitView);
            this.pieces.forEach(piece -> piece.move(0, -1, 0));
            Vec3i structureCenter = this.pieces.get(0).getBoundingBox().getCenter();
            int xOffset = structureBlockPos.getX() - structureCenter.getX();
            int zOffset = structureBlockPos.getZ() - structureCenter.getZ();
            for(StructurePiece structurePiece : this.pieces){
                structurePiece.move(xOffset, 0, zOffset);
            }
            this.getBoundingBox();
        }
    }
}
