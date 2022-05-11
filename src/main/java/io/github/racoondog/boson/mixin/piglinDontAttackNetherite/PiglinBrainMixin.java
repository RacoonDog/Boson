package io.github.racoondog.boson.mixin.piglinDontAttackNetherite;

import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import static io.github.racoondog.boson.Boson.CONFIG;

@Mixin(PiglinBrain.class)
public abstract class PiglinBrainMixin {
    @Redirect(method = "wearsGoldArmor(Lnet/minecraft/entity/LivingEntity;)Z", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ArmorItem;getMaterial()Lnet/minecraft/item/ArmorMaterial;"))
    private static ArmorMaterial mixin(ArmorItem instance) {
        ArmorMaterial armorMaterial = instance.getMaterial();
        return CONFIG.vanillaTweaks.piglinDontAttackNetherite && armorMaterial == ArmorMaterials.NETHERITE ? ArmorMaterials.GOLD : armorMaterial;
    }
}
