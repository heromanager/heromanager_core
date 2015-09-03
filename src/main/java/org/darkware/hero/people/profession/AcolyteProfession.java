package org.darkware.hero.people.profession;

import org.darkware.hero.annotations.AutoLoad;
import org.darkware.hero.annotations.LoadKey;

/**
 * @author jeff
 * @since 2015-08-22
 */
@AutoLoad(key = LoadKey.PROFESSION)
public class AcolyteProfession extends AcademicProfession
{
    public AcolyteProfession()
    {
        super("ACLT", "Acolyte", 10);
    }
}
