package com.thevortex.allthemodium.events;


import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.TagRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.util.FakePlayer;
import net.neoforged.neoforge.event.level.BlockEvent;

@EventBusSubscriber(bus=EventBusSubscriber.Bus.GAME, modid = Reference.MOD_ID)
public class BlockBreak {


	@SubscribeEvent
	public static void on(BlockEvent.EntityPlaceEvent context){
		if (context.getLevel() == Level.END) {
			BlockPos pos = context.getPos();
			int x = pos.getX();
			int z = pos.getZ();
			if (Math.abs(x) < 1000 || Math.abs(z) < 1000) {

				context.setCanceled(true);
			}

		}

	}
	@SubscribeEvent
	public static void on(BlockEvent.BreakEvent event) {
		if(event.getPlayer().isCreative()) { return; }

		if((event.getPlayer() instanceof FakePlayer) && (event.getState().is(TagRegistry.OTHER_PROTECTION)) && (event.getLevel().getBiome(event.getPos()).is(TagRegistry.OTHER_BIOMES))) {
			event.setCanceled(true);
			return;
		}
		
		if((event.getState().is(TagRegistry.ALLTHEMODIUM_ORE)) && ((event.getPlayer() instanceof FakePlayer) || (event.getPlayer() == null) || (event.getPlayer().getMainHandItem().isEmpty()))) {
			
			event.setCanceled(true);
			event.getLevel().setBlock(event.getPos(), Blocks.AIR.defaultBlockState(), 3);
			return;
		}

		if((event.getState().is(TagRegistry.VIBRANIUM_ORE)) && ((event.getPlayer() instanceof FakePlayer) || (event.getPlayer() == null) || (event.getPlayer().getMainHandItem().isEmpty()))) {
			
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
