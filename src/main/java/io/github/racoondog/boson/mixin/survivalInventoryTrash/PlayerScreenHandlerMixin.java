package io.github.racoondog.boson.mixin.survivalInventoryTrash;

import io.github.racoondog.boson.util.DeleteItemSlotProvider;
import io.github.racoondog.boson.util.TrashInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.screen.AbstractRecipeScreenHandler;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static io.github.racoondog.boson.Boson.CONFIG;

@Mixin(PlayerScreenHandler.class)
public abstract class PlayerScreenHandlerMixin extends AbstractRecipeScreenHandler<CraftingInventory> implements DeleteItemSlotProvider {
    @Unique
    private Slot deleteItemSlot;

    @Override
    public Slot getDeleteItemSlot() {
        return this.deleteItemSlot;
    }

    public PlayerScreenHandlerMixin(ScreenHandlerType<?> screenHandlerType, int i) {
        super(screenHandlerType, i);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void injectInit(PlayerInventory inventory, boolean onServer, PlayerEntity owner, CallbackInfo ci) {
        if (CONFIG.vanillaTweaks.survivalInventoryTrash) this.deleteItemSlot = this.addSlot(new Slot(new TrashInventory(), 46, 152, 62));
    }

    @Inject(method = "close", at = @At("TAIL"))
    private void injectClose(PlayerEntity player, CallbackInfo ci) {
        if (CONFIG.vanillaTweaks.survivalInventoryTrash) this.deleteItemSlot.inventory.removeStack(0);
    }
}
