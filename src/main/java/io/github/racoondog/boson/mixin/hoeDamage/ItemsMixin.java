package io.github.racoondog.boson.mixin.hoeDamage;

import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Slice;

import static io.github.racoondog.boson.Boson.CONFIG;

@Mixin(Items.class)
public abstract class ItemsMixin {
    @ModifyArg(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "CONSTANT", args = "stringValue=wooden_hoe")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/HoeItem;<init>(Lnet/minecraft/item/ToolMaterial;IFLnet/minecraft/item/Item$Settings;)V",
                    ordinal = 0
            )
    )
    private static int modifyWoodenHoeDamage(int i) {
        if (CONFIG.vanillaTweaks.hoeDamage) {
            return 1;
        } else {
            return i;
        }
    }
    @ModifyArg(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "CONSTANT", args = "stringValue=stone_hoe")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/HoeItem;<init>(Lnet/minecraft/item/ToolMaterial;IFLnet/minecraft/item/Item$Settings;)V",
                    ordinal = 0
            )
    )
    private static int modifyStoneHoeDamage(int i) {
        if (CONFIG.vanillaTweaks.hoeDamage) {
            return 1;
        } else {
            return i;
        }
    }
    @ModifyArg(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "CONSTANT", args = "stringValue=golden_hoe")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/HoeItem;<init>(Lnet/minecraft/item/ToolMaterial;IFLnet/minecraft/item/Item$Settings;)V",
                    ordinal = 0
            )
    )
    private static int modifyGoldenHoeDamage(int i) {
        if (CONFIG.vanillaTweaks.hoeDamage) {
            return 1;
        } else {
            return i;
        }
    }
    @ModifyArg(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "CONSTANT", args = "stringValue=iron_hoe")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/HoeItem;<init>(Lnet/minecraft/item/ToolMaterial;IFLnet/minecraft/item/Item$Settings;)V",
                    ordinal = 0
            )
    )
    private static int modifyIronHoeDamage(int i) {
        if (CONFIG.vanillaTweaks.hoeDamage) {
            return 1;
        } else {
            return i;
        }
    }
    @ModifyArg(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "CONSTANT", args = "stringValue=diamond_hoe")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/HoeItem;<init>(Lnet/minecraft/item/ToolMaterial;IFLnet/minecraft/item/Item$Settings;)V",
                    ordinal = 0
            )
    )
    private static int modifyDiamondHoeDamage(int i) {
        if (CONFIG.vanillaTweaks.hoeDamage) {
            return 1;
        } else {
            return i;
        }
    }
    @ModifyArg(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "CONSTANT", args = "stringValue=netherite_hoe")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/HoeItem;<init>(Lnet/minecraft/item/ToolMaterial;IFLnet/minecraft/item/Item$Settings;)V",
                    ordinal = 0
            )
    )
    private static int modifyNetheriteHoeDamage(int i) {
        if (CONFIG.vanillaTweaks.hoeDamage) {
            return 1;
        } else {
            return i;
        }
    }

    @ModifyArg(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "CONSTANT", args = "stringValue=stone_hoe")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/HoeItem;<init>(Lnet/minecraft/item/ToolMaterial;IFLnet/minecraft/item/Item$Settings;)V",
                    ordinal = 0
            )
    )
    private static float modifyStoneHoeSpeed(float i) {
        if (CONFIG.vanillaTweaks.hoeDamage) {
            return i - 1.0f;
        } else {
            return i;
        }
    }
    @ModifyArg(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "CONSTANT", args = "stringValue=iron_hoe")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/HoeItem;<init>(Lnet/minecraft/item/ToolMaterial;IFLnet/minecraft/item/Item$Settings;)V",
                    ordinal = 0
            )
    )
    private static float modifyIronHoeSpeed(float i) {
        if (CONFIG.vanillaTweaks.hoeDamage) {
            return i - 2.0f;
        } else {
            return i;
        }
    }
    @ModifyArg(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "CONSTANT", args = "stringValue=diamond_hoe")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/HoeItem;<init>(Lnet/minecraft/item/ToolMaterial;IFLnet/minecraft/item/Item$Settings;)V",
                    ordinal = 0
            )
    )
    private static float modifyDiamondHoeSpeed(float i) {
        if (CONFIG.vanillaTweaks.hoeDamage) {
            return i - 3.0f;
        } else {
            return i;
        }
    }
    @ModifyArg(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "CONSTANT", args = "stringValue=netherite_hoe")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/HoeItem;<init>(Lnet/minecraft/item/ToolMaterial;IFLnet/minecraft/item/Item$Settings;)V",
                    ordinal = 0
            )
    )
    private static float modifyNetheriteHoeSpeed(float i) {
        if (CONFIG.vanillaTweaks.hoeDamage) {
            return i - 3.0f;
        } else {
            return i;
        }
    }
}
