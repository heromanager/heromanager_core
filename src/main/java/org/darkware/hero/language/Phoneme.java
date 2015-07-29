package org.darkware.hero.language;

import java.util.*;

/**
 * @author jeff
 * @since 2015-07-27
 */
public class Phoneme
{
    private final String text;
    private final Gender gender;
    private final EnumSet<PhonemeTag> tags;

    public Phoneme(final String text, Gender gender, PhonemeTag ... tags)
    {
        super();

        this.text = text;
        this.gender = gender;
        this.tags = EnumSet.noneOf(PhonemeTag.class);
        for (PhonemeTag tag : tags) this.tags.add(tag);
    }

    public boolean hasGender(Gender gender)
    {
        return (gender != null && gender.equals(this.gender));
    }

    public boolean hasTag(PhonemeTag tag)
    {
        if (tag == null) return false;

        return this.tags.contains(tag);
    }

    @Override public String toString()
    {
        return this.text;
    }
}
