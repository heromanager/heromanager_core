package org.darkware.hero.people.caste;

import org.darkware.hero.base.StaticId;
import org.darkware.hero.base.StaticObjectLibrary;
import org.darkware.hero.people.BaseGroupLibrary;
import org.darkware.hero.people.profession.Profession;

import java.util.Collection;

/**
 * @author jeff
 * @since 2015-08-12
 */
public class Castes extends BaseGroupLibrary<Caste>
{
    private final static Castes global = new Castes();

    public static Caste lookup(CharSequence id)
    {
        return Castes.lookup(new StaticId(id));
    }

    public static Caste lookup(StaticId id)
    {
        return Castes.global.get(id);
    }

    public static Caste lookup(Class<?> casteClass)
    {
        return Castes.global.getByClass(casteClass);
    }

    public static Collection<Caste> all()
    {
        return Castes.global.getAll();
    }

    public Castes()
    {
        super();
    }

    @Override protected void prepopulate()
    {
        super.prepopulate();

        this.insert(new NobleCaste());

        this.insert(new PeasantCaste());
        this.insert(new OutlawCaste());

        this.insert(new VampyrCaste());
        this.insert(new WerewolfCaste());
        this.insert(new WererabbitCaste());
    }
}
