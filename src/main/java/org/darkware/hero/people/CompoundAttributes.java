package org.darkware.hero.people;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author jeff
 * @since 2015-08-12
 */
public class CompoundAttributes implements Attributes
{
    private final int defaultValue;
    private final Map<String, Attributes> components;

    private final Attributes cache;
    private final AtomicBoolean rebuildCache;
    private final ReadWriteLock cacheLock;

    public CompoundAttributes(int defaultValue)
    {
        super();

        this.defaultValue = defaultValue;
        this.components = Collections.synchronizedMap(new HashMap<String, Attributes>());

        this.cache = new SimpleAttributes();
        this.rebuildCache = new AtomicBoolean(true);
        this.cacheLock = new ReentrantReadWriteLock(true);
    }

    public CompoundAttributes()
    {
        this(0);
    }

    public int get(final Attribute attr)
    {
        this.cacheLock.readLock().lock();
        try
        {
            // If we need to rebuild, release the read lock and rebuild.
            if (this.rebuildCache.get())
            {
                this.cacheLock.readLock().unlock();
                this.rebuild();
                this.cacheLock.readLock().lock();
            }

            return this.cache.get(attr);
        }
        finally
        {
            this.cacheLock.readLock().unlock();
        }
    }

    protected void rebuild()
    {
        Attribute[] allValues = Attribute.values();

        this.cacheLock.writeLock().lock();
        try
        {
            // Clear the cache
            this.cache.resetAll();

            synchronized (this.components)
            {
                for (Attributes set : this.components.values())
                {
                    for (Attribute attr : allValues)
                    {
                        this.cache.add(attr, set.get(attr));
                    }
                }
            }
        }
        finally
        {
            this.cacheLock.writeLock().unlock();
        }
    }

    public void addComponent(String key, Attributes attrs)
    {
        this.components.put(key, attrs);
    }

    public void removeComponent(String key)
    {
        this.components.remove(key);
    }

    public void removeAllComponents()
    {
        this.components.clear();
    }

    public void set(final Attribute attr, final int value)
    {
        // You cannot modify the value of a compound attribute set.
        return;
    }

    public void set(final String attrName, final int value)
    {
        // You cannot modify the value of a compound attribute set.
        return;
    }

    public void add(final Attribute attr, final int delta)
    {
        // You cannot modify the value of a compound attribute set.
        return;
    }

    public void reset(final Attribute attr)
    {
        // You cannot modify the value of a compound attribute set.
        return;
    }

    public void resetAll()
    {
        // You cannot modify the value of a compound attribute set.
        return;
    }

    public Set<Attribute> allFields()
    {
        Set<Attribute> fields = new HashSet<Attribute>();
        Collections.addAll(fields, Attribute.values());
        return fields;
    }

    public Set<Attribute> allNonDefaultFields()
    {
        final Set<Attribute> nonDef = new HashSet<Attribute>();

        for (Attribute attr : Attribute.values())
        {
            if (this.get(attr) != this.defaultValue) nonDef.add(attr);
        }

        return nonDef;
    }

    public double getDefaultValue()
    {
        return this.defaultValue;
    }
}
