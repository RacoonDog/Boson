package io.github.racoondog.boson.mixin.dispenserPlacesBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static io.github.racoondog.boson.Boson.CONFIG;

@Mixin(ItemDispenserBehavior.class)
public abstract class ItemDispenserBehaviorMixin {
    @Inject(method = "dispenseSilently", at = @At("HEAD"), cancellable = true)
    private void inject(BlockPointer pointer, ItemStack stack, CallbackInfoReturnable<ItemStack> cir) {
        if (CONFIG.fun.dispenserPlacesBlocks && stack.getItem() instanceof BlockItem blockItem) {
            Direction direction = pointer.getBlockState().get(DispenserBlock.FACING);
            BlockPos blockPos = pointer.getPos().offset(direction);
            World world = pointer.getWorld();
            if (world.getBlockState(blockPos).isAir()) {
                Block block = blockItem.getBlock();
                BlockState state = block.getDefaultState();
                if (!world.isClient) {
                    world.setBlockState(blockPos, state);
                    world.emitGameEvent(null, GameEvent.BLOCK_PLACE, blockPos);
                }
                stack.decrement(1);
            }
            cir.setReturnValue(stack);
        }
    }
}
