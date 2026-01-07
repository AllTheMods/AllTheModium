package com.thevortex.allthemodium.chunkgenerator;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.chunk.ChunkGeneratorStructureState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.minecraft.world.level.levelgen.flat.FlatLevelGeneratorSettings;
import net.minecraft.world.level.levelgen.structure.StructureSet;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class CustomFlatLevelSource extends ChunkGenerator {
    public static final MapCodec<CustomFlatLevelSource> CODEC = RecordCodecBuilder.mapCodec(
            p_255577_ -> p_255577_.group(FlatLevelGeneratorSettings.CODEC.fieldOf("settings").forGetter(CustomFlatLevelSource::settings))
                    .apply(p_255577_, p_255577_.stable(CustomFlatLevelSource::new))
    );
    private final FlatLevelGeneratorSettings settings;

    public CustomFlatLevelSource(FlatLevelGeneratorSettings settings) {
        super(new FixedBiomeSource(settings.getBiome()));
        this.settings = settings;
    }

    @Override
    public ChunkGeneratorStructureState createState(HolderLookup<StructureSet> structureSetLookup, RandomState randomState, long seed) {
        Stream<Holder<StructureSet>> stream = this.settings
                .structureOverrides()
                .map(HolderSet::stream)
                .orElseGet(() -> structureSetLookup.listElements().map(p_255579_ -> (Holder<StructureSet>)p_255579_));
        return ChunkGeneratorStructureState.createForFlat(randomState, seed, this.biomeSource, stream);
    }

    @Override
    protected MapCodec<? extends ChunkGenerator> codec() {
        return CODEC;
    }

    public FlatLevelGeneratorSettings settings() {
        return this.settings;
    }

    @Override
    public void buildSurface(WorldGenRegion level, StructureManager structureManager, RandomState random, ChunkAccess chunk) {
    }

    @Override
    public int getSpawnHeight(LevelHeightAccessor level) {
        return level.getMinBuildHeight() + Math.min(level.getHeight(), this.settings.getLayers().size());
    }

    @Override
    public CompletableFuture<ChunkAccess> fillFromNoise(Blender blender, RandomState randomState, StructureManager structureManager, ChunkAccess chunk) {
        List<BlockState> list = this.settings.getLayers();
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
        Heightmap heightmap = chunk.getOrCreateHeightmapUnprimed(Heightmap.Types.OCEAN_FLOOR_WG);
        Heightmap heightmap1 = chunk.getOrCreateHeightmapUnprimed(Heightmap.Types.WORLD_SURFACE_WG);

        for (int i = 0; i < Math.min(chunk.getHeight(), list.size()); i++) {
            BlockState blockstate = list.get(i);
            if (blockstate != null) {
                int j = chunk.getMinBuildHeight() + i;

                for (int k = 0; k < 16; k++) {
                    for (int l = 0; l < 16; l++) {
                        chunk.setBlockState(blockpos$mutableblockpos.set(k, j, l), blockstate, false);
                        heightmap.update(k, j, l, blockstate);
                        heightmap1.update(k, j, l, blockstate);
                    }
                }
            }
        }

        return CompletableFuture.completedFuture(chunk);
    }

    @Override
    public int getBaseHeight(int x, int z, Heightmap.Types type, LevelHeightAccessor level, RandomState random) {
        List<BlockState> list = this.settings.getLayers();

        for (int i = Math.min(list.size(), level.getMaxBuildHeight()) - 1; i >= 0; i--) {
            BlockState blockstate = list.get(i);
            if (blockstate != null && type.isOpaque().test(blockstate)) {
                return level.getMinBuildHeight() + i + 1;
            }
        }

        return level.getMinBuildHeight();
    }

    @Override
    public NoiseColumn getBaseColumn(int x, int z, LevelHeightAccessor height, RandomState random) {
        return new NoiseColumn(
                height.getMinBuildHeight(),
                this.settings
                        .getLayers()
                        .stream()
                        .limit((long)height.getHeight())
                        .map(p_204549_ -> p_204549_ == null ? Blocks.AIR.defaultBlockState() : p_204549_)
                        .toArray(BlockState[]::new)
        );
    }

    @Override
    public void addDebugScreenInfo(List<String> info, RandomState random, BlockPos pos) {
    }

    @Override
    public void applyCarvers(
            WorldGenRegion level,
            long seed,
            RandomState random,
            BiomeManager biomeManager,
            StructureManager structureManager,
            ChunkAccess chunk,
            GenerationStep.Carving step
    ) {
    }

    @Override
    public void spawnOriginalMobs(WorldGenRegion level) {
    }

    @Override
    public int getMinY() {
        return 0;
    }

    @Override
    public int getGenDepth() {
        return 384;
    }

    @Override
    public int getSeaLevel() {
        return -63;
    }
}
