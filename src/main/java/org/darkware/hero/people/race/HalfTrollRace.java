package org.darkware.hero.people.race;

import org.darkware.hero.annotations.AutoLoad;
import org.darkware.hero.annotations.LoadKey;
import org.darkware.hero.people.Attribute;

/**
 * @author jeff
 * @since 2015-08-06
 */
@AutoLoad(key = LoadKey.RACE)
public class HalfTrollRace extends SubterraneanRace
{
    public HalfTrollRace()
    {
        super("HTRL", "Half-Troll", 4);
    }

    @Override protected void applyBonuses()
    {
        super.applyBonuses();

        this.getAttributes().add(Attribute.ALLURE, -18);
        this.getAttributes().add(Attribute.FINESSE, -22);
        this.getAttributes().add(Attribute.BRAWN, 22);
        this.getAttributes().add(Attribute.INSIGHT, -18);
        this.getAttributes().add(Attribute.FITNESS, 12);
    }

}
