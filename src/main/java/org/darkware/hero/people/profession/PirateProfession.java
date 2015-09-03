package org.darkware.hero.people.profession;

import org.darkware.hero.annotations.AutoLoad;
import org.darkware.hero.annotations.LoadKey;

/**
 * @author jeff
 * @since 2015-08-22
 */
@AutoLoad(key = LoadKey.PROFESSION)
public class PirateProfession extends FighterProfession
{
    public PirateProfession()
    {
        super("PRAT", "Pirate", 11);
    }
}
