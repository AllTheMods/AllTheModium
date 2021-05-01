package com.thevortex.allthemodium.events;

import com.thevortex.allthemodium.AllTheModium;
import com.thevortex.allthemodium.init.ModItems;
import com.thevortex.allthemodium.reference.Reference;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.FORGE)
public class BlockBreak {

	@SubscribeEvent
	public static void on(BreakEvent event) {
		if(event.getPlayer().isCreative()) { return; }

		if((event.getState().getBlock().getTags().contains(Reference.ORETYPE)) && ((event.getPlayer() instanceof FakePlayer) || (event.getPlayer() == null) || (event.getPlayer().getMainHandItem().isEmpty()))) {
			
			event.setCanceled(true);
			return;
		}
		if((event.getState().getBlock().getTags().contains(Reference.ORETYPE2)) && ((event.getPlayer() instanceof FakePlayer) || (event.getPlayer() == null || (event.getPlayer().getMainHandItem().isEmpty())))) {
			
			event.setCanceled(true);
			return;
		}
		if((event.getState().getBlock().getTags().contains(Reference.ORETYPE3)) && ((event.getPlayer() instanceof FakePlayer) || (event.getPlayer() == null) || (event.getPlayer().getMainHandItem().isEmpty()))) {
			
			event.setCanceled(true);
			return;
		}
		if(event.getPlayer() instanceof FakePlayer) {

			return;
		}

		
	}


	
}
