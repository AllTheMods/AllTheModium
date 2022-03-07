package com.thevortex.allthemodium.datagen.server;

import com.thevortex.allthemodium.reference.TagRegistry;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class FluidTags extends FluidTagsProvider {
    public FluidTags(DataGenerator p_126523_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_126523_, modId, existingFileHelper);
    }
    @Override
    protected void addTags() {

    tag(TagRegistry.SOUL_LAVA).add(ModRegistry.blueLava.get());
    tag(TagRegistry.SOUL_LAVA).add(ModRegistry.flowing_blueLava.get());
    tag(net.minecraft.tags.FluidTags.LAVA).add(ModRegistry.blueLava.get());
    tag(net.minecraft.tags.FluidTags.LAVA).add(ModRegistry.flowing_blueLava.get());

    tag(TagRegistry.ALLTHEMODIUM).add(ModRegistry.moltenAllthemodium.get());
    tag(TagRegistry.VIBRANIUM).add(ModRegistry.moltenVibranium.get());
    tag(TagRegistry.UNOBTAINIUM).add(ModRegistry.moltenUnobtainium.get());
    }

}
