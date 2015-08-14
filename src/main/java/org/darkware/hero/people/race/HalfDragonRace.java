package org.darkware.hero.people.race;

import org.darkware.hero.people.Attribute;

/**
 * @author jeff
 * @since 2015-08-06
 */
public class HalfDragonRace extends SubterraneanRace
{
    public HalfDragonRace()
    {
        super("HDRG", "Half-Dragon");
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
