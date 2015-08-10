package org.darkware.hero.base;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author ${user}
 * @since 2015-08-07
 */
public class EnumValueSet<T extends Enum<T>>
{
    private final int[] values;
    private final int defaultValue;
    private final Class<T> enumClass;

    public EnumValueSet(int defaultValue, Class<T> enumClass)
    {
        super();

        this.defaultValue = defaultValue;
        this.enumClass = enumClass;

        this.values = new int[enumClass.getEnumConstants().length];
        Arrays.fill(this.values, defaultValue);
    }

    public EnumValueSet(Class<T> enumClass)
    {
        this(0, enumClass);
    }

    public final int get(T item)
    {
        int idx = item.ordinal();
        return this.values[idx];
    }

    public final void set(T item, int value)
    {
        int idx = item.ordinal();
        this.values[idx] = value;
    }

    public final void set(String itemName, int value)
    {
        //TODO: Find some way to speed this up
        for (T item : this.enumClass.getEnumConstants())
        {
            if (item.name().equalsIgnoreCase(itemName)) this.set(item, value);
            return;
        }
    }

    public final void add(T item, int delta)
    {
        int idx = item.ordinal();
        this.values[idx] += delta;
    }

    public final void reset(T item)
    {
        this.set(item, this.defaultValue);
    }

    public final Set<T> allFields()
    {
        Set<T> fields = new TreeSet<T>(new EnumNameComparator<T>());

        for (T item : enumClass.getEnumConstants())
        {
            fields.add(item);
        }

        return fields;
    }

    public final Set<T> allNonDefaultFields()
    {
        Set<T> fields = new TreeSet<T>(new EnumNameComparator<T>());

        for (T item : enumClass.getEnumConstants())
        {
            int idx = item.ordinal();
            if (this.values[idx] != this.defaultValue) fields.add(item);
        }

        return fields;
    }

    public final double getDefaultValue()
    {
        return this.defaultValue;
    }

    public final String toString()
    {
        StringBuilder out = new StringBuilder("[ \n");
        for (T item : enumClass.getEnumConstants())
        {
            int idx = item.ordinal();

            out.append("  ").append(item.name()).append(" = ").append(this.values[idx]).append("\n");
        }
        out.append("]\n");

        return out.toString();
    }
}
