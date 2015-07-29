package org.darkware.hero.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author jeff
 * @since 2015-07-27
 */
public class TextUtils
{
    public static StringBuilder join(String glue, Collection<? extends Object> items) {
        StringBuilder result = new StringBuilder();

        for (Object i : items) {
            if (result.length() > 1) result.append(glue);
            if (i != null) result.append(i);
        }

        return result;
    }

    public static StringBuilder join(String glue, Object ... items) {
        return TextUtils.join(glue, Arrays.asList(items));
    }
}
