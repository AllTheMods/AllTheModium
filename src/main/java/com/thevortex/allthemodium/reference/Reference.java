package com.thevortex.allthemodium.reference;

import net.minecraft.resources.ResourceLocation;


public class Reference {

	public static final ResourceLocation ORETYPE = location("forge:ores/allthemodium");
	public static final ResourceLocation ORETYPE2 = location("forge:ores/vibranium");
	public static final ResourceLocation ORETYPE3 = location("forge:ores/unobtainium");
	public static final String MOD_ID = "allthemodium";
	
	public static ResourceLocation location(String pathIn) {
		return new ResourceLocation(pathIn);
	}

}
