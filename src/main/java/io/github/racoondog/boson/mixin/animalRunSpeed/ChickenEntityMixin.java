package io.github.racoondog.boson.mixin.animalRunSpeed;

import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.ChickenEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import static io.github.racoondog.boson.Boson.CONFIG;

@Mixin(ChickenEntity.class)
public abstract class ChickenEntityMixin {
    @ModifyArg(method = "initGoals", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/ai/goal/EscapeDangerGoal;<init>(Lnet/minecraft/entity/mob/PathAwareEntity;D)V"), index = 1)
    private double mixin(PathAwareEntity pathAwareEntity, double d) {
        return CONFIG.vanillaTweaks.animalRunSpeed ? 1.3D : d;
    }
}
