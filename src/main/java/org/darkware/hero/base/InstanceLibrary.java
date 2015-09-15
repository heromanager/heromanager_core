package org.darkware.hero.base;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jeff
 * @since 2015-09-01
 */
public class InstanceLibrary<T extends StaticObject>
{
    private final Map<Class<?>, T> instances;
    private final Map<StaticId, Class<?>> idMap;

    protected InstanceLibrary()
    {
        super();

        this.instances = new HashMap<>();
        this.idMap = new HashMap<>();

        this.populate();
    }

    protected void populate()
    {
        // Child classes implement this
    }

    protected final void add(T item)
    {
        this.instances.put(item.getClass(), item);
        this.idMap.put(item.getId(), item.getClass());
    }

    public final Set<T> all()
    {
        return new HashSet<>(this.instances.values());
    }

    public final T get(Class<?> itemClass)
    {
        if (itemClass == null) return null;
        return this.instances.get(itemClass);
    }

    public final T get(String id)
    {
        if (id == null) return null;
        return this.get(new StaticId(id));
    }

    public final T get(StaticId id)
    {
        if (id == null) return null;
        return this.get(this.idMap.get(id));
    }

    public final boolean has(Class<?> itemClass)
    {
        if (itemClass == null) return false;
        return this.instances.containsKey(itemClass);
    }

    public final boolean has(StaticId id)
    {
        if (id == null) return false;
        return this.idMap.containsKey(id);
    }

    public final boolean has(String id)
    {
        if (id == null) return false;
        return this.has(new StaticId(id));
    }

    public final int size()
    {
        return this.instances.size();
    }
}
