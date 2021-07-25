package com.thevortex.allthemodium.blocks;

import com.thevortex.allthemodium.fluids.FluidList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.storage.loot.LootContext;

import java.util.ArrayList;
import java.util.List;

public class UVAlloy_Block extends Block {

	public UVAlloy_Block() {
	super(Properties.of(Material.STONE).sound(SoundType.STONE).strength(7.0f));
	}

@Deprecated
@Override
public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
	List<ItemStack> list = new ArrayList<ItemStack>();
	list.add(new ItemStack(FluidList.UV_ALLOY_ITEM.get()));
	return list;
}



}
