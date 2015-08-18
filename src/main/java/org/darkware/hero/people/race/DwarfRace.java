package org.darkware.hero.people.race;

import org.darkware.hero.people.Attribute;

/**
 * @author jeff
 * @since 2015-08-06
 */
public class DwarfRace extends SubterraneanRace
{
    public DwarfRace()
    {
        super("DWRF", "Dwarf", 8);
    }

    @Override protected void applyBonuses()
    {
        super.applyBonuses();

        this.getAttributes().add(Attribute.ALLURE, 5);
        this.getAttributes().add(Attribute.FINESSE, 4);
        this.getAttributes().add(Attribute.BRAWN, 8);
        this.getAttributes().add(Attribute.INSIGHT, 4);
        this.getAttributes().add(Attribute.FITNESS, 8);
    }

}
