package org.darkware.hero.people;

import org.darkware.hero.base.NamedStaticObject;
import org.darkware.hero.base.StaticId;

/**
 * @author jeff
 * @since 2015-08-05
 */
public class Profession extends NamedStaticObject
{
    public Profession(CharSequence id, String name)
    {
        this(new StaticId(id), name);
    }

    public Profession(StaticId id, String name)
    {
        super(id, name);
    }
}
