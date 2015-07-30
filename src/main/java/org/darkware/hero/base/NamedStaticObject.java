package org.darkware.hero.base;

/**
 * @author ${user}
 * @since 2015-07-29
 */
public abstract class NamedStaticObject extends BasicStaticObject
{
    /** The general name of this object instance. */
    private final String name;

    public NamedStaticObject(StaticId id, CharSequence name)
    {
        super(id);

        this.name = name.toString();
    }
}
