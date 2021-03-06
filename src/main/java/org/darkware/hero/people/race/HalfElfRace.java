package org.darkware.hero.people.race;

import org.darkware.hero.annotations.AutoLoad;
import org.darkware.hero.annotations.LoadKey;
import org.darkware.hero.people.Attribute;

/**
 * @author ${user}
 * @since 2015-08-06
 */
@AutoLoad(key = LoadKey.RACE)
public class HalfElfRace extends ElfenRace
{
    public HalfElfRace()
    {
        super("HELF", "Half-Elf", 9);
    }

    @Override protected void applyBonuses()
    {
        super.applyBonuses();

        this.getAttributes().add(Attribute.BRAWN, 8);
    }
}
