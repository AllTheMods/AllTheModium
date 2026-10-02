package net.allthemods.allthemodium.data.provider;

import net.neoforged.neoforge.client.data.SpriteSourceProvider;

import net.minecraft.client.renderer.texture.atlas.sources.PalettedPermutations;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.AtlasIds;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import net.minecraft.world.item.equipment.trim.TrimPattern;
import net.minecraft.world.item.equipment.trim.TrimPatterns;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.core.registry.ATMTrimMaterials;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ATMSpriteSourceProvider extends SpriteSourceProvider {

    private static final Identifier TRIM_PALETTE_KEY = Identifier.withDefaultNamespace("trims/color_palettes/trim_palette");

    private static final List<ResourceKey<TrimPattern>> PATTERNS = List.of(
            TrimPatterns.SENTRY,
            TrimPatterns.DUNE,
            TrimPatterns.COAST,
            TrimPatterns.WILD,
            TrimPatterns.WARD,
            TrimPatterns.EYE,
            TrimPatterns.VEX,
            TrimPatterns.TIDE,
            TrimPatterns.SNOUT,
            TrimPatterns.RIB,
            TrimPatterns.SPIRE,
            TrimPatterns.WAYFINDER,
            TrimPatterns.SHAPER,
            TrimPatterns.SILENCE,
            TrimPatterns.RAISER,
            TrimPatterns.HOST,
            TrimPatterns.FLOW,
            TrimPatterns.BOLT
    );

    private static final List<EquipmentClientInfo.LayerType> HUMANOID_LAYERS = List.of(
            EquipmentClientInfo.LayerType.HUMANOID,
            EquipmentClientInfo.LayerType.HUMANOID_LEGGINGS
    );

    private static final List<MaterialAssetGroup> ASSETS = List.of(
            ATMTrimMaterials.ALLTHEMODIUM_ASSETS,
            ATMTrimMaterials.VIBRANIUM_ASSETS,
            ATMTrimMaterials.UNOBTAINIUM_ASSETS
    );

    public ATMSpriteSourceProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, ATM.MOD_ID);
    }

    @Override
    protected void gather() {
        this.atlas(AtlasIds.ARMOR_TRIMS)
                .addSource(new PalettedPermutations(ATMSpriteSourceProvider.patternTextures(), TRIM_PALETTE_KEY, ATMSpriteSourceProvider.palettes()));
    }

    private static List<Identifier> patternTextures() {
        List<Identifier> textures = new ArrayList<>(PATTERNS.size() * HUMANOID_LAYERS.size());

        for (ResourceKey<TrimPattern> pattern : PATTERNS) {
            Identifier assetId = TrimPatterns.defaultAssetId(pattern);

            for (EquipmentClientInfo.LayerType layer : HUMANOID_LAYERS) {
                textures.add(assetId.withPath(path -> layer.trimAssetPrefix() + "/" + path));
            }
        }

        return textures;
    }

    private static Map<String, Identifier> palettes() {
        return ASSETS.stream()
                .flatMap(group -> Stream.concat(Stream.of(group.base()), group.overrides().values().stream()))
                .collect(Collectors.toMap(MaterialAssetGroup.AssetInfo::suffix, asset -> ATM.id("trims/color_palettes/" + asset.suffix())));
    }
}
