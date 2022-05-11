package io.github.racoondog.boson.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.EggEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SpawnEggEntity extends EggEntity {
    public SpawnEggEntity(EntityType<? extends EggEntity> entityEntityType, World world) {
        super(entityEntityType, world);
    }

    public SpawnEggEntity(World world, LivingEntity owner) {
        super(world, owner);
    }

    public SpawnEggEntity(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        if (!this.world.isClient) {
            ItemStack stack = this.getItem();
            if (stack.getItem() instanceof SpawnEggItem spawnEggItem) {
                EntityType<?> entityType = spawnEggItem.getEntityType(stack.getNbt());
                BlockPos blockPos = new BlockPos(this.getX(), this.getY(), this.getZ());
                entityType.spawnFromItemStack((ServerWorld) this.world, stack, this.getOwner() instanceof PlayerEntity user ? user : null, blockPos, SpawnReason.SPAWN_EGG, false, false);
                this.world.sendEntityStatus(this, (byte)3);
            }
            this.discard();
        }
    }
}
