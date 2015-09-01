package org.darkware.hero.people.generation;

import org.darkware.hero.base.Deck;
import org.darkware.hero.people.caste.Caste;
import org.darkware.hero.people.caste.Castes;
import org.darkware.hero.people.profession.Profession;
import org.darkware.hero.people.profession.Professions;
import org.darkware.hero.people.race.Race;
import org.darkware.hero.people.race.Races;

/**
 * @author jeff
 * @since 2015-08-28
 */
public class GroupSelector
{
    private final Deck<Race> raceDeck = new Deck<>();
    private final Deck<Caste> casteDeck = new Deck<>();
    private final Deck<Profession> profDeck = new Deck<>();

    public GroupSelector()
    {
        super();

        this.initializeDecks();
    }

    private void initializeDecks()
    {
        this.raceDeck.clear();
        for (Race r : Races.all()) this.raceDeck.add(r, r.getRarity());

        this.casteDeck.clear();
        for (Caste c : Castes.all()) this.casteDeck.add(c, c.getRarity());

        this.profDeck.clear();
        for (Profession p : Professions.all()) this.profDeck.add(p, p.getRarity());
    }

    public void restrictFor(Race race)
    {
        CasteDeckFilter casteFilter = new CasteDeckFilter();
        casteFilter.addProhibited(race);
        this.casteDeck.filter(casteFilter);

        ProfessionDeckFilter professionFilter = new ProfessionDeckFilter();
        professionFilter.addProhibited(race);
        this.profDeck.filter(professionFilter);
    }

    public void restrictFor(Caste caste)
    {
        RaceDeckFilter raceFilter = new RaceDeckFilter();
        raceFilter.addProhibited(caste);
        this.raceDeck.filter(raceFilter);

        ProfessionDeckFilter professionFilter = new ProfessionDeckFilter();
        professionFilter.addProhibited(caste);
        this.profDeck.filter(professionFilter);
    }

    public void restrictFor(Profession profession)
    {
        CasteDeckFilter casteFilter = new CasteDeckFilter();
        casteFilter.addProhibited(profession);
        this.casteDeck.filter(casteFilter);

        RaceDeckFilter raceFilter = new RaceDeckFilter();
        raceFilter.addProhibited(profession);
        this.raceDeck.filter(raceFilter);
    }

    public Race pickRace()
    {
        return this.raceDeck.pick();
    }

    public Caste pickCaste()
    {
        return this.casteDeck.pick();
    }

    public Profession pickProfession()
    {
        return this.profDeck.pick();
    }
}
