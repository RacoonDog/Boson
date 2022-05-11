package io.github.racoondog.boson.config;

import io.github.racoondog.boson.Boson;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = Boson.MODID)
public class ModConfig implements ConfigData {
    @ConfigEntry.Gui.RequiresRestart
    @ConfigEntry.Gui.Tooltip
    public boolean strangeBlocks = true;
    @ConfigEntry.Gui.CollapsibleObject
    public StrangeBlocks strangeBlocksSpecific = new StrangeBlocks();

    @ConfigEntry.Gui.CollapsibleObject
    public VanillaTweaks vanillaTweaks = new VanillaTweaks();

    @ConfigEntry.Gui.CollapsibleObject
    public Fun fun = new Fun();

    @ConfigEntry.Gui.RequiresRestart
    public boolean brewableLuck = true;

    public static class StrangeBlocks {
        @ConfigEntry.Gui.RequiresRestart
        public boolean wool = true;
        @ConfigEntry.Gui.RequiresRestart
        public boolean carpet = true;
        @ConfigEntry.Gui.RequiresRestart
        public boolean candle = true;
        @ConfigEntry.Gui.RequiresRestart
        public boolean terracotta = true;
        @ConfigEntry.Gui.RequiresRestart
        public boolean glazed_terracotta = true;
        @ConfigEntry.Gui.RequiresRestart
        public boolean concrete = true;
        @ConfigEntry.Gui.RequiresRestart
        public boolean concrete_powder = true;
    }

    public static class VanillaTweaks {
        public boolean animalRunSpeed = true;
        @ConfigEntry.Gui.Tooltip
        public float bedExplosionMultiplier = 1.3f;
        public float netherFireDamageMultiplier = 1.25f;
        @ConfigEntry.Gui.Tooltip
        public boolean moreInstrumentBlocks = true;
        public boolean hoeDamage = true;
        @ConfigEntry.Gui.Tooltip
        public boolean stopZombifiedPiglinSpawning = false;
        public boolean piglinDontAttackNetherite = false;
        @ConfigEntry.Gui.RequiresRestart
        @ConfigEntry.Gui.Tooltip
        public boolean moreGoatBlocks = true;
        @ConfigEntry.Gui.Tooltip
        public boolean hardnessBasedBlockItemDamage = true;
        @ConfigEntry.Gui.RequiresRestart
        @ConfigEntry.Gui.Tooltip
        public boolean throwableSpawnEggs = true;
        @ConfigEntry.Gui.Tooltip
        public boolean smartToolDurability = true;

        @ConfigEntry.Gui.RequiresRestart
        public boolean survivalInventoryTrash = true;
    }

    public static class Fun {
        @ConfigEntry.Gui.RequiresRestart
        @ConfigEntry.Gui.Tooltip
        public boolean blit = true;
        @ConfigEntry.Gui.RequiresRestart
        public String blitTexture = "minecraft:stone";

        public boolean dispenserPlacesBlocks = false;
    }
}
