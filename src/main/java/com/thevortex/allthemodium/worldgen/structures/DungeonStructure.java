package com.thevortex.allthemodium.worldgen.structures;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.JigsawFeature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.structure.PostPlacementProcessor;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGenerator;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGeneratorSupplier;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.event.world.StructureSpawnListGatherEvent;

import java.util.List;
import java.util.Optional;

public class DungeonStructure extends StructureFeature<JigsawConfiguration> {
    public DungeonStructure(Codec<JigsawConfiguration> codec) {

        super(JigsawConfiguration.CODEC, DungeonStructure::createPiecesGenerator, PostPlacementProcessor.NONE);
    }
    private static boolean isFeatureChunk(PieceGeneratorSupplier.Context<JigsawConfiguration> context) {
        BlockPos blockPos = context.chunkPos().getWorldPosition();

        // Grab height of land. Will stop at first non-air block.
        int landHeight = context.chunkGenerator().getFirstOccupiedHeight(blockPos.getX(), blockPos.getZ(), Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor());

        // Grabs column of blocks at given position. In overworld, this column will be made of stone, water, and air.
        // In nether, it will be netherrack, lava, and air. End will only be endstone and air. It depends on what block
        // the chunk generator will place for that dimension.
        NoiseColumn columnOfBlocks = context.chunkGenerator().getBaseColumn(blockPos.getX(), blockPos.getZ(), context.heightAccessor());

        // Combine the column of blocks with land height and you get the top block itself which you can test.
        BlockState topBlock = columnOfBlocks.getBlock(landHeight);

        // Now we test to make sure our structure is not spawning on water or other fluids.
        // You can do height check instead too to make it spawn at high elevations.
        return topBlock.getFluidState().isEmpty(); //landHeight > 100;
    }

    public static Optional<PieceGenerator<JigsawConfiguration>> createPiecesGenerator(PieceGeneratorSupplier.Context<JigsawConfiguration> context) {
        // Turns the chunk coordinates into actual coordinates we can use. (Gets center of that chunk)
        BlockPos blockpos = context.chunkPos().getMiddleBlockPosition(0);

        /*
         * If you are doing Nether structures, you'll probably want to spawn your structure on top of ledges.
         * Best way to do that is to use getBaseColumn to grab a column of blocks at the structure's x/z position.
         * Then loop through it and look for land with air above it and set blockpos's Y value to it.
         * Make sure to set the final boolean in JigsawPlacement.addPieces to false so
         * that the structure spawns at blockpos's y value instead of placing the structure on the Bedrock roof!
         */
        // NoiseColumn blockReader = context.chunkGenerator().getBaseColumn(blockpos.getX(), blockpos.getZ(), context.heightAccessor());


        /*
         * The only reason we are using JigsawConfiguration here is because further down, we are using
         * JigsawPlacement.addPieces which requires JigsawConfiguration. However, if you create your own
         * JigsawPlacement.addPieces, you could reduce the amount of workarounds like above that you need
         * and give yourself more opportunities and control over your structures.
         *
         * An example of a custom JigsawPlacement.addPieces in action can be found here:
         * https://github.com/TelepathicGrunt/RepurposedStructures/blob/1.18/src/main/java/com/telepathicgrunt/repurposedstructures/world/structures/pieces/PieceLimitedJigsawManager.java
         */
        /*
        JigsawConfiguration newConfig = new JigsawConfiguration(
                // The path to the starting Template Pool JSON file to read.
                //
                // Note, this is "structure_tutorial:run_down_house/start_pool" which means
                // the game will automatically look into the following path for the template pool:
                // "resources/data/structure_tutorial/worldgen/template_pool/run_down_house/start_pool.json"
                // This is why your pool files must be in "data/<modid>/worldgen/template_pool/<the path to the pool here>"
                // because the game automatically will check in worldgen/template_pool for the pools.
                DungeonPieces.START,

                // How many pieces outward from center can a recursive jigsaw structure spawn.
                // Our structure is only 1 piece outward and isn't recursive so any value of 1 or more doesn't change anything.
                // However, I recommend you keep this a decent value like 7 so people can use datapacks to add additional pieces to your structure easily.
                // But don't make it too large for recursive structures like villages or you'll crash server due to hundreds of pieces attempting to generate!
                // Requires AccessTransformer  (see resources/META-INF/accesstransformer.cfg)
                10
        );

        // Create a new context with the new config that has our json pool. We will pass this into JigsawPlacement.addPieces
        PieceGeneratorSupplier.Context<JigsawConfiguration> newContext = new PieceGeneratorSupplier.Context<>(
                context.chunkGenerator(),
                context.biomeSource(),
                context.seed(),
                context.chunkPos(),
                newConfig,
                context.heightAccessor(),
                context.validBiome(),
                context.structureManager(),
                context.registryAccess()
        );
*/
        Optional<PieceGenerator<JigsawConfiguration>> structurePiecesGenerator =
                JigsawPlacement.addPieces(
                        context, // Used for JigsawPlacement to get all the proper behaviors done.
                        PoolElementStructurePiece::new, // Needed in order to create a list of jigsaw pieces when making the structure's layout.
                        blockpos, // Position of the structure. Y value is ignored if last parameter is set to true.
                        false,  // Special boundary adjustments for villages. It's... hard to explain. Keep this false and make your pieces not be partially intersecting.
                        // Either not intersecting or fully contained will make children pieces spawn just fine. It's easier that way.
                        true // Place at heightmap (top land). Set this to false for structure to be place at the passed in blockpos's Y value instead.
                        // Definitely keep this false when placing structures in the nether as otherwise, heightmap placing will put the structure on the Bedrock roof.
                );


        if(structurePiecesGenerator.isPresent()) {

        }


        return structurePiecesGenerator;
    }

    public static void setupStructureSpawns(final StructureSpawnListGatherEvent event) {
        if(event.getStructure() == ATMStructures.DUNGEON.get()) {
            event.addEntitySpawns(MobCategory.MONSTER, STRUCTURE_MONSTERS.get());
            event.addEntitySpawns(MobCategory.CREATURE, STRUCTURE_CREATURES.get());
        }
    }
    /*
        @Override
        public StructureStartFactory<NoneFeatureConfiguration> getStartFactory() {
            return APStructure.Start::new;
        }
    */
    @Override
    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.SURFACE_STRUCTURES;
    }

    private static final Lazy<List<MobSpawnSettings.SpawnerData>> STRUCTURE_MONSTERS = Lazy.of(() -> ImmutableList.of(
            new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 100, 4, 9),
            new MobSpawnSettings.SpawnerData(EntityType.EVOKER, 10, 1, 2)
    ));

    private static final Lazy<List<MobSpawnSettings.SpawnerData>> STRUCTURE_CREATURES = Lazy.of(() -> ImmutableList.of(
            new MobSpawnSettings.SpawnerData(EntityType.BAT, 30, 10, 15),
            new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_HORSE, 100, 1, 2)
    ));


}