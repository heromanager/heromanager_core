package org.darkware.hero.people.race;

import org.darkware.hero.people.Attribute;

/**
 * @author jeff
 * @since 2015-08-06
 */
public class ElfRace extends ElfenRace
{
    public ElfRace()
    {
        super("UELF", "Elf", 10);
    }

    @Override protected void applyBonuses()
    {
        super.applyBonuses();

        this.getAttributes().add(Attribute.ALLURE, 8);
        this.getAttributes().add(Attribute.FINESSE, 5);
        this.getAttributes().add(Attribute.BRAWN, -4);
        this.getAttributes().add(Attribute.INSIGHT, 18);
        this.getAttributes().add(Attribute.FITNESS, 10);
    }

}
