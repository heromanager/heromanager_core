package org.darkware.hero.util;

import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author jeff
 * @since 2015-07-27
 */
public class TextUtils
{
    public static StringBuilder join(String glue, Iterable<? extends Object> items) {
        StringBuilder result = new StringBuilder();

        for (Object i : items) {
            if (result.length() > 0) result.append(glue);
            if (i != null) result.append(i);
        }

        return result;
    }

    public static <T extends Object> StringBuilder join(String glue, T ... items) {
        return TextUtils.join(glue, Arrays.asList(items));
    }

    public static String stripWhitespace(CharSequence text)
    {
        CharBuffer buf = CharBuffer.allocate(text.length());

        for (int i = 0; i < text.length(); i++)
        {
            if (!Character.isWhitespace(text.charAt(i)))
            {
                buf.put(text.charAt(i));
            }
        }
        buf.flip();

        return buf.toString();
    }

    public static String fromConst(String constName)
    {
        return constName.toLowerCase().replace('_', ' ');
    }
}
