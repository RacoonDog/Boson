package io.github.racoondog.boson.entities;

import io.github.racoondog.boson.Boson;
import io.github.racoondog.boson.util.Util;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static EntityType<SpawnEggEntity> SPAWN_EGG_ENTITY = null;

    public static void init() {
        if (Boson.CONFIG.vanillaTweaks.throwableSpawnEggs) {
            SPAWN_EGG_ENTITY = FabricEntityTypeBuilder.<SpawnEggEntity>create(
                    SpawnGroup.MISC, SpawnEggEntity::new).dimensions(EntityDimensions.fixed(0.25f, 0.25f)).trackRangeChunks(4).trackedUpdateRate(10).build();
            Registry.register(Registry.ENTITY_TYPE, Util.id("spawn_egg_entity"), SPAWN_EGG_ENTITY);
        }
    }

    private static EntityType<? extends Entity> register(String path, EntityType<? extends Entity> entityType) {
        return Registry.register(Registry.ENTITY_TYPE, Util.id(path), entityType);
    }
}
