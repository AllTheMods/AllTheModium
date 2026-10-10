package net.allthemods.allthemodium.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import net.allthemods.allthemodium.core.registry.ATMBlocks;
import net.allthemods.allthemodium.data.worldgen.ATMConfiguredFeatures;

import com.mojang.serialization.MapCodec;

import java.util.Optional;

public class AncientGrassBlock extends GrassBlock {
    
    private static final MapCodec<GrassBlock> CODEC = BlockBehaviour.simpleCodec(AncientGrassBlock::new);
    private static final int BONEMEAL_TRIES = 128;
    private static final int SPREAD_TRIES = 4;
    private static final int SPREAD_MIN_LIGHT = 9;
    
    public AncientGrassBlock(Properties properties) {
        super(properties);
    }
    
    @Override
    public MapCodec<GrassBlock> codec() {
        return AncientGrassBlock.CODEC;
    }
    
    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.getBlockState(pos.above()).isAir()) {
            level.setBlock(pos, ATMBlocks.ANCIENT_DIRT.get().defaultBlockState(), Block.UPDATE_NEIGHBORS);
            return;
        }

        if (!level.isAreaLoaded(pos, 3) || level.getMaxLocalRawBrightness(pos.above()) < AncientGrassBlock.SPREAD_MIN_LIGHT) return;

        for (int attempt = 0; attempt < AncientGrassBlock.SPREAD_TRIES; attempt++) {
            BlockPos testPos = pos.offset(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
            if (level.getBlockState(testPos).is(ATMBlocks.ANCIENT_DIRT) && level.getBlockState(testPos.above()).isAir()) {
                level.setBlockAndUpdate(testPos, this.defaultBlockState());
            }
        }
    }
    
    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        Optional<Holder.Reference<ConfiguredFeature<?, ?>>> feature = level.registryAccess()
                .lookupOrThrow(Registries.CONFIGURED_FEATURE)
                .get(ATMConfiguredFeatures.ANCIENT_GRASS_BONEMEAL);
        if (feature.isEmpty()) return;
        
        tries:
        for (int attempt = 0; attempt < AncientGrassBlock.BONEMEAL_TRIES; attempt++) {
            BlockPos testPos = pos.above();
            for (int step = 0; step < attempt / 16; step++) {
                testPos = testPos.offset(random.nextInt(3) - 1, (random.nextInt(3) - 1) * random.nextInt(3) / 2, random.nextInt(3) - 1);
                if (!level.getBlockState(testPos.below()).is(this) || level.getBlockState(testPos).isCollisionShapeFullBlock(level, testPos)) {
                    continue tries;
                }
            }
            
            if (level.getBlockState(testPos).isAir() && !level.isOutsideBuildHeight(testPos)) {
                feature.get().value().place(level, level.getChunkSource().getGenerator(), random, testPos);
            }
        }
    }
}
