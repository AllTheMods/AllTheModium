package com.thevortex.allthemodium.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class AllthemodiumServerConfigs {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> ALLTHEMODIUM_QUARRYABLE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> UNOBTAINIUM_QUARRYABLE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> VIBRANIUM_QUARRYABLE;

    public static final ForgeConfigSpec.ConfigValue<Boolean> OTHER_PROTECTION;

    // public static final ForgeConfigSpec.ConfigValue<List<String>> ALLTHEMODIUM_BIOMES;

    static {
        BUILDER.push("AllTheModium Configs");
        ALLTHEMODIUM_QUARRYABLE = BUILDER
                .comment(
                        "Whether or not Allthemodium Ore should be quarryable or only player mineable. (Default value: false)")
                .define("Allthemodium Quarryable", false);
        UNOBTAINIUM_QUARRYABLE = BUILDER
                .comment(
                        "Whether or not Unobtainium Ore should be quarryable or only player mineable. (Default value: false)")
                .define("Unobtainium Quarryable", false);
        VIBRANIUM_QUARRYABLE = BUILDER
                .comment(
                        "Whether or not Vibranium Ore should be quarryable or only player mineable. (Default value: false)")
                .define("Vibranium Quarryable", false);
        OTHER_PROTECTION = BUILDER
                .comment(
                        "Whether The Other is protected from quarries. (Default value: true)")
                .define("Other Protection", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
