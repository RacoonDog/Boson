package io.github.racoondog.boson.blocks;

import io.github.racoondog.boson.blocks.strange.*;
import io.github.racoondog.boson.util.Constants;
import io.github.racoondog.boson.util.Util;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

import static io.github.racoondog.boson.Boson.CONFIG;

@SuppressWarnings("unused")
public class ModBlocks {
    public static Block STRANGE_WOOL;
    public static Block ACTIVE_STRANGE_WOOL;
    public static Block STRANGE_CARPET;
    public static Block ACTIVE_STRANGE_CARPET;
    public static Block STRANGE_CANDLE;
    public static Block ACTIVE_STRANGE_CANDLE;
    public static Block STRANGE_TERRACOTTA;
    public static Block ACTIVE_STRANGE_TERRACOTTA;
    public static Block STRANGE_GLAZED_TERRACOTTA;
    public static Block ACTIVE_STRANGE_GLAZED_TERRACOTTA;
    public static Block STRANGE_CONCRETE;
    public static Block ACTIVE_STRANGE_CONCRETE;
    public static Block STRANGE_CONCRETE_POWDER;
    public static Block ACTIVE_STRANGE_CONCRETE_POWDER;

    public static Block BLIT;

    private static <T extends Block> T register(T block, String path, boolean flammable) {
        if (flammable) FlammableBlockRegistry.getDefaultInstance().add(block, 8, 4);
        Registry.register(Registry.ITEM, Util.id(path), new BlockItem(block, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        return Registry.register(Registry.BLOCK, Util.id(path), block);
    }

    public static void init() {
        if (CONFIG.strangeBlocks) {
            if (CONFIG.strangeBlocksSpecific.wool) {
                STRANGE_WOOL = new StrangeBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL), Constants.WOOLS);
                ACTIVE_STRANGE_WOOL = new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL));
                register(STRANGE_WOOL, "strange_wool", true);
                register(ACTIVE_STRANGE_WOOL, "active_strange_wool", true);
            }
            if (CONFIG.strangeBlocksSpecific.carpet) {
                STRANGE_CARPET = new StrangeCarpetBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CARPET), Constants.CARPETS);
                ACTIVE_STRANGE_CARPET = new CarpetBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CARPET));
                register(STRANGE_CARPET, "strange_carpet", true);
                register(ACTIVE_STRANGE_CARPET, "active_strange_carpet", true);
            }
            if (CONFIG.strangeBlocksSpecific.candle) {
                STRANGE_CANDLE = new StrangeCandleBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE), Constants.CANDLES);
                ACTIVE_STRANGE_CANDLE = new CandleBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE));
                register(STRANGE_CANDLE, "strange_candle", false);
                register(ACTIVE_STRANGE_CANDLE, "active_strange_candle", false);
            }
            if (CONFIG.strangeBlocksSpecific.terracotta) {
                STRANGE_TERRACOTTA = new StrangeBlock(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA), Constants.TERRACOTTAS);
                ACTIVE_STRANGE_TERRACOTTA = new Block(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA));
                register(STRANGE_TERRACOTTA, "strange_terracotta", false);
                register(ACTIVE_STRANGE_TERRACOTTA, "active_strange_terracotta", false);
            }
            if (CONFIG.strangeBlocksSpecific.glazed_terracotta) {
                STRANGE_GLAZED_TERRACOTTA = new StrangeGlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.WHITE_GLAZED_TERRACOTTA), Constants.GLAZED_TERRACOTTAS);
                ACTIVE_STRANGE_GLAZED_TERRACOTTA = new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.WHITE_GLAZED_TERRACOTTA));
                register(STRANGE_GLAZED_TERRACOTTA, "strange_glazed_terracotta", false);
                register(ACTIVE_STRANGE_GLAZED_TERRACOTTA, "active_strange_glazed_terracotta", false);
            }
            if (CONFIG.strangeBlocksSpecific.concrete) {
                STRANGE_CONCRETE = new StrangeBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE), Constants.CONCRETES);
                ACTIVE_STRANGE_CONCRETE = new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE));
                register(STRANGE_CONCRETE, "strange_concrete", false);
                register(ACTIVE_STRANGE_CONCRETE, "active_strange_concrete", false);
            }
            if (CONFIG.strangeBlocksSpecific.concrete_powder) {
                STRANGE_CONCRETE_POWDER = new StrangeConcretePowderBlock(CONFIG.strangeBlocksSpecific.concrete ? STRANGE_CONCRETE : Blocks.WHITE_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE_POWDER), Constants.CONCRETE_POWDERS);
                ACTIVE_STRANGE_CONCRETE_POWDER = new ConcretePowderBlock(CONFIG.strangeBlocksSpecific.concrete ? ACTIVE_STRANGE_CONCRETE : Blocks.WHITE_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE_POWDER));
                register(STRANGE_CONCRETE_POWDER, "strange_concrete_powder", false);
                register(ACTIVE_STRANGE_CONCRETE_POWDER, "active_strange_concrete_powder", false);
            }
        }
        if (CONFIG.fun.blit) {
            BLIT = new ShapedBlock(FabricBlockSettings.copyOf(Blocks.STONE).nonOpaque(), Block.createCuboidShape(7, 7, 7, 9, 9, 9));
            register(BLIT, "blit", Util.contains(CONFIG.fun.blitTexture, "oak", "spruce", "birch", "jungle", "acacia", "dark_oak", "log", "plank", "wood", "hyphae", "bark"));
        }
    }
}
