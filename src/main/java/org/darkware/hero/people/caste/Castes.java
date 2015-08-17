package org.darkware.hero.people.caste;

import org.darkware.hero.base.StaticId;
import org.darkware.hero.base.StaticObjectLibrary;
import org.darkware.hero.people.profession.Profession;

/**
 * @author jeff
 * @since 2015-08-12
 */
public class Castes extends StaticObjectLibrary<Caste>
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

    public Castes()
    {
        super();
    }

    @Override protected void prepopulate()
    {
        super.prepopulate();


    }
}