package org.darkware.hero.people.race;

import org.darkware.hero.people.Attribute;

/**
 * @author jeff
 * @since 2015-08-12
 */
public class HumanRace extends Race
{
    public HumanRace()
    {
        super("HUMN", "Human");
    }

    public HumanRace(String id, String name) { super(id, name); }

    @Override protected void applyBonuses()
    {
        super.applyBonuses();
    }
}
