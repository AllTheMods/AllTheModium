package com.thevortex.allthemodium.worldgen.features;

import com.mojang.serialization.Codec;
import com.thevortex.allthemodium.registry.BlockRegistry;
import com.thevortex.allthemodium.registry.ModRegistry;
import javax.annotation.Nonnull;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class Volcano extends Feature<VolcanoConfig> {

    FastNoiseLite fnlPerlin = null;
    BlockPos lastPos = new BlockPos(0, 0, 0);

    public Volcano(Codec<VolcanoConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(
            @Nonnull FeaturePlaceContext<VolcanoConfig> p_159749_) {
        return place(
                p_159749_.level(),
                p_159749_.chunkGenerator(),
                p_159749_.random(),
                p_159749_.origin(),
                FeatureConfiguration.NONE);
    }

    private boolean place(
            WorldGenLevel world,
            ChunkGenerator generator,
            RandomSource rand,
            BlockPos pos,
            FeatureConfiguration config) {
        setSeed(world.getSeed());
        int landHeight = generator.getSpawnHeight(
                world.getChunk(pos).getHeightAccessorForGeneration());
        if (rand.nextFloat() < 0.0005F) {
            // pos = world.getHeightmapPos(Heightmap.Types.OCEAN_FLOOR_WG, pos);

            pos = new BlockPos(pos.getX(), landHeight, pos.getZ());
            BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

            double baseRadius = 16;
            double lavaLeakage = 0.7;
            int volcanoConeSize = 75;
            int volcanoStartHeight = volcanoConeSize - 5;
            double threshold = 0.5;

            for (double x = -volcanoConeSize; x <= volcanoConeSize; x++) {
                for (double y = -volcanoConeSize; y <= -15; y++) {
                    for (double z = -volcanoConeSize; z <= volcanoConeSize; z++) {
                        mutable
                                .set(pos)
                                .move(
                                        (int) x,
                                        (int) y + volcanoStartHeight,
                                        (int) z);
                        float noise3 = FastNoiseLite.getSpongePerlinValue(
                                fnlPerlin.GetNoise(mutable.getX(), mutable.getZ()));

                        double scaledNoise = (noise3 / 11) *
                                (-(y * baseRadius) / ((x * x) + (z * z)));
                        if (scaledNoise - lavaLeakage >= threshold) {
                            if (mutable.getY() <= pos.getY() + (volcanoStartHeight - 19)) {
                                world.setBlock(
                                        mutable,
                                        BlockRegistry.SOULLAVA_BLOCK
                                                .get()
                                                .defaultBlockState(),
                                        2);
                            }
                        } else if (scaledNoise >= threshold) {
                            world.setBlock(
                                    mutable,
                                    rand.nextBoolean()
                                            ? Blocks.BASALT.defaultBlockState()
                                            : ModRegistry.ANCIENT_STONE
                                                    .get()
                                                    .defaultBlockState(),
                                    2);
                        }
                    }
                }
            }
        }

        return true;
    }

    public void setSeed(long seed) {
        if (fnlPerlin == null) {
            fnlPerlin = FastNoiseLite.createSpongePerlin((int) seed);
            fnlPerlin.SetFrequency(0.2F);
        }
    }
}
