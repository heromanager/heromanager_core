package org.darkware.hero.people.profession;

import org.darkware.hero.base.StaticId;
import org.darkware.hero.base.StaticObjectLibrary;

import java.util.Collection;

/**
 * @author jeff
 * @since 2015-08-12
 */
public class Professions extends StaticObjectLibrary<Profession>
{
    private final static Professions global = new Professions();

    public static Profession lookup(CharSequence id)
    {
        return Professions.lookup(new StaticId(id));
    }

    public static Profession lookup(StaticId id)
    {
        return Professions.global.get(id);
    }

    public static Collection<Profession> all()
    {
        return Professions.global.getAll();
    }

    public Professions()
    {
        super();
    }

    @Override protected void prepopulate()
    {
        super.prepopulate();

        this.insert(new WarriorProfession());
    }
}
