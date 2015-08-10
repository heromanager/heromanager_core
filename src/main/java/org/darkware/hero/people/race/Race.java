package org.darkware.hero.people.race;

import org.darkware.hero.base.NamedStaticObject;
import org.darkware.hero.base.StaticId;
import org.darkware.hero.people.BaseGroup;

/**
 * @author jeff
 * @since 2015-08-05
 */
public class Race extends BaseGroup
{
    public Race(CharSequence id, String name)
    {
        this(new StaticId(id), name);
    }

    public Race(StaticId id, String name)
    {
        super(id, name);
    }
}
