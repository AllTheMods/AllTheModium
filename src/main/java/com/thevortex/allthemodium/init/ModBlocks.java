package com.thevortex.allthemodium.init;

import com.thevortex.allthemodium.blocks.Allthemodium_Block;
import com.thevortex.allthemodium.blocks.Allthemodium_Ore;
import com.thevortex.allthemodium.blocks.TeleportPad;
import com.thevortex.allthemodium.blocks.Unobtainium_Block;
import com.thevortex.allthemodium.blocks.Unobtainium_Ore;
import com.thevortex.allthemodium.blocks.Vibranium_Block;
import com.thevortex.allthemodium.blocks.Vibranium_Ore;
import com.thevortex.allthemodium.reference.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {
	@ObjectHolder("allthemodium:allthemodium_block")
	public static Block ALLTHEMODIUMBLOCK;
	@ObjectHolder("allthemodium:allthemodium_ore")
	public static Block ALLTHEMODIUMORE;
	@ObjectHolder("allthemodium:vibranium_ore")
	public static Block VIBRANIUM_ORE;
	@ObjectHolder("allthemodium:unobtainium_ore")
	public static Block UNOBTAINIUM_ORE;
	@ObjectHolder("allthemodium:vibranium_block")
	public static Block VIBRANIUMBLOCK;
	@ObjectHolder("allthemodium:unobtainium_block")
	public static Block UNOBTAINIUMBLOCK;
	@ObjectHolder("allthemodium:teleport_pad")
	public static Block TELEPORT_PAD;
	public ModBlocks() {
		
	}

	public static void init(Register<Block> event) {
		ALLTHEMODIUMBLOCK = new Allthemodium_Block().setRegistryName(location("allthemodium_block"));
		VIBRANIUMBLOCK = new Vibranium_Block().setRegistryName(location("vibranium_block"));
		UNOBTAINIUMBLOCK = new Unobtainium_Block().setRegistryName(location("unobtainium_block"));
		
				
		ALLTHEMODIUMORE = new Allthemodium_Ore().setRegistryName(location("allthemodium_ore"));
		VIBRANIUM_ORE = new Vibranium_Ore().setRegistryName(location("vibranium_ore"));
		UNOBTAINIUM_ORE = new Unobtainium_Ore().setRegistryName(location("unobtainium_ore"));

		TELEPORT_PAD = new TeleportPad(Block.Properties.create(Material.IRON).harvestTool(ToolType.PICKAXE).harvestLevel(1).variableOpacity().hardnessAndResistance(20.0F)).setRegistryName(location("teleport_pad"));
		
		event.getRegistry().register(ModBlocks.ALLTHEMODIUMBLOCK);
		event.getRegistry().register(ModBlocks.VIBRANIUMBLOCK);
		event.getRegistry().register(ModBlocks.UNOBTAINIUMBLOCK);

		event.getRegistry().register(ModBlocks.ALLTHEMODIUMORE);
		event.getRegistry().register(ModBlocks.VIBRANIUM_ORE);
		event.getRegistry().register(ModBlocks.UNOBTAINIUM_ORE);
		event.getRegistry().register(ModBlocks.TELEPORT_PAD);
	}

	private static ResourceLocation location(String name) {
		return new ResourceLocation(Reference.MOD_ID, name);
	}
}
