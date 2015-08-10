package org.darkware.hero.base;

import java.util.Comparator;

/**
 * @author jeff
 * @since 2015-08-07
 */
public class EnumNameComparator<T extends Enum<T>> implements Comparator<T>
{
    public int compare(final T a, final T b)
    {
        return a.name().compareTo(b.name());
    }
}
