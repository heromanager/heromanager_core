package org.darkware.hero.people.race;

import org.darkware.hero.people.Attribute;

/**
 * @author jeff
 * @since 2015-08-06
 */
public class DoubleDwarfRace extends SubterraneanRace
{
    public DoubleDwarfRace()
    {
        super("DDWF", "Double-Dwarf");
    }

    @Override protected void applyBonuses()
    {
        super.applyBonuses();

        this.getAttributes().add(Attribute.ALLURE, -4);
        this.getAttributes().add(Attribute.FINESSE, 6);
        this.getAttributes().add(Attribute.BRAWN, 16);
        this.getAttributes().add(Attribute.INSIGHT, -6);
        this.getAttributes().add(Attribute.FITNESS, 14);
    }

}
