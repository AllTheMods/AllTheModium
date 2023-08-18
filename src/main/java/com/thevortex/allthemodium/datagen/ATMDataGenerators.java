package com.thevortex.allthemodium.datagen;

import com.thevortex.allthemodium.datagen.client.BlockStates;
import com.thevortex.allthemodium.datagen.client.ItemModels;
import com.thevortex.allthemodium.datagen.server.*;
import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Reference.MOD_ID)
public final class ATMDataGenerators {

    private ATMDataGenerators() {

    }


    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) throws IOException {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        if (event.includeServer()) {
            ATMBlockTags blockTags1 = new ATMBlockTags(packOutput,event.getLookupProvider(), fileHelper);
            generator.addProvider(true, blockTags1);
            generator.addProvider(true,new ATMItemTags(packOutput,event.getLookupProvider(), blockTags1.contentsGetter(), fileHelper));
            generator.addProvider(true,new ATMCraftingRecipes(packOutput));
            generator.addProvider(true,new LootTableProvider(packOutput, Collections.emptySet(),
                    List.of(new LootTableProvider.SubProviderEntry(ATMLootTables::new, LootContextParamSets.BLOCK))));
        }
        if (event.includeClient()) {
            generator.addProvider(true,new BlockStates(generator, fileHelper));
            generator.addProvider(true,new ItemModels(generator, fileHelper));
        }
    }
}
