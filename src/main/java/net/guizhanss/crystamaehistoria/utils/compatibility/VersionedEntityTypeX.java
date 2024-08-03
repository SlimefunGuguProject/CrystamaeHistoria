package net.guizhanss.crystamaehistoria.utils.compatibility;

import io.github.thebusybiscuit.slimefun4.api.MinecraftVersion;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import org.bukkit.entity.EntityType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.Field;

// // https://hub.spigotmc.org/stash/projects/SPIGOT/repos/craftbukkit/browse/src/main/java/org/bukkit/craftbukkit/legacy/FieldRename.java?until=2a6207fe150b6165722fce94c83cc1f206620ab5&untilPath=src%2Fmain%2Fjava%2Forg%2Fbukkit%2Fcraftbukkit%2Flegacy%2FFieldRename.java#158-193
// covers the missing fields
public class VersionedEntityTypeX {

    public static final EntityType POTION;
    public static final EntityType FIREWORK_ROCKET;

    static {
        MinecraftVersion version = Slimefun.getMinecraftVersion();

        // SPLASH_POTION is renamed to POTION in 1.20.5
        POTION = version.isAtLeast(MinecraftVersion.MINECRAFT_1_20_5) ? EntityType.POTION : getKey("SPLASH_POTION");

        // FIREWORK is renamed to FIREWORK_ROCKET in 1.20.5
        FIREWORK_ROCKET = version.isAtLeast(MinecraftVersion.MINECRAFT_1_20_5) ? EntityType.FIREWORK_ROCKET : getKey("FIREWORK");
    }

    @Nullable
    private static EntityType getKey(@Nonnull String key) {
        try {
            Field field = EntityType.class.getDeclaredField(key);
            return (EntityType) field.get(null);
        } catch (Exception e) {
            return null;
        }
    }
}
