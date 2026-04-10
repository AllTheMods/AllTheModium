package net.allthemods.allthemodium.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import net.allthemods.allthemodium.core.registry.ATMBlocks;

import com.mojang.serialization.MapCodec;

public abstract class OtherLeaveBlock extends LeavesBlock {
    
    public OtherLeaveBlock(Properties properties) {
        super(0.02F, properties);
    }
    
    @Override
    protected abstract void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random);
    
    @Override
    public abstract MapCodec<? extends OtherLeaveBlock> codec();
    
    @Override
    protected void spawnFallingLeavesParticle(Level level, BlockPos pos, RandomSource random) {
        ParticleUtils.spawnParticleBelow(level, pos, random, ParticleTypes.PALE_OAK_LEAVES);
    }
    
    public static final class Ancient extends OtherLeaveBlock {
        
        private static final MapCodec<Ancient> CODEC = BlockBehaviour.simpleCodec(Ancient::new);
        
        public Ancient(Properties properties) {
            super(properties);
        }
        
        @Override
        protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
            final BlockPos below = pos.below();
            if (!level.getBlockState(below).isAir()) return;
            level.setBlockAndUpdate(below, ATMBlocks.ANCIENT_LEAVES_BOTTOM.get().defaultBlockState());
        }
        
        @Override
        public MapCodec<Ancient> codec() {
            return Ancient.CODEC;
        }
    }
    
    public static final class Soul extends OtherLeaveBlock {
        
        private static final MapCodec<Soul> CODEC = BlockBehaviour.simpleCodec(Soul::new);
        
        public Soul(Properties properties) {
            super(properties);
        }
        
        @Override
        protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
            final BlockPos below = pos.below();
            if (!level.getBlockState(below).isAir()) return;
            level.setBlockAndUpdate(below, ATMBlocks.SOUL_LEAVES_BOTTOM.get().defaultBlockState());
        }
        
        @Override
        public MapCodec<Soul> codec() {
            return Soul.CODEC;
        }
    }
    
    public static final class Demonic extends OtherLeaveBlock {
        
        private static final MapCodec<Demonic> CODEC = BlockBehaviour.simpleCodec(Demonic::new);
        
        public Demonic(Properties properties) {
            super(properties);
        }
        
        @Override
        protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
            final BlockPos below = pos.below();
            if (!level.getBlockState(below).isAir()) return;
            level.setBlockAndUpdate(below, ATMBlocks.DEMONIC_LEAVES_BOTTOM.get().defaultBlockState());
        }
        
        @Override
        public MapCodec<Demonic> codec() {
            return Demonic.CODEC;
        }
    }
}
