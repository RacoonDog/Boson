package io.github.racoondog.boson.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;

public class TrashInventory implements Inventory {
    private ItemStack stack = ItemStack.EMPTY;

    @Override
    public int size() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public ItemStack getStack(int slot) {
        return stack;
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        return removeStack(slot);
    }

    @Override
    public ItemStack removeStack(int slot) {
        ItemStack itemStack = stack;
        stack = ItemStack.EMPTY;
        return itemStack;
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        this.stack = stack;
    }

    @Override
    public void markDirty() {
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return true;
    }

    @Override
    public void clear() {
        stack = ItemStack.EMPTY;
    }
}
