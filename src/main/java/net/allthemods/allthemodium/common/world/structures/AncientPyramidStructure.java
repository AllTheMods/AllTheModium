package net.allthemods.allthemodium.common.world.structures;

import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pools.DimensionPadding;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.pools.alias.PoolAliasBinding;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings;

import net.allthemods.allthemodium.core.registry.ATMStructureTypes;

import com.mojang.serialization.MapCodec;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public class AncientPyramidStructure extends ATMJigsawStructure {
    
    public static final MapCodec<AncientPyramidStructure> CODEC = ATMJigsawStructure.codec(AncientPyramidStructure::new);
    
    protected AncientPyramidStructure(
            StructureSettings settings,
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
        super(
                settings,
                startPool,
                startJigsawName,
                maxDepth,
                startHeight,
                useExpansionHack,
                projectStartToHeightmap,
                maxDistanceFromCenter,
                poolAliases,
                dimensionPadding,
                liquidSettings
        );
    }
    
    public AncientPyramidStructure(
            Structure.StructureSettings settings,
            Holder<StructureTemplatePool> startPool,
            int maxDepth,
            int startHeight,
            boolean useExpansionHack,
            Heightmap.Types projectStartToHeightmap,
            int maxDistanceFromCenter
    ) {
        super(settings, startPool, maxDepth, startHeight, useExpansionHack, projectStartToHeightmap, maxDistanceFromCenter);
    }
    
    @Override
    public StructureType<?> type() {
        return ATMStructureTypes.ANCIENT_PYRAMID.get();
    }
}
