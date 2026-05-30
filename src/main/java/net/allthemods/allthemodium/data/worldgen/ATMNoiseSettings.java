package net.allthemods.allthemodium.data.worldgen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.NoiseSettings;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.core.registry.ATMBlocks;

import java.util.List;

public class ATMNoiseSettings {

    public static final ResourceKey<NoiseGeneratorSettings> THE_OTHER = ATM.key(Registries.NOISE_SETTINGS, "the_other");

    private static final int ISLAND_MIN_Y = 0;
    private static final int ISLAND_HEIGHT = 256;

    public static void bootstrap(final BootstrapContext<NoiseGeneratorSettings> ctx) {
        HolderGetter<DensityFunction> functions = ctx.lookup(Registries.DENSITY_FUNCTION);
        HolderGetter<NormalNoise.NoiseParameters> noises = ctx.lookup(Registries.NOISE);

        ctx.register(ATMNoiseSettings.THE_OTHER, new NoiseGeneratorSettings(
                NoiseSettings.create(ISLAND_MIN_Y, ISLAND_HEIGHT, 2, 1),
                ATMBlocks.ANCIENT_STONE.get().defaultBlockState(),
                Blocks.AIR.defaultBlockState(),
                ATMNoiseSettings.router(functions, noises),
                ATMNoiseSettings.surfaceRule(),
                ATMNoiseSettings.spawnTarget(),
                63,
                false,
                false,
                false,
                false
        ));
    }

    private static NoiseRouter router(HolderGetter<DensityFunction> functions, HolderGetter<NormalNoise.NoiseParameters> noises) {
        DensityFunction shiftX = ref(functions, "shift_x");
        DensityFunction shiftZ = ref(functions, "shift_z");
        DensityFunction temperature = DensityFunctions.shiftedNoise2d(shiftX, shiftZ, 0.25, noises.getOrThrow(Noises.TEMPERATURE));
        DensityFunction vegetation = DensityFunctions.shiftedNoise2d(shiftX, shiftZ, 0.25, noises.getOrThrow(Noises.VEGETATION));

        DensityFunction island = islandDensity(ref(functions, "end/base_3d_noise"));

        return new NoiseRouter(
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                temperature,
                vegetation,
                ref(functions, "overworld/continents"),
                ref(functions, "overworld/erosion"),
                ref(functions, "overworld/depth"),
                ref(functions, "overworld/ridges"),
                DensityFunctions.zero(),
                island,
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero()
        );
    }

    private static DensityFunction islandDensity(DensityFunction base3dNoise) {
        DensityFunction slid = slide(base3dNoise, ISLAND_MIN_Y, ISLAND_HEIGHT, 72, -184, -23.4375, 4, 32, -0.234375);
        DensityFunction blended = DensityFunctions.blendDensity(slid);
        return DensityFunctions.mul(DensityFunctions.interpolated(blended), DensityFunctions.constant(0.64)).squeeze();
    }

    private static DensityFunction slide(DensityFunction noise, int minY, int height, int topStartY, int topEndY, double topTarget, int bottomStartY, int bottomEndY, double bottomTarget) {
        DensityFunction topFactor = DensityFunctions.yClampedGradient(minY + height - topStartY, minY + height - topEndY, 1.0, 0.0);
        DensityFunction withTop = DensityFunctions.lerp(topFactor, topTarget, noise);
        DensityFunction bottomFactor = DensityFunctions.yClampedGradient(minY + bottomStartY, minY + bottomEndY, 0.0, 1.0);
        return DensityFunctions.lerp(bottomFactor, bottomTarget, withTop);
    }

    private static SurfaceRules.RuleSource surfaceRule() {
        SurfaceRules.RuleSource surface = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ATMBiomes.SOUL_SAND_VALLEY), SurfaceRules.state(Blocks.SOUL_SAND.defaultBlockState())),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ATMBiomes.CRIMSON_FOREST), SurfaceRules.state(Blocks.CRIMSON_NYLIUM.defaultBlockState())),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ATMBiomes.WARPED_FOREST), SurfaceRules.state(Blocks.WARPED_NYLIUM.defaultBlockState())),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ATMBiomes.DESERT, ATMBiomes.DESERT_HILLS), SurfaceRules.state(Blocks.SAND.defaultBlockState())),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ATMBiomes.THE_OTHER), SurfaceRules.state(ATMBlocks.ANCIENT_GRASS.get().defaultBlockState()))
        );
        SurfaceRules.RuleSource subsurface = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ATMBiomes.SOUL_SAND_VALLEY), SurfaceRules.state(Blocks.SOUL_SOIL.defaultBlockState())),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ATMBiomes.DESERT, ATMBiomes.DESERT_HILLS), SurfaceRules.state(Blocks.SANDSTONE.defaultBlockState())),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ATMBiomes.CRIMSON_FOREST, ATMBiomes.WARPED_FOREST, ATMBiomes.THE_OTHER), SurfaceRules.state(ATMBlocks.ANCIENT_DIRT.get().defaultBlockState()))
        );
        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(-2, true, 2, CaveSurface.FLOOR), surface),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), subsurface)
        );
    }

    private static List<Climate.ParameterPoint> spawnTarget() {
        return List.of(
                Climate.parameters(Climate.Parameter.span(-1.0F, 1.0F), Climate.Parameter.span(-1.0F, 1.0F), Climate.Parameter.span(-0.11F, 1.0F), Climate.Parameter.span(-1.0F, 1.0F), Climate.Parameter.point(0.0F), Climate.Parameter.span(-1.0F, -0.16F), 0.0F),
                Climate.parameters(Climate.Parameter.span(-1.0F, 1.0F), Climate.Parameter.span(-1.0F, 1.0F), Climate.Parameter.span(-0.11F, 1.0F), Climate.Parameter.span(-1.0F, 1.0F), Climate.Parameter.point(0.0F), Climate.Parameter.span(0.16F, 1.0F), 0.0F)
        );
    }

    private static DensityFunction ref(HolderGetter<DensityFunction> functions, String name) {
        return new DensityFunctions.HolderHolder(functions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.withDefaultNamespace(name))));
    }
}
