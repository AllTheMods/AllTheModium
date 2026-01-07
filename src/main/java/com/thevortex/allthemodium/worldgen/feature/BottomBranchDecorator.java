package com.thevortex.allthemodium.worldgen.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.BlockColumnConfiguration;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BottomBranchDecorator extends TreeDecorator
{
    public static final MapCodec<BottomBranchDecorator> CODEC = RecordCodecBuilder.mapCodec((decoratorInstance) -> decoratorInstance
            .group(
                    BlockColumnConfiguration.Layer.CODEC.listOf().fieldOf("layers").forGetter(BottomBranchDecorator::getLayers),
                    Codec.FLOAT.fieldOf("probability").orElse(0.5f).forGetter(BottomBranchDecorator::getProbability),
                    Codec.INT.fieldOf("max_blocks").orElse(100).forGetter(BottomBranchDecorator::getMaxBlocks)
            ).apply(decoratorInstance, BottomBranchDecorator::new)
    );

    private final float probability;
    private final int maxBlocks;
    private final List<BlockColumnConfiguration.Layer> layers;

    public BottomBranchDecorator(List<BlockColumnConfiguration.Layer> layers, float probability, int maxBlocks) {
        this.layers = layers;
        this.probability = probability;
        this.maxBlocks = maxBlocks;
    }

    private float getProbability() {
        return probability;
    }

    private int getMaxBlocks() {
        return maxBlocks;
    }

    private List<BlockColumnConfiguration.Layer> getLayers() {
        return layers;
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return ATMFeatures.BOTTOM_BRANCH_DECORATOR.get();
    }

    @Override
    public void place(Context context) {
        if (context.leaves().isEmpty()) {
            return;
        }
        AtomicInteger count = new AtomicInteger();
        var rand = context.random();
        context.logs().forEach(blockPos -> {
            if (count.get() < maxBlocks && context.isAir(blockPos.below()) && rand.nextFloat() < probability) {
                for (BlockColumnConfiguration.Layer layer : layers) {
                    context.setBlock(blockPos.below(), layer.state().getState(rand, blockPos.below()));
                    count.getAndIncrement();
                }
            }
        });
    }
}