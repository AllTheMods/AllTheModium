package com.thevortex.allthemodium.worldgen.carvers;

import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.biome.Biome;
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

public class OtherCaveCarver extends CaveWorldCarver {
        public OtherCaveCarver(Codec<CaveCarverConfiguration> config) {
            super(config);
            this.replaceableBlocks = ImmutableSet.of(ModRegistry.ANCIENT_STONE_WORLDGEN,Blocks.DEEPSLATE, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE, Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.PODZOL, Blocks.GRASS_BLOCK, Blocks.NETHERRACK, Blocks.SOUL_SAND, Blocks.SOUL_SOIL, Blocks.CRIMSON_NYLIUM, Blocks.WARPED_NYLIUM, Blocks.NETHER_WART_BLOCK, Blocks.WARPED_WART_BLOCK, Blocks.BASALT, Blocks.BLACKSTONE);
            this.liquids = ImmutableSet.of(Fluids.LAVA, Fluids.WATER);
        }

        protected int getCaveBound() {
            return 20;
        }

        protected float getThickness(Random rand) {
            return (rand.nextFloat() * 2.0F + rand.nextFloat()) * 2.0F;
        }

        protected double getYScale() {
            return 5.0D;
        }

        protected boolean carveBlock(CarvingContext context, CaveCarverConfiguration config, ChunkAccess chunkaccessor, Function<BlockPos, Biome> biomeFunction, CarvingMask mask, BlockPos.MutableBlockPos mutableBlockPos, BlockPos.MutableBlockPos blockPos, Aquifer aquifer, MutableBoolean mutableBoolean) {
            if (this.canReplaceBlock(chunkaccessor.getBlockState(mutableBlockPos))) {
                BlockState blockstate;
                if (mutableBlockPos.getY() <= context.getMinGenY() + 31) {
                    blockstate = LAVA.createLegacyBlock();
                } else {
                    blockstate = CAVE_AIR;
                }

                chunkaccessor.setBlockState(mutableBlockPos, blockstate, false);
                return true;
            } else {
                return false;
            }
        }

}
