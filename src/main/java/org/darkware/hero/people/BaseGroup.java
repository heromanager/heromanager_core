package org.darkware.hero.people;

import org.darkware.hero.base.NamedStaticObject;
import org.darkware.hero.base.Rarified;
import org.darkware.hero.base.StaticId;
import org.darkware.hero.people.caste.Caste;
import org.darkware.hero.people.profession.Profession;
import org.darkware.hero.people.race.Race;

/**
 * @author jeff
 * @since 2015-08-05
 */
public abstract class BaseGroup extends NamedStaticObject implements Rarified
{
    private final int rarity;
    private final Attributes attrs;

    public BaseGroup(CharSequence id, String name, int rarity)
    {
        this(new StaticId(id), name, rarity);
    }

    public BaseGroup(StaticId id, String name, int rarity)
    {
        super(id, name);

        this.rarity = rarity;
        this.attrs = new SimpleAttributes();

        this.applyBonuses();
    }

    public final Attributes getAttributes()
    {
        return this.attrs;
    }

    protected void applyBonuses()
    {

    }

    public Race[] getIncompatibleRaces()
    {
        return new Race[0];
    }

    public Caste[] getIncompatibleCastes()
    {
        return new Caste[0];
    }

    public Profession[] getIncompatibleProfessions()
    {
        return new Profession[0];
    }

    public int getRarity()
    {
        return this.rarity;
    }
}
