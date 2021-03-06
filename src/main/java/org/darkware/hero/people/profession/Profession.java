package org.darkware.hero.people.profession;

import org.darkware.hero.base.NamedStaticObject;
import org.darkware.hero.base.StaticId;
import org.darkware.hero.people.BaseGroup;

/**
 * @author jeff
 * @since 2015-08-05
 */
public class Profession extends BaseGroup
{
    public Profession(CharSequence id, String name, int rarity)
    {
        this(new StaticId(id), name, rarity);
    }

    public Profession(StaticId id, String name, int rarity)
    {
        super(id, name, rarity);
    }
}

