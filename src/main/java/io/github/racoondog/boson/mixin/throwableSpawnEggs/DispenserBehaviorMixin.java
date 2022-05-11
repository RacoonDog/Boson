package io.github.racoondog.boson.mixin.throwableSpawnEggs;

import io.github.racoondog.boson.entities.SpawnEggEntity;
import net.minecraft.block.DispenserBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static io.github.racoondog.boson.Boson.CONFIG;
import static net.minecraft.block.dispenser.DispenserBehavior.LOGGER;

@Mixin(targets = "net/minecraft/block/dispenser/DispenserBehavior$26")
public abstract class DispenserBehaviorMixin {
    @Inject(method = "dispenseSilently(Lnet/minecraft/util/math/BlockPointer;Lnet/minecraft/item/ItemStack;)Lnet/minecraft/item/ItemStack;", at = @At("HEAD"), cancellable = true)
    private void inject(BlockPointer pointer, ItemStack stack, CallbackInfoReturnable<ItemStack> cir) {
        if (CONFIG.vanillaTweaks.throwableSpawnEggs) {
            Direction direction = pointer.getBlockState().get(DispenserBlock.FACING);

            try {
                Position pos = DispenserBlock.getOutputLocation(pointer);
                SpawnEggEntity spawnEggEntity = new SpawnEggEntity(pointer.getWorld(), pos.getX(), pos.getY(), pos.getZ());
                spawnEggEntity.setItem(stack);
                spawnEggEntity.setVelocity(direction.getOffsetX(), (float)direction.getOffsetY() + 0.1F, direction.getOffsetZ(), 1.1f, 6.0f);
                pointer.getWorld().spawnEntity(spawnEggEntity);
            } catch (Exception var6) {
                LOGGER.error("Error while dispensing spawn egg from dispenser at {}", pointer.getPos(), var6);
                cir.setReturnValue(ItemStack.EMPTY);
            }

            stack.decrement(1);
            pointer.getWorld().emitGameEvent(GameEvent.ENTITY_PLACE, pointer.getPos());
            cir.setReturnValue(stack);
        }
    }
}
