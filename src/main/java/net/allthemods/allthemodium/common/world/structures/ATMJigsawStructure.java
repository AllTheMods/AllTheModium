package net.allthemods.allthemodium.common.world.structures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.pools.DimensionPadding;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.pools.alias.PoolAliasBinding;
import net.minecraft.world.level.levelgen.structure.pools.alias.PoolAliasLookup;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public abstract class ATMJigsawStructure extends Structure {
    
    protected static final DimensionPadding DEFAULT_DIMENSION_PADDING = DimensionPadding.ZERO;
    protected static final LiquidSettings DEFAULT_LIQUID_SETTINGS = LiquidSettings.APPLY_WATERLOGGING;
    
    protected final Holder<StructureTemplatePool> startPool;
    protected final Optional<Identifier> startJigsawName;
    protected final int maxDepth;
    protected final HeightProvider startHeight;
    protected final boolean useExpansionHack;
    protected final Optional<Heightmap.Types> projectStartToHeightmap;
    protected final JigsawStructure.MaxDistance maxDistanceFromCenter;
    protected final List<PoolAliasBinding> poolAliases;
    protected final DimensionPadding dimensionPadding;
    protected final LiquidSettings liquidSettings;
    
    protected ATMJigsawStructure(
            Structure.StructureSettings settings,
            Holder<StructureTemplatePool> startPool,
            Optional<Identifier> startJigsawName,
            int maxDepth,
            HeightProvider startHeight,
            boolean useExpansionHack,
            Optional<Heightmap.Types> projectStartToHeightmap,
            JigsawStructure.MaxDistance maxDistanceFromCenter,
            List<PoolAliasBinding> poolAliases,
            DimensionPadding dimensionPadding,
            LiquidSettings liquidSettings
    ) {
        super(settings);
        this.startPool = startPool;
        this.startJigsawName = startJigsawName;
        this.maxDepth = maxDepth;
        this.startHeight = startHeight;
        this.useExpansionHack = useExpansionHack;
        this.projectStartToHeightmap = projectStartToHeightmap;
        this.maxDistanceFromCenter = maxDistanceFromCenter;
        this.poolAliases = poolAliases;
        this.dimensionPadding = dimensionPadding;
        this.liquidSettings = liquidSettings;
    }
    
    protected ATMJigsawStructure(
            Structure.StructureSettings settings,
            Holder<StructureTemplatePool> startPool,
            int maxDepth,
            int startHeight,
            boolean useExpansionHack,
            Heightmap.Types projectStartToHeightmap,
            int maxDistanceFromCenter
    ) {
        this(
                settings,
                startPool,
                Optional.empty(),
                maxDepth,
                ConstantHeight.of(VerticalAnchor.absolute(startHeight)),
                useExpansionHack,
                Optional.of(projectStartToHeightmap),
                new JigsawStructure.MaxDistance(maxDistanceFromCenter),
                List.of(),
                ATMJigsawStructure.DEFAULT_DIMENSION_PADDING,
                ATMJigsawStructure.DEFAULT_LIQUID_SETTINGS
        );
    }
    
    protected static <S extends ATMJigsawStructure> MapCodec<S> codec(StructureFactory<S> factory) {
        return RecordCodecBuilder.<S>mapCodec(
                instance -> instance.group(
                        Structure.settingsCodec(instance),
                        StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter(ATMJigsawStructure::startPool),
                        Identifier.CODEC.optionalFieldOf("start_jigsaw_name").forGetter(ATMJigsawStructure::startJigsawName),
                        Codec.intRange(0, 20).fieldOf("size").forGetter(ATMJigsawStructure::maxDepth),
                        HeightProvider.CODEC.fieldOf("start_height").forGetter(ATMJigsawStructure::startHeight),
                        Codec.BOOL.fieldOf("use_expansion_hack").forGetter(ATMJigsawStructure::useExpansionHack),
                        Heightmap.Types.CODEC.optionalFieldOf("project_start_to_heightmap").forGetter(ATMJigsawStructure::projectStartToHeightmap),
                        JigsawStructure.MaxDistance.CODEC.fieldOf("max_distance_from_center").forGetter(ATMJigsawStructure::maxDistanceFromCenter),
                        Codec.list(PoolAliasBinding.CODEC).optionalFieldOf("pool_aliases", List.of()).forGetter(ATMJigsawStructure::poolAliases),
                        DimensionPadding.CODEC.optionalFieldOf("dimension_padding", ATMJigsawStructure.DEFAULT_DIMENSION_PADDING).forGetter(ATMJigsawStructure::dimensionPadding),
                        LiquidSettings.CODEC.optionalFieldOf("liquid_settings", ATMJigsawStructure.DEFAULT_LIQUID_SETTINGS).forGetter(ATMJigsawStructure::liquidSettings)
                ).apply(instance, factory::create)
        ).validate(ATMJigsawStructure::verifyRange);
    }
    
    @Override
    protected Optional<Structure.GenerationStub> findGenerationPoint(Structure.GenerationContext context) {
        ChunkPos chunkPos = context.chunkPos();
        int height = this.startHeight.sample(context.random(), new WorldGenerationContext(context.chunkGenerator(), context.heightAccessor()));
        BlockPos origin = new BlockPos(chunkPos.getMinBlockX(), height, chunkPos.getMinBlockZ());
        return JigsawPlacement.addPieces(
                context,
                this.startPool,
                this.startJigsawName,
                this.maxDepth,
                origin,
                this.useExpansionHack,
                this.projectStartToHeightmap,
                this.maxDistanceFromCenter,
                PoolAliasLookup.create(this.poolAliases, origin, context.seed()),
                this.dimensionPadding,
                this.liquidSettings
        );
    }
    
    private static <S extends ATMJigsawStructure> DataResult<S> verifyRange(S structure) {
        int edgeNeeded = switch (structure.terrainAdaptation()) {
            case NONE -> 0;
            case BURY, BEARD_THIN, BEARD_BOX, ENCAPSULATE -> 12;
        };
        int maxHorizontalRange = 128;
        return structure.maxDistanceFromCenter.horizontal() + edgeNeeded > maxHorizontalRange
                ? DataResult.error(() -> "Horizontal structure size including terrain adaptation must not exceed " + maxHorizontalRange)
                : DataResult.success(structure);
    }
    
    protected Holder<StructureTemplatePool> startPool() {
        return this.startPool;
    }
    
    protected Optional<Identifier> startJigsawName() {
        return this.startJigsawName;
    }
    
    protected int maxDepth() {
        return this.maxDepth;
    }
    
    protected HeightProvider startHeight() {
        return this.startHeight;
    }
    
    protected boolean useExpansionHack() {
        return this.useExpansionHack;
    }
    
    protected Optional<Heightmap.Types> projectStartToHeightmap() {
        return this.projectStartToHeightmap;
    }
    
    protected JigsawStructure.MaxDistance maxDistanceFromCenter() {
        return this.maxDistanceFromCenter;
    }
    
    protected List<PoolAliasBinding> poolAliases() {
        return this.poolAliases;
    }
    
    protected DimensionPadding dimensionPadding() {
        return this.dimensionPadding;
    }
    
    protected LiquidSettings liquidSettings() {
        return this.liquidSettings;
    }
    
    @FunctionalInterface
    protected interface StructureFactory<S extends ATMJigsawStructure> {
        
        S create(
                Structure.StructureSettings settings,
                Holder<StructureTemplatePool> startPool,
                Optional<Identifier> startJigsawName,
                int maxDepth,
                HeightProvider startHeight,
                boolean useExpansionHack,
                Optional<Heightmap.Types> projectStartToHeightmap,
                JigsawStructure.MaxDistance maxDistanceFromCenter,
                List<PoolAliasBinding> poolAliases,
                DimensionPadding dimensionPadding,
                LiquidSettings liquidSettings
        );
    }
}
