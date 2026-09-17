package com.thevortex.allthemodium.blocks;

import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class Vortex_Block extends HorizontalDirectionalBlock {

	public static final BooleanProperty POWERED = BooleanProperty.create("powered");

	public Vortex_Block() {
		super(Properties.of().sound(SoundType.STONE).strength(7.0f));
		this.registerDefaultState(this.stateDefinition.any()
			.setValue(FACING, Direction.NORTH)
			.setValue(POWERED, Boolean.FALSE));
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, POWERED);
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
