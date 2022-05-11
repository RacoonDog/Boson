package io.github.racoondog.boson;

import com.mojang.logging.LogUtils;
import io.github.racoondog.boson.blocks.ModBlocks;
import io.github.racoondog.boson.config.ModConfig;
import io.github.racoondog.boson.datagen.DataGen;
import io.github.racoondog.boson.datagen.DataTags;
import io.github.racoondog.boson.entities.ModEntities;
import io.github.racoondog.boson.items.ModItems;
import io.github.racoondog.boson.mixin.BrewingRecipeRegistryInvoker;
import io.github.racoondog.boson.util.Util;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;

public class Boson implements ModInitializer {
    public static final String MODID = "boson";
    public static final RuntimeResourcePack RRP = RuntimeResourcePack.create(MODID);
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final ModConfig CONFIG;

    static {
        AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
    }

    @Override
    public void onInitialize() {
        Util.logModConfigs(CONFIG);
        Util.log("Registering Items");
        ModItems.init();
        Util.log("Registering Blocks");
        ModBlocks.init();
        Util.log("Registering Entites");
        ModEntities.init();

        Util.log("Registering Potion Recipes");
        if (CONFIG.brewableLuck) {
            if (FabricLoader.getInstance().isModLoaded("felix-felicis")) {
                BrewingRecipeRegistryInvoker.invokeRegisterPotionRecipe(Potions.AWKWARD, Registry.ITEM.get(new Identifier("felix-felicis", "bat_wings")), Potions.LUCK);
            } else {
                BrewingRecipeRegistryInvoker.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.BAT_WING, Potions.LUCK);
            }
        }

        Util.log("Registering Loot Tables");
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, table, setter) -> {
            if (CONFIG.brewableLuck) {
                if (id.equals(new Identifier("minecraft", "bat"))) {
                    table.pool(FabricLootPoolBuilder.builder().rolls(ConstantLootNumberProvider.create(1)).with(ItemEntry.builder(ModItems.BAT_WING)).withCondition(RandomChanceLootCondition.builder(0.33f).build()));
                }
            }
        });

        Util.log("Registering Data Generators");
        DataGen.pregen();
        DataTags.initDataTags();
        RRPCallback.BEFORE_VANILLA.register(a -> a.add(RRP));
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            RRP.dump();
        }
    }
}
