package org.darkware.hero.people.race;

import org.darkware.hero.base.StaticId;
import org.darkware.hero.base.StaticObjectLibrary;

import java.util.Collection;

/**
 * @author jeff
 * @since 2015-08-12
 */
public class Races extends StaticObjectLibrary<Race>
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

    public static Collection<Race> all()
    {
        return Races.global.getAll();
    }

    public Races()
    {
        super();
    }

    @Override protected void prepopulate()
    {
        super.prepopulate();

        this.insert(new HumanRace());
        this.insert(new HalflingRace());
        this.insert(new HalfHalflingRace());

        this.insert(new HalfElfRace());
        this.insert(new ElfRace());

        this.insert(new DwarfRace());
        this.insert(new DoubleDwarfRace());

        this.insert(new HalfDragonRace());
        this.insert(new HalfTrollRace());
    }
}
