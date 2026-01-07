package com.thevortex.allthemodium.reference;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import static com.thevortex.allthemodium.AllTheModium.*;


public class Reference {

	public static final ResourceLocation ORETYPE = location("c:ores/allthemodium");
	public static final ResourceLocation ORETYPE2 = location("c:ores/vibranium");
	public static final ResourceLocation ORETYPE3 = location("c:ores/unobtainium");
	public static final String MOD_ID = "allthemodium";
	public static String tab() {
		return String.format("itemGroup.%s", MOD_ID);
	}
	public static String tabmek() {
		return String.format("itemGroup.%s", MOD_ID + "_mek");
	}
	public static ResourceLocation atm(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}
	public static ResourceLocation mek(String path) {
		return ResourceLocation.fromNamespaceAndPath("mekanism", path);
	}
	public static ResourceLocation location(String pathIn) {
		return ResourceLocation.tryParse(pathIn);
	}
	public static ResourceLocation common(String path) {
		return ResourceLocation.fromNamespaceAndPath("c", path);
	}
	public static ResourceLocation raw_ores(String path) {
		return common("raw_ores/" + path);
	}
	public static ResourceLocation material(String path) {
		return common("raw_materials/" + path);
	}
	public static ResourceLocation ingot(String path) {
		return common("ingots/" + path);
	}
	public static ResourceLocation dust(String path) {
		return common("dusts/" + path);
	}
	public static ResourceLocation dirty(String path) {
		return common("dirty_dusts/" + path);
	}
	public static ResourceLocation shard(String path) {
		return common("shards/" + path);
	}
	public static ResourceLocation clump(String path) {
		return common("clumps/" + path);
	}
	public static ResourceLocation crystal(String path) {
		return common("crystals/" + path);
	}
	public static ResourceLocation nugget(String path) {
		return common("nuggets/" + path);
	}
	public static ResourceLocation ore(String path) {
		return common("ores/" + path);
	}
	public static ResourceLocation rod(String path) {
		return common("rods/" + path);
	}
	public static ResourceLocation gear(String path) {
		return common("gears/" + path);
	}
	public static ResourceLocation plate(String path) {
		return common("plates/" + path);
	}
	public static ResourceLocation block(String path) {
		return common("storage_blocks/" + path);
	}
	public static ResourceLocation raw_block(String path) {
		return common("raw_blocks/" + path);
	}

    public static final ResourceKey<Level> OverWorld = Level.OVERWORLD;
    public static final ResourceKey<Level> Nether = Level.NETHER;
    public static final ResourceKey<Level> The_End = Level.END;
    public static final ResourceLocation MINING_DIM_ID = ResourceLocation.fromNamespaceAndPath(MOD_ID,"mining");
    public static final ResourceLocation THE_OTHER_DIM_ID = ResourceLocation.fromNamespaceAndPath(MOD_ID,"the_other");

    public static final ResourceLocation THE_BEYOND_DIM_ID = ResourceLocation.fromNamespaceAndPath(MOD_ID,"the_beyond");

    public static final ResourceKey<DimensionType> MINING_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, MINING_DIM_ID);
    public static final ResourceKey<DimensionType> THE_OTHER_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, THE_OTHER_DIM_ID);
    public static final ResourceKey<DimensionType> THE_BEYOND_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, THE_BEYOND_DIM_ID);

	public static final ResourceKey<Level> MINING = ResourceKey.create(Registries.DIMENSION, MINING_DIM_ID);
	public static final ResourceKey<Level> THE_OTHER = ResourceKey.create(Registries.DIMENSION, THE_OTHER_DIM_ID);
	public static final ResourceKey<Level> THE_BEYOND = ResourceKey.create(Registries.DIMENSION, THE_BEYOND_DIM_ID);

    public static final ResourceKey<Biome> Basalt_Deltas = ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(MOD_ID, "basalt_deltas"));
    public static final ResourceKey<Biome> Crimson_Forest = ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(MOD_ID, "crimson_forest"));
    public static final ResourceKey<Biome> Warped_Forest = ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(MOD_ID, "warped_forest"));
    public static final ResourceKey<Biome> Soul_Sand_Valley = ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(MOD_ID, "soul_sand_valley"));
    public static final ResourceKey<Biome> Desert = ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(MOD_ID, "desert"));
    public static final ResourceKey<Biome> Desert_Hills = ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(MOD_ID, "desert_hills"));
    public static final ResourceKey<Biome> The_Other = ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(MOD_ID, "the_other"));

    public static final ResourceKey<ConfiguredFeature<?,?>> SOUL_TREE = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MOD_ID, "soul_tree"));
    public static final ResourceKey<ConfiguredFeature<?,?>> DEMONIC_TREE = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MOD_ID, "demonic_tree"));
    public static final ResourceKey<ConfiguredFeature<?,?>> ANCIENT_TREE = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MOD_ID, "ancient_tree"));
    public static final ResourceKey<ConfiguredFeature<?,?>> OTHER_DELTAS = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MOD_ID, "other_deltas"));

}
