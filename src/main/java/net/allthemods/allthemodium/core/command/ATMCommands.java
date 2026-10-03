package net.allthemods.allthemodium.core.command;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import net.allthemods.allthemodium.api.ATM;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@EventBusSubscriber(modid = ATM.MOD_ID)
public class ATMCommands {

    private static final int DEFAULT_RADIUS = 64;

    @SubscribeEvent
    static void registerCommands(final RegisterCommandsEvent event) {
        event.getDispatcher().register(
                Commands.literal(ATM.MOD_ID)
                        .requires(Commands.hasPermission(Commands.LEVEL_GAMEMASTERS))
                        .then(Commands.literal("clear")
                                .executes(context -> ATMCommands.clear(context, ATMCommands.DEFAULT_RADIUS))
                                .then(Commands.argument("radius", IntegerArgumentType.integer(1, 256))
                                        .executes(context -> ATMCommands.clear(context, IntegerArgumentType.getInteger(context, "radius")))
                                )
                        )
        );
    }

    /**
     * Strips everything but ores and bedrock from a column around the player, from the build floor up to the
     * player's own height, then reports what each ore left behind. Blocks are replaced with
     * {@link Block#UPDATE_CLIENTS} so no neighbour or shape updates cascade across the cleared volume.
     */
    private static int clear(CommandContext<CommandSourceStack> context, int radius) {
        ServerPlayer player = context.getSource().getPlayer();
        if (player == null) {
            context.getSource().sendFailure(Component.literal("Only a player can run this"));
            return 0;
        }

        ServerLevel level = player.level();
        BlockState air = Blocks.AIR.defaultBlockState();
        AABB area = new AABB(player.blockPosition()).setMinY(level.getMinY()).inflate(radius, 0.0D, radius);
        Map<Block, Integer> ores = new HashMap<>();

        BlockPos.betweenClosedStream(area).forEach(pos -> {
            BlockState state = level.getBlockState(pos);
            if (state.is(Tags.Blocks.ORES)) {
                ores.merge(state.getBlock(), 1, Integer::sum);
                return;
            }
            if (state.isAir() || state.is(Blocks.BEDROCK)) return;
            level.setBlock(pos, air, Block.UPDATE_CLIENTS);
        });

        int total = ores.values().stream().mapToInt(Integer::intValue).sum();
        context.getSource().sendSuccess(() -> Component.literal("Cleared r=" + radius + " down to y=" + level.getMinY() + ", " + total + " ore blocks left").withStyle(ChatFormatting.GREEN), true);
        ores.entrySet().stream()
                .sorted(Map.Entry.<Block, Integer>comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> context.getSource().sendSuccess(
                        () -> Component.literal("  " + entry.getValue() + "x ").append(entry.getKey().getName()).withStyle(ChatFormatting.GRAY), false
                ));

        return total;
    }
}
