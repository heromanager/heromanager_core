package org.darkware.hero.people.caste;

import org.darkware.hero.annotations.AutoLoad;
import org.darkware.hero.annotations.LoadKey;

/**
 * @author jeff
 * @since 2015-08-18
 */
@AutoLoad(key = LoadKey.CASTE)
public class ZombieCaste extends CursedCaste
{
    public ZombieCaste()
    {
        super("ZOMB", "Zombie", 6);
    }
}
