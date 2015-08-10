package org.darkware.hero.base;

import java.util.*;

/**
 * @author ${user}
 * @since 2015-08-07
 */
public class EnumFactorSet<T extends Enum<T>>
{
    private final double[] factors;
    private final double defaultValue;
    private final Class<T> enumClass;

    public EnumFactorSet(double defaultValue, Class<T> enumClass)
    {
        super();

        this.defaultValue = defaultValue;
        this.enumClass = enumClass;

        this.factors = new double[enumClass.getEnumConstants().length];
        Arrays.fill(this.factors, defaultValue);
    }

    public EnumFactorSet(Class<T> enumClass)
    {
        this(1.0, enumClass);
    }

    public final double get(T item)
    {
        int idx = item.ordinal();
        return this.factors[idx];
    }

    public final void set(T item, double factor)
    {
        int idx = item.ordinal();
        this.factors[idx] = factor;
    }

    public final void apply(T item, double factor)
    {
        int idx = item.ordinal();
        this.factors[idx] *= factor;
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
            if (this.factors[idx] != this.defaultValue) fields.add(item);
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

            out.append("  ").append(item.name()).append(" = ").append(this.factors[idx]).append("\n");
        }
        out.append("]\n");

        return out.toString();
    }
}
