package io.github.racoondog.boson.datagen;

import io.github.racoondog.boson.util.Util;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.loot.JLootTable;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.recipe.JIngredient;
import net.devtech.arrp.json.recipe.JIngredients;
import net.devtech.arrp.json.recipe.JRecipe;
import net.devtech.arrp.json.recipe.JResult;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;

import java.nio.charset.StandardCharsets;

import static io.github.racoondog.boson.Boson.CONFIG;
import static io.github.racoondog.boson.Boson.RRP;

public class DataGen {
    public static void pregen() {
        if (CONFIG.strangeBlocks) {
            item("strange_powder", "active_strange_powder");
            RRP.addRecipe(Util.id("active_strange_powder"), JRecipe.shapeless(addAll(JIngredients.ingredients(), recipeItem("minecraft:redstone"), recipeItem("minecraft:gold_nugget"), recipeItem("boson:strange_powder"), recipeItem("boson:strange_powder")), JResult.stackedResult("boson:active_strange_powder", 3)));
            RRP.addRecipe(Util.id("strange_powder"), JRecipe.shapeless(addAll(JIngredients.ingredients(), recipeItem("minecraft:sugar"), recipeItem("minecraft:glowstone_dust")), JResult.stackedResult("boson:strange_powder", 2)));

            if (CONFIG.strangeBlocksSpecific.wool) {
                block("strange_wool", "active_strange_wool");
                resource(ResourceType.SERVER_DATA, "recipes/active_strange_wool.json", "{\"type\":\"minecraft:crafting_shapeless\",\"ingredients\":[{\"item\":\"boson:active_strange_powder\"},{\"tag\":\"minecraft:wool\"},{\"tag\":\"minecraft:wool\"},{\"tag\":\"minecraft:wool\"},{\"tag\":\"minecraft:wool\"},{\"tag\":\"minecraft:wool\"},{\"tag\":\"minecraft:wool\"},{\"tag\":\"minecraft:wool\"},{\"tag\":\"minecraft:wool\"}],\"result\":{\"item\":\"boson:active_strange_wool\",\"count\":8}}");
                resource(ResourceType.SERVER_DATA, "recipes/strange_wool.json", "{\"type\":\"minecraft:crafting_shapeless\",\"ingredients\":[{\"item\":\"boson:strange_powder\"},{\"tag\":\"minecraft:wool\"},{\"tag\":\"minecraft:wool\"},{\"tag\":\"minecraft:wool\"},{\"tag\":\"minecraft:wool\"},{\"tag\":\"minecraft:wool\"},{\"tag\":\"minecraft:wool\"},{\"tag\":\"minecraft:wool\"},{\"tag\":\"minecraft:wool\"}],\"result\":{\"item\":\"boson:strange_wool\",\"count\":8}}");

                DataTags.add(DataTags.MINEABLE$SHEARS, "strange_wool", "active_strange_wool");
                DataTags.add(DataTags.MINECRAFT$OCCLUDES_VIBRATION_SIGNALS, "strange_wool", "active_strange_wool");
                DataTags.add(DataTags.MINECRAFT$WOOL, "strange_wool", "active_strange_wool");

                RRP.addRecipe(Util.id("strange_wool"), JRecipe.shapeless(addTime(JIngredients.ingredients(), recipeTag("c:wools"), 4).add(recipeItem("boson:strange_powder")), JResult.stackedResult("boson:strange_wool", 4)));
                RRP.addRecipe(Util.id("active_strange_wool"), JRecipe.shapeless(addTime(JIngredients.ingredients(), recipeTag("c:wools"), 4).add(recipeItem("boson:active_strange_powder")), JResult.stackedResult("boson:active_strange_wool", 4)));
            }
            if (CONFIG.strangeBlocksSpecific.carpet) {
                blockState("strange_carpet");
                blockItemModel("strange_carpet");
                lootTable("strange_carpet");
                blockState("active_strange_carpet");
                blockItemModel("active_strange_carpet");
                lootTable("active_strange_carpet");

                DataTags.add(DataTags.MINECRAFT$CARPETS, "strange_carpet", "active_strange_carpet");

                RRP.addRecipe(Util.id("strange_carpet"), JRecipe.shapeless(addTime(JIngredients.ingredients(), recipeTag("c:carpets"), 4).add(recipeItem("boson:strange_powder")), JResult.stackedResult("boson:strange_carpet", 4)));
                RRP.addRecipe(Util.id("active_strange_carpet"), JRecipe.shapeless(addTime(JIngredients.ingredients(), recipeTag("c:carpets"), 4).add(recipeItem("boson:active_strange_powder")), JResult.stackedResult("boson:active_strange_carpet", 4)));
            }
            if (CONFIG.strangeBlocksSpecific.candle) {
                itemModel("strange_candle");
                itemModel("active_strange_candle");
                resource(ResourceType.SERVER_DATA, "loot_tables/blocks/active_strange_candle.json", "{\"type\":\"minecraft:block\",\"pools\":[{\"rolls\":1,\"bonus_rolls\":0,\"entries\":[{\"type\":\"minecraft:item\",\"functions\":[{\"function\":\"minecraft:set_count\",\"conditions\":[{\"condition\":\"minecraft:block_state_property\",\"block\":\"boson:active_strange_candle\",\"properties\":{\"candles\":\"2\"}}],\"count\":2,\"add\":false},{\"function\":\"minecraft:set_count\",\"conditions\":[{\"condition\":\"minecraft:block_state_property\",\"block\":\"boson:active_strange_candle\",\"properties\":{\"candles\":\"3\"}}],\"count\":3,\"add\":false},{\"function\":\"minecraft:set_count\",\"conditions\":[{\"condition\":\"minecraft:block_state_property\",\"block\":\"boson:active_strange_candle\",\"properties\":{\"candles\":\"4\"}}],\"count\":4,\"add\":false},{\"function\":\"minecraft:explosion_decay\"}],\"name\":\"boson:active_strange_candle\"}]}]}");
                resource(ResourceType.SERVER_DATA, "loot_tables/blocks/strange_candle.json", "{\"type\":\"minecraft:block\",\"pools\":[{\"rolls\":1,\"bonus_rolls\":0,\"entries\":[{\"type\":\"minecraft:item\",\"functions\":[{\"function\":\"minecraft:set_count\",\"conditions\":[{\"condition\":\"minecraft:block_state_property\",\"block\":\"boson:strange_candle\",\"properties\":{\"candles\":\"2\"}}],\"count\":2,\"add\":false},{\"function\":\"minecraft:set_count\",\"conditions\":[{\"condition\":\"minecraft:block_state_property\",\"block\":\"boson:strange_candle\",\"properties\":{\"candles\":\"3\"}}],\"count\":3,\"add\":false},{\"function\":\"minecraft:set_count\",\"conditions\":[{\"condition\":\"minecraft:block_state_property\",\"block\":\"boson:strange_candle\",\"properties\":{\"candles\":\"4\"}}],\"count\":4,\"add\":false},{\"function\":\"minecraft:explosion_decay\"}],\"name\":\"boson:strange_candle\"}]}]}");

                DataTags.add(DataTags.MINECRAFT$CANDLES, "strange_candle", "active_strange_candle");

                RRP.addRecipe(Util.id("strange_candle"), JRecipe.shapeless(addTime(JIngredients.ingredients(), recipeTag("c:candles"), 4).add(recipeItem("boson:strange_powder")), JResult.stackedResult("boson:strange_candle", 4)));
                RRP.addRecipe(Util.id("active_strange_candle"), JRecipe.shapeless(addTime(JIngredients.ingredients(), recipeTag("c:candles"), 4).add(recipeItem("boson:active_strange_powder")), JResult.stackedResult("boson:active_strange_candle", 4)));
            }
            if (CONFIG.strangeBlocksSpecific.terracotta) {
                block("strange_terracotta", "active_strange_terracotta");

                DataTags.add(DataTags.MINEABLE$PICKAXE, "strange_terracotta", "active_strange_terracotta");
                DataTags.add(DataTags.MINECRAFT$AZALEA_GROWS_ON, "strange_terracotta", "active_strange_terracotta");
                DataTags.add(DataTags.MINECRAFT$TERRACOTTA, "strange_terracotta", "active_strange_terracotta");

                RRP.addRecipe(Util.id("strange_terracotta"), JRecipe.shapeless(addTime(JIngredients.ingredients(), recipeTag("c:terracottas"), 4).add(recipeItem("boson:strange_powder")), JResult.stackedResult("boson:strange_terracotta", 4)));
                RRP.addRecipe(Util.id("active_strange_terracotta"), JRecipe.shapeless(addTime(JIngredients.ingredients(), recipeTag("c:terracottas"), 4).add(recipeItem("boson:active_strange_powder")), JResult.stackedResult("boson:active_strange_terracotta", 4)));
            }
            if (CONFIG.strangeBlocksSpecific.glazed_terracotta) {
                blockItemModel("strange_glazed_terracotta");
                blockModel("strange_glazed_terracotta");
                lootTable("strange_glazed_terracotta");
                blockItemModel("active_strange_glazed_terracotta");
                blockModel("active_strange_glazed_terracotta");
                lootTable("active_strange_glazed_terracotta");

                DataTags.add(DataTags.MINEABLE$PICKAXE, "strange_glazed_terracotta", "active_strange_glazed_terracotta");

                RRP.addRecipe(Util.id("strange_glazed_terracotta"), JRecipe.shapeless(addTime(JIngredients.ingredients(), recipeTag("c:glazed_terracottas"), 4).add(recipeItem("boson:strange_powder")), JResult.stackedResult("boson:strange_terracotta", 4)));
                RRP.addRecipe(Util.id("active_strange_glazed_terracotta"), JRecipe.shapeless(addTime(JIngredients.ingredients(), recipeTag("c:glazed_terracottas"), 4).add(recipeItem("boson:active_strange_powder")), JResult.stackedResult("boson:active_strange_terracotta", 4)));
            }
            if (CONFIG.strangeBlocksSpecific.concrete) {
                block("strange_concrete", "active_strange_concrete");

                DataTags.add(DataTags.MINEABLE$PICKAXE, "strange_concrete", "active_strange_concrete");

                RRP.addRecipe(Util.id("strange_concrete"), JRecipe.shapeless(addTime(JIngredients.ingredients(), recipeTag("c:concretes"), 4).add(recipeItem("boson:strange_powder")), JResult.stackedResult("boson:strange_concrete", 4)));
                RRP.addRecipe(Util.id("active_strange_concrete"), JRecipe.shapeless(addTime(JIngredients.ingredients(), recipeTag("c:concretes"), 4).add(recipeItem("boson:active_strange_powder")), JResult.stackedResult("boson:active_strange_concrete", 4)));
            }
            if (CONFIG.strangeBlocksSpecific.concrete_powder) {
                block("strange_concrete_powder", "active_strange_concrete_powder");

                DataTags.add(DataTags.MINEABLE$SHOVEL, "strange_concrete_powder", "active_strange_concrete_powder");

                RRP.addRecipe(Util.id("strange_concrete_powder"), JRecipe.shapeless(addTime(JIngredients.ingredients(), recipeTag("c:concrete_powders"), 4).add(recipeItem("boson:strange_powder")), JResult.stackedResult("boson:strange_concrete_powder", 4)));
                RRP.addRecipe(Util.id("active_strange_concrete_powder"), JRecipe.shapeless(addTime(JIngredients.ingredients(), recipeTag("c:concrete_powders"), 4).add(recipeItem("boson:active_strange_powder")), JResult.stackedResult("boson:active_strange_concrete_powder", 4)));
            }
        }

        if (CONFIG.brewableLuck && !FabricLoader.getInstance().isModLoaded("felix-felicis")) {
            item("bat_wing");
            resource(ResourceType.SERVER_DATA, new Identifier("minecraft", "loot_tables/entities/bat.json"), "{\"type\":\"minecraft:entity\",\"pools\":[{\"rolls\":1,\"bonus_rolls\":0,\"entries\":[{\"type\":\"minecraft:item\",\"functions\":[{\"function\":\"minecraft:set_count\",\"count\":{\"type\":\"minecraft:uniform\",\"min\":-1,\"max\":1},\"add\":false},{\"function\":\"minecraft:looting_enchant\",\"count\":{\"type\":\"minecraft:uniform\",\"min\":0,\"max\":1}}],\"name\":\"boson:bat_wing\"}],\"conditions\":[{\"condition\":\"minecraft:killed_by_player\"}]}]}");
        }

        if (CONFIG.vanillaTweaks.moreGoatBlocks) DataTags.add(DataTags.MINECRAFT$GOATS_SPAWNABLE_ON, new Identifier("minecraft", "infested_stone"), new Identifier("minecraft", "granite"), new Identifier("minecraft", "diorite"), new Identifier("minecraft", "andesite"));

        if (CONFIG.fun.blit) {
            blockItemModel("blit");
            blockState("blit");
            lootTable("blit");
            DataTags.add(DataTags.MINEABLE$PICKAXE, "blit");
            final String[] strings = CONFIG.fun.blitTexture.split(":");
            final String texture = strings[0] + ":block/" + strings[1];
            resource(ResourceType.CLIENT_RESOURCES, new Identifier("boson", "models/block/blit.json"), "{\"parent\":\"block/block\",\"textures\":{\"texture\":\"%s\",\"particle\":\"%s\"},\"elements\":[{\"from\":[7,7,7],\"to\":[9,9,9],\"faces\":{\"north\":{\"uv\":[7,7,9,9],\"texture\":\"#texture\"},\"east\":{\"uv\":[7,7,9,9],\"texture\":\"#texture\"},\"south\":{\"uv\":[7,7,9,9],\"texture\":\"#texture\"},\"west\":{\"uv\":[7,7,9,9],\"texture\":\"#texture\"},\"up\":{\"uv\":[7,7,9,9],\"texture\":\"#texture\"},\"down\":{\"uv\":[7,7,9,9],\"texture\":\"#texture\"}}}]}".formatted(texture, texture));
            RRP.addRecipe(Util.id("blit"), JRecipe.shapeless(JIngredients.ingredients().add(recipeItem("minecraft:stone_button")), JResult.stackedResult("boson:blit", 9)));
        }
    }

    public static void blockState(String path) {
        final Identifier identifier = Util.id(path);
        RRP.addBlockState(JState.state(JState.variant(JState.model(Util.prefixPath(identifier, "block").toString()))), identifier);
    }
    public static void blockItemModel(String path) {
        final Identifier identifier = Util.id(path);
        RRP.addModel(JModel.model(Util.prefixPath(identifier, "block").toString()), Util.prefixPath(identifier, "item"));
    }
    public static void lootTable(String path) {
        final Identifier identifier = Util.id(path);
        RRP.addLootTable(Util.prefixPath(identifier, "blocks"), JLootTable.loot("minecraft:block").pool(JLootTable.pool().rolls(1).bonus(0).entry(JLootTable.entry().type("minecraft:item").name(identifier.toString())).condition(JLootTable.predicate("minecraft:survives_explosion"))));
    }
    public static void blockModel(String path) {
        final Identifier prefix = Util.prefixPath(Util.id(path), "block");
        RRP.addModel(JModel.model("block/cube_all").textures(JModel.textures().var("all", prefix.toString())), prefix);
    }
    public static void itemModel(String path) {
        final Identifier prefix = Util.prefixPath(Util.id(path), "item");
        RRP.addModel(JModel.model("item/generated").textures(JModel.textures().layer0(prefix.toString())), prefix);
    }

    public static void block(String... paths) {
        for (var path : paths) {
            blockModel(path);
            blockState(path);
            lootTable(path);
            blockItemModel(path);
        }
    }

    public static void item(String... paths) {
        for (var path : paths) {
            itemModel(path);
        }
    }

    public static void resource(ResourceType type, String name, String data) {
        final Identifier id = Util.id(name);
        RRP.addResource(type, id, data.getBytes(StandardCharsets.UTF_8));
    }
    public static void resource(ResourceType type, Identifier id, String data) {
        RRP.addResource(type, id, data.getBytes(StandardCharsets.UTF_8));
    }

    public static JIngredient recipeItem(String item) {
        return JIngredient.ingredient().item(item);
    }

    public static JIngredient recipeTag(String tag) {
        return JIngredient.ingredient().tag(tag);
    }

    public static JIngredients addAll(JIngredients jIngredients, JIngredient... jIngredientsArray) {
        for (var jIngredient : jIngredientsArray) {
            jIngredients.add(jIngredient);
        }
        return jIngredients;
    }

    public static JIngredients addTime(JIngredients jIngredients, JIngredient jIngredient, int count) {
        for (int i = 0; i < count; i++) {
            jIngredients.add(jIngredient);
        }
        return jIngredients;
    }
}
