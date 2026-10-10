package net.allthemods.allthemodium.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

import net.allthemods.allthemodium.core.registry.ATMBlocks;

import com.mojang.serialization.MapCodec;

import java.util.function.Supplier;

public abstract class OtherLeaveBlock extends LeavesBlock {
    
    public OtherLeaveBlock(Properties properties) {
        super(0.02F, properties);
    }
    
    @Override
    public abstract MapCodec<? extends OtherLeaveBlock> codec();
    
    @Override
    protected void spawnFallingLeavesParticle(Level level, BlockPos pos, RandomSource random) {
        ParticleUtils.spawnParticleBelow(level, pos, random, ParticleTypes.PALE_OAK_LEAVES);
    }
    
    public abstract static class Top extends OtherLeaveBlock {
        
        private final Supplier<? extends Block> bottom;
        private final int bottomChance;
        private final boolean removesBottom;
        
        protected Top(Properties properties, Supplier<? extends Block> bottom, int bottomChance, boolean removesBottom) {
            super(properties);
            this.bottom = bottom;
            this.bottomChance = bottomChance;
            this.removesBottom = removesBottom;
        }
        
        @Override
        protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        }
        
        @Override
        protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
            super.tick(state, level, pos, random);
            if (this.bottomChance <= 0 || random.nextInt(this.bottomChance) != 0) return;
            
            final BlockPos below = pos.below();
            if (!level.getBlockState(below).isAir()) return;
            
            final Block bottom = this.bottom.get();
            level.setBlockAndUpdate(below, bottom.defaultBlockState());
            level.scheduleTick(below, bottom, 1);
        }
        
        @Override
        public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, ItemStack toolStack, boolean willHarvest, FluidState fluid) {
            final BlockPos below = pos.below();
            if (this.removesBottom && level.getBlockState(below).is(this.bottom.get())) {
                level.setBlockAndUpdate(below, Blocks.AIR.defaultBlockState());
            }
            return super.onDestroyedByPlayer(state, level, pos, player, toolStack, willHarvest, fluid);
        }
    }
    
    public static final class Ancient extends Top {
        
        private static final MapCodec<Ancient> CODEC = BlockBehaviour.simpleCodec(Ancient::new);
        
        public Ancient(Properties properties) {
            super(properties, ATMBlocks.ANCIENT_LEAVES_BOTTOM, 800, false);
        }
        
        @Override
        public MapCodec<Ancient> codec() {
            return Ancient.CODEC;
        }
    }
    
    public static final class Soul extends Top {
        
        private static final MapCodec<Soul> CODEC = BlockBehaviour.simpleCodec(Soul::new);
        
        public Soul(Properties properties) {
            super(properties, ATMBlocks.SOUL_LEAVES_BOTTOM, 0, true);
        }
        
        @Override
        public MapCodec<Soul> codec() {
            return Soul.CODEC;
        }
    }
    
    public static final class Demonic extends Top {
        
        private static final MapCodec<Demonic> CODEC = BlockBehaviour.simpleCodec(Demonic::new);
        
        public Demonic(Properties properties) {
            super(properties, ATMBlocks.DEMONIC_LEAVES_BOTTOM, 80, true);
        }
        
        @Override
        public MapCodec<Demonic> codec() {
            return Demonic.CODEC;
        }
    }
    
    public static final class Bottom extends OtherLeaveBlock {
        
        private static final MapCodec<Bottom> CODEC = BlockBehaviour.simpleCodec(Bottom::new);
        
        public Bottom(Properties properties) {
            super(properties);
        }
        
        @Override
        public MapCodec<Bottom> codec() {
            return Bottom.CODEC;
        }
    }
}
