package com.thevortex.allthemodium.blocks;

import com.thevortex.allthemodium.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;

import java.util.ArrayList;
import java.util.List;

public class UAAlloy_Block extends Block {

	public UAAlloy_Block() {
	super(Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(7.0f));
	}

@Deprecated
@Override
public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
	List<ItemStack> list = new ArrayList<ItemStack>();
	list.add(new ItemStack(ModItems.UNOBTAINIUM_BLOCK));
	return list;
}



}
