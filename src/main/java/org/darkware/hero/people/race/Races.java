package org.darkware.hero.people.race;

import com.google.common.reflect.ClassPath;
import org.darkware.hero.GameEnvironment;
import org.darkware.hero.annotations.LoadKey;
import org.darkware.hero.base.StaticId;
import org.darkware.hero.people.BaseGroup;
import org.darkware.hero.people.BaseGroupLibrary;

import java.rmi.AccessException;
import java.util.Collection;

/**
 * @author jeff
 * @since 2015-08-12
 */
public class Races extends BaseGroupLibrary<Race>
{
    private final static Races global = new Races();

    public static Race lookup(CharSequence id)
    {
        return Races.lookup(new StaticId(id));
    }

    public static Race lookup(StaticId id)
    {
        return Races.global.get(id);
    }

    public static Race lookup(Class<?> raceClass)
    {
        return Races.global.getByClass(raceClass);
    }

    public static Collection<Race> all()
    {
        return Races.global.getAll();
    }

    public Races()
    {
        super();
    }

    protected LoadKey getAutoLoadKey()
    {
        return LoadKey.RACE;
    }

    @Override public void insert(final Race item)
    {
        super.insert(item);
    }
}
