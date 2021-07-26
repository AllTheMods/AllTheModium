package com.thevortex.allthemodium.datagen.client;

import com.thevortex.allthemodium.registry.ModRegistry;
import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModels extends ItemModelProvider {

    public ItemModels(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, Reference.MOD_ID, fileHelper);
    }

    private ResourceLocation res(String name) {
        return new ResourceLocation(Reference.MOD_ID, ITEM_FOLDER + "/" + name);
    }

    @Override
    protected void registerModels() {
        ResourceLocation generated = new ResourceLocation("item/generated");

        ModRegistry.ITEMS.getEntries().stream()
            .filter(item -> !(item.get() instanceof BlockItem))
            .forEach(item -> {
                String name = item.getId().getPath();
                if(!name.contains("bucket")){
                withExistingParent(name, generated)
                    .texture("layer0", res(name));

            }});
    }
}
