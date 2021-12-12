package com.thevortex.allthemodium.datagen.server;


import com.thevortex.allthemodium.registry.ModRegistry;
import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.reference.TagRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;


public class BlockTags extends BlockTagsProvider {

    public BlockTags(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, Reference.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        //tag(TagRegistry.ANCIENT_STONE).add(ModRegistry.ANCIENT_STONE.get());

        tag(net.minecraft.tags.BlockTags.NYLIUM).add(ModRegistry.ANCIENT_STONE.get());
        tag(net.minecraft.tags.BlockTags.BASE_STONE_OVERWORLD).add(ModRegistry.ANCIENT_STONE.get());
        tag(net.minecraft.tags.BlockTags.DEEPSLATE_ORE_REPLACEABLES).add(ModRegistry.ANCIENT_STONE.get());
        tag(net.minecraft.tags.BlockTags.BASE_STONE_NETHER).add(ModRegistry.ANCIENT_STONE.get());
        tag(net.minecraft.tags.BlockTags.AZALEA_GROWS_ON).add(ModRegistry.ANCIENT_STONE.get());
        tag(net.minecraft.tags.BlockTags.AZALEA_ROOT_REPLACEABLE).add(ModRegistry.ANCIENT_STONE.get());
        tag(net.minecraft.tags.BlockTags.INFINIBURN_NETHER).add(ModRegistry.ANCIENT_STONE.get());
        tag(net.minecraft.tags.BlockTags.LUSH_GROUND_REPLACEABLE).add(ModRegistry.ANCIENT_STONE.get());
        tag(net.minecraft.tags.BlockTags.STONE_ORE_REPLACEABLES).add(ModRegistry.ANCIENT_STONE.get());
        tag(net.minecraft.tags.BlockTags.BIG_DRIPLEAF_PLACEABLE).add(ModRegistry.ANCIENT_STONE.get());
        tag(net.minecraft.tags.BlockTags.SMALL_DRIPLEAF_PLACEABLE).add(ModRegistry.ANCIENT_STONE.get());

        tag(net.minecraft.tags.BlockTags.DIRT).add(ModRegistry.ANCIENT_DIRT.get());
        tag(TagRegistry.ALLTHEMODIUM_BLOCK).add(ModRegistry.ALLTHEMODIUM_BLOCK.get());
        tag(TagRegistry.ALLTHEMODIUM_ORE).add(ModRegistry.ALLTHEMODIUM_ORE.get());
        tag(TagRegistry.ALLTHEMODIUM_ORE).add(ModRegistry.ALLTHEMODIUM_SLATE_ORE.get());
        tag(TagRegistry.VIBRANIUM_BLOCK).add(ModRegistry.VIBRANIUM_BLOCK.get());
        tag(TagRegistry.VIBRANIUM_ORE).add(ModRegistry.VIBRANIUM_ORE.get());
        tag(TagRegistry.UNOBTAINIUM_BLOCK).add(ModRegistry.UNOBTAINIUM_BLOCK.get());
        tag(TagRegistry.UNOBTAINIUM_ORE).add(ModRegistry.UNOBTAINIUM_ORE.get());
        }
}
