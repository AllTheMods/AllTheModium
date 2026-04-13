package net.allthemods.allthemodium.data.provider;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;

public class ATMEnchantments {
    
    public static void bootstrap(final BootstrapContext<Enchantment> ctx) {
        HolderGetter<Item> items = ctx.lookup(Registries.ITEM);
        HolderGetter<Block> blocks = ctx.lookup(Registries.BLOCK);
        HolderGetter<EntityType<?>> entityTypes = ctx.lookup(Registries.ENTITY_TYPE);
        
        // This override is needed to make channeling work with the alloy trident since the vanilla enchantment only checks for the default trident entity type.
        // This will NOT generate under the vanilla resource key, so uncomment this only if any changes are needed.
        // After generating in /src/generated/resources/data/allthemodium/enchantment/channeling.json copy to /src/main/resources/data/minecraft/enchantment/channeling.json
        //        ctx.register(
        //                ATM.key(Registries.ENCHANTMENT, "channeling"),
        //                Enchantment.enchantment(
        //                        Enchantment.definition(
        //                                items.getOrThrow(ItemTags.TRIDENT_ENCHANTABLE),
        //                                1,
        //                                1,
        //                                Enchantment.constantCost(25),
        //                                Enchantment.constantCost(50),
        //                                8,
        //                                EquipmentSlotGroup.MAINHAND
        //                        ))
        //                        .withEffect(
        //                                EnchantmentEffectComponents.POST_ATTACK,
        //                                EnchantmentTarget.ATTACKER,
        //                                EnchantmentTarget.VICTIM,
        //                                AllOf.entityEffects(
        //                                        new SummonEntityEffect(HolderSet.direct(EntityType.LIGHTNING_BOLT.builtInRegistryHolder()), false),
        //                                        new PlaySoundEffect(List.of(SoundEvents.TRIDENT_THUNDER), ConstantFloat.of(5.0F), ConstantFloat.of(1.0F))
        //                                ),
        //                                AnyOfCondition.anyOf(
        //                                        AllOfCondition.allOf(
        //                                                WeatherCheck.weather().setThundering(true),
        //                                                LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().located(LocationPredicate.Builder.location().setCanSeeSky(true))),
        //                                                LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.DIRECT_ATTACKER, EntityPredicate.Builder.entity().of(entityTypes, EntityType.TRIDENT))
        //                                        ),
        //                                        LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.DIRECT_ATTACKER, EntityPredicate.Builder.entity().of(entityTypes, ATMEntities.ALLOY_TRIDENT_ENTITY.get()))
        //                                )
        //                        )
        //                        .withEffect(
        //                                EnchantmentEffectComponents.HIT_BLOCK,
        //                                AllOf.entityEffects(
        //                                        new SummonEntityEffect(HolderSet.direct(EntityType.LIGHTNING_BOLT.builtInRegistryHolder()), false),
        //                                        new PlaySoundEffect(List.of(SoundEvents.TRIDENT_THUNDER), ConstantFloat.of(5.0F), ConstantFloat.of(1.0F))
        //                                ),
        //                                AnyOfCondition.anyOf(
        //                                        AllOfCondition.allOf(
        //                                                WeatherCheck.weather().setThundering(true),
        //                                                LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().of(entityTypes, EntityType.TRIDENT)),
        //                                                LocationCheck.checkLocation(LocationPredicate.Builder.location()
        //                                                        .setCanSeeSky(true)
        //                                                        .setBlock(BlockPredicate.Builder.block().of(blocks, BlockTags.LIGHTNING_RODS))
        //                                                )
        //                                        ),
        //                                        LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().of(entityTypes, ATMEntities.ALLOY_TRIDENT_ENTITY.get()))
        //                                )
        //                        ).build(Enchantments.CHANNELING.identifier())
        //        );
    }
}
