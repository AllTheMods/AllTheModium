package com.thevortex.allthemodium.config;

import java.util.List;

import net.minecraftforge.common.ForgeConfigSpec;

public class AllthemodiumCommonConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> ALLTHEMODIUM_QUARRYABLE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> UNOBTAINIUM_QUARRYABLE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> VIBRANIUM_QUARRYABLE;

    //public static final ForgeConfigSpec.ConfigValue<List<String>> ALLTHEMODIUM_BIOMES;

    static {
        BUILDER.push("AllTheModium Configs");
        ALLTHEMODIUM_QUARRYABLE = BUILDER
                .comment("Whether or not Allthemodium Ore should be quarryable or only player mineable")
                .define("Allthemodium Quarryable", false);
        UNOBTAINIUM_QUARRYABLE = BUILDER
                .comment("Whether or not Unobtainium Ore should be quarryable or only player mineable")
                .define("Unobtainium Quarryable", false);
        VIBRANIUM_QUARRYABLE = BUILDER
                .comment("Whether or not Vibranium Ore should be quarryable or only player mineable")
                .define("Vibranium Quarryable", false);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
