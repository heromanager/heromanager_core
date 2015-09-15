package org.darkware.hero.util;

import org.darkware.hero.base.Range;
import org.darkware.hero.base.Rarified;

import java.util.Collection;
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

    public static double getDouble(double min, double max)
    {
        double val = RNG.global.nextDouble();
        val = (val * (max-min)) + min;
        if (val > max) val = max; // Correction for floating-point math weirdness.

        return val;
    }

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

    public static <T extends Rarified> T pickWithRarity(final Collection<T> items)
    {
        return RNG.pickWithRarity(items, 0, 1, 0.0);
    }

    public static <T extends Rarified> T pickWithRarity(final Collection<T> items, int targetRarity, int targetSize, double targetWeight)
    {
        if (items.isEmpty()) throw new IllegalArgumentException("Cannot pick from an empty list.");
        if (items.size() == 1) return items.iterator().next();
        if (targetSize == 0) throw new IllegalArgumentException("Cannot pick from rarified collections with a target size of 0");

        // First, iterate through the collection to calculate the range
        double max = 0.0;
        for (T item : items)
        {
            max += RNG.calculateTargetedRarity(item.getRarity(), targetRarity, targetSize, targetWeight);
        }

        // Now select a random number in that range
        double selection = RNG.getDouble(0.0, max);

        // Now, run through the collection again to find the matching item
        double seen = 0.0;
        T last = null;
        for (T item : items)
        {
            last = item;
            seen += RNG.calculateTargetedRarity(item.getRarity(), targetRarity, targetSize, targetWeight);
            if (seen >= selection) return item;
        }

        /*
         * This seems like a funny way to do this. The goal here is catch the case when the accumulator
         * passes the trigger value, but still catch any weird cases where the calculated target value
         * may fall short of the max due to floating point math. Tracking the last item lets us fall off
         * the end of our collection, but still return the value that should have been selected if
         * floating point math wasn't wonky.
         */
        return last;
    }

    private static double calculateTargetedRarity(int rarity, int target, int targetSize, double weight)
    {
        int targetDistance = Math.abs(rarity - target);
        return rarity + (weight * (targetDistance / targetSize));
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
