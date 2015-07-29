package org.darkware.hero.language;

import org.darkware.hero.util.RNG;

import java.util.HashSet;
import java.util.Set;
import static org.darkware.hero.language.Gender.*;
import static org.darkware.hero.language.PhonemeTag.*;

/**
 * @author jeff
 * @since 2015-07-27
 */
public class Phonemes
{
    private static Phonemes globalInstance;

    /** Initialize the list of phonemes */
    private synchronized static void initializeGlobal()
    {
        Phonemes global = new Phonemes();

        // Add phonemes
        global.add(new Phoneme("ela", FEMALE, NAME_SUFFIX));
        global.add(new Phoneme("ira", FEMALE, NAME_SUPER));
        global.add(new Phoneme("oru", FEMALE, NAME_INFER));
        global.add(new Phoneme("en", FEMALE, NAME_DESC));
        global.add(new Phoneme("lasa", FEMALE, NAME_OBJ));

        // Set this as the global list.
        Phonemes.globalInstance = global;
    }

    public synchronized static Phonemes global()
    {
        if (Phonemes.globalInstance == null)
        {
            Phonemes.initializeGlobal();
        }
        return Phonemes.globalInstance;
    }

    private final Set<Phoneme> phonemes;

    public Phonemes()
    {
        super();

        this.phonemes = new HashSet<Phoneme>();
    }

    public void add(Phoneme phoneme)
    {
        this.phonemes.add(phoneme);
    }

    public Phonemes filter(Gender gender)
    {
        Phonemes filtered = new Phonemes();

        for (Phoneme p : this.phonemes)
        {
            if (p.hasGender(gender)) filtered.add(p);
        }

        return filtered;
    }

    public Phonemes filter(PhonemeTag tag)
    {
        Phonemes filtered = new Phonemes();

        for (Phoneme p : this.phonemes)
        {
            if (p.hasTag(tag)) filtered.add(p);
        }

        return filtered;
    }

    public Phoneme pickRandom()
    {
        return RNG.pick(this.phonemes);
    }
}
