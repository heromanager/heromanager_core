package org.darkware.hero.people.caste;

import org.darkware.hero.annotations.AutoLoad;
import org.darkware.hero.annotations.LoadKey;

/**
 * @author jeff
 * @since 2015-08-18
 */
@AutoLoad(key = LoadKey.CASTE)
public class WerewolfCaste extends CursedCaste
{
    public WerewolfCaste()
    {
        super("WWLF", "Werewolf", 4);
    }
}
