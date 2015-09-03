package org.darkware.hero.people.race;

import org.darkware.hero.annotations.AutoLoad;
import org.darkware.hero.annotations.LoadKey;
import org.darkware.hero.people.Attribute;

/**
 * @author ${user}
 * @since 2015-08-12
 */
@AutoLoad(key = LoadKey.RACE)
public class HalflingRace extends HumanRace
{
    public HalflingRace()
    {
        super("HALF", "Halfling", 4);
    }

    protected HalflingRace(String id, String name, int rarity)
    {
        super(id, name, rarity);
    }

    @Override protected void applyBonuses()
    {
        this.getAttributes().add(Attribute.FITNESS, -8);
        this.getAttributes().add(Attribute.COURAGE, 6);
        this.getAttributes().add(Attribute.ALLURE, -8);
        this.getAttributes().add(Attribute.BRAWN, -18);
        this.getAttributes().add(Attribute.INSIGHT, 17);
    }
}
