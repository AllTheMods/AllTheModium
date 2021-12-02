package com.thevortex.allthemodium.worldgen.structures;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.data.worldgen.ProcessorLists;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.structures.StructurePoolElement;
import net.minecraft.world.level.levelgen.feature.structures.StructureTemplatePool;

public class DungeonPieces {
    public static final StructureTemplatePool START = Pools.register(new StructureTemplatePool(new ResourceLocation("dungeon/start_pool"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(StructurePoolElement.single("fortress", ProcessorLists.EMPTY), 1)), StructureTemplatePool.Projection.RIGID));

    public static void bootstrap() {

    }
}
