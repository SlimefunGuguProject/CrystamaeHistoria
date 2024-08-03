package io.github.sefiraat.crystamaehistoria.magic.spells.tier1;

import io.github.sefiraat.crystamaehistoria.magic.CastInformation;
import io.github.sefiraat.crystamaehistoria.magic.spells.core.Spell;
import io.github.sefiraat.crystamaehistoria.magic.spells.core.SpellCoreBuilder;
import io.github.sefiraat.crystamaehistoria.slimefun.items.mechanisms.liquefactionbasin.RecipeSpell;
import io.github.sefiraat.crystamaehistoria.stories.definition.StoryType;
import io.github.sefiraat.crystamaehistoria.utils.Keys;
import io.github.sefiraat.crystamaehistoria.utils.ParticleUtils;
import io.github.thebusybiscuit.slimefun4.libraries.dough.data.persistent.PersistentDataAPI;
import io.github.thebusybiscuit.slimefun4.utils.compatibility.VersionedPotionEffectType;
import net.guizhanss.crystamaehistoria.utils.compatibility.VersionedParticleX;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class Prism extends Spell {

    public Prism() {
        SpellCoreBuilder spellCoreBuilder = new SpellCoreBuilder(25, true, 0, false, 75, true)
            .makeInstantSpell(this::cast)
            .makeEffectingSpell(true, true)
            .addPositiveEffect(PotionEffectType.ABSORPTION, 1, 30)
            .addPositiveEffect(PotionEffectType.CONDUIT_POWER, 1, 30)
            .addPositiveEffect(VersionedPotionEffectType.RESISTANCE, 1, 30)
            .addPositiveEffect(PotionEffectType.DOLPHINS_GRACE, 1, 30)
            .addPositiveEffect(VersionedPotionEffectType.HASTE, 1, 30)
            .addPositiveEffect(PotionEffectType.HEALTH_BOOST, 1, 30)
            .addPositiveEffect(PotionEffectType.HERO_OF_THE_VILLAGE, 1, 30)
            .addPositiveEffect(VersionedPotionEffectType.STRENGTH, 1, 30)
            .addPositiveEffect(PotionEffectType.INVISIBILITY, 1, 30)
            .addPositiveEffect(VersionedPotionEffectType.JUMP_BOOST, 1, 30)
            .addPositiveEffect(PotionEffectType.LUCK, 1, 30)
            .addPositiveEffect(PotionEffectType.NIGHT_VISION, 1, 30)
            .addPositiveEffect(PotionEffectType.REGENERATION, 1, 30)
            .addPositiveEffect(PotionEffectType.SATURATION, 1, 30)
            .addPositiveEffect(PotionEffectType.SPEED, 1, 30)
            .addPositiveEffect(PotionEffectType.WATER_BREATHING, 1, 30);
        setSpellCore(spellCoreBuilder.build());
    }

    @ParametersAreNonnullByDefault
    public void cast(CastInformation castInformation) {
        Player player = castInformation.getCasterAsPlayer();
        if (PersistentDataAPI.getBoolean(player, Keys.newKey("ANTIPRISM"))) {
            player.damage(200);
        }
        PersistentDataAPI.setBoolean(player, Keys.newKey("PRISM"), true);
        applyPositiveEffects(player, castInformation);
        ParticleUtils.displayParticleEffect(player, VersionedParticleX.EFFECT, 2, 20);
    }

    @Nonnull
    @Override
    public RecipeSpell getRecipe() {
        return new RecipeSpell(
            1,
            StoryType.ALCHEMICAL,
            StoryType.HISTORICAL,
            StoryType.HUMAN
        );
    }

    @Nonnull
    @Override
    public String getName() {
        return "棱镜";
    }

    @Nonnull
    @Override
    public String[] getLore() {
        return new String[]{
            "施法者可以获得",
            "多种正面效果"
        };
    }

    @Nonnull
    @Override
    public String getId() {
        return "PRISM";
    }

    @Nonnull
    @Override
    public Material getMaterial() {
        return Material.POTION;
    }
}
