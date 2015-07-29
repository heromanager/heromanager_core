package org.darkware.hero.base;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author jeff
 * @since 2015-07-27
 */
public class LRUCacheMap<K, V> extends LinkedHashMap<K, V>
{
    private int capacity;

    public LRUCacheMap(int capacity, boolean usageOrder)
    {
        super(Math.max(16, capacity), 0.75f, usageOrder);

        this.capacity = capacity;
    }

    public final int getCapacity()
    {
        return this.capacity;
    }

    @Override protected final boolean removeEldestEntry(final Map.Entry entry)
    {
        return (this.capacity > 0) && (super.size() > this.capacity);
    }
}
