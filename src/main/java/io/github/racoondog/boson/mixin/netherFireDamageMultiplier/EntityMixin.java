package io.github.racoondog.boson.mixin.netherFireDamageMultiplier;

import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import static io.github.racoondog.boson.Boson.CONFIG;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @ModifyArg(method = "setOnFireFor", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;setFireTicks(I)V"))
    private int mixin(int i) {
        return (int) (CONFIG.vanillaTweaks.netherFireDamageMultiplier * i);
    }
}
