package net.allthemods.allthemodium.common.blocks;

import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.SpreadingSnowyBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import net.allthemods.allthemodium.core.registry.ATMBlocks;

import com.mojang.serialization.MapCodec;

public class AncientGrassBlock extends SpreadingSnowyBlock {
    
    public static final MapCodec<GrassBlock> CODEC = BlockBehaviour.simpleCodec(GrassBlock::new);
    
    public AncientGrassBlock(Properties properties) {
        super(properties, ATMBlocks.ANCIENT_GRASS.getKey());
    }
    
    @Override
    protected MapCodec<? extends SpreadingSnowyBlock> codec() {
        return AncientGrassBlock.CODEC;
    }
}
