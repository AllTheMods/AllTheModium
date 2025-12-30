package com.thevortex.allthemodium.registry;

import com.mojang.serialization.MapCodec;
import com.thevortex.allthemodium.chunkgenerator.CustomFlatLevelSource;
import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ChunkGenRegistry {
    public static final DeferredRegister<MapCodec<? extends ChunkGenerator>> CHUNKGENERATORS = DeferredRegister.create(Registries.CHUNK_GENERATOR, Reference.MOD_ID);

    static {
        CHUNKGENERATORS.register("flat", () -> CustomFlatLevelSource.CODEC);
    }

}
