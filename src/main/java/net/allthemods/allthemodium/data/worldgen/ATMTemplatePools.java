package net.allthemods.allthemodium.data.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

import net.allthemods.allthemodium.api.ATM;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

public class ATMTemplatePools {
    
    public static final ResourceKey<StructureTemplatePool> DUNGEON_BEGIN = ATMTemplatePools.create("dungeon/begin");
    public static final ResourceKey<StructureTemplatePool> DUNGEON_DOWN = ATMTemplatePools.create("dungeon/down");
    public static final ResourceKey<StructureTemplatePool> DUNGEON_SIDE_POOL = ATMTemplatePools.create("dungeon/side_pool");
    public static final ResourceKey<StructureTemplatePool> DUNGEON_START_POOL = ATMTemplatePools.create("dungeon/start_pool");
    
    public static final ResourceKey<StructureTemplatePool> PYRAMID_SIDE_2 = ATMTemplatePools.create("pyramid/side_2");
    public static final ResourceKey<StructureTemplatePool> PYRAMID_SIDE_3 = ATMTemplatePools.create("pyramid/side_3");
    public static final ResourceKey<StructureTemplatePool> PYRAMID_SIDE_4 = ATMTemplatePools.create("pyramid/side_4");
    public static final ResourceKey<StructureTemplatePool> PYRAMID_START_POOL = ATMTemplatePools.create("pyramid/start_pool");
    
    public static final ResourceKey<StructureTemplatePool> VILLAGE_MAIN_POOL = ATMTemplatePools.create("village/main_pool");
    public static final ResourceKey<StructureTemplatePool> VILLAGE_START_POOL = ATMTemplatePools.create("village/start_pool");
    
    public static void bootstrap(final BootstrapContext<StructureTemplatePool> ctx) {
        HolderGetter<StructureTemplatePool> pools = ctx.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> empty = pools.getOrThrow(Pools.EMPTY);
        
        ATMTemplatePools.register(ctx, ATMTemplatePools.PYRAMID_START_POOL, empty, ATMTemplatePools.element("allthemodium:pyramid/start", 1));
        ATMTemplatePools.register(ctx, ATMTemplatePools.PYRAMID_SIDE_2, empty, ATMTemplatePools.element("allthemodium:pyramid/side_2", 1));
        ATMTemplatePools.register(ctx, ATMTemplatePools.PYRAMID_SIDE_3, empty, ATMTemplatePools.element("allthemodium:pyramid/side_3", 1));
        ATMTemplatePools.register(ctx, ATMTemplatePools.PYRAMID_SIDE_4, empty, ATMTemplatePools.element("allthemodium:pyramid/side_4", 1));
        
        ATMTemplatePools.register(ctx, ATMTemplatePools.DUNGEON_START_POOL, empty, ATMTemplatePools.element("allthemodium:dungeon/fortress_start", 1));
        ATMTemplatePools.register(ctx, ATMTemplatePools.DUNGEON_BEGIN, empty, ATMTemplatePools.element("allthemodium:dungeon/beginning", 100));
        ATMTemplatePools.register(ctx, ATMTemplatePools.DUNGEON_DOWN, empty, ATMTemplatePools.element("allthemodium:dungeon/descent", 100));
        ATMTemplatePools.register(ctx, ATMTemplatePools.DUNGEON_SIDE_POOL, empty,
                ATMTemplatePools.element("allthemodium:dungeon/hallway_1", 40),
                ATMTemplatePools.element("allthemodium:dungeon/hallway_2", 40),
                ATMTemplatePools.element("allthemodium:dungeon/corner_room", 40),
                ATMTemplatePools.element("allthemodium:dungeon/center_room", 30),
                ATMTemplatePools.element("allthemodium:dungeon/center_deck", 30),
                ATMTemplatePools.element("allthemodium:dungeon/library", 10),
                ATMTemplatePools.element("allthemodium:village/maze", 4),
                ATMTemplatePools.element("allthemodium:dungeon/center_dome", 5),
                ATMTemplatePools.element("allthemodium:dungeon/treasure_room", 3),
                ATMTemplatePools.element("allthemodium:dungeon/mob_forge", 1));
        
        ATMTemplatePools.register(ctx, ATMTemplatePools.VILLAGE_START_POOL, empty, ATMTemplatePools.element("allthemodium:village/illager_keep_start", 1));
        ATMTemplatePools.register(ctx, ATMTemplatePools.VILLAGE_MAIN_POOL, empty,
                ATMTemplatePools.element("allthemodium:village/bastion", 10),
                ATMTemplatePools.element("allthemodium:village/well", 10),
                ATMTemplatePools.element("allthemodium:village/smithy_house", 10),
                ATMTemplatePools.element("allthemodium:village/piglin_guardhouse", 10),
                ATMTemplatePools.element("allthemodium:village/path_1", 30),
                ATMTemplatePools.element("allthemodium:village/path_2", 30),
                ATMTemplatePools.element("allthemodium:village/path_3", 30),
                ATMTemplatePools.element("allthemodium:village/path_4", 30),
                ATMTemplatePools.element("allthemodium:village/cross_path", 40),
                ATMTemplatePools.element("allthemodium:village/forge", 10),
                ATMTemplatePools.element("allthemodium:village/prisoners", 10),
                ATMTemplatePools.element("allthemodium:village/windmill", 10),
                ATMTemplatePools.element("allthemodium:village/merchant_librarian", 5),
                ATMTemplatePools.element("allthemodium:village/merchant_farmer", 5),
                ATMTemplatePools.element("allthemodium:village/merchant_weaponsmith", 5),
                ATMTemplatePools.element("allthemodium:village/farm", 25),
                ATMTemplatePools.element("allthemodium:village/maze", 1));
    }
    
    @SafeVarargs
    private static void register(
            BootstrapContext<StructureTemplatePool> ctx,
            ResourceKey<StructureTemplatePool> key,
            Holder<StructureTemplatePool> fallback,
            Pair<java.util.function.Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer>... elements
    ) {
        ctx.register(key, new StructureTemplatePool(fallback, ImmutableList.copyOf(elements), StructureTemplatePool.Projection.RIGID));
    }
    
    private static Pair<java.util.function.Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer> element(String location, int weight) {
        return Pair.of(StructurePoolElement.single(location), weight);
    }
    
    private static ResourceKey<StructureTemplatePool> create(String path) {
        return ATM.key(Registries.TEMPLATE_POOL, path);
    }
}
