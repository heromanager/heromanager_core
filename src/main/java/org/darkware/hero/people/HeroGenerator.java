package org.darkware.hero.people;

import org.darkware.hero.base.Deck;
import org.darkware.hero.people.caste.Caste;
import org.darkware.hero.people.caste.Castes;
import org.darkware.hero.people.profession.Profession;
import org.darkware.hero.people.profession.Professions;
import org.darkware.hero.people.race.Race;
import org.darkware.hero.people.race.Races;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author jeff
 * @since 2015-08-17
 */
public class HeroGenerator
{
    private static final AtomicBoolean localInit = new AtomicBoolean(false);
    private static final Deck<Race> raceDeck = new Deck<Race>();
    private static final Deck<Caste> casteDeck = new Deck<Caste>();
    private static final Deck<Profession> profDeck = new Deck<Profession>();

    private static void initializeDecks()
    {
        if (HeroGenerator.localInit.compareAndSet(false, true))
        {
            HeroGenerator.raceDeck.clear();
            for (Race r : Races.all()) HeroGenerator.raceDeck.add(r, r.getRarity());

            HeroGenerator.casteDeck.clear();
            for (Caste c : Castes.all()) HeroGenerator.casteDeck.add(c, c.getRarity());

            HeroGenerator.profDeck.clear();
            for (Profession p : Professions.all()) HeroGenerator.profDeck.add(p, p.getRarity());
        }
    }

    public HeroGenerator()
    {
        super();
    }

    public Hero generateHero(HeroTemplate template)
    {
        Hero hero = new Hero();



        return hero;
    }
}
