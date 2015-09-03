package org.darkware.hero.people.caste;

import org.darkware.hero.annotations.AutoLoad;

/**
 * @author jeff
 * @since 2015-08-18
 */
@AutoLoad(key = "CASTE")
public class WerewolfCaste extends CursedCaste
{
    public WerewolfCaste()
    {
        super("WWLF", "Werewolf", 4);
    }
}
