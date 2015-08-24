package org.darkware.hero.people.race;

import org.darkware.hero.people.Attribute;
import org.darkware.hero.people.caste.Caste;
import org.darkware.hero.people.caste.Castes;
import org.darkware.hero.people.profession.Profession;
import org.darkware.hero.people.profession.Professions;

import java.util.Set;

/**
 * @author jeff
 * @since 2015-08-06
 */
public abstract class SubterraneanRace extends Race
{
    protected SubterraneanRace(String id, String name, int rarity)
    {
        super(id, name, rarity);
    }

    @Override protected void applyBonuses()
    {
        super.applyBonuses();

        this.getAttributes().add(Attribute.ALLURE, -22);
        this.getAttributes().add(Attribute.FINESSE, -12);
        this.getAttributes().add(Attribute.BRAWN, 28);
        this.getAttributes().add(Attribute.COURAGE, 15);
        this.getAttributes().add(Attribute.FITNESS, 20);
    }

    @Override public Set<Profession> getIncompatibleProfessions()
    {
        Set<Profession> prohibit = super.getIncompatibleProfessions();

        prohibit.add(Professions.lookup("PRAT"));
        prohibit.add(Professions.lookup("NNJA"));
        prohibit.add(Professions.lookup("ACLT"));

        return prohibit;
    }

    @Override public Set<Caste> getIncompatibleCastes()
    {
        Set<Caste> prohibit = super.getIncompatibleCastes();

        prohibit.add(Castes.lookup("WRBT"));
        prohibit.add(Castes.lookup("WWLF"));

        return prohibit;
    }
}
