package org.darkware.hero.people;

import org.darkware.hero.base.StaticId;
import org.darkware.hero.base.StaticObjectLibrary;
import org.darkware.hero.people.race.Race;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jeff
 * @since 2015-08-30
 */
public abstract class BaseGroupLibrary<T extends BaseGroup> extends StaticObjectLibrary<T>
{
    protected Map<Class<?>, StaticId> idMap;

    public BaseGroupLibrary()
    {
        super();
    }

    @Override public void insert(final T item)
    {
        super.insert(item);

        // We need to lazy-create the map so its compatible with autoloading.
        if (this.idMap == null) this.idMap = new HashMap<>();
        this.idMap.put(item.getClass(), item.getId());
    }

    public T getByClass(Class<?> classInst)
    {
        StaticId id = this.idMap.get(classInst);

        if (id == null) return null;
        else return this.get(id);
    }
}
