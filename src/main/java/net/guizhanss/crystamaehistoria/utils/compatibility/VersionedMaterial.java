package net.guizhanss.crystamaehistoria.utils.compatibility;


import io.github.thebusybiscuit.slimefun4.api.MinecraftVersion;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.paperlib.PaperLib;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.Field;

public class VersionedMaterial {
    public static final Material SHORT_GRASS;

    static {
        // GRASS is renamed to SHORT_GRASS in 1.20.3
        SHORT_GRASS = isAtLeast(20, 3) ? Material.SHORT_GRASS : getKey("GRASS");
    }

    private static boolean isAtLeast(int major, int minor) {
        return PaperLib.getMinecraftVersion() > major || (PaperLib.getMinecraftVersion() == major && PaperLib.getMinecraftPatchVersion() >= minor);
    }

    @Nullable
    private static Material getKey(@Nonnull String key) {
        try {
            Field field = Material.class.getDeclaredField(key);
            return (Material) field.get(null);
        } catch (Exception e) {
            return null;
        }
    }
}
