package net.allthemods.allthemodium.data.worldgen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TimelineTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.attribute.BedRule;
import net.minecraft.world.attribute.EnvironmentAttributeMap;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.clock.WorldClock;
import net.minecraft.world.clock.WorldClocks;
import net.minecraft.world.level.CardinalLighting;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.timeline.Timeline;

import net.allthemods.allthemodium.api.ATM;

import java.util.Optional;

public class ATMDimensions {
    
    public static final ResourceKey<Level> MINING = ATMDimensions.createLevel("mining");
    public static final ResourceKey<Level> THE_OTHER = ATMDimensions.createLevel("the_other");
    public static final ResourceKey<Level> THE_BEYOND = ATMDimensions.createLevel("the_beyond");
    
    public static final ResourceKey<DimensionType> MINING_TYPE = ATMDimensions.createType("mining");
    public static final ResourceKey<DimensionType> THE_OTHER_TYPE = ATMDimensions.createType("the_other");
    public static final ResourceKey<DimensionType> THE_BEYOND_TYPE = ATMDimensions.createType("the_beyond");
    
    public static void bootstrap(final BootstrapContext<DimensionType> ctx) {
        HolderGetter<Timeline> timelines = ctx.lookup(Registries.TIMELINE);
        HolderGetter<WorldClock> clocks = ctx.lookup(Registries.WORLD_CLOCK);
        
        ctx.register(
                ATMDimensions.MINING_TYPE,
                new DimensionType(
                        false,
                        true,
                        false,
                        false,
                        1.0D,
                        -64,
                        384,
                        384,
                        BlockTags.INFINIBURN_OVERWORLD,
                        1.0F,
                        new DimensionType.MonsterSettings(
                                ConstantInt.of(0),
                                15
                        ),
                        DimensionType.Skybox.OVERWORLD,
                        CardinalLighting.Type.DEFAULT,
                        EnvironmentAttributeMap.builder()
                                .set(EnvironmentAttributes.BED_RULE, BedRule.EXPLODES)
                                .set(EnvironmentAttributes.FOG_COLOR, 0xC0D8FF)
                                .set(EnvironmentAttributes.SKY_COLOR, 0x6ED1FF)
                                .set(EnvironmentAttributes.WATER_FOG_COLOR, 0x050533)
                                .set(EnvironmentAttributes.AMBIENT_LIGHT_COLOR, 0x0A0A0A)
                                .build(),
                        timelines.getOrThrow(TimelineTags.IN_OVERWORLD),
                        Optional.of(clocks.getOrThrow(WorldClocks.OVERWORLD))
                )
        );
        
        ctx.register(
                ATMDimensions.THE_BEYOND_TYPE,
                new DimensionType(
                        false,
                        true,
                        false,
                        false,
                        50.0D,
                        -128,
                        512,
                        512,
                        BlockTags.INFINIBURN_OVERWORLD,
                        0.0F,
                        new DimensionType.MonsterSettings(
                                ConstantInt.of(15),
                                15
                        ),
                        DimensionType.Skybox.OVERWORLD,
                        CardinalLighting.Type.DEFAULT,
                        EnvironmentAttributeMap.builder()
                                .set(EnvironmentAttributes.RESPAWN_ANCHOR_WORKS, true)
                                .set(EnvironmentAttributes.PIGLINS_ZOMBIFY, false)
                                .set(EnvironmentAttributes.FOG_COLOR, 0xC0D8FF)
                                .set(EnvironmentAttributes.SKY_COLOR, 0x6ED1FF)
                                .set(EnvironmentAttributes.WATER_FOG_COLOR, 0x050533)
                                .set(EnvironmentAttributes.AMBIENT_LIGHT_COLOR, 0x0A0A0A)
                                .build(),
                        timelines.getOrThrow(TimelineTags.IN_OVERWORLD),
                        Optional.of(clocks.getOrThrow(WorldClocks.OVERWORLD))
                )
        );
        
        ctx.register(
                ATMDimensions.THE_OTHER_TYPE,
                new DimensionType(
                        true,
                        true,
                        false,
                        false,
                        12.0D, //This was 500 before, but this would obliterate the teleport pad logic by loading 500x500 chunks
                        -64,
                        384,
                        384,
                        BlockTags.INFINIBURN_OVERWORLD,
                        0.0F,
                        new DimensionType.MonsterSettings(
                                ConstantInt.of(15),
                                15
                        ),
                        DimensionType.Skybox.END,
                        CardinalLighting.Type.DEFAULT,
                        EnvironmentAttributeMap.builder()
                                .set(EnvironmentAttributes.RESPAWN_ANCHOR_WORKS, true)
                                .set(EnvironmentAttributes.PIGLINS_ZOMBIFY, false)
                                .set(EnvironmentAttributes.FOG_COLOR, 0x330303)
                                .set(EnvironmentAttributes.SKY_COLOR, 0x330303)
                                .set(EnvironmentAttributes.WATER_FOG_COLOR, 0x330303)
                                .set(EnvironmentAttributes.AMBIENT_LIGHT_COLOR, 0x0A0A0A)
                                .build(),
                        timelines.getOrThrow(TimelineTags.IN_OVERWORLD),
                        Optional.empty()
                )
        );
    }
    
    private static ResourceKey<Level> createLevel(String path) {
        return ATM.key(Registries.DIMENSION, path);
    }
    
    private static ResourceKey<DimensionType> createType(String path) {
        return ATM.key(Registries.DIMENSION_TYPE, path);
    }
}
