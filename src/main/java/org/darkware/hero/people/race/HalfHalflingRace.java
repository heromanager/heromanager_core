package org.darkware.hero.people.race;

import org.darkware.hero.annotations.AutoLoad;
import org.darkware.hero.annotations.LoadKey;
import org.darkware.hero.people.Attribute;

/**
 * @author ${user}
 * @since 2015-08-12
 */
@AutoLoad(key = LoadKey.RACE)
public class HalfHalflingRace extends HumanRace
{
    public HalfHalflingRace()
    {
        super("HHLF", "Half-Halfling", 3);
    }

    @Override protected void applyBonuses()
    {
        this.getAttributes().add(Attribute.FITNESS, -6);
        this.getAttributes().add(Attribute.COURAGE, 4);
        this.getAttributes().add(Attribute.ALLURE, 6);
        this.getAttributes().add(Attribute.BRAWN, -6);
        this.getAttributes().add(Attribute.INSIGHT, 4);
    }
}
