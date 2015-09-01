package org.darkware.hero.people.generation;

import org.darkware.hero.base.StaticId;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jeff
 * @since 2015-08-27
 */
public class GroupRestrictions
{
    private final Set<StaticId> restrictRaces;
    private final Set<StaticId> restrictCastes;
    private final Set<StaticId> restrictProfessions;

    protected GroupRestrictions()
    {
        super();

        this.restrictRaces = new HashSet<>();
        this.restrictCastes = new HashSet<>();
        this.restrictProfessions = new HashSet<>();
    }

    public void restrictRace(StaticId id)
    {
        this.restrictRaces.add(id);
    }

    public void restrictCaste(StaticId id)
    {
        this.restrictCastes.add(id);
    }

    public void restrictProfession(StaticId id)
    {
        this.restrictProfessions.add(id);
    }

    public Set<StaticId> getRestrictProfessions()
    {
        return restrictProfessions;
    }

    public Set<StaticId> getRestrictRaces()
    {
        return restrictRaces;
    }

    public Set<StaticId> getRestrictCastes()
    {
        return restrictCastes;
    }
}
