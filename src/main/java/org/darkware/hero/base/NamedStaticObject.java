package org.darkware.hero.base;

/**
 * @author jsharpe
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

    /**
     * Fetches the name assigned to this object.
     *
     * @return The object's name.
     */
    public final String getName()
    {
        return this.name;
    }
}
