package org.darkware.hero.people.profession;

import org.darkware.hero.annotations.AutoLoad;
import org.darkware.hero.annotations.LoadKey;

/**
 * Created: 2015-08-18
 */
@AutoLoad(key = LoadKey.PROFESSION)
public class WarriorProfession extends FighterProfession
{
    public WarriorProfession()
    {
        super("WARR", "Warrior", 14);
    }
}
