package io.github.racoondog.boson.mixin.survivalInventoryTrash;

import com.mojang.blaze3d.systems.RenderSystem;
import io.github.racoondog.boson.util.DeleteItemSlotProvider;
import io.github.racoondog.boson.util.Util;
import net.minecraft.client.gui.screen.ingame.AbstractInventoryScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.gui.screen.recipebook.RecipeBookProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static io.github.racoondog.boson.Boson.CONFIG;

@Mixin(InventoryScreen.class)
public abstract class InventoryScreenMixin extends AbstractInventoryScreen<PlayerScreenHandler> implements RecipeBookProvider {
    @Unique
    private static final Text DELETE_ITEM_SLOT_TEXT = Text.translatable("inventory.binSlot");

    @Unique
    private static final Identifier BACKGROUND_TEXTURE_WITH_TRASH = Util.id("textures/gui/inventory_with_trash.png");

    public InventoryScreenMixin(PlayerScreenHandler screenHandler, PlayerInventory playerInventory, Text text) {
        super(screenHandler, playerInventory, text);
    }

    @Inject(method = "render", at = @At("TAIL"))
    private void injectRender(MatrixStack matrices, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        if (CONFIG.vanillaTweaks.survivalInventoryTrash) {
            Slot deleteItemSlot = ((DeleteItemSlotProvider)this.handler).getDeleteItemSlot();
            if (deleteItemSlot != null && this.isPointWithinBounds(deleteItemSlot.x, deleteItemSlot.y, 16, 16, mouseX, mouseY) && deleteItemSlot.inventory.isEmpty()) {
                this.renderTooltip(matrices, DELETE_ITEM_SLOT_TEXT, mouseX, mouseY);
            }

            //RenderSystem.setShaderTexture(0, DELETE_ITEM_SLOT_TEXTURE);
            //DrawableHelper.drawTexture(matrices, 128 * client.options.guiScale, 49 * client.options.guiScale, 350, 172, 111, 18, 18, 256, 256);
        }
    }

    @Redirect(method = "drawBackground", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;setShaderTexture(ILnet/minecraft/util/Identifier;)V"))
    private void redirectBackgroundTexture(int i, Identifier identifier) {
        if (!CONFIG.vanillaTweaks.survivalInventoryTrash) {
            RenderSystem.setShaderTexture(i, identifier);
        } else {
            RenderSystem.setShaderTexture(i, BACKGROUND_TEXTURE_WITH_TRASH);
        }
    }
}