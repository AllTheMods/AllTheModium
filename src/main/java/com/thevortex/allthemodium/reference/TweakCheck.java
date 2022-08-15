package com.thevortex.allthemodium.reference;

import com.thevortex.allthetweaks.config.Configuration;

public class TweakCheck {

    public static boolean init() {

        return (Configuration.COMMON.mainmode.get() != 2);
    }
}
