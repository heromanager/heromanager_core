package org.darkware.hero.demo;

import org.darkware.hero.people.Attribute;
import org.darkware.hero.people.Hero;
import org.darkware.hero.people.HeroGenerator;
import org.darkware.hero.people.HeroTemplate;
import org.darkware.hero.people.race.HalfElfRace;
import org.darkware.hero.people.race.Race;
import org.darkware.hero.system.Serializer;

/**
 * @author ${user}
 * @since 2015-08-05
 */
public class HeroGenDemo
{
    public static final void main(String ... args)
    {
        HeroGenerator heroGen = new HeroGenerator();

        HeroTemplate template = new HeroTemplate();

        Hero hero = heroGen.generateHero(template);

        System.out.println("Race: " + hero.getRace().getName());
        System.out.println("Caste: " + hero.getCaste().getName());
        System.out.println("Profession: " + hero.getProfession().getName());

        System.out.println();

        System.out.println("==== GENERATED ====");
        System.out.println(Serializer.global().toJson(hero));
    }
}
