package org.darkware.hero.people.race;

import org.darkware.hero.annotations.AutoLoad;
import org.darkware.hero.annotations.LoadKey;
import org.darkware.hero.people.Attribute;

/**
 * @author jeff
 * @since 2015-08-06
 */
@AutoLoad(key = LoadKey.RACE)
public class HalfDragonRace extends SubterraneanRace
{
    public HalfDragonRace()
    {
        super("HDRG", "Half-Dragon", 2);
    }

    @Override protected void applyBonuses()
    {
        super.applyBonuses();

        this.getAttributes().add(Attribute.ALLURE, -12);
        this.getAttributes().add(Attribute.FINESSE, -8);
        this.getAttributes().add(Attribute.BRAWN, 18);
        this.getAttributes().add(Attribute.INSIGHT, 12);
        this.getAttributes().add(Attribute.FITNESS, 16);
    }

}
