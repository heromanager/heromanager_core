package org.darkware.hero.people.race;

import org.darkware.hero.people.Attribute;
import org.darkware.hero.people.caste.Caste;
import org.darkware.hero.people.caste.Castes;
import org.darkware.hero.people.caste.WererabbitCaste;
import org.darkware.hero.people.caste.WerewolfCaste;
import org.darkware.hero.people.profession.*;

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

    @Override protected void declareIncompatibilities()
    {
        super.declareIncompatibilities();

        this.declareIncompatibility(PirateProfession.class);
        this.declareIncompatibility(NinjaProfession.class);
        this.declareIncompatibility(AcolyteProfession.class);

        this.declareIncompatibility(WererabbitCaste.class);
        this.declareIncompatibility(WerewolfCaste.class);
    }
}
