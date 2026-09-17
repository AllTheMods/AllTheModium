package com.thevortex.allthemodium.blocks;

import com.mojang.authlib.properties.PropertyMap;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.item.component.ResolvableProfile;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;

public class Vortex_Block extends SkullBlock {

	// Name-only and unresolved: SkullBlockEntity/ResolvableProfile resolve the real UUID and skin
	// textures asynchronously by username (same path vanilla uses for a player head placed by name),
	// since authlib's GameProfile no longer allows a null id.
	public static final ResolvableProfile OWNER_PROFILE = new ResolvableProfile(Optional.of("theVortex"), Optional.empty(), new PropertyMap());

	public Vortex_Block() {
		super(Types.PLAYER, Properties.of().sound(SoundType.STONE).strength(7.0f));
	}

	@Override
	public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		super.setPlacedBy(level, pos, state, placer, stack);
		if (!level.isClientSide && level.getBlockEntity(pos) instanceof SkullBlockEntity skullEntity) {
			skullEntity.setOwner(OWNER_PROFILE);
		}
	}

	// AbstractSkullBlock already toggles POWERED on redstone changes; just layer the soundbit on top.
	@Override
	protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, BlockPos neighborPos, boolean movedByPiston) {
		if (!level.isClientSide && level.hasNeighborSignal(pos) && !state.getValue(POWERED)) {
			level.playSound(null, pos, ModRegistry.SONOFA.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
		}
		super.neighborChanged(state, level, pos, neighborBlock, neighborPos, movedByPiston);
	}

}
