package org.darkware.hero.people.race;

import org.darkware.hero.annotations.AutoLoad;
import org.darkware.hero.annotations.LoadKey;

/**
 * @author jeff
 * @since 2015-08-12
 */
@AutoLoad(key = LoadKey.RACE)
public class HumanRace extends Race
{
    public HumanRace()
    {
        super("HUMN", "Human", 16);
    }

    protected HumanRace(String id, String name, int rarity) { super(id, name, rarity); }

    @Override protected void applyBonuses()
    {
        super.applyBonuses();
    }
}
