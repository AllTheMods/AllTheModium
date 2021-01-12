package com.thevortex.allthemodium.blocks.portals;

import com.thevortex.allthemodium.AllTheModium;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class OtherPortalBlock extends ContainerBlock {
        protected static final VoxelShape SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D);

        public OtherPortalBlock(AbstractBlock.Properties builder) {
            super(builder);
        }

        public TileEntity createNewTileEntity(IBlockReader worldIn) {
            return new OtherPortalTileEntity();
        }

        public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
            return SHAPE;
        }

        public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
            if (worldIn instanceof ServerWorld && !entityIn.isPassenger() && !entityIn.isBeingRidden() && entityIn.isNonBoss() && VoxelShapes.compare(VoxelShapes.create(entityIn.getBoundingBox().offset((double)(-pos.getX()), (double)(-pos.getY()), (double)(-pos.getZ()))), state.getShape(worldIn, pos), IBooleanFunction.AND)) {
                RegistryKey<World> registrykey = worldIn.getDimensionKey() == AllTheModium.THE_OTHER ? World.THE_NETHER : AllTheModium.THE_OTHER;
                ServerWorld serverworld = ((ServerWorld)worldIn).getServer().getWorld(registrykey);
                if (serverworld == null) {
                    return;
                }

                entityIn.setWorld(serverworld);
            }

        }


        @OnlyIn(Dist.CLIENT)
        public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
            double d0 = (double)pos.getX() + rand.nextDouble();
            double d1 = (double)pos.getY() + 0.8D;
            double d2 = (double)pos.getZ() + rand.nextDouble();
            worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }

        public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
            return ItemStack.EMPTY;
        }

        public boolean isReplaceable(BlockState p_225541_1_, Fluid p_225541_2_) {
            return false;
        }

}
