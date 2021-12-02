package com.thevortex.allthemodium.worldgen.structures;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.data.worldgen.ProcessorLists;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.structures.StructurePoolElement;
import net.minecraft.world.level.levelgen.feature.structures.StructureTemplatePool;

public class VillagePieces {
    public static final StructureTemplatePool START = Pools.register(new StructureTemplatePool(new ResourceLocation(Reference.MOD_ID + ":village/start_pool"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(StructurePoolElement.single(Reference.MOD_ID + ":illager_keep", ProcessorLists.EMPTY), 1)), StructureTemplatePool.Projection.RIGID));

    public static void bootstrap() {

    }
}
