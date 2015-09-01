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
        this.prohibit(GroupCombos.restrictions(race).getRestrictProfessions());
    }

    @Override public void addProhibited(final Caste caste)
    {
        this.prohibit(GroupCombos.restrictions(caste).getRestrictProfessions());
    }

    @Override public void addProhibited(final Profession profession)
    {
        this.prohibit(profession);
    }
}
