package com.thevortex.allthemodium.events;


import com.thevortex.allthemodium.AllTheModium;
import com.thevortex.allthemodium.config.AllthemodiumCommonConfigs;
import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.TagRegistry;

import net.minecraft.client.Minecraft;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.FORGE)
public class BlockBreak {


	@SubscribeEvent
	public static void on(BlockEvent.BreakEvent event) {
		if(event.getPlayer().isCreative()) { return; }

		boolean fakePlayer = (event.getPlayer() instanceof FakePlayer) || (event.getPlayer() == null);
		boolean emptyHand = event.getPlayer().getMainHandItem().isEmpty();

		if((event.getState().is(TagRegistry.OTHER_PROTECTION)) && fakePlayer && event.getLevel().getBiome(event.getPos()).is(TagRegistry.OTHER_BIOMES)) {

			event.setCanceled(true);
			return;
		}
		if((event.getState().is(TagRegistry.ALLTHEMODIUM_ORE)) && (fakePlayer || emptyHand) && !AllthemodiumCommonConfigs.ALLTHEMODIUM_QUARRYABLE.get()) {
			
			event.setCanceled(true);
			return;
		}

		if((event.getState().is(TagRegistry.VIBRANIUM_ORE)) && (fakePlayer || emptyHand) && !AllthemodiumCommonConfigs.VIBRANIUM_QUARRYABLE.get()) {
			
			event.setCanceled(true);
			return;
		}
		if((event.getState().is(TagRegistry.UNOBTAINIUM_ORE)) && (fakePlayer || emptyHand) && !AllthemodiumCommonConfigs.UNOBTAINIUM_QUARRYABLE.get()) {
			
			event.setCanceled(true);
			return;
		}
		if(event.getPlayer() instanceof FakePlayer) {

			return;
		}
	}
}
