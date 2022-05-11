package io.github.racoondog.boson.util;

import io.github.racoondog.boson.Boson;
import io.github.racoondog.boson.config.ModConfig;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.NotNull;

import static io.github.racoondog.boson.Boson.CONFIG;
import static io.github.racoondog.boson.Boson.LOGGER;

public final class Util {
    public static @NotNull Identifier id(String path) {
        return new Identifier(Boson.MODID, path);
    }

    public static Identifier prefixPath(Identifier identifier, String prefix) {
        return new Identifier(identifier.getNamespace(), prefix + '/' + identifier.getPath());
    }

    public static void log(String string) {
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            LOGGER.info(string);
        }
    }

    public static boolean contains(String base, String... inputs) {
        for (var string : inputs) {
            if (base.contains(string)) return true;
        }
        return false;
    }

    public static void logModConfigs(ModConfig config) {
        StringBuilder sb = new StringBuilder("Config Dump : ");

        sb.append("modVersion=%s ; ".formatted(FabricLoader.getInstance().getModContainer(Boson.MODID).get().getMetadata().getVersion().getFriendlyString()));

        try {
            for (var field : config.getClass().getDeclaredFields()) {
                if (field.getName().equals("strangeBlocksSpecific") || field.getName().equals("vanillaTweaks") || field.getName().equals("fun")) continue;
                sb.append("%s=%s ; ".formatted(field.getName(), field.get(config)));
            }
            for (var field : config.strangeBlocksSpecific.getClass().getDeclaredFields()) sb.append("%s=%s ; ".formatted(field.getName(), field.get(config.strangeBlocksSpecific)));
            for (var field : config.vanillaTweaks.getClass().getDeclaredFields()) sb.append("%s=%s ; ".formatted(field.getName(), field.get(config.vanillaTweaks)));
            for (var field : config.fun.getClass().getDeclaredFields()) sb.append("%s=%s ; ".formatted(field.getName(), field.get(config.fun)));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        LOGGER.info(sb.toString());
    }

    public static IncompatibleConfigsException throwException(String... configs) {
        StringBuilder sb = new StringBuilder("Incompatible configs:");
        for (int i = 0; i < configs.length; i++) {
            if (i == 0) {
                sb.append(" ");
            } else {
                sb.append(", ");
            }
            sb.append(configs[i]);
        }
        return new IncompatibleConfigsException(sb.toString());
    }

    public static class IncompatibleConfigsException extends RuntimeException {
        public IncompatibleConfigsException(String message) {
            super(message);
        }
    }
}
