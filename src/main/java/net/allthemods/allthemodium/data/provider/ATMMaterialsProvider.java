package net.allthemods.allthemodium.data.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.silentchaos512.gear.SilentGear;
import net.silentchaos512.gear.api.data.material.MaterialBuilder;
import net.silentchaos512.gear.api.data.material.MaterialsProviderBase;
import net.silentchaos512.gear.api.material.TextureType;
import net.silentchaos512.gear.api.property.HarvestTier;
import net.silentchaos512.gear.api.property.HarvestTierPropertyValue;
import net.silentchaos512.gear.api.property.NumberProperty;
import net.silentchaos512.gear.api.util.DataResource;
import net.silentchaos512.gear.gear.material.MaterialCategories;
import net.silentchaos512.gear.gear.trait.condition.GearTypeTraitCondition;
import net.silentchaos512.gear.gear.trait.condition.MaterialRatioTraitCondition;
import net.silentchaos512.gear.setup.gear.GearProperties;
import net.silentchaos512.gear.setup.gear.GearTypes;
import net.silentchaos512.gear.setup.gear.PartTypes;
import net.silentchaos512.gear.util.Const;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.core.registry.ATMItems;
import net.allthemods.allthemodium.core.registry.ATMTags;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Silent Gear materials for the three ATM metals. The material ids live in the {@code silentgear} namespace, so gear
 * crafted from them keeps resolving and a pack's own copy of a definition still overrides this one by datapack
 * priority. Only referenced from {@link #register} behind a Silent Gear presence check.
 */
public class ATMMaterialsProvider extends MaterialsProviderBase {

    public ATMMaterialsProvider(DataGenerator generator, CompletableFuture<HolderLookup.Provider> registries) {
        super(registries, generator, ATM.MOD_ID);
    }

    public static void register(GatherDataEvent event) {
        event.addProvider(new ATMMaterialsProvider(event.getGenerator(), event.getLookupProvider()));
    }

    @Override
    protected Collection<MaterialBuilder<?>> getMaterials(HolderLookup.Provider provider) {
        return List.of(
                ATMMaterialsProvider.metal("allthemodium", ATMItems.SILENT_ALLTHEMODIUM_PLATE.get(), 0xFFEF0E,
                                HarvestTier.create("allthemodium", "5", ATMTags.Blocks.INCORRECT_FOR_ALLTHEMODIUM_TOOL))
                        .stat(PartTypes.MAIN, GearProperties.DURABILITY, 5500)
                        .stat(PartTypes.MAIN, GearProperties.ARMOR_DURABILITY, 60)
                        .stat(PartTypes.MAIN, GearProperties.ENCHANTMENT_VALUE, 85)
                        .stat(PartTypes.MAIN, GearProperties.RARITY, 90)
                        .stat(PartTypes.MAIN, GearProperties.ATTACK_DAMAGE, 22)
                        .stat(PartTypes.MAIN, GearProperties.ATTACK_SPEED, 8.2f)
                        .mainStatsHarvest(HarvestTier.create("allthemodium", "5", ATMTags.Blocks.INCORRECT_FOR_ALLTHEMODIUM_TOOL), 8)
                        .mainStatsArmor(15, 15, 15, 15, 60, 200)
                        .trait(PartTypes.MAIN, Const.Traits.MALLEABLE, 4)
                        .trait(PartTypes.MAIN, Const.Traits.CRUSHING, 4)
                        .stat(PartTypes.ROD, GearProperties.DURABILITY, 1.5f, NumberProperty.Operation.MULTIPLY_TOTAL)
                        .stat(PartTypes.ROD, GearProperties.ENCHANTMENT_VALUE, 3, NumberProperty.Operation.ADD)
                        .stat(PartTypes.ROD, GearProperties.RARITY, 70)
                        .trait(PartTypes.ROD, Const.Traits.HARD, 5, new MaterialRatioTraitCondition(0.5f))
                        .stat(PartTypes.TIP, GearProperties.RARITY, 30, NumberProperty.Operation.ADD)
                        .trait(PartTypes.TIP, Const.Traits.MALLEABLE, 4)
                        .trait(PartTypes.TIP, Const.Traits.SOFT, 3),

                ATMMaterialsProvider.metal("vibranium", ATMItems.SILENT_VIBRANIUM_PLATE.get(), 0x26DE88,
                                HarvestTier.create("vibranium", "6", ATMTags.Blocks.INCORRECT_FOR_VIBRANIUM_TOOL))
                        .stat(PartTypes.MAIN, GearProperties.DURABILITY, 7500)
                        .stat(PartTypes.MAIN, GearProperties.ARMOR_DURABILITY, 90)
                        .stat(PartTypes.MAIN, GearProperties.ENCHANTMENT_VALUE, 105)
                        .stat(PartTypes.MAIN, GearProperties.RARITY, 90)
                        .stat(PartTypes.MAIN, GearProperties.ATTACK_DAMAGE, 27)
                        .stat(PartTypes.MAIN, GearProperties.ATTACK_SPEED, 12.2f)
                        .mainStatsHarvest(HarvestTier.create("vibranium", "6", ATMTags.Blocks.INCORRECT_FOR_VIBRANIUM_TOOL), 9)
                        .mainStatsArmor(15, 20, 20, 15, 70, 400)
                        .trait(PartTypes.MAIN, Const.Traits.MALLEABLE, 5)
                        .trait(PartTypes.MAIN, Const.Traits.CRUSHING, 5)
                        .trait(PartTypes.MAIN, Const.Traits.CURE_WITHER, 1, new GearTypeTraitCondition(GearTypes.LEGGINGS))
                        .stat(PartTypes.ROD, GearProperties.DURABILITY, 2.5f, NumberProperty.Operation.MULTIPLY_TOTAL)
                        .stat(PartTypes.ROD, GearProperties.ENCHANTMENT_VALUE, 23, NumberProperty.Operation.ADD)
                        .stat(PartTypes.ROD, GearProperties.RARITY, 99)
                        .trait(PartTypes.ROD, Const.Traits.HARD, 6, new MaterialRatioTraitCondition(0.5f))
                        .stat(PartTypes.TIP, GearProperties.RARITY, 60, NumberProperty.Operation.ADD)
                        .trait(PartTypes.TIP, Const.Traits.MALLEABLE, 5)
                        .trait(PartTypes.TIP, Const.Traits.HARD, 5),

                ATMMaterialsProvider.metal("unobtainium", ATMItems.SILENT_UNOBTAINIUM_PLATE.get(), 0xD152E3,
                                HarvestTier.create("unobtainium", "7", ATMTags.Blocks.INCORRECT_FOR_UNOBTAINIUM_TOOL))
                        .stat(PartTypes.MAIN, GearProperties.DURABILITY, 9500)
                        .stat(PartTypes.MAIN, GearProperties.ARMOR_DURABILITY, 120)
                        .stat(PartTypes.MAIN, GearProperties.ENCHANTMENT_VALUE, 175)
                        .stat(PartTypes.MAIN, GearProperties.RARITY, 99)
                        .stat(PartTypes.MAIN, GearProperties.ATTACK_DAMAGE, 35)
                        .stat(PartTypes.MAIN, GearProperties.ATTACK_SPEED, 18.2f)
                        .mainStatsHarvest(HarvestTier.create("unobtainium", "7", ATMTags.Blocks.INCORRECT_FOR_UNOBTAINIUM_TOOL), 18)
                        .mainStatsArmor(20, 25, 25, 20, 90, 600)
                        .trait(PartTypes.MAIN, Const.Traits.MALLEABLE, 5)
                        .trait(PartTypes.MAIN, Const.Traits.CRUSHING, 5)
                        .trait(PartTypes.MAIN, Const.Traits.CURE_WITHER, 1, new GearTypeTraitCondition(GearTypes.LEGGINGS))
                        .stat(PartTypes.ROD, GearProperties.DURABILITY, 1.5f, NumberProperty.Operation.MULTIPLY_TOTAL)
                        .stat(PartTypes.ROD, GearProperties.ENCHANTMENT_VALUE, 13, NumberProperty.Operation.ADD)
                        .stat(PartTypes.ROD, GearProperties.RARITY, 90)
                        .trait(PartTypes.ROD, Const.Traits.HARD, 7, new MaterialRatioTraitCondition(0.5f))
                        .stat(PartTypes.TIP, GearProperties.RARITY, 60, NumberProperty.Operation.ADD)
                        .trait(PartTypes.TIP, Const.Traits.MALLEABLE, 5)
                        .trait(PartTypes.TIP, Const.Traits.HARD, 5)
        );
    }

    /**
     * The parts every ATM metal shares: crafting from its silent plate, the armour traits on the main part, and the
     * tip's flat bonuses and harvest tier.
     */
    private static MaterialBuilder<?> metal(String name, ItemLike plate, int color, HarvestTier tier) {
        return MaterialBuilder.simple(DataResource.material(SilentGear.getId(name)))
                .crafting(plate, MaterialCategories.METAL, MaterialCategories.ENDGAME)
                .displayWithDefaultName(color, TextureType.HIGH_CONTRAST)
                .stat(PartTypes.MAIN, GearProperties.RANGED_DAMAGE, 0)
                .trait(PartTypes.MAIN, Const.Traits.BRILLIANT, 1, new GearTypeTraitCondition(GearTypes.ARMOR))
                .trait(PartTypes.MAIN, Const.Traits.AQUATIC, 1, new GearTypeTraitCondition(GearTypes.HELMET))
                .trait(PartTypes.MAIN, Const.Traits.FLAME_WARD, 1, new GearTypeTraitCondition(GearTypes.CHESTPLATE))
                .stat(PartTypes.TIP, GearProperties.DURABILITY, 16, NumberProperty.Operation.ADD)
                .stat(PartTypes.TIP, GearProperties.ARMOR_DURABILITY, 10, NumberProperty.Operation.ADD)
                .stat(PartTypes.TIP, GearProperties.HARVEST_TIER, new HarvestTierPropertyValue(tier))
                .stat(PartTypes.TIP, GearProperties.HARVEST_SPEED, 6, NumberProperty.Operation.ADD)
                .stat(PartTypes.TIP, GearProperties.MAGIC_DAMAGE, 2, NumberProperty.Operation.ADD);
    }
}
