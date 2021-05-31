package com.thevortex.allthemodium.init;

import com.github.alexthe666.iceandfire.entity.EntityDragonBase;
import com.thevortex.allthemodium.entities.SkeletonDragonEntity;
import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.entity.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Reference.MOD_ID);

    public static final RegistryObject<EntityType<SkeletonDragonEntity>> SKELETON_DRAGON = createCreatureEntity("skeleton_dragon", SkeletonDragonEntity::new, 0.78F, 1.2F);

    private static <T extends CreatureEntity> RegistryObject<EntityType<T>> createCreatureEntity(String name, EntityType.IFactory<T> factory, float width, float height) {
        ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
        EntityType<T> entity = EntityType.Builder.of(factory, EntityClassification.CREATURE).sized(width, height).setTrackingRange(256).setUpdateInterval(1).build(location.toString());

        return ENTITIES.register(name, () -> entity);
    }

    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.SKELETON_DRAGON.get(), EntityDragonBase.bakeAttributes().build());
    }
}
