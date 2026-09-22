package com.thevortex.allthemodium.blocks;

import com.mojang.authlib.GameProfile;
import com.thevortex.allthemodium.blocks.entity.VortexSkullBlockEntity;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class Vortex_Block extends SkullBlock {

	public static final BooleanProperty POWERED = BooleanProperty.create("powered");
	public static final GameProfile OWNER_PROFILE = new GameProfile(null, "theVortex");

	public Vortex_Block() {
		super(Types.PLAYER, Properties.of().sound(SoundType.STONE).strength(7.0f));
		this.registerDefaultState(this.stateDefinition.any().setValue(ROTATION, 0).setValue(POWERED, Boolean.FALSE));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(POWERED);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new VortexSkullBlockEntity(pos, state);
	}

	@Override
	public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		super.setPlacedBy(level, pos, state, placer, stack);
		if (!level.isClientSide && level.getBlockEntity(pos) instanceof SkullBlockEntity skullEntity) {
			skullEntity.setOwner(OWNER_PROFILE);
		}
	}

	@Override
	public void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, BlockPos neighborPos, boolean movedByPiston) {
		if (level.isClientSide) {
			return;
		}

		boolean powered = level.hasNeighborSignal(pos);
		if (powered != state.getValue(POWERED)) {
			if (powered) {
				level.playSound(null, pos, ModRegistry.SONOFA.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
			}
			level.setBlock(pos, state.setValue(POWERED, powered), 2);
		}
	}

}
