package io.github.racoondog.boson.mixin.moreInstrumentBlocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.enums.Instrument;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static io.github.racoondog.boson.Boson.CONFIG;

@Mixin(Instrument.class)
public abstract class InstrumentMixin {
    @Inject(method = "fromBlockState", at = @At("HEAD"), cancellable = true)
    private static void fromBlockState(BlockState state, CallbackInfoReturnable<Instrument> cir) {
        if (CONFIG.vanillaTweaks.moreInstrumentBlocks) {
            Material material = state.getMaterial();
            if (material == Material.GOURD) {
                cir.setReturnValue(Instrument.DIDGERIDOO);
            } else if (state.isOf(Blocks.ICE)) {
                cir.setReturnValue(Instrument.CHIME);
            } else if (state.isOf(Blocks.REDSTONE_LAMP)) {
                cir.setReturnValue(Instrument.PLING);
            } else if (state.isOf(Blocks.SOUL_SOIL)) {
                cir.setReturnValue(Instrument.COW_BELL);
            } else if (material == Material.METAL && !state.isOf(Blocks.GOLD_BLOCK)) {
                cir.setReturnValue(Instrument.IRON_XYLOPHONE);
            } else if (state.isOf(Blocks.BEACON) || state.isOf(Blocks.EMERALD_ORE) || state.isOf(Blocks.DEEPSLATE_EMERALD_ORE)) {
                cir.setReturnValue(Instrument.BIT);
            } else if (state.isOf(Blocks.WITHER_SKELETON_SKULL) || state.isOf(Blocks.WITHER_SKELETON_WALL_SKULL) || state.isOf(Blocks.WITHER_ROSE) || state.isOf(Blocks.POTTED_WITHER_ROSE)) {
                cir.setReturnValue(Instrument.COW_BELL);
            } else if (state.isOf(Blocks.RAW_GOLD_BLOCK) || state.isOf(Blocks.GOLD_ORE) || state.isOf(Blocks.DEEPSLATE_GOLD_ORE) || state.isOf(Blocks.NETHER_GOLD_ORE)) {
                cir.setReturnValue(Instrument.BELL);
            } else if (state.isOf(Blocks.RAW_IRON_BLOCK) || state.isOf(Blocks.IRON_ORE) || state.isOf(Blocks.DEEPSLATE_IRON_ORE)) {
                cir.setReturnValue(Instrument.IRON_XYLOPHONE);
            }
        }
    }
}
