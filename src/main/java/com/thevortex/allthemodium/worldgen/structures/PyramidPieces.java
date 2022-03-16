package com.thevortex.allthemodium.worldgen.structures;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

public class PyramidPieces {
    public static final Holder<StructureTemplatePool> START = Pools.register(new StructureTemplatePool(new ResourceLocation(Reference.MOD_ID, "pyramid/start_pool"), new ResourceLocation(Reference.MOD_ID, "pyramid/start_pool"), ImmutableList.of(Pair.of(StructurePoolElement.legacy(Reference.MOD_ID + ":ancient_pyramid_1", ProcessorLists.EMPTY), 1)), StructureTemplatePool.Projection.RIGID));

    public static void bootstrap() {

    }
}
