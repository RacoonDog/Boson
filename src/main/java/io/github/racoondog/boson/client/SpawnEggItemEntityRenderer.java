package io.github.racoondog.boson.client;

import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.FlyingItemEntity;
import net.minecraft.item.SpawnEggItem;

public class SpawnEggItemEntityRenderer<T extends Entity & FlyingItemEntity> extends FlyingItemEntityRenderer<T> {
    public SpawnEggItemEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public boolean shouldRender(T entity, Frustum frustum, double x, double y, double z) {
        if (entity.getStack().getItem() instanceof SpawnEggItem) {
            return super.shouldRender(entity, frustum, x, y, z);
        }
        return false;
    }
}
