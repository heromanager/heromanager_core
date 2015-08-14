package org.darkware.hero.base;

import java.util.Arrays;

/**
 * @author jeff
 * @since 2015-07-27
 */
public class StaticId
{
    private static final int ID_LENGTH = 4;

    private static char[] extractKey(CharSequence seq)
    {
        char[] key = new char[StaticId.ID_LENGTH];

        Arrays.fill(key, ' ');
        for (int i = 0; i < StaticId.ID_LENGTH && i < seq.length(); i++)
        {
            key[i] = seq.charAt(i);
        }

        return key;
    }

    private final char[] key;
    private final int hashcode;

    public StaticId(char[] key)
    {
        super();

        if (key.length == StaticId.ID_LENGTH) this.key = key;
        else this.key = Arrays.copyOfRange(key, 0, StaticId.ID_LENGTH);

        this.hashcode = Arrays.hashCode(this.key);
    }

    public StaticId(CharSequence key)
    {
        this(StaticId.extractKey(key));
    }

    public final char[] getKey()
    {
        return Arrays.copyOf(this.key, StaticId.ID_LENGTH);
    }

    @Override
    public final String toString()
    {
        return new String(this.key);
    }

    @Override
    public final boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof StaticId)) return false;

        StaticId staticId = (StaticId) o;

        if (!Arrays.equals(key, staticId.key)) return false;

        return true;
    }

    @Override
    public final int hashCode()
    {
        return this.hashcode;
    }
}
