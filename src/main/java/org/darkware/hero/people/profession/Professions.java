package org.darkware.hero.people.profession;

import org.darkware.hero.base.StaticId;
import org.darkware.hero.base.StaticObjectLibrary;
import org.darkware.hero.people.BaseGroupLibrary;
import org.darkware.hero.people.race.Race;

import java.util.Collection;

/**
 * @author jeff
 * @since 2015-08-12
 */
public class Professions extends BaseGroupLibrary<Profession>
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

    public static Profession lookup(Class<?> professionClass)
    {
        return Professions.global.getByClass(professionClass);
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
        this.insert(new PirateProfession());
        this.insert(new BerserkerProfession());

        this.insert(new CookProfession());

        this.insert(new AcolyteProfession());
        this.insert(new ArchaeologistProfession());
        this.insert(new ClerkProfession());

        this.insert(new ThiefProfession());
        this.insert(new NinjaProfession());
        this.insert(new AssassinProfession());
    }

    @Override protected String getAutoLoadKey()
    {
        return "PROFESSION";
    }
}
