package io.github.racoondog.boson.mixin.throwableSpawnEggs;

import io.github.racoondog.boson.entities.SpawnEggEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static io.github.racoondog.boson.Boson.CONFIG;

@Mixin(SpawnEggItem.class)
public abstract class SpawnEggItemMixin<T> {
    @Inject(method = "use", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/TypedActionResult;pass(Ljava/lang/Object;)Lnet/minecraft/util/TypedActionResult;", ordinal = 0, by = -1), cancellable = true)
    private void throwable(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir) {
        if (CONFIG.vanillaTweaks.throwableSpawnEggs) {
            ItemStack itemStack = user.getStackInHand(hand);
            world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
            if (!world.isClient) {
                SpawnEggEntity eggEntity = new SpawnEggEntity(world, user);
                eggEntity.setItem(itemStack);
                eggEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
                world.spawnEntity(eggEntity);
            }

            user.incrementStat(Stats.USED.getOrCreateStat(itemStack.getItem()));
            if (!user.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }

            cir.setReturnValue(TypedActionResult.success(itemStack, world.isClient()));
        }
    }
}
