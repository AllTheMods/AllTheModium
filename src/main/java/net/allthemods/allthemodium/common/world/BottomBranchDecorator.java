package net.allthemods.allthemodium.common.world;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.configurations.BlockColumnConfiguration;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import net.allthemods.allthemodium.core.registry.ATMTreeDecorators;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.List;

public class BottomBranchDecorator extends TreeDecorator {
    
    public static final MapCodec<BottomBranchDecorator> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            BlockColumnConfiguration.Layer.CODEC.listOf().fieldOf("layers").forGetter(decorator -> decorator.layers),
            Codec.FLOAT.fieldOf("probability").orElse(0.5F).forGetter(decorator -> decorator.probability),
            Codec.INT.fieldOf("max_blocks").orElse(100).forGetter(decorator -> decorator.maxBlocks)
    ).apply(instance, BottomBranchDecorator::new));
    
    private final List<BlockColumnConfiguration.Layer> layers;
    private final float probability;
    private final int maxBlocks;
    
    public BottomBranchDecorator(List<BlockColumnConfiguration.Layer> layers, float probability, int maxBlocks) {
        this.layers = layers;
        this.probability = probability;
        this.maxBlocks = maxBlocks;
    }
    
    @Override
    protected TreeDecoratorType<?> type() {
        return ATMTreeDecorators.BOTTOM_BRANCH.get();
    }
    
    @Override
    public void place(TreeDecorator.Context context) {
        if (context.leaves().isEmpty()) return;
        
        RandomSource random = context.random();
        int columns = 0;
        for (BlockPos log : context.logs()) {
            if (columns >= this.maxBlocks) return;
            
            BlockPos.MutableBlockPos pos = log.below().mutable();
            if (!context.isAir(pos) || random.nextFloat() >= this.probability) continue;
            
            for (BlockColumnConfiguration.Layer layer : this.layers) {
                int height = layer.height().sample(random);
                for (int placed = 0; placed < height && context.isAir(pos); placed++) {
                    context.setBlock(pos, layer.state().getState(context.level(), random, pos));
                    pos.move(Direction.DOWN);
                }
            }
            columns++;
        }
    }
}
