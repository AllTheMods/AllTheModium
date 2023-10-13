package com.thevortex.allthemodium.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class AllthemodiumClientConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    static {
        BUILDER.push("AllTheModium Configs");

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
