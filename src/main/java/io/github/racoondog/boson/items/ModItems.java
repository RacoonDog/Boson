package io.github.racoondog.boson.items;

import io.github.racoondog.boson.util.Util;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

import static io.github.racoondog.boson.Boson.CONFIG;

public class ModItems {
    public static Item STRANGE_POWDER;
    public static Item ACTIVE_STRANGE_POWDER;
    public static Item BAT_WING;

    private static <T extends Item> T register(T item, String path) {
        return Registry.register(Registry.ITEM, Util.id(path), item);
    }

    public static void init() {
        if (CONFIG.strangeBlocks) {
            STRANGE_POWDER = new Item(new FabricItemSettings().group(ItemGroup.MISC));
            ACTIVE_STRANGE_POWDER = new EnchantedItem(new FabricItemSettings().group(ItemGroup.MISC));
            register(STRANGE_POWDER, "strange_powder");
            register(ACTIVE_STRANGE_POWDER, "active_strange_powder");
        }
        if (CONFIG.brewableLuck && !FabricLoader.getInstance().isModLoaded("felix-felicis")) {
            BAT_WING = new Item(new FabricItemSettings().group(ItemGroup.MISC));
            register(BAT_WING, "bat_wing");
        }
    }
}
