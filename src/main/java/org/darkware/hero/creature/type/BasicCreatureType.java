package org.darkware.hero.creature.type;

import org.darkware.hero.base.BasicStaticObject;
import org.darkware.hero.base.NamedStaticObject;
import org.darkware.hero.base.StaticId;

/**
 * @author ${user}
 * @since 2015-07-29
 */
public class BasicCreatureType extends NamedStaticObject
{
    public BasicCreatureType(StaticId id, CharSequence name)
    {
        super(id, name);
    }

    public BasicCreatureType(CharSequence id, CharSequence name)
    {
        this(new StaticId(id), name);
    }
}
