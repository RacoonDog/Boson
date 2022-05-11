package io.github.racoondog.boson.datagen;

import io.github.racoondog.boson.Boson;
import net.devtech.arrp.json.tags.JTag;
import net.minecraft.util.Identifier;

import static io.github.racoondog.boson.Boson.RRP;

public class DataTags {
    public static final JTag MINECRAFT$AZALEA_GROWS_ON = JTag.tag();
    public static final JTag MINECRAFT$CANDLES = JTag.tag();
    public static final JTag MINECRAFT$CARPETS = JTag.tag();
    public static final JTag MINECRAFT$OCCLUDES_VIBRATION_SIGNALS = JTag.tag();
    public static final JTag MINECRAFT$TERRACOTTA = JTag.tag();
    public static final JTag MINECRAFT$GOATS_SPAWNABLE_ON = JTag.tag();
    public static final JTag MINECRAFT$WOOL = JTag.tag();

    public static final JTag MINEABLE$PICKAXE = JTag.tag();
    public static final JTag MINEABLE$SHOVEL = JTag.tag();
    public static final JTag MINEABLE$SHEARS = JTag.tag();
    public static final JTag MINEABLE$AXE = JTag.tag();

    public static void initDataTags() {
        RRP.addTag(new Identifier("minecraft", "blocks/azalea_grows_on"), MINECRAFT$AZALEA_GROWS_ON);
        RRP.addTag(new Identifier("minecraft", "blocks/candles"), MINECRAFT$CANDLES);
        RRP.addTag(new Identifier("minecraft", "items/candles"), MINECRAFT$CANDLES);
        RRP.addTag(new Identifier("minecraft", "blocks/carpets"), MINECRAFT$CARPETS);
        RRP.addTag(new Identifier("minecraft", "items/carpets"), MINECRAFT$CARPETS);
        RRP.addTag(new Identifier("minecraft", "blocks/occludes_vibration_signals"), MINECRAFT$OCCLUDES_VIBRATION_SIGNALS);
        RRP.addTag(new Identifier("minecraft", "blocks/terracotta"), MINECRAFT$TERRACOTTA);
        RRP.addTag(new Identifier("minecraft", "items/terracotta"), MINECRAFT$TERRACOTTA);
        RRP.addTag(new Identifier("minecraft", "blocks/goats_spawnable_on"), MINECRAFT$GOATS_SPAWNABLE_ON);
        RRP.addTag(new Identifier("minecraft", "blocks/wool"), MINECRAFT$WOOL);
        RRP.addTag(new Identifier("minecraft", "items/wool"), MINECRAFT$WOOL);

        RRP.addTag(new Identifier("minecraft", "blocks/mineable/pickaxe"), MINEABLE$PICKAXE);
        RRP.addTag(new Identifier("minecraft", "blocks/mineable/shovel"), MINEABLE$SHOVEL);
        RRP.addTag(new Identifier("minecraft", "blocks/mineable/axe"), MINEABLE$AXE);
        RRP.addTag(new Identifier("fabric", "blocks/mineable/shears"), MINEABLE$SHEARS);
    }

    public static void add(JTag tag, String... paths) {
        for (var path : paths) {
            final Identifier id = new Identifier(Boson.MODID, path);
            tag.add(id);
        }
    }
    public static void add(JTag tag, Identifier... ids) {
        for (var id : ids) {
            tag.add(id);
        }
    }
}
