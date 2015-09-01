package org.darkware.hero.people.caste;

import org.darkware.hero.people.profession.AcolyteProfession;
import org.darkware.hero.people.profession.Profession;
import org.darkware.hero.people.race.Race;
import org.darkware.hero.people.tags.Tag;

import java.util.Set;

/**
 * @author jeff
 * @since 2015-08-18
 */
public class CursedCaste extends OutCaste
{
    public CursedCaste(final CharSequence id, final String name, final int rarity)
    {
        super(id, name, rarity);
    }

    @Override protected void declareIncompatibilities()
    {
        super.declareIncompatibilities();

        this.declareIncompatibility(AcolyteProfession.class);
    }

    @Override protected void defineTags()
    {
        super.defineTags();

        this.getTags().add(Tag.CURSED);
    }
}
