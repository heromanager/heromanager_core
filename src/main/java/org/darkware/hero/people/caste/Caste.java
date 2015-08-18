package org.darkware.hero.people.caste;

import org.darkware.hero.base.NamedStaticObject;
import org.darkware.hero.base.StaticId;
import org.darkware.hero.people.BaseGroup;

/**
 * @author jeff
 * @since 2015-08-05
 */
public class Caste extends BaseGroup
{
    public Caste(CharSequence id, String name, int rarity)
    {
        this(new StaticId(id), name, rarity);
    }

    public Caste(StaticId id, String name, int rarity)
    {
        super(id, name, rarity);
    }
}
