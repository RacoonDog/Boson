package io.github.racoondog.boson;

import com.mojang.logging.LogUtils;
import io.github.racoondog.boson.blocks.ModBlocks;
import io.github.racoondog.boson.config.ModConfig;
import io.github.racoondog.boson.datagen.DataGen;
import io.github.racoondog.boson.datagen.DataTags;
import io.github.racoondog.boson.entities.ModEntities;
import io.github.racoondog.boson.entities.SpawnEggEntity;
import io.github.racoondog.boson.items.ModItems;
import io.github.racoondog.boson.mixin.BrewingRecipeRegistryInvoker;
import io.github.racoondog.boson.util.Util;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.event.GameEvent;
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
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, table, setter) -> {
            if (CONFIG.brewableLuck) {
                if (id.equals(new Identifier("minecraft", "bat"))) {
                    table.pool(new LootPool.Builder().rolls(ConstantLootNumberProvider.create(1)).with(ItemEntry.builder(ModItems.BAT_WING)).conditionally(RandomChanceLootCondition.builder(0.33f).build()));
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

        Util.log("Registering Dispensor Behaviours");
        if (CONFIG.vanillaTweaks.throwableSpawnEggs) {
            ItemDispenserBehavior itemDispenserBehavior = new ItemDispenserBehavior() {
                public ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                    Direction direction = pointer.getBlockState().get(DispenserBlock.FACING);

                    try {
                        Position pos = DispenserBlock.getOutputLocation(pointer);
                        SpawnEggEntity spawnEggEntity = new SpawnEggEntity(pointer.getWorld(), pos.getX(), pos.getY(), pos.getZ());
                        spawnEggEntity.setItem(stack);
                        spawnEggEntity.setVelocity(direction.getOffsetX(), (float)direction.getOffsetY() + 0.1F, direction.getOffsetZ(), 1.1f, 6.0f);
                        pointer.getWorld().spawnEntity(spawnEggEntity);
                    } catch (Exception var6) {
                        LOGGER.error("Error while dispensing spawn egg from dispenser at {}", pointer.getPos(), var6);
                        return ItemStack.EMPTY;
                    }

                    stack.decrement(1);
                    pointer.getWorld().emitGameEvent(null, GameEvent.ENTITY_PLACE, pointer.getPos());
                    return stack;
                }
            };

            for (SpawnEggItem spawnEggItem : SpawnEggItem.getAll()) {
                DispenserBlock.registerBehavior(spawnEggItem, itemDispenserBehavior);
            }
        }
    }
}
