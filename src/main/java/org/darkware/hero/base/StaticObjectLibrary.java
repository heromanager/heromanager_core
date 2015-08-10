package org.darkware.hero.base;

import java.util.Map;

/**
 * The StaticObjectLibrary is a special base class for storing {@link StaticObject}s. It is
 * based off of the usage of the {@link StaticId}s as unique identifiers to simplify some of
 * the routines for {@link Library} storage.
 *
 * In exchange for this, there are special constraints or caveats based on the usage. While it
 * is possible to create multiple <code>StaticObject</code>s that share an ID, that situation
 * should be avoided when working with this sort of Library. <code>StaticObject</code>s with
 * identical IDs will not coexist here, and will replace/remove each other when its attempted.
 *
 * @author ${user}
 * @since 2015-07-29
 */
public abstract class StaticObjectLibrary<T extends StaticObject> extends AbstractLibrary<T> implements StaticLibrary<T>
{
    protected StaticObjectLibrary()
    {
        this(0, false);
    }

    protected StaticObjectLibrary(final int capacity, boolean usageOrder)
    {
        super(capacity, usageOrder);
    }

    public boolean has(final T item)
    {
        return this.has(item.getId());
    }

    public void insert(final T item)
    {
        this.insert(item.getId(), item);
    }

    public T remove(final T item)
    {
        if (this.has(item)) return this.remove(item.getId());

        return null;
    }
}
