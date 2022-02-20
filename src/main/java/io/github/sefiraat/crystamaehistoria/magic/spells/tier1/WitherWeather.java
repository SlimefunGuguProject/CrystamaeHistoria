package io.github.sefiraat.crystamaehistoria.magic.spells.tier1;

import io.github.sefiraat.crystamaehistoria.magic.CastInformation;
import io.github.sefiraat.crystamaehistoria.magic.spells.core.Spell;
import io.github.sefiraat.crystamaehistoria.magic.spells.core.SpellCoreBuilder;
import io.github.sefiraat.crystamaehistoria.slimefun.mechanisms.liquefactionbasin.RecipeSpell;
import io.github.sefiraat.crystamaehistoria.stories.definition.StoryType;
import io.github.sefiraat.crystamaehistoria.utils.Keys;
import io.github.thebusybiscuit.slimefun4.libraries.dough.data.persistent.PersistentDataAPI;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.WitherSkeleton;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.concurrent.ThreadLocalRandom;

public class WitherWeather extends Spell {

    public WitherWeather() {
        SpellCoreBuilder spellCoreBuilder = new SpellCoreBuilder(5, true, 0, false, 1, true)
            .makeInstantSpell(this::cast);
        setSpellCore(spellCoreBuilder.build());
    }

    @ParametersAreNonnullByDefault
    public void cast(CastInformation castInformation) {
        Location location = castInformation.getCastLocation();
        for (int i = 0; i < castInformation.getStaveLevel(); i++) {
            Location spawnLocation = location.clone().add(
                ThreadLocalRandom.current().nextDouble(3),
                0,
                ThreadLocalRandom.current().nextDouble(3)
            );
            WitherSkeleton witherSkeleton = (WitherSkeleton) spawnLocation.getWorld().spawnEntity(
                spawnLocation,
                EntityType.WITHER_SKELETON
            );
            witherSkeleton.setTarget(castInformation.getCasterAsPlayer());
            PersistentDataAPI.setBoolean(witherSkeleton, Keys.PDC_IS_WEATHER_WITHER, true);
        }
    }

    @Nonnull
    @Override
    public RecipeSpell getRecipe() {
        return new RecipeSpell(
            1,
            StoryType.HUMAN,
            StoryType.ANIMAL,
            StoryType.VOID
        );
    }

    @Nonnull
    @Override
    public String getName() {
        return "凋灵风暴";
    }
    
    @Nonnull
    @Override
    public String[] getLore() {
        return new String[]{
            "召唤 1-5 只凋灵骷髅",
            "这些凋灵骷髅会主动攻击施法者",
            "但击杀后一定会掉落凋灵骷髅头"
        };
    }

    @Nonnull
    @Override
    public String getId() {
        return "WITHER_WEATHER";
    }

    @Nonnull
    @Override
    public Material getMaterial() {
        return Material.WITHER_SKELETON_SKULL;
    }
}
