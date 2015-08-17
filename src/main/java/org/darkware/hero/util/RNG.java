package org.darkware.hero.util;

import org.darkware.hero.base.Range;

import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @author jeff
 * @since 2015-07-27
 */
public class RNG
{
    private static Random global = new Random();

    /**
     * Selects a random element from a set. The selection is unweighted and equally
     * likely for all elements.
     *
     * @param set The set to select from
     * @param <T> Any type
     * @return One of the objects stored in the list.
     */
    public static <T> T pick(Set<T> set)
    {
        int r = RNG.global.nextInt(set.size());

        for (T item : set)
        {
            if (r == 0) return item;
            r--;
        }

        throw new UnknownError("Set bounds overflow while selecting a random entry.");
    }

    /**
     * Selects a random element from a list. The selection is unweighted and equally
     * likely for all elements.
     *
     * @param list The list to select from
     * @param <T> Any type
     * @return One of the objects stored in the list.
     */
    public static <T> T pick(final List<T> list)
    {
        int r = RNG.global.nextInt(list.size());
        return list.get(r);
    }

    /**
     * Selects a random element from an array. The selection is unweighted and equally
     * likely for all elements.
     *
     * @param array The array to select from
     * @param <T> Any type
     * @return One of the objects stored in the array.
     */
    public static <T> T pick(final T[] array)
    {
        int r = RNG.global.nextInt(array.length);
        return array[r];
    }

    /**
     * Select an integer from an integer {@link Range}. The values selected are inclusive
     * within the range (ie: the ending value is a valid selection result).
     *
     * @param range The <code>Range</code> to select from.
     * @return An integer from the range's start to end, inclusive.
     */
    public static int pick(Range range)
    {
        return range.getStart() + RNG.global.nextInt(range.getSize());
    }

    /**
     * Yields a randomized boolean based upon a given number of chances within a pool.
     *
     * @param chance The number of chances that the event should occur.
     * @param pool The size of the random pool to "roll" from.
     * @return A randomized <code>true</code> or <code>false</code> value.
     */
    public static boolean chance(int chance, int pool)
    {
        return (RNG.global.nextInt(pool) < chance);
    }
}
