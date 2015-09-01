package org.darkware.hero.people;

import org.darkware.hero.base.NamedStaticObject;
import org.darkware.hero.base.Rarified;
import org.darkware.hero.base.StaticId;
import org.darkware.hero.people.caste.Caste;
import org.darkware.hero.people.caste.Castes;
import org.darkware.hero.people.profession.Profession;
import org.darkware.hero.people.profession.Professions;
import org.darkware.hero.people.race.Race;
import org.darkware.hero.people.race.Races;
import org.darkware.hero.people.tags.Tags;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jeff
 * @since 2015-08-05
 */
public abstract class BaseGroup extends NamedStaticObject implements Rarified
{
    private final int rarity;
    private final Attributes attrs;
    private final Tags tags;

    private final Set<Race> incompatibleRaces;
    private final Set<Caste> incompatibleCastes;
    private final Set<Profession> incompatibleProfessions;

    public BaseGroup(CharSequence id, String name, int rarity)
    {
        this(new StaticId(id), name, rarity);
    }

    public BaseGroup(StaticId id, String name, int rarity)
    {
        super(id, name);

        this.rarity = rarity;
        this.attrs = new SimpleAttributes();
        this.tags = new Tags();

        this.incompatibleRaces = new HashSet<>();
        this.incompatibleCastes = new HashSet<>();
        this.incompatibleProfessions = new HashSet<>();

        this.declareIncompatibilities();

        this.applyBonuses();
        this.defineTags();
    }

    public final Attributes getAttributes()
    {
        return this.attrs;
    }

    protected void declareIncompatibilities()
    {
        // No incompatibilities by default.
    }

    protected final void declareIncompatibility(Race race)
    {
        if (!(this instanceof Race)) this.incompatibleRaces.add(race);
    }

    protected final void declareIncompatibility(Caste caste)
    {
        if (!(this instanceof Caste)) this.incompatibleCastes.add(caste);
    }

    protected final void declareIncompatibility(Profession profession)
    {
        if (!(this instanceof Profession)) this.incompatibleProfessions.add(profession);
    }

    protected final void declareIncompatibility(Class<?> groupClass)
    {
        if (Race.class.isAssignableFrom(groupClass))
        {
            this.declareIncompatibility(Races.lookup(groupClass));
        }
        else if (Caste.class.isAssignableFrom(groupClass))
        {
            this.declareIncompatibility(Castes.lookup(groupClass));
        }
        else if (Profession.class.isAssignableFrom(groupClass))
        {
            this.declareIncompatibility(Professions.lookup(groupClass));
        }
        else
        {
            throw new IllegalArgumentException("The given class is not a BaseGroup class.");
        }
    }

    protected void applyBonuses()
    {

    }

    protected void defineTags()
    {

    }

    public final Set<Race> getIncompatibleRaces()
    {
        return this.incompatibleRaces;
    }

    public final Set<Caste> getIncompatibleCastes()
    {
        return this.incompatibleCastes;
    }

    public final Set<Profession> getIncompatibleProfessions()
    {
        return this.incompatibleProfessions;
    }

    public int getRarity()
    {
        return this.rarity;
    }

    public final Tags getTags()
    {
        return this.tags;
    }
}
