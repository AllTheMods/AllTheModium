package net.allthemods.allthemodium.api;

import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

public class ATM {
    
    public static final String MOD_ID = "allthemodium";
    
    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(ATM.MOD_ID, path);
    }
    
    public static Identifier c(String path) {
        return Identifier.fromNamespaceAndPath("c", path);
    }
    
    public static <T> ResourceKey<T> key(ResourceKey<? extends Registry<T>> registryKey, String path) {
        return ResourceKey.create(registryKey, ATM.id(path));
    }
}
