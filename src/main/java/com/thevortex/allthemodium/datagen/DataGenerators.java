package com.thevortex.allthemodium.datagen;

import com.thevortex.allthemodium.datagen.client.BlockStates;
import com.thevortex.allthemodium.datagen.client.ItemModels;
import com.thevortex.allthemodium.datagen.server.*;
import com.thevortex.allthemodium.reference.Reference;
import java.io.IOException;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public final class DataGenerators {

    private DataGenerators() {
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) throws IOException {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        if (event.includeServer()) {
            BlockTagsProvider blockTagsProvider = new BlockTags(
                    generator,
                    fileHelper);
            generator.addProvider(
                    true,
                    new ItemTags(generator, blockTagsProvider, fileHelper));
            generator.addProvider(true, blockTagsProvider);
            generator.addProvider(
                    true,
                    new FluidTags(generator, Reference.MOD_ID, fileHelper));
            generator.addProvider(true, new CraftingRecipes(generator));
            generator.addProvider(true, new ShapelessCrafting(generator));
            generator.addProvider(true, new BlastingRecipes(generator));
            generator.addProvider(true, new SmeltingRecipes(generator));
            generator.addProvider(true, new LootTables(generator));
        }
        if (event.includeClient()) {
            generator.addProvider(true, new BlockStates(generator, fileHelper));
            generator.addProvider(true, new ItemModels(generator, fileHelper));
        }
    }
}
