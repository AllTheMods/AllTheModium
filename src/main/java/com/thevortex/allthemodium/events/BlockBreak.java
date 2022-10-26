package com.thevortex.allthemodium.events;


import com.thevortex.allthemodium.registry.TagRegistry;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.FORGE)
public class BlockBreak {


	@SubscribeEvent
	public static void on(BlockEvent.BreakEvent event) {
		if(event.getPlayer().isCreative()) { return; }

		if((event.getState().is(TagRegistry.OTHER_PROTECTION)) && ((event.getPlayer() instanceof FakePlayer) || (event.getPlayer() == null)) && ((!event.getLevel().dimensionType().hasCeiling()) && (event.getLevel().dimensionType().piglinSafe()) && (!event.getLevel().dimensionType().hasFixedTime()))) {

			event.setCanceled(true);
			return;
		}
		if((event.getState().is(TagRegistry.ALLTHEMODIUM_ORE)) && ((event.getPlayer() instanceof FakePlayer) || (event.getPlayer() == null) || (event.getPlayer().getMainHandItem().isEmpty()))) {
			
			event.setCanceled(true);
			return;
		}

		if((event.getState().is(TagRegistry.VIBRANIUM_ORE)) && ((event.getPlayer() instanceof FakePlayer) || (event.getPlayer() == null || (event.getPlayer().getMainHandItem().isEmpty())))) {
			
			event.setCanceled(true);
			return;
		}
		if((event.getState().is(TagRegistry.UNOBTAINIUM_ORE)) && ((event.getPlayer() instanceof FakePlayer) || (event.getPlayer() == null) || (event.getPlayer().getMainHandItem().isEmpty()))) {
			
			event.setCanceled(true);
			return;
		}
		if(event.getPlayer() instanceof FakePlayer) {

			return;
		}

		
	}


	
}
