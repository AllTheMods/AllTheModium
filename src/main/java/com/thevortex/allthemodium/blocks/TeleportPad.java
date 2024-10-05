package com.thevortex.allthemodium.blocks;

import com.thevortex.allthemodium.AllTheModium;
import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.LevelRegistry;
import com.thevortex.allthemodium.registry.ModRegistry;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TeleportPad extends Block {

    protected static final VoxelShape TELEPORTPAD_AABB = Block.box(
            0.0D,
            0.0D,
            0.0D,
            16.0D,
            3.0D,
            16.0D);

    public TeleportPad(Properties properties) {
        super(properties);
        // TODO Auto-generated constructor stub
    }

    @Override
    public VoxelShape getShape(
            @Nonnull BlockState state,
            @Nonnull BlockGetter worldIn,
            @Nonnull BlockPos pos,
            @Nonnull CollisionContext context) {
        return TELEPORTPAD_AABB;
    }

    @Override
    public PushReaction getPistonPushReaction(@Nonnull BlockState state) {
        return PushReaction.BLOCK;
    }

    @Override
    public VoxelShape getCollisionShape(
            @Nonnull BlockState state,
            @Nonnull BlockGetter worldIn,
            @Nonnull BlockPos pos,
            @Nonnull CollisionContext context) {
        return TELEPORTPAD_AABB;
    }

    @SuppressWarnings("deprecation")
    @Override
    public InteractionResult use(
            @Nonnull BlockState state,
            @Nonnull Level worldIn,
            @Nonnull BlockPos pos,
            @Nonnull Player player,
            @Nonnull InteractionHand handIn,
            @Nonnull BlockHitResult hit) {
        if ((player instanceof ServerPlayer) && (player.isCrouching() == true)) {
            transferPlayer((ServerPlayer) player, pos);
            worldIn.addAlwaysVisibleParticle(
                    ParticleTypes.SOUL_FIRE_FLAME,
                    pos.getX(),
                    pos.getY() + 1,
                    pos.getZ(),
                    0,
                    1,
                    0);
        }

        return super.use(state, worldIn, pos, player, handIn, hit);
    }

    @Override
    public boolean canHarvestBlock(
            BlockState state,
            BlockGetter world,
            BlockPos pos,
            Player player) {
        if (player.level
                .dimension()
                .registry()
                .getNamespace()
                .contains(Reference.MOD_ID)) {
            return false;
        } else {
            return true;
        }
    }

    public void transferPlayer(ServerPlayer player, BlockPos pos) {
        boolean config = AllTheModium.ALLOW_TELEPORT_MINING;
        if (player.level.dimension().equals(LevelRegistry.Mining)) {
            ServerLevel targetWorld = player.server.getLevel(
                    AllTheModium.OverWorld);

            if (targetWorld == null)
                return;

            int y = 256;
            boolean located = false;
            while (y >= 1) {
                BlockPos posA = new BlockPos(
                        Math.round(pos.getX()),
                        y,
                        Math.round(pos.getZ()));
                Block potential = targetWorld.getBlockState(posA).getBlock();
                if (potential.getName().toString().contains("teleport_pad")) {
                    located = true;
                    break;
                } else {
                    y--;
                }
            }
            if (located) {
                targetWorld.addParticle(
                        ParticleTypes.SOUL_FIRE_FLAME,
                        pos.getX(),
                        pos.getY(),
                        pos.getZ(),
                        0,
                        1,
                        0);
                player.teleportTo(
                        targetWorld,
                        pos.getX() + 0.5D,
                        y + 0.25D,
                        pos.getZ() + 0.5D,
                        player.rotA,
                        player.yya);

                return;
            } else {
                if ((!targetWorld.getBlockState(pos).hasBlockEntity()) &&
                        (targetWorld
                                .getBlockState(pos)
                                .canEntityDestroy(targetWorld, pos, player))) {
                    // targetWorld.setBlockState(pos, ModBlocks.TELEPORT_PAD.getDefaultState());
                }

                targetWorld.addParticle(
                        ParticleTypes.SOUL_FIRE_FLAME,
                        pos.getX(),
                        pos.getY(),
                        pos.getZ(),
                        0,
                        1,
                        0);
                player.teleportTo(
                        targetWorld,
                        pos.getX() + 0.5D,
                        pos.getY() + 0.25D,
                        pos.getZ() + 0.5D,
                        player.rotA,
                        player.yya);
            }
        } else if (player.level.dimension().equals(AllTheModium.Nether)) {
            ServerLevel targetWorld = player.server.getLevel(
                    LevelRegistry.THE_OTHER);
            BlockPos targetPos = new BlockPos(
                    Math.round(pos.getX()),
                    Math.round(pos.getY()),
                    Math.round(pos.getZ()));

            if (targetWorld == null)
                return;

            if (!targetWorld.getBlockState(targetPos).hasBlockEntity()) {
                LevelHeightAccessor accessor = targetWorld
                        .getChunk(pos)
                        .getHeightAccessorForGeneration();
                int y = targetWorld
                        .getChunkSource()
                        .getGenerator()
                        .getSpawnHeight(accessor);
                targetWorld.setBlockAndUpdate(
                        new BlockPos(targetPos.getX(), y, targetPos.getZ()),
                        ModRegistry.TELEPORT_PAD.get().defaultBlockState());

                targetWorld.addParticle(
                        ParticleTypes.SOUL_FIRE_FLAME,
                        pos.getX(),
                        pos.getY(),
                        pos.getZ(),
                        0,
                        1,
                        0);
                player.teleportTo(
                        targetWorld,
                        targetPos.getX() + 0.5D,
                        y + 0.25D,
                        targetPos.getZ() + 0.5D,
                        0,
                        0);
            }
        } else if (player.level.dimension().equals(LevelRegistry.THE_OTHER)) {
            ServerLevel targetWorld = player.server.getLevel(
                    AllTheModium.Nether);

            if (targetWorld == null)
                return;

            int y = 128;
            boolean located = false;
            while (y >= 1) {
                BlockPos posA = new BlockPos(
                        Math.round(pos.getX()),
                        y,
                        Math.round(pos.getZ()));
                Block potential = targetWorld.getBlockState(posA).getBlock();
                if (potential.getName().toString().contains("teleport_pad")) {
                    located = true;
                    break;
                } else {
                    y--;
                }
            }
            if (located) {
                targetWorld.addParticle(
                        ParticleTypes.SOUL_FIRE_FLAME,
                        pos.getX(),
                        pos.getY(),
                        pos.getZ(),
                        0,
                        1,
                        0);
                player.teleportTo(
                        targetWorld,
                        pos.getX() + 0.5D,
                        y + 0.25D,
                        pos.getZ() + 0.5D,
                        player.rotA,
                        player.yya);

                return;
            } else {
                BlockPos newPos = new BlockPos(pos.getX(), 90, pos.getZ());
                if ((!targetWorld.getBlockState(newPos).hasBlockEntity()) &&
                        (targetWorld
                                .getBlockState(newPos)
                                .canEntityDestroy(targetWorld, newPos, player))) {
                    targetWorld.setBlockAndUpdate(
                            newPos,
                            ModRegistry.TELEPORT_PAD.get().defaultBlockState());
                }

                targetWorld.addParticle(
                        ParticleTypes.SOUL_FIRE_FLAME,
                        newPos.getX(),
                        newPos.getY(),
                        newPos.getZ(),
                        0,
                        1,
                        0);
                player.teleportTo(
                        targetWorld,
                        newPos.getX() + 0.5D,
                        newPos.getY() + 0.25D,
                        newPos.getZ() + 0.5D,
                        player.rotA,
                        player.yya);
            }
        } else if (player.level.dimension().equals(AllTheModium.OverWorld) &&
                (config == true)) {
            ServerLevel targetWorld = player.server.getLevel(
                    LevelRegistry.Mining);
            BlockPos targetPos = new BlockPos(
                    Math.round(pos.getX()),
                    253,
                    Math.round(pos.getZ()));

            if (targetWorld == null)
                return;

            if (!targetWorld.getBlockState(targetPos).hasBlockEntity()) {
                targetWorld.setBlockAndUpdate(
                        targetPos,
                        ModRegistry.TELEPORT_PAD.get().defaultBlockState());
                targetWorld.addParticle(
                        ParticleTypes.SOUL_FIRE_FLAME,
                        pos.getX(),
                        pos.getY(),
                        pos.getZ(),
                        0,
                        1,
                        0);
                player.teleportTo(
                        targetWorld,
                        targetPos.getX() + 0.5D,
                        targetPos.getY() + 0.25D,
                        targetPos.getZ() + 0.5D,
                        0,
                        0);
            }
        }
    }

    @Override
    public List<ItemStack> getDrops(
            @Nonnull BlockState state,
            @Nonnull LootContext.Builder builder) {
        List<ItemStack> list = new ArrayList<ItemStack>();
        return list;
    }
}
