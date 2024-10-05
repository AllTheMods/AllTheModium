package com.thevortex.allthemodium.blocks;

import com.thevortex.allthemodium.config.AllthemodiumServerConfigs;
import com.thevortex.allthemodium.registry.TagRegistry;
import javax.annotation.Nonnull;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RedStoneOreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.FakePlayer;

public class AllthemodiumOre extends RedStoneOreBlock {

    // public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;
    public AllthemodiumOre() { // func_235861_h_ = setRequiresTool
        super(
                BlockBehaviour.Properties
                        .of(Material.STONE)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.ANCIENT_DEBRIS)
                        .lightLevel(state -> {
                            return 15;
                        })
                        .strength(80.0f, 1500.0f));
    }

    @Override
    @SuppressWarnings("deprecation") // deprecated method from super class
    public float getDestroyProgress(
            @Nonnull BlockState state,
            @Nonnull Player player,
            @Nonnull BlockGetter getter,
            @Nonnull BlockPos blockPos) {
        if (canEntityDestroy(state, getter, blockPos, player)) {
            if (AllthemodiumServerConfigs.ALLTHEMODIUM_QUARRYABLE.get())
                return super.getDestroyProgress(state, player, getter, blockPos);

            int i = net.minecraftforge.common.ForgeHooks.isCorrectToolForDrops(
                    state,
                    player)
                            ? 250
                            : 1500;
            return player.getDigSpeed(state, blockPos) / 2.0F / i;
        }
        return 0.0F;
    }

    @Override
    public boolean canEntityDestroy(
            BlockState state,
            BlockGetter world,
            BlockPos pos,
            Entity player) {
        if ((player instanceof FakePlayer) &&
                (state.is(TagRegistry.ALLTHEMODIUM_ORE))) {
            return AllthemodiumServerConfigs.ALLTHEMODIUM_QUARRYABLE.get();
        }

        return (super.canEntityDestroy(state, world, pos, player) &&
                (distanceTo(pos, player.blockPosition) < 16.0F));
    }

    private double distanceTo(BlockPos block, BlockPos player) {
        return Math.sqrt(
                Math.pow(block.getX() - player.getX(), 2) +
                        Math.pow(block.getY() - player.getY(), 2) +
                        Math.pow(block.getZ() - player.getZ(), 2));
    }

    @Override
    public PushReaction getPistonPushReaction(@Nonnull BlockState state) {
        return PushReaction.BLOCK;
    }

    @OnlyIn(Dist.CLIENT)
    private static void activate(
            BlockState p_196500_0_,
            Level worldIn,
            BlockPos p_196500_2_) {
        spawnParticles(worldIn, p_196500_2_);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void animateTick(
            @Nonnull BlockState stateIn,
            @Nonnull Level worldIn,
            @Nonnull BlockPos pos,
            @Nonnull RandomSource rand) {
        spawnParticles(worldIn, pos);
    }

    @SuppressWarnings("unused") // TODO Remove unused suppression
    @OnlyIn(Dist.CLIENT)
    private static void spawnParticles(Level world, BlockPos worldIn) {
        RandomSource random = world.random;

        for (Direction direction : Direction.values()) {
            BlockPos blockPos = worldIn.offset(direction.getNormal());
            if (!world.getBlockState(blockPos).isSolidRender(world, blockPos)) {
                Direction.Axis direction$axis = direction.getAxis();
                double d1 = direction$axis == Direction.Axis.X
                        ? 0.5D + 0.5625D * (double) direction.getStepX()
                        : (double) random.nextFloat();
                double d2 = direction$axis == Direction.Axis.Y
                        ? 0.5D + 0.5625D * (double) direction.getStepY()
                        : (double) random.nextFloat();
                double d3 = direction$axis == Direction.Axis.Z
                        ? 0.5D + 0.5625D * (double) direction.getStepZ()
                        : (double) random.nextFloat();
                // TODO spawn particles
            }
        }
    }
}
