package io.github.sefiraat.crystamaehistoria.magic.spells;

import io.github.sefiraat.crystamaehistoria.magic.CastInformation;
import io.github.sefiraat.crystamaehistoria.magic.spells.core.Spell;
import io.github.sefiraat.crystamaehistoria.magic.spells.core.SpellCoreBuilder;
import io.github.sefiraat.crystamaehistoria.magic.wrappers.MagicProjectile;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class PoisonNova extends Spell {

    public PoisonNova() {
        SpellCoreBuilder spellCoreBuilder = new SpellCoreBuilder(20, true, 20, true, 10, true)
                .makeDamagingSpell(1, false, 0, false)
                .makeProjectileSpell(this::fireProjectile, this::projectileHit, 0, false, 0 ,false)
                .addAfterProjectileHitEvent(this::afterProjectileHit);
        setSpellCore(spellCoreBuilder.build());
    }

    @ParametersAreNonnullByDefault
    public void fireProjectile(CastInformation castInformation) {
        double sizeEnd = getRange(castInformation);
        int sizeCast = 1;
        int stepSize = 3;
        Location middle = castInformation.getCastLocation().clone().add(0, 1, 0);
        for(double i = 0; i < 360; i += stepSize) {
            double angle = (i * Math.PI / 180);
            double sx = sizeCast * Math.cos(angle);
            double sz = sizeCast * Math.sin(angle);
            double dx = sizeEnd * Math.cos(angle);
            double dz = sizeEnd * Math.sin(angle);
            Location spawn = middle.clone().add(sx, 0, sz);
            Location destination = middle.clone().add(dx, 1, dz);
            MagicProjectile magicProjectile = new MagicProjectile(EntityType.ENDER_PEARL, spawn, castInformation.getCaster());
            magicProjectile.setVelocity(destination, 1);

            registerProjectile(magicProjectile.getProjectile(), castInformation);
        }
    }

    @ParametersAreNonnullByDefault
    public void projectileHit(CastInformation castInformation) {
        LivingEntity hit = castInformation.getMainTarget();
        if (hit.getHealth() == 1) {
            damageEntity(hit, castInformation.getCaster(), getDamage(castInformation));
        } else {
            PotionEffect potionEffect = new PotionEffect(PotionEffectType.POISON, castInformation.getPowerMulti() * 40, castInformation.getPowerMulti() + 1);
            hit.addPotionEffect(potionEffect);
            setLastDamageToCaster(hit, castInformation);
        }
    }

    @ParametersAreNonnullByDefault
    public void afterProjectileHit(CastInformation castInformation) {
        displayParticleEffect(castInformation.getMainTarget(), Particle.CRIMSON_SPORE, 1.0, 10);
    }
}