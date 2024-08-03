package net.guizhanss.crystamaehistoria.utils.compatibility;
import io.github.thebusybiscuit.slimefun4.api.MinecraftVersion;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import java.lang.reflect.Field;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.bukkit.Particle;

// https://hub.spigotmc.org/stash/projects/SPIGOT/repos/craftbukkit/browse/src/main/java/org/bukkit/craftbukkit/legacy/FieldRename.java?until=2a6207fe150b6165722fce94c83cc1f206620ab5&untilPath=src%2Fmain%2Fjava%2Forg%2Fbukkit%2Fcraftbukkit%2Flegacy%2FFieldRename.java#281-318
// covers the missing fields
public class VersionedParticleX {

    public static final Particle POOF;
    public static final Particle SPLASH;
    public static final Particle EFFECT;
    public static final Particle ANGRY_VILLAGER;
    public static final Particle ITEM_SNOWBALL;
    public static final Particle ITEM_SLIME;

    static {
        MinecraftVersion version = Slimefun.getMinecraftVersion();

        // EXPLOSION_NORMAL is renamed to POOF in 1.20.5
        POOF = version.isAtLeast(MinecraftVersion.MINECRAFT_1_20_5) ? Particle.POOF : getKey("EXPLOSION_NORMAL");

        // WATER_SPLASH is renamed to SPLASH in 1.20.5
        SPLASH = version.isAtLeast(MinecraftVersion.MINECRAFT_1_20_5) ? Particle.SPLASH : getKey("WATER_SPLASH");

        // SPELL is renamed to EFFECT in 1.20.5
        EFFECT = version.isAtLeast(MinecraftVersion.MINECRAFT_1_20_5) ? Particle.EFFECT : getKey("SPELL");

        // VIILAGER_ANGRY is renamed to ANGRY_VILLAGER in 1.20.5
        ANGRY_VILLAGER = version.isAtLeast(MinecraftVersion.MINECRAFT_1_20_5) ? Particle.ANGRY_VILLAGER : getKey("VILLAGER_ANGRY");

        // SNOW_SHOVEL is renamed to ITEM_SNOWBALL in 1.20.5
        ITEM_SNOWBALL = version.isAtLeast(MinecraftVersion.MINECRAFT_1_20_5) ? Particle.ITEM_SNOWBALL : getKey("SNOW_SHOVEL");

        // SLIME is renamed to ITEM_SLIME in 1.20.5
        ITEM_SLIME = version.isAtLeast(MinecraftVersion.MINECRAFT_1_20_5) ? Particle.ITEM_SLIME : getKey("SLIME");
    }

    @Nullable private static Particle getKey(@Nonnull String key) {
        try {
            Field field = Particle.class.getDeclaredField(key);
            return (Particle) field.get(null);
        } catch (Exception e) {
            return null;
        }
    }
}
