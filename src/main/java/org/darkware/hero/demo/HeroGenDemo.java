package org.darkware.hero.demo;

import org.darkware.hero.people.Attribute;
import org.darkware.hero.people.Hero;
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
        Hero hero = new Hero();

        hero.setRace(new HalfElfRace());

        System.out.println("===== HERO =====");
        System.out.println(Serializer.global().toJson(hero));

        System.out.println("===== BASE ATTRS =====");
        System.out.println(Serializer.global().toJson(hero.getBaseAttributes()));

        System.out.println("===== ATTRS =====");
        System.out.println(Serializer.global().toJson(hero.getActiveAttributes()));
    }
}
