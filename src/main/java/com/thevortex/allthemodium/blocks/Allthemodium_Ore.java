package com.thevortex.allthemodium.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thevortex.allthemodium.AllTheModium;
import com.thevortex.allthemodium.init.ModBlocks;
import com.thevortex.allthemodium.init.ModItems;
import com.thevortex.allthemodium.particledata.AllthemodiumParticleData;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneTorchBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.loot.LootContext;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.util.FakePlayer;

public class Allthemodium_Ore extends Block {
	   public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;

	public Allthemodium_Ore() {	//func_235861_h_ = setRequiresTool
	super (Properties.create(Material.IRON).setRequiresTool().sound(SoundType.STONE).hardnessAndResistance(19.0f));
    this.setDefaultState(this.getDefaultState().with(LIT, Boolean.valueOf(true)));

	}


	@Override
	public boolean canHarvestBlock(BlockState state, IBlockReader world, BlockPos pos, PlayerEntity player) {
		if((player instanceof FakePlayer) && (state.getBlock() == ModBlocks.ALLTHEMODIUMORE)) { return false; }

	return super.canHarvestBlock(state,world,pos,player) && (distanceTo(pos,player.getPosition()) < 16.0F);
	}

	private double distanceTo(BlockPos block,BlockPos player) {
		return Math.sqrt(Math.pow(block.getX() - player.getX(), 2) + Math.pow(block.getY() - player.getY(), 2) + Math.pow(block.getZ() - player.getZ(), 2));
	}

	@Override
	public PushReaction getPushReaction(BlockState state) {

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

	@Override
	@OnlyIn(Dist.CLIENT)
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
	      activate(worldIn.getBlockState(pos), worldIn, pos);
	      super.onEntityWalk(worldIn, pos, entityIn);
	   }

   @OnlyIn(Dist.CLIENT)	
   private static void activate(BlockState p_196500_0_, World p_196500_1_, BlockPos p_196500_2_) {
      spawnParticles(p_196500_1_, p_196500_2_);
      if (!p_196500_0_.get(LIT)) {
         p_196500_1_.setBlockState(p_196500_2_, p_196500_0_.with(LIT, Boolean.valueOf(true)), 3);
      }

   }
   @OnlyIn(Dist.CLIENT)
   @Override
   public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
      if (stateIn.get(LIT)) {
         spawnParticles(worldIn, pos);
      }

   }
   @OnlyIn(Dist.CLIENT)
   private static void spawnParticles(World p_180691_0_, BlockPos worldIn) {
	      Random random = p_180691_0_.rand;

	      for(Direction direction : Direction.values()) {
	         BlockPos blockpos = worldIn.offset(direction);
	         if (!p_180691_0_.getBlockState(blockpos).isOpaqueCube(p_180691_0_, blockpos)) {
	            Direction.Axis direction$axis = direction.getAxis();
	            double d1 = direction$axis == Direction.Axis.X ? 0.5D + 0.5625D * (double)direction.getXOffset() : (double)random.nextFloat();
	            double d2 = direction$axis == Direction.Axis.Y ? 0.5D + 0.5625D * (double)direction.getYOffset() : (double)random.nextFloat();
	            double d3 = direction$axis == Direction.Axis.Z ? 0.5D + 0.5625D * (double)direction.getZOffset() : (double)random.nextFloat();
	            p_180691_0_.addParticle(new RedstoneParticleData(AllthemodiumParticleData.ParticleDUST.getRed(),AllthemodiumParticleData.ParticleDUST.getGreen(),AllthemodiumParticleData.ParticleDUST.getBlue(),AllthemodiumParticleData.ParticleDUST.getAlpha()), (double)worldIn.getX() + d1, (double)worldIn.getY() + d2, (double)worldIn.getZ() + d3, 0.0D, 0.0D, 0.0D);
	         }
	      }

	   }

	   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
	      builder.add(LIT);
	   }

}
