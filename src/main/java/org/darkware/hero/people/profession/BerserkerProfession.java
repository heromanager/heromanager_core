package org.darkware.hero.people.profession;

import org.darkware.hero.annotations.AutoLoad;
import org.darkware.hero.annotations.LoadKey;

/**
 * @author jeff
 * @since 2015-08-23
 */
@AutoLoad(key = LoadKey.PROFESSION)
public class BerserkerProfession extends FighterProfession
{
    public BerserkerProfession()
    {
        super("BRSK", "Berserker", 2);
    }
}
