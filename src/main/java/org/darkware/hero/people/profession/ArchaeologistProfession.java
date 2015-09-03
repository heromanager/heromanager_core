package org.darkware.hero.people.profession;

import org.darkware.hero.annotations.AutoLoad;
import org.darkware.hero.annotations.LoadKey;

/**
 * @author jeff
 * @since 2015-08-22
 */
@AutoLoad(key = LoadKey.PROFESSION)
public class ArchaeologistProfession extends AcademicProfession
{
    public ArchaeologistProfession()
    {
        super("ARCH", "Archaeologist", 6);
    }
}
