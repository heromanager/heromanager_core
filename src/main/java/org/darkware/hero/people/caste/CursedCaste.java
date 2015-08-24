package org.darkware.hero.people.caste;

import org.darkware.hero.people.profession.Profession;
import org.darkware.hero.people.race.Race;

import java.util.Set;

/**
 * @author jeff
 * @since 2015-08-18
 */
public class CursedCaste extends OutCaste
{
    public CursedCaste(final CharSequence id, final String name, final int rarity)
    {
        super(id, name, rarity);
    }

    @Override public Set<Race> getIncompatibleRaces()
    {
        Set<Race> prohibit = super.getIncompatibleRaces();

        return prohibit;
    }

    @Override public Set<Profession> getIncompatibleProfessions()
    {
        Set<Profession> prohibit = super.getIncompatibleProfessions();

        return prohibit;
    }
}
