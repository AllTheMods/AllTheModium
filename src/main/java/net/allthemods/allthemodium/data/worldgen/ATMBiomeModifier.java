package net.allthemods.allthemodium.data.worldgen;

import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.alltheores.common.material.Material;

public class ATMBiomeModifier {
    
    public static final ResourceKey<BiomeModifier> ALLTHEMODIUM = ATMBiomeModifier.create("allthemodium");
    public static final ResourceKey<BiomeModifier> VIBRANIUM = ATMBiomeModifier.create("vibranium");
    public static final ResourceKey<BiomeModifier> UNOBTAINIUM = ATMBiomeModifier.create("unobtainium");
    
    public static void bootstrap(final BootstrapContext<BiomeModifier> ctx) {
        HolderGetter<Biome> biomes = ctx.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placed = ctx.lookup(Registries.PLACED_FEATURE);
        
        ctx.register(
                ATMBiomeModifier.ALLTHEMODIUM,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        HolderSet.direct(biomes.getOrThrow(Biomes.DEEP_DARK)),
                        HolderSet.direct(placed.getOrThrow(ATMPlacedFeatures.ALLTHEMODIUM)),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );
        ctx.register(
                ATMBiomeModifier.VIBRANIUM,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(Tags.Biomes.IS_NETHER),
                        HolderSet.direct(placed.getOrThrow(ATMPlacedFeatures.VIBRANIUM)),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );
        ctx.register(
                ATMBiomeModifier.UNOBTAINIUM,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        HolderSet.direct(biomes.getOrThrow(Biomes.END_HIGHLANDS)),
                        HolderSet.direct(placed.getOrThrow(ATMPlacedFeatures.UNOBTAINIUM)),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );
        
        Material.forAll(material -> {
            if (material.getWorldGen() == null) return;
            
            ctx.register(
                    ATMBiomeModifier.create("mining/" + material.getGroup()),
                    new BiomeModifiers.AddFeaturesBiomeModifier(
                            HolderSet.direct(biomes.getOrThrow(ATMBiomes.MINING)),
                            HolderSet.direct(placed.getOrThrow(material.getPlacedOreFeatureKey())),
                            GenerationStep.Decoration.UNDERGROUND_ORES
                    )
            );
        });
    }
    
    private static ResourceKey<BiomeModifier> create(String path) {
        return ATM.key(NeoForgeRegistries.Keys.BIOME_MODIFIERS, path);
    }
}
