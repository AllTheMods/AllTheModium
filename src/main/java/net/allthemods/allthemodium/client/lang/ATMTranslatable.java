package net.allthemods.allthemodium.client.lang;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public interface ATMTranslatable {
    
    String key();
    
    String translation();
    
    default MutableComponent translate() {
        return Component.translatable(this.key());
    }
    
    default MutableComponent translate(ChatFormatting... formatting) {
        return Component.translatable(this.key()).withStyle(formatting);
    }
    
    default MutableComponent translate(Object... args) {
        return Component.translatable(this.key(), args);
    }
}
