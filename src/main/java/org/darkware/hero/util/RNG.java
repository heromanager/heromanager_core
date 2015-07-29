package org.darkware.hero.util;

import java.util.Random;
import java.util.Set;

/**
 * @author jeff
 * @since 2015-07-27
 */
public class RNG
{
    private static Random global = new Random();

    public static <T> T pick(Set<T> set)
    {
        synchronized (set)
        {
            int r = RNG.global.nextInt(set.size());

            for (T item : set)
            {
                if (r == 0) return item;
                r--;
            }
        }

        throw new UnknownError("Set bounds overflow while selecting a random entry.");
    }
}
