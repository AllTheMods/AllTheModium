package com.thevortex.allthemodium.datagen.server;


import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.reference.TagRegistry;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemTags extends ItemTagsProvider {


    public ItemTags(DataGenerator generator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(generator, blockTagsProvider, Reference.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {

        tag(TagRegistry.ALLTHEMODIUM_BLOCK_ITEM).add(ModRegistry.ALLTHEMODIUM_BLOCK_ITEM.get());
        tag(TagRegistry.VIBRANIUM_BLOCK_ITEM).add(ModRegistry.VIBRANIUM_BLOCK_ITEM.get());
        tag(TagRegistry.UNOBTAINIUM_BLOCK_ITEM).add(ModRegistry.UNOBTAINIUM_BLOCK_ITEM.get());

        tag(TagRegistry.ALLTHEMODIUM_ORE_ITEM).add(ModRegistry.ALLTHEMODIUM_ORE_ITEM.get());
        tag(TagRegistry.VIBRANIUM_ORE_ITEM).add(ModRegistry.VIBRANIUM_ORE_ITEM.get());
        tag(TagRegistry.UNOBTAINIUM_ORE_ITEM).add(ModRegistry.UNOBTAINIUM_ORE_ITEM.get());

        tag(TagRegistry.ALLTHEMODIUM_GEAR).add(ModRegistry.ATM_GEAR.get());
        tag(TagRegistry.VIBRANIUM_GEAR).add(ModRegistry.VIB_GEAR.get());
        tag(TagRegistry.UNOBTAINIUM_GEAR).add(ModRegistry.ONOB_GEAR.get());

        tag(TagRegistry.ALLTHEMODIUM_PLATE).add(ModRegistry.ATM_PLATE.get());
        tag(TagRegistry.VIBRANIUM_PLATE).add(ModRegistry.VIB_PLATE.get());
        tag(TagRegistry.UNOBTAINIUM_PLATE).add(ModRegistry.ONOB_PLATE.get());

        tag(TagRegistry.ALLTHEMODIUM_ROD).add(ModRegistry.ATM_ROD.get());
        tag(TagRegistry.VIBRANIUM_ROD).add(ModRegistry.VIB_ROD.get());
        tag(TagRegistry.UNOBTAINIUM_ROD).add(ModRegistry.ONOB_ROD.get());

    }
}
