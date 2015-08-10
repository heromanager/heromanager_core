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
        super("UELF", "Elf");
    }

    @Override protected void applyBonuses()
    {
        super.applyBonuses();

        this.getAttributes().add(Attribute.ALLURE, 2);
        this.getAttributes().add(Attribute.FINESSE, 1);
        this.getAttributes().add(Attribute.BRAWN, -1);
    }

}
