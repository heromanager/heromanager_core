package org.darkware.hero.base;

import java.util.Map;

/**
 * @author jeff
 * @since 2015-07-27
 */
public abstract class AbstractLibrary<T> implements Library<T>
{
    private final LRUCacheMap<StaticId, T> storage;

    protected AbstractLibrary()
    {
        this(0, false);
    }

    protected AbstractLibrary(final int capacity, boolean usageOrder)
    {
        super();

        this.storage = new LRUCacheMap<StaticId, T>(capacity, usageOrder);
    }

    @Override public final boolean has(final StaticId key)
    {
        synchronized (this.storage)
        {
            return this.storage.containsKey(key);
        }
    }

    @Override public final int capacity()
    {
        return this.storage.getCapacity();
    }

    @Override public final int size()
    {
        synchronized (this.storage)
        {
            return this.storage.size();
        }
    }

    @Override public final void insert(final StaticId key, final T item)
    {
        synchronized (this.storage)
        {
            // If the key exists, remove that value before inserting the new value
            if (this.has(key)) this.remove(key);

            // Check for capacity constraints

            this.storage.put(key, item);
            this.onAddItem(key, item);
        }
    }

    @Override public final T get(final StaticId key)
    {
        synchronized (this.storage)
        {
            return this.storage.get(key);
        }
    }

    @Override public final T remove(final StaticId key)
    {
        synchronized (this.storage)
        {
            T item = this.storage.remove(key);
            this.onRemoveItem(key, item);
            return item;
        }
    }

    @Override public final int remove(final T item)
    {
        int removed = 0;

        synchronized (this.storage)
        {
            for (Map.Entry<StaticId, T> entry : this.storage.entrySet())
            {
                if (item.equals(entry.getValue())) this.remove(entry.getKey());
                removed++;
            }
        }

        return removed;
    }

    protected void onAddItem(StaticId key, T item)
    {

    }

    protected void onRemoveItem(StaticId key, T item)
    {

    }
}
