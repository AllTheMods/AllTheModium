package com.thevortex.allthemodium.worldgen.carvers;

import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.CarvingMask;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Aquifer;
import net.minecraft.world.level.levelgen.carver.CarvingContext;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CaveWorldCarver;
import net.minecraft.world.level.material.Fluids;
import org.apache.commons.lang3.mutable.MutableBoolean;

import java.util.Random;
import java.util.function.Function;

public class OtherCarver extends CaveWorldCarver {
        public OtherCarver(Codec<CaveCarverConfiguration> config) {
            super(config);
            this.replaceableBlocks = ImmutableSet.of(ModRegistry.ANCIENT_STONE.get(),Blocks.STONE,Blocks.DEEPSLATE, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE, Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.PODZOL, Blocks.GRASS_BLOCK, Blocks.NETHERRACK, Blocks.SOUL_SAND, Blocks.SOUL_SOIL, Blocks.CRIMSON_NYLIUM, Blocks.WARPED_NYLIUM, Blocks.NETHER_WART_BLOCK, Blocks.WARPED_WART_BLOCK, Blocks.BASALT, Blocks.BLACKSTONE);
            this.liquids = ImmutableSet.of(Fluids.LAVA, Fluids.WATER);
        }

        protected int getCaveBound() {
            return 10;
        }

        protected float getThickness(Random random) {
            return (random.nextFloat() * 2.0F + random.nextFloat()) * 2.0F;
        }

        protected double getYScale() {
            return 5.0D;
        }

        protected boolean carveBlock(CarvingContext context, CaveCarverConfiguration config, ChunkAccess chunkAccessor, Function<BlockPos, Biome> biomeFunction, CarvingMask mask, BlockPos.MutableBlockPos mutableblockPos, BlockPos.MutableBlockPos unusedBlockPos, Aquifer aquifer, MutableBoolean mutableBoolean) {
            if (this.canReplaceBlock(chunkAccessor.getBlockState(mutableblockPos))) {
                BlockState blockstate;
                if (mutableblockPos.getY() <= context.getMinGenY() + 31) {
                    blockstate = LAVA.createLegacyBlock();
                } else {
                    blockstate = CAVE_AIR;
                }

                chunkAccessor.setBlockState(mutableblockPos, blockstate, false);
                return true;
            } else {
                return false;
            }
        }

}
