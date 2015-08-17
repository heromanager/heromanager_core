package org.darkware.hero.base;

/**
 * @author jeff
 * @since 2015-08-16
 */
public class Range
{
    private final int start;
    private final int end;

    public Range(final int start, final int end)
    {
        super();

        if (start > end) throw new IllegalArgumentException("Invalid range specification.");

        this.start = start;
        this.end = end;
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
