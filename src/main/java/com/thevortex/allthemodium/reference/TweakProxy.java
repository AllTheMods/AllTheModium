package com.thevortex.allthemodium.reference;

import com.thevortex.allthetweaks.config.Configuration;
import net.minecraftforge.fml.ModList;

public class TweakProxy {

    public static int packMode() {
        if(ModList.get().isLoaded("allthetweaks")){
            return Configuration.COMMON.mainmode.get();
        }
        else {
            return 0;
        }
    }
}
