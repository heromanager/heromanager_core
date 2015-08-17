package org.darkware.hero.base;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jeff
 * @since 2015-08-16
 */
public class Range
{
    static private final String BRACKET_START = "[{(<";
    static private final String BRACKET_END = "]})>";
    static private final String[] DELIMITERs = { "..", "-" };

    static private int getArgument(int index, String name, int[] args)
    {
        if (index >= args.length) throw new IllegalArgumentException("No value supplied for " + name);

        return args[index];
    }

    static private int[] parse(String text)
    {
        // First, scrub all whitespace
        String working = text.replaceAll("\\s+", "");

        // Ensure we have enough characters to work on
        if (working.length() < 3) throw new IllegalArgumentException("Invalid format for Range.");

        // Remove any bracketing characters
        char startChar = working.charAt(0);
        int startMatch = Range.BRACKET_START.indexOf(startChar);

        if (startMatch >= 0)
        {
            if (working.charAt(working.length() - 1) == Range.BRACKET_END.charAt(startMatch))
            {
                working = working.substring(1, working.length()-1);
            }
        }

        // Look for the pattern
        Pattern rangePattern = Pattern.compile("(\\-?\\d+)(\\-|\\.\\.)(\\-?\\d+)");
        Matcher rangeMatcher = rangePattern.matcher(working);
        if (rangeMatcher.matches())
        {
            final int[] bounds = new int[2];

            bounds[0] = Integer.parseInt(rangeMatcher.group(1));
            bounds[1] = Integer.parseInt(rangeMatcher.group(3));

            return bounds;
        }
        else
        {
            throw new IllegalArgumentException("Invalid format for Range.");
        }
    }

    private final int start;
    private final int end;

    public Range(final int start, final int end)
    {
        super();

        if (start > end) throw new IllegalArgumentException("Invalid range specification.");

        this.start = start;
        this.end = end;
    }

    public Range(final int ... bounds)
    {
        this(Range.getArgument(0, "start", bounds), Range.getArgument(1, "end", bounds));
    }

    public Range(String text)
    {
        this(Range.parse(text));
    }

    /**
     * Fetch the low end of the range.
     *
     * @return The lower bound of the range.
     */
    public int getStart()
    {
        return this.start;
    }

    /**
     * Fetch the high end of the range.
     *
     * @return The higher bound of the range.
     */
    public final int getEnd()
    {
        return this.end;
    }

    /**
     * Fetch the size of the range. The size is defined as the count of integers which
     * are contained by the start and end bounds of the range, inclusive. The minimum
     * size of a valid range is 1 and occurs when the start and end are equal.
     *
     * @return The magnitude of the range, as an integer greater than or equal to 1.
     */
    public final int getSize()
    {
        return 1 + (this.end - this.start);
    }

    /**
     * Builds a representation of the range as a string.
     *
     * @return The range, presented as bracketed integers delimited by double periods.
     */
    public final String toString()
    {
        return "[" + this.start + ".." + this.end + "]";
    }

    @Override public boolean equals(final Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Range range = (Range) o;

        if (start != range.start) return false;
        return end == range.end;
    }

    @Override public int hashCode()
    {
        int result = start;
        result = 31 * result + end;
        return result;
    }
}
