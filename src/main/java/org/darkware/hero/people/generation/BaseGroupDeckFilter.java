package org.darkware.hero.people.generation;

import org.darkware.hero.base.DeckFilter;
import org.darkware.hero.base.StaticId;
import org.darkware.hero.base.StaticObjectLibrary;
import org.darkware.hero.people.BaseGroup;
import org.darkware.hero.people.caste.Caste;
import org.darkware.hero.people.profession.Profession;
import org.darkware.hero.people.race.Race;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created: 2015-08-18
 */
public abstract class BaseGroupDeckFilter<T extends BaseGroup> implements DeckFilter<T>
{
    private final Set<StaticId> prohibited;

    public BaseGroupDeckFilter()
    {
        super();

        this.prohibited = new HashSet<StaticId>();
    }

    protected void prohibit(StaticId id)
    {
        this.prohibited.add(id);
    }

    protected void prohibit(Collection<StaticId> ids)
    {
        this.prohibited.addAll(ids);
    }

    protected void prohibit(T ... items)
    {
        for (T item : items)
        {
            this.prohibit(item.getId());
        }
    }

    protected void prohibit(Set<T> items)
    {
        for (T item : items)
        {
            this.prohibit(item.getId());
        }
    }

    public abstract void addProhibited(Race race);
    public abstract void addProhibited(Caste caste);
    public abstract void addProhibited(Profession profession);

    public boolean allowItem(final T item)
    {
        return !this.prohibited.contains(item.getId());
    }
}
