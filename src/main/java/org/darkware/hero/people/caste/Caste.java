package org.darkware.hero.people.caste;

import org.darkware.hero.base.NamedStaticObject;
import org.darkware.hero.base.StaticId;

/**
 * @author jeff
 * @since 2015-08-05
 */
public class Caste extends NamedStaticObject
{
    public Caste(CharSequence id, String name)
    {
        this(new StaticId(id), name);
    }

    public Caste(StaticId id, String name)
    {
        super(id, name);
    }
}
