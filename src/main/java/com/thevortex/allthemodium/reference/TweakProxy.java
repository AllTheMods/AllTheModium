package com.thevortex.allthemodium.reference;

import com.thevortex.allthetweaks.config.Configuration;

public class TweakProxy {

    public static int packMode() {
        return Configuration.COMMON.mainmode.get();
    }
}
