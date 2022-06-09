package io.github.racoondog.boson.client;

import io.github.racoondog.boson.blocks.ModBlocks;
import io.github.racoondog.boson.entities.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

import static io.github.racoondog.boson.Boson.CONFIG;

@Environment(EnvType.CLIENT)
public class BosonClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        if (CONFIG.fun.blit) renderLayer(ModBlocks.BLIT, RenderLayer.getTranslucent());
        if (CONFIG.vanillaTweaks.throwableSpawnEggs) {
            EntityRendererRegistry.register(ModEntities.SPAWN_EGG_ENTITY, SpawnEggItemEntityRenderer::new);
        }
    }

    private static void renderLayer(Block block, RenderLayer renderLayer) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, renderLayer);
    }
}
