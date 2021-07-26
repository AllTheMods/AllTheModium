package com.thevortex.allthemodium.datagen;

import com.thevortex.allthemodium.datagen.client.BlockStates;
import com.thevortex.allthemodium.datagen.client.ItemModels;
import com.thevortex.allthemodium.datagen.server.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

import java.io.IOException;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public final class DataGenerators {
    private DataGenerators() {}

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) throws IOException {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        if (event.includeServer()) {
            BlockTagsProvider blockTagsProvider = new BlockTags(generator, fileHelper);
            generator.addProvider(new ItemTags(generator, blockTagsProvider, fileHelper));
            generator.addProvider(blockTagsProvider);
            generator.addProvider(new CraftingRecipes(generator));
            generator.addProvider(new ShapelessCrafting(generator));
            generator.addProvider(new BlastingRecipes(generator));
            generator.addProvider(new SmeltingRecipes(generator));
            //generator.addProvider(new LootTables(generator));
        }
        if (event.includeClient()) {
            generator.addProvider(new BlockStates(generator, fileHelper));
            generator.addProvider(new ItemModels(generator, fileHelper));
        }
    }
}
