package org.darkware.hero.base;

/**
 * @author jeff
 * @since 2015-07-29
 */
public abstract class BasicStaticObject
{
    /** The object's defined identifier. */
    private final StaticId id;

    public BasicStaticObject(StaticId id)
    {
        super();

        this.id = id;
    }

    @Override public boolean equals(final Object o)
    {
        if (this == o) return true;
        if (!(o instanceof BasicStaticObject)) return false;

        final BasicStaticObject that = (BasicStaticObject) o;

        return id.equals(that.id);
    }

    @Override public final int hashCode()
    {
        return id.hashCode();
    }
}
