package org.darkware.hero.people;

import org.darkware.hero.people.caste.Caste;
import org.darkware.hero.people.generation.GroupSelector;
import org.darkware.hero.people.profession.Profession;
import org.darkware.hero.people.race.Race;

/**
 * @author jeff
 * @since 2015-08-17
 */
public class HeroGenerator
{
    public HeroGenerator()
    {
        super();
    }

    public Hero generateHero(HeroTemplate template)
    {
        Hero hero = new Hero();
        GroupSelector selector = new GroupSelector();

        Race r = selector.pickRace();
        hero.setRace(r);
        selector.restrictFor(r);

        Caste c = selector.pickCaste();
        hero.setCaste(c);
        selector.restrictFor(c);

        Profession p = selector.pickProfession();
        hero.setProfession(p);
        selector.restrictFor(p);

        return hero;
    }
}
