package io.github.racoondog.boson.util;

import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.FoodComponent;

import java.util.List;

public final class Constants {
    public static final List<Block> WOOLS = Lists.newArrayList(Blocks.WHITE_WOOL, Blocks.BLUE_WOOL, Blocks.BLACK_WOOL, Blocks.BROWN_WOOL, Blocks.CYAN_WOOL, Blocks.GRAY_WOOL, Blocks.GREEN_WOOL, Blocks.LIGHT_BLUE_WOOL, Blocks.LIGHT_GRAY_WOOL, Blocks.LIME_WOOL, Blocks.MAGENTA_WOOL, Blocks.ORANGE_WOOL, Blocks.PINK_WOOL, Blocks.PURPLE_WOOL, Blocks.RED_WOOL, Blocks.YELLOW_WOOL);
    public static final List<Block> CARPETS = Lists.newArrayList(Blocks.WHITE_CARPET, Blocks.BLUE_CARPET, Blocks.BLACK_CARPET, Blocks.BROWN_CARPET, Blocks.CYAN_CARPET, Blocks.GRAY_CARPET, Blocks.GREEN_CARPET, Blocks.LIGHT_BLUE_CARPET, Blocks.LIGHT_GRAY_CARPET, Blocks.LIME_CARPET, Blocks.MAGENTA_CARPET, Blocks.ORANGE_CARPET, Blocks.PINK_CARPET, Blocks.RED_CARPET, Blocks.YELLOW_CARPET);
    public static final List<Block> CANDLES = Lists.newArrayList(Blocks.WHITE_CANDLE, Blocks.BLUE_CANDLE, Blocks.BLACK_CANDLE, Blocks.BROWN_CANDLE, Blocks.CYAN_CANDLE, Blocks.GRAY_CANDLE, Blocks.GREEN_CANDLE, Blocks.LIGHT_BLUE_CANDLE, Blocks.LIGHT_GRAY_CANDLE, Blocks.LIME_CANDLE, Blocks.MAGENTA_CANDLE, Blocks.ORANGE_CANDLE, Blocks.PINK_CANDLE, Blocks.RED_CANDLE, Blocks.YELLOW_CANDLE);
    public static final List<Block> TERRACOTTAS = Lists.newArrayList(Blocks.WHITE_TERRACOTTA, Blocks.BLUE_TERRACOTTA, Blocks.BLACK_TERRACOTTA, Blocks.BROWN_TERRACOTTA, Blocks.CYAN_TERRACOTTA, Blocks.GRAY_TERRACOTTA, Blocks.GREEN_TERRACOTTA, Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.LIME_TERRACOTTA, Blocks.MAGENTA_TERRACOTTA, Blocks.ORANGE_TERRACOTTA, Blocks.PINK_TERRACOTTA, Blocks.RED_TERRACOTTA, Blocks.YELLOW_TERRACOTTA);
    public static final List<Block> GLAZED_TERRACOTTAS = Lists.newArrayList(Blocks.WHITE_GLAZED_TERRACOTTA, Blocks.BLUE_GLAZED_TERRACOTTA, Blocks.BLACK_GLAZED_TERRACOTTA, Blocks.BROWN_GLAZED_TERRACOTTA, Blocks.CYAN_GLAZED_TERRACOTTA, Blocks.GRAY_GLAZED_TERRACOTTA, Blocks.GREEN_GLAZED_TERRACOTTA, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, Blocks.LIME_GLAZED_TERRACOTTA, Blocks.MAGENTA_GLAZED_TERRACOTTA, Blocks.ORANGE_GLAZED_TERRACOTTA, Blocks.PINK_GLAZED_TERRACOTTA, Blocks.RED_GLAZED_TERRACOTTA, Blocks.YELLOW_GLAZED_TERRACOTTA);
    public static final List<Block> CONCRETES = Lists.newArrayList(Blocks.WHITE_CONCRETE, Blocks.BLUE_CONCRETE, Blocks.BLACK_CONCRETE, Blocks.BROWN_CONCRETE, Blocks.CYAN_CONCRETE, Blocks.GRAY_CONCRETE, Blocks.GREEN_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE, Blocks.LIME_CONCRETE, Blocks.MAGENTA_CONCRETE, Blocks.ORANGE_CONCRETE, Blocks.PINK_CONCRETE, Blocks.RED_CONCRETE, Blocks.YELLOW_CONCRETE);
    public static final List<Block> CONCRETE_POWDERS = Lists.newArrayList(Blocks.WHITE_CONCRETE_POWDER, Blocks.BLUE_CONCRETE_POWDER, Blocks.BLACK_CONCRETE_POWDER, Blocks.BROWN_CONCRETE_POWDER, Blocks.CYAN_CONCRETE_POWDER, Blocks.GRAY_CONCRETE_POWDER, Blocks.GREEN_CONCRETE_POWDER, Blocks.LIGHT_BLUE_CONCRETE_POWDER, Blocks.LIGHT_GRAY_CONCRETE_POWDER, Blocks.LIME_CONCRETE_POWDER, Blocks.MAGENTA_CONCRETE_POWDER, Blocks.ORANGE_CONCRETE_POWDER, Blocks.PINK_CONCRETE_POWDER, Blocks.RED_CONCRETE_POWDER, Blocks.YELLOW_CONCRETE_POWDER);
    public static final List<Block> STAINED_GLASSES = Lists.newArrayList(Blocks.WHITE_STAINED_GLASS, Blocks.BLUE_STAINED_GLASS, Blocks.BLACK_STAINED_GLASS, Blocks.BROWN_STAINED_GLASS, Blocks.CYAN_STAINED_GLASS, Blocks.GRAY_STAINED_GLASS, Blocks.GREEN_STAINED_GLASS, Blocks.LIGHT_BLUE_STAINED_GLASS, Blocks.LIGHT_GRAY_STAINED_GLASS, Blocks.LIME_STAINED_GLASS, Blocks.MAGENTA_STAINED_GLASS, Blocks.ORANGE_STAINED_GLASS, Blocks.PINK_STAINED_GLASS, Blocks.RED_STAINED_GLASS, Blocks.YELLOW_STAINED_GLASS);
    public static final List<Block> STAINED_GLASS_PANES = Lists.newArrayList(Blocks.WHITE_STAINED_GLASS_PANE, Blocks.BLUE_STAINED_GLASS_PANE, Blocks.BLACK_STAINED_GLASS_PANE, Blocks.BROWN_STAINED_GLASS_PANE, Blocks.CYAN_STAINED_GLASS_PANE, Blocks.GRAY_STAINED_GLASS_PANE, Blocks.GREEN_STAINED_GLASS_PANE, Blocks.LIGHT_BLUE_STAINED_GLASS_PANE, Blocks.LIGHT_GRAY_STAINED_GLASS_PANE, Blocks.LIME_STAINED_GLASS_PANE, Blocks.MAGENTA_STAINED_GLASS_PANE, Blocks.ORANGE_STAINED_GLASS_PANE, Blocks.PINK_STAINED_GLASS_PANE, Blocks.RED_STAINED_GLASS_PANE, Blocks.YELLOW_STAINED_GLASS_PANE);

    public static final FoodComponent SPAWN_EGG_FOOD_COMPONENT = new FoodComponent.Builder().hunger(2).saturationModifier(1.0f).snack().build();
}
