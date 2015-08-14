package org.darkware.hero.people.race;

import org.darkware.hero.base.StaticId;
import org.darkware.hero.people.Attribute;

/**
 * @author jeff
 * @since 2015-08-06
 */
public class ElfenRace extends Race
{
    public ElfenRace(String id, String name)
    {
        super(id, name);
    }

    @Override protected void applyBonuses()
    {
        super.applyBonuses();

        this.getAttributes().add(Attribute.ALLURE, 22);
        this.getAttributes().add(Attribute.FINESSE, 18);
        this.getAttributes().add(Attribute.BRAWN, -20);
        this.getAttributes().add(Attribute.INSIGHT, 12);
    }
}
