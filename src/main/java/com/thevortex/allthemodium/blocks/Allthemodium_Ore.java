package com.thevortex.allthemodium.blocks;

import java.util.Random;

import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.util.FakePlayer;

public class Allthemodium_Ore extends Block {
	  // public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;
	public Allthemodium_Ore() {	//func_235861_h_ = setRequiresTool
	super (Properties.of(Material.METAL).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(19.0f));
    this.registerDefaultState(this.defaultBlockState());

	}


	@Override
	public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
		if((player instanceof FakePlayer) && (state.getBlock() == ModRegistry.ALLTHEMODIUM_ORE.get())) { return false; }

	return super.canHarvestBlock(state,world,pos,player) && (distanceTo(pos,player.blockPosition()) < 16.0F);
	}

	private double distanceTo(BlockPos block,BlockPos player) {
		return Math.sqrt(Math.pow(block.getX() - player.getX(), 2) + Math.pow(block.getY() - player.getY(), 2) + Math.pow(block.getZ() - player.getZ(), 2));
	}

	@Override
	public PushReaction getPistonPushReaction(BlockState state) {

		return PushReaction.BLOCK;
	}
	@Override
	public int getHarvestLevel(BlockState state) {
		return 4;
	}
	@Override
	public ToolType getHarvestTool(BlockState state) {
		
		return ToolType.PICKAXE;
	}



   @OnlyIn(Dist.CLIENT)	
   private static void activate(BlockState p_196500_0_, Level worldIn, BlockPos p_196500_2_) {
      spawnParticles(worldIn, p_196500_2_);


   }
   @OnlyIn(Dist.CLIENT)
   @Override
   public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, Random rand) {
     /* if (stateIn.getValue(LIT)) {
         spawnParticles(worldIn, pos);
      }*/

   }
   @OnlyIn(Dist.CLIENT)
   private static void spawnParticles(Level world, BlockPos worldIn) {
	      Random random = world.random;

	      for(Direction direction : Direction.values()) {
	         BlockPos blockpos = worldIn.offset(direction.getNormal());
	         if (!world.getBlockState(blockpos).isSolidRender(world, blockpos)) {
	            Direction.Axis direction$axis = direction.getAxis();
	            double d1 = direction$axis == Direction.Axis.X ? 0.5D + 0.5625D * (double)direction.getStepX() : (double)random.nextFloat();
	            double d2 = direction$axis == Direction.Axis.Y ? 0.5D + 0.5625D * (double)direction.getStepY() : (double)random.nextFloat();
	            double d3 = direction$axis == Direction.Axis.Z ? 0.5D + 0.5625D * (double)direction.getStepZ() : (double)random.nextFloat();
				 //todo spawn particles
	         }
	      }

	   }



}
