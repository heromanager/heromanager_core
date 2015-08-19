package org.darkware.hero.people.generation;

import org.darkware.hero.people.caste.Caste;
import org.darkware.hero.people.profession.Profession;
import org.darkware.hero.people.race.Race;

/**
 * @author jeff
 * @since 2015-08-18
 */
public class ProfessionDeckFilter extends BaseGroupDeckFilter<Profession>
{
    @Override public void addProhibited(final Race race)
    {
        this.prohibit(race.getIncompatibleProfessions());
    }

    @Override public void addProhibited(final Caste caste)
    {
        this.prohibit(caste.getIncompatibleProfessions());
    }

    @Override public void addProhibited(final Profession profession)
    {
        this.prohibit(profession);
    }
}
