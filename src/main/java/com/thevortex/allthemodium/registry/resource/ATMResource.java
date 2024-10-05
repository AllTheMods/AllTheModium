package com.thevortex.allthemodium.registry.resource;

import com.thevortex.allthemodium.registry.TagRegistry;
import java.util.function.Supplier;
import mekanism.common.resource.BlockResourceInfo;
import mekanism.common.resource.IResource;
import mekanism.common.resource.ResourceType;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;

public enum ATMResource implements IResource {
    ALLTHEMODIUM("allthemodium", 16701786, TagRegistry.ALLTHEMODIUM_ORE_ITEM), VIBRANIUM("vibranium", 2547336,
            TagRegistry.VIBRANIUM_ORE_ITEM), UNOBTAINIUM("unobtainium", 13718243, TagRegistry.UNOBTAINIUM_ORE_ITEM);

    private final String name;
    private final int tint;
    // Note: This is a supplier because of the chicken and egg of referencing OreType and OreType referencing PrimaryResource
    private final Supplier<TagKey<Item>> oreTag;
    private final boolean isVanilla;
    private final BlockResourceInfo resourceBlockInfo;
    private final BlockResourceInfo rawResourceBlockInfo;

    ATMResource(String name, int colour, TagKey<Item> oreTag) {
        this(name, colour, () -> oreTag, true, null, null);
    }

    ATMResource(
            String name,
            int tint,
            Supplier<TagKey<Item>> oreTag,
            boolean isVanilla,
            BlockResourceInfo resourceBlockInfo,
            BlockResourceInfo rawResourceBlockInfo) {
        this.name = name;
        this.tint = tint;
        this.oreTag = oreTag;
        this.isVanilla = isVanilla;
        this.resourceBlockInfo = resourceBlockInfo;
        this.rawResourceBlockInfo = rawResourceBlockInfo;
    }

    @Override
    public String getRegistrySuffix() {
        return name;
    }

    public int getTint() {
        return tint;
    }

    public TagKey<Item> getOreTag() {
        return oreTag.get();
    }

    public boolean has(ResourceType type) {
        return (type != ResourceType.ENRICHED && (!isVanilla || !type.isVanilla()));
    }

    public boolean isVanilla() {
        return isVanilla;
    }

    @Nullable
    public BlockResourceInfo getResourceBlockInfo() {
        return resourceBlockInfo;
    }

    @Nullable
    public BlockResourceInfo getRawResourceBlockInfo() {
        return rawResourceBlockInfo;
    }
}
