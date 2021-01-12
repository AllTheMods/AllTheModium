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
		if(event.getPlayer().isCreative() == true) { return; }
		if((event.getState().getBlock().getTags().contains(Reference.ORETYPE) == true) && ((event.getPlayer() instanceof FakePlayer) || (event.getPlayer() == null) || (event.getPlayer().getHeldItemMainhand().isEmpty() == true))) {
			
			event.setCanceled(true);
			return;
		}
		if((event.getState().getBlock().getTags().contains(Reference.ORETYPE2) == true) && ((event.getPlayer() instanceof FakePlayer) || (event.getPlayer() == null || (event.getPlayer().getHeldItemMainhand().isEmpty() == true)))) {
			
			event.setCanceled(true);
			return;
		}
		if((event.getState().getBlock().getTags().contains(Reference.ORETYPE3) == true) && ((event.getPlayer() instanceof FakePlayer) || (event.getPlayer() == null) || (event.getPlayer().getHeldItemMainhand().isEmpty() == true))) {
			
			event.setCanceled(true);
			return;
		}
		if(event.getPlayer() instanceof FakePlayer) {
			return;
		}
		if(event.getPlayer().getActiveItemStack().getItem() == ModItems.ALLTHEMODIUM_PICKAXE) {
			BlockPos center = event.getPos();
			PlayerEntity player = event.getPlayer();
			Direction facing = player.getAdjustedHorizontalFacing();
			
		}
		
	}
	@SubscribeEvent
	public static void on(BlockEvent event) {

	}

	
}
