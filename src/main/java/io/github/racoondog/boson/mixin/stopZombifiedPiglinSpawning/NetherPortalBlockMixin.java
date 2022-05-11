package io.github.racoondog.boson.mixin.stopZombifiedPiglinSpawning;

import net.minecraft.block.NetherPortalBlock;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import static io.github.racoondog.boson.Boson.CONFIG;

@Mixin(NetherPortalBlock.class)
public abstract class NetherPortalBlockMixin {
    @Redirect(method = "randomTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/GameRules;getBoolean(Lnet/minecraft/world/GameRules$Key;)Z"))
    private boolean mixin(GameRules instance, GameRules.Key<GameRules.BooleanRule> rule) {
        return !CONFIG.vanillaTweaks.stopZombifiedPiglinSpawning && instance.getBoolean(rule);
    }
}
